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
public class ProductoGUI extends JFrame implements ActionListener
{
    private JTextField tfidProducto, tfNombre, tfPrecioCompra,tfPrecioVenta,tfDistribuidor,tfDescripcion, tfPrecioPromocion,tfporcent,tfurl;
    private JComboBox   CBestado, CBestadoPromocion, CBdepartamento;
    private JButton    bCapturarProducto,bBuscar,bModificar;
    private JPanel     panel1, panel2;
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
        tfporcent=new JTextField("0");
        tfurl=new JTextField();

        bCapturarProducto = new JButton("Capturar producto");

        bBuscar=new JButton("Buscar producto");

        bModificar=new JButton("Modificar Producto");




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




        panel1 = new JPanel();
        panel2 = new JPanel();
        //taDatos = new JTextArea(10,30);
        CBestado.setSelectedIndex(-1);
        CBestadoPromocion.setSelectedIndex(-1);
        CBdepartamento.setSelectedIndex(-1);


        // Adicionar addActionListener a lo JButtons
        bCapturarProducto.addActionListener(this);

;
      //  bBuscarTemporada.addActionListener(this);
         bBuscar.addActionListener(this);
         bModificar.addActionListener(this);
        CBdepartamento.addActionListener(this);
        CBestado.addActionListener(this);
        CBestadoPromocion.addActionListener(this);




        // 2. Definir los Layouts de los JPanels
        panel1.setLayout(new GridLayout(0,2));
        panel2.setLayout(new FlowLayout());

        // 3. Colocar los objetos de los atributos en los JPanels correspondientes
        panel1.add(new JLabel("ID producto"));
        panel1.add(tfidProducto);
        panel1.add(new JLabel("Departamento"));
        panel1.add(CBdepartamento);
        panel1.add(new JLabel("Nombre"));
        panel1.add(tfNombre);
        panel1.add(new JLabel("Precio Compra"));
				panel1.add(tfPrecioCompra);
				panel1.add(new JLabel("Precio Venta"));
        panel1.add(tfPrecioVenta);
				panel1.add(new JLabel("Distribuidor"));
				panel1.add(tfDistribuidor);
				panel1.add(new JLabel("Descripcion"));
				panel1.add(tfDescripcion);
				panel1.add(new JLabel("Estado"));
        panel1.add(CBestado);
        panel1.add(new JLabel("Estado de promocion"));
        panel1.add(CBestadoPromocion);
				panel1.add(new JLabel("Precio Promocion"));
				panel1.add(tfPrecioPromocion);
        panel1.add(new JLabel("Porcentaje Promocion"));
        panel1.add(tfporcent);
        panel1.add(new JLabel("URL"));
        panel1.add(tfurl);


        panel1.add(bCapturarProducto);

        //panel1.add(bBuscarProducto);
        //panel1.add(bBuscarTemporada);
        panel1.add(bBuscar);
       panel1.add(bModificar);



        panel2.add(panel1);
        //panel2.add(new JScrollPane(taDatos));

        // 4. Adicionar el panel2 al JFrame y hacerlo visible
        add(panel2);
        setSize(550,670);
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

            //panel.setVisible(false);

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


    }

    public static void main(String args[])
    {
        new ProductoGUI();
    }
}
