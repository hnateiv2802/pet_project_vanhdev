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
        UserEntity user = userRepository.findByUsername(request.getUsername());
        if (user == null) {
            return "account is not exist";
        }
        if (!user.getPassword().equals(request.getPassword())) {
            return "wrong password";
        }
        // create response:


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
        userEntity.setNickname(request.getNickname());
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
        response.setNickname(request.getNickname());
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


    //test JPA -create user
    public Object createTest(UserCreateReq request) {
        UserEntity userEntity = new UserEntity();
        userEntity.setUsername(request.getUsername());
        userEntity.setNickname(request.getNickname());
        userEntity.setStatus(URLConst.ACTIVE);
        userEntity.setCreatedDate(new Date());
        userEntity.setUpdatedDate(new Date());
        userEntity = userRepository.save(userEntity);
        return userEntity;
    }

}
