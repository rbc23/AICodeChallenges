```
#include <iostream>
using namespace std;

int main() {
    float weight, height, bmi;

    cout << "Enter weight in kilograms: ";
    cin >> weight;

    cout << "Enter height in meters: ";
    cin >> height;

    bmi = weight / (height * height);

    cout << "Your BMI is: " << bmi << endl;

    return 0;
}
```