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
//import com.bydan.erp.contabilidad.util.CentroCostoConstantesFunciones;
import com.bydan.erp.contabilidad.util.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.importaciones.util.*;
import com.bydan.erp.nomina.util.*;
import com.bydan.erp.contabilidad.util.*;
import com.bydan.erp.tesoreria.util.*;
import com.bydan.erp.cartera.util.*;
import com.bydan.erp.facturacion.util.*;
import com.bydan.erp.inventario.util.*;
import com.bydan.erp.comisiones.util.*;
import com.bydan.erp.activosfijos.util.*;



import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.importaciones.business.entity.*;
import com.bydan.erp.nomina.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.tesoreria.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;
import com.bydan.erp.facturacion.business.entity.*;
import com.bydan.erp.inventario.business.entity.*;
import com.bydan.erp.comisiones.business.entity.*;
import com.bydan.erp.activosfijos.business.entity.*;




@SuppressWarnings("unused")
public class CentroCosto extends CentroCostoAdditional implements Serializable ,Cloneable {//CentroCostoAdditional,GeneralEntity
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
	
	private CentroCosto centrocostoOriginal;
	
	private Map<String, Object> mapCentroCosto;
			
	public Map<String, Object> getMapCentroCosto() {
		return mapCentroCosto;
	}

	public void setMapCentroCosto(Map<String, Object> mapCentroCosto) {
		this.mapCentroCosto = mapCentroCosto;
	}
	
	public void inicializarMapCentroCosto() {
		this.mapCentroCosto = new HashMap<String,Object>();
	}
	
	public void setMapCentroCostoValue(String sKey,Object oValue) {
		this.mapCentroCosto.put(sKey, oValue);
	}
	
