package my.project;

public class Customer {
    private String name;
    private String lastname;
    private int age;
    private String gender;
    private Lizens lizens;

    public Customer(String name, String lastname, int age, String gender, Lizens lizens) {
        this.name = name;
        this.lastname = lastname;
        this.age = age;
        this.gender = gender;
        this.lizens = lizens;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return this.lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public int getAge() {
        return this.age;
    }

    public void setBirthDate(String birthDate) {
        this.age = this.age;
    }

    public String getGender() {
        return this.gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Lizens getLizens() {
        return this.lizens;
    }

    public void setLizens(Lizens lizens) {
        this.lizens = lizens;
    }
}
