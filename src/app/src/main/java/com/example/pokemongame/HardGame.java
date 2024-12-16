package com.example.pokemongame;
////////////////////////////////////////SAME STRUCTURE THAN EASYGAME.JAVA///////////////////////////////
//////////////////////////////////////////CHECK THERE///////////////////////////////////////////////////

import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.RelativeSizeSpan;
import android.text.style.StyleSpan;
import android.util.Log;
import android.widget.Button;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import com.bumptech.glide.Glide;
import com.google.android.material.snackbar.Snackbar;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.PSIGroupE.PokemonGame.*;


public class HardGame extends AppCompatActivity {
    private MediaPlayer mediaPlayer, mediaplayer2;
    private Button attack1;
    private Button attack2;
    private Button attack3;
    private Button attack4;
    private Button switch1;
    private Button switch2;
    private Button switch3;
    private Button switch4, music;
    private PokemonGame pokemonGame;
    private ImageView gifImageView;
    private ImageView ImageView;
    private ProgressBar progressBar;
    private ProgressBar progressBar2;
    private TextView textView;
    private TextView textView2;
    private TextView textView3, textTurn;
    private String [] pokemon = new String[4];
    private int battleturn=0;
    private ArrayList<Button> switchs = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hard);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.hard), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        String audioUrl = "https://play.pokemonshowdown.com/audio/dpp-rival.mp3";
        mediaPlayer = new MediaPlayer();
        mediaplayer2 = new MediaPlayer();
        try {
            mediaPlayer.setDataSource(audioUrl);  // Establece la URL del archivo de audio
            mediaPlayer.setLooping(true);  // Reproducir en bucle
            mediaPlayer.prepare();  // Prepara el MediaPlayer
            mediaPlayer.start();  // Inicia la reproducción automáticamente
        } catch (IOException e) {
            Log.e("MediaPlayer", "Error al cargar la URL de audio: " + e.getMessage());
        }
        pokemonGame = (PokemonGame) getIntent().getParcelableExtra("pokemon_game");
        pokemon = getIntent().getStringArrayExtra("selected_pokemon");
        pokemonGame.startGame(pokemon);
        progressBar = findViewById(R.id.progressBar);
        progressBar.getProgressDrawable().setColorFilter(Color.GREEN, PorterDuff.Mode.SRC_IN);
        progressBar2 = findViewById(R.id.progressBar2);
        progressBar2.getProgressDrawable().setColorFilter(Color.GREEN, PorterDuff.Mode.SRC_IN);

        gifImageView = findViewById(R.id.gifImageView);
        ImageView = findViewById(R.id.imageView);
        textView = findViewById(R.id.text1);
        textView2 = findViewById(R.id.text2);
        textView3 = findViewById(R.id.text3);
        textTurn = findViewById(R.id.textTurn);
        music = findViewById(R.id.music);
        attack1 = findViewById(R.id.attack1);
        attack2 = findViewById(R.id.attack2);
        attack3 = findViewById(R.id.attack3);
        attack4 = findViewById(R.id.attack4);
        updateButtons();

        switch1 = findViewById(R.id.switch1);
        switch2 = findViewById(R.id.switch2);
        switch3 = findViewById(R.id.switch3);
        switch4 = findViewById(R.id.switch4);
        switchs.add(switch1);
        switchs.add(switch2);
        switchs.add(switch3);
        switchs.add(switch4);
        switch1.setText(pokemonGame.getPlayer1().getTeam()[0].getName());
        switch2.setText(pokemonGame.getPlayer1().getTeam()[1].getName());
        switch3.setText(pokemonGame.getPlayer1().getTeam()[2].getName());
        switch4.setText(pokemonGame.getPlayer1().getTeam()[3].getName());

        music.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mediaPlayer != null && mediaPlayer.isPlaying()){
                    mediaPlayer.pause();
                }
                else if(mediaPlayer != null && !mediaPlayer.isPlaying()){
                    mediaPlayer.start();
                }
            }
        });
        attack1.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                Toast.makeText(HardGame.this, "Attack: " + pokemonGame.getPlayer1().getActivePokemon().getAttacks()[0].getName() + "\nPower: " + pokemonGame.getPlayer1().getActivePokemon().getAttacks()[0].getPower() + "\nType: " + pokemonGame.getPlayer1().getActivePokemon().getAttacks()[0].getType(), Toast.LENGTH_LONG).show();
                return true; // Consume el evento y evita que se ejecute el OnClick.
            }
        });
        attack2.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                Toast.makeText(HardGame.this, "Attack: " + pokemonGame.getPlayer1().getActivePokemon().getAttacks()[1].getName() + "\nPower: " + pokemonGame.getPlayer1().getActivePokemon().getAttacks()[1].getPower() + "\nType: " + pokemonGame.getPlayer1().getActivePokemon().getAttacks()[1].getType(), Toast.LENGTH_LONG).show();
                return true; // Consume el evento y evita que se ejecute el OnClick.
            }
        });
        attack3.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                Snackbar.make(findViewById(R.id.attack1), "Attack: " + pokemonGame.getPlayer1().getActivePokemon().getAttacks()[2].getName() + "\nPower: " + pokemonGame.getPlayer1().getActivePokemon().getAttacks()[2].getPower() + "\nType: " + pokemonGame.getPlayer1().getActivePokemon().getAttacks()[2].getType(), Snackbar.LENGTH_LONG).show();
                return true; // Consume el evento y evita que se ejecute el OnClick.
            }
        });
        attack4.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                Toast.makeText(HardGame.this, "Attack: " + pokemonGame.getPlayer1().getActivePokemon().getAttacks()[3].getName() + "\nPower: " + pokemonGame.getPlayer1().getActivePokemon().getAttacks()[3].getPower() + "\nType: " + pokemonGame.getPlayer1().getActivePokemon().getAttacks()[3].getType(), Toast.LENGTH_LONG).show();
                return true; // Consume el evento y evita que se ejecute el OnClick.
            }
        });


        attack1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Llama a la función externa para cambiar el texto
                pokemonGame.playAction(1);
                updateButtons();
            }
        });
        attack2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Llama a la función externa para cambiar el text
                pokemonGame.playAction(2);
                updateButtons();
            }
        });
        attack3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pokemonGame.playAction(3);
                updateButtons();
            }
            // Llama a la función externa para cambiar el texto
        });
        attack4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Llama a la función externa para cambiar el texto
                pokemonGame.playAction(4);
                updateButtons();
            }
        });


        switch1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!pokemonGame.getPlayer1().getTeam()[0].isConscious()){
                    String text = "You can't swap to and unconscious Pokémon!!";
                    textView3.setText(text);
                }
                else{
                    pokemonGame.playAction(50);
                    updateButtons();
                }
            }
        });
        switch2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Llama a la función externa para cambiar el text
                if(!pokemonGame.getPlayer1().getTeam()[1].isConscious()){
                    String text = "You can't swap to and unconscious Pokémon!!";
                    textView3.setText(text);
                }
                else{
                    pokemonGame.playAction(51);
                    updateButtons();
                }
            }
        });
        switch3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!pokemonGame.getPlayer1().getTeam()[2].isConscious()){
                    String text = "You can't swap to and unconscious Pokémon!!";
                    textView3.setText(text);                }
                else{
                    pokemonGame.playAction(52);
                    updateButtons();
                }
            }
            // Llama a la función externa para cambiar el texto
        });
        switch4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!pokemonGame.getPlayer1().getTeam()[3].isConscious()){
                    String text = "You can't swap to and unconscious Pokémon!!";
                    textView3.setText(text);
                }
                else{
                    pokemonGame.playAction(53);
                    updateButtons();
                }
            }
        });
    }

    public void updateButtons() {
            progressBar.setMax(pokemonGame.getPlayer1().getActivePokemon().getMaxHP());
            progressBar.setProgress(pokemonGame.getPlayer1().getActivePokemon().getHp());
            if(((double) pokemonGame.getPlayer1().getActivePokemon().getHp() /pokemonGame.getPlayer1().getActivePokemon().getMaxHP())<0.25){
                progressBar.getProgressDrawable().setColorFilter(Color.RED, PorterDuff.Mode.SRC_IN);
            }
            else if(((double) pokemonGame.getPlayer1().getActivePokemon().getHp() /pokemonGame.getPlayer1().getActivePokemon().getMaxHP())<0.5){
                progressBar.getProgressDrawable().setColorFilter(Color.YELLOW, PorterDuff.Mode.SRC_IN);
            }
            else{
                progressBar.getProgressDrawable().setColorFilter(Color.GREEN, PorterDuff.Mode.SRC_IN);
            }


        progressBar2.setMax(pokemonGame.getPlayer2().getActivePokemon().getMaxHP());

        progressBar2.setProgress(pokemonGame.getPlayer2().getActivePokemon().getHp());
        if(((double) pokemonGame.getPlayer2().getActivePokemon().getHp() /pokemonGame.getPlayer2().getActivePokemon().getMaxHP())<0.25){
            progressBar2.getProgressDrawable().setColorFilter(Color.RED, PorterDuff.Mode.SRC_IN);
        }
        else if(((double) pokemonGame.getPlayer2().getActivePokemon().getHp() /pokemonGame.getPlayer2().getActivePokemon().getMaxHP())<0.5){
            progressBar2.getProgressDrawable().setColorFilter(Color.YELLOW, PorterDuff.Mode.SRC_IN);
        }
        else {
            progressBar2.getProgressDrawable().setColorFilter(Color.GREEN, PorterDuff.Mode.SRC_IN);
        }


        String text;
        if (pokemonGame.getPlayer1().getConsciousPokemon().isEmpty()) {
            textView.setText(pokemonGame.getPlayer1().getActivePokemon().getName() + " - " + pokemonGame.getPlayer1().getActivePokemon().getHp()+" / "+pokemonGame.getPlayer1().getActivePokemon().getMaxHP());
            textView2.setText(pokemonGame.getPlayer2().getActivePokemon().getName() + " - " + pokemonGame.getPlayer2().getActivePokemon().getHp()+" / "+pokemonGame.getPlayer2().getActivePokemon().getMaxHP());
            text = "Player 2 WINS\nYou LOST";
            textView3.setText(text);
            return;
        } else if (pokemonGame.getPlayer2().getConsciousPokemon().isEmpty()) {
            textView.setText(pokemonGame.getPlayer1().getActivePokemon().getName() + " - " + pokemonGame.getPlayer1().getActivePokemon().getHp()+" / "+pokemonGame.getPlayer1().getActivePokemon().getMaxHP());
            textView2.setText(pokemonGame.getPlayer2().getActivePokemon().getName() + " - " + pokemonGame.getPlayer2().getActivePokemon().getHp()+" / "+pokemonGame.getPlayer2().getActivePokemon().getMaxHP());
            text = "Player 1 WINS\nYou WON";
            textView3.setText(text);
            return;
        }
        for(int i=0;i<pokemonGame.getPlayer1().getTeam().length;i++){
            if(!pokemonGame.getPlayer1().getTeam()[i].isConscious()){
                switchs.get(i).setBackgroundColor(Color.parseColor("#80FF0000"));
            }
        }
        if(!pokemonGame.getPlayer1().getActivePokemon().isConscious()){
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("Your Pokémon fainted. Choose another one to switch in:");
            String [] activepokemon = new String[pokemonGame.getPlayer1().getConsciousPokemon().size()];
            int y=0;
            for(int i=0;i<pokemonGame.getPlayer1().getTeam().length;i++){
                if(pokemonGame.getPlayer1().getConsciousPokemon().contains(String.valueOf(i))) {
                    activepokemon[y] = pokemonGame.getPlayer1().getTeam()[i].getName();
                    y++;
                }
            }
            builder.setItems(activepokemon, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    String selectedPokemonName = pokemonGame.getPlayer1().getConsciousPokemon().get(which);
                            pokemonGame.getPlayer1().setActivePokemon(Integer.parseInt(selectedPokemonName));
                            Toast.makeText(HardGame.this, "You selected " + pokemonGame.getPlayer1().getTeam()[Integer.parseInt(selectedPokemonName)].getName(), Toast.LENGTH_SHORT).show();
                    for (int i = 0; i < pokemonGame.getPlayer1().getTeam().length; i++) {
                        if (pokemonGame.getPlayer1().getActivePokemon().getName().equals(pokemonGame.getPlayer1().getTeam()[i].getName())) {
                            progressBar.setMax(pokemonGame.getPlayer1().getActivePokemon().getMaxHP());
                        }
                        if (pokemonGame.getPlayer2().getActivePokemon().getName().equals(pokemonGame.getPlayer2().getTeam()[i].getName())) {
                            progressBar2.setMax(pokemonGame.getPlayer2().getActivePokemon().getMaxHP());
                        }
                    }
                    showString();
                    textView.setText(pokemonGame.getPlayer1().getActivePokemon().getName() + " - " + pokemonGame.getPlayer1().getActivePokemon().getHp()+" / "+pokemonGame.getPlayer1().getActivePokemon().getMaxHP());
                    textView2.setText(pokemonGame.getPlayer2().getActivePokemon().getName() + " - " + pokemonGame.getPlayer2().getActivePokemon().getHp()+" / "+pokemonGame.getPlayer2().getActivePokemon().getMaxHP());
                    attack1.setText(pokemonGame.getPlayer1().getActivePokemon().getAttacks()[0].getName());
                    attack1.setBackgroundColor(Color.parseColor(pokemonGame.getPlayer1().getActivePokemon().getAttacks()[0].getType().getColor()));
                    attack2.setText(pokemonGame.getPlayer1().getActivePokemon().getAttacks()[1].getName());
                    attack2.setBackgroundColor(Color.parseColor(pokemonGame.getPlayer1().getActivePokemon().getAttacks()[1].getType().getColor()));
                    attack3.setText(pokemonGame.getPlayer1().getActivePokemon().getAttacks()[2].getName());
                    attack3.setBackgroundColor(Color.parseColor(pokemonGame.getPlayer1().getActivePokemon().getAttacks()[2].getType().getColor()));
                    attack4.setText(pokemonGame.getPlayer1().getActivePokemon().getAttacks()[3].getName());
                    attack4.setBackgroundColor(Color.parseColor(pokemonGame.getPlayer1().getActivePokemon().getAttacks()[3].getType().getColor()));
                    String newImagePath = "https://play.pokemonshowdown.com/sprites/ani-back/" + pokemonGame.getPlayer1().getActivePokemon().getName().toLowerCase() + ".gif";
                    Glide.with(HardGame.this)
                            .load(newImagePath)
                            .into(gifImageView);
                    String newImagePath2 = "https://play.pokemonshowdown.com/sprites/ani/" + pokemonGame.getPlayer2().getActivePokemon().getName().toLowerCase() + ".gif";
                    Glide.with(HardGame.this)
                            .load(newImagePath2)
                            .into(ImageView);
                    return;
                }
            });
            builder.setCancelable(false); // Evitar que el jugador cierre el diálogo sin seleccionar un Pokémon
            builder.show();
        }
        else {
            for (int i = 0; i < pokemonGame.getPlayer1().getTeam().length; i++) {
                if (pokemonGame.getPlayer1().getActivePokemon().getName().equals(pokemonGame.getPlayer1().getTeam()[i].getName())) {
                    progressBar.setMax(pokemonGame.getPlayer1().getActivePokemon().getMaxHP());
                }
                if (pokemonGame.getPlayer2().getActivePokemon().getName().equals(pokemonGame.getPlayer2().getTeam()[i].getName())) {
                    progressBar2.setMax(pokemonGame.getPlayer2().getActivePokemon().getMaxHP());
                }
            }
            showString();
            textView.setText(pokemonGame.getPlayer1().getActivePokemon().getName() + " - " + pokemonGame.getPlayer1().getActivePokemon().getHp()+" / "+pokemonGame.getPlayer1().getActivePokemon().getMaxHP());
            textView2.setText(pokemonGame.getPlayer2().getActivePokemon().getName() + " - " + pokemonGame.getPlayer2().getActivePokemon().getHp()+" / "+pokemonGame.getPlayer2().getActivePokemon().getMaxHP());
            attack1.setText(pokemonGame.getPlayer1().getActivePokemon().getAttacks()[0].getName()+" - "+pokemonGame.getPlayer1().getActivePokemon().getAttacks()[0].getType());
            attack1.setBackgroundColor(Color.parseColor(pokemonGame.getPlayer1().getActivePokemon().getAttacks()[0].getType().getColor()));
            attack2.setText(pokemonGame.getPlayer1().getActivePokemon().getAttacks()[1].getName()+" - "+pokemonGame.getPlayer1().getActivePokemon().getAttacks()[1].getType());
            attack2.setBackgroundColor(Color.parseColor(pokemonGame.getPlayer1().getActivePokemon().getAttacks()[1].getType().getColor()));
            attack3.setText(pokemonGame.getPlayer1().getActivePokemon().getAttacks()[2].getName()+" - "+pokemonGame.getPlayer1().getActivePokemon().getAttacks()[2].getType());
            attack3.setBackgroundColor(Color.parseColor(pokemonGame.getPlayer1().getActivePokemon().getAttacks()[2].getType().getColor()));
            attack4.setText(pokemonGame.getPlayer1().getActivePokemon().getAttacks()[3].getName()+" - "+pokemonGame.getPlayer1().getActivePokemon().getAttacks()[3  ].getType());
            attack4.setBackgroundColor(Color.parseColor(pokemonGame.getPlayer1().getActivePokemon().getAttacks()[3].getType().getColor()));
            String newImagePath = "https://play.pokemonshowdown.com/sprites/ani-back/" + pokemonGame.getPlayer1().getActivePokemon().getName().toLowerCase() + ".gif";
            Glide.with(HardGame.this)
                    .load(newImagePath)
                    .into(gifImageView);
            String newImagePath2 = "https://play.pokemonshowdown.com/sprites/ani/" + pokemonGame.getPlayer2().getActivePokemon().getName().toLowerCase() + ".gif";
            Glide.with(HardGame.this)
                    .load(newImagePath2)
                    .into(ImageView);
            return;
        }
    }
    public void showString() {
        List<String> message = pokemonGame.getAllMessages();
        String turn = "Turn " + battleturn;
        String aux = String.join("\n", message);
        String result = turn + ":\n" + aux;
        SpannableString spannableMessage = new SpannableString(result);
        int startBold = 0; // Posición de la palabra "negrita"
        int endBold = startBold + turn.length() + 1;
        spannableMessage.setSpan(new StyleSpan(android.graphics.Typeface.BOLD), startBold, endBold, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        spannableMessage.setSpan(new RelativeSizeSpan(1.3f), startBold, endBold, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE); // 1.5f hace que el texto sea 1.5 veces más grande
        SpannableString spannableMessage2 = new SpannableString(turn);
        int startTurn=0;
        int endTurn=turn.length();
        spannableMessage2.setSpan(new StyleSpan(android.graphics.Typeface.BOLD), startTurn, endTurn, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        spannableMessage2.setSpan(new RelativeSizeSpan(1.5f), startTurn, endTurn, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE); // 1.5f hace que el texto sea 1.5 veces más grande
        textView3.setText(spannableMessage);
        textTurn.setText(spannableMessage2);
        battleturn= battleturn+1;
        }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mediaPlayer != null) {
            mediaPlayer.release();  // Libera los recursos cuando la actividad se destruye
            mediaPlayer = null;
        }
    }
    @Override
    protected void onPause(){
        super.onPause();
        if(mediaPlayer != null && mediaPlayer.isPlaying()){
            mediaPlayer.pause();
        }
    }
    @Override
    protected void onResume() {
        super.onResume();
        // Reanudar la música cuando la actividad vuelve al primer plano
        if (mediaPlayer != null && !mediaPlayer.isPlaying()) {
            mediaPlayer.start();  // Inicia o reanuda la música
        }
    }

}
