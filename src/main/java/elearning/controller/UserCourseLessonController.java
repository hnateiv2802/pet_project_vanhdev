package elearning.controller;

import elearning.constant.URLConst;
import elearning.dto.request.UserCourseLessonCreateReq;
import elearning.dto.request.UserCourseLessonReadReq;
import elearning.dto.request.UserCourseLessonUpdateReq;
import elearning.service.UserCourseLessonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController("userCourseLessonController")
@RequestMapping("/api/v1")
public class UserCourseLessonController {
    @Autowired
    private final UserCourseLessonService userCourseLessonService;

    public UserCourseLessonController(@Qualifier("UserCourseLessonService") UserCourseLessonService userCourseLessonService) {
        this.userCourseLessonService = userCourseLessonService;
    }

    // Create
    @PostMapping(URLConst.CREATE_USER_COURSE_LESSON)
    public ResponseEntity<?> createUserCourseLesson(@Validated @RequestBody UserCourseLessonCreateReq request) {
        Object res = userCourseLessonService.create(request);
        return ResponseEntity.ok(res);
    }

    // Read
    @GetMapping(URLConst.READ_USER_COURSE_LESSON)
    public ResponseEntity<?> readUserCourseLesson(
            @Validated
            @RequestParam("sort") String sort,
            @RequestParam("page") int page,
            @RequestParam("size") int size,
            @RequestBody UserCourseLessonReadReq request) {
        Object res = userCourseLessonService.read(sort, page, size, request);
        return ResponseEntity.ok(res);
    }

    // Update
    @PutMapping(URLConst.UPDATE_USER_COURSE_LESSON)
    public ResponseEntity<?> updateUserCourseLesson(
            @Validated
            @PathVariable("lesson_id") String courseID,
            @RequestBody UserCourseLessonUpdateReq request) {
        Object res = userCourseLessonService.update(courseID, request);
        return ResponseEntity.ok(res);
    }

    // Delete
    @DeleteMapping(URLConst.DELETE_USER_COURSE_LESSON)
    public ResponseEntity<?> deleteUserCourseLesson(@Validated @PathVariable("lesson_id") String courseID) {
        Object res = userCourseLessonService.delete(courseID);
        return ResponseEntity.ok(res);
    }

    // Start
    @PostMapping(URLConst.START_LESSON)
    public ResponseEntity<?> startLesson(@Validated @PathVariable("lesson_id") String lessonID) {
        Object res = userCourseLessonService.start(lessonID);
        return ResponseEntity.ok(res);
    }

    // Stop
    @PostMapping(URLConst.STOP_LESSON)
    public ResponseEntity<?> stopLesson(@Validated @PathVariable("lesson_id") String lessonID) {
        Object res = userCourseLessonService.stop(lessonID);
        return ResponseEntity.ok(res);
    }

    // Finish
    @PostMapping(URLConst.FINISH_LESSON)
    public ResponseEntity<?> finishLesson(@Validated @PathVariable("lesson_id") String lessonID) {
        Object res = userCourseLessonService.finish(lessonID);
        return ResponseEntity.ok(res);
    }
}
