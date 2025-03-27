package a0327.hashmap;

import java.util.HashMap;
import java.util.Scanner;

public class Donggihwa {
    public static void main(String[] args) {
        HashMap<Integer,String> acceptance = new HashMap<Integer,String>();
        acceptance.put(20250001, "합격");
        acceptance.put(20240004, "합격");
        acceptance.put(20230007, "불합격");
        acceptance.put(20250002, "불합격");

        Scanner scan = new Scanner(System.in);

        while (true) {
            System.out.println("수험번호를 입력하세요");
            System.out.print("응시 수험번호 : ");
            int num = scan.nextInt();
            scan.nextLine();

            if(!acceptance.containsKey(num)){
                System.out.println("유효하지 않은 수험번호 입니다. 다시 입력해주세요");
                continue;
            }else{
                System.out.println(acceptance.get(num));
                break;
            }
        }
    }
    
}
