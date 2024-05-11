package org.example.pard.member.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.example.pard.member.entity.Member;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
//member을 읽도혹 하는 DTO
public class MemberReadDTO {
    private Long id;
    private String name;
    private String part;
    private int age;


    //해당 맴버의 id, 나이, 이름, 파트 읽어드림.
    public MemberReadDTO toDTO(Member member) {
        return MemberReadDTO.builder()
                .id(member.getId())
                .age(member.getAge())
                .name(member.getName())
                .part(member.getPart())
                .build();
    }
}


