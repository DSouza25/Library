package screens;

// Importações necessárias para componentes gráficos e eventos
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import entities.dao.FuncionarioDao;
import entities.Funcionario;

import resources.Cores;

// Classe responsável pela tela de cadastro e gerenciamento de funcionários
public class TelaFuncionario implements ActionListener {

    // ------------ Atributos ------------
    Funcionario fun; // Objeto auxiliar para manipulação de funcionários
    FuncionarioDao fd = new FuncionarioDao(); // DAO para operações com funcionários
    Cores cor = new Cores(); // Classe para gerenciar cores do sistema
    ImageIcon icone = new ImageIcon("src/resources/images/fun.png"); // Ícone da tela
    
    JFrame tela = new JFrame("Cadastro de Funcionarios"); // Janela principal
    JPanel painel = new JPanel(); // Painel para adicionar componentes

    JLabel lbImg = new JLabel(icone); // Label para exibir imagem

    JLabel lbmatricula = new JLabel("Matricula: "); // Label matrícula

    JLabel lbnome = new JLabel("Nome: "); // Label nome

    JLabel lbnasc = new JLabel("Nascimento: "); // Label nascimento

    JLabel lbsexo = new JLabel("Sexo: "); // Label sexo
    
    JCheckBox checkBoxM = new JCheckBox("Masculino"); // Checkbox masculino
    JCheckBox checkBoxF = new JCheckBox("Feminino");  // Checkbox feminino
    JCheckBox checkBoxO = new JCheckBox("Outro");     // Checkbox outro

    JLabel lbcargo = new JLabel("Cargo: "); // Label cargo
    String[] cargos = { "Selecione um cargo","Gerente", "Atendente", "Estoquista", "Estagiario" }; // Opções de cargo
    JComboBox<String> menucargos = new JComboBox<>(cargos); // ComboBox para cargos
    JLabel lbcargos = new JLabel("Cargo: "); // Label para ComboBox de cargos

    JLabel lbemail = new JLabel("Email: "); // Label email

    JLabel lbsenha = new JLabel("Senha: "); // Label senha

    JTextField txtmatricula = new JTextField(""); // Campo matrícula

    JTextField txtnome = new JTextField(); // Campo nome

    JTextField txtnasc = new JTextField("DD/MM/AAAA"); // Campo nascimento com texto pré-definido

    // JTextField txtcargo = new JTextField(); // Campo cargo (não utilizado, pois usa ComboBox)

    JTextField txtemail = new JTextField(); // Campo email

    JTextField txtsenha = new JTextField(); // Campo senha

    JButton btsalvar = new JButton("Salvar");     // Botão salvar
    JButton btlistar = new JButton("Listar");     // Botão listar
    JButton btalterar = new JButton("Alterar");   // Botão alterar
    JButton btexcluir = new JButton("Excluir");   // Botão excluir
    JButton btpesq = new JButton("Pesquisar");    // Botão pesquisar

