package com.hyy.demo.common.utils;

import lombok.Data;

@Data
public class Menu {
    private Integer id;
    private String name;
    private String linkUrl;
    private String path;
    private String description;
    private Integer parentMenuId;
    private String icon;
    private Integer level;
}
