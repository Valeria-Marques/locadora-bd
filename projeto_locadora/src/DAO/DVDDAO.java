package DAO;

import Modelo.DVD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DVDDAO extends ExecuteSQL{
  public DVDDAO(Connection con) {
        super(con);
    }

    public String InserirDVD(DVD d) {
        String sql = "INSERT INTO dvd VALUES (0,?,?,?,?)";
        try {
            PreparedStatement ps = getCon().prepareStatement(sql);
            ps.setInt(1, d.getCodigoFilme());
            ps.setDouble(2, d.getPreco());
            ps.setString(3, d.getDataCompra());
            ps.setString(4, d.getSituacao());
            
            if (ps.executeUpdate() > 0) {
                return "DVD cadastrado!";
            } else {
                return "Problema ao cadastrar DVD.";
            }
        } catch (SQLException e) {
            return e.getMessage();
        }
    }

    public String ExcluirDVD(DVD d) {
        String sql = "DELETE FROM dvd WHERE iddvd = ?";
        try {
            PreparedStatement ps = getCon().prepareStatement(sql);
            ps.setInt(1, d.getCodigo());
            
            if (ps.executeUpdate() > 0) {
                return "Excluido(a)!";
            } else {
                return "Problema ao excluir DVD.";
            }
        } catch (SQLException e) {
            return e.getMessage();
        }
    }

    public List<DVD> ConsultaCodigoDVD(int cod) {
        String sql = "SELECT iddvd FROM dvd WHERE iddvd = '" + cod + "'";
        List<DVD> lista = new ArrayList<>();
        try {
            PreparedStatement ps = getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            if (rs != null) {
                while (rs.next()) {
                    DVD d = new DVD();
                    d.setCodigo(rs.getInt(1));
                    lista.add(d);
                }
                return lista;
            } else {
                return null;
            }
        } catch (SQLException e) {
            return null;
        }
    }

    public List<DVD> ListarComboDVD() {
        String sql = "SELECT iddvd FROM dvd ORDER BY iddvd";
        List<DVD> lista = new ArrayList<>();
        try {
            PreparedStatement ps = getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            if (rs != null) {
                while (rs.next()) {
                    DVD d = new DVD();
                    d.setCodigo(rs.getInt(1));
                    lista.add(d);
                }
                return lista;
            } else {
                return null;
            }
        } catch (Exception e) {
            return null;
        }
    }

    public List<DVD> ListarDVD() {
        String sql = "SELECT iddvd, idfilme, preco_compra, data_compra, situacao FROM dvd";
        List<DVD> lista = new ArrayList<>();
        try {
            PreparedStatement ps = getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            if (rs != null) {
                while (rs.next()) {
                    DVD d = new DVD();
                    d.setCodigo(rs.getInt(1));
                    d.setCodigoFilme(rs.getInt(2));
                    d.setPreco(rs.getDouble(3));
                    d.setDataCompra(rs.getString(4));
                    d.setSituacao(rs.getString(5));
                    lista.add(d);
                }
                return lista;
            } else {
                return null;
            }
        } catch (SQLException e) {
            return null;
        }
    }

    public List<DVD> CodigoDVD(int cod) {
        String sql = "SELECT iddvd FROM dvd WHERE iddvd LIKE'" + cod + "%'";
        List<DVD> lista = new ArrayList<>();
        try {
            PreparedStatement ps = getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            if (rs != null) {
                while (rs.next()) {
                    DVD d = new DVD();
                    d.setCodigo(rs.getInt(1));
                    lista.add(d);
                }
                return lista;
            } else {
                return null;
            }
        } catch (SQLException e) {
            return null;
        }
    }

    public List<DVD> PesquisarCodigoFilme(int cod) {
        String sql = "SELECT iddvd, idfilme, preco_compra, data_compra, situacao FROM dvd WHERE idfilme = " + cod + "";
        List<DVD> lista = new ArrayList<>();
        try {
            PreparedStatement ps = getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            if (rs != null) {
                while (rs.next()) {
                    DVD d = new DVD();
                    d.setCodigo(rs.getInt(1));
                    d.setCodigo(rs.getInt(2));
                    d.setPreco(rs.getInt(3));
                    d.setDataCompra(rs.getString(4));
                    d.setSituacao(rs.getString(5));
                    lista.add(d);
                }
                return lista;
            } else {
                return null;
            }
        } catch (SQLException e) {
            return null;
        }
    }

    public List<DVD> PegarIDFilme(int id) {
        String sql = "SELECT iddvd, idfilme, preco_compra, data_compra, situacao FROM dvd WHERE idfilme LIKE'" + id + "%'";
        List<DVD> lista = new ArrayList<>();
        try {
            PreparedStatement ps = getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            if (rs != null) {
                while (rs.next()) {
                    DVD d = new DVD();
                    d.setCodigo(rs.getInt(1));
                    d.setCodigoFilme(rs.getInt(2));
                    d.setPreco(rs.getDouble(3));
                    d.setDataCompra(rs.getString(4));
                    d.setSituacao(rs.getString(5));
                    lista.add(d);
                }
                return lista;
            } else {
                return null;
            }
        } catch (SQLException e) {
            return null;
        }
    }

    public boolean TestarDVD(int cod) {
        boolean Resultado = false;
        try {
            String sql = "SELECT * FROM dvd WHERE iddvd = " + cod + "";
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

    public List<DVD> CapturarDVD(int cod) {
        String sql = "SELECT * FROM dvd WHERE iddvd = " + cod + "";
        List<DVD> lista = new ArrayList<>();
        try {
            PreparedStatement ps = getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            if (rs != null) {
                while (rs.next()) {
                    DVD d = new DVD();
                    d.setCodigo(rs.getInt(1));
                    d.setCodigoFilme(rs.getInt(2));
                    d.setPreco(rs.getDouble(3));
                    d.setDataCompra(rs.getString(4));
                    d.setSituacao(rs.getString(5));
                    lista.add(d);
                }
                return lista;
            } else {
                return null;
            }
        } catch (SQLException e) {
            return null;
        }
    }

    public String AlterarDVD(DVD d ) {
        String sql = "UPDATE dvd SET idfilme = ?, preco_compra = ?, data_compra = ?, situacao = ? WHERE iddvd = ?";
        try {
            PreparedStatement ps = getCon().prepareStatement(sql);
            ps.setInt(1, d.getCodigoFilme());
            ps.setDouble(2, d.getPreco());
            ps.setString(3, d.getDataCompra());
            ps.setString(4, d.getSituacao());
            ps.setInt(5, d.getCodigo());
            
            if (ps.executeUpdate() > 0) {
                return "Editado(a)!";
            } else {
                return "Problema ao editar.";
            }
        } catch (SQLException e) {
            return e.getMessage();
        }
    }

    public boolean TestarSituacao(int cod) {
        boolean Resultado = true;
        try {
            String sql = "SELECT iddvd FROM dvd WHERE iddvd = " + cod + "AND situacao = 'Disponível'";
            PreparedStatement ps = getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            if (rs != null) {
                while (rs.next()) {
                    Resultado = false;
                }
            }
        } catch (SQLException ex) {
        }
        return Resultado;
    }

    public List<DVD> ListarCodigoFilme(int cod) {
        String sql = "SELECT idfilme, preco_compra FROM dvd WHERE iddvd = " + cod + "";
        List<DVD> lista = new ArrayList<>();
        try {
            PreparedStatement ps = getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            if (rs != null) {
                while (rs.next()) {
                    DVD d = new DVD();
                    d.setCodigoFilme(rs.getInt(1));
                    d.setPreco(rs.getInt(2));
                    lista.add(d);
                }
                return lista;
            } else {
                return null;
            }
        } catch (SQLException e) {
            return null;
        }
    }
    
    public List<DVD> CodigoID() {
        String sql = "SELECT MAX(iddvd) FROM dvd";
        List<DVD> lista = new ArrayList<>();
        try {
            PreparedStatement ps = getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            if (rs != null) {
                while (rs.next()) {
                    DVD d = new DVD();
                    d.setFCodigo(rs.getInt(1));
                    lista.add(d);
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
