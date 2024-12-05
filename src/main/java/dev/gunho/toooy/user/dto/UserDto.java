package dev.gunho.toooy.user.dto;

import dev.gunho.toooy.user.entity.UserRole;

public record UserDto(
        String userId,
        String password,
        String email,
        String nick,
        UserRole role
) {
    // 유효성 검증 메소드 추가 가능
    public UserDto {
        if (userId == null || userId.isBlank()) {
            throw new IllegalArgumentException("아이디는 필수 입력 값입니다.");
        }
        if (password == null || password.isBlank()) {
            throw new IllegalArgumentException("패스워드는 필수 입력 값입니다.");
        }
//        if (email == null || email.isBlank() || email.matches("^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+.[A-Za-z]{2,6}$")) {
        if (email == null || email.isBlank()) {
            throw new IllegalArgumentException("이메일이 비어있거나 형식에 맞지 않습니다.");
        }
    }

    public UserDto setRole(UserRole role) {
        return new UserDto(userId, password, email, nick, role);
    }
}