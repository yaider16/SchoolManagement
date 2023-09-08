package co.edu.uptc.model;

public class Subject {
    private int code;
    private String name;
    private int credCant;
    private float finalNote;

    public void setFinalNote (float finalNote){
        this.finalNote = finalNote;
    }

    public float getFinalNote (){
        return this.finalNote;
    }

    public Subject(int code, String name, int credCant){
        this.code = code;
        this.name = name;
        this.credCant = credCant;
    }
}
