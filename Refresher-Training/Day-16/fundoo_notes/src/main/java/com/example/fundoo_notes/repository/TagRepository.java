package com.example.fundoo_notes.repository;

import com.example.fundoo_notes.entity.Tag;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TagRepository extends JpaRepository<Tag,Integer> {
    Optional<Tag> findByName(String tagName);
}
