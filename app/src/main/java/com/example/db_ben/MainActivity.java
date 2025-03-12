package com.example.db_ben;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {


    TextView textView;
    Button button;
    Random rn;
    List<Note> noteList;
    NoteDAO noteDAO;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });







        NoteDatabase database = NoteDatabase.getInstance(this);
        noteDAO = database.noteDao();
        rn = new Random();

        textView = findViewById(R.id.textView);
        button = findViewById(R.id.button);


        Note sampleNote1 = new Note("hello",3,"30%");
        noteDAO.insert(sampleNote1);
        Note sampleNote2 = new Note("hi",4,"40%");
        noteDAO.insert(sampleNote2);
        Note sampleNote3 = new Note("yo",5,"60%");
        noteDAO.insert(sampleNote3);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                noteList = noteDAO.getAllNotes();
                int randomIndex = rn.nextInt(noteList.size());
                Note randomNote = noteList.get(randomIndex);
                textView.setText("ID: " + randomNote.getId() +
                        "\nWords: " + randomNote.getWords() +
                        "\nNumber: " + randomNote.getNumber() +
                        "\nPercentage: " + randomNote.getA_hoze());
            }
        });


    }



}