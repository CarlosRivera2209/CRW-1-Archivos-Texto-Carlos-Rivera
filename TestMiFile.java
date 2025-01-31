package Progra2_Parcial2;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class TestMiFile {

    static MiFile mf = new MiFile();
    static Scanner lea = new Scanner(System.in);

    public static void main(String args[]) {
        int opcion = 0;
        do {
            System.out.println("\nMENU\n");
            System.out.println("1- Set el archivo / folder.");
            System.out.println("2- Ver información.");
            System.out.println("3- Crear un archivo.");
            System.out.println("4- Crear un folder.");
            System.out.println("5- Borrar.");
            System.out.println("6- CMD - DIR.");
            System.out.println("7- Tree.");
            System.out.println("8- Escribir (reemplazar).");
            System.out.println("9- Escribir (mantener contenido).");
            System.out.println("10- Leer archivo.");
            System.out.println("11- Salir.");
            System.out.println("Escoja una opción");

            try {
                opcion = lea.nextInt();
                lea.nextLine();

                switch (opcion) {
                    case 1:
                        set();
                        break;
                    case 2:
                        mf.Info();
                        break;
                    case 3:
                        mf.crearFile();
                        break;
                    case 4:
                        mf.crearFolder();
                        break;
                    case 5:
                        mf.Borrar();
                        break;
                    case 6:
                        mf.dir();
                        break;
                    case 7:
                        mf.tree();
                        break;
                    case 8:
                        escribirReemplazar();
                        break;
                    case 9:
                        escribirAppend();
                        break;
                    case 10:
                        mf.leerArchivo();
                        break;
                    case 11:
                        System.out.println("Saliendo...");
                        break;
                    default:
                        System.out.println("Opción no válida. Intente de nuevo.");
                }
            } catch (InputMismatchException e) {
                lea.nextLine();
                System.out.println("Por favor, escoja una opción válida.");
            } catch (NullPointerException e) {
                System.out.println("Se debe escoger la opción 1 por lo menos una vez.");
            } catch (IOException e) {
                System.out.println("Error: " + e.getMessage());
            }

        } while (opcion != 11);
    }

    private static void set() {
        System.out.println(" Dirección: ");
        mf.setFile(lea.next());
    }

    private static void escribirReemplazar() throws IOException {
        System.out.println("Ingrese el contenido a escribir (se reemplazará el contenido existente): ");
        String contenido = lea.nextLine();
        mf.escribirReemplazar(contenido);
    }

    private static void escribirAppend() throws IOException {
        System.out.println("Ingrese el contenido a escribir (se mantendrá el contenido existente): ");
        String contenido = lea.nextLine();
        mf.escribirAppend(contenido);
    }
}
