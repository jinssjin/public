#include <iostream>
#include <vector>
using namespace std;

int main()
{
    vector<string> cars = {"Volvo","BMW","Ford","Mazda"};
    cars.push_back("렉서스");  // 벡터 요소 추가
    cars.push_back("VM");
    cars.push_back("Mitsubishi");
    cars.push_back("Mini");
    for(string car:cars){
        cout << car << "\n";
    }

    cout << cars.size() << "\n";
    return 0;
}
