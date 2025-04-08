package elearning.service;

import elearning.dto.request.*;

public interface UserCourseService {
    // Create
    public Object create(int userID, UserCourseCreateReq request);

    // Read
    public Object read(int userID, String sort, int page, int size, UserCourseReadReq request);

    // Update
    public Object update(int userID, int courseID, UserCourseUpdateReq request);

    // Delete
    public Object delete(int userID, int courseID);
}
