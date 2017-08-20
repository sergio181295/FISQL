tipo -> TEXT
      |INTEGER
      |DOUBLE
      |BOOL
      |DATE
      |DATETIME

//VARIABLES INICIAN CON @

valor -> valor + valor
        |valor - valor
        |valor * valor
        |valor / valor
        |valor ^ valor
        |valor == valor
        |valor != valor
        |valor < valor
        |valor <= valor
        |valor > valor
        |valor >= valor
        |valor && valor
        |valor || valor
        |- valor
        |! valor
        |( valor )
        |llamada
        |CADENA
        |NUMERO
        |VERDADERO
        |FALSO
        |CARACTER

llamada -> llamada PAR1 enviados PAR2 
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
                        |SELECCIONAR camposSeleccion DE enviados

            tipoOrden -> ASC
                        |DESC

            camposSeleccion -> ASTERISCO
                              |enviados

etorno -> RETORNO valor PUNTOYCOMA






