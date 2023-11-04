package com.backend.app.store.models;

public class Store {
	
	private Laptop lap;
	
	private Integer cantidad;

	public Store() {
		
	}
	
	public Store(Laptop lap, Integer cantidad) {
		super();
		this.lap = lap;
		this.cantidad = cantidad;
	}

	public Laptop getLap() {
		return lap;
	}

	public void setLap(Laptop lap) {
		this.lap = lap;
	}

	public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}
	
	
}
