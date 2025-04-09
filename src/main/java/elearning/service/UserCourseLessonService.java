package elearning.service;

import elearning.dto.request.UserCourseLessonCreateReq;
import elearning.dto.request.UserCourseLessonReadReq;
import elearning.dto.request.UserCourseLessonUpdateReq;

public interface UserCourseLessonService {
    // Create
    public Object create(int userId, int courseId, UserCourseLessonCreateReq request);

    // Read
    public Object read(int userId, int courseId, String sort, int page, int size, UserCourseLessonReadReq request);

    // Update
    public Object update(int userId, int courseId, int lessonId, UserCourseLessonUpdateReq request);

    // Delete
    public Object delete(int userId, int courseId, int lessonId);

}
