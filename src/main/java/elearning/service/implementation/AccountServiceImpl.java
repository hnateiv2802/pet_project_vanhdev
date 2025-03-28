package elearning.service.implementation;

import elearning.dto.request.AccountCreateReq;
import elearning.dto.request.AccountLoginReq;
import elearning.dto.request.AccountReadReq;
import elearning.dto.request.AccountUpdateReq;
import elearning.dto.response.AccountRes;
import elearning.service.AccountService;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;

@Service("AccountService")
public class AccountServiceImpl implements AccountService {

    @Override
    public Object login(AccountLoginReq request) {
        return request;
    }

    @Override
    public Object logout(String accountID) {
        return accountID;
    }

    @Override
    public Object create(AccountCreateReq request) {
        request.setStatus("active");
        Instant currentTimestamp = Instant.now();
        String createdDate = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").withZone(ZoneOffset.UTC).format(currentTimestamp);
        request.setCreatedDate(createdDate);

        return request;
    }

    @Override
    public Object read(String sort, int page, int size, AccountReadReq request) {
        AccountRes response = new AccountRes();
        response.setUsername(request.getUsername());
        response.setName(request.getName());
        response.setStatus(request.getStatus());
        response.setCreatedDate(request.getCreatedDate());
        response.setSort(sort);
        response.setPage(page);
        response.setSize(size);

        return response;
    }

    @Override
    public Object update(String accountID, AccountUpdateReq request) {
        Instant currentTimestamp = Instant.now();
        String updatedDate = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").withZone(ZoneOffset.UTC).format(currentTimestamp);
        request.setUpdatedDate(updatedDate);

        return request;
    }

    @Override
    public Object delete(String accountID) {
        return accountID;
    }
}
