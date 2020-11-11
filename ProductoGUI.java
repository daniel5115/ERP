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
import java.util.StringTokenizer;
public class ProductoGUI extends JFrame implements ActionListener
{
    private JTextField tfidProducto, tfNombre, tfPrecioCompra,tfPrecioVenta,tfDistribuidor,tfDescripcion, tfPrecioPromocion,tfporcent,tfurl;
    private JComboBox   CBestado, CBestadoPromocion, CBdepartamento;
    private JButton    bCapturarProducto,bBuscar,bModificar,breset;
    private JPanel    panel, panel1, panel2;
    private String fin,cg,es,eP,idP;

//    private JTextArea  taDatos;
//GUIS
private RopaGUI ropa=new RopaGUI();
private LibroGUI libro=new LibroGUI();
private VinosLicoresGUI vinlic=new VinosLicoresGUI();
private VideojuegosGUI video=new VideojuegosGUI();
private LineaBlancaGUI lb=new LineaBlancaGUI();
private MueblesGUI muebles=new MueblesGUI();
private ElectronicaGUI elec=new ElectronicaGUI();

private  RetailADjdbc retailad=new RetailADjdbc();

    //private BancoAD bancoad= new BancoAD();
    //private BancoADjdbc bancoad= new BancoADjdbc();


