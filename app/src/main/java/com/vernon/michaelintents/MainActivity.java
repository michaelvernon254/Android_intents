package com.vernon.michaelintents;

import android.content.Intent;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void Call(View view) {
        Intent call_me = new Intent(Intent.ACTION_DIAL);
        call_me.setData(Uri.parse("Tel:"));
        startActivity(call_me);
    }

    public void message(View view) {
        Intent text_me = new Intent(Intent.ACTION_MAIN);
        text_me.setType("vnd.android-dir/mms-sms");
        startActivity(text_me);
    }

    public void camera(View view) {
        Intent selfie_me = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(selfie_me, 0);
    }

    public void share(View view) {
        Intent share_me = new Intent(Intent.ACTION_SEND);
        share_me.setType("plain/text");
        share_me.putExtra(Intent.EXTRA_EMAIL, new String[]{"_ _ _"});
        share_me.putExtra(Intent.EXTRA_SUBJECT, "_ _ _");
        startActivity(Intent.createChooser(share_me, "Sharing"));
    }
}
