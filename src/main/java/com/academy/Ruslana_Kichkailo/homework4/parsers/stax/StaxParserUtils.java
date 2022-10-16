package com.academy.Ruslana_Kichkailo.homework4.parsers.stax;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

public class StaxParserUtils {

    public static XMLStreamReader createXMLStreamReader(String path){
        XMLInputFactory factory = XMLInputFactory.newInstance();
        try {
            return factory.createXMLStreamReader(ClassLoader.getSystemResourceAsStream(path));
        } catch (XMLStreamException e) {
            throw new RuntimeException(e);
        }
    }
}
