package servidorweb;

public class GenerarAnalizadores {
    public static void main(String[] args) {
        //Generar("H","src/compilador/haskell");
        //Generar("HC","src/compilador/haskell");
        Generar("U","src/servidorweb");
    }
    
    public static void Generar(String tipo, String ruta){
        try {
            String opcFlex[] = {"FlexYCup/Lexico"+tipo+".jflex", "-d", ruta };
            jflex.Main.generate(opcFlex);
            String opcCUP[] = { "-destdir", ruta, "-parser", "parser"+tipo, "-symbols", "sym"+tipo, "FlexYCup/Sintactico"+tipo+".cup" };
            java_cup.Main.main(opcCUP);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
