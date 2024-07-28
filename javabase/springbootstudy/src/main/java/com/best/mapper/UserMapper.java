package com.best.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.best.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author cctv14
 * @data 2023/9/15 21:05
 * @description
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {
    List<User> list();
}
