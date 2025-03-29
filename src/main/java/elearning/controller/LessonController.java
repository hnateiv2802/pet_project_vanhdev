package elearning.controller;

import elearning.constant.URLConst;
import elearning.dto.request.LessonCreateReq;
import elearning.dto.request.LessonReadReq;
import elearning.dto.request.LessonUpdateReq;
import elearning.service.LessonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class LessonController {
    private final LessonService lessonService;
    @Autowired
    public LessonController(LessonService lessonService) {
        this.lessonService = lessonService;
    }

    // Create
    @PostMapping(URLConst.CREATE_LESSON)
    public Object createLesson(@RequestBody LessonCreateReq request) {
        return lessonService.create(request);
    }

    // Read
    @GetMapping(URLConst.READ_LESSON)
    public Object readChapter(@RequestParam("sort") String sort,
                              @RequestParam("page") int page,
                              @RequestParam("size") int size,
                              @RequestBody LessonReadReq request) {
        return lessonService.read(sort, page, size, request);
    }

    // Update
    @PutMapping(URLConst.UPDATE_LESSON)
    public Object updateLesson(@PathVariable("lesson_id") String lessonID,
                               @RequestBody LessonUpdateReq request) {
        return lessonService.update(lessonID, request);
    }

    // Delete
    @DeleteMapping(URLConst.DELETE_LESSON)
    public Object deleteLesson(@PathVariable("lesson_id") String lessonID) {
        return lessonService.delete(lessonID);
    }
}
