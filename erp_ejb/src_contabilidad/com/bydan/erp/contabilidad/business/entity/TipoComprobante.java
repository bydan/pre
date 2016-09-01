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
package com.bydan.erp.contabilidad.business.entity;

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
//import com.bydan.erp.contabilidad.util.TipoComprobanteConstantesFunciones;
import com.bydan.erp.contabilidad.util.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.sris.util.*;
import com.bydan.erp.tesoreria.util.*;
import com.bydan.erp.cartera.util.*;
import com.bydan.erp.contabilidad.util.*;
import com.bydan.erp.facturacion.util.*;
import com.bydan.erp.produccion.util.*;
import com.bydan.erp.inventario.util.*;
import com.bydan.erp.nomina.util.*;
import com.bydan.erp.importaciones.util.*;
import com.bydan.erp.puntoventa.util.*;



import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.sris.business.entity.*;
import com.bydan.erp.tesoreria.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.facturacion.business.entity.*;
import com.bydan.erp.produccion.business.entity.*;
import com.bydan.erp.inventario.business.entity.*;
import com.bydan.erp.nomina.business.entity.*;
import com.bydan.erp.importaciones.business.entity.*;
import com.bydan.erp.puntoventa.business.entity.*;




@SuppressWarnings("unused")
public class TipoComprobante extends GeneralEntity implements Serializable ,Cloneable {//TipoComprobanteAdditional,GeneralEntity
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
	
	private TipoComprobante tipocomprobanteOriginal;
	
	private Map<String, Object> mapTipoComprobante;
			
	public Map<String, Object> getMapTipoComprobante() {
		return mapTipoComprobante;
	}

	public void setMapTipoComprobante(Map<String, Object> mapTipoComprobante) {
		this.mapTipoComprobante = mapTipoComprobante;
	}
	
	public void inicializarMapTipoComprobante() {
		this.mapTipoComprobante = new HashMap<String,Object>();
	}
	
	public void setMapTipoComprobanteValue(String sKey,Object oValue) {
		this.mapTipoComprobante.put(sKey, oValue);
	}
	
