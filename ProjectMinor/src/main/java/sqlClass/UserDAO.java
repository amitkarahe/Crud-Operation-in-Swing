
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sqlClass;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Lenovo
 */
public class UserDAO {
     private final String INSERT_USER = "insert into UserInformation ("
            + "name,father_name,email,mobile,address,created_on,is_active) values(?,?,?,?,?,?,?)";
    private final String UPDATE_USER_BY_ID = "update UserInformation set name=?,father_name=?,email=?,address=?,modified_on=? ,is_active=? where mobile=?";
    public final String FIND_BY_USER_ID = "select * from  UserInformation  where id=?";
    public final String FIND_BY_MOBILE= "select * from UserInformation where mobile=?";
    public final String DELETE_BY_MOBILE = "delete from  UserInformation  where mobile=?";
    public final String GET_ALL = "select * from  UserInformation ";
    DBUtil dbUtil = new DBUtil();

    //insert 
    public int insert(UserDTO userDTO) throws Exception {
        Connection connection = null;
        PreparedStatement pstmt = null;
        try {
            connection = dbUtil.getConnection();
            System.out.println("INSERT_USER: " + INSERT_USER);
            pstmt = connection.prepareStatement(INSERT_USER);

//            pstmt.setInt(1, userDTO.getId());
            pstmt.setString(1, userDTO.getName());
            pstmt.setString(2, userDTO.getFatherName());
            pstmt.setString(3, userDTO.getEmail());
            pstmt.setString(4, userDTO.getMobile());
            pstmt.setString(5, userDTO.getAddress());
            pstmt.setDate(6, userDTO.getCreatedOn());
            pstmt.setInt(7, userDTO.getIsActive());

            int count = pstmt.executeUpdate();
            dbUtil.close(connection, pstmt);

            System.out.println("count: " + count);
            return count;

        } catch (Exception e) {
            dbUtil.close(connection, pstmt);
            System.err.println(e.getMessage());
            throw e;
        }
    }

    //update
    public int update(UserDTO userDTO) throws Exception {

        Connection connection = null;
        PreparedStatement pstmt = null;

        try {
            connection = dbUtil.getConnection();
            pstmt = connection.prepareStatement(UPDATE_USER_BY_ID);
            pstmt.setString(1, userDTO.getName());
            pstmt.setString(2, userDTO.getFatherName());
            pstmt.setString(3, userDTO.getEmail());
            //pstmt.setString(4, userDTO.getMobile());
            pstmt.setString(4, userDTO.getAddress());
//            pstmt.setString(6, userDTO.getPassword());
            pstmt.setDate(5, userDTO.getModifiedOn());
            pstmt.setInt(6, userDTO.getIsActive());
            pstmt.setString(7, userDTO.getMobile());

            int count = pstmt.executeUpdate();
            dbUtil.close(connection, pstmt);

            System.out.println("count: " + count);
            return count;
        } catch (Exception e) {
            dbUtil.close(connection, pstmt);
            System.err.println(e.getMessage());
            throw e;
        }
    }

    //getById
    public UserDTO getById(int id) throws Exception {
        Connection connection = null;
        PreparedStatement pstmt = null;
        try {
            connection = dbUtil.getConnection();

            pstmt = connection.prepareStatement(FIND_BY_USER_ID);
            pstmt.setInt(1, id);
            ResultSet resultSet = pstmt.executeQuery();
            UserDTO userDTO = null;
            if (resultSet.next()) {
                userDTO = new UserDTO();
                userDTO.setId(resultSet.getInt("id"));
                userDTO.setName(resultSet.getString("name"));
                userDTO.setFatherName(resultSet.getString("father_name"));
                userDTO.setEmail(resultSet.getString("email"));
                userDTO.setMobile(resultSet.getString("mobile"));
                userDTO.setAddress(resultSet.getString("address"));
//                userDTO.setPassword(resultSet.getString("password"));
                userDTO.setIsActive(resultSet.getInt("is_active"));
                userDTO.setModifiedOn(resultSet.getDate("modified_on"));
            }
            return userDTO;
        } catch (Exception e) {
            dbUtil.close(connection, pstmt);
            System.err.println(e.getMessage());
            throw e;
        }
    }

    //getByMobile
    public UserDTO getByMobile(String mobile) throws Exception {
        Connection connection = null;
        PreparedStatement pstmt = null;
        try {
            connection = dbUtil.getConnection();

            pstmt = connection.prepareStatement(FIND_BY_MOBILE);
            pstmt.setString(1, mobile);
            ResultSet resultSet = pstmt.executeQuery();
            UserDTO userDTO = null;
            if (resultSet.next()) {
                userDTO = new UserDTO();
                userDTO.setId(resultSet.getInt("id"));
                userDTO.setName(resultSet.getString("name"));
                userDTO.setFatherName(resultSet.getString("father_name"));
                userDTO.setEmail(resultSet.getString("email"));
                userDTO.setMobile(resultSet.getString("mobile"));
                userDTO.setAddress(resultSet.getString("address"));
//                userDTO.setPassword(resultSet.getString("password"));
                userDTO.setIsActive(resultSet.getInt("is_active"));
                userDTO.setModifiedOn(resultSet.getDate("modified_on"));
            }
            return userDTO;
        } catch (Exception e) {
            dbUtil.close(connection, pstmt);
            System.err.println(e.getMessage());
            throw e;
        }
    }

    //deleteById
    public int deleteByMobile(String mobile) throws Exception {
        Connection connection = null;
        PreparedStatement pstmt = null;
        try {
            connection = dbUtil.getConnection();
            pstmt = connection.prepareStatement(DELETE_BY_MOBILE);
            pstmt.setString(1, mobile);

            int count = pstmt.executeUpdate();
            dbUtil.close(connection, pstmt);

            System.out.println("count: " + count);
            return count;
        } catch (Exception e) {
            dbUtil.close(connection, pstmt);
            System.err.println(e.getMessage());
            throw e;
        }
    }

    public ResultSet getTotalRecords() throws Exception {
        Connection connection = null;
        PreparedStatement pstmt = null;
        try {
            connection = dbUtil.getConnection();

            pstmt = connection.prepareStatement(GET_ALL);
            ResultSet rs = pstmt.executeQuery();
            //Retrieving the result
//            while(rs.next()){
//                        System.out.println(rs.getInt("id") + " " + rs.getString("name") + " " + rs.getString("father_name")+ " " + rs.getString("mobile")+ " " + rs.getString("email") + " " + rs.getString("address") + " " + rs.getDate("created_on") + " " + rs.getDate("modified_on") + " " + rs.getInt("is_active"));
//
//            };
//            int count = rs.getInt(1);

            return rs;

        } catch (Exception e) {
            dbUtil.close(connection, pstmt);
            System.err.println(e.getMessage());
            throw e;

        }

    }
}
