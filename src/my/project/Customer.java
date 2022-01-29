package my.project;

/**
 * This class is responsible for creating a client.
 */
public class Customer {
    private String name;
    private String lastname;
    private int age;
    private String gender;
    private License license;

    public Customer(String name, String lastname, int age, String gender, License license) {
        this.name = name;
        this.lastname = lastname;
        this.age = age;
        this.gender = gender;
        this.license = license;
    }

    public String getName() {
        return this.name;
    }


    public String getLastname() {
        return this.lastname;
    }


    public int getAge() {
        return this.age;
    }


    public String getGender() {
        return this.gender;
    }


    public License getLicense() {
        return this.license;
    }


}
