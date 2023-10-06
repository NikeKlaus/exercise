package com.best.utils;

import io.github.asleepyfish.util.OpenAiUtils;
import org.apache.commons.collections4.CollectionUtils;

import java.util.Collections;
import java.util.List;

/**
 * @author cctv14
 * @data 2023/10/5 23:08
 * @description
 */
public class ChatUtil {

    public static List<String> getAnswer(String question) {
        List<String> answer = OpenAiUtils.createChatCompletion(question, "admin");
        if (CollectionUtils.isEmpty(answer)) {
            answer = Collections.singletonList("暂无答案 ......");
        }
        return answer;
    }
}
