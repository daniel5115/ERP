//PANEL PARA CAPTURAR MUEBLE
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
//PANEL PARA CAPTURAR MUEBLE
public class MueblesGUI  extends JFrame implements ActionListener
{
    private JTextField tfLinea, tfColor, tfMarca, tfAcabados;
    private JButton    bAceptar;
    private JPanel     panel1, panel2;
        private String idP,idD;

    public MueblesGUI()
    {
        tfLinea=new JTextField();
        tfColor=new JTextField();
        tfMarca=new JTextField();
        tfAcabados=new JTextField();
        bAceptar=new JButton();

        bAceptar.addActionListener(this);
        panel1 = new JPanel();
        panel2 = new JPanel();
        panel1.setLayout(new GridLayout(5,2));
        panel2.setLayout(new FlowLayout());
        panel1.add(new JLabel("Linea"));
        panel1.add(tfLinea);
        panel1.add(new JLabel("Color"));
        panel1.add(tfColor);
        panel1.add(new JLabel("Marca"));
        panel1.add(tfMarca);
        panel1.add(new JLabel("Acabados"));
        panel1.add(tfAcabados);

        panel1.add(bAceptar);

        panel2.add(panel1);
        setSize(500,600);
        setVisible(false);
    }

    public String obtenerDatos()
    {
        String datos="";
        String linea=tfLinea.getText();
        String color=tfColor.getText();
        String marca=tfMarca.getText();
        String acabados=tfAcabados.getText();
        datos=idD+"_"+idP+"_"+linea+"_"+color+"_"+marca+"_"+acabados;
        return datos;
    }
    public JPanel getPanel2(String a,String b){
        idP=a;
        idD=b;
        return this.panel2;

        }

    public void actionPerformed(ActionEvent e)
    {
        String datos, respuesta;

        if(e.getSource() == bAceptar)
        {
            datos=obtenerDatos();
            //respuesta=retailad.capturar("Mueble",datos);
        }
    }
    public static void main(String args[])
    {
    new MueblesGUI();
    }
}
