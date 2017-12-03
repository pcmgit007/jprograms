package com.interviews.adesk.score.board;

import java.util.Arrays;

import com.interviews.adesk.score.board.entity.ScoreEntity;

/**
 * Score board implementation
 * 
 * @author Ranjith
 */
public class ScoreBoard {

	private int size;
	private int top;

	private Double lastOver;
	private ScoreEntity[] scoreInfo;

	public ScoreBoard() {
		this.top = -1;
		this.size = 10;
		this.scoreInfo = new ScoreEntity[this.size];
	}

	/**
	 * method to add score values
	 * 
	 * @param over
	 * @param score
	 * @param wicket
	 */
	public void addScore(double over, int score, int wicket) {
		top = top + 1;

		// increasing the array size dynamically
		if (this.top >= this.size) {
			int newSize = ((scoreInfo.length / size) + 1) * size;
			ScoreEntity[] temp = new ScoreEntity[newSize];
			System.arraycopy(scoreInfo, 0, temp, 0, top);
			scoreInfo = temp;
		}

		int lastScore = (top - 1 < 0) ? 0 : scoreInfo[top - 1].getScore();
		ScoreEntity entity = new ScoreEntity(over, score, wicket, lastScore);
		scoreInfo[index(over)] = entity;
		lastOver = over;
	}

	/**
	 * method to get score informations
	 * 
	 * @return
	 */
	public ScoreEntity[] getScoreInfo() {
		return Arrays.copyOfRange(scoreInfo, 0, top + 1);
	}

	/**
	 * method to get score information for specific over
	 * 
	 * @param over
	 * @return
	 */
	public ScoreEntity getScoreInfo(double over) {
		int index = index(over);
		return (index < top) ? scoreInfo[index] : null;
	}

	/**
	 * method to get live score
	 * 
	 * @return
	 */
	public ScoreEntity getLiveScore() {
		return (lastOver != null) ? scoreInfo[index(lastOver)] : null;
	}

	/**
	 * method to calculate index value for storing score details in-memory
	 * 
	 * @param over
	 * @return
	 */
	public int index(Double over) {
		Long n1 = Math.round((over - Math.floor(over)) * 10);
		Long n2 = over.longValue();
		Long n3 = (6 * (n2 - 1)) + n1;
		return n3.intValue() - 1;
	}
}