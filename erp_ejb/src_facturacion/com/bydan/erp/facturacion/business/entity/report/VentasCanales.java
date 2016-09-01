/*
*AVISO LEGAL
© Copyright
*Este programa esta protegido por la ley de derechos de autor.
*La reproduccion o distribucion ilicita de este programa o de cualquiera de
*sus partes esta penado por la ley con severas sanciones civiles y penales,
*y seran objeto de todas las sanciones legales que correspondan.

*Su contenido no puede copiarse para fines comerciales o de otras,
*ni puede mostrarse, incluso en una version modificada, en otros sitios Web.
Solo esta permitido colocar hipervinculos al sitio web.
*/
package com.bydan.erp.facturacion.business.entity.report;

import java.io.Serializable;
import java.io.File;

import java.util.Calendar;
import java.sql.Timestamp;
import java.util.Set;
import java.util.HashSet;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.Date;



import org.hibernate.validator.*;

import com.bydan.framework.erp.business.entity.*;
import com.bydan.framework.erp.business.entity.DatoGeneral;
import com.bydan.framework.erp.business.dataaccess.ConstantesSql;
//import com.bydan.framework.erp.business.entity.Mensajes;
import com.bydan.framework.erp.util.Constantes;
import com.bydan.framework.erp.util.ConstantesValidacion;
//import com.bydan.erp.facturacion.util.VentasCanalesConstantesFunciones;
import com.bydan.erp.facturacion.util.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.cartera.util.*;

import com.bydan.erp.facturacion.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;




@SuppressWarnings("unused")
public class VentasCanales extends VentasCanalesAdditional implements Serializable ,Cloneable {//VentasCanalesAdditional,GeneralEntity
	private static final long serialVersionUID=1L;
	
	public Object clone() {
        return super.clone();
    }
	
	protected Long id;
	protected boolean isNew;
	protected boolean isChanged;
	protected boolean isDeleted;
	protected boolean isSelected;
	protected Date versionRow;
	protected String sType;
	
	public Long getId() {
		return this.id;
	}
	
	public void setId(Long newId) {
		if(this.id!=newId) {
			this.isChanged=true;
		}
		
		this.id=newId;
		super.setId(newId);
	}
	
	
	
	public Date getVersionRow(){
		//ESTO SIEMPRE SE EJECUTA CUANDO SE CONSUME EJB
		return this.versionRow;
	}
	
	public void setVersionRow(Date newVersionRow){
		if(this.versionRow!=newVersionRow){
			//LE COMENTO PORQUE CUANDO HAGO GET SIEMPRE POR ESTO LE PONE isChanged=true
			//this.isChanged=true;
		}
		
		this.versionRow=newVersionRow;
		super.setVersionRow(newVersionRow);
	}
	
	
	public boolean getIsNew() {
		return this.isNew;
	}
	
	public void setIsNew(boolean newIsNew) {
		this.isNew=newIsNew;
		super.setIsNew(newIsNew);
	}
	
	public boolean getIsChanged() {
		return this.isChanged;
	}
	
	public void setIsChanged(boolean newIsChanged) {
		this.isChanged=newIsChanged;
		super.setIsChanged(newIsChanged);
	}
	
	public boolean getIsDeleted() {
		return this.isDeleted;
	}
	
	public void setIsDeleted(boolean newIsDeleted) {
		this.isDeleted=newIsDeleted;
		super.setIsDeleted(newIsDeleted);
	}
	
	public boolean getIsSelected() {
		return this.isSelected;
	}
	
	public void setIsSelected(boolean newIsSelected) {
		this.isSelected=newIsSelected;
		super.setIsSelected(newIsSelected);
	}
	
	public String getsType() {
		return this.sType;
	}
	
	public void setsType(String sType) {
		this.sType=sType;
		super.setsType(sType);
	}
	
	private VentasCanales ventascanalesOriginal;
	
	private Map<String, Object> mapVentasCanales;
			
	public Map<String, Object> getMapVentasCanales() {
		return mapVentasCanales;
	}

	public void setMapVentasCanales(Map<String, Object> mapVentasCanales) {
		this.mapVentasCanales = mapVentasCanales;
	}
	
