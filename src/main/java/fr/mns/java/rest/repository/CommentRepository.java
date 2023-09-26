package fr.mns.java.rest.repository;

import fr.mns.java.rest.dto.CommentDTO;
import fr.mns.java.rest.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {

}