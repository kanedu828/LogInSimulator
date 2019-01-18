import java.sql.*;

public class DataUtility {
    public static String extractData(String data, String username) throws SQLException {
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/loginsimulator", "kanedu", "kanedu");
        PreparedStatement extractData = con.prepareStatement("SELECT * from logindata WHERE username = ?");
        extractData.setString(1, username);
        ResultSet resultSet = extractData.executeQuery();
        String returnData = null;
        if(resultSet.next()){
            returnData = resultSet.getString(data);
        }
        else{
            returnData = "ERROR: 'resultSet' is false.";
        }
        System.out.println("returnData= "+returnData);
        extractData.close();
        return returnData;
    }
    public static void insertData(String username, String password) throws SQLException {
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/loginsimulator", "kanedu", "kanedu");
        PreparedStatement extractData = con.prepareStatement("INSERT into logindata (username, password) VALUES(?,?)");
        extractData.setString(1, username);
        extractData.setString(2, password);
        extractData.execute();
        extractData.close();

    }
}
