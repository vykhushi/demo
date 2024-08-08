package com.reimbursement.service;
import com.reimbursement.dtoconversion.DtoConversion;
import com.reimbursement.entities.User;
import com.reimbursement.exception.EmailAlreadyExists;

import com.reimbursement.exception.EmailNotFoundException;
import com.reimbursement.exception.PasswordMismatchException;
import com.reimbursement.exception.UserNotFoundException;
import com.reimbursement.indto.LoginRequest;
import com.reimbursement.indto.UserRequest;
import com.reimbursement.outdto.UserResponse;
import com.reimbursement.passwordencryption.PasswordEncodingAndDecoding;
import com.reimbursement.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.ArrayList;
import java.util.List;


@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    PasswordEncodingAndDecoding passwordEncodingAndDecoding;

    public List<User> getAllUserList(){
        List<User> list=new ArrayList<>();
        list=userRepository.findAll();
        return list;
    }

    public UserResponse addUser(UserRequest userRequest)  {
      User user = DtoConversion.convertUserRequestToUser(userRequest);

        if(userRepository.findByUserEmail(user.getUserEmail()).isPresent()){
            throw new EmailAlreadyExists("Email already exists");
        }
        passwordEncodingAndDecoding =new PasswordEncodingAndDecoding();
        user.setUserPassword(passwordEncodingAndDecoding.encodePassword(user.getUserPassword()));
        User savedUser =userRepository.save(user);
        UserResponse userResponse = DtoConversion.userToUserResponse(savedUser);
            return userResponse;
    }

    public UserResponse authenticateUser(LoginRequest loginRequest) {

        User user = userRepository.findByUserEmail(loginRequest.getUserEmail()).orElseThrow(() -> new EmailNotFoundException(loginRequest.getUserEmail()));
        passwordEncodingAndDecoding =new PasswordEncodingAndDecoding();

        if (!passwordEncodingAndDecoding.decodePassword(user.getUserPassword()).equals(loginRequest.getUserPassword()) ) {
            throw new PasswordMismatchException(user.getUserPassword());
        }
        UserResponse userResponse = DtoConversion.userToUserResponse(user);
        return userResponse;
    }

    public User updateUser(User updatedUser,Long userId){
        User user = userRepository.findById(userId).orElse(null);
        if(user!=null){

            user.setUserName(updatedUser.getUserName());
            user.setUserEmail(updatedUser.getUserEmail());
            user.setUserPassword(updatedUser.getUserPassword());

            return userRepository.save(user);
        }
        return null;
    }

    public boolean deleteUser(Long userId){
        userRepository.deleteById(userId);
        if (!userRepository.existsById(userId)){
            throw new UserNotFoundException(userId);
        }
        userRepository.deleteById(userId);
        //if(!userRepository.findById(id).isPresent())
        return true;
    }
}

