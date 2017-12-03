package com.interviews.adesk.score.board.entity;

/**
 * Score info entity
 * 
 * @author Ranjith
 */
public class ScoreEntity {

	/** total score ex: 50 */
	private int score;

	/** score ex: 1/2/4/6 */
	private int bScore;

	/** wicket */
	private int wicket;

	/** over ex: 1.1 */
	private double over;

	public ScoreEntity(double over, int score, int wicket, int lastScore) {
		this.setOver(over);
		this.setWicket(wicket);

		this.setbScore(score);
		this.setScore(score + lastScore);

	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public int getbScore() {
		return bScore;
	}

	public void setbScore(int bScore) {
		this.bScore = bScore;
	}

	public int getWicket() {
		return wicket;
	}

	public void setWicket(int wicket) {
		this.wicket = wicket;
	}

	public double getOver() {
		return over;
	}

	public void setOver(double over) {
		this.over = over;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(over);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ScoreEntity other = (ScoreEntity) obj;
		if (Double.doubleToLongBits(over) != Double.doubleToLongBits(other.over))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ScoreEntity [over=" + over + ", score=" + score + ", bScore=" + bScore + ", wicket=" + wicket + "]";
	}

}