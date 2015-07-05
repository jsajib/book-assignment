package com.jubydull.bookinformation.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.commons.validator.UrlValidator;

import com.jubydull.formatenum.FormatEnum;
import com.jubydull.parser.Parser;
import com.jubydull.parser.impl.JsonParser;
import com.jubydull.parser.impl.TextParser;
import com.jubydull.parser.impl.XmlParser;
import com.jubydull.viewer.context.ViewerContext;
import com.jubydull.viewer.impl.JsonViewer;
import com.jubydull.viewer.impl.TextViewer;
import com.jubydull.viewer.impl.XmlViewer;

public class Util {

	public static Parser chooseFileParser(String fileType) {

		if (fileType.equals(FormatEnum.json.toString())) {
			JsonParser jsonParser = new JsonParser();
			return jsonParser;
		} else if (fileType.equals(FormatEnum.txt.toString())) {
			TextParser textParser = new TextParser();
			return textParser;
		} else if (fileType.equals(FormatEnum.xml.toString())) {
			XmlParser xmltParser = new XmlParser();
			return xmltParser;
		}else {
			return null;
		}
	}

	public static String chooseViewForFile(File file) {
		Properties properties = new Properties();
		InputStream input = null;
		String targetFormat = "";
		try {

			input = new FileInputStream(file);
			try {
				properties.load(input);
				targetFormat = properties.getProperty("targetFormat");
			} catch (IOException e) {

				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		}

		return targetFormat;
	}

	public static boolean checkEnableStorage(File file) {
		Properties properties = new Properties();
		InputStream input = null;
		String storage = "";
		try {
			input = new FileInputStream(file);
			properties.load(input);
			storage = properties.getProperty("storageEnabled");
			if (storage.equals("true")) {
				return true;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return false;
	}

	public static ViewerContext setViewerForFile(String targerFormat) {

		ViewerContext viewerContext = new ViewerContext();
		if (targerFormat.equals(FormatEnum.json.toString())) {
			viewerContext.setViewer(new JsonViewer());
		} else if (targerFormat.equals(FormatEnum.txt.toString())) {
			viewerContext.setViewer(new TextViewer());
		} else if (targerFormat.equals(FormatEnum.xml.toString())) {
			viewerContext.setViewer(new XmlViewer());
		} else {
			viewerContext.setViewer(null);
		}

		return viewerContext;

	}

	public static boolean validUrl(String filePath) {
		UrlValidator urlValidator = new UrlValidator();
		if (urlValidator.isValid(filePath)) {
			return true;
		} else {
			return false;
		}

	}
}
