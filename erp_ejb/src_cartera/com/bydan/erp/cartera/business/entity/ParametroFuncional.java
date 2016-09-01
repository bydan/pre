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
package com.bydan.erp.cartera.business.entity;

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
//import com.bydan.erp.cartera.util.ParametroFuncionalConstantesFunciones;
import com.bydan.erp.cartera.util.*;









@SuppressWarnings("unused")
public class ParametroFuncional extends ParametroFuncionalAdditional implements Serializable ,Cloneable {//ParametroFuncionalAdditional,GeneralEntity
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
	
	private ParametroFuncional parametrofuncionalOriginal;
	
	private Map<String, Object> mapParametroFuncional;
			
	public Map<String, Object> getMapParametroFuncional() {
		return mapParametroFuncional;
	}

	public void setMapParametroFuncional(Map<String, Object> mapParametroFuncional) {
		this.mapParametroFuncional = mapParametroFuncional;
	}
	
	public void inicializarMapParametroFuncional() {
		this.mapParametroFuncional = new HashMap<String,Object>();
	}
	
	public void setMapParametroFuncionalValue(String sKey,Object oValue) {
		this.mapParametroFuncional.put(sKey, oValue);
	}
	
	public Object getMapParametroFuncionalValue(String sKey) {
		return this.mapParametroFuncional.get(sKey);
	}
	
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Boolean con_copia_clientes;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Boolean con_copia_proveedor;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Boolean con_proveedor_cliente;
			
	
	
	
	
	
		
	public ParametroFuncional () throws Exception {
		super();		
		
		this.id=0L;
		
		
		this.versionRow=new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());//new Date();
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		this.sType="NONE";
		
		this.parametrofuncionalOriginal=this;
		
 		this.con_copia_clientes=false;
 		this.con_copia_proveedor=false;
 		this.con_proveedor_cliente=false;
		
		
		
		
		
		
		
			
		
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
    //PARA REPORTES
	public ParametroFuncional (Long id,Date versionRow,Boolean con_copia_clientes,Boolean con_copia_proveedor,Boolean con_proveedor_cliente) throws Exception {
		super();		
		
		this.id=id;
		this.versionRow=versionRow;
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.parametrofuncionalOriginal=this;
		
 		this.con_copia_clientes=con_copia_clientes;
 		this.con_copia_proveedor=con_copia_proveedor;
 		this.con_proveedor_cliente=con_proveedor_cliente;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	 //PARA REPORTES
	public ParametroFuncional (Boolean con_copia_clientes,Boolean con_copia_proveedor,Boolean con_proveedor_cliente) throws Exception {
		super();		
		
		this.id=0L;
		this.versionRow=new Date();
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.parametrofuncionalOriginal=this;
		
 		this.con_copia_clientes=con_copia_clientes;
 		this.con_copia_proveedor=con_copia_proveedor;
 		this.con_proveedor_cliente=con_proveedor_cliente;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	public boolean equals(Object object) {
		boolean equal=false;
		ParametroFuncional parametrofuncionalLocal=null;
		
		if(object!=null) {
			parametrofuncionalLocal=(ParametroFuncional)object;
			
			if(parametrofuncionalLocal!=null) {
				if(this.getId()!=null && parametrofuncionalLocal.getId()!=null) {
					if(this.getId().equals(parametrofuncionalLocal.getId())) {
						equal=true;
					}
				}
			}
		}
		
		return equal;
	}
	
	public String toString() {
		String sDetalle="";
		
		if(!ParametroFuncionalConstantesFunciones.CON_DESCRIPCION_DETALLADO) {
        	sDetalle=ParametroFuncionalConstantesFunciones.getParametroFuncionalDescripcion(this);
		} else {
			sDetalle=ParametroFuncionalConstantesFunciones.getParametroFuncionalDescripcionDetallado(this);
		}
		
		return sDetalle;
    }
	
	public ParametroFuncional getParametroFuncionalOriginal() {
		return this.parametrofuncionalOriginal;
	}
	
	public void setParametroFuncionalOriginal(ParametroFuncional parametrofuncional) {
		try {
			this.parametrofuncionalOriginal=parametrofuncional;
		} catch(Exception e) {
			;
		}
	}
	
	
	protected ParametroFuncionalAdditional parametrofuncionalAdditional=null;
	
	public ParametroFuncionalAdditional getParametroFuncionalAdditional() {
		return this.parametrofuncionalAdditional;
	}
	
	public void setParametroFuncionalAdditional(ParametroFuncionalAdditional parametrofuncionalAdditional) {
		try {
			this.parametrofuncionalAdditional=parametrofuncionalAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
    
	
	public Boolean getcon_copia_clientes() {
		return this.con_copia_clientes;
	}
    
	
	public Boolean getcon_copia_proveedor() {
		return this.con_copia_proveedor;
	}
    
	
	public Boolean getcon_proveedor_cliente() {
		return this.con_proveedor_cliente;
	}
	
    
	public void setcon_copia_clientes(Boolean newcon_copia_clientes)throws Exception
	{
		try {
			if(this.con_copia_clientes!=newcon_copia_clientes) {
				if(newcon_copia_clientes==null) {
					//newcon_copia_clientes=false;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ParametroFuncional:Valor nulo no permitido en columna con_copia_clientes");
					}
				}

				this.con_copia_clientes=newcon_copia_clientes;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setcon_copia_proveedor(Boolean newcon_copia_proveedor)throws Exception
	{
		try {
			if(this.con_copia_proveedor!=newcon_copia_proveedor) {
				if(newcon_copia_proveedor==null) {
					//newcon_copia_proveedor=false;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ParametroFuncional:Valor nulo no permitido en columna con_copia_proveedor");
					}
				}

				this.con_copia_proveedor=newcon_copia_proveedor;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setcon_proveedor_cliente(Boolean newcon_proveedor_cliente)throws Exception
	{
		try {
			if(this.con_proveedor_cliente!=newcon_proveedor_cliente) {
				if(newcon_proveedor_cliente==null) {
					//newcon_proveedor_cliente=false;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ParametroFuncional:Valor nulo no permitido en columna con_proveedor_cliente");
					}
				}

				this.con_proveedor_cliente=newcon_proveedor_cliente;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	/*PARA REPORTES*/
	String con_copia_clientes_descripcion="";String con_copia_proveedor_descripcion="";String con_proveedor_cliente_descripcion="";
	
	
	public String getcon_copia_clientes_descripcion() {
		return con_copia_clientes_descripcion;
	}
	public String getcon_copia_proveedor_descripcion() {
		return con_copia_proveedor_descripcion;
	}
	public String getcon_proveedor_cliente_descripcion() {
		return con_proveedor_cliente_descripcion;
	}
	
	
	public void setcon_copia_clientes_descripcion(String newcon_copia_clientes_descripcion)throws Exception {
		try {
			this.con_copia_clientes_descripcion=newcon_copia_clientes_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setcon_copia_proveedor_descripcion(String newcon_copia_proveedor_descripcion)throws Exception {
		try {
			this.con_copia_proveedor_descripcion=newcon_copia_proveedor_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setcon_proveedor_cliente_descripcion(String newcon_proveedor_cliente_descripcion)throws Exception {
		try {
			this.con_proveedor_cliente_descripcion=newcon_proveedor_cliente_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	
	public void inicializarVariablesParaReporte() {
		this.con_copia_clientes_descripcion="";this.con_copia_proveedor_descripcion="";this.con_proveedor_cliente_descripcion="";
	}
	
	
	
	
	
	
	/*PARA REPORTES FIN*/		
}

