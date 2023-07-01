package model.dto;
// java usuario
public class Usuario {
	
	private int id;
	private String name;
	private String tipo;
	
	public Usuario() {
		super();
	}

	public Usuario(int id, String name, String tipo) {
		super();
		this.id = id;
		this.name = name;
		this.tipo = tipo;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}


}
