package com.foodapp.dbutil;

import java.sql.Connection;

public class TestDBConnection {

    public static void main(String[] args) {

        Connection con = DButil.getConnection();

        if (con != null) {
            System.out.println("Connection Successful");
        } else {
            System.out.println("Connection Failed");
        }
    }
}