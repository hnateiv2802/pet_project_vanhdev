package elearning.service;

import elearning.dto.request.*;

public interface AdminService {
    // Login
    public Object login(AdminLoginReq request);

    // Logout
    public Object logout(String accountID);

    // Create
    public Object create(AdminCreateReq request);

    // Read
    public Object read(String sort, int page, int size, AdminReadReq request);

    // Update
    public Object update(String accountID, AdminUpdateReq request);

    // Delete
    public Object delete(String accountID);
}
