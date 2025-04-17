#include <iostream>
#include <string>
using namespace std;

/*
1. 입출력과 문자열
사용자 이름과 나이를 입력받아 "홍길동님은 25세입니다." 와 같은 문장을 출력하는 프로그램을 작성하시오.
*/

int main()
{
    string name;
    int age;
    cout << "시용자 이름을 입력하시오 : ";
    cin >> name;
    cout << endl;
    cout << "시용자 나이를 입력하시오 : ";
    cin >> age;
    cout << endl;
    cout << name << "님은 " << age << "세 입니다.";
    return 0;
}
