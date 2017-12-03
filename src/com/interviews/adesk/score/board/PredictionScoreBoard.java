package com.interviews.adesk.score.board;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import com.interviews.adesk.score.board.entity.ScoreEntity;

/**
 * Prediction score board.
 * 
 * @author Ranjith
 */
public class PredictionScoreBoard {

	private ScoreBoard scoreBoard;

	private Map<Double, ScoreEntity> cache;

	public PredictionScoreBoard(ScoreBoard scoreBoard) {
		this.scoreBoard = scoreBoard;
		this.cache = new HashMap<>();
	}

	/**
	 * method to predict the score for over
	 * 
	 * @param predictOver
	 * @return
	 */
	public ScoreEntity predictScore(Double predictOver) {

		if (cache.containsKey(predictOver)) {
			return cache.get(predictOver);
		}

		ScoreEntity[] scoreInfo = this.scoreBoard.getScoreInfo();
		Double over = scoreInfo[scoreInfo.length - 1].getOver();

		int top = scoreBoard.index(over);
		while (over < predictOver) {

			// increasing the array size dynamically
			if (top + 1 >= scoreInfo.length) {
				int newSize = scoreInfo.length * 2;
				ScoreEntity[] temp = new ScoreEntity[newSize];
				System.arraycopy(scoreInfo, 0, temp, 0, scoreInfo.length);
				scoreInfo = temp;
			}

			ScoreEntity entity = getScore(over, scoreInfo, top);
			scoreInfo[scoreBoard.index(entity.getOver())] = entity;
			over = entity.getOver();
			top = top + 1;

			cache.put(over, entity);
		}

		return scoreInfo[scoreBoard.index(over)];
	}

	/**
	 * method helps to predict the score for input over
	 * 
	 * @param over
	 * @param entities
	 * @param top
	 * @return
	 */
	private ScoreEntity getScore(Double over, ScoreEntity[] entities, int top) {

		Double next = null;
		if (Math.round((over - Math.floor(over)) * 10) < 6) {
			next = over + 0.1;
		} else {
			next = over.longValue() + 1.1;
		}

		NumberFormat formatter = new DecimalFormat("#0.0");
		next = Double.parseDouble(formatter.format(next));

		int index = new Random().nextInt(top);
		int score = entities[index].getbScore();

		ScoreEntity entity = new ScoreEntity(next, score, entities[scoreBoard.index(over)].getWicket(),
				entities[scoreBoard.index(over)].getScore());
		return entity;

	}

}