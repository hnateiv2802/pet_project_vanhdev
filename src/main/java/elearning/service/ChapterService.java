package elearning.service;

import elearning.dto.request.ChapterCreateReq;
import elearning.dto.request.ChapterReadReq;
import elearning.dto.request.ChapterUpdateReq;

public interface ChapterService {
    // Create
    public Object create(ChapterCreateReq request);

    // Read
    public Object read(String sort, int page, int size, ChapterReadReq request);

    // Update
    public Object update(String chapterID, ChapterUpdateReq request);

    // Delete
    public Object delete(String chapterID);
}
