/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author ignac
 */
import java.util.ArrayList;
import javax.xml.parsers.DocumentBuilderFactory; // Define un API que pemite obtener un "parser" que produce objetos DOM (Document Object Model es una inrerface para documentos WEB ) de XML's 
import javax.xml.parsers.DocumentBuilder;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
//Define la API para obtener instancias de DOM de un XML
// con esta clase, se puede obtener un documento de un XML
//una instancias de esta clase se puede obtener de DocumentBuilderFactory.newDocumentBuilder() . 
//Una vez que la instancia de esta clase se tien, el XML se puede parsear de varias fuentes
import org.w3c.dom.Document;
//esta interface representa el XML completo, es la raíz del arbol de documento
import org.w3c.dom.NodeList;
//provee la abstraccion de una coleccion de nodos ordenados
// los items de un NodeList se accesan por un indice que inicia en 0
import org.w3c.dom.Element;
//esta interfaz representa un elemento en un documento XML

public class Servicio {
    
    private static DocumentBuilderFactory factory;
    private static DocumentBuilder builder;
    private static Document document;
    private static Servicio instance;
    
    private ArrayList<TipoInstrumento> ListaTipoInstrumento;
    private ArrayList<Instrumento> ListaInstrumentos;
    
    public static Servicio getInstance(){
        if(instance == null) instance = new Servicio();
        return instance;
    }
    
    private Servicio() {
        this.ListaTipoInstrumento = new ArrayList();
        this.ListaInstrumentos = new ArrayList();
        
        
        
        
        read();
    }
    
    private void lectura() {
        try{
            document = builder.parse("Instrumentos.xml");
            NodeList rootList = document.getElementsByTagName("TipoInstrumentos");
            Element root = (Element)rootList.item(0);
            if(!root.hasChildNodes())
                document.appendChild(document.createElement("TipoInstrumentos"));
            else{
                NodeList tempListaTipoInstrumentos = root.getElementsByTagName("TipoInstrumento");
                for(int i = 0; i < tempListaTipoInstrumentos.getLength(); i++){
                    Element tipoInstrumento =(Element) tempListaTipoInstrumentos.item(i);
                    String codigo = tipoInstrumento.getAttribute("Codigo");
                    String nombre = tipoInstrumento.getAttribute("Nombre");
                    String unidad = tipoInstrumento.getAttribute("Unidad");
                    
                    if(tipoInstrumento.hasChildNodes()){
                        NodeList tempListaInstrumentos = root.getElementsByTagName("Instrumentos");
                        for(int j = 0; j < tempListaInstrumentos.getLength(); j++){
                            Element instrumento =(Element) tempListaTipoInstrumentos.item(i);
                            //String s, String d, int min, int  max, int t, TipoInstrumento ti
                            String serie = instrumento.getAttribute("Serie");
                            String descripcion = instrumento.getAttribute("Descripcion");
                            int minimo = Integer.parseInt(instrumento.getAttribute("Minimo"));
                            int maximo = Integer.parseInt(instrumento.getAttribute("Maximo"));
                            int tolerancia = Integer.parseInt(instrumento.getAttribute("Tolerancia"));
                            
                        }
                    }
                    
                    this.ListaTipoInstrumento.add(new TipoInstrumento(codigo, nombre, unidad));
                }
            }
        }catch(Exception e){
            
        }
    }
    
    
    
    public void addTipoInstrumento(TipoInstrumento objeto) throws Exception{
        document = builder.parse("Instrumentos.xml");
        NodeList root = document.getElementsByTagName("TipoInstrumentos");
        Element test = (Element)root.item(0);
        if(!test.hasChildNodes()) test.appendChild(TipoInstrumentoToElement(objeto));
        else{
            NodeList Lista = test.getElementsByTagName("TipoInstrumento");
            for(int i = 0; i < Lista.getLength(); i++){
                Element temp =(Element) Lista.item(i);
                if (temp.getAttribute("Codigo").equals(objeto.getCodigo())){
                    System.out.print("Repetido");
                    return;
                }
            }
            test.appendChild(TipoInstrumentoToElement(objeto));
        }
        write();
    }
    
