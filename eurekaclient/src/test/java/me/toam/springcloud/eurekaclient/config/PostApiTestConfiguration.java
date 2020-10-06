package me.toam.springcloud.eurekaclient.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import me.toam.springcloud.eurekaclient.processors.PostProcessor;
import me.toam.springcloud.eurekaclient.repositories.PostRepository;
import me.toam.springcloud.eurekaclient.services.PostService;
import me.toam.springcloud.eurekaclient.transformers.PostTransformer;

@TestConfiguration
public class PostApiTestConfiguration {
    @Bean
    @Autowired
    public PostService postService(PostRepository postRepository){
        return new PostService(postRepository);
    }

    @Bean
    public PostTransformer postTransformer(){
        return new PostTransformer();
    }

    @Bean
    public PostProcessor postProcessor(PostService postService, PostTransformer postTransformer){
        return new PostProcessor(postService, postTransformer);
    }
}
