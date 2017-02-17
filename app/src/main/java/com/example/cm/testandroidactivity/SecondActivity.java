package com.example.cm.testandroidactivity;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.util.Log;
import android.widget.TextView;


public class SecondActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("BaseActivity", getClass().getSimpleName());
        Intent intent1 = getIntent();
        final String Url = intent1.getStringExtra("Url");
        setContentView(R.layout.activity_second);
        TextView textView = (TextView)findViewById(R.id.textView2);
        textView.setText(Url);
        findViewById(R.id.But2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent2 = new Intent(Intent.ACTION_VIEW);
                intent2.setData(Uri.parse(Url));
                startActivity(intent2);
            }
        });
        findViewById(R.id.CloseAC).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent3 = new Intent();
                intent3.putExtra("url",Url);
                setResult(RESULT_OK,intent3);
                finish();
            }
        });
        findViewById(R.id.CloseBC).setOnClickListener(new View.OnClickListener() {
            Intent intent5 = getIntent();
            final String Url = intent5.getStringExtra("String");
            @Override
            public void onClick(View view) {
                Intent intent4 = new Intent();
                intent4.putExtra("String",Url);
                setResult(RESULT_OK,intent4);
                finish();
            }
        });

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("SecondActivity", "onDestroy");
        ActivityCollector.removeActivity(this);
    }

    @Override
    protected void onPause() {
        super.onPause();
    }
}
