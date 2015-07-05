package com.jubydull.forxml;

import com.sun.xml.bind.marshaller.NamespacePrefixMapper;

public class XmlBookPrefix extends NamespacePrefixMapper {

	@Override
	public String getPreferredPrefix(String uri, String suggestion, boolean bln) {
		if (uri.equals("http://example.com/programming/test/book")) {
            return "b";
        }
		return "";
	}

}
