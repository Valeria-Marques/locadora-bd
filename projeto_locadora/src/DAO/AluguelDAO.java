/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Modelo.Aluguel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AluguelDAO extends ExecuteSQL{
    
    public AluguelDAO(Connection con) {
        super(con);
    }

    
    public String Inserir_Aluguel(Aluguel a){
        
        String sql = "INSERT INTO aluguel VALUES(0,?,?,?,?,?)";
        
        try {
            
            PreparedStatement ps = (PreparedStatement) getCon().prepareStatement(sql);
            
            ps.setInt(1, a.getCoddvd());
            ps.setInt(2, a.getCodcliente());
            ps.setString(3, a.getHorario());
            ps.setString(4, a.getDataAluguel());
            ps.setString(5, a.getDataDevolucao());
            
            if (ps.executeUpdate() > 0) {
                return "Inserido com sucesso";
            } else {
                return "Erro ao inserir";
            }
            
        } catch (SQLException e) {
            
            return e.getMessage();
            
        }
        
    }
    
    public String Atualiza_Situacao(Aluguel a){
       
        String situacao = "Emprestado";
        
        String sql = "UPDATE dvd SET situacao = ? WHERE iddvd = ?";
        
        try {
            
           PreparedStatement ps = (PreparedStatement) getCon().prepareStatement(sql);
           ps.setString(1, situacao);
           ps.setInt(2, a.getCoddvd());
           
            if (ps.executeUpdate() > 0) {
                return "Atualizado com sucesso";
            } else {
                return "Erro ao Atualizar";
            }
           
           
        } catch (SQLException e) {
            return e.getMessage(); 
        }
       
   } 
    
    public List<Aluguel> ListarAluguel(){
        
        String sql = "SELECT * FROM aluguel"; 
        List<Aluguel> lista = new ArrayList<>();
       
        try {
           PreparedStatement ps = (PreparedStatement) getCon().prepareStatement(sql);
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
    
    public List<Aluguel> Pesquisar_Cod_Aluguel(int cod){
        
        String sql = "SELECT * FROM aluguel WHERE idaluguel = '"+cod+"'"; 
        List<Aluguel> lista = new ArrayList<>();
       
        try {
           PreparedStatement ps = (PreparedStatement) getCon().prepareStatement(sql);
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
    
    public List<Aluguel> Pesquisar_Cod_DVD(int cod){
        
        String sql = "SELECT * FROM aluguel WHERE iddvd = '"+cod+"'"; 
        List<Aluguel> lista = new ArrayList<>();
       
        try {
           PreparedStatement ps = (PreparedStatement) getCon().prepareStatement(sql);
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
    
    public List<Aluguel> Pesquisar_Cod_Cliente(int cod){
        
        String sql = "SELECT * FROM aluguel WHERE idcliente = '"+cod+"'"; 
        List<Aluguel> lista = new ArrayList<>();
       
        try {
           PreparedStatement ps = (PreparedStatement) getCon().prepareStatement(sql);
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
    
    public String Excluir_Aluguel(Aluguel a){
        
        String sql = "DELETE FROM aluguel WHERE idaluguel = ?";
       
        try {

            com.mysql.jdbc.PreparedStatement ps = (com.mysql.jdbc.PreparedStatement) getCon().prepareStatement(sql);
            ps.setInt(1, a.getCod());

            if (ps.executeUpdate() > 0) {

                return "Excluido com sucesso";

            } else {

                return "Erro ao excluir";

            }

        } catch (SQLException e) {

            return e.getMessage();

        }
        
    }
    
    public String Atualiza_Situacao_Devolucao(Aluguel a){
       
        String situacao = "Disponivel";
        
        String sql = "UPDATE dvd SET situacao = ? WHERE iddvd = ?";
        
        try {
            
           PreparedStatement ps = (PreparedStatement) getCon().prepareStatement(sql);
           ps.setString(1, situacao);
           ps.setInt(2, a.getCoddvd());
           
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
