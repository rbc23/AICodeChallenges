import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

public class RSSFeedReader {
    public static void main(String[] args) {
        try {
            URL rssUrl = new URL("http://example.com/rss-feed.xml");
            
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(rssUrl.openStream());
            
            NodeList items = doc.getElementsByTagName("item");
            
            for (int i = 0; i < items.getLength(); i++) {
                System.out.println(items.item(i).getTextContent());
                System.out.println("-----------------------------");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}