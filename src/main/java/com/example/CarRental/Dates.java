package com.example.CarRental;

import java.util.Objects;

public class Dates {

    String debut;
    String fin;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dates dates = (Dates) o;
        return debut.equals(dates.debut) &&
                fin.equals(dates.fin);
    }

    @Override
    public int hashCode() {
        return Objects.hash(debut, fin);
    }

    public String getDebut() {
        return debut;
    }

    public void setDebut(String debut) {
        this.debut = debut;
    }

    public String getFin() {
        return fin;
    }

    public void setFin(String fin) {
        this.fin = fin;
    }
}
