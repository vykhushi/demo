package com.reimbursement.dtoconversion;

import com.reimbursement.entities.User;
import com.reimbursement.indto.UserRequest;
import com.reimbursement.outdto.UserResponse;

public class DtoConversion {
    public static User convertUserRequestToUser(UserRequest userRequest) {
        User user = new User();
        user.setUserName(userRequest.getUserName());
        user.setUserEmail(userRequest.getUserEmail());
        user.setManagerId(userRequest.getManagerId());
        user.setUserRole(userRequest.getUserRole());
        user.setUserPassword(userRequest.getUserPassword());
        user.setUserDepartment(userRequest.getUserDepartment());
        return user;
    }

    public static UserResponse userToUserResponse(User user) {
        UserResponse userResponse = new UserResponse();
        userResponse.setUserName(user.getUserName());
        userResponse.setUserEmail(user.getUserEmail());
        userResponse.setUserRole(user.getUserRole());
        return userResponse;
    }
}

//    public static LoginResponse userToLoginResponse( User user){
//      LoginResponse loginResponse=new LoginResponse();
//
//
//      return logInResponse;
//    }
//}
