package elearning.service;

import elearning.dto.request.UserCreateReq;
import elearning.dto.request.UserLoginReq;
import elearning.dto.request.UserReadReq;
import elearning.dto.request.UserUpdateReq;

public interface UserService {
    // Login
    public Object login(UserLoginReq request);

    // Logout
    public Object logout(int userID);

    // Create
    public Object create(UserCreateReq request);

    // Read
    public Object read(String sort, int page, int size, UserReadReq request);

    // Update
    public Object update(int userID, UserUpdateReq request);

    // Delete
    public Object delete(int userID);
}
