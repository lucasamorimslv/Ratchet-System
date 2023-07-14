/* 
    *O programa tem como objetivo integrar o banco de dados com a catraca de leitor biométrico fazendo, assim, o controle e monitoramento do acesso de um estabelecimento
*/

import java.sql.*;

public class DbConnection {

    public static String URL =
        "jdbc:mysql://localhost:3306/banco_de_digitais";
    public static String USER = "root";
    public static String PWD = "root";

    private Connection dbconn = null; 
    private Statement sqlmgr = null;
    private ResultSet resultsql = null;

    // Método para abrir o banco de dados
    public void OpenDatabase (){

        try {
            dbconn = DriverManager.getConnection(URL, USER, PWD);
            System.out.println("Conetado com sucesso: "+URL);
            sqlmgr = dbconn.createStatement(); // cria objeto para SQLs
        }catch (Exception Error)
        {
            System.out.println("Error on connect: "+Error.getMessage());
        }
    }

    // Método para fechar o banco de dados
    public void CloseDatabase () throws SQLException{

        sqlmgr.close();
        dbconn.close();
    }

    // 
    public int ExecutaQuery(String sql){

        try {
            return sqlmgr.executeUpdate(sql);
        } catch (Exception Error)
        {
        System.out.println("Error on connect: "+Error.getMessage());
        }
        
        return -1;
    }
}
