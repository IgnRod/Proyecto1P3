/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;
import java.time.*;
import java.util.ArrayList;
/**
 *
 * @author ignac
 */
public class Calibracion {
    private LocalDate fecha;
    private String instrumentoID;
    private ArrayList<Medicion> Cont = new ArrayList<>();
    public Calibracion(String id, LocalDate f){
        this.instrumentoID = id;
        this.fecha = f;
    }
    public Medicion getMedicion(int index){
        return Cont.get(index);
    }
    public void insertMedicion(Medicion med){
        Cont.add(med);
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public String getInstrumentoID() {
        return instrumentoID;
    }

    public void setInstrumentoID(String instrumentoID) {
        this.instrumentoID = instrumentoID;
    }

    public ArrayList<Medicion> getCont() {
        return Cont;
    }

    public void setCont(ArrayList<Medicion> Cont) {
        this.Cont = Cont;
    }
}