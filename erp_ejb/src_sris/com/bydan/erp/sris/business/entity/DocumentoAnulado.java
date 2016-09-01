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
//import com.bydan.erp.sris.util.DocumentoAnuladoConstantesFunciones;
import com.bydan.erp.sris.util.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.contabilidad.util.*;



import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;




@SuppressWarnings("unused")
public class DocumentoAnulado extends DocumentoAnuladoAdditional implements Serializable ,Cloneable {//DocumentoAnuladoAdditional,GeneralEntity
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
	
	private DocumentoAnulado documentoanuladoOriginal;
	
	private Map<String, Object> mapDocumentoAnulado;
			
	public Map<String, Object> getMapDocumentoAnulado() {
		return mapDocumentoAnulado;
	}

	public void setMapDocumentoAnulado(Map<String, Object> mapDocumentoAnulado) {
		this.mapDocumentoAnulado = mapDocumentoAnulado;
	}
	
	public void inicializarMapDocumentoAnulado() {
		this.mapDocumentoAnulado = new HashMap<String,Object>();
	}
	
	public void setMapDocumentoAnuladoValue(String sKey,Object oValue) {
		this.mapDocumentoAnulado.put(sKey, oValue);
	}
	
	public Object getMapDocumentoAnuladoValue(String sKey) {
		return this.mapDocumentoAnulado.get(sKey);
	}
	
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_empresa;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_periodo_declara;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_modulo;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_tipo_comprobante;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=50,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=DocumentoAnuladoConstantesFunciones.SREGEXNUMERO,message=DocumentoAnuladoConstantesFunciones.SMENSAJEREGEXNUMERO)
	private String numero;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=20,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=DocumentoAnuladoConstantesFunciones.SREGEXSERIE,message=DocumentoAnuladoConstantesFunciones.SMENSAJEREGEXSERIE)
	private String serie;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=20,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=DocumentoAnuladoConstantesFunciones.SREGEXAUTORIZACION,message=DocumentoAnuladoConstantesFunciones.SMENSAJEREGEXAUTORIZACION)
	private String autorizacion;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Date fecha_anulacion;
			
	
	public Empresa empresa;
	public PeriodoDeclara periododeclara;
	public Modulo modulo;
	public TipoComprobante tipocomprobante;
	
	
	private String empresa_descripcion;
	private String periododeclara_descripcion;
	private String modulo_descripcion;
	private String tipocomprobante_descripcion;
	
	
		
	public DocumentoAnulado () throws Exception {
		super();		
		
		this.id=0L;
		
		
		this.versionRow=new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());//new Date();
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		this.sType="NONE";
		
		this.documentoanuladoOriginal=this;
		
 		this.id_empresa=-1L;
 		this.id_periodo_declara=-1L;
 		this.id_modulo=-1L;
 		this.id_tipo_comprobante=-1L;
 		this.numero="";
 		this.serie="";
 		this.autorizacion="";
 		this.fecha_anulacion=new Date();
		
		
		this.empresa=null;
		this.periododeclara=null;
		this.modulo=null;
		this.tipocomprobante=null;
		
		
		this.empresa_descripcion="";
		this.periododeclara_descripcion="";
		this.modulo_descripcion="";
		this.tipocomprobante_descripcion="";
		
		
		
			
		
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
    //PARA REPORTES
	public DocumentoAnulado (Long id,Date versionRow,Long id_empresa,Long id_periodo_declara,Long id_modulo,Long id_tipo_comprobante,String numero,String serie,String autorizacion,Date fecha_anulacion) throws Exception {
		super();		
		
		this.id=id;
		this.versionRow=versionRow;
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.documentoanuladoOriginal=this;
		
 		this.id_empresa=id_empresa;
 		this.id_periodo_declara=id_periodo_declara;
 		this.id_modulo=id_modulo;
 		this.id_tipo_comprobante=id_tipo_comprobante;
 		this.numero=numero;
 		this.serie=serie;
 		this.autorizacion=autorizacion;
 		this.fecha_anulacion=fecha_anulacion;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	 //PARA REPORTES
	public DocumentoAnulado (Long id_empresa,Long id_periodo_declara,Long id_modulo,Long id_tipo_comprobante,String numero,String serie,String autorizacion,Date fecha_anulacion) throws Exception {
		super();		
		
		this.id=0L;
		this.versionRow=new Date();
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.documentoanuladoOriginal=this;
		
 		this.id_empresa=id_empresa;
 		this.id_periodo_declara=id_periodo_declara;
 		this.id_modulo=id_modulo;
 		this.id_tipo_comprobante=id_tipo_comprobante;
 		this.numero=numero;
 		this.serie=serie;
 		this.autorizacion=autorizacion;
 		this.fecha_anulacion=fecha_anulacion;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	public boolean equals(Object object) {
		boolean equal=false;
		DocumentoAnulado documentoanuladoLocal=null;
		
		if(object!=null) {
			documentoanuladoLocal=(DocumentoAnulado)object;
			
			if(documentoanuladoLocal!=null) {
				if(this.getId()!=null && documentoanuladoLocal.getId()!=null) {
					if(this.getId().equals(documentoanuladoLocal.getId())) {
						equal=true;
					}
				}
			}
		}
		
		return equal;
	}
	
	public String toString() {
		String sDetalle="";
		
		if(!DocumentoAnuladoConstantesFunciones.CON_DESCRIPCION_DETALLADO) {
        	sDetalle=DocumentoAnuladoConstantesFunciones.getDocumentoAnuladoDescripcion(this);
		} else {
			sDetalle=DocumentoAnuladoConstantesFunciones.getDocumentoAnuladoDescripcionDetallado(this);
		}
		
		return sDetalle;
    }
	
	public DocumentoAnulado getDocumentoAnuladoOriginal() {
		return this.documentoanuladoOriginal;
	}
	
	public void setDocumentoAnuladoOriginal(DocumentoAnulado documentoanulado) {
		try {
			this.documentoanuladoOriginal=documentoanulado;
		} catch(Exception e) {
			;
		}
	}
	
	
	protected DocumentoAnuladoAdditional documentoanuladoAdditional=null;
	
	public DocumentoAnuladoAdditional getDocumentoAnuladoAdditional() {
		return this.documentoanuladoAdditional;
	}
	
	public void setDocumentoAnuladoAdditional(DocumentoAnuladoAdditional documentoanuladoAdditional) {
		try {
			this.documentoanuladoAdditional=documentoanuladoAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
    
	
	public Long getid_empresa() {
		return this.id_empresa;
	}
    
	
	public Long getid_periodo_declara() {
		return this.id_periodo_declara;
	}
    
	
	public Long getid_modulo() {
		return this.id_modulo;
	}
    
	
	public Long getid_tipo_comprobante() {
		return this.id_tipo_comprobante;
	}
    
	
	public String getnumero() {
		return this.numero;
	}
    
	
	public String getserie() {
		return this.serie;
	}
    
	
	public String getautorizacion() {
		return this.autorizacion;
	}
    
	
	public Date getfecha_anulacion() {
		return this.fecha_anulacion;
	}
	
    
	public void setid_empresa(Long newid_empresa)throws Exception
	{
		try {
			if(this.id_empresa!=newid_empresa) {
				if(newid_empresa==null) {
					//newid_empresa=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("DocumentoAnulado:Valor nulo no permitido en columna id_empresa");
					}
				}

				this.id_empresa=newid_empresa;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_periodo_declara(Long newid_periodo_declara)throws Exception
	{
		try {
			if(this.id_periodo_declara!=newid_periodo_declara) {
				if(newid_periodo_declara==null) {
					//newid_periodo_declara=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("DocumentoAnulado:Valor nulo no permitido en columna id_periodo_declara");
					}
				}

				this.id_periodo_declara=newid_periodo_declara;
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
						System.out.println("DocumentoAnulado:Valor nulo no permitido en columna id_modulo");
					}
				}

				this.id_modulo=newid_modulo;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_tipo_comprobante(Long newid_tipo_comprobante)throws Exception
	{
		try {
			if(this.id_tipo_comprobante!=newid_tipo_comprobante) {
				if(newid_tipo_comprobante==null) {
					//newid_tipo_comprobante=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("DocumentoAnulado:Valor nulo no permitido en columna id_tipo_comprobante");
					}
				}

				this.id_tipo_comprobante=newid_tipo_comprobante;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setnumero(String newnumero)throws Exception
	{
		try {
			if(this.numero!=newnumero) {
				if(newnumero==null) {
					//newnumero="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("DocumentoAnulado:Valor nulo no permitido en columna numero");
					}
				}

				if(newnumero!=null&&newnumero.length()>50) {
					newnumero=newnumero.substring(0,48);
					System.out.println("DocumentoAnulado:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=50 en columna numero");
				}

				this.numero=newnumero;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setserie(String newserie)throws Exception
	{
		try {
			if(this.serie!=newserie) {
				if(newserie==null) {
					//newserie="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("DocumentoAnulado:Valor nulo no permitido en columna serie");
					}
				}

				if(newserie!=null&&newserie.length()>20) {
					newserie=newserie.substring(0,18);
					System.out.println("DocumentoAnulado:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=20 en columna serie");
				}

				this.serie=newserie;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setautorizacion(String newautorizacion)throws Exception
	{
		try {
			if(this.autorizacion!=newautorizacion) {
				if(newautorizacion==null) {
					//newautorizacion="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("DocumentoAnulado:Valor nulo no permitido en columna autorizacion");
					}
				}

				if(newautorizacion!=null&&newautorizacion.length()>20) {
					newautorizacion=newautorizacion.substring(0,18);
					System.out.println("DocumentoAnulado:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=20 en columna autorizacion");
				}

				this.autorizacion=newautorizacion;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setfecha_anulacion(Date newfecha_anulacion)throws Exception
	{
		try {
			if(this.fecha_anulacion!=newfecha_anulacion) {
				if(newfecha_anulacion==null) {
					//newfecha_anulacion=new Date();
					if(Constantes.ISDEVELOPING) {
						System.out.println("DocumentoAnulado:Valor nulo no permitido en columna fecha_anulacion");
					}
				}

				this.fecha_anulacion=newfecha_anulacion;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	
	public Empresa getEmpresa() {
		return this.empresa;
	}

	public PeriodoDeclara getPeriodoDeclara() {
		return this.periododeclara;
	}

	public Modulo getModulo() {
		return this.modulo;
	}

	public TipoComprobante getTipoComprobante() {
		return this.tipocomprobante;
	}

	
	
	public String getempresa_descripcion() {
		return this.empresa_descripcion;
	}

	public String getperiododeclara_descripcion() {
		return this.periododeclara_descripcion;
	}

	public String getmodulo_descripcion() {
		return this.modulo_descripcion;
	}

	public String gettipocomprobante_descripcion() {
		return this.tipocomprobante_descripcion;
	}

	
	
	public  void  setEmpresa(Empresa empresa) {
		try {
			this.empresa=empresa;
		} catch(Exception e) {
			;
		}
	}


	public  void  setPeriodoDeclara(PeriodoDeclara periododeclara) {
		try {
			this.periododeclara=periododeclara;
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


	public  void  setTipoComprobante(TipoComprobante tipocomprobante) {
		try {
			this.tipocomprobante=tipocomprobante;
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


	public  void  setperiododeclara_descripcion(String periododeclara_descripcion) {
		try {
			this.periododeclara_descripcion=periododeclara_descripcion;
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


	public  void  settipocomprobante_descripcion(String tipocomprobante_descripcion) {
		try {
			this.tipocomprobante_descripcion=tipocomprobante_descripcion;
		} catch(Exception e) {
			;
		}
	}


	
	
	
	
	
	/*PARA REPORTES*/
	String id_empresa_descripcion="";String id_periodo_declara_descripcion="";String id_modulo_descripcion="";String id_tipo_comprobante_descripcion="";
	
	
	public String getid_empresa_descripcion() {
		return id_empresa_descripcion;
	}
	public String getid_periodo_declara_descripcion() {
		return id_periodo_declara_descripcion;
	}
	public String getid_modulo_descripcion() {
		return id_modulo_descripcion;
	}
	public String getid_tipo_comprobante_descripcion() {
		return id_tipo_comprobante_descripcion;
	}
	
	
	public void setid_empresa_descripcion(String newid_empresa_descripcion)throws Exception {
		try {
			this.id_empresa_descripcion=newid_empresa_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_periodo_declara_descripcion(String newid_periodo_declara_descripcion)throws Exception {
		try {
			this.id_periodo_declara_descripcion=newid_periodo_declara_descripcion;
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
	public void setid_tipo_comprobante_descripcion(String newid_tipo_comprobante_descripcion)throws Exception {
		try {
			this.id_tipo_comprobante_descripcion=newid_tipo_comprobante_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	
	public void inicializarVariablesParaReporte() {
		this.id_empresa_descripcion="";this.id_periodo_declara_descripcion="";this.id_modulo_descripcion="";this.id_tipo_comprobante_descripcion="";
	}
	
	
	
	
	
	
	/*PARA REPORTES FIN*/		
}

