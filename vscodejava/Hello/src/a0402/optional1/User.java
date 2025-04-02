package a0402.optional1;

public class User {
    
    private Long id;
    private String name;
    
    public User(Long id, String name) {
        this.id = id;
        this.name = name;
    }
    public Long getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    @Override
    public String toString() {
        // 출력할때 printf와 같이 출력하겠다.
        return String.format("User{id=%d, name='%s'}",id,name);
    }
}
