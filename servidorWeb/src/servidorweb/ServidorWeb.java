package servidorweb;

import java.io.*;
import usql.*;

public class ServidorWeb {

    public static void main(String[] args) throws ParseException {
        String ruta = "C:\\Users\\Sergio\\Dropbox (SergioUsac)\\FISQL\\entrada1.usql";
        try{
            usql parser;
            parser = new usql(new FileInputStream(ruta));
            System.out.println(usql.inicio());
        }catch(FileNotFoundException e){
            System.out.println("El archivo "+ruta+" no se encuentra");
            return;
        }
        
    }
}
