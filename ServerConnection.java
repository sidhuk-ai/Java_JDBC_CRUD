import java.sql.*;

public class ServerConnection {

    public void createDB(String dataBase){
        try {
            String url = "jdbc:mysql://localhost:3306/";
            String userName = "root";
            String password = "Sidhu@1234";
            Connection conn = DriverManager.getConnection(url, userName, password);
            Statement stm = conn.createStatement();
            String query = "CREATE database " + dataBase;
            stm.execute(query);
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void createTable(String tableName){
        try {
            String url = "jdbc:mysql://localhost:3306/project";
            String userName = "root";
            String password = "S***4";
            Connection conn = DriverManager.getConnection(url, userName, password);
            Statement stm = conn.createStatement();
            String query = "CREATE TABLE " + tableName + " (ClassId int NOT NULL AUTO_INCREMENT, FirstName varchar(20) NOT NULL, LastName varchar(20), Age int, PRIMARY KEY(ClassId))";
            stm.execute(query);

            System.out.println("Table created successfully.");
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void createRecord(String firstName,String lastName, int age){
        try {
            String url = "jdbc:mysql://localhost:3306/";
            String db = "project";
            String userName = "root";
            String password = "Sidhu@1234";
            Connection conn = DriverManager.getConnection(url+db, userName, password);
            String query = "INSERT INTO Student (FirstName, LastName, Age) VALUES (?,?,?)";
            PreparedStatement pstm = conn.prepareStatement(query);
            pstm.setString(1, firstName);
            pstm.setString(2, lastName);
            pstm.setInt(3, age);
            pstm.execute();
            System.out.println("Recird added successfully.");
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void readTable() {
        try {
            String url = "jdbc:mysql://localhost:3306/";
            String db = "project";
            String userName = "root";
            String password = "Sidhu@1234";
            Connection conn = DriverManager.getConnection(url+db, userName, password);
            Statement stm = conn.createStatement();
            String query = "SELECT * FROM Student";
            ResultSet rs = stm.executeQuery(query);
            while(rs.next()){
                System.out.println("Id -->"+rs.getInt(1));
                System.out.println("First Name -->"+rs.getString(2));
                System.out.println("Last Name -->"+rs.getString(3));
                System.out.println("Age -->"+rs.getInt(4));
            }
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    
    // public void updateRecord(){
        public void updateRecord(String newName, int classID){
            try {
                String url = "jdbc:mysql://localhost:3306/";
                String db = "project";
                String userName = "root";
                String password = "Sidhu@1234";
                Connection conn = DriverManager.getConnection(url+db, userName, password);
                String query = "UPDATE Student SET FirstName=? WHERE ClassId=?";
                PreparedStatement pstm = conn.prepareStatement(query);
                pstm.setString(1, newName);
                pstm.setInt(2, classID);
                pstm.execute();
                System.out.println("Record updated successfully.");
                conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteRecord(String firstName, String lastName, int age) {
        String url = "jdbc:mysql://localhost:3306/project";
        String username = "root";
        String password = "Sidhu@1234";

        String sql = "DELETE FROM Student WHERE FirstName=? AND LastName=? AND Age=?";

        try (Connection conn = DriverManager.getConnection(url, username, password);
            PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, firstName);
            pstmt.setString(2, lastName);
            pstmt.setInt(3, age);

            int rowsDeleted = pstmt.executeUpdate();

            if (rowsDeleted > 0) {
                System.out.println("Record deleted successfully");
            } else {
                System.out.println("No such record exists");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
