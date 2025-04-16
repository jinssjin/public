#include <iostream>
#include <queue>
using namespace std;

int main()
{
    queue<int> q;
    // FIFO (First In First Out)
    // 큐에 데이터 추가(push)
    q.push(10);
    q.push(20);
    q.push(30);
    cout << "현재 스택의 맨 앞 값 : " << q.front() << endl; // 10
    cout << "현재 스택의 맨 뒤 값 : " << q.back() << endl; // 30

    q.pop();
    cout << "값 하나를 꺼낸 후 현재 스택의 맨 앞 값 : " << q.front() << endl; // 20 (10을 꺼낸 후)

    cout << "현재 큐의 크기 : " << q.size() << endl;

    while(!q.empty()){
        cout << "큐에서 꺼낸 값 : " << q.front() << endl;
        q.pop();
    }

    // push() : 큐에 데이터 추가 (뒤쪽으로 삽입)
    // pop() : 큐에 데이터 제거 (앞쪽 요소 삭제)
    // front() : 맨 앞 요소 확인
    // back() : 맨 뒤 요소 확인
    // size() : 현재 큐 크기 확인
    // empty() : 큐가 비어있는 지 확인

    return 0;
}
