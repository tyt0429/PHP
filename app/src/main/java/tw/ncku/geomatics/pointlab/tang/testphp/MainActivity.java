package tw.ncku.geomatics.pointlab.tang.testphp;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Looper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        new Thread(new Runnable(){

            @Override
            public void run() {
                Looper.prepare();
                // TODO Auto-generated method stub
                HttpClient client = new DefaultHttpClient();
                HttpPost myPost = new HttpPost("http://140.116.80.235:8080/post_ok.php");
                try {
                    List<NameValuePair> params = new ArrayList<NameValuePair>();
                    params.add(new BasicNameValuePair("UUID","25-AB-155-123-123"));
                    params.add(new BasicNameValuePair("Time","140.567567"));
                    params.add(new BasicNameValuePair("Major","99"));
                    params.add(new BasicNameValuePair("Minor","88"));
                    params.add(new BasicNameValuePair("Residual","13.853"));
                    myPost.setEntity(new UrlEncodedFormEntity(params, HTTP.UTF_8));
                    HttpResponse response = new DefaultHttpClient().execute(myPost);

                } catch (Exception e) {
                    Toast.makeText(MainActivity.this, "Cannot insert the data\n Please check INTERNET", Toast.LENGTH_SHORT).show();
                    e.printStackTrace();

                }
                Looper.loop();
            }}).start();
    }
}






