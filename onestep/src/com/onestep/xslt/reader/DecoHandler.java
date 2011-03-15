package com.onestep.xslt.reader;

import org.xml.sax.Attributes;
import org.xml.sax.ContentHandler;
import org.xml.sax.Locator;
import org.xml.sax.SAXException;

public class DecoHandler implements ContentHandler {
	private ContentHandler handler;
	public DecoHandler(ContentHandler handler) {
		this.handler = handler;
	}
	@Override
	public void setDocumentLocator(Locator locator) {
		handler.setDocumentLocator(locator);
		
	}
	@Override
	public void startDocument() throws SAXException {
		handler.startDocument();
		
	}
	@Override
	public void endDocument() throws SAXException {
		handler.endDocument();
		
	}
	@Override
	public void startPrefixMapping(String prefix, String uri) throws SAXException {
		handler.startPrefixMapping(prefix, uri);
		
	}
	@Override
	public void endPrefixMapping(String prefix) throws SAXException {
		handler.endPrefixMapping(prefix);
		
	}
	/**
	 * Strip the import-schema element for Saxon
	 */
	@Override
	public void startElement(String uri, String localName, String qName, Attributes atts) throws SAXException {
		if (!(localName.equals("import-schema"))) {
			handler.startElement(uri, localName, qName, atts);
		}  else
			System.out.println("start skipping: " + localName);
		
	}
	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		if (!(localName.equals("import-schema"))) {
			handler.endElement(uri, localName, qName);
		} else
			System.out.println("end skipping: " + localName);
	}
	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		
		handler.characters(ch, start, length);
		
	}
	@Override
	public void ignorableWhitespace(char[] ch, int start, int length) throws SAXException {
		handler.ignorableWhitespace(ch, start, length);
		
	}
	@Override
	public void processingInstruction(String target, String data) throws SAXException {
		handler.processingInstruction(target, data);
		
	}
	@Override
	public void skippedEntity(String name) throws SAXException {
		handler.skippedEntity(name);
		
	}
}
