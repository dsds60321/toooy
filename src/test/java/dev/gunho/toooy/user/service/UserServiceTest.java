package dev.gunho.toooy.user.service;

import dev.gunho.toooy.user.dto.ResultStatus;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Sql(scripts = {"/data.sql"})
class UserServiceTest {

    @Autowired
    private UserService userService;

    @Test
    public void testCalculateResultStatus() {
        // 테스트 로직 작성
        Long userId = 1L; // test-data.sql에서 INSERT한 데이터 사용
        ResultStatus resultStatus = userService.calculateResultStatus(userId);

        assertEquals(1, resultStatus.getWins());
        assertEquals(0, resultStatus.getLosses());
    }

}