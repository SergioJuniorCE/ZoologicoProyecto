package objetos;

import java.util.ArrayList;
import java.util.Objects;

public class Habitat {

    private String nombre;
    private String clima;
    private String tipoVegetacion;
    private ArrayList<String> continentes;

    public Habitat(String nombre, String clima, String tipoVegetacion, ArrayList<String> continentes) {
        this.nombre = nombre;
        this.clima = clima;
        this.tipoVegetacion = tipoVegetacion;
        this.continentes = continentes;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getClima() {
        return clima;
    }

    public void setClima(String clima) {
        this.clima = clima;
    }

    public String getTipoVegetacion() {
        return tipoVegetacion;
    }

    public void setTipoVegetacion(String tipoVegetacion) {
        this.tipoVegetacion = tipoVegetacion;
    }

    public ArrayList<String> getContinentes() {
        return continentes;
    }

    public void setContinentes(ArrayList<String> continentes) {
        this.continentes = continentes;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 71 * hash + Objects.hashCode(this.nombre);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Habitat other = (Habitat) obj;
        return Objects.equals(this.nombre, other.nombre);
    }

    @Override
    public String toString() {
        return "Habitat{" + "nombre=" + nombre + ", clima=" + clima + ", tipoVegetacion=" + tipoVegetacion + ", continentes=" + continentes + '}';
    }

    
}
