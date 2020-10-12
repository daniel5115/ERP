import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class RetailGUI extends JFrame implements ActionListener
{


private JMenuBar  menuBarCatalogos;
private JMenu     menuCatalogos,menuCentros;
private JMenuItem miProducto, miConProd,miCentro,miConCentro;
private JMenuItem miSalir;
//private JMenuItem miRepAuCli,miRepAccAut;

//private JPanel    panelReportes   = new JPanel();
//private JTextArea taDatosReportes = new JTextArea(25,40);

//private ClienteGUI cliente= new ClienteGUI();


private RetailADjdbc retailad=new RetailADjdbc();
private ProductoGUI producto=new ProductoGUI();
private ConsultaProductoGUI consulta=new ConsultaProductoGUI();
	private JPanel panel;

public RetailGUI(){
super("RetailERP");
//CREO LOS OBJETOS
menuBarCatalogos = new JMenuBar();
menuCatalogos    = new JMenu("Producto");
menuCentros=new JMenu("Inventario");
//menuReportes 	 = new JMenu("Reportes y Consultas");

miProducto	 	 = new JMenuItem("Agregar Producto");
miConProd 	 = new JMenuItem("Consultar Producto");
miCentro= new JMenuItem("Agregar a Inventario");
miConCentro=new JMenuItem("Consultar un Centro");
miSalir=          new  JMenuItem("Exit");

//miRepAuCli = new JMenuItem("Autos de un Cliente");
//miRepAccAut  = new JMenuItem("Accidentes de un Auto");



//añade evento a los JMenuItem
miProducto.addActionListener(this);
miConProd.addActionListener(this);
miSalir.addActionListener(this);


    panel = new JPanel();

    menuCatalogos.add(miProducto);
    menuCatalogos.add(miConProd);
    menuCentros.add(miCentro);
    menuCentros.add(miConCentro);
    //menuCatalogos.add(miAccidente);
  //  menuCatalogos.add(miSalir);






    menuBarCatalogos.add(menuCatalogos);
    menuBarCatalogos.add(menuCentros);
   menuBarCatalogos.add(miSalir);

		//menuBarCatalogos.add(menuReportes);

		setJMenuBar(menuBarCatalogos);
		setSize(500,550);
		setVisible(true);

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		System.out.println("Ejecute el constructor...\n");
}
public void actionPerformed(ActionEvent e){

if (e.getSource() == miSalir){
  System.exit(0);
}

if(e.getSource()==miProducto){

  panel.setVisible(false);

  panel = producto.getPanel2();
  panel.setVisible(true);

  add(panel);
  setVisible(true);
}

if(e.getSource()==miConProd){

  panel.setVisible(false);

  panel = consulta.getPanel2();
  panel.setVisible(true);

  add(panel);
  setVisible(true);

/*
  taDatosReportes.setText("REPORTE: AUTOS DE UN CLIENTE\n\n");

  String cved = JOptionPane.showInputDialog("Clave del Cliente:");

  String datos = seguroad.reporteClienteAuto(cved);

taDatosReportes.append(datos);
*/
}

}


public static void main(String args[])
{
  new RetailGUI();
}




}
