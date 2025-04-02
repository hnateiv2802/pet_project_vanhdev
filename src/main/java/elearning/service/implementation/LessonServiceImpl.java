package elearning.service.implementation;

import elearning.dto.request.LessonCreateReq;
import elearning.dto.request.LessonReadReq;
import elearning.dto.request.LessonUpdateReq;
import elearning.dto.response.LessonRes;
import elearning.repository.LessonRepository;
import elearning.service.LessonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.Date;

@Service("LessonService")
public class LessonServiceImpl implements LessonService {
    private final LessonRepository lessonRepository;
    @Autowired
    public LessonServiceImpl(LessonRepository lessonRepository) {
        this.lessonRepository = lessonRepository;
    }
    // Create
    @Override
    public Object create(LessonCreateReq request) {
        request.setStatus("active");
        request.setCreatedDate(Date.from(Instant.now()));

        return request;
    }

    // Read
    @Override
    public Object read(String sort, int page, int size, LessonReadReq request) {
        LessonRes response = new LessonRes();
        response.setLessonName(request.getLessonName());
        response.setType(request.getType());
        response.setUrl(request.getUrl());
        response.setLessonOrder(request.getLessonOrder());
        response.setStatus(request.getStatus());
        response.setCreatedDate(request.getCreatedDate());
        response.setSort(sort);
        response.setPage(page);
        response.setSize(size);

        return response;
    }

    // Update
    @Override
    public Object update(String lessonID, LessonUpdateReq request) {
        request.setUpdatedDate(Date.from(Instant.now()));

        return request;
    }

    // Delete
    @Override
    public Object delete(String lessonID) {

        return lessonID;
    }
}
