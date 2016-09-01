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
//import com.bydan.erp.facturacion.util.VisibleFacturaConstantesFunciones;
import com.bydan.erp.facturacion.util.*;


import com.bydan.erp.seguridad.util.*;



import com.bydan.erp.seguridad.business.entity.*;




@SuppressWarnings("unused")
public class VisibleFactura extends VisibleFacturaAdditional implements Serializable ,Cloneable {//VisibleFacturaAdditional,GeneralEntity
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
	
	private VisibleFactura visiblefacturaOriginal;
	
	private Map<String, Object> mapVisibleFactura;
			
	public Map<String, Object> getMapVisibleFactura() {
		return mapVisibleFactura;
	}

	public void setMapVisibleFactura(Map<String, Object> mapVisibleFactura) {
		this.mapVisibleFactura = mapVisibleFactura;
	}
	
	public void inicializarMapVisibleFactura() {
		this.mapVisibleFactura = new HashMap<String,Object>();
	}
	
	public void setMapVisibleFacturaValue(String sKey,Object oValue) {
		this.mapVisibleFactura.put(sKey, oValue);
	}
	
	public Object getMapVisibleFacturaValue(String sKey) {
		return this.mapVisibleFactura.get(sKey);
	}
	
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_empresa;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Boolean cabe_consignatario;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Boolean cabe_tipo_tasa;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Boolean cabe_consultor;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Boolean cabe_ice;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Boolean cabe_transporte;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Boolean cabe_fue;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Boolean cabe_orden;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Boolean deta_autori_precio;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Boolean deta_area;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Boolean deta_foto;
			
	
	public Empresa empresa;
	
	
	private String empresa_descripcion;
	
	
		
	public VisibleFactura () throws Exception {
		super();		
		
		this.id=0L;
		
		
		this.versionRow=new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());//new Date();
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		this.sType="NONE";
		
		this.visiblefacturaOriginal=this;
		
