
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
private VinosLicores vinoslicdp;
private VideojuegosDP videodp;
private LineaBlancaDP lbdp;
private MuebleDP muebledp;
private ElectronicaDP elecdp;
	// Constructor
	public RetailADjdbc()
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver").newInstance(); // Indicar el tipo de driver JDBC a utilizar
			conexion = DriverManager.getConnection("jdbc:mysql://localhost/TIENDA?user=root"); // Conectar a la BD

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
}
