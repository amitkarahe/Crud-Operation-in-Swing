/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sqlClass;

import java.sql.ResultSet;

/**
 *
 * @author Lenovo
 */
public class UserServices {
     private UserDAO userDAO = new UserDAO();
    UserDTO userDTO = new UserDTO();

    public int insert(UserDTO userDTO) throws Exception {
        return userDAO.insert(userDTO);
    }

    public int update(UserDTO userDTO) throws Exception {
        return userDAO.update(userDTO);
    }

    public  UserDTO getById(int id) throws Exception {
        return userDAO.getById(id);
    }
    public  UserDTO getByMobile(String mobile) throws Exception {
        return userDAO.getByMobile(mobile);
    }
    public void getAll() {
    }

    public  int deleteByMobile(String mobile) throws Exception {
        return userDAO.deleteByMobile(mobile);
    }
    public ResultSet getTotalRecords()  throws Exception {
        return userDAO.getTotalRecords() ;
    }
}
