package com.softwify.libraryapp.util;

import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class OptionSelector {
	private static Scanner scanner = new Scanner(System.in);
	private static final Logger logger = LogManager.getLogger(OptionSelector.class.getSimpleName());

	public int readInt() {
		try {
			String option = scanner.nextLine();
			return Integer.parseInt(option);
		} catch (NumberFormatException e) {
			logger.error(
					"Une erreur s'est produite quand vous avez entré une mauvaise valeur. Veuillez entrer le nombre correspondent s'il vous plait !!!");
			return -1;
		}
	}

	public String readString() {
		return scanner.nextLine();
	}
	public String readDate() {return scanner.nextLine();
	}
}
