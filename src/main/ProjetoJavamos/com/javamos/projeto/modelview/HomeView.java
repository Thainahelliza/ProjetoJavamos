package com.javamos.projeto.modelview;

import java.util.ArrayList;
import java.util.List;

public class HomeView {
	public String getApresents () {
		return "Bem-vindo a nossa API";
	}
	
	public List<String> getEndpoints(){
		var lista = new ArrayList<String>();
		lista.add("/contas");
		lista.add("/conta/1");
		lista.add("/conta/2");
		lista.add("/conta/3");
		lista.add("/conta/4");
		lista.add("/conta/5");
		lista.add("/conta/6");
		lista.add("/conta/7");
						
		lista.add("");
		
		lista.add("/clientes");
		lista.add("/clientes/1");
		lista.add("/clientes/2");
		lista.add("/clientes/3");
		
		return lista;
		
	}
}
