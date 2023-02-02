package com.elijah.vacationtourproject.repository;

import com.elijah.vacationtourproject.model.image.ImageModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImageRepository extends JpaRepository<ImageModel,String> {
}
