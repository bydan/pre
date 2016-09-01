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
package com.bydan.erp.sris.business.entity;

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
//import com.bydan.erp.sris.util.PeriodoDeclaraConstantesFunciones;
import com.bydan.erp.sris.util.*;


import com.bydan.erp.seguridad.util.*;



import com.bydan.erp.seguridad.business.entity.*;




@SuppressWarnings("unused")
public class PeriodoDeclara extends PeriodoDeclaraAdditional implements Serializable ,Cloneable {//PeriodoDeclaraAdditional,GeneralEntity
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
	
	private PeriodoDeclara periododeclaraOriginal;
	
	private Map<String, Object> mapPeriodoDeclara;
			
	public Map<String, Object> getMapPeriodoDeclara() {
		return mapPeriodoDeclara;
	}

	public void setMapPeriodoDeclara(Map<String, Object> mapPeriodoDeclara) {
		this.mapPeriodoDeclara = mapPeriodoDeclara;
	}
	
	public void inicializarMapPeriodoDeclara() {
		this.mapPeriodoDeclara = new HashMap<String,Object>();
	}
	
	public void setMapPeriodoDeclaraValue(String sKey,Object oValue) {
		this.mapPeriodoDeclara.put(sKey, oValue);
	}
	
	public Object getMapPeriodoDeclaraValue(String sKey) {
		return this.mapPeriodoDeclara.get(sKey);
	}
	
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=20,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=PeriodoDeclaraConstantesFunciones.SREGEXCODIGO,message=PeriodoDeclaraConstantesFunciones.SMENSAJEREGEXCODIGO)
	private String codigo;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_anio;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_mes;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Date fecha;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Boolean esta_activo;
			
	
	public Anio anio;
	public Mes mes;
	
	
	private String anio_descripcion;
	private String mes_descripcion;
	
	
	public List<TransaccionLocal> transaccionlocals;
	public List<RetencionVenta> retencionventas;
	public List<FacturaDiario> facturadiarios;
	public List<DocumentoAnulado> documentoanulados;
		
	public PeriodoDeclara () throws Exception {
		super();		
		
		this.id=0L;
		
		
		this.versionRow=new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());//new Date();
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		this.sType="NONE";
		
		this.periododeclaraOriginal=this;
		
 		this.codigo="";
 		this.id_anio=-1L;
 		this.id_mes=-1L;
 		this.fecha=new Date();
 		this.esta_activo=false;
		
		
		this.anio=null;
		this.mes=null;
		
		
		this.anio_descripcion="";
		this.mes_descripcion="";
		
		
		this.transaccionlocals=null;
		this.retencionventas=null;
		this.facturadiarios=null;
		this.documentoanulados=null;
		
			
		
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
    //PARA REPORTES
	public PeriodoDeclara (Long id,Date versionRow,String codigo,Long id_anio,Long id_mes,Date fecha,Boolean esta_activo) throws Exception {
		super();		
		
		this.id=id;
		this.versionRow=versionRow;
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.periododeclaraOriginal=this;
		
 		this.codigo=codigo;
 		this.id_anio=id_anio;
 		this.id_mes=id_mes;
 		this.fecha=fecha;
 		this.esta_activo=esta_activo;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	 //PARA REPORTES
	public PeriodoDeclara (String codigo,Long id_anio,Long id_mes,Date fecha,Boolean esta_activo) throws Exception {
		super();		
		
		this.id=0L;
		this.versionRow=new Date();
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.periododeclaraOriginal=this;
		
 		this.codigo=codigo;
 		this.id_anio=id_anio;
 		this.id_mes=id_mes;
 		this.fecha=fecha;
 		this.esta_activo=esta_activo;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	public boolean equals(Object object) {
		boolean equal=false;
		PeriodoDeclara periododeclaraLocal=null;
		
		if(object!=null) {
			periododeclaraLocal=(PeriodoDeclara)object;
			
			if(periododeclaraLocal!=null) {
				if(this.getId()!=null && periododeclaraLocal.getId()!=null) {
					if(this.getId().equals(periododeclaraLocal.getId())) {
						equal=true;
					}
				}
			}
		}
		
		return equal;
	}
	
	public String toString() {
		String sDetalle="";
		
		if(!PeriodoDeclaraConstantesFunciones.CON_DESCRIPCION_DETALLADO) {
        	sDetalle=PeriodoDeclaraConstantesFunciones.getPeriodoDeclaraDescripcion(this);
		} else {
			sDetalle=PeriodoDeclaraConstantesFunciones.getPeriodoDeclaraDescripcionDetallado(this);
		}
		
		return sDetalle;
    }
	
	public PeriodoDeclara getPeriodoDeclaraOriginal() {
		return this.periododeclaraOriginal;
	}
	
	public void setPeriodoDeclaraOriginal(PeriodoDeclara periododeclara) {
		try {
			this.periododeclaraOriginal=periododeclara;
		} catch(Exception e) {
			;
		}
	}
	
	
	protected PeriodoDeclaraAdditional periododeclaraAdditional=null;
	
	public PeriodoDeclaraAdditional getPeriodoDeclaraAdditional() {
		return this.periododeclaraAdditional;
	}
	
	public void setPeriodoDeclaraAdditional(PeriodoDeclaraAdditional periododeclaraAdditional) {
		try {
			this.periododeclaraAdditional=periododeclaraAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
    
	
	public String getcodigo() {
		return this.codigo;
	}
    
	
	public Long getid_anio() {
		return this.id_anio;
	}
    
	
	public Long getid_mes() {
		return this.id_mes;
	}
    
	
	public Date getfecha() {
		return this.fecha;
	}
    
	
	public Boolean getesta_activo() {
		return this.esta_activo;
	}
	
    
	public void setcodigo(String newcodigo)throws Exception
	{
		try {
			if(this.codigo!=newcodigo) {
				if(newcodigo==null) {
					//newcodigo="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("PeriodoDeclara:Valor nulo no permitido en columna codigo");
					}
				}

				if(newcodigo!=null&&newcodigo.length()>20) {
					newcodigo=newcodigo.substring(0,18);
					System.out.println("PeriodoDeclara:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=20 en columna codigo");
				}

				this.codigo=newcodigo;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_anio(Long newid_anio)throws Exception
	{
		try {
			if(this.id_anio!=newid_anio) {
				if(newid_anio==null) {
					//newid_anio=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("PeriodoDeclara:Valor nulo no permitido en columna id_anio");
					}
				}

				this.id_anio=newid_anio;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_mes(Long newid_mes)throws Exception
	{
		try {
			if(this.id_mes!=newid_mes) {
				if(newid_mes==null) {
					//newid_mes=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("PeriodoDeclara:Valor nulo no permitido en columna id_mes");
					}
				}

				this.id_mes=newid_mes;
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
						System.out.println("PeriodoDeclara:Valor nulo no permitido en columna fecha");
					}
				}

				this.fecha=newfecha;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setesta_activo(Boolean newesta_activo)throws Exception
	{
		try {
			if(this.esta_activo!=newesta_activo) {
				if(newesta_activo==null) {
					//newesta_activo=false;
					if(Constantes.ISDEVELOPING) {
						System.out.println("PeriodoDeclara:Valor nulo no permitido en columna esta_activo");
					}
				}

				this.esta_activo=newesta_activo;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	
	public Anio getAnio() {
		return this.anio;
	}

	public Mes getMes() {
		return this.mes;
	}

	
	
	public String getanio_descripcion() {
		return this.anio_descripcion;
	}

	public String getmes_descripcion() {
		return this.mes_descripcion;
	}

	
	
	public  void  setAnio(Anio anio) {
		try {
			this.anio=anio;
		} catch(Exception e) {
			;
		}
	}


	public  void  setMes(Mes mes) {
		try {
			this.mes=mes;
		} catch(Exception e) {
			;
		}
	}


	
	
	public  void  setanio_descripcion(String anio_descripcion) {
		try {
			this.anio_descripcion=anio_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  setmes_descripcion(String mes_descripcion) {
		try {
			this.mes_descripcion=mes_descripcion;
		} catch(Exception e) {
			;
		}
	}


	
	
	public List<TransaccionLocal> getTransaccionLocals() {
		return this.transaccionlocals;
	}

	public List<RetencionVenta> getRetencionVentas() {
		return this.retencionventas;
	}

	public List<FacturaDiario> getFacturaDiarios() {
		return this.facturadiarios;
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

	public  void  setRetencionVentas(List<RetencionVenta> retencionventas) {
		try {
			this.retencionventas=retencionventas;
		} catch(Exception e) {
			;
		}
	}

	public  void  setFacturaDiarios(List<FacturaDiario> facturadiarios) {
		try {
			this.facturadiarios=facturadiarios;
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
	String id_anio_descripcion="";String id_mes_descripcion="";String esta_activo_descripcion="";
	
	
	public String getid_anio_descripcion() {
		return id_anio_descripcion;
	}
	public String getid_mes_descripcion() {
		return id_mes_descripcion;
	}
	public String getesta_activo_descripcion() {
		return esta_activo_descripcion;
	}
	
	
	public void setid_anio_descripcion(String newid_anio_descripcion)throws Exception {
		try {
			this.id_anio_descripcion=newid_anio_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_mes_descripcion(String newid_mes_descripcion)throws Exception {
		try {
			this.id_mes_descripcion=newid_mes_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setesta_activo_descripcion(String newesta_activo_descripcion)throws Exception {
		try {
			this.esta_activo_descripcion=newesta_activo_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	
	public void inicializarVariablesParaReporte() {
		this.id_anio_descripcion="";this.id_mes_descripcion="";this.esta_activo_descripcion="";
	}
	
	
	Object transaccionlocalsDescripcionReporte;
	Object retencionventasDescripcionReporte;
	Object facturadiariosDescripcionReporte;
	Object documentoanuladosDescripcionReporte;
	
	
	public Object gettransaccionlocalsDescripcionReporte() {
		return transaccionlocalsDescripcionReporte;
	}

	public Object getretencionventasDescripcionReporte() {
		return retencionventasDescripcionReporte;
	}

	public Object getfacturadiariosDescripcionReporte() {
		return facturadiariosDescripcionReporte;
	}

	public Object getdocumentoanuladosDescripcionReporte() {
		return documentoanuladosDescripcionReporte;
	}

	
	
	public  void  settransaccionlocalsDescripcionReporte(Object transaccionlocals) {
		try {
			this.transaccionlocalsDescripcionReporte=transaccionlocals;
		} catch(Exception ex) {
			;
		}
	}

	public  void  setretencionventasDescripcionReporte(Object retencionventas) {
		try {
			this.retencionventasDescripcionReporte=retencionventas;
		} catch(Exception ex) {
			;
		}
	}

	public  void  setfacturadiariosDescripcionReporte(Object facturadiarios) {
		try {
			this.facturadiariosDescripcionReporte=facturadiarios;
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

