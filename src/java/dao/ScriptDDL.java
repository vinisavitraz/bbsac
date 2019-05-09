/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Vinicius
 */
public class ScriptDDL {
    
    public static void execute() throws SQLException {
        Connection connection = ConnectionFactory.getInstance().getConnection();

        criarTabelas(connection);

    }
    
    private static void criarTabelas(Connection connection) throws SQLException {
        List<String> scriptCreateTable = new ArrayList<>();
        scriptCreateTable.add(createTableCategoriaProduto());
                
        PreparedStatement st = null;
        ResultSet rs = null;

        try{
            st = connection.prepareStatement(createTableCategoriaProduto());
            rs = st.executeQuery();
        } catch (SQLException e){
            if(!e.getMessage().contains("already exists")){
                throw e;
            } 
            
        }
    }

    private static String createTableCategoriaProduto(){
        return "create table categoria_produto( catp_id int not null, catp_nome varchar(50) not null, primary key(catp_id));";
    }
}
