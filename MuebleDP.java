import java.util.StringTokenizer;

public class MuebleDP //extends ProductoDP
{
	// Atributos
  private String linea, color, marca, acabados;
  private int idProducto, idDepto;
  
	// Constructor
	public MuebleDP()
	{
		//Atributos de ProductoDP
		this.idProducto    = 0;
    	this.idDepto        =0;

		//Atributos específicos de MuebleDP
		this.linea      = "";
		this.color      = "";
		this.marca      = "";
		this.acabados      = "";
	}

	public MuebleDP(String datos)
	{
		StringTokenizer st = new StringTokenizer(datos,"_");
		this.idDepto       =Integer.parseInt(st.nextToken());
		this.idProducto       = Integer.parseInt(st.nextToken());
		
		this.linea       = st.nextToken();
		this.color       = st.nextToken();
		this.marca       = st.nextToken();
		this.acabados       = st.nextToken();
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

  public String getLinea()
	{
		return this.linea;
	}
	public String getColor()
	{
		return this.color;
	}
  public String  getMarca()
	{
		return this.marca;
	}
  public String  getAcabados()
	{
		return this.acabados;
	}
  

	// Mutators o seters
	
	public void setLinea(String line)
	{
		this.linea = line;
	}
	public void setColor(String colour){
		this.color=colour;
	}
	public void setMarca(String brand){
	this.marca=brand;
	}
	public void setAcabados(String details){
	this.acabados=details;
	}
	// Metodos
	public String toString()
	{
		return this.idDepto+"_"+this.idProducto+"_"+this.linea+"_"+this.color+"_"+this.marca+"_"+this.acabados;
	}

	public String toStringSql()
	{
	return "'"+this.idDepto+"','"+this.idProducto+"','"+this.linea+"','"+this.color+"','"+this.marca+"','"+this.acabados+"'";
	}

	public String toStringSqlUpdate()
	{
    return "idDepto='"+this.idDepto+"',idProducto='"+this.idProducto+"',linea='"+this.linea+"', color='"+this.color+"',marca='"+this.marca+"',acabado='"+this.acabados+"' ";

	}
}