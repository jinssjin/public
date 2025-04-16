#include <stdio.h>

int main()
{
    int a, b, c;

    scanf("%d%d%d",&a,&b,&c);
    int result;
    if(a>b && a>c){
        result = a;
    }else if(a>b && a<c){
        result = c;
    }else if(b>a && b>c){
        result = b;
    };
    printf("%d",result);
    



    int max = a;
    if(b > max){
       max = b;
    };
    if(c > max){
        max = c;
     };
    printf("가장 큰 수는 %d 입니다.\n",max);

     return 0;
}

