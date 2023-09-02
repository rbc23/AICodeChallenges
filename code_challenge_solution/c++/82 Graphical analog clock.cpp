```cpp
#include <SFML/Graphics.hpp>
#include <cmath>

int main()
{
    sf::RenderWindow window(sf::VideoMode(400, 400), "Analog Clock");

    while (window.isOpen())
    {
        sf::Event event;
        while (window.pollEvent(event))
        {
            if (event.type == sf::Event::Closed)
                window.close();
        }

        window.clear(sf::Color::White);

        sf::CircleShape clockShape(200);
        clockShape.setPosition(100, 100);
        clockShape.setFillColor(sf::Color::White);
        clockShape.setOutlineThickness(2);
        clockShape.setOutlineColor(sf::Color::Black);

        sf::CircleShape centerShape(10);
        centerShape.setFillColor(sf::Color::Black);
        centerShape.setOrigin(centerShape.getRadius(), centerShape.getRadius());
        centerShape.setPosition(300, 300);

        float angle = 0;
        float secondsRadius = 180;
        float minutesRadius = 160;
        float hoursRadius = 100;

        sf::Vertex line[2];

        // Draw seconds hand
        angle = (90 - 6) - std::fmod((6 * std::time(0)), 360.0);
        line[0].position = sf::Vector2f(300, 300);
        line[1].position = sf::Vector2f(300 + secondsRadius * std::sin(angle * 3.14 / 180),
                                        300 - secondsRadius * std::cos(angle * 3.14 / 180));
        line[0].color = sf::Color::Red;
        line[1].color = sf::Color::Red;
        window.draw(line, 2, sf::Lines);

        // Draw minutes hand
        angle = (90 - 6) - std::fmod((6 * std::time(0)) / 60, 360.0);
        line[0].position = sf::Vector2f(300, 300);
        line[1].position = sf::Vector2f(300 + minutesRadius * std::sin(angle * 3.14 / 180),
                                        300 - minutesRadius * std::cos(angle * 3.14 / 180));
        line[0].color = sf::Color::Black;
        line[1].color = sf::Color::Black;
        window.draw(line, 2, sf::Lines);

        // Draw hours hand
        angle = (90 - 30) - std::fmod((30 * std::time(0)) / 3600, 360.0);
        line[0].position = sf::Vector2f(300, 300);
        line[1].position = sf::Vector2f(300 + hoursRadius * std::sin(angle * 3.14 / 180),
                                        300 - hoursRadius * std::cos(angle * 3.14 / 180));
        line[0].color = sf::Color::Black;
        line[1].color = sf::Color::Black;
        window.draw(line, 2, sf::Lines);

        window.draw(clockShape);
        window.draw(centerShape);

        window.display();
    }

    return 0;
}
```