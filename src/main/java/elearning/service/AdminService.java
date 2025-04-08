package elearning.service;

import elearning.dto.request.*;

public interface AdminService {
    // Login
    public Object login(AdminLoginReq request);

    // Logout
    public Object logout(int id);

    // Create
    public Object create(AdminCreateReq request);

    // Read
    public Object read(String sort, int page, int size, AdminReadReq request);

    // Update
    public Object update(int id, AdminUpdateReq request);

    // Delete
    public Object delete(int id);
}
