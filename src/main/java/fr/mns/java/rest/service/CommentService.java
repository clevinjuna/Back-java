package fr.mns.java.rest.service;

import fr.mns.java.rest.dto.CommentDTO;
import fr.mns.java.rest.dto.PostDTO;
import fr.mns.java.rest.model.Comment;
import fr.mns.java.rest.model.Post;
import fr.mns.java.rest.repository.CommentRepository;
import fr.mns.java.rest.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CommentService {

    private final CommentRepository commentRepository;
    private final PostRepository postRepository;

    @Autowired
    public CommentService(CommentRepository commentRepository, PostRepository postRepository) {
        this.commentRepository = commentRepository;
        this.postRepository = postRepository;
    }

    public List<CommentDTO> getAllComment() {
        List<Comment> posts = commentRepository.findAll();
        return posts.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public void addComment(Long postId, CommentDTO commentDTO) {
        Post post = postRepository.findById(postId).orElse(null);
        if (post != null) {
            Comment comment = convertToEntity(commentDTO);
            commentRepository.save(comment);
        } else {

        }
    }

    public void editComment(CommentDTO commentDTO) {
        Comment comment = convertToEntity(commentDTO);
        commentRepository.save(comment);
    }

    public void deleteComment(Long commentId) {
        commentRepository.deleteById(commentId);
    }

    private CommentDTO convertToDTO(Comment comment) {
        CommentDTO commentDTO = new CommentDTO();
        commentDTO.setId(comment.getId());
        commentDTO.setContent(comment.getContent());
        commentDTO.setAuthor(comment.getAuthor());
        commentDTO.setDate(comment.getDate());
        commentDTO.setPost(comment.getPost());
        return commentDTO;
    }

    private Comment convertToEntity(CommentDTO commentDTO) {
        if(commentDTO!= null){
            Comment comment = new Comment();
            comment.setId(commentDTO.getId());
            comment.setContent(commentDTO.getContent());
            comment.setAuthor(commentDTO.getAuthor());
            comment.setDate(commentDTO.getDate());
            comment.setPost(commentDTO.getPost());
            return comment;
        }
      return null;
    }
}