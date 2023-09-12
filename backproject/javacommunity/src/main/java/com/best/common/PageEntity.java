package com.best.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author cctv14
 * @data 2023/9/4 22:54
 * @description 分页实体类
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PageEntity<E> {

    private Integer pageNo;

    private Integer pageSize;

    private List<E> records;

    private Long total;
}

