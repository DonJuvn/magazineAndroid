package com.example.magazine;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView chooseAnroid, chooseIOS;
    RadioButton kartochka_radioBTN, kolmakol_radioBTN, qiwi_radioBTN;
    CheckBox uige_checkBOX, syilyk_checkBOX;
    Button jiberu_btn;
    String tolemTuri, jetkizuTuri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        chooseAnroid = findViewById(R.id.chooseAndroid);
        chooseIOS = findViewById(R.id.chooseIOS);

        kartochka_radioBTN = findViewById(R.id.kartochka_radioBTN);
        kolmakol_radioBTN = findViewById(R.id.kolmakol_radioBTN);
        qiwi_radioBTN = findViewById(R.id.qiwi_radioBTN);

        uige_checkBOX = findViewById(R.id.uige_checkBOX);
        syilyk_checkBOX = findViewById(R.id.syilyk_checkBOX);

        jiberu_btn = findViewById(R.id.jiberu_btn);

        registerForContextMenu(chooseAnroid);
        registerForContextMenu(chooseIOS);

        jiberu_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(kartochka_radioBTN.isChecked()){
                    tolemTuri = "bank kartochka arkyly";
                }else if(qiwi_radioBTN.isChecked()){
                    tolemTuri = "qiwi arkyly";
                }else if(kolmakol_radioBTN.isChecked()){
                    tolemTuri = "kolma kol arkyly";
                }

                if(uige_checkBOX.isChecked()){
                    jetkizuTuri = "uige dein";
                }
                if(syilyk_checkBOX.isChecked()){
                    jetkizuTuri = "syilyk retinde";
                }
                String result = "Android:" + chooseAnroid.getText() + "\n" +
                        "IOS:" + chooseIOS.getText() + "\n" +
                        "Tolem Turi:" + tolemTuri + "\n" +
                        "Jetkizu turi:" + jetkizuTuri;

                Toast.makeText(MainActivity.this, result, Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        if(v == chooseAnroid) {
            MenuInflater menuInflater = getMenuInflater();
            menuInflater.inflate(R.menu.android_menu, menu);

            super.onCreateContextMenu(menu, v, menuInfo);
        }
        if(v == chooseIOS){

            MenuInflater menuInflater = getMenuInflater();
            menuInflater.inflate(R.menu.ios_phone, menu);

            super.onCreateContextMenu(menu, v, menuInfo);
        }
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.samsung:
                chooseAnroid.setText("samsung tandaldy");
                break;
            case R.id.xiaomi:
                chooseAnroid.setText("xiaomi tandaldy");
                break;
            case R.id.redmi:
                chooseAnroid.setText("redmi tandaldy");
                break;

            case R.id.iphone10:
                chooseIOS.setText("iphone 10 tandaldy");
                break;
            case R.id.iphone11:
                chooseIOS.setText("iphone 11 tandaldy");
                break;
            case R.id.iphone12:
                chooseIOS.setText("iphone 12 tandaldy");
                break;
            case R.id.iphone13:
                chooseIOS.setText("iphone 13 tandaldy");
                break;
        }
        return super.onContextItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.main, menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.menu_settings:
                Toast.makeText(this, "Settings menu basyldy", Toast.LENGTH_LONG).show();
                break;
            case R.id.menu_cut:
                Toast.makeText(this, "Cut menu basyldy", Toast.LENGTH_LONG).show();
                break;
            case R.id.menu_exit:
                Toast.makeText(this, "Exit menu basyldy", Toast.LENGTH_LONG).show();
                break;
            case R.id.menu_save:
                Toast.makeText(this, "Save menu basyldy", Toast.LENGTH_LONG).show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

}