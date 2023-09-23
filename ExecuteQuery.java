import java.sql.*;

public class App{
    public static final String url = "jdbc:mysql://localhost:3306/mydb";
    public static final String username = "root";
    public static final String password = "199500";
    public static void main(String[] args) {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection connection = DriverManager.getConnection(url, username, password);
            
            Statement statement = connection.createStatement();

            String sqlQuery = "SELECT  employees.Id, employees.FirstName, employees.LastName, employees.department_Id, department.department_name FROM mydb.employees JOIN mydb.department ON employees.department_Id = department.department_Id";

            ResultSet resultSet = statement.executeQuery(sqlQuery);

            /*SELECT employees.Id, employees.FirstName,employees.LastName, employees.department_Id, department.department_name    FROM mydb.employees JOIN mydb.department ON employees.department_Id = department.department_Id; */
            
            /*String sqlQuery ="UPDATE mydb.employeesString sqlQuery = SET department_Id = 3 WHERE Id = 102;";

            //ResultSet resultSet = statement.executeQuery(sqlQuery); read value from data

            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);

            preparedStatement.setString(0, sqlQuery);;

            int rowsUpdated = preparedStatement.executeUpdate();*/
 
            while(resultSet.next()){
                String colum1Id = resultSet.getString("Id");
                String colum2FirstName = resultSet.getString("FirstName");
                String colum3LastName = resultSet.getString("LastName");
                String colum4Department_Id = resultSet.getString("department_Id");
                String colum5Department_name = resultSet.getString("department_name");
                
                System.out.format("|%s |%s |%s |%s |%s | %n", colum1Id, colum2FirstName, colum3LastName, colum4Department_Id, colum5Department_name );
            }
          }catch(Exception e){
            System.out.println(e);
        }
    }
}

//url = "jdbc:mysql://localhost:3306/myshop";
//Class.forName = "com.mysql.cj.jdbc.Driver"

            // Iterate through the result set and display data
            /*while (resultSet.next()) {
                // Replace "column_name" with the actual column names in your table
                String column1 = resultSet.getString("Id");
                String column2 = resultSet.getString("FirstName");
                String column3 = resultSet.getString("LastName");
                String column4 = resultSet.getString("address");

                // Display the data (customize this part based on your needs)
                System.out.println("Column1: " + column1 + ", Column2: " + column2 + ", Column3: " + column3 + ", Column4: " + column4);
            }*/


