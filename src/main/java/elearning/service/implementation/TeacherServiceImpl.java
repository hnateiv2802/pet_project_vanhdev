package elearning.service.implementation;

import elearning.dto.request.TeacherCreateReq;
import elearning.dto.request.TeacherLoginReq;
import elearning.dto.request.TeacherReadReq;
import elearning.dto.request.TeacherUpdateReq;
import elearning.dto.response.TeacherRes;
import elearning.entity.TeacherEntity;
import elearning.repository.TeacherRepository;
import elearning.service.TeacherService;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Date;

@Service
public class TeacherServiceImpl implements TeacherService {
    private TeacherRepository teacherRepository;
    public TeacherServiceImpl(TeacherRepository teacherRepository) {
        this.teacherRepository = teacherRepository;
    }


    // Login
    @Override
    public Object login(TeacherLoginReq request) {
        TeacherEntity teacher = teacherRepository.findByUsername(request.getUsername()).orElseThrow(() -> new RuntimeException("<Teacher> Wrong username"));

        // Check password (assuming you have a hashed password in the database)
        if (!teacher.getPassword().equals(request.getPassword())) {
            throw new RuntimeException("<Teacher> Wrong password");
        }

        return "<Teacher> Login successful";
    }

    // Logout
    @Override
    public Object logout(int id) {
        return String.format("<Teacher> Logout successful [%d]", id);
    }

    // Create
    @Override
    public Object create(TeacherCreateReq request) {
        request.setStatus("active");
        request.setCreatedDate(Date.from(Instant.now()));

        TeacherEntity newTeacher = new TeacherEntity();
        newTeacher.setUsername(request.getUsername());
        newTeacher.setPassword(request.getPassword());
        newTeacher.setName(request.getName());
        newTeacher.setStatus(request.getStatus());
        newTeacher.setCreatedDate(request.getCreatedDate());
        teacherRepository.save(newTeacher);

        return newTeacher;
    }

    // Read
    @Override
    public Object read(String sort, int page, int size, TeacherReadReq request) {

        TeacherRes response = new TeacherRes();
        response.setUsername(request.getUsername());
        response.setName(request.getName());
        response.setStatus(request.getStatus());
        response.setCreatedDate(request.getCreatedDate());
        response.setSort(sort);
        response.setPage(page);
        response.setSize(size);

        return response;
    }


    // Update
    @Override
    public Object update(int id, TeacherUpdateReq request) {
        request.setUpdatedDate(Date.from(Instant.now()));

        TeacherEntity existingTeacher = teacherRepository.findById(id).orElseThrow(() -> new RuntimeException(String.format("Teacher not found [%d]", id)));
        existingTeacher.setUsername(request.getUsername() != null ? request.getUsername() : existingTeacher.getUsername());
        existingTeacher.setPassword(request.getPassword() != null ? request.getPassword() : existingTeacher.getPassword());
        existingTeacher.setName(request.getName() != null ? request.getName() : existingTeacher.getName());
        existingTeacher.setStatus(request.getStatus() != null ? request.getStatus() : existingTeacher.getStatus());
        existingTeacher.setCreatedDate(request.getCreatedDate() != null ? request.getCreatedDate() : existingTeacher.getCreatedDate());
        existingTeacher.setUpdatedDate(request.getUpdatedDate() != null ? request.getUpdatedDate() : existingTeacher.getUpdatedDate());
        teacherRepository.save(existingTeacher);

        return existingTeacher;
    }

    // Delete
    @Override
    public Object delete(int id) {
        TeacherEntity existingTeacher = teacherRepository.findById(id).orElseThrow(() -> new RuntimeException(String.format("Teacher not found [%d]", id)));
        existingTeacher.setStatus("inactive");
        teacherRepository.save(existingTeacher);

        return existingTeacher;
    }
}
