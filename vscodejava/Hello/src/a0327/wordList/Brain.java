package a0327.wordList;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Brain implements Interface {
    static HashMap<String,String> word = new HashMap<>();
    public Brain(){
        word.put("peach","복숭아");
        word.put("Plum","자두");
        word.put("Pomegrante","석류");
        word.put("persimmon","감");
    }

    @Override
    public void Menu() {
        System.out.println("---- 선택 해주세요. ----");
        System.out.println(" 1. 단어 등록 ");
        System.out.println(" 2. 단어 조회 ");
        System.out.println(" 3. 단어 삭제 ");
        System.out.println(" 4. 테스트 ");
        System.out.println(" 5. 단어 목록보기");
        System.out.println(" 6. 종료 ");
        System.out.println("-----------------------");
    }

    @Override
    public void Addword() {
        String Eng = null;
        String Kor = null;
        while (true) {
            Scanner sc = new Scanner(System.in);
            System.out.print("등록할 영단어를 입력하세요.(목록에서 돌아가려면 Menu입력) : ");
            Eng = sc.nextLine();
            if(Eng.equals("Menu")|| Eng.equals("menu")){
                break;
            }else{
                if(word.containsKey(Eng) == true){
                    System.out.println("이미 입력된 단어 입니다. 수정을 원하시면 삭제 후 다시 입력");
                }else{
                    System.out.print("뜻을 입력해 주세요 : ");
                    Kor = sc.nextLine();

                    try {
                        word.put(Eng,Kor);
                    } catch (Exception e) {
                        System.out.println("다시 입력해주세요");
                        e.printStackTrace();
                    }finally{
                        System.out.println(" 입력 되었습니다.");
                    }
                    
                }
            }
            
        }
    }

    @Override
    public void WordSearch() {
        while (true) {
            Scanner sc = new Scanner(System.in);
            System.out.println("조회하고 싶은 영단어를 입력하세요. (목록으로 돌아가려면 Menu입력) : ");
            String Eng = sc.nextLine();
            if(Eng.equals("Menu")|| Eng.equals("menu")){
                break;
            }else{
                if(word.containsKey(Eng) == true){
                    System.out.println(word.get(Eng));  // key 해당하는 value(단어뜻)
                }else{
                    System.out.print("등록되지 않은 단어입니다.");
                }
                
        }
    }
}

    @Override
    public void DeleteWord() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("====단어목록====");
            if(word.isEmpty()){
                System.out.println("저장된 단어가 없어요");
            }else{
                // for(Map.Entry<String,String> entry:word.entrySet()){
                //     System.out.println("※     "+entry.getKey()+" : "+entry.getValue());
                for(String delword:word.keySet()){
                    System.out.println("※     "+delword+" : "+word.get(delword));
                }
                //}
            }
            System.out.println("===========================");
            System.out.print("삭제하고 싶은 단어를 입력하세요 (목록으로 돌아가려면 'Menu'입력) : ");
            String del = sc.nextLine().trim();  // 입력값 앞뒤 공백제거
            if(del.equalsIgnoreCase("menu")){
                System.out.println("메뉴로 돌아갑니다.");
                break;
        }
        if(word.containsKey(del)){
            System.out.println(" 입력한 단어 (" + del + " : " + word.remove(del) + ") 가 삭제되었습니다.");
        }else{
            System.out.println("존재하지 않는 단어입니다.");
        }
    }
    }

    @Override
    public void Test() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("1.시작하기");
            System.out.println("2.종료하기");
            System.out.print("번호를 입력하세요: ");
            if (!sc.hasNextInt()) {  // 숫자 입력이 아닌 경우 예외 처리
                System.out.println("숫자를 입력하세요.");
                sc.next();  // 잘못된 입력 제거
                continue;
            }
            
            int a = sc.nextInt();
            sc.nextLine(); // 입력 버퍼 문제 방지

            if(a == 1){
                int correctCount = 0;  // 정답을 맞춘 수 누적
                int totalCount = 0;  // 문제 수 누적
                System.out.println("====뜻에맞는 영단어 입력하세요====");
                for(Map.Entry<String,String> entry:word.entrySet()){
                    System.out.println(entry.getValue());
                    System.out.print("답 입력:");
                    String answer = sc.nextLine().trim();
                    if(answer.equalsIgnoreCase(entry.getKey())){
                        System.out.println("정답입니다.");
                        correctCount++;
                    }else{
                        System.out.println("틀림 (정답 :"+entry.getKey()+")\n");
                    }
                    totalCount++;
            }
            System.out.println("결과 : "+correctCount+"/"+totalCount+"\n");
            break;
        }else if(a == 2){
            System.out.println("프로그램을 종료합니다.");
            break;
        }else{
            System.out.println("1 또는 2를 입력해 주세요");
        }
        
    }
}

    @Override
    public void WordList() {
        System.out.println("==== 단어 목록 =====");
        if(word.isEmpty()){
            System.out.println("저장된 단어가 없어요");
        }else{
            for(Map.Entry<String, String> entry : word.entrySet()){
                System.out.println("※   "+  entry.getKey() + " : " + entry.getValue());
        }
        System.out.println("================");
    }
}

    @Override
    public void Exit() {
    }
    
}
