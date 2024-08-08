//package com.reimbursement.service;
//import com.reimbursement.entities.User;
//import com.reimbursement.exception.EmailAlreadyExists;
//import com.reimbursement.repository.UserRepository;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.security.crypto.password.PasswordEncoder;
//
//import static org.junit.jupiter.api.Assertions.assertThrows;
//import static org.mockito.Mockito.*;
//
//import java.util.Optional;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.mockito.Mockito.when;
//
//
//@SpringBootTest
//   public class UserServiceTest {
//
//    @Mock
//    private UserRepository userRepository;
//
//    @Mock
//    private PasswordEncoder passwordEncoder;
//
//    @InjectMocks
//    private UserService userService;
//
//    private User user;
//
//
//    @BeforeEach
//    void setUp() {
//        user = new User();
//        user.setUserEmail("test@example.com");
//        user.setUserPassword("password");
//    }
//
//    @Test
//    public void testAddUser_Success() {
//
//        when(userRepository.findByUserEmail(user.getUserEmail())).thenReturn(Optional.empty());
//        when(passwordEncoder.encode(user.getUserPassword())).thenReturn("encodedPassword");
//        when(userRepository.save(user)).thenReturn(user);
//
//
//        User savedUser = userService.addUser(userRequest);
//
//        assertEquals(user, savedUser);
//        verify(userRepository, times(1)).save(user);
//
//    }
//        @Test
//        void testAddUser_EmailAlreadyExists() {
//
//            when(userRepository.findByUserEmail(userRequest.getUserEmail())).thenReturn(Optional.of(user));
//            assertThrows(EmailAlreadyExists.class, () -> userService.addUser(userRequest));
//            verify(userRepository, never()).save(user);
//
//
//    }
//}