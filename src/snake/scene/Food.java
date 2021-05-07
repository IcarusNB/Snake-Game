package snake.scene;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.Rectangle;

import snake.graphics.Rect;
import snake.util.Constants;
import snake.util.GameUtils;

public class Food extends Rect {
	private int eatenTimes;

	public Food (Rectangle drawingArea, Snake snake) {
		setRandomLocation(drawingArea, snake);
		setDimension(new Dimension(Constants.FOOD_SIZE, Constants.FOOD_SIZE));
		setColor(Color.GREEN);
	}
	
	public void setRandomLocation (Rectangle drawingArea, Snake snake) {
		do {
			int offset = 3;
			int x = GameUtils.random(
					(int) drawingArea.getMinX() + offset,
					(int) drawingArea.getMaxX() - offset - Constants.FOOD_SIZE);
			int y = GameUtils.random(
					(int) drawingArea.getMinY() + offset,
					(int) drawingArea.getMaxY() - offset - Constants.FOOD_SIZE);
			
			setLocation(new Point(x, y));
		} while (snake.intersects(this));
	}
	
	public void checkIfEaten (Snake snake, Rectangle drawingArea) {
		if (snake.intersects(this)) {
			eatenTimes++;
			setRandomLocation(drawingArea, snake);
			snake.elongate();
		}
	}
	
	public int getEatenTimes() {
		return eatenTimes;
	}
	
}
