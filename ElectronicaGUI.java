//PANEL PARA CAPTURAR ELECTRONICA 
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPanel;
//import javax.swing.JTextArea;
import javax.swing.JLabel;
//import javax.swing.JScrollPane;

import java.awt.GridLayout;
import java.awt.FlowLayout;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.*;
//PANEL PARA CAPTURAR ELECTRONICA 
public class ElectronicaGUI  extends JFrame implements ActionListener
{
    private JTextField tfMarca, tfTipo;
    private JButton    bAceptar;
    private JPanel     panel1, panel2;

    public ElectronicaGUI()
    {
        tfMarca=new JTextField();
        tfTipo=new JTextField();
        bAceptar=new JButton();

        bAceptar.addActionListener(this);
        panel1 = new JPanel();
        panel2 = new JPanel();
        panel1.setLayout(new GridLayout(2,2));
        panel2.setLayout(new FlowLayout());
        panel1.add(new JLabel("Marca"));
        panel1.add(tfMarca);
        panel1.add(new JLabel("Tipo"));
        panel1.add(tfTipo);

        panel1.add(bAceptar);

        panel2.add(panel1);

        setSize(500,600);
        setVisible(true);
    }

    public String obtenerDatos()
    {
        String datos="";
        String marca=tfMarca.getText();
        String tipo=tfTipo.getText();
        datos=marca+"_"+tipo;
        return datos;
    }
    public JPanel getPanel2(){

        return this.panel2;
        
        }
        
    public void actionPerformed(ActionEvent e)
    {
        String datos, respuesta;

        if(e.getSource() == bAceptar)
        {
            datos=obtenerDatos();
            respuesta=retailad.capturar("Electronica",datos);
        }
    }
    public static void main(String args[])
    {
    new ElectronicaGUI();
    }
}
