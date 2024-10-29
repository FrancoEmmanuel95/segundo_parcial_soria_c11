package Model;

import java.util.Objects;

public class Person {
    private String name;
    private String lastName;
    private Integer age;
    private String neighborhood;
    private Integer dni;

    public Person() {
    }

    public Person(String name, String lastName, Integer age, String neighborhood, Integer dni) {
        this.name = name;
        this.lastName = lastName;
        this.age = age;
        this.neighborhood = neighborhood;
        this.dni = dni;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getNeighborhood() {
        return neighborhood;
    }

    public void setNeighborhood(String neighborhood) {
        this.neighborhood = neighborhood;
    }

    public Integer getDni() {
        return dni;
    }

    public void setDni(Integer dni) {
        this.dni = dni;
    }


    @Override
    public String toString() {
        return "Persona{" +
                "nombre='" + name + '\'' +
                ", Apellido='" + lastName + '\'' +
                ", edad=" + age +
                ", barrio='" + neighborhood + '\'' +
                ", dni=" + dni +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(dni, person.dni);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dni);
    }
}
