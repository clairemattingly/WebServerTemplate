package service;

import java.util.ArrayList;
import java.sql.*;

public class ConnectToTeacherDatabase {
    public static TeacherInfo teacherInfo(String teacherName) {
        TeacherInfo newTeacherInfo = new TeacherInfo("","","","", "");
        String hostname = "holynamesacademy.database.windows.net";
        String dbName = "GlassDome";
        String user = "hna-admin";
        String password = "HolyNames123";
        String url = String.format("jdbc:sqlserver://%s:1433;database=%s;user=%s;password=%s;encrypt=true;" + "hostNameInCertificate=*.database.windows.net;loginTimeout=30;",
                hostname, dbName, user, password);
        Connection connection;
        try {
            connection = DriverManager.getConnection(url);
            String query = "SELECT * FROM Teacher WHERE Name = " + teacherName + ";" ;//SQL SELECT query that filters all throughout table only from teachername

            Statement st = connection.createStatement();//create the java statement
            ResultSet resultSet = st.executeQuery(query);//execute the query and get a java resultset
           //printing
            ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
            String columnName = resultSetMetaData.getColumnName(1);
            System.out.println(columnName);

            while (resultSet.next()) {
                String teacher = resultSet.getString("Name");//might need to capatalize if doesn't work
                newTeacherInfo.setTeacherName(teacher);
                String title = resultSet.getString("Title");
                newTeacherInfo.setTitle(title);
                String department = resultSet.getString("Department");
                newTeacherInfo.setDepartment(department);
                String education = resultSet.getString("Education");
                newTeacherInfo.setEducation(education);
                String email = resultSet.getString("Email");
                newTeacherInfo.setEmail(email);

                System.out.format(newTeacherInfo.getTeacherName(), newTeacherInfo.getTitle(), newTeacherInfo.getDepartment(), newTeacherInfo.getEducation(), newTeacherInfo.getEmail());
                System.out.println(newTeacherInfo);
            }

            connection.close();
        } catch (SQLException e)//handle any errors
        {
            e.printStackTrace();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return newTeacherInfo;
    }

    public static ArrayList<String> getTeacher(String teacherName) {
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

    public static ArrayList<String> getDepartmentNames(String department) {
        String hostname = "holynamesacademy.database.windows.net";
        String dbName = "GlassDome";
        String user = "hna-admin";
        String password = "HolyNames123";
        String url = String.format("jdbc:sqlserver://%s:1433;database=%s;user=%s;password=%s;encrypt=true;" + "hostNameInCertificate=*.database.windows.net;loginTimeout=30;", hostname, dbName, user, password);
        Connection connection;
        ArrayList<String> teacherNames = new ArrayList <String>();

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
                    if (resultSet.getString(3).equals(department))
                    {
                        teacherNames.add(resultSet.getString(1));
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
        return teacherNames;
    }
}

