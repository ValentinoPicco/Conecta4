package conecta4;

import java.util.Scanner;
import javax.swing.JFrame;

public class App {

    public static void main(String[] args) {
        int opcion; // opcion del menu
        Scanner entrada = new Scanner(System.in);

        menu();
        do {
            opcion = entrada.nextInt();
            System.out.println();
            switch (opcion) {
                case 1:
                    partidaCBot();
                    menu();
                    break;
                
                case 2:
                    partidaCAmigo();
                    menu();
                    break;
                case 3:
                    salir();
                    break;
                default:
                    opcionNoValida();
                    menu();
                    break;
            }
        } while (opcion != 3);
        entrada.close();
    }

    public static void menu(){
        System.out.println("          Conecta 4" );
        System.out.println("        Menu Principal");
        System.out.println();
        System.out.println();
        System.out.println("       Elige una opcion:");
        System.out.println("    1. Jugar contra un bot");
        System.out.println("     2. Jugar con un amigo");
        System.out.println("          3. Salir");
    }

    public static void partidaCBot(){
        JFrame bg = new JFrame("Conecta4");
        bg.setSize(1000, 600);
        bg.setVisible(true);
    }

    public static void partidaCAmigo(){

    }

    public static void salir(){
        System.out.println("       Gracias por jugar");
    }

    public static void opcionNoValida(){
        System.out.println(" Selecciono una opcion no valida");
        System.out.println("Las opciones validas son 1, 2 o 3");
        System.out.println();
    }
}
