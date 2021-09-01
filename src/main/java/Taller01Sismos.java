import java.util.Scanner;
import java.util.Random;

public class Taller01Sismos {
    public static void main(String[] args) {
        opcionMenu();
    }

    public static double[][] llenarArreglo() {                                                  //en este metodo se instancia un arreglo de 10*7
        double[][] sismos = new double[7][10];
        Random rand = new Random();                                                             //se utiliza el objeto Random para crear numeros aleatorios y asi completar el arreglo
        for (int i = 0; i < sismos.length; i++) {
            for (int j = 0; j < sismos[i].length; j++) {
                sismos[i][j] = Math.round((0 + (9.5) * rand.nextDouble()) * 100.0) / 100.0;     //la libreria Math.round ayuda a redondear los numeros con 2 digitos decimales, para que sea mas legible los numeros creados por random
            }
        }
    return sismos;
    }

    public static double[] buscarMayorSismo(double[][] sismos) {                                //decidí que retornara un arreglo, para obtener mayor informacion de los sismos a la hora de mostrarlos
        double mayor = sismos[0][0];                                                            //se utiliza un auxiliar para almacenar el mayor momentaneamente, hasta que se complete el ciclo
        double[] datos = new double[3];
        for (int i = 0; i < sismos.length; i++) {
            for (int j = 0; j < sismos[i].length; j++) {
                if (mayor < sismos[i][j]) {
                    mayor = sismos[i][j];                                                       //si cumple las condiciones se almacena en el arreglo, ademas almacenamos el día y el numero de registro hecho
                    datos[0]=mayor;
                    datos[1]=i+1;
                    datos[2]=j+1;

                }
            }
        }
        return datos;
    }
    public static void mostrarMayorSismo(double[] mayorSismo){
        System.out.println("El mayor sismo registrado está semana es: "+ mayorSismo[0]+" el día número " + (int)mayorSismo[1]+" en el registro n°"+(int)mayorSismo[2]); //se muestra toda la informacion recopilada en el metodo anterior
    }
    public static void contarSismos(double[][] sismos) {                                        //para este metodo utilice un auxiliar para almacenar el numero de veces que se cumple la condicion y asi establecer los sismos de gran magnitud
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
    public static void contadorSismico(double[][] sismos){                                      //utilizando la misma manera del metodo anterior, se utilizó este metodo, pero a diferencia del anterior este almacena el dia en que se registro esa magnitud
        for (int i = 0; i < sismos.length; i++) {
            for (int j = 0; j < sismos[i].length; j++) {
                if(7.0<=sismos[i][j]){
                    enviarSms(i+1);
                }
            }
        }
    }
    public static void enviarSms(int día) {                                                     //se envia un sms alertando al publico, informando del día del suceso
        System.out.println("Alerta!!! se debe evacuar zona costera! día: "+día);
    }
    public static void mostrarcontarSismos(int datosSismos){
        System.out.println("Se generaron " + datosSismos+" sismos de gran intensidad");        //se muestra en pantalla los sismos de mayor intensidad
    }
    public static void mostrarMenu() {
        System.out.println("--------------------------------------------------");               //muestra las opciones posibles
        System.out.println("Ingrese una opción:");
        System.out.println("[1] Ingresar datos.");
        System.out.println("[2] Mostrar sismo de mayor magnitud.");
        System.out.println("[3] Contar sismos mayores o iguales a 5.0.");
        System.out.println("[4] Enviar SMS por cada sismo mayor o igual a 7.0");
        System.out.println("[0] Salir (S/N)");
        System.out.println("--------------------------------------------------");
    }
    public static void opcionMenu() {                                                           //en este metodo se maneja todas las opciones
        Scanner tecla = new Scanner(System.in);
        double[][] sismos = new double[7][10];                                                  //se crea un arreglo vacio
        int aux = 0;
        while (aux == 0) {
            mostrarMenu();                                                                      //llama a la opcion mostrarmenu
            String opcion = tecla.next();                                                       //se ingresa la opcion, se utiliza String, para asi evitar que se caiga el programa y poder manejar los errores.
            switch (opcion) {
                case "1":
                    sismos = llenarArreglo();                                                   //dado que el arreglo está vacio, se necesitan ingresar los datos primeramente para que funcione el programa.
                    System.out.println("Los datos se han ingresado correctamente");
                    break;
                case "2":
                    if(validarDatosSismos(sismos)) {                                             //para ello se necesita una validacion del arreglo. el cual verifica si el arreglo está vacio o no.
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
