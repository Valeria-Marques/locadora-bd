package Modelo;
public class Classificacao {
    private int codigo;
    private String nome;
    private double preco;
    private int FCodigo;

    public int getFCodigo() {
        return FCodigo;
    }

    public void setFCodigo(int FCodigo) {
        this.FCodigo = FCodigo;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }
    
    
}
