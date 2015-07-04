package com.jubydull.viewer.impl;

import com.jubydull.bean.BookInformation;
import com.jubydull.viewer.Viewer;

public class TextViewer implements Viewer {

	public void view(Object txtObject) {

		BookInformation bookInformation = (BookInformation) txtObject;
		System.out.println(bookInformation.getName().toUpperCase());

	}

}
