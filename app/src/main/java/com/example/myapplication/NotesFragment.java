package com.example.myapplication;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class NotesFragment extends Fragment {
    // При создании фрагмента укажем его макет
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_notes, container, false);
    }
    // Этот метод вызывается, когда макет экрана создан и готов к отображению информации. Создаем список городов
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle
            savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Notes[] arrayNotes = new Notes[5];

        String[] cities = getResources().getStringArray(R.array.cities);
        for (int i = 0; i<5; i++){
            arrayNotes[i] = new Notes(cities[i],cities[i] + " город","12.12.1996");
        }
        initList(view,arrayNotes);
    }
    // создаём список городов на экране из массива в ресурсах
    private void initList(View view,Notes [] notes) {
        LinearLayout layoutView = (LinearLayout) view;


// В этом цикле создаём элемент TextView,
// заполняем его значениями,
// и добавляем на экран.
        for (Notes city : notes) {
            TextView tv = new TextView(getContext());
            tv.setText(city.getName());
            tv.setTextSize(30);
            layoutView.addView(tv);
            tv.setOnClickListener(v -> {
                showCoatOfArms(city);
            });
        }
    }
    private void showCoatOfArms(Notes note) {
        DirectionFragment coatOfArmsFragment =
                DirectionFragment.newInstance(note);
        FragmentManager fragmentManager =
                requireActivity().getSupportFragmentManager();
        FragmentTransaction fragmentTransaction =
                fragmentManager.beginTransaction();
// добавляем фрагмент через add
        fragmentTransaction.add(R.id.fragment_container, coatOfArmsFragment);
        fragmentTransaction.commit();
    }

}