	public void inicializarMapVentasCanales() {
		this.mapVentasCanales = new HashMap<String,Object>();
	}
	
	public void setMapVentasCanalesValue(String sKey,Object oValue) {
		this.mapVentasCanales.put(sKey, oValue);
	}
	
	public Object getMapVentasCanalesValue(String sKey) {
		return this.mapVentasCanales.get(sKey);
	}
	
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_empresa;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_titulo_cliente;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Date fecha_emision_desde;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Date fecha_emision_hasta;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=150,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	//@Pattern(regex=VentasCanalesConstantesFunciones.SREGEXNOMBRE_TITULO_CLIENTE,message=VentasCanalesConstantesFunciones.SMENSAJEREGEXNOMBRE_TITULO_CLIENTE)
	private String nombre_titulo_cliente;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double monto;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=50,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	//@Pattern(regex=VentasCanalesConstantesFunciones.SREGEXCODIGO_TITULO_CLIENTE,message=VentasCanalesConstantesFunciones.SMENSAJEREGEXCODIGO_TITULO_CLIENTE)
	private String codigo_titulo_cliente;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double notas_credito;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double venta_neta;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double porcentaje;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double acumulado;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=50,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	//@Pattern(regex=VentasCanalesConstantesFunciones.SREGEXTIPO,message=VentasCanalesConstantesFunciones.SMENSAJEREGEXTIPO)
	private String tipo;
			
	
	public Empresa empresa;
	public TituloCliente titulocliente;
	
	
	private String empresa_descripcion;
	private String titulocliente_descripcion;
	
	
		
	public VentasCanales () throws Exception {
		super();		
		
		this.id=0L;
		
		
		this.versionRow=new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());//new Date();
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		this.sType="NONE";
		
		this.ventascanalesOriginal=this;
		
