package elearning.service.implementation;

import elearning.constant.URLConst;
import elearning.dto.request.UserCreateReq;
import elearning.dto.request.UserLoginReq;
import elearning.dto.request.UserReadReq;
import elearning.dto.request.UserUpdateReq;
import elearning.dto.response.UserRes;
import elearning.entity.UserEntity;
import elearning.exception.GlobalExceptionHandler;
import elearning.repository.UserRepository;
import elearning.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.Date;

@Service("UserService")
public class UserServiceImpl implements UserService {
    @Autowired
    private final UserRepository userRepository;
    public UserServiceImpl(@Qualifier("UserRepository") UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // Login
    @Override
    public Object login(UserLoginReq request) {
        UserEntity user = userRepository.findByUsername(request.getUsername()).orElseThrow(() -> new RuntimeException("User not found"));

        //check password:
        if(!user.getPassword().equals(request.getPassword())) {
            throw new RuntimeException("Wrong password");
        }
        return "Login successful";
    }

    // Logout
    @Override
    public Object logout(int id) {
        String response = String.format("Logout successful [%d]", id);
        return String.format("Logout successful [%d]", id);
    }

    // Create
    @Override
    public Object create(UserCreateReq request) {
        request.setStatus("active");
        request.setCreatedDate(Date.from(Instant.now()));

        UserEntity newUser = new UserEntity();
        newUser.setUsername(request.getUsername());
        newUser.setPassword(request.getPassword());
        newUser.setName(request.getName());
        newUser.setStatus(request.getStatus());
        newUser.setCreatedDate(request.getCreatedDate());
        newUser.setAge(request.getAge());
        userRepository.save(newUser);

        return newUser;
    }

    // Read
    @Override
    public Object read(String sort, int page, int size, UserReadReq request) {

        UserRes response = new UserRes();
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
    public Object update(int id, UserUpdateReq request) {
        Date currentTime = Date.from(Instant.now());
        request.setUpdatedDate(currentTime);

        UserEntity user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy người dùng với ID: " + id));


        if (request.getName() != null) {
            user.setName(request.getName());
        }

        if (request.getPassword() != null) {
            user.setPassword(request.getPassword());
        }

        if (request.getStatus() != null) {
            user.setStatus(request.getStatus());
        }

        if (request.getCreatedDate() != null) {
            user.setCreatedDate(request.getCreatedDate());
        }

        if (request.getUpdatedDate() != null) {
            user.setUpdatedDate(request.getUpdatedDate());
        }

        userRepository.save(user);

        return user;
    }

    // Delete
    @Override
    public Object delete(int id) {
        UserEntity existingUser = userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found with ID: " + id));
        existingUser.setStatus("inactive");
        userRepository.save(existingUser);

        return existingUser;
    }
}
