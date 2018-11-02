package Modelo;
public class Listar {
    static private int CodigoDVD;
    static private int CodigoAluguel;
    static private int CodigoCliente;

    public static int getCodigoDVD() {
        return CodigoDVD;
    }

    public static void setCodigoDVD(int CodigoDVD) {
        Listar.CodigoDVD = CodigoDVD;
    }

    public static int getCodigoAluguel() {
        return CodigoAluguel;
    }

    public static void setCodigoAluguel(int CodigoAluguel) {
        Listar.CodigoAluguel = CodigoAluguel;
    }

    public static int getCodigoCliente() {
        return CodigoCliente;
    }

    public static void setCodigoCliente(int CodigoCliente) {
        Listar.CodigoCliente = CodigoCliente;
    }
}
