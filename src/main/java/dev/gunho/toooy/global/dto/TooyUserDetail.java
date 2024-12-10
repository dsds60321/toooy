package dev.gunho.toooy.global.dto;

import dev.gunho.toooy.user.domain.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;

public class TooyUserDetail implements UserDetails {

    private final User user;
    public TooyUserDetail(User user) {
        this.user = user;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.singleton(new SimpleGrantedAuthority(user.getRole().name()));
    }

    public Long getId() {
        return user.getIdx();
    }

    @Override
    public String getUsername() {
        return user.getUserId();
    }

    public String getUserId() {return user.getUserId();}

    public String getEmail(){
        return user.getEmail();
    }

    public String getNick() {
        return user.getNick();
    }

    public String getUuid() {
        return user.getUuid();
    }

    public String getOs() {return user.getOs();}

    @Override
    public String getPassword() {
        return user.getPassword();
    }



    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
