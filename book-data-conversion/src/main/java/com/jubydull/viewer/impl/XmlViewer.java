package com.jubydull.viewer.impl;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import com.jubydull.bean.BookInformation;
import com.jubydull.forxml.XMLBook;
import com.jubydull.viewer.Viewer;
import com.sun.xml.bind.marshaller.NamespacePrefixMapper;

public class XmlViewer implements Viewer {

	public void view(Object object) {
		
		JAXBContext jaxbContext;
		try {
			jaxbContext = JAXBContext.newInstance( XMLBook.class );
			Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
			
			BookInformation bookInformation = (BookInformation) object;
			XMLBook xmlBook = new XMLBook();
			
			xmlBook.setIsbn(bookInformation.getIsbn());
			xmlBook.setName(bookInformation.getName());
			xmlBook.setAuthors(bookInformation.getAuthors());
			xmlBook.setPublisheddate(bookInformation.getPublisheddate());
			
			NamespacePrefixMapper mapper = new NamespacePrefixMapper() {
			    public String getPreferredPrefix(String namespaceUri, String suggestion, boolean requirePrefix) {
			        return "b";
			    }
			};
			jaxbMarshaller.setProperty("com.sun.xml.bind.namespacePrefixMapper", mapper);
			
			//jaxbMarshaller.setProperty("com.sun.xml.bind.xmlDeclaration", Boolean.TRUE);
			jaxbMarshaller.setProperty(Marshaller.JAXB_ENCODING, "UTF-8");

			
			jaxbMarshaller.setProperty( Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE );
			jaxbMarshaller.marshal( xmlBook, System.out );

		} catch (JAXBException e) {
			e.printStackTrace();
		}
	


	}

}
