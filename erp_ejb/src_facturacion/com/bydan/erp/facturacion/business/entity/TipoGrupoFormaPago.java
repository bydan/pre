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
package com.bydan.erp.facturacion.business.entity;

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
//import com.bydan.erp.facturacion.util.TipoGrupoFormaPagoConstantesFunciones;
import com.bydan.erp.facturacion.util.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.contabilidad.util.*;
import com.bydan.erp.tesoreria.util.*;
import com.bydan.erp.puntoventa.util.*;
import com.bydan.erp.facturacion.util.*;
import com.bydan.erp.inventario.util.*;
import com.bydan.erp.nomina.util.*;



import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.tesoreria.business.entity.*;
import com.bydan.erp.puntoventa.business.entity.*;
import com.bydan.erp.facturacion.business.entity.*;
import com.bydan.erp.inventario.business.entity.*;
import com.bydan.erp.nomina.business.entity.*;




@SuppressWarnings("unused")
public class TipoGrupoFormaPago extends TipoGrupoFormaPagoAdditional implements Serializable ,Cloneable {//TipoGrupoFormaPagoAdditional,GeneralEntity
	private static final long serialVersionUID=1L;
	
	public Object clone() {
        return super.clone();
    }
	
	protected Long id;
	protected Long idOriginal;
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
	
	public Long getIdOriginal() {
		return this.idOriginal;
	}
	
	public void setIdOriginal(Long newIdOriginal) {		
		this.idOriginal=newIdOriginal;
		super.setIdOriginal(newIdOriginal);
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
	
	private TipoGrupoFormaPago tipogrupoformapagoOriginal;
	
	private Map<String, Object> mapTipoGrupoFormaPago;
			
	public Map<String, Object> getMapTipoGrupoFormaPago() {
		return mapTipoGrupoFormaPago;
	}

	public void setMapTipoGrupoFormaPago(Map<String, Object> mapTipoGrupoFormaPago) {
		this.mapTipoGrupoFormaPago = mapTipoGrupoFormaPago;
	}
	
	public void inicializarMapTipoGrupoFormaPago() {
		this.mapTipoGrupoFormaPago = new HashMap<String,Object>();
	}
	
	public void setMapTipoGrupoFormaPagoValue(String sKey,Object oValue) {
		this.mapTipoGrupoFormaPago.put(sKey, oValue);
	}
	
	public Object getMapTipoGrupoFormaPagoValue(String sKey) {
		return this.mapTipoGrupoFormaPago.get(sKey);
	}
	
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=150,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=TipoGrupoFormaPagoConstantesFunciones.SREGEXNOMBRE,message=TipoGrupoFormaPagoConstantesFunciones.SMENSAJEREGEXNOMBRE)
	private String nombre;
			
	
	
	
	
	
	public List<TipoFormaPago> tipoformapagos;
	public List<DatoGeneralEmpleado> datogeneralempleados;
	public List<AnticipoCliente> anticipoclientes;
		
	public TipoGrupoFormaPago () throws Exception {
		super();		
		
		this.id=0L;
		this.idOriginal=0L;
		
		
		this.versionRow=new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());//new Date();
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		this.sType="NONE";
		
		this.tipogrupoformapagoOriginal=this;
		
