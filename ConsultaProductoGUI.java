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

public class ConsultaProductoGUI extends JFrame implements ActionListener
{
    private JTextField tfidProducto, tfNombre, tfPrecioVenta, tfTemporada;
    private JComboBox  CBestado, CBestadoPromocion, CBdepartamento,CBCentroDistribucion;
    private JButton    bSalir,bBuscarProductoNombre,bBuscarProductoID,bBuscarPrecio,bBuscarTemporada, bBuscarTodo,bBuscarDept,bBuscarEstado,bBuscarEstadoPromocion;
    private JPanel     panel1, panel2;
    private JTextArea  taDatos;
    private String fin;

private RetailADjdbc retailad=new RetailADjdbc();

    public ConsultaProductoGUI()
    {
        super("Consulta de producto");

        tfidProducto=new JTextField();
        tfNombre=new JTextField();
        tfPrecioVenta=new JTextField();
        tfTemporada=new JTextField();
        bBuscarProductoID= new JButton("Buscar producto por Id");
        bBuscarProductoNombre= new JButton("Buscar producto por nombre");
        bBuscarPrecio= new JButton("Buscar por precio");
        bBuscarTemporada= new JButton("Buscar por temporada");
        bBuscarTodo= new JButton("Ver todos los productos");
        bBuscarEstado= new JButton("Buscar por estado de disponibilidad");
        bBuscarEstadoPromocion= new JButton("Buscar por estado de promocion");
        bBuscarDept= new JButton("Buscar por departamento");

        bBuscarTemporada.setEnabled(false);
        tfTemporada.setEnabled(false);
        CBdepartamento= new JComboBox();
        CBdepartamento.addItem("");
        CBdepartamento.addItem("Ropa");
        CBdepartamento.addItem("Libros");
        CBdepartamento.addItem("Vinos y Licores");
        CBdepartamento.addItem("Videojuegos");
        CBdepartamento.addItem("Linea Blanca");
        CBdepartamento.addItem("Muebles");
        CBdepartamento.addItem("Electronica");
        CBestado= new JComboBox();
        CBestado.addItem("");
        CBestado.addItem("Disponible");
        CBestado.addItem("Agotado");
        CBestado.addItem("Descontinuado");
        CBestadoPromocion= new JComboBox();
        CBestadoPromocion.addItem("");
        CBestadoPromocion.addItem("Con promocion");
        CBestadoPromocion.addItem("Sin promocion");
        CBCentroDistribucion= new JComboBox();
        CBCentroDistribucion.addItem("");
        CBCentroDistribucion.addItem("Monterrey");
        CBCentroDistribucion.addItem("Queretaro");
        CBCentroDistribucion.addItem("Yucatan");
        bSalir = new JButton("Exit");
        panel1 = new JPanel();
        panel2 = new JPanel();
        taDatos = new JTextArea(10,35);
        CBestado.setSelectedIndex(-1);
        CBestadoPromocion.setSelectedIndex(-1);
        CBdepartamento.setSelectedIndex(-1);

        // Adicionar addActionListener a lo JButtons

        bBuscarProductoID.addActionListener(this);
        bBuscarProductoNombre.addActionListener(this);
        bBuscarPrecio.addActionListener(this);
        bBuscarTemporada.addActionListener(this);
        bBuscarTodo.addActionListener(this);
        bBuscarDept.addActionListener(this);
        bBuscarEstado.addActionListener(this);
        bBuscarEstadoPromocion.addActionListener(this);
        CBdepartamento.addActionListener(this);
        CBestado.addActionListener(this);
        CBestadoPromocion.addActionListener(this);
        CBCentroDistribucion.addActionListener(this);
        bSalir.addActionListener(this);



        // 2. Definir los Layouts de los JPanels
        panel1.setLayout(new GridLayout(0,2));
        panel2.setLayout(new FlowLayout());

        // 3. Colocar los objetos de los atributos en los JPanels correspondientes
        panel1.add(new JLabel("ID producto"));
        panel1.add(tfidProducto);
        panel1.add(new JLabel("Nombre"));
        panel1.add(tfNombre);
        panel1.add(new JLabel("Departamento"));
        panel1.add(CBdepartamento);
        panel1.add(new JLabel("Precio Venta"));
        panel1.add(tfPrecioVenta);
        panel1.add(new JLabel("Temporada"));
        panel1.add(tfTemporada);
        panel1.add(new JLabel("Estado"));
        panel1.add(CBestado);
        panel1.add(new JLabel("Estado de promocion"));
        panel1.add(CBestadoPromocion);
        //panel1.add(new JLabel("Centro de distribucion"));
        //panel1.add(CBCentroDistribucion);
        panel1.add(bBuscarProductoID);
        panel1.add(bBuscarProductoNombre);
        panel1.add(bBuscarPrecio);
        panel1.add(bBuscarTemporada);
        panel1.add(bBuscarTodo);
        panel1.add(bBuscarDept);
        panel1.add(bBuscarEstado);
        panel1.add(bBuscarEstadoPromocion);
        panel1.add(bSalir);
        panel2.add(panel1);
        panel2.add(new JScrollPane(taDatos));
        add(panel2);
        setSize(500,600);
        setVisible(false);


    }
    public JPanel getPanel2(){

return this.panel2;

}
private void obtenerCategoria(String a){




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
fin="nada";
  }
}


    public void actionPerformed(ActionEvent e)
    {
        String datos, respuesta;

        if(e.getSource() == CBdepartamento)
        {
        if(String.valueOf(CBdepartamento.getSelectedItem())=="Ropa")
        {
          bBuscarTemporada.setEnabled(true);
          tfTemporada.setEnabled(true);
        }
        else
        {
        bBuscarTemporada.setEnabled(false);
        tfTemporada.setEnabled(false);
        }
      }

        if(e.getSource() == bBuscarProductoID)
        {
            // 2. Checar los datos
            datos=tfidProducto.getText();
            if(datos.equals(""))
              respuesta = "INGRESA ID";
            else{


              respuesta = retailad.buscarID(datos);
              taDatos.setText(respuesta);

            }
            JOptionPane.showMessageDialog( this , respuesta , "Agregar a la base" , JOptionPane.INFORMATION_MESSAGE );
        }
        if(e.getSource() == bBuscarProductoNombre)
        {
          datos=tfNombre.getText();
          if(datos.equals(""))
            respuesta = "INGRESA ID";
          else{


            respuesta = retailad.buscarNombre(datos);
            taDatos.setText(respuesta);

          }
          JOptionPane.showMessageDialog( this , respuesta , "Agregar a la base" , JOptionPane.INFORMATION_MESSAGE );
        }

        if(e.getSource() == bBuscarTemporada)
        {
          //taDatos.setText("producto buscado por temporada");

        }

if(e.getSource() == bBuscarPrecio)
        {
  //taDatos.setText("producto buscado por precio");
   datos=tfPrecioVenta.getText();
    if(datos.equals(""))
     respuesta = "INGRESA ID";
    else{

     respuesta = retailad.buscarPrecio(datos);
      taDatos.setText(respuesta);

     }
     JOptionPane.showMessageDialog( this , respuesta , "Agregar a la base" , JOptionPane.INFORMATION_MESSAGE );
        }

    if(e.getSource() == bBuscarTodo)
        {
          datos = retailad.consultarProductos();

          // 2. Desplegar los datos de los automoviles
          taDatos.setText(datos);
        }
    if(e.getSource() == bBuscarDept)
        {
            fin=(String) CBdepartamento.getSelectedItem();
            obtenerCategoria(fin);

            datos = retailad.consultarDepto(fin);

            // 2. Desplegar los datos de los automoviles
            taDatos.setText(datos);

        }
  if(e.getSource() == bBuscarEstado)
        {
          fin=(String) CBestado.getSelectedItem();

          datos = retailad.consultarEdo(fin);

          // 2. Desplegar los datos de los automoviles
          taDatos.setText(datos);
        }
  if(e.getSource() == bBuscarEstadoPromocion)
        {
          fin=(String) CBestadoPromocion.getSelectedItem();

          datos = retailad.consultarEdoPromo(fin);

          // 2. Desplegar los datos de los automoviles
          taDatos.setText(datos);
        }

        if(e.getSource() == bSalir)
        {
            System.exit(0);
        }
    }

    public static void main(String args[])
    {
        new ConsultaProductoGUI();
    }
}
