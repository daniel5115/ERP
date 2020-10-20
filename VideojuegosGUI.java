import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JComboBox;

import java.awt.GridLayout;
import java.awt.FlowLayout;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VideojuegosGUI extends JFrame implements ActionListener
{
    private JTextField tfclasificacion, tftitulo, tfconsola;
    private JButton bAceptar;
    private JPanel     panel1, panel2;
    private String idP,idD;
private RetailADjdbc retailjdbc= new RetailADjdbc();

    //private BancoAD bancoad= new BancoAD();
    //private BancoADjdbc bancoad= new BancoADjdbc();


    public VideojuegosGUI()
    {
        super("VideojuegosGUI");

        // 1. Crear los objetos de los atributos
        tfclasificacion=new JTextField();
        tfconsola=new JTextField();
        tftitulo=new JTextField();

        bAceptar= new JButton("Aceptar");

        panel1 = new JPanel();
        panel2 = new JPanel();



        // Adicionar addActionListener a lo JButtons
        bAceptar.addActionListener(this);





        // 2. Definir los Layouts de los JPanels
        panel1.setLayout(new GridLayout(0,2));
        panel2.setLayout(new FlowLayout());

        // 3. Colocar los objetos de los atributos en los JPanels correspondientes
        panel1.add(new JLabel("Clasificacion"));
        panel1.add(tfclasificacion);
        panel1.add(new JLabel("Titulo"));
        panel1.add(tftitulo);
        panel1.add(new JLabel("Consola"));
        panel1.add(tfconsola);


        panel1.add(bAceptar);

        panel2.add(panel1);


        // 4. Adicionar el panel2 al JFrame y hacerlo visible
        add(panel2);
        setSize(300,300);
        setVisible(false);


    }

    private String obtenerDatos()
    {
        String datos;

        String clasif  = tfclasificacion.getText();
        String tit = tftitulo.getText();
        String consol   = tfconsola.getText();

        if(clasif.equals("") || tit.isEmpty() || consol.equals(""))
        {
          datos = "VACIO";
        }
        else
        {
          datos = clasif+"_"+tit+"_"+consol;
        }


        return datos;
    }


    public JPanel getPanel2(String a,String b)
    {
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
            respuesta=retailjdbc.capturar("Videojuegos",datos);
        }

    }

    public static void main(String args[])
    {
        new VideojuegosGUI();
    }
}
