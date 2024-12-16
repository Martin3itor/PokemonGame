package org.PSIGroupE.PokemonGame;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;

import androidx.annotation.NonNull;

import com.example.pokemongame.MainActivity;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class PokemonGame implements Parcelable {
    private static List<String> messages = new ArrayList<>();

    private GameState gameState;
    private final TypeChart typeChart;
    private Player player1;
    private Player player2;
    private List<String> pokemonList;
    private final Random random;
    private Player winner;

    public PokemonGame() {
        random = new Random();
        typeChart = new TypeChart();
        createPokemonList();
        gameState = GameState.S0AwaitingTeamSelection;
    }

    protected PokemonGame(Parcel in) {
        pokemonList = in.createStringArrayList();
        random = new Random();
        typeChart = new TypeChart();
    }

    public static final Creator<PokemonGame> CREATOR = new Creator<PokemonGame>() {
        @Override
        public PokemonGame createFromParcel(Parcel in) {
            return new PokemonGame(in);
        }

        @Override
        public PokemonGame[] newArray(int size) {
            return new PokemonGame[size];
        }
    };

    public GameState startGame(String[] selectedPokemon) {
        Pokemon[] team1 = createTeam(selectedPokemon);
        Pokemon[] team2 = createRandomTeam();

        player1 = new Player(1, team1);
        player2 = new Player(2, team2);
        player1.setActivePokemon(0);
        addMessage("Player 1 choose: " + player1.getActivePokemon().getName());
        addMessage("Player 2 choose: " + player2.getActivePokemon().getName());
        gameState = GameState.S1AwaitingAction;
        return gameState;
    }

    private Pokemon[] createTeam(String[] selectedPokemon) {
        if (selectedPokemon.length != 4) {
            throw new IllegalArgumentException("There must be 4 selected Pokemon!");
        }
        Pokemon[] team = new Pokemon[4];

        for (int i = 0; i < 4; i++) {
            String pokemonName = selectedPokemon[i];
            if (pokemonName == null) {
                throw new IllegalArgumentException("The selected Pokemon cannot be null!");
            }
            team[i] = PokemonFactory.createPokemon(pokemonName);
        }

        return team;
    }

    private Pokemon[] createRandomTeam() {
        Pokemon[] randomTeam = new Pokemon[4];
        List<String> pool = new ArrayList<>(pokemonList);
        for (int i = 0; i < 4; i++) {
            int index = random.nextInt(pool.size());
            String selectedName = pool.get(index);
            Log.d("DEBUG",selectedName);
            randomTeam[i] = PokemonFactory.createPokemon(selectedName);
            pool.remove(index);
        }
        return randomTeam;
    }

    private void createPokemonList() {
        pokemonList = new ArrayList<>();
        pokemonList.add("Blastoise");
        pokemonList.add("Flareon");
        pokemonList.add("Tyranitar");
        pokemonList.add("Gigalith");
        pokemonList.add("Hippowdon");
        pokemonList.add("Leafeon");
        pokemonList.add("Sandaconda");
        pokemonList.add("Sceptile");
        pokemonList.add("Typhlosion");
        pokemonList.add("Vaporeon");
    }

    public GameState playAction(int action) {
        if (action > 4) {
            if (action / 10 != 5 || action % 10 > 3) {
                throw new IllegalArgumentException("Invalid action");
            }
        } else if (action < 1) {
            throw new IllegalArgumentException("Invalid action");
        }
        playMoves(action, selectRandomMove());
        return gameState;
}

private int selectRandomMove() {
    int randomMove = random.nextInt(5) + 1;
    if (randomMove == 5) {
        int randomOtherPokemon = Integer.parseInt(player2.getConsciousPokemon().get(random.nextInt(player2.getConsciousPokemon().size())));
        randomMove = randomMove * 10 + randomOtherPokemon;
    }
    return randomMove;
}

private void playMoves(int move1, int move2) {
    Player fasterPlayer;
    Player slowerPlayer;
    int fasterMove;
    int slowerMove;
    if (player1.getActivePokemon().getSp() > player2.getActivePokemon().getSp()) {
        fasterPlayer = player1;
        fasterMove = move1;
        slowerPlayer = player2;
        slowerMove = move2;
    } else {
        fasterPlayer = player2;
        fasterMove = move2;
        slowerPlayer = player1;
        slowerMove = move1;
    }

    if (fasterMove > 4) {
        fasterPlayer.setActivePokemon(fasterMove % 10);
        addMessage("Player " + fasterPlayer.getId()+ " swap to " + fasterPlayer.getActivePokemon().getName());
        // Call a GUI function to inform about Pokemon switch of faster player
    }

    if (slowerMove > 4) {
        slowerPlayer.setActivePokemon(slowerMove % 10);
        addMessage("Player " + slowerPlayer.getId()+ " swap to " + slowerPlayer.getActivePokemon().getName());
        // Call a GUI function to inform about Pokemon switch of slower player
    }

    if (fasterMove <= 4) {
        executeAttack(fasterPlayer.getActivePokemon(), slowerPlayer.getActivePokemon(), fasterMove - 1);
        // Call GUI function to inform about attack used and damage
    }

    if (!slowerPlayer.getActivePokemon().isConscious()) {
        slowerPlayer.faint();
        addMessage(slowerPlayer.getActivePokemon().getName() + " fainted.");
        // Call GUI function to inform about faint

        if (slowerPlayer.canPlay()) {
            if (slowerPlayer == player2) {
                //Select random next Pokemon if it is the bot
                slowerPlayer.setActivePokemon(Integer.parseInt(slowerPlayer.getConsciousPokemon().get(random.nextInt(slowerPlayer.getConsciousPokemon().size()))));
                // Call GUI method to inform about new Pokemon
            } else {
                gameState = GameState.S2AwaitingNextPokemon;
            }

        } else {
            winner = fasterPlayer;
            gameState = GameState.S3GameOver;
        }

    } else if (slowerMove <= 4) {
        executeAttack(slowerPlayer.getActivePokemon(), fasterPlayer.getActivePokemon(), slowerMove - 1);
        // Call GUI function to inform about attack used and damage
    }

    if (!fasterPlayer.getActivePokemon().isConscious()) {
        addMessage(fasterPlayer.getActivePokemon().getName() + " fainted.");
        fasterPlayer.faint();
        // Call GUI function to inform about faint

        if (fasterPlayer.canPlay()) {
            if (fasterPlayer == player2) {
                fasterPlayer.setActivePokemon(Integer.parseInt(fasterPlayer.getConsciousPokemon().get(random.nextInt(fasterPlayer.getConsciousPokemon().size()))));
                addMessage("Player "+fasterPlayer.getId()+" withdrew "+fasterPlayer.getActivePokemon().getName());
                // Call GUI method to inform about new Pokemon
            } else {
                gameState = GameState.S2AwaitingNextPokemon;
            }
        } else {
            winner = slowerPlayer;
            gameState = GameState.S3GameOver;
        }
    }
}

private void executeAttack(Pokemon attackingPokemon, Pokemon defendingPokemon, int attackId) {
    int power = attackingPokemon.getAttacks()[attackId].getPower();
    int a = attackingPokemon.getAp();
    int d = defendingPokemon.getDp();

    // Critical hit
    int crit;
    if (random.nextInt(256) < (attackingPokemon.getSp() / 2)) {
        crit = 2;
    } else {
        crit = 1;
    }

    //Same type attack bonus
    double stab;
    if (attackingPokemon.getAttacks()[attackId].getType() == attackingPokemon.getType()) {
        stab = 1.5;
    } else {
        stab = 1.0;
    }

    // Type effectiveness
    double eff = typeChart.getEffectiveness(attackingPokemon.getAttacks()[attackId].getType(), defendingPokemon.getType());

    // Random parameter
    int ran = random.nextInt(15) + 85;
    int N = 200;
    // Damage calculation
    int damage = (int) (((crit / 5 + 2) * ((0.2*N+2)*power * a /(25*d)) / 50 + 2) * stab * eff * ran *0.01);

    defendingPokemon.decreaseHp(damage);
    addMessage(attackingPokemon.getName()+" used "+ attackingPokemon.getAttacks()[attackId].getName());
    addMessage(defendingPokemon.getName()+" lost "+damage+ " HP");
}

public GameState selectNextPokemon(int next) {
    if (next < 0 || next > 3) {
        throw new IllegalArgumentException("Invalid next Pokemon index");
    }

    if(!player1.getConsciousPokemon().contains(String.valueOf(next))) {
        throw new IllegalArgumentException("Chosen next pokemon is unconscious");
    }

    player1.setActivePokemon(next);
    gameState = GameState.S1AwaitingAction;
    return gameState;
}
public GameState getGameState(){
        return gameState;
}
public List<String> getPokemonList() {
    return pokemonList;
}

public Player getPlayer1() {
    return player1;
}

public Player getPlayer2() {
    return player2;
}

public Player getWinner() {
    return winner;
}

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel dest, int flags) {
        dest.writeStringList(pokemonList);
    }

    public static void addMessage(String message) {
        messages.add(message);
    }

    public static String getNextMessage() {
        if (messages.isEmpty()) {
            return "No hay más mensajes.";
        }
        return messages.remove(0); // Extrae el primer mensaje de la lista
    }

    public static List<String> getAllMessages() {
        List<String> logs = new ArrayList<>(messages);
        messages.clear();
        return logs;
    }
}