    // Método responsável por montar e exibir a tela
    public void abrirTela(){
        // ------------ Customização da tela ------------
        tela.setSize(550, 450); 
        tela.setLocation(550, 250);
        painel.setLayout(null); // Layout absoluto

        // MATRÍCULA + BOTÃO PESQUISAR
        lbmatricula.setBounds(30, 20, 100, 30);
        lbmatricula.setFont(new Font("Century Gothic", Font.BOLD, 12));
        lbmatricula.setForeground(cor.getBranco());
        
        txtmatricula.setBounds(120, 20, 180, 30);
        txtmatricula.setEnabled(false); // Só é habilitado após salvar
        txtmatricula.setBackground(java.awt.Color.LIGHT_GRAY);

        btpesq.setBounds(310, 20, 120, 30);
        btpesq.setBackground(cor.getVerdeClaro());
        btpesq.setForeground(java.awt.Color.WHITE);
        btpesq.addActionListener(this); // Adiciona ação ao botão pesquisar
        btpesq.setEnabled(false); // Só habilita após salvar

        // IMAGEM
        lbImg.setBounds(250, 150, 300, 200);

        // NOME 
        lbnome.setBounds(30, 70, 100, 30);
        lbnome.setFont(new Font("Century Gothic", Font.BOLD, 12));
        lbnome.setForeground(cor.getBranco()); 
        txtnome.setBounds(120, 70, 180, 30);

        // NASCIMENTO
        lbnasc.setBounds(30, 120, 100, 30);
        lbnasc.setFont(new Font("Century Gothic", Font.BOLD, 12));
        lbnasc.setForeground(cor.getBranco()); 
        txtnasc.setBounds(120, 120, 75, 30);

        // SEXO
        lbsexo.setBounds(202, 75, 200, 100);
        lbsexo.setForeground(cor.getBranco());
        
        // CheckBox para seleção de sexo
        checkBoxM.setBounds(200, 130, 100, 30);
        checkBoxM.setBackground(cor.getVerdeEscuro());
        checkBoxM.setForeground(cor.getBranco());
        checkBoxM.setFocusPainted(false);
        checkBoxM.addActionListener(this); // Permite selecionar apenas um sexo
        checkBoxM.setCursor(new Cursor(Cursor.HAND_CURSOR));

        checkBoxF.setBounds(300, 130, 100, 30);
        checkBoxF.setBackground(cor.getVerdeEscuro());
        checkBoxF.setForeground(cor.getBranco());
        checkBoxF.setFocusPainted(false);
        checkBoxF.addActionListener(this);
        checkBoxF.setCursor(new Cursor(Cursor.HAND_CURSOR));

        checkBoxO.setBounds(400, 130, 100, 30);
        checkBoxO.setBackground(cor.getVerdeEscuro());
        checkBoxO.setForeground(cor.getBranco());
        checkBoxO.setFocusPainted(false);
        checkBoxO.addActionListener(this);
        checkBoxO.setCursor(new Cursor(Cursor.HAND_CURSOR));

        // CARGO
        lbcargos.setBounds(30, 170, 100, 30);
        lbcargos.setFont(new Font("Century Gothic", Font.BOLD, 12));
        lbcargos.setForeground(cor.getBranco()); 
        menucargos.setBounds(120, 170, 180, 30);
        menucargos.setBackground(cor.getBranco());
        menucargos.setBorder(new LineBorder(cor.getVerdeClaro(), 3));
        menucargos.setCursor(new Cursor(Cursor.HAND_CURSOR));

        // EMAIL
        lbemail.setBounds(30, 220, 100, 30);
        lbemail.setFont(new Font("Century Gothic", Font.BOLD, 12));
        lbemail.setForeground(cor.getBranco()); 
        txtemail.setBounds(120, 220, 180, 30);

        // SENHA
        lbsenha.setBounds(30, 270, 100, 30);
        lbsenha.setFont(new Font("Century Gothic", Font.BOLD, 12));
        lbsenha.setForeground(cor.getBranco()); 
        txtsenha.setBounds(120, 270, 180, 30);

        // BOTÕES
        btsalvar.setBounds(70, 340, 90, 30);
        btsalvar.addActionListener(this); // Adiciona ação ao botão salvar
        btsalvar.setBackground(cor.getVerdeClaro());
        btsalvar.setForeground(cor.getBranco());

        btlistar.setBounds(170, 340, 90, 30);
        btlistar.addActionListener(this); // Adiciona ação ao botão listar
        btlistar.setBackground(cor.getVerdeClaro());
        btlistar.setForeground(cor.getBranco());

        btalterar.setBounds(270, 340, 90, 30);
        btalterar.addActionListener(this); // Adiciona ação ao botão alterar
        btalterar.setBackground(cor.getVerdeClaro());
        btalterar.setForeground(cor.getBranco());

        btexcluir.setBounds(370, 340, 90, 30);
        btexcluir.addActionListener(this); // Adiciona ação ao botão excluir
        btexcluir.setBackground(cor.getVerdeClaro());
        btexcluir.setForeground(cor.getBranco());

        // ------------ Adicionando os componentes ao painel ------------
        painel.add(lbnome);
        painel.add(txtnome);
        painel.add(btpesq);

        painel.add(lbnasc);
        painel.add(txtnasc);
        painel.add(checkBoxM);
        painel.add(checkBoxF);
        painel.add(checkBoxO);
        painel.add(lbsexo);

        painel.add(lbcargos);
        painel.add(menucargos);

        painel.add(lbmatricula);
        painel.add(txtmatricula);

        painel.add(lbemail);
        painel.add(txtemail);

        painel.add(lbsenha);
        painel.add(txtsenha);

        painel.add(btsalvar);
        painel.add(btlistar);
        painel.add(btalterar);
        painel.add(btexcluir);

        painel.add(lbImg);

        painel.setBackground(cor.getBranco());

        tela.getContentPane().add(painel);
        tela.setVisible(true); // Exibe a janela

        painel.setBackground(cor.getVerdeEscuro());

        // ------------ Configurações de texto pre definido ------------
        // Remove o texto "DD/MM/AAAA" ao clicar no campo e retorna se ficar vazio
        txtnasc.addFocusListener(new java.awt.event.FocusAdapter() {
            @Override
            public void focusGained(java.awt.event.FocusEvent e) {
                if (txtnasc.getText().equals("DD/MM/AAAA")) {
                    txtnasc.setText("");
                }
            }
            @Override
            public void focusLost(java.awt.event.FocusEvent e) {
                if (txtnasc.getText().isEmpty()) {
                    txtnasc.setText("DD/MM/AAAA");
                }
            }
        });
    }

