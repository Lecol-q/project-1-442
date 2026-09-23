package edu.towson.cis.cosc442.project1.monopoly;

import java.util.ArrayList;
import java.util.Hashtable;

public class GameBoard {

	private ArrayList<Cell> cells = new ArrayList<Cell>();
    private ArrayList<Card> chanceCards = new ArrayList<Card>();
	//the key of colorGroups is the name of the color group.
	private Hashtable<String, Integer> colorGroups = new Hashtable<String, Integer>();
	private ArrayList<Card> communityChestCards = new ArrayList<Card>();
	/**
	 * Constructs a new GameBoard and initializes it with the GoCell.
	 */
	/**
	 * Constructs a new GameBoard and initializes it with the GoCell.
	 */
	public GameBoard() {
		Cell go = new GoCell();
		addCell(go);
	}

    /**
     * Adds the specified Card to the appropriate deck based on its type.
     * @param card the Card to add to the board's decks
     */
    /**
     * Adds the specified Card to the appropriate deck based on its type.
     * @param card the Card to add to the board's decks
     */
    public void addCard(Card card) {
        if(card.getCardType() == Card.TYPE_CC) {
            communityChestCards.add(card);
        } else {
            chanceCards.add(card);
        }
    }
	
	/**
	 * Adds the specified Cell to the list of board cells.
	 * @param cell the Cell to add to the board
	 */
	/**
	 * Adds the specified Cell to the list of board cells.
	 * @param cell the Cell to add to the board
	 */
	public void addCell(Cell cell) {
		cells.add(cell);
	}
	
	/**
	 * Adds the specified PropertyCell to the board and updates the count for its color group.
	 * @param cell the PropertyCell to add to the board
	 */
	/**
	 * Adds the specified PropertyCell to the board and updates the count for its color group.
	 * @param cell the PropertyCell to add to the board
	 */
	public void addCell(PropertyCell cell) {
		String colorGroup = cell.getColorGroup();
		int propertyNumber = getPropertyNumberForColor(colorGroup);
		colorGroups.put(colorGroup, new Integer(propertyNumber + 1));
        cells.add(cell);
	}

    /**
     * Draws the top Community Chest card, moves it to the bottom of the deck, and returns it.
     * @return the drawn Community Chest Card
     */
    /**
     * Draws the top Community Chest card, moves it to the bottom of the deck, and returns it.
     * @return the drawn Community Chest Card
     */
    public Card drawCCCard() {
        Card card = communityChestCards.get(0);
        communityChestCards.remove(0);
        addCard(card);
        return card;
    }

    /**
     * Draws the top Chance card, moves it to the bottom of the deck, and returns it.
     * @return the drawn Chance Card
     */
    /**
     * Draws the top Chance card, moves it to the bottom of the deck, and returns it.
     * @return the drawn Chance Card
     */
    public Card drawChanceCard() {
        Card card = (Card)chanceCards.get(0);
        chanceCards.remove(0);
        addCard(card);
        return card;
    }

	/**
	 * Retrieves the Cell at the specified index on the board.
	 * @param newIndex the index of the desired Cell
	 * @return the Cell at the specified index
	 */
	/**
	 * Retrieves the Cell at the specified index on the board.
	 * @param newIndex the index of the desired Cell
	 * @return the Cell at the specified index
	 */
	public Cell getCell(int newIndex) {
		return (Cell)cells.get(newIndex);
	}
	
	/**
	 * Returns the total number of Cells on the board.
	 * @return the number of Cells on the board
	 */
	/**
	 * Returns the total number of Cells on the board.
	 * @return the number of Cells on the board
	 */
	public int getCellNumber() {
		return cells.size();
	}
	
	/**
	 * Returns an array of all PropertyCells belonging to the specified color group.
	 * @param color the name of the color group
	 * @return an array of PropertyCells in the specified monopoly
	 */
	/**
	 * Returns an array of all PropertyCells belonging to the specified color group.
	 * @param color the name of the color group
	 * @return an array of PropertyCells in the specified monopoly
	 */
	public PropertyCell[] getPropertiesInMonopoly(String color) {
		PropertyCell[] monopolyCells = 
			new PropertyCell[getPropertyNumberForColor(color)];
		int counter = 0;
		for (int i = 0; i < getCellNumber(); i++) {
			Cell c = getCell(i);
			if(c instanceof PropertyCell) {
				PropertyCell pc = (PropertyCell)c;
				if(pc.getColorGroup().equals(color)) {
					monopolyCells[counter] = pc;
					counter++;
				}
			}
		}
		return monopolyCells;
	}
	
	/**
	 * Returns the number of properties belonging to the specified color group.
	 * @param name the name of the color group
	 * @return the number of properties in the color group
	 */
	/**
	 * Returns the number of properties belonging to the specified color group.
	 * @param name the name of the color group
	 * @return the number of properties in the color group
	 */
	public int getPropertyNumberForColor(String name) {
		Integer number = (Integer)colorGroups.get(name);
		if(number != null) {
			return number.intValue();
		}
		return 0;
	}

	/**
	 * Searches for a Cell by its name and returns it if found.
	 * @param string the name of the Cell to search for
	 * @return the Cell with the specified name, or null if not found
	 */
	/**
	 * Searches for a Cell by its name and returns it if found.
	 * @param string the name of the Cell to search for
	 * @return the Cell with the specified name, or null if not found
	 */
	public Cell queryCell(String string) {
		for(int i = 0; i < cells.size(); i++){
			Cell temp = (Cell)cells.get(i); 
			if(temp.getName().equals(string)) {
				return temp;
			}
		}
		return null;
	}
	
	/**
	 * Finds the index of the Cell with the specified name on the board.
	 * @param string the name of the Cell to locate
	 * @return the index of the Cell, or -1 if not found
	 */
	/**
	 * Finds the index of the Cell with the specified name on the board.
	 * @param string the name of the Cell to locate
	 * @return the index of the Cell, or -1 if not found
	 */
	public int queryCellIndex(String string){
		for(int i = 0; i < cells.size(); i++){
			Cell temp = (Cell)cells.get(i); 
			if(temp.getName().equals(string)) {
				return i;
			}
		}
		return -1;
	}

    /**
     * Removes all Community Chest cards from the deck.
     */
    /**
     * Removes all Community Chest cards from the deck.
     */
    public void removeCards() {
        communityChestCards.clear();
    }
}
