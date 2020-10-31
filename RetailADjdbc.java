
import java.io.PrintWriter;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;
import java.io.FileNotFoundException;

import java.util.StringTokenizer;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
//import com.google.cloud.sql.core.CoreSocketFactory;

public class RetailADjdbc
{
	// Atributos
	private PrintWriter    archivoOut;
	private BufferedReader archivoIn;

	private Connection conexion;
	private Statement  statement;

//private ClienteDP   clientedp;
//private AutomovilDP autodp;
//private AccidenteDP accidentedp;
private ProductoDP productodp;
private RopaDP ropadp;
private LibroDP librodp;
private VinosLicoresDP vinoslicdp;
private VideojuegosDP videodp;
private LineaBlancaDP lbdp;
private MuebleDP muebledp;
private ElectronicaDP elecdp;
private InventarioDP inventariodp;
private CentroDistribucionDP centrodistdp;
	// Constructor
	public RetailADjdbc()
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver").newInstance(); // Indicar el tipo de driver JDBC a utilizar
		//conexion = DriverManager.getConnection("jdbc:mysql://localhost/TIENDA?user=root"); // Conectar a la BD
//conexion = DriverManager.getConnection("jdbc:mysql:34.94.218.60[:8000]/Tienda");
conexion = DriverManager.getConnection("jdbc:mysql://34.94.218.60/TIENDA","root","chuchito");

