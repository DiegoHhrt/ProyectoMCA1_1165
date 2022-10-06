/**
 *  Programa que permitirá realizar
 *  operaciones con puntos en la forma P = (x,y)
 *
 *  NOTA: DEBEN IMPLEMENTAR LOS MÉTODOS
 *
 *  Curso: Matemáticas para ciencias Aplicadas
 *
 *  Temas:  Función distancia, producto punto y
 *          su aplicación para obtener el área
 *
 *  @author Roberto Méndez Méndez
 *  @version  22-Septiembre-22
 */


package Metricas1;

public class OperacionesConPuntos2D {


    public static double normaEuclidiana(Punto2D p) { //Distanciia del punto al origen
        double originDistance = metricaEuclidiana(new Punto2D(), p);
        return originDistance;
    }


    public static double metricaEuclidiana(Punto2D a, Punto2D b) { //Distancia entre dos puntos cualquiera
        double ABdistance = Math.sqrt(Math.pow(a.getX() - b.getX(), 2) + Math.pow(a.getY() - b.getY(), 2));
        return ABdistance;
    }

    //Metrica Manhattan 
    public static double metricaTaxista(Punto2D a, Punto2D b) {
        double hypotenuse = metricaEuclidiana(a, b);
        double aSide = hypotenuse*(Math.sqrt(3)/2);
        double bSide = Math.sqrt(Math.pow(hypotenuse, 2) - Math.pow(aSide, 2));
        double result = aSide + bSide;
        return result;
    }


    public static double dotProduct(Punto2D a, Punto2D b) {
        double dotProduct = (a.getX()*b.getX()) + (a.getY()*b.getY());
        return dotProduct;
    }


    public static double area(Punto2D a, Punto2D b) {

        Punto2D forBase = new Punto2D(b.getX(), a.getY());

        double area = (metricaEuclidiana(a, forBase) * metricaEuclidiana(b, forBase));
        return area;
    }
}
