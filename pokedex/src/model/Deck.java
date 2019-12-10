package model;

import java.io.*;
import java.util.ArrayList;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class Deck {
	protected static ArrayList<Card> cards = new ArrayList<Card>();

	public Deck() {
		this.cards = new ArrayList<>();
	}
	public static ArrayList<Card> getCards() {
		return cards;
	}
	public  Card getCard(int i) {
		for(Card card: cards) {
			if(card.getId() == i){
				return card;
			}
		}
		return null;
	}
	public int getSizeCards() {
		return this.cards.size();
	}
	public void addCard(Card card) {
		this.cards.add(card);
	}
	public void setCards(ArrayList<Card> cards) {
		this.cards = cards;
	}

	public static void initializeDeck() {
		Gson gson = new Gson();
		BufferedReader bufferedReader = null;
		try {
			// Read file
			bufferedReader = new BufferedReader(new FileReader("cards.json"));
			JsonElement tree = new JsonParser().parse(bufferedReader);
			if (!tree.isJsonNull()) {
				JsonArray array = tree.getAsJsonArray();
				// Create new card foreach found element in json
				for (JsonElement card : array) {
					JsonObject json = card.getAsJsonObject();

					// Create pokemon card
					if (json.get("type").getAsString().equals("Pokemon")) {
						int id = json.get("id").getAsInt();
						String name = json.get("name").getAsString();
						int hp = json.get("hp").getAsInt();
						String typePokemon = json.get("typePokemon").getAsString();
						String description = json.get("description").getAsString();
						String image = json.get("image").getAsString();


						ArrayList<Attack> attacks = new ArrayList<Attack>();
						JsonElement attackjson = json.get("attacks").getAsJsonArray();
						for(JsonElement attack: array){
							JsonObject jsonAttack = attack.getAsJsonObject();

							String attackName = jsonAttack.getAsJsonObject().get("name").getAsString();
							String attackDesc = jsonAttack.getAsJsonObject().get("desc").getAsInt();
							int power = jsonAttack.getAsJsonObject().get("power").getAsInt();
							attacks.add(new Attack(attackName, attackDesc, power));

						}
						new Pokemon(name, typePokemon, description, image, id, hp,attacks);

					} else if (json.get("type").getAsString().equals("Energy")) {
						int id = json.get("id").getAsInt();
						String name = json.get("name").getAsString();
						int hp = json.get("hp").getAsInt();
						String typePokemon = json.get("typePokemon").getAsString();
						String description = json.get("description").getAsString();
						String image = json.get("image").getAsString();

						new Energy(name, type, description, img, id);
					}
					else if(json.get("type").getAsString().equals("Trainer")){
						int id = json.get("id").getAsInt();
						String name = json.get("name").getAsString();
						String typePokemon = json.get("typePokemon").getAsString();
						String description = json.get("description").getAsString();
						String image = json.get("image").getAsString();

						new Trainer(name, type, description, img, id);
					}

				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
				bufferedReader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public static void saveDeck() {
		String json = new Gson().toJson(cards);
		try {
			FileWriter writer = new FileWriter("cards.json");
			writer.write(json);
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
