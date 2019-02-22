package mohan.com.htmltextimg;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LevelListDrawable;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.text.Spanned;
import android.util.Log;
import android.widget.TextView;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

public class MainActivity extends AppCompatActivity implements Html.ImageGetter {
    private final static String TAG = "TestImageGetter";
    private TextView mTv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String source = "this is a test of <b>ImageGetter</b> it contains " +
                "two images: <br/>" +
                "<img src=\"http://developer.android.com/assets/images/dac_logo.png\"><br/>and<br/>" +
                "<img src=\"http://www.hdwallpapersimages.com/wp-content/uploads/2014/01/Winter-Tiger-Wild-Cat-Images.jpg\">";
        String imgs="<p><img alt=\"\" src=\"https://s3.ap-southeast-1.amazonaws.com/images.deccanchronicle.com/dc-Cover-652ovhkibhg82kh6on274ihkn1-20171208011414.Medi.jpeg\" style=\"height:50px; width:100px\" />Test Article, Test Article, Test Article, Test Article,Test Article,Test Article,Test Article,Test Article,Test Article,Test Article,Test Article,Test Article,Test Article,Test Article,Test Article,Test Article,Test Article,Test Article,Test Article,Test Article,Test Article,Test Article,Test Article,v</p>";
        String src="<p><img alt=\"\" src=\"https://i.pinimg.com/originals/19/b6/3c/19b63c6baa28dc6517ee7d620a0132a4.jpg\" />Test Attractions Test Attractions Test Attractions Test Attractions</p>";
        String img="<p><img alt=\"\" src=\"/site_media/photos/gallery/75b3fb14-3be6-4d14-88fd-1b9d979e716f.jpg\" style=\"height:508px; width:640px\" />Test Article, Test Article, Test Article, Test Article,Test Article,Test Article,Test Article,Test Article,Test Article,Test Article,Test Article,Test Article,Test Article,Test Article,Test Article,Test Article,Test Article,Test Article,Test Article,Test Article,Test Article,Test Article,Test Article,v</p>";
        Spanned spanned = Html.fromHtml(imgs, this, null);
        mTv = (TextView) findViewById(R.id.text);
        mTv.setText(spanned);
    }
    @Override
    public Drawable getDrawable(String source) {
        LevelListDrawable d = new LevelListDrawable();
        Drawable empty = getDrawable(R.drawable.ic_launcher_background);
        d.addLevel(0, 0, empty);
        d.setBounds(0, 0, empty.getIntrinsicWidth(), empty.getIntrinsicHeight());

        new LoadImage().execute(source, d);

        return d;
    }

    class LoadImage extends AsyncTask<Object, Void, Bitmap> {

        private LevelListDrawable mDrawable;

        @Override
        protected Bitmap doInBackground(Object... params) {
            String source = (String) params[0];
            mDrawable = (LevelListDrawable) params[1];
            Log.d(TAG, "doInBackground " + source);
            try {
                InputStream is = new URL(source).openStream();
                return BitmapFactory.decodeStream(is);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(Bitmap bitmap) {
            Log.d(TAG, "onPostExecute drawable " + mDrawable);
            Log.d(TAG, "onPostExecute bitmap " + bitmap);
            if (bitmap != null) {
                BitmapDrawable d = new BitmapDrawable(bitmap);
                mDrawable.addLevel(1, 1, d);
                mDrawable.setBounds(0, 0, bitmap.getWidth(), bitmap.getHeight());
                mDrawable.setLevel(1);
                // i don't know yet a better way to refresh TextView
                // mTv.invalidate() doesn't work as expected
                CharSequence t = mTv.getText();
                mTv.setText(t);
            }
        }
    }
}
