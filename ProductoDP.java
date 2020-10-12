import java.util.StringTokenizer;

public class ProductoDP
{
	// Atributos
	private int idDepto,idProducto;
  private String nombre,precioCompra,precioVenta,distribuidor,descripcion,estado,edoPromocion,precioPromocion;
	// Constructor
	public ProductoDP()
	{
		this.idProducto    = 0;
    this.idDepto        =0;
		this.nombre      = "";
    this.precioCompra="";
    this.precioVenta="";
    this.distribuidor="";
    this.descripcion="";
    this.estado="";
    this.edoPromocion="";
    this.precioPromocion="";
	//	this.telefono   = "";

	}

	public ProductoDP(String datos)
	{
		StringTokenizer st = new StringTokenizer(datos,"_");

		this.idProducto       = Integer.parseInt(st.nextToken());
    this.idDepto       =Integer.parseInt(st.nextToken());
		this.nombre       = st.nextToken();
    this.precioCompra       = st.nextToken();
    this.precioVenta       = st.nextToken();
    this.distribuidor       = st.nextToken();
    this.descripcion       = st.nextToken();
    this.estado       = st.nextToken();
    this.edoPromocion       = st.nextToken();
    this.precioPromocion       = st.nextToken();
    //this.       = st.nextToken();

    //this.telefono    = st.nextToken();
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

  public String getNombre()
	{
		return this.nombre;
	}
	public String getprecioCompra()
	{
		return this.precioCompra;
	}
  public String  getprecioVenta()
	{
		return this.precioVenta;
	}
  public String  getDistribuidor()
	{
		return this.distribuidor;
	}
  public String  getDescripcion()
	{
		return this.descripcion;
	}
  public String  getEstado()
	{
		return this.estado;
	}

  public String  getedoPromocion()
	{
		return this.edoPromocion;
	}
  public String  getprecioPromocion()
  {
    return this.precioPromocion;
  }

	// Mutators o seters
	public void setidProducto(int ip)
	{
		this.idProducto = ip;
	}

  public void setidDepto(int dep)
	{
		this.idDepto =dep;
	}
	public void setNombre(String nomb)
	{
		this.nombre = nomb;
	}
  public void setprecioCompra(String pc){
    this.precioCompra=pc;
  }
public void setprecioVenta(String pv){
  this.precioVenta=pv;
}
public void setDistribuidor(String dist){
  this.distribuidor=dist;
}
public void setDescripcion(String desc){
  this.descripcion=desc;
}
public void setEstado(String edo){
  this.estado=edo;
}
public void setedoPromocion(String edop){
  this.edoPromocion=edop;
}
public void setprecioPromocion(String prep ){
   this.precioPromocion=prep;
}



	// Metodos
	public String toString()
	{
    return this.idProducto+"_"+this.idDepto+"_"+this.nombre+"_"+this.precioCompra+"_"+this.precioVenta+"_"+this.distribuidor+"_"+this.descripcion+"_"+this.estado+"_"+this.edoPromocion+"_"+this.precioPromocion;
	}

	public String toStringSql()
	{
	return "'"+this.idProducto+"','"+this.idDepto+"','"+this.nombre+"','"+this.precioCompra+"','"+this.precioVenta+"','"+this.distribuidor+"','"+this.descripcion+"','"+this.estado+"','"+this.edoPromocion+"','"+this.precioPromocion+"'";
	}

	public String toStringSqlUpdate()
	{
    return "idProducto='"+this.idProducto+"',idDepto='"+this.idDepto+"',nombre='"+this.nombre+"',precioCompra='"+this.precioCompra+"',precioVenta='"+this.precioVenta+"',distribuidor='"+this.distribuidor+"',descripcion='"+this.descripcion+"',estado='"+this.estado+"',edoPromocion='"+this.edoPromocion+"',precioPromocion='"+this.precioPromocion+"'";

	}
}
