package co.edu.uptc.model;

public class Systems {
    public Student[] students;


    public Systems(int cantStudents){
        students= new Student[cantStudents];
        filler();
    }
    public void filler(){
        for (int i = 0; i < students.length; i++) {
            students[i] = new Student();
        }
    }

    public Boolean searchStudent(int studentCode){
        for (int i = 0; i < students.length; i++) {
            if (students[i].getCode() == studentCode){
                return true;
            }
        }
        return false;
    }
    public void registerStudent(String studentName, String studentLastName, int studentCode) {
        for (int i = 0; i < students.length; i++) {
            if (students[i].getCode() == 0){
                students[i] = new Student(studentName, studentLastName, studentCode);
                break;
            }
        }
    }

    public void registerSubjects(int studentCode) {
        if (searchStudent(studentCode)){
            for (int i = 0; i < students.length; i++) {
                if (students[i].getCode() == studentCode){
                    for (int j = 0; j < students[i].subjects.length; j++) {
                        students[i].subjects[j].setFinalNote(-1);
                    }
                }
            }
        }
    }

    public int verifyInscription(int studentCode) {
        if (searchStudent(studentCode)){
            for (int i = 0; i < students.length; i++) {
                if (students[i].getCode() == studentCode){
                    for (int j = 0; j < students[i].subjects.length; j++) {
                        if (students[i].subjects[j].getFinalNote() == -1){
                            return j;
                        }
                    }
                }
            }
        }
        return -1;
    }

    public void registerFinalNote(int studentCode, String note) {
        if (searchStudent(studentCode)){
            for (Student student : students) {
                if (student.getCode() == studentCode) {
                    for (int j = 0; j < student.subjects.length; j++) {
                        student.subjects[j].setFinalNote(Float.parseFloat(note));
                    }
                }
            }
        }
    }

    public float verifyCondition(int studentCode) {
        return average(studentCode);
    }

    public float average(int studentCode) {
        for (int i = 0; i < students.length; i++) {
            if (students[i].getCode() == studentCode){
                float average = 0;
                for (int j = 0; j < students[i].subjects.length; j++) {
                    average += students[i].subjects[j].getFinalNote();
                }
                if(average<0){
                    return -1;
                }
                return average / students[i].subjects.length;
            }
        }
        return -1;
    }
}
