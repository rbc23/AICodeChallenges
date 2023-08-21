using System;
using System.Net;
using System.Xml;

class RSSFeedReader
{
    static void Main()
    {
        string rssUrl = "https://example.com/rssfeed"; // Replace with the URL of the RSS feed
        
        try
        {
            using (WebClient client = new WebClient())
            {
                string rssData = client.DownloadString(rssUrl);
                XmlDocument xmlDoc = new XmlDocument();
                xmlDoc.LoadXml(rssData);

                XmlNodeList rssNodes = xmlDoc.SelectNodes("rss/channel/item");

                foreach (XmlNode rssNode in rssNodes)
                {
                    XmlNode titleNode = rssNode.SelectSingleNode("title");
                    XmlNode linkNode = rssNode.SelectSingleNode("link");
                    XmlNode descriptionNode = rssNode.SelectSingleNode("description");

                    string title = titleNode != null ? titleNode.InnerText : "";
                    string link = linkNode != null ? linkNode.InnerText : "";
                    string description = descriptionNode != null ? descriptionNode.InnerText : "";

                    Console.WriteLine("Title: " + title);
                    Console.WriteLine("Link: " + link);
                    Console.WriteLine("Description: " + description);
                    Console.WriteLine();
                }
            }
        }
        catch (Exception ex)
        {
            Console.WriteLine("An error occurred: " + ex.Message);
        }
    }
}