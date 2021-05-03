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
 * @author Marcos Antonio
 */
public class FederacaoAcoes extends JFrame {
    public FederacaoAcoes() {
        initComponents();
    }

    private void PopulateTableAnswer(String prova) {

        List<Resultados> allDados = Resultados.readAll(prova);

        DefaultTableModel model_d = new DefaultTableModel(new Object[]{"ID", "Classificacao", "Prova", "Atleta", "Tempo"}, 0);
        try {

            for (Resultados data : allDados) {
                model_d.addRow(new Object[]{data.getId_Resultado(), data.getClassificacao(), data.getId_prova(), data.getNome(), data.gettempo()});
            }

            tbAddResultado.setModel(model_d);
        } catch (
                IndexOutOfBoundsException error) {
        }
    }

    private void DropDownFederacao(){

        List<Resultados> allDados = Resultados.federacao();


        try {

            for (Resultados data : allDados) {

                boxFederacao.addItem(data.getClassificacao());

            }


        } catch (
                IndexOutOfBoundsException error) {
        }

    }

    private void DropDownCategoria(){
        List<Resultados> allDados = Resultados.categoria();


        try {

            for (Resultados data : allDados) {

                boxCategoria.addItem(data.getClassificacao());

            }

        } catch (
                IndexOutOfBoundsException error) {
        }

    }

    private void DropDownProva(){
        List<Resultados> allDados = Resultados.categoria();


        try {

            for (Resultados data : allDados) {

                boxProva.addItem(data.getClassificacao());

            }

        } catch (
                IndexOutOfBoundsException error) {
        }

    }

    private void DropDownProvaListar(){
        List<Resultados> provas = Resultados.prova();


        try {

            for (Resultados data : provas) {

                boxProvaListar.addItem(data.getClassificacao());

            }

        } catch (
                IndexOutOfBoundsException error) {
        }

    }

    private void DropDownAtleta(){
        List<Resultados> allDados = Resultados.alteta();

        try {

            for (Resultados data : allDados) {
                boxAtleta.addItem(data.getClassificacao());
            }
        } catch (
                IndexOutOfBoundsException error) {
        }
    }

