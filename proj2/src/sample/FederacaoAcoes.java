/*
 * Created by JFormDesigner on Thu Apr 22 21:40:37 BST 2021
 */

package sample;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.GroupLayout;
import javax.swing.border.*;

/**
 * @author Marcos
 */
public class FederacaoAcoes extends JFrame {
    public FederacaoAcoes() {
        initComponents();
    }

    private void btnLogin(ActionEvent e) {
        // TODO add your code here
    }

    private void btnCriarProvaPainel(ActionEvent e) {
        panel2.removeAll();
        panel2.add(panel3);
        panel2.repaint();
        panel2.revalidate();
    }

    private void btnListarResultadosPainel(ActionEvent e) {
        panel2.removeAll();
        panel2.add(panel4);
        panel2.repaint();
        panel2.revalidate();
    }

    private void btnLoginPainel(ActionEvent e) {
       btnAddResultado.setVisible(true);
       btnCriarProvaPag.setVisible(true);
       btnListarResultados.setVisible(true);
       btnLogOut.setVisible(true);
        panel2.removeAll();
        panel2.add(panel3);
        panel2.repaint();
        panel2.revalidate();

    }

    private void btnLogOutAcao(ActionEvent e) {
        btnAddResultado.setVisible(false);
        btnCriarProvaPag.setVisible(false);
        btnListarResultados.setVisible(false);
        btnLogOut.setVisible(false);
        panel2.removeAll();
        panel2.add(panelLogin);
        panel2.repaint();
        panel2.revalidate();
        
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Marcos
        panelFederacao = new JPanel();
        lbBemVindo = new JLabel();
        btnCriarProvaPag = new JButton();
        btnListarResultados = new JButton();
        btnLogOut = new JButton();
        btnAddResultado = new JButton();
        panel2 = new JPanel();
        panelLogin = new JPanel();
        textUserName = new JTextField();
        textPassword = new JPasswordField();
        lbUserName = new JLabel();
        lbPassWord = new JLabel();
        lbUserName2 = new JLabel();
        btnLogin = new JButton();
        panel3 = new JPanel();
        lbFederacao = new JLabel();
        boxFederacao = new JComboBox();
        lbCategoria = new JLabel();
        boxCategoria = new JComboBox();
        lbCategoria2 = new JLabel();
        txtHora = new JTextField();
        btnCriarProva = new JButton();
        lbCriarProva = new JLabel();
        panel4 = new JPanel();

        //======== this ========
        var contentPane = getContentPane();

        //======== panelFederacao ========
        {
            panelFederacao.setBorder(new javax.swing.border.CompoundBorder(new javax.swing.border.TitledBorder(new javax.swing.border.
            EmptyBorder(0,0,0,0), "JFor\u006dDesi\u0067ner \u0045valu\u0061tion",javax.swing.border.TitledBorder.CENTER,javax.swing
            .border.TitledBorder.BOTTOM,new java.awt.Font("Dia\u006cog",java.awt.Font.BOLD,12),
            java.awt.Color.red),panelFederacao. getBorder()));panelFederacao. addPropertyChangeListener(new java.beans.PropertyChangeListener()
            {@Override public void propertyChange(java.beans.PropertyChangeEvent e){if("bord\u0065r".equals(e.getPropertyName()))
            throw new RuntimeException();}});

            //---- lbBemVindo ----
            lbBemVindo.setText("Bem-Vindo");
            lbBemVindo.setFont(new Font("Segoe UI", Font.PLAIN, 30));

            //---- btnCriarProvaPag ----
            btnCriarProvaPag.setText("Criar Prova");
            btnCriarProvaPag.setFont(new Font("Segoe UI", Font.PLAIN, 22));
            btnCriarProvaPag.setVisible(false);
            btnCriarProvaPag.addActionListener(e -> btnCriarProvaPainel(e));

            //---- btnListarResultados ----
            btnListarResultados.setText("Listar Resultados");
            btnListarResultados.setFont(new Font("Segoe UI", Font.PLAIN, 22));
            btnListarResultados.setVisible(false);
            btnListarResultados.addActionListener(e -> btnListarResultadosPainel(e));

            //---- btnLogOut ----
            btnLogOut.setText("Logout");
            btnLogOut.setFont(new Font("Segoe UI", Font.PLAIN, 22));
            btnLogOut.setVisible(false);
            btnLogOut.addActionListener(e -> btnLogOutAcao(e));

            //---- btnAddResultado ----
            btnAddResultado.setText("Adicionar Resultados");
            btnAddResultado.setFont(new Font("Segoe UI", Font.PLAIN, 22));
            btnAddResultado.setVisible(false);

            //======== panel2 ========
            {
                panel2.setLayout(new CardLayout());

                //======== panelLogin ========
                {

                    //---- textUserName ----
                    textUserName.setFont(new Font("Segoe UI", Font.PLAIN, 12));

                    //---- lbUserName ----
                    lbUserName.setText("UserName");
                    lbUserName.setFont(new Font("Segoe UI", Font.PLAIN, 20));

                    //---- lbPassWord ----
                    lbPassWord.setText("PassWord");
                    lbPassWord.setFont(new Font("Segoe UI", Font.PLAIN, 20));

                    //---- lbUserName2 ----
                    lbUserName2.setText("Login");
                    lbUserName2.setFont(new Font("Segoe UI", Font.PLAIN, 30));

                    //---- btnLogin ----
                    btnLogin.setText("Login");
                    btnLogin.addActionListener(e -> {
			btnLogin(e);
			btnLoginPainel(e);
		});

                    GroupLayout panelLoginLayout = new GroupLayout(panelLogin);
                    panelLogin.setLayout(panelLoginLayout);
                    panelLoginLayout.setHorizontalGroup(
                        panelLoginLayout.createParallelGroup()
                            .addGroup(panelLoginLayout.createSequentialGroup()
                                .addGap(145, 145, 145)
                                .addGroup(panelLoginLayout.createParallelGroup()
                                    .addGroup(panelLoginLayout.createSequentialGroup()
                                        .addGap(226, 226, 226)
                                        .addComponent(lbUserName2, GroupLayout.PREFERRED_SIZE, 82, GroupLayout.PREFERRED_SIZE))
                                    .addGroup(panelLoginLayout.createSequentialGroup()
                                        .addComponent(lbUserName)
                                        .addGap(135, 135, 135)
                                        .addComponent(textUserName, GroupLayout.PREFERRED_SIZE, 244, GroupLayout.PREFERRED_SIZE))
                                    .addGroup(panelLoginLayout.createSequentialGroup()
                                        .addGap(4, 4, 4)
                                        .addComponent(lbPassWord)
                                        .addGap(135, 135, 135)
                                        .addComponent(textPassword, GroupLayout.PREFERRED_SIZE, 244, GroupLayout.PREFERRED_SIZE))
                                    .addGroup(panelLoginLayout.createSequentialGroup()
                                        .addGap(226, 226, 226)
                                        .addComponent(btnLogin, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(148, Short.MAX_VALUE))
                    );
                    panelLoginLayout.setVerticalGroup(
                        panelLoginLayout.createParallelGroup()
                            .addGroup(panelLoginLayout.createSequentialGroup()
                                .addGap(43, 43, 43)
                                .addComponent(lbUserName2, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE)
                                .addGap(60, 60, 60)
                                .addGroup(panelLoginLayout.createParallelGroup()
                                    .addComponent(lbUserName)
                                    .addComponent(textUserName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(43, 43, 43)
                                .addGroup(panelLoginLayout.createParallelGroup()
                                    .addComponent(lbPassWord)
                                    .addGroup(panelLoginLayout.createSequentialGroup()
                                        .addGap(3, 3, 3)
                                        .addComponent(textPassword, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
                                .addGap(93, 93, 93)
                                .addComponent(btnLogin, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(91, Short.MAX_VALUE))
                    );
                }
                panel2.add(panelLogin, "card3");

                //======== panel3 ========
                {

                    //---- lbFederacao ----
                    lbFederacao.setText("Federa\u00e7\u00e3o");
                    lbFederacao.setFont(new Font("Segoe UI", Font.PLAIN, 25));

                    //---- lbCategoria ----
                    lbCategoria.setText("Categoria");
                    lbCategoria.setFont(new Font("Segoe UI", Font.PLAIN, 25));

                    //---- lbCategoria2 ----
                    lbCategoria2.setText("Hora");
                    lbCategoria2.setFont(new Font("Segoe UI", Font.PLAIN, 25));

                    //---- btnCriarProva ----
                    btnCriarProva.setText("Criar Prova");
                    btnCriarProva.setFont(new Font("Segoe UI", Font.PLAIN, 25));

                    //---- lbCriarProva ----
                    lbCriarProva.setText("Criar Pova");
                    lbCriarProva.setFont(new Font("Segoe UI", Font.PLAIN, 30));

                    GroupLayout panel3Layout = new GroupLayout(panel3);
                    panel3.setLayout(panel3Layout);
                    panel3Layout.setHorizontalGroup(
                        panel3Layout.createParallelGroup()
                            .addGroup(panel3Layout.createSequentialGroup()
                                .addGroup(panel3Layout.createParallelGroup()
                                    .addGroup(panel3Layout.createSequentialGroup()
                                        .addGap(319, 319, 319)
                                        .addComponent(lbCriarProva))
                                    .addGroup(panel3Layout.createSequentialGroup()
                                        .addGap(103, 103, 103)
                                        .addGroup(panel3Layout.createParallelGroup()
                                            .addGroup(panel3Layout.createSequentialGroup()
                                                .addGap(261, 261, 261)
                                                .addComponent(btnCriarProva))
                                            .addGroup(panel3Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                                .addComponent(txtHora, GroupLayout.PREFERRED_SIZE, 198, GroupLayout.PREFERRED_SIZE)
                                                .addGroup(panel3Layout.createSequentialGroup()
                                                    .addGroup(panel3Layout.createParallelGroup()
                                                        .addGroup(panel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                                            .addComponent(lbCategoria, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                            .addComponent(lbFederacao))
                                                        .addGroup(panel3Layout.createSequentialGroup()
                                                            .addGap(19, 19, 19)
                                                            .addComponent(lbCategoria2)))
                                                    .addGap(94, 94, 94)
                                                    .addGroup(panel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(boxCategoria)
                                                        .addComponent(boxFederacao, GroupLayout.PREFERRED_SIZE, 198, GroupLayout.PREFERRED_SIZE)))))))
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    );
                    panel3Layout.setVerticalGroup(
                        panel3Layout.createParallelGroup()
                            .addGroup(panel3Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(lbCriarProva, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
                                .addGap(32, 32, 32)
                                .addGroup(panel3Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                    .addComponent(lbFederacao)
                                    .addComponent(boxFederacao, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(32, 32, 32)
                                .addGroup(panel3Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                    .addComponent(lbCategoria)
                                    .addComponent(boxCategoria, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(35, 35, 35)
                                .addGroup(panel3Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                    .addComponent(lbCategoria2)
                                    .addComponent(txtHora, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(73, 73, 73)
                                .addComponent(btnCriarProva)
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    );
                }
                panel2.add(panel3, "card1");

                //======== panel4 ========
                {

                    GroupLayout panel4Layout = new GroupLayout(panel4);
                    panel4.setLayout(panel4Layout);
                    panel4Layout.setHorizontalGroup(
                        panel4Layout.createParallelGroup()
                            .addGap(0, 763, Short.MAX_VALUE)
                    );
                    panel4Layout.setVerticalGroup(
                        panel4Layout.createParallelGroup()
                            .addGap(0, 484, Short.MAX_VALUE)
                    );
                }
                panel2.add(panel4, "card2");
            }

            GroupLayout panelFederacaoLayout = new GroupLayout(panelFederacao);
            panelFederacao.setLayout(panelFederacaoLayout);
            panelFederacaoLayout.setHorizontalGroup(
                panelFederacaoLayout.createParallelGroup()
                    .addComponent(panel2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(panelFederacaoLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnCriarProvaPag)
                        .addGroup(panelFederacaoLayout.createParallelGroup()
                            .addGroup(panelFederacaoLayout.createSequentialGroup()
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnListarResultados)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnAddResultado)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnLogOut)
                                .addGap(16, 16, 16))
                            .addGroup(panelFederacaoLayout.createSequentialGroup()
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lbBemVindo)
                                .addGap(293, 293, 293))))
            );
            panelFederacaoLayout.setVerticalGroup(
                panelFederacaoLayout.createParallelGroup()
                    .addGroup(panelFederacaoLayout.createSequentialGroup()
                        .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lbBemVindo)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelFederacaoLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(btnCriarProvaPag)
                            .addComponent(btnListarResultados)
                            .addComponent(btnAddResultado)
                            .addComponent(btnLogOut))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(panel2, GroupLayout.PREFERRED_SIZE, 484, GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
            );
        }

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addComponent(panelFederacao, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addComponent(panelFederacao, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Marcos
    private JPanel panelFederacao;
    private JLabel lbBemVindo;
    private JButton btnCriarProvaPag;
    private JButton btnListarResultados;
    private JButton btnLogOut;
    private JButton btnAddResultado;
    private JPanel panel2;
    private JPanel panelLogin;
    private JTextField textUserName;
    private JPasswordField textPassword;
    private JLabel lbUserName;
    private JLabel lbPassWord;
    private JLabel lbUserName2;
    private JButton btnLogin;
    private JPanel panel3;
    private JLabel lbFederacao;
    private JComboBox boxFederacao;
    private JLabel lbCategoria;
    private JComboBox boxCategoria;
    private JLabel lbCategoria2;
    private JTextField txtHora;
    private JButton btnCriarProva;
    private JLabel lbCriarProva;
    private JPanel panel4;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
