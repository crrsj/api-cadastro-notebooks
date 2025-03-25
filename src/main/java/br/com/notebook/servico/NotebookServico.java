package br.com.notebook.servico;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;
import org.springframework.web.bind.annotation.PathVariable;

import br.com.notebook.dto.AtualizarNote;
import br.com.notebook.dto.BuscarNotebook;
import br.com.notebook.dto.SalvarNotebook;
import br.com.notebook.entidade.Notebook;
import br.com.notebook.repositorio.NotebookRepositorio;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class NotebookServico {
	
	private final ModelMapper modelMapper;
	
	private final NotebookRepositorio notebookRepositorio;
	
	public Notebook salvarNotebook(SalvarNotebook salvarNote) {
		return notebookRepositorio.save(modelMapper.map(salvarNote, Notebook.class));
	}
	
	public List<BuscarNotebook>listarTodos(){
		return notebookRepositorio.findAll()
				.stream().map(listar -> 
				 modelMapper.map(listar, BuscarNotebook.class))
				.collect(Collectors.toList());
	}

	public Notebook buscarPorId(Long id) {
		Optional<Notebook>buscar = notebookRepositorio.findById(id);
		return buscar.orElseThrow();
	}
	
	@Transactional
	public AtualizarNote atualizarNotebook(Long id,Map<String, Object>atualizarNote)  {
		var atualizar = notebookRepositorio.findById(id).orElseThrow();
		  atualizarNote.forEach((campo, valor) -> {
	            Field field = ReflectionUtils.findField(Notebook.class, campo);
	            if (field != null) {
	                field.setAccessible(true);
	                ReflectionUtils.setField(field, atualizar, valor);
	            }
	        });

	     notebookRepositorio.save(atualizar);
	     return modelMapper.map(atualizarNote, AtualizarNote.class);
	        
	    }

      public void excluirNotebook(@PathVariable Long id) {
    	  buscarPorId(id);
	   notebookRepositorio.deleteById(id);
   }
      
      public Notebook atualizarNotebooks(AtualizarNote notebook) {
    	  return notebookRepositorio.save(modelMapper.map(notebook, Notebook.class));
      }
	
}
