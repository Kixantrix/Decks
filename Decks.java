// Michael Von Hippel
// This is a card deck simulator 

import java.io.*;
import java.util.*;
import java.awt.*;
	
public class Decks {

	// Game variables	
	public static final int LENGTH   = 52;
	public static final int PLAYERS  = 4;
	public static final int CARDS    = 7;
	public static final int SHUFFLES = 4;
	
	public static void main(String[] args) {
		int[] deck    = new int[LENGTH];
		int[][] hands = new int[PLAYERS][CARDS];
		initDeck(deck);
		showDeck(deck);
		shuffle(deck, SHUFFLES);
		showDeck(deck);
		dealDeck(deck, hands);
		showHands(hands);
		showDeck(deck);
	}
	
	// Creates a deck of cards
	public static void initDeck(int[] deck) {
		for(int i = 0; i < LENGTH; i++) {
			deck[i] = i + 1;
		}
	}		
	
	// Shuffles the deck of cards
	public static void shuffle(int[] deck, int num) {
		Random r = new Random(); 
		int[] temp = Arrays.copyOf(deck, 52);
		Arrays.fill(deck, 0);
		for (int i = 0; i < LENGTH; i++) {
			while (temp[i] != 0) {
				int j = r.nextInt(LENGTH);
				if (deck[j] == 0) {
					deck[j] = temp[i];
					temp[i] = 0;
				}	
			}
		}
	}
	
	// Displays the cards in the deck
	public static void showDeck(int[] deck) {
		System.out.println(Arrays.toString(deck));
	}	
	
	// Displays the card in each player's hand
	public static void showHands(int[][] hands) {
		for (int i = 0; i < PLAYERS; i++) {
			int[] temp = new int[CARDS];
			for (int j = 0; j < CARDS; j++) {
				hands[i][j] = temp[j]; 
			}
			System.out.println("Player " + i + " " + Arrays.toString(temp));
		}	
	}
	
	// Deals the deck to the players
	public static void dealDeck(int [] deck, int[][] hands) {
		for (int i = 0; i < CARDS; i++) {
			for (int j = 0; j < PLAYERS; j++) { 
				int x = Arrays.copyOf(deck[PLAYERS * j + i], 1);
				hands[j][i] = x;
				deck[PLAYERS * j + i] = 0;
			}
		}	
	}
}	