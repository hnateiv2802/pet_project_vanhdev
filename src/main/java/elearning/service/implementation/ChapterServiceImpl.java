package elearning.service.implementation;

import elearning.dto.request.ChapterCreateReq;
import elearning.dto.request.ChapterReadReq;
import elearning.dto.request.ChapterUpdateReq;
import elearning.dto.response.ChapterRes;
import elearning.service.ChapterService;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
@Service("ChapterService")
public class ChapterServiceImpl implements ChapterService {
    // Create
    @Override
    public Object create(ChapterCreateReq request) {
        request.setStatus("active");
        Instant currentTimestamp = Instant.now();
        String createdDate = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").withZone(ZoneOffset.UTC).format(currentTimestamp);
        request.setCreatedDate(createdDate);

        return request;
    }

    // Read
    @Override
    public Object read(String sort, int page, int size, ChapterReadReq request) {
        ChapterRes response = new ChapterRes();
        response.setChapterName(request.getChapterName());
        response.setCourseName(request.getCourseName());
        response.setDescription(request.getDescription());
        response.setOrder(request.getOrder());
        response.setStatus(request.getStatus());
        response.setCreatedDate(request.getCreatedDate());
        response.setUpdatedDate(request.getUpdatedDate());
        response.setSort(sort);
        response.setPage(page);
        response.setSize(size);

        return response;
    }

    // Update
    @Override
    public Object update(String chapterID, ChapterUpdateReq request) {
        Instant currentTimestamp = Instant.now();
        String updatedDate = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").withZone(ZoneOffset.UTC).format(currentTimestamp);
        request.setUpdatedDate(updatedDate);

        return request;
    }

    // Delete
    @Override
    public Object delete(String chapterID) {
        return chapterID;
    }
}
