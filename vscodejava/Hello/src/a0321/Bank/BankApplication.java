package a0321.Bank;

import java.util.Scanner;

import a0321.Acoount1.AcoountTest;

public class BankApplication {
    private static Account[] accountArray = new Account[100];
    // 모든 계좌정보를 저장 : 하나의 배열에 저장하므로 새로운 배열을 만들 필요가 없어 static을 쓴다.
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean run = true;

        while (run) {
            System.out.println("------------------------------------------------");
            System.out.println("1.계좌생성 | 2.계좌목록 | 3.예금 | 4.출금 | 5.계좌이체 | 6.종료");
            System.out.println("------------------------------------------------");
            System.out.print("선택>");
            int selectNo = Integer.parseInt(scanner.nextLine());
            if(selectNo == 1){
                creatAccount();
            }else if(selectNo == 2){
                accountList();
            }else if(selectNo == 3){
                deposit();
            }else if(selectNo == 4){
                withdraw();
            }else if(selectNo == 5){
                transfermoney();
            }else if(selectNo == 6){
                run = false;
            }
        }
        System.out.println("프로그램 종료");
    }
                
                            
                
            private static void creatAccount(){
                System.out.println("--------");
                System.out.println("계좌생성");
                System.out.println("--------");
                System.out.print("계좌번호: ");
                String ano1 = scanner.nextLine();
                System.out.print("계좌주: ");
                String owner1 = scanner.nextLine();
                System.out.print("초기입금액: ");
                int balance1 = Integer.parseInt(scanner.nextLine());

                Account newAccount = new Account(ano1, owner1, balance1);  // 키보드로 입력된 값을 생성자로 초기화
                    for(int i=0; i < accountArray.length; i++){
                        if(accountArray[i]==null){  // 중복되면 안되니까 i번 손님이 있는 배열에 저장하지않고 i+1에 있는 손님에 저장함 (비어있어야 저장함)
                            accountArray[i] = newAccount;
                            System.out.println("결과 : 계좌가 생성되었습니다.");
                            break;
                        }
                    }
                    // accountArray[0] = newAccount("110-110","gildong",10000)
                    // accountArray[1] = newAccount("110-111","sunja",20000)
            }

            private static void accountList() {
                System.out.println("--------");
                System.out.println("계좌조회");
                System.out.println("--------");
                    for(int i=0; i < accountArray.length; i++){
                        Account account = accountArray[i];
                        if(account != null){
                            System.out.print(account.getAno());
                            System.out.print("     ");
                            System.out.print(account.getOwner());
                            System.out.print("     ");
                            System.out.print(account.getBalance());
                            System.out.print("     ");
                            System.out.println();
                        }
                    }
            }

            private static void deposit(){
                System.out.println("--------");
                System.out.println("예금");
                System.out.println("--------");
                System.out.print("계좌번호: ");
                String ano1 = scanner.nextLine();
                System.out.print("예금액: ");
                int money = Integer.parseInt(scanner.nextLine());
                Account account = findAccount(ano1);
                if(account == null){
                    System.out.println("결과 : 계좌가 없습니다.");
                    return;
                }
                account.setBalance(account.getBalance() + money);
                // 현재의 계좌금액을 account.getBalance()로 불러와서 money예금을 더한 뒤 account.setBalance 더한 금액을 넣기
            }
            
            private static Account findAccount(String ano1) {
                        Account account = null;  // 비어있는 객체를 만든다. (반환되는 내용을 담아갈 객체)
                        for(int i = 0; i < accountArray.length; i++){
                            if(accountArray[i] !=null){  // accountArray[i] 배열 내용이 있으면
                                String dbAno = accountArray[i].getAno(); // 배열의 계좌번호를 가져와서
                            if(dbAno.equals(ano1)){  // 계좌를 비교해서
                                account = accountArray[i];  // 변수에 넣어주고
                                break;  // 빠져나감
                            }
                            }
                        }
                        return account;
            }

            private static void withdraw(){
                System.out.println("--------");
                System.out.println("출금");
                System.out.println("--------");
                System.out.print("계좌번호: ");
                String ano12 = scanner.nextLine();
                System.out.print("출금액: ");
                int money = Integer.parseInt(scanner.nextLine());
                Account account = findAccount(ano12);
                
                if(account.getBalance() < money){
                    System.out.println("결과 : 잔액이 부족합니다.");
                    return;
                }
                
                if(account == null){
                    System.out.println("결과 : 계좌가 없습니다.");
                    return;
                }

                account.setBalance(account.getBalance() - money);
                // 현재의 계좌금액을 account.getBalance()로 불러와서 money예금을 뺀 뒤 account.setBalance 뺀 금액을 넣기
            }

            private static void transfermoney(){
                System.out.println("--------");
                System.out.println("이체");
                System.out.println("--------");
                System.out.print("출금하실 계좌번호: ");
                String ano1 = scanner.nextLine();
                System.out.print("입금받으실 계좌번호: ");
                String ano2 = scanner.nextLine();
                System.out.print("입금액: ");
                int money = Integer.parseInt(scanner.nextLine());
                Account account1 = findAccount(ano1);
                Account account2 = findAccount(ano2);

                if(account1.getBalance() < money){
                    System.out.println("결과 : 잔액이 부족합니다.");
                    return;
                }

                if(account1 == null || account2 == null){
                    System.out.println("결과 : 계좌가 없습니다.");
                    return;
                }
                account1.setBalance(account1.getBalance() - money);
                account2.setBalance(account2.getBalance() + money);
}
}
