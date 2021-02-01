package service;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.DriverManager;
import java.sql.SQLException;


public class ConnectToStudentDatabase {
    public static double DatabaseConnection(String teacherName) {//prints studentdatabase for specific teacher and returns percentages of yes for it
        String hostname = "holynamesacademy.database.windows.net";
        String dbName = "GlassDome";
        String user = "hna-admin";
        String password = "HolyNames123";
        String url = String.format("jdbc:sqlserver://%s:1433;database=%s;user=%s;password=%s;encrypt=true;" + "hostNameInCertificate=*.database.windows.net;loginTimeout=30;", hostname, dbName, user, password);
        Connection connection;
        double percentage = 0;
        int num = 0;

        try {
            connection = DriverManager.getConnection(url);
            String schema = connection.getSchema();
            System.out.println("Successful connection - Schema: " + schema);

            System.out.println("Query data example:");
            System.out.println("==============================");

            String selectSql = " SELECT * from Student; ";

            try (Statement statement = connection.createStatement();
                 ResultSet resultSet = statement.executeQuery(selectSql)) {


                while (resultSet.next()) {
                    if(resultSet.getString(1).equals(teacherName))
                    {
                        System.out.println(resultSet.getString(1) + " " + resultSet.getInt(2) + " " + resultSet.getString(3) + " " + resultSet.getString(4) + " " + resultSet.getString(5));
                        if(resultSet.getString(3)=="Yes")
                        {
                            percentage++;
                        }
                        num++;
                    }

                }
                percentage/=num;

                connection.close();

            } catch (SQLException e)//handle any errors
            {
                e.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return percentage;
    }
}

