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
import java.awt.*;
public class RopaGUI extends JFrame implements ActionListener
{
private JTextField tfmaterial,tftalla,tfcolor,tftemporada,tfmodelo,tfgenero;
private JButton bAceptar;
private JPanel panel1,panel2;
private String idP,idD;

private RetailADjdbc retailad;

public RopaGUI(){
  super("Ropa GUI");

  tfmaterial=new JTextField();
  tftalla=new JTextField();
  tfcolor=new JTextField();
  tftemporada=new JTextField();
  tfmodelo=new JTextField();
  tfgenero=new JTextField();

  bAceptar=new JButton("Aceptar");
  bAceptar.addActionListener(this);

  panel1=new JPanel();
  panel2=new JPanel();

  panel1.setLayout(new GridLayout(0,2));
  panel2.setLayout(new FlowLayout());

  panel1.add(new JLabel("Material"));
  panel1.add(tfmaterial);

  panel1.add(new JLabel("Talla"));
  panel1.add(tftalla);

  panel1.add(new JLabel("Color"));
  panel1.add(tfcolor);

  panel1.add(new JLabel("Temporada"));
  panel1.add(tftemporada);

  panel1.add(new JLabel("Modelo"));
  panel1.add(tfmodelo);

  panel1.add(new JLabel("Genero"));
  panel1.add(tfgenero);


panel1.add(bAceptar);
panel2.add(panel1);

//

  add(panel2);
  setSize(500,600);
  setVisible(false);


}

public JPanel getPanel2(String i,String b){
idP=i;
idD=b;
return this.panel2;

}

public String obtenerDatos()
{
    String datos;
    String mat,talla,col,tem,mod,gen;

    mat=tfmaterial.getText();
    talla=tftalla.getText();
    col=tfcolor.getText();
    tem=tftemporada.getText();
    mod=tfmodelo.getText();
    gen=tfgenero.getText();

if(mat.isEmpty()||talla.isEmpty()||col.isEmpty()||tem.isEmpty()||mod.isEmpty()||gen.isEmpty()){
datos="VACIO";

}
else{
  datos=idP+"_"+idD+"_"+mat+"_"+talla+"_"+col+"_"+tem+"_"+mod+"_"+gen;
}

    return datos;
}
public void actionPerformed(ActionEvent e)
{
if(e.getSource()==bAceptar){
  /*
  String datos;

  datos=obtenerDatos();
  if(datos.equals("VACIO"))
respuesta = "Algun campo esta vacio...";
else
retailad.capturar("Ropa",datos);
JOptionPane.showMessageDialog( this , respuesta , "Agregar a la base" , JOptionPane.INFORMATION_MESSAGE );
*/
  }
}

public static void main(String args[])
{
    new RopaGUI();
}


}
