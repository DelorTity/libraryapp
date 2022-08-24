package com.softwify.libraryapp.service;

import com.softwify.libraryapp.dao.*;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.softwify.libraryapp.configuration.DataBaseConfig;
import com.softwify.libraryapp.configuration.DefaultDataBaseConfig;
import com.softwify.libraryapp.util.OptionSelector;

public class LibraryMenu {
	private static final Logger logger = LogManager.getLogger(LibraryMenu.class.getSimpleName());

	private static final OptionSelector optionSelector = new OptionSelector();
	public static final DataBaseConfig dataBaseConfig = new DefaultDataBaseConfig();
    private static final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("library-app-pu");
    private static final EntityManager entityManager = entityManagerFactory.createEntityManager();
    private static final AuthorDao authorDao = new JpaAuthorDao(entityManager);
	private static final TextbookDao textbookDao = new NativeJdbcTextbookDao();
	private static final AuthorManager authorManager = new AuthorManager(authorDao, optionSelector);
	private static final TextbookManager textbookManager = new TextbookManager(textbookDao, optionSelector, authorDao);

	public static void loadApp() {
		System.out.println("Bienvenue a la Bibliotheque");

		boolean continueApp = true;

		while (continueApp) {
			loadMenu();
			int option = optionSelector.readInt();
			switch (option) {
				case 1: {
					authorManager.manage();
					continueApp = false;
					break;
				}
				case 2: {
					textbookManager.manage();
					break;
				}
				case 0: {
					System.exit(option);
				}
				default:
					logger.error("S'il vous plait veillez entrer une valeur correcte");
					break;
			}
		}
	}

	private static void loadMenu() {
		System.out.println("Que voulez-vous faire ?\n" + "1 - Gestion des auteurs\n" + "2 - Gestion des livres\n"
				+ "0 - Quitter la bibliothèque \n" + "--------------------------------------------");
	}
}