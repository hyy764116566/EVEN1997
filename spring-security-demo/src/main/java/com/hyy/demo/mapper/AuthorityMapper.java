package com.hyy.demo.mapper;

import com.hyy.demo.common.dtos.AuthorityDto;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AuthorityMapper {
    public List<AuthorityDto> findAuthority(Integer  id);
    List<AuthorityDto> findAuthorityChildren (Integer id);
}
