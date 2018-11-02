package Modelo;
public class Aluguel {
    private int cod;
    private int coddvd;
    private int codcliente;
    private String DataAluguel;
    private String horario;
    private String DataDevolucao;
    private int FCodigo;

    public int getCod() {
        return cod;
    }

    public void setCod(int cod) {
        this.cod = cod;
    }

    public int getCoddvd() {
        return coddvd;
    }

    public void setCoddvd(int coddvd) {
        this.coddvd = coddvd;
    }

    public int getCodcliente() {
        return codcliente;
    }

    public int getFCodigo() {
        return FCodigo;
    }

    public void setFCodigo(int FCodigo) {
        this.FCodigo = FCodigo;
    }

    public void setCodcliente(int codcliente) {
        this.codcliente = codcliente;
    }

    public String getDataAluguel() {
        return DataAluguel;
    }

    public void setDataAluguel(String data_aluguel) {
        this.DataAluguel = DataAluguel;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public String getDataDevolucao() {
        return DataDevolucao;
    }

    public void setDataDevolucao(String data_devolucao) {
        this.DataDevolucao = DataDevolucao;
    }
    
}
