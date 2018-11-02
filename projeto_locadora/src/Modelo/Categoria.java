package Modelo;
public class Categoria {
    private int codigo;
    private String nome;
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
    
}
