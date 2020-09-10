package me.toam.springcloud.eurekaclient.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import me.toam.springcloud.eurekaclient.common.CommonRepository;
import me.toam.springcloud.eurekaclient.entities.Post;

import java.util.List;

public interface PostRepository extends CommonRepository<Post, Long> {
    @Query("SELECT a FROM Post a WHERE a.content = :content")
    public List<Post> getPostByContent(@Param("content") String content);
}
