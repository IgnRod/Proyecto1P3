/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

/**
 *
 * @author ESCINF
 */
import Controlador.Controlador;
import Modelo.*;
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try{
        Servicio.getInstance().addTipoInstrumento(new TipoInstrumento("1","2","3"));
        Servicio.getInstance().addTipoInstrumento(new TipoInstrumento("1","2","3"));
        Servicio.getInstance().addTipoInstrumento(new TipoInstrumento("3","2","3"));
        
        Servicio.getInstance().removeTipoInstrumento("1");

        } catch(Exception e){}
    }
    
}
