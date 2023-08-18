/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.generadoryverificadordeseguridaddelacontrasena;
//importamos las bibliotecas necesarias
import java.security.SecureRandom;
import javax.swing.JOptionPane;

/**
 *
 * @author USER
 */
public class Generadoryverificadordeseguridaddelacontrasena {
//definimos el  metodo main
   public static void main(String[] args) {
       
       //mostramos el cuadro de dialogo con opciones
    int opcion = JOptionPane.showOptionDialog(
        null,
        "Seleccione una opción:",
        "Generador de Contraseñas",
        JOptionPane.YES_NO_OPTION,
        JOptionPane.QUESTION_MESSAGE,
        null,
        new String[]{"Crear Contraseña", "Comprobar Contraseña"},
        "Crear Contraseña");

       
}

    }

