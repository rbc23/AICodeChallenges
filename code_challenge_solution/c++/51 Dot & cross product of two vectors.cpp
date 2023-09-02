#include <iostream>
#include <vector>

using namespace std;

// Function to compute the dot product of two vectors
double dotProduct(vector<double> vector1, vector<double> vector2) {
    if (vector1.size() != vector2.size()) {
        cout << "Error: Vectors must have the same dimension!";
        return 0;
    }

    double dotProduct = 0.0;

    for (int i = 0; i < vector1.size(); i++) {
        dotProduct += vector1[i] * vector2[i];
    }

    return dotProduct;
}

// Function to compute the cross product of two vectors
vector<double> crossProduct(vector<double> vector1, vector<double> vector2) {
    if (vector1.size() != 3 || vector2.size() != 3) {
        cout << "Error: Vectors must be 3-dimensional!";
        return {};
    }

    vector<double> crossProduct(3);

    crossProduct[0] = vector1[1] * vector2[2] - vector1[2] * vector2[1];
    crossProduct[1] = vector1[2] * vector2[0] - vector1[0] * vector2[2];
    crossProduct[2] = vector1[0] * vector2[1] - vector1[1] * vector2[0];

    return crossProduct;
}

int main() {
    vector<double> vector1 = {1, 2, 3};
    vector<double> vector2 = {4, 5, 6};

    // Compute dot product
    double dotProductResult = dotProduct(vector1, vector2);
    cout << "Dot Product: " << dotProductResult << endl;

    // Compute cross product
    vector<double> crossProductResult = crossProduct(vector1, vector2);
    cout << "Cross Product: ";
    for (int i = 0; i < crossProductResult.size(); i++) {
        cout << crossProductResult[i] << " ";
    }
    cout << endl;

    return 0;
}