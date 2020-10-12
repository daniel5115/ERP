import java.util.StringTokenizer;

public class InventarioDP
{
	// Atributos
	private int idCD,idProducto,cantidad;

	// Constructor
	public InventarioDP()
	{
		this.idCD     = 0;
    this.idProducto        =0;
		this.cantidad      = 0;
	//	this.telefono   = "";

	}

	public InventarioDP(String datos)
	{
		StringTokenizer st = new StringTokenizer(datos,"_");

		this.idCD       = Integer.parseInt(st.nextToken());
    this.idProducto       =Integer.parseInt(st.nextToken());
		this.cantidad       = Integer.parseInt(st.nextToken());
		//this.telefono    = st.nextToken();
	}

	// Accesors o geters
	public int getidCD()
	{
		return this.idCD;
	}

  public int getidProducto()
	{
		return this.idProducto;
	}
	public int getCantidad()
	{
		return this.cantidad;
	}





	// Mutators o seters
	public void setidCD(int cd)
	{
		this.idCD = cd;
	}

  public void setidProducto(int prod)
	{
		this.idProducto =prod;
	}
	public void setCantidad(int cant)
	{
		this.cantidad = cant;
	}







	// Metodos
	public String toString()
	{
		return this.idCD+"_"+this.idProducto+"_"+this.cantidad;
	}

	public String toStringSql()
	{
	return "'"+this.idCD+"','"+this.idProducto+"','"+this.cantidad+"'";
	}

	public String toStringSqlUpdate()
	{
    return "idCD='"+this.idCD+"',idProducto='"+this.idProducto+"',cantidad='"+this.cantidad+"'";

	}
}
