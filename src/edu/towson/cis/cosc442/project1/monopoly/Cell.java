package edu.towson.cis.cosc442.project1.monopoly;

public abstract class Cell {
	private boolean available = true;
	private String name;
	protected Player theOwner;

	/**
	 * Returns the name of the cell.
	 * @return The name of the cell.
	 */
	/**
	 * Returns the name of the cell.
	 * @return The name of the cell.
	 */
	public String getName() {
		return name;
	}

	/**
	 * Returns the player who owns this cell.
	 * @return The owner player of the cell.
	 */
	/**
	 * Returns the player who owns this cell.
	 * @return The owner player of the cell.
	 */
	public Player getTheOwner() {
		return theOwner;
	}
	
	/**
	 * Returns the price of the cell, defaulting to 0 in this abstract class.
	 * @return The price of the cell.
	 */
	/**
	 * Returns the price of the cell, defaulting to 0 in this abstract class.
	 * @return The price of the cell.
	 */
	public int getPrice() {
		return 0;
	}

	/**
	 * Checks if the cell is currently available.
	 * @return True if the cell is available; false otherwise.
	 */
	/**
	 * Checks if the cell is currently available.
	 * @return True if the cell is available; false otherwise.
	 */
	public boolean isAvailable() {
		return available;
	}
	
	/**
	 * Performs the action associated with landing on this cell.
	 */
	/**
	 * Performs the action associated with landing on this cell.
	 */
	public abstract void playAction();

	/**
	 * Sets the availability status of the cell.
	 * @param available The new availability status to set.
	 */
	/**
	 * Sets the availability status of the cell.
	 * @param available The new availability status to set.
	 */
	public void setAvailable(boolean available) {
		this.available = available;
	}
	
	/**
	 * Sets the name of the cell.
	 * @param name The new name to assign to the cell.
	 */
	/**
	 * Sets the name of the cell.
	 * @param name The new name to assign to the cell.
	 */
	void setName(String name) {
		this.name = name;
	}

	/**
	 * Assigns a player as the owner of this cell.
	 * @param owner The player to set as the owner.
	 */
	/**
	 * Assigns a player as the owner of this cell.
	 * @param owner The player to set as the owner.
	 */
	public void setTheOwner(Player owner) {
		this.theOwner = owner;
	}
    
    /**
     * Returns the string representation of the cell.
     * @return The name of the cell as a string.
     */
    /**
     * Returns the string representation of the cell.
     * @return The name of the cell as a string.
     */
    public String toString() {
        return name;
    }
}
