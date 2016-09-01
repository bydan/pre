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
//import com.bydan.erp.nomina.util.FormularioRenta107ConstantesFunciones;
import com.bydan.erp.nomina.util.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.contabilidad.util.*;



import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;




@SuppressWarnings("unused")
public class FormularioRenta107 extends FormularioRenta107Additional implements Serializable ,Cloneable {//FormularioRenta107Additional,GeneralEntity
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
	
	private FormularioRenta107 formulariorenta107Original;
	
	private Map<String, Object> mapFormularioRenta107;
			
	public Map<String, Object> getMapFormularioRenta107() {
		return mapFormularioRenta107;
	}

	public void setMapFormularioRenta107(Map<String, Object> mapFormularioRenta107) {
		this.mapFormularioRenta107 = mapFormularioRenta107;
	}
	
	public void inicializarMapFormularioRenta107() {
		this.mapFormularioRenta107 = new HashMap<String,Object>();
	}
	
	public void setMapFormularioRenta107Value(String sKey,Object oValue) {
		this.mapFormularioRenta107.put(sKey, oValue);
	}
	
	public Object getMapFormularioRenta107Value(String sKey) {
		return this.mapFormularioRenta107.get(sKey);
	}
	
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_empresa;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_empleado;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_ejercicio;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=50,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=FormularioRenta107ConstantesFunciones.SREGEXNUMERO_PRE_IMPRESO,message=FormularioRenta107ConstantesFunciones.SMENSAJEREGEXNUMERO_PRE_IMPRESO)
	private String numero_pre_impreso;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Date fecha_entrega;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Date fecha_generacion;
			
	
	public Empresa empresa;
	public Empleado empleado;
	public Ejercicio ejercicio;
	
	
	private String empresa_descripcion;
	private String empleado_descripcion;
	private String ejercicio_descripcion;
	
	
	public List<DetalleFormularioRenta107> detalleformulariorenta107s;
		
	public FormularioRenta107 () throws Exception {
		super();		
		
		this.id=0L;
		
		
		this.versionRow=new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());//new Date();
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		this.sType="NONE";
		
		this.formulariorenta107Original=this;
		
 		this.id_empresa=-1L;
 		this.id_empleado=-1L;
 		this.id_ejercicio=-1L;
 		this.numero_pre_impreso="";
 		this.fecha_entrega=new Date();
 		this.fecha_generacion=new Date();
		
		
		this.empresa=null;
		this.empleado=null;
		this.ejercicio=null;
		
		
		this.empresa_descripcion="";
		this.empleado_descripcion="";
		this.ejercicio_descripcion="";
		
		
		this.detalleformulariorenta107s=null;
		
			
		
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
    //PARA REPORTES
	public FormularioRenta107 (Long id,Date versionRow,Long id_empresa,Long id_empleado,Long id_ejercicio,String numero_pre_impreso,Date fecha_entrega,Date fecha_generacion) throws Exception {
		super();		
		
		this.id=id;
		this.versionRow=versionRow;
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.formulariorenta107Original=this;
		
 		this.id_empresa=id_empresa;
 		this.id_empleado=id_empleado;
 		this.id_ejercicio=id_ejercicio;
 		this.numero_pre_impreso=numero_pre_impreso;
 		this.fecha_entrega=fecha_entrega;
 		this.fecha_generacion=fecha_generacion;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	 //PARA REPORTES
	public FormularioRenta107 (Long id_empresa,Long id_empleado,Long id_ejercicio,String numero_pre_impreso,Date fecha_entrega,Date fecha_generacion) throws Exception {
		super();		
		
		this.id=0L;
		this.versionRow=new Date();
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.formulariorenta107Original=this;
		
 		this.id_empresa=id_empresa;
 		this.id_empleado=id_empleado;
 		this.id_ejercicio=id_ejercicio;
 		this.numero_pre_impreso=numero_pre_impreso;
 		this.fecha_entrega=fecha_entrega;
 		this.fecha_generacion=fecha_generacion;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	public boolean equals(Object object) {
		boolean equal=false;
		FormularioRenta107 formulariorenta107Local=null;
		
		if(object!=null) {
			formulariorenta107Local=(FormularioRenta107)object;
			
			if(formulariorenta107Local!=null) {
				if(this.getId()!=null && formulariorenta107Local.getId()!=null) {
					if(this.getId().equals(formulariorenta107Local.getId())) {
						equal=true;
					}
				}
			}
		}
		
		return equal;
	}
	
	public String toString() {
		String sDetalle="";
		
		if(!FormularioRenta107ConstantesFunciones.CON_DESCRIPCION_DETALLADO) {
        	sDetalle=FormularioRenta107ConstantesFunciones.getFormularioRenta107Descripcion(this);
		} else {
			sDetalle=FormularioRenta107ConstantesFunciones.getFormularioRenta107DescripcionDetallado(this);
		}
		
		return sDetalle;
    }
	
	public FormularioRenta107 getFormularioRenta107Original() {
		return this.formulariorenta107Original;
	}
	
	public void setFormularioRenta107Original(FormularioRenta107 formulariorenta107) {
		try {
			this.formulariorenta107Original=formulariorenta107;
		} catch(Exception e) {
			;
		}
	}
	
	
	protected FormularioRenta107Additional formulariorenta107Additional=null;
	
	public FormularioRenta107Additional getFormularioRenta107Additional() {
		return this.formulariorenta107Additional;
	}
	
	public void setFormularioRenta107Additional(FormularioRenta107Additional formulariorenta107Additional) {
		try {
			this.formulariorenta107Additional=formulariorenta107Additional;
		} catch(Exception e) {
			;
		}
	}
	
	
    
	
	public Long getid_empresa() {
		return this.id_empresa;
	}
    
	
	public Long getid_empleado() {
		return this.id_empleado;
	}
    
	
	public Long getid_ejercicio() {
		return this.id_ejercicio;
	}
    
	
	public String getnumero_pre_impreso() {
		return this.numero_pre_impreso;
	}
    
	
	public Date getfecha_entrega() {
		return this.fecha_entrega;
	}
    
	
	public Date getfecha_generacion() {
		return this.fecha_generacion;
	}
	
    
	public void setid_empresa(Long newid_empresa)throws Exception
	{
		try {
			if(this.id_empresa!=newid_empresa) {
				if(newid_empresa==null) {
					//newid_empresa=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("FormularioRenta107:Valor nulo no permitido en columna id_empresa");
					}
				}

				this.id_empresa=newid_empresa;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_empleado(Long newid_empleado)throws Exception
	{
		try {
			if(this.id_empleado!=newid_empleado) {
				if(newid_empleado==null) {
					//newid_empleado=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("FormularioRenta107:Valor nulo no permitido en columna id_empleado");
					}
				}

				this.id_empleado=newid_empleado;
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
						System.out.println("FormularioRenta107:Valor nulo no permitido en columna id_ejercicio");
					}
				}

				this.id_ejercicio=newid_ejercicio;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setnumero_pre_impreso(String newnumero_pre_impreso)throws Exception
	{
		try {
			if(this.numero_pre_impreso!=newnumero_pre_impreso) {
				if(newnumero_pre_impreso==null) {
					//newnumero_pre_impreso="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("FormularioRenta107:Valor nulo no permitido en columna numero_pre_impreso");
					}
				}

				if(newnumero_pre_impreso!=null&&newnumero_pre_impreso.length()>50) {
					newnumero_pre_impreso=newnumero_pre_impreso.substring(0,48);
					System.out.println("FormularioRenta107:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=50 en columna numero_pre_impreso");
				}

				this.numero_pre_impreso=newnumero_pre_impreso;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setfecha_entrega(Date newfecha_entrega)throws Exception
	{
		try {
			if(this.fecha_entrega!=newfecha_entrega) {
				if(newfecha_entrega==null) {
					//newfecha_entrega=new Date();
					if(Constantes.ISDEVELOPING) {
						System.out.println("FormularioRenta107:Valor nulo no permitido en columna fecha_entrega");
					}
				}

				this.fecha_entrega=newfecha_entrega;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setfecha_generacion(Date newfecha_generacion)throws Exception
	{
		try {
			if(this.fecha_generacion!=newfecha_generacion) {
				if(newfecha_generacion==null) {
					//newfecha_generacion=new Date();
					if(Constantes.ISDEVELOPING) {
						System.out.println("FormularioRenta107:Valor nulo no permitido en columna fecha_generacion");
					}
				}

				this.fecha_generacion=newfecha_generacion;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	
	public Empresa getEmpresa() {
		return this.empresa;
	}

	public Empleado getEmpleado() {
		return this.empleado;
	}

	public Ejercicio getEjercicio() {
		return this.ejercicio;
	}

	
	
	public String getempresa_descripcion() {
		return this.empresa_descripcion;
	}

	public String getempleado_descripcion() {
		return this.empleado_descripcion;
	}

	public String getejercicio_descripcion() {
		return this.ejercicio_descripcion;
	}

	
	
	public  void  setEmpresa(Empresa empresa) {
		try {
			this.empresa=empresa;
		} catch(Exception e) {
			;
		}
	}


	public  void  setEmpleado(Empleado empleado) {
		try {
			this.empleado=empleado;
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


	
	
	public  void  setempresa_descripcion(String empresa_descripcion) {
		try {
			this.empresa_descripcion=empresa_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  setempleado_descripcion(String empleado_descripcion) {
		try {
			this.empleado_descripcion=empleado_descripcion;
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


	
	
	public List<DetalleFormularioRenta107> getDetalleFormularioRenta107s() {
		return this.detalleformulariorenta107s;
	}

	
	
	public  void  setDetalleFormularioRenta107s(List<DetalleFormularioRenta107> detalleformulariorenta107s) {
		try {
			this.detalleformulariorenta107s=detalleformulariorenta107s;
		} catch(Exception e) {
			;
		}
	}

	
	/*PARA REPORTES*/
	String id_empresa_descripcion="";String id_empleado_descripcion="";String id_ejercicio_descripcion="";
	
	
	public String getid_empresa_descripcion() {
		return id_empresa_descripcion;
	}
	public String getid_empleado_descripcion() {
		return id_empleado_descripcion;
	}
	public String getid_ejercicio_descripcion() {
		return id_ejercicio_descripcion;
	}
	
	
	public void setid_empresa_descripcion(String newid_empresa_descripcion)throws Exception {
		try {
			this.id_empresa_descripcion=newid_empresa_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_empleado_descripcion(String newid_empleado_descripcion)throws Exception {
		try {
			this.id_empleado_descripcion=newid_empleado_descripcion;
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
	
	public void inicializarVariablesParaReporte() {
		this.id_empresa_descripcion="";this.id_empleado_descripcion="";this.id_ejercicio_descripcion="";
	}
	
	
	Object detalleformulariorenta107sDescripcionReporte;
	
	
	public Object getdetalleformulariorenta107sDescripcionReporte() {
		return detalleformulariorenta107sDescripcionReporte;
	}

	
	
	public  void  setdetalleformulariorenta107sDescripcionReporte(Object detalleformulariorenta107s) {
		try {
			this.detalleformulariorenta107sDescripcionReporte=detalleformulariorenta107s;
		} catch(Exception ex) {
			;
		}
	}

	/*PARA REPORTES FIN*/		
}

