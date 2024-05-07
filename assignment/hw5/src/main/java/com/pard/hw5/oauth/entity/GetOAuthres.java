package com.pard.hw5.oauth.entity;

import com.pard.hw5.user.entity.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
public class GetOAuthres implements Serializable {
    private String userName;
    private String email;

    public GetOAuthres(User user){
        this.userName = user.getName();
        this.email = user.getEmail();
    }
}
