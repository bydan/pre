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
package com.bydan.erp.nomina.business.entity;

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
//import com.bydan.erp.nomina.util.TipoGeneroConstantesFunciones;
import com.bydan.erp.nomina.util.*;


import com.bydan.erp.cartera.util.*;
import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.nomina.util.*;
import com.bydan.erp.contabilidad.util.*;
import com.bydan.erp.comisiones.util.*;
import com.bydan.erp.inventario.util.*;
import com.bydan.erp.sris.util.*;
import com.bydan.erp.facturacion.util.*;
import com.bydan.erp.tesoreria.util.*;
import com.bydan.erp.puntoventa.util.*;
import com.bydan.erp.activosfijos.util.*;
import com.bydan.erp.importaciones.util.*;
import com.bydan.erp.produccion.util.*;



import com.bydan.erp.cartera.business.entity.*;
import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.nomina.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.comisiones.business.entity.*;
import com.bydan.erp.inventario.business.entity.*;
import com.bydan.erp.sris.business.entity.*;
import com.bydan.erp.facturacion.business.entity.*;
import com.bydan.erp.tesoreria.business.entity.*;
import com.bydan.erp.puntoventa.business.entity.*;
import com.bydan.erp.activosfijos.business.entity.*;
import com.bydan.erp.importaciones.business.entity.*;
import com.bydan.erp.produccion.business.entity.*;




@SuppressWarnings("unused")
public class TipoGenero extends GeneralEntitySinIdGenerated implements Serializable ,Cloneable {//TipoGeneroAdditional,GeneralEntity
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
	
	private TipoGenero tipogeneroOriginal;
	
	private Map<String, Object> mapTipoGenero;
			
	public Map<String, Object> getMapTipoGenero() {
		return mapTipoGenero;
	}

	public void setMapTipoGenero(Map<String, Object> mapTipoGenero) {
		this.mapTipoGenero = mapTipoGenero;
	}
	
	public void inicializarMapTipoGenero() {
		this.mapTipoGenero = new HashMap<String,Object>();
	}
	
	public void setMapTipoGeneroValue(String sKey,Object oValue) {
		this.mapTipoGenero.put(sKey, oValue);
	}
	
