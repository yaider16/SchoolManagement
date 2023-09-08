package Presenter;
import View.View;
import co.edu.uptc.model.Subject;
import co.edu.uptc.model.Systems;

public class Presenter {
    final View view = new View();
    Systems system;
    public static void main(String[] args) {
        Presenter presenter = new Presenter();
        presenter.menu();
    }

    public void menu(){
        String option;
        int cantStudents = Integer.parseInt(view.askInfo("Ingrese la cantidad de estudiantes"));
        if (cantStudents < 0){
            view.showMessage("No se puede ingresar una cantidad negativa");
            System.exit(0);
        }
        system = new Systems(cantStudents);
        do {
            option = view.askVariousInfo("Seleccione una opción", new String[]{"Registrar estudiante","Mirar estudiantes","Verificar inscripcion", "Registrar nota definitiva", "Calcular promedio", "Verificacion de estado", "Salir"});
            switch (option) {
                case "Registrar estudiante"-> registerStudent();
                case "Verificar inscripcion"-> verifyInscription();
                case "Registrar nota definitiva"-> registerFinalNote();
                case "Calcular promedio"-> average();
                case "Verificacion de estado" -> verifyCondition();
                case "Mirar estudiantes" -> showStudents();
                case "Salir" -> System.exit(0);
                default -> view.showMessage("Opción no válida");
            }
        }while (true);
    }

    private void showStudents() {
        int count = 0;
        for (int i = 0; i < system.students.length; i++) {
            if (system.students[i].getCode() == 0) {
                count++;
            }
        }
        if(count == system.students.length){
            view.showMessage("No hay estudiantes registrados");
            return;
        }
        for (int i = 0; i < system.students.length; i++) {
            if (system.students[i].getCode() != 0) {
                view.showMessage("Nombre: " + system.students[i].getName() + "\nApellido: " + system.students[i].getLastName() + "\nCódigo: " + system.students[i].getCode());
            }
        }
    }
    public void registerStudent(){
        String name = view.askInfo("Ingrese el nombre del estudiante");
        String lastName = view.askInfo("Ingrese el apellido del estudiante");
        int code = Integer.parseInt(view.askInfo("Ingrese el código del estudiante"));
        system.registerStudent(name, lastName, code);
        registerSubject(code);
        view.showMessage("Estudiante registrado junto con sus materias");
    }
    public void registerSubject(int verifyer){
        system.registerSubjects(verifyer);
    }
    public void verifyInscription(){
        int verifyer = Integer.parseInt(view.askInfo("Ingrese el código del estudiante"));
        int registered = system.verifyInscription(verifyer);
        if (registered != -1){
            view.showMessage("El estudiante está inscrito en todas las materias");
        }else{
            view.showMessage("El estudiante no existe");
        }
    }
    private void registerFinalNote() {
        int verifyer = Integer.parseInt(view.askInfo("Ingrese el código del estudiante"));
        if (!system.searchStudent(verifyer)){
            view.showMessage("El estudiante no existe");
        }else{
            String[] subjects = {"Matematicas", "Ingles", "Programacion", "Fisica"};
            for (int i = 0; i < subjects.length; i++) {
                system.registerFinalNote(verifyer, view.askInfo("Ingrese la nota de " + subjects[i]));
            }
        }
    }
    private void average() {
        int verifyer = Integer.parseInt(view.askInfo("Ingrese el código del estudiante"));
        if (!system.searchStudent(verifyer)){
            view.showMessage("El estudiante no existe");
        }else{
            if(system.average(verifyer) == -1){
                view.showMessage("El estudiante no tiene notas registradas");
            }else{
                view.showMessage("El promedio del estudiante es: " + system.average(verifyer));
            }

        }
    }
    private void verifyCondition() {
        int verifyer = Integer.parseInt(view.askInfo("Ingrese el código del estudiante"));
        if(system.verifyCondition(verifyer) < 3.0 && system.verifyCondition(verifyer) != -1){
            view.showMessage("El estudiante está condicionado");
        }else if(system.verifyCondition(verifyer) >= 3.0){
            view.showMessage("El estudiante no está condicionado");
        }else if(system.verifyCondition(verifyer) == -1){
            view.showMessage("El estudiante no tiene notas registradas o no existe");
        }
    }


}
