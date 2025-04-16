#include <iostream>
#include <vector>
using namespace std;

int main()
{
    vector<string> cars = {"Volvo","BMW","Ford","Mazda"};
    cars.push_back("렉서스");
    cars[0] = "테슬라";  // 재정의 가능
    cars.at(1) = "Hyundai";  // 재정의 가능
        cout << cars[0] << "\n";
        cout << cars.at(1) << "\n";
    return 0;
}
