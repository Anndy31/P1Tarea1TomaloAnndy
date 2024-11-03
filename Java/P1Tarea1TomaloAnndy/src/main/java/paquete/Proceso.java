/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package paquete;
import org.json.JSONObject;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Proceso {
    private float[] Tomalopromedios;
    private int TomalocantidadEstudiantes;
    private static final Scanner scan = new Scanner(System.in);

    public void ingresarNotas() {//funcion de notas
        TomalocantidadEstudiantes = solicitarCantidad();
        Tomalopromedios = new float[TomalocantidadEstudiantes];

        for (int i = 0; i < TomalocantidadEstudiantes; i++) {
            System.out.println("Ingrese las notas para calcular el promedio del estudiante # " + (i + 1));
            float Tomalonota1 = solicitarNota("Primer");
            float Tomalonota2 = solicitarNota("Segunda");
            float Tomalonota3 = solicitarNota("Tercer");

            float Tomalopromedio = (Tomalonota1 + Tomalonota2 + Tomalonota3) / 3;
            Tomalopromedios[i] = Tomalopromedio;

            System.out.print("El Estado del Estudiante #" + (i + 1) + " es: ");
            if (Tomalopromedio < 14) {
                System.out.println("Reprobado con " + Tomalopromedio);
            } else {
                System.out.println("Aprobado con " + Tomalopromedio);
            }
        }
        guardarPromediosJSON();//llamas a las funciones para guardar 
        guardarPromediosCSV();
    }

    private int solicitarCantidad() {
        int Tomalocantidad;
        do {
            System.out.println("Cuantos Estudiantes va a Ingresar (1-5) ");
            Tomalocantidad = scan.nextInt();
        } while (Tomalocantidad < 1 || Tomalocantidad > 5);
        return Tomalocantidad;
    }

    float solicitarNota(String numeroNota) {
        float Tomalonota;
        do {
            System.out.println("Ingrese la " + numeroNota + " Nota: ");
            Tomalonota = scan.nextFloat();
            if (Tomalonota < 0 || Tomalonota > 20) {
                System.out.println("La nota debe estar en el rango de (0-20). Intente de nuevo.");
            }
        } while (Tomalonota < 0 || Tomalonota > 20);
        return Tomalonota;
    }

    private void guardarPromediosJSON() {//se guarda en ese tipo de archivo
        JSONObject jsonObject = new JSONObject();
        for (int i = 0; i < TomalocantidadEstudiantes; i++) {
            jsonObject.put("Estudiante_" + (i + 1), Tomalopromedios[i]);
        }

        try (FileWriter file = new FileWriter("promedios.json")) {
            file.write(jsonObject.toString());
            System.out.println("Se han guardado los promedios en formato JSON correctamente");
        } catch (IOException e) {
            System.out.println("Error al guardar los promedios en JSON: " + e.getMessage());
        }
    }

    private void guardarPromediosCSV() {//se guarda en ese tipo de archivo
        try (FileWriter file = new FileWriter("promedios.csv")) {
            file.write("Estudiante,Promedio\n");
            for (int i = 0; i < TomalocantidadEstudiantes; i++) {
                file.write("Estudiante_" + (i + 1) + "," + Tomalopromedios[i] + "\n");
            }
            System.out.println("Se han guardado los promedios en formato CSV correctamente");
        } catch (IOException e) {
            System.out.println("Error al guardar los promedios en CSV: " + e.getMessage());
        }
    }

    public void leerArchivo(String nombreArchivo) {//se lee los archivos
        try (Scanner fileScanner = new Scanner(new File(nombreArchivo))) {
            while (fileScanner.hasNextLine()) {
                System.out.println(fileScanner.nextLine());
            }
            System.out.println("Lectura del archivo " + nombreArchivo + " completa");
        } catch (IOException e) {
            System.out.println("Error al leer el archivo " + nombreArchivo + ": " + e.getMessage());
        }
    }
}