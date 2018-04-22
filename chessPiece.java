package fivegame;

public class chessPiece {
	private int x, y;

	boolean chessColor;

	chessPiece(int a, int b, boolean c) {
		x = a;
		y = b;
		chessColor = c;
	}

	chessPiece(int a, int b) {
		x = a;
		y = b;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public boolean getColor() {
		return chessColor;
	}
}