			System.out.println("Conexion exitosa a la BD...");
		}
		catch(ClassNotFoundException cnfe)
		{
			System.out.println("Error 1: "+cnfe);
		}
		catch(InstantiationException ie)
		{
			System.out.println("Error 2: "+ie);
		}
		catch(IllegalAccessException iae)
		{
			System.out.println("Error 3: "+iae);
		}
		catch(SQLException sqle)
		{
			System.out.println("Error 4: "+sqle);
		}
	}

  public String capturar(String tabla, String datos)
{
  String resultado="";
  String insert="";


  if(tabla.equals("Producto"))
  {
    productodp = new ProductoDP(datos);
    insert = "INSERT INTO "+tabla+" VALUES("+productodp.toStringSql()+");";
  }

  if(tabla.equals("Ropa"))
  {
    ropadp = new RopaDP(datos);
    insert = "INSERT INTO "+tabla+" VALUES("+ropadp.toStringSql()+");";
  }
  if(tabla.equals("Libros"))
  {
    librodp = new LibroDP(datos);
    insert = "INSERT INTO "+tabla+" VALUES("+librodp.toStringSql()+");";
  }
  if(tabla.equals("VinosyLicores"))
  {
    vinoslicdp = new VinosLicoresDP(datos);
    insert = "INSERT INTO "+tabla+" VALUES("+vinoslicdp.toStringSql()+");";
  }
  if(tabla.equals("LineaBlanca"))
  {
    lbdp = new LineaBlancaDP(datos);
    insert = "INSERT INTO "+tabla+" VALUES("+lbdp.toStringSql()+");";
  }
  if(tabla.equals("Videojuegos"))
  {
    videodp = new VideojuegosDP(datos);
    insert = "INSERT INTO "+tabla+" VALUES("+videodp.toStringSql()+");";
  }
  if(tabla.equals("Muebles"))
  {
    muebledp = new MuebleDP(datos);
    insert = "INSERT INTO "+tabla+" VALUES("+muebledp.toStringSql()+");";
  }
  if(tabla.equals("Electronica"))
  {
    elecdp = new ElectronicaDP(datos);
    insert = "INSERT INTO "+tabla+" VALUES("+elecdp.toStringSql()+");";
  }

  try
  {
    //se crea statement
    statement = conexion.createStatement();

    // aqui es donde se le da el insert a mysql
    statement.executeUpdate(insert);

    // se cierra conexion
    statement.close();

    resultado = "Captura correcta: "+datos;

    System.out.println(insert);
  }
  catch(SQLException ioe)
  {
    resultado = "Error: "+ioe;
    System.out.println("Error: "+ioe);
  }

  return resultado;
}
////////////////
public String actualizar(String tabla,String datos){
	String resultado="";
	String update="";


	if(tabla.equals("Inventario")){
	inventariodp = new InventarioDP(datos);
		update = "UPDATE Inventario SET "+inventariodp.toStringSqlUpdate()+" WHERE idCD='"+inventariodp.getidCD()+"' AND idProducto='"+inventariodp.getidProducto()+"'";
	}




	try{
		// 1. Abrir la BD
		statement = conexion.createStatement();

		// 2. Actualizar datos con Update
		statement.executeUpdate(update);

		// 3. Cerrar la BD
		statement.close();

		resultado = "Actualizacion correcta...";

		System.out.println(update);
	}
	catch(SQLException ioe){
		resultado = "Error: "+ioe;
		System.out.println("Error: "+ioe);
	}

	return resultado;
}
////////////////7
public String consultarProductos(){
  String datos="";
  String query;

  ResultSet tr;

  query = "SELECT * FROM Producto";

  try
  {

    statement = conexion.createStatement();

    // Ejecutar query
    tr = statement.executeQuery(query);

    productodp = new ProductoDP();

    while(tr.next())
    {


			productodp.setidProducto(tr.getInt(1));
			productodp.setidDepto(tr.getInt(2));
      productodp.setNombre(tr.getString("nombre"));
			productodp.setprecioCompra(tr.getString("precioCompra"));
			productodp.setprecioVenta(tr.getString("precioVenta"));
			productodp.setDistribuidor(tr.getString("distribuidor"));
			productodp.setDescripcion(tr.getString("descripcion"));
			productodp.setEstado(tr.getString("estado"));
			productodp.setedoPromocion(tr.getString("edoPromocion"));
			productodp.setprecioPromocion(tr.getString("precioPromocion"));
			productodp.setUrl(tr.getString("url"));





      datos = datos + productodp.toString() + "\n";
    }


    statement.close();

    System.out.println(query);
  }
  catch(SQLException sqle)
  {
    datos = "Error 2: "+sqle;
    System.out.println("Error: "+sqle);
  }

  return datos;
}
/////////////////////////////
public String buscarID(String dat){
	String datos="";
  String query;
  boolean encontrado=false;
  ResultSet tr;

  query = "SELECT * FROM Producto WHERE idProducto='"+dat+"'";

  try
  {
    // 1.Abrir la BD
    statement = conexion.createStatement();

    // Ejecutar query
    tr = statement.executeQuery(query);

    // 2. Procesar los datos de la Tabla Resultante
  productodp = new ProductoDP();

    if(tr.next())
    {
			      productodp.setidProducto(tr.getInt(1));
						productodp.setidDepto(tr.getInt(2));
						productodp.setNombre(tr.getString("nombre"));
						productodp.setprecioCompra(tr.getString("precioCompra"));
						productodp.setprecioVenta(tr.getString("precioVenta"));
						productodp.setDistribuidor(tr.getString("distribuidor"));
						productodp.setDescripcion(tr.getString("descripcion"));
						productodp.setEstado(tr.getString("estado"));
						productodp.setedoPromocion(tr.getString("edoPromocion"));
						productodp.setprecioPromocion(tr.getString("precioPromocion"));
						productodp.setUrl(tr.getString("url"));



      datos = datos + productodp.toString() + "\n";

      encontrado = true;
    }

    // 3. SE cierra BD
    statement.close();

    if(!encontrado)
      datos = "NOT_FOUND";

    System.out.println(query);
  }
  catch(SQLException sqle)
  {
    datos = "Error 2: "+sqle;
    System.out.println("Error: "+sqle);
  }

  return datos;

}
///////////
public String buscarNombre(String dat){
	String datos="";
  String query;
  boolean encontrado=false;
  ResultSet tr;

  query = "SELECT * FROM Producto WHERE nombre='"+dat+"'";

  try
  {
    // 1.Abrir la BD
    statement = conexion.createStatement();

    // Ejecutar query
    tr = statement.executeQuery(query);

    // 2. Procesar los datos de la Tabla Resultante
  productodp = new ProductoDP();

    if(tr.next())
    {
			      productodp.setidProducto(tr.getInt(1));
						productodp.setidDepto(tr.getInt(2));
						productodp.setNombre(tr.getString("nombre"));
						productodp.setprecioCompra(tr.getString("precioCompra"));
						productodp.setprecioVenta(tr.getString("precioVenta"));
						productodp.setDistribuidor(tr.getString("distribuidor"));
						productodp.setDescripcion(tr.getString("descripcion"));
						productodp.setEstado(tr.getString("estado"));
						productodp.setedoPromocion(tr.getString("edoPromocion"));
						productodp.setprecioPromocion(tr.getString("precioPromocion"));
						productodp.setUrl(tr.getString("url"));



      datos = datos + productodp.toString() + "\n";

      encontrado = true;
    }

    // 3. SE cierra BD
    statement.close();

    if(!encontrado)
      datos = "NOT_FOUND";

    System.out.println(query);
  }
  catch(SQLException sqle)
  {
    datos = "Error 2: "+sqle;
    System.out.println("Error: "+sqle);
  }

  return datos;

}
///////
public String buscarPrecio(String dat){
	String datos="";
  String query;
  boolean encontrado=false;
  ResultSet tr;

  query = "SELECT * FROM Producto WHERE precioVenta='"+dat+"'";

	try
  {

    statement = conexion.createStatement();

    // Ejecutar query
    tr = statement.executeQuery(query);

    productodp = new ProductoDP();

    while(tr.next())
    {


			productodp.setidProducto(tr.getInt(1));
			productodp.setidDepto(tr.getInt(2));
      productodp.setNombre(tr.getString("nombre"));
			productodp.setprecioCompra(tr.getString("precioCompra"));
			productodp.setprecioVenta(tr.getString("precioVenta"));
			productodp.setDistribuidor(tr.getString("distribuidor"));
			productodp.setDescripcion(tr.getString("descripcion"));
			productodp.setEstado(tr.getString("estado"));
			productodp.setedoPromocion(tr.getString("edoPromocion"));
			productodp.setprecioPromocion(tr.getString("precioPromocion"));
			productodp.setUrl(tr.getString("url"));


    datos = datos + productodp.toString() + "\n";

    encontrado = true;

    }


    statement.close();
		if(!encontrado)
      datos = "NOT_FOUND";
    System.out.println(query);
  }
  catch(SQLException sqle)
  {
    datos = "Error 2: "+sqle;
    System.out.println("Error: "+sqle);
  }

  return datos;

}
///////

