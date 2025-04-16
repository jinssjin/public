#include <iostream>
#include <set>
using namespace std;

int main()
{
    set<int> mySet;

    // 값을 추가(중복 불가)
    mySet.insert(50);
    mySet.insert(20);
    mySet.insert(30);
    mySet.insert(20);  // 중복된 값 -> 무시됨

    cout << "Set 안의 값들: ";
    for( int num : mySet){
        cout << num << " ";
    }
    cout << endl;

// 값 찾기
    if(mySet.find(30) != mySet.end()){
        cout << "30을 찾았습니다." << endl;
    }else{
        cout << "30이 없습니다." << endl;
    }

// 값 삭제
    mySet.erase(20);
    cout << "20삭제 후 값들: ";
    for(int num : mySet){
        cout << num << " ";
    }
    cout << endl;


    // insert() : 원소 삽입(중복 불허)
    // find() : 찾기 (반환값 == end() 이면 없음)
    // erase() : 특정원소 삭제
    // size() : 크기
    // empty() : 비어있는지 확인
    // clear() : 모두삭제
    
    return 0;
}
