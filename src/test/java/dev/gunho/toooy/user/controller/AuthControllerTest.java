package dev.gunho.toooy.user.controller;

import dev.gunho.toooy.user.service.AuthService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.restdocs.RestDocumentationContextProvider;
import org.springframework.restdocs.RestDocumentationExtension;
import org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;

import java.time.LocalDate;
import java.util.UUID;

import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.documentationConfiguration;
import static org.springframework.restdocs.operation.preprocess.Preprocessors.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@ExtendWith(RestDocumentationExtension.class)
class AuthControllerTest {

    private MockMvc mockMvc;

    @InjectMocks
    private AuthService authService;

    @BeforeEach
    void setUp(WebApplicationContext webApplicationContext, RestDocumentationContextProvider restDocumentation) {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext)
                .apply(documentationConfiguration(restDocumentation))
                .build();
    }

    @Test
    @Transactional
    @DisplayName("회원가입 성공 테스트")
    void 회원가입성공() throws Exception {

        String random = UUID.randomUUID().toString().substring(0, 5);
        // given
        String userJson = """
        {
          "userId": "%s",
          "password": "12345",
          "email": "%s@naver.com",
          "nick": "게스트"
        }
        """;

        userJson = String.format(userJson, random, random);

        // when - then
        mockMvc.perform(RestDocumentationRequestBuilders.post("/auth/sign-up")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(userJson))
                .andExpect(status().isOk())  // 가입 성공 시 HTTP 200을 기대
                .andExpect(content().contentType(MediaType.APPLICATION_JSON)) // JSON 응답 타입 확인
                .andDo(MockMvcResultHandlers.log())  // 요청 및 응답을 더 자세히 콘솔에 로그로 출력
                .andDo(MockMvcResultHandlers.print())  // 요청 및 응답을 콘솔에 출력
                .andDo(document("sign-up-success",
                        preprocessRequest(prettyPrint()),
                        preprocessResponse(prettyPrint())));
    }

}