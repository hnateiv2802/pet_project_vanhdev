package elearning.controller;

import elearning.constant.URLConst;
import elearning.dto.request.UserCourseLessonCreateReq;
import elearning.dto.request.UserCourseLessonReadReq;
import elearning.dto.request.UserCourseLessonUpdateReq;
import elearning.service.UserCourseLessonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
@RestController("userCourseLessonController")
@RequestMapping("/api/v1")
public class UserCourseLessonController {
    @Autowired
    private final UserCourseLessonService userCourseLessonService;


    public UserCourseLessonController(UserCourseLessonService userCourseLessonService) {
        this.userCourseLessonService = userCourseLessonService;
    }

    // Create
    @PostMapping(URLConst.CREATE_USER_COURSE_LESSON)
    public ResponseEntity<?> createUserCourseLesson(
            @Validated
            @PathVariable("userId") int userId,
            @PathVariable("courseId") int courseId,
            @RequestBody UserCourseLessonCreateReq request
    ) {
        Object response = userCourseLessonService.create(userId, courseId, request);
        return ResponseEntity.ok(response);
    }

    // Read
    @PostMapping(URLConst.READ_USER_COURSE_LESSON)
    public ResponseEntity<?> readUserCourseLesson(
            @Validated
            @PathVariable("userId") int userId,
            @PathVariable("courseId") int courseId,
            @RequestParam("sort") String sort,
            @RequestParam("page") int page,
            @RequestParam("size") int size,
            @RequestBody UserCourseLessonReadReq request
    ) {
        Object response = userCourseLessonService.read(userId, courseId, sort, page, size, request);
        return ResponseEntity.ok(response);
    }

    // Update
    @PutMapping(URLConst.UPDATE_USER_COURSE_LESSON)
    public ResponseEntity<?> updateUserCourseLesson(
            @Validated
            @PathVariable("userId") int userId,
            @PathVariable("courseId") int courseId,
            @PathVariable("lessonId") int lessonId,
            @RequestBody UserCourseLessonUpdateReq request
    ) {
        Object response = userCourseLessonService.update(userId, courseId, lessonId, request);
        return ResponseEntity.ok(response);
    }

    // Delete
    @DeleteMapping(URLConst.DELETE_USER_COURSE_LESSON)
    public ResponseEntity<?> deleteUserCourseLesson(
            @Validated
            @PathVariable("userId") int userId,
            @PathVariable("courseId") int courseId,
            @PathVariable("lessonId") int lessonId
    ) {
        Object response = userCourseLessonService.delete(userId, courseId, lessonId);
        return ResponseEntity.ok(response);
    }

}
