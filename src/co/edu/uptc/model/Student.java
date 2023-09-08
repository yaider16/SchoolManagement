package co.edu.uptc.model;

public class Student {
    private String name;
    private int code;
    private String lastName;
    private Boolean isCondicionated;

    public String getName() {
        return name;
    }

    public int getCode() {
        return code;
    }

    public Boolean getCondicionated() {
        return isCondicionated;
    }

    public void setCondicionated(Boolean condicionated) {
        isCondicionated = condicionated;
    }

    public Student(String name, String lastName, int code){
        this.name = name;
        this.lastName = lastName;
        this.code = code;
    }
    public Student(){}
}
