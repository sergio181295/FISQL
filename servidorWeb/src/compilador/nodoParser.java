package compilador;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class nodoParser {
    public String nombre;
    public ArrayList<nodoParser> hijos = new ArrayList<nodoParser>();
    public String valor;
    public int contador = 0;
    public String codigo = "";
    
    public nodoParser clonar(){
        nodoParser nuevo = new nodoParser(this.nombre, this.valor);
        nuevo.contador = this.contador;
        nuevo.codigo = this.codigo;
        if(!hijos.isEmpty()){
            for (nodoParser h : hijos) {
                nodoParser aux = h.clonar();
                nuevo.hijos.add(aux);
            }
        }
        return nuevo;
    }
    
    //CONSTRUCTOR PARA NODOS HOJA
    public nodoParser(String nombre, String valor) {
        this.nombre = nombre;
        this.valor = valor;
    }
    //CONSTRUCTOR PARA NODOS RAMA
    public nodoParser(String nombre, String valor, ArrayList<nodoParser> hijos) {
        this.nombre = nombre;
        this.valor = valor;
        this.hijos = hijos;
    }
    
    public void agregarHijo(nodoParser n){
        this.hijos.add(n);
        contador++;
    }
    
    
    
    
}
