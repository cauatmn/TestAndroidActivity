package com.example.cm.testandroidactivity;
//import android.Manifest;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText editText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        String TAG = "TestAndroidActivity";
        super.onCreate(savedInstanceState);
        Log.d(TAG,this.toString());
        setContentView(R.layout.activity_main);

        findViewById(R.id.But1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse("http://www.baidu.com"));
                startActivity(i);
            }
        });
        findViewById(R.id.But2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,SecondActivity.class);
                intent.putExtra("Url","http://www.baidu.com");
                startActivityForResult(intent, 1);
            }
        });
        findViewById(R.id.Bu3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,SecondActivity.class);
                editText = (EditText)findViewById(R.id.edit_text);
                String putText = editText.getText().toString();
                intent.putExtra("String",putText);
                startActivityForResult(intent,2);
            }
        });
    }
    @Override
    protected  void onActivityResult(int requestCode,int resultCode,Intent data){
        switch (requestCode){
            case 1:
                if(resultCode == RESULT_OK){
                    String returnedData =data.getStringExtra("url");
                    TextView showTestView = (TextView) findViewById(R.id.textView);
                    showTestView.setText(returnedData);
                }
                break;
            case 2:
                if(resultCode == RESULT_OK){
                    String returnedData =data.getStringExtra("String");
                    Toast.makeText(MainActivity.this,returnedData,Toast.LENGTH_SHORT).show();
                }
            default:{

            }
        }
    }
    @Override
    protected void onRestart(){
        super.onRestart();
        Log.d("FirstActivity","onRestart");
    }
}
