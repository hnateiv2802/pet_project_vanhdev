package elearning.service;

import elearning.dto.request.*;

public interface AccountCourseService {
    // Create
    public Object create(AccountCourseCreateReq request);

    // Read
    public Object read(String sort, int page, int size, AccountCourseReadReq request);

    // Update
    public Object update(String courseID, AccountCourseUpdateReq request);

    // Delete
    public Object delete(String courseID);

    // View
    public Object view(String courseID);

    // Join
    public Object join(String courseID);

    // Rate
    public Object rate(String courseID, AccountCourseRateReq request);

    // Review
    public Object review(String courseID, AccountCourseReviewReq request);
}
