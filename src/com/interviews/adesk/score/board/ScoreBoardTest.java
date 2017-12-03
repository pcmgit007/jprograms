package com.interviews.adesk.score.board;

/**
 * Score board test
 * 
 * @author Ranjith
 */
public class ScoreBoardTest {

	public static void main(String[] args) {

		// creating score board instance
		ScoreBoard scoreBoard = new ScoreBoard();

		// adding score for 1st over
		scoreBoard.addScore(1.1, 4, 0);
		scoreBoard.addScore(1.2, 1, 0);
		scoreBoard.addScore(1.3, 0, 0);
		scoreBoard.addScore(1.4, 2, 0);
		scoreBoard.addScore(1.5, 1, 0);
		scoreBoard.addScore(1.6, 6, 0);

		// creating prediction score board instance
		PredictionScoreBoard predictor = new PredictionScoreBoard(scoreBoard);

		// predicting over 2.3 score
		System.out.println(predictor.predictScore(2.3));

		// predicting over 2.1 score (already we've a score till over 2.3. so the value of 2.1 will be returned from cache)
		System.out.println(predictor.predictScore(2.1));

	}

}