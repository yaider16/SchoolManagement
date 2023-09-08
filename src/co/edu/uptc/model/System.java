package co.edu.uptc.model;

public class System {
    public Student[] students;

    public System(int cantStudents){
        students= new Student[cantStudents];
        filler();
    }

    public void filler(){
        for (int i = 0; i < students.length; i++) {
            students[i] = new Student();
        }
    }
}
