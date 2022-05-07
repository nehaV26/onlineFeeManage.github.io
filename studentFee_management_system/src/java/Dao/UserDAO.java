/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import model.vser;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author hp
 */
public class UserDAO {
    private static final String INSET_STU="INSERT INTO `student`(`roll no`, `name`, `email`, `gender`, `course`, `fee`, `paid`, `due`, `address`, `contact`) VALUES (?,?,?,?,?,?,?,?,?,?)";
    private static final String SELECT_STU_ID="SELECT `roll no`, `name`, `email`, `gender`, `course`, `fee`, `paid`, `due`, `address`, `contact` FROM `student` WHERE roll no=?";
    private static final String SELECT_ALL_STU="SELECT * FROM `student`";       
    private static final String DELETE_STU="DELETE FROM `student` WHERE `roll no`=?";      
    private static final String  UPDATE_STU="UPDATE `student` SET `name`=?,`email`=?,`gender`=?,`course`=?,`fee`=?,`paid`=?,`due`=?,`address`=?,`contact`=? WHERE roll no=?";      
            
    private static Connection con;
    public static Connection getConnection() {
        
        try{
            
        
           Class.forName("com.mysql.jdbc.Driver");
           con=DriverManager.getConnection("jdbc:mysql://localhost:3306/neha","root","");
			
	   
    
        }
       catch(ClassNotFoundException | SQLException e){
	 System.out.println(e);
        }
        return con;
        
    }
    
    
    //creat or insert
    public void insertUser(vser user) throws SQLException{
        try( Connection con = getConnection();
                PreparedStatement preparedStatement=con.prepareStatement(INSET_STU)){
                preparedStatement.setInt(1, user.getRoll());
                preparedStatement.setString(2, user.getName());
                preparedStatement.setString(3, user.getEmail());
                preparedStatement.setString(4, user.getGender());
                 preparedStatement.setString(5, user.getCourse());
                preparedStatement.setInt(6, user.getFee());
                preparedStatement.setInt(7, user.getPaid());
                 preparedStatement.setInt(8, user.getDue());
                preparedStatement.setString(9, user.getAddress());
                preparedStatement.setInt(10, user.getContect());
               int i= preparedStatement.executeUpdate();
               
                
        }
            
    }
    
    
    //update user

    /**
     *
     * @param user
     * @return
     * @throws java.sql.SQLException
     */
    public boolean updateUser(vser user) throws SQLException{
        boolean rowUpdated;
        try(Connection con = getConnection();
                PreparedStatement statement=con.prepareStatement(UPDATE_STU);){
                statement.setString(1, user.getName());
                statement.setString(2, user.getEmail());
                statement.setString(3, user.getGender());
                statement.setString(4, user.getCourse());
                statement.setInt(5, user.getFee());
                statement.setInt(6, user.getPaid());
                statement.setInt(7, user.getDue());
                statement.setString(8, user.getAddress());
                statement.setInt(9, user.getContect());
               rowUpdated= statement.executeUpdate()>0;
        }
        return rowUpdated;
        
        
    }
    
    //select user by id
    public vser selectUser(int roll) throws SQLException{
        vser user=null;
        try(Connection con = getConnection();
                PreparedStatement preparedStatement=con.prepareStatement(SELECT_STU_ID);){
            preparedStatement.setInt(1, roll);
           // System.out.println(preparedStatement);
            ResultSet rs=preparedStatement.executeQuery();
            while(rs.next()){
                int rollno=rs.getInt("roll no");
                String name=rs.getString("name");
                String email=rs.getString("email");
                String gender=rs.getString("gender");
                String course=rs.getString("course");
                int fee=rs.getInt("fee");
                int paid=rs.getInt("paid");
                int due=rs.getInt("due");
                String address=rs.getString("address");
                int contect=rs.getInt("contact");
                user=new vser(rollno,name,email,gender,course,fee,paid,due,address,contect);
                
            }
        }
        return user;
    }
    //select user
    public List<vser> selectAllUser() throws SQLException{
        List<vser> users=new ArrayList<>(); 
        vser user=null;
        try(Connection con = getConnection();
                PreparedStatement preparedStatement=con.prepareStatement(SELECT_ALL_STU);){
          
            System.out.println(preparedStatement);
            ResultSet rs=preparedStatement.executeQuery();
            while(rs.next()){
                int rollno=rs.getInt("roll no");
                String name=rs.getString("name");
                String email=rs.getString("email");
                String gender=rs.getString("gender");
                String course=rs.getString("course");
                int fee=rs.getInt("fee");
                int paid=rs.getInt("paid");
                int due=rs.getInt("due");
                String address=rs.getString("address");
                int contect=rs.getInt("contact");
                users.add(new vser(rollno,name,email,gender,course,fee,paid,due,address,contect));
                
            }
        }
        return users;
    }
    
    //delete user
    public boolean deleteUser(int roll) throws SQLException{
        boolean rowDeleted;
        try(Connection con = getConnection();
                PreparedStatement statement=con.prepareStatement(DELETE_STU);){
                statement.setInt(1,roll);
               rowDeleted= statement.executeUpdate()>0;
        }
        return rowDeleted;
        
        
    }
    
    
    
}
