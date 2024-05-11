package org.example.pard.member.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.example.pard.member.dto.MemberCreateDTO;
import org.example.pard.member.dto.MemberReadDTO;
import org.example.pard.member.entity.Member;
import org.example.pard.member.repo.MemberRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
//Repository를 통해 database에 접근할 수 있도록 한다. 직접적인 로직을 구현.
public class MemberService {
    private final MemberRepo memberRepo;

    // 맴버 만들기 -> 이름, 파트, 나이를 받아서 만들어 냄.
    public void createMember(MemberCreateDTO dto) {
        memberRepo.save(new Member().toEntity(dto));
    }

    // 아이디를통해 해당 맴버의 정보를 알아냄.
    public MemberReadDTO findById(Long id) {
        return new MemberReadDTO().toDTO(memberRepo.findById(id).orElseThrow());
    }

    //모든 맴버의 정보를 List로 뽑아냅.
    public List<MemberReadDTO> findAll() {
        return memberRepo.findAll()
                .stream()
                .map(member -> new MemberReadDTO().toDTO(member))
                .collect(Collectors.toList());
    }

    // 파트를 통해 맴버의 정보를 알아냄.
    public List<MemberReadDTO> findByPart(String part) {
        return memberRepo.findByPart(part)
                .stream()
                .map(member -> new MemberReadDTO().toDTO(member))
                .collect(Collectors.toList());
    }

    //아이디로 해당 아이디 갖은 맴버 삭제
    public void deleteById(Long id) {
        memberRepo.deleteById(id);
    }

    // 아이드로 해당 아이디 갖는 맴버 이름 나이 part 고치기.
    @Transactional
    public void patchById(Long id, MemberCreateDTO memberCreateDTO){
        Member member = memberRepo.findById(id).get();
        member.setAge(memberCreateDTO.getAge());
        member.setName(memberCreateDTO.getName());
        member.setPart(memberCreateDTO.getPart());
    }
}