public String consultarDepto(String a){
  String datos="";
  String query;

  ResultSet tr;

  query = "SELECT * FROM Producto WHERE idDepto= ' "+a+"'";
	try
  {

    statement = conexion.createStatement();

    // Ejecutar query
    tr = statement.executeQuery(query);

    productodp = new ProductoDP();

    while(tr.next())
    {


			productodp.setidProducto(tr.getInt(1));
			productodp.setidDepto(tr.getInt(2));
      productodp.setNombre(tr.getString("nombre"));
			productodp.setprecioCompra(tr.getString("precioCompra"));
			productodp.setprecioVenta(tr.getString("precioVenta"));
			productodp.setDistribuidor(tr.getString("distribuidor"));
			productodp.setDescripcion(tr.getString("descripcion"));
			productodp.setEstado(tr.getString("estado"));
			productodp.setedoPromocion(tr.getString("edoPromocion"));
			productodp.setprecioPromocion(tr.getString("precioPromocion"));
			productodp.setUrl(tr.getString("url"));





      datos = datos + productodp.toString() + "\n";
    }


    statement.close();

    System.out.println(query);
  }
  catch(SQLException sqle)
  {
    datos = "Error 2: "+sqle;
    System.out.println("Error: "+sqle);
  }

  return datos;

}

