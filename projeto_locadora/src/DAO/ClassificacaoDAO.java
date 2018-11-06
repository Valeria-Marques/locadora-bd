package DAO;

import Modelo.Classificacao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClassificacaoDAO extends ExecuteSQL{
    public ClassificacaoDAO(Connection con) {
        super(con);
    }

    public String InserirClassificacao(Classificacao c) {
        String sql = "INSERT INTO classificacao VALUES (0,?,?)";
        try {
            PreparedStatement ps = getCon().prepareStatement(sql);
            ps.setString(1, c.getNome());
            ps.setDouble(2, c.getPreco());
            
            if (ps.executeUpdate() > 0) {
                return "Classificação cadastrada!";
            } else {
                return "Problema ao cadastrar classificação.";
            }
        } catch (SQLException e) {
            return e.getMessage();
        }
    }

    public String ExcluirClassificacao(Classificacao c) {
        String sql = "DELETE FROM classificacao WHERE idclassificacao = ? AND nome = ?";
        try {
            PreparedStatement ps = getCon().prepareStatement(sql);
            ps.setInt(1, c.getCodigo());
            ps.setString(2, c.getNome());
            
            if (ps.executeUpdate() > 0) {
                return "Excluido(a)!";
            } else {
                return "Problema ao excluir.";
            }
        } catch (SQLException e) {
            return e.getMessage();
        }
    }

    public List<Classificacao> ListarComboClassificacao() {
        String sql = "SELECT nome FROM classificacao ORDER BY nome";
        List<Classificacao> lista = new ArrayList<>();
        try {
            PreparedStatement ps = getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            if (rs != null) {
                while (rs.next()) {
                    Classificacao c = new Classificacao();
                    c.setNome(rs.getString(1));
                    lista.add(c);
                }
                return lista;
            } else {
                return null;
            }
        } catch (Exception e) {
            return null;
        }
    }

    public List<Classificacao> ConsultaCodigoClassificacao(String nome) {
        String sql = "SELECT idclassificacao FROM classificacao WHERE nome = '" + nome + "'";
        List<Classificacao> lista = new ArrayList<>();
        try {
            PreparedStatement ps = getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            if (rs != null) {
                while (rs.next()) {
                    Classificacao c = new Classificacao();
                    c.setCodigo(rs.getInt(1));
                    lista.add(c);
                }
                return lista;
            } else {
                return null;
            }
        } catch (SQLException e) {
            return null;
        }
    }

    public List<Classificacao> ListarClassificacao() {
        String sql = "SELECT idclassificacao, nome, preco FROM classificacao";
        List<Classificacao> lista = new ArrayList<>();
        try {
            PreparedStatement ps = getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            if (rs != null) {
                while (rs.next()) {
                    Classificacao c = new Classificacao();
                    c.setCodigo(rs.getInt(1));
                    c.setNome(rs.getString(2));
                    c.setPreco(rs.getInt(3));
                    lista.add(c);
                }
                return lista;
            } else {
                return null;
            }
        } catch (SQLException e) {
            return null;
        }
    }

    public List<Classificacao> PesquisarNomeClassificacao(String C) {
        String sql = "SELECT idclassificacao, nome, preco FROM classificacao WHERE nome LIKE'" + C + "%'";
        List<Classificacao> lista = new ArrayList<>();
        try {
            PreparedStatement ps = getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            if (rs != null) {
                while (rs.next()) {
                    Classificacao c = new Classificacao();
                    c.setCodigo(rs.getInt(1));
                    c.setNome(rs.getString(2));
                    c.setPreco(rs.getInt(3));
                    lista.add(c);
                }
                return lista;
            } else {
                return null;
            }
        } catch (SQLException e) {
            return null;
        }
    }

    public List<Classificacao> PesquisarCodigoClassificacao(String cod) {
        String sql = "SELECT idclassificacao, nome, preco FROM classificacao WHERE idclassificacao LIKE'" + cod + "%'";
        List<Classificacao> lista = new ArrayList<>();
        try {
            PreparedStatement ps = getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            if (rs != null) {
                while (rs.next()) {
                    Classificacao c = new Classificacao();
                    c.setCodigo(rs.getInt(1));
                    c.setNome(rs.getString(2));
                    c.setPreco(rs.getInt(3));
                    lista.add(c);
                }
                return lista;
            } else {
                return null;
            }
        } catch (SQLException e) {
            return null;
        }
    }

    public boolean TestarClassificacao(int cod) {
        boolean Resultado = false;
        try {
            String sql = "SELECT * FROM classificacao WHERE idclassificacao = " + cod + "";
            PreparedStatement ps = getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            if (rs != null) {
                while (rs.next()) {
                    Resultado = true;
                }
            }
        } catch (SQLException ex) {
            ex.getMessage();
        }
        return Resultado;
    }

    public List<Classificacao> CapturarClassificacao(int cod) {
        String sql = "SELECT * FROM classificacao WHERE idclassificacao = " + cod + " ";
        List<Classificacao> lista = new ArrayList<>();
        try {
            PreparedStatement ps = getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            if (rs != null) {
                while (rs.next()) {
                    Classificacao c = new Classificacao();
                    c.setCodigo(rs.getInt(1));
                    c.setNome(rs.getString(2));
                    c.setPreco(rs.getInt(3));
                    lista.add(c);
                }
                return lista;
            } else {
                return null;
            }
        } catch (SQLException e) {
            return null;
        }
    }

    public String AlterarClassificacao(Classificacao c) {
        String sql = "UPDATE classificacao SET nome = ?, preco = ? WHERE idclassificacao = ? ";
        try {
            PreparedStatement ps = getCon().prepareStatement(sql);
            ps.setString(1, c.getNome());
            ps.setInt(2, c.getCodigo());
            ps.setInt(3, (int) c.getPreco());

            if (ps.executeUpdate() > 0) {
                return "Editado(a)!";
            } else {
                return "Problema ao editar.";
            }
        } catch (SQLException e) {
            return e.getMessage();
        }
    }
    
    public List<Classificacao> CodigoID() {
        String sql = "SELECT MAX(idclassificacao) FROM classificacao";
        List<Classificacao> lista = new ArrayList<>();
        try {
            PreparedStatement ps = getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            if (rs != null) {
                while (rs.next()) {
                    Classificacao c = new Classificacao();
                    c.setFCodigo(rs.getInt(1));
                    lista.add(c);
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
