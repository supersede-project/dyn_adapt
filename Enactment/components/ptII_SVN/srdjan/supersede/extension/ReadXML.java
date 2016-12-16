package srdjan.supersede.extension;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.EntityResolver;
import org.xml.sax.InputSource;



/* An example of an XML file and the output after calling the given class

XML file:

<?xml version="1.0"?>
<company>
        <staff id="1001">
                <firstname>yong</firstname>
                <lastname>mook kim</lastname>
                <nickname>mkyong</nickname>
                <salary>100000</salary>
        </staff>
        <staff id="2001">
                <firstname>low</firstname>
                <lastname>yin fong</lastname>
                <nickname>fong fong</nickname>
                <salary>200000</salary>
        </staff>
</company>

OUTPUT:

Root element :company

Node Name =company [OPEN]
Node Value =

                yong
                mook kim
                mkyong
                100000


                low
                yin fong
                fong fong
                200000



Node Name =staff [OPEN]
Node Value =
                yong
                mook kim
                mkyong
                100000

attr name : id
attr value : 1001
...
*/

public class ReadXML {
    
  //saving the Recorder element attributes  
  static String Recorder_name;
  
  //all attributes of parsed elements (if an element is Recorder, the name of the element is saved to the Recorder string) 
  static Map<String, String> All_attributes = new HashMap<String, String>();

  public static String getRecorderName (File file) {

    try 
    {
        DocumentBuilder dBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();

        // uncomment the below lines to get rid of the 'connection refused: connect' error:
        dBuilder.setEntityResolver(new EntityResolver(){
             public InputSource resolveEntity(String publicId, String systemId){
                 return new InputSource(
                 new ByteArrayInputStream("<?xml version='1.0' encoding='UTF-8'?>".getBytes()));
             }});
        
        
        Document doc = dBuilder.parse(file);

        //System.out.println("Root element :" + doc.getDocumentElement().getNodeName());

        if (doc.hasChildNodes()) {

                printNote(doc.getChildNodes());

        }

    } 
    catch (Exception e) {
        System.out.println(e.getMessage());
    }
    
    return Recorder_name;

  }

  private static void printNote(NodeList nodeList) {

    for (int count = 0; count < nodeList.getLength(); count++) {

        Node tempNode = nodeList.item(count);

        // make sure it's element node.
        if (tempNode.getNodeType() == Node.ELEMENT_NODE) {

                // get node name and value
                //System.out.println("\nNode Name =" + tempNode.getNodeName() + " [OPEN]");
                //System.out.println("Node Value =" + tempNode.getTextContent());

                if (tempNode.hasAttributes()) {

                        // get attributes names and values
                        NamedNodeMap nodeMap = tempNode.getAttributes();
                        int foundRecorder=0;

                        for (int i = 0; i < nodeMap.getLength(); i++) {

                                Node node = nodeMap.item(i);
                                
                                //System.out.println("attr name : " + node.getNodeName());
                                //System.out.println("attr value : " + node.getNodeValue());
                                
                                All_attributes.put(node.getNodeName(), node.getNodeValue());
                                if(node.getNodeName().equals("class") & node.getNodeValue().equals("ptolemy.actor.lib.Recorder"))
                                {
                                    foundRecorder=1; 
                                }

                        }
                        
                        if(foundRecorder==1)
                        {
                            Recorder_name=All_attributes.get("name");
                            All_attributes.clear();
                            //here we get out of the main loop (note that the Recorder element is not nested within other elements, it must be defined at the end of the actors chain)
                            break;
                            
                        }
                        
                        All_attributes.clear();
                        

                }

                if (tempNode.hasChildNodes()) {

                        // loop again if has child nodes
                        printNote(tempNode.getChildNodes());

                }

                System.out.println("Node Name =" + tempNode.getNodeName() + " [CLOSE]");

        }

    }

  }

}