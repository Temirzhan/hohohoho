package com.example.myapplication;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.fragment.app.Fragment;
public class DirectionFragment extends Fragment {
    static final String ARG_INDEX = "index";
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_direction, container,
                false);
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle
            savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Bundle arguments = getArguments();
// Аргументы могут быть null (как в случае с методом Activity
// поэтому обязательно проверяем на null
        if (arguments != null) {
            Notes note  =  arguments.getParcelable(ARG_INDEX);
// найдем в root view нужный ImageView
            initList(view,note);
        }

    }
    // Фабричный метод создания фрагмента
// Фрагменты рекомендуется создавать через фабричные метnоды
    public static DirectionFragment newInstance(Notes note) {
// Создание фрагмента
        DirectionFragment fragment = new DirectionFragment();
// Передача параметра через бандл
        Bundle args = new Bundle();
        args.putParcelable(ARG_INDEX, note);
        fragment.setArguments(args);
        return fragment;
    }

    private void initList(View view,Notes note) {
        LinearLayout layoutView = (LinearLayout) view;


            TextView tv = new TextView(getContext());
            TextView tv2= new TextView(getContext());
          TextView tv3= new TextView(getContext());
            tv.setText(note.getName());
            tv2.setText(note.getDate());
            tv3.setText(note.getDescription());
            tv.setTextSize(30);
            tv2.setTextSize(30);
            tv3.setTextSize(30);

            layoutView.addView(tv);
        layoutView.addView(tv2);
        layoutView.addView(tv3);
    }
}

