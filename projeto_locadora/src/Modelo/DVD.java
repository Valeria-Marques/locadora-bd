package Modelo;
public class DVD {
    private int codigo;
    private int CodigoFilme;
    private String situacao;
    private double preco;
    private String DataCompra;
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

    public int getCodigoFilme() {
        return CodigoFilme;
    }

    public void setCodigoFilme(int cod_filme) {
        this.CodigoFilme = CodigoFilme;
    }

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public String getDataCompra() {
        return DataCompra;
    }

    public void setDataCompra(String data_compra) {
        this.DataCompra = DataCompra;
    }
    
}
