package br.com.notebook.dto;

import br.com.notebook.enums.Marca;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AtualizarNote {

	private Long id;
	@NotBlank(message  = "não pode estar em branco")
	private Marca marca;
	@NotBlank(message  = "não pode estar em branco")
	private String modelo;
	@NotBlank(message  = "não pode estar em branco")
	private String memoria;
	@NotBlank(message  = "não pode estar em branco")
	private String ssd;
	private Double total;
}
