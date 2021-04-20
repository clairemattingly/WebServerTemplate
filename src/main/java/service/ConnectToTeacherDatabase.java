package service;//look at Student database and copy exactly

import java.util.ArrayList;
import java.sql.*;

public class ConnectToTeacherDatabase {
    public static ArrayList<TeacherInfo> teacherInfo(String teacherName) {
        ArrayList<TeacherInfo> teacherInfo = new ArrayList<TeacherInfo>();
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

            String query = "SELECT * FROM Teacher WHERE TeacherName = 'teacherName'; ";//SQL SELECT query that filters all throughout table only from teachername
            Statement st = connection.createStatement();//create the java statement

            ResultSet resultSet = st.executeQuery(query);//execute the query and get a java resultset


            while (resultSet.next()) {
                    String teacher = resultSet.getString("teacher_Name");//might need to capatalize if doesn't work
                    newTeacherInfo.setTeacherName(teacher);
                    String title = resultSet.getString("teacher_Title");
                    newTeacherInfo.setTitle(title);
                    String department = resultSet.getString("teacher_Department");
                    newTeacherInfo.setDepartment(department);
                    String education = resultSet.getString("teacher_Education");
                    newTeacherInfo.setEducation(education);
                    String email = resultSet.getString("teacher_Email");
                    newTeacherInfo.setEmail(email);

                    teacherInfo.add(newTeacherInfo);
                    //printing out the results
                    System.out.format(newTeacherInfo.getTeacherName(), newTeacherInfo.getTitle(), newTeacherInfo.getDepartment(), newTeacherInfo.getEducation(), newTeacherInfo.getEmail());
                }

                connection.close();

            } catch (SQLException e)//handle any errors
            {
                e.printStackTrace();
            }
         catch (Exception e) {
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

            String query = "SELECT * FROM Teacher WHERE Department = 'department'; ";//SQL SELECT query that filters all throughout table only from teachername
            Statement st = connection.createStatement();//create the java statement

            ResultSet resultSet = st.executeQuery(query);//execute the query and get a java resultset


                while (resultSet.next()) {
                        teacherNames.add(resultSet.getString(1));
                }
                connection.close();

            }
            catch (SQLException e)//handle any errors
            {
                e.printStackTrace();
            }
        return teacherNames;
        }

    }


