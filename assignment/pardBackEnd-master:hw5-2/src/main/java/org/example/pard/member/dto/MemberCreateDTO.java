package org.example.pard.member.dto;

import lombok.Getter;

@Getter
//member을 만들어 내는 DTO
public class MemberCreateDTO {

    private String name;
    private String part;
    private int age;

}
