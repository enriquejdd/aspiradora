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
//        JOptionPane.showMessageDialog(null, "Buenos días"); Manera de añadir los Joptions
        System.out.println("Buenos días");
        bateria = 100;
        do {
            System.out.println("");
            System.out.println("¿Desea que empiece con la limpieza?"
                    + "\n Si."
                    + "\n No.");
            String iniciar = teclado.nextLine();
            while (!iniciar.equals(si) && !iniciar.equals(no)) {
                System.out.println("Valor incorrecto, pruebe nuevamente.");
                iniciar = teclado.nextLine();
            }
        } while (repetir);
    }
}
