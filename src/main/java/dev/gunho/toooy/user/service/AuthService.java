package dev.gunho.toooy.user.service;

import dev.gunho.toooy.global.dto.ApiResponse;
import dev.gunho.toooy.user.dto.UserDto;
import dev.gunho.toooy.user.entity.UserEntity;
import dev.gunho.toooy.user.entity.UserRole;
import dev.gunho.toooy.user.mapper.UserMapper;
import dev.gunho.toooy.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@RequiredArgsConstructor
@Service
public class AuthService {

    private final UserRepository userRepository;

    @Transactional
    public ResponseEntity<?> signUp(UserDto userDto) {
        String userId = userDto.userId();
        boolean isUser = userRepository.existsByUserId(userId);

        if (isUser) {
            return ApiResponse.BAD_REQUEST("이미 존재하는 계정입니다.");
        }

        UserEntity userEntity = UserMapper.INSTANCE.toEntity(userDto.setRole(UserRole.DEFAULT));
        UserEntity resEntity = userRepository.save(userEntity);

        return resEntity != null ? ApiResponse.SUCCESS("계정 등록에 성공했습니다.") : ApiResponse.SERVER_ERROR();
    }
}
