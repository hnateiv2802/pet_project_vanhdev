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
    public ResponseEntity<?> createUserCourse(
            @Validated
            @PathVariable("userID") int userID,
            @RequestBody UserCourseCreateReq request
    ) {
        Object res = userCourseService.create(userID, request);
        return ResponseEntity.ok(res);
    }

    // Read
    @PostMapping(URLConst.READ_USER_COURSE)
    public ResponseEntity<?> readUserCourse(
            @Validated
            @PathVariable("userID") int userID,
            @RequestParam("sort") String sort,
            @RequestParam("page") int page,
            @RequestParam("size") int size,
            @RequestBody UserCourseReadReq request
    ) {
        Object res = userCourseService.read(userID, sort, page, size, request);
        return ResponseEntity.ok(res);
    }

    // Update
    @PutMapping(URLConst.UPDATE_USER_COURSE)
    public ResponseEntity<?> updateUserCourse(
            @Validated
            @PathVariable("userID") int userID,
            @PathVariable("courseID") int courseID,
            @RequestBody UserCourseUpdateReq request
    ) {
        Object res = userCourseService.update(userID, courseID, request);
        return ResponseEntity.ok(res);
    }

    // Delete
    @DeleteMapping(URLConst.DELETE_USER_COURSE)
    public ResponseEntity<?> deleteUserCourse(
            @Validated
            @PathVariable("userID") int userID,
            @PathVariable("courseID") int courseID
    ) {
        Object res = userCourseService.delete(userID, courseID);
        return ResponseEntity.ok(res);
    }
}
