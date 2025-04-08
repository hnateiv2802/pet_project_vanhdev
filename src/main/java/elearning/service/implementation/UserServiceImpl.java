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
        return request;
    }

    // Logout
    @Override
    public Object logout(int userID) {
        return userID;
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

        return request;
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
    public Object update(int userID, UserUpdateReq request) {
        Date currentTime = Date.from(Instant.now());
        request.setUpdatedDate(currentTime);

        UserEntity user = userRepository.findById(userID)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy người dùng với ID: " + userID));


        if (request.getName() != null) {
            user.setName(request.getName());
        }
        if (request.getPassword() != null) {
            user.setPassword(request.getPassword());
        }

        if (request.getStatus() != null) {
            user.setStatus(request.getStatus());
        }

        user.setUpdatedDate(currentTime);

        userRepository.save(user);

        return request;
    }

    // Delete
    @Override
    public Object delete(int userID) {
        return userID;
    }

}
