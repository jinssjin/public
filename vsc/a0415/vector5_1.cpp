#include <iostream>
#include <vector>
using namespace std;

int main()
{
    vector<string> cars = {"Volvo","BMW","Ford","Mazda"};
    cars.pop_back();  // 벡터 요소의 제거
    for(string car:cars){
        cout << car << "\n";
    }
    cout << cars.size() << "\n";  // 벡터의 크기
    cout << cars.empty() << "\n";  // 벡터가 값이 있는지 없는지 (비어있으면 1, 요소가 있으면 0)
    return 0;
}
