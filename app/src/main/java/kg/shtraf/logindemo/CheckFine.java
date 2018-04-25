package kg.shtraf.logindemo;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CheckFine extends AppCompatActivity {

    private TextView tvData;
    public EditText textFill;


    private List<Result> employeeList;
    private ProgressDialog pDialog;
    private RecyclerView recyclerView;
    private EmployeesAdapter eAdapter;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_fine);


        Button btnHit = findViewById(R.id.btnHit);
        tvData = findViewById(R.id.tvJsonItem);
        textFill = findViewById(R.id.fillText);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pDialog = new ProgressDialog(CheckFine.this);
        pDialog.setMessage("Loading Data.. Please wait...");
        pDialog.setIndeterminate(false);
        pDialog.setCancelable(false);
        pDialog.show();

        btnHit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                ApiService api = RetroClient.getApiService();

                /**
                 * Calling JSON
                 */
                Call<EmployeeList> call = api.getMyJSON();

                /**
                 * Enqueue Callback will be call when get response...
                 */
                call.enqueue(new Callback<EmployeeList>() {
                    @Override
                    public void onResponse(Call<EmployeeList> call, Response<EmployeeList> response) {
                        //Dismiss Dialog
                        pDialog.dismiss();

                        if (response.isSuccessful()) {
                            /**
                             * Got Successfully
                             */
                                employeeList = response.body().getResult();
                        }
                    }

                    @Override
                    public void onFailure(Call<EmployeeList> call, Throwable t) {
                        pDialog.dismiss();
                    }
                });
            }
        });
    }
}