    public TipoInstrumento returnTipoInstrumento(String codigo) throws Exception{
        document = builder.parse("Instrumentos.xml");
        NodeList root = document.getElementsByTagName("TipoInstrumentos");
        Element test = (Element)root.item(0);
        if(!test.hasChildNodes()) throw new Exception("Not found");
        else{
            NodeList Lista = test.getElementsByTagName("TipoInstrumento");
            for(int i = 0; i < Lista.getLength(); i++){
                Element temp =(Element) Lista.item(i);
                if (temp.getAttribute("Codigo").equals(codigo)){
                    String nombre = temp.getElementsByTagName("Nombre").item(0).getTextContent();
                    String unidad = temp.getElementsByTagName("Unidad").item(0).getTextContent();
                    return(new TipoInstrumento(codigo, nombre, unidad));
                    
                }
            }
        }
        throw new Exception("Not found");
    }
    
    public void removeTipoInstrumento(String codigo) throws Exception {
        
        document = builder.parse("Instrumentos.xml");
        NodeList root = document.getElementsByTagName("TipoInstrumentos");
        Element test = (Element)root.item(0);
        
        if(!test.hasChildNodes()) return;
        else{
            NodeList Lista = test.getElementsByTagName("TipoInstrumento");
            for(int i = 0; i < Lista.getLength(); i++){
                Element temp =(Element) Lista.item(i);
                if (temp.getAttribute("Codigo").equals(codigo)){
                    test.removeChild(temp);
                }
            }
        }
        write();
    }
    
    public void read(){
        try{
            factory = DocumentBuilderFactory.newInstance();
            builder = factory.newDocumentBuilder();
            
            document = builder.parse("Instrumentos.xml");
            
            if (!document.hasChildNodes()){
                document.appendChild(document.createElement("TipoInstrumentos"));
            }  
        }catch(Exception e){
            try{
                DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
                DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
                document = dBuilder.newDocument();
                
                Element root = document.createElement("TipoInstrumentos");
                document.appendChild(root);
                
                
                TransformerFactory transformerFactory = TransformerFactory.newInstance();
                Transformer transformer = transformerFactory.newTransformer();
                transformer.setOutputProperty(OutputKeys.INDENT, "yes");

                DOMSource source = new DOMSource(document);

                // Escribe el contenido del documento XML en un archivo llamado "libros.xml"
                StreamResult result = new StreamResult("Instrumentos.xml");
                transformer.transform(source, result);

                System.out.println("Archivo XML creado exitosamente.");
            } catch(Exception e2){
                
            }
        }
    }
    public void write(){
        try {
            // Crear un nuevo documento XML
//            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
//            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
//            Document doc = dBuilder.newDocument();
            
            // Crear un elemento raíz
//            Element rootElement = doc.createElement("TipoInstrumentos");
//            doc.appendChild(rootElement);
//
//            // Crear elementos de libro
//            Element libro1 = doc.createElement("Libro");
//            rootElement.appendChild(libro1);
//            
//            Element titulo1 = doc.createElement("Titulo");
//            titulo1.appendChild(doc.createTextNode("El Señor de los Anillos"));
//            libro1.appendChild(titulo1);
//
//            Element autor1 = doc.createElement("Autor");
//            autor1.appendChild(doc.createTextNode("J.R.R. Tolkien"));
//            libro1.appendChild(autor1);

            // Crear el transformador para escribir el documento XML en un archivo
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");

            DOMSource source = new DOMSource(document);

            // Escribe el contenido del documento XML en un archivo llamado "libros.xml"
            StreamResult result = new StreamResult("Instrumentos.xml");
            transformer.transform(source, result);

            System.out.println("Archivo XML creado exitosamente.");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public Element TipoInstrumentoToElement(TipoInstrumento objeto){
        Element TI = document.createElement("TipoInstrumento");
        TI.setAttribute("Codigo", objeto.getCodigo());
        
        Element nombre = document.createElement("Nombre");
        nombre.appendChild(document.createTextNode(objeto.getNombre()));
        TI.appendChild(nombre);
        
        Element unidad = document.createElement("Unidad");
        unidad.appendChild(document.createTextNode(objeto.getUnidad()));
        TI.appendChild(unidad);
        
        return TI;
    }
}
