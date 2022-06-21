package org.example.dao;

import org.example.domain.AuthUser;
import org.example.domain.User;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.List;

public class UserDao {

    private JdbcTemplate jdbcTemplate;

    public UserDao(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public List<User> getAll() {
        return this.jdbcTemplate.query(
                "select id, name, email from users",
                (resultSet, rowNum) -> {
                    User user = new User();
                    user.setId(resultSet.getInt("id"));
                    user.setName(resultSet.getString("name"));
                    user.setEmail(resultSet.getString("email"));
                    return user;
                });
    }

    public int addUser(String username, String password){
        return this.jdbcTemplate.update("insert into users (username,password) values (?,?)",username,password);
    }

    public String authenticateUser(String username, String password){
//        List<AuthUser> authUsers = this.jdbcTemplate.query("select id,username,password from users where username=? and password=?",
//                (resultSet, rowNum)->{
//                    System.out.println("rowNum : "+rowNum);
//                    AuthUser user = new AuthUser();
//                    user.setId(resultSet.getInt("id"));
//                    user.setUsername(resultSet.getString("username"));
//                    user.setPassword(resultSet.getString("password"));
//                    return user;
//                }
//                ,username,password
//        );
//        if(authUsers.isEmpty()) return "Incorrect username or password";
//        return "Login Successful";
        try{
            AuthUser authUser = this.jdbcTemplate.queryForObject(
                    "select id,username,password from users where username=? and password=?",
                    (resultSet,rowNum)-> new AuthUser(
                            resultSet.getInt("id"),
                            resultSet.getString("username"),
                            resultSet.getString("password")
                    ),
                    username,
                    password
            );
            if(authUser!=null) return "Login Successful";
            return "Incorrect";
        }
        catch (Exception error){
            System.out.println("authenticateUser Error : "+error.getMessage());
            return "Error";
        }
    }

    public void delete(int id) {
        this.jdbcTemplate.update(
                "delete from users where id = ?",
                id);
    }
}
