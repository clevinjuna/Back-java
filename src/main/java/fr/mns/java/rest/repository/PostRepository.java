package fr.mns.java.rest.repository;

import fr.mns.java.rest.dto.PostDTO;
import fr.mns.java.rest.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
}