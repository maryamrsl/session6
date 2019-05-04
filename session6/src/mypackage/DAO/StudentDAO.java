package mypackage.DAO;

import mypackage.Student;

import java.sql.*;
import java.util.ArrayList;

public class StudentDAO {
    public Connection con;
    public PreparedStatement statement;
    public StudentDAO() {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "mona", "myjava123");
        }catch (Exception em){
            System.out.println("khata dar connection: "+em.getMessage());
        }
        }
    public void insert(Student st) {
        try {
            statement = con.prepareStatement("insert into student(id,name,lastname) values(?,?,?)");
            statement.setInt(1, st.getId());
            statement.setString(2, st.getNam());
            statement.setString(3, st.getFamily());
            statement.executeUpdate();
        }catch (Exception em) {
            System.out.println("khata dar : " + em.getMessage());
        }
    }
    public void update(Student st) throws SQLException {
        statement=con.prepareStatement("update student set name=? where id=?");
        statement.setString(1,st.getNam());
        statement.setInt(2,st.getId());
        statement.executeUpdate();
    }
    public void delet(Student st) throws SQLException {
        statement=con.prepareStatement("delete student where lastname=?");
        statement.setString(1,st.getFamily());
        statement.executeUpdate();
    }

   /* public ResultSet selectall() throws SQLException {
        statement=con.prepareStatement("select * from student");
        ResultSet rs=statement.executeQuery();
        return rs;*/
    public ArrayList<Student> selectall() throws SQLException {
        statement=con.prepareStatement("select * from student");
        ResultSet rs=statement.executeQuery();
        //..................tabdil rs be arraylist;
        ArrayList<Student> stlist=new ArrayList<>();
        while (rs.next()){
            Student st=new Student();
            st.setId(rs.getInt("id"));
            st.setNam(rs.getString("name"));
            st.setFamily(rs.getString("lastname"));
            stlist.add(st);


        }
        for (Student holo:stlist){
            System.out.println(holo.getId());
            System.out.println(holo.getNam());
            System.out.println(holo.getFamily());
        }
        return stlist;
    }
}
