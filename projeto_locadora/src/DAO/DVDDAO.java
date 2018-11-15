/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Modelo.DVD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DVDDAO extends ExecuteSQL {

    public DVDDAO(Connection con) {
        super(con);
    }
    
    public String Inserir_DVD(DVD a){
        
        String sql = "INSERT INTO dvd VALUES(0,?,?,?,?)";
        
        try {
            
            PreparedStatement ps = (PreparedStatement) getCon().prepareStatement(sql);
            
            ps.setInt(1, a.getCodigoFilme());
            ps.setDouble(2, a.getPreco());
            ps.setString(3, a.getDataCompra());
            ps.setString(4, a.getSituacao());
            
            if (ps.executeUpdate() > 0) {
                return "Inserido com sucesso";
            } else {
                return "Erro ao inserir";
            }
            
        } catch (SQLException e) {
            
            return e.getMessage();
            
        }
        
    }
    
    public List<DVD> ListarDVD(){
        
        String sql = "SELECT * FROM dvd"; 
        List<DVD> lista = new ArrayList<>();
       
        try {
           PreparedStatement ps = (PreparedStatement) getCon().prepareStatement(sql);
           ResultSet rs = ps.executeQuery();
           
            if (rs != null) {
                while (rs.next()) {                    
                    
                    DVD a = new DVD();
                    a.setCodigo(rs.getInt(1));
                    a.setCodigoFilme(rs.getInt(2));
                    a.setPreco(rs.getDouble(3));
                    a.setDataCompra(rs.getString(4));
                    a.setSituacao(rs.getString(5));
                    
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
    
    public List<DVD> Pesquisa_Cod_DVD(int cod){
        
        String sql = "SELECT * FROM dvd WHERE iddvd = '"+cod+"'";
        List<DVD> lista = new ArrayList<>();
       
        try {
           PreparedStatement ps = (PreparedStatement) getCon().prepareStatement(sql);
           ResultSet rs = ps.executeQuery();
           
            if (rs != null) {
                while (rs.next()) {                    
                    
                    DVD a = new DVD();
                    a.setCodigo(rs.getInt(1));
                    a.setCodigoFilme(rs.getInt(2));
                    a.setPreco(rs.getDouble(3));
                    a.setDataCompra(rs.getString(4));
                    a.setSituacao(rs.getString(5));
                    
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
    
    public List<DVD> Pesquisa_Cod_Filme(int cod){
        
        String sql = "SELECT * FROM dvd WHERE idfilme = '"+cod+"'";
        List<DVD> lista = new ArrayList<>();
       
        try {
           PreparedStatement ps = (PreparedStatement) getCon().prepareStatement(sql);
           ResultSet rs = ps.executeQuery();
           
            if (rs != null) {
                while (rs.next()) {                    
                    
                    DVD a = new DVD();
                    a.setCodigo(rs.getInt(1));
                    a.setCodigoFilme(rs.getInt(2));
                    a.setPreco(rs.getDouble(3));
                    a.setDataCompra(rs.getString(4));
                    a.setSituacao(rs.getString(5));
                    
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
    
    public List<DVD> ListarComboDVD(){
       
       String sql = "SELECT iddvd FROM dvd";
       List<DVD> lista = new ArrayList<>();
       
       try {
           
           PreparedStatement ps = (PreparedStatement) getCon().prepareStatement(sql);
           ResultSet rs = ps.executeQuery();
           
           if (rs != null) {
               
               while (rs.next()) {                   
                   DVD a = new DVD();
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
   
   public List<DVD> ConsultaCodigoDVD(String cod){
       
       String sql = "SELECT iddvd FROM dvd WHERE iddvd = '"+cod+"'";
       List<DVD> lista = new ArrayList<>();
       
       try {
           
           PreparedStatement ps = (PreparedStatement) getCon().prepareStatement(sql);
           ResultSet rs = ps.executeQuery();
           
           if (rs != null) {
               
               while (rs.next()) {                   
                   DVD a = new DVD();
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
   
   public String Excluir_DVD(DVD a){
       
       String sql = "DELETE FROM dvd WHERE iddvd = ?";
       
       try {
           
           PreparedStatement ps = (PreparedStatement) getCon().prepareStatement(sql);
           ps.setInt(1, a.getCodigo());
           
           if (ps.executeUpdate() > 0) {
               
               return "Excluido com sucesso";
               
           } else {
               
               return "Erro ao excluir";
               
           }
           
       } catch (SQLException e) {
           
           return e.getMessage();
           
       }
       
   }
   
   public boolean Testar_DVD(int cod){
        
        boolean Resultado = false;
        
        try {
            
          String sql = "SELECT * FROM dvd WHERE iddvd = '"+cod+"'";
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
   
    public boolean Testar_Situacao(int cod){
        
        boolean teste = false;
        
        try {
            
          String sql = "SELECT * FROM dvd WHERE iddvd = '"+cod+"' AND situacao = 'Disponivel'";
          PreparedStatement ps = (PreparedStatement) getCon().prepareStatement(sql);
          ResultSet rs = ps.executeQuery();
          
            if (rs != null) {
                
                while (rs.next()) {                    
                    teste = true;
                }
                
            }
            
        } catch (SQLException e) {
            
            e.getMessage();
            
        }
        return teste;
        
    }
    
    public List<DVD> ListarCodFilme(int cod){
        
        String sql = "SELECT idfilme FROM dvd WHERE iddvd = '"+cod+"'";
        List<DVD> lista = new ArrayList<>();
        
        try {
            
            PreparedStatement ps = getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            if (rs != null) {
                
                while (rs.next()) {                    
                    DVD a = new DVD();
                    a.setCodigoFilme(rs.getInt(1));
                    
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
    
    public List<DVD> CapturarDVD(int cod){
        
        String sql = "SELECT * FROM dvd WHERE iddvd = "+cod+"";
        List<DVD> lista = new ArrayList<>();
       
        try {
           PreparedStatement ps = (PreparedStatement) getCon().prepareStatement(sql);
           ResultSet rs = ps.executeQuery();
           
            if (rs != null) {
                while (rs.next()) {                    
                    
                    DVD a = new DVD();
                    a.setCodigo(rs.getInt(1));
                    a.setCodigoFilme(rs.getInt(2));
                    a.setPreco(rs.getDouble(3));
                    a.setDataCompra(rs.getString(4));
                    a.setSituacao(rs.getString(5));
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
    
   public String Alterar_DVD(DVD a){
       
        String sql = "UPDATE dvd SET idfilme = ?, preco_compra = ?, data_compra = ?"
               +",situacao = ? WHERE iddvd = ?";
        
        try {
            
           PreparedStatement ps = (PreparedStatement) getCon().prepareStatement(sql);
           ps.setInt(1, a.getCodigoFilme());
           ps.setDouble(2, a.getPreco());
           ps.setString(3, a.getDataCompra());
           ps.setString(4, a.getSituacao());
           ps.setInt(5, a.getCodigo());
           
            if (ps.executeUpdate() > 0) {
                return "Atualizado com sucesso";
            } else {
                return "Erro ao Atualizar";
            }
           
           
        } catch (SQLException e) {
            return e.getMessage(); 
        }
       
   }
    
}
