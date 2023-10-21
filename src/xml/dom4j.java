package xml;

import com.sun.xml.internal.fastinfoset.tools.StAX2SAXReader;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.xml.sax.*;

import javax.xml.parsers.SAXParser;
import java.util.List;

public class dom4j {
    public static void main(String[] args) throws DocumentException {
        SAXReader saxReader = new SAXReader();
        Document read = saxReader.read("src/xml/student.xml");
        Element rootElement = read.getRootElement();
        List<Element> elements = rootElement.elements("student");
        for(Element element : elements) {
            String name = element.elementText("name");
            String age = element.elementText("age");
            System.out.println(name+" "+ age +"\n");
        }
    }
}