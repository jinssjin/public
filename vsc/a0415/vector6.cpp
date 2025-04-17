#include <iostream>
#include <vector>
using namespace std;

int main()
{
    vector<string> cars = {"Volvo","BMW","Ford","Mazda"};
    auto it = cars.begin()+2; // 인덱스 2번위치(3번째방, [2])에
    cars.insert(it,"Hyundai");  // 삽입

    for(string car:cars){
        cout << car << "\n";
    }
    return 0;
}