	public Object getMapTipoComprobanteValue(String sKey) {
		return this.mapTipoComprobante.get(sKey);
	}
	
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_empresa;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=100,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=TipoComprobanteConstantesFunciones.SREGEXNOMBRE,message=TipoComprobanteConstantesFunciones.SMENSAJEREGEXNOMBRE)
	private String nombre;
			
	
	public Empresa empresa;
	
	
	private String empresa_descripcion;
	
	
	public List<TransaccionLocal> transaccionlocals;
	public List<Transaccion> transaccions;
	public List<DocumentoAnulado> documentoanulados;
		
	public TipoComprobante () throws Exception {
		super();		
		
		this.id=0L;
		
		
		this.versionRow=new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());//new Date();
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		this.sType="NONE";
		
		this.tipocomprobanteOriginal=this;
		
 		this.id_empresa=-1L;
 		this.nombre="";
		
		
		this.empresa=null;
		
		
		this.empresa_descripcion="";
		
		
		this.transaccionlocals=null;
		this.transaccions=null;
		this.documentoanulados=null;
		
			
		
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
    //PARA REPORTES
	public TipoComprobante (Long id,Date versionRow,Long id_empresa,String nombre) throws Exception {
		super();		
		
		this.id=id;
		this.versionRow=versionRow;
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.tipocomprobanteOriginal=this;
		
 		this.id_empresa=id_empresa;
 		this.nombre=nombre;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	 //PARA REPORTES
	public TipoComprobante (Long id_empresa,String nombre) throws Exception {
		super();		
		
		this.id=0L;
		this.versionRow=new Date();
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.tipocomprobanteOriginal=this;
		
 		this.id_empresa=id_empresa;
 		this.nombre=nombre;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	public boolean equals(Object object) {
		boolean equal=false;
		TipoComprobante tipocomprobanteLocal=null;
		
		if(object!=null) {
			tipocomprobanteLocal=(TipoComprobante)object;
			
			if(tipocomprobanteLocal!=null) {
				if(this.getId()!=null && tipocomprobanteLocal.getId()!=null) {
					if(this.getId().equals(tipocomprobanteLocal.getId())) {
						equal=true;
					}
				}
			}
		}
		
		return equal;
	}
	
	public String toString() {
		String sDetalle="";
		
		if(!TipoComprobanteConstantesFunciones.CON_DESCRIPCION_DETALLADO) {
        	sDetalle=TipoComprobanteConstantesFunciones.getTipoComprobanteDescripcion(this);
		} else {
			sDetalle=TipoComprobanteConstantesFunciones.getTipoComprobanteDescripcionDetallado(this);
		}
		
		return sDetalle;
    }
	
	public TipoComprobante getTipoComprobanteOriginal() {
		return this.tipocomprobanteOriginal;
	}
	
	public void setTipoComprobanteOriginal(TipoComprobante tipocomprobante) {
		try {
			this.tipocomprobanteOriginal=tipocomprobante;
		} catch(Exception e) {
			;
		}
	}
	
	
    
	
	public Long getid_empresa() {
		return this.id_empresa;
	}
    
	
	public String getnombre() {
		return this.nombre;
	}
	
    
	public void setid_empresa(Long newid_empresa)throws Exception
	{
		try {
			if(this.id_empresa!=newid_empresa) {
				if(newid_empresa==null) {
					//newid_empresa=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("TipoComprobante:Valor nulo no permitido en columna id_empresa");
					}
				}

				this.id_empresa=newid_empresa;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setnombre(String newnombre)throws Exception
	{
		try {
			if(this.nombre!=newnombre) {
				if(newnombre==null) {
					//newnombre="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("TipoComprobante:Valor nulo no permitido en columna nombre");
					}
				}

				if(newnombre!=null&&newnombre.length()>100) {
					newnombre=newnombre.substring(0,98);
					System.out.println("TipoComprobante:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=100 en columna nombre");
				}

				this.nombre=newnombre;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	
	public Empresa getEmpresa() {
		return this.empresa;
	}

	
	
	public String getempresa_descripcion() {
		return this.empresa_descripcion;
	}

	
	
	public  void  setEmpresa(Empresa empresa) {
		try {
			this.empresa=empresa;
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


	
	
	public List<TransaccionLocal> getTransaccionLocals() {
		return this.transaccionlocals;
	}

	public List<Transaccion> getTransaccions() {
		return this.transaccions;
	}

	public List<DocumentoAnulado> getDocumentoAnulados() {
		return this.documentoanulados;
	}

	
	
	public  void  setTransaccionLocals(List<TransaccionLocal> transaccionlocals) {
		try {
			this.transaccionlocals=transaccionlocals;
		} catch(Exception e) {
			;
		}
	}

	public  void  setTransaccions(List<Transaccion> transaccions) {
		try {
			this.transaccions=transaccions;
		} catch(Exception e) {
			;
		}
	}

	public  void  setDocumentoAnulados(List<DocumentoAnulado> documentoanulados) {
		try {
			this.documentoanulados=documentoanulados;
		} catch(Exception e) {
			;
		}
	}

	
	/*PARA REPORTES*/
	String id_empresa_descripcion="";
	
	
	public String getid_empresa_descripcion() {
		return id_empresa_descripcion;
	}
	
	
	public void setid_empresa_descripcion(String newid_empresa_descripcion)throws Exception {
		try {
			this.id_empresa_descripcion=newid_empresa_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	
	public void inicializarVariablesParaReporte() {
		this.id_empresa_descripcion="";
	}
	
	
	Object srisDescripcionReporte;
	Object importarexportarsDescripcionReporte;
	Object transaccionlocalsDescripcionReporte;
	Object transaccionsDescripcionReporte;
	Object documentoanuladosDescripcionReporte;
	
	
	public Object getsrisDescripcionReporte() {
		return srisDescripcionReporte;
	}

	public Object getimportarexportarsDescripcionReporte() {
		return importarexportarsDescripcionReporte;
	}

	public Object gettransaccionlocalsDescripcionReporte() {
		return transaccionlocalsDescripcionReporte;
	}

	public Object gettransaccionsDescripcionReporte() {
		return transaccionsDescripcionReporte;
	}

	public Object getdocumentoanuladosDescripcionReporte() {
		return documentoanuladosDescripcionReporte;
	}

	
	
	public  void  setsrisDescripcionReporte(Object sris) {
		try {
			this.srisDescripcionReporte=sris;
		} catch(Exception ex) {
			;
		}
	}

	public  void  setimportarexportarsDescripcionReporte(Object importarexportars) {
		try {
			this.importarexportarsDescripcionReporte=importarexportars;
		} catch(Exception ex) {
			;
		}
	}

	public  void  settransaccionlocalsDescripcionReporte(Object transaccionlocals) {
		try {
			this.transaccionlocalsDescripcionReporte=transaccionlocals;
		} catch(Exception ex) {
			;
		}
	}

	public  void  settransaccionsDescripcionReporte(Object transaccions) {
		try {
			this.transaccionsDescripcionReporte=transaccions;
		} catch(Exception ex) {
			;
		}
	}

	public  void  setdocumentoanuladosDescripcionReporte(Object documentoanulados) {
		try {
			this.documentoanuladosDescripcionReporte=documentoanulados;
		} catch(Exception ex) {
			;
		}
	}

	/*PARA REPORTES FIN*/		
}
