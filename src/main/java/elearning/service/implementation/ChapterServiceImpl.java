package elearning.service.implementation;

import elearning.dto.request.ChapterCreateReq;
import elearning.dto.request.ChapterReadReq;
import elearning.dto.request.ChapterUpdateReq;
import elearning.dto.response.ChapterRes;
import elearning.repository.ChapterRepository;
import elearning.service.ChapterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.Date;

@Service("ChapterService")
public class ChapterServiceImpl implements ChapterService {
    private final ChapterRepository chapterRepository;
    @Autowired
    public ChapterServiceImpl(ChapterRepository chapterRepository) {
        this.chapterRepository = chapterRepository;
    }

    // Create
    @Override
    public Object create(ChapterCreateReq request) {
        request.setStatus("active");
        request.setCreatedDate(Date.from(Instant.now()));

        return request;
    }

    // Read
    @Override
    public Object read(String sort, int page, int size, ChapterReadReq request) {
        ChapterRes response = new ChapterRes();
        response.setChapterName(request.getName());
        response.setDescription(request.getDescription());
        response.setChapterOrder(request.getChapterOrder());
        response.setStatus(request.getStatus());
        response.setCreatedDate(request.getCreatedDate());
        response.setSort(sort);
        response.setPage(page);
        response.setSize(size);

        return response;
    }

    // Update
    @Override
    public Object update(int chapterId, ChapterUpdateReq request) {
        request.setUpdatedDate(Date.from(Instant.now()));

        return request;
    }

    // Delete
    @Override
    public Object delete(int chapterId) {
        return chapterId;
    }
}
