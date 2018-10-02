package com.codecool.kinder.repository;

import com.codecool.kinder.model.Image;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ImageRepository extends JpaRepository<Image,Integer>{

    Optional<Image> findByIdAndEnabledTrue(Integer integer);

    List<Image> findAllByProfile(Integer profileId);
}
