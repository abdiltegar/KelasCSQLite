package com.example.kelascsqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.kelascsqlite.database.DBController;
import com.google.android.material.textfield.TextInputEditText;

import java.util.HashMap;

public class TemanEdit extends AppCompatActivity {
    private TextInputEditText tNama, tTelp;
    private Button btnSimpan;
    String id, nm, tlp;
    DBController controller = new DBController(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teman_edit);

        tNama = findViewById(R.id.tietEditNama);
        tTelp = findViewById(R.id.tietEditTelpon);
        btnSimpan = findViewById(R.id.buttonSaveEdit);

        Bundle bundle = getIntent().getExtras();
        tNama.setText(bundle.getString("nama"));
        tTelp.setText(bundle.getString("telepon"));

        btnSimpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (tNama.getText().toString().equals("") || tTelp.getText().toString().equals("")){
                    Toast.makeText(getApplicationContext(), "Data tidak boleh kosong !",Toast.LENGTH_LONG).show();
                }else{
                    nm = tNama.getText().toString();
                    tlp = tTelp.getText().toString();
                    id = bundle.getString("id");

                    HashMap<String, String> qvalues = new HashMap<>();
                    qvalues.put("nama",nm);
                    qvalues.put("telpon",tlp);
                    qvalues.put("id",id);

                    controller.updateData(qvalues);
                    callName();
                }
            }
        });
    }

    public void callName(){
        Intent intent = new Intent(TemanEdit.this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}