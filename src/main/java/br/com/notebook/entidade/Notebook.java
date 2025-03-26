package br.com.notebook.entidade;

import br.com.notebook.enums.Marca;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "tb_notebooks")
@Data
public class Notebook {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Enumerated(EnumType.STRING)
	private Marca marca;	
	private String modelo;
	private String processador;
	private String memoria;
	private String ssd;
	private Integer estoque;
	private Double total;
}
