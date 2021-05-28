package objetos;

import java.time.LocalDateTime;
import org.bson.codecs.pojo.annotations.BsonId;
import org.bson.codecs.pojo.annotations.BsonProperty;
import org.bson.types.ObjectId;

public class Empleado {

    @BsonProperty("_id")
    @BsonId
    private ObjectId id;
    private String nombre;
    private String telefono;
    private LocalDateTime fechaInicio;

    public Empleado(String nombre, String telefono, LocalDateTime fechaInicio) {
        this.nombre = nombre;
        this.telefono = telefono;
        this.fechaInicio = fechaInicio;
    }

    public Empleado(String nombre) {
        this.nombre = nombre;
    }

    public Empleado() {
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

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public LocalDateTime getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDateTime fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Empleado)) {
            return false;
        }
        Empleado other = (Empleado) object;
        return (this.id != null || other.id == null) && (this.id == null || this.id.equals(other.id));
    }

    @Override
    public String toString() {
        return "Empleado{" + "nombre=" + nombre + ", telefono=" + telefono + ", fechaInicio=" + fechaInicio + '}';
    }

}
