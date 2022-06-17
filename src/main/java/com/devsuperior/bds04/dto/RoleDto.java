package com.devsuperior.bds04.dto;

import com.devsuperior.bds04.entities.Role;
import com.devsuperior.bds04.service.validation.EventInsertValid;


public class RoleDto {

    private String authority;

    public RoleDto() {
    }

    public RoleDto(String authority) {
        this.authority = authority;
    }

    public RoleDto(Role role){
        this.authority = role.getAuthority();
    }

    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }
}
