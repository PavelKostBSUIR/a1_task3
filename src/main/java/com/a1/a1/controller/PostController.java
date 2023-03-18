package com.a1.a1.controller;

import com.a1.a1.entity.dto.GetPostDto;
import com.a1.a1.service.PostService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.List;

@RestController
@RequestMapping("/posts")
public class PostController {

    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    public List<GetPostDto> getInPeriod(@RequestParam(required = false) Date postDateStart, @RequestParam(required = false) Date postDateEnd) {
        return postService.getInPeriod(postDateStart, postDateEnd);
    }
}
