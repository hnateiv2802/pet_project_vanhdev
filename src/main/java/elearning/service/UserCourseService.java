package elearning.service;

import elearning.dto.request.*;

public interface UserCourseService {
    // Create
    public Object create(int userId, UserCourseCreateReq request);

    // Read
    public Object read(int userId, String sort, int page, int size, UserCourseReadReq request);

    // Update
    public Object update(int userId, int courseId, UserCourseUpdateReq request);

    // Delete
    public Object delete(int userId, int courseId);
}
