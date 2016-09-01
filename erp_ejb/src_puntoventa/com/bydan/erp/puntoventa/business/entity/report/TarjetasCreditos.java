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
package com.bydan.erp.puntoventa.business.entity.report;

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
//import com.bydan.erp.puntoventa.util.TarjetasCreditosConstantesFunciones;
import com.bydan.erp.puntoventa.util.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.puntoventa.util.*;

import com.bydan.erp.puntoventa.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.puntoventa.business.entity.*;




@SuppressWarnings("unused")
public class TarjetasCreditos extends TarjetasCreditosAdditional implements Serializable ,Cloneable {//TarjetasCreditosAdditional,GeneralEntity
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
	
	private TarjetasCreditos tarjetascreditosOriginal;
	
	private Map<String, Object> mapTarjetasCreditos;
			
	public Map<String, Object> getMapTarjetasCreditos() {
		return mapTarjetasCreditos;
	}

	public void setMapTarjetasCreditos(Map<String, Object> mapTarjetasCreditos) {
		this.mapTarjetasCreditos = mapTarjetasCreditos;
	}
	
	public void inicializarMapTarjetasCreditos() {
		this.mapTarjetasCreditos = new HashMap<String,Object>();
	}
	
	public void setMapTarjetasCreditosValue(String sKey,Object oValue) {
		this.mapTarjetasCreditos.put(sKey, oValue);
	}
	
	public Object getMapTarjetasCreditosValue(String sKey) {
		return this.mapTarjetasCreditos.get(sKey);
	}
	
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_empresa;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_sucursal;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_tarjeta_credito;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Date fecha_inicio;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Date fecha_fin;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=100,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	//@Pattern(regex=TarjetasCreditosConstantesFunciones.SREGEXNOMBRE_TARJETA,message=TarjetasCreditosConstantesFunciones.SMENSAJEREGEXNOMBRE_TARJETA)
	private String nombre_tarjeta;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=50,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	//@Pattern(regex=TarjetasCreditosConstantesFunciones.SREGEXLOTE,message=TarjetasCreditosConstantesFunciones.SMENSAJEREGEXLOTE)
	private String lote;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Date fecha;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double total;
			
	
	public Empresa empresa;
	public Sucursal sucursal;
	public TarjetaCredito tarjetacredito;
	
	
	private String empresa_descripcion;
	private String sucursal_descripcion;
	private String tarjetacredito_descripcion;
	
	
		
	public TarjetasCreditos () throws Exception {
		super();		
		
		this.id=0L;
		
		
		this.versionRow=new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());//new Date();
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		this.sType="NONE";
		
		this.tarjetascreditosOriginal=this;
		
