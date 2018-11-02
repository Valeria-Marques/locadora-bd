package DAO;

import Modelo.Aluguel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class AlugueDAO extends ExecuteSQL{
    public AlugueDAO(Connection con) {
        super(con);
    }
    public String InserirAluguel(Aluguel a) {
        String sql = "INSERT INTO aluguel VALUES (0,?,?,?,?,?)";
        try {
            PreparedStatement ps = getCon().prepareStatement(sql);
            ps.setInt(1, a.getCoddvd());
            ps.setInt(2, a.getCodcliente());
            ps.setString(3, a.getHorario());
            ps.setString(4, a.getDataAluguel());
            ps.setString(5, a.getDataDevolucao());
            
            if (ps.executeUpdate() > 0) {
                return "Alugado(a)!";
            } else {
                return "Problema ao alugar";
            }
        } catch (SQLException e) {
            return e.getMessage();
        }
    }
    public List<Aluguel> ListarAluguel() {
        String sql = "SELECT * FROM aluguel";
        List<Aluguel> lista = new ArrayList<>();
        try {
            PreparedStatement ps = getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            if (rs != null) {
                while (rs.next()) {
                    Aluguel a = new Aluguel();
                    a.setCod(rs.getInt(1));
                    a.setCoddvd(rs.getInt(2));
                    a.setCodcliente(rs.getInt(3));
                    a.setHorario(rs.getString(4));
                    a.setDataAluguel(rs.getString(5));
                    a.setDataDevolucao(rs.getString(6));
                    lista.add(a);
                }
                return lista;
            } else {
                return null;
            }
        } catch (SQLException e) {
            return null;
        }
    }

    public List<Aluguel> PesquisarCodigoAluguel(int cod) {
        String sql = "SELECT FROM aluguel WHERE idaluguel = " + cod + "";
        List<Aluguel> lista = new ArrayList<>();
        try {
            PreparedStatement ps = getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            if (rs != null) {
                while (rs.next()) {
                    Aluguel a = new Aluguel();
                    a.setCod(rs.getInt(1));
                    a.setCoddvd(rs.getInt(2));
                    a.setCodcliente(rs.getInt(3));
                    a.setHorario(rs.getString(4));
                    a.setDataAluguel(rs.getString(5));
                    a.setDataDevolucao(rs.getString(6));
                    lista.add(a);
                }
                return lista;
            } else {
                return null;
            }
        } catch (SQLException e) {
            return null;
        }
    }

    public List<Aluguel> PesquisarCodigoDVD(int cod) {
        String sql = "SELECT FROM aluguel WHERE iddvd = " + cod + "";
        List<Aluguel> lista = new ArrayList<>();
        try {
            PreparedStatement ps = getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            if (rs != null) {
                while (rs.next()) {
                    Aluguel a = new Aluguel();
                    a.setCod(rs.getInt(1));
                    a.setCoddvd(rs.getInt(2));
                    a.setCodcliente(rs.getInt(3));
                    a.setHorario(rs.getString(4));
                    a.setDataAluguel(rs.getString(5));
                    a.setDataDevolucao(rs.getString(6));
                    lista.add(a);
                }
                return lista;
            } else {
                return null;
            }
        } catch (SQLException e) {
            return null;
        }
    }

    public List<Aluguel> PesquisarCodigoCliente(int cod) {
        String sql = "SELECT * FROM aluguel WHERE idcliente = " + cod + "";
        List<Aluguel> lista = new ArrayList<>();
        try {
            PreparedStatement ps = getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            if (rs != null) {
                while (rs.next()) {
                    Aluguel a = new Aluguel();
                    a.setCod(rs.getInt(1));
                    a.setCoddvd(rs.getInt(2));
                    a.setCodcliente(rs.getInt(3));
                    a.setHorario(rs.getString(4));
                    a.setDataAluguel(rs.getString(5));
                    a.setDataDevolucao(rs.getString(6));
                    lista.add(a);
                }
                return lista;
            } else {
                return null;
            }
        } catch (SQLException e) {
            return null;
        }
    }

    public String DevolverFilme(Aluguel a) {
        String sql = "DELETE FROM aluguel WHERE idaluguel = ? ";
        try {
            PreparedStatement ps = getCon().prepareStatement(sql);
            ps.setInt(1, a.getCod());
            if (ps.executeUpdate() > 0) {
                return "Filime devolvido!";
            } else {
                return "Problema ao devolver o filme.";
            }
        } catch (SQLException e) {
            return e.getMessage();
        }
    }

    public String AtualizarSituacao(String a, int cod) {
        String sql = "UPDATE dvd SET situacao = '" + a + "' WHERE iddvd = " + cod + "";
        try {
            PreparedStatement ps = getCon().prepareStatement(sql);

            if (ps.executeUpdate() > 0) {
                return "Situação atualizada!";
            } else {
                return "Problema ao atualizar a situação.";
            }
        } catch (SQLException e) {
            return e.getMessage();
        }
    }
    
    public List<Aluguel> ProximoID() {
        String sql = "SELECT MAX(idcategoria) FROM categoria";
        List<Aluguel> lista = new ArrayList<>();
        try {
            PreparedStatement ps = getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            if (rs != null) {
                while (rs.next()) {
                    Aluguel a = new Aluguel();
                    a.setFCodigo(rs.getInt(1));
                    lista.add(a);
                }
                return lista;
            } else {
                return null;
            }
        } catch (SQLException e) {
            return null;
        }
    }
    
    public List<Aluguel> CodigoID() {
        String sql = "SELECT MAX(idaluguel) FROM aluguel";
        List<Aluguel> lista = new ArrayList<>();
        try {
            PreparedStatement ps = getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            if (rs != null) {
                while (rs.next()) {
                    Aluguel a = new Aluguel();
                    a.setFCodigo(rs.getInt(1));
                    lista.add(a);
                }
                return lista;
            } else {
                return null;
            }
        } catch (SQLException e) {
            return null;
        }
    }
   
}
