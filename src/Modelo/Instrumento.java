/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;
import java.util.ArrayList;
/**
 *
 * @author ignac
 */
public class Instrumento {
    private String serie;
    private String descripcion;
    private int minimo;
    private int maximo;
    private int tolerancia;
    private TipoInstrumento tipoInst;
    private ArrayList<Calibracion> Cont;
    public Instrumento(String s, String d, int min, int  max, int t, TipoInstrumento ti) {
        this.serie = s;
        this.descripcion = d;
        this.minimo = min;
        this.maximo = max;
        this.tolerancia = t;
        this.tipoInst = ti;
    }
    
    public Calibracion getCalibracion(int index){return Cont.get(index);}
    public Medicion getMedicion(int index1, int index2){return Cont.get(index1).getMedicion(index2);}
    
    public void insertCalibracion(Calibracion c) {Cont.add(c);}
    public void insertMedicion(int index, Medicion med){
        Cont.get(index).insertMedicion(med);
    }

    public String getSerie() {
        return serie;
    }

    public void setSerie(String serie) {
        this.serie = serie;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getMinimo() {
        return minimo;
    }

    public void setMinimo(int minimo) {
        this.minimo = minimo;
    }

    public int getMaximo() {
        return maximo;
    }

    public void setMaximo(int maximo) {
        this.maximo = maximo;
    }

    public int getTolerancia() {
        return tolerancia;
    }

    public void setTolerancia(int tolerancia) {
        this.tolerancia = tolerancia;
    }

    public TipoInstrumento getTipoInst() {
        return tipoInst;
    }

    public void setTipoInst(TipoInstrumento tipoInst) {
        this.tipoInst = tipoInst;
    }

    public ArrayList<Calibracion> getCont() {
        return Cont;
    }

    public void setCont(ArrayList<Calibracion> Cont) {
        this.Cont = Cont;
    }
}
