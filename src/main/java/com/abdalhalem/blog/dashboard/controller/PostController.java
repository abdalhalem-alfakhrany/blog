package com.abdalhalem.blog.dashboard.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.abdalhalem.blog.model.Post;
import com.abdalhalem.blog.repository.PostRepository;

@RestController
@RequestMapping("posts")
public class PostController {

    private final PostRepository repository;

    public PostController(PostRepository repository) {
        this.repository = repository;
    }

    @GetMapping("")
    public List<Post> index() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public Post show(@PathVariable long id) {
        return repository.findById(id).orElse(null);
    }

    @PostMapping("")
    public void store(@RequestBody Post post) {
        repository.save(post);
    }

    @PutMapping("/{id}")
    public Post update(@RequestBody Post newPost, @PathVariable long id) {
        return repository.findById(id)
                .map(post -> {
                    post.setTitle(newPost.getTitle());
                    post.setContent(newPost.getContent());
                    post.setImageFileName(newPost.getImageFileName());
                    return repository.save(post);
                })
                .orElseGet(() -> {
                    return repository.save(newPost);
                });
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable long id) {
        repository.deleteById(id);
    }
}
