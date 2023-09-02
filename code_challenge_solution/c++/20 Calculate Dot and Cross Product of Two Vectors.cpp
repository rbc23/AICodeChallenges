#include<iostream>
#include<vector>

int dotProduct(std::vector<int> v1, std::vector<int> v2) {
    int dotProduct = 0;
    for (int i = 0; i < v1.size(); i++) {
        dotProduct += v1[i] * v2[i];
    }
    return dotProduct;
}

std::vector<int> crossProduct(std::vector<int> v1, std::vector<int> v2) {
    std::vector<int> crossProduct(3);
    crossProduct[0] = v1[1] * v2[2] - v1[2] * v2[1];
    crossProduct[1] = v1[2] * v2[0] - v1[0] * v2[2];
    crossProduct[2] = v1[0] * v2[1] - v1[1] * v2[0];
    return crossProduct;
}

int main() {
    std::vector<int> v1 = {1, 2, 3};
    std::vector<int> v2 = {4, 5, 6};

    std::cout << "Dot Product: " << dotProduct(v1, v2) << std::endl;

    std::vector<int> cross = crossProduct(v1, v2);
    std::cout << "Cross Product: ";
    for (int value : cross) {
        std::cout << value << " ";
    }
    std::cout << std::endl;

    return 0;
}