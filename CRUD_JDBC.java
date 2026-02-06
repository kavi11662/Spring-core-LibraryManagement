import java.sql.*;

public class CRUD_JDBC {
  private Connection con;
  CRUD_JDBC()throws Exception{
    String url="jdbc:mysql://localhost:3306/use your database name";
    String user="use your username";
    String password="use your password";
    con=DriverManager.getConnection(url, user, password);
    System.out.println("*************************  JAVA is connected to MYSQL successfull  **************************");
    System.out.println();
  }

  public void addStudent(Student s) throws SQLException{
    String SQL="INSERT INTO students VALUES(?,?,?)";//Query
    PreparedStatement pst=con.prepareStatement(SQL);
    pst.setInt(1,s.getId());
    pst.setString(2, s.getName());
    pst.setString(3, s.getGrade());
    pst.executeUpdate();
    System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~  The student "+s.getName()+" is add to database  ~~~~~~~~~~~~~~~~~~~~~~~~~~~");
    System.out.println();
    pst.close();
  }

  public void getStudent() throws SQLException{
    String DQL="select * from students";//Query
    Statement st = con.createStatement();
    ResultSet rs=st.executeQuery(DQL);
    System.out.println("<================>  Student Records  <===================>");
    while(rs.next()){
      System.out.println(rs.getInt(1)+" - "+rs.getString(2)+" - "+rs.getString(3));
    }
    System.out.println();
    st.close();
    rs.close();
  }

  public void updateGrade(int id,String grade) throws Exception{
    String SQL="update students set grade=? where id=?";//Query
    PreparedStatement pst=con.prepareStatement(SQL);
    pst.setString(1, grade);
    pst.setInt(2, id);
    pst.executeUpdate();
    System.out.println("~~~~~~~~~~~~~~~~~~~~~~  The student "+id+" is updated to database  ~~~~~~~~~~~~~~~~~~~~~~");
    System.out.println();
    pst.close();
  }

  public void deleteStudent(int id) throws SQLException {
    String sql="DELETE FROM students WHERE id=?";//Query
    PreparedStatement pst=con.prepareStatement(sql);
    pst.setInt(1, id);
    pst.executeUpdate();
    pst.close();
    System.out.println("~~~~~~~~~~~~~~~~~~~~~~~  The student "+id+" Deleted Successfully  ~~~~~~~~~~~~~~~~~~~~~~~~~~");
    System.out.println();
    pst.close();
  }

  public void close() throws SQLException {
    if (con!=null){
     con.close();
     System.out.println("**************************  Connection is closed successfully  **************************");
     System.out.println();
    }
  }

}
