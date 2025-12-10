/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.dao;

import conexao.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.bean.Cliente; // Importa a classe Bean

public class ClienteDAO {
    
    // ===================================
    // MÉTODO CREATE (CADASTRAR)
    // ===================================
    public void create(Cliente c) {
        Connection con = Conexao.getConexao();
        PreparedStatement stmt = null;
        
        try {
            // A query usa 'id_cliente' para a coluna PK no BD
            String query = "INSERT INTO cliente (nome, cpf, email) VALUES (?,?,?)";
            stmt = con.prepareStatement(query);
            stmt.setString(1, c.getNome());
            stmt.setString(2, c.getCpf());
            stmt.setString(3, c.getEmail());
            
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Cliente cadastrado com sucesso! 🎉");
        }
        catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Falha ao cadastrar Cliente. Erro: " + ex.getMessage());
        }
        finally {
            Conexao.fecharConexao(con, stmt);
        }
    }
    
    // ===================================
    // MÉTODO READ (LISTAR TODOS)
    // ===================================
    public ArrayList<Cliente> read() {
        Connection con = Conexao.getConexao();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        ArrayList<Cliente> clientes = new ArrayList<>();
        
        try {
            String query = "SELECT * FROM cliente";
            stmt = con.prepareStatement(query);
            rs = stmt.executeQuery();
            
            while (rs.next()) {
                Cliente c = new Cliente();
                c.setId(rs.getInt("id_cliente"));
                c.setNome(rs.getString("nome"));
                c.setCpf(rs.getString("cpf"));
                c.setEmail(rs.getString("email"));
                
                clientes.add(c);
            }
        }
        catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Falha ao ler Clientes. Erro: " + ex.getMessage());
        }
        finally {
            Conexao.fecharConexao(con, stmt, rs);
        }
        return clientes;
    }

    // ===================================
    // MÉTODO UPDATE (EDITAR)
    // ===================================
    public void update(Cliente c) {
        Connection con = Conexao.getConexao();
        PreparedStatement stmt = null;
        
        try {
            String query = "UPDATE cliente SET nome = ?, cpf = ?, email = ? WHERE id_cliente = ?";
            stmt = con.prepareStatement(query);
            stmt.setString(1, c.getNome());
            stmt.setString(2, c.getCpf());
            stmt.setString(3, c.getEmail());
            stmt.setInt(4, c.getId());
            
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Cliente atualizado com sucesso!");
        }
        catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Falha ao atualizar Cliente. Erro: " + ex.getMessage());
        }
        finally {
            Conexao.fecharConexao(con, stmt);
        }
    }
    
    // ===================================
    // MÉTODO DESTROY (EXCLUIR)
    // ===================================
    public void destroy(Cliente c) {
        Connection con = Conexao.getConexao();
        PreparedStatement stmt = null;
        
        try {
            String query = "DELETE FROM cliente WHERE id_cliente = ?";
            stmt = con.prepareStatement(query);            
            stmt.setInt(1, c.getId());
            
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Cliente excluído com sucesso!");
        }
        catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Falha ao excluir Cliente. Erro: " + ex.getMessage());
        }
        finally {
            Conexao.fecharConexao(con, stmt);
        }
    }
}
