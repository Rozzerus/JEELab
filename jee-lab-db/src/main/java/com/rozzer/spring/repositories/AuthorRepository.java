package com.rozzer.spring.repositories;

import com.rozzer.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository  extends JpaRepository<Author, Long> {
}
