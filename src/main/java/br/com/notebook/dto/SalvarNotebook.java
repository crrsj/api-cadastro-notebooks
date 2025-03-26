package br.com.notebook.dto;

import br.com.notebook.enums.Marca;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class SalvarNotebook {

	
	private Marca marca;	
	@NotBlank(message  = "não pode estar em branco")
	private String modelo;
	@NotBlank(message  = "não pode estar em branco")
	private String processador;
	@NotBlank(message  = "não pode estar em branco")
	private String memoria;
	@NotBlank(message  = "não pode estar em branco")
	private String ssd;
	@NotNull(message = "Não pode ser nulo")
	private Integer estoque;
	private Double total;
}
