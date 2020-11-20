
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
private JButton bIngresar,bBuscar;


private JPanel panel1,panel2;
private RetailADjdbc retailad=new RetailADjdbc();

  public AgregarInventario(){
  super("Agregar Inventario");
tfidProducto=new JTextField();
tfCantidad=new JTextField();
//tfnuevaCanti=new JTextField();


bIngresar=new JButton("Ingresar cantidad");
bBuscar=new JButton("Buscar producto");


panel1=new JPanel();
panel2=new JPanel();

CBCentroDistribucion=new JComboBox();
CBCentroDistribucion.addItem("");
CBCentroDistribucion.addItem("Monterrey");
CBCentroDistribucion.addItem("Queretaro");
CBCentroDistribucion.addItem("Yucatan");

bIngresar.addActionListener(this);
CBCentroDistribucion.addActionListener(this);
bBuscar.addActionListener(this);
bIngresar.setEnabled(false);
//tfnuevaCanti.setEnabled(false);
panel1.setLayout(new GridLayout(0,2));
panel2.setLayout(new FlowLayout());

panel1.add(new JLabel("Centro de distribucion"));
panel1.add(CBCentroDistribucion);
panel1.add(new JLabel("ID Producto"));
panel1.add(tfidProducto);
panel1.add(new JLabel("Cantidad"));
panel1.add(tfCantidad);
//panel1.add(new JLabel("Cantidad nueva que"))
panel1.add(bBuscar);
panel1.add(bIngresar);
panel2.add(panel1);

add(panel2);
setSize(500,600);
setVisible(false);
}

public JPanel getPanel2(){

    return this.panel2;

    }
public String obtenerCentro(String a){
  String fin;
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
        fin="NADA";
      }
return fin;
    }

public String obtenerDatos(String d){

String datos;
String cd,prod,cant;
cd=d;
prod=tfidProducto.getText();
cant=tfCantidad.getText();
if(cd.equals("")||prod.equals(""))//RECUERDA TIENES QUE CORREGIR QUE CANTIDAD ESTE VACION
datos="VACIO";
else{
  datos=cd+"_"+prod+"_"+cant;
}
return datos;
}

public void actionPerformed(ActionEvent e){
  String datos,respuesta,id,centro;

if(e.getSource()==bBuscar){
  centro= (String) CBCentroDistribucion.getSelectedItem();
  centro= obtenerCentro(centro);
  //centro=obtenerDatos(centro);
  id=tfidProducto.getText();
  datos=obtenerDatos(centro);
  if(datos.equals("VACIO")){
    respuesta="ALGUN CAMPO ESTA VACIO";
   }
   else{
   respuesta=retailad.consultarCentroProducto(centro,id);
   System.out.println(respuesta);
   tfCantidad.setText(respuesta);
   bIngresar.setEnabled(true);
    }
  }
if(e.getSource()==bIngresar){
  // depto=obtenerCategoria(depto);
  centro= (String) CBCentroDistribucion.getSelectedItem();
  centro= obtenerCentro(centro);
  datos=obtenerDatos(centro);

    if(datos.equals("VACIO") ||tfCantidad.getText().equals("")){
respuesta="ALGUN CAMPO ESTA VACIO";
   }
   else{
  respuesta=retailad.actualizar("Inventario",datos);
  }

  }

}

public static void main(String args[]){
  new AgregarInventario();
}
}
