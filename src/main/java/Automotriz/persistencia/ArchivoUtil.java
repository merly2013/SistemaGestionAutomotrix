/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Automotriz.persistencia;

import java.io.*;
import java.util.ArrayList;

public class ArchivoUtil {

    public static void guardarDatos(Object objeto, String nombreArchivo) {

        try (ObjectOutputStream salida =
                new ObjectOutputStream(
                        new FileOutputStream(nombreArchivo))) {

            salida.writeObject(objeto);

        } catch (IOException e) {
            System.out.println("Error al guardar archivo: " + e.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    public static <T> ArrayList<T> cargarDatos(String nombreArchivo) {

        File archivo = new File(nombreArchivo);

        if (!archivo.exists()) {
            return new ArrayList<>();
        }

        try (ObjectInputStream entrada =
                new ObjectInputStream(
                        new FileInputStream(nombreArchivo))) {

            return (ArrayList<T>) entrada.readObject();

        } catch (IOException | ClassNotFoundException e) {

            System.out.println("Error al cargar archivo: " + e.getMessage());

            return new ArrayList<>();
        }
    }
}