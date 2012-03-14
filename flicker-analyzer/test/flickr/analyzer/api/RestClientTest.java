package flickr.analyzer.api;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import javax.xml.namespace.QName;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;
import org.springframework.web.client.RestTemplate;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class RestClientTest extends TestCase {

	private RestClient api;
	private DocumentBuilder documentBuilder;
	private XPath xpathCompiler;

	@Before
	@Override
	public void setUp() throws ParserConfigurationException {
		String apiKey = "c55dc6d6b4d2a240d4bca36f680d34b4";

		api = new RestClient(new RestTemplate(), apiKey);
		documentBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
		xpathCompiler = XPathFactory.newInstance().newXPath();
	}

	@Test
	public void testGetPublicPhotos() throws SAXException, IOException, XPathExpressionException {
		String xml = api.getPublicPhotos("46992844@N08");
		NodeList nodes = (NodeList) evaluateXpathOnXml(xml, "/rsp/photos/photo", XPathConstants.NODESET);
		
		assertTrue(nodes.getLength() > 0);
	}

	@Test
	public void testGetUserId() throws SAXException, IOException, XPathExpressionException {
		String xml = api.getUserId("Mariajo2010");
		String text = (String) evaluateXpathOnXml(xml, "//username/text()", XPathConstants.STRING);

		assertEquals("Mariajo2010", text);
	}

	@Test
	public void testGetCommentsList() throws SAXException, IOException, XPathExpressionException {
		String xml = api.getCommentsList("6978675831");
		NodeList nodes = (NodeList) evaluateXpathOnXml(xml, "/rsp/comments/comment", XPathConstants.NODESET);

		assertTrue(nodes.getLength() > 0);
	}

	private Object evaluateXpathOnXml(String xml, String xpath, QName returnType) throws SAXException, IOException, XPathExpressionException {
		Document document = documentBuilder.parse(new ByteArrayInputStream(xml.getBytes()));
		XPathExpression expression = xpathCompiler.compile(xpath);
		return expression.evaluate(document, returnType);
	}
}