    // Método responsável por tratar as ações dos botões e checkboxes
    @Override
    public void actionPerformed(ActionEvent e) {
        // Botão Salvar: valida os campos, cria um novo funcionário e salva na lista
        if (e.getSource() == btsalvar) {

            if (txtnome.getText().isEmpty() || txtnasc.getText().isEmpty()
                    || menucargos.getSelectedIndex() == 0
                    || txtemail.getText().isEmpty() || txtsenha.getText().isEmpty()
                    || (!checkBoxM.isSelected() && !checkBoxF.isSelected() && !checkBoxO.isSelected())) {
                JOptionPane.showMessageDialog(null, "Preencha todos os campos antes de salvar!");
                return;
            }

            try {
                String n = txtnome.getText(); // Nome
                int i = Integer.parseInt(txtnasc.getText()); // Nascimento (como inteiro)
                String c = menucargos.getSelectedItem().toString(); // Cargo selecionado
                int m = fd.retornaTamanhoLista() + 1; // Gera matrícula automaticamente
                String a = txtemail.getText(); // Email
                String s = txtsenha.getText(); // Senha

                // Captura o sexo selecionado
                String sexo = "";
                if (checkBoxM.isSelected()) sexo = "Masculino";
                else if (checkBoxF.isSelected()) sexo = "Feminino";
                else if (checkBoxO.isSelected()) sexo = "Outro";

                // Cria novo funcionário e salva na lista
                fun = new Funcionario(n, i, c, m, a, s, sexo);
                fd.salvar(fun);
                txtmatricula.setBackground(cor.getBranco());
                JOptionPane.showMessageDialog(null, "Salvo com sucesso!");

                // Limpa os campos após salvar
                txtnome.setText("");
                txtnasc.setText("");
                menucargos.setSelectedIndex(0);
                txtmatricula.setText("");
                txtemail.setText("");
                txtsenha.setText("");
                checkBoxM.setSelected(false);
                checkBoxF.setSelected(false);
                checkBoxO.setSelected(false);

                btpesq.setEnabled(true); // Habilita pesquisa após salvar
                txtmatricula.setEnabled(true);

            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null,
                        "Erro: os campos 'Nascimento' e 'Matrícula' devem conter números válidos.");
            }
        }

