package objetos;

import org.bson.codecs.pojo.annotations.BsonId;
import org.bson.codecs.pojo.annotations.BsonProperty;
import org.bson.types.ObjectId;

import java.util.Date;
import java.util.Objects;

public class Guia extends Empleado {

    @BsonProperty("_id")
    @BsonId
    private ObjectId id;
    private Itinerario itinerario;

    public Guia(Itinerario itinerario, String nombre, String telefono, Date fechaInicio) {
        super(nombre, telefono, fechaInicio);
        this.itinerario = itinerario;
    }
    
    public Itinerario getItinerario() {
        return itinerario;
    }

    public void setItinerario(Itinerario itinerario) {
        this.itinerario = itinerario;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + Objects.hashCode(this.itinerario);
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
        final Guia other = (Guia) obj;
        return Objects.equals(this.itinerario, other.itinerario);
    }

    @Override
    public String toString() {
        return "Guia{" + "itinerario=" + itinerario + '}';
    }

}
