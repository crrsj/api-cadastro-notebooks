package br.com.notebook.controle;

import java.util.List;
import java.util.Map;

import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.notebook.dto.AtualizarNote;
import br.com.notebook.dto.BuscarNotebook;
import br.com.notebook.dto.SalvarNotebook;
import br.com.notebook.servico.NotebookServico;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/notebook")
@RequiredArgsConstructor
public class NotebookControle {
	
	private final ModelMapper modelMapper;
	private final NotebookServico notebookServico;
	
	
	@PostMapping
	@Operation(summary = "Endpoint responsável por cadastrar notebooks.") 
    @ApiResponse(responseCode = "201",description = " sucesso",content = {
   	@Content(mediaType = "application.json",schema = @Schema(implementation = ResponseEntity.class))
    })           
	public ResponseEntity<SalvarNotebook>salvarNotebookks(@RequestBody  SalvarNotebook salvarNotebook){
		var salvar = notebookServico.salvarNotebook(salvarNotebook);
		var uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(salvar.getId()).toUri();
		return ResponseEntity.created(uri).body(modelMapper.map(salvar, SalvarNotebook.class));
	}

	@PatchMapping("/{id}")	
	@Operation(summary = "Endpoint responsável por atualizar notebook.") 
    @ApiResponse(responseCode = "200",description = " sucesso",content = {
   	@Content(mediaType = "application.json",schema = @Schema(implementation = ResponseEntity.class))
    })           
	public ResponseEntity<AtualizarNote>atualizarNotebook(@PathVariable Long id,@RequestBody Map<String, Object> atualizar){
		var atualizando = notebookServico.atualizarNotebook(id, atualizar);
		return ResponseEntity.ok().body(modelMapper.map(atualizando, AtualizarNote.class));
	}
	
	
	@GetMapping
	@PostMapping
	@Operation(summary = "Endpoint responsável por buscar notebooks.") 
    @ApiResponse(responseCode = "200",description = " sucesso",content = {
   	@Content(mediaType = "application.json",schema = @Schema(implementation = ResponseEntity.class))
    })           
	public ResponseEntity<List<BuscarNotebook>>liatarTodos(){
		var listar = notebookServico.listarTodos();
		return ResponseEntity.ok().body(listar);
	}
	
	
	@GetMapping("/{id}")
	@PostMapping
	@Operation(summary = "Endpoint responsável por buscar notebook pelo id.") 
    @ApiResponse(responseCode = "200",description = " sucesso",content = {
   	@Content(mediaType = "application.json",schema = @Schema(implementation = ResponseEntity.class))
    })           
	public ResponseEntity<BuscarNotebook>buscarPorId(@PathVariable Long id){
		var buscar = notebookServico.buscarPorId(id);
		return ResponseEntity.ok().body(modelMapper.map(buscar, BuscarNotebook.class));
	}
	
	@DeleteMapping("/{id}")	
	@Operation(summary = "Endpoint responsável por excluir notebooks pelo id.") 
    @ApiResponse(responseCode = "204",description = " sucesso",content = {
   	@Content(mediaType = "application.json",schema = @Schema(implementation = ResponseEntity.class))
    })           
	public ResponseEntity<Void>excluirNotebook(@PathVariable Long id){
		notebookServico. excluirNotebook(id);
		return ResponseEntity.noContent().build();
	}
}
