package elearning.controller;

import elearning.constant.URLConst;
import elearning.dto.request.UserCreateReq;
import elearning.dto.request.UserLoginReq;
import elearning.dto.request.UserReadReq;
import elearning.dto.request.UserUpdateReq;
import elearning.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class UserController {
    @Autowired
    private final UserService userService;

    public UserController(@Qualifier("UserService") UserService userService) {
        this.userService = userService;
    }


    // Login
    @PostMapping(URLConst.LOGIN_USER)
    public ResponseEntity<?> login(@Validated @RequestBody UserLoginReq request) {
        Object res = userService.login(request);
        String message = "Login successful";
        return ResponseEntity.ok(message);
    }

    // Logout
    @PostMapping(URLConst.LOGOUT_USER)
    public ResponseEntity<?> logout(@Validated @PathVariable("id") int id) {
        Object res = userService.logout(id);
        String message = "Logout successful";
        return ResponseEntity.ok(message);
    }

    // Create
    @PostMapping(URLConst.CREATE_USER)
    public ResponseEntity<?> createUser(@Validated @RequestBody UserCreateReq request) {
        Object res = userService.create(request);
        return ResponseEntity.ok(res);
    }

    // Read
    @PostMapping(URLConst.READ_USER)
    public ResponseEntity<?> readUser(
            @Validated
            @RequestParam("sort") String sort,
            @RequestParam("page") int page,
            @RequestParam("size") int size,
            @RequestBody UserReadReq request) {
        Object res = userService.read(sort, page, size, request);
        return ResponseEntity.ok(res);
    }

    // Update
    @PutMapping(URLConst.UPDATE_USER)
    public ResponseEntity<?> updateUser(
            @Validated
            @PathVariable("id") int id,
            @RequestBody UserUpdateReq request) {
        Object res = userService.update(id, request);
        return ResponseEntity.ok(res);
    }

    // Delete
    @DeleteMapping(URLConst.DELETE_USER)
    public ResponseEntity<?> deleteUser(@Validated @PathVariable("id") int id) {
        Object res =  userService.delete(id);
        return ResponseEntity.ok(res);
    }
}
