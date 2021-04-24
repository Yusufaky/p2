/*
 * Created by JFormDesigner on Thu Apr 22 21:40:37 BST 2021
 */

package sample;

import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;
import javax.swing.GroupLayout;
import javax.swing.border.*;
import javax.swing.table.DefaultTableModel;

/**
 * @author Marcos
 */
public class FederacaoAcoes extends JFrame {
    public FederacaoAcoes() {
        initComponents();
    }

    private void PopulateTableAnswer() {
        List<Resultados> allDados = Resultados.readAll();


        DefaultTableModel model_d = new DefaultTableModel(new Object[]{"ID", "Name", "ID Prova", "ID Atleta"}, 0);
        //Adiciona os medicamentos na tablela
        try {

            for (Resultados data : allDados) {
                System.out.println(data.getClassificacao());
                model_d.addRow(new Object[]{data.getId_Resultado(), data.getClassificacao(), data.getId_prova(), data.getId_atleta()});
            }

            tbAddResultado.setModel(model_d);
        } catch (
                IndexOutOfBoundsException error) {
            System.out.println("Sem Resultados..");
        }
    }

    private void btnCriarProvaPainel(ActionEvent e) {
        panel2.removeAll();
        panel2.add(panelCriarProva);
        panel2.repaint();
        panel2.revalidate();
    }

    private void btnListarResultadosPainel(ActionEvent e) {
        panel2.removeAll();
        panel2.add(panelListarResultados);
        panel2.repaint();
        panel2.revalidate();
        PopulateTableAnswer();
    }



    private void btnLogOutAcao(ActionEvent e) {
        btnAddResultadoPAG.setVisible(false);
        btnCriarProvaPAG.setVisible(false);
        btnListarResultadosPAG.setVisible(false);
        btnLogOutPAG.setVisible(false);
        panel2.removeAll();
        panel2.add(panelLogin);
        panel2.repaint();
        panel2.revalidate();

    }

    private void btnAddResultadoPAGAction(ActionEvent e) {
        btnAddResultadoPAG.setVisible(true);
        btnCriarProvaPAG.setVisible(true);
        btnListarResultadosPAG.setVisible(true);
        btnLogOutPAG.setVisible(true);
        panel2.removeAll();
        panel2.add(paneladdResultado);
        panel2.repaint();
        panel2.revalidate();
    }

    private void btnLoginPainel(ActionEvent e) {
        Connection conn = Util.criarConexao();

        String sqlCommand = "SELECT username, password  FROM federacao where username =? and password=?";

        String username = textUserName.getText();
        String password = String.valueOf(textPassword.getPassword());
        


        try {
            PreparedStatement st = conn.prepareStatement(sqlCommand);
            st.setString(1, username);
            st.setString(2, password);
            ResultSet rs = st.executeQuery();
            System.out.println(username + password
            );
            if (rs.next()) {
                System.out.println(username + password
                );
                btnAddResultadoPAG.setVisible(true);
                btnCriarProvaPAG.setVisible(true);
                btnListarResultadosPAG.setVisible(true);
                btnLogOutPAG.setVisible(true);
                panel2.removeAll();
                panel2.add(panelCriarProva);
                panel2.repaint();
                panel2.revalidate();
                textPassword.setText("");
                textUserName.setText("");
                errologin.setText("");
            } else {
                System.out.println("ERRO: "
                );
                errologin.setText("Erro a efetuar o login");
            }


        } catch (SQLException ex) {
            System.out.println("ERRO: " + ex.getMessage());
        }
    }

    private void btnLogin(ActionEvent e) {
        // TODO add your code here
    }


    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Marcos
        panelFederacao = new JPanel();
        lbBemVindo = new JLabel();
        btnCriarProvaPAG = new JButton();
        btnListarResultadosPAG = new JButton();
        btnLogOutPAG = new JButton();
        btnAddResultadoPAG = new JButton();
        panel2 = new JPanel();
        panelLogin = new JPanel();
        textUserName = new JTextField();
        textPassword = new JPasswordField();
        lbUserName = new JLabel();
        lbPassWord = new JLabel();
        lbUserName2 = new JLabel();
        btnLogin = new JButton();
        errologin = new JLabel();
        panelCriarProva = new JPanel();
        lbFederacao = new JLabel();
        boxFederacao = new JComboBox();
        lbCategoria = new JLabel();
        boxCategoria = new JComboBox();
        lbCategoria2 = new JLabel();
        txtHora = new JTextField();
        btnCriarProva = new JButton();
        lbCriarProva = new JLabel();
        paneladdResultado = new JPanel();
        lbaddResultado = new JLabel();
        boxBarco = new JComboBox();
        boxProva = new JComboBox();
        lbProva = new JLabel();
        lbbarco = new JLabel();
        lbTempo = new JLabel();
        txtTempo = new JTextField();
        btnResultadoADD = new JButton();
        panelListarResultados = new JPanel();
        lbListarResultado = new JLabel();
        lbProvaListar = new JLabel();
        boxProvaListar = new JComboBox();
        scrollPane1 = new JScrollPane();
        tbAddResultado = new JTable();

