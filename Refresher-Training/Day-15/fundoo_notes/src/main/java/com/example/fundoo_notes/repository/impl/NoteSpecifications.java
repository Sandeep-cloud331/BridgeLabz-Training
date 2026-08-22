package com.example.fundoo_notes.repository.impl;

import com.example.fundoo_notes.entity.Note;
import com.example.fundoo_notes.entity.User;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.List;
//import java.util.function.Predicate;
import jakarta.persistence.criteria.Predicate;

public class NoteSpecifications {
    public static Specification<Note> search(
            User owner,
            String titleText,
            Note.NoteState state,
            String tagName
    ){
        return (root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();
            predicates.add(
                    criteriaBuilder.equal(
                            root.get("owner"), owner));
            if(titleText != null && !titleText.isBlank()){
                predicates.add(
                        criteriaBuilder.like(
                                criteriaBuilder.lower(
                                        root.get("title")),
                                "%"+
                                        titleText.toLowerCase()+
                                        "%"));
            }
            if(state != null){
                predicates.add(
                        criteriaBuilder.equal(
                                root.get("state"),
                                state));
            }
            if (tagName != null &&
                    !tagName.isBlank()) {
                predicates.add(
                        criteriaBuilder.equal(
                                root.join("tags").get("name"),
                                tagName));
            }
            return criteriaBuilder.and(
                    predicates.toArray(
                            new Predicate[0]));

        };
    }
}
