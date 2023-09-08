package co.edu.uptc.model;

public class Student {
    private String name;
    private int code;
    private String lastName;
    Subject[] subjects;

    public Student() {

    }

    public String getName() {
        return name;
    }

    public int getCode() {
        return code;
    }

    public Student(String name, String lastName, int code){
        this.name = name;
        this.lastName = lastName;
        this.code = code;
        subjects = new Subject[4];
        filler();
    }

    public void filler(){
        subjects[0] = new Subject(1, "Matematicas", 4);
        subjects[1] = new Subject(2, "Ingles", 2);
        subjects[2] = new Subject(3, "Programacion", 6);
        subjects[3] = new Subject(4, "Fisica", 2);
    }

    public String getLastName() {
        return lastName;
    }
}
