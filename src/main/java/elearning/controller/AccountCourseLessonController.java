package elearning.controller;

import elearning.constant.URLConst;
import elearning.dto.request.AccountCourseLessonCreateReq;
import elearning.dto.request.AccountCourseLessonReadReq;
import elearning.dto.request.AccountCourseLessonUpdateReq;
import elearning.service.AccountCourseLessonService;
import org.springframework.beans.factory.annotation.Autowired;
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
    public Object createAccountCourseLesson(@RequestBody AccountCourseLessonCreateReq request) {
        return accountCourseLessonService.create(request);
    }

    // Read
    @GetMapping(URLConst.READ_ACCOUNT_COURSE_LESSON)
    public Object readAccountCourseLesson(@RequestParam("sort") String sort,
                                          @RequestParam("page") int page,
                                          @RequestParam("size") int size,
                                          @RequestBody AccountCourseLessonReadReq request) {
        return accountCourseLessonService.read(sort, page, size, request);
    }

    // Update
    @PutMapping(URLConst.UPDATE_ACCOUNT_COURSE_LESSON)
    public Object updateAccountCourseLesson(@PathVariable("lesson_id") String courseID,
                                            @RequestBody AccountCourseLessonUpdateReq request) {
        return accountCourseLessonService.update(courseID, request);
    }

    // Delete
    @DeleteMapping(URLConst.DELETE_ACCOUNT_COURSE_LESSON)
    public Object deleteAccountCourseLesson(@PathVariable("lesson_id") String courseID) {
        return accountCourseLessonService.delete(courseID);
    }

    // Start
    @PostMapping(URLConst.START_LESSON)
    public Object startLesson(@PathVariable("lesson_id") String lessonID) {
        return accountCourseLessonService.start(lessonID);
    }

    // Stop
    @PostMapping(URLConst.STOP_LESSON)
    public Object stopLesson(@PathVariable("lesson_id") String lessonID) {
        return accountCourseLessonService.stop(lessonID);
    }

    // Finish
    @PostMapping(URLConst.FINISH_LESSON)
    public Object finishLesson(@PathVariable("lesson_id") String lessonID) {
        return accountCourseLessonService.finish(lessonID);
    }
}
