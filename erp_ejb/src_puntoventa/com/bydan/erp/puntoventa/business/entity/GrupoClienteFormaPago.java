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
package com.bydan.erp.puntoventa.business.entity;

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
//import com.bydan.erp.puntoventa.util.GrupoClienteFormaPagoConstantesFunciones;
import com.bydan.erp.puntoventa.util.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.cartera.util.*;
import com.bydan.erp.facturacion.util.*;



import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;
import com.bydan.erp.facturacion.business.entity.*;




@SuppressWarnings("unused")
public class GrupoClienteFormaPago extends GrupoClienteFormaPagoAdditional implements Serializable ,Cloneable {//GrupoClienteFormaPagoAdditional,GeneralEntity
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
	
	private GrupoClienteFormaPago grupoclienteformapagoOriginal;
	
	private Map<String, Object> mapGrupoClienteFormaPago;
			
	public Map<String, Object> getMapGrupoClienteFormaPago() {
		return mapGrupoClienteFormaPago;
	}

	public void setMapGrupoClienteFormaPago(Map<String, Object> mapGrupoClienteFormaPago) {
		this.mapGrupoClienteFormaPago = mapGrupoClienteFormaPago;
	}
	
	public void inicializarMapGrupoClienteFormaPago() {
		this.mapGrupoClienteFormaPago = new HashMap<String,Object>();
	}
	
	public void setMapGrupoClienteFormaPagoValue(String sKey,Object oValue) {
		this.mapGrupoClienteFormaPago.put(sKey, oValue);
	}
	
	public Object getMapGrupoClienteFormaPagoValue(String sKey) {
		return this.mapGrupoClienteFormaPago.get(sKey);
	}
	
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_empresa;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_grupo_cliente;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_tipo_forma_pago;
			
	
	public Empresa empresa;
	public GrupoCliente grupocliente;
	public TipoFormaPago tipoformapago;
	
	
	private String empresa_descripcion;
	private String grupocliente_descripcion;
	private String tipoformapago_descripcion;
	
	
		
	public GrupoClienteFormaPago () throws Exception {
		super();		
		
		this.id=0L;
		
		
		this.versionRow=new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());//new Date();
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		this.sType="NONE";
		
		this.grupoclienteformapagoOriginal=this;
		