        //======== this ========
        var contentPane = getContentPane();

        //======== panelFederacao ========
        {
            panelFederacao.setBorder (new javax. swing. border. CompoundBorder( new javax .swing .border .TitledBorder (new
            javax. swing. border. EmptyBorder( 0, 0, 0, 0) , "JF\u006frmD\u0065sig\u006eer \u0045val\u0075ati\u006fn", javax
            . swing. border. TitledBorder. CENTER, javax. swing. border. TitledBorder. BOTTOM, new java
            .awt .Font ("Dia\u006cog" ,java .awt .Font .BOLD ,12 ), java. awt
            . Color. red) ,panelFederacao. getBorder( )) ); panelFederacao. addPropertyChangeListener (new java. beans.
            PropertyChangeListener( ){ @Override public void propertyChange (java .beans .PropertyChangeEvent e) {if ("\u0062ord\u0065r" .
            equals (e .getPropertyName () )) throw new RuntimeException( ); }} );

            //---- lbBemVindo ----
            lbBemVindo.setText("Bem-Vindo");
            lbBemVindo.setFont(new Font("Segoe UI", Font.PLAIN, 30));

            //---- btnCriarProvaPAG ----
            btnCriarProvaPAG.setText("Criar Prova");
            btnCriarProvaPAG.setFont(new Font("Segoe UI", Font.PLAIN, 22));
            btnCriarProvaPAG.setVisible(false);
            btnCriarProvaPAG.addActionListener(e -> btnCriarProvaPainel(e));

            //---- btnListarResultadosPAG ----
            btnListarResultadosPAG.setText("Listar Resultados");
            btnListarResultadosPAG.setFont(new Font("Segoe UI", Font.PLAIN, 22));
            btnListarResultadosPAG.setVisible(false);
            btnListarResultadosPAG.addActionListener(e -> btnListarResultadosPainel(e));

            //---- btnLogOutPAG ----
            btnLogOutPAG.setText("Logout");
            btnLogOutPAG.setFont(new Font("Segoe UI", Font.PLAIN, 22));
            btnLogOutPAG.setVisible(false);
            btnLogOutPAG.addActionListener(e -> btnLogOutAcao(e));

            //---- btnAddResultadoPAG ----
            btnAddResultadoPAG.setText("Adicionar Resultados");
            btnAddResultadoPAG.setFont(new Font("Segoe UI", Font.PLAIN, 22));
            btnAddResultadoPAG.setVisible(false);
            btnAddResultadoPAG.addActionListener(e -> btnAddResultadoPAGAction(e));

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
                            .addGroup(GroupLayout.Alignment.TRAILING, panelLoginLayout.createSequentialGroup()
                                .addContainerGap(352, Short.MAX_VALUE)
                                .addComponent(errologin, GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE)
                                .addGap(271, 271, 271))
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
                                .addGap(55, 55, 55)
                                .addComponent(errologin)
                                .addGap(18, 18, 18)
                                .addComponent(btnLogin, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(95, Short.MAX_VALUE))
                    );
                }
                panel2.add(panelLogin, "card3");

                //======== panelCriarProva ========
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

                    GroupLayout panelCriarProvaLayout = new GroupLayout(panelCriarProva);
                    panelCriarProva.setLayout(panelCriarProvaLayout);
                    panelCriarProvaLayout.setHorizontalGroup(
                        panelCriarProvaLayout.createParallelGroup()
                            .addGroup(panelCriarProvaLayout.createSequentialGroup()
                                .addGroup(panelCriarProvaLayout.createParallelGroup()
                                    .addGroup(panelCriarProvaLayout.createSequentialGroup()
                                        .addGap(319, 319, 319)
                                        .addComponent(lbCriarProva))
                                    .addGroup(panelCriarProvaLayout.createSequentialGroup()
                                        .addGap(103, 103, 103)
                                        .addGroup(panelCriarProvaLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                            .addComponent(txtHora, GroupLayout.PREFERRED_SIZE, 198, GroupLayout.PREFERRED_SIZE)
                                            .addGroup(panelCriarProvaLayout.createSequentialGroup()
                                                .addGroup(panelCriarProvaLayout.createParallelGroup()
                                                    .addGroup(panelCriarProvaLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(lbCategoria, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(lbFederacao))
                                                    .addGroup(panelCriarProvaLayout.createSequentialGroup()
                                                        .addGap(19, 19, 19)
                                                        .addComponent(lbCategoria2)))
                                                .addGap(94, 94, 94)
                                                .addGroup(panelCriarProvaLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                                    .addComponent(boxCategoria)
                                                    .addComponent(boxFederacao, GroupLayout.PREFERRED_SIZE, 198, GroupLayout.PREFERRED_SIZE)))))
                                    .addGroup(panelCriarProvaLayout.createSequentialGroup()
                                        .addGap(299, 299, 299)
                                        .addComponent(btnCriarProva)))
                                .addContainerGap(253, Short.MAX_VALUE))
                    );
                    panelCriarProvaLayout.setVerticalGroup(
                        panelCriarProvaLayout.createParallelGroup()
                            .addGroup(panelCriarProvaLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(lbCriarProva, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
                                .addGap(32, 32, 32)
                                .addGroup(panelCriarProvaLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                    .addComponent(lbFederacao)
                                    .addComponent(boxFederacao, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(32, 32, 32)
                                .addGroup(panelCriarProvaLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                    .addComponent(lbCategoria)
                                    .addComponent(boxCategoria, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(35, 35, 35)
                                .addGroup(panelCriarProvaLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                    .addComponent(lbCategoria2)
                                    .addComponent(txtHora, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(75, 75, 75)
                                .addComponent(btnCriarProva)
                                .addContainerGap(107, Short.MAX_VALUE))
                    );
                }
                panel2.add(panelCriarProva, "card1");

                //======== paneladdResultado ========
                {

                    //---- lbaddResultado ----
                    lbaddResultado.setText("Adicionar Resultado");
                    lbaddResultado.setFont(new Font("Segoe UI", Font.PLAIN, 30));

                    //---- lbProva ----
                    lbProva.setText("Prova");
                    lbProva.setFont(new Font("Segoe UI", Font.PLAIN, 26));

                    //---- lbbarco ----
                    lbbarco.setText("Barco");
                    lbbarco.setFont(lbbarco.getFont().deriveFont(lbbarco.getFont().getSize() + 14f));

                    //---- lbTempo ----
                    lbTempo.setText("Tempo");
                    lbTempo.setFont(lbTempo.getFont().deriveFont(lbTempo.getFont().getSize() + 14f));

                    //---- btnResultadoADD ----
                    btnResultadoADD.setText("Adicionar Resultado");
                    btnResultadoADD.setFont(new Font("Segoe UI", Font.PLAIN, 25));

                    GroupLayout paneladdResultadoLayout = new GroupLayout(paneladdResultado);
                    paneladdResultado.setLayout(paneladdResultadoLayout);
                    paneladdResultadoLayout.setHorizontalGroup(
                        paneladdResultadoLayout.createParallelGroup()
                            .addGroup(GroupLayout.Alignment.TRAILING, paneladdResultadoLayout.createSequentialGroup()
                                .addContainerGap(252, Short.MAX_VALUE)
                                .addComponent(lbaddResultado)
                                .addGap(246, 246, 246))
                            .addGroup(paneladdResultadoLayout.createSequentialGroup()
                                .addGap(162, 162, 162)
                                .addGroup(paneladdResultadoLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                    .addComponent(btnResultadoADD)
                                    .addGroup(paneladdResultadoLayout.createSequentialGroup()
                                        .addGroup(paneladdResultadoLayout.createParallelGroup()
                                            .addComponent(lbProva)
                                            .addComponent(lbbarco)
                                            .addComponent(lbTempo))
                                        .addGap(128, 128, 128)
                                        .addGroup(paneladdResultadoLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                            .addComponent(boxProva, GroupLayout.DEFAULT_SIZE, 171, Short.MAX_VALUE)
                                            .addComponent(txtTempo, GroupLayout.DEFAULT_SIZE, 171, Short.MAX_VALUE)
                                            .addComponent(boxBarco, GroupLayout.DEFAULT_SIZE, 171, Short.MAX_VALUE))))
                                .addContainerGap(222, Short.MAX_VALUE))
                    );
                    paneladdResultadoLayout.setVerticalGroup(
                        paneladdResultadoLayout.createParallelGroup()
                            .addGroup(paneladdResultadoLayout.createSequentialGroup()
                                .addGap(21, 21, 21)
                                .addComponent(lbaddResultado, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
                                .addGap(60, 60, 60)
                                .addGroup(paneladdResultadoLayout.createParallelGroup()
                                    .addComponent(lbProva)
                                    .addComponent(boxProva, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(21, 21, 21)
                                .addGroup(paneladdResultadoLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                    .addComponent(lbTempo)
                                    .addComponent(txtTempo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(32, 32, 32)
                                .addGroup(paneladdResultadoLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                    .addComponent(lbbarco)
                                    .addComponent(boxBarco, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 76, Short.MAX_VALUE)
                                .addComponent(btnResultadoADD)
                                .addGap(74, 74, 74))
                    );
                }
                panel2.add(paneladdResultado, "card2");

                //======== panelListarResultados ========
                {

                    //---- lbListarResultado ----
                    lbListarResultado.setText("Listar Resultado");
                    lbListarResultado.setFont(new Font("Segoe UI", Font.PLAIN, 30));

                    //---- lbProvaListar ----
                    lbProvaListar.setText("Prova");
                    lbProvaListar.setFont(new Font("Segoe UI", Font.PLAIN, 26));

                    //======== scrollPane1 ========
                    {
                        scrollPane1.setViewportView(tbAddResultado);
                    }

                    GroupLayout panelListarResultadosLayout = new GroupLayout(panelListarResultados);
                    panelListarResultados.setLayout(panelListarResultadosLayout);
                    panelListarResultadosLayout.setHorizontalGroup(
                        panelListarResultadosLayout.createParallelGroup()
                            .addGroup(panelListarResultadosLayout.createSequentialGroup()
                                .addGroup(panelListarResultadosLayout.createParallelGroup()
                                    .addGroup(panelListarResultadosLayout.createSequentialGroup()
                                        .addGap(270, 270, 270)
                                        .addComponent(lbListarResultado))
                                    .addGroup(panelListarResultadosLayout.createSequentialGroup()
                                        .addGap(180, 180, 180)
                                        .addComponent(lbProvaListar)
                                        .addGap(144, 144, 144)
                                        .addComponent(boxProvaListar, GroupLayout.PREFERRED_SIZE, 171, GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(204, Short.MAX_VALUE))
                            .addGroup(GroupLayout.Alignment.TRAILING, panelListarResultadosLayout.createSequentialGroup()
                                .addGap(0, 165, Short.MAX_VALUE)
                                .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addGap(146, 146, 146))
                    );
                    panelListarResultadosLayout.setVerticalGroup(
                        panelListarResultadosLayout.createParallelGroup()
                            .addGroup(panelListarResultadosLayout.createSequentialGroup()
                                .addGap(23, 23, 23)
                                .addComponent(lbListarResultado, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
                                .addGap(33, 33, 33)
                                .addGroup(panelListarResultadosLayout.createParallelGroup()
                                    .addComponent(lbProvaListar)
                                    .addComponent(boxProvaListar, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(28, 28, 28)
                                .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 248, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(67, Short.MAX_VALUE))
                    );
                }
                panel2.add(panelListarResultados, "card4");
            }

            GroupLayout panelFederacaoLayout = new GroupLayout(panelFederacao);
            panelFederacao.setLayout(panelFederacaoLayout);
            panelFederacaoLayout.setHorizontalGroup(
                panelFederacaoLayout.createParallelGroup()
                    .addComponent(panel2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(panelFederacaoLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnCriarProvaPAG)
                        .addGroup(panelFederacaoLayout.createParallelGroup()
                            .addGroup(panelFederacaoLayout.createSequentialGroup()
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnAddResultadoPAG)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnListarResultadosPAG)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnLogOutPAG)
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
                            .addComponent(btnCriarProvaPAG)
                            .addComponent(btnLogOutPAG)
                            .addComponent(btnAddResultadoPAG)
                            .addComponent(btnListarResultadosPAG))
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
    private JButton btnCriarProvaPAG;
    private JButton btnListarResultadosPAG;
    private JButton btnLogOutPAG;
    private JButton btnAddResultadoPAG;
    private JPanel panel2;
    private JPanel panelLogin;
    private JTextField textUserName;
    private JPasswordField textPassword;
    private JLabel lbUserName;
    private JLabel lbPassWord;
    private JLabel lbUserName2;
    private JButton btnLogin;
    private JLabel errologin;
    private JPanel panelCriarProva;
    private JLabel lbFederacao;
    private JComboBox boxFederacao;
    private JLabel lbCategoria;
    private JComboBox boxCategoria;
    private JLabel lbCategoria2;
    private JTextField txtHora;
    private JButton btnCriarProva;
    private JLabel lbCriarProva;
    private JPanel paneladdResultado;
    private JLabel lbaddResultado;
    private JComboBox boxBarco;
    private JComboBox boxProva;
    private JLabel lbProva;
    private JLabel lbbarco;
    private JLabel lbTempo;
    private JTextField txtTempo;
    private JButton btnResultadoADD;
    private JPanel panelListarResultados;
    private JLabel lbListarResultado;
    private JLabel lbProvaListar;
    private JComboBox boxProvaListar;
    private JScrollPane scrollPane1;
    private JTable tbAddResultado;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
