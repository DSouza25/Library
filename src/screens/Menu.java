package screens;

import java.awt.Cursor;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import resources.Cores;

public class Menu implements ActionListener{
    JFrame janela = new JFrame("Library");
    JPanel painel = new JPanel();
    JLabel lblTitulo = new JLabel("Library");
    JButton btnUsuario = new JButton();
    JLabel lblUsuario = new JLabel("Usuários");
    JButton btnLivro = new JButton();
    JLabel lblLivro = new JLabel("Livros");
    JButton btnFuncionario = new JButton();
    JLabel lblFuncionarios = new JLabel("Funcionários");
    Cores cor = new Cores();

    public void ajustarIcon(String path, JButton button){
        ImageIcon icon = new ImageIcon(getClass().getResource(path));
        Image img = icon.getImage().getScaledInstance(100, 100, java.awt.Image.SCALE_SMOOTH); 
        button.setIcon(new ImageIcon(img));
    }

    public void estilizarBotao(JButton button){
        button.setBackground(cor.getVerdeClaro());
        button.setBorder(null);
        button.setFocusPainted(false);
        button.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent e) {
            }

            @Override
            public void mousePressed(MouseEvent e) {
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                button.setCursor(new Cursor(Cursor.HAND_CURSOR));
                button.setBorder(new LineBorder(cor.getBranco(), 5));
            }
            
            @Override
            public void mouseExited(MouseEvent e) {
                button.setBorder(null);
            }
            
        });
    }

    public void estilizarLabel(JLabel label){
        label.setForeground(cor.getBranco());
        label.setFont(new Font("Corbel", Font.CENTER_BASELINE, 18));
    }

    public void abrirMenu(){
        // ------- estilizando componentes ----------
        painel.setBackground(cor.getVerdeEscuro());
        painel.setLayout(null);
                // botoes
        btnUsuario.setBounds(50,180, 200, 200);
        ajustarIcon("/resources/images/usuarioBranco.png", btnUsuario);
        estilizarBotao(btnUsuario);
        btnUsuario.addActionListener(this);

        btnLivro.setBounds(300,180, 200, 200);
        ajustarIcon("/resources/images/livrosBranco.png", btnLivro);
        btnLivro.addActionListener(this);
        estilizarBotao(btnLivro);

        btnFuncionario.setBounds(550,180, 200, 200);
        ajustarIcon("/resources/images/funcionariosBranco.png", btnFuncionario);
        estilizarBotao(btnFuncionario);
        btnFuncionario.addActionListener(this);

                // labels
        lblTitulo.setBounds(290, 50, 300, 70);
        lblTitulo.setForeground(cor.getBranco());
        lblTitulo.setFont(new Font("Bauhaus 93", Font.CENTER_BASELINE, 70));
        lblUsuario.setBounds(117, 385, 200, 30);
        estilizarLabel(lblUsuario);
        lblLivro.setBounds(377, 385, 200, 30);
        estilizarLabel(lblLivro);
        lblFuncionarios.setBounds(600, 385, 200, 30);
        estilizarLabel(lblFuncionarios);

        // --------- adicionando à janela ----------
        janela.add(lblUsuario);
        janela.add(lblLivro);
        janela.add(lblFuncionarios);
        janela.add(lblTitulo);
        janela.add(btnFuncionario);
        janela.add(btnLivro);
        janela.add(btnUsuario);
        janela.add(painel);
        // --------- configurando JFrame -----------
        janela.setSize(800,500);
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        janela.setResizable(false);
        janela.setLocationRelativeTo(null);
        janela.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnUsuario) {
            JOptionPane.showMessageDialog(null, "Funcionando.");
        }
        if (e.getSource() == btnLivro) {
            new TelaLivro().abrirTela();

        }
        if (e.getSource() == btnFuncionario) {
            new TelaFuncionario().abrirTela();
        }
    }
}
