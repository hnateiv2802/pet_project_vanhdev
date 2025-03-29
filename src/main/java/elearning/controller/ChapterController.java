package elearning.controller;

import elearning.constant.URLConst;
import elearning.dto.request.ChapterCreateReq;
import elearning.dto.request.ChapterReadReq;
import elearning.dto.request.ChapterUpdateReq;
import elearning.service.ChapterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class ChapterController {
    // Init
    private final ChapterService chapterService;
    @Autowired
    public ChapterController(ChapterService chapterService) {
        this.chapterService = chapterService;
    }

    // Create
    @PostMapping(URLConst.CREATE_CHAPTER)
    public Object createChapter(@RequestBody ChapterCreateReq request) {
        return chapterService.create(request);
    }

    // Read
    @GetMapping(URLConst.READ_CHAPTER)
    public Object readChapter(@RequestParam("sort") String sort,
                              @RequestParam("page") int page,
                              @RequestParam("size") int size,
                              @RequestBody ChapterReadReq request) {
        return chapterService.read(sort, page, size, request);
    }

    // Update
    @PutMapping(URLConst.UPDATE_CHAPTER)
    public Object updateChapter(@PathVariable("chapter_id") String chapterID,
                                @RequestBody ChapterUpdateReq request) {
        return chapterService.update(chapterID, request);
    }

    // Delete
    @DeleteMapping(URLConst.DELETE_CHAPTER)
    public Object deleteChapter(@PathVariable("chapter_id") String chapterID) {
        return chapterService.delete(chapterID);
    }
}
