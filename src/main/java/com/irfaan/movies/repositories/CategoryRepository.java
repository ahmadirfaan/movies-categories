package com.irfaan.movies.repositories;

import com.irfaan.movies.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
}
