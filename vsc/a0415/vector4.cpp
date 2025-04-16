#include <iostream>
#include <vector>
using namespace std;

int main()
{
    vector<string> cars = {"Volvo","BMW","Ford","Mazda"};
        cout << cars.at(1) << "\n";  // 인덱스1번
        cout << cars.at(2) << "\n";  // 인덱스2번
        cout << cars.at(6) << "\n";  // 인덱스6번(없음) : 오류가 있을 때 자세히 알려줌
        cout << cars[6] << "\n";  // 인덱스6번(없음) : 오류가 있을 때 자세히 알려줌
    return 0;
}
