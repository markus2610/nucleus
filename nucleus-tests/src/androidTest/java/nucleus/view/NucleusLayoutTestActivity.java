package nucleus.view;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;

import nucleus.presenter.Presenter;

public class NucleusLayoutTestActivity extends Activity {

    public TestView view;
    public boolean detached;

    @RequiresPresenter(Presenter.class)
    public static class TestView extends NucleusLayout {
        public TestView(Context context) {
            super(context);
            //noinspection ResourceType
            setId(1024);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(view = new TestView(this));
    }

    @Override
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        detached = true;
    }
}
