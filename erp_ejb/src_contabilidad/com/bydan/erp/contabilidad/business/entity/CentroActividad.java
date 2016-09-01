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
//import com.bydan.erp.contabilidad.util.CentroActividadConstantesFunciones;
import com.bydan.erp.contabilidad.util.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.tesoreria.util.*;
import com.bydan.erp.cartera.util.*;
import com.bydan.erp.nomina.util.*;
import com.bydan.erp.contabilidad.util.*;
import com.bydan.erp.comisiones.util.*;
import com.bydan.erp.inventario.util.*;
import com.bydan.erp.sris.util.*;
import com.bydan.erp.facturacion.util.*;
import com.bydan.erp.puntoventa.util.*;
import com.bydan.erp.activosfijos.util.*;
import com.bydan.erp.importaciones.util.*;
import com.bydan.erp.produccion.util.*;



import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.tesoreria.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;
import com.bydan.erp.nomina.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.comisiones.business.entity.*;
import com.bydan.erp.inventario.business.entity.*;
import com.bydan.erp.sris.business.entity.*;
import com.bydan.erp.facturacion.business.entity.*;
import com.bydan.erp.puntoventa.business.entity.*;
import com.bydan.erp.activosfijos.business.entity.*;
import com.bydan.erp.importaciones.business.entity.*;
import com.bydan.erp.produccion.business.entity.*;




@SuppressWarnings("unused")
public class CentroActividad extends CentroActividadAdditional implements Serializable ,Cloneable {//CentroActividadAdditional,GeneralEntity
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
	
	private CentroActividad centroactividadOriginal;
	
	private Map<String, Object> mapCentroActividad;
			
	public Map<String, Object> getMapCentroActividad() {
		return mapCentroActividad;
	}

	public void setMapCentroActividad(Map<String, Object> mapCentroActividad) {
		this.mapCentroActividad = mapCentroActividad;
	}
	
	public void inicializarMapCentroActividad() {
		this.mapCentroActividad = new HashMap<String,Object>();
	}
	
	public void setMapCentroActividadValue(String sKey,Object oValue) {
		this.mapCentroActividad.put(sKey, oValue);
	}
	
