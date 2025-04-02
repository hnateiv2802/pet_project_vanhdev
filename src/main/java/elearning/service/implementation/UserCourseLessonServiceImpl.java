package elearning.service.implementation;

import elearning.dto.request.UserCourseLessonCreateReq;
import elearning.dto.request.UserCourseLessonReadReq;
import elearning.dto.request.UserCourseLessonUpdateReq;
import elearning.dto.response.UserCourseLessonRes;
import elearning.repository.UserCourseLessonRepository;
import elearning.service.UserCourseLessonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.Date;

@Service("UserCourseLessonService")
public class UserCourseLessonServiceImpl implements UserCourseLessonService {
    private final UserCourseLessonRepository userCourseLessonRepository;
    @Autowired
    public UserCourseLessonServiceImpl(UserCourseLessonRepository userCourseLessonRepository) {
        this.userCourseLessonRepository = userCourseLessonRepository;
    }

    //create
    @Override
    public Object create(UserCourseLessonCreateReq request) {
        request.setStatus("stopped");
        request.setCreatedDate(Date.from(Instant.now()));

        return request;
    }

    //read
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

    //update
    @Override
    public Object update(String lessonID, UserCourseLessonUpdateReq request) {
        request.setUpdatedDate(Date.from(Instant.now()));

        return request;
    }

    //delete
    @Override
    public Object delete(String lessonID) {
        return lessonID;
    }
}
