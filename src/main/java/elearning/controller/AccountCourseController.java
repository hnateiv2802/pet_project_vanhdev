package elearning.controller;

import elearning.constant.URLConst;
import elearning.dto.request.*;
import elearning.service.AccountCourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController("accountCourseController")
@RequestMapping("/api/v1")
public class AccountCourseController {
    // Init
    private final AccountCourseService accountCourseService;
@Autowired
    public AccountCourseController(AccountCourseService accountCourseService) {
        this.accountCourseService = accountCourseService;
    }


    // AccountCourse

    // Create
    @PostMapping(URLConst.CREATE_ACCOUNT_COURSE)
    public Object createAccountCourse(@RequestBody AccountCourseCreateReq request) {
        return accountCourseService.create(request);
    }

    // Read
    @GetMapping(URLConst.READ_ACCOUNT_COURSE)
    public Object readAccountCourse(@RequestParam("sort") String sort,
                                    @RequestParam("page") int page,
                                    @RequestParam("size") int size,
                                    @RequestBody AccountCourseReadReq request) {
        return accountCourseService.read(sort, page, size, request);
    }

    // Update
    @PutMapping(URLConst.UPDATE_ACCOUNT_COURSE)
    public Object updateAccountCourse(@PathVariable("course_id") String courseID,
                                      @RequestBody AccountCourseUpdateReq request) {
        return accountCourseService.update(courseID, request);
    }

    // Delete
    @DeleteMapping(URLConst.DELETE_ACCOUNT_COURSE)
    public Object deleteAccountCourse(@PathVariable("course_id") String courseID) {
        return accountCourseService.delete(courseID);
    }

    // View
    @GetMapping(URLConst.VIEW_COURSE)
    public Object viewCourse(@PathVariable("course_id") String courseID) {
        return accountCourseService.view(courseID);
    }

    // Join
    @PostMapping(URLConst.JOIN_COURSE)
    public Object joinCourse(@PathVariable("course_id") String courseID) {
        return accountCourseService.join(courseID);
    }

    // Rate
    @PostMapping(URLConst.RATE_COURSE)
    public Object rateCourse(@PathVariable("course_id") String courseID,
                             @RequestBody AccountCourseRateReq request) {
        return accountCourseService.rate(courseID, request);
    }

    // Review
    @PostMapping(URLConst.REVIEW_COURSE)
    public Object reviewCourse(@PathVariable("course_id") String courseID,
                               @RequestBody AccountCourseReviewReq request) {
        return accountCourseService.review(courseID, request);
    }
}
