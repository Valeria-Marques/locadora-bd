/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Modelo.Filme;
import com.mysql.jdbc.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FilmeDAO extends ExecuteSQL{
    
    public FilmeDAO(Connection con) {
        super(con);
    }
    
    public String Inserir_Filme(Filme a){
        
        String sql = "INSERT INTO filme VALUES(0,?,?,?,?,?)";
        
        try {
            
            PreparedStatement ps = (PreparedStatement) getCon().prepareStatement(sql);
            
            ps.setString(1, a.getTitulo());
            ps.setInt(2, a.getAno());
            ps.setString(3, a.getDuracao());
            ps.setInt(4, a.getCodigoCategoria());
            ps.setInt(5, a.getCodigoClassificacao());
            
            if (ps.executeUpdate() > 0) {
                return "Inserido com sucesso";
            } else {
                return "Erro ao inserir";
            }
            
        } catch (SQLException e) {
            
            return e.getMessage();
            
        }
        
    }
    
    public List<Filme> ListarFilme(){
        
        String sql = "SELECT * FROM filme"; 
        List<Filme> lista = new ArrayList<>();
        
        try {
            PreparedStatement ps = (PreparedStatement) getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
           
            if (rs != null) {
                while (rs.next()) {                    
                    
                    Filme a = new Filme();
                    a.setCodigo(rs.getInt(1));
                    a.setTitulo(rs.getString(2));
                    a.setAno(rs.getInt(3));
                    a.setDuracao(rs.getString(4));
                    a.setCodigoCategoria(rs.getInt(5));
                    a.setCodigoClassificacao(rs.getInt(6));
                    
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
    
    public List<Filme> Pesquisa_Nome_Filme(String nome){
        
        String sql = "SELECT * FROM filme WHERE titulo = '"+nome+"'";
        List<Filme> lista = new ArrayList<>();
       
        try {
           PreparedStatement ps = (PreparedStatement) getCon().prepareStatement(sql);
           ResultSet rs = ps.executeQuery();
           
            if (rs != null) {
                while (rs.next()) {                    
                    
                    Filme a = new Filme();
                    a.setCodigo(rs.getInt(1));
                    a.setTitulo(rs.getString(2));
                    a.setAno(rs.getInt(3));
                    a.setDuracao(rs.getString(4));
                    a.setCodigoCategoria(rs.getInt(5));
                    a.setCodigoClassificacao(rs.getInt(6));
                    
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
    
    public List<Filme> Pesquisa_Cod_Filme(int cod){
        
        String sql = "SELECT * FROM filme WHERE idfilme = '"+cod+"'";
        List<Filme> lista = new ArrayList<>();
       
        try {
           PreparedStatement ps = (PreparedStatement) getCon().prepareStatement(sql);
           ResultSet rs = ps.executeQuery();
           
            if (rs != null) {
                while (rs.next()) {                    
                    
                    Filme a = new Filme();
                    a.setCodigo(rs.getInt(1));
                    a.setTitulo(rs.getString(2));
                    a.setAno(rs.getInt(3));
                    a.setDuracao(rs.getString(4));
                    a.setCodigoCategoria(rs.getInt(5));
                    a.setCodigoClassificacao(rs.getInt(6));
                    
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
    
    public List<Filme> ListarComboFilme(){
       
       String sql = "SELECT titulo FROM filme ORDER BY titulo";
       List<Filme> lista = new ArrayList<>();
       
       try {
           
           PreparedStatement ps = (PreparedStatement) getCon().prepareStatement(sql);
           ResultSet rs = ps.executeQuery();
           
           if (rs != null) {
               
               while (rs.next()) {                   
                   Filme a = new Filme();
                   a.setTitulo(rs.getString(1));
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
   
   public List<Filme> ConsultaCodigoFilme(String nome){
       
       String sql = "SELECT idfilme FROM filme WHERE titulo = '"+nome+"'";
       List<Filme> lista = new ArrayList<>();
       
       try {
           
           PreparedStatement ps = (PreparedStatement) getCon().prepareStatement(sql);
           ResultSet rs = ps.executeQuery();
           
           if (rs != null) {
               
               while (rs.next()) {                   
                   Filme a = new Filme();
                   a.setCodigo(rs.getInt(1));
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
   
   public String Excluir_Filme(Filme a){
       
       String sql = "DELETE FROM filme WHERE idfilme = ? AND titulo = ?";
       
       try {
           
           PreparedStatement ps = (PreparedStatement) getCon().prepareStatement(sql);
           ps.setInt(1, a.getCodigo());
           ps.setString(2, a.getTitulo());
           
           if (ps.executeUpdate() > 0) {
               
               return "Excluido com sucesso";
               
           } else {
               
               return "Erro ao excluir";
               
           }
           
       } catch (SQLException e) {
           
           return e.getMessage();
           
       }
       
   }
   
   public boolean Testar_Filme(int cod){
        
        boolean Resultado = false;
        
        try {
            
          String sql = "SELECT * FROM filme WHERE idfilme = "+cod+"";
          PreparedStatement ps = (PreparedStatement) getCon().prepareStatement(sql);
          ResultSet rs = ps.executeQuery();
          
            if (rs != null) {
                
                while (rs.next()) {                    
                    Resultado = true;
                }
                
            }
            
        } catch (SQLException e) {
            
            e.getMessage();
            
        }
        return Resultado;
        
    }
    
    public List<Filme> CapturarFilme(int cod){
        
        String sql = "SELECT * FROM filme WHERE idfilme = "+cod+"";
        List<Filme> lista = new ArrayList<>();
       
        try {
           PreparedStatement ps = (PreparedStatement) getCon().prepareStatement(sql);
           ResultSet rs = ps.executeQuery();
           
            if (rs != null) {
                while (rs.next()) {                    
                    
                    Filme a = new Filme();
                    a.setCodigo(rs.getInt(1));
                    a.setTitulo(rs.getString(2));
                    a.setAno(rs.getInt(3));
                    a.setDuracao(rs.getString(4));
                    a.setCodigoCategoria(rs.getInt(5));
                    a.setCodigoClassificacao(rs.getInt(6));
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
    
   public String Alterar_Filme(Filme a){
       
        String sql = "UPDATE filme SET titulo = ?, ano = ?,duracao = ?, idcategoria = ?, idclassificacao = ? WHERE idfilme = ?";
        
        try {
            
           PreparedStatement ps = (PreparedStatement) getCon().prepareStatement(sql);
           ps.setString(1, a.getTitulo());
           ps.setInt(2, a.getAno());
           ps.setString(3, a.getDuracao());
           ps.setInt(4, a.getCodigoCategoria());
           ps.setInt(5, a.getCodigoClassificacao());
           ps.setInt(7, a.getCodigo());
           
            if (ps.executeUpdate() > 0) {
                return "Atualizado com sucesso";
            } else {
                return "Erro ao Atualizar";
            }
           
           
        } catch (SQLException e) {
            return e.getMessage(); 
        }
       
   }
   
   public List<Filme> Pesquisar_Cod_Filme(int cod){
       
       String sql = "SELECT * FROM filme WHERE idfilme = '"+cod+"'";
       List<Filme> lista = new ArrayList<>();
       
       try {
           
           PreparedStatement ps = (PreparedStatement) getCon().prepareStatement(sql);
           ResultSet rs = ps.executeQuery();
           
           if (rs != null) {
               
               while (rs.next()) {                   
                   
                   Filme a = new Filme();
                   a.setCodigo(rs.getInt(1));
                   a.setTitulo(rs.getString(2));
                   a.setAno(rs.getInt(3));
                   a.setDuracao(rs.getString(4));
                   a.setCodigoCategoria(rs.getInt(5));
                   a.setCodigoClassificacao(rs.getInt(6));
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
