package br.ufc.JDBC;

import java.sql.Connection;

import br.ufc.JDBC.ConnectionFactory;

public class teste {

    public static void main(String[] args) {

        ConnectionFactory factory = new ConnectionFactory();
        Connection conn = factory.getConnection();

        System.out.println(conn);

    }

}