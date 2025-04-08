#include <stdio.h>

int main(){

    int myNumbers[] = {25,50,75,100};
    myNumbers[0] = 33;
    for(int i=0; i < 4; i++){
        printf("%d\n",myNumbers[i]);
    }

    return 0;
}
