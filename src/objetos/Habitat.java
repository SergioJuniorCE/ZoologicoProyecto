package objetos;

import org.bson.codecs.pojo.annotations.BsonId;
import org.bson.codecs.pojo.annotations.BsonProperty;
import org.bson.types.ObjectId;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

public class Habitat implements Serializable {

    @BsonProperty("_id")
    @BsonId
    private ObjectId id;
    private String nombre;
    private String clima;
    private String tipoVegetacion;
    private List<String> continentes;

    public Habitat(String nombre, String clima, String tipoVegetacion, List<String> continentes) {
        this.nombre = nombre;
        this.clima = clima;
        this.tipoVegetacion = tipoVegetacion;
        this.continentes = continentes;
    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
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

    public List<String> getContinentes() {
        return continentes;
    }

    public void setContinentes(List<String> continentes) {
        this.continentes = continentes;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Habitat)) {
            return false;
        }
        Habitat other = (Habitat) object;
        return (this.id != null || other.id == null) && (this.id == null || this.id.equals(other.id));
    }

    @Override
    public String toString() {
        return "Habitat{" + "nombre=" + nombre + ", clima=" + clima + ", tipoVegetacion=" + tipoVegetacion + ", continentes=" + continentes + '}';
    }


}
