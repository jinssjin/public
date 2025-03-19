package a0319;

public class Ex01 {
    public static void main(String[] args) {
        
        int[] people = {559,51,46,43,27};
        String[] area = {"서울","부산","인천","대전","대구"};

        for(int i=0; i<people.length; i++){
        System.out.printf("%s: %d명\n",area[i],people[i]);
    }
    }
}
