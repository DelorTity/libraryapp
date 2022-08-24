package com.softwify.libraryapp;


import com.softwify.libraryapp.dao.AuthorDao;
import com.softwify.libraryapp.dao.TextbookDao;
import com.softwify.libraryapp.model.Author;
import com.softwify.libraryapp.model.Textbook;
import com.softwify.libraryapp.service.TextbookManager;
import com.softwify.libraryapp.util.OptionSelector;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.text.ParseException;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;

public class TextbookManagerTest {
    TextbookDao textbookDao = Mockito.mock(TextbookDao.class);
    OptionSelector optionSelector = Mockito.mock(OptionSelector.class);
    AuthorDao authorDao = Mockito.mock(AuthorDao.class);
    TextbookManager textbookManager = new TextbookManager(textbookDao, optionSelector, authorDao);

    @Test
    public void testDisplayTextbooks() {
        textbookManager.displayTextbooks();
        verify(textbookDao, times(1)).getAll();
    }

    @Test
    public void deleteTextbookShouldReturnFalseWhenDaoReturnFalse() {
        when(textbookDao.delete(anyInt())).thenReturn(false);

        boolean deleted = textbookManager.delete(5);
        assertFalse(deleted);
        verify(textbookDao, times(1)).delete(5);
    }

    @Test
    public void deleteTextbookShouldReturnTrueWhenDaoReturnTrue() {
        when(textbookDao.delete(anyInt())).thenReturn(true);
        boolean deleted = textbookManager.delete(5);
        assertTrue(deleted);
        verify(textbookDao, times(1)).delete(5);
    }

    @Test
    public void testShouldReturnTrueWhenTextbookIsDisplayed() {
        Textbook textbook = new Textbook(6, "titre propre", 5, 1234, "USA", new Date());
        when(textbookDao.getById(6)).thenReturn(textbook);
        assertTrue(textbookManager.readTextbook(6));
        verify(textbookDao, times(1)).getById(6);
    }

    @Test
    public void testShouldReturnFalseWhenTextbookIsNotDisplayed() {
        when(textbookDao.getById(5)).thenReturn(null);
        assertFalse(textbookManager.readTextbook(5));
        verify(textbookDao, times(1)).getById(5);
    }

    @Test
    public void testTextbookRegistrationIs() throws ParseException {
        when(optionSelector.readString()).thenReturn("Thione Niang");
        when(optionSelector.readInt()).thenReturn(569);
        when(optionSelector.readDate()).thenReturn("02-03-2020");
        when(authorDao.getByFirstNameAndLastName(any(), any())).thenReturn(new Author(1, "Thione", "Niang"));
        textbookManager.processAdd();

        verify(authorDao, times(1)).getByFirstNameAndLastName(any(), any());
    }

}
