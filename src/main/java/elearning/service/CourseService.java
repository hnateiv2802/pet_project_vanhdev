package elearning.service;

import elearning.dto.request.CourseCreateReq;
import elearning.dto.request.CourseReadReq;
import elearning.dto.request.CourseUpdateReq;

public interface CourseService {
    // Create
    public Object create(CourseCreateReq request);

    // Read
    public Object read(String sort, int page, int size, CourseReadReq request);

    // Update
    public Object update(String courseID, CourseUpdateReq request);

    // Delete
    public Object delete(String courseID);
}
