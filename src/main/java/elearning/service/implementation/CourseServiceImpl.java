package elearning.service.implementation;

import elearning.dto.request.CourseCreateReq;
import elearning.dto.request.CourseReadReq;
import elearning.dto.request.CourseUpdateReq;
import elearning.dto.response.CourseRes;
import elearning.service.CourseService;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
@Service("CourseService")
public class CourseServiceImpl implements CourseService {
    @Override
    public Object create(CourseCreateReq request) {
        request.setStatus("active");
        Instant currentTimestamp = Instant.now();
        String createdDate = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").withZone(ZoneOffset.UTC).format(currentTimestamp);
        request.setCreatedDate(createdDate);

        return request;
    }

    @Override
    public Object read(String sort, int page, int size, CourseReadReq request) {
        CourseRes response = new CourseRes();
        response.setCourseName(request.getCourseName());
        response.setDescription(request.getDescription());
        response.setTeacherName(request.getTeacherName());
        response.setStatus(request.getStatus());
        response.setCreatedDate(request.getCreatedDate());
        response.setSort(sort);
        response.setPage(page);
        response.setSize(size);

        return response;
    }

    @Override
    public Object update(String courseID, CourseUpdateReq request) {
        Instant currentTimestamp = Instant.now();
        String updatedDate = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").withZone(ZoneOffset.UTC).format(currentTimestamp);
        request.setUpdatedDate(updatedDate);

        return request;
    }

    @Override
    public Object delete(String courseID) {
        return courseID;
    }
}
