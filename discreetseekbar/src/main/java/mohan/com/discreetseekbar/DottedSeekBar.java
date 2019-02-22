package mohan.com.discreetseekbar;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.util.AttributeSet;

/*
 * Copyright (c) 2018. Created by Mohanraj.S,Innobot Systems on 12/6/18 for MyWorkspace
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
public class DottedSeekBar extends android.support.v7.widget.AppCompatSeekBar {

    /** Int values which corresponds to dots */
    private int[] mDotsPositions = null;
    /** Drawable for dot */
    private Bitmap mDotBitmap = null;

    public DottedSeekBar(final Context context) {
        super(context);
        init(null);
    }

    public DottedSeekBar(final Context context, final AttributeSet attrs) {
        super(context, attrs);
        init(attrs);
    }

    public DottedSeekBar(final Context context, final AttributeSet attrs, final int defStyle) {
        super(context, attrs, defStyle);
        init(attrs);
    }

    /**
     * Initializes Seek bar extended attributes from xml
     *
     * @param attributeSet {@link AttributeSet}
     */
    private void init(final AttributeSet attributeSet) {
        final TypedArray attrsArray = getContext().obtainStyledAttributes(attributeSet, R.styleable.DottedSeekBar, 0, 0);

        final int dotsArrayResource = attrsArray.getResourceId(R.styleable.DottedSeekBar_dots_positions, 0);

        if (0 != dotsArrayResource) {
            mDotsPositions = getResources().getIntArray(dotsArrayResource);
        }

        final int dotDrawableId = attrsArray.getResourceId(R.styleable.DottedSeekBar_dots_drawable, 0);

        if (0 != dotDrawableId) {
            mDotBitmap = BitmapFactory.decodeResource(getResources(), dotDrawableId);
        }
    }

    /**
     * @param dots to be displayed on this SeekBar
     */
    public void setDots(final int[] dots) {
        mDotsPositions = dots;
        invalidate();
    }

    /**
     * @param dotsResource resource id to be used for dots drawing
     */
    public void setDotsDrawable(final int dotsResource) {
        mDotBitmap = BitmapFactory.decodeResource(getResources(), dotsResource);
        invalidate();
    }

    @Override
    protected synchronized void onDraw(final Canvas canvas) {
        super.onDraw(canvas);

        final int width = getMeasuredWidth();
        final int step = width / getMax();

        if (null != mDotsPositions && 0 != mDotsPositions.length && null != mDotBitmap) {
            // draw dots if we have ones
            for (int position : mDotsPositions) {
                canvas.drawBitmap(mDotBitmap, position * step, 0, null);
            }
        }
    }
}
