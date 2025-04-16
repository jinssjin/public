#include <iostream>
#include <vector>
using namespace std;

int main()
{
    vector<string> cars = {"Volvo","BMW","Ford","Mazda"};
        cout << cars.front() << "\n";  // 첫번째 요소 접근, 맨 앞 출력
        cout << cars.back() << "\n";  // 마지막 요소 접근, 맨 뒤 출력
    return 0;
}
