package elearning.service.implementation;

import elearning.dto.request.AccountCourseLessonCreateReq;
import elearning.dto.request.AccountCourseLessonReadReq;
import elearning.dto.request.AccountCourseLessonUpdateReq;
import elearning.dto.response.AccountCourseLessonRes;
import elearning.service.AccountCourseLessonService;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
@Service("AccountCourseLessonService")
public class AccountCourseLessonServiceImpl implements AccountCourseLessonService {
    // Create
    @Override
    public Object create(AccountCourseLessonCreateReq request) {
        request.setStatus("stopped");
        Instant currentTimestamp = Instant.now();
        String createdDate = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").withZone(ZoneOffset.UTC).format(currentTimestamp);
        request.setCreatedDate(createdDate);

        return request;
    }

    // Read
    @Override
    public Object read(String sort, int page, int size, AccountCourseLessonReadReq request) {
        AccountCourseLessonRes response = new AccountCourseLessonRes();
        response.setStatus(request.getStatus());
        response.setCreatedDate(request.getCreatedDate());
        response.setSort(sort);
        response.setPage(page);
        response.setSize(size);

        return response;
    }

    // Update
    @Override
    public Object update(String lessonID, AccountCourseLessonUpdateReq request) {
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

    // Start
    @Override
    public Object start(String lessonID) {
        return lessonID;
    }

    // Stop
    @Override
    public Object stop(String lessonID) {
        return lessonID;
    }

    // Finish
    @Override
    public Object finish(String lessonID) {
        return lessonID;
    }
}
