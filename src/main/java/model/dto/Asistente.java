package model.dto;

public class Asistente {
	private int capacitacionId;
	private int usuarioId;
	
	public Asistente() {
		super();
	}

	public Asistente(int capacitacionId, int usuarioId) {
		super();
		this.capacitacionId = capacitacionId;
		this.usuarioId = usuarioId;
	}

	public int getCapacitacionId() {
		return capacitacionId;
	}

	public void setCapacitacionId(int capacitacionId) {
		this.capacitacionId = capacitacionId;
	}

	public int getUsuarioId() {
		return usuarioId;
	}

	public void setUsuarioId(int usuarioId) {
		this.usuarioId = usuarioId;
	}

	@Override
	public String toString() {
		return "Asistente [capacitacionId=" + capacitacionId + ", usuarioId=" + usuarioId + "]";
	}
	
}
