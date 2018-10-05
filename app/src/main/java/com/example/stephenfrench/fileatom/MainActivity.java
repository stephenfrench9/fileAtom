package com.example.stephenfrench.fileatom;

import android.os.Build;
import android.os.Environment;
import android.speech.tts.TextToSpeech;
import android.support.annotation.RequiresApi;
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

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTextView = findViewById(R.id.tv);
        mFullAddress = this.getExternalFilesDir(null) + "/BBB.txt";
        mMessage = "TutorialsPoint is one the best site in the world\nAnd this is some new info\nand another line\nAlexYerby";

        write(mMessage, mFullAddress);

        File caitlin = this.getExternalFilesDir(null);
        String externalFilesDirAddress = caitlin.getAbsolutePath();
        Log.d("BASIL", "onCreate(), externalFilesDir is at: " + externalFilesDirAddress);
        Log.d("BASIL", "onCreate(), externalFilesDir State is: " + String.valueOf(Environment.getExternalStorageState(caitlin)));
        Log.d("BASIL", "onCreate(), externalFilesDir is emulated: - " + String.valueOf(Environment.isExternalStorageEmulated(caitlin)));
        Log.d("BASIL", "onCreate(), externalFilesDir is removable: - " + String.valueOf(Environment.isExternalStorageRemovable(caitlin)));


        File externalStorageDirectory = Environment.getExternalStorageDirectory();
        String externalStorageDirectoryAddress = externalStorageDirectory.getAbsolutePath();
        Log.d("BASIL", "onCreate(), externalStorageDirectory is at: " + externalStorageDirectoryAddress);
        Log.d("BASIL", "onCreate(), externalStorageDirectory State is: " + Environment.getExternalStorageState(externalStorageDirectory));
        Log.d("BASIL", "onCreate(), externalStorageDirectory is emulated: - " + String.valueOf(Environment.isExternalStorageEmulated(externalStorageDirectory)));
        Log.d("BASIL", "onCreate(), externalFilesDir is removable: - " + String.valueOf(Environment.isExternalStorageRemovable(externalStorageDirectory)));


        File externalStoragePublicDirectory = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES);
        String externalStoragePublicDirectoryAddress = externalStoragePublicDirectory.getAbsolutePath();
        Log.d("BASIL", "onCreate(), externalStoragePublicDirectory is at: " + externalStoragePublicDirectoryAddress);
        Log.d("BASIL", "onCreate(), externalStoragePublicDirectory State is: " + Environment.getExternalStorageState(externalStoragePublicDirectory));
        Log.d("BASIL", "onCreate(), externalStoragePublicDirectory is emulated: - " + String.valueOf(Environment.isExternalStorageEmulated(externalStoragePublicDirectory)));
        Log.d("BASIL", "onCreate(), externalStoragePublicDirectory is removable: - " + String.valueOf(Environment.isExternalStorageRemovable(externalStoragePublicDirectory)));

        File dataDirectory = Environment.getDataDirectory();
        String dataDirectoryAddress = dataDirectory.getAbsolutePath();
        Log.d("BASIL", "onCreate(), dataDirectory is at: " + dataDirectoryAddress);
//        Log.d("BASIL", "onCreate(), dataDirectory is emulated: " + Environment.isExternalStorageEmulated(dataDirectory));

        File downloadCacheDirectory = Environment.getDownloadCacheDirectory();
        String downloadCacheDirectoryAddress = downloadCacheDirectory.getAbsolutePath();
        Log.d("BASIL", "onCreate(), downloadCacheDirectory is at: " + downloadCacheDirectoryAddress);
//        Log.d("BASIL", "onCreate(), downloadCacheDirectory is emulated: " + Environment.isExternalStorageEmulated(downloadCacheDirectory));

        File rootDirectory = Environment.getRootDirectory();
        String rootDirectoryAddress = rootDirectory.getAbsolutePath();
        Log.d("BASIL", "onCreate(), root is at: " + rootDirectoryAddress);

        Log.d("BASIL", "onCreate(), the Overall external storage state is: " + Environment.getExternalStorageState());
        Log.d("BASIL", "onCreate(), the Overall external storage is emulated: " + Environment.isExternalStorageEmulated());
        Log.d("BASIL", "onCreate(), the Overall external storage is removable: " + Environment.isExternalStorageRemovable());


    }

    public void zooba(View v) {
        mTextView.setText(read(mFullAddress));
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
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
