/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;
import Modelo.*;

/**
 *
 * @author ignac
 */
public class Controlador {
    
    private Servicio Modelo;
        private static Controlador instance;
    
    public static Controlador getInstance(){
        if(instance == null) instance = new Controlador();
        return instance;
    }
    
    private Controlador(){
        Modelo = Servicio.getInstance();
    }
    
    public void CreaTipoInstrumento() throws Exception{

    }
}
