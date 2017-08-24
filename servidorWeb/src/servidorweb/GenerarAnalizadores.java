package servidorweb;

public class GenerarAnalizadores {
    public static void main(String[] args) {
        //Generar("H","src/compilador/haskell");
        //Generar("HC","src/compilador/haskell");
        Generar("src/usql/usql.jj");
    }
    
    public static void Generar(String ruta){
        try {
          String[] cmd = new String[2];
          cmd[0] = "C:\\javacc-5.0\\bin\\lib\\javacc.jar";
          cmd[1] = ruta;
          Runtime rt = Runtime.getRuntime();
          rt.exec( cmd );
            System.out.println("generado");
        } catch (Exception ex) {
            System.out.println("error al generar");
            ex.printStackTrace();
        }
    }
}
