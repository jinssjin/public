package a0402.calendar;

import java.util.Calendar;

public class Calendar2 {
    public static void main(String[] args) {
        Calendar startDate = Calendar.getInstance();
        startDate.set(2025, Calendar.JANUARY,1);

        Calendar endDate = Calendar.getInstance();
        endDate.set(2025,Calendar.DECEMBER,31);

        // getTimeInMillis() 1970.1.1 부터 지정한 시간까지를 1/1000초 계산
        long starMillis = startDate.getTimeInMillis();
        System.out.println(starMillis);
        long endMillis = endDate.getTimeInMillis();
        System.out.println(endMillis);

        long diff = endMillis - starMillis;
        long diffDays = diff / (24*60*60*1000);
        System.out.println("두 날짜의 차이는 "+diffDays+"일 입니다.");
    }
    
}
