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

public class VinosLicoresGUI extends JFrame implements ActionListener
{
    private JTextField tfPresentacion,tfGradoDeAlcohol,tfMarca,tfTipo,tfPaisOrigen;
    private JButton    bAceptar;
    private JPanel     panel1,panel2;
        private String idP,idD;
    RetailADjdbc retailad= new RetailADjdbc();

    public VinosLicoresGUI()
    {
        super("Vinos y Licores");

        tfPresentacion=new JTextField();
        tfGradoDeAlcohol=new JTextField();
        tfMarca=new JTextField();
        tfTipo=new JTextField();
        tfPaisOrigen= new JTextField();

        bAceptar = new JButton("Aceptar");
        panel1 = new JPanel();
        panel2 = new JPanel();


        bAceptar.addActionListener(this);
        panel1.setLayout(new GridLayout(0,2));
        panel2.setLayout(new FlowLayout());

        panel1.add(new JLabel("Presentacion"));
        panel1.add(tfPresentacion);
        panel1.add(new JLabel("Grado de alcohol"));
        panel1.add(tfGradoDeAlcohol);
        panel1.add(new JLabel("Marca"));
        panel1.add(tfMarca);
        panel1.add(new JLabel("Tipo"));
        panel1.add(tfTipo);
        panel1.add(new JLabel("Pais de Origen"));
        panel1.add(tfPaisOrigen);
        panel1.add(bAceptar);
        panel2.add(panel1);
        add(panel2);
        setSize(500,600);
        setVisible(false);


    }

    public String obtenerDatos()
    {
        String datos="";
        String presentacion=tfPresentacion.getText();
        String gradoAlcohol=tfGradoDeAlcohol.getText();
        String marca=tfMarca.getText();
        String tipo=tfTipo.getText();
        String paisOrigen=tfPaisOrigen.getText();

        datos=presentacion+"_"+gradoAlcohol+"_"+marca+"_"+tipo+"_"+paisOrigen;
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
        new VinosLicoresGUI();
    }
}
