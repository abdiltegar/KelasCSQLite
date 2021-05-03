package com.example.kelascsqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class TemanLihat extends AppCompatActivity {
    private TextView tvViewNama, tvViewTelepon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teman_lihat);

        tvViewNama = findViewById(R.id.tvViewNama);
        tvViewTelepon = findViewById(R.id.tvViewTelp);

        Bundle bundle = getIntent().getExtras();
        tvViewNama.setText(bundle.getString("nama"));
        tvViewTelepon.setText(bundle.getString("telepon"));
    }
}