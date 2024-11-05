package com.abdalhalem.blog;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.abdalhalem.blog.model.Post;
import com.abdalhalem.blog.repository.PostRepository;

@SpringBootApplication
public class BlogApplication {

	private static final Logger log = LoggerFactory.getLogger(BlogApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(BlogApplication.class, args);
	}
 @Bean
  public CommandLineRunner demo(PostRepository repository) {
    return (args) -> {
      // save a few customers
      repository.save(new Post("blog 1 title", "blog 1 content", "blog 1 image"));
      repository.save(new Post("blog 2 title", "blog 2 content", "blog 2 image"));
      repository.save(new Post("blog 3 title", "blog 3 content", "blog 3 image") );
      repository.save(new Post("blog 4 title", "blog 4 content", "blog 4 image") );
      repository.save(new Post("blog 5 title", "blog 5 content", "blog 5 image") );

      // fetch all customers
      log.info("blogs found with findAll():");
      log.info("-------------------------------");
      repository.findAll().forEach(customer -> {
        log.info(customer.toString());
      });
      log.info("");
    };
  }
}
