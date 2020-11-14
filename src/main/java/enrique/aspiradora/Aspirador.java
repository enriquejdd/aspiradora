/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package enrique.aspiradora;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 *
 * @author Enrique
 */
public class Aspirador {

    // Pendiente que sepa la ubicación de la aspiradora y cambiar los sout por JOptions.
    public static void main(String[] args) {
        // Creamos el escaner, las variables int del numero de dependencias, el modo de limpieza que usará, la ubicación y un int para saber
        // si es la primera ejecucion del programa.
        //Luego los double del numero de m2, el porcentaje de bateria, el contador de m2 y la suma de los m2.
        // También creamos la variable boleana repetir para salir del bucle y las String para saber si el usuario desea usarla o no.

        Scanner teclado = new Scanner(System.in);
        int nDependencias = 5;
        double[] metrosCuadrados = new double[nDependencias];
        double bateria;
        boolean repetir = true;
        int modo;
        int primeraVez = 1;
        double contador = 0;
        double sumaMetros = 0;
        int ubicacion = 0;
        String si = "si";
        String no = "no";

        // Manera en la que usar los JOptionPane
//        JOptionPane.showMessageDialog(null, "Buenos días"); Manera de añadir los Joptions
        System.out.println("Buenos días");
        // Al ser la primera vez empezará con la batería totalmente cargada
        bateria = 100;
        // Creamos el bucle general de la aplicacion la cual permitira su uso hasta que la persona quiera finalizar.
        do {
            System.out.println("");
            System.out.println("¿Desea que empiece con la limpieza?"
                    + "\n Si."
                    + "\n No.");
            String iniciar = teclado.nextLine();
            // Creamos un bucle para que hasta que no sea la respuesta si o no pregunte sin fin.
            while (!iniciar.equals(si) && !iniciar.equals(no)) {
                System.out.println("Valor incorrecto, pruebe nuevamente.");
                iniciar = teclado.nextLine();
            }

            // Creamos un switch para las opciones si y no, tambien se podria hacer con un if-else pero le veo mejor estetica así. 
            switch (iniciar) {
                case "si":
                    // Creamos un if para que la primera vez que se inicie el programa pida los metros cuadrados de las habitaciones.
                    if (primeraVez == 1) {
                        System.out.println("Configuración inicial de los metros cuadrados.");
                        // Bucle for en el cual se repetirá mientras i sea menor que el numero de dependencias(5) en este caso.
                        for (int i = 0; i < nDependencias; i++) {
                            // Mostramos el numero de la sala a pedir los datos y se lo asignamos por teclado.
                            System.out.println("Metros cuadrados de la sala " + (i + 1));
                            metrosCuadrados[i] = teclado.nextDouble();

                            // Se añadiran siempre que los datos sean mayor a 0m2, en caso contrario lo pedirá de nuevo.
                            while (metrosCuadrados[i] < 0) {
                                System.out.println("Escriba un valor superior a 0 metros cuadrados");
                                metrosCuadrados[i] = teclado.nextDouble();
                            }
                            // Sumamos todos los m2 de la casa para poder mostrarlos mas adelante.
                            sumaMetros += metrosCuadrados[i];
                        }
                    }
                    // Añadimos un menú para el usuario. Mientras no seleccione una de las opciones se le preguntara de nuevo.
                    System.out.println("¿Qué desea hacer?"
                            + "\n 1. - Configurar el sistema"
                            + "\n 2. - Cargar"
                            + "\n 3. - Aspiración"
                            + "\n 4. - Aspiración y fregado"
                            + "\n 5. - Estado general"
                            + "\n 6. - Base de carga"
                            + "\n 7. - Salir");
                    modo = teclado.nextInt();

                    while (modo < 0 || modo > 7) {
                        System.out.println("Escriba un valor correcto");
                        modo = teclado.nextInt();
                    }

                    switch (modo) {
                        case 1:
                            break;
                        case 2:
                            break;
                        case 3:
                            break;
                        case 4:
                            break;
                        case 5:
                            break;
                        case 6:
                            break;
                        case 7:
                            break;
                    }

                    System.out.println("Bateria restante " + bateria);
                    primeraVez++;
                    break;

                case "no":
                    // En caso de que su respuesta sea no, mostrará que finalizará el programa, cambiando el valor del boolean y así saliendo.
                    System.out.println("");
                    System.out.println("Finalizando el programa de limpieza");
                    repetir = false;
            }
        } while (repetir);
    }
}
