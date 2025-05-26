package screens;

import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.UUID;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import entities.Livro;
import entities.dao.LivroDao;
import resources.Cores;

public class TelaLivro implements ActionListener{
    Cores cor = new Cores();
    JFrame janela = new JFrame("Livros");
    JPanel painel = new JPanel();

    Boolean atualizar = false;
    String matriculaLivro;
    LivroDao livroDao = new LivroDao();

    JLabel lblMatricula = new JLabel("Matrícula:");
    JTextField txtMatricula = new JTextField("Sua matrícula aparecerá aqui assim que o livro for cadastrado.");

    JLabel lblTitulo = new JLabel("Título:");
    JTextField txtTitulo = new JTextField("");

    String[] generos = {"Selecione um gênero","Romance","Ficção Científica","Fantasia","Terror","Suspense","Mistério","Aventura","Drama","Comédia","Biografia","Histórico","Distopia","Poesia","Ensaios","Crônicas","Contos","Literatura Infantil","Literatura Juvenil","Erótico","Autoajuda"};
    JLabel lblGenero = new JLabel("Gênero: ");
    JComboBox<String> menuGenero = new JComboBox<>(generos);
    
    JLabel lblEdicao = new JLabel("Edição única? ");
    JCheckBox checkBoxSim = new JCheckBox("Sim");
    JCheckBox checkBoxNao = new JCheckBox("Não");

    JLabel lblSinopse = new JLabel("Sinopse: ");
    JTextArea sinopse = new JTextArea();

    JLabel lblAutor = new JLabel("Autor: ");
    JTextField txtAutor = new JTextField();

    JLabel lblEditora = new JLabel("Editora: ");
    JTextField txtEditora = new JTextField();

    JLabel lblAnoPublicacao = new JLabel("Ano de publicação:");
    JTextField txtAnoPublicacao = new JTextField();

    JLabel lblNumPaginas = new JLabel("Número de páginas: ");
    JTextField txtNumPaginas = new JTextField();

    JButton btnCadastrar = new JButton("Cadastrar");
    JButton btnListar = new JButton("Listar");
    JButton btnAtualizar = new JButton("Alterar");
    JButton btnDeletar = new JButton("Deletar");

