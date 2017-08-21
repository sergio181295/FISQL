package servidorweb;
import java_cup.runtime.Symbol;
import java_cup.runtime.*;
import java.io.Reader;
import java.awt.Color;
import javax.swing.JOptionPane;

%% //opciones

%class scannerU
%cupsym symU
%cup
%public
%unicode
%line
%char
%ignorecase
%full
%state COMENTARIO1 COMENTARIO2 CADENA DATE

%{
    String cadena="";
    public static int linea = 0;
    public static int columna = 0;
%}

Salto = \r|\n|\r\n
Espacio = " " | [ \t\f]
INTEGER = [0-9]+
DOUBLE = [0-9]+"."[0-9]+
Id  = [@]?[A-Za-z][_0-9A-Za-z]*

%% //fin de opciones

 <YYINITIAL> {
//PROPIAS DE HASKELL
"INTEGER"
{columna += 6;return new Symbol(symU.INTEGER,columna,linea,new String(yytext()));}
"DOUBLE"
{columna += 7;return new Symbol(symU.DOUBLE,columna,linea,new String(yytext()));}
"DATE"
{columna += 8;return new Symbol(symU.DATE,columna,linea,new String(yytext()));}
"TEXT"
{columna += 6;return new Symbol(symU.TEXT,columna,linea,new String(yytext()));}
"BOOL"
{columna += 4;return new Symbol(symU.BOOL,columna,linea,new String(yytext()));}
"DATETIME"
{columna += 3;return new Symbol(symU.DATETIME,columna,linea,new String(yytext()));}
"VERDADERO"
{columna += 9;return new Symbol(symU.VERDADERO,columna,linea,new String(yytext()));}
"FALSO"
{columna += 5;return new Symbol(symU.FALSO,columna,linea,new String(yytext()));}
"CREAR"
{columna += 7;return new Symbol(symU.CREAR,columna,linea,new String(yytext()));}
"BASE_DATOS"
{columna += 7;return new Symbol(symU.BASE_DATOS,columna,linea,new String(yytext()));}
"TABLA"
{columna += 10;return new Symbol(symU.TABLA,columna,linea,new String(yytext()));}
"OBJETO"
{columna += 8;return new Symbol(symU.OBJETO,columna,linea,new String(yytext()));}
"PROCEDIMIENTO"
{columna += 6;return new Symbol(symU.PROCEDIMIENTO,columna,linea,new String(yytext()));}
"FUNCION"
{columna += 5;return new Symbol(symU.FUNCION,columna,linea,new String(yytext()));}
"USUARIO"
{columna += 8;return new Symbol(symU.USUARIO,columna,linea,new String(yytext()));}
"COLOCAR"
{columna += 8;return new Symbol(symU.COLOCAR,columna,linea,new String(yytext()));}
"PASSWORD"
{columna += 6;return new Symbol(symU.PASSWORD,columna,linea,new String(yytext()));}
"NULO"
{columna += 10;return new Symbol(symU.NULO,columna,linea,new String(yytext()));}
"NO_NULO"
{columna += 8;return new Symbol(symU.NO_NULO,columna,linea,new String(yytext()));}
"AUTOINCREMENTABLE"
{columna += 3;return new Symbol(symU.AUTOINCREMENTABLE,columna,linea,new String(yytext()));}
"LLAVE_PRIMARIA"
{columna += 3;return new Symbol(symU.LLAVE_PRIMARIA,columna,linea,new String(yytext()));}
"LLAVE_FORANEA"
{columna += 3;return new Symbol(symU.LLAVE_FORANEA,columna,linea,new String(yytext()));}
"REFERENCIA"
{columna += 3;return new Symbol(symU.REFERENCIA,columna,linea,new String(yytext()));}
"UNICO"
{columna += 3;return new Symbol(symU.UNICO,columna,linea,new String(yytext()));}
"USAR"
{columna += 3;return new Symbol(symU.USAR,columna,linea,new String(yytext()));}
"ALTERAR"
{columna += 3;return new Symbol(symU.ALTERAR,columna,linea,new String(yytext()));}
"CAMBIAR"
{columna += 3;return new Symbol(symU.CAMBIAR,columna,linea,new String(yytext()));}
"AGREGAR"
{columna += 3;return new Symbol(symU.AGREGAR,columna,linea,new String(yytext()));}
"QUITAR"
{columna += 3;return new Symbol(symU.QUITAR,columna,linea,new String(yytext()));}
"ELIMINAR"
{columna += 3;return new Symbol(symU.ELIMINAR,columna,linea,new String(yytext()));}
"BACKUP"
{columna += 3;return new Symbol(symU.BACKUP,columna,linea,new String(yytext()));}
"RESTAURAR"
{columna += 3;return new Symbol(symU.RESTAURAR,columna,linea,new String(yytext()));}
"USQLDUMP"
{columna += 3;return new Symbol(symU.USQLDUMP,columna,linea,new String(yytext()));}
"COMPLETO"
{columna += 3;return new Symbol(symU.COMPLETO,columna,linea,new String(yytext()));}
"RETORNO"
{columna += 3;return new Symbol(symU.RETORNO,columna,linea,new String(yytext()));}
"INSERTAR"
{columna += 3;return new Symbol(symU.INSERTAR,columna,linea,new String(yytext()));}
"EN"
{columna += 3;return new Symbol(symU.EN,columna,linea,new String(yytext()));}
"VALORES"
{columna += 3;return new Symbol(symU.VALORES,columna,linea,new String(yytext()));}
"DONDE"
{columna += 3;return new Symbol(symU.DONDE,columna,linea,new String(yytext()));}
"ACTUALIZAR"
{columna += 3;return new Symbol(symU.ACTUALIZAR,columna,linea,new String(yytext()));}
"BORRAR"
{columna += 3;return new Symbol(symU.BORRAR,columna,linea,new String(yytext()));}
"ORDENAR_POR"
{columna += 3;return new Symbol(symU.ORDENAR_POR,columna,linea,new String(yytext()));}
"SELECCIONAR"
{columna += 3;return new Symbol(symU.SELECCIONAR,columna,linea,new String(yytext()));}
"DE"
{columna += 3;return new Symbol(symU.DE,columna,linea,new String(yytext()));}
"ASC"
{columna += 3;return new Symbol(symU.ASC,columna,linea,new String(yytext()));}
"DESC"
{columna += 3;return new Symbol(symU.DESC,columna,linea,new String(yytext()));}
"OTORGAR"
{columna += 3;return new Symbol(symU.OTORGAR,columna,linea,new String(yytext()));}
"DENEGAR"
{columna += 3;return new Symbol(symU.DENEGAR,columna,linea,new String(yytext()));}
"PERMISOS"
{columna += 3;return new Symbol(symU.PERMISOS,columna,linea,new String(yytext()));}
"DECLARAR"
{columna += 3;return new Symbol(symU.DECLARAR,columna,linea,new String(yytext()));}

"SI"
{columna += 2;return new Symbol(symU.SI,columna,linea,new String(yytext()));}
"SINO"
{columna += 4;return new Symbol(symU.SINO,columna,linea,new String(yytext()));}
"SELECCIONA"
{columna += 9;return new Symbol(symU.SELECCIONA,columna,linea,new String(yytext()));}
"CASO"
{columna += 4;return new Symbol(symU.CASO,columna,linea,new String(yytext()));}
"DEFECTO"
{columna += 7;return new Symbol(symU.DEFECTO,columna,linea,new String(yytext()));}
"PARA"
{columna += 4;return new Symbol(symU.PARA,columna,linea,new String(yytext()));}
"MIENTRAS"
{columna += 8;return new Symbol(symU.MIENTRAS,columna,linea,new String(yytext()));}
"DETENER"
{columna += 8;return new Symbol(symU.DETENER,columna,linea,new String(yytext()));}
"IMPRIMIR"
{columna += 9;return new Symbol(symU.IMPRIMIR,columna,linea,new String(yytext()));}
"FECHA"
{columna += 3;return new Symbol(symU.FECHA,columna,linea,new String(yytext()));}
"FECHA_HORA"
{columna += 3;return new Symbol(symU.FECHA_HORA,columna,linea,new String(yytext()));}
"CONTAR"
{columna += 3;return new Symbol(symU.CONTAR,columna,linea,new String(yytext()));}
//{columna += ;return new Symbol(symU.IMPRIMIRK,columna,linea,new String(yytext()));}
//""
"+"         	  {columna += 1;return new Symbol(symU.MAS,columna,linea,"+");}
"-"         	  {columna += 1;return new Symbol(symU.MENOS,columna,linea,"-");}
"*"         	  {columna += 1;return new Symbol(symU.POR,columna,linea,"*");}
"/"         	  {columna += 1;return new Symbol(symU.DIV,columna,linea,"/");}
"^"         	  {columna += 1;return new Symbol(symU.POT,columna,linea,"^");}
"++"         	  {columna += 2;return new Symbol(symU.MASMAS,columna,linea,"++");}
"--"         	  {columna += 2;return new Symbol(symU.MENOSMENOS,columna,linea,"--");}
">"         	  {columna += 1;return new Symbol(symU.MAYOR,columna,linea,">");}
"<"         	  {columna += 1;return new Symbol(symU.MENOR,columna,linea,"<");}
">="         	  {columna += 2;return new Symbol(symU.MAYORIGUAL,columna,linea,">=");}
"<="         	  {columna += 2;return new Symbol(symU.MENORIGUAL,columna,linea,"<=");}
"=="         	  {columna += 2;return new Symbol(symU.IGUALIGUAL,columna,linea,"==");}
"!="         	  {columna += 2;return new Symbol(symU.NOIGUAL,columna,linea,"!=");}
"||"         	  {columna += 2;return new Symbol(symU.OR,columna,linea,"||");}
"&&"         	  {columna += 2;return new Symbol(symU.AND,columna,linea,"&&");}
"!"         	  {columna += 1;return new Symbol(symU.NOT,columna,linea,"!");}
"="         	  {columna += 1;return new Symbol(symU.IGUAL,columna,linea,"=");}
"{"         	  {columna += 1;return new Symbol(symU.LLA1,columna,linea,"{");}
"}"         	  {columna += 1;return new Symbol(symU.LLA2,columna,linea,"}");}
"("         	  {columna += 1;return new Symbol(symU.PAR1,columna,linea,"(");}
")"         	  {columna += 1;return new Symbol(symU.PAR2,columna,linea,")");}
"."         	  {columna += 1;return new Symbol(symU.PUNTO,columna,linea,".");}
","         	  {columna += 1;return new Symbol(symU.COMA,columna,linea,",");}
";"         	  {columna += 1;return new Symbol(symU.PUNTOYCOMA,columna,linea,"?");}
":"         	  {columna += 1;return new Symbol(symU.DOSPUNTOS,columna,linea,":");}
"\*"         	  {columna += 1;return new Symbol(symU.ASTERISCO,columna,linea,"*");}

//""         	  {columna += ;return new Symbol(symU.,columna,linea,new String(yytext()));}
{Id}    		  {columna += new String(yytext()).length();return new Symbol(symU.ID,columna, linea, new String(yytext()));}
{INTEGER}     	  {columna += new String(yytext()).length();return new Symbol(symU.NUMERO,columna, linea, new String(yytext()));}
{DOUBLE}     	  {columna += new String(yytext()).length();return new Symbol(symU.NUMERO,columna, linea, new String(yytext()));}
" "               {columna += 1; }
"\t" 			  {columna += 4; }
"\n"     		  {columna = 0; linea += 1;}
"\r"     		  {columna = 0; linea += 1;}
"\r\n"     		  {columna = 0; linea += 1;}
"#"               {cadena = "";yybegin(COMENTARIO1);}
"#/"              {cadena = "";yybegin(COMENTARIO2);}
[\"]              {cadena = ""; yybegin(CADENA);}
[\']              {cadena = ""; yybegin(DATE);}
}

<CADENA> {
[^\"]   {cadena+=yytext();}
[\"]    {String temporal=cadena; cadena=""; yybegin(YYINITIAL);columna += temporal.length()+2;return new Symbol(symU.CADENA,columna,linea, temporal);}
}

<COMENTARIO1> {
[^\n]+  {/**/}
[\n]    {columna = 0; linea += 1; yybegin(YYINITIAL);}
}

<COMENTARIO2> {
[^/#]+  {cadena += yytext();}
"/#"    {
			int x = cadena.length();
            for(int i = 0;i<x;i++){
                if(cadena.charAt(i) == '\n'){
                    linea += 1;
                }
            }
			yybegin(YYINITIAL);
		}
}

. {
        String errLex = "Error léxico, DATE irreconocible: '"+yytext()+"' en la línea: "+(linea+1)+" y columna: "+yycolumn;
        System.err.println(errLex);
}
