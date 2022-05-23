package com.desafiolatam.models;


import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="direcciones")
public class Direccion {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	private String calle;
	
	@NotNull
	private String numero;
	
	@NotNull
	private String ciudad;
	
	@NotNull
	private String tipoDireccionEnum;
	
	@OneToOne(mappedBy="direccion",cascade=CascadeType.ALL, fetch= FetchType.LAZY)
	private Alumno alumno;
	
	public Direccion() {
		super();
	}

	public Direccion(String calle, String numero, String ciudad, String tipoDireccionEnum) {
		super();
		this.calle = calle;
		this.numero = numero;
		this.ciudad = ciudad;
		this.tipoDireccionEnum = tipoDireccionEnum;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCalle() {
		return calle;
	}

	public void setCalle(String calle) {
		this.calle = calle;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public String getTipoDireccionEnum() {
		return tipoDireccionEnum;
	}

	public void setTipoDireccionEnum(String tipoDireccionEnum) {
		this.tipoDireccionEnum = tipoDireccionEnum;
	}

	public Alumno getAlumno() {
		return alumno;
	}

	public void setAlumno(Alumno alumno) {
		this.alumno = alumno;
	}
	
	
	
}
