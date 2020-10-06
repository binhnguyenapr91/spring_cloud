package me.toam.springcloud.eurekaclient.processors;

import me.toam.springcloud.eurekaclient.api.PostApi.UpdatePostModel;
import me.toam.springcloud.eurekaclient.transformers.PostTransformer;
import org.springframework.stereotype.Component;
import me.toam.springcloud.eurekaclient.common.CommonProcessor;
import me.toam.springcloud.eurekaclient.entities.Post;
import me.toam.springcloud.eurekaclient.exception.NotFoundEntityException;
import me.toam.springcloud.eurekaclient.models.PostModel;
import me.toam.springcloud.eurekaclient.services.PostService;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class PostProcessor extends CommonProcessor<PostService, PostTransformer> {
    public PostProcessor(PostService service, PostTransformer transformer) {
        super(service, transformer);
    }

    public PostModel getPost(Long id) throws NotFoundEntityException   {
        Post post = service.getOrElseThrow(id,"NOT FOUND");
        return transformer.toModel(post);
    }

    public PostModel createPost(PostModel postModel){
        Post post = service.save(transformer.toEntity(postModel));
        return transformer.toModel(post);
    }

    public PostModel updatePost(Long id, UpdatePostModel updatePostModel) throws NotFoundEntityException {
        Post post = service.getOrElseThrow(id,"NOT FOUND");
        service.update(post, $ ->{
           if(updatePostModel.getTitle()!=null){
               $.setTitle(updatePostModel.getTitle());
           }
           if(updatePostModel.getDescription()!=null){
               $.setDescription(updatePostModel.getDescription());
           }
            if(updatePostModel.getContent()!=null){
                $.setDescription(updatePostModel.getContent());
            }
        });

        return transformer.toModel(post);
    }

    public PostModel deletePostById(Long id) throws NotFoundEntityException {
        Post post = service.getOrElseThrow(id,"NOT FOUND");
        service.delete(post);
        PostModel postModel = transformer.toModel(post);
        return postModel;
    }

    public List<PostModel> getPostByContent(String content){
        List<Post> posts = service.getPostByContent(content);
        List<PostModel> postModels = null;
        postModels = transformer.toModels(posts);
        return postModels;
    }

    public List<PostModel> getPosts() {
        List<PostModel> results = service.getAllPost()
                .stream().map(transformer::toModel)
                .collect(Collectors.toList());
        return results;
    }
}
