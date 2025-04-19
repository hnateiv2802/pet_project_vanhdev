package elearning.controller;

import elearning.constant.URLConst;
import elearning.dto.request.TeacherCreateReq;
import elearning.dto.request.TeacherLoginReq;
import elearning.dto.request.TeacherReadReq;
import elearning.dto.request.TeacherUpdateReq;
import elearning.repository.TeacherRepository;
import elearning.service.TeacherService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class TeacherController {
    private final TeacherService teacherService;

    public TeacherController(@Qualifier("teacherServiceImpl") TeacherService teacherService) {
        this.teacherService = teacherService;
    }

    // Login
    @PostMapping(URLConst.LOGIN_TEACHER)
    public ResponseEntity<?> login(@Validated @RequestBody TeacherLoginReq request) {
        Object response = teacherService.login(request);
        return ResponseEntity.ok(response);
    }

    // Logout
    @PostMapping(URLConst.LOGOUT_TEACHER)
    public ResponseEntity<?> logout(@Validated @PathVariable("id") int id) {
        Object response = teacherService.logout(id);
        return ResponseEntity.ok(response);
    }

    // Create
    @PostMapping(URLConst.CREATE_TEACHER)
    public ResponseEntity<?> createTeacher(@Validated @RequestBody TeacherCreateReq request) {
        Object response = teacherService.create(request);
        return ResponseEntity.ok(response);
    }

    // Read
    @PostMapping(URLConst.READ_TEACHER)
    public ResponseEntity<?> readTeacher(
            @Validated
            @RequestParam("sort") String sort,
            @RequestParam("page") int page,
            @RequestParam("size") int size,
            @RequestBody TeacherReadReq request) {
        Object response = teacherService.read(sort, page, size, request);
        return ResponseEntity.ok(response);
    }

    // Update
    @PutMapping(URLConst.UPDATE_TEACHER)
    public ResponseEntity<?> updateTeacher(
            @Validated
            @PathVariable("id") int id,
            @RequestBody TeacherUpdateReq request) {
        Object response = teacherService.update(id, request);
        return ResponseEntity.ok(response);
    }

    // Delete
    @DeleteMapping(URLConst.DELETE_TEACHER)
    public ResponseEntity<?> deleteTeacher(@Validated @PathVariable("id") int id) {
        Object response =  teacherService.delete(id);
        return ResponseEntity.ok(response);
    }



}
