package com.abdalhalem.blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.abdalhalem.blog.model.Post;

public interface PostRepository extends JpaRepository<Post, Long> {
}