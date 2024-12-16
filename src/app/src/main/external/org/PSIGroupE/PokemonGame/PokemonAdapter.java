//package org.PSIGroupE.PokemonGame;
//
//import android.content.Context;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.ArrayAdapter;
//import android.widget.ImageView;
//import android.widget.TextView;
//
//import androidx.annotation.NonNull;
//import androidx.annotation.Nullable;

//import com.example.pokemongame.*;
//
//import java.util.List;
//
//public class PokemonAdapter extends ArrayAdapter<Pokemon> {
//
//    public PokemonAdapter(Context context, List<Pokemon> pokemons) {
//        super(context, 0, pokemons);
//    }
//
//    @NonNull
//    @Override
//    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
//        if (convertView == null) {
//            convertView = LayoutInflater.from(getContext()).inflate(R.layout.dialog_item, parent, false);
//        }
//
//        Pokemon pokemon = getItem(position);
//
//        ImageView imageView = convertView.findViewById(R.id.pokemon_image);
//        TextView textView = convertView.findViewById(R.id.pokemon_name);
//
//        // Configura la imagen y el nombre del Pokémon
//        imageView.setImageResource(pokemon.getImageResource()); // Suponiendo que tienes el ID del recurso de la imagen
//        textView.setText(pokemon.getName());
//
//        return convertView;
//    }
//}
