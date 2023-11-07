package DAO;

import conexao.Conexao;
import entity.Viagem;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ViagemDAO {
    public void cadastrarViagem(Viagem viagem){
        String sql = "INSERT INTO VIAGENS (id_cliente,id_passagem) VALUES (?,?)";
        PreparedStatement ps = null;
        try {
            ps = Conexao.getConexao().prepareStatement(sql);
            ps.setInt(1, viagem.getId_cliente());
            ps.setInt(2, viagem.getId_passagem());

            ps.execute();
            ps.close();
        } catch (SQLException e){
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public List<Viagem> listarViagens() throws Exception {
        String sql = "select * from viagens";
        List<Viagem> viagens = new ArrayList<Viagem>();
        PreparedStatement ps = null;
        ResultSet rset = null;
        try {
            ps = Conexao.getConexao().prepareStatement(sql);
            rset = ps.executeQuery();
            while (rset.next()){
                Viagem viagem = new Viagem();
                viagem.setId(rset.getInt("id"));
                viagem.setId_cliente(rset.getInt("id_cliente"));
                viagem.setId_passagem(rset.getInt("id_passagem"));
                viagens.add(viagem);
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
        return viagens;



    }

    public void modificarViagem(Viagem viagem) throws Exception {
        String sql = "update viagens set id_cliente = ?, id_passagem = ? " +
                "where id = ?";
        PreparedStatement ps = null;
        try {
            ps = Conexao.getConexao().prepareStatement(sql);
            ps.setInt(1,viagem.getId_cliente());
            ps.setInt(2,viagem.getId_passagem());

            ps.setInt(3,viagem.getId());
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

    public void deletarViagem(int id){
        String sql = "delete from viagens where id = ?";
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
