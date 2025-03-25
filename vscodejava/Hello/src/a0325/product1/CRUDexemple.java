package a0325.product1;

import java.util.Scanner;

public class CRUDexemple {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        ProductManager manager = new ProductManager();
        boolean running = true;
        // 새로운 제품 추가
        // manager.addProduct("Monitor", 300.0);

        while (running) {
            System.out.println("\n📌 제품 관리 시스템");
            System.out.println("1. 제품 추가");
            System.out.println("2. 제품 목록 보기");
            System.out.println("3. 제품 수정");
            System.out.println("4. 제품 삭제");
            System.out.println("5. 종료");
            System.out.print("선택 > ");
            int choice = scan.nextInt();
            scan.nextLine(); // 개행 문자 제거

            switch (choice) {
                case 1:
                    System.out.print("제품명 입력: ");
                    String name = scan.nextLine();
                    System.out.println("가격 입력");
                    double price = scan.nextDouble();
                    manager.addProduct(name,price); // name과 price를 추가할 것이다.
                    break;
                case 2:
                    manager.listProducts();
                break;
                case 3:  //제품 수정
                    System.out.println("수정할 제품 ID입력");
                    int idToUpdate = scan.nextInt();
                    scan.nextLine();
                    System.out.println("새로운 제품명");
                    String newName = scan.nextLine();
                    System.out.println("새로운 가격");
                    double newPrice = scan.nextDouble();
                    manager.updateProduct(idToUpdate,newName,newPrice);
                break;
                case 4:
                    System.out.println("삭제할 제품 ID입력");
                    int idTodelete = scan.nextInt();
                    scan.nextLine();
                    if(manager.deleteProduct(idTodelete)){
                        System.out.println("제품이 삭제되었습니다.");
                    }else{
                        System.out.println("해당 제품이 없습니다.");
                    }
                break;
                case 5: // 종료
                    System.out.println("🔚 프로그램을 종료합니다.");
                    running = false;
                    break;
                           
                default:
                    break;
            }
        }
    }   
}
