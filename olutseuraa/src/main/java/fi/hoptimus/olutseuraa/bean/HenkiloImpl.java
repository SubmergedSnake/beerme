package fi.hoptimus.olutseuraa.bean;

public class HenkiloImpl implements Henkilo {

	private int id;
	private String etunimi;
	private String sukunimi;
	private String sahkoposti;
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEtunimi() {
		return etunimi;
	}

	public void setEtunimi(String etunimi) {
		this.etunimi = etunimi;
	}

	public String getSukunimi() {
		return sukunimi;
	}

	public void setSukunimi(String sukunimi) {
		this.sukunimi = sukunimi;
	}

	public String getSahkoposti() {
		return sahkoposti;
	}

	public void setSahkoposti(String sahkoposti) {
		this.sahkoposti = sahkoposti;
	}

	@Override
	public String toString() {
		return etunimi + " " + sukunimi ;
	}
	
	

}