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
    public String serie;
    public String descripcion;
    public int minimo;
    public int maximo;
    public int tolerancia;
    public TipoInstrumento tipoInst;
    public ArrayList<Calibracion> Cont;
    public Instrumento(String s, String d, int min, int  max, int t, TipoInstrumento ti) {
        this.serie = s;
        this.descripcion = d;
        this.minimo = min;
        this.maximo = max;
        this.tolerancia = t;
        this.tipoInst = ti;
    }
    public void insertCalibracion(Calibracion c) {Cont.add(c);}
    public Calibracion getCalibracion(int index){return Cont.get(index);}
    public Medicion getMedicion(int index1, int index2){return Cont.get(index1).getMedicion(index2);}
    public void insertMedicion(int index, Medicion med){
        Cont.get(index).insertMedicion(med);
    }
}
