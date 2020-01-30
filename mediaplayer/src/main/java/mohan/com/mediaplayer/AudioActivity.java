package mohan.com.mediaplayer;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

/*
 * Copyright (c) 2020. Created by Mohanraj.S,Innobot Systems on 30/1/20 for MyWorkspace
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
public class AudioActivity extends AppCompatActivity {
    private Button start,pause,stop;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_audio);
        start= findViewById(R.id.button1);
        pause= findViewById(R.id.button2);
        stop= findViewById(R.id.button3);

        final MediaPlayer mp=new MediaPlayer();
        try{
            mp.setDataSource(Environment.getExternalStorageDirectory().getPath()+"/Music/maine.mp3");
            //mp.setDataSource("android.resource://" + getPackageName() + "/" + R.raw.birdsofparadise);
            Uri uri = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.birdsofparadise);
            mp.prepare();
        }catch(Exception e){e.printStackTrace();}

        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mp.start();
            }
        });
        pause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mp.pause();
            }
        });
        stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mp.stop();
            }
        });
    }
}
