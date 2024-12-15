package com.example.taskmanager.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/strings")
public class StringController {

    @GetMapping("/reverse")
    public ResponseEntity<String> reverse(@RequestParam String input) {
        String reversed = new StringBuilder(input).reverse().toString();
        return ResponseEntity.ok(reversed);
    }

    @GetMapping("/count-vowels")
    public ResponseEntity<Map<String, Integer>> countVowels(@RequestParam String input) {
        int vowels = 0;
        for (char c : input.toLowerCase().toCharArray()) {
            if ("aeiou".indexOf(c) != -1) vowels++;
        }
        Map<String, Integer> result = new HashMap<>();
        result.put("Vowels", vowels);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/to-upper")
    public ResponseEntity<String> toUpper(@RequestParam String input) {
        return ResponseEntity.ok(input.toUpperCase());
    }
}
