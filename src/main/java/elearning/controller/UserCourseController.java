package elearning.controller;

import elearning.constant.URLConst;
import elearning.dto.request.*;
import elearning.dto.response.AdminRes;
import elearning.service.UserCourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.util.Date;

@RestController("userCourseController")
@RequestMapping("/api/v1")
public class UserCourseController {
    @Autowired
    private final UserCourseService userCourseService;

    public UserCourseController(@Qualifier("UserCourseService") UserCourseService userCourseService) {
        this.userCourseService = userCourseService;
    }

    // Create
    @PostMapping(URLConst.CREATE_USER_COURSE)
    public ResponseEntity<?> createUserCourse(@Validated @RequestBody UserCourseCreateReq request) {
        Object res = userCourseService.create(request);
        return ResponseEntity.ok(res);
    }

    // Read
    @GetMapping(URLConst.READ_USER_COURSE)
    public ResponseEntity<?> readUserCourse(
            @Validated
            @RequestParam("sort") String sort,
            @RequestParam("page") int page,
            @RequestParam("size") int size,
            @RequestBody UserCourseReadReq request) {
        Object res = userCourseService.read(sort, page, size, request);
        return ResponseEntity.ok(res);
    }

    // Update
    @PutMapping(URLConst.UPDATE_USER_COURSE)
    public ResponseEntity<?> updateUserCourse(
            @Validated
            @PathVariable("course_id") String courseID,
            @RequestBody UserCourseUpdateReq request) {
        Object res = userCourseService.update(courseID, request);
        return ResponseEntity.ok(res);
    }

    // Delete
    @DeleteMapping(URLConst.DELETE_USER_COURSE)
    public ResponseEntity<?> deleteUserCourse(@Validated @PathVariable("course_id") String courseID) {
        Object res = userCourseService.delete(courseID);
        return ResponseEntity.ok(res);
    }
}
