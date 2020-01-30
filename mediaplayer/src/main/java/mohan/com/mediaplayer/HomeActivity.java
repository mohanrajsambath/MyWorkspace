package mohan.com.mediaplayer;

import android.content.Intent;
import android.os.Bundle;
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
public class HomeActivity extends AppCompatActivity implements View .OnClickListener{
    private Button btn_video,btn_audio,btn_customvideo;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        btn_video= findViewById(R.id.btn_video);
        btn_audio= findViewById(R.id.btn_audio);
        btn_customvideo= findViewById(R.id.btn_customvideo);
        btn_video.setOnClickListener(this);
        btn_audio.setOnClickListener(this);
        btn_customvideo.setOnClickListener(this);
    }

    @Override
    public void onClick(View clickedView) {
        Intent  ioIntent;
        switch (clickedView.getId()){
            case R.id.btn_video:
                  ioIntent = new Intent(HomeActivity.this,VideoActivity.class);
                startActivity(ioIntent);

                break;
            case R.id.btn_audio:
                  ioIntent = new Intent(HomeActivity.this,AudioActivity.class);
                startActivity(ioIntent);
                break;
            case R.id.btn_customvideo:
                ioIntent = new Intent(HomeActivity.this,CustomVideoViewActivity.class);
                startActivity(ioIntent);
                break;
                default:break;
        }

    }
}
