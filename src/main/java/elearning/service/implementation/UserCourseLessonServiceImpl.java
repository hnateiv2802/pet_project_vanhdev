package elearning.service.implementation;

import elearning.dto.request.UserCourseLessonCreateReq;
import elearning.dto.request.UserCourseLessonReadReq;
import elearning.dto.request.UserCourseLessonUpdateReq;
import elearning.dto.response.UserCourseLessonRes;
import elearning.service.UserCourseLessonService;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
@Service("UserCourseLessonService")
public class UserCourseLessonServiceImpl implements UserCourseLessonService {
    @Override
    public Object create(UserCourseLessonCreateReq request) {
        request.setStatus("stopped");
        Instant currentTimestamp = Instant.now();
        String createdDate = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").withZone(ZoneOffset.UTC).format(currentTimestamp);
        request.setCreatedDate(createdDate);

        return request;
    }

    @Override
    public Object read(String sort, int page, int size, UserCourseLessonReadReq request) {
        UserCourseLessonRes response = new UserCourseLessonRes();
        response.setStatus(request.getStatus());
        response.setCreatedDate(request.getCreatedDate());
        response.setSort(sort);
        response.setPage(page);
        response.setSize(size);

        return response;
    }

    @Override
    public Object update(String lessonID, UserCourseLessonUpdateReq request) {
        Instant currentTimestamp = Instant.now();
        String updatedDate = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").withZone(ZoneOffset.UTC).format(currentTimestamp);
        request.setUpdatedDate(updatedDate);

        return request;
    }

    @Override
    public Object delete(String lessonID) {
        return lessonID;
    }

    @Override
    public Object start(String lessonID) {
        return lessonID;
    }

    @Override
    public Object stop(String lessonID) {
        return lessonID;
    }

    @Override
    public Object finish(String lessonID) {
        return lessonID;
    }
}
