import feedparser

# Function to read the RSS feed
def read_rss(url):
    # Parse the RSS feed
    feed = feedparser.parse(url)
    
    # Print the feed title
    print("Feed Title:", feed.feed.title)
    print()
    
    # Print the feed entries
    for entry in feed.entries:
        print("Title:", entry.title)
        print("Link:", entry.link)
        print("Published Date:", entry.published)
        print("Summary:", entry.summary)
        print()
        

# URL of the RSS feed
url = "https://example.com/rss-feed"

# Call the read_rss function
read_rss(url)