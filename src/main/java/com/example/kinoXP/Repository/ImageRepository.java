package com.example.kinoXP.Repository;

import com.example.kinoXP.Domain.Image;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ImageRepository extends PagingAndSortingRepository<Image, Long> {

    public Image findByName(String name);
}
