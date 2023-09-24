package hiber.model;

import javax.persistence.*;

@Entity
@Table (name = "car")
public class Car {
    @Column(name = "model")
    String model;

    @Id
    @Column(name = "series")
    private int series;

    public Car () {
    }

    public Car (String model, int series) {
        this.model = model;
        this.series = series;
    }

    public String getModel() {
        return model;
    }

    public int getSeries() {
        return series;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setSeries(int series) {
        this.series = series;
    }

    @Override
    public String toString() {
        return "Car{" +
                "model='" + model + '\'' +
                ", series=" + series +
                '}';
    }
}
