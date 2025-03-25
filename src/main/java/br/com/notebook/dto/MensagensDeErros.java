package br.com.notebook.dto;

import org.springframework.http.HttpStatus;

public record MensagensDeErros(HttpStatus status, String mensagem) {

}
