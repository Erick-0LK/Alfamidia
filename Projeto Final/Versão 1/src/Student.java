public class Student extends Person {

    private String final_grade;

    Student(String name, String phone_number, String birth_date, String registration_date, String last_update_date, String final_grade) {

        super(name, phone_number, birth_date, registration_date, last_update_date);
        this.final_grade = final_grade;

    }

    public void setName(String name) {

        super.setName(name);

    }

    public void setPhoneNumber(String phone_number) {

        super.setPhoneNumber(phone_number);

    }

    public void setBirthDate(String birth_date) {

        super.setBirthDate(birth_date);

    }

    public void setRegistrationDate(String registration_date) {

        super.setRegistrationDate(registration_date);

    }

    public void setLastUpdateDate(String last_update_date) {

        super.setLastUpdateDate(last_update_date);

    }

    public void setFinalGrade(String final_grade) {

        this.final_grade = final_grade;

    }

    public String getName() {

        return super.getName();

    }

    public String getPhoneNumber() {

        return super.getPhoneNumber();

    }

    public String getBirthDate() {

        return super.getBirthDate();

    }

    public String getRegistrationDate() {

        return super.getRegistrationDate();

    }

    public String getLastUpdateDate() {

        return super.getLastUpdateDate();

    }

    public String getFinalGrade() {

        return this.final_grade;

    }

    @Override
    public String toString() {

        return super.toString() + ", " + this.final_grade;

    }

}