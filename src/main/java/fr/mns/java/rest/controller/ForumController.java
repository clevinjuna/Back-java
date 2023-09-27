package fr.mns.java.rest.controller;

import fr.mns.java.rest.dto.CommentDTO;
import fr.mns.java.rest.dto.PostDTO;
import fr.mns.java.rest.dto.PersonDTO;
import fr.mns.java.rest.service.CommentService;
import fr.mns.java.rest.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequestMapping("/forum")
public class ForumController {
	@Autowired
	private final PostService postService;
	@Autowired
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
	public ResponseEntity<PostDTO> addPost(@RequestBody PostDTO postDTO, @RequestBody String jsonRequest) {
		postDTO = PostDTO.fromJsonString(jsonRequest);
		postService.addPost(postDTO);
		return ResponseEntity.ok(postDTO);
	}

	@PostMapping("/editPost")
	public ResponseEntity<PostDTO> editPost(@RequestBody PostDTO postDTO) {
		postService.editPost(postDTO);
		return ResponseEntity.ok(postDTO);
	}

	@PostMapping("/deletePost")
	public ResponseEntity<PostDTO> deletePost(@RequestBody PostDTO postDTO) {
		postService.deletePost(postDTO.getId());
		return ResponseEntity.ok(postDTO);
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
