import java.util.StringTokenizer;

public class LibroDP //extends ProductoDP
{
	// Atributos
  private String editorial,autor,genero;
  private int idProducto, idDepto;

	// Constructor
	public LibroDP()
	{
		//Atributos de ProductoDP
		this.idProducto    = 0;
    	this.idDepto        =0;
		//Atributos específicos de LibroDP
		this.editorial      = "";
		this.autor      = "";
		this.genero      = "";

	}

	public LibroDP(String datos)
	{
		StringTokenizer st = new StringTokenizer(datos,"_");
		this.idDepto       =Integer.parseInt(st.nextToken());
		this.idProducto       = Integer.parseInt(st.nextToken());
		this.editorial       = st.nextToken();
    this.autor       = st.nextToken();
		this.genero       = st.nextToken();

	}

	// Accesors o geters
	public int getidProducto()
	{
		return this.idProducto;
	}

    public int getidDepto()
	{
		return this.idDepto;
	}

  public String getEditorial()
	{
		return this.editorial;
	}
	public String getAutor()
	{
		return this.autor;
	}
  public String getGenero()
	{
		return this.genero;
	}


	// Mutators o seters

	public void setEditorial(String line)
	{
		this.editorial = line;
	}
  public void setAutor(String colour){
    this.autor=colour;
  }
public void setGenero(String brand){
  this.genero=brand;
}

	// Metodos
	public String toString()
	{
		return this.idDepto+"_"+this.idProducto+"_"+this.editorial+"_"+this.autor+"_"+this.genero;
	}

	public String toStringSql()
	{
	return "'"+this.idDepto+"','"+this.idProducto+"','"+this.editorial+"','"+this.autor+"','"+this.genero+"'";
	}

	public String toStringSqlUpdate()
	{
    return "idDepto='"+this.idDepto+"',idProducto='"+this.idProducto+"',editorial='"+this.editorial+"',autor='"+this.autor+"',genero='"+this.genero+"' ";

	}
}
