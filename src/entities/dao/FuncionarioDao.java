package entities.dao;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import entities.Funcionario;

public class FuncionarioDao {
		
		ArrayList<Funcionario> lista = new ArrayList<Funcionario>(); //lista para armazenar objetos Funcionario
		Funcionario fun; //variável auxiliar para manipulação de objetos Funcionario
		
		public void salvar(Funcionario f) {
			// Adiciona o objeto Funcionario na lista de funcionários
			lista.add(f);
		}
		
		public void listar() { 
			// Percorre a lista de funcionários e exibe cada um usando o método toString()
			for(Funcionario f: lista)  {
				JOptionPane.showMessageDialog(null, f); // Exibe os dados do funcionário
			}
		}
		
		public Funcionario pesquisar(int cod) { 
		    // Percorre a lista de funcionários procurando por um com a matrícula igual ao código informado
		    for (Funcionario funcionario : lista) { 
		        if (funcionario.getMatricula() == cod) {
		            return funcionario; // Retorna o funcionário encontrado
		        }
		    }
		    return null; // Retorna null caso não encontre nenhum funcionário com a matrícula informada
		}

		
		public void alterar(int cod, Funcionario f) { 
			// Altera o funcionário na posição (matrícula - 1) da lista pelo novo objeto passado
			cod--;
			lista.set(cod, f); 
		}
		
		public void excluir(int cod) {
			// Remove o funcionário com a matrícula informada da lista
			fun = pesquisar(cod);
			lista.remove(fun);
		}
		
		public Integer retornaTamanhoLista(){
			// Retorna o tamanho atual da lista de funcionários
			return lista.size();
		}
}