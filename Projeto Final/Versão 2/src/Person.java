public class Person {

    protected String name;
    protected String phone_number;
    protected String birth_date;
    protected String registration_date;
    protected String last_update_date;

    Person(String name, String phone_number, String birth_date, String registration_date, String last_update_date) {

        this.name = name;
        this.phone_number = phone_number;
        this.birth_date = birth_date;
        this.registration_date = registration_date;
        this.last_update_date = last_update_date;

    }

    public void setName(String name) {

        this.name = name;

    }

    public void setPhoneNumber(String phone_number) {

        this.phone_number = phone_number;

    }

    public void setBirthDate(String birth_date) {

        this.birth_date = birth_date;

    }

    public void setRegistrationDate(String registration_date) {

        this.registration_date = registration_date;

    }

    public void setLastUpdateDate(String last_update_date) {

        this.last_update_date = last_update_date;

    }

    public String getName() {

        return this.name;

    }

    public String getPhoneNumber() {

        return this.phone_number;

    }

    public String getBirthDate() {

        return this.birth_date;

    }

    public String getRegistrationDate() {

        return this.registration_date;

    }

    public String getLastUpdateDate() {

        return this.last_update_date;

    }

    public String toString() {

        String information = "Nome: " + this.name + "\n" +
                             "Número de telefone: " + this.phone_number + "\n" +
                             "Data de nascimento: " + this.birth_date + "\n" +
                             "Data de cadastro: " + this.registration_date + "\n" +
                             "Última data de alteração: " + this.last_update_date;                                    
        return information;
        
    }

}