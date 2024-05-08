package org.example.pard.member.controller;

import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.example.pard.member.dto.MemberCreateDTO;
import org.example.pard.member.dto.MemberReadDTO;
import org.example.pard.member.service.MemberService;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/pard")
// 직접적인 로직을 수행함.
public class MemberController {
    private final MemberService memberService;

    @PostMapping("")
    @Operation(summary = "맴버 가입", description = "name, age, part를 적어내면 가입이 완료 됩니다.")
    // 맴버 가입 method
    public String createMember(@RequestBody MemberCreateDTO dto) {
        memberService.createMember(dto);
        return "파드에 가입을 축하드립니다.";
    }

    @GetMapping("")
    @Operation(summary = "맴버 찾기", description = "part로 찾으면 해당 파트의 인원의 정보를 찾고 아닐시, 모든 맴버의 정보를 찾아냄.")
    // 맴버 찾기 method / Param은 읽어내며 쓰는 중 if 파트 이름이 있을시 findbypard else hasText없는 걸로 취급 findAll
    public List<MemberReadDTO> findMember(@RequestParam(required = false) String part) {
        if (StringUtils.hasText(part)) {
            return memberService.findByPart(part);
        }

        return memberService.findAll();
    }

    @GetMapping("/{id}")
    @Operation(summary = "맴버 아이디로 찾기", description = "id를 적어 내면 해당 id를 갖은 member을 찾고 호출한다.")
    public MemberReadDTO findById(@PathVariable Long id) {
        return memberService.findById(id);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "맴버 아이디로 해당 맴버 삭제", description = "id를 적어내면 해당 id를 갖은 member을 database에서 삭제한다.")
    public String deleteById(@PathVariable Long id) {
        memberService.deleteById(id);
        return "삭제됨";
    }
}
