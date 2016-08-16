/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Estudiante
 */
public class Main {
    public static int[] IngresarVotacion(){
        java.util.Scanner teclado = 
                new java.util.Scanner(System.in);
        int[] votacion = new int [3];
        System.out.println("Ingrese Rango de edad: Presione 1 si tiene menos de 18 años, 2. si tiene entre 18 y 55. 3. Si tiene más de 55");
        votacion[0] = teclado.nextInt();
        System.out.println("Situacion Civil: Presione 1 si es soltero, 2 Si es casado");
        votacion[1] = teclado.nextInt();
        System.out.println("Ingrese calificación del curso entre 0 y 10");
        votacion[2] = teclado.nextInt();
        return votacion;
    }
    public static void ReporteFinal (int[] calificacion, int tamano){
        System.out.println("Reporte Final");
        int total = 0;
        for (int i = 0; i <= tamano; i++) {
            total = total + calificacion[i];
        }
        total = total / tamano;
        System.out.println("Resultado Final" + " Numero de encuestados actuales " + tamano + " Promedio Votacion " + total);
    }
    public static void ReporteParcial(int[] edad, int[] estadoCivil, int[] calificacion, int tamano, int filtroEstadoCivil, int filtroEdad) { 
        System.out.println("Reporte Parcial");
        int total = 0;
        double promedio = 0;
        int numCumpleFiltro = 0;
        for (int i = 0; i <= tamano; i++) {
                if (estadoCivil[i]==filtroEstadoCivil && edad[i]==filtroEdad){
                    numCumpleFiltro++;
                    total = total +  calificacion [i];
                }
            }
        promedio = total / numCumpleFiltro;
        System.out.println("Resultados Parcial: " + " Votaron " + numCumpleFiltro +" Personas con Estado Civil " + filtroEstadoCivil + " Y en rango de edad de " + filtroEdad + " con promedio total de " + promedio);      
    }  
    
    public static void Centinela (){
        int[] votacion = null;
        int edad[] = null;
        int[] estadoCivil = null;
        int[] calificacion = null;
        int filtroEstadoCivil = 0;
        int filtroEdad = 0;
        boolean centinela = true;
        int opcion = 0;
        int tamanoMaximo = 0;
        System.out.println("Ingrese la cantidad máxima de Personas a participar en las votaciones");
        java.util.Scanner teclado = new java.util.Scanner(System.in);
        tamanoMaximo = teclado.nextInt();
        edad = new int[tamanoMaximo];
        estadoCivil = new int[tamanoMaximo];
        calificacion = new int[tamanoMaximo];
        int personasIngresadas = 1;
        while (centinela == true){
        System.out.println("Seleccione la opcion a ejecutar 1. Ingresar Votacion. 2. Reporte Parcial. 3. Reporte Final Elecciones");
        opcion = teclado.nextInt();
        if (opcion == 1){
            if (personasIngresadas <= tamanoMaximo){
                votacion = IngresarVotacion();
                edad[personasIngresadas] = votacion[1];
                estadoCivil[personasIngresadas] = votacion[2];
                calificacion[personasIngresadas] = votacion[3];
                personasIngresadas++;
            }           
            else {
                System.out.println("Ya participaron todas las personas posibles");
            }
        }
        else if (opcion == 2){
            System.out.println("Sobre que estado civil desea hacer el filtro");
            filtroEstadoCivil = teclado.nextInt();
            System.out.println("Sobre que rango de edad desea hacer el filtro");
            filtroEdad = teclado.nextInt();
            ReporteParcial(edad, estadoCivil, calificacion, personasIngresadas - 1, filtroEdad, filtroEstadoCivil);
        }
        else {
            ReporteFinal(calificacion, personasIngresadas - 1);
        }
        System.out.println("Si desea finalizar presione 0, para continuar presione 1");
        int indicador = teclado.nextInt();
        if (indicador == 0){
            centinela = false;
        }
        System.out.println("Se ha finalizado la ejecución del proceso de elecciones");
        }
        
    }
}
