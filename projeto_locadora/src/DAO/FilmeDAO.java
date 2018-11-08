package DAO;

import Modelo.Filme;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class FilmeDAO extends ExecuteSQL{
  
    public FilmeDAO(Connection con) {
        super(con);
    }
  
     public String InserirFilme(Filme c) {
        String sql = "INSERT INTO filme VALUES (0,?,?,?,?,?,?)";
        try {
            PreparedStatement ps = getCon().prepareStatement(sql);
            ps.setString(1, c.getTitulo());
            ps.setInt(2, c.getAno());
            ps.setString(3, c.getDuracao());
            ps.setInt(4, c.getCodigoCategoria());
            ps.setInt(5, c.getCodigoClassificacao());
            ps.setString(6, c.getCapa());
            
            if (ps.executeUpdate() > 0) {
                return "Cliente cadastrado com sucesso.";
            } else {
                return "Erro ao cadastrar cliente.";
            }
        } catch (SQLException e) {
            return e.getMessage();
        }
    }

    public String ExcluirFilme(Filme f) {
        String sql = "DELETE FROM filme WHERE idfilme = ? AND titulo = ?";
        try {
            PreparedStatement ps = getCon().prepareStatement(sql);
            ps.setInt(1, f.getCodigo());
            ps.setString(2, f.getTitulo());
            
            if (ps.executeUpdate() > 0) {
                return "Excluido(a)!";
            } else {
                return "Problema ao excluir filme.";
            }
        } catch (SQLException e) {
            return e.getMessage();
        }
    }

    public List<Filme> ListarComboFilme() {
        String sql = "SELECT titulo FROM filme ORDER BY titulo";
        List<Filme> lista = new ArrayList<>();
        try {
            PreparedStatement ps = getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            if (rs != null) {
                while (rs.next()) {
                    Filme f = new Filme();
                    f.setTitulo(rs.getString(1));
                    lista.add(f);
                }
                return lista;
            } else {
                return null;
            }
        } catch (Exception e) {
            return null;
        }
    }

    public List<Filme> ConsultaCodigoFilme(String cod) {
        String sql = "SELECT idfilme FROM filme WHERE titulo = '" + cod + "'";
        List<Filme> lista = new ArrayList<>();
        try {
            PreparedStatement ps = getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            if (rs != null) {
                while (rs.next()) {
                    Filme f = new Filme();
                    f.setCodigo(rs.getInt(1));
                    lista.add(f);
                }
                return lista;
            } else {
                return null;
            }
        } catch (SQLException e) {
            return null;
        }
    }

    public List<Filme> ListarFilme() {
        String sql = "SELECT idfilme, titulo, ano, duracao, idcategoria, idclassificacao FROM filme";
        List<Filme> lista = new ArrayList<>();
        try {
            PreparedStatement ps = getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            if (rs != null) {
                while (rs.next()) {
                    Filme f = new Filme();
                    f.setCodigo(rs.getInt(1));
                    f.setTitulo(rs.getString(2));
                    f.setAno(rs.getInt(3));
                    f.setDuracao(rs.getString(4));
                    f.setCodigoCategoria(rs.getInt(5));
                    f.setCodigoClassificacao(rs.getInt(6));
                    lista.add(f);
                }
                return lista;
            } else {
                return null;
            }
        } catch (SQLException e) {
            return null;
        }
    }

    public List<Filme> PesquisarTituloFilme(String titulo) {
        String sql = "SELECT idfilme, titulo, ano, duracao, idcategoria, idclassificacao FROM filme WHERE titulo LIKE'" + titulo + "%'";
        List<Filme> lista = new ArrayList<>();
        try {
            PreparedStatement ps = getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            if (rs != null) {
                while (rs.next()) {
                    Filme f = new Filme();
                    f.setCodigo(rs.getInt(1));
                    f.setTitulo(rs.getString(2));
                    f.setAno(rs.getInt(3));
                    f.setDuracao(rs.getString(4));
                    f.setCodigoCategoria(rs.getInt(5));
                    f.setCodigoClassificacao(rs.getInt(6));
                    lista.add(f);
                }
                return lista;
            } else {
                return null;
            }
        } catch (SQLException e) {
            return null;
        }
    }

    public List<Filme> PegarIDFilme(int id) {
        String sql = "SELECT  idfilme, titulo, ano, duracao, idcategoria, idclassificacao FROM filme WHERE idfilme LIKE'" + id + "%'";
        List<Filme> lista = new ArrayList<>();
        try {
            PreparedStatement ps = getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            if (rs != null) {
                while (rs.next()) {
                    Filme f = new Filme();
                    f.setCodigo(rs.getInt(1));
                    f.setTitulo(rs.getString(2));
                    f.setAno(rs.getInt(3));
                    f.setDuracao(rs.getString(4));
                    f.setCodigoCategoria(rs.getInt(5));
                    f.setCodigoClassificacao(rs.getInt(6));
                    lista.add(f);
                }
                return lista;
            } else {
                return null;
            }
        } catch (SQLException e) {
            return null;
        }
    }

    public List<Filme> CapturarFilme(int cod) {
        String sql = "SELECT * FROM filme WHERE idfilme = " + cod + "";
        List<Filme> lista = new ArrayList<>();
        try {
            PreparedStatement ps = getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            if (rs != null) {
                while (rs.next()) {
                    Filme f = new Filme();
                    f.setCodigo(rs.getInt(1));
                    f.setTitulo(rs.getString(2));
                    f.setAno(rs.getInt(3));
                    f.setDuracao(rs.getString(4));
                    f.setCodigoCategoria(rs.getInt(5));
                    f.setCodigoClassificacao(rs.getInt(6));
                    f.setCapa(rs.getString(7));
                    lista.add(f);
                }
                return lista;
            } else {
                return null;
            }
        } catch (SQLException e) {
            return null;
        }
    }

    public boolean TestarFilme(int cod) {
        boolean Resultado = false;
        try {
            String sql = "SELECT * FROM filme WHERE idfilme = " + cod + "";
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

    public String AlterarFilme(Filme f) {
        String sql = "UPDATE filme SET titulo = ?, ano = ?, duracao = ?, idcategoria = ?, idclassificacao = ?, capa = ? WHERE idfilme = ?";
        try {
            PreparedStatement ps = getCon().prepareStatement(sql);
            ps.setString(1, f.getTitulo());
            ps.setInt(2, f.getAno());
            ps.setString(3, f.getDuracao());
            ps.setInt(4, f.getCodigoCategoria());
            ps.setInt(5, f.getCodigoClassificacao());
            ps.setString(6, f.getCapa());
            ps.setInt(7, f.getCodigo());
            
            if (ps.executeUpdate() > 0) {
                return "Editado(a)!";
            } else {
                return "Problema ao editar filme.";
            }
        } catch (SQLException e) {
            return e.getMessage();
        }
    }

    public List<Filme> PerquisarCodigoFilme(int cod) {
        String sql = "SELECT idfilme, titulo, ano, duracao, idcategoria, idclassificacao, capa FROM filme WHERE idfilme = '" + cod + "'";
        List<Filme> lista = new ArrayList<>();
        try {
            PreparedStatement ps = getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            if (rs != null) {
                while (rs.next()) {
                    Filme f = new Filme();
                    f.setCodigo(rs.getInt(1));
                    f.setTitulo(rs.getString(2));
                    f.setAno(rs.getInt(3));
                    f.setDuracao(rs.getString(4));
                    f.setCodigoCategoria(rs.getInt(5));
                    f.setCodigoClassificacao(rs.getInt(6));
                    f.setCapa(rs.getString(7));
                    lista.add(f);
                }
                return lista;
            } else {
                return null;
            }
        } catch (SQLException e) {
            return null;
        }
    }
    
    public List<Filme> CodigoID() {
        String sql = "SELECT MAX(idfilme) FROM filme";
        List<Filme> lista = new ArrayList<>();
        try {
            PreparedStatement ps = getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            if (rs != null) {
                while (rs.next()) {
                    Filme f = new Filme();
                    f.setFCodigo(rs.getInt(1));
                    lista.add(f);
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