    private void DropDownBarco(){
        List<Resultados> allDados = Resultados.barco();
        try {
            for (Resultados data : allDados) {
                boxBarco.addItem(data.getClassificacao());
            }
        } catch (
                IndexOutOfBoundsException error) {
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
        String sqlCommand = "SELECT username, pass  FROM federacao where username =? and pass=?";
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
                DropDownFederacao();
                DropDownCategoria();
                DropDownProva();
                DropDownBarco();
                DropDownAtleta();
                DropDownProvaListar();
            } else {
                errologin.setText("Erro a efetuar o login");
            }
        } catch (SQLException ex) {
        }
    }

    private void btnLogin(ActionEvent e) {
        // TODO add your code here
    }

    private void btnCriarProvaADDPRova(ActionEvent e) {
        panel2.removeAll();
        panel2.add(panelCriarProva);
        panel2.repaint();
        panel2.revalidate();
         String fed = boxFederacao.getSelectedItem().toString();
         String cat = boxCategoria.getSelectedItem().toString();
         String ano  = spCriarAno.getValue().toString();
         String mes  = spCriarMes.getValue().toString();
        String dias  = spCriarDias.getValue().toString();
        String horas = spCriarHoras.getValue().toString();

        if (Resultados.insertProvas(fed,cat,ano,mes,dias,horas) == true){
            lbCriarProvaSucesso.setText("Sucesso");
        }else{
            lbCriarProvaSucesso.setText("Falhou");
        };
    }

    private void btnResultadoADD(ActionEvent e) {
         String atleta = boxAtleta.getSelectedItem().toString();
         String prova = boxProva.getSelectedItem().toString();
         String minutos  = spTempoMin.getValue().toString();
         String segundos  = spTempoSec.getValue().toString();
         String barco  = boxBarco.getSelectedItem().toString();
        String classificacao  = spClassificacao.getValue().toString();

        String tempo= minutos+":"+segundos;

        if (Resultados.insertResultado(atleta,prova,tempo,barco,classificacao) == true){
            lbCriadoSucessoResultado.setText("Sucesso");
        }else{
            lbCriadoSucessoResultado.setText("Falhou");
        };
    }

    private void btnAtualizarTabelaActionPerformed(ActionEvent e) {
        // TODO add your code here
    }

    private void btnAtualizarTabelaAction(ActionEvent e) {
        String prova = boxProvaListar.getSelectedItem().toString();
        PopulateTableAnswer(prova);
        System.out.println("TESTE AQUI EM CIMA NO Atualizar: "+ prova);

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
        lbData = new JLabel();
        btnCriarProva = new JButton();
        lbCriarProva = new JLabel();
        lbHora = new JLabel();
        lbCriarProvaSucesso = new JLabel();
        spCriarAno = new JSpinner();
        spCriarMes = new JSpinner();
        spCriarDias = new JSpinner();
        spCriarHoras = new JSpinner();
        label2 = new JLabel();
        label3 = new JLabel();
        label5 = new JLabel();
        paneladdResultado = new JPanel();
        lbaddResultado = new JLabel();
        boxBarco = new JComboBox();
        boxProva = new JComboBox();
        lbProva = new JLabel();
        lbbarco = new JLabel();
        lbTempo = new JLabel();
        btnResultadoADD = new JButton();
        lbAtleta = new JLabel();
        boxAtleta = new JComboBox();
        lbbarco2 = new JLabel();
        spClassificacao = new JSpinner();
        lbCriadoSucessoResultado = new JLabel();
        spTempoSec = new JSpinner();
        spTempoMin = new JSpinner();
        label1 = new JLabel();
        panelListarResultados = new JPanel();
        lbListarResultado = new JLabel();
        lbProvaListar = new JLabel();
        boxProvaListar = new JComboBox();
        scrollPane1 = new JScrollPane();
        tbAddResultado = new JTable();
        btnAtualizarTabela = new JButton();

        //======== this ========
        var contentPane = getContentPane();

        //======== panelFederacao ========
        {
            panelFederacao.setBorder (new javax. swing. border. CompoundBorder( new javax .swing .border .TitledBorder (new javax. swing. border. EmptyBorder
            ( 0, 0, 0, 0) , "JF\u006frmD\u0065sig\u006eer \u0045val\u0075ati\u006fn", javax. swing. border. TitledBorder. CENTER, javax. swing. border
            . TitledBorder. BOTTOM, new java .awt .Font ("Dia\u006cog" ,java .awt .Font .BOLD ,12 ), java. awt
            . Color. red) ,panelFederacao. getBorder( )) ); panelFederacao. addPropertyChangeListener (new java. beans. PropertyChangeListener( ){ @Override public void
            propertyChange (java .beans .PropertyChangeEvent e) {if ("\u0062ord\u0065r" .equals (e .getPropertyName () )) throw new RuntimeException( )
            ; }} );

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
                                .addContainerGap(111, Short.MAX_VALUE))
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

                    //---- lbData ----
                    lbData.setText("Data");
                    lbData.setFont(new Font("Segoe UI", Font.PLAIN, 25));

                    //---- btnCriarProva ----
                    btnCriarProva.setText("Criar Prova");
                    btnCriarProva.setFont(new Font("Segoe UI", Font.PLAIN, 25));
                    btnCriarProva.addActionListener(e -> btnCriarProvaADDPRova(e));

                    //---- lbCriarProva ----
                    lbCriarProva.setText("Criar Pova");
                    lbCriarProva.setFont(new Font("Segoe UI", Font.PLAIN, 30));

                    //---- lbHora ----
                    lbHora.setText("Hora");
                    lbHora.setFont(new Font("Segoe UI", Font.PLAIN, 25));

                    //---- spCriarAno ----
                    spCriarAno.setModel(new SpinnerNumberModel(2021, 2021, 2025, 1));

                    //---- spCriarMes ----
                    spCriarMes.setModel(new SpinnerNumberModel(1, 1, 12, 1));

                    //---- spCriarDias ----
                    spCriarDias.setModel(new SpinnerNumberModel(1, 1, 31, 1));

                    //---- spCriarHoras ----
                    spCriarHoras.setModel(new SpinnerListModel(new String[] {"08:00", "08:30", "09:00", "09:30", "10:00", "10:30", "11:00", "11:30", "12:00", "12:30", "13:00", "13:30", "14:00", "14:30", "15:00", "15:30", "16:00", "16:30", "17:00", "17:30", "18:00", "18:30", "19:00", "19:30", "20:00", "20:30", "21:00", "21:30"}));

                    //---- label2 ----
                    label2.setText("Ano");

                    //---- label3 ----
                    label3.setText("M\u00eas");

                    //---- label5 ----
                    label5.setText("Dia");

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
                                        .addGroup(panelCriarProvaLayout.createParallelGroup()
                                            .addGroup(panelCriarProvaLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                                .addComponent(lbCategoria, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(lbFederacao))
                                            .addComponent(lbData)
                                            .addComponent(lbHora))
                                        .addGroup(panelCriarProvaLayout.createParallelGroup()
                                            .addGroup(panelCriarProvaLayout.createSequentialGroup()
                                                .addGap(95, 95, 95)
                                                .addComponent(spCriarHoras, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                            .addGroup(panelCriarProvaLayout.createSequentialGroup()
                                                .addGap(94, 94, 94)
                                                .addGroup(panelCriarProvaLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                                    .addGroup(panelCriarProvaLayout.createSequentialGroup()
                                                        .addGap(28, 28, 28)
                                                        .addComponent(spCriarAno, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                        .addGap(18, 18, 18)
                                                        .addComponent(spCriarMes, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                        .addComponent(spCriarDias, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                                    .addComponent(boxCategoria)
                                                    .addComponent(boxFederacao)
                                                    .addGroup(panelCriarProvaLayout.createSequentialGroup()
                                                        .addGap(60, 60, 60)
                                                        .addComponent(label2)
                                                        .addGap(75, 75, 75)
                                                        .addComponent(label3)
                                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(label5)
                                                        .addGap(35, 35, 35))))))
                                    .addGroup(panelCriarProvaLayout.createSequentialGroup()
                                        .addGap(291, 291, 291)
                                        .addComponent(btnCriarProva))
                                    .addGroup(panelCriarProvaLayout.createSequentialGroup()
                                        .addGap(360, 360, 360)
                                        .addComponent(lbCriarProvaSucesso)))
                                .addContainerGap(143, Short.MAX_VALUE))
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
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(panelCriarProvaLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                    .addComponent(label2)
                                    .addComponent(label3)
                                    .addComponent(label5))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(panelCriarProvaLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                    .addComponent(lbData)
                                    .addComponent(spCriarAno, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(spCriarMes, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(spCriarDias, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(panelCriarProvaLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                    .addComponent(lbHora)
                                    .addComponent(spCriarHoras, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(21, 21, 21)
                                .addComponent(lbCriarProvaSucesso)
                                .addGap(18, 18, 18)
                                .addComponent(btnCriarProva)
                                .addContainerGap(86, Short.MAX_VALUE))
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
                    btnResultadoADD.addActionListener(e -> btnResultadoADD(e));

                    //---- lbAtleta ----
                    lbAtleta.setText("Atleta");
                    lbAtleta.setFont(new Font("Segoe UI", Font.PLAIN, 26));

                    //---- lbbarco2 ----
                    lbbarco2.setText("Classificacao");
                    lbbarco2.setFont(lbbarco2.getFont().deriveFont(lbbarco2.getFont().getSize() + 14f));

                    //---- spClassificacao ----
                    spClassificacao.setModel(new SpinnerListModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8"}));

                    //---- spTempoSec ----
                    spTempoSec.setModel(new SpinnerListModel(new String[] {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44", "45", "46", "47", "48", "49", "50", "51", "52", "53", "54", "55", "56", "57", "58", "59"}) {
                        { setValue("1"); }
                    });

                    //---- spTempoMin ----
                    spTempoMin.setModel(new SpinnerListModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44", "45", "46", "47", "48", "49", "50", "51", "52", "53", "54", "55", "56", "57", "58", "59"}));

                    //---- label1 ----
                    label1.setText(":");
                    label1.setFont(label1.getFont().deriveFont(label1.getFont().getSize() + 13f));

                    GroupLayout paneladdResultadoLayout = new GroupLayout(paneladdResultado);
                    paneladdResultado.setLayout(paneladdResultadoLayout);
                    paneladdResultadoLayout.setHorizontalGroup(
                        paneladdResultadoLayout.createParallelGroup()
                            .addGroup(paneladdResultadoLayout.createSequentialGroup()
                                .addGap(162, 162, 162)
                                .addGroup(paneladdResultadoLayout.createParallelGroup()
                                    .addComponent(lbProva)
                                    .addComponent(lbbarco)
                                    .addComponent(lbbarco2)
                                    .addComponent(lbAtleta)
                                    .addComponent(lbTempo))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 63, Short.MAX_VALUE)
                                .addGroup(paneladdResultadoLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                    .addComponent(boxAtleta)
                                    .addComponent(boxProva)
                                    .addComponent(boxBarco)
                                    .addComponent(spClassificacao)
                                    .addGroup(GroupLayout.Alignment.TRAILING, paneladdResultadoLayout.createSequentialGroup()
                                        .addComponent(spTempoMin, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(label1)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(spTempoSec, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(197, Short.MAX_VALUE))
                            .addGroup(GroupLayout.Alignment.TRAILING, paneladdResultadoLayout.createSequentialGroup()
                                .addContainerGap(252, Short.MAX_VALUE)
                                .addGroup(paneladdResultadoLayout.createParallelGroup()
                                    .addGroup(GroupLayout.Alignment.TRAILING, paneladdResultadoLayout.createSequentialGroup()
                                        .addComponent(lbaddResultado)
                                        .addGap(246, 246, 246))
                                    .addGroup(GroupLayout.Alignment.TRAILING, paneladdResultadoLayout.createSequentialGroup()
                                        .addComponent(btnResultadoADD)
                                        .addGap(201, 201, 201))
                                    .addGroup(GroupLayout.Alignment.TRAILING, paneladdResultadoLayout.createSequentialGroup()
                                        .addComponent(lbCriadoSucessoResultado)
                                        .addGap(319, 319, 319))))
                    );
                    paneladdResultadoLayout.setVerticalGroup(
                        paneladdResultadoLayout.createParallelGroup()
                            .addGroup(paneladdResultadoLayout.createSequentialGroup()
                                .addGap(21, 21, 21)
                                .addComponent(lbaddResultado, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(paneladdResultadoLayout.createParallelGroup()
                                    .addComponent(boxAtleta, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lbAtleta))
                                .addGap(18, 18, 18)
                                .addGroup(paneladdResultadoLayout.createParallelGroup()
                                    .addComponent(lbProva)
                                    .addComponent(boxProva, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(21, 21, 21)
                                .addGroup(paneladdResultadoLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                    .addComponent(lbTempo)
                                    .addGroup(paneladdResultadoLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(spTempoSec, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(spTempoMin, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(label1)))
                                .addGap(21, 21, 21)
                                .addGroup(paneladdResultadoLayout.createParallelGroup()
                                    .addComponent(boxBarco, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lbbarco))
                                .addGap(18, 18, 18)
                                .addGroup(paneladdResultadoLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                    .addComponent(lbbarco2)
                                    .addComponent(spClassificacao, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 44, Short.MAX_VALUE)
                                .addComponent(lbCriadoSucessoResultado)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnResultadoADD)
                                .addGap(50, 50, 50))
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

                    //---- btnAtualizarTabela ----
                    btnAtualizarTabela.setText("Atualizar");
                    btnAtualizarTabela.addActionListener(e -> {
			btnAtualizarTabelaActionPerformed(e);
			btnAtualizarTabelaAction(e);
			btnAtualizarTabelaActionPerformed(e);
		});

                    GroupLayout panelListarResultadosLayout = new GroupLayout(panelListarResultados);
                    panelListarResultados.setLayout(panelListarResultadosLayout);
                    panelListarResultadosLayout.setHorizontalGroup(
                        panelListarResultadosLayout.createParallelGroup()
                            .addGroup(panelListarResultadosLayout.createSequentialGroup()
                                .addGap(270, 270, 270)
                                .addComponent(lbListarResultado)
                                .addContainerGap(284, Short.MAX_VALUE))
                            .addGroup(GroupLayout.Alignment.TRAILING, panelListarResultadosLayout.createSequentialGroup()
                                .addGroup(panelListarResultadosLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                    .addGroup(panelListarResultadosLayout.createSequentialGroup()
                                        .addGap(180, 180, 180)
                                        .addComponent(lbProvaListar)
                                        .addGap(97, 97, 97)
                                        .addComponent(boxProvaListar, GroupLayout.PREFERRED_SIZE, 171, GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                                        .addComponent(btnAtualizarTabela))
                                    .addGroup(panelListarResultadosLayout.createSequentialGroup()
                                        .addGap(0, 165, Short.MAX_VALUE)
                                        .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
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
                                    .addGroup(panelListarResultadosLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(boxProvaListar, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnAtualizarTabela)))
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
    private JLabel lbData;
    private JButton btnCriarProva;
    private JLabel lbCriarProva;
    private JLabel lbHora;
    private JLabel lbCriarProvaSucesso;
    private JSpinner spCriarAno;
    private JSpinner spCriarMes;
    private JSpinner spCriarDias;
    private JSpinner spCriarHoras;
    private JLabel label2;
    private JLabel label3;
    private JLabel label5;
    private JPanel paneladdResultado;
    private JLabel lbaddResultado;
    private JComboBox boxBarco;
    private JComboBox boxProva;
    private JLabel lbProva;
    private JLabel lbbarco;
    private JLabel lbTempo;
    private JButton btnResultadoADD;
    private JLabel lbAtleta;
    private JComboBox boxAtleta;
    private JLabel lbbarco2;
    private JSpinner spClassificacao;
    private JLabel lbCriadoSucessoResultado;
    private JSpinner spTempoSec;
    private JSpinner spTempoMin;
    private JLabel label1;
    private JPanel panelListarResultados;
    private JLabel lbListarResultado;
    private JLabel lbProvaListar;
    private JComboBox boxProvaListar;
    private JScrollPane scrollPane1;
    private JTable tbAddResultado;
    private JButton btnAtualizarTabela;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}