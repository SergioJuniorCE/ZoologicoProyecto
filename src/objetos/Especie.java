package objetos;

import org.bson.codecs.pojo.annotations.BsonId;
import org.bson.codecs.pojo.annotations.BsonProperty;
import org.bson.types.ObjectId;
import java.util.ArrayList;
import java.util.Objects;

public class Especie {

    @BsonProperty("_id")
    @BsonId
    private ObjectId id;
    private String nombre;
    private String nombreCientifico;
    private String descripcion;
//  private ArrayList<Habitat> habitats;
    private String habitat;

    public Especie(String nombre, String nombreCientifico, String descripcion, String habitat) {
        this.nombre = nombre;
        this.nombreCientifico = nombreCientifico;
        this.descripcion = descripcion;
        this.habitat = habitat;
    }

    public Especie() {
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

    public String getNombreCientifico() {
        return nombreCientifico;
    }

    public void setNombreCientifico(String nombreCientifico) {
        this.nombreCientifico = nombreCientifico;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getHabitat() {
        return habitat;
    }

    public void setHabitat(String habitat) {
        this.habitat = habitat;
    }

//    public ArrayList<Habitat> getHabitats() {
//        return habitats;
//    }
//
//    public void setHabitats(ArrayList<Habitat> habitats) {
//        this.habitats = habitats;
//    }
    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Especie)) {
            return false;
        }
        Especie other = (Especie) object;
        return (this.id != null || other.id == null) && (this.id == null || this.id.equals(other.id));
    }

    @Override
    public String toString() {
        return "Especie{" + "nombre=" + nombre + ", nombreCientifico=" + nombreCientifico + ", descripcion=" + descripcion + ", habitats=" + habitat + '}';
    }

}
