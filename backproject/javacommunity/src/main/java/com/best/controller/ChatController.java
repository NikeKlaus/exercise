package com.best.controller;

import com.best.common.ResponseData;
import com.best.utils.ChatUtil;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author cctv14
 * @data 2023/9/4 22:54
 * @description chat的控制器
 */
@RestController
@RequestMapping("/chat")
@CrossOrigin
public class ChatController {
    @GetMapping("/talk")
    public ResponseData<List<String>> getAnswer(@RequestParam("question") String question) {
        return ResponseData.success("ok", ChatUtil.getAnswer(question));
    }
}
