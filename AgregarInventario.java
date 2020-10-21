
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




public class AgregarInventario extends JFrame implements ActionListener{


private JTextField tfidProducto,tfCantidad;
private JComboBox CBCentroDistribucion;
private JButton bIngresar;


private JPanel panel1,panel2;
private RetailADjdbc retailad=new RetailADjdbc();

  public AgregarInventario(){
  super("Agregar Inventario");
tfidProducto=new JTextField();
tfCantidad=new JTextField();


bIngresar=new JButton("Ingresar cantidad");

panel1=new JPanel();
panel2=new JPanel();

CBCentroDistribucion=new JComboBox();
CBCentroDistribucion.addItem("");
CBCentroDistribucion.addItem("Monterrey");
CBCentroDistribucion.addItem("Queretaro");
CBCentroDistribucion.addItem("Yucatan");

bIngresar.addActionListener(this);
CBCentroDistribucion.addActionListener(this);

panel1.setLayout(new GridLayout(0,2));
panel2.setLayout(new FlowLayout());

panel1.add(new JLabel("Centro de distribucion"));
panel1.add(CBCentroDistribucion);
panel1.add(new JLabel("ID Producto"));
panel1.add(tfidProducto);
panel1.add(new JLabel("Cantidad"));
panel1.add(tfCantidad);
panel1.add(bIngresar);
panel2.add(panel1);

add(panel2);
setSize(500,600);
setVisible(false);
}

public JPanel getPanel2(){

    return this.panel2;

    }
private String obtenerCategoria(String a){
String fin;
      switch(a){

      case "Ropa":
         fin= "1";
        break;
      case "Libros":
        fin= "2";
        break;
      case "Vinos y Licores":
        fin= "3";
        break;
      case "Videojuegos":
        fin= "4";
        break;
      case "Linea Blanca":
        fin= "5";
        break;
      case "Muebles":
        fin= "6";
        break;
      case "Electronica":
      fin= "7";
      break;
     default:
    fin="";
      }
return fin;
    }
public String obtenerDatos(String d){
String datos;
String cd,prod,cant;
cd=d;
prod=tfidProducto.getText();
cant=tfCantidad.getText();
if(cd.equals("")||prod.equals("")||cant.equals(""))
datos="VACIO";
else{
  datos=cd+"_"+prod+"_"+cant;
}
return datos;
}
public void actionPerformed(ActionEvent e){
  String datos,respuesta,depto;

if(e.getSource()==bIngresar){
   depto= (String) CBCentroDistribucion.getSelectedItem();
   depto=obtenerCategoria(depto);
  datos=obtenerDatos(depto);

    if(datos.equals("VACIO")){
respuesta="ALGUN CAMPO ESTA VACIO";
   }
   else{
  respuesta=retailad.capturar("Inventario",datos);
  }

  }

}

public static void main(String args[]){
  new AgregarInventario();
}
}
