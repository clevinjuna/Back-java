package fr.mns.java.rest.controller;

import fr.mns.java.rest.dto.CommentDTO;
import fr.mns.java.rest.dto.PostDTO;
import fr.mns.java.rest.service.CommentService;
import fr.mns.java.rest.service.PostService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/forum")
public class ForumController {

	private final PostService postService;
	private final CommentService commentService;

	public ForumController(PostService postService, CommentService commentService) {
		this.postService = postService;
		this.commentService = commentService;
	}

	@GetMapping({"/", ""})
	public ResponseEntity<List<PostDTO>> getAllPosts() {
		List<PostDTO> postDTOs = postService.getAllPosts();
		return ResponseEntity.ok(postDTOs);
	}

	@PostMapping("/addPost")
	public ResponseEntity<String> addPost(@ModelAttribute PostDTO postDTO) {
		postService.addPost(postDTO);
		return new ResponseEntity<>("Post added successfully", HttpStatus.CREATED);
	}

	@PostMapping("/editPost")
	public ResponseEntity<String> editPost(@ModelAttribute PostDTO postDTO) {
		postService.editPost(postDTO);
		return new ResponseEntity<>("Post edited successfully", HttpStatus.OK);
	}

	@PostMapping("/deletePost")
	public ResponseEntity<String> deletePost(@RequestParam Long postId) {
		postService.deletePost(postId);
		return new ResponseEntity<>("Post deleted successfully", HttpStatus.OK);
	}

	@PostMapping("/addComment")
	public ResponseEntity<String> addComment(@RequestParam Long postId, @ModelAttribute CommentDTO commentDTO) {
		commentService.addComment(postId, commentDTO);
		return new ResponseEntity<>("Comment added successfully", HttpStatus.CREATED);
	}

	@PostMapping("/editComment")
	public ResponseEntity<String> editComment(@ModelAttribute CommentDTO commentDTO) {
		commentService.editComment(commentDTO);
		return new ResponseEntity<>("Comment edited successfully", HttpStatus.OK);
	}

	@PostMapping("/deleteComment")
	public ResponseEntity<String> deleteComment(@RequestParam Long commentId) {
		commentService.deleteComment(commentId);
		return new ResponseEntity<>("Comment deleted successfully", HttpStatus.OK);
	}
}
