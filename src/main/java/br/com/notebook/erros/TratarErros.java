package br.com.notebook.erros;

import java.util.NoSuchElementException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import br.com.notebook.dto.MensagensDeErros;
import br.com.notebook.dto.ValidandoCampos;

@ControllerAdvice
public class TratarErros {
	
	@ExceptionHandler(NoSuchElementException.class)
	public ResponseEntity<MensagensDeErros>idNaoEncontrado(){
		var erros = new MensagensDeErros(HttpStatus.NOT_FOUND, "Objeto não existe !");
		return new ResponseEntity<>(erros, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<?>validarCampos(MethodArgumentNotValidException ex){
		var erros = ex.getFieldErrors();
		return ResponseEntity.badRequest()
				.body(erros.stream()
				.map(ValidandoCampos::new)
				.toList());
    
	}			
				
}
