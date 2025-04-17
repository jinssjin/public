#include <iostream>
#include <string>
using namespace std;

/*
3. 생성자와 소멸자
Student클래스를 만들고, 생성자에서 이름과 학번을 초기화하며, 소멸자에서는 "객체가 삭제되었습니다"를 출력하게 하시오.
*/

class Student{
    public:
    string name="john";
    int studentId=20250417;

    Student(string a, int b){
        name = a;
        studentId = b;
    }
};

~class Student{
    public:
    cout << "객체가 소멸되었습니다.";
};

int main()
{
      
    return 0;
}
