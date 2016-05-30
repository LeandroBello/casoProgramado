/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Vista.FRM_RegistroCursos;
import java.io.File;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;

/**
 *
 * @author Leandro
 */
public class MetodosCursosXML 
{
     FRM_RegistroCursos fRM_RegistroCursos;
    DocumentBuilderFactory documentBuilderFactory;
    DocumentBuilder documentBuilder;
    DOMImplementation dOMImplementation;
    Document document;
    ArrayList titulos;
    ArrayList valores;
    Element raiz,principal;
    String arregloInformacion[];
    Source source;
    Result result;
    Result console;
    Transformer transformer;
    String nombreArchivo;
    
    public MetodosCursosXML(FRM_RegistroCursos fRM_RegistroCurso) 
    {
        this.fRM_RegistroCursos=fRM_RegistroCurso;  
        nombreArchivo="Cursos";
        if(cargarXML1())
        {
        }
        else
        {
            crearXML2();
        }
        
        arregloInformacion=new String[4];
        titulos = new ArrayList();
        valores = new ArrayList();
    }
    
     public void crearArchivo(String nombreArchivo) 
    {
        try{
            documentBuilderFactory = DocumentBuilderFactory.newInstance();
            documentBuilder = documentBuilderFactory.newDocumentBuilder();
            dOMImplementation = documentBuilder.getDOMImplementation();
            document = dOMImplementation.createDocument(null, nombreArchivo, null);
            document.setXmlVersion("1.0");
            raiz = document.getDocumentElement();
            Source source = new DOMSource(document);
            Result result = new StreamResult(new java.io.File(nombreArchivo+".xml")); 
            Transformer transformer = TransformerFactory.newInstance().newTransformer();
            transformer.transform(source, result);
            System.out.println("Archivo XML creado con el nombre: "+nombreArchivo);
        } catch (ParserConfigurationException ex) {
            Logger.getLogger(MetodosCursosXML.class.getName()).log(Level.SEVERE, null, ex);
        
        } catch (TransformerException ex) {
            Logger.getLogger(MetodosCursosXML.class.getName()).log(Level.SEVERE, null, ex);
        }   
    }
     
    public void crearXML2() 
    {
        documentBuilderFactory = DocumentBuilderFactory.newInstance();
        try {
            documentBuilder = documentBuilderFactory.newDocumentBuilder();
            dOMImplementation = documentBuilder.getDOMImplementation();
            document = dOMImplementation.createDocument(null, "xml", null);
            document.setXmlVersion("1.0");
            source = new DOMSource(document);
            result = new StreamResult(new java.io.File(nombreArchivo+".xml"));
 
            console = new StreamResult(System.out);
 
            transformer = TransformerFactory.newInstance().newTransformer();
 
            transformer.transform(source, result);
            transformer.transform(source, console);
 
        } catch (Exception e) {
            System.err.println("Error al crear el archivo XML: " + e);
        }
    }
    
     public void guardarEnXML(String arregloInformacion[])//Método nuevo en pruebas
    {
        try{
            
            raiz = document.createElement("Cursos");
            principal = document.createElement("Cursos");
            document.getDocumentElement().appendChild(raiz);
            
            Element valor1 = document.createElement("sigla");
            Text text = document.createTextNode(arregloInformacion[0]);
            Element valor2 = document.createElement("nombre");
            Text text2 = document.createTextNode(arregloInformacion[1]);
            Element valor3 = document.createElement("creditos");
            Text text3 = document.createTextNode(arregloInformacion[2]);
            Element valor4 = document.createElement("horario");
            Text text4 = document.createTextNode(arregloInformacion[3]);
            
            raiz.appendChild(valor1);
            valor1.appendChild(text);
            raiz.appendChild(valor2);
            valor2.appendChild(text2);
            raiz.appendChild(valor3);
            valor3.appendChild(text3);
            raiz.appendChild(valor4);
            valor4.appendChild(text4);
            
            source = new DOMSource(document);
            result = new StreamResult(new java.io.File(nombreArchivo+".xml"));
            console = new StreamResult(System.out);
            transformer = TransformerFactory.newInstance().newTransformer();
            transformer.transform(source, result);
            transformer.transform(source, console);
            
            }
        catch (Exception e) 
        {
            System.err.println("Error al guardar: " + e);
        }
    }
     
