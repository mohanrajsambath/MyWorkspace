package mohan.com.chiputils;

import android.content.Context;
import android.util.TypedValue;
import android.widget.TextView;

/*import com.tokenautocomplete.ViewSpan;*/

/**
 * Span that displays +[x]
 */

class CountSpan extends ViewSpan {
    String text = "";

    CountSpan(int count, Context ctx, int textColor, int textSize, int maxWidth) {
        super(new TextView(ctx), maxWidth);
        TextView v = (TextView)view;
        v.setTextColor(textColor);
        v.setTextSize(TypedValue.COMPLEX_UNIT_PX, textSize);
        setCount(count);
    }

    void setCount(int c) {
        text = "+" + c;
        ((TextView)view).setText(text);
    }
}
