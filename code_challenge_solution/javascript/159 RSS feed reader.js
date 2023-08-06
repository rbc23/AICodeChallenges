```javascript
// Fetch the RSS feed data using the fetch() function
fetch('https://example.com/rss-feed-url')
  .then(response => response.text())
  .then(data => {
    // Parse the XML data to JSON using an XML parser library
    const parser = new DOMParser();
    const xml = parser.parseFromString(data, 'text/xml');
    
    // Get the list of items from the RSS feed
    const items = xml.querySelectorAll('item');
    
    // Iterate through each item and extract the required information
    items.forEach(item => {
      const title = item.querySelector('title').textContent;
      const link = item.querySelector('link').textContent;
      const description = item.querySelector('description').textContent;
      
      // Display the extracted information
      console.log('Title:', title);
      console.log('Link:', link);
      console.log('Description:', description);
      console.log('---');
    });
  })
  .catch(error => {
    console.error('An error occurred while fetching the RSS feed:', error);
  });
```