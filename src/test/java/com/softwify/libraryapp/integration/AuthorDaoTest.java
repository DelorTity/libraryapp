package com.softwify.libraryapp.integration;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import com.softwify.libraryapp.dao.NativeJdbcAuthorDao;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.softwify.libraryapp.configuration.DataBaseConfig;
import com.softwify.libraryapp.dao.AuthorDao;
import com.softwify.libraryapp.integration.config.DataBaseConfigTest;
import com.softwify.libraryapp.integration.service.DataBasePrepareService;
import com.softwify.libraryapp.model.Author;

public class AuthorDaoTest {

	DataBaseConfig dataBaseConfig = new DataBaseConfigTest();
	AuthorDao authorDao = new NativeJdbcAuthorDao(dataBaseConfig);
	DataBasePrepareService dataBasePrepareService = new DataBasePrepareService();

	@BeforeEach
	public void setUp() {
		dataBasePrepareService.clearDataBaseEntries();
	}

	@Test
	public void getAuthorsReturnsExpectedSizeAndAuthorsOrderByFullName() {
		List<Author> authors = authorDao.getAll();
		assertEquals("Napoleon Hill", authors.get(0).getFullName());
		assertEquals("Pierre-Yves Mcsween", authors.get(1).getFullName());
		assertEquals("Thione Niang", authors.get(2).getFullName());
		assertEquals("Wilfried Djomo", authors.get(3).getFullName());
		assertEquals(4, authors.size());
	}

	@Test
	public void givenIdDeleteAuthorRemovesCorrespondingAuthor() {
		assertEquals(4, authorDao.getAll().size());
		boolean deleted = authorDao.delete(3);
		assertTrue(deleted);

		List<Author> authors = authorDao.getAll();
		assertEquals(3, authors.size());

		for (Author author : authors) {
			assertNotEquals(4, author.getId());
		}

		/*
		 * boolean authorFound = false; for(Author author : authors) { if
		 * (author.getId() == 4) { authorFound = true; } } assertFalse(authorFound);
		 */
	}

	@Test
	public void insertAuthor() {
		Author authorAdd = new Author("liti", "kouam");
		authorDao.save(authorAdd);
		assertEquals(5, authorDao.getAll().size());
	}

	@Test
	public void checkAuthorAlreadyExist() {
		Author author = authorDao.getByFirstNameAndLastName("Thione", "Niang");
		assertNotNull(author);
	}

	@Test
	public void checkAuthorIsNotAlreadyExist() {
		Author author = authorDao.getByFirstNameAndLastName("Anze", "Niang");
		assertNull(author);
	}

}
