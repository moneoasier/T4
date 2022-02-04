package com.example.beltzarun;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Build;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.NumberPicker;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Executable;
import java.util.ArrayList;

import Data.GameDBhelper;
import Data.Highscore;
import PostgreSQL.Database;
import PostgreSQL.SendDataToServer;

public class Choose_player_data extends AppCompatActivity implements AdapterView.OnItemSelectedListener{
    public static Spinner spin;
    Button back_home,bidali,checkfile;
    TextView choose_player_score_text;
    private boolean done = false;
    ArrayList<String> array_employee = new ArrayList<>();
    public static int selectedEmployee = 0;
    public static int age = 0;
    EditText mEditText;
    GameDBhelper gameDBhelper;
    @RequiresApi(api = Build.VERSION_CODES.Q)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.choose_player_data);
        System.out.println(MainActivity.employees);
        setBidali_Button();
        setCheckFile_Button();
        setBack_Home_Button();
        setSpin();
    }

    private void setCheckFile_Button() {
        checkfile = findViewById(R.id.checkFile);

        checkfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                readLocalUser();
            }
        });
    }


    public void setSpin(){
        spin = findViewById(R.id.employee_spinner);
        spin.setOnItemSelectedListener(this);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, array_employee){
            public View getView(int position, View convertView, ViewGroup parent) {

                View v = super.getView(position, convertView, parent);

                ((TextView) v).setTextSize(16);

                return v;

            }

            public View getDropDownView(int position, View convertView,ViewGroup parent) {

                View v = super.getDropDownView(position, convertView,parent);

                ((TextView) v).setGravity(Gravity.CENTER);

                return v;

            }

        };
        //adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spin.setAdapter(adapter);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        System.out.println(position);
        selectedEmployee = position;
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    public void setBack_Home_Button(){
        back_home = findViewById(R.id.choose_player_back_home);

        back_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),MainActivity.class));
            }
        });
        for (Employee employe:MainActivity.employees)
        {
            array_employee.add(employe.getEmployee_name());
        }
        done = true;
    }

    public void setBidali_Button(){
        TextView password_text = findViewById(R.id.editTextTextPassword);
        bidali = findViewById(R.id.choose_player_bidali);
        gameDBhelper = new GameDBhelper(this);
        bidali.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.O)
            @Override
            public void onClick(View v) {
                System.out.println(MainActivity.employees.get(selectedEmployee).getPassword()+","+password_text.getText());
                if(MainActivity.employees.get(selectedEmployee).getPassword().contentEquals(password_text.getText())){
                    try {
                        createLocalUser("user", MainActivity.employees.get(selectedEmployee).getEmployeeId()+":"+MainActivity.employees.get(selectedEmployee).getPassword());
                        //gameDBhelper.saveHighscore(new Highscore(15,2,22,"Disenatzailea"));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
    }

    public void createLocalUser(String fileName, String content) throws IOException {
        File path = getApplicationContext().getFilesDir();
        FileOutputStream writer = null;
        try{
            writer = new FileOutputStream(new File(path,fileName));
            System.out.println(path);
            writer.write(content.getBytes());
        }catch(Exception e){
            e.printStackTrace();
        }finally {
            if(writer != null){
                writer.close();
            }
        }
    }

    public void readSQLite(){
        Cursor cursor = gameDBhelper.getData();
        if(cursor.getCount() == 0){
            System.out.println("There is no data to fetch");
        }else{
            StringBuffer stringBuffer = new StringBuffer();
            while(cursor.moveToNext()){
                stringBuffer.append("Points "+cursor.getString(1)+"\n");
                stringBuffer.append("PlayerId "+cursor.getString(3)+"\n");
            }
            System.out.println(stringBuffer.toString());
        }
    }

    public void readLocalUser(){
        FileInputStream fis = null;

        try{
            fis = openFileInput("user");
            InputStreamReader isr = new InputStreamReader(fis);
            BufferedReader br = new BufferedReader(isr);
            StringBuilder sb = new StringBuilder();
            String text;
            while((text = br.readLine()) != null){
                sb.append(text).append("\n");
            }
            System.out.println(sb.toString());

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(fis != null){
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }


}
