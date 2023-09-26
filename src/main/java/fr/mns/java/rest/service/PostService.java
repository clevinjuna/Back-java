package fr.mns.java.rest.service;

import fr.mns.java.rest.dto.CommentDTO;
import fr.mns.java.rest.dto.PostDTO;
import fr.mns.java.rest.model.Post;
import fr.mns.java.rest.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostService {

    private final PostRepository postRepository;

    @Autowired
    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public List<PostDTO> getAllPosts() {
        List<Post> posts = postRepository.findAll();
        return posts.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }
    public void addPost(PostDTO postCreateDTO) {
        Post post = convertToEntity(postCreateDTO);
        postRepository.save(post);
    }


    public void editPost(PostDTO postDTO) {
        Post post = convertToEntity(postDTO);
        postRepository.save(post);
    }

    public void deletePost(Long postId) {
        postRepository.deleteById(postId);
    }

    private PostDTO convertToDTO(Post post) {
        PostDTO postDTO = new PostDTO();
        postDTO.setId(post.getId());
        postDTO.setContent(post.getContent());
        postDTO.setAuthor(post.getAuthor());
        postDTO.setDate(post.getDate());
        return postDTO;
    }

    private Post convertToEntity(PostDTO postDTO) {
        Post post = new Post();
        post.setId(postDTO.getId());
        post.setContent(postDTO.getContent());
        post.setAuthor(postDTO.getAuthor());
        post.setDate(postDTO.getDate());
        return post;
    }
}