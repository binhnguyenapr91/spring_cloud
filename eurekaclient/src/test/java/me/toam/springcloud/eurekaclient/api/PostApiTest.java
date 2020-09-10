package me.toam.springcloud.eurekaclient.api;

import me.toam.springcloud.eurekaclient.config.PostApiTestConfiguration;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import me.toam.springcloud.eurekaclient.common.JsonMapper;
import me.toam.springcloud.eurekaclient.entities.Post;
import me.toam.springcloud.eurekaclient.models.PostModel;
import me.toam.springcloud.eurekaclient.repositories.PostRepository;

import java.util.Optional;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(PostApi.class)
@Import(PostApiTestConfiguration.class)
public class PostApiTest {
    @MockBean
    PostRepository postRepository;

    @Autowired
    MockMvc mockMvc;

    private Post post;
    private PostModel postModel;

    @Before
    public void setup(){
        post = new Post();
        post.setId((long) 1);
        post.setTitle("testadmin");
        post.setDescription("1234$");
        post.setContent("admin");

        postModel = new PostModel();
        postModel.setTitle("testadmin");
        postModel.setDescription("1234$");
        postModel.setContent("admin");
    }

    @Test
    public void getAccountById_thenReturnStatus200() throws Exception {
      when(postRepository.findById(ArgumentMatchers.anyLong())).thenReturn(Optional.of(post));
        mockMvc.perform(MockMvcRequestBuilders.get("/api/account/1")
                .contentType(MediaType.APPLICATION_JSON).content(JsonMapper.write(post)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", equalTo(1)))
                .andExpect(jsonPath("$.username", is("testadmin")))
                .andExpect(jsonPath("$.password", is("1234$")))
                .andExpect(jsonPath("$.role", is("admin")));
    }

    @Test
    public void createNewAccount_IfOK_ReturnStatus200() throws Exception {
        doAnswer(invocationOnMock -> {
            Post post = invocationOnMock.getArgument(0);
            post.setId(1L);
            return post;
        }).when(postRepository).save(any(Post.class));

        mockMvc.perform(post("/api/account")
                .contentType(MediaType.APPLICATION_JSON).content(JsonMapper.write(postModel)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.username", is("testadmin")))
                .andExpect(jsonPath("$.password", is("1234$")))
                .andExpect(jsonPath("$.role", is("admin")));
    }
}
