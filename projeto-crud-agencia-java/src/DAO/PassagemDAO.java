package DAO;

import conexao.Conexao;
import entity.Passagem;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PassagemDAO {
    public void cadastrarPassagem(Passagem passagem){
        String sql = "INSERT INTO PASSAGENS (cidade,preco) VALUES (?,?)";
        PreparedStatement ps = null;
        try {
            ps = Conexao.getConexao().prepareStatement(sql);
            ps.setString(1, passagem.getCidade());
            ps.setInt(2, passagem.getPreco());

            ps.execute();
            ps.close();
        } catch (SQLException e){
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public List<Passagem> listarPassagens() throws Exception {
        String sql = "select * from passagens";
        List<Passagem> passagens = new ArrayList<Passagem>();
        PreparedStatement ps = null;
        ResultSet rset = null;
        try {
            ps = Conexao.getConexao().prepareStatement(sql);
            rset = ps.executeQuery();
            while (rset.next()){
                Passagem passagem = new Passagem();
                passagem.setId(rset.getInt("id"));
                passagem.setCidade(rset.getString("cidade"));
                passagem.setPreco(rset.getInt("preco"));
                passagens.add(passagem);
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
        return passagens;



    }

    public void modificar(Passagem passagem) throws Exception {
        String sql = "update passagens set cidade = ?, preco = ? " +
                "where id = ?";
        PreparedStatement ps = null;
        try {
            ps = Conexao.getConexao().prepareStatement(sql);
            ps.setString(1,passagem.getCidade());
            ps.setInt(2,passagem.getPreco());

            ps.setInt(3,passagem.getId());
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

    public void deletar(int id){
        String sql = "delete from passagens where id = ?";
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
