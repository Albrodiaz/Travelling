package es.travelworld.travelling.repository.response.login;

import com.google.gson.annotations.SerializedName;

public class ResponseLogin{

	@SerializedName("userToken")
	private String userToken;

	@SerializedName("genero")
	private int genero;

	@SerializedName("idBdReference")
	private int idBdReference;

	@SerializedName("nombre")
	private String nombre;

	@SerializedName("edad")
	private int edad;

	public String getUserToken(){
		return userToken;
	}

	public int getGenero(){
		return genero;
	}

	public int getIdBdReference(){
		return idBdReference;
	}

	public String getNombre(){
		return nombre;
	}

	public int getEdad(){
		return edad;
	}
}