/////////////
public String consultarEdo(String a){
  String datos="";
  String query;

  ResultSet tr;

  query = "SELECT * FROM Producto WHERE estado= '"+a+"'";

  try
  {

    statement = conexion.createStatement();

    // Ejecutar query
    tr = statement.executeQuery(query);

    productodp = new ProductoDP();

    while(tr.next())
    {


			productodp.setidProducto(tr.getInt(1));
			productodp.setidDepto(tr.getInt(2));
      productodp.setNombre(tr.getString("nombre"));
			productodp.setprecioCompra(tr.getString("precioCompra"));
			productodp.setprecioVenta(tr.getString("precioVenta"));
			productodp.setDistribuidor(tr.getString("distribuidor"));
			productodp.setDescripcion(tr.getString("descripcion"));
			productodp.setEstado(tr.getString("estado"));
			productodp.setedoPromocion(tr.getString("edoPromocion"));
			productodp.setprecioPromocion(tr.getString("precioPromocion"));
			productodp.setUrl(tr.getString("url"));





      datos = datos + productodp.toString() + "\n";
    }


    statement.close();

    System.out.println(query);
  }
  catch(SQLException sqle)
  {
    datos = "Error 2: "+sqle;
    System.out.println("Error: "+sqle);
  }

  return datos;
}
///////
public String consultarEdoPromo(String a){
  String datos="";
  String query;

  ResultSet tr;

  query = "SELECT * FROM Producto WHERE edoPromocion= '"+a+"'";

  try
  {

    statement = conexion.createStatement();

    // Ejecutar query
    tr = statement.executeQuery(query);

    productodp = new ProductoDP();

    while(tr.next())
    {


			productodp.setidProducto(tr.getInt(1));
			productodp.setidDepto(tr.getInt(2));
      productodp.setNombre(tr.getString("nombre"));
			productodp.setprecioCompra(tr.getString("precioCompra"));
			productodp.setprecioVenta(tr.getString("precioVenta"));
			productodp.setDistribuidor(tr.getString("distribuidor"));
			productodp.setDescripcion(tr.getString("descripcion"));
			productodp.setEstado(tr.getString("estado"));
			productodp.setedoPromocion(tr.getString("edoPromocion"));
			productodp.setprecioPromocion(tr.getString("precioPromocion"));
			productodp.setUrl(tr.getString("url"));





      datos = datos + productodp.toString() + "\n";
    }


    statement.close();

    System.out.println(query);
  }
  catch(SQLException sqle)
  {
    datos = "Error 2: "+sqle;
    System.out.println("Error: "+sqle);
  }

  return datos;
}
////
public String consultarCentro(String a,String tipo){
  String datos="";
  String query;

  ResultSet tr;
if(a=="Global"){
	  query = "SELECT * FROM Inventario";
}else
  query = "SELECT * FROM Inventario WHERE idCD= '"+a+"'";

  try
  {

    statement = conexion.createStatement();

    // Ejecutar query
    tr = statement.executeQuery(query);

     inventariodp = new InventarioDP();

    while(tr.next())
    {


			inventariodp.setidCD(tr.getInt(1));
      inventariodp.setidProducto(tr.getInt(2));
      inventariodp.setCantidad(tr.getInt(3));




if(tipo=="Buscar"){
      datos = datos + inventariodp.toString() + "\n";
    }
		else{
			datos=inventariodp.toStringCantidad();
		}
	}


    statement.close();

    System.out.println(query);
  }
  catch(SQLException sqle)
  {
    datos = "Error 2: "+sqle;
    System.out.println("Error: "+sqle);
  }

  return datos;
}
}
