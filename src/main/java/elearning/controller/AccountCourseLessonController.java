package elearning.controller;

import elearning.constant.URLConst;
import elearning.dto.request.AccountCourseLessonCreateReq;
import elearning.dto.request.AccountCourseLessonReadReq;
import elearning.dto.request.AccountCourseLessonUpdateReq;
import elearning.service.AccountCourseLessonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController("accountCourseLessonController")
@RequestMapping("/api/v1")
public class AccountCourseLessonController {
    private final AccountCourseLessonService accountCourseLessonService;
@Autowired
    public AccountCourseLessonController(AccountCourseLessonService accountCourseLessonService) {
        this.accountCourseLessonService = accountCourseLessonService;
    }

    // Create
    @PostMapping(URLConst.CREATE_ACCOUNT_COURSE_LESSON)
    public ResponseEntity<?> createAccountCourseLesson(@Validated @RequestBody AccountCourseLessonCreateReq request) {
        Object res = accountCourseLessonService.create(request);
        return ResponseEntity.ok(res);
    }

    // Read
    @GetMapping(URLConst.READ_ACCOUNT_COURSE_LESSON)
    public ResponseEntity<?> readAccountCourseLesson(
            @Validated
            @RequestParam("sort") String sort,
            @RequestParam("page") int page,
            @RequestParam("size") int size,
            @RequestBody AccountCourseLessonReadReq request) {
        Object res = accountCourseLessonService.read(sort, page, size, request);
        return ResponseEntity.ok(res);
    }

    // Update
    @PutMapping(URLConst.UPDATE_ACCOUNT_COURSE_LESSON)
    public ResponseEntity<?> updateAccountCourseLesson(
            @Validated
            @PathVariable("lesson_id") String courseID,
            @RequestBody AccountCourseLessonUpdateReq request) {
        Object res = accountCourseLessonService.update(courseID, request);
        return ResponseEntity.ok(res);
    }

    // Delete
    @DeleteMapping(URLConst.DELETE_ACCOUNT_COURSE_LESSON)
    public ResponseEntity<?> deleteAccountCourseLesson(@Validated @PathVariable("lesson_id") String courseID) {
        Object res = accountCourseLessonService.delete(courseID);
        return ResponseEntity.ok(res);
    }

    // Start
    @PostMapping(URLConst.START_LESSON)
    public ResponseEntity<?> startLesson(@Validated @PathVariable("lesson_id") String lessonID) {
        Object res = accountCourseLessonService.start(lessonID);
        return ResponseEntity.ok(res);
    }

    // Stop
    @PostMapping(URLConst.STOP_LESSON)
    public ResponseEntity<?> stopLesson(@Validated @PathVariable("lesson_id") String lessonID) {
        Object res = accountCourseLessonService.stop(lessonID);
        return ResponseEntity.ok(res);
    }

    // Finish
    @PostMapping(URLConst.FINISH_LESSON)
    public ResponseEntity<?> finishLesson(@Validated @PathVariable("lesson_id") String lessonID) {
        Object res = accountCourseLessonService.finish(lessonID);
        return ResponseEntity.ok(res);
    }
}
