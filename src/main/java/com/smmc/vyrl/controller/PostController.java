package com.smmc.vyrl.controller;

import com.smmc.vyrl.domain.Post;
import com.smmc.vyrl.service.PostService;
import org.apache.thrift.TException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/posts")
public class PostController {

    @Autowired
    private PostService postService;

    @GetMapping("/creates")
    public void createPostTable() throws Exception {
        postService.createPostTable();
    }

    @GetMapping("/save")
    public void putPostData() throws TException {
        postService.putData();
    }

    @GetMapping("/data/{id}")
    public Post getPostData(@PathVariable final String id) {
        return postService.getPostData(id);
    }


}
