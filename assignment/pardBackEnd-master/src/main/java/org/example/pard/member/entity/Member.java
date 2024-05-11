package org.example.pard.member.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;
import org.example.pard.member.dto.MemberCreateDTO;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
// database table mapping
public class Member {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    private String name;

    private String part;

    private int age;


    // 아이디, 나이, 이름, 파트
    public Member toEntity(MemberCreateDTO dto) {
        return Member.builder()
                .age(dto.getAge())
                .part(dto.getPart())
                .name(dto.getName())
                .build();
    }
}
