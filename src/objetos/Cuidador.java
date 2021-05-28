package objetos;

import java.time.LocalDateTime;
import java.util.Objects;
import org.bson.codecs.pojo.annotations.BsonId;
import org.bson.codecs.pojo.annotations.BsonProperty;
import org.bson.types.ObjectId;

public class Cuidador extends Empleado {

    @BsonProperty("_id")
    @BsonId
    private ObjectId id;
    private String experto;
    private String basico;
    private LocalDateTime fechaCiudado;
    private String especieCuidada;

    public Cuidador(){}
    
    public Cuidador(ObjectId id, String experto, String basico, LocalDateTime fechaCiudado, String especieCuidada, String nombre) {
        super(nombre);
        this.id = id;
        this.experto = experto;
        this.basico = basico;
        this.fechaCiudado = fechaCiudado;
        this.especieCuidada = especieCuidada;
    }
    
    public Cuidador(ObjectId id, String experto, String basico, LocalDateTime fechaCiudado, String especieCuidada, String nombre, String telefono, LocalDateTime fechaInicio) {
        super(nombre, telefono, fechaInicio);
        this.id = id;
        this.experto = experto;
        this.basico = basico;
        this.fechaCiudado = fechaCiudado;
        this.especieCuidada = especieCuidada;
    }

    public Cuidador(String experto, String basico, LocalDateTime fechaCiudado, String especieCuidada, String nombre, String telefono, LocalDateTime fechaInicio) {
        super(nombre, telefono, fechaInicio);
        this.experto = experto;
        this.basico = basico;
        this.fechaCiudado = fechaCiudado;
        this.especieCuidada = especieCuidada;
    }
    
    

    @Override
    public ObjectId getId() {
        return id;
    }

    @Override
    public void setId(ObjectId id) {
        this.id = id;
    }

    public String getExpertos() {
        return experto;
    }

    public void setExpertos(String expertos) {
        this.experto = expertos;
    }

    public String getBasico() {
        return basico;
    }

    public void setBasico(String basicos) {
        this.basico = basicos;
    }

    public LocalDateTime getFechaCiudado() {
        return fechaCiudado;
    }

    public void setFechaCiudado(LocalDateTime fechaCiudado) {
        this.fechaCiudado = fechaCiudado;
    }

    public String getEspecieCuidada() {
        return especieCuidada;
    }

    public void setEspecieCuidada(String especieCuidada) {
        this.especieCuidada = especieCuidada;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Cuidador)) {
            return false;
        }
        Cuidador other = (Cuidador) object;
        return (this.id != null || other.id == null) && (this.id == null || this.id.equals(other.id));
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 31 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public String toString() {
        return "Cuidador{" + "expertos=" + experto + ", basicos=" + basico + ", fechaCiudado=" + fechaCiudado + ", especieCuidada=" + especieCuidada + '}';
    }

}
