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
package com.bydan.erp.nomina.business.entity.report;

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
//import com.bydan.erp.nomina.util.ProcesoIessAportesConstantesFunciones;
import com.bydan.erp.nomina.util.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.nomina.util.*;

import com.bydan.erp.nomina.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.nomina.business.entity.*;




@SuppressWarnings("unused")
public class ProcesoIessAportes extends ProcesoIessAportesAdditional implements Serializable ,Cloneable {//ProcesoIessAportesAdditional,GeneralEntity
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
	
	private ProcesoIessAportes procesoiessaportesOriginal;
	
	private Map<String, Object> mapProcesoIessAportes;
			
	public Map<String, Object> getMapProcesoIessAportes() {
		return mapProcesoIessAportes;
	}

	public void setMapProcesoIessAportes(Map<String, Object> mapProcesoIessAportes) {
		this.mapProcesoIessAportes = mapProcesoIessAportes;
	}
	
	public void inicializarMapProcesoIessAportes() {
		this.mapProcesoIessAportes = new HashMap<String,Object>();
	}
	
	public void setMapProcesoIessAportesValue(String sKey,Object oValue) {
		this.mapProcesoIessAportes.put(sKey, oValue);
	}
	
	public Object getMapProcesoIessAportesValue(String sKey) {
		return this.mapProcesoIessAportes.get(sKey);
	}
	
	
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_anio;
	
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_mes;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_tipo_afiliacion;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_numero_patronal;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double porcentaje;
			
	
	public Anio anio;
	public Mes mes;
	public TipoAfiliacion tipoafiliacion;
	public NumeroPatronal numeropatronal;
	
	
	private String anio_descripcion;
	private String mes_descripcion;
	private String tipoafiliacion_descripcion;
	private String numeropatronal_descripcion;
	
	
		
	public ProcesoIessAportes () throws Exception {
		super();		
		
		this.id=0L;
		
		
		this.versionRow=new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());//new Date();
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		this.sType="NONE";
		
		this.procesoiessaportesOriginal=this;
		
 		this.id_anio=null;
 		this.id_mes=null;
 		this.id_tipo_afiliacion=-1L;
 		this.id_numero_patronal=-1L;
 		this.porcentaje=0.0;
		
		
		this.anio=null;
		this.mes=null;
		this.tipoafiliacion=null;
		this.numeropatronal=null;
		
		
		this.anio_descripcion="";
		this.mes_descripcion="";
		this.tipoafiliacion_descripcion="";
		this.numeropatronal_descripcion="";
		
		
		
			
		
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	
	
	public ProcesoIessAportes getProcesoIessAportesOriginal() {
		return this.procesoiessaportesOriginal;
	}
	
	public void setProcesoIessAportesOriginal(ProcesoIessAportes procesoiessaportes) {
		try {
			this.procesoiessaportesOriginal=procesoiessaportes;
		} catch(Exception e) {
			;
		}
	}
	
	
	protected ProcesoIessAportesAdditional procesoiessaportesAdditional=null;
	
	public ProcesoIessAportesAdditional getProcesoIessAportesAdditional() {
		return this.procesoiessaportesAdditional;
	}
	
