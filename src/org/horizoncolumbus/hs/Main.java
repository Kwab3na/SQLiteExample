package org.horizoncolumbus.hs;

import java.sql.*;

public class Main {

    public static void main(String[] args) {

        Connection connection = null;

        //Connection
        String url = "jdbc:sqlite:Resources/student.db";
        try {
            connection = DriverManager.getConnection(url);
            System.out.println("Connection Success!");
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        //Drop Table
        String sqlDropTable = "DROP TABLE students";
        try {
            Statement statement = connection.createStatement();
            statement.execute(sqlDropTable);
            System.out.println("Drop Success!");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        //Create a Table
        String sqlCreateCmd = "create table students (id INTEGER," +
                "student_name TEXT, grade_level TEXT, favorite_subject TEXT)";
        try {
            Statement statement = connection.createStatement();
            statement.execute(sqlCreateCmd);
            System.out.println("Table Creation Success");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        //InsertData
        String sqlInsertCommand = "insert into students values (1, \"Sabriye\", \"11\", \"Math\")";
        try {
            Statement statement = connection.createStatement();
            statement.execute(sqlInsertCommand);
            System.out.println("Student Insertion Success!");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        //Query
        String sqlQueryCommand = "select * from students where grade_level is \"11\";";
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sqlQueryCommand);
            while(resultSet.next()){
                System.out.println(resultSet.getInt("Id") + "\t" +
                        resultSet.getString("student_name") + "\t" +
                                resultSet.getString("grade_level"));

            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
}