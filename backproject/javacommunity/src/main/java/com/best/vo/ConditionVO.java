package com.best.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author cctv14
 * @data 2023/10/5 17:25
 * @description
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ConditionVO {

    private String id;

    private String name;

    private String startTime;

    private String endTime;
}