	public Object getMapCentroActividadValue(String sKey) {
		return this.mapCentroActividad.get(sKey);
	}
	
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_empresa;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=50,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=CentroActividadConstantesFunciones.SREGEXCODIGO,message=CentroActividadConstantesFunciones.SMENSAJEREGEXCODIGO)
	private String codigo;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=100,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=CentroActividadConstantesFunciones.SREGEXNOMBRE,message=CentroActividadConstantesFunciones.SMENSAJEREGEXNOMBRE)
	private String nombre;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_tipo_movimiento;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_tipo_grupo_flujo_caja;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Boolean consolidado;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Boolean con_proyecto;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=150,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@Pattern(regex=CentroActividadConstantesFunciones.SREGEXOBSERVACION,message=CentroActividadConstantesFunciones.SMENSAJEREGEXOBSERVACION)
	private String observacion;
			
	
	public Empresa empresa;
	public TipoMovimiento tipomovimiento;
	public TipoGrupoFlujoCaja tipogrupoflujocaja;
	
	
	private String empresa_descripcion;
	private String tipomovimiento_descripcion;
	private String tipogrupoflujocaja_descripcion;
	
	
	public List<PagoAuto> pagoautos;
	public List<Cliente> clientes;
	public List<AutoriPago> autoripagos;
		
	public CentroActividad () throws Exception {
		super();		
		
		this.id=0L;
		
		
		this.versionRow=new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());//new Date();
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		this.sType="NONE";
		
		this.centroactividadOriginal=this;
		
 		this.id_empresa=-1L;
 		this.codigo="";
 		this.nombre="";
 		this.id_tipo_movimiento=-1L;
 		this.id_tipo_grupo_flujo_caja=-1L;
 		this.consolidado=false;
 		this.con_proyecto=false;
 		this.observacion="";
		
		
		this.empresa=null;
		this.tipomovimiento=null;
		this.tipogrupoflujocaja=null;
		
		
		this.empresa_descripcion="";
		this.tipomovimiento_descripcion="";
		this.tipogrupoflujocaja_descripcion="";
		
		
		this.pagoautos=null;
		this.clientes=null;
		this.autoripagos=null;
		
			
		
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
    //PARA REPORTES
	public CentroActividad (Long id,Date versionRow,Long id_empresa,String codigo,String nombre,Long id_tipo_movimiento,Long id_tipo_grupo_flujo_caja,Boolean consolidado,Boolean con_proyecto,String observacion) throws Exception {
		super();		
		
		this.id=id;
		this.versionRow=versionRow;
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.centroactividadOriginal=this;
		
 		this.id_empresa=id_empresa;
 		this.codigo=codigo;
 		this.nombre=nombre;
 		this.id_tipo_movimiento=id_tipo_movimiento;
 		this.id_tipo_grupo_flujo_caja=id_tipo_grupo_flujo_caja;
 		this.consolidado=consolidado;
 		this.con_proyecto=con_proyecto;
 		this.observacion=observacion;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	 //PARA REPORTES
	public CentroActividad (Long id_empresa,String codigo,String nombre,Long id_tipo_movimiento,Long id_tipo_grupo_flujo_caja,Boolean consolidado,Boolean con_proyecto,String observacion) throws Exception {
		super();		
		
		this.id=0L;
		this.versionRow=new Date();
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.centroactividadOriginal=this;
		
 		this.id_empresa=id_empresa;
 		this.codigo=codigo;
 		this.nombre=nombre;
 		this.id_tipo_movimiento=id_tipo_movimiento;
 		this.id_tipo_grupo_flujo_caja=id_tipo_grupo_flujo_caja;
 		this.consolidado=consolidado;
 		this.con_proyecto=con_proyecto;
 		this.observacion=observacion;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	public boolean equals(Object object) {
		boolean equal=false;
		CentroActividad centroactividadLocal=null;
		
		if(object!=null) {
			centroactividadLocal=(CentroActividad)object;
			
			if(centroactividadLocal!=null) {
				if(this.getId()!=null && centroactividadLocal.getId()!=null) {
					if(this.getId().equals(centroactividadLocal.getId())) {
						equal=true;
					}
				}
			}
		}
		
		return equal;
	}
	
	public String toString() {
		String sDetalle="";
		
		if(!CentroActividadConstantesFunciones.CON_DESCRIPCION_DETALLADO) {
        	sDetalle=CentroActividadConstantesFunciones.getCentroActividadDescripcion(this);
		} else {
			sDetalle=CentroActividadConstantesFunciones.getCentroActividadDescripcionDetallado(this);
		}
		
		return sDetalle;
    }
	
	public CentroActividad getCentroActividadOriginal() {
		return this.centroactividadOriginal;
	}
	
	public void setCentroActividadOriginal(CentroActividad centroactividad) {
		try {
			this.centroactividadOriginal=centroactividad;
		} catch(Exception e) {
			;
		}
	}
	
	
	protected CentroActividadAdditional centroactividadAdditional=null;
	
	public CentroActividadAdditional getCentroActividadAdditional() {
		return this.centroactividadAdditional;
	}
	
	public void setCentroActividadAdditional(CentroActividadAdditional centroactividadAdditional) {
		try {
			this.centroactividadAdditional=centroactividadAdditional;
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
    
	
	public Long getid_tipo_movimiento() {
		return this.id_tipo_movimiento;
	}
    
	
	public Long getid_tipo_grupo_flujo_caja() {
		return this.id_tipo_grupo_flujo_caja;
	}
    
	
	public Boolean getconsolidado() {
		return this.consolidado;
	}
    
	
	public Boolean getcon_proyecto() {
		return this.con_proyecto;
	}
    
	
	public String getobservacion() {
		return this.observacion;
	}
	
    
	public void setid_empresa(Long newid_empresa)throws Exception
	{
		try {
			if(this.id_empresa!=newid_empresa) {
				if(newid_empresa==null) {
					//newid_empresa=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("CentroActividad:Valor nulo no permitido en columna id_empresa");
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
						System.out.println("CentroActividad:Valor nulo no permitido en columna codigo");
					}
				}

				if(newcodigo!=null&&newcodigo.length()>50) {
					newcodigo=newcodigo.substring(0,48);
					System.out.println("CentroActividad:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=50 en columna codigo");
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
						System.out.println("CentroActividad:Valor nulo no permitido en columna nombre");
					}
				}

				if(newnombre!=null&&newnombre.length()>100) {
					newnombre=newnombre.substring(0,98);
					System.out.println("CentroActividad:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=100 en columna nombre");
				}

				this.nombre=newnombre;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_tipo_movimiento(Long newid_tipo_movimiento)throws Exception
	{
		try {
			if(this.id_tipo_movimiento!=newid_tipo_movimiento) {
				if(newid_tipo_movimiento==null) {
					//newid_tipo_movimiento=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("CentroActividad:Valor nulo no permitido en columna id_tipo_movimiento");
					}
				}

				this.id_tipo_movimiento=newid_tipo_movimiento;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_tipo_grupo_flujo_caja(Long newid_tipo_grupo_flujo_caja)throws Exception
	{
		try {
			if(this.id_tipo_grupo_flujo_caja!=newid_tipo_grupo_flujo_caja) {
				if(newid_tipo_grupo_flujo_caja==null) {
					//newid_tipo_grupo_flujo_caja=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("CentroActividad:Valor nulo no permitido en columna id_tipo_grupo_flujo_caja");
					}
				}

				this.id_tipo_grupo_flujo_caja=newid_tipo_grupo_flujo_caja;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setconsolidado(Boolean newconsolidado)throws Exception
	{
		try {
			if(this.consolidado!=newconsolidado) {
				if(newconsolidado==null) {
					//newconsolidado=false;
					if(Constantes.ISDEVELOPING) {
						System.out.println("CentroActividad:Valor nulo no permitido en columna consolidado");
					}
				}

				this.consolidado=newconsolidado;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setcon_proyecto(Boolean newcon_proyecto)throws Exception
	{
		try {
			if(this.con_proyecto!=newcon_proyecto) {
				if(newcon_proyecto==null) {
					//newcon_proyecto=false;
					if(Constantes.ISDEVELOPING) {
						System.out.println("CentroActividad:Valor nulo no permitido en columna con_proyecto");
					}
				}

				this.con_proyecto=newcon_proyecto;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setobservacion(String newobservacion)throws Exception
	{
		try {
			if(this.observacion!=newobservacion) {
				if(newobservacion==null) {
					//newobservacion="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("CentroActividad:Valor nulo no permitido en columna observacion");
					}
				}

				if(newobservacion!=null&&newobservacion.length()>150) {
					newobservacion=newobservacion.substring(0,148);
					System.out.println("CentroActividad:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=150 en columna observacion");
				}

				this.observacion=newobservacion;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	
	public Empresa getEmpresa() {
		return this.empresa;
	}

	public TipoMovimiento getTipoMovimiento() {
		return this.tipomovimiento;
	}

	public TipoGrupoFlujoCaja getTipoGrupoFlujoCaja() {
		return this.tipogrupoflujocaja;
	}

	
	
	public String getempresa_descripcion() {
		return this.empresa_descripcion;
	}

	public String gettipomovimiento_descripcion() {
		return this.tipomovimiento_descripcion;
	}

	public String gettipogrupoflujocaja_descripcion() {
		return this.tipogrupoflujocaja_descripcion;
	}

	
	
	public  void  setEmpresa(Empresa empresa) {
		try {
			this.empresa=empresa;
		} catch(Exception e) {
			;
		}
	}


	public  void  setTipoMovimiento(TipoMovimiento tipomovimiento) {
		try {
			this.tipomovimiento=tipomovimiento;
		} catch(Exception e) {
			;
		}
	}


	public  void  setTipoGrupoFlujoCaja(TipoGrupoFlujoCaja tipogrupoflujocaja) {
		try {
			this.tipogrupoflujocaja=tipogrupoflujocaja;
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


	public  void  settipomovimiento_descripcion(String tipomovimiento_descripcion) {
		try {
			this.tipomovimiento_descripcion=tipomovimiento_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  settipogrupoflujocaja_descripcion(String tipogrupoflujocaja_descripcion) {
		try {
			this.tipogrupoflujocaja_descripcion=tipogrupoflujocaja_descripcion;
		} catch(Exception e) {
			;
		}
	}


	
	
	public List<PagoAuto> getPagoAutos() {
		return this.pagoautos;
	}

	public List<Cliente> getClientes() {
		return this.clientes;
	}

	public List<AutoriPago> getAutoriPagos() {
		return this.autoripagos;
	}

	
	
	public  void  setPagoAutos(List<PagoAuto> pagoautos) {
		try {
			this.pagoautos=pagoautos;
		} catch(Exception e) {
			;
		}
	}

	public  void  setClientes(List<Cliente> clientes) {
		try {
			this.clientes=clientes;
		} catch(Exception e) {
			;
		}
	}

	public  void  setAutoriPagos(List<AutoriPago> autoripagos) {
		try {
			this.autoripagos=autoripagos;
		} catch(Exception e) {
			;
		}
	}

	
	/*PARA REPORTES*/
	String id_empresa_descripcion="";String id_tipo_movimiento_descripcion="";String id_tipo_grupo_flujo_caja_descripcion="";String consolidado_descripcion="";String con_proyecto_descripcion="";
	
	
	public String getid_empresa_descripcion() {
		return id_empresa_descripcion;
	}
	public String getid_tipo_movimiento_descripcion() {
		return id_tipo_movimiento_descripcion;
	}
	public String getid_tipo_grupo_flujo_caja_descripcion() {
		return id_tipo_grupo_flujo_caja_descripcion;
	}
	public String getconsolidado_descripcion() {
		return consolidado_descripcion;
	}
	public String getcon_proyecto_descripcion() {
		return con_proyecto_descripcion;
	}
	
	
	public void setid_empresa_descripcion(String newid_empresa_descripcion)throws Exception {
		try {
			this.id_empresa_descripcion=newid_empresa_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_tipo_movimiento_descripcion(String newid_tipo_movimiento_descripcion)throws Exception {
		try {
			this.id_tipo_movimiento_descripcion=newid_tipo_movimiento_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_tipo_grupo_flujo_caja_descripcion(String newid_tipo_grupo_flujo_caja_descripcion)throws Exception {
		try {
			this.id_tipo_grupo_flujo_caja_descripcion=newid_tipo_grupo_flujo_caja_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setconsolidado_descripcion(String newconsolidado_descripcion)throws Exception {
		try {
			this.consolidado_descripcion=newconsolidado_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setcon_proyecto_descripcion(String newcon_proyecto_descripcion)throws Exception {
		try {
			this.con_proyecto_descripcion=newcon_proyecto_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	
	public void inicializarVariablesParaReporte() {
		this.id_empresa_descripcion="";this.id_tipo_movimiento_descripcion="";this.id_tipo_grupo_flujo_caja_descripcion="";this.consolidado_descripcion="";this.con_proyecto_descripcion="";
	}
	
	
	Object pagoautosDescripcionReporte;
	Object clientesDescripcionReporte;
	Object detalleasientocontablesDescripcionReporte;
	Object autoripagosDescripcionReporte;
	Object presupuestoflujocajatsrsDescripcionReporte;
	
	
	public Object getpagoautosDescripcionReporte() {
		return pagoautosDescripcionReporte;
	}

	public Object getclientesDescripcionReporte() {
		return clientesDescripcionReporte;
	}

	public Object getdetalleasientocontablesDescripcionReporte() {
		return detalleasientocontablesDescripcionReporte;
	}

	public Object getautoripagosDescripcionReporte() {
		return autoripagosDescripcionReporte;
	}

	public Object getpresupuestoflujocajatsrsDescripcionReporte() {
		return presupuestoflujocajatsrsDescripcionReporte;
	}

	
	
	public  void  setpagoautosDescripcionReporte(Object pagoautos) {
		try {
			this.pagoautosDescripcionReporte=pagoautos;
		} catch(Exception ex) {
			;
		}
	}

	public  void  setclientesDescripcionReporte(Object clientes) {
		try {
			this.clientesDescripcionReporte=clientes;
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

	public  void  setautoripagosDescripcionReporte(Object autoripagos) {
		try {
			this.autoripagosDescripcionReporte=autoripagos;
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

	/*PARA REPORTES FIN*/		
}

