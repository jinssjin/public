#include <string>
#include <iostream>

// string은 C++ 표준 라이브러리 클래스
// <iostream>에선 기본 제공 안 하고, 따로 <string>을 include 해야함

using namespace std;



// 왜 쓰는 걸까?
// std::cout, std::endl, std::string, std::cin 등 std:: 붙이기 귀찮으니까 생략하려고!
// 코드 간결해지고 보기 좋아짐

int main()
{
    string line;
    cout << "type a full sentence : ";  // terimnal 안에서 입력 받음
    getline(cin,line); // 공백 포함 전체 문장을 입력
    cout << "You wrote : " << line;
    
    // 응용
    cout << "문장의 길이: " << line.length() << endl;

    
    return 0;
}


// cin 파일에서 cin >> x 에서 입력 받은 값에 공백이 있다면 공백 이전까지 읽지만
// getline()은 공백을 포함한 한 줄 전체를 읽는다