    public ProductoGUI()
    {
        super("Interfaz Basica");

        // 1. Crear los objetos de los atributos
        tfidProducto=new JTextField();
        tfNombre=new JTextField();

        //tfTemporada=new JTextField();
        tfPrecioCompra=new JTextField();
				tfPrecioVenta=new JTextField();
				tfDistribuidor=new JTextField();
				tfDescripcion=new JTextField();
				tfPrecioPromocion=new JTextField("0");
        //tfPrecioPromocion.setEnabled(false);
        tfporcent=new JTextField("0");
        tfPrecioPromocion.setEditable(false);

        tfurl=new JTextField();

        bCapturarProducto = new JButton("Capturar producto");

        bBuscar=new JButton("Buscar producto");

        bModificar=new JButton("Modificar Producto");
        bModificar.setEnabled(false);

        breset=new JButton("Reset");



      //  bBuscarTemporada.setEnabled(false);
        //tfTemporada.setEnabled(false);
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
        CBestado.addItem("Activo");
        CBestado.addItem("Inactivo");
        CBestado.addItem("Descontinuado");
        CBestado.addItem("Agotado");

        CBestadoPromocion= new JComboBox();
        CBestadoPromocion.addItem("");
        CBestadoPromocion.addItem("Con promocion");
        CBestadoPromocion.addItem("Sin promocion");



        panel=new JPanel();
        panel1 = new JPanel();
        panel2 = new JPanel();
        //taDatos = new JTextArea(10,30);
        CBestado.setSelectedIndex(-1);
        CBestadoPromocion.setSelectedIndex(-1);
        CBdepartamento.setSelectedIndex(-1);


        // Adicionar addActionListener a lo JButtons
        bCapturarProducto.addActionListener(this);
        breset.addActionListener(this);

;
      //  bBuscarTemporada.addActionListener(this);
         bBuscar.addActionListener(this);
         bModificar.addActionListener(this);
        CBdepartamento.addActionListener(this);
        CBestado.addActionListener(this);
        CBestadoPromocion.addActionListener(this);




        // 2. Definir los Layouts de los JPanels
        panel.setLayout(new GridLayout(0,2));
        panel1.setLayout(new FlowLayout());

        // 3. Colocar los objetos de los atributos en los JPanels correspondientes
        panel.add(new JLabel("ID producto"));
        panel.add(tfidProducto);
        panel.add(new JLabel("Departamento"));
        panel.add(CBdepartamento);
        panel.add(new JLabel("Nombre"));
        panel.add(tfNombre);
        panel.add(new JLabel("Precio Compra"));
				panel.add(tfPrecioCompra);
				panel.add(new JLabel("Precio Venta"));
        panel.add(tfPrecioVenta);
				panel.add(new JLabel("Distribuidor"));
				panel.add(tfDistribuidor);
				panel.add(new JLabel("Descripcion"));
				panel.add(tfDescripcion);
				panel.add(new JLabel("Estado"));
        panel.add(CBestado);
        panel.add(new JLabel("Estado de promocion"));
        panel.add(CBestadoPromocion);

				panel.add(new JLabel("Precio Promocion"));
				panel.add(tfPrecioPromocion);
        panel.add(new JLabel("Porcentaje Promocion"));
        panel.add(tfporcent);
        panel.add(new JLabel("URL"));
        panel.add(tfurl);


        panel.add(bCapturarProducto);

        //panel.add(bBuscarProducto);
        //panel.add(bBuscarTemporada);
        panel.add(bBuscar);
       panel.add(bModificar);
       panel.add(breset);



        panel1.add(panel);
        panel1.add(panel2);
        //panel2.add(new JScrollPane(taDatos));

        // 4. Adicionar el panel2 al JFrame y hacerlo visible
        add(panel1);
        setSize(550,670);
        setVisible(false);


    }
    public JPanel getPanel2(){

return this.panel1;

}
private String tipDepto(String a){
String fin1;
  switch(a){

  case "1":
     fin1= "Ropa";
    break;
  case "2":
    fin1= "Libros";
    break;
  case "3":
    fin1= "Vinos y Licores";
    break;
  case "4":
    fin1= "Videojuegos";
    break;
  case "5":
    fin1= "Linea Blanca";
    break;
  case "6":
    fin1= "Muebles";
    break;
  case "7":
  fin1= "Electronica";
  break;
 default:
fin1="nada";
  }
  return fin1;

}
private void limpiar(){
  tfidProducto.setText("");
  tfNombre.setText("");
  tfPrecioCompra.setText("");
  tfPrecioVenta.setText("");
  CBdepartamento.setSelectedIndex(-1);
  tfDistribuidor.setText("");
  tfDescripcion.setText("");
  CBestado.setSelectedIndex(-1);
  CBestadoPromocion.setSelectedIndex(-1);
  tfPrecioPromocion.setText("");
  tfporcent.setText("");
  tfurl.setText("");

}
private void desplegar(String datos)
{
  StringTokenizer st = new StringTokenizer(datos,"_");

  tfidProducto.setText(st.nextToken());
CBdepartamento.setSelectedItem(tipDepto(st.nextToken()));
tfNombre.setText(st.nextToken());
  tfPrecioCompra.setText(st.nextToken());
  tfPrecioVenta.setText(st.nextToken());
  tfDistribuidor.setText(st.nextToken());
  tfDescripcion.setText(st.nextToken());
     CBestado.setSelectedItem(st.nextToken());
     CBestadoPromocion.setSelectedItem(st.nextToken());
     tfPrecioPromocion.setText(st.nextToken());
     tfporcent.setText(st.nextToken());
     tfurl.setText(st.nextToken());
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

    private String obtenerDatos()
    {
      String datos;
      String idProd, idDepto, nomb,pC,pV,dist,desc,edo,edoProm,pP,porct,ul;


      idProd=tfidProducto.getText();
      idP=idProd;
      idDepto= fin;
      //id=idDepto;
      nomb=tfNombre.getText();
      pC=tfPrecioCompra.getText();
      pV=tfPrecioVenta.getText();
      dist=tfDistribuidor.getText();
      desc=tfDescripcion.getText();
      edo=es;
      edoProm=eP;
      pP=tfPrecioPromocion.getText();
      porct=tfporcent.getText();
      ul=tfurl.getText();



      if(idProd.equals("") || idDepto.isEmpty() || nomb.isEmpty() ||pC.isEmpty() || pV.isEmpty() || dist.isEmpty() || desc.isEmpty() || edo.isEmpty() || edoProm.isEmpty()||pP.isEmpty()||ul.isEmpty()||porct.isEmpty())
      {
        datos = "VACIO";
      }
      else
      {
        datos = idProd+"_"+idDepto+"_"+nomb+"_"+pC+"_"+pV+"_"+dist+"_"+desc+"_"+edo+"_"+edoProm+"_"+pP+"_"+porct+"_"+ul;
      }

      return datos;
    }
public void actionPerformed(ActionEvent e)
    {
        String datos, respuesta;

        if(e.getSource() == CBdepartamento)
        {
        if(String.valueOf(CBdepartamento.getSelectedItem())=="Ropa")
        {
          //bBuscarTemporada.setEnabled(true);
          //tfTemporada.setEnabled(true);
        }
        else
        {
        //bBuscarTemporada.setEnabled(false);
        //tfTemporada.setEnabled(false);
        }
      }

   if(e.getSource() == bCapturarProducto)
        {
          cg=(String) CBdepartamento.getSelectedItem();
          obtenerCategoria(cg);
         es=(String)CBestado.getSelectedItem();
          eP=(String) CBestadoPromocion.getSelectedItem();
          datos = obtenerDatos();

          // 2. Checar los datos
          if(datos.equals("VACIO"))
            respuesta = "Algun campo esta vacio...";
          else{


            respuesta = retailad.capturar("Producto",datos);
            JOptionPane.showMessageDialog( this , respuesta , "Agregar a la base" , JOptionPane.INFORMATION_MESSAGE );



          //  panel = producto.getPanel2();
            //panel.setVisible(true);
          if(fin=="1"){
               System.out.println(idP+"este es producto");
               System. out. println(fin+"Este depto");
            panel2.add(ropa.getPanel2(idP,fin));
            panel2.setVisible(true);
            panel2.revalidate();
            panel2.repaint();
              }
            if(fin=="2"){
              panel2.add(libro.getPanel2(idP,fin));
              panel2.setVisible(true);
              panel2.revalidate();
              panel2.repaint();
            }

            if(fin=="3"){
              panel2.add(vinlic.getPanel2(idP,fin));
              panel2.setVisible(true);
              panel2.revalidate();
              panel2.repaint();

            }
            if (fin=="4"){
              panel2.add(video.getPanel2(idP,fin));
              panel2.setVisible(true);
              panel2.revalidate();
              panel2.repaint();
            }
            if(fin=="5"){
              panel2.add(lb.getPanel2(idP,fin));
              panel2.setVisible(true);
              panel2.revalidate();
              panel2.repaint();


            }
            if(fin=="6"){
              panel2.add(muebles.getPanel2(idP,fin));
              panel2.setVisible(true);
              panel2.revalidate();
              panel2.repaint();


            }
            if(fin=="7"){
              panel2.add(elec.getPanel2(idP,fin));
              panel2.setVisible(true);
              panel2.revalidate();
              panel2.repaint();

            }
        }
      }

   if(e.getSource()== bBuscar){
     datos=tfidProducto.getText();
     datos=retailad.buscarID(datos);

     if(datos.equals("NOT_FOUND")){

     }

			else
			{

				desplegar(datos);
				tfidProducto.setEditable(false);
        bModificar.setEnabled(true);

			}
   }
   if(e.getSource()== bModificar){

     float  precio,porcent, precioTotal;
     datos=(String) CBestadoPromocion.getSelectedItem();

     if(datos.equals("Con promocion")){
      respuesta=tfporcent.getText();
    porcent=100-Integer.parseInt(respuesta);
    porcent=(porcent/100);
    precio=Integer.parseInt(tfPrecioVenta.getText());

    precioTotal=precio*porcent;
    tfPrecioPromocion.setText(String.valueOf(precioTotal));
      }
        datos = obtenerDatos();
      retailad.actualizar("Producto",datos);
    }
    if(e.getSource()== breset){
      panel2.setVisible(false);
      limpiar();

    }


    }

    public static void main(String args[])
    {
        new ProductoGUI();
    }
}
