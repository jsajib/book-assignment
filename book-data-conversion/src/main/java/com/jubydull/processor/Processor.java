package com.jubydull.processor;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import com.jubydull.FileExeption.NoFileException;
import com.jubydull.bean.BookInformation;
import com.jubydull.bookinformation.util.Util;
import com.jubydull.parser.Parser;
import com.jubydull.parser.context.ParserContext;
import com.jubydull.parser.manager.ParsingManager;
import com.jubydull.persist.context.PersistContext;
import com.jubydull.persist.impl.TextPersist;
import com.jubydull.persist.manager.PersistManager;
import com.jubydull.viewer.context.ViewerContext;
import com.jubydull.viewer.manager.ViewerManager;

public class Processor {

	private static final String FILE_PATH_PREFIX = "com/jubydull/resource/";

	public void process(String fileName) {

		ParsingManager parsingManager = new ParsingManager();
		File file =null;
		String[] fileType=null;
		if (fileName != null && fileName.length() > 0) {
			if(Util.validUrl(fileName)){
				try {
					URL url = new URL(fileName);
					file = new File(url.getPath());
				} catch (MalformedURLException e) {
					e.printStackTrace();
				}
			}else{
				String fullFileName = FILE_PATH_PREFIX + fileName;
				fileType = fileName.split("\\.");
				file = getFilePath(fullFileName);}
				if (file != null) {

					Parser chooseParser = Util.chooseFileParser(fileType[1]);

					if (chooseParser != null) {

						ParserContext parserContext = new ParserContext();
						parserContext.setParser(chooseParser);

						BookInformation bookInformation = parsingManager.parse(
								parserContext, file);
						File propertiesFile;
						if (bookInformation != null) {
							propertiesFile = getFilePath(FILE_PATH_PREFIX
									+ "book-info-converter.properties");

							ViewerContext viewerContext = Util.setViewerForFile(Util.chooseViewForFile(propertiesFile));
							ViewerManager manager = new ViewerManager();
							manager.parse(viewerContext, bookInformation);

							if (Util.checkEnableStorage(propertiesFile)) {
								PersistManager persistManager = new PersistManager();
								PersistContext persistContext = new PersistContext();
								persistContext.setPersist(new TextPersist());
								persistManager.persist(persistContext,
										bookInformation);

							}

						}
					}
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
