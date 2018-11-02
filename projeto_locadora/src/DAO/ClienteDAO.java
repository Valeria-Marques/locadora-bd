package DAO;

import Modelo.Cliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClienteDAO extends ExecuteSQL{
   public ClienteDAO(Connection con) {
        super(con);
    }

    public String InserirCliente(Cliente c) {
        String sql = "INSERT INTO cliente VALUES (0,?,?,?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement ps = getCon().prepareStatement(sql);
            ps.setString(1, c.getNome());
            ps.setString(2, c.getNascimento());
            ps.setString(3, c.getRG());
            ps.setString(4, c.getCPF());
            ps.setString(5, c.getEmail());
            ps.setString(6, c.getTelefone());
            ps.setString(7, c.getBairro());
            ps.setString(8, c.getRua());
            ps.setInt(9, c.getNumero());
            ps.setString(10, c.getCEP());
            
            if (ps.executeUpdate() > 0) {
                return "Cliente cadastrado com sucesso.";
            } else {
                return "Erro ao cadastrar cliente.";
            }
        } catch (SQLException e) {
            return e.getMessage();
        }
    }

    public String ExcluirCliente(Cliente c) {
        String sql = "DELETE FROM cliente WHERE idcliente = ? AND nome = ? ";
        try {
            PreparedStatement ps = getCon().prepareStatement(sql);
            ps.setInt(1, c.getCodigo());
            ps.setString(2, c.getNome());
            
            if (ps.executeUpdate() > 0) {
                return "Cliente excluido com sucesso.";
            } else {
                return "Erro ao excluir cliente.";
            }
        } catch (SQLException e) {
            return e.getMessage();
        }
    }

    public List<Cliente> ListarComboCliente() {
        String sql = "SELECT nome FROM cliente ORDER BY nome";
        List<Cliente> lista = new ArrayList<>();
        try {
            PreparedStatement ps = getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            if (rs != null) {
                while (rs.next()) {
                    Cliente a = new Cliente();
                    a.setNome(rs.getString(1));
                    lista.add(a);
                }
                return lista;
            } else {
                return null;
            }
        } catch (Exception e) {
            return null;
        }
    }

    public List<Cliente> ConsultaCodigoCliente(String cod) {
        String sql = "SELECT idcliente FROM cliente WHERE nome = '" + cod + "'";
        List<Cliente> lista = new ArrayList<>();
        try {
            PreparedStatement ps = getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            if (rs != null) {
                while (rs.next()) {
                    Cliente c = new Cliente();
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
    
    public List<Cliente> ConsultaNomeCliente(String nome) {
        String sql = "SELECT nome FROM cliente WHERE nome = '" + nome + "'";
        List<Cliente> lista = new ArrayList<>();
        try {
            PreparedStatement ps = getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            if (rs != null) {
                while (rs.next()) {
                    Cliente c = new Cliente();
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

    public List<Cliente> ListarCliente() {
        String sql = "SELECT idcliente, nome, rg, cpf, telefone, email FROM cliente";
        List<Cliente> lista = new ArrayList<>();
        try {
            PreparedStatement ps = getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            if (rs != null) {
                while (rs.next()) {
                    Cliente c = new Cliente();
                    c.setCodigo(rs.getInt(1));
                    c.setNome(rs.getString(2));
                    c.setRG(rs.getString(3));
                    c.setCPF(rs.getString(4));
                    c.setTelefone(rs.getString(5));
                    c.setEmail(rs.getString(6));
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

    public List<Cliente> PesquisarNomeCliente(String nome) {
        String sql = "SELECT idcliente, nome, rg, cpf, telefone, email FROM cliente WHERE nome LIKE '%" + nome + "%'";
        List<Cliente> lista = new ArrayList<>();
        try {
            PreparedStatement ps = getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            if (rs != null) {
                while (rs.next()) {
                    Cliente c = new Cliente();
                    c.setCodigo(rs.getInt(1));
                    c.setNome(rs.getString(2));
                    c.setRG(rs.getString(3));
                    c.setCPF(rs.getString(4));
                    c.setTelefone(rs.getString(5));
                    c.setEmail(rs.getString(6));
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

    public List<Cliente> PegarCodigoCliente(int cod) {
        String sql = "SELECT idcliente, nome, rg, cpf, telefone, email FROM cliente WHERE idcliente = '" + cod + "'";
        List<Cliente> lista = new ArrayList<>();
        try {
            PreparedStatement ps = getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    Cliente a = new Cliente();
                    a.setCodigo(rs.getInt(1));
                    a.setNome(rs.getString(2));
                    a.setRG(rs.getString(3));
                    a.setCPF(rs.getString(4));
                    a.setTelefone(rs.getString(5));
                    a.setEmail(rs.getString(6));
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

    public boolean TestarCliente(int cod) {
        boolean Resultado = false;
        try {
            String sql = "SELECT * FROM cliente WHERE idcliente = " + cod + "";
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

    public List<Cliente> CapturarCliente(int cod) {
        String sql = "SELECT * FROM cliente WHERE idcliente = " + cod + " ";
        List<Cliente> lista = new ArrayList<>();
        try {
            PreparedStatement ps = getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            if (rs != null) {
                while (rs.next()) {
                    Cliente a = new Cliente();
                    a.setCodigo(rs.getInt(1));
                    a.setNome(rs.getString(2));
                    a.setNascimento(rs.getString(3));
                    a.setRG(rs.getString(4));
                    a.setCPF(rs.getString(5));
                    a.setEmail(rs.getString(6));
                    a.setTelefone(rs.getString(7));
                    a.setBairro(rs.getString(8));
                    a.setRua(rs.getString(9));
                    a.setNumero(rs.getInt(10));
                    a.setCEP(rs.getString(11));
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

    public String AlterarCliente(Cliente c) {
        String sql = "UPDATE cliente SET nome = ?, data_nasc = ?, rg = ?, cpf = ?, email = ?, telefone =  ?, bairro = ?, rua = ?, numero = ?, cep = ? WHERE idcliente = ? ";
        try {
            PreparedStatement ps = getCon().prepareStatement(sql);
            ps.setString(1, c.getNome());
            ps.setString(2, c.getNascimento());
            ps.setString(3, c.getRG());
            ps.setString(4, c.getCPF());
            ps.setString(5, c.getEmail());
            ps.setString(6, c.getTelefone());
            ps.setString(7, c.getBairro());
            ps.setString(8, c.getRua());
            ps.setInt(9, c.getNumero());
            ps.setString(10, c.getCEP());
            ps.setInt(11, c.getCodigo());
            
            if (ps.executeUpdate() > 0) {
                return "Cliente alterado com sucesso.";
            } else {
                return "Erro ao alterar cliente.";
            }
        } catch (SQLException e) {
            return e.getMessage();
        }
    }
    
    public List<Cliente> CodigoID() {
        String sql = "SELECT MAX(idcliente) FROM cliente";
        List<Cliente> lista = new ArrayList<>();
        try {
            PreparedStatement ps = getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            if (rs != null) {
                while (rs.next()) {
                    Cliente c = new Cliente();
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
