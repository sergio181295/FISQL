package servidorweb;

import compilador.nodoParser;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import usql.*;

public class ServidorWeb {
    public static nodoParser raiz;
    
    public static void main(String[] args) throws ParseException {
        String ruta = "C:\\Users\\Sergio\\Dropbox (SergioUsac)\\FISQL\\entrada1.usql";
        try{
            String s = "\"hola COMO estan\"";
            System.out.println(s);
            s = s.toLowerCase().replaceAll("\"", "");
            System.out.println(s);
            usql parser;
            parser = new usql(new FileInputStream(ruta));
            raiz = usql.inicio();
            pintar("U");
        }catch(FileNotFoundException e){
            System.out.println("El archivo "+ruta+" no se encuentra");
        }
        
    }
    
    private static int contador;
    private static String grafo;
    
    public static void pintar(String tipo){
        String dot = getDOT(raiz);
        File archivo = new File("Reportes/arbol"+tipo+".txt");
        BufferedWriter bw;
        try {
            bw = new BufferedWriter(new FileWriter(archivo));
            bw.write(dot);
            bw.close();
        } catch (IOException ex) {
            Logger.getLogger(ServidorWeb.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
          String dotPath = "C:\\Program Files (x86)\\Graphviz2.38\\bin\\dot.exe";
          String fileInputPath = "C:\\Users\\Sergio\\Dropbox (SergioUsac)\\FISQL\\servidorWeb\\Reportes\\arbol"+tipo+".txt";
          String fileOutputPath = "C:\\Users\\Sergio\\Desktop\\"+tipo+".jpg";
          String tParam = "-Tjpg";
          String tOParam = "-o";
          String[] cmd = new String[5];
          cmd[0] = dotPath;
          cmd[1] = tParam;
          cmd[2] = fileInputPath;
          cmd[3] = tOParam;
          cmd[4] = fileOutputPath;
          Runtime rt = Runtime.getRuntime();
          rt.exec( cmd );
          System.out.println("pintado");
        } catch (Exception ex) {
            System.out.println("error pintar");
          ex.printStackTrace();
        }
    }
    
    

    public static String getDOT(nodoParser raiz) {
        grafo = "digraph g{";
        grafo += "node[shape = \"box\"];";
        grafo += "nodo0[label = \""+raiz.nombre+";" + raiz.valor + "\"];\n";
        contador = 1;
        reccorerAST("nodo0", raiz);
        grafo += "}";
        return grafo;
    }

    public static void reccorerAST(String padre, nodoParser nodoPadre) {
        for (nodoParser nodoHijo : nodoPadre.hijos) {
            String hijo = "nodo" + contador;
            grafo += hijo + "[label = \""+nodoHijo.nombre+";" + nodoHijo.valor + "\"];\n";
            grafo += padre + "->" + hijo + ";\n";
            contador++;
            reccorerAST(hijo, nodoHijo);
        }
    }
}
