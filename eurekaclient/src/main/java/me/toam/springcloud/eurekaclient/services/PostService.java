package me.toam.springcloud.eurekaclient.services;

import me.toam.springcloud.eurekaclient.repositories.PostRepository;
import org.springframework.stereotype.Service;
import me.toam.springcloud.eurekaclient.common.CommonService;
import me.toam.springcloud.eurekaclient.entities.Post;

import java.util.List;


@Service
public class PostService extends CommonService<Post,Long, PostRepository> {

    public PostService(PostRepository repo) {
        super(repo);
    }

    public List<Post> getPostByContent(String content){
        return repo.getPostByContent(content);
    }

    public List<Post> getAllPost() {
        return repo.getAllPost();
    }
}
