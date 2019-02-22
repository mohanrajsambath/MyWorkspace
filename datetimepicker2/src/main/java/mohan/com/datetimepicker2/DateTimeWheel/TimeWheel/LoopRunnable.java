package mohan.com.datetimepicker2.DateTimeWheel.TimeWheel;

/**
 * Created by prati on 06-Jul-16 at VARAHI TECHNOLOGIES.
 * http://www.varahitechnologies.com
 */
final class LoopRunnable implements Runnable {

    final LoopView loopView;

    LoopRunnable(LoopView loopview) {
        super();
        loopView = loopview;

    }

    @Override
    public final void run() {
        LoopListener listener = loopView.loopListener;
        int selectedItem = LoopView.getSelectedItem(loopView);
        loopView.arrayList.get(selectedItem);
        listener.onItemSelect(selectedItem);
    }
}
