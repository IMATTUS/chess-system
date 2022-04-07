package chess;

import boardgame.Position;

public class ChessPosition {
	private char column;
	private int row;
	public ChessPosition(char column, int row) {
		if(column < 'a' || column > 'h' || row < 1 || row > 8) {
			throw new ChessException("Error instantiating ChessPosition."
					+ " Valid values are from a1 to h8");
		}
		this.column = column;
		this.row = row;
	}
	public char getColumn() {
		return column;
	}
	public int getRow() {
		return row;
	}
	protected Position toPosition() {
		//XXX 
		//Rows are integer: matrix_row = 8 - chess_row
		//XXX
		//Columns are char and can be used in math operations such as '+' and '-'
		//'a' - 'a' = 0
		//'b' - 'a' = 1
		//'c' - 'a' = 2
		return new Position(8-row,column - 'a');
	}
	protected static ChessPosition fromPosition(Position position) {
		return new ChessPosition((char)('a'+position.getColumn()),8-position.getRow());
	}
	
	@Override
	public String toString() {
		return ""+column+row;
	}
}
