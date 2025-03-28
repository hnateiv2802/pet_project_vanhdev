package elearning.service;

import elearning.dto.request.AccountCreateReq;
import elearning.dto.request.AccountLoginReq;
import elearning.dto.request.AccountReadReq;
import elearning.dto.request.AccountUpdateReq;

public interface AccountService {
    // Login
    public Object login(AccountLoginReq request);

    // Logout
    public Object logout(String accountID);

    // Create
    public Object create(AccountCreateReq request);

    // Read
    public Object read(String sort, int page, int size, AccountReadReq request);

    // Update
    public Object update(String accountID, AccountUpdateReq request);

    // Delete
    public Object delete(String accountID);
}
