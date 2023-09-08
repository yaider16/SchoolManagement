package co.edu.uptc.model;

public class Subject {
    private final int code;
    private final String name;
    private final int credCant;
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