    public boolean cargarXML1() 
    {
        boolean cargo=false;
        try {
        
            File fXmlFile = new File(nombreArchivo+".xml");
            documentBuilderFactory = DocumentBuilderFactory.newInstance();
            documentBuilder = documentBuilderFactory.newDocumentBuilder();
            document = documentBuilder.parse(fXmlFile);
            document.getDocumentElement().normalize();
            cargo=true;
            
            NodeList nList = document.getElementsByTagName("Curso");
            Node nNode = nList.item(0);
            raiz = (Element) nNode;
                
        } catch (Exception e) {
            System.out.println("Error al cargar el archivo XML"+e);
        }
        return cargo;
    } 
   
   
    public boolean consultarInformacionDelXml(String sigla)
    { 
         Element raiz = document.getDocumentElement();
         NodeList listaDeItems = raiz.getElementsByTagName("Cursos");
         Node tag=null,datoContenido=null;

         boolean itemEncontrado=false,tituloSigla=false;
         int contador=0;

         for(int contadorItems=0; contadorItems<listaDeItems.getLength(); contadorItems++) 
         {   
             Node item = listaDeItems.item(contadorItems);
             NodeList datosItem = item.getChildNodes();
             for(int contadorTags=0; contadorTags<datosItem.getLength(); contadorTags++) 
             {           
                 tag = datosItem.item(contadorTags); 
                 datoContenido = tag.getFirstChild();

                 if(tag.getNodeName().equals("sigla") && datoContenido.getNodeValue().equals(""+sigla) )
                 {
                    itemEncontrado=true;     
                 }
                 if(itemEncontrado && contador<4)
                 {
                    arregloInformacion[contador]=datoContenido.getNodeValue();
                    contador++;
                 }
             }

         }
         return itemEncontrado;
    }
    public String[] getArregloInformacion()
    {
        return this.arregloInformacion;
    }
    public void modificarInformacionDelXml(String informacion[])
    { 
         Element raiz = document.getDocumentElement();
         NodeList listaDeItems = raiz.getElementsByTagName("Cursos");
         Node tag=null,datoContenido=null;
         String arregloInformacion[]=new String[4];
         boolean itemEncontrado=false,tituloSigla=false;
         int contador=0;
         try
         {
            for(int contadorItems=0; contadorItems<listaDeItems.getLength(); contadorItems++) 
            {   
                Node item = listaDeItems.item(contadorItems);
                NodeList datosItem = item.getChildNodes();
                for(int contadorTags=0; contadorTags<datosItem.getLength(); contadorTags++) 
                {   
                    tag = datosItem.item(contadorTags); 
                    datoContenido = tag.getFirstChild();
                    if(tag.getNodeName().equals("sigla") && datoContenido.getNodeValue().equals(""+informacion[0]) )
                    {   
                       itemEncontrado=true;     
                    }
                    if(itemEncontrado && contador<4)
                    {
                        datoContenido.setNodeValue(informacion[contador]);                    
                        contador++;
                    }
                }
            }
           source = new DOMSource(document);
           result = new StreamResult(new java.io.File(nombreArchivo+".xml"));
           console = new StreamResult(System.out);
           transformer = TransformerFactory.newInstance().newTransformer();
           transformer.transform(source, result);
           transformer.transform(source, console);
        }
        catch (Exception e) 
        {
            System.err.println("Error al modificar: " + e);
        }
    }
    public void eliminarInformacionDelXml(String sigla)
    { 
         Element raiz = document.getDocumentElement();
         NodeList listaDeItems = raiz.getElementsByTagName("Cursos");
         Node tag=null,datoContenido=null;
         String arregloInformacion[]=new String[4];
         boolean itemEncontrado=false,tituloSigla=false;

         try{
            for(int contadorItems=0; contadorItems<listaDeItems.getLength(); contadorItems++) 
            {   
                Node item = listaDeItems.item(contadorItems);
                NodeList datosItem = item.getChildNodes();
                for(int contadorTags=0; contadorTags<datosItem.getLength(); contadorTags++) 
                {
                    tag = datosItem.item(contadorTags); 
                    datoContenido = tag.getFirstChild();
                    if(tag.getNodeName().equals("sigla") && datoContenido.getNodeValue().equals(""+sigla) )
                    {
                       itemEncontrado=true;
                       raiz.removeChild(item);
                       source = new DOMSource(document);
                       result = new StreamResult(new java.io.File(nombreArchivo+".xml"));
                       console = new StreamResult(System.out);
                       transformer = TransformerFactory.newInstance().newTransformer();
                       transformer.transform(source, result);
                       transformer.transform(source, console);
                    } 
                }
            }
         }
        catch (Exception e)
        {
            System.err.println("Error al eliminar: " + e);
        }
    }
}