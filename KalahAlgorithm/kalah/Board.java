package kalah;

import java.util.*;

/**
 * This class represents a board of the kalah game.
 */
public class Board {

	/**
	 * A map of type key, int, and value, piece, which represents
	 * the piece of the board. The key is the piece ID and the
	 * value is a reference to the piece in memory.
	 */
	private Map<Integer, Piece> pieces;
	/**
	 * An integer that represents the current players turn
	 */
	private int turn = 1;

	/**
	 * This is the default constructor for the Board class.This will set the
	 * board to it's initial game state.
	 */
	public Board() {
		this.pieces = new HashMap<Integer, Piece>();
        int count = 0;

        for (int i = 0; i < 14; i++) {
            // set the piece's owner
            int owner;
            if (i < 7)
                owner = 1;
            else
                owner = 2;

            // build an empty stack of seeds
            Stack<Seed> seeds = new Stack<Seed>();

            if (i == 6 || i == 13) {
                // add a house to the map with empty seeds
                pieces.put(i, new House(i, owner, seeds));
            } else {
                // push seeds to the stack
                for (int j = 0; j < 3; j++)
                    seeds.push(new Seed(count));
                // add a store to the map with 3 seeds
                pieces.put(i, new Store(i, owner, seeds));
            }
        }
	}

	/**
	 * This method is responsible for checking if the game is over. It
	 * checks both sides of the board to see if either side has no seeds.
	 * @return A boolean object that represents if the game is over
	 */
	public boolean isGameOver() {
        boolean pl1 = true;
        boolean pl2 = true;
        for(Piece cur : pieces.values()) {
            if (cur.getClass() == Store.class && cur.getCount() != 0) {
                if (cur.getOwner() == 1)
                    pl1 = false;
                if (cur.getOwner() == 2)
                    pl2 = false;
            }
        }

        return pl1 && pl2;
	}

	/**
	 * This method transfers the seeds from the source store to the destination pieces adjacent to it. It iterates until all seeds are
	 * removed from the source store. If the destination piece is the
	 * opponents home then skip and move to the next piece. Each
	 * iteration makes a call to isLastSeed(). If it is the last seed then
	 * it calls isHome which returns the turn of the player who made the
	 * move. Otherwise it call isOwner which checks if the player who is
	 * making the move owns the destination piece. If true it calls
	 * isEmpty to check the destination piece which if true calls isEmpty to the opponents piece across from the destination piece. If the
	 * the opponents piece across from destination piece is not empty all
	 * seeds are transferred to the house of the player that made the
	 * move.
	 * @param source An integer that represents the piece of the board that
	 * the seeds will be transferred from.
	 */
	public void transfer(int source) {
		// TODO - implement Board.transfer
		throw new UnsupportedOperationException();
	}


    /**
     * This method check if the seed being transferred is the last seed in
     * the store.
     * @return A boolean that represents if the present seed is the last one in the store.
     */
    public boolean isLastSeed(Piece source) {
        return source.getCount() == 1;
    }


	/**
	 * This method is responsible for checking if the pieces type is a House.
	 * @param source An integer that represents a piece on the board.
	 * @return true if the source piece is a house, otherwise false
	 */
	public boolean isHouse(int source) {
		// TODO - implement Board.isHouse
		throw new UnsupportedOperationException();
	}

}