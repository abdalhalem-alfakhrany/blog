package com.abdalhalem.blog.dashboard.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


// @RestController("DashboardPostsController")
@RestController
@RequestMapping("posts")
public class PostController {
    @GetMapping("")
    public String index() {
        return "this is dashboard posts index";
    }
}
