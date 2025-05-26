package entities;


public class Livro {
    private String matricula; 
    private String titulo; 
    private String genero; 
    private String autor; 
    private String sinopse; 
    private Integer anoPublicacao; 
    private Integer numPaginas; 
    private Boolean edicaoUnica; 

    public Livro(String matricula, String titulo, String genero, String autor, Integer anoPublicacao, Integer numPaginas, Boolean edicaoUnica, String sinopse) {
        this.matricula = matricula;
        this.titulo = titulo;
        this.genero = genero;
        this.autor = autor;
        this.anoPublicacao = anoPublicacao;
        this.numPaginas = numPaginas;
        this.sinopse = sinopse;
        this.edicaoUnica = edicaoUnica;
    }
    
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public Integer getAnoPublicacao() {
        return anoPublicacao;
    }

    public void setAnoPublicacao(Integer anoPublicacao) {
        this.anoPublicacao = anoPublicacao;
    }

    public Integer getNumPaginas() {
        return numPaginas;
    }

    public void setNumPaginas(Integer numPaginas) {
        this.numPaginas = numPaginas;
    }

    public String getEditora() {
        return sinopse;
    }

    public void setEditora(String sinopse) {
        this.sinopse = sinopse;
    }

    public Boolean getEdicaoUnica() {
        return edicaoUnica;
    }

    public void setEdicaoUnica(Boolean edicaoUnica) {
        this.edicaoUnica = edicaoUnica;
    }


    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getSinopse() {
        return sinopse;
    }

    public void setSinopse(String sinopse) {
        this.sinopse = sinopse;
    }
    

    

}
