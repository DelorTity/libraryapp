package com.softwify.libraryapp.dao;

import com.softwify.libraryapp.model.Author;

import java.util.List;

public interface AuthorDao {

	List<Author> getAll();

	boolean delete(int id);

	Author save(Author author);

	Author getByFirstNameAndLastName(String firstName, String lastName);
}
