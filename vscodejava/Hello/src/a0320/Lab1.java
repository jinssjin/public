package a0320;

public class Lab1 {
    public static void main(String[] args) {
        Square area = new Square();
        
        
        area.areaResult();
    }
}


class Square{
    int length;
    int areaSquare;

    void areaResult(){
        areaSquare = length*length;
    }
}