 		this.id_empresa=-1L;
 		this.id_grupo_cliente=-1L;
 		this.id_tipo_forma_pago=-1L;
		
		
		this.empresa=null;
		this.grupocliente=null;
		this.tipoformapago=null;
		
		
		this.empresa_descripcion="";
		this.grupocliente_descripcion="";
		this.tipoformapago_descripcion="";
		
		
		
			
		
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
    //PARA REPORTES
	public GrupoClienteFormaPago (Long id,Date versionRow,Long id_empresa,Long id_grupo_cliente,Long id_tipo_forma_pago) throws Exception {
		super();		
		
		this.id=id;
		this.versionRow=versionRow;
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.grupoclienteformapagoOriginal=this;
		
 		this.id_empresa=id_empresa;
 		this.id_grupo_cliente=id_grupo_cliente;
 		this.id_tipo_forma_pago=id_tipo_forma_pago;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	 //PARA REPORTES
	public GrupoClienteFormaPago (Long id_empresa,Long id_grupo_cliente,Long id_tipo_forma_pago) throws Exception {
		super();		
		
		this.id=0L;
		this.versionRow=new Date();
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.grupoclienteformapagoOriginal=this;
		
 		this.id_empresa=id_empresa;
 		this.id_grupo_cliente=id_grupo_cliente;
 		this.id_tipo_forma_pago=id_tipo_forma_pago;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	public boolean equals(Object object) {
		boolean equal=false;
		GrupoClienteFormaPago grupoclienteformapagoLocal=null;
		
		if(object!=null) {
			grupoclienteformapagoLocal=(GrupoClienteFormaPago)object;
			
			if(grupoclienteformapagoLocal!=null) {
				if(this.getId()!=null && grupoclienteformapagoLocal.getId()!=null) {
					if(this.getId().equals(grupoclienteformapagoLocal.getId())) {
						equal=true;
					}
				}
			}
		}
		
		return equal;
	}
	
	public String toString() {
		String sDetalle="";
		
		if(!GrupoClienteFormaPagoConstantesFunciones.CON_DESCRIPCION_DETALLADO) {
        	sDetalle=GrupoClienteFormaPagoConstantesFunciones.getGrupoClienteFormaPagoDescripcion(this);
		} else {
			sDetalle=GrupoClienteFormaPagoConstantesFunciones.getGrupoClienteFormaPagoDescripcionDetallado(this);
		}
		
		return sDetalle;
    }
	
	public GrupoClienteFormaPago getGrupoClienteFormaPagoOriginal() {
		return this.grupoclienteformapagoOriginal;
	}
	
	public void setGrupoClienteFormaPagoOriginal(GrupoClienteFormaPago grupoclienteformapago) {
		try {
			this.grupoclienteformapagoOriginal=grupoclienteformapago;
		} catch(Exception e) {
			;
		}
	}
	
	
	protected GrupoClienteFormaPagoAdditional grupoclienteformapagoAdditional=null;
	
	public GrupoClienteFormaPagoAdditional getGrupoClienteFormaPagoAdditional() {
		return this.grupoclienteformapagoAdditional;
	}
	
	public void setGrupoClienteFormaPagoAdditional(GrupoClienteFormaPagoAdditional grupoclienteformapagoAdditional) {
		try {
			this.grupoclienteformapagoAdditional=grupoclienteformapagoAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
    
	
	public Long getid_empresa() {
		return this.id_empresa;
	}
    
	
	public Long getid_grupo_cliente() {
		return this.id_grupo_cliente;
	}
    
	
	public Long getid_tipo_forma_pago() {
		return this.id_tipo_forma_pago;
	}
	
    
	public void setid_empresa(Long newid_empresa)throws Exception
	{
		try {
			if(this.id_empresa!=newid_empresa) {
				if(newid_empresa==null) {
					//newid_empresa=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("GrupoClienteFormaPago:Valor nulo no permitido en columna id_empresa");
					}
				}

				this.id_empresa=newid_empresa;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_grupo_cliente(Long newid_grupo_cliente)throws Exception
	{
		try {
			if(this.id_grupo_cliente!=newid_grupo_cliente) {
				if(newid_grupo_cliente==null) {
					//newid_grupo_cliente=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("GrupoClienteFormaPago:Valor nulo no permitido en columna id_grupo_cliente");
					}
				}

				this.id_grupo_cliente=newid_grupo_cliente;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_tipo_forma_pago(Long newid_tipo_forma_pago)throws Exception
	{
		try {
			if(this.id_tipo_forma_pago!=newid_tipo_forma_pago) {
				if(newid_tipo_forma_pago==null) {
					//newid_tipo_forma_pago=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("GrupoClienteFormaPago:Valor nulo no permitido en columna id_tipo_forma_pago");
					}
				}

				this.id_tipo_forma_pago=newid_tipo_forma_pago;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	
	public Empresa getEmpresa() {
		return this.empresa;
	}

	public GrupoCliente getGrupoCliente() {
		return this.grupocliente;
	}

	public TipoFormaPago getTipoFormaPago() {
		return this.tipoformapago;
	}

	
	
	public String getempresa_descripcion() {
		return this.empresa_descripcion;
	}

	public String getgrupocliente_descripcion() {
		return this.grupocliente_descripcion;
	}

	public String gettipoformapago_descripcion() {
		return this.tipoformapago_descripcion;
	}

	
	
	public  void  setEmpresa(Empresa empresa) {
		try {
			this.empresa=empresa;
		} catch(Exception e) {
			;
		}
	}


	public  void  setGrupoCliente(GrupoCliente grupocliente) {
		try {
			this.grupocliente=grupocliente;
		} catch(Exception e) {
			;
		}
	}


	public  void  setTipoFormaPago(TipoFormaPago tipoformapago) {
		try {
			this.tipoformapago=tipoformapago;
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


	public  void  setgrupocliente_descripcion(String grupocliente_descripcion) {
		try {
			this.grupocliente_descripcion=grupocliente_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  settipoformapago_descripcion(String tipoformapago_descripcion) {
		try {
			this.tipoformapago_descripcion=tipoformapago_descripcion;
		} catch(Exception e) {
			;
		}
	}


	
	
	
	
	
	/*PARA REPORTES*/
	String id_empresa_descripcion="";String id_grupo_cliente_descripcion="";String id_tipo_forma_pago_descripcion="";
	
	
	public String getid_empresa_descripcion() {
		return id_empresa_descripcion;
	}
	public String getid_grupo_cliente_descripcion() {
		return id_grupo_cliente_descripcion;
	}
	public String getid_tipo_forma_pago_descripcion() {
		return id_tipo_forma_pago_descripcion;
	}
	
	
	public void setid_empresa_descripcion(String newid_empresa_descripcion)throws Exception {
		try {
			this.id_empresa_descripcion=newid_empresa_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_grupo_cliente_descripcion(String newid_grupo_cliente_descripcion)throws Exception {
		try {
			this.id_grupo_cliente_descripcion=newid_grupo_cliente_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_tipo_forma_pago_descripcion(String newid_tipo_forma_pago_descripcion)throws Exception {
		try {
			this.id_tipo_forma_pago_descripcion=newid_tipo_forma_pago_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	
	public void inicializarVariablesParaReporte() {
		this.id_empresa_descripcion="";this.id_grupo_cliente_descripcion="";this.id_tipo_forma_pago_descripcion="";
	}
	
	
	
	
	
	
	/*PARA REPORTES FIN*/		
}

