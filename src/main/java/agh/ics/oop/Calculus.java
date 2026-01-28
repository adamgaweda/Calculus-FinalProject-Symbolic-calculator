package agh.ics.oop;

import static java.lang.Math.sqrt;

public class Calculus {

    public static double[][] mes(int n) {
        double d = 2;
        double h = d/n;
        double[] x  = new double[n+1];
        for(int i=0;i<n+1;i++){
            x[i]=i*h;
        }
        //wyznaczenie n+1 węzłów

        double[][] B = new double[n+1][n+1];
        double[] L = new double[n+1];
        double[] gauss = new double[2];
        gauss[0] = -1/sqrt(3);
        gauss[1] = 1/sqrt(3);

        for(int e=0;e<n;e++){
            double x1=x[e];
            double x2=x[e+1];
            double J = (x2-x1)/2;

            for(int j=0;j<2;j++){
                double shift = (x2-x1)/2 *gauss[j] + (x1+x2)/2;

                double[] N = new double[2];
                double[] dN = new double[2];
                N[0]=(x2-shift)/h;
                N[1]=(shift-x1)/h;
                dN[0]=-1/h;
                dN[1]=1/h;
                //jeśli się pojawi błąd to użyj chwilowych tablic i w oddzielnej pętli dodaj do końcowej macierzy
                for (int k=0;k<2;k++){
                    for (int m=0;m<2;m++){
                        B[e+k][e+m]+=J*(dN[k]*dN[m]-N[k]*N[m]);
                    }
                    L[e+k]+= 5*Math.sin(shift*2*Math.acos(-1))*N[k]*J;
                    //wagi są 1, więc pomijam w obliczeniach
                }

            }

        }
        B[n][n]+=1;
        L[n]-= 8;
        for(int i=0;i<n+1;i++){
            B[0][i]=0;
        }
        B[0][0]=1;
        L[0]=1;

        double[] answer= Gauss_elim(B,L);
        double[][] wynik = new double[n+1][2];
        for(int i=0;i<n+1;i++){
            wynik[i][0]=x[i];
        }
        for(int i=0;i<n+1;i++){
            wynik[i][1]=answer[i];
        }

        System.out.println("\nRozwiązanie u(x):");
        for (int i=0; i<=n; i++) {
            System.out.printf("x=%.3f, u=%.5f\n", wynik[i][0], wynik[i][1]);
        }

        return wynik;
    }

    private static double[] Gauss_elim(double[][] B, double[] L ) {
        int n = L.length;
        for(int i=0;i<n;i++){
            double pivot = B[i][i];
            for(int j=i;j<n;j++){
                B[i][j] /= pivot;
            }
            L[i] /= pivot;
            for(int j=i+1;j<n;j++){
                double factor = B[j][i];
                for(int k=i;k<n;k++){
                    B[j][k] -= factor* B[i][k];
                }
                L[j] -= factor*L[i];
            }
        }
        double[] x1 = new double[n];
        for(int i=n-1;i>-1;i--){
            double suma=0;
            for(int j=i+1;j<n;j++){
                suma+=B[i][j]*x1[j];
            }
            x1[i]=L[i] - suma;
        }
        return x1;
    }

}
