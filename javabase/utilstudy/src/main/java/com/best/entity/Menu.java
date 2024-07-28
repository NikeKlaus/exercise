package com.best.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author cctv14
 * @data 2023/10/29 20:45
 * @description
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Menu {

    private Integer id;

    private String nodeId;

    private String pid;

    private String name;

    private List<Menu> childMenus;
}
