#include <stdio.h>
#include <string.h>

struct Student{
    char name[20];
    int studentId;
    char grade;
};

int main()
{
    struct Student s;
    printf("이름을 입력하세요(최대20자): ");
    scanf("%s",s.name);  // 배열명 자체가 주소이므로 & 생략 가능
    printf("학번을 입력하세요: ");
    scanf("%d",&s.studentId);  // 입력 시 변수에 주소를 입력
    printf("학점을 입력하세요: ");
    scanf(" %c",&s.grade);  // 공백 문자를 처리하여 scanf 오류 방지

    printf("\n--- 학생정보 ---\n");
    printf("이름: %s\n", s.name);
    printf("학번: %d\n", s.studentId);
    printf("학점: %c\n", s.grade);
    
    return 0;
}
