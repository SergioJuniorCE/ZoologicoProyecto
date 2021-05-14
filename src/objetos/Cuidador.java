package objetos;

import java.util.ArrayList;
import java.util.Date;
import org.bson.codecs.pojo.annotations.BsonId;
import org.bson.codecs.pojo.annotations.BsonProperty;
import org.bson.types.ObjectId;

public class Cuidador extends Empleado {

    @BsonProperty("_id")
    @BsonId
    private ObjectId id;
    private ArrayList<Especie> expertos;
    private ArrayList<Especie> basicos;
    private Date fechaCiudado;
    private Especie especieCuidada;

    public Cuidador(ArrayList<Especie> expertos, ArrayList<Especie> basicos, Date fechaCiudado, Especie especieCuidada, String nombre, String telefono, Date fechaInicio) {
        super(nombre, telefono, fechaInicio);
        this.expertos = expertos;
        this.basicos = basicos;
        this.fechaCiudado = fechaCiudado;
        this.especieCuidada = especieCuidada;
    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public ArrayList<Especie> getExpertos() {
        return expertos;
    }

    public void setExpertos(ArrayList<Especie> expertos) {
        this.expertos = expertos;
    }

    public ArrayList<Especie> getBasicos() {
        return basicos;
    }

    public void setBasicos(ArrayList<Especie> basicos) {
        this.basicos = basicos;
    }

    public Date getFechaCiudado() {
        return fechaCiudado;
    }

    public void setFechaCiudado(Date fechaCiudado) {
        this.fechaCiudado = fechaCiudado;
    }

    public Especie getEspecieCuidada() {
        return especieCuidada;
    }

    public void setEspecieCuidada(Especie especieCuidada) {
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
    public String toString() {
        return "Cuidador{" + "expertos=" + expertos + ", basicos=" + basicos + ", fechaCiudado=" + fechaCiudado + ", especieCuidada=" + especieCuidada + '}';
    }

}
