package mohan.com.htmltextview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // read HTML String from Assets: http://upshots.org/android/android-read-a-text-file-from-assets
        InputStream stream;
        String text;
        try {
            stream = getAssets().open("data.html");
            int size = stream.available();
            byte[] buffer = new byte[size];
            stream.read(buffer);
            stream.close();
            text = new String(buffer);
        } catch (IOException e) {
            e.printStackTrace();
            text = "No data available";
        }

        TextView test = (TextView) findViewById(R.id.test);
        test.setText(Html.fromHtml(text, null, new MyTagHandler()));
    }
}
