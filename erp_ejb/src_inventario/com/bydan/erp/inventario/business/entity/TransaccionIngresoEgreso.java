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
package com.bydan.erp.inventario.business.entity;

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
//import com.bydan.erp.inventario.util.TransaccionIngresoEgresoConstantesFunciones;
import com.bydan.erp.inventario.util.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.tesoreria.util.*;



import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.tesoreria.business.entity.*;




@SuppressWarnings("unused")
public class TransaccionIngresoEgreso extends TransaccionIngresoEgresoAdditional implements Serializable ,Cloneable {//TransaccionIngresoEgresoAdditional,GeneralEntity
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
	
	private TransaccionIngresoEgreso transaccioningresoegresoOriginal;
	
	private Map<String, Object> mapTransaccionIngresoEgreso;
			
	public Map<String, Object> getMapTransaccionIngresoEgreso() {
		return mapTransaccionIngresoEgreso;
	}

	public void setMapTransaccionIngresoEgreso(Map<String, Object> mapTransaccionIngresoEgreso) {
		this.mapTransaccionIngresoEgreso = mapTransaccionIngresoEgreso;
	}
	
	public void inicializarMapTransaccionIngresoEgreso() {
		this.mapTransaccionIngresoEgreso = new HashMap<String,Object>();
	}
	
	public void setMapTransaccionIngresoEgresoValue(String sKey,Object oValue) {
		this.mapTransaccionIngresoEgreso.put(sKey, oValue);
	}
	
	public Object getMapTransaccionIngresoEgresoValue(String sKey) {
		return this.mapTransaccionIngresoEgreso.get(sKey);
	}
	
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_empresa;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_modulo;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_transaccion;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Boolean es_ingreso;
			
	
	public Empresa empresa;
	public Modulo modulo;
	public Transaccion transaccion;
	
	
	private String empresa_descripcion;
	private String modulo_descripcion;
	private String transaccion_descripcion;
	
	
		
	public TransaccionIngresoEgreso () throws Exception {
		super();		
		
		this.id=0L;
		
		
		this.versionRow=new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());//new Date();
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		this.sType="NONE";
		
		this.transaccioningresoegresoOriginal=this;
		
