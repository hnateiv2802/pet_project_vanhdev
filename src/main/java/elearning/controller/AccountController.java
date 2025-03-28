package elearning.controller;

import elearning.constant.URLConst;
import elearning.dto.request.AccountCreateReq;
import elearning.dto.request.AccountLoginReq;
import elearning.dto.request.AccountReadReq;
import elearning.dto.request.AccountUpdateReq;
import elearning.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
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
    public Object login(@RequestBody AccountLoginReq request) {
        return accountService.login(request);
    }

    // Logout
    @PostMapping(URLConst.LOGOUT)
    public Object logout(@PathVariable("user_id") String accountID) {
        return accountService.logout(accountID);
    }

    // Create
    @PostMapping(URLConst.CREATE_ACCOUNT)
    public Object createAccount(@RequestBody AccountCreateReq request) {
        return accountService.create(request);
    }

    // Read
    @GetMapping(URLConst.READ_ACCOUNT)
    public Object readAccount(@RequestParam("sort") String sort,
                              @RequestParam("page") int page,
                              @RequestParam("size") int size,
                              @RequestBody AccountReadReq request) {
        return accountService.read(sort, page, size, request);
    }

    // Update
    @PutMapping(URLConst.UPDATE_ACCOUNT)
    public Object updateAccount(@PathVariable("user_id") String accountID,
                                @RequestBody AccountUpdateReq request) {
        return accountService.update(accountID, request);
    }

    // Delete
    @DeleteMapping(URLConst.DELETE_ACCOUNT)
    public Object deleteAccount(@PathVariable("user_id") String accountID) {
        return accountService.delete(accountID);
    }
}
