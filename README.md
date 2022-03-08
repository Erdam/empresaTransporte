# empresaTransporte

#### Bienvenido a la empresa de transporte.
 Se desea realizar una aplicación para el manejo de una mini empresa de transporte. La empresa tiene capacidad para administrar 4 camiones y sus cargas respectivas.
De cada camión se conoce:
-	La matrícula. Este es el identificador del camión.
-	La capacidad de carga, en kilogramos.
-	El consumo de gasolina, en galones/kilómetro.
-	La carga actual, en kilogramos.

#### Requerimientos Funcionales"
------------------------------------------------------------------------------------------------------
**Nombre** R1 – Visualización del identificador del camión..
**Resumen**Permite visualizar la información (matrícula, capacidad, el consumo
y la carga actual) de los cuatro camiones de la empresa. 
**Entrada**
Ninguna
**Resultado**
Muestra la información de los cuatro camiones.

------------------------------------------------------------------------------------------------------
**Nombre** R2 – Cargar un camión.
**Resumen** Permite cargar un camión.
**Entrada**
Matrícula y peso de la carga medida en kg.
**Resultado**
- Si la capacidad del camión es mayor o igual al peso de la carga, se cambia la
carga actual.
- Si la capacidad del camión es menor al peso de la carga, no se modifica la
carga actual y se le informa al usuario que no se pudo cargar el camión.

------------------------------------------------------------------------------------------------------
**Nombre** R3 – Descargar un camión.
**Resumen** Permite descargar un camión.
**Entrada**
Matrícula del camión.
**Resultado**
Se ha descargado el camión, modifica su carga actual en 0.

------------------------------------------------------------------------------------------------------
**Nombre**
R4 – Buscar el mejor camión.
**Resumen**
Determina cuál es el mejor camión que tiene una capacidad
suficiente para transportar un peso dado y que tiene menor
consumo. 
**Entrada**
Peso de la carga.
**Resultado**
Muestra al usuario la matrícula del mejor camión.

------------------------------------------------------------------------------------------------------
**Nombre**
R5 – Calcular información general.
**Resumen**
Calcula la carga total, la carga promedio y la capacidad de la
empresa. 
**Entrada**
Ninguno.
**Resultado**
Muestra la carga total, el promedio y la capacidad total.

------------------------------------------------------------------------------------------------------
#### Directorio
    editor.md/
       		 source/
        		test/source/
       		 data/
        		docs/
            		specs/
            		api/
        ...

[YouTube](https://www.youtube.com/user/MrDionicios/videos "youtube")
