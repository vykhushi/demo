package com.reimbursement.controller;
import java.util.List;
import com.reimbursement.entities.User;
import com.reimbursement.indto.LoginRequest;
import com.reimbursement.indto.UserRequest;
import com.reimbursement.outdto.UserResponse;
import com.reimbursement.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RequestMapping("/user")
@RestController
public class UserController {

    @Autowired
    private UserService userService;   //injects instance of Userservice .

    @GetMapping("/getAllUser")
    public ResponseEntity<List<User>> getAllUser() {
        List<User> list = userService.getAllUserList();
        if (!list.isEmpty()) {
            return ResponseEntity.ok(list);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @PostMapping("/addUser")
    public ResponseEntity<UserResponse> addUser(@RequestBody UserRequest userRequest) {
        UserResponse newUser = userService.addUser(userRequest);
        if (newUser != null) {
            return ResponseEntity.status(HttpStatus.CREATED).body(newUser);
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }

    @DeleteMapping("deleteUser/{userId}")
    public ResponseEntity<User> deleteUser(@PathVariable("userId") Long userId) {
        boolean isdeleted = userService.deleteUser(userId);
        if (isdeleted) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } else
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }


    @PutMapping("updateDetails/{userId}")
    public ResponseEntity<User> updateUser(@RequestBody User updatedUser, @PathVariable("userId") Long id) {
        User updated = userService.updateUser(updatedUser, id);
        if (updated!=null) {
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }


    @PostMapping("/loginUser")
    public ResponseEntity<UserResponse> loginUser(@RequestBody LoginRequest loginRequest) {
        UserResponse response = userService.authenticateUser(loginRequest);
        return null;
    }
}