package DAO;

import conexao.Conexao;
import entity.Cliente;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ClienteDAO {
    public void cadastrarCliente(Cliente cliente){
        String sql = "INSERT INTO CLIENTES (nome,email,telefone,endereco,senha) VALUES (?,?,?,?,?)";
        PreparedStatement ps = null;
        try {
            ps = Conexao.getConexao().prepareStatement(sql);
            ps = Conexao.getConexao().prepareStatement(sql);
            ps.setString(1, cliente.getNome());
            ps.setString(2, cliente.getEmail());
            ps.setString(3, cliente.getTelefone());
            ps.setString(4, cliente.getEndereco());
            ps.setString(5, cliente.getSenha());


            ps.execute();
            ps.close();
        } catch (Exception e){
            e.printStackTrace();
        }
    }
    public List<Cliente> listarClientes() throws Exception {
        String sql = "select * from clientes";
        List<Cliente> clientes = new ArrayList<Cliente>();
        PreparedStatement ps = null;
        ResultSet rset = null;

        try {
            ps = Conexao.getConexao().prepareStatement(sql);
            rset = ps.executeQuery();
            while (rset.next()){
                Cliente cliente = new Cliente();
                cliente.setId(rset.getInt("id"));
                cliente.setNome(rset.getString("nome"));
                cliente.setEmail(rset.getString("email"));
                cliente.setTelefone(rset.getString("telefone"));
                cliente.setEndereco(rset.getString("endereco"));
                cliente.setSenha(rset.getString("senha"));
                clientes.add(cliente);
            }
        } catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                if(rset!=null) {
                    rset.close();
                }

                if(ps!=null) {
                    ps.close();
                }
            }catch(Exception e) {
                e.printStackTrace();
            }
        }
        return clientes;
    }

    public void modificarClientes(Cliente cliente) throws Exception {
        String sql = "update clientes set nome = ?, email = ?, telefone = ?, endereco = ?, senha = ? " +
                "where id = ?";
        PreparedStatement ps = null;
        try {
            ps = Conexao.getConexao().prepareStatement(sql);
            ps.setString(1,cliente.getNome());
            ps.setString(2, cliente.getEmail());
            ps.setString(3, cliente.getTelefone());
            ps.setString(4,cliente.getEndereco());
            ps.setString(5,cliente.getSenha());

            ps.setInt(6,cliente.getId());
            ps.execute();
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            try {
                if(ps!=null) {
                    ps.close();
                }
            }catch(Exception e) {
                e.printStackTrace();
            }
        }
    }
    public void deletarClientes(int id){
        String sql = "delete from clientes where id = ?";
        PreparedStatement ps = null;

        try {
            ps = Conexao.getConexao().prepareStatement(sql);
            ps.setInt(1,id);
            ps.execute();

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                if(ps!=null) {
                    ps.close();
                }
            }catch(Exception e) {
                e.printStackTrace();
            }
        }

    }
}

