package elearning.controller;

import elearning.constant.URLConst;
import elearning.dto.request.LessonCreateReq;
import elearning.dto.request.LessonReadReq;
import elearning.dto.request.LessonUpdateReq;
import elearning.service.LessonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class LessonController {

    private final LessonService lessonService;
    @Autowired
    public LessonController(@Qualifier("LessonService") LessonService lessonService) {
        this.lessonService = lessonService;
    }

    // Create
    @PostMapping(URLConst.CREATE_LESSON)
    public ResponseEntity<?> createLesson(@Validated @RequestBody LessonCreateReq request) {
        Object res = lessonService.create(request);
        return ResponseEntity.ok(res);
    }

    // Read
    @GetMapping(URLConst.READ_LESSON)
    public ResponseEntity<?> readChapter(
            @Validated
            @RequestParam("sort") String sort,
            @RequestParam("page") int page,
            @RequestParam("size") int size,
            @RequestBody LessonReadReq request) {
        Object res = lessonService.read(sort, page, size, request);
        return ResponseEntity.ok(res);
    }

    // Update
    @PutMapping(URLConst.UPDATE_LESSON)
    public ResponseEntity<?> updateLesson(
            @Validated
            @PathVariable("lesson_id") String lessonID,
            @RequestBody LessonUpdateReq request) {
        Object res = lessonService.update(lessonID, request);
        return ResponseEntity.ok(res);
    }

    // Delete
    @DeleteMapping(URLConst.DELETE_LESSON)
    public ResponseEntity<?> deleteLesson(@Validated @PathVariable("lesson_id") String lessonID) {
        Object res = lessonService.delete(lessonID);
        return ResponseEntity.ok(res);
    }
}
