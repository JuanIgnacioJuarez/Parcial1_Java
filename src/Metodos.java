public class Metodos {
    public static int[] obtenerValoresCentrales(int[][] matriz){
        int[] valoresCentrales = new int[9];
        int posCentro = matriz.length/2;
        int cont = 0;
        for (int i = posCentro - 1; i <= posCentro + 1; i++){
            for (int j = posCentro -1; j <= posCentro +1; j++){
                valoresCentrales[cont] = matriz[i][j];
                cont = cont+1;
            }
        }
        return valoresCentrales;
    }
    public static int[] burbuja(int[] A){
        int n = A.length;
        boolean intercambiado;
        do{
            intercambiado = false;
            for (int i = 1; i<n; i++){
                if (A[i-1] > A[i]){
                    int aux = A[i-1];
                    A[i-1] = A[i];
                    A[i] = aux;
                    intercambiado = true;
                }
            }
        }while (intercambiado == true);
        return A;
    }
    public static double calcularPromedioDeMatrices (int[][] matriz, int[] matrizValoresCentral){
        double promTotal = 0, promUno = 0, promDos = 0;
        int cont = 0, suma = 0;

        for (int i = 0; i < matriz.length; i++){
            for (int j = 0; j < matriz.length; j++){
                cont ++;
                suma = suma +  matriz[i][j];
            }
        }
        promUno = suma/cont;
        System.out.println("\nMatriz 1: Suma total(" + suma + ") cantidad de elementos (" + cont + ") promedio = " + promUno);

        cont = 0;
        suma = 0;
        for (int i = 0; i < matrizValoresCentral.length; i++) {
            cont ++;
            suma = suma +  matrizValoresCentral[i];
        }
        promDos = suma/cont;
        System.out.println("Matriz 2: Suma total(" + suma + ") cantidad de elementos (" + cont + ") promedio = " + promDos);

        promTotal = (promUno + promDos) / 2;
        return promTotal;
    }
    public static boolean repetir(String opc){
        boolean repetir = true;
        do {
            if (opc.equalsIgnoreCase("S") || opc.equalsIgnoreCase("N")){
                if (opc.equalsIgnoreCase("S")){
                    System.out.println("Empezando de nuevo...");
                    break;
                }else{
                    System.out.println("Saliendo...");
                    repetir = false;
                }
            }else{
                System.out.println("Caracter inválido, vuelva a intentarlo");
            }
        }while (repetir == true);
        return repetir;
    }
}
