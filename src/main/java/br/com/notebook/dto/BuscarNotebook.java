package br.com.notebook.dto;

import br.com.notebook.enums.Marca;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class BuscarNotebook {
	private Long id;
	private Marca marca;	
	private String modelo;
	private String processador;
	private String memoria;
	private String ssd;
	private Integer estoque;
	private Double total;
}