	public Object getMapTipoGeneroValue(String sKey) {
		return this.mapTipoGenero.get(sKey);
	}
	
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=50,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=TipoGeneroConstantesFunciones.SREGEXCODIGO,message=TipoGeneroConstantesFunciones.SMENSAJEREGEXCODIGO)
	private String codigo;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=100,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=TipoGeneroConstantesFunciones.SREGEXNOMBRE,message=TipoGeneroConstantesFunciones.SMENSAJEREGEXNOMBRE)
	private String nombre;
			
	
	
	
	
	
	public List<Cliente> clientes;
	public List<CargaFamiliar_NM> cargafamiliar_nms;
	public List<SubCliente> subclientes;
	public List<Empleado> empleados;
	public List<ParametroCarteraDefecto> parametrocarteradefectos;
	public List<CargaFamiliar> cargafamiliars;
		
	public TipoGenero () throws Exception {
		super();		
		
		this.id=0L;
		this.idOriginal=0L;
		
		
		this.versionRow=new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());//new Date();
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		this.sType="NONE";
		
		this.tipogeneroOriginal=this;
		
 		this.codigo="";
 		this.nombre="";
		
		
		
		
		
		
		this.clientes=null;
		this.cargafamiliar_nms=null;
		this.subclientes=null;
		this.empleados=null;
		this.parametrocarteradefectos=null;
		this.cargafamiliars=null;
		
			
		
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
    //PARA REPORTES
	public TipoGenero (Long id,Date versionRow,String codigo,String nombre) throws Exception {
		super();		
		
		this.id=id;
		this.idOriginal=this.id;
		this.versionRow=versionRow;
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.tipogeneroOriginal=this;
		
 		this.codigo=codigo;
 		this.nombre=nombre;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	 //PARA REPORTES
	public TipoGenero (String codigo,String nombre) throws Exception {
		super();		
		
		this.id=0L;
		this.idOriginal=0L;
		this.versionRow=new Date();
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.tipogeneroOriginal=this;
		
 		this.codigo=codigo;
 		this.nombre=nombre;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	public boolean equals(Object object) {
		boolean equal=false;
		TipoGenero tipogeneroLocal=null;
		
		if(object!=null) {
			tipogeneroLocal=(TipoGenero)object;
			
			if(tipogeneroLocal!=null) {
				if(this.getId()!=null && tipogeneroLocal.getId()!=null) {
					if(this.getId().equals(tipogeneroLocal.getId())) {
						equal=true;
					}
				}
			}
		}
		
		return equal;
	}
	
	public String toString() {
		String sDetalle="";
		
		if(!TipoGeneroConstantesFunciones.CON_DESCRIPCION_DETALLADO) {
        	sDetalle=TipoGeneroConstantesFunciones.getTipoGeneroDescripcion(this);
		} else {
			sDetalle=TipoGeneroConstantesFunciones.getTipoGeneroDescripcionDetallado(this);
		}
		
		return sDetalle;
    }
	
	public TipoGenero getTipoGeneroOriginal() {
		return this.tipogeneroOriginal;
	}
	
	public void setTipoGeneroOriginal(TipoGenero tipogenero) {
		try {
			this.tipogeneroOriginal=tipogenero;
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
						System.out.println("TipoGenero:Valor nulo no permitido en columna codigo");
					}
				}

				if(newcodigo!=null&&newcodigo.length()>50) {
					newcodigo=newcodigo.substring(0,48);
					System.out.println("TipoGenero:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=50 en columna codigo");
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
						System.out.println("TipoGenero:Valor nulo no permitido en columna nombre");
					}
				}

				if(newnombre!=null&&newnombre.length()>100) {
					newnombre=newnombre.substring(0,98);
					System.out.println("TipoGenero:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=100 en columna nombre");
				}

				this.nombre=newnombre;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
	
	public List<Cliente> getClientes() {
		return this.clientes;
	}

	public List<CargaFamiliar_NM> getCargaFamiliar_NMs() {
		return this.cargafamiliar_nms;
	}

	public List<SubCliente> getSubClientes() {
		return this.subclientes;
	}

	public List<Empleado> getEmpleados() {
		return this.empleados;
	}

	public List<ParametroCarteraDefecto> getParametroCarteraDefectos() {
		return this.parametrocarteradefectos;
	}

	public List<CargaFamiliar> getCargaFamiliars() {
		return this.cargafamiliars;
	}

	
	
	public  void  setClientes(List<Cliente> clientes) {
		try {
			this.clientes=clientes;
		} catch(Exception e) {
			;
		}
	}

	public  void  setCargaFamiliar_NMs(List<CargaFamiliar_NM> cargafamiliar_nms) {
		try {
			this.cargafamiliar_nms=cargafamiliar_nms;
		} catch(Exception e) {
			;
		}
	}

	public  void  setSubClientes(List<SubCliente> subclientes) {
		try {
			this.subclientes=subclientes;
		} catch(Exception e) {
			;
		}
	}

	public  void  setEmpleados(List<Empleado> empleados) {
		try {
			this.empleados=empleados;
		} catch(Exception e) {
			;
		}
	}

	public  void  setParametroCarteraDefectos(List<ParametroCarteraDefecto> parametrocarteradefectos) {
		try {
			this.parametrocarteradefectos=parametrocarteradefectos;
		} catch(Exception e) {
			;
		}
	}

	public  void  setCargaFamiliars(List<CargaFamiliar> cargafamiliars) {
		try {
			this.cargafamiliars=cargafamiliars;
		} catch(Exception e) {
			;
		}
	}

	
	/*PARA REPORTES*/
	
	
	
	
	
	
	public void inicializarVariablesParaReporte() {
		
	}
	
	
	Object clientesDescripcionReporte;
	Object cargafamiliar_nmsDescripcionReporte;
	Object subclientesDescripcionReporte;
	Object empleadosDescripcionReporte;
	Object parametrocarteradefectosDescripcionReporte;
	Object cargafamiliarsDescripcionReporte;
	
	
	public Object getclientesDescripcionReporte() {
		return clientesDescripcionReporte;
	}

	public Object getcargafamiliar_nmsDescripcionReporte() {
		return cargafamiliar_nmsDescripcionReporte;
	}

	public Object getsubclientesDescripcionReporte() {
		return subclientesDescripcionReporte;
	}

	public Object getempleadosDescripcionReporte() {
		return empleadosDescripcionReporte;
	}

	public Object getparametrocarteradefectosDescripcionReporte() {
		return parametrocarteradefectosDescripcionReporte;
	}

	public Object getcargafamiliarsDescripcionReporte() {
		return cargafamiliarsDescripcionReporte;
	}

	
	
	public  void  setclientesDescripcionReporte(Object clientes) {
		try {
			this.clientesDescripcionReporte=clientes;
		} catch(Exception ex) {
			;
		}
	}

	public  void  setcargafamiliar_nmsDescripcionReporte(Object cargafamiliar_nms) {
		try {
			this.cargafamiliar_nmsDescripcionReporte=cargafamiliar_nms;
		} catch(Exception ex) {
			;
		}
	}

	public  void  setsubclientesDescripcionReporte(Object subclientes) {
		try {
			this.subclientesDescripcionReporte=subclientes;
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

	public  void  setparametrocarteradefectosDescripcionReporte(Object parametrocarteradefectos) {
		try {
			this.parametrocarteradefectosDescripcionReporte=parametrocarteradefectos;
		} catch(Exception ex) {
			;
		}
	}

	public  void  setcargafamiliarsDescripcionReporte(Object cargafamiliars) {
		try {
			this.cargafamiliarsDescripcionReporte=cargafamiliars;
		} catch(Exception ex) {
			;
		}
	}

	/*PARA REPORTES FIN*/		
}

