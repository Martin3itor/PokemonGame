//package org.PSIGroupE.PokemonGame;
//
//import android.os.Parcel;
//import android.os.Parcelable;
//
//import androidx.annotation.NonNull;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Random;
//import java.util.Scanner;
//
//import com.example.pokemongame.*;
//
//
///**
// *
// * @author Robert Sonnenburg
// */
//public class PokemonGameOG{
//
//    private Player player1;
//    private Player player2;
//    private MainActivity gui;
//    private List<String> pokemonList;
//    private static Scanner scanner;
//    private static Random random;
//    private boolean gameOver;
//    private Player winner;
//
//    public PokemonGameOG(MainActivity gui) {
//        scanner = new Scanner(System.in);
//        random = new Random();
//
//        this.gui=gui;
//        createPokemonList();
//        gameOver = false;
//    }
//
//    protected PokemonGameOG(Parcel in, Scanner scanner, Random random, MainActivity gui) {
//        pokemonList = in.createStringArrayList();
//        gameOver = in.readByte() != 0;
//        this.scanner = scanner;
//        this.random = random;
//        this.gui = gui;
//        createPokemonList();
//        gameOver = false;
//    }
//
//    //public static final Creator<PokemonGameOG> CREATOR = new Creator<PokemonGameOG>() {
//        //@Override
//       // public PokemonGameOG createFromParcel(Parcel in) {
//       //     return new PokemonGameOG(in, random, scanner, MainActivity);
//     //   }
//
//      //  @Override
//        //public PokemonGameOG[] newArray(int size) {
//          //  return new PokemonGameOG[size];
//       // }
//    //};
//
//    public void start() {
//        Pokemon[] team1 = selectRandomTeam();
//        Pokemon[] team2 = selectRandomTeam();
//
//        player1 = new Player(1, team1);
//        player2 = new Player(2, team2);
//
//        //while(!gameOver) {
//        // playRound();
//        // }
//    }
//
//    private Pokemon[] selectTeam() {
//        Pokemon[] team = new Pokemon[4];
//        boolean selectionValid = false;
//        while (selectionValid == false) {
//            System.out.println("Please select 4 Pokemon (e.g. 1,2,4,7):");
//            for (int i = 0; i < pokemonList.size(); i++) {
//                System.out.println( (i+1) + ". " + pokemonList.get(i));
//            }
//
//            String selection = scanner.next();
//            String[] selectedPokemonStr = selection.split(",");
//            if (selectedPokemonStr.length != 4) {
//                System.out.println("Please enter exactly 4 integers separated by commas.");
//                continue;
//            }
//
//            int[] selectedPokemonInt = new int[4];
//
//            try {
//                for (int i = 0 ; i < 4; i++) {
//                    selectedPokemonInt[i] = Integer.parseInt(selectedPokemonStr[i]);
//                    if (selectedPokemonInt[i] < 1 || selectedPokemonInt[i] > 10) {
//                        throw new IllegalArgumentException("Selection not in range");
//                    }
//                }
//            } catch (NumberFormatException e) {
//                System.out.println("Invalid input. Please ensure all entries are integers.");
//                continue;
//            } catch (IllegalArgumentException e) {
//                System.out.println("Invalid input. Selection not in range.");
//                continue;
//            }
//
//            selectionValid = true;
//
//            for (int i = 0; i < 4; i++) {
//                String selectedName = pokemonList.get(selectedPokemonInt[i] - 1);
//                team[i] = PokemonFactory.createPokemon(selectedName);
//            }
//        }
//        return team;
//    }
//
//    private Pokemon[] selectRandomTeam() {
//        Pokemon[] randomTeam = new Pokemon[4];
//        boolean repeated = false;
//        for (int i = 0; i < 4; i++) {
//            int index = random.nextInt(10);
//            String selectedName = pokemonList.get(index);
////            for(int j=0; j<i;j++) {
////                if(randomTeam[j] != null) {
////                    if (selectedName.equals(randomTeam[j].getName())) {
////                        i--;
////                        repeated = true;
////                    }
////                }
////            }
////            if(!repeated) {
//            randomTeam[i] = PokemonFactory.createPokemon(selectedName);
////            }
//        }
//        return randomTeam;
//    }
//
//    private void createPokemonList() {
//        pokemonList = new ArrayList<>();
//        pokemonList.add("Blastoise");
//        pokemonList.add("Flareon");
//        pokemonList.add("Garganacl");
//        pokemonList.add("Gigalith");
//        pokemonList.add("Hippowdon");
//        pokemonList.add("Leafeon");
//        pokemonList.add("Sandaconda");
//        pokemonList.add("Sceptile");
//        pokemonList.add("Typhlosion");
//        pokemonList.add("Vaporeon");
//    }
//
//    private int selectSwitch() {
//        int selection = 0;
//        boolean inputValid = false;
//        while (!inputValid) {
//            try {
//                selection = scanner.nextInt();
//            } catch (Exception e) {
//                System.out.println("Please enter an integer");
//                continue;
//            }
//            if (selection < 1 || selection > 4) {
//                System.out.println("Invalid Selection");
//                continue;
//            }
//            inputValid = true;
//        }
//        return selection - 1;
//    }
//
//    public int selectRandomMove() {
//        int randomMove = random.nextInt(5) + 1;
//        if (randomMove == 5) {
//            int randomOtherPokemon = Integer.parseInt(player2.getConsciousPokemon().get(random.nextInt(player2.getConsciousPokemon().size())));
//            randomMove = randomMove * 10 + randomOtherPokemon;
//        }
//        return randomMove;
//    }
//
//    public void playMoves(int move1, int move2) {
//        Player fasterPlayer;
//        Player slowerPlayer;
//        int fasterMove;
//        int slowerMove;
//        if (player1.getActivePokemon().getSp() > player2.getActivePokemon().getSp()) {
//            fasterPlayer = player1;
//            fasterMove = move1;
//            slowerPlayer = player2;
//            slowerMove = move2;
//        } else {
//            fasterPlayer = player2;
//            fasterMove = move2;
//            slowerPlayer = player1;
//            slowerMove = move1;
//        }
//
//        if (fasterMove > 4) {
//            fasterPlayer.setActivePokemon(fasterMove % 10);
//            gui.showString("Player " + fasterPlayer.getId() + " switched to " + fasterPlayer.getActivePokemon().getName());
//        }
//
//        if (slowerMove > 4) {
//            slowerPlayer.setActivePokemon(slowerMove % 10);
//            gui.showString("Player " + slowerPlayer.getId() + " switched to " + slowerPlayer.getActivePokemon().getName());
//        }
//
//        if (fasterMove <= 4) {
//            int damage = fasterPlayer.getActivePokemon().getAttacks()[fasterMove - 1].getPower() / 4; // Very simple
//            slowerPlayer.getActivePokemon().decreaseHp(damage);
//            gui.showString(fasterPlayer.getActivePokemon().getName() + " used "
//                    + fasterPlayer.getActivePokemon().getAttacks()[fasterMove - 1].getName());
//
//            gui.showString(slowerPlayer.getActivePokemon().getName() + " lost " + damage + " HP.");
//
//        }
//
//        if (!slowerPlayer.getActivePokemon().isConscious()) {
//            slowerPlayer.faint();
//            gui.showString(slowerPlayer.getActivePokemon().getName() + " fainted.");
//
//
//            if (slowerPlayer.canPlay()) {
//                //Sorry  for the following abomination haha
//                // Basically, it selects a random conscious Pokemon as the new active Pokemon
//                slowerPlayer.setActivePokemon(Integer.parseInt(slowerPlayer.getConsciousPokemon().get(random.nextInt(slowerPlayer.getConsciousPokemon().size()))));
//                gui.showString("Player " + slowerPlayer.getId() + " put " + slowerPlayer.getActivePokemon().getName() + " into battle.");
//
//            } else {
//                gameOver = true;
//                winner = fasterPlayer;
//                return;
//            }
//
//        } else if (slowerMove <= 4) {
//            int damage = slowerPlayer.getActivePokemon().getAttacks()[slowerMove - 1].getPower() / 4; // Very simple
//            fasterPlayer.getActivePokemon().decreaseHp(damage);
//            gui.showString(slowerPlayer.getActivePokemon().getName() + " used "
//                    + slowerPlayer.getActivePokemon().getAttacks()[slowerMove - 1].getName());
//
//            gui.showString(fasterPlayer.getActivePokemon().getName() + " lost " + damage + " HP.");
//
//        }
//
//        if (!fasterPlayer.getActivePokemon().isConscious()) {
//            fasterPlayer.faint();
//            gui.showString(fasterPlayer.getActivePokemon().getName() + " fainted.");
//
//            if (fasterPlayer.canPlay()) {
//                fasterPlayer.setActivePokemon(Integer.parseInt(fasterPlayer.getConsciousPokemon().get(random.nextInt(fasterPlayer.getConsciousPokemon().size()))));
//                gui.showString("Player " + fasterPlayer.getId() + " put " + fasterPlayer.getActivePokemon().getName() + " into battle.");
//
//            } else {
//                gameOver = true;
//                winner = slowerPlayer;
//            }
//        }
//    }
//    public Player getPlayer1(){
//        return player1;
//    }
//    public Player getPlayer2(){
//        return player2;
//    }
//    public List<String> getPokemonList(){
//        return pokemonList;
//    }
//
//   // @Override
//    //public int describeContents() {
//      //  return 0;
//    //}
//
//    //@Override
//    //public void writeToParcel(@NonNull Parcel dest, int flags) {
//      //  dest.writeStringList(pokemonList);
//        //dest.writeByte((byte) (gameOver ? 1 : 0));
//   // }
//}