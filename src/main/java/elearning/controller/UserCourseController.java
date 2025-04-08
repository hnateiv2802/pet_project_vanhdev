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
            @PathVariable("userId") int userId,
            @RequestBody UserCourseCreateReq request
    ) {
        Object response = userCourseService.create(userId, request);
        return ResponseEntity.ok(response);
    }

    // Read
    @PostMapping(URLConst.READ_USER_COURSE)
    public ResponseEntity<?> readUserCourse(
            @Validated
            @PathVariable("userId") int userId,
            @RequestParam("sort") String sort,
            @RequestParam("page") int page,
            @RequestParam("size") int size,
            @RequestBody UserCourseReadReq request
    ) {
        Object response = userCourseService.read(userId, sort, page, size, request);
        return ResponseEntity.ok(response);
    }

    // Update
    @PutMapping(URLConst.UPDATE_USER_COURSE)
    public ResponseEntity<?> updateUserCourse(
            @Validated
            @PathVariable("userId") int userId,
            @PathVariable("courseId") int courseId,
            @RequestBody UserCourseUpdateReq request
    ) {
        Object response = userCourseService.update(userId, courseId, request);
        return ResponseEntity.ok(response);
    }

    // Delete
    @DeleteMapping(URLConst.DELETE_USER_COURSE)
    public ResponseEntity<?> deleteUserCourse(
            @Validated
            @PathVariable("userId") int userId,
            @PathVariable("courseId") int courseId
    ) {
        Object response = userCourseService.delete(userId, courseId);
        return ResponseEntity.ok(response);
    }
}
