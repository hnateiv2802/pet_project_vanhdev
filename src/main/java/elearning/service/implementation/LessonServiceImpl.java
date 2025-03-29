package elearning.service.implementation;

import elearning.dto.request.LessonCreateReq;
import elearning.dto.request.LessonReadReq;
import elearning.dto.request.LessonUpdateReq;
import elearning.dto.response.LessonRes;
import elearning.service.LessonService;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;

@Service("LessonSevice")
public class LessonServiceImpl implements LessonService {

    // Create
    @Override
    public Object create(LessonCreateReq request) {
        request.setStatus("active");
        Instant currentTimestamp = Instant.now();
        String createdDate = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").withZone(ZoneOffset.UTC).format(currentTimestamp);
        request.setCreatedDate(createdDate);

        return request;
    }

    // Read
    @Override
    public Object read(String sort, int page, int size, LessonReadReq request) {
        LessonRes response = new LessonRes();
        response.setLessonName(request.getLessonName());
        response.setChapterName(request.getChapterName());
        response.setCourseName(request.getCourseName());
        response.setType(request.getType());
        response.setUrl(request.getUrl());
        response.setOrder(request.getOrder());
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
        Instant currentTimestamp = Instant.now();
        String updatedDate = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").withZone(ZoneOffset.UTC).format(currentTimestamp);
        request.setUpdatedDate(updatedDate);

        return request;
    }

    // Delete
    @Override
    public Object delete(String lessonID) {
        return lessonID;
    }
}
