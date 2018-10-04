package com.codecool.kinder.repository;

import com.codecool.kinder.model.Image;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ImageRepository extends JpaRepository<Image,Integer>{

    Optional<Image> findById(Integer integer);

    List<Image> findAllByProfileId(Integer profileId);
}
