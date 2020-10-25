import java.util.StringTokenizer;

public class CentroDistribucionDP
{
	// Atributos
	private int idCD;
  private String nombre,coordenadas;

	// Constructor
	public CentroDistribucionDP()
	{
		this.idCD     = 0;
    this.nombre        ="";
		this.coordenadas      = "";
	//	this.telefono   = "";

	}

	public CentroDistribucionDP(String datos)
	{
		StringTokenizer st = new StringTokenizer(datos,"_");

		this.idCD       = Integer.parseInt(st.nextToken());
    this.nombre       =st.nextToken();
		this.coordenadas       = st.nextToken();
		//this.telefono    = st.nextToken();
	}

	// Accesors o geters
	public int getidCD()
	{
		return this.idCD;
	}

  public String getName()
	{
		return this.nombre;
	}
	public String getCoordenadas()
	{
		return this.coordenadas;
	}





	// Mutators o seters
	public void setidCD(int cd)
	{
		this.idCD = cd;
	}

  public void setidProducto(String nom)
	{
		this.nombre =nom;
	}
	public void setCantidad(String coord)
	{
		this.coordenadas = coord;
	}







	// Metodos
	public String toString()
	{
		return this.idCD+"_"+this.nombre+"_"+this.coordenadas;
	}

	public String toStringSql()
	{
	return "'"+this.idCD+"','"+this.nombre+"','"+this.coordenadas+"'";
	}

	public String toStringSqlUpdate()
	{
    return "idCD='"+this.idCD+"',nombre='"+this.nombre+"',coordenadas='"+this.coordenadas+"'";

	}
}
