package PostgreSQL;

import android.app.Activity;
import android.database.sqlite.SQLiteDatabase;

import com.example.beltzarun.Choose_player_data;
import com.example.beltzarun.Employee;
import com.example.beltzarun.MainActivity;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import Data.GameDBhelper;

public class Database {
    private Connection connection;

    private final String host = "192.168.65.55";

    private final String database = "partidak";
    private final int port = 5432;
    private final String user = "odoo";
    private final String pass = "admin";
    private String url = "jdbc:postgresql://%s:%d/%s";
    private boolean status;
    Activity mainActivity;
    Choose_player_data choose_player_data = new Choose_player_data();
    private Statement st;
    public Database()
    {
        this.url = String.format(this.url, this.host, this.port, this.database);
        connect();
        //this.disconnect();
        System.out.println("connection status:" + status);
        //MainActivity.employees = new ArrayList<>();
    }

    private void connect() {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run()
            {
                try
                {
                    Class.forName("org.postgresql.Driver");
                    connection = DriverManager.getConnection(url, user, pass);
                    status = true;
                    System.out.println("connected:" + status);
                    st = connection.createStatement();
                    String sql;
//                    sql = "SELECT hr_employee.id,hr_employee.name,hr_department.complete_name,(((365* EXTRACT(YEAR FROM NOW()))-(365*(EXTRACT(YEAR FROM hr_employee.birthday))))+ (EXTRACT(MONTH FROM NOW())-EXTRACT(MONTH FROM hr_employee.birthday))*30\n" +
//                            "+(EXTRACT(YEAR FROM NOW()) -  EXTRACT(DAY FROM hr_employee.birthday)))/365 as Age FROM hr_employee INNER JOIN hr_department ON hr_employee.department_id = hr_department.id";
                    sql = "SELECT hr_employee.id,hr_employee.name,hr_department.complete_name,date_part('year',age(hr_employee.birthday)) as Age,hr_passwords.password_id,hr_passwords.password FROM hr_employee INNER JOIN hr_department ON hr_employee.department_id = hr_department.id INNER JOIN hr_passwords ON hr_employee.id = hr_passwords.password_id";
                    ResultSet rs = st.executeQuery(sql);
                    MainActivity.employees = new ArrayList<>();
                    while(rs.next()){
                        int id = rs.getInt("id");
                        String name = rs.getString("name");
                        String complete_name = rs.getString("complete_name");
                        int age = rs.getInt("Age");
                        String password = rs.getString("password");
                        System.out.println(id+","+name+","+complete_name+","+password);
                        MainActivity.employees.add(new Employee(id,name,complete_name,age,password));
                        //System.out.println(MainActivity.employees);
                    }
                    rs.close();
                    st.close();
                    connection.close();
                }
                catch (Exception e)
                {
                    status = false;
                    System.out.print(e.getMessage());
                    e.printStackTrace();
                }
            }
        });
        thread.start();
        try
        {
            thread.join();
        }
        catch (Exception e)
        {
            e.printStackTrace();
            this.status = false;
        }
    }

    public Connection getExtraConnection()
    {
        Connection c = null;
        try
        {
            Class.forName("org.postgresql.Driver");
            c = DriverManager.getConnection(url, user, pass);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }

        return c;
    }


}
