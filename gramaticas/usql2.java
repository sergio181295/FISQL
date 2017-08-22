inicio -> sentencias

sentencias -> sentencia sentencias2

sentencias2 -> sentencia sentencias2
            |epsilon

sentencia -> ddl
            |dml
            |dcl
            |ssl

/** OBJETOS USQL
      BASE DE DATOS
      TABLAS
      OBJETO
      PROCEDIMIENTO
      FUCION
*/

/** SENTENCIAS DDL */
      ddl -> crear  
            |usar
            |alterar
            |eliminar
            |backup
            |restaurar
            |retorno

      //DDL CREAR
            crear -> CREAR crearCosa

            crearCosa -> BASE_DATOS ID PUNTOYCOMA
                        |TABLA ID PAR1 atrTabla PAR2 PUNTOYCOMA 
                        |OBJETO ID PAR1 atrTabla PAR2 PUNTOYCOMA
                        |PROCEDIMIENTO ID PAR1 atrTabla PAR2 LLA1  LLA2
                        |FUNCION ID PAR1 atrTabla PAR2 tipo LLA1 sentencias LLA2
                        |USUARIO ID COLOCAR PASSWORD IGUAL valor PUNTOYCOMA

            atrTabla -> tipo ID atrTabla2

            atrTabla2 -> COMA tipo ID atrTabla2
                        |complemento atrTabla2
                        |epsilon

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

            alterarCosa -> TABLA ID tipoAlterar PUNTOYCOMA
                        |OBJETO ID tipoAlterar PUNTOYCOMA
                        |USUARIO ID CAMBIAR PASSWORD IGUAL valor PUNTOYCOMA

            tipoAlterar -> AGREGAR PAR1 atrTabla PAR2
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

      retorno -> RETORNO valor PUNTOYCOMA

/** SENTENCIAS DML */
      dml -> insertar 
            |actualizar PUNTOYCOMA
            |borrar PUNTOYCOMA
            |seleccionar PUNTOYCOMA

      //DML INSERTAR
            insertar -> INSERTAR EN TABLA ID tipoInsertar PUNTOYCOMA

            tipoInsertar -> PAR1 enviados PAR2 tipoInsertar2

            tipoInsertar2 -> VALORES PAR1 enviados PAR2
                            |epsilon

      //DML ACTUALIZAR
            actualizar -> ACTUALIZAR TABLA ID PAR1 enviados PAR2 VALORES PAR1 enviados PAR2 restricciones

            restricciones -> DONDE valor restricciones
                        |ORDENAR_POR ID tipoOrden restricciones
                        |epsilon


      //DML BORRAR
            borrar -> BORRAR EN TABLA ID restricciones

      //DML SELECCIONAR
            seleccionar -> SELECCIONAR seleccionCampos DE enviados seleccionar2

            tipoOrden -> ASC
                        |DESC

            seleccionCampos -> ASTERISCO
                              |enviados

/** SENTENCIAS DCL */
      dcl -> otorgar
            |denegar

      //DCL OTORGAR
            otorgar -> OTORGAR PERMISOS ID  COMA ID PUNTO seleccionCampos PUNTOYCOMA

      //DCL DENEGAR
            denegar -> DENEGAR PERMISOS ID COMA ID PUNTO seleccionCampos PUNTOYCOMA

/** SENTENCIAS SSL */
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
            declaracion -> DECLARAR listId tipo conValor

            conValor -> IGUAL valor
                        |epsilon

            listId -> ID listId2
            
            listId2 -> COMA ID listId2
                        |epsilon
      //SSL ASIGNACION
            asignacion -> ID IGUAL valor PUNTOYCOMA

      //SSL SI
            si -> SI PAR1 valor PAR2 LLA1 sentencias LLA2 sino

            sino -> SINO LLA1 sentencias LLA2
                  |epsilon
      
      //SS SELECCIONA
            selecciona -> SELECCIONA PAR1 varlor PAR2 LLA1 casos LLA2

            casos -> caso casos2

            casos2 -> caso casos2
                  |epsilon

            caso -> CASO valor DOSPUNTOS sentencias
                  |DEFECTO DOSPUNTOS sentencias

      //SSL PARA
            para -> PARA PAR1 DECLARAR ID INTEGER IGUAL valor PUNTOYCOMA valor PUNTOYCOMA paso PAR2 LLA1 sentencias LLA2

            paso -> MASMAS
                  |MENOSMENOS

      //SSL MIENTRAS
            mientras -> MIENTRAS PAR1 valor PAR2 LLA1 sentencias LLA2

      //SSL DETENER
            detener -> DETENER PUNTOYCOMA

      //SSL IMPRIMIR
            imprimir -> IMPRIMIR PAR1 valor PAR2 PUNTOYCOMA

      //SSL FECHA Y HORA
            fecha -> FECHA PAR1 PAR2 PUNTOYCOMA

            fechahora -> FECHA_HORA PAR1 PAR2 PUNTOYCOMA

      //SSL CONTAR
            contar -> CONTAR PAR1 MENOR MENOR seleccionar MAYOR MAYOR PAR2 PUNTOYCOMA

            
tipo -> TEXT
      |INTEGER
      |DOUBLE
      |BOOL
      |DATE
      |DATETIME
      |ID

//VARIABLES INICIAN CON @

valor -> valor21 valorP

valorP -> OR valor21 valorP
      |epsilon

valor3 -> valor31 valor3P

valor3P -> AND valor31 valor3P
      |epsilon

valor31 -> NOT valor4
		|valor4

valor4 -> valor5 valor4P

valor4P -> MAYOR valor5 valor4P
      |MENOR valor5 valor4P
      |MAYORIGUAL valor5 valor4P
      |MENORIGUAL valor5 valor4P
      |IGUALIGUAL valor5 valor4P
      |NOIGUAL valor5 valor4P
      |epsilon

valor5 -> valor6 valor5P

valor5P -> MAS valor6 valor5P
      |MENOR valor6 valor5P
      |epsilon

valor6 -> valor7 valor6P

valor6P -> POR valor7 valor6P
      |DIV valor7 valor6P
      |epsilon

valor7 -> valor8 valor7P

valor7P -> POT valor8 valor7P
      |epsilon

valor9 ->   CADENA
		|NUMERO
		|VERDADERO
		|FALSO
		|MENOS valor9
		|llamada
            |fecha
            |fechahora
		|PAR1 valor PAR2

llamada -> ID llamadaP

llamadaP -> PAR1 enviados PAR2 llamadaP
      |PAR1 PAR2 llamadaP
      |PUNTO ID llamadaP
      |epsilon

enviados -> valor enviadosP

enviadosP -> COMA valor enviadosP
            |epsilon





