package elearning.service;

import elearning.dto.request.UserCourseLessonCreateReq;
import elearning.dto.request.UserCourseLessonReadReq;
import elearning.dto.request.UserCourseLessonUpdateReq;

public interface UserCourseLessonService {
    // Create
    public Object create(int userID, int courseID, UserCourseLessonCreateReq request);

    // Read
    public Object read(int userID, int courseID, String sort, int page, int size, UserCourseLessonReadReq request);

    // Update
    public Object update(int userID, int courseID, int lessonID, UserCourseLessonUpdateReq request);

    // Delete
    public Object delete(int userID, int courseID, int lessonID);

    // // Start
    // public Object start(String lessonID);

    // // Stop
    // public Object stop(String lessonID);

    // // Finish
    // public Object finish(String lessonID);
}
