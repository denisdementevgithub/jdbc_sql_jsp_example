package entity;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

public class Person {
    private String name;
    private Gender gender;
    private Date birthDate;

    private Person(String name, Gender gender, Date birthDate) {
        this.name = name;
        this.gender = gender;
        this.birthDate = birthDate;
    }

    public static Person createMale(String name, Date birthDate) { return new Person(name, Gender.MALE, birthDate); }

    public static Person createFemale(String name, Date birthDate) { return new Person(name, Gender.FEMALE, birthDate); }

    public String getName() {        return name;    }

    public void setName(String name) {        this.name = name;    }

    public Gender getGender() {return gender;    }

    public void setGender(Gender gender) {this.gender = this.gender;    }

    public Date getBirthDate() {        return birthDate;    }

    public void setBirthDate(Date birthDate) {        this.birthDate = birthDate;    }

    @Override
    public String toString() {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        return "Person{" +
                "name='" + name + '\'' +
                ", gender=" + gender +
                ", birthDate=" + format.format(birthDate) +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return name.equals(person.name) && gender == person.gender && birthDate.equals(person.birthDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, gender, birthDate);
    }
}
