import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JScrollPane;

import java.awt.GridLayout;
import java.awt.FlowLayout;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.*;

public class LibroGUI extends JFrame implements ActionListener
{
    private JTextField tfEditorial, tfAutor, tfGenero;
    private JButton    bAceptar;
    private JPanel     panel1,panel2;

    private String idP,idD;
private RetailADjdbc retailad= new RetailADjdbc();


    public LibroGUI()
    {
        super("Libros");

        tfEditorial=new JTextField();
        tfAutor=new JTextField();
        tfGenero=new JTextField();

        bAceptar = new JButton("Aceptar");
        panel1 = new JPanel();
        panel2 = new JPanel();


        bAceptar.addActionListener(this);
        panel1.setLayout(new GridLayout(0,2));
        panel2.setLayout(new FlowLayout());

        panel1.add(new JLabel("Editorial"));
        panel1.add(tfEditorial);
        panel1.add(new JLabel("Autor"));
        panel1.add(tfAutor);
        panel1.add(new JLabel("Genero"));
        panel1.add(tfGenero);
        panel1.add(bAceptar);
        panel2.add(panel1);
        add(panel2);
        setSize(500,600);
        setVisible(false);


    }

    public String obtenerDatos()
    {
        String datos="";
        String editorial=tfEditorial.getText();
        String autor=tfAutor.getText();
        String genero=tfGenero.getText();
        datos=editorial+"_"+autor+"_"+genero;
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
            respuesta=retailad.capturar("Libros",datos);
        }
    }

    public static void main(String args[])
    {
        new LibroGUI();
    }
}
