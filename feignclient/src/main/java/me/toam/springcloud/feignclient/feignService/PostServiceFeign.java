package me.toam.springcloud.feignclient.feignService;

import me.toam.springcloud.feignclient.models.UpdatePostModel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;
import me.toam.springcloud.feignclient.models.PostModel;

import java.util.List;

@FeignClient(name = "eurekaclient")
public interface PostServiceFeign {
    @GetMapping("api/posts/{id}")
    PostModel getPostById(@PathVariable Long id);

    @GetMapping("api/posts/")
    List<PostModel> getPostByContent(@RequestParam String content);

    @GetMapping("api/posts/all")
    List<PostModel> getPosts();

    @PostMapping("api/posts/")
    PostModel createPost(@RequestBody PostModel postModel);

    @PutMapping("api/posts/{id}")
    PostModel updatePost(@PathVariable Long id, @RequestBody UpdatePostModel updatePostModel);

    @DeleteMapping("api/posts/{id}")
    PostModel deletePostById(@PathVariable Long id);
}
