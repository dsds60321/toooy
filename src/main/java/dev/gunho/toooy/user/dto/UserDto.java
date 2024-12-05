package dev.gunho.toooy.user.dto;

import dev.gunho.toooy.user.entity.UserRole;
import lombok.*;

@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {

    private String userId;
    private String email;
    private String password;
    private String nick;
    private UserRole role;

}

