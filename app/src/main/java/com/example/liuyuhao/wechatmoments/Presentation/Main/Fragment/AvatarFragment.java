package com.example.liuyuhao.wechatmoments.Presentation.Main.Fragment;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.liuyuhao.wechatmoments.R;

public class AvatarFragment extends Fragment {
    private ImageView background;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_avatar, container, false);
        background = (ImageView) v.findViewById(R.id.img_image);
        background.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(), "toast", Toast.LENGTH_SHORT).show();
            }
        });
        return v;
    }
}
