```cpp
#include <iostream>
#include <vector>
#include <random>

std::vector<std::vector<std::string>> haikus = {
    { "Autumn moonlight", "A worm digs silently", "Leaves rustle softly" },
    { "Winter's cold embrace", "Snowflakes dance in the moonlight", "Silent beauty shines" },
    { "Spring blossoms in bloom", "Birds sing their sweet melodies", "Nature's symphony" },
    { "Summer's blazing heat", "Waves crash against sandy shore", "Cool breeze brings relief" }
};

std::string getRandomHaiku() {
    std::random_device rd;
    std::mt19937 gen(rd());
    std::uniform_int_distribution<> dis(0, haikus.size() - 1);

    int index = dis(gen);
    std::string haiku;
    for (const auto& line : haikus[index]) {
        haiku += line + "\n";
    }

    return haiku;
}

int main() {
    std::cout << getRandomHaiku() << std::endl;

    return 0;
}
```