 		this.id_empresa=-1L;
 		this.id_modulo=-1L;
 		this.id_transaccion=-1L;
 		this.es_ingreso=false;
		
		
		this.empresa=null;
		this.modulo=null;
		this.transaccion=null;
		
		
		this.empresa_descripcion="";
		this.modulo_descripcion="";
		this.transaccion_descripcion="";
		
		
		
			
		
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
    //PARA REPORTES
	public TransaccionIngresoEgreso (Long id,Date versionRow,Long id_empresa,Long id_modulo,Long id_transaccion,Boolean es_ingreso) throws Exception {
		super();		
		
		this.id=id;
		this.versionRow=versionRow;
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.transaccioningresoegresoOriginal=this;
		
 		this.id_empresa=id_empresa;
 		this.id_modulo=id_modulo;
 		this.id_transaccion=id_transaccion;
 		this.es_ingreso=es_ingreso;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	 //PARA REPORTES
	public TransaccionIngresoEgreso (Long id_empresa,Long id_modulo,Long id_transaccion,Boolean es_ingreso) throws Exception {
		super();		
		
		this.id=0L;
		this.versionRow=new Date();
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.transaccioningresoegresoOriginal=this;
		
 		this.id_empresa=id_empresa;
 		this.id_modulo=id_modulo;
 		this.id_transaccion=id_transaccion;
 		this.es_ingreso=es_ingreso;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	public boolean equals(Object object) {
		boolean equal=false;
		TransaccionIngresoEgreso transaccioningresoegresoLocal=null;
		
		if(object!=null) {
			transaccioningresoegresoLocal=(TransaccionIngresoEgreso)object;
			
			if(transaccioningresoegresoLocal!=null) {
				if(this.getId()!=null && transaccioningresoegresoLocal.getId()!=null) {
					if(this.getId().equals(transaccioningresoegresoLocal.getId())) {
						equal=true;
					}
				}
			}
		}
		
		return equal;
	}
	
	public String toString() {
		String sDetalle="";
		
		if(!TransaccionIngresoEgresoConstantesFunciones.CON_DESCRIPCION_DETALLADO) {
        	sDetalle=TransaccionIngresoEgresoConstantesFunciones.getTransaccionIngresoEgresoDescripcion(this);
		} else {
			sDetalle=TransaccionIngresoEgresoConstantesFunciones.getTransaccionIngresoEgresoDescripcionDetallado(this);
		}
		
		return sDetalle;
    }
	
	public TransaccionIngresoEgreso getTransaccionIngresoEgresoOriginal() {
		return this.transaccioningresoegresoOriginal;
	}
	
	public void setTransaccionIngresoEgresoOriginal(TransaccionIngresoEgreso transaccioningresoegreso) {
		try {
			this.transaccioningresoegresoOriginal=transaccioningresoegreso;
		} catch(Exception e) {
			;
		}
	}
	
	
	protected TransaccionIngresoEgresoAdditional transaccioningresoegresoAdditional=null;
	
	public TransaccionIngresoEgresoAdditional getTransaccionIngresoEgresoAdditional() {
		return this.transaccioningresoegresoAdditional;
	}
	
	public void setTransaccionIngresoEgresoAdditional(TransaccionIngresoEgresoAdditional transaccioningresoegresoAdditional) {
		try {
			this.transaccioningresoegresoAdditional=transaccioningresoegresoAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
    
	
	public Long getid_empresa() {
		return this.id_empresa;
	}
    
	
	public Long getid_modulo() {
		return this.id_modulo;
	}
    
	
	public Long getid_transaccion() {
		return this.id_transaccion;
	}
    
	
	public Boolean getes_ingreso() {
		return this.es_ingreso;
	}
	
    
	public void setid_empresa(Long newid_empresa)throws Exception
	{
		try {
			if(this.id_empresa!=newid_empresa) {
				if(newid_empresa==null) {
					//newid_empresa=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("TransaccionIngresoEgreso:Valor nulo no permitido en columna id_empresa");
					}
				}

				this.id_empresa=newid_empresa;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_modulo(Long newid_modulo)throws Exception
	{
		try {
			if(this.id_modulo!=newid_modulo) {
				if(newid_modulo==null) {
					//newid_modulo=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("TransaccionIngresoEgreso:Valor nulo no permitido en columna id_modulo");
					}
				}

				this.id_modulo=newid_modulo;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_transaccion(Long newid_transaccion)throws Exception
	{
		try {
			if(this.id_transaccion!=newid_transaccion) {
				if(newid_transaccion==null) {
					//newid_transaccion=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("TransaccionIngresoEgreso:Valor nulo no permitido en columna id_transaccion");
					}
				}

				this.id_transaccion=newid_transaccion;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setes_ingreso(Boolean newes_ingreso)throws Exception
	{
		try {
			if(this.es_ingreso!=newes_ingreso) {
				if(newes_ingreso==null) {
					//newes_ingreso=false;
					if(Constantes.ISDEVELOPING) {
						System.out.println("TransaccionIngresoEgreso:Valor nulo no permitido en columna es_ingreso");
					}
				}

				this.es_ingreso=newes_ingreso;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	
	public Empresa getEmpresa() {
		return this.empresa;
	}

	public Modulo getModulo() {
		return this.modulo;
	}

	public Transaccion getTransaccion() {
		return this.transaccion;
	}

	
	
	public String getempresa_descripcion() {
		return this.empresa_descripcion;
	}

	public String getmodulo_descripcion() {
		return this.modulo_descripcion;
	}

	public String gettransaccion_descripcion() {
		return this.transaccion_descripcion;
	}

	
	
	public  void  setEmpresa(Empresa empresa) {
		try {
			this.empresa=empresa;
		} catch(Exception e) {
			;
		}
	}


	public  void  setModulo(Modulo modulo) {
		try {
			this.modulo=modulo;
		} catch(Exception e) {
			;
		}
	}


	public  void  setTransaccion(Transaccion transaccion) {
		try {
			this.transaccion=transaccion;
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


	public  void  setmodulo_descripcion(String modulo_descripcion) {
		try {
			this.modulo_descripcion=modulo_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  settransaccion_descripcion(String transaccion_descripcion) {
		try {
			this.transaccion_descripcion=transaccion_descripcion;
		} catch(Exception e) {
			;
		}
	}


	
	
	
	
	
	/*PARA REPORTES*/
	String id_empresa_descripcion="";String id_modulo_descripcion="";String id_transaccion_descripcion="";String es_ingreso_descripcion="";
	
	
	public String getid_empresa_descripcion() {
		return id_empresa_descripcion;
	}
	public String getid_modulo_descripcion() {
		return id_modulo_descripcion;
	}
	public String getid_transaccion_descripcion() {
		return id_transaccion_descripcion;
	}
	public String getes_ingreso_descripcion() {
		return es_ingreso_descripcion;
	}
	
	
	public void setid_empresa_descripcion(String newid_empresa_descripcion)throws Exception {
		try {
			this.id_empresa_descripcion=newid_empresa_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_modulo_descripcion(String newid_modulo_descripcion)throws Exception {
		try {
			this.id_modulo_descripcion=newid_modulo_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_transaccion_descripcion(String newid_transaccion_descripcion)throws Exception {
		try {
			this.id_transaccion_descripcion=newid_transaccion_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setes_ingreso_descripcion(String newes_ingreso_descripcion)throws Exception {
		try {
			this.es_ingreso_descripcion=newes_ingreso_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	
	public void inicializarVariablesParaReporte() {
		this.id_empresa_descripcion="";this.id_modulo_descripcion="";this.id_transaccion_descripcion="";this.es_ingreso_descripcion="";
	}
	
	
	
	
	
	
	/*PARA REPORTES FIN*/		
}

