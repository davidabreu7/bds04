package com.devsuperior.bds04.dto;

import com.devsuperior.bds04.entities.Role;
import com.devsuperior.bds04.entities.User;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

public class UserDto {

    private Long id;
    @Email
    @NotBlank
    private String email;
    private String password;
    private RoleDto authority;

    public UserDto() {
    }

    public UserDto(Long id, String email, String password, Role authority){
        this.id = id;
        this.email = email;
        this.password = password;
        this.authority = new RoleDto(authority);
    }

    public UserDto(User user){
        this.id = user.getId();
        this.email = user.getEmail();
        this.password = user.getPassword();
        this.authority = new RoleDto(user.getAuthority());
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

    public RoleDto getAuthority() {
        return authority;
    }

}
