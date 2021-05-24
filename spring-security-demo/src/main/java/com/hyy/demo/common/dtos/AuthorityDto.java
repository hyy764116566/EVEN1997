package com.hyy.demo.common.dtos;

import com.hyy.demo.common.utils.Menu;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class AuthorityDto extends Menu {
    private List<AuthorityDto> children;
}
