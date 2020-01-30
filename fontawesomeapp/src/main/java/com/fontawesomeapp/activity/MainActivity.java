package com.fontawesomeapp.activity;

import android.graphics.Typeface;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatTextView;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.fontawesomeapp.R;
import com.fontawesomeapp.utils.Brands_FontManager;
import com.fontawesomeapp.utils.FontManager;
import com.fontawesomeapp.utils.Light_FontManager;
import com.fontawesomeapp.utils.Solid_FontManager;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    TextView txTw_circle_outside,txTw_circle_inside,txTw_flipCamera,txTw_scriptEdit,txtVw_close,txtVw_settings,txTw_audio,txTw_library,txTw_link;
    Typeface iconFont,brandIconFont,solidIconFont,lightIconFont;
    private RelativeLayout icons_container;
private AppCompatTextView txTw_Video;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Let's mark this ViewGroup as an icon container
        iconFont = FontManager.getTypeface(getApplicationContext(), FontManager.FONTAWESOME);
        FontManager.markAsIconContainer(findViewById(R.id.icons_container_webfont), iconFont);

        brandIconFont = Brands_FontManager.getTypeface(getApplicationContext(), Brands_FontManager.BRAND_FONTAWESOME);
        Brands_FontManager.markAsIconContainer(findViewById(R.id.icons_container_brand), brandIconFont);

        solidIconFont = Solid_FontManager.getTypeface(getApplicationContext(), Solid_FontManager.SOLID_FONTAWESOME);
        lightIconFont = Light_FontManager.getTypeface(getApplicationContext(), Light_FontManager.LIGHT_FONTAWESOME);

        initViews();

    }

    private void initViews() {
        icons_container = findViewById(R.id.icons_container);
        txTw_circle_outside = findViewById(R.id.txTw_circle_outside);
        txTw_circle_inside = findViewById(R.id.txTw_circle_inside);
        txTw_flipCamera = findViewById(R.id.txTw_flipCamera);
        txTw_scriptEdit = findViewById(R.id.txTw_scriptEdit);
        txtVw_close = findViewById(R.id.txtVw_close);
        txtVw_settings = findViewById(R.id.txtVw_settings);

        txTw_Video = findViewById(R.id.txTw_Video);
        txTw_audio = findViewById(R.id.txTw_audio);
        txTw_library = findViewById(R.id.txTw_library);
        txTw_link = findViewById(R.id.txTw_link);
        //Typeface typeFace = Typeface.createFromAsset(getAssets(), "<file name>");
        txTw_circle_outside.setTypeface(lightIconFont);
        txTw_flipCamera.setTypeface(lightIconFont);
        txTw_scriptEdit.setTypeface(lightIconFont);
        txtVw_close.setTypeface(lightIconFont);
        txtVw_settings.setTypeface(lightIconFont);
        txTw_circle_inside.setTypeface(solidIconFont);

        txTw_Video.setBackgroundResource(R.drawable.round_rect_shape);
        txTw_audio.setBackgroundResource(0);
        txTw_library.setBackgroundResource(0);
        txTw_link.setBackgroundResource(0);

        txTw_Video.setOnClickListener(this);
        txTw_audio.setOnClickListener(this);
        txTw_library.setOnClickListener(this);
        txTw_link.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case  R.id.txTw_Video:

                txTw_Video.setBackgroundResource(R.drawable.round_rect_shape);
                txTw_audio.setBackgroundResource(0);
                txTw_library.setBackgroundResource(0);
                txTw_link.setBackgroundResource(0);
                icons_container.setBackgroundResource(R.drawable.bg_minion);
                break;
            case  R.id.txTw_audio:
                txTw_Video.setBackgroundResource(0);
                txTw_audio.setBackgroundResource(R.drawable.round_rect_shape);
                txTw_library.setBackgroundResource(0);
                txTw_link.setBackgroundResource(0);
                icons_container.setBackgroundResource(R.drawable.bg_rio);
                break;
            case  R.id.txTw_library:
                txTw_Video.setBackgroundResource(0);
                txTw_audio.setBackgroundResource(0);
                txTw_library.setBackgroundResource(R.drawable.round_rect_shape);
                txTw_link.setBackgroundResource(0);
                icons_container.setBackgroundResource(R.drawable.bg_zotopia);
                break;
            case  R.id.txTw_link:
                txTw_Video.setBackgroundResource(0);
                txTw_audio.setBackgroundResource(0);
                txTw_library.setBackgroundResource(0);
                txTw_link.setBackgroundResource(R.drawable.round_rect_shape);
                icons_container.setBackgroundResource(R.drawable.bg_cloudnet);
                break;
            default:
                break;
        }

    }
}