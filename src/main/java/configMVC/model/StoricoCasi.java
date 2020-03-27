package configMVC.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "STORICO_CASI_OGGI")
public class StoricoCasi {

	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int id;

	@Column(name = "CASI")
	public int casiOggi;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "DATA")
	public Date data;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCasiOggi() {
		return casiOggi;
	}

	public void setCasiOggi(int casiOggi) {
		this.casiOggi = casiOggi;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

}
