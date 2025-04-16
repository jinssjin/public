#include <iostream>
#include <stack>
using namespace std;

int main()
{
    stack<int> s;
    // LIFO (Lsat In First Out)
    // 스택에 값을 넣기(push)
    s.push(10);
    s.push(20);
    s.push(30);
    cout << "현재 스택의 맨 위 값 : " << s.top() << endl; // 줄바꿈

    // 스택에서 값 꺼내기
    s.pop();  // 맨 위 값을 꺼냄
    cout << "현재 스택의 맨 위 값 : " << s.top() << endl;

    if(!s.empty()){
        cout << "스택은 비어있지 않습니다" << endl;
    }

    cout << "현재 스택의 크기 : " << s.size() << endl;

    // 전체 스택 비우기
    while(!s.empty()){
        cout << "스택에서 꺼낸 값 : " << s.top() << endl;
        s.pop();
    }

    // push() : 값 넣기
    // pop() : 값 꺼내기
    // top() : 맨 위에 있는 값
    // empty() : 비어있는 지 확인

    return 0;
}
