import java.util.StringTokenizer;

public class RopaDP
{
	// Atributos
	private int idDepto,idProducto;
  private String material,talla,color,temporada,modelo,genero;
	// Constructor
	public RopaDP()
	{
		this.idDepto    = 0;
    this.idProducto        =0;
		this.material      = "";
    this.talla="";
    this.color="";
    this.temporada="";
    this.modelo="";
    this.genero="";



	}

	public RopaDP(String datos)
	{
		StringTokenizer st = new StringTokenizer(datos,"_");


		this.idDepto      = Integer.parseInt(st.nextToken());
    this.idProducto       =Integer.parseInt(st.nextToken());
		this.material    = st.nextToken();
    this.talla       = st.nextToken();
    this.color       = st.nextToken();
    this.temporada       = st.nextToken();
    this.modelo       = st.nextToken();
    this.genero       = st.nextToken();

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
  public String getMaterial()
	{
		return this.material;
	}
	public String getTalla()
	{
		return this.talla;
	}
  public String  getColor()
	{
		return this.color;
	}
  public String  getTemporada()
	{
		return this.temporada;
	}
  public String  getModelo()
	{
		return this.modelo;
	}
  public String  getGenero()
	{
		return this.genero;
	}


	// Mutators o seters

	public void setMaterial(String mat)
	{
		this.material = mat;
	}
  public void setTalla(String tall){
    this.talla=tall;
  }
public void setColor(String color){
  this.color=color;
}
public void setTemporada(String temp){
  this.temporada=temp;
}
public void setModelo(String mod){
  this.modelo=mod;
}
public void setGenero(String gen){
  this.genero=gen;
}




	// Metodos
	public String toString()
	{
		return this.idDepto+"_"+this.idProducto+"_"+this.material+"_"+this.talla+"_"+this.color+"_"+this.temporada+"_"+this.modelo+"_"+this.genero;
	}

	public String toStringSql()
	{
	return "'"+this.idDepto+"','"+this.idProducto+"','"+this.material+"','"+this.talla+"','"+this.color+"','"+this.temporada+"','"+this.modelo+"','"+this.genero+"'";
	}

	public String toStringSqlUpdate()
	{
    return "idDepto='"+this.idDepto+"',idProducto='"+this.idProducto+"',material='"+this.material+"',talla='"+this.talla+"',color='"+this.color+"',temporadar='"+this.temporada+"',modelo='"+this.modelo+"',genero='"+this.genero+"'";

	}
}
