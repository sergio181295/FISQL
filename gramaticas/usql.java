tipo -> TEXT
      |INTEGER
      |DOUBLE
      |BOOL
      |DATE
      |DATETIME
      |ID

//VARIABLES INICIAN CON @

valor -> valor MAS valor
        |valor MENOS valor
        |valor POR valor
        |valor DIVISION valor
        |valor POTENCIA valor
        |valor IGUALIGUAL valor
        |valor NOIGUAL valor
        |valor MENOR valor
        |valor MENORIGUAL valor
        |valor MAYOR valor
        |valor MAYORIGUAL valor
        |valor AND valor
        |valor OR valor
        |MENOS valor
        |NOT valor
        |( valor )
        |llamada
        |CADENA
        |NUMERO
        |VERDADERO
        |FALSO
        |CARACTER
        |fecha
        |fechahora

llamada -> llamada PAR1 enviados PAR2 
      |llamada PAR1 PAR2
      |llamada PUNTO ID
      |ID

enviados -> enviados COMA valor
            |valor

/** OBJETOS USQL
      BASE DE DATOS
      TABLAS
      OBJETO
      PROCEDIMIENTO
      FUCION
*/

/** SENTENCIAS DDL */
      sentenciasDDL -> sentenciasDDL ddl
                        |ddl

      ddl -> crear  
            |usar
            |alterar
            |eliminar
            |backup
            |restaurar

      //DDL CREAR
            crear -> CREAR crearCosa

            crearCosa -> BASE_DATOS ID PUNTOYCOMA
                        |TABLA ID PAR1 atrTabla PAR2 PUNTOYCOMA 
                        |OBJETO ID PAR1 atrTabla PAR2 PUNTOYCOMA
                        |PROCEDIMIENTO ID PAR1 atrTabla PAR2 LLA1 sentenciasDML LLA2
                        |FUNCION ID PAR1 atrTabla PAR2 tipo LLA1 sentenciasDML LLA2
                        |USUARIO ID COLOCAR PASSWORD IGUAL valor PUNTOYCOMA
            
            atrTabla -> atrTabla COMA tipo ID 
                        |atrTabla complemento
                        |tipo ID

            complemento -> NULO 
                        |NO_NULO
                        |AUTOINCREMENTABLE
                        |LLAVE_PRIMARIA
                        |LLAVE_FORANEA REFERENCIA ID
                        |UNICO

      //DDL USAR 
            usar -> USAR ID PUNTOYCOMA

      //DDL ALTERAR
            alterar -> ALTERAR alterarCosa

            alterarCosa -> TABLA ID alterarTabla PUNTOYCOMA
                        |OBJETO ID alterarObjeto PUNTOYCOMA
                        |USUARIO ID CAMBIAR PASSWORD IGUAL valor PUNTOYCOMA

            alterarTabla -> AGREGAR PAR1 atrTabla PAR2
                        |QUITAR enviados

            alterarObjeto -> AGREGAR PAR1 atrTabla PAR2
                        |QUITAR enviados

      //DDL ELIMINAR
            eliminar -> ELIMINAR eliminarCosa

            eliminarCosa -> TABLA ID PUNTOYCOMA
                        |BASE_DATOS ID PUNTOYCOMA
                        |OBJETO ID PUNTOYCOMA 
                        |USUARIO ID PUNTOYCOMA

      //DDL BACKUP
            backup -> BACKUP tipoBackup ID ID PUNTOYCOMA

            tipoBackup -> USQLDUMP   
                        |COMPLETO
      
      //DDL RESTAURAR
            restaurar -> RESTAURAR tipoBackup CADENA PUNTOYCOMA

            tipoBackup -> USQLDUMP   
                        |COMPLETO

      retorno -> RETORNO valor PUNTOYCOMA

/** SENTENCIAS DML */
      sentenciasDML -> sentenciasDML dml
                        |dml

      dml -> insertar
            |actualizar
            |borrar
            |seleccionar

      //DML INSERTAR
            insertar -> INSERTAR EN TABLA ID tipoInsertar PUNTOYCOMA

            tipoInsertar -> tipoInsertar VALORES PAR1 enviados PAR2
                        |PAR1 enviados PAR2 

      //DML ACTUALIZAR
            actualizar -> actualizar DONDE valor
                        |actualizar PUNTOYCOMA
                        |ACTUALIZAR TABLA ID PAR1 enviados PAR2 VALORES PAR1 enviados PAR2

      //DML BORRAR
            borrar -> borrar DONDE valor
                  |borrar PUNTOYCOMA
                  |BORRAR EN TABLA ID 

      //DML SELECCIONAR
            seleccionar -> seleccionar ORDENAR_POR ID tipoOrden
                        |seleccionar DONDE valor
                        |seleccionar PUNTOYCOMA
                        |SELECCIONAR seleccionCampos DE enviados

            tipoOrden -> ASC
                        |DESC

            seleccionCampos -> ASTERISCO
                              |enviados

/** SENTENCIAS DCL */
      sentenciasDCL -> sentenciasDCL dcl
                        |dcl

      dcl -> otorgar
            |denegar

      //DCL OTORGAR
            otorgar -> OTORGAR PERMISOS ID  COMA ID PUNTO seleccionCampos PUNTOYCOMA

      //DCL DENEGAR
            denegar -> DENEGAR PERMISOS ID COMA ID PUNTO seleccionCampos PUNTOYCOMA

/** SENTENCIAS SSL */
      sentenciasSSL -> sentenciasSSL ssl
                        |ssl

      ssl -> declaracion PUNTOYCOMA
            |asignacion
            |si
            |selecciona
            |para
            |mientras
            |detener
            |imprimir
            |fecha
            |fechahora
            |contar

      //SSL DECLARACION
            declaracion -> declaracion IGUAL valor
                        |DECLARAR listId tipo

            listId -> listId COMA ID
                  |ID

      //SSL ASIGNACION
            asignacion -> ID IGUAL valor PUNTOYCOMA

      //SSL SI
            si -> si SINO LLA1 sentenciasSSL LLA2
                  |SI PAR1 valor PAR2 LLA1 sentenciasSSL LLA2
      
      //SS SELECCIONA
            selecciona -> SELECCIONA PAR1 varlor PAR2 LLA1 casos LLA2

            casos -> casos caso
                  |caso

            caso -> CASO valor DOSPUNTOS sentencias
                  |DEFECTO DOSPUNTOS sentencias

      //SSL PARA
            para -> PARA PAR1 DECLARAR ID INTEGER PUNTOYCOMA valor PUNTOYCOMA paso PAR2 LLA1 sentenciasSSL LLA2

            paso -> INCREMENTO 
                  |DECREMENTO

      //SSL MIENTRAS
            mientras -> MIENTRAS PAR1 valor PAR2 LLA1 sentenciasSSL LLA2

      //SSL DETENER
            detener -> DETENER PUNTOYCOMA

      //SSL IMPRIMIR
            imprimir -> IMPRIMIR PAR1 valor PAR2 PUNTOYCOMA

      //SSL FECHA Y HORA
            fecha -> FECHA PAR1 PAR2 PUNTOYCOMA

            fechahora -> FECHA_HORA PAR1 PA2 PUNTOYCOMA

      //SSL CONTAR
            contar -> CONTAR PAR1 MENOR MENOR seleccionar MAYOR MAYOR PAR2 PUNTOYCOMA

/** BACKUP Y RESTAURACION */
      //BACKUP
            




