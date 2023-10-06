package com.best.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author cctv14
 * @data 2023/9/29 14:38
 * @description 条件查询 DTO
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ConditionDTO {

    private String id;

    private String name;

    private String startTime;

    private String endTime;
}
