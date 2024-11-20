package com.example.independentwork_v23;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import java.util.ArrayList;
import java.util.Objects;

public class Record extends AppCompatActivity {

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_record);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        PagesMenu pagesMenu = new PagesMenu();
        setNewFragment(pagesMenu);

        String passedArg = Objects.requireNonNull(getIntent().getExtras()).getString("arg");
        assert passedArg != null;
        String[] books = passedArg.split(",\n");

        int len = books.length;

        TextView labelTextView = findViewById(R.id.labelText);
        labelTextView.setText("   Вы выбрали " + Integer.toString(len) + " книги. " +
                "\n   Стандартная стоимость аренды 30руб./день. " +
                "\n   Стандартный период аренды 3 недели." +
                "\n   Стоимость аренды выбранных книг на стандартный период составит " + Integer.toString(len * 10 * 21) + " рублей");
    }

    private void setNewFragment(Fragment fragment) {
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.recordContainerView, fragment);
        ft.commit();
    }
}