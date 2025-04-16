#include <iostream>
#include <deque>
using namespace std;

int main()
{
    deque<int> dq;


    dq.push_back(10);  // 뒤에 추가
    dq.push_back(20);  // 뒤에 추가
    dq.push_front(5);  // 앞에 추가
    cout << "앞쪽 값 : " << dq.front() << endl; // 5 출력
    cout << "뒤쪽 값 : " << dq.back() << endl; // 20 출력

    // 데이터 제거
    dq.pop_front(); // 5 제거 (앞 데이터 제거)
    dq.pop_back();  // 20 제거 (뒤 데이터 제거)
    cout << "삭제 후 앞쪽 값 : " << dq.front() << endl; // 10 출력

    dq.push_back(30);
    dq.push_front(1);

    cout << "현재 데큐 요소들 : ";
    for(int num : dq){
        cout << num << " ";
    }
    cout << endl;

    // push_back() : 뒤에 삽입
    // push_front() : 앞에 삽입
    // pop_back() : 뒤에서 꺼내기
    // pop_front() : 앞에서 꺼내기
    // front() : 앞쪽 요소 확인
    // back() : 뒤쪽 요소 확인
    // size() : 크기 확인
    // empty() : 비어있는 지 확인

    return 0;
}
