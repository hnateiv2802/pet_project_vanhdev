package elearning.controller;

import elearning.constant.URLConst;
import elearning.dto.request.CourseCreateReq;
import elearning.dto.request.CourseReadReq;
import elearning.dto.request.CourseUpdateReq;
import elearning.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class CourseController {

    private final CourseService courseService;
    @Autowired
    public CourseController(@Qualifier("CourseService") CourseService courseService) {
        this.courseService = courseService;
    }

    // Create
    @PostMapping(URLConst.CREATE_COURSE)
    public ResponseEntity<?> createCourse(@Validated @RequestBody CourseCreateReq request) {
        Object res = courseService.create(request);
        return ResponseEntity.ok(res);
    }

    // Read
    @GetMapping(URLConst.READ_COURSE)
    public ResponseEntity<?> readCourse(
            @Validated
            @RequestParam("sort") String sort,
            @RequestParam("page") int page,
            @RequestParam("size") int size,
            @RequestBody CourseReadReq request) {
        Object res = courseService.read(sort, page, size, request);
        return ResponseEntity.ok(res);
    }

    // Update
    @PutMapping(URLConst.UPDATE_COURSE)
    public ResponseEntity<?> updateCourse(
            @Validated
            @PathVariable("course_id") String courseID,
            @RequestBody CourseUpdateReq request) {
        Object res = courseService.update(courseID, request);
        return ResponseEntity.ok(res);
    }

    // Delete
    @DeleteMapping(URLConst.DELETE_COURSE)
    public ResponseEntity<?> deleteCourse(@Validated @PathVariable("course_id") String courseID) {
        Object res = courseService.delete(courseID);
        return ResponseEntity.ok(res);
    }
}
