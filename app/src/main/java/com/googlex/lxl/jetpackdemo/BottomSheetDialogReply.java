package com.googlex.lxl.jetpackdemo;

import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.googlex.lxl.jetpackdemo.fragment.BlankFragment;

public class BottomSheetDialogReply {

    private BottomSheetDialog bottomSheetDialog;
    private final LinearLayout layout;


    public BottomSheetDialogReply(Context context) {

        View view = LayoutInflater.from(context).inflate(R.layout.window_reply_new, null);
        bottomSheetDialog = new BottomSheetDialog(context, R.style.BottomSheetEdit);
        bottomSheetDialog.setContentView(view);

        layout = view.findViewById(R.id.fl_content);

        layout.addView(LayoutInflater.from(context).inflate(R.layout.fragment_blank, null));

        view.findViewById(R.id.send)
                .setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (layout.getVisibility() == View.VISIBLE) {
                            layout.setVisibility(View.GONE);
                        } else {
                            layout.setVisibility(View.VISIBLE);
                        }
                    }
                });

    }


    public void show() {
        bottomSheetDialog.show();
    }


}
