package a0318;

public class Ex04 {
    public static void main(String[] args) {
        // double l = 8.86;
        // double km = 182.736;

        // double y = yun(l);
                
        //     }
        
        //     private static double yun(double km) {
        //         double yonby = km/l;

        //     }

        // 가솔린의 사용량
        double gasoline = 8.86;
        // 이동 거리
        double distance = 182.736;
        // 연비 계산
        double eff = calc(gasoline,distance);
                System.out.printf("연비: %.2f km/L",eff);
        }
        
            public static double calc(double gasoline, double distance) {
                return distance / gasoline;

            }
        }

        // calc : 메소드 이름
        // double gasoline, double distance : 매개변수, 입력변수, 파라미터
        // return distance / gasoline; : 반환값
        // double : 반환 타입