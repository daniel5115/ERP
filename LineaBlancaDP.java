import java.util.StringTokenizer;


public class LineaBlancaDP
{

  private int idProducto, idDepto;
  private String marca,tipoenergia,consumoEnergetico,capacidad;

public LineaBlancaDP()
{
  this.idDepto        =0;
  this.idProducto    = 0;
  this.marca="";
  this.tipoenergia="";
  this.consumoEnergetico="";
  this.capacidad="";
}

public LineaBlancaDP(String datos)
{
  StringTokenizer st= new StringTokenizer(datos,"_");
  this.idDepto       = Integer.parseInt(st.nextToken());
  this.idProducto       = Integer.parseInt(st.nextToken());
  this.marca=st.nextToken();
  this.tipoenergia=st.nextToken();
  this.consumoEnergetico=st.nextToken();
  this.capacidad=st.nextToken();
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

public String getMarca()
{
  return this.marca;
}
public String getTipoEnergia()
{
  return this.tipoenergia;
}
public String getConsumoEnergetico()
{
  return this.consumoEnergetico;
}
public String getCapacidad()
{
  return this.capacidad;
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

public void setMarca(String cla)
{
  this.marca=cla;
}
public void setTipoEnergia(String tit)
{
  this.tipoenergia=tit;
}
public void setConsumoEnergetico(String cons)
{
  this.consumoEnergetico=cons;
}
public void setCapacidad(String cap)
{
  this.capacidad=cap;
}

// Metodos
public String toString()
{
  return this.idDepto+"_"+this.idProducto+"_"+this.marca+"_"+this.tipoenergia+"_"+this.consumoEnergetico+"_"+this.capacidad;
}

public String toStringSql()
{
return "'"+this.idDepto+"','"+this.idProducto+"','"+this.marca+"','"+this.tipoenergia+"','"+this.consumoEnergetico+"','"+this.capacidad;
}

public String toStringSqlUpdate()
{
  return "idDepto='"+this.idDepto+"',idProducto='"+this.idProducto+"',marca='"+this.marca+"',tipoEnergia='"+this.tipoenergia+"',consumoEnergetico='"+this.consumoEnergetico+"',capacidad='"+this.capacidad+"'";
}

}
