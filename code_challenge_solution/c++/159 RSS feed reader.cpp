```cpp
#include <iostream>
#include <string>

#include "tinyxml2.h"

using namespace std;
using namespace tinyxml2;

int main() {
    XMLDocument xmlDoc;

    // Load RSS feed XML file
    if (xmlDoc.LoadFile("rss.xml") == XML_SUCCESS) {
        XMLElement* rssElement = xmlDoc.FirstChildElement("rss");

        if (rssElement) {
            XMLElement* channelElement = rssElement->FirstChildElement("channel");

            if (channelElement) {
                // Retrieve feed title and display
                XMLElement* titleElement = channelElement->FirstChildElement("title");

                if (titleElement) {
                    const char* title = titleElement->GetText();
                    cout << "Feed Title: " << title << endl;
                }

                // Loop through all item elements
                XMLElement* itemElement = channelElement->FirstChildElement("item");

                while (itemElement) {
                    // Retrieve item title and display
                    XMLElement* itemTitleElement = itemElement->FirstChildElement("title");

                    if (itemTitleElement) {
                        const char* itemTitle = itemTitleElement->GetText();
                        cout << "Item Title: " << itemTitle << endl;
                    }

                    // Retrieve item link and display
                    XMLElement* itemLinkElement = itemElement->FirstChildElement("link");

                    if (itemLinkElement) {
                        const char* itemLink = itemLinkElement->GetText();
                        cout << "Item Link: " << itemLink << endl;
                    }

                    itemElement = itemElement->NextSiblingElement("item");
                }
            } else {
                cout << "No channel element found." << endl;
            }
        } else {
            cout << "No rss element found." << endl;
        }
    } else {
        cout << "Failed to load RSS feed XML file." << endl;
    }

    return 0;
}
```

Note: Replace "rss.xml" in `xmlDoc.LoadFile("rss.xml")` with the actual path to your RSS feed XML file.