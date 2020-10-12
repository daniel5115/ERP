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

public class LineaBlancaGUI extends JFrame implements ActionListener
{
    private JTextField tfmarca, tftipoenergia, tfconsumoenergetico,tfcapacidad;
    private JButton bAceptar;
    private JPanel     panel1, panel2;
private RetailADjdbc retailjdbc= new RetailADjdbc();

    //private BancoAD bancoad= new BancoAD();
    //private BancoADjdbc bancoad= new BancoADjdbc();


    public LineaBlancaGUI()
    {
        super("LineaBlancaGUI");

        // 1. Crear los objetos de los atributos
        tfmarca=new JTextField();
        tfconsumoenergetico=new JTextField();
        tftipoenergia=new JTextField();
        tfcapacidad=new JTextField();

        bAceptar= new JButton("Aceptar");

        panel1 = new JPanel();
        panel2 = new JPanel();



        // Adicionar addActionListener a lo JButtons
        bAceptar.addActionListener(this);





        // 2. Definir los Layouts de los JPanels
        panel1.setLayout(new GridLayout(0,2));
        panel2.setLayout(new FlowLayout());

        // 3. Colocar los objetos de los atributos en los JPanels correspondientes
        panel1.add(new JLabel("Marca"));
        panel1.add(tfmarca);
        panel1.add(new JLabel("Tipo de Energia"));
        panel1.add(tftipoenergia);
        panel1.add(new JLabel("Consumo Energetico"));
        panel1.add(tfconsumoenergetico);
        panel1.add(new JLabel("Capacidad"));
        panel1.add(tfcapacidad);

        panel1.add(bAceptar);

        panel2.add(panel1);


        // 4. Adicionar el panel2 al JFrame y hacerlo visible
        add(panel2);
        setSize(300,300);
        setVisible(true);


    }


        private String obtenerDatos()
        {
            String datos;

            String marca  = tfmarca.getText();
            String tipEner = tftipoenergia.getText();
            String consumoenerg   = tfconsumoenergetico.getText();
            String capacidad   = tfcapacidad.getText();

            if(marca.equals("") || tipEner.isEmpty() || consumoenerg.equals("")|| capacidad.equals(""))
            {
              datos = "VACIO";
            }
            else
            {
              datos=marca+"_"+tipEner+"_"+consumoenerg+"_"+capacidad;
            }


            return datos;
        }


        public JPanel getPanel2()
        {
          return this.panel2;
        }

    public void actionPerformed(ActionEvent e)
    {
        String datos, respuesta;
        if(e.getSource() == bAceptar)
        {
          datos=obtenerDatos();
          respuesta=retailjdbc.capturar("LineaBlanca",datos);
        }

    }

    public static void main(String args[])
    {
        new LineaBlancaGUI();
    }
}
