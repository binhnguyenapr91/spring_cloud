package me.toam.springcloud.eurekaclient.transformers;

import org.springframework.stereotype.Component;
import me.toam.springcloud.eurekaclient.entities.Post;
import me.toam.springcloud.eurekaclient.models.PostModel;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

@Component
public class PostTransformer {
    public Post toEntity(PostModel postModel){
        Post post = new Post();
        post.setId(postModel.getId());
        post.setTitle(postModel.getTitle());
        post.setDescription(postModel.getDescription());
        post.setContent(postModel.getContent());
        return post;
    }

    public PostModel toModel(Post post){
        PostModel postModel = convertEntityToModel.apply(post);
        return postModel;
    }

    public List<PostModel> toModels (List<Post> posts){
        return posts.stream()
                .map(this::toModel)
                .collect(Collectors.toList());
    }

    public Function<Post, PostModel> convertEntityToModel = entity ->{
        PostModel postModel = new PostModel();
        postModel.setId(entity.getId());
        postModel.setTitle(entity.getTitle());
        postModel.setDescription(entity.getDescription());
        postModel.setContent(entity.getContent());
        return postModel;
    };
}
