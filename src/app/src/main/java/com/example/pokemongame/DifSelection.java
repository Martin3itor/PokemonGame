package com.example.pokemongame;

/////////LIBRARIES/////////////////////////////////
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import org.PSIGroupE.PokemonGame.*;
public class DifSelection extends AppCompatActivity {
    ////////////////////////////////////////////////////////////////////////////////////////
    /////////VARIABLES/////////////////////////////////
    TextView text;
    Button easy,hard;
    PokemonGame pokemonGame;
    String [] pokemon;
    @Override
    ////////////////////////////////////////////////////////////////////////////////////////
    /////////ON CREATE(CALLED BY SELECTION)/////////////////////////////////
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_difselection);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.difselection), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        ////////////////////////////////////////////////////////////////////////////////////////
        /////////SETUP ANDROID VARIABLES AND GET DATA FROM SELECTION/////////////////////////////////
        text = findViewById(R.id.text);
        text.setText("Choose the Difficulty");
        easy = findViewById(R.id.easy);
        hard = findViewById(R.id.hard);
        pokemonGame = (PokemonGame) getIntent().getParcelableExtra("pokemon_game");
        pokemon = getIntent().getStringArrayExtra("selected_pokemon");
        ////////////////////////////////////////////////////////////////////////////////////////
        /////////DIFFICULTY SELECTIONS/////////////////////////////////
        easy.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                /////////IF EASY WE PUT THE DATA INTO THE INTENT AND LAUNCH EASYGAME////////////
                Intent intent = new Intent(DifSelection.this,EasyGame.class);
                intent.putExtra("pokemon_game", pokemonGame);
                intent.putExtra( "selected_pokemon", pokemon);
                setResult(RESULT_OK, intent);
                ////////////////////////////////////////////////////////////////////////////////////////
                /////////LAUNCH INTENT AND CLOSE THIS ONE/////////////////////////////////
                startActivity(intent);
                finish();
            }
        });

        hard.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                /////////IF HARD WE PUT THE DATA INTO THE INTENT AND LAUNCH EASYGAME////////////
                Intent intent = new Intent(DifSelection.this,HardGame.class);
                intent.putExtra("pokemon_game", pokemonGame);
                intent.putExtra( "selected_pokemon", pokemon);
                setResult(RESULT_OK, intent);
                ////////////////////////////////////////////////////////////////////////////////////////
                /////////LAUNCH INTENT AND CLOSE THIS ONE/////////////////////////////////
                startActivity(intent);
                finish();
            }
        });

    }

}
