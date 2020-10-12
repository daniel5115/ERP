import java.util.StringTokenizer;

public class VinosLicoresDP //extends ProductoDP
{
	// Atributos
  private String presentacion,marca,tipo,paisOrigen;
  private int idProducto, idDepto,gradoDeAlcohol;

	// Constructor
	public VinosLicoresDP()
	{
		//Atributos de ProductoDP
		this.idProducto    = 0;
    	this.idDepto        =0;
		//Atributos específicos de LibroDP
		this.presentacion      = "";
		this.gradoDeAlcohol      =0;
		this.marca      = "";
    this.tipo      = "";
		this.paisOrigen      = "";

	}

	public VinosLicoresDP(String datos)
	{
		StringTokenizer st = new StringTokenizer(datos,"_");
		this.idDepto       =Integer.parseInt(st.nextToken());
		this.idProducto       = Integer.parseInt(st.nextToken());
		this.presentacion       = st.nextToken();
    this.gradoDeAlcohol       = Integer.parseInt(st.nextToken());
    this.marca       = st.nextToken();
		this.tipo       = st.nextToken();
    this.paisOrigen       = st.nextToken();


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

  public String getPresentacion()
	{
		return this.presentacion;
	}
	public int getGradoDeAlcohol()
	{
		return this.gradoDeAlcohol;
	}
  public String getMarca()
	{
		return this.marca;
	}
  public String getTipo()
	{
		return this.tipo;
	}
  public String getPaisOrigen()
	{
		return this.paisOrigen;
	}


	// Mutators o seters

	public void setPresentacion(String line)
	{
		this.presentacion = line;
	}
  public void setGradoDeAlcohol(int colour){
    this.gradoDeAlcohol=colour;
  }
  public void setMarca(String brand){
  this.marca=brand;
  }
  public void setTipo(String brand){
  this.tipo=brand;
  }
  public void setPaisOrigen(String brand){
  this.paisOrigen=brand;
  }

	// Metodos
	public String toString()
	{
		return this.idDepto+"_"+this.idProducto+"_"+this.presentacion+"_"+this.gradoDeAlcohol+"_"+this.marca+"_"+this.tipo+"_"+this.paisOrigen;
	}

	public String toStringSql()
	{
	return "'"+this.idDepto+"','"+this.idProducto+"','"+this.presentacion+"','"+this.gradoDeAlcohol+"','"+this.marca+"','"+this.tipo+"','"+this.paisOrigen+"'";
	}

	public String toStringSqlUpdate()
	{
    return "idDepto='"+this.idDepto+"',idProducto='"+this.idProducto+"',presentacion='"+this.presentacion+"',gradoDeAlcohol='"+this.gradoDeAlcohol+"',marca='"+this.marca+"',tipo='"+this.tipo+"',paisOrigen='"+this.paisOrigen+"' ";

	}
}
