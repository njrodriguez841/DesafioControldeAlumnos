package com.desafiolatam.models;

public class TipoDireccionEnum {

	public enum TipoDireccion {

	Casa("Casa"), Trabajo("Trabajo"), Otro("Otro");

	TipoDireccion(String value){
		this.value=value;
	}

		public String value;
		@Override
		public String toString() {
			return value;
		}

	}
}