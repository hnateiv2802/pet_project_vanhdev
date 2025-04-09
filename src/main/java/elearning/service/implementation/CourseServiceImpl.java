package elearning.service.implementation;

import elearning.dto.request.CourseCreateReq;
import elearning.dto.request.CourseReadReq;
import elearning.dto.request.CourseUpdateReq;
import elearning.dto.response.CourseRes;
import elearning.repository.CourseRepository;
import elearning.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.Date;

@Service("CourseService")
public class CourseServiceImpl implements CourseService {
    private final CourseRepository courseRepository;

    @Autowired
    public CourseServiceImpl(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }
    // Create
    @Override
    public Object create(CourseCreateReq request) {
        request.setStatus("active");
        request.setCreatedDate(Date.from(Instant.now()));

        return request;
    }

    // Read
    @Override
    public Object read(String sort, int page, int size, CourseReadReq request) {
        CourseRes response = new CourseRes();
        response.setCourseName(request.getName());
        response.setDescription(request.getDescription());
        response.setTeacherName(request.getName());
        response.setStatus(request.getStatus());
        response.setCreatedDate(request.getCreatedDate());
        response.setSort(sort);
        response.setPage(page);
        response.setSize(size);

        return response;
    }

    // Update
    @Override
    public Object update(int courseID, CourseUpdateReq request) {
        request.setUpdatedDate(Date.from(Instant.now()));

        return request;
    }

    // Delete
    @Override
    public Object delete(int courseID) {

        return courseID;
    }
}