 		this.nombre="";
		
		
		
		
		
		
		this.tipoformapagos=null;
		this.datogeneralempleados=null;
		this.anticipoclientes=null;
		
			
		
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
    //PARA REPORTES
	public TipoGrupoFormaPago (Long id,Date versionRow,String nombre) throws Exception {
		super();		
		
		this.id=id;
		this.idOriginal=this.id;
		this.versionRow=versionRow;
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.tipogrupoformapagoOriginal=this;
		
 		this.nombre=nombre;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	 //PARA REPORTES
	public TipoGrupoFormaPago (String nombre) throws Exception {
		super();		
		
		this.id=0L;
		this.idOriginal=0L;
		this.versionRow=new Date();
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.tipogrupoformapagoOriginal=this;
		
 		this.nombre=nombre;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	public boolean equals(Object object) {
		boolean equal=false;
		TipoGrupoFormaPago tipogrupoformapagoLocal=null;
		
		if(object!=null) {
			tipogrupoformapagoLocal=(TipoGrupoFormaPago)object;
			
			if(tipogrupoformapagoLocal!=null) {
				if(this.getId()!=null && tipogrupoformapagoLocal.getId()!=null) {
					if(this.getId().equals(tipogrupoformapagoLocal.getId())) {
						equal=true;
					}
				}
			}
		}
		
		return equal;
	}
	
	public String toString() {
		String sDetalle="";
		
		if(!TipoGrupoFormaPagoConstantesFunciones.CON_DESCRIPCION_DETALLADO) {
        	sDetalle=TipoGrupoFormaPagoConstantesFunciones.getTipoGrupoFormaPagoDescripcion(this);
		} else {
			sDetalle=TipoGrupoFormaPagoConstantesFunciones.getTipoGrupoFormaPagoDescripcionDetallado(this);
		}
		
		return sDetalle;
    }
	
	public TipoGrupoFormaPago getTipoGrupoFormaPagoOriginal() {
		return this.tipogrupoformapagoOriginal;
	}
	
	public void setTipoGrupoFormaPagoOriginal(TipoGrupoFormaPago tipogrupoformapago) {
		try {
			this.tipogrupoformapagoOriginal=tipogrupoformapago;
		} catch(Exception e) {
			;
		}
	}
	
	
	protected TipoGrupoFormaPagoAdditional tipogrupoformapagoAdditional=null;
	
	public TipoGrupoFormaPagoAdditional getTipoGrupoFormaPagoAdditional() {
		return this.tipogrupoformapagoAdditional;
	}
	
	public void setTipoGrupoFormaPagoAdditional(TipoGrupoFormaPagoAdditional tipogrupoformapagoAdditional) {
		try {
			this.tipogrupoformapagoAdditional=tipogrupoformapagoAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
    
	
	public String getnombre() {
		return this.nombre;
	}
	
    
	public void setnombre(String newnombre)throws Exception
	{
		try {
			if(this.nombre!=newnombre) {
				if(newnombre==null) {
					//newnombre="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("TipoGrupoFormaPago:Valor nulo no permitido en columna nombre");
					}
				}

				if(newnombre!=null&&newnombre.length()>150) {
					newnombre=newnombre.substring(0,148);
					System.out.println("TipoGrupoFormaPago:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=150 en columna nombre");
				}

				this.nombre=newnombre;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
	
	public List<TipoFormaPago> getTipoFormaPagos() {
		return this.tipoformapagos;
	}

	public List<DatoGeneralEmpleado> getDatoGeneralEmpleados() {
		return this.datogeneralempleados;
	}

	public List<AnticipoCliente> getAnticipoClientes() {
		return this.anticipoclientes;
	}

	
	
	public  void  setTipoFormaPagos(List<TipoFormaPago> tipoformapagos) {
		try {
			this.tipoformapagos=tipoformapagos;
		} catch(Exception e) {
			;
		}
	}

	public  void  setDatoGeneralEmpleados(List<DatoGeneralEmpleado> datogeneralempleados) {
		try {
			this.datogeneralempleados=datogeneralempleados;
		} catch(Exception e) {
			;
		}
	}

	public  void  setAnticipoClientes(List<AnticipoCliente> anticipoclientes) {
		try {
			this.anticipoclientes=anticipoclientes;
		} catch(Exception e) {
			;
		}
	}

	
	/*PARA REPORTES*/
	
	
	
	
	
	
	public void inicializarVariablesParaReporte() {
		
	}
	
	
	Object tipoformapagosDescripcionReporte;
	Object datogeneralempleadosDescripcionReporte;
	Object anticipoclientesDescripcionReporte;
	
	
	public Object gettipoformapagosDescripcionReporte() {
		return tipoformapagosDescripcionReporte;
	}

	public Object getdatogeneralempleadosDescripcionReporte() {
		return datogeneralempleadosDescripcionReporte;
	}

	public Object getanticipoclientesDescripcionReporte() {
		return anticipoclientesDescripcionReporte;
	}

	
	
	public  void  settipoformapagosDescripcionReporte(Object tipoformapagos) {
		try {
			this.tipoformapagosDescripcionReporte=tipoformapagos;
		} catch(Exception ex) {
			;
		}
	}

	public  void  setdatogeneralempleadosDescripcionReporte(Object datogeneralempleados) {
		try {
			this.datogeneralempleadosDescripcionReporte=datogeneralempleados;
		} catch(Exception ex) {
			;
		}
	}

	public  void  setanticipoclientesDescripcionReporte(Object anticipoclientes) {
		try {
			this.anticipoclientesDescripcionReporte=anticipoclientes;
		} catch(Exception ex) {
			;
		}
	}

	/*PARA REPORTES FIN*/		
}

