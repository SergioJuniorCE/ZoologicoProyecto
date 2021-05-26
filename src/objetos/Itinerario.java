package objetos;

import java.util.Date;
import org.bson.codecs.pojo.annotations.BsonId;
import org.bson.codecs.pojo.annotations.BsonProperty;
import org.bson.types.ObjectId;

public class Itinerario {

    @BsonProperty("_id")
    @BsonId
    private ObjectId id;
    private int duracionMin;
    private int longitud;
    private int numeroVisitantes;
    private int numeroEspecies;
    private Date fecha;

    public Itinerario(int duracionMin, int longitud, int numeroVisitantes, int numeroEspecies, Date fecha) {
        this.duracionMin = duracionMin;
        this.longitud = longitud;
        this.numeroVisitantes = numeroVisitantes;
        this.numeroEspecies = numeroEspecies;
        this.fecha = fecha;
    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public int getDuracionMin() {
        return duracionMin;
    }

    public void setDuracionMin(int duracionMin) {
        this.duracionMin = duracionMin;
    }

    public int getLongitud() {
        return longitud;
    }

    public void setLongitud(int longitud) {
        this.longitud = longitud;
    }

    public int getNumeroVisitantes() {
        return numeroVisitantes;
    }

    public void setNumeroVisitantes(int numeroVisitantes) {
        this.numeroVisitantes = numeroVisitantes;
    }

    public int getNumeroEspecies() {
        return numeroEspecies;
    }

    public void setNumeroEspecies(int numeroEspecies) {
        this.numeroEspecies = numeroEspecies;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
    
    

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 23 * hash + this.duracionMin;
        hash = 23 * hash + this.longitud;
        hash = 23 * hash + this.numeroVisitantes;
        hash = 23 * hash + this.numeroEspecies;
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
        final Itinerario other = (Itinerario) obj;
        if (this.duracionMin != other.duracionMin) {
            return false;
        }
        if (this.longitud != other.longitud) {
            return false;
        }
        if (this.numeroVisitantes != other.numeroVisitantes) {
            return false;
        }
        if (this.numeroEspecies != other.numeroEspecies) {
            return false;   
        }
        if (this.fecha != other.fecha) {
            return false;   
        }
        return true;
    }

    @Override
    public String toString() {
        return "Itinerario{" + "id=" + id + ", duracionMin=" + duracionMin + ", longitud=" + longitud + ", numeroVisitantes=" + numeroVisitantes + ", numeroEspecies=" + numeroEspecies + ", fecha=" + fecha + '}';
    }

}
