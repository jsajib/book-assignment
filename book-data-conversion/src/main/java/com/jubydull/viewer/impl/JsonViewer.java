package com.jubydull.viewer.impl;

import java.io.IOException;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.ObjectWriter;

import com.jubydull.bean.BookInformation;
import com.jubydull.forjson.impl.Book;
import com.jubydull.viewer.Viewer;

public class JsonViewer implements Viewer {

	public void view(Object object) {

		BookInformation bookInformation = (BookInformation) object;

		Book jsonDomainObject = new Book();
		jsonDomainObject.setName(bookInformation.getName());
		jsonDomainObject.setAuthors(bookInformation.getAuthors());
		jsonDomainObject.setPublishedDate(bookInformation.getPublisheddate());

		ObjectWriter objectWritter = new ObjectMapper().writer()
				.withDefaultPrettyPrinter();
		try {
			String jsonBookInformation = objectWritter
					.writeValueAsString(jsonDomainObject.toJSON());

			System.out.println(jsonBookInformation);

		} catch (JsonGenerationException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
