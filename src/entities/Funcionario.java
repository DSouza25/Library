package entities;
public class Funcionario {
    

    private String nome;
    private Integer DatadeNasc;
    private String cargo;
    private Integer matricula;
    private String email;
    private String senha;
    private String sexo;

    public Funcionario(String nome, Integer idade, String cargo, Integer matricula, String email, String senha, String sexo) {
        this.nome = nome;
        this.DatadeNasc = idade;
        this.cargo = cargo;
        this.matricula = matricula;
        this.email = email;
        this.senha = senha;
        this.sexo = sexo;

    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getIdade() {
        return DatadeNasc;
    }

    public void setIdade(Integer idade) {
        this.DatadeNasc = idade;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public Integer getMatricula() {
        return matricula;
    }

    public void setMatricula(Integer matricula) {
        this.matricula = matricula;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    @Override
    public String toString() {
        return "Funcionario \n[Nome=" + nome + ", \nMatricula=" + matricula
                + ", \nNascimento=" + DatadeNasc + ", \nSexo=" + sexo + ", \nCargo=" + cargo
                + ", \nEmail=" + email + ", \nSenha=" + senha + "]";
    }

   

    


}