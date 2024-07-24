package com.chatapp.dao;

import com.chatapp.dto.UserDto;
import com.chatapp.utils.Encryption;

import java.security.NoSuchAlgorithmException;
import java.sql.*;

public class UserDao {

    public boolean isLogin(UserDto userDto) throws SQLException, ClassNotFoundException, NoSuchAlgorithmException {
        Connection con =null;
        PreparedStatement pstmt =null;
        ResultSet rs =null;
        final String SQL = "select userid from users where userid=? and password=?";
        try{
            con = CommonDao.createConnection();
            pstmt = con.prepareStatement(SQL);
            pstmt.setString(1, userDto.getUserid());
            String encryptedpswd = Encryption.passwordEncrypt(new String(userDto.getPassword()));
            pstmt.setString(2,encryptedpswd);
            rs=pstmt.executeQuery();
            return rs.next();
        }
        finally {
            if(rs!=null){
                rs.close();
            }
            if (pstmt!=null){
                pstmt.close();
            }
            if (con!=null){
                con.close();
            }
        }
    }
    public int add(UserDto userDto) throws SQLException, ClassNotFoundException, NoSuchAlgorithmException {

        //System.out.println(userDto.getUserid()+" this is in dao"+userDto.getPassword());
        Connection connection = null;
        Statement stmt = null;
        try {
        connection = CommonDao.createConnection();
        stmt = connection.createStatement();
        int record = stmt.executeUpdate("insert into users (userid, password) values ('"+userDto.getUserid()+"','"+ Encryption.passwordEncrypt(new String(userDto.getPassword()))+"');");
        return record;
        }
        finally {
            if (stmt!=null)
                stmt.close();
            if (connection!=null)
                connection.close();
        }
    }
}
