package entities.dao;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import entities.Livro;

public class LivroDao {
    private List<Livro> livros = new ArrayList<>();

    public void cadastrar(Livro livro){
        livros.add(livro);
    }

    public Livro buscarLivroPorMatricula(String matricula){
        for (Livro livro : livros) {
            if(livro.getMatricula().equals(matricula)){
                return livro;
            }
        }
        return null;
    }

    public void atualizarLivro(String matricula, String titulo, String genero, String autor, Integer anoPublicacao, Integer numPaginas, Boolean edicaoUnica, String sinopse){
        Livro livro = buscarLivroPorMatricula(matricula);
        livro.setTitulo(titulo);
        livro.setGenero(genero);
        livro.setAutor(autor);
        livro.setAnoPublicacao(anoPublicacao);
        livro.setNumPaginas(numPaginas);
        livro.setEdicaoUnica(edicaoUnica);
    }

    public void listar(){
        if (livros.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Nenhum livro cadastrado: ");
        }else{
            for (Livro livro : livros) {
                JOptionPane.showMessageDialog(null, "Matricula: " + livro.getMatricula() + "| Titulo: " + livro.getTitulo());
            }
        }
    }

    public void deletar(String matricula){
        Livro livroDeletar = buscarLivroPorMatricula(matricula);
        if (livroDeletar == null) {
            JOptionPane.showMessageDialog(null, "Livro não encontrado!");
        }else{
            livros.remove(livroDeletar);
            JOptionPane.showMessageDialog(null, "Livro deletado com sucesso!");
        }
    }

}
