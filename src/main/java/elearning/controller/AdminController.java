package elearning.controller;

import elearning.constant.URLConst;
import elearning.dto.request.AdminCreateReq;
import elearning.dto.request.AdminLoginReq;
import elearning.dto.request.AdminReadReq;
import elearning.dto.request.AdminUpdateReq;
import elearning.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController("accountController")
@RequestMapping("/api/v1")
public class AdminController {
    @Autowired
    private final AdminService adminService;

    public AdminController(@Qualifier("adminServiceImpl")AdminService adminService) {
        this.adminService = adminService;
    }

    // Login
    @PostMapping(URLConst.LOGIN_ADMIN)
    public ResponseEntity<?> login(@Validated @RequestBody AdminLoginReq request) {
        Object res = adminService.login(request);
        String message = "Login successful";
        return ResponseEntity.ok(message);
    }

    // Logout
    @PostMapping(URLConst.LOGOUT_ADMIN)
    public ResponseEntity<?> logout(@Validated @PathVariable("admin_id") String adminID) {
        Object res = adminService.logout(adminID);
        String message = "Logout successful";
        return ResponseEntity.ok(message);
    }

    // Create
    @PostMapping(URLConst.CREATE_ADMIN)
    public ResponseEntity<?> createAdmin(@Validated @RequestBody AdminCreateReq request) {
        Object res = adminService.create(request);
        return ResponseEntity.ok(res);
    }

    // Read
    @GetMapping(URLConst.READ_ADMIN)
    public ResponseEntity<?> readAdmin(
            @Validated
            @RequestParam("sort") String sort,
            @RequestParam("page") int page,
            @RequestParam("size") int size,
            @RequestBody AdminReadReq request) {
        Object res = adminService.read(sort, page, size, request);
        return ResponseEntity.ok(res);
    }

    // Update
    @PutMapping(URLConst.UPDATE_ADMIN)
    public ResponseEntity<?> updateAdmin(
            @Validated
            @PathVariable("admin_id") String adminID,
            @RequestBody AdminUpdateReq request) {
        Object res = adminService.update(adminID, request);
        return ResponseEntity.ok(res);
    }

    // Delete
    @DeleteMapping(URLConst.DELETE_ADMIN)
    public ResponseEntity<?> deleteAdmin(@Validated @PathVariable("admin_id") String adminID) {
        Object res =  adminService.delete(adminID);
        return ResponseEntity.ok(res);
    }
}
