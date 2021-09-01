import java.util.Scanner;
import java.util.Random;

public class Taller01Sismos {
    public static void main(String[] args) {
        opcionMenu();
    }

    public static double[][] llenarArreglo() {
        double[][] sismos = new double[10][7];
        Random rand = new Random();
        for (int i = 0; i < sismos.length; i++) {
            for (int j = 0; j < sismos[i].length; j++) {
                sismos[i][j] = Math.round((0 + (9.5) * rand.nextDouble()) * 100.0) / 100.0;
                System.out.printf(" "+sismos[i][j]+" ");
            } System.out.println(" ");
        }
    return sismos;
    }

    public static double[] buscarMayorSismo(double[][] sismos) {
        double mayor = sismos[0][0];
        double[] datos = new double[3];
        for (int i = 0; i < sismos.length; i++) {
            for (int j = 0; j < sismos[i].length; j++) {
                if (mayor < sismos[i][j]) {
                    mayor = sismos[i][j];
                    datos[0]=mayor;
                    datos[1]=i+1;
                    datos[2]=j+1;

                }
            }
        }
        return datos;
    }
    public static void mostrarMayorSismo(double[] mayorSismo){
        System.out.println("El mayor sismo registrado está semana es: "+ mayorSismo[0]+" el día número " + (int)mayorSismo[2]+" en el registro n°"+(int)mayorSismo[1]);
    }
    public static void contarSismos(double[][] sismos) {
        int contadorSismo = 0;
        for (int i = 0; i < sismos.length; i++) {
            for (int j = 0; j < sismos[i].length; j++) {
                if (5.0 <= sismos[i][j]) {
                    contadorSismo++;
                }
            }
        }
        mostrarcontarSismos(contadorSismo);
    }
    public static void contadorSismico(double[][] sismos){
        for (int i = 0; i < sismos.length; i++) {
            for (int j = 0; j < sismos[i].length; j++) {
                if(7.0<=sismos[i][j]){
                    enviarSms();
                }
            }
        }
    }
    public static void enviarSms() {
        System.out.println("Alerta!!! se debe evacuar zona costera!");
    }
    public static void mostrarcontarSismos(int datosSismos){
        System.out.println("Se generaron " + datosSismos+" sismos de gran intensidad");
    }
    public static void mostrarMenu() {
        System.out.println("--------------------------------------------------");
        System.out.println("Ingrese una opción:");
        System.out.println("[1] Ingresar datos.");
        System.out.println("[2] Mostrar sismo de mayor magnitud.");
        System.out.println("[3] Contar sismos mayores o iguales a 5.0.");
        System.out.println("[4] Enviar SMS por cada sismo mayor o igual a 7.0");
        System.out.println("[0] Salir (S/N)");
        System.out.println("--------------------------------------------------");
    }
    public static void opcionMenu() {
        Scanner tecla = new Scanner(System.in);
        double[][] sismos = new double[10][7];
        int aux = 0;
        while (aux == 0) {
            mostrarMenu();
            String opcion = tecla.next();
            switch (opcion) {
                case "1":
                    sismos = llenarArreglo();
                    System.out.println("Los datos se han ingresado correctamente");
                    break;
                case "2":
                    if(validarDatosSismos(sismos)) {
                        mostrarMayorSismo(buscarMayorSismo(sismos));
                    }else {
                        System.err.println("no se han ingresado datos");
                    }
                    break;
                case "3":
                    if(validarDatosSismos(sismos)) {
                    contarSismos(sismos);
                        contadorSismico(sismos);
                     }else {
                    System.err.println("no se han ingresado datos");
                    }
                    break;
                case "4":
                    if(validarDatosSismos(sismos)) {
                        contadorSismico(sismos);
                    }else {
                        System.err.println("no se han ingresado datos");
                    }
                    break;
                case "0":
                    aux = 1;
                    break;
                default:
                    System.err.println("opcion ingresada no valida");
            }
        }
    }
    public static boolean validarDatosSismos(double[][] sismos){
        int contador = 0;
        for (int i = 0; i < sismos.length; i++) {
            for (int j = 0; j < sismos[i].length; j++) {
                if(sismos[i][j]==0){
                    contador++;
                }
            }
        }
        if (contador==70){
            return false;
        }
    return true;}
}
