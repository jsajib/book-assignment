package com.jubydull.forxml;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement( name="book" )
@XmlType (propOrder = {"isbn","name","authors","publisheddate"})
public class XMLBook {

	private String isbn;
	private String name;
	private String[] authors;
	private String publisheddate;

	public String getIsbn() {
		return isbn;
	}

	@XmlElement(name = "isbn")
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getName() {
		return name;
	}

	@XmlElement(name = "name")
	public void setName(String name) {
		this.name = name;
	}

	public String[] getAuthors() {
		return authors;
	}

	@XmlElementWrapper(name = "Authors")
	@XmlElement(name = "Author")
	public void setAuthors(String[] authors) {
		this.authors = authors;
	}

	public String getPublisheddate() {
		return publisheddate;
	}

	@XmlElement(name = "published-date")
	public void setPublisheddate(String publisheddate) {
		this.publisheddate = publisheddate;
	}

}