 		this.id_empresa=-1L;
 		this.id_titulo_cliente=-1L;
 		this.fecha_emision_desde=new Date();
 		this.fecha_emision_hasta=new Date();
 		this.nombre_titulo_cliente="";
 		this.monto=0.0;
 		this.codigo_titulo_cliente="";
 		this.notas_credito=0.0;
 		this.venta_neta=0.0;
 		this.porcentaje=0.0;
 		this.acumulado=0.0;
 		this.tipo="";
		
		
		this.empresa=null;
		this.titulocliente=null;
		
		
		this.empresa_descripcion="";
		this.titulocliente_descripcion="";
		
		
		
			
		
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
    //PARA REPORTES
	public VentasCanales (Long id,Date versionRow,String nombre_titulo_cliente,Double monto,String codigo_titulo_cliente,Double notas_credito,Double venta_neta,Double porcentaje,Double acumulado,String tipo) throws Exception {
		super();		
		
		this.id=id;
		this.versionRow=versionRow;
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.ventascanalesOriginal=this;
		
 		this.nombre_titulo_cliente=nombre_titulo_cliente;
 		this.monto=monto;
 		this.codigo_titulo_cliente=codigo_titulo_cliente;
 		this.notas_credito=notas_credito;
 		this.venta_neta=venta_neta;
 		this.porcentaje=porcentaje;
 		this.acumulado=acumulado;
 		this.tipo=tipo;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	 //PARA REPORTES
	public VentasCanales (String nombre_titulo_cliente,Double monto,String codigo_titulo_cliente,Double notas_credito,Double venta_neta,Double porcentaje,Double acumulado,String tipo) throws Exception {
		super();		
		
		this.id=0L;
		this.versionRow=new Date();
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.ventascanalesOriginal=this;
		
 		this.nombre_titulo_cliente=nombre_titulo_cliente;
 		this.monto=monto;
 		this.codigo_titulo_cliente=codigo_titulo_cliente;
 		this.notas_credito=notas_credito;
 		this.venta_neta=venta_neta;
 		this.porcentaje=porcentaje;
 		this.acumulado=acumulado;
 		this.tipo=tipo;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	
	public VentasCanales getVentasCanalesOriginal() {
		return this.ventascanalesOriginal;
	}
	
	public void setVentasCanalesOriginal(VentasCanales ventascanales) {
		try {
			this.ventascanalesOriginal=ventascanales;
		} catch(Exception e) {
			;
		}
	}
	
	
	protected VentasCanalesAdditional ventascanalesAdditional=null;
	
	public VentasCanalesAdditional getVentasCanalesAdditional() {
		return this.ventascanalesAdditional;
	}
	
	public void setVentasCanalesAdditional(VentasCanalesAdditional ventascanalesAdditional) {
		try {
			this.ventascanalesAdditional=ventascanalesAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
    
	
	public Long getid_empresa() {
		return this.id_empresa;
	}
    
	
	public Long getid_titulo_cliente() {
		return this.id_titulo_cliente;
	}
    
	
	public Date getfecha_emision_desde() {
		return this.fecha_emision_desde;
	}
    
	
	public Date getfecha_emision_hasta() {
		return this.fecha_emision_hasta;
	}
    
	
	public String getnombre_titulo_cliente() {
		return this.nombre_titulo_cliente;
	}
    
	
	public Double getmonto() {
		return this.monto;
	}
    
	
	public String getcodigo_titulo_cliente() {
		return this.codigo_titulo_cliente;
	}
    
	
	public Double getnotas_credito() {
		return this.notas_credito;
	}
    
	
	public Double getventa_neta() {
		return this.venta_neta;
	}
    
	
	public Double getporcentaje() {
		return this.porcentaje;
	}
    
	
	public Double getacumulado() {
		return this.acumulado;
	}
    
	
	public String gettipo() {
		return this.tipo;
	}
	
    
	public void setid_empresa(Long newid_empresa)throws Exception
	{
		try {
			if(this.id_empresa!=newid_empresa) {
				if(newid_empresa==null) {
					//newid_empresa=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("VentasCanales:Valor nulo no permitido en columna id_empresa");
					}
				}

				this.id_empresa=newid_empresa;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_titulo_cliente(Long newid_titulo_cliente)throws Exception
	{
		try {
			if(this.id_titulo_cliente!=newid_titulo_cliente) {
				if(newid_titulo_cliente==null) {
					//newid_titulo_cliente=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("VentasCanales:Valor nulo no permitido en columna id_titulo_cliente");
					}
				}

				this.id_titulo_cliente=newid_titulo_cliente;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setfecha_emision_desde(Date newfecha_emision_desde)throws Exception
	{
		try {
			if(this.fecha_emision_desde!=newfecha_emision_desde) {
				if(newfecha_emision_desde==null) {
					//newfecha_emision_desde=new Date();
					if(Constantes.ISDEVELOPING) {
						System.out.println("VentasCanales:Valor nulo no permitido en columna fecha_emision_desde");
					}
				}

				this.fecha_emision_desde=newfecha_emision_desde;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setfecha_emision_hasta(Date newfecha_emision_hasta)throws Exception
	{
		try {
			if(this.fecha_emision_hasta!=newfecha_emision_hasta) {
				if(newfecha_emision_hasta==null) {
					//newfecha_emision_hasta=new Date();
					if(Constantes.ISDEVELOPING) {
						System.out.println("VentasCanales:Valor nulo no permitido en columna fecha_emision_hasta");
					}
				}

				this.fecha_emision_hasta=newfecha_emision_hasta;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setnombre_titulo_cliente(String newnombre_titulo_cliente)throws Exception
	{
		try {
			if(this.nombre_titulo_cliente!=newnombre_titulo_cliente) {
				if(newnombre_titulo_cliente==null) {
					//newnombre_titulo_cliente="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("VentasCanales:Valor nulo no permitido en columna nombre_titulo_cliente");
					}
				}

				if(newnombre_titulo_cliente!=null&&newnombre_titulo_cliente.length()>150) {
					newnombre_titulo_cliente=newnombre_titulo_cliente.substring(0,148);
					System.out.println("VentasCanales:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=150 en columna nombre_titulo_cliente");
				}

				this.nombre_titulo_cliente=newnombre_titulo_cliente;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setmonto(Double newmonto)throws Exception
	{
		try {
			if(this.monto!=newmonto) {
				if(newmonto==null) {
					//newmonto=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("VentasCanales:Valor nulo no permitido en columna monto");
					}
				}

				this.monto=newmonto;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setcodigo_titulo_cliente(String newcodigo_titulo_cliente)throws Exception
	{
		try {
			if(this.codigo_titulo_cliente!=newcodigo_titulo_cliente) {
				if(newcodigo_titulo_cliente==null) {
					//newcodigo_titulo_cliente="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("VentasCanales:Valor nulo no permitido en columna codigo_titulo_cliente");
					}
				}

				if(newcodigo_titulo_cliente!=null&&newcodigo_titulo_cliente.length()>50) {
					newcodigo_titulo_cliente=newcodigo_titulo_cliente.substring(0,48);
					System.out.println("VentasCanales:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=50 en columna codigo_titulo_cliente");
				}

				this.codigo_titulo_cliente=newcodigo_titulo_cliente;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setnotas_credito(Double newnotas_credito)throws Exception
	{
		try {
			if(this.notas_credito!=newnotas_credito) {
				if(newnotas_credito==null) {
					//newnotas_credito=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("VentasCanales:Valor nulo no permitido en columna notas_credito");
					}
				}

				this.notas_credito=newnotas_credito;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setventa_neta(Double newventa_neta)throws Exception
	{
		try {
			if(this.venta_neta!=newventa_neta) {
				if(newventa_neta==null) {
					//newventa_neta=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("VentasCanales:Valor nulo no permitido en columna venta_neta");
					}
				}

				this.venta_neta=newventa_neta;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setporcentaje(Double newporcentaje)throws Exception
	{
		try {
			if(this.porcentaje!=newporcentaje) {
				if(newporcentaje==null) {
					//newporcentaje=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("VentasCanales:Valor nulo no permitido en columna porcentaje");
					}
				}

				this.porcentaje=newporcentaje;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setacumulado(Double newacumulado)throws Exception
	{
		try {
			if(this.acumulado!=newacumulado) {
				if(newacumulado==null) {
					//newacumulado=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("VentasCanales:Valor nulo no permitido en columna acumulado");
					}
				}

				this.acumulado=newacumulado;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void settipo(String newtipo)throws Exception
	{
		try {
			if(this.tipo!=newtipo) {
				if(newtipo==null) {
					//newtipo="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("VentasCanales:Valor nulo no permitido en columna tipo");
					}
				}

				if(newtipo!=null&&newtipo.length()>50) {
					newtipo=newtipo.substring(0,48);
					System.out.println("VentasCanales:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=50 en columna tipo");
				}

				this.tipo=newtipo;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	
	public Empresa getEmpresa() {
		return this.empresa;
	}

	public TituloCliente getTituloCliente() {
		return this.titulocliente;
	}

	
	
	public String getempresa_descripcion() {
		return this.empresa_descripcion;
	}

	public String gettitulocliente_descripcion() {
		return this.titulocliente_descripcion;
	}

	
	
	public  void  setEmpresa(Empresa empresa) {
		try {
			this.empresa=empresa;
		} catch(Exception e) {
			;
		}
	}


	public  void  setTituloCliente(TituloCliente titulocliente) {
		try {
			this.titulocliente=titulocliente;
		} catch(Exception e) {
			;
		}
	}


	
	
	public  void  setempresa_descripcion(String empresa_descripcion) {
		try {
			this.empresa_descripcion=empresa_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  settitulocliente_descripcion(String titulocliente_descripcion) {
		try {
			this.titulocliente_descripcion=titulocliente_descripcion;
		} catch(Exception e) {
			;
		}
	}


	
	
	
	
	
	/*PARA REPORTES*/
	String id_empresa_descripcion="";String id_titulo_cliente_descripcion="";
	
	
	public String getid_empresa_descripcion() {
		return id_empresa_descripcion;
	}
	public String getid_titulo_cliente_descripcion() {
		return id_titulo_cliente_descripcion;
	}
	
	
	public void setid_empresa_descripcion(String newid_empresa_descripcion)throws Exception {
		try {
			this.id_empresa_descripcion=newid_empresa_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_titulo_cliente_descripcion(String newid_titulo_cliente_descripcion)throws Exception {
		try {
			this.id_titulo_cliente_descripcion=newid_titulo_cliente_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	
	public void inicializarVariablesParaReporte() {
		this.id_empresa_descripcion="";this.id_titulo_cliente_descripcion="";
	}
	
	
	
	
	
	
	/*PARA REPORTES FIN*/		
}

