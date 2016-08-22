package minhaLang;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Base64;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.payfood.payfood.R;

/**
 * Created by cassiano on 21/08/16.
 */
public class Util {
    public static Bitmap getBitmapFrom64Str(String base64Str) {
        byte[] bytes = Base64.decode(base64Str, Base64.DEFAULT);
        return BitmapFactory.decodeByteArray(bytes, 0, bytes.length);
    }

    public static void glidImage(ImageView imgLogo, String url, Context myFragment) {
        Glide
        .with(myFragment)
        .load(url)
        .fitCenter()
        .placeholder(R.drawable.ic_store_black_24dp)
        .crossFade()
        .into(imgLogo);
    }
}
