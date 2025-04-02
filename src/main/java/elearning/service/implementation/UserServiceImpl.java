package elearning.service.implementation;

import elearning.dto.request.UserCreateReq;
import elearning.dto.request.UserLoginReq;
import elearning.dto.request.UserReadReq;
import elearning.dto.request.UserUpdateReq;
import elearning.dto.response.UserRes;
import elearning.entity.UserEntity;
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
    public Object logout(String userID) {
        return userID;
    }

    // Create
    @Override
    public Object create(UserCreateReq request) {
        request.setStatus("active");
        request.setCreatedDate(Date.from(Instant.now()));

        UserEntity userEntity = new UserEntity();
        userEntity.setUsername(request.getUsername());
        userEntity.setName(request.getName());
        userEntity.setStatus(request.getStatus());
        userEntity.setCreatedDate(request.getCreatedDate());

        userRepository.save(userEntity);

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
    public Object update(String userID, UserUpdateReq request) {
        request.setUpdatedDate(Date.from(Instant.now()));

        return request;
    }

    // Delete
    @Override
    public Object delete(String userID) {
        return userID;
    }
}
