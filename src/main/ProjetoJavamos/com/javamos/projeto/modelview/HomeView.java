package com.javamos.projeto.modelview;

import java.util.ArrayList;
import java.util.List;

public class HomeView {
	public String getMensagem () {
		return "Bem vindo";
	}
	
	public List<String> getEndpoints(){
		var lista = new ArrayList<String>();
		lista.add("/contas");
		lista.add("/contas/{id}");
		
		lista.add("/cliente");
		lista.add("/cliente/{id}");
		
		return lista;
		
	}
}
