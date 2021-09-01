

public class Taller01Sismos {
    public static void main(String[] args) {

    }
    public static double[][] llenarArreglo(){
        double[][] sismos = new double[7][10];
        for (int i = 0; i<sismos.length;i++){
            for (int j=0;j<sismos[i].length;j++){
                sismos[i][j]=(Math.random()*9.5);
            }
        }

    return sismos;
    }
}
