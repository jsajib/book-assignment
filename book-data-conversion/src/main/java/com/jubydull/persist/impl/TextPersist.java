package com.jubydull.persist.impl;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import com.jubydull.FileExeption.NoFileException;
import com.jubydull.bean.BookInformation;
import com.jubydull.persist.Persist;

public class TextPersist implements Persist {

	private static final String FILE_PATH_PREFIX = "com/jubydull/resource/";
	private static final String FILE_STORAGE = "output.txt";

	public void save(Object persistObjet) {

		BookInformation bookInformation = (BookInformation) persistObjet;
		PrintWriter pribtWritter = null;

		File file = getFilePath(FILE_PATH_PREFIX + FILE_STORAGE);
		try {
			FileWriter fileWriteer = new FileWriter(file,true);
			BufferedWriter bufferWritter = new BufferedWriter(fileWriteer);
			
			pribtWritter = new PrintWriter(bufferWritter);
			pribtWritter.println(bookInformation);
			pribtWritter.write("");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		} finally {

			if (pribtWritter != null) {
				pribtWritter.close();
			}
		}

	}

	public File getFilePath(String fileName) {

		ClassLoader classLoader = getClass().getClassLoader();
		File file = null;
		try {
			file = new File(classLoader.getResource(fileName).getFile());
		} catch (Exception e) {
			try {
				throw new NoFileException(e.getLocalizedMessage());
			} catch (NoFileException e1) {
				e1.printStackTrace();
			}
		}
		return file;

	}

}
