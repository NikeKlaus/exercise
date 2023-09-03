package com.best.controller;

import com.best.common.R;
import io.github.asleepyfish.util.OpenAiUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author: maowenxing
 * @date: 2023/6/7
 */
@RestController
@RequestMapping("/")
@CrossOrigin
public class ChatGPTController {
    @GetMapping("/chatgpt")
    public R list(@RequestParam("question") String question){
        List<String> answer = OpenAiUtils.createChatCompletion(question, "mwx");
        return R.success("ok",answer);
    }
}
