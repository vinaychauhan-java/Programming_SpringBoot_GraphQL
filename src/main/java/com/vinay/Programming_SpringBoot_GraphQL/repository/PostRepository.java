package com.vinay.Programming_SpringBoot_GraphQL.repository;

import com.vinay.Programming_SpringBoot_GraphQL.domain.Post;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Transactional
@Repository("postRepository")
public interface PostRepository extends JpaRepository<Post, Long> {

}
