package me.toam.springcloud.feignclient.controllers;

import me.toam.springcloud.feignclient.feignService.PostServiceFeign;
import me.toam.springcloud.feignclient.models.UpdatePostModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import me.toam.springcloud.feignclient.models.PostModel;

import java.util.List;

@RestController
@RequestMapping ("api/posts")
public class PostController {
    @Autowired
    private PostServiceFeign postServiceFeign;

    @GetMapping("/{id}")
    public PostModel getPostById(@PathVariable Long id){
        return postServiceFeign.getPostById(id);
    }

    @GetMapping("")
    public List<PostModel> getPostByContent(@RequestParam String content){
        return postServiceFeign.getPostByContent(content);
    }

    @GetMapping("/all")
    public List<PostModel> getAllPost(){
        return postServiceFeign.getPosts();
    }

    @DeleteMapping("/{id}")
    public PostModel deletePostById(@PathVariable Long id){
        return postServiceFeign.deletePostById(id);
    }

    @PostMapping("")
    public PostModel createPost(@RequestBody PostModel postModel){
        return postServiceFeign.createPost(postModel);
    }

    @PutMapping("/{id}")
    public PostModel updatePost(@PathVariable Long id, @RequestBody UpdatePostModel updatePostModel){
        return  postServiceFeign.updatePost(id, updatePostModel);
    }
}
