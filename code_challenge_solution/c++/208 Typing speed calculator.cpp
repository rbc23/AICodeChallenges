#include <iostream>
#include <chrono>
#include <string>

int main() {
    std::cout << "Type the following sentence:\n";
    std::string sentence = "The quick brown fox jumps over the lazy dog.";
    std::cout << sentence << std::endl;

    std::string input;
    std::getline(std::cin, input);

    auto start = std::chrono::high_resolution_clock::now();
    auto end = std::chrono::high_resolution_clock::now();

    double time_taken = std::chrono::duration_cast<std::chrono::milliseconds>(end - start).count() / 1000.0;

    int sentence_length = sentence.length();
    int input_length = input.length();
    int num_words = 1; // Assuming there is at least one word in the sentence

    for (int i = 0; i < input_length; i++) {
        if (input[i] == ' ') {
            num_words++;
        }
    }

    int typing_speed = (input_length / 5) / time_taken;

    std::cout << "Typing speed: " << typing_speed << " words per minute" << std::endl;

    return 0;
}