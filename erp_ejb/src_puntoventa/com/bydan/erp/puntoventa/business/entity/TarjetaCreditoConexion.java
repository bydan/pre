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
package com.bydan.erp.puntoventa.business.entity;

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
//import com.bydan.erp.puntoventa.util.TarjetaCreditoConexionConstantesFunciones;
import com.bydan.erp.puntoventa.util.*;


import com.bydan.erp.seguridad.util.*;



import com.bydan.erp.seguridad.business.entity.*;




@SuppressWarnings("unused")
public class TarjetaCreditoConexion extends TarjetaCreditoConexionAdditional implements Serializable ,Cloneable {//TarjetaCreditoConexionAdditional,GeneralEntity
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
	
	private TarjetaCreditoConexion tarjetacreditoconexionOriginal;
	
	private Map<String, Object> mapTarjetaCreditoConexion;
			
	public Map<String, Object> getMapTarjetaCreditoConexion() {
		return mapTarjetaCreditoConexion;
	}

	public void setMapTarjetaCreditoConexion(Map<String, Object> mapTarjetaCreditoConexion) {
		this.mapTarjetaCreditoConexion = mapTarjetaCreditoConexion;
	}
	
	public void inicializarMapTarjetaCreditoConexion() {
		this.mapTarjetaCreditoConexion = new HashMap<String,Object>();
	}
	
	public void setMapTarjetaCreditoConexionValue(String sKey,Object oValue) {
		this.mapTarjetaCreditoConexion.put(sKey, oValue);
	}
	
