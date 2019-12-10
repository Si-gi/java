import model.Deck;
import view.MainMenu;
//import pokedex.Json;
//import pokedex.menu;

import java.awt.*;
import java.lang.reflect.Type;


public class main {
	
	public static void main(String[] args) {
		Deck.initializeDeck();
		MainMenu frame = new MainMenu(new Frame());
		frame.setVisible(true);
	}

}
