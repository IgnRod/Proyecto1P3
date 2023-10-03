/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;
/**
 *
 * @author ignac
 */
public class TipoInstrumento {
    private String Codigo;
    private String Nombre;
    private String Unidad;
    public TipoInstrumento(String c, String n, String u){
        this.Codigo = c;
        this.Nombre = n;
        this.Unidad = u;
    }
    public String getCodigo(){return this.Codigo;}
    public String getNombre(){return this.Nombre;}
    public String getUnidad(){return this.Unidad;}
    public void setCodigo(String c){this.Codigo = c;}
    public void setNombre(String n){this.Nombre = n;}
    public void setUnidad(String u){this.Unidad = u;}
}
