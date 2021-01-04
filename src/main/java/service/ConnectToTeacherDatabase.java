package service;

import java.sql.*;
import java.util.ArrayList;


public class ConnectToTeacherDatabase {
    public static void main(String [] args) {
        String hostname = "holynamesacademy.database.windows.net";
        String dbName = "GlassDome";
        String user = "hna-admin";
        String password = "HolyNames123";
        String url = String.format("jdbc:sqlserver://%s:1433;database=%s;user=%s;password=%s;encrypt=true;" + "hostNameInCertificate=*.database.windows.net;loginTimeout=30;", hostname, dbName, user, password);
        Connection connection;

        try {
            connection = DriverManager.getConnection(url);
            String schema = connection.getSchema();
            System.out.println("Successful connection - Schema: " + schema);

            System.out.println("Query data example:");
            System.out.println("==============================");

            String selectSql = " SELECT * from Teacher; ";

            try (Statement statement = connection.createStatement();
                 ResultSet resultSet = statement.executeQuery(selectSql)) {

                while (resultSet.next()) {
                    System.out.println(resultSet.getString(1) + " " + resultSet.getString(2) + " " + resultSet.getString(3) + " " + resultSet.getString(4) + " " + resultSet.getString(5));
                }

                connection.close();

            } catch (SQLException e)//handle any errors
            {
                e.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static ArrayList getTeacher(String teacherName) {
        String hostname = "holynamesacademy.database.windows.net";
        String dbName = "GlassDome";
        String user = "hna-admin";
        String password = "HolyNames123";
        String url = String.format("jdbc:sqlserver://%s:1433;database=%s;user=%s;password=%s;encrypt=true;" + "hostNameInCertificate=*.database.windows.net;loginTimeout=30;", hostname, dbName, user, password);
        Connection connection;
        ArrayList<String> teacherInfo = new ArrayList <String>();

        try {
            connection = DriverManager.getConnection(url);
            String schema = connection.getSchema();
            System.out.println("Successful connection - Schema: " + schema);

            System.out.println("Query data example:");
            System.out.println("==============================");

            String selectSql = " SELECT * from Teacher; ";


            try (Statement statement = connection.createStatement();
                 ResultSet resultSet = statement.executeQuery(selectSql)) {

                while (resultSet.next()) {
                    if (resultSet.getString(1).equals(teacherName))
                    {
                        teacherInfo.add(resultSet.getString(1));
                        teacherInfo.add(resultSet.getString(2));
                        teacherInfo.add(resultSet.getString(3));
                        teacherInfo.add(resultSet.getString(4));
                        teacherInfo.add(resultSet.getString(5));
                        System.out.println(teacherInfo.add(resultSet.getString(1)));
                        System.out.println(teacherInfo.add(resultSet.getString(2)));
                        System.out.println(teacherInfo.add(resultSet.getString(3)));
                        System.out.println("Background: " + teacherInfo.add(resultSet.getString(4)));
                        System.out.println("Contact: " + teacherInfo.add(resultSet.getString(5)));
                        break;
                    }
                }
                connection.close();

            }
            catch (SQLException e)//handle any errors
            {
                e.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return teacherInfo;
    }
}

