package com.example.stephenfrench.fileatom;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    TextView mTextView;
    String mFullAddress;
    String mMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTextView = findViewById(R.id.tv);
        mFullAddress = this.getFilesDir() + "AAA.txt";
        mMessage = "TutorialsPoint is one the best site in the world\nAnd this is some new info\nand another line";

        write(mMessage, mFullAddress);
    }

    public void zooba(View v) {
        mTextView.setText(read(mFullAddress));
    }

    private void write(String address, String message) {
        try {
            File file = new File(mFullAddress);
            if (!file.exists()) {
                file.createNewFile();
            }
            FileWriter fw = new FileWriter(file.getAbsoluteFile());
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(mMessage);
            bw.close();

            System.out.println("Done");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String read(String address) {
        String something="nonsuccess/that";
        try {
            BufferedReader in = new BufferedReader(new FileReader(mFullAddress));
            String str;

            while ((str = in.readLine()) != null) {
                something = str;
            }

        } catch (IOException e) {
        }
        return something;
    }

}
