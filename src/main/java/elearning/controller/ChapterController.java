package elearning.controller;

import elearning.constant.URLConst;
import elearning.dto.request.ChapterCreateReq;
import elearning.dto.request.ChapterReadReq;
import elearning.dto.request.ChapterUpdateReq;
import elearning.service.ChapterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController("chapterController")
@RequestMapping("/api/v1")
public class ChapterController {
@Autowired
    private final ChapterService chapterService;

    public ChapterController(@Qualifier("ChapterService")ChapterService chapterService) {
        this.chapterService = chapterService;
    }

    // Create
    @PostMapping(URLConst.CREATE_CHAPTER)
    public ResponseEntity<?> createChapter(@Validated @RequestBody ChapterCreateReq request) {
        Object response = chapterService.create(request);
        return ResponseEntity.ok(response);
    }

    // Read
    @PostMapping(URLConst.READ_CHAPTER)
    public ResponseEntity<?> readChapter(
            @Validated
            @RequestParam("sort") String sort,
            @RequestParam("page") int page,
            @RequestParam("size") int size,
            @RequestBody ChapterReadReq request) {
        Object response = chapterService.read(sort, page, size, request);
        return ResponseEntity.ok(response);
    }

    // Update
    @PutMapping(URLConst.UPDATE_CHAPTER)
    public ResponseEntity<?> updateChapter(
            @Validated
            @PathVariable("chapter_id") int chapterId,
            @RequestBody ChapterUpdateReq request) {
        Object response = chapterService.update(chapterId, request);
        return ResponseEntity.ok(response);
    }

    // Delete
    @DeleteMapping(URLConst.DELETE_CHAPTER)
    public ResponseEntity<?> deleteChapter(@Validated @PathVariable("chapter_id") int chapterId) {
        Object response = chapterService.delete(chapterId);
        return ResponseEntity.ok(response);
    }
}
