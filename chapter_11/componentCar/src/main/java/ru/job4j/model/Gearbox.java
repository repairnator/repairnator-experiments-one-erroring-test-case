package ru.job4j.model;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

/**
 * @author Hincu Andrei (andreih1981@gmail.com)on 12.03.2018.
 * @version $Id$.
 * @since 0.1.
 */
public class Gearbox {
    private static final Logger LOG = LogManager.getLogger(Gearbox.class);
    private int id;
    private String type;
    private Car car;

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public Gearbox() {
    }

    public Gearbox(String type) {
        this.type = type;
    }

    public int getId() {

        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Gearbox(int id) {

        this.id = id;
    }

    @Override
    public String toString() {
        return "Gearbox{"
                + "id="
                + id
                + ", type='"
                + type
                + '\''
                + ", car="
                + car
                + '}';
    }
}
