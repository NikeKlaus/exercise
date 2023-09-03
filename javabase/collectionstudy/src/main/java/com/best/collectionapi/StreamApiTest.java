package com.best.collectionapi;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author: cctv14
 * @date: 2023/9/2
 */
public class StreamApiTest {

    @Test
    public void filterStreamTest() {
        List<String> words = Arrays.stream("asasas".split(" ")).collect(Collectors.toList());
        long filterCount = words.parallelStream().filter(word -> word.length() > 3).count();
        long distinctCount = words.parallelStream().distinct().count();
        List<Integer> map = words.parallelStream().map(String::toUpperCase).map(String::length).collect(Collectors.toList());
        boolean allMatch = words.stream().allMatch(word -> word.length() > 1);
        Optional<String> optional = Optional.empty();
        words = Arrays.asList("aa","aa","aaa","aaaa");
        Optional<String> any = words.stream().parallel().filter(word -> word.length() < 2).findAny();
        System.out.println(any.orElse("no"));
    }
}
