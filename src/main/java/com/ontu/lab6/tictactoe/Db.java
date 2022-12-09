package com.ontu.lab6.tictactoe;
import java.sql.*; 

public class Db{
    String dbUrl = "jdbc:mysql://localhost:3306/myGame?useSSL=false";
    String user = "root";
    String password = "pass";
    Connection con;

    public Db() {
        try 
        { 
            Class.forName("com.mysql.cj.jdbc.Driver"); 
            this.con=DriverManager.getConnection(dbUrl,user,password);
            System.out.println(this.con == null);
        } 
        catch(Exception e) 
        { 
            System.out.println(e); 
        }
    }

    public void close() {
        try {
            con.close(); 
        }
        catch(Exception e) { 
            System.out.println(e); 
        }    
    }
    public boolean isUserExists(String username)
    {
        try 
        {
             Statement stmt=con.createStatement(); 
             ResultSet rs=stmt.executeQuery("SELECT count(*) FROM users WHERE username='"+username+"';"); 
             while(rs.next()) 
                if (rs.getInt(1) == 1) 
                    return true;
                else return false;
                }
                catch(Exception e) 
                { 
                    System.out.println(e); 
                }
                return true;
    }

    public boolean LoginUser(String username,String password) {
        try{
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT count(*) AS count FROM users WHERE username='"+username+"' AND password='"+password+"';");
        
        System.out.println(username);
        System.out.println(password);

        rs.next();
        if(rs.getInt("count") == 0){
            System.out.println("НЕ найдено пользователя или неправильный пароль");
            return false;
        }
        else{
            System.out.println("Добро пожаловать," + username + "!");
            return true;
        }
        }
        catch(Exception e){
            System.out.println(e);
            return false;
        }
    }

    
} 