 		this.id_empresa=-1L;
 		this.cabe_consignatario=false;
 		this.cabe_tipo_tasa=false;
 		this.cabe_consultor=false;
 		this.cabe_ice=false;
 		this.cabe_transporte=false;
 		this.cabe_fue=false;
 		this.cabe_orden=false;
 		this.deta_autori_precio=false;
 		this.deta_area=false;
 		this.deta_foto=false;
		
		
		this.empresa=null;
		
		
		this.empresa_descripcion="";
		
		
		
			
		
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
    //PARA REPORTES
	public VisibleFactura (Long id,Date versionRow,Long id_empresa,Boolean cabe_consignatario,Boolean cabe_tipo_tasa,Boolean cabe_consultor,Boolean cabe_ice,Boolean cabe_transporte,Boolean cabe_fue,Boolean cabe_orden,Boolean deta_autori_precio,Boolean deta_area,Boolean deta_foto) throws Exception {
		super();		
		
		this.id=id;
		this.versionRow=versionRow;
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.visiblefacturaOriginal=this;
		
 		this.id_empresa=id_empresa;
 		this.cabe_consignatario=cabe_consignatario;
 		this.cabe_tipo_tasa=cabe_tipo_tasa;
 		this.cabe_consultor=cabe_consultor;
 		this.cabe_ice=cabe_ice;
 		this.cabe_transporte=cabe_transporte;
 		this.cabe_fue=cabe_fue;
 		this.cabe_orden=cabe_orden;
 		this.deta_autori_precio=deta_autori_precio;
 		this.deta_area=deta_area;
 		this.deta_foto=deta_foto;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	 //PARA REPORTES
	public VisibleFactura (Long id_empresa,Boolean cabe_consignatario,Boolean cabe_tipo_tasa,Boolean cabe_consultor,Boolean cabe_ice,Boolean cabe_transporte,Boolean cabe_fue,Boolean cabe_orden,Boolean deta_autori_precio,Boolean deta_area,Boolean deta_foto) throws Exception {
		super();		
		
		this.id=0L;
		this.versionRow=new Date();
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.visiblefacturaOriginal=this;
		
 		this.id_empresa=id_empresa;
 		this.cabe_consignatario=cabe_consignatario;
 		this.cabe_tipo_tasa=cabe_tipo_tasa;
 		this.cabe_consultor=cabe_consultor;
 		this.cabe_ice=cabe_ice;
 		this.cabe_transporte=cabe_transporte;
 		this.cabe_fue=cabe_fue;
 		this.cabe_orden=cabe_orden;
 		this.deta_autori_precio=deta_autori_precio;
 		this.deta_area=deta_area;
 		this.deta_foto=deta_foto;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	public boolean equals(Object object) {
		boolean equal=false;
		VisibleFactura visiblefacturaLocal=null;
		
		if(object!=null) {
			visiblefacturaLocal=(VisibleFactura)object;
			
			if(visiblefacturaLocal!=null) {
				if(this.getId()!=null && visiblefacturaLocal.getId()!=null) {
					if(this.getId().equals(visiblefacturaLocal.getId())) {
						equal=true;
					}
				}
			}
		}
		
		return equal;
	}
	
	public String toString() {
		String sDetalle="";
		
		if(!VisibleFacturaConstantesFunciones.CON_DESCRIPCION_DETALLADO) {
        	sDetalle=VisibleFacturaConstantesFunciones.getVisibleFacturaDescripcion(this);
		} else {
			sDetalle=VisibleFacturaConstantesFunciones.getVisibleFacturaDescripcionDetallado(this);
		}
		
		return sDetalle;
    }
	
	public VisibleFactura getVisibleFacturaOriginal() {
		return this.visiblefacturaOriginal;
	}
	
	public void setVisibleFacturaOriginal(VisibleFactura visiblefactura) {
		try {
			this.visiblefacturaOriginal=visiblefactura;
		} catch(Exception e) {
			;
		}
	}
	
	
	protected VisibleFacturaAdditional visiblefacturaAdditional=null;
	
	public VisibleFacturaAdditional getVisibleFacturaAdditional() {
		return this.visiblefacturaAdditional;
	}
	
	public void setVisibleFacturaAdditional(VisibleFacturaAdditional visiblefacturaAdditional) {
		try {
			this.visiblefacturaAdditional=visiblefacturaAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
    
	
	public Long getid_empresa() {
		return this.id_empresa;
	}
    
	
	public Boolean getcabe_consignatario() {
		return this.cabe_consignatario;
	}
    
	
	public Boolean getcabe_tipo_tasa() {
		return this.cabe_tipo_tasa;
	}
    
	
	public Boolean getcabe_consultor() {
		return this.cabe_consultor;
	}
    
	
	public Boolean getcabe_ice() {
		return this.cabe_ice;
	}
    
	
	public Boolean getcabe_transporte() {
		return this.cabe_transporte;
	}
    
	
	public Boolean getcabe_fue() {
		return this.cabe_fue;
	}
    
	
	public Boolean getcabe_orden() {
		return this.cabe_orden;
	}
    
	
	public Boolean getdeta_autori_precio() {
		return this.deta_autori_precio;
	}
    
	
	public Boolean getdeta_area() {
		return this.deta_area;
	}
    
	
	public Boolean getdeta_foto() {
		return this.deta_foto;
	}
	
    
	public void setid_empresa(Long newid_empresa)throws Exception
	{
		try {
			if(this.id_empresa!=newid_empresa) {
				if(newid_empresa==null) {
					//newid_empresa=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("VisibleFactura:Valor nulo no permitido en columna id_empresa");
					}
				}

				this.id_empresa=newid_empresa;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setcabe_consignatario(Boolean newcabe_consignatario)throws Exception
	{
		try {
			if(this.cabe_consignatario!=newcabe_consignatario) {
				if(newcabe_consignatario==null) {
					//newcabe_consignatario=false;
					if(Constantes.ISDEVELOPING) {
						System.out.println("VisibleFactura:Valor nulo no permitido en columna cabe_consignatario");
					}
				}

				this.cabe_consignatario=newcabe_consignatario;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setcabe_tipo_tasa(Boolean newcabe_tipo_tasa)throws Exception
	{
		try {
			if(this.cabe_tipo_tasa!=newcabe_tipo_tasa) {
				if(newcabe_tipo_tasa==null) {
					//newcabe_tipo_tasa=false;
					if(Constantes.ISDEVELOPING) {
						System.out.println("VisibleFactura:Valor nulo no permitido en columna cabe_tipo_tasa");
					}
				}

				this.cabe_tipo_tasa=newcabe_tipo_tasa;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setcabe_consultor(Boolean newcabe_consultor)throws Exception
	{
		try {
			if(this.cabe_consultor!=newcabe_consultor) {
				if(newcabe_consultor==null) {
					//newcabe_consultor=false;
					if(Constantes.ISDEVELOPING) {
						System.out.println("VisibleFactura:Valor nulo no permitido en columna cabe_consultor");
					}
				}

				this.cabe_consultor=newcabe_consultor;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setcabe_ice(Boolean newcabe_ice)throws Exception
	{
		try {
			if(this.cabe_ice!=newcabe_ice) {
				if(newcabe_ice==null) {
					//newcabe_ice=false;
					if(Constantes.ISDEVELOPING) {
						System.out.println("VisibleFactura:Valor nulo no permitido en columna cabe_ice");
					}
				}

				this.cabe_ice=newcabe_ice;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setcabe_transporte(Boolean newcabe_transporte)throws Exception
	{
		try {
			if(this.cabe_transporte!=newcabe_transporte) {
				if(newcabe_transporte==null) {
					//newcabe_transporte=false;
					if(Constantes.ISDEVELOPING) {
						System.out.println("VisibleFactura:Valor nulo no permitido en columna cabe_transporte");
					}
				}

				this.cabe_transporte=newcabe_transporte;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setcabe_fue(Boolean newcabe_fue)throws Exception
	{
		try {
			if(this.cabe_fue!=newcabe_fue) {
				if(newcabe_fue==null) {
					//newcabe_fue=false;
					if(Constantes.ISDEVELOPING) {
						System.out.println("VisibleFactura:Valor nulo no permitido en columna cabe_fue");
					}
				}

				this.cabe_fue=newcabe_fue;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setcabe_orden(Boolean newcabe_orden)throws Exception
	{
		try {
			if(this.cabe_orden!=newcabe_orden) {
				if(newcabe_orden==null) {
					//newcabe_orden=false;
					if(Constantes.ISDEVELOPING) {
						System.out.println("VisibleFactura:Valor nulo no permitido en columna cabe_orden");
					}
				}

				this.cabe_orden=newcabe_orden;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setdeta_autori_precio(Boolean newdeta_autori_precio)throws Exception
	{
		try {
			if(this.deta_autori_precio!=newdeta_autori_precio) {
				if(newdeta_autori_precio==null) {
					//newdeta_autori_precio=false;
					if(Constantes.ISDEVELOPING) {
						System.out.println("VisibleFactura:Valor nulo no permitido en columna deta_autori_precio");
					}
				}

				this.deta_autori_precio=newdeta_autori_precio;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setdeta_area(Boolean newdeta_area)throws Exception
	{
		try {
			if(this.deta_area!=newdeta_area) {
				if(newdeta_area==null) {
					//newdeta_area=false;
					if(Constantes.ISDEVELOPING) {
						System.out.println("VisibleFactura:Valor nulo no permitido en columna deta_area");
					}
				}

				this.deta_area=newdeta_area;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setdeta_foto(Boolean newdeta_foto)throws Exception
	{
		try {
			if(this.deta_foto!=newdeta_foto) {
				if(newdeta_foto==null) {
					//newdeta_foto=false;
					if(Constantes.ISDEVELOPING) {
						System.out.println("VisibleFactura:Valor nulo no permitido en columna deta_foto");
					}
				}

				this.deta_foto=newdeta_foto;
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


	
	
	
	
	
	/*PARA REPORTES*/
	String id_empresa_descripcion="";String cabe_consignatario_descripcion="";String cabe_tipo_tasa_descripcion="";String cabe_consultor_descripcion="";String cabe_ice_descripcion="";String cabe_transporte_descripcion="";String cabe_fue_descripcion="";String cabe_orden_descripcion="";String deta_autori_precio_descripcion="";String deta_area_descripcion="";String deta_foto_descripcion="";
	
	
	public String getid_empresa_descripcion() {
		return id_empresa_descripcion;
	}
	public String getcabe_consignatario_descripcion() {
		return cabe_consignatario_descripcion;
	}
	public String getcabe_tipo_tasa_descripcion() {
		return cabe_tipo_tasa_descripcion;
	}
	public String getcabe_consultor_descripcion() {
		return cabe_consultor_descripcion;
	}
	public String getcabe_ice_descripcion() {
		return cabe_ice_descripcion;
	}
	public String getcabe_transporte_descripcion() {
		return cabe_transporte_descripcion;
	}
	public String getcabe_fue_descripcion() {
		return cabe_fue_descripcion;
	}
	public String getcabe_orden_descripcion() {
		return cabe_orden_descripcion;
	}
	public String getdeta_autori_precio_descripcion() {
		return deta_autori_precio_descripcion;
	}
	public String getdeta_area_descripcion() {
		return deta_area_descripcion;
	}
	public String getdeta_foto_descripcion() {
		return deta_foto_descripcion;
	}
	
	
	public void setid_empresa_descripcion(String newid_empresa_descripcion)throws Exception {
		try {
			this.id_empresa_descripcion=newid_empresa_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setcabe_consignatario_descripcion(String newcabe_consignatario_descripcion)throws Exception {
		try {
			this.cabe_consignatario_descripcion=newcabe_consignatario_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setcabe_tipo_tasa_descripcion(String newcabe_tipo_tasa_descripcion)throws Exception {
		try {
			this.cabe_tipo_tasa_descripcion=newcabe_tipo_tasa_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setcabe_consultor_descripcion(String newcabe_consultor_descripcion)throws Exception {
		try {
			this.cabe_consultor_descripcion=newcabe_consultor_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setcabe_ice_descripcion(String newcabe_ice_descripcion)throws Exception {
		try {
			this.cabe_ice_descripcion=newcabe_ice_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setcabe_transporte_descripcion(String newcabe_transporte_descripcion)throws Exception {
		try {
			this.cabe_transporte_descripcion=newcabe_transporte_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setcabe_fue_descripcion(String newcabe_fue_descripcion)throws Exception {
		try {
			this.cabe_fue_descripcion=newcabe_fue_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setcabe_orden_descripcion(String newcabe_orden_descripcion)throws Exception {
		try {
			this.cabe_orden_descripcion=newcabe_orden_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setdeta_autori_precio_descripcion(String newdeta_autori_precio_descripcion)throws Exception {
		try {
			this.deta_autori_precio_descripcion=newdeta_autori_precio_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setdeta_area_descripcion(String newdeta_area_descripcion)throws Exception {
		try {
			this.deta_area_descripcion=newdeta_area_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setdeta_foto_descripcion(String newdeta_foto_descripcion)throws Exception {
		try {
			this.deta_foto_descripcion=newdeta_foto_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	
	public void inicializarVariablesParaReporte() {
		this.id_empresa_descripcion="";this.cabe_consignatario_descripcion="";this.cabe_tipo_tasa_descripcion="";this.cabe_consultor_descripcion="";this.cabe_ice_descripcion="";this.cabe_transporte_descripcion="";this.cabe_fue_descripcion="";this.cabe_orden_descripcion="";this.deta_autori_precio_descripcion="";this.deta_area_descripcion="";this.deta_foto_descripcion="";
	}
	
	
	
	
	
	
	/*PARA REPORTES FIN*/		
}

