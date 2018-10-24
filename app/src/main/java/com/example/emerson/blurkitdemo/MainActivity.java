package com.example.emerson.blurkitdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import io.alterac.blurkit.BlurKit;
import io.alterac.blurkit.BlurLayout;

public class MainActivity extends AppCompatActivity {
    ImageView imageView2;
    BlurLayout blurLayout;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView2 = findViewById(R.id.imageView2);
        blurLayout = findViewById(R.id.blurLayout);
        button = findViewById(R.id.button);

        button.setOnClickListener(buttonFunction);
        BlurKit.init(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
        blurLayout.startBlur();
    }

    @Override
    protected void onStop() {
        blurLayout.pauseBlur();
        super.onStop();
    }

    private View.OnClickListener buttonFunction = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            imageView2.setImageBitmap(BlurKit.getInstance().fastBlur(imageView2, 12, 0.12f));
//            imageView.setImageBitmap(BlurKit.getInstance().blur(imageView, 25));
        }
    };
}
