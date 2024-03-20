
package org.example.entity;

import jakarta.persistence.*;

@Table(name = "users")
@Entity
public class User {
    @Id
    @GeneratedValue
    @Column(name ="user_id")
    private Long User_id;
    @Column(name = "user_name")
    private String User_name;
    @Column(name = "Login")
    private String User_login;
    @Column(name = "user_pass")
    private String User_password;

    public User(){
    }
    public Long getUser_id() {
        return User_id;
    }

    public void setUser_id(Long user_id) {
        User_id = user_id;
    }

    public String getUser_name() {
        return User_name;
    }

    public void setUser_name(String user_name) {
        User_name = user_name;
    }

    public String getUser_login() {
        return User_login;
    }

    public void setUser_login(String user_login) {
        User_login = user_login;
    }

    public String getUser_password() {
        return User_password;
    }

    public void setUser_password(String user_password) {
        User_password = user_password;
    }
}
