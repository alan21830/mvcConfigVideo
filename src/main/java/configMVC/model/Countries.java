package configMVC.model;

public class Countries {

	@Override
	public String toString() {
		return "Countries [id=" + id + ", country=" + country + ", cases=" + cases + ", todayCases=" + todayCases
				+ ", deaths=" + deaths + ", todayDeaths=" + todayDeaths + ", recovered=" + recovered + ", active="
				+ active + ", critical=" + critical + "]";
	}

	public String id;
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String country;
	public int cases,todayCases,deaths,todayDeaths,recovered,active,critical;

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public int getCases() {
		return cases;
	}

	public void setCases(int cases) {
		this.cases = cases;
	}

	public int getTodayCases() {
		return todayCases;
	}

	public void setTodayCases(int todayCases) {
		this.todayCases = todayCases;
	}

	public int getDeaths() {
		return deaths;
	}

	public void setDeaths(int deaths) {
		this.deaths = deaths;
	}

	public int getTodayDeaths() {
		return todayDeaths;
	}

	public void setTodayDeaths(int todayDeaths) {
		this.todayDeaths = todayDeaths;
	}

	public int getRecovered() {
		return recovered;
	}

	public void setRecovered(int recovered) {
		this.recovered = recovered;
	}

	public int getActive() {
		return active;
	}

	public void setActive(int active) {
		this.active = active;
	}

	public int getCritical() {
		return critical;
	}

	public void setCritical(int critical) {
		this.critical = critical;
	}

	 
	
}
