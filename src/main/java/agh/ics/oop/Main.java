package agh.ics.oop;


public class Main {
    public static void main(){

        double[][] wynik = Calculus.mes(1000);
        new PlotFrame(wynik);

    }
}
