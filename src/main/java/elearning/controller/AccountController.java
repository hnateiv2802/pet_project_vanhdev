package elearning.controller;

import elearning.constant.URLConst;
import elearning.dto.request.AccountCreateReq;
import elearning.dto.request.AccountLoginReq;
import elearning.dto.request.AccountReadReq;
import elearning.dto.request.AccountUpdateReq;
import elearning.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController("accountController")
@RequestMapping("/api/v1")
public class AccountController {
    // Init
    private final AccountService accountService;
@Autowired
    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }


    // Test
    @GetMapping("/test")
    public String test() {
        return "Test endpoint is working!";
    }

    // Login
    @PostMapping(URLConst.LOGIN)
    public ResponseEntity<?> login(@Validated @RequestBody AccountLoginReq request) {
        Object res = accountService.login(request);
        String message = "Login successful";
        return ResponseEntity.ok(message);
    }

    // Logout
    @PostMapping(URLConst.LOGOUT)
    public ResponseEntity<?> logout(@Validated @PathVariable("user_id") String accountID) {
        Object res = accountService.logout(accountID);
        String message = "Logout successful";
        return ResponseEntity.ok(message);
    }

    // Create
    @PostMapping(URLConst.CREATE_ACCOUNT)
    public ResponseEntity<?> createAccount(@Validated @RequestBody AccountCreateReq request) {
        Object res = accountService.create(request);
        return ResponseEntity.ok(res);
    }

    // Read
    @GetMapping(URLConst.READ_ACCOUNT)
    public ResponseEntity<?> readAccount(
            @Validated
            @RequestParam("sort") String sort,
            @RequestParam("page") int page,
            @RequestParam("size") int size,
            @RequestBody AccountReadReq request) {
        Object res = accountService.read(sort, page, size, request);
        return ResponseEntity.ok(res);
    }

    // Update
    @PutMapping(URLConst.UPDATE_ACCOUNT)
    public ResponseEntity<?> updateAccount(
            @Validated
            @PathVariable("user_id") String accountID,
            @RequestBody AccountUpdateReq request) {
        Object res = accountService.update(accountID, request);
        return ResponseEntity.ok(res);
    }

    // Delete
    @DeleteMapping(URLConst.DELETE_ACCOUNT)
    public ResponseEntity<?> deleteAccount(@Validated @PathVariable("user_id") String accountID) {
        Object res =  accountService.delete(accountID);
        return ResponseEntity.ok(res);
    }
}
