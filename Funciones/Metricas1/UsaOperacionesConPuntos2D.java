/**
 *  Programa que muestra el uso de las clases
 *  Punto2D y OperacionesConPuntos2D
 *
 *  Actividad a realizar:
 *  1.- Pedir los datos en enorno gráfico
 *  2.- Probar los métodos de OperacionesConPuntos2D
 *
 *   @version 22/Sep/22
 */

package Metricas1;

import javax.swing.JOptionPane;


public class UsaOperacionesConPuntos2D {

    public static void main(String... something){
        int[] coords = new int[4];
        String[] request = {"x1", "y1", "x2", "y2"}, ordinates = {"abscisa", "ordenada"};
        boolean process = true;
        for (int i = 0; i < 4; i++) {
            String text = "", obligatory = "\n*Obligatorio", nonObligatory = "\n*Opcional, si dejas este campo vacío, el segundo punto será el origen", input = "";
            if(i%2 == 0){
                text = ordinates[0];
            }
            else{
                text = ordinates[1];
            }
            if(i<2){
                input = JOptionPane.showInputDialog("Introduce la " + text + " del punto " + request[i] + obligatory);
            }
            else{
                input = JOptionPane.showInputDialog("Introduce la " + text + " del punto " + request[i] + nonObligatory);
            }

            if(input != null)
            {
                try {
                    coords[i] = Integer.parseInt(input);
                } catch (Exception e) {
                    if(i<2){
                        while (true) {
                            input = JOptionPane.showInputDialog("Ha ocurrido un error, por favor introduce un entero válido para tu "+ text +" ("+ request[i] +")");
                            try {
                                coords[i] = Integer.parseInt(input);
                                break;
                            } catch (Exception ex) {
                                JOptionPane.showMessageDialog(null, "Has ingresado un valor inválido, por favor intenta de nuevo");
                            }
                        }
                    }
                    else{
                        coords[2] = 0;
                        coords[3] = 0;
                        break;
                    }
                }
            }
            else {
                process = false;
                break;
            }
        }
        if(process)
        {
            Punto2D a = new Punto2D(coords[0],coords[1]);
            Punto2D b;
            if(coords[2] == 0 && coords[3] == 0){
                b = new Punto2D();
            }
            else{
                b = new Punto2D(coords[2],coords[3]);
            }
    
            double norma = OperacionesConPuntos2D.normaEuclidiana(a);
            double dAB = OperacionesConPuntos2D.metricaEuclidiana(a,b);
            double Manhattan = OperacionesConPuntos2D.metricaTaxista(a,b);
            double dotProduct = OperacionesConPuntos2D.dotProduct(a,b);
            double area = OperacionesConPuntos2D.area(a,b);
    
            JOptionPane.showMessageDialog(null, "Los puntos que introdujiste son: "+ a + "y" + b +
                                                                "\nLa norma del punto " + a + " es : " + norma + 
                                                                "\nLa distancia del punto " + a + "al punto" + b + " es : " + dAB +
                                                                "\nLa distancia del punto " + a + "al punto" + b + " según la métrica del taxista es : " + Manhattan + 
                                                                "\nEl producto punto de " + a + " y " + b + " es : " + dotProduct +
                                                                "\nEl área del rectángulo formado por " + a + " y " + b + " es : " + area);
        }
    }
}
