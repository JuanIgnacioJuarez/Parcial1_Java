import java.util.Scanner;
import java.util.Random;
public class Main {
    static Scanner sc = new Scanner(System.in);
    static Random random = new Random();

    public static void main(String[] args) {
        boolean repetir = true;
        do {
            System.out.println("Ingrese la dimensión de la matriz (nxn) \n" +
                    "(Debe ser impar y estar entre 3 y 15): ");
            int n = sc.nextInt();
            boolean vuelta = true;
            do {
                if (n % 2 != 0 && n >= 3 && n <= 15) {
                    vuelta = false;
                } else {
                    System.out.println("Número inválido, inténtelo de nuevo: ");
                    n = sc.nextInt();
                }
            } while (vuelta == true);

            int[][] matriz = new int[n][n];
            for (int i = 0; i < n; i++) {
                if (i == n - 1) {
                    System.out.println("Fila " + n + " ingrese sus valores: ");
                }
                for (int j = 0; j < n; j++) {
                    int valor;
                    if (i == n - 1) {
                        vuelta = true;
                        do {
                            valor = sc.nextInt();
                            if (valor >= 10 && valor <= 99) {
                                matriz[i][j] = valor;
                                vuelta = false;
                            } else {
                                System.out.println("Intente nuevamente.");
                            }
                        } while (vuelta == true);
                    } else {
                        valor = random.nextInt(90) + 10;
                        matriz[i][j] = valor;
                    }
                }
            }

            System.out.println("\nArray resultante: ");
            for (int i = 0; i < n; i++) {
                System.out.println("");
                for (int j = 0; j < n; j++) {
                    System.out.print(matriz[i][j] + " ");
                }
            }

            int[] valoresCentrales;
            valoresCentrales = Metodos.obtenerValoresCentrales(matriz);

            System.out.println("\n\nMatriz de valores centrales");
            System.out.println("");
            for (int i = 0; i < 9; i++) {
                System.out.print(valoresCentrales[i] + " ");
            }

            int[] valoresOrdenados;
            valoresOrdenados = Metodos.burbuja(valoresCentrales);

            System.out.println("\n\nMatriz de valores centrales ordenados");
            System.out.println("");
            for (int i = 0; i < 9; i++) {
                System.out.print(valoresOrdenados[i] + " ");
            }

            double promTotal = Metodos.calcularPromedioDeMatrices(matriz, valoresCentrales);
            System.out.println("\nEl promedio de las dos matrices es " + promTotal);

            sc.nextLine();
            System.out.println("¿Desea volver a empezar? S = si / N = no");
            String opc = sc.nextLine();
            repetir = Metodos.repetir(opc);

        }while (repetir == true);
    }
}