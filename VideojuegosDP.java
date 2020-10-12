import java.util.StringTokenizer;


public class VideojuegosDP
{

  private int idProducto, idDepto;
  private String clasificacion,titulo,consola;

public VideojuegosDP()
{
  this.idDepto        =0;
  this.idProducto    = 0;
  this.clasificacion="";
  this.titulo="";
  this.consola="";
}

public VideojuegosDP(String datos)
{
  StringTokenizer st= new StringTokenizer(datos,"_");
  this.idDepto       = Integer.parseInt(st.nextToken());
  this.idProducto       = Integer.parseInt(st.nextToken());
  this.clasificacion=st.nextToken();
  this.titulo=st.nextToken();
  this.consola=st.nextToken();
}

//Accesors


public int getidProducto()
{
  return this.idProducto;
}

public int getidDepto()
{
  return this.idDepto;
}

public String getClasificacion()
{
  return this.clasificacion;
}
public String getTitulo()
{
  return this.titulo;
}
public String getConsola()
{
  return this.consola;
}

//Mutators
public void setidProducto(int ip)
{
  this.idProducto = ip;
}

public void setidDepto(int dep)
{
  this.idDepto =dep;
}

public void setClasificacion(String cla)
{
  this.clasificacion=cla;
}
public void setTitulo(String tit)
{
  this.titulo=tit;
}
public void setConsola(String cons)
{
  this.consola=cons;
}


// Metodos
public String toString()
{
  return this.idDepto+"_"+this.idProducto+"_"+this.clasificacion+"_"+this.titulo+"_"+this.consola;
}

public String toStringSql()
{
return "'"+this.idDepto+"','"+this.idProducto+"','"+this.clasificacion+"','"+this.titulo+"','"+this.consola;
}

public String toStringSqlUpdate()
{
  return "idDepto='"+this.idDepto+"',idProducto='"+this.idProducto+"',clasificacion='"+this.clasificacion+"',titulo='"+this.titulo+"',consola='"+this.consola+"'";
}



















}
