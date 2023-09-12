package com.best.controller;

import com.best.common.ResponseData;
import io.github.asleepyfish.util.OpenAiUtils;
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
    public ResponseData<List<String>> list(@RequestParam("question") String question) {
        List<String> answer = OpenAiUtils.createChatCompletion(question, "admin");
        return ResponseData.success("ok", answer);
    }
}
