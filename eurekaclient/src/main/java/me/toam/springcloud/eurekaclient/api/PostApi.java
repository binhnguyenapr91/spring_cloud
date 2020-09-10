package me.toam.springcloud.eurekaclient.api;

import lombok.*;
import me.toam.springcloud.eurekaclient.exception.NotFoundEntityException;
import me.toam.springcloud.eurekaclient.models.PostModel;
import me.toam.springcloud.eurekaclient.processors.PostProcessor;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("api/posts")
@RequiredArgsConstructor
public class PostApi {

    private final PostProcessor postProcessor;

    @GetMapping("{id}")
    public PostModel getPostById(@PathVariable Long id) throws NotFoundEntityException {
            return postProcessor.getPost(id);
    }

    @PostMapping("")
    public PostModel createPost(@RequestBody PostModel postModel){
        return postProcessor.createPost(postModel);
    }

    @DeleteMapping("{id}")
    public PostModel deletePostById(@PathVariable Long id) throws NotFoundEntityException {
        return postProcessor.deletePostById(id);
    }

    @GetMapping("")
    public List<PostModel> getPostByContent(@RequestParam String content){
        return postProcessor.getPostByContent(content);
    }

    @PutMapping("{id}")
    public PostModel updatePost(@PathVariable Long id, @RequestBody UpdatePostModel updatePostModel) throws NotFoundEntityException {
        return postProcessor.updatePost(id, updatePostModel);
    }
    @Getter
    @Setter
    @ToString
    @NoArgsConstructor
    public static class UpdatePostModel {
        private String title;
        private String description;
        private String content;
    }
    @Getter
    @Setter
    @NoArgsConstructor
    public static class CreatePostModel {
        private String title;
        private String description;
        private String content;
    }
}