	public Object getMapTarjetaCreditoConexionValue(String sKey) {
		return this.mapTarjetaCreditoConexion.get(sKey);
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
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_conexion;
			
	
	public Empresa empresa;
	public Sucursal sucursal;
	public TarjetaCredito tarjetacredito;
	public Conexion conexion;
	
	
	private String empresa_descripcion;
	private String sucursal_descripcion;
	private String tarjetacredito_descripcion;
	private String conexion_descripcion;
	
	
		
	public TarjetaCreditoConexion () throws Exception {
		super();		
		
		this.id=0L;
		
		
		this.versionRow=new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());//new Date();
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		this.sType="NONE";
		
		this.tarjetacreditoconexionOriginal=this;
		
 		this.id_empresa=-1L;
 		this.id_sucursal=-1L;
 		this.id_tarjeta_credito=-1L;
 		this.id_conexion=-1L;
		
		
		this.empresa=null;
		this.sucursal=null;
		this.tarjetacredito=null;
		this.conexion=null;
		
		
		this.empresa_descripcion="";
		this.sucursal_descripcion="";
		this.tarjetacredito_descripcion="";
		this.conexion_descripcion="";
		
		
		
			
		
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
    //PARA REPORTES
	public TarjetaCreditoConexion (Long id,Date versionRow,Long id_empresa,Long id_sucursal,Long id_tarjeta_credito,Long id_conexion) throws Exception {
		super();		
		
		this.id=id;
		this.versionRow=versionRow;
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.tarjetacreditoconexionOriginal=this;
		
 		this.id_empresa=id_empresa;
 		this.id_sucursal=id_sucursal;
 		this.id_tarjeta_credito=id_tarjeta_credito;
 		this.id_conexion=id_conexion;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	 //PARA REPORTES
	public TarjetaCreditoConexion (Long id_empresa,Long id_sucursal,Long id_tarjeta_credito,Long id_conexion) throws Exception {
		super();		
		
		this.id=0L;
		this.versionRow=new Date();
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.tarjetacreditoconexionOriginal=this;
		
 		this.id_empresa=id_empresa;
 		this.id_sucursal=id_sucursal;
 		this.id_tarjeta_credito=id_tarjeta_credito;
 		this.id_conexion=id_conexion;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	public boolean equals(Object object) {
		boolean equal=false;
		TarjetaCreditoConexion tarjetacreditoconexionLocal=null;
		
		if(object!=null) {
			tarjetacreditoconexionLocal=(TarjetaCreditoConexion)object;
			
			if(tarjetacreditoconexionLocal!=null) {
				if(this.getId()!=null && tarjetacreditoconexionLocal.getId()!=null) {
					if(this.getId().equals(tarjetacreditoconexionLocal.getId())) {
						equal=true;
					}
				}
			}
		}
		
		return equal;
	}
	
	public String toString() {
		String sDetalle="";
		
		if(!TarjetaCreditoConexionConstantesFunciones.CON_DESCRIPCION_DETALLADO) {
        	sDetalle=TarjetaCreditoConexionConstantesFunciones.getTarjetaCreditoConexionDescripcion(this);
		} else {
			sDetalle=TarjetaCreditoConexionConstantesFunciones.getTarjetaCreditoConexionDescripcionDetallado(this);
		}
		
		return sDetalle;
    }
	
	public TarjetaCreditoConexion getTarjetaCreditoConexionOriginal() {
		return this.tarjetacreditoconexionOriginal;
	}
	
	public void setTarjetaCreditoConexionOriginal(TarjetaCreditoConexion tarjetacreditoconexion) {
		try {
			this.tarjetacreditoconexionOriginal=tarjetacreditoconexion;
		} catch(Exception e) {
			;
		}
	}
	
	
	protected TarjetaCreditoConexionAdditional tarjetacreditoconexionAdditional=null;
	
	public TarjetaCreditoConexionAdditional getTarjetaCreditoConexionAdditional() {
		return this.tarjetacreditoconexionAdditional;
	}
	
	public void setTarjetaCreditoConexionAdditional(TarjetaCreditoConexionAdditional tarjetacreditoconexionAdditional) {
		try {
			this.tarjetacreditoconexionAdditional=tarjetacreditoconexionAdditional;
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
    
	
	public Long getid_conexion() {
		return this.id_conexion;
	}
	
    
	public void setid_empresa(Long newid_empresa)throws Exception
	{
		try {
			if(this.id_empresa!=newid_empresa) {
				if(newid_empresa==null) {
					//newid_empresa=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("TarjetaCreditoConexion:Valor nulo no permitido en columna id_empresa");
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
						System.out.println("TarjetaCreditoConexion:Valor nulo no permitido en columna id_sucursal");
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
						System.out.println("TarjetaCreditoConexion:Valor nulo no permitido en columna id_tarjeta_credito");
					}
				}

				this.id_tarjeta_credito=newid_tarjeta_credito;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_conexion(Long newid_conexion)throws Exception
	{
		try {
			if(this.id_conexion!=newid_conexion) {
				if(newid_conexion==null) {
					//newid_conexion=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("TarjetaCreditoConexion:Valor nulo no permitido en columna id_conexion");
					}
				}

				this.id_conexion=newid_conexion;
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

	public Conexion getConexion() {
		return this.conexion;
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

	public String getconexion_descripcion() {
		return this.conexion_descripcion;
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


	public  void  setConexion(Conexion conexion) {
		try {
			this.conexion=conexion;
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


	public  void  setconexion_descripcion(String conexion_descripcion) {
		try {
			this.conexion_descripcion=conexion_descripcion;
		} catch(Exception e) {
			;
		}
	}


	
	
	
	
	
	/*PARA REPORTES*/
	String id_empresa_descripcion="";String id_sucursal_descripcion="";String id_tarjeta_credito_descripcion="";String id_conexion_descripcion="";
	
	
	public String getid_empresa_descripcion() {
		return id_empresa_descripcion;
	}
	public String getid_sucursal_descripcion() {
		return id_sucursal_descripcion;
	}
	public String getid_tarjeta_credito_descripcion() {
		return id_tarjeta_credito_descripcion;
	}
	public String getid_conexion_descripcion() {
		return id_conexion_descripcion;
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
	public void setid_conexion_descripcion(String newid_conexion_descripcion)throws Exception {
		try {
			this.id_conexion_descripcion=newid_conexion_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	
	public void inicializarVariablesParaReporte() {
		this.id_empresa_descripcion="";this.id_sucursal_descripcion="";this.id_tarjeta_credito_descripcion="";this.id_conexion_descripcion="";
	}
	
	
	
	
	
	
	/*PARA REPORTES FIN*/		
}

