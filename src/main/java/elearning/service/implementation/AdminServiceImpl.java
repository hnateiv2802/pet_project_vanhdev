package elearning.service.implementation;

import elearning.constant.RegexConst;
import elearning.dto.request.*;
import elearning.dto.response.AdminRes;
import elearning.service.AdminService;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.Date;

@Service("adminServiceImpl")
public class AdminServiceImpl implements AdminService {
    // Login
    @Override
    public Object login(AdminLoginReq request) {
        return request;
    }

    // Logout
    @Override
    public Object logout(String adminID) {
        return adminID;
    }

    // Create
    @Override
    public Object create(AdminCreateReq request) {
        request.setStatus("active");
        Instant currentTimestamp = Instant.now();
        String createdDate = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").withZone(ZoneOffset.UTC).format(currentTimestamp);
        request.setCreatedDate(createdDate);
        return request;
    }

    // Read
    @Override
    public Object read(String sort, int page, int size, AdminReadReq request) {

        AdminRes response = new AdminRes();
        response.setUsername(request.getUsername());
        response.setStatus(request.getStatus());
        response.setCreatedDate(request.getCreatedDate());
        response.setSort(sort);
        response.setPage(page);
        response.setSize(size);

        return response;
    }

    // Update
    @Override
    public Object update(String adminID, AdminUpdateReq request) {
        Instant currentTimestamp = Instant.now();
        String updatedDate = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").withZone(ZoneOffset.UTC).format(currentTimestamp);
        request.setUpdatedDate(updatedDate);

        return request;
    }

    // Delete
    @Override
    public Object delete(String adminID) {
        return adminID;
    }


}
