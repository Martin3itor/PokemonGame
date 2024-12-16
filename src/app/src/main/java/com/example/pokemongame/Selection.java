package com.example.pokemongame;


/////////LIBRARIES//////////////////////////////////////////////
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.SimpleTarget;
import com.bumptech.glide.request.transition.Transition;

import org.PSIGroupE.PokemonGame.*;
////////////////////////////////////////////////////////////////////////////////////////

public class Selection extends AppCompatActivity {
    /////////VARIABLES/////////////////////////////////
    public String[] pokemon = {" "," "," "," "};
    PokemonGame pokemonGame = new PokemonGame();
    public int count=0;
    public boolean flag = false;
    ////////////////////////////////////////////////////////////////////////////////////////
    /////////ON CREATE(LAUNCHED DEFAULT)/////////////////////////////////
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selection);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        ////////////////////////////////////////////////////////////////////////////////////////
        /////////LOADING ALL POKEMON AND IMAGES/////////////////////////////////
        TextView textView1 = findViewById(R.id.pokemon1);
        String imagePath1 = "https://play.pokemonshowdown.com/sprites/dex/" + pokemonGame.getPokemonList().get(0).toLowerCase()+ ".png";
        Glide.with(this)
                .load(imagePath1) // La URL de la imagen
                .into(new SimpleTarget<Drawable>() {  // Usamos un SimpleTarget para manejar la imagen cargada
                    @Override
                    public void onResourceReady(Drawable resource, Transition<? super Drawable> transition) {
                        // Cuando la imagen está lista, la establecemos en el TextView
                        textView1.setCompoundDrawablesWithIntrinsicBounds(resource, null, null, null);
                    }
                });
        textView1.setText(pokemonGame.getPokemonList().get(0));

        TextView textView2 = findViewById(R.id.pokemon2);
        String imagePath2 = "https://play.pokemonshowdown.com/sprites/dex/" + pokemonGame.getPokemonList().get(1).toLowerCase()+ ".png";
        Glide.with(this)
                .load(imagePath2) // La URL de la imagen
                .into(new SimpleTarget<Drawable>() {  // Usamos un SimpleTarget para manejar la imagen cargada
                    @Override
                    public void onResourceReady(Drawable resource, Transition<? super Drawable> transition) {
                        // Cuando la imagen está lista, la establecemos en el TextView
                        textView2.setCompoundDrawablesWithIntrinsicBounds(resource, null, null, null);
                    }
                });
        textView2.setText(pokemonGame.getPokemonList().get(1));

        TextView textView3 = findViewById(R.id.pokemon3);
        String imagePath3 = "https://play.pokemonshowdown.com/sprites/dex/" + pokemonGame.getPokemonList().get(2).toLowerCase()+ ".png";
        Glide.with(this)
                .load(imagePath3) // La URL de la imagen
                .into(new SimpleTarget<Drawable>() {  // Usamos un SimpleTarget para manejar la imagen cargada
                    @Override
                    public void onResourceReady(Drawable resource, Transition<? super Drawable> transition) {
                        // Cuando la imagen está lista, la establecemos en el TextView
                        textView3.setCompoundDrawablesWithIntrinsicBounds(resource, null, null, null);
                    }
                });
        textView3.setText(pokemonGame.getPokemonList().get(2));

        TextView textView4 = findViewById(R.id.pokemon4);
        String imagePath4 = "https://play.pokemonshowdown.com/sprites/dex/" + pokemonGame.getPokemonList().get(3).toLowerCase()+ ".png";
        Glide.with(this)
                .load(imagePath4) // La URL de la imagen
                .into(new SimpleTarget<Drawable>() {  // Usamos un SimpleTarget para manejar la imagen cargada
                    @Override
                    public void onResourceReady(Drawable resource, Transition<? super Drawable> transition) {
                        // Cuando la imagen está lista, la establecemos en el TextView
                        textView4.setCompoundDrawablesWithIntrinsicBounds(resource, null, null, null);
                    }
                });
        textView4.setText(pokemonGame.getPokemonList().get(3));

        TextView textView5 = findViewById(R.id.pokemon5);
        String imagePath5 = "https://play.pokemonshowdown.com/sprites/dex/" + pokemonGame.getPokemonList().get(4).toLowerCase()+ ".png";
        Glide.with(this)
                .load(imagePath5) // La URL de la imagen
                .into(new SimpleTarget<Drawable>() {  // Usamos un SimpleTarget para manejar la imagen cargada
                    @Override
                    public void onResourceReady(Drawable resource, Transition<? super Drawable> transition) {
                        // Cuando la imagen está lista, la establecemos en el TextView
                        textView5.setCompoundDrawablesWithIntrinsicBounds(resource, null, null, null);
                    }
                });
        textView5.setText(pokemonGame.getPokemonList().get(4));

        TextView textView6 = findViewById(R.id.pokemon6);
        String imagePath6 = "https://play.pokemonshowdown.com/sprites/dex/" + pokemonGame.getPokemonList().get(5).toLowerCase()+ ".png";
        Glide.with(this)
                .load(imagePath6) // La URL de la imagen
                .into(new SimpleTarget<Drawable>() {  // Usamos un SimpleTarget para manejar la imagen cargada
                    @Override
                    public void onResourceReady(Drawable resource, Transition<? super Drawable> transition) {
                        // Cuando la imagen está lista, la establecemos en el TextView
                        textView6.setCompoundDrawablesWithIntrinsicBounds(resource, null, null, null);
                    }
                });
        textView6.setText(pokemonGame.getPokemonList().get(5));

        TextView textView7 = findViewById(R.id.pokemon7);
        String imagePath7 = "https://play.pokemonshowdown.com/sprites/dex/" + pokemonGame.getPokemonList().get(6).toLowerCase()+ ".png";
        Glide.with(this)
                .load(imagePath7) // La URL de la imagen
                .into(new SimpleTarget<Drawable>() {  // Usamos un SimpleTarget para manejar la imagen cargada
                    @Override
                    public void onResourceReady(Drawable resource, Transition<? super Drawable> transition) {
                        // Cuando la imagen está lista, la establecemos en el TextView
                        textView7.setCompoundDrawablesWithIntrinsicBounds(resource, null, null, null);
                    }
                });
        textView7.setText(pokemonGame.getPokemonList().get(6));

        TextView textView8 = findViewById(R.id.pokemon8);
        String imagePath8 = "https://play.pokemonshowdown.com/sprites/dex/" + pokemonGame.getPokemonList().get(7).toLowerCase()+ ".png";
        Glide.with(this)
                .load(imagePath8) // La URL de la imagen
                .into(new SimpleTarget<Drawable>() {  // Usamos un SimpleTarget para manejar la imagen cargada
                    @Override
                    public void onResourceReady(Drawable resource, Transition<? super Drawable> transition) {
                        // Cuando la imagen está lista, la establecemos en el TextView
                        textView8.setCompoundDrawablesWithIntrinsicBounds(resource, null, null, null);
                    }
                });
        textView8.setText(pokemonGame.getPokemonList().get(7));

        TextView textView9 = findViewById(R.id.pokemon9);
        String imagePath9 = "https://play.pokemonshowdown.com/sprites/dex/" + pokemonGame.getPokemonList().get(8).toLowerCase()+ ".png";
        Glide.with(this)
                .load(imagePath9) // La URL de la imagen
                .into(new SimpleTarget<Drawable>() {  // Usamos un SimpleTarget para manejar la imagen cargada
                    @Override
                    public void onResourceReady(Drawable resource, Transition<? super Drawable> transition) {
                        // Cuando la imagen está lista, la establecemos en el TextView
                        textView9.setCompoundDrawablesWithIntrinsicBounds(resource, null, null, null);
                    }
                });
        textView9.setText(pokemonGame.getPokemonList().get(8));

        TextView textView10 = findViewById(R.id.pokemon10);
        String imagePath10 = "https://play.pokemonshowdown.com/sprites/dex/" + pokemonGame.getPokemonList().get(9).toLowerCase()+ ".png";
        Glide.with(this)
                .load(imagePath10) // La URL de la imagen
                .into(new SimpleTarget<Drawable>() {  // Usamos un SimpleTarget para manejar la imagen cargada
                    @Override
                    public void onResourceReady(Drawable resource, Transition<? super Drawable> transition) {
                        // Cuando la imagen está lista, la establecemos en el TextView
                        textView10.setCompoundDrawablesWithIntrinsicBounds(resource, null, null, null);
                    }
                });
        textView10.setText(pokemonGame.getPokemonList().get(9));
        ////////////////////////////////////////////////////////////////////////////////////////
        /////////POKEMON LISTENERS/////////////////////////////////
        textView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                /////////IF POKEMON IS ALREADY CHOSEN WE ACTIVATE THE FLAG/////////////////////////////////
                for(int i=0;i<pokemon.length;i++){
                    if(pokemon[i].equals(pokemonGame.getPokemonList().get(0))){
                        flag=true;
                        break;
                    }
                }
                ////////////////////////////////////////////////////////////////////////////////////////
                /////////IF FLAG IS NOT ACTIVATED WE ADD THE POKEMON/////////////////////////////////
                if(!flag) {
                    pokemon[count] = pokemonGame.getPokemonList().get(0);
                    count++;
                    textView1.setBackgroundColor(Color.parseColor("#770000FF"));
                    String text = count + "º " + pokemonGame.getPokemonList().get(0);
                    textView1.setText(text);
                    ////////////////////////////////////////////////////////////////////////////////////////
                    /////////IF WE HAVE 4 FOR POKEMONS CHOSEN WE END/////////////////////////////////
                    if (count == 4) {
                        close();
                    }
                }
                ////////////////////////////////////////////////////////////////////////////////////////
                /////////RESET FLAG/////////////////////////////////
                flag=false;
            }
        });
        ////////////////////////////////////////////////////////////////////////////////////////
        /////////SAME FOR ALL/////////////////////////////////
        textView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for(int i=0;i<pokemon.length;i++){
                    if(pokemon[i].equals(pokemonGame.getPokemonList().get(1))){
                        flag=true;
                        break;
                    }
                }
                if(!flag) {
                        pokemon[count] = pokemonGame.getPokemonList().get(1);
                        count++;
                        textView2.setBackgroundColor(Color.parseColor("#770000FF"));
                        String text = count + "º " + pokemonGame.getPokemonList().get(1);
                        textView2.setText(text);
                        if (count == 4) {
                            close();
                        }
                    }
                flag=false;
                }
        });
        textView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for(int i=0;i<pokemon.length;i++){
                    if(pokemon[i].equals(pokemonGame.getPokemonList().get(2))){
                        flag=true;
                        break;
                    }
                }
                if(!flag) {
                    pokemon[count] = pokemonGame.getPokemonList().get(2);
                    count++;
                    textView3.setBackgroundColor(Color.parseColor("#770000FF"));
                    String text = count + "º " + pokemonGame.getPokemonList().get(2);
                    textView3.setText(text);
                    if (count == 4) {
                        close();
                    }
                }
                flag=false;
            }
        });
        textView4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for(int i=0;i<pokemon.length;i++){
                    if(pokemon[i].equals(pokemonGame.getPokemonList().get(3))){
                        flag=true;
                        break;
                    }
                }
                if(!flag) {
                    pokemon[count] = pokemonGame.getPokemonList().get(3);
                    count++;
                    textView4.setBackgroundColor(Color.parseColor("#770000FF"));
                    String text = count + "º " + pokemonGame.getPokemonList().get(3);
                    textView4.setText(text);
                    if (count == 4) {
                        close();
                    }
                }
                flag=false;
            }
        });
        textView5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for (int i = 0; i < pokemon.length; i++) {
                    if (pokemon[i].equals(pokemonGame.getPokemonList().get(4))) {
                        flag = true;
                        break;
                    }
                }
                if (!flag) {
                    pokemon[count] = pokemonGame.getPokemonList().get(4);
                    count++;
                    textView5.setBackgroundColor(Color.parseColor("#770000FF"));
                    String text = count + "º " + pokemonGame.getPokemonList().get(4);
                    textView5.setText(text);
                    if (count == 4) {
                        close();
                    }
                }
                flag=false;
            }
        });
        textView6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for(int i=0;i<pokemon.length;i++){
                    if(pokemon[i].equals(pokemonGame.getPokemonList().get(5))){
                        flag=true;
                        break;
                    }
                }
                if(!flag) {
                    pokemon[count] = pokemonGame.getPokemonList().get(5);
                    count++;
                    textView6.setBackgroundColor(Color.parseColor("#770000FF"));
                    String text = count + "º " + pokemonGame.getPokemonList().get(5);
                    textView6.setText(text);
                    if (count == 4) {
                        close();
                    }
                }
                flag=false;
            }
        });
        textView7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for(int i=0;i<pokemon.length;i++){
                    if(pokemon[i].equals(pokemonGame.getPokemonList().get(6))){
                        flag=true;
                        break;
                    }
                }
                if(!flag) {
                    pokemon[count] = pokemonGame.getPokemonList().get(6);
                    count++;
                    textView7.setBackgroundColor(Color.parseColor("#770000FF"));
                    String text = count + "º " + pokemonGame.getPokemonList().get(6);
                    textView7.setText(text);
                    if (count == 4) {
                        close();
                    }
                }
                flag=false;
            }
        });
        textView8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for(int i=0;i<pokemon.length;i++){
                    if(pokemon[i].equals(pokemonGame.getPokemonList().get(7))){
                        flag=true;
                        break;
                    }
                }
                if(!flag) {
                    pokemon[count] = pokemonGame.getPokemonList().get(7);
                    count++;
                    textView8.setBackgroundColor(Color.parseColor("#770000FF"));
                    String text = count + "º " + pokemonGame.getPokemonList().get(7);
                    textView8.setText(text);
                    if (count == 4) {
                        close();
                    }
                }
                flag=false;
            }
        });
        textView9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for(int i=0;i<pokemon.length;i++){
                    if(pokemon[i].equals(pokemonGame.getPokemonList().get(8))){
                        flag=true;
                        break;
                    }
                }
                if(!flag) {
                    pokemon[count] = pokemonGame.getPokemonList().get(8);
                    count++;
                    textView9.setBackgroundColor(Color.parseColor("#770000FF"));
                    String text = count + "º " + pokemonGame.getPokemonList().get(8);
                    textView9.setText(text);
                    if (count == 4) {
                        close();
                    }
                }
                flag=false;
            }
        });
        textView10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for(int i=0;i<pokemon.length;i++){
                    if(pokemon[i].equals(pokemonGame.getPokemonList().get(9))){
                        flag=true;
                        break;
                    }
                }
                if(!flag) {
                    pokemon[count] = pokemonGame.getPokemonList().get(9);
                    count++;
                    textView10.setBackgroundColor(Color.parseColor("#770000FF"));
                    String text = count + "º " + pokemonGame.getPokemonList().get(9);
                    textView10.setText(text);
                    if (count == 4) {
                        close();
                    }
                }
                flag=false;
            }
        });
    }
    ////////////////////////////////////////////////////////////////////////////////////////
    /////////ON END/////////////////////////////////
    public void close(){
        for (String s : pokemon) {
            System.out.println(s);
        }
        /////////////WE ADD THE POKEMON ARRAY AND THE POKEMONGAME OBJECT TO THE INTENT////////
        Intent intent = new Intent(Selection.this,DifSelection.class);
        intent.putExtra("pokemon_game", pokemonGame);
        intent.putExtra( "selected_pokemon", pokemon);
        setResult(RESULT_OK, intent);
        ////////////////////////////////////////////////////////////////////////////////////////
        /////////WE LAUNCH DIFSELECTION AND CLOSE THIS ONE/////////////////////////////////
        startActivity(intent);
        finish();
    }
    ////////////////////////////////////////////////////////////////////////////////////////
    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
