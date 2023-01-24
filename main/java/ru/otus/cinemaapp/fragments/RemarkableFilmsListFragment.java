package ru.otus.cinemaapp.fragments;


import android.os.Bundle;

import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Spinner;


import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.widget.SwitchCompat;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;


import butterknife.ButterKnife;
import ru.otus.cinemaapp.R;

public class RemarkableFilmsListFragment extends Fragment implements View.OnClickListener, Switch.OnCheckedChangeListener {

    public static final String TAG = "RemarkableFilmsListFragment";

    // списочек фильмов. Пока что только так
    String[] films1 = { "\"Мертвец идет\" (1995 г.). Режиссер: Тим Роббинс. В ролях: Шон Пенн, Сьюзен Сарандон", "\"Голгофа\"(комедия-драма) 2014 года кинорежиссёра и сценариста Джона Майкла Макдонаха.", "\"Мандарины\"(2013г). Грузино-эстонский.", "Протопресвитер Александр Шмеман", "протоиерей Александр Мень"};



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_remarkable_films_list, container, false);
        // наш спиннер с фильмецами
        Spinner spinner = (Spinner) view.findViewById(R.id.spinner);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this.getActivity(), android.R.layout.simple_spinner_item, films1);
        adapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        spinner.setAdapter(adapter);

        //  и обработаем теперь кнопочку
        Button b = (Button) view.findViewById(R.id.button4);
        b.setOnClickListener(this);

        // обработаем теперь свитч
        Switch switch1 = view.findViewById(R.id.switch1);
        if (switch1 != null) {
            switch1.setOnCheckedChangeListener(this);
        }

        ButterKnife.bind(this, view);

        return view;
    }

    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        // для отображения режима 3d
        Toast.makeText(getActivity(), "Режим 3D: " + (isChecked ? "+" : "-"),
                Toast.LENGTH_SHORT).show();
        TextView tv = (TextView) getView().findViewById(R.id.textView7);  // текст с текстом пожертвования
        // изменим еще текст там
        if(isChecked)
        {
            tv.setText("Пожертвование:\n 100 рублей\n+50 рублей за 3D");
        }
        else {
            tv.setText("Пожертвование:\n 100 рублей");
        }
       }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button4:
                Toast toast = Toast.makeText(getActivity().getApplicationContext(),
                        "Билет на выбранный фильм успешно забронирован! Подробности придут к Вам на почту! Спасибо, что вы с Лептой!", Toast.LENGTH_SHORT);
                toast.show();
                break;
        }
    }
}


