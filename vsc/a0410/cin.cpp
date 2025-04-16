#include <iostream>
using namespace std;


// 왜 쓰는 걸까?
// std::cout, std::endl, std::string, std::cin 등 std:: 붙이기 귀찮으니까 생략하려고!
// 코드 간결해지고 보기 좋아짐

int main()
{
    int x;
    cout << "type a number : ";  // terimnal 안에서 입력 받음
    cin >> x; // 숫자 입력  // 입력 받은 수를 변수 x에 저장
    cout << "your number is : " << x;  // 입력 받은 결과를 출력

    cout << "your number is : " << x << endl;

    // endl;  : 줄바꿈 + 버퍼 flush (출력 강제 전송
    cout << "your number is : " << x << "\n";
    return 0;
}


// 