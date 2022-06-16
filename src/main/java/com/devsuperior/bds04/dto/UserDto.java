package com.devsuperior.bds04.dto;

import com.devsuperior.bds04.entities.Role;
import com.devsuperior.bds04.entities.User;

import javax.validation.constraints.Email;
import java.util.Set;

public class UserDto {

    private Long id;
    @Email
    private String email;
    private String password;
    Set<RoleDto> roles;

    public UserDto() {
    }

    public UserDto(Long id, String email, String password, Set<Role> roles){
        this.id = id;
        this.email = email;
        this.password = password;
        if (roles != null && roles.size() > 0){
            roles.stream()
                    .map(RoleDto::new)
                    .forEach(role -> this.roles.add(role));
        }
    }

    public UserDto(User user){
        this.id = user.getId();
        this.email = user.getEmail();
        this.password = user.getPassword();
        if (user.getRoles() != null){
            user.getRoles().stream()
                    .map(RoleDto::new)
                    .forEach(role -> roles.add(role));
        }

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<RoleDto> getRoles() {
        return roles;
    }

}
