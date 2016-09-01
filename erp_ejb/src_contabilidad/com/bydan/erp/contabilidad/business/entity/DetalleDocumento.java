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
//import com.bydan.erp.contabilidad.util.DetalleDocumentoConstantesFunciones;
import com.bydan.erp.contabilidad.util.*;


import com.bydan.erp.seguridad.util.*;



import com.bydan.erp.seguridad.business.entity.*;




@SuppressWarnings("unused")
public class DetalleDocumento extends DetalleDocumentoAdditional implements Serializable ,Cloneable {//DetalleDocumentoAdditional,GeneralEntity
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
	
	private DetalleDocumento detalledocumentoOriginal;
	
	private Map<String, Object> mapDetalleDocumento;
			
	public Map<String, Object> getMapDetalleDocumento() {
		return mapDetalleDocumento;
	}

	public void setMapDetalleDocumento(Map<String, Object> mapDetalleDocumento) {
		this.mapDetalleDocumento = mapDetalleDocumento;
	}
	
	public void inicializarMapDetalleDocumento() {
		this.mapDetalleDocumento = new HashMap<String,Object>();
	}
	
	public void setMapDetalleDocumentoValue(String sKey,Object oValue) {
		this.mapDetalleDocumento.put(sKey, oValue);
	}
	
