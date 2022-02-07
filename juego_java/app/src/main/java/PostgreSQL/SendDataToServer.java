package PostgreSQL;



import android.content.res.AssetManager;
import android.os.Build;

import androidx.annotation.RequiresApi;

import com.example.beltzarun.MainActivity;
import com.example.beltzarun.Choose_player_data;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;

import java.io.ByteArrayInputStream;

import java.io.IOException;
import java.net.Socket;
import java.time.format.DateTimeFormatter;


@RequiresApi(api = Build.VERSION_CODES.O)
public class SendDataToServer extends Thread{
    AssetManager assetManager;
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

        @RequiresApi(api = Build.VERSION_CODES.O)
        public void run(){
            try{
                JSONObject json = new JSONObject();
                json.put("puntuazioa", MainActivity.Highscore);
                json.put("adina", MainActivity.employees.get(Choose_player_data.selectedEmployee).getAge());
                json.put("departamentua", MainActivity.employees.get(Choose_player_data.selectedEmployee).getDepartment());
                json.put("employeeid", MainActivity.employees.get(Choose_player_data.selectedEmployee).getEmployeeId());

                System.out.println("json"+json);
                //Create input stream
                BufferedInputStream bis = new BufferedInputStream(new ByteArrayInputStream(json.toString().getBytes()));
                //Create Socket
                Socket client = new Socket("192.168.65.5", 8888);
                //Output stream
                BufferedOutputStream bos = new BufferedOutputStream(client.getOutputStream());
                //Write data
                byte[] b = new byte[1024 * 8];
                int len;
                while ((len = bis.read(b)) != -1) {
                    bos.write(b, 0, len);
                    bos.flush();
                }
                System.out.println("File uploaded");

                //close resource
                bos.close();
                client.close();
                bis.close();
                System.out.println("File upload completed");
            }catch(IOException | JSONException e){
                System.out.println(e);
            }
        }

    }
