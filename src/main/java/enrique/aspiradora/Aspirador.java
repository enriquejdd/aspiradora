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
        // Bateria que gasta segun si aspiran o aspiran y friega
        double bateriaAspiracion = 1.5;
        double bateriaAspiracionFregado = 2.5;

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
                        // Primera opcion en la cual configuramos los m2 de la casa nuevamente.
                        case 1:
                            System.out.println("");
                            System.out.println("--------------------------------------------------");
                            System.out.println("CONFIGURACIÓN DE LOS METROS CUADRADOS DE LAS SALAS");
                            for (int i = 0; i < metrosCuadrados.length; i++) {
                                System.out.println("Metros cuadrados de la sala " + (i + 1));
                                metrosCuadrados[i] = teclado.nextDouble();

                                while (metrosCuadrados[i] < 0) {
                                    System.out.println("Escriba un valor superior a 0 metros cuadrados");
                                    metrosCuadrados[i] = teclado.nextDouble();
                                }
                            }
                            break;

                        // Mostramos el nivel de la carga de la aspiradora.
                        case 2:
                            System.out.println("La bateria actual de la aspiradora es: " + bateria);
                            break;

                        // Modo de aspiración.
                        case 3:
                            // Preguntamos por que tipo de aspiracion desea. Y creamos su respectivo bucle de control.
                            System.out.println("¿Qué modo de aspiración desea?"
                                    + "\n 1. - Modo Completo"
                                    + "\n 2. - Modo Dependencias");
                            int modoAspiracion = teclado.nextInt();

                            while (modoAspiracion != 1 && modoAspiracion != 2) {
//                                JOptionPane.showMessageDialog(null, "Opcion elegida incorrecta, pruebe nuevamente");
                                System.out.println("Opcion elegida incorrecta, pruebe nuevamente");
                                modoAspiracion = teclado.nextInt();
                            }
                            // Creamos otro switch dependiendo de la eleccion
                            switch (modoAspiracion) {
                                case 1:
                                    // En caso de que la eleccion sea la 1 recorrerá todas las habitaciones mientras no se quede sin bateria
                                    for (int j = 0; j < metrosCuadrados.length; j++) {
                                        contador = contador + metrosCuadrados[j];
//                                        System.out.println(contador);
                                        // Creo un if para que antes de "iniciar" la limpieza vea si puede acabar la habitacion y en caso contrario
                                        // se lo notifique al usuario y pare con la limpieza.
                                        if ((bateria - (contador * bateriaAspiracion)) <= 3) {
                                            System.out.println("Batería restante insuficiente para continuar, mandar a la base de carga");
                                            break;
                                        }
                                        // Si tiene bateria suficiente limpiará la habitacion y mostrará su bateria.
                                        bateria = bateria - (contador * bateriaAspiracion);
                                        System.out.println("La bateria restante de la aspiradora es: " + bateria);
                                        // Le sumamos 1 al valor de la ubicacion para saber en que sala se encuentra.
                                        ubicacion++;
                                        // Tambien volvemos a darle el valor 0 al contador para que no se solapen unas habitaciones con otras
                                        contador = 0;

                                    }
                                    // Mensaje a mostrar al finalizar la limpieza de las habitaciones
                                    System.out.println("Limpieza de todas las dependencias completa");
                                    break;

                                case 2:
                                    // Modo en el cual selecionamos una habitacion a limpiar.
                                    System.out.println("¿Qué dependencia desea que se limpie?");
                                    int dependenciaLimpiar = teclado.nextInt();
                                    // Restamos 1 ya que la array empieza en 0
                                    contador = contador + metrosCuadrados[dependenciaLimpiar-1];

                                    if ((bateria - (contador * bateriaAspiracion)) <= 3) {
                                        System.out.println("Batería restante insuficiente para continuar, mandar a la base de carga");
                                        break;
                                    }
                                    ubicacion = dependenciaLimpiar;
                                    System.out.println("La dependencia " + dependenciaLimpiar + " ha sido limpiada correctamente.");
                                    bateria = bateria - (contador * bateriaAspiracion);
                                    // Bateria después de la limpieza.
                                    System.out.println("La bateria restante de la aspiradora es: " + bateria);
                                    break;
                            }
                            break;

                        // Modo de aspiración y fregado
                        case 4:
                            // Preguntamos por que tipo de aspiracion y fregado desea. Y creamos su respectivo bucle de control.
                            System.out.println("¿Qué modo de aspiración y fregado desea?"
                                    + "\n 1. - Modo Completo"
                                    + "\n 2. - Modo Dependencias");
                            modoAspiracion = teclado.nextInt();

                            while (modoAspiracion != 1 && modoAspiracion != 2) {
                                System.out.println("Opcion elegida incorrecta, pruebe nuevamente");
                                modoAspiracion = teclado.nextInt();
                            }

                            switch (modoAspiracion) {
                                case 1:
                                    // En caso de que la eleccion sea la 1 recorrerá todas las habitaciones mientras no se quede sin bateria
                                    for (int j = 0; j < metrosCuadrados.length; j++) {
                                        contador = contador + metrosCuadrados[j];
//                                        System.out.println(contador);
                                        // Para deteenr su ejecución si no tiene bateria suficiente para su funcion
                                        if ((bateria - (contador * bateriaAspiracionFregado)) <= 3) {
                                            System.out.println("Batería restante insuficiente para continuar, mandar a la base de carga");

                                            break;
                                        }
                                        // EN caso contrario realizará la limpieza sin problemas
                                        bateria = bateria - (contador * bateriaAspiracionFregado);
                                        System.out.println("La bateria restante de la aspiradora es: " + bateria);
                                        contador = 0;
                                        ubicacion++;

                                    }
                                    System.out.println("Limpieza de todas las dependencias completa");
                                    break;

                                case 2:
                                    // Modo en el cual selecionamos una habitacion a limpiar.
                                    System.out.println("¿Qué dependencia desea que se limpie?");
                                    int dependenciaLimpiar = teclado.nextInt();
                                    // Restamos 1 ya que la array empieza en 0
                                    contador = contador + metrosCuadrados[dependenciaLimpiar-1];

                                    // Para detener su ejecución si no tiene bateria suficiente para su funcion
                                    if ((bateria - (contador * bateriaAspiracionFregado)) <= 3) {
                                        System.out.println("Batería restante insuficiente para continuar, mandar a la base de carga");
                                        break;
                                    }
                                    ubicacion = dependenciaLimpiar;
                                    bateria = bateria - (contador * bateriaAspiracionFregado);
                                    System.out.println("La bateria restante de la aspiradora es: " + bateria);
                                    break;
                            }
                            break;
                        case 5:
                            // Configuración 
                            // Mostrar la fecha actual
                            DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
                            Date hora = new Date();
                            System.out.println("Hora actual: " + dateFormat.format(hora));

                            // Mostrar la ubicacion, si es 0 se encuentra en la base de carga
                            if (ubicacion == 0) {
                                System.out.println("La aspiradora se encuentra en la base de carga");
                            } else {
                                System.out.println("La aspiradora se encuentra en la dependencia " + ubicacion);
                            }
                            // Enseñar los m2 de la casa y el numero de dependencias.
                            System.out.println("La casa tiene " + nDependencias + " dependencias y en total " + sumaMetros + " metros ");
                            break;
                        case 6:
                            // Carga
                            ubicacion = 0;
                            System.out.println("Aspiradora diriguiendose a su base de carga");
                            System.out.println("");
                            System.out.println("Aspiradora cargandose");
                            bateria = 100;
                            System.out.println("");
                            System.out.println("Batería cargada satisfactoriamente");
                            break;
                        case 7:
                            // Salir
                            System.out.println("");
                            System.out.println("Finalizando el programa de limpieza");
                            repetir = false;
                            break;
                    }
                    // Mostramos la bateria restante a la aspiradora, y aumentamos el valor a primeraVEz para que no pida siempre los m2.
                    System.out.println("Bateria restante " + bateria);
                    primeraVez++;
                    // Vaciamos el buffer del tecaldo para poder pasar de numeros a letras en las repeticiones.
                    teclado.nextLine();
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
