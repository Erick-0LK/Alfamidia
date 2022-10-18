import java.text.DecimalFormat;

public class Student extends Person {

    private String final_grade;

    Student(String name, String phone_number, String birth_date, String registration_date, String last_update_date, String final_grade) {

        super(name, phone_number, birth_date, registration_date, last_update_date);
        this.final_grade = final_grade;

    }

    public void setFinalGrade(String final_grade) {

        this.final_grade = final_grade;

    }

    public String getFinalGrade() {

        return this.final_grade;
        
    }

    public String toString() {

        DecimalFormat decimal_format = new DecimalFormat("#.##");
        return super.toString() + "\nNota final do curso: " + decimal_format.format(Float.parseFloat(this.final_grade));

    }

}