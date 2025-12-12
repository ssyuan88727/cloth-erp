package com.misstilo.cloth_erp_api.controller.member;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.misstilo.cloth_erp_api.model.member.member.MemberCreate;
import com.misstilo.cloth_erp_api.model.member.member.MemberQuery;
import com.misstilo.cloth_erp_api.model.member.member.MemberResponse;
import com.misstilo.cloth_erp_api.model.member.member.MemberUpdate;
import com.misstilo.cloth_erp_api.service.member.MemberService;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;

@RestController
@RequestMapping("/member")
@Builder
public class MemberController {
    @Autowired
    private final MemberService service;

    @PostMapping("/insert")
    public Integer insert(@RequestBody @Valid MemberCreate model) {
        return service.insert(model);
    }

    @DeleteMapping("/delete/{id}")
    public Integer delete(@PathVariable @NotNull(message = "Delete: Id is required.") Integer id) {
        return service.delete(id);
    }

    @PutMapping("/update")
    public Integer update(@RequestBody @Valid MemberUpdate model) {
        return service.update(model);
    }

    @GetMapping("/select")
    public List<MemberResponse> select(@Valid MemberQuery model) {
        return service.select(model);
    }
}
