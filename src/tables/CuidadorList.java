/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tables;

import java.util.ArrayList;
import java.util.List;
import javax.swing.AbstractListModel;
import objetos.Especie;

/**
 *
 * @author maikr
 */
public class CuidadorList extends AbstractListModel {

    private final List<Especie> especies;

    public CuidadorList() {
        super();
        this.especies = new ArrayList<>();
    }

    public CuidadorList(List<Especie> especies) {
        super();
        this.especies = especies;
    }

    @Override
    public int getSize() {
        return especies.size();
    }

    @Override
    public Object getElementAt(int index) {
        return especies.get(index);
    }

    @Override
    public String toString() {
        return especies.toString();
    }

    public void add(Especie especie) {
        especies.add(especie);
    }

}
