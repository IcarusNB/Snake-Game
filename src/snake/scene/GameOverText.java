package snake.scene;

import snake.graphics.Text;
import snake.util.Constants;

public class GameOverText extends Text {

	public GameOverText(int score) {
		super(String.format(Constants.GAME_OVER_TEXT, score), Constants.GAME_OVER_LOCATION, Constants.GAME_OVER_COLOR);
	}
}
