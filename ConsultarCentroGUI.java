
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





public class ConsultarCentroGUI extends JFrame implements ActionListener{
private JButton bConsultarCentro;
private JTextArea taDatos;
private JPanel panel1,panel2;
private JComboBox CBCentroDistribucion ;
private String fin;
private RetailADjdbc retailad=new RetailADjdbc();

public ConsultarCentroGUI(){
super("Consultar Centro");

bConsultarCentro=new JButton("Consultar Centro de distribucion");


taDatos=new JTextArea(30,35);

panel1=new JPanel();
panel2=new JPanel();

CBCentroDistribucion=new JComboBox();
CBCentroDistribucion.addItem("");
CBCentroDistribucion.addItem("Global");
CBCentroDistribucion.addItem("Monterrey");
CBCentroDistribucion.addItem("Queretaro");
CBCentroDistribucion.addItem("Yucatan");


bConsultarCentro.addActionListener(this);

CBCentroDistribucion.addActionListener(this);

panel1.setLayout(new GridLayout(0,2));
panel2.setLayout(new FlowLayout());

panel1.add(CBCentroDistribucion);
panel1.add(bConsultarCentro);

//panel1.add(taDatos);

panel2.add(panel1);
panel2.add(new JScrollPane(taDatos));

add(panel2);
setSize(500,600);
setVisible(false);
}

public JPanel getPanel2(){
  return this.panel2;
}
public void obtenerCentro(String a){
  switch(a){

  case "Monterrey":
     fin= "1";
    break;
  case "Queretaro":
   fin= "2";
   break;
   case "Yucatan":
    fin= "3";
    break;
    default:
    fin="Global";
  }

}
 public void actionPerformed(ActionEvent e){
   String datos,respuesta;
   if(e.getSource()==bConsultarCentro){
     fin=(String) CBCentroDistribucion.getSelectedItem();
     obtenerCentro(fin);

     datos = retailad.consultarCentro(fin,"Buscar");

     // 2. Desplegar los datos de los automoviles
     taDatos.setText(datos);
   }

 }





public static void main(String args[]){
new ConsultarCentroGUI();
   }
}
