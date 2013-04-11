package workoutmanager.database;

import java.net.URL;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

public class XMLReader {

	// URL url = new URL("mysqltoxml.php");
	// tags[0] = users

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
	
	public static void getAllElements2(URL url, String tagName) {
		
	}
	public static void getAllElements(URL url, String element) {
		DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory
				.newInstance();
		DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();
		Document doc = docBuilder.parse(url.toString());
		// normalize text representation
		doc.getDocumentElement().normalize();
	 
		System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
	 
		NodeList nList = doc.getElementsByTagName(element);
	 
		System.out.println("----------------------------");
	 
		for (int temp = 0; temp < nList.getLength(); temp++) {
	 
			Node nNode = nList.item(temp);
	 
			System.out.println("\nCurrent Element :" + nNode.getNodeName());
	 
			if (nNode.getNodeType() == Node.ELEMENT_NODE) {
	 
				Element eElement = (Element) nNode;
	 
				System.out.println("Staff id : " + eElement.getAttribute("id"));
				System.out.println("First Name : " + eElement.getElementsByTagName("firstname").item(0).getTextContent());
				System.out.println("Last Name : " + eElement.getElementsByTagName("lastname").item(0).getTextContent());
				System.out.println("Nick Name : " + eElement.getElementsByTagName("nickname").item(0).getTextContent());
				System.out.println("Salary : " + eElement.getElementsByTagName("salary").item(0).getTextContent());
	 
			}
		}
	    } catch (Exception e) {
		e.printStackTrace();
	    }
	  }

	}
	
	 private static void printNote(NodeList nodeList) {
		    for (int count = 0; count < nodeList.getLength(); count++) {
		 
			Node tempNode = nodeList.item(count);
		 
			// make sure it's element node.
			if (tempNode.getNodeType() == Node.ELEMENT_NODE) {
		 
				// get node name and value
				System.out.println("\nNode Name =" + tempNode.getNodeName() + " [OPEN]");
				System.out.println("Node Value =" + tempNode.getTextContent());
		 
				if (tempNode.hasAttributes()) {
					// get attributes names and values
					NamedNodeMap nodeMap = tempNode.getAttributes();
					for (int i = 0; i < nodeMap.getLength(); i++) {
						Node node = nodeMap.item(i);
						System.out.println("attr name : " + node.getNodeName());
						System.out.println("attr value : " + node.getNodeValue());
					}
				}
				if (tempNode.hasChildNodes()) {
					// loop again if has child nodes
					printNote(tempNode.getChildNodes());
				}
		 
				System.out.println("Node Name =" + tempNode.getNodeName() + " [CLOSE]");
			}
		}
		 
	}

	public static void bang(URL url, String...tags) {
		try {

			DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory
					.newInstance();
			DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();

			Document doc = docBuilder.parse(url.toString());

			// normalize text representation
			doc.getDocumentElement().normalize();

			
			
			
			System.out.println("Root element :"
					+ doc.getDocumentElement().getNodeName());

			NodeList nList = doc.getElementsByTagName("staff");

			System.out.println("----------------------------");

			for (int temp = 0; temp < nList.getLength(); temp++) {

				Node nNode = nList.item(temp);

				System.out.println("\nCurrent Element :" + nNode.getNodeName());

				if (nNode.getNodeType() == Node.ELEMENT_NODE) {

					Element eElement = (Element) nNode;

					System.out.println("Staff id : "
							+ eElement.getAttribute("id"));
					System.out.println("First Name : "
							+ eElement.getElementsByTagName("firstname")
									.item(0).getTextContent());
					System.out.println("Last Name : "
							+ eElement.getElementsByTagName("lastname").item(0)
									.getTextContent());
					System.out.println("Nick Name : "
							+ eElement.getElementsByTagName("nickname").item(0)
									.getTextContent());
					System.out.println("Salary : "
							+ eElement.getElementsByTagName("salary").item(0)
									.getTextContent());

				}
			}
		} catch (Exception e) {
			e.printStackTrace();
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