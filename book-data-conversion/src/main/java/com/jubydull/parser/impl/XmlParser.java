package com.jubydull.parser.impl;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import com.jubydull.bean.BookInformation;
import com.jubydull.parser.Parser;

public class XmlParser implements Parser {

	public BookInformation parse(File file) {
		JAXBContext jaxbContext;
		BookInformation bookInformation = null;
		
		try {
			jaxbContext = JAXBContext.newInstance(BookInformation.class);
			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			bookInformation = (BookInformation) jaxbUnmarshaller.unmarshal(file);
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return bookInformation;
	}

}
