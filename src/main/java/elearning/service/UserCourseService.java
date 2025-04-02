package elearning.service;

import elearning.dto.request.*;

public interface UserCourseService {
    // Create
    public Object create(UserCourseCreateReq request);

    // Read
    public Object read(String sort, int page, int size, UserCourseReadReq request);

    // Update
    public Object update(String courseID, UserCourseUpdateReq request);

    // Delete
    public Object delete(String courseID);
}
