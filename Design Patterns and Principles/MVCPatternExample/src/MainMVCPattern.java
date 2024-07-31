public class MainMVCPattern {
    public static void main(String[] args) {
        Student model = new Student("Jeyakumar", "5008540", "A+");

        StudentView view = new StudentView();

        StudentController controller = new StudentController(model, view);

        controller.updateView();

        controller.updateStudentDetails();

        controller.updateView();
    }
}
