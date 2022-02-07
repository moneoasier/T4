package Data;

import android.content.ContentValues;
import android.os.Build;

import androidx.annotation.RequiresApi;

import java.time.LocalDateTime;
import java.util.Date;

public class Highscore {

    private int Points,PlayerID,Age;
    private String Department;
    private LocalDateTime date;



    @RequiresApi(api = Build.VERSION_CODES.O)
    public Highscore(int points, int playerID, int age, String department) {
        this.Points = points;
        this.date = LocalDateTime.now();
        this.PlayerID = playerID;
        this.Age = age;
        this.Department = department;
    }

    public Highscore(int points) {
        this.Points = points;
        this.Department = "Guest";
    }

    public ContentValues toContentValues() {
        ContentValues values = new ContentValues();
        values.put(GameDataStructure.GameDataColums.PUNTUAZIOA, Points);
        values.put(GameDataStructure.GameDataColums.DATA, String.valueOf(date));
        values.put(GameDataStructure.GameDataColums.EMPLOYEEID, PlayerID);
        values.put(GameDataStructure.GameDataColums.ADINA, Age);
        values.put(GameDataStructure.GameDataColums.DEPARTAMENDUA, Department);
        return values;
    }

    public int getPoints() {
        return Points;
    }

    public void setPoints(int points) {
        Points = points;
    }

    public int getPlayerID() {
        return PlayerID;
    }

    public void setPlayerID(int playerID) {
        PlayerID = playerID;
    }

    public int getAge() {
        return Age;
    }

    public void setAge(int age) {
        Age = age;
    }

    public String getDepartment() {
        return Department;
    }

    public void setDepartment(String department) {
        Department = department;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }
}
