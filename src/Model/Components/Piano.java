package Model.Components;

public class Piano {
	
	int id_piano;
	int numero_corridoi;
	int numero_stanze;
	int edificio;
	
	public int getEdificio() {
		return edificio;
	}
	public void setEdificio(int edificio) {
		edificio = edificio;
	}
	public int getId_piano() {
		return id_piano;
	}
	public void setId_piano(int id_piano) {
		this.id_piano = id_piano;
	}
	public int getNumero_corridoi() {
		return numero_corridoi;
	}
	public void setNumero_corridoi(int numero_corridoi) {
		this.numero_corridoi = numero_corridoi;
	}
	public int getNumero_stanze() {
		return numero_stanze;
	}
	public void setNumero_stanze(int numero_stanze) {
		this.numero_stanze = numero_stanze;
	}

}
