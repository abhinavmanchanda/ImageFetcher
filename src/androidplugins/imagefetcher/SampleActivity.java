package androidplugins.imagefetcher;

import android.app.Activity;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import androidplugins.Callback;

public class SampleActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        findViewById(R.id.progress).setVisibility(View.VISIBLE);
        findViewById(R.id.image).setVisibility(View.GONE);
        new ImageFetcher(bitmapCallback(), this).execute("http://xplorationstudio.com/sample_images/watch_2.jpeg");
    }

    private Callback<Bitmap> bitmapCallback() {
        return new Callback<Bitmap>() {
            @Override
            public void execute(Bitmap object) {
                findViewById(R.id.progress).setVisibility(View.GONE);
                ImageView imageView = (ImageView) findViewById(R.id.image);
                imageView.setVisibility(View.VISIBLE);
                imageView.setImageBitmap(object);
            }
        };
    }
}
