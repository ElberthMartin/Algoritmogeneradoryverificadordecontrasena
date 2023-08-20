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
    //manejo de opciones seleccionados
    if (opcion == 0) {
    crearContraseña();
} else if (opcion == 1) {
    comprobarContraseña();
}


       
}
 public static void crearContraseña() {
    // Solicitar la longitud de la contraseña al usuario
    int longitud = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la longitud de la contraseña:"));
  
//Ahora mostramos un cuadro de diálogo para seleccionar el nivel de seguridad
    
int nivelSeguridad = JOptionPane.showOptionDialog(
            null,
            "Seleccione el nivel de seguridad:",
            "Generador de Contraseñas",
            JOptionPane.YES_NO_CANCEL_OPTION,
            JOptionPane.QUESTION_MESSAGE,
            null,
            new String[]{"No seguro", "Seguro", "Muy seguro"},
            "Seguro");

  //generamos la contraseña
    
     String contraseñaGenerada = generarContraseña(longitud, nivelSeguridad);
    JOptionPane.showMessageDialog(null, "Contraseña generada: " + contraseñaGenerada);
    //aqui evaluamos
    evaluarSeguridad(contraseñaGenerada);
}
 
 //Solicitamos al usuario que ingrese la contraseña a comprobar
 public static void comprobarContraseña() {
    
    String contraseñaIngresada = JOptionPane.showInputDialog("Ingrese la contraseña a comprobar:");

   evaluarSeguridad(contraseñaIngresada);
}
 //Definimos los caracteres disponibles según el nivel de seguridad seleccionado.
public static String generarContraseña(int longitud, int nivelSeguridad) {
    String caracteres = "";

    if (nivelSeguridad == 0) {
        caracteres = "abcdefghijklmnopqrstuvwxyz";
    } else if (nivelSeguridad == 1) {
        caracteres = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
    } else if (nivelSeguridad == 2) {
        caracteres = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!@#$%^&*()-_=+";
    }
    
    // Crear una instancia de SecureRandom 
    SecureRandom random = new SecureRandom();
//creamos ahora  un StringBuilder para construir la contraseña
StringBuilder contraseña = new StringBuilder();
  //
  for (int i = 0; i < longitud; i++) {
  //ahora generamos un bucle que se ejecuta longitud de veces para generar la contraseña
int randomIndex = random.nextInt(caracteres.length());
     
char caracterAleatorio = caracteres.charAt(randomIndex);
    
contraseña.append(caracterAleatorio);
}
// Convertimos el contenido del StringBuilder en una cadena 
return contraseña.toString();

}
public static void evaluarSeguridad(String contraseña) {
    
    //verificacion si la contraña tiene un cracter especial un aletra mayuscula
    //y su respectivo incremento
    int seguridad = 0;

    if (contraseña.matches(".[a-z].")) {
        seguridad++;
    }
    if (contraseña.matches(".[A-Z].")) {
        seguridad++;
    }
    if (contraseña.matches(".\\d.")) {
        seguridad++;
    }
    if (contraseña.matches(".[!@#$%^&()-_=+].*")) {
        seguridad++;
    }
    //determinamos el mensaje que tipo de seguridad tiene
    
    String mensaje = "";
    switch (seguridad) {
        case 0:
            mensaje = "Muy débil 😢";
            break;
        case 1:
            mensaje = "Débil 🙄";
            break;
        case 2:
            mensaje = "Moderada 🙂";
            break;
        case 3:
            mensaje = "Fuerte 😀";
            break;
        case 4:
            mensaje = "Muy fuerte 😎";
            break;
    }
 
}


