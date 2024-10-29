package Model;

public class TestedPerson {
    private Integer dni;
    private Double temp;

    public TestedPerson(Integer dni, Double temp) {
        this.dni = dni;
        this.temp = temp;
    }

    public Integer getDni() {
        return dni;
    }

    public void setDni(Integer dni) {
        this.dni = dni;
    }

    public Double getTemp() {
        return temp;
    }

    public void setTemp(Double temp) {
        this.temp = temp;
    }

    @Override
    public String toString() {
        return "TestedPerson{" +
                "dni=" + dni +
                ", temp=" + temp +
                '}';
    }
}
