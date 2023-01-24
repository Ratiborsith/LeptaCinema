package ru.otus.cinemaapp.fragments;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import ru.otus.cinemaapp.R;
import ru.otus.cinemaapp.presenters.FilmListFragmentPresenter;
import ru.otus.cinemaapp.repo.FilmRepository;
import android.widget.AdapterView;


public class FilmListFragment extends Fragment {

    public static final String CHECKED_POSITION = "checkedPosition";
    public static final String TAG = "FilmListFragment";
    String[] films1 = { "\"Мертвец идет\" (1995 г.)", "\"Голгофа\"(комедия-драма) 2014 года кинорежиссёра и сценариста Джона Майкла Макдонаха.", "\"Мандарины\"(2013г). Грузино-эстонский.", "Протопресвитер Александр Шмеман", "протоиерей Александр Мень"};


    private FilmListFragmentPresenter presenter = new FilmListFragmentPresenter(FilmRepository.getInstance());

    private int checkedPosition = -1;
    private OnInviteFriendClickListener inviteFriendClickListener;


    public FilmListFragment() {}

    public static FilmListFragment newInstance(int position) {
        FilmListFragment fragment = new FilmListFragment();
        Bundle args = new Bundle();
        args.putInt(CHECKED_POSITION, position);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_film_list, container, false);



        // наш спиннер с фильмецами
        Spinner spinner = (Spinner) view.findViewById(R.id.spinner2);
        //spinner.setPrompt("\"Мертвец идет\" (1995 г.). Режиссер: Тим Роббинс. В ролях: Шон Пенн, Сьюзен Сарандон");
        // установим скачанное значение
        TextView tv = (TextView) view.findViewById(R.id.textView4);  // текст
        ImageView iv= (ImageView)view.findViewById(R.id.imageView2); // изображение

        //tv.setText("Заключенный, приговоренный к смерти за жестокое убийство, избирает своей духовной наставницей монахиню. Сначала она пытается помочь ему избежать высшей меры наказания, но, не добившись этого, старается облегчить последние часы его жизни, пробудить в нем человечность и убедить покаяться.");


        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this.getActivity(), android.R.layout.simple_spinner_item, films1);
        adapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        spinner.setAdapter(adapter);

        AdapterView.OnItemSelectedListener itemSelectedListener = new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                // Получаем выбранный объект
                String item = (String)parent.getItemAtPosition(position);

                // теперь, все отловив, установим смену описания и картинки
                if(item == "\"Мертвец идет\" (1995 г.)")
                {
                    iv.setImageResource(R.drawable.deadman);
                    tv.setText("Заключенный, приговоренный к смерти за жестокое убийство, избирает своей духовной наставницей монахиню. Сначала она пытается помочь ему избежать высшей меры наказания, но, не добившись этого, старается облегчить последние часы его жизни, пробудить в нем человечность и убедить покаяться.");}
                else if (item == "\"Голгофа\"(комедия-драма) 2014 года кинорежиссёра и сценариста Джона Майкла Макдонаха.") {
                    iv.setImageResource(R.drawable.golgofa);
                    tv.setText("Отец Джеймс — католический священник в небольшом провинциальном городке — слушает покаяние, на котором прихожанин сообщает ему, что в течение многих лет подвергался сексуальному насилию со стороны ныне покойного священнослужителя. Прихожанин делится с Джеймсом своими размышлениями о том, что на гибель плохого священника никто и не обратит внимания, тогда как убийство хорошего может заставить общество задуматься. С этими словами он даёт святому отцу неделю на то, чтобы привести в порядок дела, после чего Джеймс будет убит. Однако вместо того, чтобы начинать готовиться к смерти или обратиться в полицию, в отпущенный срок священник занимается обычными повседневными делами, стараясь изменить жизнь прихожан к лучшему.");
                }
                else if (item == "\"Мандарины\"(2013г). Грузино-эстонский.") {
                    iv.setImageResource(R.drawable.mandarini);
                    tv.setText("1992 год, Абхазия. Древнее эстонское село, расположенное в живописном месте между горами и морем, опустело - эстонцы вернулись на свою историческую родину. Остались только хозяин товарного цеха Иво, его сосед, владелец мандариновой плантации Маргус и местный доктор Юхан, который уже готов покинуть селение. Маргус также собирается уехать в Эстонию, но лишь после того, как будет собран урожай мандаринов. Война доходит до села, происходит боевое столкновение между грузинами и абхазцами. После боя Иво и Маргус находят одного оставшегося в живых чеченского наёмника по имени Ахмед, который воюет на абхазской стороне. Иво забирает Ахмеда к себе домой, чтобы его вылечить... ");
                }
                else if (item == "Протопресвитер Александр Шмеман") {
                    iv.setImageResource(R.drawable.shmeman);
                    tv.setText("Фильм посвящен деяниям и памяти выдающегося миссионера и богослова православной церкви в Америке, протопресвитера Александра Шмемана.");
                }
                else if (item == "протоиерей Александр Мень") {
                    iv.setImageResource(R.drawable.men);
                    tv.setText("Первый священник, который произнес проповедь в телеэфире. Человек, который находил общий язык и с простыми прихожанами, и со столичными знаменитостями. Александр Мень. Он не был похож на других священников. Его не все принимали в церкви и преследовали спецслужбы. Его убийство так и не раскрыли.\n" +
                            "\n" +
                            "Каким на самом деле был Александр Мень? Почему именно ему так верили люди? И какую правду он поведал миру?\n" +
                            "\n");
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        };
        spinner.setOnItemSelectedListener(itemSelectedListener);



        ButterKnife.bind(this, view);
        return view;
    }
    private void inviteFriend() {
        inviteFriendClickListener.onInviteFriendClicked();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setRetainInstance(true);
        if (getArguments() != null) {
            checkedPosition = getArguments().getInt(CHECKED_POSITION);
        }
    }

        @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);



            FloatingActionButton actionButton = view.findViewById(R.id.contactFriendFab);
            actionButton.setOnClickListener(v -> inviteFriend());

            if (savedInstanceState != null) {
                checkedPosition = savedInstanceState.getInt(CHECKED_POSITION);
            }
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        outState.putInt(CHECKED_POSITION, checkedPosition);
        super.onSaveInstanceState(outState);
    }


    public void setInviteFriendClickListener(OnInviteFriendClickListener inviteFriendClickListener) {
        this.inviteFriendClickListener = inviteFriendClickListener;
    }


    public interface OnInviteFriendClickListener {
        void onInviteFriendClicked();
    }

}
