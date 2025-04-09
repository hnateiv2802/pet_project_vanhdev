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

    // Create
    @Override
    public Object create(int userId, int courseId, UserCourseLessonCreateReq request) {
        request.setStatus("stopped");
        request.setCreatedDate(Date.from(Instant.now()));

        return request;
    }

    // Read
    @Override
    public Object read(int userId, int courseId, String sort, int page, int size, UserCourseLessonReadReq request) {
        UserCourseLessonRes response = new UserCourseLessonRes();
        response.setStatus(request.getStatus());
        response.setCreatedDate(request.getCreatedDate());
        response.setSort(sort);
        response.setPage(page);
        response.setSize(size);

        return response;
    }

    // Update
    @Override
    public Object update(int userId, int courseId, int lessonId, UserCourseLessonUpdateReq request) {
        request.setUpdatedDate(Date.from(Instant.now()));

        return request;
    }

    // Delete
    @Override
    public Object delete(int userId, int courseId, int lessonId) {
        return lessonId;
    }
}
