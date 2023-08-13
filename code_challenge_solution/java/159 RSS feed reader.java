let rssFeeds = [
    "https://example.com/rss-feed-1",
    "https://example.com/rss-feed-2",
    "https://example.com/rss-feed-3"
];

function readRssFeed(feedUrl) {
    fetch(feedUrl)
        .then(response => response.text())
        .then(xml => {
            let parser = new DOMParser();
            let xmlDoc = parser.parseFromString(xml, "text/xml");

            let items = xmlDoc.getElementsByTagName("item");
            for (let i = 0; i < items.length; i++) {
                let title = items[i].getElementsByTagName("title")[0].textContent;
                let link = items[i].getElementsByTagName("link")[0].textContent;
                let description = items[i].getElementsByTagName("description")[0].textContent;

                // Do something with the feed item
                console.log("Title: " + title);
                console.log("Link: " + link);
                console.log("Description: " + description);
                console.log("---------");
            }
        })
        .catch(error => {
            console.error("Error fetching RSS feed:", error);
        });
}

rssFeeds.forEach(feedUrl => readRssFeed(feedUrl));