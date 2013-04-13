package workoutmanager.applet;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

public class XMLReader {

	// URL url = new URL("mysqltoxml.php");
	// tags[0] = users

	public static void main(String[] args) {
		getWorkout();
	}

	public static boolean read2(URL url, String... tags) {
		try {
			DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory
					.newInstance();
			DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();
			Document doc = docBuilder.parse(url.toString());
			// normalize text representation
			doc.getDocumentElement().normalize();

			NodeList users = doc.getElementsByTagName(tags[0]);
			Node firstPersonNode = users.item(0);
			String sucess = firstPersonNode.getTextContent();
			if (sucess == "true")
				return true;

		} catch (SAXParseException err) {
			System.out.println("** Parsing error" + ", line "
					+ err.getLineNumber() + ", uri " + err.getSystemId());
			System.out.println(" " + err.getMessage());

		} catch (SAXException e) {
			Exception x = e.getException();
			((x == null) ? e : x).printStackTrace();
		} catch (Throwable t) {
			t.printStackTrace();
		}
		return false;
	}

	/**
	 * Finds the tag you are looking for and returns all of the corresponding
	 * elements.
	 * 
	 * @param url
	 * @param tagName
	 */
	public static void getAllElements2(URL url, String tagName) {
		Document doc = createDocument(url);

		// normalize text representation
		doc.getDocumentElement().normalize();

		// Get the list of nodes by the tagName.
		NodeList list = doc.getElementsByTagName(tagName);

		// If the list has nodes, print the nodes.
		if (list.getLength() > 0)
			printNodes(list);
	}

	public static void getWorkout() {
		String user = "helson";
		String password = "123456";

		URL url = getDataBaseURL("helson", "123456");
		String workout = findElementTree(url, "status");
		System.out.println(workout);
	}

	public static String findElementTree(URL url, String... tags) {
		Document doc = createDocument(url);
		doc.normalize();

		return getSpecificTag(doc, tags);

	}

	private static URL getDataBaseURL(String username, String password) {
		try {
			return new URL("http://carlunger.se/login.php?username=" + username
					+ "&password=" + password + "");
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static String getSpecificTag(Document doc, String... tag) {
		NodeList nList = doc.getElementsByTagName(tag[0]);
		for (int temp = 0; temp < nList.getLength(); temp++) {
			Node nNode = nList.item(temp);
			if (nNode.getNodeType() == Node.ELEMENT_NODE) {

				Element eElement = (Element) nNode;

				if (eElement.getAttribute(tag[0]) != null) {
					if (tag.length > 1)
						return getSpecificTag(doc,
								Arrays.copyOfRange(tag, 1, tag.length - 1));
					else
						return eElement.getTextContent();
				}
			}
		}
		System.out.println("Failed");
		return null;
	}

	/**
	 * Prints an entire XML file.
	 * 
	 * @param url
	 *            The URL where the XML file is located.
	 */
	public static void printXML(URL url) {
		Document doc = createDocument(url);
		doc.normalize();
		if (doc.hasChildNodes())
			printNodes(doc.getChildNodes());
	}

	/**
	 * Returns a non-normalized document by parsing the the XML file at the
	 * specified URL.
	 * 
	 * @param url
	 *            The URL of the XML file.
	 * @return A XML document.
	 */
	private static Document createDocument(URL url) {
		DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory
				.newInstance();
		DocumentBuilder docBuilder;
		Document doc;
		try {
			docBuilder = docBuilderFactory.newDocumentBuilder();
			doc = docBuilder.parse(url.toString());
			return doc;
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	private static void printNodes(NodeList nodeList) {

		for (int count = 0; count < nodeList.getLength(); count++) {
			Node tempNode = nodeList.item(count);

			// make sure it's element node.
			if (tempNode.getNodeType() == Node.ELEMENT_NODE) {

				// get node name and value
				System.out.println("\nNode Name =" + tempNode.getNodeName()
						+ " [OPEN]");
				System.out.println("Node Value =" + tempNode.getTextContent());

				if (tempNode.hasAttributes()) {
					// get attributes names and values
					NamedNodeMap nodeMap = tempNode.getAttributes();
					for (int i = 0; i < nodeMap.getLength(); i++) {
						Node node = nodeMap.item(i);
						System.out.println("attr name : " + node.getNodeName());
						System.out.println("attr value : "
								+ node.getNodeValue());
					}
				}
				if (tempNode.hasChildNodes()) {
					// loop again if has child nodes
					printNodes(tempNode.getChildNodes());
				}

				System.out.println("Node Name =" + tempNode.getNodeName()
						+ " [CLOSE]");
			}
		}
	}

	public static void read(URL url, String... tags) {
		try {
			DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory
					.newInstance();
			DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();

			Document doc = docBuilder.parse(url.toString());

			// normalize text representation
			doc.getDocumentElement().normalize();

			NodeList users = doc.getElementsByTagName(tags[0]);

			for (int s = 0; s < users.getLength(); s++) {

				Node firstPersonNode = users.item(s);
				if (firstPersonNode.getNodeType() == Node.ELEMENT_NODE) {

					// Get First Name
					Element firstPersonElement = (Element) firstPersonNode;
					NodeList firstNameList = firstPersonElement
							.getElementsByTagName("id");
					Element firstNameElement = (Element) firstNameList.item(0);

					readElement(firstNameElement, "First Name: ");

					// Get Last Name
					NodeList lastNameList = firstPersonElement
							.getElementsByTagName("username");
					Element lastNameElement = (Element) lastNameList.item(0);
					readElement(lastNameElement, "Last Name: ");

					// Get Age
					NodeList ageList = firstPersonElement
							.getElementsByTagName("age");
					Element ageElement = (Element) ageList.item(0);
					readElement(ageElement, "Age: ");

				}
			}

		} catch (SAXParseException err) {
			System.out.println("** Parsing error" + ", line "
					+ err.getLineNumber() + ", uri " + err.getSystemId());
			System.out.println(" " + err.getMessage());

		} catch (SAXException e) {
			Exception x = e.getException();
			((x == null) ? e : x).printStackTrace();
		} catch (Throwable t) {
			t.printStackTrace();
		}
	}

	private static void readElement(Element list, String tag) {
		NodeList textFNList = list.getChildNodes();
		System.out.println(tag
				+ ((Node) textFNList.item(0)).getNodeValue().trim());
	}
}
