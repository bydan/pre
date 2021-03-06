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
//import com.bydan.erp.facturacion.util.TipoDocumentoGeneralConstantesFunciones;
import com.bydan.erp.facturacion.util.*;









@SuppressWarnings("unused")
public class TipoDocumentoGeneral extends TipoDocumentoGeneralAdditional implements Serializable ,Cloneable {//TipoDocumentoGeneralAdditional,GeneralEntity
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
	
	private TipoDocumentoGeneral tipodocumentogeneralOriginal;
	
	private Map<String, Object> mapTipoDocumentoGeneral;
			
	public Map<String, Object> getMapTipoDocumentoGeneral() {
		return mapTipoDocumentoGeneral;
	}

	public void setMapTipoDocumentoGeneral(Map<String, Object> mapTipoDocumentoGeneral) {
		this.mapTipoDocumentoGeneral = mapTipoDocumentoGeneral;
	}
	
	public void inicializarMapTipoDocumentoGeneral() {
		this.mapTipoDocumentoGeneral = new HashMap<String,Object>();
	}
	
	public void setMapTipoDocumentoGeneralValue(String sKey,Object oValue) {
		this.mapTipoDocumentoGeneral.put(sKey, oValue);
	}
	
	public Object getMapTipoDocumentoGeneralValue(String sKey) {
		return this.mapTipoDocumentoGeneral.get(sKey);
	}
	
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=50,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=TipoDocumentoGeneralConstantesFunciones.SREGEXCODIGO,message=TipoDocumentoGeneralConstantesFunciones.SMENSAJEREGEXCODIGO)
	private String codigo;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=100,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=TipoDocumentoGeneralConstantesFunciones.SREGEXNOMBRE,message=TipoDocumentoGeneralConstantesFunciones.SMENSAJEREGEXNOMBRE)
	private String nombre;
			
	
	
	
	
	
		
	public TipoDocumentoGeneral () throws Exception {
		super();		
		
		this.id=0L;
		this.idOriginal=0L;
		
		
		this.versionRow=new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());//new Date();
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		this.sType="NONE";
		
		this.tipodocumentogeneralOriginal=this;
		
 		this.codigo="";
 		this.nombre="";
		
		
		
		
		
		
		
			
		
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
    //PARA REPORTES
	public TipoDocumentoGeneral (Long id,Date versionRow,String codigo,String nombre) throws Exception {
		super();		
		
		this.id=id;
		this.idOriginal=this.id;
		this.versionRow=versionRow;
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.tipodocumentogeneralOriginal=this;
		
 		this.codigo=codigo;
 		this.nombre=nombre;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	 //PARA REPORTES
	public TipoDocumentoGeneral (String codigo,String nombre) throws Exception {
		super();		
		
		this.id=0L;
		this.idOriginal=0L;
		this.versionRow=new Date();
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.tipodocumentogeneralOriginal=this;
		
 		this.codigo=codigo;
 		this.nombre=nombre;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	public boolean equals(Object object) {
		boolean equal=false;
		TipoDocumentoGeneral tipodocumentogeneralLocal=null;
		
		if(object!=null) {
			tipodocumentogeneralLocal=(TipoDocumentoGeneral)object;
			
			if(tipodocumentogeneralLocal!=null) {
				if(this.getId()!=null && tipodocumentogeneralLocal.getId()!=null) {
					if(this.getId().equals(tipodocumentogeneralLocal.getId())) {
						equal=true;
					}
				}
			}
		}
		
		return equal;
	}
	
	public String toString() {
		String sDetalle="";
		
		if(!TipoDocumentoGeneralConstantesFunciones.CON_DESCRIPCION_DETALLADO) {
        	sDetalle=TipoDocumentoGeneralConstantesFunciones.getTipoDocumentoGeneralDescripcion(this);
		} else {
			sDetalle=TipoDocumentoGeneralConstantesFunciones.getTipoDocumentoGeneralDescripcionDetallado(this);
		}
		
		return sDetalle;
    }
	
	public TipoDocumentoGeneral getTipoDocumentoGeneralOriginal() {
		return this.tipodocumentogeneralOriginal;
	}
	
	public void setTipoDocumentoGeneralOriginal(TipoDocumentoGeneral tipodocumentogeneral) {
		try {
			this.tipodocumentogeneralOriginal=tipodocumentogeneral;
		} catch(Exception e) {
			;
		}
	}
	
	
	protected TipoDocumentoGeneralAdditional tipodocumentogeneralAdditional=null;
	
	public TipoDocumentoGeneralAdditional getTipoDocumentoGeneralAdditional() {
		return this.tipodocumentogeneralAdditional;
	}
	
	public void setTipoDocumentoGeneralAdditional(TipoDocumentoGeneralAdditional tipodocumentogeneralAdditional) {
		try {
			this.tipodocumentogeneralAdditional=tipodocumentogeneralAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
    
	
	public String getcodigo() {
		return this.codigo;
	}
    
	
	public String getnombre() {
		return this.nombre;
	}
	
    
	public void setcodigo(String newcodigo)throws Exception
	{
		try {
			if(this.codigo!=newcodigo) {
				if(newcodigo==null) {
					//newcodigo="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("TipoDocumentoGeneral:Valor nulo no permitido en columna codigo");
					}
				}

				if(newcodigo!=null&&newcodigo.length()>50) {
					newcodigo=newcodigo.substring(0,48);
					System.out.println("TipoDocumentoGeneral:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=50 en columna codigo");
				}

				this.codigo=newcodigo;
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
						System.out.println("TipoDocumentoGeneral:Valor nulo no permitido en columna nombre");
					}
				}

				if(newnombre!=null&&newnombre.length()>100) {
					newnombre=newnombre.substring(0,98);
					System.out.println("TipoDocumentoGeneral:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=100 en columna nombre");
				}

				this.nombre=newnombre;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	/*PARA REPORTES*/
	
	
	
	
	
	
	public void inicializarVariablesParaReporte() {
		
	}
	
	
	Object autorisrisDescripcionReporte;
	Object parametrogeneralsDescripcionReporte;
	Object secuencialusuariosDescripcionReporte;
	Object parametrofactusecuencialsDescripcionReporte;
	
	
	public Object getautorisrisDescripcionReporte() {
		return autorisrisDescripcionReporte;
	}

	public Object getparametrogeneralsDescripcionReporte() {
		return parametrogeneralsDescripcionReporte;
	}

	public Object getsecuencialusuariosDescripcionReporte() {
		return secuencialusuariosDescripcionReporte;
	}

	public Object getparametrofactusecuencialsDescripcionReporte() {
		return parametrofactusecuencialsDescripcionReporte;
	}

	
	
	public  void  setautorisrisDescripcionReporte(Object autorisris) {
		try {
			this.autorisrisDescripcionReporte=autorisris;
		} catch(Exception ex) {
			;
		}
	}

	public  void  setparametrogeneralsDescripcionReporte(Object parametrogenerals) {
		try {
			this.parametrogeneralsDescripcionReporte=parametrogenerals;
		} catch(Exception ex) {
			;
		}
	}

	public  void  setsecuencialusuariosDescripcionReporte(Object secuencialusuarios) {
		try {
			this.secuencialusuariosDescripcionReporte=secuencialusuarios;
		} catch(Exception ex) {
			;
		}
	}

	public  void  setparametrofactusecuencialsDescripcionReporte(Object parametrofactusecuencials) {
		try {
			this.parametrofactusecuencialsDescripcionReporte=parametrofactusecuencials;
		} catch(Exception ex) {
			;
		}
	}

	/*PARA REPORTES FIN*/		
}

