#include <stdio.h>

int main()
{
  // Create a string
  char firstName[30];

  // Ask the user to input some text (name)
  printf("Enter your first name and press enter: \n");

  // Get and save the text
  scanf("%s", firstName);  // 배열이름은 배열자체가 주소이므로 & 이 필요없음

  // Output the text
  printf("Hello %s", firstName);
  
  return 0;
}