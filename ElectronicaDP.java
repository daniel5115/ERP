import java.util.StringTokenizer;

public class ElectronicaDP //extends ProductoDP
{
	// Atributos
  private String marca, tipo;
  private int idProducto, idDepto;
  
	// Constructor
	public ElectronicaDP()
	{
		//Atributos de ProductoDP
		this.idProducto    = 0;
    	this.idDepto        =0;

		//Atributos específicos de MuebleDP
		this.tipo      = "";
		this.marca      = "";
	}

	public ElectronicaDP(String datos)
	{
		StringTokenizer st = new StringTokenizer(datos,"_");
		this.idDepto       =Integer.parseInt(st.nextToken());
		this.idProducto       = Integer.parseInt(st.nextToken());
		
		this.tipo       = st.nextToken();
		this.marca       = st.nextToken();

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

  public String  getMarca()
	{
		return this.marca;
	}
  public String  getTipo()
	{
		return this.tipo;
	}
  

	// Mutators o seters
	
	public void setMarca(String brand){
	this.marca=brand;
	}
	public void setTipo(String type){
	this.tipo=type;
	}
	// Metodos
	public String toString()
	{
		return this.idDepto+"_"+this.idProducto+"_"+this.tipo+"_"+this.marca;
	}

	public String toStringSql()
	{
	return "'"+this.idDepto+"','"+this.idProducto+"','"+this.tipo+"','"+this.marca+"'";
	}

	public String toStringSqlUpdate()
	{
    return "idDepto='"+this.idDepto+"',idProducto='"+this.idProducto+"',tipo='"+this.tipo+"', marca='"+this.marca+"' ";

	}
}