/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package paquete;
import java.util.Scanner;

public class Menu {
    private static final Scanner scan = new Scanner(System.in);
    private Proceso proceso;

    public Menu() {
        proceso = new Proceso();
    }

    public void iniciar() {
        int Tomaloopcion; // Declarar la variable opción fuera del bucle
        do {
            mostrarMenu();
            Tomaloopcion = solicitarOpcion(); // Obtener opción del menu

            switch (Tomaloopcion) {
                case 1:
                    proceso.ingresarNotas();//llamada a las funciones
                    break;
                case 2:
                    proceso.leerArchivo("promedios.json");//llamada a las funciones
                    proceso.leerArchivo("promedios.csv");
                    break;
                case 3:
                    System.out.println("Saliendo del programa...");
                    break; // Salir del programa
                default:
                    System.out.println(" intente de nuevo");
            }
        } while (Tomaloopcion != 3); //  para salir el bucle
    }

    private void mostrarMenu() {//opcion de mostarra el menu
        System.out.println("****************************************************");
        System.out.println("1.- Ingreso de las notas");
        System.out.println("2.- Leer los promedios");
        System.out.println("3.- Salir");
        System.out.println("****************************************************");
        System.out.print("Seleccione una opción: ");
        
    }

    private int solicitarOpcion() {
        return scan.nextInt();
    }
}