        // Botão Listar: exibe todos os funcionários cadastrados
        if (e.getSource() == btlistar) {
            fd.listar();
        }

        // Botão Pesquisar: busca funcionário pela matrícula e preenche os campos
        if (e.getSource() == btpesq) {
            // Verifica se o campo matrícula está vazio
            if (txtmatricula.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Insira uma matrícula!");
                return;
            }

            Integer matricula = Integer.valueOf(txtmatricula.getText());

            fun = fd.pesquisar(matricula);

            if (fun == null) {
                JOptionPane.showMessageDialog(null, "Funcionario nao encontrado");
            } else {

                txtnome.setText(fun.getNome());
                txtnasc.setText(String.valueOf(fun.getIdade()));
                menucargos.setSelectedItem(fun.getCargo());
                txtmatricula.setText(String.valueOf(fun.getMatricula()));
                txtemail.setText(fun.getEmail());
                txtsenha.setText(fun.getSenha());

                // Seleciona o checkbox de acordo com o sexo salvo
                checkBoxM.setSelected("Masculino".equals(fun.getSexo()));
                checkBoxF.setSelected("Feminino".equals(fun.getSexo()));
                checkBoxO.setSelected("Outro".equals(fun.getSexo()));
            }

        }

        // Botão Alterar: atualiza os dados do funcionário pesquisado
        if (e.getSource() == btalterar) {
            Integer matricula = Integer.valueOf(txtmatricula.getText());

            fun = fd.pesquisar(matricula);

            if (fun == null) {
                JOptionPane.showMessageDialog(null, "Matricula invalida!");
            } else {

                fun.setNome(txtnome.getText());
                fun.setIdade(Integer.parseInt(txtnasc.getText()));
                fun.setCargo(menucargos.getSelectedItem().toString());
                fun.setEmail(txtemail.getText());
                fun.setSenha(txtsenha.getText());

                // Atualiza o sexo
                String sexo = "";
                if (checkBoxM.isSelected()) sexo = "Masculino";
                else if (checkBoxF.isSelected()) sexo = "Feminino";
                else if (checkBoxO.isSelected()) sexo = "Outro";
                fun.setSexo(sexo);

                JOptionPane.showMessageDialog(null, "Alterado com sucesso!");

                // Limpa os campos após alterar
                txtnome.setText("");
                txtnasc.setText("");
                menucargos.setSelectedIndex(0);
                txtmatricula.setText("");
                txtemail.setText("");
                txtsenha.setText("");
                checkBoxM.setSelected(false);
                checkBoxF.setSelected(false);
                checkBoxO.setSelected(false);
            }
        }

        // Botão Excluir: remove o funcionário pesquisado da lista
        if (e.getSource() == btexcluir) {
            Integer matricula = Integer.valueOf(txtmatricula.getText());

            fd.excluir(matricula);

            JOptionPane.showMessageDialog(null, "Excluido com sucesso");

            // Limpa os campos após excluir
            txtnome.setText("");
            txtnasc.setText("");
            //txtcargo.setText("");
            txtmatricula.setText("");
            txtemail.setText("");
            txtsenha.setText("");

            if (fd.retornaTamanhoLista() < matricula) {
                // Caso especial se necessário tratar algo após exclusão
            }
        }
        
        // Permite selecionar apenas um checkbox de sexo por vez
        if (e.getSource() == checkBoxM) {
            checkBoxF.setSelected(false);
            checkBoxO.setSelected(false);

        }
        if (e.getSource() == checkBoxF) {
            checkBoxM.setSelected(false);
            checkBoxO.setSelected(false);

        }
        if (e.getSource() == checkBoxO) {
            checkBoxM.setSelected(false);
            checkBoxF.setSelected(false);

        }

    }

}