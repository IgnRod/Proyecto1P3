
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author ignac
 */
public class Medicion {
    private int referencia;
    private int lectura;
    private int numero;
    
    public Medicion(int r, int l, int n){
        this.referencia=r;
        this.lectura=l;
        this.numero=n;
    }
    
    public int getReferencia() {return referencia;}
    public int getLectura() {return lectura;}
    public int getNumero() {return numero;}

    public void setReferencia(int referencia) {this.referencia = referencia;}
    public void setLectura(int lectura) {this.lectura = lectura;}
    public void setNumero(int numero) {this.numero = numero;}
}
