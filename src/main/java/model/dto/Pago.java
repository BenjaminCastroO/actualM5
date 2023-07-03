package model.dto;

import java.util.Date;

public class Pago {
	private int id;
	private int clienteId;
	private double monto;
	private Date fechaPago;
	
	public Pago() {}
	
	public Pago(int id, int clienteId, double monto, Date fechaPago) {
		super();
		this.id = id;
		this.clienteId = clienteId;
		this.monto = monto;
		this.fechaPago = fechaPago;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getClienteId() {
		return clienteId;
	}

	public void setClienteId(int clienteId) {
		this.clienteId = clienteId;
	}

	public double getMonto() {
		return monto;
	}

	public void setMonto(double monto) {
		this.monto = monto;
	}

	public Date getFechaPago() {
		return fechaPago;
	}

	public void setFechaPago(Date fechaPago) {
		this.fechaPago = fechaPago;
	}

	@Override
	public String toString() {
		return "Pago [id=" + id + ", clienteId=" + clienteId + ", monto=" + monto + ", fechaPago=" + fechaPago + "]";
	}
	
}
