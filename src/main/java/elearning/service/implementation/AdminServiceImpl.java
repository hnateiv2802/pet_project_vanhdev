package elearning.service.implementation;

import elearning.constant.RegexConst;
import elearning.dto.request.*;
import elearning.dto.response.AdminRes;
import elearning.entity.AdminEntity;
import elearning.repository.AdminRepository;
import elearning.repository.UserRepository;
import elearning.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.Date;

@Service("adminServiceImpl")
public class AdminServiceImpl implements AdminService {
    private final AdminRepository adminRepository;
    @Autowired
    public AdminServiceImpl(AdminRepository adminRepository) {
        this.adminRepository = adminRepository;
    }

    // Login
    @Override
    public Object login(AdminLoginReq request) {
        AdminEntity admin = adminRepository.findByUsername(request.getUsername()).orElseThrow(() -> new RuntimeException("User not found"));
        //check password:
        if(!admin.getPassword().equals(request.getPassword())) {
            throw new RuntimeException("Wrong password");
        }
        String response = "Login successful";
        return response;
    }

    // Logout
    @Override
    public Object logout(int id) {
        String response = String.format("Logout successful [%d]", id);
        return response;
    }

    // Create
    @Override
    public Object create(AdminCreateReq request) {
        request.setStatus("active");
        request.setCreatedDate(Date.from(Instant.now()));

        AdminEntity newAdmin = new AdminEntity();
        newAdmin.setUsername(request.getUsername());
        newAdmin.setPassword(request.getPassword());
        newAdmin.setStatus(request.getStatus());
//        newAdmin.setCreatedDate(request.getCreatedDate());
        adminRepository.save(newAdmin);

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
    public Object update(int id, AdminUpdateReq request) {
        request.setUpdatedDate(Date.from(Instant.now()));
        AdminEntity admin = adminRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found with id " + id));
//        if (request.getUsername() != null) {
//            admin.setUsername(request.getUsername());
//        }

        if (request.getPassword() != null) {
            admin.setPassword(request.getPassword());
        }

        if (request.getStatus() != null) {
            admin.setStatus(request.getStatus());
        }

        if (request.getCreatedDate() != null) {
            admin.setCreatedDate(request.getCreatedDate());
        }

        if (request.getUpdatedDate() != null) {
            admin.setUpdatedDate(request.getUpdatedDate());
        }

        adminRepository.save(admin);

        return request;
    }

    // Delete
    @Override
    public Object delete(int id) {
        AdminEntity existingAdmin = adminRepository.findById(id).orElseThrow(() ->
                new RuntimeException("Admin not found with Id: " + id));
        existingAdmin.setStatus("inactive");
        adminRepository.save(existingAdmin);

        return id;
    }
}
