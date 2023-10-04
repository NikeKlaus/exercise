package com.best.service;

import com.best.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author cctv14
 * @data 2023/9/15 22:15
 * @description
 */
public interface UserService {
    List<User> list();
}
