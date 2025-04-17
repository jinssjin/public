#include <iostream>
#include <string>
using namespace std;

class Student {
public:
    string name;
    int studentId;

    // 생성자(Constructor): 객체 생성 시 호출되어 멤버 변수 초기화
    Student(string a, int b) : name(a), studentId(b) {
        cout << "학생 객체가 생성되었습니다." << endl;
    }

    // 소멸자(Destructor): 객체가 소멸될 때 호출되어 정리 작업 수행
    ~Student() {
        cout << "객체가 삭제되었습니다." << endl;
    }
};

int main() {
    Student student1("홍길동", 20250417);
    cout << "이름: " << student1.name << ", 학번: " << student1.studentId << endl;
    return 0;
}
