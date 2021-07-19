package com.javamos.projeto.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="tbcliente")
public class Cliente {

		@Id
		@GeneratedValue(strategy=GenerationType.IDENTITY)
		@Column(name="codcliente")
		private int codigo;
		
		@Column(name="nome")
		private String nome;
		
		@Column(name="cpf")
		private String cpf;
		
		@Column(name="email")
		private String email;
		
		@Column(name="telefone")
		private String telefone;
		
		
		@OneToMany(targetEntity=Conta.class, mappedBy="cliente",cascade=CascadeType.ALL, fetch = FetchType.LAZY)
		private List<Conta> contas;
		
				
		public List<Conta> getContas() {
			return this.contas;
		}
		
		public int getCodigo() {
			return codigo;
		}

		public void setCodigo(int codigo) {
			this.codigo = codigo;
		}

		public String getNome() {
			return nome;
		}

		public void setNome(String nome) {
			this.nome = nome;
		}

		public String getCpf() {
			return cpf;
		}

		public void setCpf(String cpf) {
			this.cpf = cpf;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public String getTelefone() {
			return telefone;
		}

		public void setTelefone(String telefone) {
			this.telefone = telefone;
		}
		
}
