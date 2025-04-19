package elearning.service;

import elearning.dto.request.TeacherCreateReq;
import elearning.dto.request.TeacherLoginReq;
import elearning.dto.request.TeacherReadReq;
import elearning.dto.request.TeacherUpdateReq;
import elearning.entity.TeacherEntity;

public interface TeacherService {

    // Login
    public Object login(TeacherLoginReq request);

    // Logout
    public Object logout(int userId);

    // Create
    public Object create(TeacherCreateReq request);

    // Read
    public Object read(String sort, int page, int size, TeacherReadReq request);

    // Update
    public Object update(int userId, TeacherUpdateReq request);

    // Delete
    public Object delete(int userId);
}
