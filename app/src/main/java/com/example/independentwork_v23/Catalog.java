package com.example.independentwork_v23;

import android.content.Intent;
import android.os.Bundle;
import android.util.SparseBooleanArray;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import java.util.ArrayList;
import java.util.Collections;

public class Catalog extends AppCompatActivity {

    Button btn_arrange;

    public ListView listView;
    String[] books = {
            "\"Анна Каренина\" (Лев Толстой)",
            "\"Мадам Бовари\" (Гюстав Флобер)",
            "\"Лолита\" (Владимир Набоков)",
            "\"Война и мир\" (Лев Толстой)",
            "\"Приключения Гекльберри Финна\" (Марк Твен)",
            "\"Гамлет\" (Уилбям Шекспир)",
            "\"Великий Гетсби\" (Ф.Скотт Фицджеральд)",
            "\"В поисках утраченного времени\" (Марсель Пруст)",
            "\"Мидлмарч\" (Джордж Элиот)",
            "\"Гарри Поттер и философский камень\" (Джоан Роулинг)",
            "\"1984\" (Джордж Оруэл)",
            "\"Тревожные люди\" (Ф. Бакман)",
            "\"Рассказы Антона Чехова\"",
            "\"Тревожные люди\" (Ф. Бакман)",
            "\"Атлант расправил плечи\" (Айн Рэнд)"
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_catalog);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        PagesMenu pagesMenu = new PagesMenu();
        setNewFragment(pagesMenu);

        listView = findViewById(R.id.booksList);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_multiple_choice, books);
        listView.setAdapter(adapter);
    }

    private void setNewFragment(Fragment fragment) {
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.fragmentContainerView, fragment);
        ft.commit();
    }

    public void addArrange(View view) {
        SparseBooleanArray selected = listView.getCheckedItemPositions();
        StringBuilder selectedItems = new StringBuilder();
        for (int i = 0; i < books.length; i++) {
            if (selected.get(i)) {
                selectedItems.append(books[i]).append(",\n");
            }

        }

        Intent intent = new Intent(this, Record.class);
        intent.putExtra("arg", selectedItems.toString());
        startActivity(intent);
    }
}