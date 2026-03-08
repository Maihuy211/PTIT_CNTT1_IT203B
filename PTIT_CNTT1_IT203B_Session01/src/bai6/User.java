package bai6;

public class User {

    private String name;

    public User(String name){
        if(name == null || name.trim().isEmpty()){
            throw new IllegalArgumentException("Tên không được rỗng");
        }

        this.name = name;
    }
    public String getName(){
        return name;
    }
}