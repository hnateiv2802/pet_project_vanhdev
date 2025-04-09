package elearning.service;

import elearning.dto.request.LessonCreateReq;
import elearning.dto.request.LessonReadReq;
import elearning.dto.request.LessonUpdateReq;

public interface LessonService {
    // Create
    public Object create(LessonCreateReq request);

    // Read
    public Object read(String sort, int page, int size, LessonReadReq request);

    // Update
    public Object update(int lessonId, LessonUpdateReq request);

    // Delete
    public Object delete(int lessonId);
}
