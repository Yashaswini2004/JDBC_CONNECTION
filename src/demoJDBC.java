import java.sql.*;
public class demoJDBC {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        String url="jdbc:postgresql://localhost:5432/demo";
        String uname="postgres";
        String pass="yashu7022";
        String query="select * from student";
//        Class.forName("org.postgresql.Driver");
        Connection con=DriverManager.getConnection(url,uname,pass);
        System.out.println("Connection Established");
        Statement st=con.createStatement();
        ResultSet rs=  st.executeQuery(query);
//        rs.next();
//       String name= rs.getString("sName");
//       System.out.println(name);
        while(rs.next()){
            System.out.println(rs.getInt(1));
            System.out.println(rs.getString(2));
            System.out.println(rs.getInt(3));

        }
         con.close();
         System.out.println("Connection closed");





    }
}