	public Object getMapDetalleDocumentoValue(String sKey) {
		return this.mapDetalleDocumento.get(sKey);
	}
	
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_empresa;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_modulo;
	
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_tipo_transaccion_modulo;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_tipo_detalle_documento;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=50,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=DetalleDocumentoConstantesFunciones.SREGEXNOMBRE,message=DetalleDocumentoConstantesFunciones.SMENSAJEREGEXNOMBRE)
	private String nombre;
			
	
	public Empresa empresa;
	public Modulo modulo;
	public TipoTransaccionModulo tipotransaccionmodulo;
	public TipoDetalleDocumento tipodetalledocumento;
	
	
	private String empresa_descripcion;
	private String modulo_descripcion;
	private String tipotransaccionmodulo_descripcion;
	private String tipodetalledocumento_descripcion;
	
	
		
	public DetalleDocumento () throws Exception {
		super();		
		
		this.id=0L;
		
		
		this.versionRow=new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());//new Date();
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		this.sType="NONE";
		
		this.detalledocumentoOriginal=this;
		
 		this.id_empresa=-1L;
 		this.id_modulo=-1L;
 		this.id_tipo_transaccion_modulo=null;
 		this.id_tipo_detalle_documento=-1L;
 		this.nombre="";
		
		
		this.empresa=null;
		this.modulo=null;
		this.tipotransaccionmodulo=null;
		this.tipodetalledocumento=null;
		
		
		this.empresa_descripcion="";
		this.modulo_descripcion="";
		this.tipotransaccionmodulo_descripcion="";
		this.tipodetalledocumento_descripcion="";
		
		
		
			
		
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
    //PARA REPORTES
	public DetalleDocumento (Long id,Date versionRow,Long id_empresa,Long id_modulo,Long id_tipo_transaccion_modulo,Long id_tipo_detalle_documento,String nombre) throws Exception {
		super();		
		
		this.id=id;
		this.versionRow=versionRow;
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.detalledocumentoOriginal=this;
		
 		this.id_empresa=id_empresa;
 		this.id_modulo=id_modulo;
 		this.id_tipo_transaccion_modulo=id_tipo_transaccion_modulo;
 		this.id_tipo_detalle_documento=id_tipo_detalle_documento;
 		this.nombre=nombre;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	 //PARA REPORTES
	public DetalleDocumento (Long id_empresa,Long id_modulo,Long id_tipo_transaccion_modulo,Long id_tipo_detalle_documento,String nombre) throws Exception {
		super();		
		
		this.id=0L;
		this.versionRow=new Date();
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.detalledocumentoOriginal=this;
		
 		this.id_empresa=id_empresa;
 		this.id_modulo=id_modulo;
 		this.id_tipo_transaccion_modulo=id_tipo_transaccion_modulo;
 		this.id_tipo_detalle_documento=id_tipo_detalle_documento;
 		this.nombre=nombre;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	public boolean equals(Object object) {
		boolean equal=false;
		DetalleDocumento detalledocumentoLocal=null;
		
		if(object!=null) {
			detalledocumentoLocal=(DetalleDocumento)object;
			
			if(detalledocumentoLocal!=null) {
				if(this.getId()!=null && detalledocumentoLocal.getId()!=null) {
					if(this.getId().equals(detalledocumentoLocal.getId())) {
						equal=true;
					}
				}
			}
		}
		
		return equal;
	}
	
	public String toString() {
		String sDetalle="";
		
		if(!DetalleDocumentoConstantesFunciones.CON_DESCRIPCION_DETALLADO) {
        	sDetalle=DetalleDocumentoConstantesFunciones.getDetalleDocumentoDescripcion(this);
		} else {
			sDetalle=DetalleDocumentoConstantesFunciones.getDetalleDocumentoDescripcionDetallado(this);
		}
		
		return sDetalle;
    }
	
	public DetalleDocumento getDetalleDocumentoOriginal() {
		return this.detalledocumentoOriginal;
	}
	
	public void setDetalleDocumentoOriginal(DetalleDocumento detalledocumento) {
		try {
			this.detalledocumentoOriginal=detalledocumento;
		} catch(Exception e) {
			;
		}
	}
	
	
	protected DetalleDocumentoAdditional detalledocumentoAdditional=null;
	
	public DetalleDocumentoAdditional getDetalleDocumentoAdditional() {
		return this.detalledocumentoAdditional;
	}
	
	public void setDetalleDocumentoAdditional(DetalleDocumentoAdditional detalledocumentoAdditional) {
		try {
			this.detalledocumentoAdditional=detalledocumentoAdditional;
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
    
	
	public Long getid_tipo_transaccion_modulo() {
		return this.id_tipo_transaccion_modulo;
	}
    
	
	public Long getid_tipo_detalle_documento() {
		return this.id_tipo_detalle_documento;
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
						System.out.println("DetalleDocumento:Valor nulo no permitido en columna id_empresa");
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
						System.out.println("DetalleDocumento:Valor nulo no permitido en columna id_modulo");
					}
				}

				this.id_modulo=newid_modulo;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_tipo_transaccion_modulo(Long newid_tipo_transaccion_modulo) {
		if(this.id_tipo_transaccion_modulo==null&&newid_tipo_transaccion_modulo!=null) {
			this.id_tipo_transaccion_modulo=newid_tipo_transaccion_modulo;
				this.setIsChanged(true);
		}

		if(this.id_tipo_transaccion_modulo!=null&&!this.id_tipo_transaccion_modulo.equals(newid_tipo_transaccion_modulo)) {

			this.id_tipo_transaccion_modulo=newid_tipo_transaccion_modulo;
				this.setIsChanged(true);
		}
	}
    
	public void setid_tipo_detalle_documento(Long newid_tipo_detalle_documento)throws Exception
	{
		try {
			if(this.id_tipo_detalle_documento!=newid_tipo_detalle_documento) {
				if(newid_tipo_detalle_documento==null) {
					//newid_tipo_detalle_documento=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("DetalleDocumento:Valor nulo no permitido en columna id_tipo_detalle_documento");
					}
				}

				this.id_tipo_detalle_documento=newid_tipo_detalle_documento;
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
						System.out.println("DetalleDocumento:Valor nulo no permitido en columna nombre");
					}
				}

				if(newnombre!=null&&newnombre.length()>50) {
					newnombre=newnombre.substring(0,48);
					System.out.println("DetalleDocumento:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=50 en columna nombre");
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

	public Modulo getModulo() {
		return this.modulo;
	}

	public TipoTransaccionModulo getTipoTransaccionModulo() {
		return this.tipotransaccionmodulo;
	}

	public TipoDetalleDocumento getTipoDetalleDocumento() {
		return this.tipodetalledocumento;
	}

	
	
	public String getempresa_descripcion() {
		return this.empresa_descripcion;
	}

	public String getmodulo_descripcion() {
		return this.modulo_descripcion;
	}

	public String gettipotransaccionmodulo_descripcion() {
		return this.tipotransaccionmodulo_descripcion;
	}

	public String gettipodetalledocumento_descripcion() {
		return this.tipodetalledocumento_descripcion;
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


	public  void  setTipoTransaccionModulo(TipoTransaccionModulo tipotransaccionmodulo) {
		try {
			this.tipotransaccionmodulo=tipotransaccionmodulo;
		} catch(Exception e) {
			;
		}
	}


	public  void  setTipoDetalleDocumento(TipoDetalleDocumento tipodetalledocumento) {
		try {
			this.tipodetalledocumento=tipodetalledocumento;
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


	public  void  settipotransaccionmodulo_descripcion(String tipotransaccionmodulo_descripcion) {
		try {
			this.tipotransaccionmodulo_descripcion=tipotransaccionmodulo_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  settipodetalledocumento_descripcion(String tipodetalledocumento_descripcion) {
		try {
			this.tipodetalledocumento_descripcion=tipodetalledocumento_descripcion;
		} catch(Exception e) {
			;
		}
	}


	
	
	
	
	
	/*PARA REPORTES*/
	String id_empresa_descripcion="";String id_modulo_descripcion="";String id_tipo_transaccion_modulo_descripcion="";String id_tipo_detalle_documento_descripcion="";
	
	
	public String getid_empresa_descripcion() {
		return id_empresa_descripcion;
	}
	public String getid_modulo_descripcion() {
		return id_modulo_descripcion;
	}
	public String getid_tipo_transaccion_modulo_descripcion() {
		return id_tipo_transaccion_modulo_descripcion;
	}
	public String getid_tipo_detalle_documento_descripcion() {
		return id_tipo_detalle_documento_descripcion;
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
	public void setid_tipo_transaccion_modulo_descripcion(String newid_tipo_transaccion_modulo_descripcion)throws Exception {
		try {
			this.id_tipo_transaccion_modulo_descripcion=newid_tipo_transaccion_modulo_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_tipo_detalle_documento_descripcion(String newid_tipo_detalle_documento_descripcion)throws Exception {
		try {
			this.id_tipo_detalle_documento_descripcion=newid_tipo_detalle_documento_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	
	public void inicializarVariablesParaReporte() {
		this.id_empresa_descripcion="";this.id_modulo_descripcion="";this.id_tipo_transaccion_modulo_descripcion="";this.id_tipo_detalle_documento_descripcion="";
	}
	
	
	
	
	
	
	/*PARA REPORTES FIN*/		
}

