package br.com.notebook.dto;

import br.com.notebook.enums.Marca;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AtualizarNote {

	private Long id;
	private Marca marca;	
	private String modelo;
	private String memoria;
	private String ssd;
	private Double total;
}
