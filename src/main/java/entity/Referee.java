package entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="referee")
public class Referee {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int refefreeId;
	@Column(name="refereename", nullable = false)
	private String refereeName;
	@Column(name="noofmatches", nullable = false)
	private int noOfMatches;
	public int getRefefreeId() {
		return refefreeId;
	}
	public void setRefefreeId(int refefreeId) {
		this.refefreeId = refefreeId;
	}
	public String getRefereeName() {
		return refereeName;
	}
	public void setRefereeName(String refereeName) {
		this.refereeName = refereeName;
	}
	public int getNoOfMatches() {
		return noOfMatches;
	}
	public void setNoOfMatches(int noOfMatches) {
		this.noOfMatches = noOfMatches;
	}
	
	

}
