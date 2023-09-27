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
    public LocalDate fecha;
    public String instrumentoID;
    public ArrayList<Medicion> Cont = new ArrayList<Medicion>();
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
}