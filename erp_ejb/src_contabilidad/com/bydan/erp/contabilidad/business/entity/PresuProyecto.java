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
//import com.bydan.erp.contabilidad.util.PresuProyectoConstantesFunciones;
import com.bydan.erp.contabilidad.util.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.nomina.util.*;



import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.nomina.business.entity.*;




@SuppressWarnings("unused")
public class PresuProyecto extends PresuProyectoAdditional implements Serializable ,Cloneable {//PresuProyectoAdditional,GeneralEntity
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
	
	private PresuProyecto presuproyectoOriginal;
	
	private Map<String, Object> mapPresuProyecto;
			
	public Map<String, Object> getMapPresuProyecto() {
		return mapPresuProyecto;
	}

	public void setMapPresuProyecto(Map<String, Object> mapPresuProyecto) {
		this.mapPresuProyecto = mapPresuProyecto;
	}
	
	public void inicializarMapPresuProyecto() {
		this.mapPresuProyecto = new HashMap<String,Object>();
	}
	
	public void setMapPresuProyectoValue(String sKey,Object oValue) {
		this.mapPresuProyecto.put(sKey, oValue);
	}
	
	public Object getMapPresuProyectoValue(String sKey) {
		return this.mapPresuProyecto.get(sKey);
	}
	
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_empresa;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_sucursal;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_ejercicio;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=150,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=PresuProyectoConstantesFunciones.SREGEXCODIGO,message=PresuProyectoConstantesFunciones.SMENSAJEREGEXCODIGO)
	private String codigo;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=200,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=PresuProyectoConstantesFunciones.SREGEXNOMBRE,message=PresuProyectoConstantesFunciones.SMENSAJEREGEXNOMBRE)
	private String nombre;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_presu_tipo_proyecto;
	
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	private Long id_centro_costo;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Date fecha;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double valor;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_presu_estado;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=200,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@Pattern(regex=PresuProyectoConstantesFunciones.SREGEXDESCRIPCION,message=PresuProyectoConstantesFunciones.SMENSAJEREGEXDESCRIPCION)
	private String descripcion;
			
	
	public Empresa empresa;
	public Sucursal sucursal;
	public Ejercicio ejercicio;
	public PresuTipoProyecto presutipoproyecto;
	public CentroCosto centrocosto;
	public PresuEstado presuestado;
	
	
	private String empresa_descripcion;
	private String sucursal_descripcion;
	private String ejercicio_descripcion;
	private String presutipoproyecto_descripcion;
	private String centrocosto_descripcion;
	private String presuestado_descripcion;
	
	
	public List<PresuTransferencia> presutransferencias;
	public List<PresuProyectoCuenta> presuproyectocuentas;
		
	public PresuProyecto () throws Exception {
		super();		
		
		this.id=0L;
		
		
		this.versionRow=new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());//new Date();
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		this.sType="NONE";
		
		this.presuproyectoOriginal=this;
		
 		this.id_empresa=-1L;
 		this.id_sucursal=-1L;
 		this.id_ejercicio=-1L;
 		this.codigo="";
 		this.nombre="";
 		this.id_presu_tipo_proyecto=-1L;
 		this.id_centro_costo=null;
 		this.fecha=new Date();
 		this.valor=0.0;
 		this.id_presu_estado=-1L;
 		this.descripcion="";
		
		
		this.empresa=null;
		this.sucursal=null;
		this.ejercicio=null;
		this.presutipoproyecto=null;
		this.centrocosto=null;
		this.presuestado=null;
		
		
		this.empresa_descripcion="";
		this.sucursal_descripcion="";
		this.ejercicio_descripcion="";
		this.presutipoproyecto_descripcion="";
		this.centrocosto_descripcion="";
		this.presuestado_descripcion="";
		
		
		this.presutransferencias=null;
		this.presuproyectocuentas=null;
		
			
		
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
    //PARA REPORTES
	public PresuProyecto (Long id,Date versionRow,Long id_empresa,Long id_sucursal,Long id_ejercicio,String codigo,String nombre,Long id_presu_tipo_proyecto,Long id_centro_costo,Date fecha,Double valor,Long id_presu_estado,String descripcion) throws Exception {
		super();		
		
		this.id=id;
		this.versionRow=versionRow;
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.presuproyectoOriginal=this;
		
 		this.id_empresa=id_empresa;
 		this.id_sucursal=id_sucursal;
 		this.id_ejercicio=id_ejercicio;
 		this.codigo=codigo;
 		this.nombre=nombre;
 		this.id_presu_tipo_proyecto=id_presu_tipo_proyecto;
 		this.id_centro_costo=id_centro_costo;
 		this.fecha=fecha;
 		this.valor=valor;
 		this.id_presu_estado=id_presu_estado;
 		this.descripcion=descripcion;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	 //PARA REPORTES
	public PresuProyecto (Long id_empresa,Long id_sucursal,Long id_ejercicio,String codigo,String nombre,Long id_presu_tipo_proyecto,Long id_centro_costo,Date fecha,Double valor,Long id_presu_estado,String descripcion) throws Exception {
		super();		
		
		this.id=0L;
		this.versionRow=new Date();
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.presuproyectoOriginal=this;
		
 		this.id_empresa=id_empresa;
 		this.id_sucursal=id_sucursal;
 		this.id_ejercicio=id_ejercicio;
 		this.codigo=codigo;
 		this.nombre=nombre;
 		this.id_presu_tipo_proyecto=id_presu_tipo_proyecto;
 		this.id_centro_costo=id_centro_costo;
 		this.fecha=fecha;
 		this.valor=valor;
 		this.id_presu_estado=id_presu_estado;
 		this.descripcion=descripcion;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	public boolean equals(Object object) {
		boolean equal=false;
		PresuProyecto presuproyectoLocal=null;
		
		if(object!=null) {
			presuproyectoLocal=(PresuProyecto)object;
			
			if(presuproyectoLocal!=null) {
				if(this.getId()!=null && presuproyectoLocal.getId()!=null) {
					if(this.getId().equals(presuproyectoLocal.getId())) {
						equal=true;
					}
				}
			}
		}
		
		return equal;
	}
	
	public String toString() {
		String sDetalle="";
		
		if(!PresuProyectoConstantesFunciones.CON_DESCRIPCION_DETALLADO) {
        	sDetalle=PresuProyectoConstantesFunciones.getPresuProyectoDescripcion(this);
		} else {
			sDetalle=PresuProyectoConstantesFunciones.getPresuProyectoDescripcionDetallado(this);
		}
		
		return sDetalle;
    }
	
	public PresuProyecto getPresuProyectoOriginal() {
		return this.presuproyectoOriginal;
	}
	
	public void setPresuProyectoOriginal(PresuProyecto presuproyecto) {
		try {
			this.presuproyectoOriginal=presuproyecto;
		} catch(Exception e) {
			;
		}
	}
	
	
	protected PresuProyectoAdditional presuproyectoAdditional=null;
	
	public PresuProyectoAdditional getPresuProyectoAdditional() {
		return this.presuproyectoAdditional;
	}
	
	public void setPresuProyectoAdditional(PresuProyectoAdditional presuproyectoAdditional) {
		try {
			this.presuproyectoAdditional=presuproyectoAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
    
	
	public Long getid_empresa() {
		return this.id_empresa;
	}
    
	
	public Long getid_sucursal() {
		return this.id_sucursal;
	}
    
	
	public Long getid_ejercicio() {
		return this.id_ejercicio;
	}
    
	
	public String getcodigo() {
		return this.codigo;
	}
    
	
	public String getnombre() {
		return this.nombre;
	}
    
	
	public Long getid_presu_tipo_proyecto() {
		return this.id_presu_tipo_proyecto;
	}
    
	
	public Long getid_centro_costo() {
		return this.id_centro_costo;
	}
    
	
	public Date getfecha() {
		return this.fecha;
	}
    
	
	public Double getvalor() {
		return this.valor;
	}
    
	
	public Long getid_presu_estado() {
		return this.id_presu_estado;
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
						System.out.println("PresuProyecto:Valor nulo no permitido en columna id_empresa");
					}
				}

				this.id_empresa=newid_empresa;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_sucursal(Long newid_sucursal)throws Exception
	{
		try {
			if(this.id_sucursal!=newid_sucursal) {
				if(newid_sucursal==null) {
					//newid_sucursal=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("PresuProyecto:Valor nulo no permitido en columna id_sucursal");
					}
				}

				this.id_sucursal=newid_sucursal;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_ejercicio(Long newid_ejercicio)throws Exception
	{
		try {
			if(this.id_ejercicio!=newid_ejercicio) {
				if(newid_ejercicio==null) {
					//newid_ejercicio=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("PresuProyecto:Valor nulo no permitido en columna id_ejercicio");
					}
				}

				this.id_ejercicio=newid_ejercicio;
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
						System.out.println("PresuProyecto:Valor nulo no permitido en columna codigo");
					}
				}

				if(newcodigo!=null&&newcodigo.length()>150) {
					newcodigo=newcodigo.substring(0,148);
					System.out.println("PresuProyecto:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=150 en columna codigo");
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
						System.out.println("PresuProyecto:Valor nulo no permitido en columna nombre");
					}
				}

				if(newnombre!=null&&newnombre.length()>200) {
					newnombre=newnombre.substring(0,198);
					System.out.println("PresuProyecto:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=200 en columna nombre");
				}

				this.nombre=newnombre;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_presu_tipo_proyecto(Long newid_presu_tipo_proyecto)throws Exception
	{
		try {
			if(this.id_presu_tipo_proyecto!=newid_presu_tipo_proyecto) {
				if(newid_presu_tipo_proyecto==null) {
					//newid_presu_tipo_proyecto=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("PresuProyecto:Valor nulo no permitido en columna id_presu_tipo_proyecto");
					}
				}

				this.id_presu_tipo_proyecto=newid_presu_tipo_proyecto;
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
    
	public void setfecha(Date newfecha)throws Exception
	{
		try {
			if(this.fecha!=newfecha) {
				if(newfecha==null) {
					//newfecha=new Date();
					if(Constantes.ISDEVELOPING) {
						System.out.println("PresuProyecto:Valor nulo no permitido en columna fecha");
					}
				}

				this.fecha=newfecha;
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
						System.out.println("PresuProyecto:Valor nulo no permitido en columna valor");
					}
				}

				this.valor=newvalor;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_presu_estado(Long newid_presu_estado)throws Exception
	{
		try {
			if(this.id_presu_estado!=newid_presu_estado) {
				if(newid_presu_estado==null) {
					//newid_presu_estado=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("PresuProyecto:Valor nulo no permitido en columna id_presu_estado");
					}
				}

				this.id_presu_estado=newid_presu_estado;
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
						System.out.println("PresuProyecto:Valor nulo no permitido en columna descripcion");
					}
				}

				if(newdescripcion!=null&&newdescripcion.length()>200) {
					newdescripcion=newdescripcion.substring(0,198);
					System.out.println("PresuProyecto:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=200 en columna descripcion");
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

	public Sucursal getSucursal() {
		return this.sucursal;
	}

	public Ejercicio getEjercicio() {
		return this.ejercicio;
	}

	public PresuTipoProyecto getPresuTipoProyecto() {
		return this.presutipoproyecto;
	}

	public CentroCosto getCentroCosto() {
		return this.centrocosto;
	}

	public PresuEstado getPresuEstado() {
		return this.presuestado;
	}

	
	
	public String getempresa_descripcion() {
		return this.empresa_descripcion;
	}

	public String getsucursal_descripcion() {
		return this.sucursal_descripcion;
	}

	public String getejercicio_descripcion() {
		return this.ejercicio_descripcion;
	}

	public String getpresutipoproyecto_descripcion() {
		return this.presutipoproyecto_descripcion;
	}

	public String getcentrocosto_descripcion() {
		return this.centrocosto_descripcion;
	}

	public String getpresuestado_descripcion() {
		return this.presuestado_descripcion;
	}

	
	
	public  void  setEmpresa(Empresa empresa) {
		try {
			this.empresa=empresa;
		} catch(Exception e) {
			;
		}
	}


	public  void  setSucursal(Sucursal sucursal) {
		try {
			this.sucursal=sucursal;
		} catch(Exception e) {
			;
		}
	}


	public  void  setEjercicio(Ejercicio ejercicio) {
		try {
			this.ejercicio=ejercicio;
		} catch(Exception e) {
			;
		}
	}


	public  void  setPresuTipoProyecto(PresuTipoProyecto presutipoproyecto) {
		try {
			this.presutipoproyecto=presutipoproyecto;
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


	public  void  setPresuEstado(PresuEstado presuestado) {
		try {
			this.presuestado=presuestado;
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


	public  void  setsucursal_descripcion(String sucursal_descripcion) {
		try {
			this.sucursal_descripcion=sucursal_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  setejercicio_descripcion(String ejercicio_descripcion) {
		try {
			this.ejercicio_descripcion=ejercicio_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  setpresutipoproyecto_descripcion(String presutipoproyecto_descripcion) {
		try {
			this.presutipoproyecto_descripcion=presutipoproyecto_descripcion;
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


	public  void  setpresuestado_descripcion(String presuestado_descripcion) {
		try {
			this.presuestado_descripcion=presuestado_descripcion;
		} catch(Exception e) {
			;
		}
	}


	
	
	public List<PresuTransferencia> getPresuTransferencias() {
		return this.presutransferencias;
	}

	public List<PresuProyectoCuenta> getPresuProyectoCuentas() {
		return this.presuproyectocuentas;
	}

	
	
	public  void  setPresuTransferencias(List<PresuTransferencia> presutransferencias) {
		try {
			this.presutransferencias=presutransferencias;
		} catch(Exception e) {
			;
		}
	}

	public  void  setPresuProyectoCuentas(List<PresuProyectoCuenta> presuproyectocuentas) {
		try {
			this.presuproyectocuentas=presuproyectocuentas;
		} catch(Exception e) {
			;
		}
	}

	
	/*PARA REPORTES*/
	String id_empresa_descripcion="";String id_sucursal_descripcion="";String id_ejercicio_descripcion="";String id_presu_tipo_proyecto_descripcion="";String id_centro_costo_descripcion="";String id_presu_estado_descripcion="";
	
	
	public String getid_empresa_descripcion() {
		return id_empresa_descripcion;
	}
	public String getid_sucursal_descripcion() {
		return id_sucursal_descripcion;
	}
	public String getid_ejercicio_descripcion() {
		return id_ejercicio_descripcion;
	}
	public String getid_presu_tipo_proyecto_descripcion() {
		return id_presu_tipo_proyecto_descripcion;
	}
	public String getid_centro_costo_descripcion() {
		return id_centro_costo_descripcion;
	}
	public String getid_presu_estado_descripcion() {
		return id_presu_estado_descripcion;
	}
	
	
	public void setid_empresa_descripcion(String newid_empresa_descripcion)throws Exception {
		try {
			this.id_empresa_descripcion=newid_empresa_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_sucursal_descripcion(String newid_sucursal_descripcion)throws Exception {
		try {
			this.id_sucursal_descripcion=newid_sucursal_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_ejercicio_descripcion(String newid_ejercicio_descripcion)throws Exception {
		try {
			this.id_ejercicio_descripcion=newid_ejercicio_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_presu_tipo_proyecto_descripcion(String newid_presu_tipo_proyecto_descripcion)throws Exception {
		try {
			this.id_presu_tipo_proyecto_descripcion=newid_presu_tipo_proyecto_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_centro_costo_descripcion(String newid_centro_costo_descripcion) {
		this.id_centro_costo_descripcion=newid_centro_costo_descripcion;
	}
	public void setid_presu_estado_descripcion(String newid_presu_estado_descripcion)throws Exception {
		try {
			this.id_presu_estado_descripcion=newid_presu_estado_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	
	public void inicializarVariablesParaReporte() {
		this.id_empresa_descripcion="";this.id_sucursal_descripcion="";this.id_ejercicio_descripcion="";this.id_presu_tipo_proyecto_descripcion="";this.id_centro_costo_descripcion="";this.id_presu_estado_descripcion="";
	}
	
	
	Object presutransferenciasDescripcionReporte;
	Object presuproyectocuentasDescripcionReporte;
	
	
	public Object getpresutransferenciasDescripcionReporte() {
		return presutransferenciasDescripcionReporte;
	}

	public Object getpresuproyectocuentasDescripcionReporte() {
		return presuproyectocuentasDescripcionReporte;
	}

	
	
	public  void  setpresutransferenciasDescripcionReporte(Object presutransferencias) {
		try {
			this.presutransferenciasDescripcionReporte=presutransferencias;
		} catch(Exception ex) {
			;
		}
	}

	public  void  setpresuproyectocuentasDescripcionReporte(Object presuproyectocuentas) {
		try {
			this.presuproyectocuentasDescripcionReporte=presuproyectocuentas;
		} catch(Exception ex) {
			;
		}
	}

	/*PARA REPORTES FIN*/		
}

