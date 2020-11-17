/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package enrique.aspiradora;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
//import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 *
 * @author Enrique
 */
public class Aspirador {

    // Pendiente cambiar los sout por JOptions.
    public static void main(String[] args) {
        // Creamos el escaner, las variables int del numero de dependencias, el modo de limpieza que usará, la ubicación y un int para saber
        // si es la primera ejecucion del programa.
        //Luego los double del numero de m2, el porcentaje de bateria, el contador de m2 y la suma de los m2.
        // También creamos la variable boleana repetir para salir del bucle y las String para saber si el usuario desea usarla o no.

        int nDependencias = 0;// = 5;
        double[] metrosCuadrados = null;// = new double[nDependencias];
        double bateria;
        boolean repetir = true;
        String modo;
        int primeraVez = 1;
        double contador = 0;
        double sumaMetros = 0;
        int ubicacion = 0;
        String si = "si";
        String no = "no";
        // Bateria que gasta segun si aspiran o aspiran y friega
        double bateriaAspiracion = 1.5;
        double bateriaAspiracionFregado = 2.5;
        String contraseña = "usu.ario";

        // Preguntamos que usuario es y cual es la contraseña de la aplicación. Comprobando que sea la misma que el valor contraseña.
        JOptionPane.showMessageDialog(null, "Buenos días"); //Manera de añadir los Joptions
        String usu = JOptionPane.showInputDialog("¿Qué usuario se quiere registrar?");
        String pswd = JOptionPane.showInputDialog("¿Qué contraseña tiene el usuario " + usu + "?");
        while (!pswd.equals(contraseña)) {
            pswd = JOptionPane.showInputDialog("Contraseña incorrecta, pruebe otra");
        }

        // Al ser la primera vez empezará con la batería totalmente cargada
        bateria = 100;
        // Creamos el bucle general de la aplicacion la cual permitira su uso hasta que la persona quiera finalizar.
        do {
            String iniciar = JOptionPane.showInputDialog("¿Desea que empiece con la limpieza?"
                    + "\n Si."
                    + "\n No.");
            // Creamos un bucle para que hasta que no sea la respuesta si o no pregunte sin fin.
            while (!iniciar.equals(si) && !iniciar.equals(no)) {
                iniciar = JOptionPane.showInputDialog("Valor incorrecto, pruebe nuevamente");
            }

            // Creamos un switch para las opciones si y no, tambien se podria hacer con un if-else pero le veo mejor estetica así. 
            switch (iniciar) {
                case "si":
                    // Creamos un if para que la primera vez que se inicie el programa pida los metros cuadrados de las habitaciones.
                    if (primeraVez == 1) {
//                        // Para indicar el numero de dependencias de la casa en vez de asignarle 5 de inicio.
                        String salas = JOptionPane.showInputDialog("¿Cuantás dependencias tiene la casa? ");
                        nDependencias = Integer.parseInt(salas);
                        metrosCuadrados = new double[nDependencias];

                        JOptionPane.showMessageDialog(null, "Configuración inicial de los metros cuadrados.");
                        // Bucle for en el cual se repetirá mientras i sea menor que el numero de dependencias(5) en este caso.
                        for (int i = 0; i < nDependencias; i++) {
                            // Mostramos el numero de la sala a pedir los datos y se lo asignamos por teclado.
                            String metros = JOptionPane.showInputDialog("Metros cuadrados de la sala " + (i + 1));
                            metrosCuadrados[i] = Integer.parseInt(metros);

                            // Se añadiran siempre que los datos sean mayor a 0m2, en caso contrario lo pedirá de nuevo.
                            while (metrosCuadrados[i] < 0) {
                                metros = JOptionPane.showInputDialog("Escriba un valor superior a 0 metros cuadrados");
                                metrosCuadrados[i] = Integer.parseInt(metros);
                            }
                            // Sumamos todos los m2 de la casa para poder mostrarlos mas adelante.
                            sumaMetros += metrosCuadrados[i];
                        }
                    }

                    // Añadimos un menú para el usuario. Mientras no seleccione una de las opciones se le preguntara de nuevo.
                    modo = JOptionPane.showInputDialog("¿Qué desea hacer?"
                            + "\n 1. - Configurar el sistema"
                            + "\n 2. - Cargar"
                            + "\n 3. - Aspiración"
                            + "\n 4. - Aspiración y fregado"
                            + "\n 5. - Estado general"
                            + "\n 6. - Base de carga"
                            + "\n 7. - Salir");
                    int modo1 = Integer.parseInt(modo);

                    while (modo1 < 1 || modo1 > 7) {
                        modo = JOptionPane.showInputDialog("Escriba un valor correcto");
                        modo1 = Integer.parseInt(modo);
                    }

                    switch (modo1) {
                        // Primera opcion en la cual configuramos los m2 de la casa nuevamente.
                        case 1:
                            JOptionPane.showMessageDialog(null, "CONFIGURACIÓN DE LOS METROS CUADRADOS DE LAS SALAS");
                            sumaMetros = 0;
                            for (int i = 0; i < metrosCuadrados.length; i++) {
                                String metros = JOptionPane.showInputDialog("Metros cuadrados de la sala " + (i + 1));
                                metrosCuadrados[i] = Integer.parseInt(metros);

                                while (metrosCuadrados[i] < 0) {
                                    metros = JOptionPane.showInputDialog("Escriba un valor superior a 0 metros cuadrados");
                                    metrosCuadrados[i] = Integer.parseInt(metros);
                                }
                                // Sumamos todos los m2 de la casa para poder mostrarlos mas adelante.
                                sumaMetros += metrosCuadrados[i];
                            }
                            break;

                        // Mostramos el nivel de la carga de la aspiradora.
                        case 2:
                            JOptionPane.showMessageDialog(null, "BATERIA ACTUAL"
                                    + "\n La bateria actual de la aspiradora es: " + bateria);
                            break;

                        // Modo de aspiración.
                        case 3:
                            // Preguntamos por que tipo de aspiracion desea. Y creamos su respectivo bucle de control.
                            String modo2 = JOptionPane.showInputDialog("MODO ASPIRACIÓN"
                                    + "\n ¿Qué modo de aspiración desea?"
                                    + "\n 1. - Modo Completo"
                                    + "\n 2. - Modo Dependencias");
                            int modoAspiracion = Integer.parseInt(modo2);

                            while (modoAspiracion != 1 && modoAspiracion != 2) {
                                modo2 = JOptionPane.showInputDialog("Opcion elegida incorrecta, pruebe nuevamente");
                                modoAspiracion = Integer.parseInt(modo2);
                            }
                            // Creamos otro switch dependiendo de la eleccion
                            switch (modoAspiracion) {
                                case 1:
                                    // En caso de que la eleccion sea la 1 recorrerá todas las habitaciones mientras no se quede sin bateria
                                    for (int j = 0; j < metrosCuadrados.length; j++) {
                                        contador = contador + metrosCuadrados[j];
                                        // Creo un if para que antes de "iniciar" la limpieza vea si puede acabar la habitacion y en caso contrario
                                        // se lo notifique al usuario y pare con la limpieza.
                                        if ((bateria - (contador * bateriaAspiracion)) <= 3) {
                                            JOptionPane.showMessageDialog(null, "Batería restante insuficiente para continuar con la operación, "
                                                    + "mandar a la base de carga");
                                            break;
                                        }
                                        // Si tiene bateria suficiente limpiará la habitacion y mostrará su bateria.
                                        bateria = bateria - (contador * bateriaAspiracion);
                                        // Le sumamos 1 al valor de la ubicacion para saber en que sala se encuentra.
                                        ubicacion++;
                                        // Tambien volvemos a darle el valor 0 al contador para que no se solapen unas habitaciones con otras
                                        contador = 0;
                                        JOptionPane.showMessageDialog(null, "Limpieza de la dependencia " + ubicacion + " realizada");

                                        if ((j + 1) == 5) {
                                            // Mensaje a mostrar al finalizar la limpieza de las habitaciones
                                            JOptionPane.showMessageDialog(null, "Limpieza de todas las dependencias completa");
                                        }
                                    }
                                    break;

                                case 2:
                                    // Modo en el cual selecionamos una habitacion a limpiar.
                                    String dep = JOptionPane.showInputDialog("¿Qué dependencia desea que se limpie?");
                                    int dependenciaLimpiar = Integer.parseInt(dep);

                                    while (dependenciaLimpiar > nDependencias || dependenciaLimpiar < 1) {
                                        dep = JOptionPane.showInputDialog("Dependencia incorecta, escoja otra");
                                        dependenciaLimpiar = Integer.parseInt(dep);
                                    }
                                    // Restamos 1 ya que la array empieza en -1
                                    contador = contador + metrosCuadrados[dependenciaLimpiar - 1];

                                    if ((bateria - (contador * bateriaAspiracion)) <= 3) {
                                        JOptionPane.showMessageDialog(null, "Batería restante insuficiente para continuar con la limpieza"
                                                + ", mandar a la base de carga");
                                        break;
                                    }
                                    ubicacion = dependenciaLimpiar;
                                    JOptionPane.showMessageDialog(null, "La dependencia " + dependenciaLimpiar + " ha sido limpiada correctamente.");
                                    bateria = bateria - (contador * bateriaAspiracion);
                                    // Tambien volvemos a darle el valor 0 al contador para que no se solapen unas habitaciones con otras
                                    contador = 0;
                                    break;
                            }
                            break;

                        // Modo de aspiración y fregado
                        case 4:
                            modo = JOptionPane.showInputDialog("ASPIRACIÓN FREGADO"
                                    + "\n ¿Qué modo de aspiración y fregado desea?"
                                    + "\n 1. - Modo Completo"
                                    + "\n 2. - Modo Dependencias");
                            modoAspiracion = Integer.parseInt(modo);

                            while (modoAspiracion != 1 && modoAspiracion != 2) {
                                JOptionPane.showMessageDialog(null, "Opcion elegida incorrecta, pruebe nuevamente");
                                modoAspiracion = Integer.parseInt(modo);
                            }

                            switch (modoAspiracion) {
                                case 1:
                                    // En caso de que la eleccion sea la 1 recorrerá todas las habitaciones mientras no se quede sin bateria
                                    for (int j = 0; j < metrosCuadrados.length; j++) {
                                        contador = contador + metrosCuadrados[j];
                                        // Para deteenr su ejecución si no tiene bateria suficiente para su funcion
                                        if ((bateria - (contador * bateriaAspiracionFregado)) <= 3) {
                                            JOptionPane.showMessageDialog(null, "Batería restante insuficiente para continuar con la dependencia"
                                                    + ", mandar a la base de carga");
                                            break;
                                        }
                                        // EN caso contrario realizará la limpieza sin problemas
                                        bateria = bateria - (contador * bateriaAspiracionFregado);
                                        contador = 0;
                                        ubicacion++;

                                        JOptionPane.showMessageDialog(null, "Limpieza de la dependencia " + ubicacion + " realizada");

                                        if ((j + 1) == 5) {
                                            JOptionPane.showMessageDialog(null, "Limpieza de todas las dependencias completa");
                                        }
                                    }
                                    break;

                                case 2:
                                    // Modo en el cual selecionamos una habitacion a limpiar.
                                    String dep = JOptionPane.showInputDialog("¿Qué dependencia desea que se limpie?");
                                    int dependenciaLimpiar = Integer.parseInt(dep);

                                    while (dependenciaLimpiar > nDependencias || dependenciaLimpiar < 1) {
                                        dep = JOptionPane.showInputDialog("Dependencia incorecta, escoja otra");
                                        dependenciaLimpiar = Integer.parseInt(dep);
                                    }

                                    // Restamos 1 ya que la array empieza en 0
                                    contador = contador + metrosCuadrados[dependenciaLimpiar - 1];

                                    // Para detener su ejecución si no tiene bateria suficiente para su funcion
                                    if ((bateria - (contador * bateriaAspiracionFregado)) <= 3) {
                                        JOptionPane.showMessageDialog(null, "Batería restante insuficiente para limpiar completamente la dependencia"
                                                + ", mandar a la base de carga");
                                        break;
                                    }
                                    ubicacion = dependenciaLimpiar;
                                    bateria = bateria - (contador * bateriaAspiracionFregado);
                                    // Tambien volvemos a darle el valor 0 al contador para que no se solapen unas habitaciones con otras
                                    contador = 0;
                                    break;
                            }
                            break;
                        case 5:
                            // Estado general 
                            JOptionPane.showMessageDialog(null, "ESTADO GENERAL");

                            if (ubicacion == 0) {
                                JOptionPane.showMessageDialog(null, "La aspiradora se encuentra en la base de carga");
                            } else {
                                JOptionPane.showMessageDialog(null, "La aspiradora se encuentra en la dependencia " + ubicacion);
                            }

                            // Mostrar la fecha actual
                            DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
                            Date hora = new Date();
                            JOptionPane.showMessageDialog(null, "Hora actual: " + dateFormat.format(hora)
                                    + "\nLa casa tiene " + nDependencias + " dependencias y en total " + sumaMetros + " metros");

                            break;
                        case 6:
                            // Carga
                            if (bateria == 100) {
                                JOptionPane.showMessageDialog(null, "La aspiradora ya dispone del 100% de bateria");
                            } else {
                                JOptionPane.showMessageDialog(null, "CARGA"
                                        + "\n Aspiradora diriguiendose a su base de carga"
                                        + "\n "
                                        + "\n Aspiradora cargandose"
                                        + "\n "
                                        + "\n Batería cargada satisfactoriamente");
                                bateria = 100;
                                ubicacion = 0;
                            }

                            break;
                        case 7:
                            // Salir
                            JOptionPane.showMessageDialog(null, "SALIR"
                                    + "\n "
                                    + "\n Finalizando el programa de limpieza");
                            repetir = false;
                            break;
                    }
                    // Mostramos la bateria restante a la aspiradora, y aumentamos el valor a primeraVEz para que no pida siempre los m2.
                    JOptionPane.showMessageDialog(null, "Bateria restante " + bateria);
                    primeraVez++;

                    break;

                case "no":
                    // En caso de que su respuesta sea no, mostrará que finalizará el programa, cambiando el valor del boolean y así saliendo.
                    JOptionPane.showMessageDialog(null, "Finalizando el programa de limpieza");
                    repetir = false;
            }
        } while (repetir);
    }

}