    public void estilizarLabel(JLabel label){
        label.setForeground(cor.getBranco());
        label.setFont(new Font("Candara", Font.CENTER_BASELINE, 17));
    }
    public void estilizarButton(JButton button){
        button.setBackground(cor.getVerdeClaro());
        button.setForeground(cor.getBranco());
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));
        button.setFocusPainted(false);
    }
    public void abrirTela(){
    // ------- customização de componentes -------
        
        lblMatricula.setBounds(40, 20, 100, 30);
        estilizarLabel(lblMatricula);
        txtMatricula.setBounds(40, 45, 410, 30);
        txtMatricula.setBorder(new EmptyBorder(5,5,5,5));
        txtMatricula.setEnabled(false);

        lblTitulo.setBounds(40, 80, 100, 30);
        estilizarLabel(lblTitulo);
        txtTitulo.setBounds(40, 105, 410, 30);
        txtTitulo.setBorder(new EmptyBorder(5,5,5,5));

        lblAutor.setBounds(40, 145, 100, 30);
        estilizarLabel(lblAutor);
        txtAutor.setBounds(40, 170, 410, 30);
        txtAutor.setBorder(new EmptyBorder(5,5,5,5));

        lblGenero.setBounds(40, 220, 100, 30);
        estilizarLabel(lblGenero);
        menuGenero.setBounds(40, 243, 155, 30);
        menuGenero.setBorder(new LineBorder(cor.getVerdeClaro(), 3));
        menuGenero.setBackground(cor.getBranco());
        menuGenero.setCursor(new Cursor(Cursor.HAND_CURSOR));

        lblEdicao.setBounds(265,220, 100, 35);
        estilizarLabel(lblEdicao);

        checkBoxSim.setBounds(263, 246, 50, 30);
        checkBoxSim.setBackground(cor.getVerdeEscuro());
        checkBoxSim.setForeground(cor.getBranco());
        checkBoxSim.setFocusPainted(false);
        checkBoxSim.addActionListener(this);
        checkBoxSim.setCursor(new Cursor(Cursor.HAND_CURSOR));

        checkBoxNao.setBounds(336, 246, 60, 30);
        checkBoxNao.setBackground(cor.getVerdeEscuro());
        checkBoxNao.setForeground(cor.getBranco());
        checkBoxNao.setFocusPainted(false);
        checkBoxNao.addActionListener(this);
        checkBoxNao.setCursor(new Cursor(Cursor.HAND_CURSOR));

        lblAnoPublicacao.setBounds(40, 300, 180, 30);
        estilizarLabel(lblAnoPublicacao);
        txtAnoPublicacao.setBounds(40, 325, 180, 30);
        txtAnoPublicacao.setBorder(new EmptyBorder(5,5,5,5));
        
        lblNumPaginas.setBounds(265, 300, 180, 30);
        estilizarLabel(lblNumPaginas);
        txtNumPaginas.setBounds(265, 325, 180, 30);
        txtNumPaginas.setBorder(new EmptyBorder(5,5,5,5));
        
        lblSinopse.setBounds(40, 360, 180, 30);
        estilizarLabel(lblSinopse);
        
        sinopse.setBounds(40, 385, 405, 100);
        sinopse.setBorder(new EmptyBorder(5,5,5,5));
        sinopse.setLineWrap(true);

        btnCadastrar.setBounds(40, 500, 95, 50);
        estilizarButton(btnCadastrar);
        btnCadastrar.addActionListener(this);
        btnListar.setBounds(143, 500, 95, 50);
        btnListar.addActionListener(this);
        estilizarButton(btnListar);
        btnAtualizar.setBounds(247, 500, 95, 50);
        btnAtualizar.addActionListener(this);
        estilizarButton(btnAtualizar);
        btnDeletar.setBounds(350, 500, 95, 50);
        btnDeletar.addActionListener(this);
        estilizarButton(btnDeletar);

    // ------------- adição à janela -------------
        janela.add(lblMatricula);
        janela.add(txtMatricula);
        janela.add(lblTitulo);
        janela.add(txtTitulo);
        janela.add(lblGenero);
        janela.add(menuGenero);
        janela.add(lblEdicao);
        janela.add(checkBoxSim);
        janela.add(checkBoxNao);
        janela.add(lblAutor);
        janela.add(txtAutor);
        janela.add(lblAnoPublicacao);
        janela.add(txtAnoPublicacao);
        janela.add(lblNumPaginas);
        janela.add(txtNumPaginas);
        janela.add(lblSinopse);
        janela.add(sinopse);
        janela.add(btnCadastrar);
        janela.add(btnListar);
        janela.add(btnAtualizar);
        janela.add(btnDeletar);
        
    // ------ customização da janela e painel ------
    
        painel.setBackground(cor.getVerdeEscuro());
        janela.add(painel);
        painel.setLayout(null);
        janela.setSize(500,630);
        janela.setVisible(true);
        janela.setResizable(false);
        janela.setLocationRelativeTo(null);
        janela.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == checkBoxNao) {
            checkBoxSim.setSelected(false);
            checkBoxNao.setSelected(true);
        }
        if (e.getSource() == checkBoxSim) {
            checkBoxSim.setSelected(true);
            checkBoxNao.setSelected(false);
        }
        if (e.getSource() == btnCadastrar){
            
            String titulo = txtTitulo.getText();
            String autor = txtAutor.getText();
            String genero = String.valueOf(menuGenero.getSelectedItem());
            Boolean edicaoUnica = checkBoxSim.isSelected();
            Integer numeroPaginas = Integer.parseInt(txtNumPaginas.getText().isEmpty()?"0":txtNumPaginas.getText());
            Integer anoPublicacao = Integer.parseInt(txtAnoPublicacao.getText().isEmpty()?"0":txtAnoPublicacao.getText());
            String sinopseTexto = sinopse.getText();
            String matricula = UUID.randomUUID().toString().substring(0,4);

            if(titulo == "" || autor == "" || genero == "" || anoPublicacao == null || numeroPaginas == null || sinopseTexto == "" ||(checkBoxNao.isSelected() == false && checkBoxSim.isSelected() == false)){
                JOptionPane.showMessageDialog(null, "Preencha todos os campos.");
            }else{
                txtMatricula.setText(matricula);
                livroDao.cadastrar(new Livro(matricula, titulo, genero, autor, anoPublicacao, numeroPaginas, edicaoUnica, sinopseTexto));
                JOptionPane.showMessageDialog(null, "Cadastro realizado com sucesso");
                txtTitulo.setText("");
                txtAutor.setText("");
                txtAnoPublicacao.setText("");
                menuGenero.setSelectedIndex(0);
                checkBoxNao.setSelected(false);
                checkBoxSim.setSelected(false);
                txtNumPaginas.setText("");
                sinopse.setText("");
                txtMatricula.setText("Sua matrícula aparecerá aqui assim que o livro for cadastrado.");
            }
        }
        if (e.getSource() == btnListar) {
            livroDao.listar();
        }
        if (e.getSource() == btnAtualizar) {
            if (!atualizar) {
                matriculaLivro = JOptionPane.showInputDialog("Digite a matricula do livro: ");
                Livro livro = livroDao.buscarLivroPorMatricula(matriculaLivro);
                if (livro != null) {
                    btnAtualizar.setText("Atualizar");
                    txtMatricula.setText(matriculaLivro);
                    txtTitulo.setText(livro.getTitulo());
                    txtAutor.setText(livro.getAutor());
                    txtAnoPublicacao.setText(String.valueOf(livro.getAnoPublicacao()));
                    Integer index = 0;
                    Integer i = 0;
                    for (String genero : generos) {
                        if (genero.equals(String.valueOf(livro.getAnoPublicacao()))) {
                            index = i;
                        }
                        i++;
                    }
                    menuGenero.setSelectedIndex(index);
                    if (livro.getEdicaoUnica()) {
                        checkBoxSim.setSelected(true);
                    }else{
                        checkBoxNao.setSelected(true);
                    }

                    txtNumPaginas.setText(String.valueOf(livro.getNumPaginas()));
                    sinopse.setText(livro.getSinopse());
                }else{
                    JOptionPane.showMessageDialog(null, "Livro não encontrado");
                }
                atualizar = !atualizar;
            }else{
                String titulo = txtTitulo.getText();
                String autor = txtAutor.getText();
                String genero = String.valueOf(menuGenero.getSelectedItem());
                Boolean edicaoUnica = checkBoxSim.isSelected();
                Integer numeroPaginas = Integer.parseInt(txtNumPaginas.getText().isEmpty()?"0":txtNumPaginas.getText());
                Integer anoPublicacao = Integer.parseInt(txtAnoPublicacao.getText().isEmpty()?"0":txtAnoPublicacao.getText());
                String sinopseTexto = sinopse.getText();

                livroDao.atualizarLivro(matriculaLivro, titulo, genero, autor, anoPublicacao, numeroPaginas, edicaoUnica, sinopseTexto);
                btnAtualizar.setText("Alterar");
                atualizar = !atualizar;

                JOptionPane.showMessageDialog(null, "Livro atualizado com sucesso");
                txtTitulo.setText("");
                txtAutor.setText("");
                txtAnoPublicacao.setText("");
                menuGenero.setSelectedIndex(0);
                checkBoxNao.setSelected(false);
                checkBoxSim.setSelected(false);
                txtNumPaginas.setText("");
                sinopse.setText("");
                txtMatricula.setText("Sua matrícula aparecerá aqui assim que o livro for cadastrado.");

            }
        }
        if (e.getSource() == btnDeletar) {
            matriculaLivro = JOptionPane.showInputDialog("Qual a matricula do livro?");
            livroDao.deletar(matriculaLivro);
        }
    }
}
