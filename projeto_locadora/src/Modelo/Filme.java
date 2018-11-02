package Modelo;
public class Filme {
    private int codigo;
    private String titulo;
    private int ano;
    private String duracao;
    private int CodigoCategoria;
    private int CodigoClassificacao;
    private String capa;
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

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public String getDuracao() {
        return duracao;
    }

    public void setDuracao(String duracao) {
        this.duracao = duracao;
    }

    public int getCodigoCategoria() {
        return CodigoCategoria;
    }

    public void setCodigoCategoria(int cod_categoria) {
        this.CodigoCategoria = CodigoCategoria;
    }

    public int getCodigoClassificacao() {
        return CodigoClassificacao;
    }

    public void setCodigoClassificacao(int cod_classificacao) {
        this.CodigoClassificacao = CodigoClassificacao;
    }

    public String getCapa() {
        return capa;
    }

    public void setCapa(String capa) {
        this.capa = capa;
    }
    
}
