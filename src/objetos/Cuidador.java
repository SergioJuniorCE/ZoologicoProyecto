package objetos;

import java.util.ArrayList;
import java.util.Date;
import java.util.Objects;

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
    public int hashCode() {
        int hash = 3;
        hash = 67 * hash + Objects.hashCode(this.expertos);
        hash = 67 * hash + Objects.hashCode(this.basicos);
        hash = 67 * hash + Objects.hashCode(this.fechaCiudado);
        hash = 67 * hash + Objects.hashCode(this.especieCuidada);
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
        final Cuidador other = (Cuidador) obj;
        if (!Objects.equals(this.expertos, other.expertos)) {
            return false;
        }
        if (!Objects.equals(this.basicos, other.basicos)) {
            return false;
        }
        if (!Objects.equals(this.fechaCiudado, other.fechaCiudado)) {
            return false;
        }
        return Objects.equals(this.especieCuidada, other.especieCuidada);
    }

    @Override
    public String toString() {
        return "Cuidador{" + "expertos=" + expertos + ", basicos=" + basicos + ", fechaCiudado=" + fechaCiudado + ", especieCuidada=" + especieCuidada + '}';
    }

}
