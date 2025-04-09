package elearning.service.implementation;

import elearning.dto.request.*;
import elearning.dto.response.UserCourseRes;
import elearning.repository.CourseRepository;
import elearning.service.UserCourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.Date;

@Service("UserCourseService")
public class UserCourseServiceImpl implements UserCourseService {
    private final CourseRepository courseRepository;
    @Autowired
    public UserCourseServiceImpl(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }
    // Create
    @Override
    public Object create(int userId, UserCourseCreateReq request) {
        request.setStatus("stopped");
        request.setCreatedDate(Date.from(Instant.now()));

        return request;
    }

    // Read
    @Override
    public Object read(int userId, String sort, int page, int size, UserCourseReadReq request) {
        UserCourseRes response = new UserCourseRes();
        response.setRating(request.getRating());
        response.setReview(request.getReview());
        response.setStatus(request.getStatus());
        response.setCreatedDate(request.getCreatedDate());
        response.setSort(sort);
        response.setPage(page);
        response.setSize(size);

        return response;
    }

    // Update
    @Override
    public Object update(int userId, int courseId, UserCourseUpdateReq request) {
        request.setUpdatedDate(Date.from(Instant.now()));

        return request;
    }

    // Delete
    @Override
    public Object delete(int userId, int courseId) {
        return courseId;
    }
}
