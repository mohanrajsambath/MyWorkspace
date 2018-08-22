package mohan.com.discreetseekbar;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private SeekBar mCustomSeekBar;
    private TextView txtVw_Size;
    float mVal=16.0f;
    float mFillDefault=32.0f;
    float mRange= 2.6f;/*16/6*/
    //float mRange= 3.2f;/*16/5*/
    //double mRange= 2.285714286;/*16/7*/
    //double mRange= 4.571428571;/*32/7*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtVw_Size=(TextView)findViewById(R.id.txtVw_Size);
        txtVw_Size.setTextSize(mVal);
        mCustomSeekBar=(SeekBar)findViewById(R.id.sb);
        mCustomSeekBar.setProgress(6);
        mCustomSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                mVal=16.0f;
                switch(progress){
                    case 1:
                        mVal=mVal+(mRange);
                        //mCustomSeekBar.setTickMark(getDrawable(R.drawable.ic_circle));
                        break;
                    case 2:
                        mVal=mVal+(mRange*2);
                        break;
                    case 3:
                        mVal=mVal+(mRange*3);
                        break;
                    case 4:
                        mVal=mVal+(mRange*4);
                        break;
                    case 5:
                        mVal=mVal+(mRange*5);
                        break;
                    case 6:
                        mVal=mVal+(mRange*6);
                        break;
                    default:
                        mVal=16.0f;
                        break;

                }
                System.out.println("ProgressValue:"+progress);
                System.out.println("ProgressValue mVal:"+mVal);
                Toast.makeText(getApplicationContext(),"ProgressValue mVal:"+mVal,Toast.LENGTH_SHORT).show();
                txtVw_Size.setTextSize(mVal);

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        /*final DottedSeekBar bar = (DottedSeekBar) findViewById(R.id.seekBar);

        bar.setDots(new int[] {25, 50, 75});
        bar.setDotsDrawable(R.drawable.ic_circle);*/
    }
}