	public Object getMapCentroCostoValue(String sKey) {
		return this.mapCentroCosto.get(sKey);
	}
	
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_empresa;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=50,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=CentroCostoConstantesFunciones.SREGEXCODIGO,message=CentroCostoConstantesFunciones.SMENSAJEREGEXCODIGO)
	private String codigo;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=150,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=CentroCostoConstantesFunciones.SREGEXNOMBRE,message=CentroCostoConstantesFunciones.SMENSAJEREGEXNOMBRE)
	private String nombre;
	
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	private Long id_centro_costo;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double porcentaje;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double valor;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=10,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONINT)
	private Integer orden;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Boolean es_final;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=200,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@Pattern(regex=CentroCostoConstantesFunciones.SREGEXDESCRIPCION,message=CentroCostoConstantesFunciones.SMENSAJEREGEXDESCRIPCION)
	private String descripcion;
			
	
	public Empresa empresa;
	public CentroCosto centrocosto;
	
	
	private String empresa_descripcion;
	private String centrocosto_descripcion;
	
	
		
	public CentroCosto () throws Exception {
		super();		
		
		this.id=0L;
		
		
		this.versionRow=new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());//new Date();
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		this.sType="NONE";
		
		this.centrocostoOriginal=this;
		
 		this.id_empresa=-1L;
 		this.codigo="";
 		this.nombre="";
 		this.id_centro_costo=null;
 		this.porcentaje=0.0;
 		this.valor=0.0;
 		this.orden=0;
 		this.es_final=false;
 		this.descripcion="";
		
		
		this.empresa=null;
		
		
		this.empresa_descripcion="";
		
		
		
			
		
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
    //PARA REPORTES
	public CentroCosto (Long id,Date versionRow,Long id_empresa,String codigo,String nombre,Long id_centro_costo,Double porcentaje,Double valor,Integer orden,Boolean es_final,String descripcion) throws Exception {
		super();		
		
		this.id=id;
		this.versionRow=versionRow;
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.centrocostoOriginal=this;
		
 		this.id_empresa=id_empresa;
 		this.codigo=codigo;
 		this.nombre=nombre;
 		this.id_centro_costo=id_centro_costo;
 		this.porcentaje=porcentaje;
 		this.valor=valor;
 		this.orden=orden;
 		this.es_final=es_final;
 		this.descripcion=descripcion;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	 //PARA REPORTES
	public CentroCosto (Long id_empresa,String codigo,String nombre,Long id_centro_costo,Double porcentaje,Double valor,Integer orden,Boolean es_final,String descripcion) throws Exception {
		super();		
		
		this.id=0L;
		this.versionRow=new Date();
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.centrocostoOriginal=this;
		
 		this.id_empresa=id_empresa;
 		this.codigo=codigo;
 		this.nombre=nombre;
 		this.id_centro_costo=id_centro_costo;
 		this.porcentaje=porcentaje;
 		this.valor=valor;
 		this.orden=orden;
 		this.es_final=es_final;
 		this.descripcion=descripcion;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	public boolean equals(Object object) {
		boolean equal=false;
		CentroCosto centrocostoLocal=null;
		
		if(object!=null) {
			centrocostoLocal=(CentroCosto)object;
			
			if(centrocostoLocal!=null) {
				if(this.getId()!=null && centrocostoLocal.getId()!=null) {
					if(this.getId().equals(centrocostoLocal.getId())) {
						equal=true;
					}
				}
			}
		}
		
		return equal;
	}
	
	public String toString() {
		String sDetalle="";
		
		if(!CentroCostoConstantesFunciones.CON_DESCRIPCION_DETALLADO) {
        	sDetalle=CentroCostoConstantesFunciones.getCentroCostoDescripcion(this);
		} else {
			sDetalle=CentroCostoConstantesFunciones.getCentroCostoDescripcionDetallado(this);
		}
		
		return sDetalle;
    }
	
	public CentroCosto getCentroCostoOriginal() {
		return this.centrocostoOriginal;
	}
	
	public void setCentroCostoOriginal(CentroCosto centrocosto) {
		try {
			this.centrocostoOriginal=centrocosto;
		} catch(Exception e) {
			;
		}
	}
	
	
	protected CentroCostoAdditional centrocostoAdditional=null;
	
	public CentroCostoAdditional getCentroCostoAdditional() {
		return this.centrocostoAdditional;
	}
	
	public void setCentroCostoAdditional(CentroCostoAdditional centrocostoAdditional) {
		try {
			this.centrocostoAdditional=centrocostoAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
    
	
	public Long getid_empresa() {
		return this.id_empresa;
	}
    
	
	public String getcodigo() {
		return this.codigo;
	}
    
	
	public String getnombre() {
		return this.nombre;
	}
    
	
	public Long getid_centro_costo() {
		return this.id_centro_costo;
	}
    
	
	public Double getporcentaje() {
		return this.porcentaje;
	}
    
	
	public Double getvalor() {
		return this.valor;
	}
    
	
	public Integer getorden() {
		return this.orden;
	}
    
	
	public Boolean getes_final() {
		return this.es_final;
	}
    
	
	public String getdescripcion() {
		return this.descripcion;
	}
	
    
	public void setid_empresa(Long newid_empresa)throws Exception
	{
		try {
			if(this.id_empresa!=newid_empresa) {
				if(newid_empresa==null) {
					//newid_empresa=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("CentroCosto:Valor nulo no permitido en columna id_empresa");
					}
				}

				this.id_empresa=newid_empresa;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setcodigo(String newcodigo)throws Exception
	{
		try {
			if(this.codigo!=newcodigo) {
				if(newcodigo==null) {
					//newcodigo="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("CentroCosto:Valor nulo no permitido en columna codigo");
					}
				}

				if(newcodigo!=null&&newcodigo.length()>50) {
					newcodigo=newcodigo.substring(0,48);
					System.out.println("CentroCosto:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=50 en columna codigo");
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
						System.out.println("CentroCosto:Valor nulo no permitido en columna nombre");
					}
				}

				if(newnombre!=null&&newnombre.length()>150) {
					newnombre=newnombre.substring(0,148);
					System.out.println("CentroCosto:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=150 en columna nombre");
				}

				this.nombre=newnombre;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_centro_costo(Long newid_centro_costo) {
		if(this.id_centro_costo==null&&newid_centro_costo!=null) {
			this.id_centro_costo=newid_centro_costo;
				this.setIsChanged(true);
		}

		if(this.id_centro_costo!=null&&!this.id_centro_costo.equals(newid_centro_costo)) {

			this.id_centro_costo=newid_centro_costo;
				this.setIsChanged(true);
		}
	}
    
	public void setporcentaje(Double newporcentaje)throws Exception
	{
		try {
			if(this.porcentaje!=newporcentaje) {
				if(newporcentaje==null) {
					//newporcentaje=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("CentroCosto:Valor nulo no permitido en columna porcentaje");
					}
				}

				this.porcentaje=newporcentaje;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setvalor(Double newvalor)throws Exception
	{
		try {
			if(this.valor!=newvalor) {
				if(newvalor==null) {
					//newvalor=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("CentroCosto:Valor nulo no permitido en columna valor");
					}
				}

				this.valor=newvalor;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setorden(Integer neworden)throws Exception
	{
		try {
			if(this.orden!=neworden) {
				if(neworden==null) {
					//neworden=0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("CentroCosto:Valor nulo no permitido en columna orden");
					}
				}

				this.orden=neworden;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setes_final(Boolean newes_final)throws Exception
	{
		try {
			if(this.es_final!=newes_final) {
				if(newes_final==null) {
					//newes_final=false;
					if(Constantes.ISDEVELOPING) {
						System.out.println("CentroCosto:Valor nulo no permitido en columna es_final");
					}
				}

				this.es_final=newes_final;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setdescripcion(String newdescripcion)throws Exception
	{
		try {
			if(this.descripcion!=newdescripcion) {
				if(newdescripcion==null) {
					//newdescripcion="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("CentroCosto:Valor nulo no permitido en columna descripcion");
					}
				}

				if(newdescripcion!=null&&newdescripcion.length()>200) {
					newdescripcion=newdescripcion.substring(0,198);
					System.out.println("CentroCosto:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=200 en columna descripcion");
				}

				this.descripcion=newdescripcion;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	
	public Empresa getEmpresa() {
		return this.empresa;
	}

	public CentroCosto getCentroCosto() {
		return this.centrocosto;
	}

	
	
	public String getempresa_descripcion() {
		return this.empresa_descripcion;
	}

	public String getcentrocosto_descripcion() {
		return this.centrocosto_descripcion;
	}

	
	
	public  void  setEmpresa(Empresa empresa) {
		try {
			this.empresa=empresa;
		} catch(Exception e) {
			;
		}
	}


	public  void  setCentroCosto(CentroCosto centrocosto) {
		try {
			this.centrocosto=centrocosto;
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


	public  void  setcentrocosto_descripcion(String centrocosto_descripcion) {
		try {
			this.centrocosto_descripcion=centrocosto_descripcion;
		} catch(Exception e) {
			;
		}
	}


	
	
	
	
	
	/*PARA REPORTES*/
	String id_empresa_descripcion="";String id_centro_costo_descripcion="";String es_final_descripcion="";
	
	
	public String getid_empresa_descripcion() {
		return id_empresa_descripcion;
	}
	public String getid_centro_costo_descripcion() {
		return id_centro_costo_descripcion;
	}
	public String getes_final_descripcion() {
		return es_final_descripcion;
	}
	
	
	public void setid_empresa_descripcion(String newid_empresa_descripcion)throws Exception {
		try {
			this.id_empresa_descripcion=newid_empresa_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_centro_costo_descripcion(String newid_centro_costo_descripcion) {
		this.id_centro_costo_descripcion=newid_centro_costo_descripcion;
	}
	public void setes_final_descripcion(String newes_final_descripcion)throws Exception {
		try {
			this.es_final_descripcion=newes_final_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	
	public void inicializarVariablesParaReporte() {
		this.id_empresa_descripcion="";this.id_centro_costo_descripcion="";this.es_final_descripcion="";
	}
	
	
	Object parametroimporsDescripcionReporte;
	Object empleadosDescripcionReporte;
	Object notacreditosolisDescripcionReporte;
	Object detalleasientocontablesDescripcionReporte;
	Object bodegasDescripcionReporte;
	Object detanotacreditosolisDescripcionReporte;
	Object pedidoexporsDescripcionReporte;
	Object presupuestoflujocajasDescripcionReporte;
	Object notacreditosDescripcionReporte;
	Object pedidosDescripcionReporte;
	Object detallecomprasDescripcionReporte;
	Object gastodepreciacioncentrocostosDescripcionReporte;
	Object detalleguiaremisionsDescripcionReporte;
	Object liquidacionimporsDescripcionReporte;
	Object bodegaproductosDescripcionReporte;
	Object detalleasientocontablecajachicasDescripcionReporte;
	Object centrocostogrupoproductosDescripcionReporte;
	Object detallemovimientoinventariosDescripcionReporte;
	Object detallepedidocompraimporsDescripcionReporte;
	Object presuproyectosDescripcionReporte;
	Object productocuentacontablesDescripcionReporte;
	Object centrocostoestructurasDescripcionReporte;
	Object detallefacturasDescripcionReporte;
	Object centrocostosDescripcionReporte;
	Object detalleproformasDescripcionReporte;
	Object detalleserviciotransportesDescripcionReporte;
	Object cuentacontablesDescripcionReporte;
	Object grupoclientesDescripcionReporte;
	Object centrocostovalorsDescripcionReporte;
	Object detalleliquidacionimporsDescripcionReporte;
	Object detallepedidocomprasDescripcionReporte;
	Object presupuestoflujocajatsrsDescripcionReporte;
	Object cuentascontableslineaproductosDescripcionReporte;
	Object detallefacturaproveedorsDescripcionReporte;
	Object autoripagosDescripcionReporte;
	Object detallerequisicioncomprasDescripcionReporte;
	Object asistenciaporcentrocostosDescripcionReporte;
	Object grupobodegasDescripcionReporte;
	Object proformasDescripcionReporte;
	Object detanotacreditosDescripcionReporte;
	Object consignacionsDescripcionReporte;
	Object pagoautosDescripcionReporte;
	
	
	public Object getparametroimporsDescripcionReporte() {
		return parametroimporsDescripcionReporte;
	}

	public Object getempleadosDescripcionReporte() {
		return empleadosDescripcionReporte;
	}

	public Object getnotacreditosolisDescripcionReporte() {
		return notacreditosolisDescripcionReporte;
	}

	public Object getdetalleasientocontablesDescripcionReporte() {
		return detalleasientocontablesDescripcionReporte;
	}

	public Object getbodegasDescripcionReporte() {
		return bodegasDescripcionReporte;
	}

	public Object getdetanotacreditosolisDescripcionReporte() {
		return detanotacreditosolisDescripcionReporte;
	}

	public Object getpedidoexporsDescripcionReporte() {
		return pedidoexporsDescripcionReporte;
	}

	public Object getpresupuestoflujocajasDescripcionReporte() {
		return presupuestoflujocajasDescripcionReporte;
	}

	public Object getnotacreditosDescripcionReporte() {
		return notacreditosDescripcionReporte;
	}

	public Object getpedidosDescripcionReporte() {
		return pedidosDescripcionReporte;
	}

	public Object getdetallecomprasDescripcionReporte() {
		return detallecomprasDescripcionReporte;
	}

	public Object getgastodepreciacioncentrocostosDescripcionReporte() {
		return gastodepreciacioncentrocostosDescripcionReporte;
	}

	public Object getdetalleguiaremisionsDescripcionReporte() {
		return detalleguiaremisionsDescripcionReporte;
	}

	public Object getliquidacionimporsDescripcionReporte() {
		return liquidacionimporsDescripcionReporte;
	}

	public Object getbodegaproductosDescripcionReporte() {
		return bodegaproductosDescripcionReporte;
	}

	public Object getdetalleasientocontablecajachicasDescripcionReporte() {
		return detalleasientocontablecajachicasDescripcionReporte;
	}

	public Object getcentrocostogrupoproductosDescripcionReporte() {
		return centrocostogrupoproductosDescripcionReporte;
	}

	public Object getdetallemovimientoinventariosDescripcionReporte() {
		return detallemovimientoinventariosDescripcionReporte;
	}

	public Object getdetallepedidocompraimporsDescripcionReporte() {
		return detallepedidocompraimporsDescripcionReporte;
	}

	public Object getpresuproyectosDescripcionReporte() {
		return presuproyectosDescripcionReporte;
	}

	public Object getproductocuentacontablesDescripcionReporte() {
		return productocuentacontablesDescripcionReporte;
	}

	public Object getcentrocostoestructurasDescripcionReporte() {
		return centrocostoestructurasDescripcionReporte;
	}

	public Object getdetallefacturasDescripcionReporte() {
		return detallefacturasDescripcionReporte;
	}

	public Object getcentrocostosDescripcionReporte() {
		return centrocostosDescripcionReporte;
	}

	public Object getdetalleproformasDescripcionReporte() {
		return detalleproformasDescripcionReporte;
	}

	public Object getdetalleserviciotransportesDescripcionReporte() {
		return detalleserviciotransportesDescripcionReporte;
	}

	public Object getcuentacontablesDescripcionReporte() {
		return cuentacontablesDescripcionReporte;
	}

	public Object getgrupoclientesDescripcionReporte() {
		return grupoclientesDescripcionReporte;
	}

	public Object getcentrocostovalorsDescripcionReporte() {
		return centrocostovalorsDescripcionReporte;
	}

	public Object getdetalleliquidacionimporsDescripcionReporte() {
		return detalleliquidacionimporsDescripcionReporte;
	}

	public Object getdetallepedidocomprasDescripcionReporte() {
		return detallepedidocomprasDescripcionReporte;
	}

	public Object getpresupuestoflujocajatsrsDescripcionReporte() {
		return presupuestoflujocajatsrsDescripcionReporte;
	}

	public Object getcuentascontableslineaproductosDescripcionReporte() {
		return cuentascontableslineaproductosDescripcionReporte;
	}

	public Object getdetallefacturaproveedorsDescripcionReporte() {
		return detallefacturaproveedorsDescripcionReporte;
	}

	public Object getautoripagosDescripcionReporte() {
		return autoripagosDescripcionReporte;
	}

	public Object getdetallerequisicioncomprasDescripcionReporte() {
		return detallerequisicioncomprasDescripcionReporte;
	}

	public Object getasistenciaporcentrocostosDescripcionReporte() {
		return asistenciaporcentrocostosDescripcionReporte;
	}

	public Object getgrupobodegasDescripcionReporte() {
		return grupobodegasDescripcionReporte;
	}

	public Object getproformasDescripcionReporte() {
		return proformasDescripcionReporte;
	}

	public Object getdetanotacreditosDescripcionReporte() {
		return detanotacreditosDescripcionReporte;
	}

	public Object getconsignacionsDescripcionReporte() {
		return consignacionsDescripcionReporte;
	}

	public Object getpagoautosDescripcionReporte() {
		return pagoautosDescripcionReporte;
	}

	
	
	public  void  setparametroimporsDescripcionReporte(Object parametroimpors) {
		try {
			this.parametroimporsDescripcionReporte=parametroimpors;
		} catch(Exception ex) {
			;
		}
	}

	public  void  setempleadosDescripcionReporte(Object empleados) {
		try {
			this.empleadosDescripcionReporte=empleados;
		} catch(Exception ex) {
			;
		}
	}

	public  void  setnotacreditosolisDescripcionReporte(Object notacreditosolis) {
		try {
			this.notacreditosolisDescripcionReporte=notacreditosolis;
		} catch(Exception ex) {
			;
		}
	}

	public  void  setdetalleasientocontablesDescripcionReporte(Object detalleasientocontables) {
		try {
			this.detalleasientocontablesDescripcionReporte=detalleasientocontables;
		} catch(Exception ex) {
			;
		}
	}

	public  void  setbodegasDescripcionReporte(Object bodegas) {
		try {
			this.bodegasDescripcionReporte=bodegas;
		} catch(Exception ex) {
			;
		}
	}

	public  void  setdetanotacreditosolisDescripcionReporte(Object detanotacreditosolis) {
		try {
			this.detanotacreditosolisDescripcionReporte=detanotacreditosolis;
		} catch(Exception ex) {
			;
		}
	}

	public  void  setpedidoexporsDescripcionReporte(Object pedidoexpors) {
		try {
			this.pedidoexporsDescripcionReporte=pedidoexpors;
		} catch(Exception ex) {
			;
		}
	}

	public  void  setpresupuestoflujocajasDescripcionReporte(Object presupuestoflujocajas) {
		try {
			this.presupuestoflujocajasDescripcionReporte=presupuestoflujocajas;
		} catch(Exception ex) {
			;
		}
	}

	public  void  setnotacreditosDescripcionReporte(Object notacreditos) {
		try {
			this.notacreditosDescripcionReporte=notacreditos;
		} catch(Exception ex) {
			;
		}
	}

	public  void  setpedidosDescripcionReporte(Object pedidos) {
		try {
			this.pedidosDescripcionReporte=pedidos;
		} catch(Exception ex) {
			;
		}
	}

	public  void  setdetallecomprasDescripcionReporte(Object detallecompras) {
		try {
			this.detallecomprasDescripcionReporte=detallecompras;
		} catch(Exception ex) {
			;
		}
	}

	public  void  setgastodepreciacioncentrocostosDescripcionReporte(Object gastodepreciacioncentrocostos) {
		try {
			this.gastodepreciacioncentrocostosDescripcionReporte=gastodepreciacioncentrocostos;
		} catch(Exception ex) {
			;
		}
	}

	public  void  setdetalleguiaremisionsDescripcionReporte(Object detalleguiaremisions) {
		try {
			this.detalleguiaremisionsDescripcionReporte=detalleguiaremisions;
		} catch(Exception ex) {
			;
		}
	}

	public  void  setliquidacionimporsDescripcionReporte(Object liquidacionimpors) {
		try {
			this.liquidacionimporsDescripcionReporte=liquidacionimpors;
		} catch(Exception ex) {
			;
		}
	}

	public  void  setbodegaproductosDescripcionReporte(Object bodegaproductos) {
		try {
			this.bodegaproductosDescripcionReporte=bodegaproductos;
		} catch(Exception ex) {
			;
		}
	}

	public  void  setdetalleasientocontablecajachicasDescripcionReporte(Object detalleasientocontablecajachicas) {
		try {
			this.detalleasientocontablecajachicasDescripcionReporte=detalleasientocontablecajachicas;
		} catch(Exception ex) {
			;
		}
	}

	public  void  setcentrocostogrupoproductosDescripcionReporte(Object centrocostogrupoproductos) {
		try {
			this.centrocostogrupoproductosDescripcionReporte=centrocostogrupoproductos;
		} catch(Exception ex) {
			;
		}
	}

	public  void  setdetallemovimientoinventariosDescripcionReporte(Object detallemovimientoinventarios) {
		try {
			this.detallemovimientoinventariosDescripcionReporte=detallemovimientoinventarios;
		} catch(Exception ex) {
			;
		}
	}

	public  void  setdetallepedidocompraimporsDescripcionReporte(Object detallepedidocompraimpors) {
		try {
			this.detallepedidocompraimporsDescripcionReporte=detallepedidocompraimpors;
		} catch(Exception ex) {
			;
		}
	}

	public  void  setpresuproyectosDescripcionReporte(Object presuproyectos) {
		try {
			this.presuproyectosDescripcionReporte=presuproyectos;
		} catch(Exception ex) {
			;
		}
	}

	public  void  setproductocuentacontablesDescripcionReporte(Object productocuentacontables) {
		try {
			this.productocuentacontablesDescripcionReporte=productocuentacontables;
		} catch(Exception ex) {
			;
		}
	}

	public  void  setcentrocostoestructurasDescripcionReporte(Object centrocostoestructuras) {
		try {
			this.centrocostoestructurasDescripcionReporte=centrocostoestructuras;
		} catch(Exception ex) {
			;
		}
	}

	public  void  setdetallefacturasDescripcionReporte(Object detallefacturas) {
		try {
			this.detallefacturasDescripcionReporte=detallefacturas;
		} catch(Exception ex) {
			;
		}
	}

	public  void  setcentrocostosDescripcionReporte(Object centrocostos) {
		try {
			this.centrocostosDescripcionReporte=centrocostos;
		} catch(Exception ex) {
			;
		}
	}

	public  void  setdetalleproformasDescripcionReporte(Object detalleproformas) {
		try {
			this.detalleproformasDescripcionReporte=detalleproformas;
		} catch(Exception ex) {
			;
		}
	}

	public  void  setdetalleserviciotransportesDescripcionReporte(Object detalleserviciotransportes) {
		try {
			this.detalleserviciotransportesDescripcionReporte=detalleserviciotransportes;
		} catch(Exception ex) {
			;
		}
	}

	public  void  setcuentacontablesDescripcionReporte(Object cuentacontables) {
		try {
			this.cuentacontablesDescripcionReporte=cuentacontables;
		} catch(Exception ex) {
			;
		}
	}

	public  void  setgrupoclientesDescripcionReporte(Object grupoclientes) {
		try {
			this.grupoclientesDescripcionReporte=grupoclientes;
		} catch(Exception ex) {
			;
		}
	}

	public  void  setcentrocostovalorsDescripcionReporte(Object centrocostovalors) {
		try {
			this.centrocostovalorsDescripcionReporte=centrocostovalors;
		} catch(Exception ex) {
			;
		}
	}

	public  void  setdetalleliquidacionimporsDescripcionReporte(Object detalleliquidacionimpors) {
		try {
			this.detalleliquidacionimporsDescripcionReporte=detalleliquidacionimpors;
		} catch(Exception ex) {
			;
		}
	}

	public  void  setdetallepedidocomprasDescripcionReporte(Object detallepedidocompras) {
		try {
			this.detallepedidocomprasDescripcionReporte=detallepedidocompras;
		} catch(Exception ex) {
			;
		}
	}

	public  void  setpresupuestoflujocajatsrsDescripcionReporte(Object presupuestoflujocajatsrs) {
		try {
			this.presupuestoflujocajatsrsDescripcionReporte=presupuestoflujocajatsrs;
		} catch(Exception ex) {
			;
		}
	}

	public  void  setcuentascontableslineaproductosDescripcionReporte(Object cuentascontableslineaproductos) {
		try {
			this.cuentascontableslineaproductosDescripcionReporte=cuentascontableslineaproductos;
		} catch(Exception ex) {
			;
		}
	}

	public  void  setdetallefacturaproveedorsDescripcionReporte(Object detallefacturaproveedors) {
		try {
			this.detallefacturaproveedorsDescripcionReporte=detallefacturaproveedors;
		} catch(Exception ex) {
			;
		}
	}

	public  void  setautoripagosDescripcionReporte(Object autoripagos) {
		try {
			this.autoripagosDescripcionReporte=autoripagos;
		} catch(Exception ex) {
			;
		}
	}

	public  void  setdetallerequisicioncomprasDescripcionReporte(Object detallerequisicioncompras) {
		try {
			this.detallerequisicioncomprasDescripcionReporte=detallerequisicioncompras;
		} catch(Exception ex) {
			;
		}
	}

	public  void  setasistenciaporcentrocostosDescripcionReporte(Object asistenciaporcentrocostos) {
		try {
			this.asistenciaporcentrocostosDescripcionReporte=asistenciaporcentrocostos;
		} catch(Exception ex) {
			;
		}
	}

	public  void  setgrupobodegasDescripcionReporte(Object grupobodegas) {
		try {
			this.grupobodegasDescripcionReporte=grupobodegas;
		} catch(Exception ex) {
			;
		}
	}

	public  void  setproformasDescripcionReporte(Object proformas) {
		try {
			this.proformasDescripcionReporte=proformas;
		} catch(Exception ex) {
			;
		}
	}

	public  void  setdetanotacreditosDescripcionReporte(Object detanotacreditos) {
		try {
			this.detanotacreditosDescripcionReporte=detanotacreditos;
		} catch(Exception ex) {
			;
		}
	}

	public  void  setconsignacionsDescripcionReporte(Object consignacions) {
		try {
			this.consignacionsDescripcionReporte=consignacions;
		} catch(Exception ex) {
			;
		}
	}

	public  void  setpagoautosDescripcionReporte(Object pagoautos) {
		try {
			this.pagoautosDescripcionReporte=pagoautos;
		} catch(Exception ex) {
			;
		}
	}

	/*PARA REPORTES FIN*/		
}

