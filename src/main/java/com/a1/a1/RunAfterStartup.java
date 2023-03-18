package com.a1.a1;

import com.a1.a1.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileNotFoundException;

@Component
public class RunAfterStartup {

    private final PostService postService;

    @Autowired
    public RunAfterStartup(PostService postService) {
        this.postService = postService;
    }

    @EventListener(ApplicationReadyEvent.class)
    public void runAfterStartup() {
        File posts = new File("src/main/resources/static/postings.csv");
        File logins = new File("src/main/resources/static/logins.csv");
        postService.ParseFiles(posts, logins);
    }
}