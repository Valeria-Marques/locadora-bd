/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;


/**
 *
 * @author tharl
 */

public class Listar {
    
    static private int codigo;
    static private int codaluguel;
    static private int codcliente;
    
    static private String hora;
    static private String dataLocacao;
    static private String dataDevolucao;

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getDataLocacao() {
        return dataLocacao;
    }

    public void setDataLocacao(String dataLocacao) {
        this.dataLocacao = dataLocacao;
    }

    public String getDataDevolucao() {
        return dataDevolucao;
    }

    public void setDataDevolucao(String dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }

    public static int getCodigo() {
        return codigo;
    }

    public static void setCodigo(int codigo) {
        Listar.codigo = codigo;
    }

    public static int getCodaluguel() {
        return codaluguel;
    }

    public static void setCodaluguel(int codaluguel) {
        Listar.codaluguel = codaluguel;
    }

    public static int getCodcliente() {
        return codcliente;
    }

    public static void setCodcliente(int codcliente) {
        Listar.codcliente = codcliente;
    }

}
