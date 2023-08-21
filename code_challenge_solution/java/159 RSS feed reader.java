import java.io.IOException;
import java.net.URL;
import java.util.List;

import com.sun.syndication.feed.synd.SyndEntry;
import com.sun.syndication.feed.synd.SyndFeed;
import com.sun.syndication.io.FeedException;
import com.sun.syndication.io.SyndFeedInput;
import com.sun.syndication.io.XmlReader;

public class RSSReader {
    public static void main(String[] args) throws IOException, IllegalArgumentException, FeedException {
        String feedUrl = "https://example.com/rss_feed.xml";
        URL url = new URL(feedUrl);

        SyndFeedInput input = new SyndFeedInput();
        SyndFeed feed = input.build(new XmlReader(url));

        System.out.println("Feed Title: " + feed.getTitle());

        List<SyndEntry> entries = feed.getEntries();
        for (SyndEntry entry : entries) {
            System.out.println();
            System.out.println("Title: " + entry.getTitle());
            System.out.println("Link: " + entry.getLink());
            System.out.println("Published Date: " + entry.getPublishedDate());
            System.out.println("Description: " + entry.getDescription().getValue());
        }
    }
}