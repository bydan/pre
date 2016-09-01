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
//import com.bydan.erp.cartera.util.FirmaClienteConstantesFunciones;
import com.bydan.erp.cartera.util.*;


import com.bydan.erp.seguridad.util.*;



import com.bydan.erp.seguridad.business.entity.*;




@SuppressWarnings("unused")
public class FirmaCliente extends FirmaClienteAdditional implements Serializable ,Cloneable {//FirmaClienteAdditional,GeneralEntity
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
	
	private FirmaCliente firmaclienteOriginal;
	
	private Map<String, Object> mapFirmaCliente;
			
	public Map<String, Object> getMapFirmaCliente() {
		return mapFirmaCliente;
	}

	public void setMapFirmaCliente(Map<String, Object> mapFirmaCliente) {
		this.mapFirmaCliente = mapFirmaCliente;
	}
	
	public void inicializarMapFirmaCliente() {
		this.mapFirmaCliente = new HashMap<String,Object>();
	}
	
	public void setMapFirmaClienteValue(String sKey,Object oValue) {
		this.mapFirmaCliente.put(sKey, oValue);
	}
	
	public Object getMapFirmaClienteValue(String sKey) {
		return this.mapFirmaCliente.get(sKey);
	}
	
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_empresa;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_cliente;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_tipo_imagen;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private byte [] firma;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=150,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=FirmaClienteConstantesFunciones.SREGEXPATH_FIRMA,message=FirmaClienteConstantesFunciones.SMENSAJEREGEXPATH_FIRMA)
	private String path_firma;
			
	
	public Empresa empresa;
	public Cliente cliente;
	public TipoImagen tipoimagen;
	
	
	private String empresa_descripcion;
	private String cliente_descripcion;
	private String tipoimagen_descripcion;
	
	
		
	public FirmaCliente () throws Exception {
		super();		
		
		this.id=0L;
		
		
		this.versionRow=new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());//new Date();
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		this.sType="NONE";
		
		this.firmaclienteOriginal=this;
		
 		this.id_empresa=-1L;
 		this.id_cliente=-1L;
 		this.id_tipo_imagen=-1L;
 		this.firma=null;
 		this.path_firma="";
		
		
		this.empresa=null;
		this.cliente=null;
		this.tipoimagen=null;
		
		
		this.empresa_descripcion="";
		this.cliente_descripcion="";
		this.tipoimagen_descripcion="";
		
		
		
			
		
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
    //PARA REPORTES
	public FirmaCliente (Long id,Date versionRow,Long id_empresa,Long id_cliente,Long id_tipo_imagen,byte [] firma,String path_firma) throws Exception {
		super();		
		
		this.id=id;
		this.versionRow=versionRow;
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.firmaclienteOriginal=this;
		
 		this.id_empresa=id_empresa;
 		this.id_cliente=id_cliente;
 		this.id_tipo_imagen=id_tipo_imagen;
 		this.firma=firma;
 		this.path_firma=path_firma;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	 //PARA REPORTES
	public FirmaCliente (Long id_empresa,Long id_cliente,Long id_tipo_imagen,byte [] firma,String path_firma) throws Exception {
		super();		
		
		this.id=0L;
		this.versionRow=new Date();
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.firmaclienteOriginal=this;
		
 		this.id_empresa=id_empresa;
 		this.id_cliente=id_cliente;
 		this.id_tipo_imagen=id_tipo_imagen;
 		this.firma=firma;
 		this.path_firma=path_firma;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	public boolean equals(Object object) {
		boolean equal=false;
		FirmaCliente firmaclienteLocal=null;
		
		if(object!=null) {
			firmaclienteLocal=(FirmaCliente)object;
			
			if(firmaclienteLocal!=null) {
				if(this.getId()!=null && firmaclienteLocal.getId()!=null) {
					if(this.getId().equals(firmaclienteLocal.getId())) {
						equal=true;
					}
				}
			}
		}
		
		return equal;
	}
	
	public String toString() {
		String sDetalle="";
		
		if(!FirmaClienteConstantesFunciones.CON_DESCRIPCION_DETALLADO) {
        	sDetalle=FirmaClienteConstantesFunciones.getFirmaClienteDescripcion(this);
		} else {
			sDetalle=FirmaClienteConstantesFunciones.getFirmaClienteDescripcionDetallado(this);
		}
		
		return sDetalle;
    }
	
	public FirmaCliente getFirmaClienteOriginal() {
		return this.firmaclienteOriginal;
	}
	
	public void setFirmaClienteOriginal(FirmaCliente firmacliente) {
		try {
			this.firmaclienteOriginal=firmacliente;
		} catch(Exception e) {
			;
		}
	}
	
	
	protected FirmaClienteAdditional firmaclienteAdditional=null;
	
	public FirmaClienteAdditional getFirmaClienteAdditional() {
		return this.firmaclienteAdditional;
	}
	
	public void setFirmaClienteAdditional(FirmaClienteAdditional firmaclienteAdditional) {
		try {
			this.firmaclienteAdditional=firmaclienteAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
    
	
	public Long getid_empresa() {
		return this.id_empresa;
	}
    
	
	public Long getid_cliente() {
		return this.id_cliente;
	}
    
	
	public Long getid_tipo_imagen() {
		return this.id_tipo_imagen;
	}
    
	
	public byte [] getfirma() {
		return this.firma;
	}
    
	
	public String getpath_firma() {
		return this.path_firma;
	}
	
    
	public void setid_empresa(Long newid_empresa)throws Exception
	{
		try {
			if(this.id_empresa!=newid_empresa) {
				if(newid_empresa==null) {
					//newid_empresa=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("FirmaCliente:Valor nulo no permitido en columna id_empresa");
					}
				}

				this.id_empresa=newid_empresa;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_cliente(Long newid_cliente)throws Exception
	{
		try {
			if(this.id_cliente!=newid_cliente) {
				if(newid_cliente==null) {
					//newid_cliente=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("FirmaCliente:Valor nulo no permitido en columna id_cliente");
					}
				}

				this.id_cliente=newid_cliente;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_tipo_imagen(Long newid_tipo_imagen)throws Exception
	{
		try {
			if(this.id_tipo_imagen!=newid_tipo_imagen) {
				if(newid_tipo_imagen==null) {
					//newid_tipo_imagen=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("FirmaCliente:Valor nulo no permitido en columna id_tipo_imagen");
					}
				}

				this.id_tipo_imagen=newid_tipo_imagen;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setfirma(byte [] newfirma) {
		if(this.firma==null&&newfirma!=null) {
			this.firma=newfirma;
				this.setIsChanged(true);
		}

		if(this.firma!=null&&!this.firma.equals(newfirma)) {

			this.firma=newfirma;
				this.setIsChanged(true);
		}
	}
    
	public void setpath_firma(String newpath_firma)throws Exception
	{
		try {
			if(this.path_firma!=newpath_firma) {
				if(newpath_firma==null) {
					//newpath_firma="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("FirmaCliente:Valor nulo no permitido en columna path_firma");
					}
				}

				if(newpath_firma!=null&&newpath_firma.length()>150) {
					newpath_firma=newpath_firma.substring(0,148);
					System.out.println("FirmaCliente:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=150 en columna path_firma");
				}

				this.path_firma=newpath_firma;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	
	public Empresa getEmpresa() {
		return this.empresa;
	}

	public Cliente getCliente() {
		return this.cliente;
	}

	public TipoImagen getTipoImagen() {
		return this.tipoimagen;
	}

	
	
	public String getempresa_descripcion() {
		return this.empresa_descripcion;
	}

	public String getcliente_descripcion() {
		return this.cliente_descripcion;
	}

	public String gettipoimagen_descripcion() {
		return this.tipoimagen_descripcion;
	}

	
	
	public  void  setEmpresa(Empresa empresa) {
		try {
			this.empresa=empresa;
		} catch(Exception e) {
			;
		}
	}


	public  void  setCliente(Cliente cliente) {
		try {
			this.cliente=cliente;
		} catch(Exception e) {
			;
		}
	}


	public  void  setTipoImagen(TipoImagen tipoimagen) {
		try {
			this.tipoimagen=tipoimagen;
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


	public  void  setcliente_descripcion(String cliente_descripcion) {
		try {
			this.cliente_descripcion=cliente_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  settipoimagen_descripcion(String tipoimagen_descripcion) {
		try {
			this.tipoimagen_descripcion=tipoimagen_descripcion;
		} catch(Exception e) {
			;
		}
	}


	
	
	
	
	
	/*PARA REPORTES*/
	String id_empresa_descripcion="";String id_cliente_descripcion="";String id_tipo_imagen_descripcion="";
	
	
	public String getid_empresa_descripcion() {
		return id_empresa_descripcion;
	}
	public String getid_cliente_descripcion() {
		return id_cliente_descripcion;
	}
	public String getid_tipo_imagen_descripcion() {
		return id_tipo_imagen_descripcion;
	}
	
	
	public void setid_empresa_descripcion(String newid_empresa_descripcion)throws Exception {
		try {
			this.id_empresa_descripcion=newid_empresa_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_cliente_descripcion(String newid_cliente_descripcion)throws Exception {
		try {
			this.id_cliente_descripcion=newid_cliente_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_tipo_imagen_descripcion(String newid_tipo_imagen_descripcion)throws Exception {
		try {
			this.id_tipo_imagen_descripcion=newid_tipo_imagen_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	
	public void inicializarVariablesParaReporte() {
		this.id_empresa_descripcion="";this.id_cliente_descripcion="";this.id_tipo_imagen_descripcion="";
	}
	
	
	
	
	
	
	/*PARA REPORTES FIN*/		
}