 		this.id_empresa=-1L;
 		this.id_sucursal=-1L;
 		this.id_tarjeta_credito=-1L;
 		this.fecha_inicio=new Date();
 		this.fecha_fin=new Date();
 		this.nombre_tarjeta="";
 		this.lote="";
 		this.fecha=new Date();
 		this.total=0.0;
		
		
		this.empresa=null;
		this.sucursal=null;
		this.tarjetacredito=null;
		
		
		this.empresa_descripcion="";
		this.sucursal_descripcion="";
		this.tarjetacredito_descripcion="";
		
		
		
			
		
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
    //PARA REPORTES
	public TarjetasCreditos (Long id,Date versionRow,Long id_tarjeta_credito,String nombre_tarjeta,String lote,Date fecha,Double total) throws Exception {
		super();		
		
		this.id=id;
		this.versionRow=versionRow;
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.tarjetascreditosOriginal=this;
		
 		this.id_tarjeta_credito=id_tarjeta_credito;
 		this.nombre_tarjeta=nombre_tarjeta;
 		this.lote=lote;
 		this.fecha=fecha;
 		this.total=total;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	 //PARA REPORTES
	public TarjetasCreditos (Long id_tarjeta_credito,String nombre_tarjeta,String lote,Date fecha,Double total) throws Exception {
		super();		
		
		this.id=0L;
		this.versionRow=new Date();
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.tarjetascreditosOriginal=this;
		
 		this.id_tarjeta_credito=id_tarjeta_credito;
 		this.nombre_tarjeta=nombre_tarjeta;
 		this.lote=lote;
 		this.fecha=fecha;
 		this.total=total;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	
	public TarjetasCreditos getTarjetasCreditosOriginal() {
		return this.tarjetascreditosOriginal;
	}
	
	public void setTarjetasCreditosOriginal(TarjetasCreditos tarjetascreditos) {
		try {
			this.tarjetascreditosOriginal=tarjetascreditos;
		} catch(Exception e) {
			;
		}
	}
	
	
	protected TarjetasCreditosAdditional tarjetascreditosAdditional=null;
	
	public TarjetasCreditosAdditional getTarjetasCreditosAdditional() {
		return this.tarjetascreditosAdditional;
	}
	
	public void setTarjetasCreditosAdditional(TarjetasCreditosAdditional tarjetascreditosAdditional) {
		try {
			this.tarjetascreditosAdditional=tarjetascreditosAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
    
	
	public Long getid_empresa() {
		return this.id_empresa;
	}
    
	
	public Long getid_sucursal() {
		return this.id_sucursal;
	}
    
	
	public Long getid_tarjeta_credito() {
		return this.id_tarjeta_credito;
	}
    
	
	public Date getfecha_inicio() {
		return this.fecha_inicio;
	}
    
	
	public Date getfecha_fin() {
		return this.fecha_fin;
	}
    
	
	public String getnombre_tarjeta() {
		return this.nombre_tarjeta;
	}
    
	
	public String getlote() {
		return this.lote;
	}
    
	
	public Date getfecha() {
		return this.fecha;
	}
    
	
	public Double gettotal() {
		return this.total;
	}
	
    
	public void setid_empresa(Long newid_empresa)throws Exception
	{
		try {
			if(this.id_empresa!=newid_empresa) {
				if(newid_empresa==null) {
					//newid_empresa=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("TarjetasCreditos:Valor nulo no permitido en columna id_empresa");
					}
				}

				this.id_empresa=newid_empresa;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_sucursal(Long newid_sucursal)throws Exception
	{
		try {
			if(this.id_sucursal!=newid_sucursal) {
				if(newid_sucursal==null) {
					//newid_sucursal=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("TarjetasCreditos:Valor nulo no permitido en columna id_sucursal");
					}
				}

				this.id_sucursal=newid_sucursal;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_tarjeta_credito(Long newid_tarjeta_credito)throws Exception
	{
		try {
			if(this.id_tarjeta_credito!=newid_tarjeta_credito) {
				if(newid_tarjeta_credito==null) {
					//newid_tarjeta_credito=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("TarjetasCreditos:Valor nulo no permitido en columna id_tarjeta_credito");
					}
				}

				this.id_tarjeta_credito=newid_tarjeta_credito;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setfecha_inicio(Date newfecha_inicio)throws Exception
	{
		try {
			if(this.fecha_inicio!=newfecha_inicio) {
				if(newfecha_inicio==null) {
					//newfecha_inicio=new Date();
					if(Constantes.ISDEVELOPING) {
						System.out.println("TarjetasCreditos:Valor nulo no permitido en columna fecha_inicio");
					}
				}

				this.fecha_inicio=newfecha_inicio;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setfecha_fin(Date newfecha_fin)throws Exception
	{
		try {
			if(this.fecha_fin!=newfecha_fin) {
				if(newfecha_fin==null) {
					//newfecha_fin=new Date();
					if(Constantes.ISDEVELOPING) {
						System.out.println("TarjetasCreditos:Valor nulo no permitido en columna fecha_fin");
					}
				}

				this.fecha_fin=newfecha_fin;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setnombre_tarjeta(String newnombre_tarjeta)throws Exception
	{
		try {
			if(this.nombre_tarjeta!=newnombre_tarjeta) {
				if(newnombre_tarjeta==null) {
					//newnombre_tarjeta="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("TarjetasCreditos:Valor nulo no permitido en columna nombre_tarjeta");
					}
				}

				if(newnombre_tarjeta!=null&&newnombre_tarjeta.length()>100) {
					newnombre_tarjeta=newnombre_tarjeta.substring(0,98);
					System.out.println("TarjetasCreditos:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=100 en columna nombre_tarjeta");
				}

				this.nombre_tarjeta=newnombre_tarjeta;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setlote(String newlote)throws Exception
	{
		try {
			if(this.lote!=newlote) {
				if(newlote==null) {
					//newlote="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("TarjetasCreditos:Valor nulo no permitido en columna lote");
					}
				}

				if(newlote!=null&&newlote.length()>50) {
					newlote=newlote.substring(0,48);
					System.out.println("TarjetasCreditos:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=50 en columna lote");
				}

				this.lote=newlote;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setfecha(Date newfecha)throws Exception
	{
		try {
			if(this.fecha!=newfecha) {
				if(newfecha==null) {
					//newfecha=new Date();
					if(Constantes.ISDEVELOPING) {
						System.out.println("TarjetasCreditos:Valor nulo no permitido en columna fecha");
					}
				}

				this.fecha=newfecha;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void settotal(Double newtotal)throws Exception
	{
		try {
			if(this.total!=newtotal) {
				if(newtotal==null) {
					//newtotal=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("TarjetasCreditos:Valor nulo no permitido en columna total");
					}
				}

				this.total=newtotal;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	
	public Empresa getEmpresa() {
		return this.empresa;
	}

	public Sucursal getSucursal() {
		return this.sucursal;
	}

	public TarjetaCredito getTarjetaCredito() {
		return this.tarjetacredito;
	}

	
	
	public String getempresa_descripcion() {
		return this.empresa_descripcion;
	}

	public String getsucursal_descripcion() {
		return this.sucursal_descripcion;
	}

	public String gettarjetacredito_descripcion() {
		return this.tarjetacredito_descripcion;
	}

	
	
	public  void  setEmpresa(Empresa empresa) {
		try {
			this.empresa=empresa;
		} catch(Exception e) {
			;
		}
	}


	public  void  setSucursal(Sucursal sucursal) {
		try {
			this.sucursal=sucursal;
		} catch(Exception e) {
			;
		}
	}


	public  void  setTarjetaCredito(TarjetaCredito tarjetacredito) {
		try {
			this.tarjetacredito=tarjetacredito;
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


	public  void  setsucursal_descripcion(String sucursal_descripcion) {
		try {
			this.sucursal_descripcion=sucursal_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  settarjetacredito_descripcion(String tarjetacredito_descripcion) {
		try {
			this.tarjetacredito_descripcion=tarjetacredito_descripcion;
		} catch(Exception e) {
			;
		}
	}


	
	
	
	
	
	/*PARA REPORTES*/
	String id_empresa_descripcion="";String id_sucursal_descripcion="";String id_tarjeta_credito_descripcion="";
	
	
	public String getid_empresa_descripcion() {
		return id_empresa_descripcion;
	}
	public String getid_sucursal_descripcion() {
		return id_sucursal_descripcion;
	}
	public String getid_tarjeta_credito_descripcion() {
		return id_tarjeta_credito_descripcion;
	}
	
	
	public void setid_empresa_descripcion(String newid_empresa_descripcion)throws Exception {
		try {
			this.id_empresa_descripcion=newid_empresa_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_sucursal_descripcion(String newid_sucursal_descripcion)throws Exception {
		try {
			this.id_sucursal_descripcion=newid_sucursal_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_tarjeta_credito_descripcion(String newid_tarjeta_credito_descripcion)throws Exception {
		try {
			this.id_tarjeta_credito_descripcion=newid_tarjeta_credito_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	
	public void inicializarVariablesParaReporte() {
		this.id_empresa_descripcion="";this.id_sucursal_descripcion="";this.id_tarjeta_credito_descripcion="";
	}
	
	
	
	
	
	
	/*PARA REPORTES FIN*/		
}

