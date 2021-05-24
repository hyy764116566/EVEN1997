package com.hyy.demo.controller;

import com.hyy.demo.common.dtos.AuthorityDto;
import com.hyy.demo.mapper.AuthorityMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/authority")
public class AuthorityController {
    @Autowired
    AuthorityMapper authorityMapper;
    @GetMapping("/test")
    public List<AuthorityDto> authorityTest(@RequestParam("id") Integer id){
        List<AuthorityDto> authority = authorityMapper.findAuthority(id);
        for (int i = 0; i < authority.size() ; i++) {

            if (authority.get(i).getParentMenuId() == null) {
                List<AuthorityDto> authorityChildren = authorityMapper.findAuthorityChildren(authority.get(i).getId());
                if (!authorityChildren.isEmpty()){
                    authority.get(i).setChildren(authorityChildren);
                }
            }
        }
        return authority;
    }
}
