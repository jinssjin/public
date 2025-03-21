package a0321.Acoount1;

public class Student {
    
    private String name;
    private int StudentId;
    private int kor, math, eng;
    
    public void setName(String name) {
        this.name = name;
    }
    public void setStudentId(int studentId) {
        StudentId = studentId;
    }
    public void setKor(int kor) {
        this.kor = kor;
    }
    public void setMath(int math) {
        this.math = math;
    }
    public void setEng(int eng) {
        this.eng = eng;
    }
    public Student(String name, int studentId, int kor, int math, int eng) {
        this.name = name;
        StudentId = studentId;
        this.kor = kor;
        this.math = math;
        this.eng = eng;
    }
    public String getName() {
        return name;
    }
    public int getStudentId() {
        return StudentId;
    }
    public int getKor() {
        return kor;
    }
    public int getMath() {
        return math;
    }
    public int getEng() {
        return eng;
    }
    public double getAverage() {
        double result = (kor+math+eng) / (double)3;
        return result;
    }

    public Student(){
        
    }

    
    

    }


