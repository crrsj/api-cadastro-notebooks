package br.com.notebook.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.notebook.entidade.Notebook;

public interface NotebookRepositorio extends JpaRepository<Notebook, Long> {

}
