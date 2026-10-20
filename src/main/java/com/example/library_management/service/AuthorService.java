package com.example.library_management.service;

import com.example.library_management.model.Author;
import com.example.library_management.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorService {

    @Autowired
    private AuthorRepository authorRepository;

    // Get all authors from the database
    public List<Author> getAllAuthors() {
        return authorRepository.findAll();
    }

    // Save a new author to the database
    public Author saveAuthor(Author author) {
        return authorRepository.save(author);
    }
}
