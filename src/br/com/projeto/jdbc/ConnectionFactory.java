/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.projeto.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Vitor
 */
public class ConnectionFactory {
    
    public Connection getConnection(){
        
        try {
                                                    //String de conexao
            return DriverManager.getConnection("jdbc:mysql://127.0.0.1/bdvendas?useTimezone=true&serverTimezone=UTC","usuario","123");
            
        } catch (Exception erro) {
            throw new RuntimeException(erro);
        }
        
    }
    
    
}



//Problema com time zone do brasil
//jdbc:mysql://localhost:3306/mondovino?useTimezone=true&serverTimezone=UTC", "root", "senha");