	public void setProcesoIessAportesAdditional(ProcesoIessAportesAdditional procesoiessaportesAdditional) {
		try {
			this.procesoiessaportesAdditional=procesoiessaportesAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
    
	
	public Long getid_anio() {
		return this.id_anio;
	}
    
	
	public Long getid_mes() {
		return this.id_mes;
	}
    
	
	public Long getid_tipo_afiliacion() {
		return this.id_tipo_afiliacion;
	}
    
	
	public Long getid_numero_patronal() {
		return this.id_numero_patronal;
	}
    
	
	public Double getporcentaje() {
		return this.porcentaje;
	}
	
    
	public void setid_anio(Long newid_anio) {
		if(this.id_anio==null&&newid_anio!=null) {
			this.id_anio=newid_anio;
				this.setIsChanged(true);
		}

		if(this.id_anio!=null&&!this.id_anio.equals(newid_anio)) {

			this.id_anio=newid_anio;
				this.setIsChanged(true);
		}
	}
    
	public void setid_mes(Long newid_mes) {
		if(this.id_mes==null&&newid_mes!=null) {
			this.id_mes=newid_mes;
				this.setIsChanged(true);
		}

		if(this.id_mes!=null&&!this.id_mes.equals(newid_mes)) {

			this.id_mes=newid_mes;
				this.setIsChanged(true);
		}
	}
    
	public void setid_tipo_afiliacion(Long newid_tipo_afiliacion)throws Exception
	{
		try {
			if(this.id_tipo_afiliacion!=newid_tipo_afiliacion) {
				if(newid_tipo_afiliacion==null) {
					//newid_tipo_afiliacion=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ProcesoIessAportes:Valor nulo no permitido en columna id_tipo_afiliacion");
					}
				}

				this.id_tipo_afiliacion=newid_tipo_afiliacion;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_numero_patronal(Long newid_numero_patronal)throws Exception
	{
		try {
			if(this.id_numero_patronal!=newid_numero_patronal) {
				if(newid_numero_patronal==null) {
					//newid_numero_patronal=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ProcesoIessAportes:Valor nulo no permitido en columna id_numero_patronal");
					}
				}

				this.id_numero_patronal=newid_numero_patronal;
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
						System.out.println("ProcesoIessAportes:Valor nulo no permitido en columna porcentaje");
					}
				}

				this.porcentaje=newporcentaje;
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

	public TipoAfiliacion getTipoAfiliacion() {
		return this.tipoafiliacion;
	}

	public NumeroPatronal getNumeroPatronal() {
		return this.numeropatronal;
	}

	
	
	public String getanio_descripcion() {
		return this.anio_descripcion;
	}

	public String getmes_descripcion() {
		return this.mes_descripcion;
	}

	public String gettipoafiliacion_descripcion() {
		return this.tipoafiliacion_descripcion;
	}

	public String getnumeropatronal_descripcion() {
		return this.numeropatronal_descripcion;
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


	public  void  setTipoAfiliacion(TipoAfiliacion tipoafiliacion) {
		try {
			this.tipoafiliacion=tipoafiliacion;
		} catch(Exception e) {
			;
		}
	}


	public  void  setNumeroPatronal(NumeroPatronal numeropatronal) {
		try {
			this.numeropatronal=numeropatronal;
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


	public  void  settipoafiliacion_descripcion(String tipoafiliacion_descripcion) {
		try {
			this.tipoafiliacion_descripcion=tipoafiliacion_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  setnumeropatronal_descripcion(String numeropatronal_descripcion) {
		try {
			this.numeropatronal_descripcion=numeropatronal_descripcion;
		} catch(Exception e) {
			;
		}
	}


	
	
	
	
	
	/*PARA REPORTES*/
	String id_anio_descripcion="";String id_mes_descripcion="";String id_tipo_afiliacion_descripcion="";String id_numero_patronal_descripcion="";
	
	
	public String getid_anio_descripcion() {
		return id_anio_descripcion;
	}
	public String getid_mes_descripcion() {
		return id_mes_descripcion;
	}
	public String getid_tipo_afiliacion_descripcion() {
		return id_tipo_afiliacion_descripcion;
	}
	public String getid_numero_patronal_descripcion() {
		return id_numero_patronal_descripcion;
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
	public void setid_tipo_afiliacion_descripcion(String newid_tipo_afiliacion_descripcion)throws Exception {
		try {
			this.id_tipo_afiliacion_descripcion=newid_tipo_afiliacion_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_numero_patronal_descripcion(String newid_numero_patronal_descripcion)throws Exception {
		try {
			this.id_numero_patronal_descripcion=newid_numero_patronal_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	
	public void inicializarVariablesParaReporte() {
		this.id_anio_descripcion="";this.id_mes_descripcion="";this.id_tipo_afiliacion_descripcion="";this.id_numero_patronal_descripcion="";
	}
	
	
	
	
	
	
	/*PARA REPORTES FIN*/		
}

