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
//import com.bydan.erp.contabilidad.util.PresuTransferenciaConstantesFunciones;
import com.bydan.erp.contabilidad.util.*;


import com.bydan.erp.nomina.util.*;



import com.bydan.erp.nomina.business.entity.*;




@SuppressWarnings("unused")
public class PresuTransferencia extends PresuTransferenciaAdditional implements Serializable ,Cloneable {//PresuTransferenciaAdditional,GeneralEntity
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
	
	private PresuTransferencia presutransferenciaOriginal;
	
	private Map<String, Object> mapPresuTransferencia;
			
	public Map<String, Object> getMapPresuTransferencia() {
		return mapPresuTransferencia;
	}

	public void setMapPresuTransferencia(Map<String, Object> mapPresuTransferencia) {
		this.mapPresuTransferencia = mapPresuTransferencia;
	}
	
	public void inicializarMapPresuTransferencia() {
		this.mapPresuTransferencia = new HashMap<String,Object>();
	}
	
	public void setMapPresuTransferenciaValue(String sKey,Object oValue) {
		this.mapPresuTransferencia.put(sKey, oValue);
	}
	
	public Object getMapPresuTransferenciaValue(String sKey) {
		return this.mapPresuTransferencia.get(sKey);
	}
	
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_presu_proyecto;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_cuenta_contable;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_cuenta_contable_destino;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_empleado;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Date fecha;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double valor;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=200,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=PresuTransferenciaConstantesFunciones.SREGEXDESCRIPCION,message=PresuTransferenciaConstantesFunciones.SMENSAJEREGEXDESCRIPCION)
	private String descripcion;
			
	
	public PresuProyecto presuproyecto;
	public CuentaContable cuentacontable;
	public CuentaContable cuentacontabledestino;
	public Empleado empleado;
	
	
	private String presuproyecto_descripcion;
	private String cuentacontable_descripcion;
	private String cuentacontabledestino_descripcion;
	private String empleado_descripcion;
	
	
		
	public PresuTransferencia () throws Exception {
		super();		
		
		this.id=0L;
		
		
		this.versionRow=new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());//new Date();
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		this.sType="NONE";
		
		this.presutransferenciaOriginal=this;
		
 		this.id_presu_proyecto=-1L;
 		this.id_cuenta_contable=-1L;
 		this.id_cuenta_contable_destino=-1L;
 		this.id_empleado=-1L;
 		this.fecha=new Date();
 		this.valor=0.0;
 		this.descripcion="";
		
		
		this.presuproyecto=null;
		this.cuentacontable=null;
		this.cuentacontabledestino=null;
		this.empleado=null;
		
		
		this.presuproyecto_descripcion="";
		this.cuentacontable_descripcion="";
		this.cuentacontabledestino_descripcion="";
		this.empleado_descripcion="";
		
		
		
			
		
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
    //PARA REPORTES
	public PresuTransferencia (Long id,Date versionRow,Long id_presu_proyecto,Long id_cuenta_contable,Long id_cuenta_contable_destino,Long id_empleado,Date fecha,Double valor,String descripcion) throws Exception {
		super();		
		
		this.id=id;
		this.versionRow=versionRow;
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.presutransferenciaOriginal=this;
		
 		this.id_presu_proyecto=id_presu_proyecto;
 		this.id_cuenta_contable=id_cuenta_contable;
 		this.id_cuenta_contable_destino=id_cuenta_contable_destino;
 		this.id_empleado=id_empleado;
 		this.fecha=fecha;
 		this.valor=valor;
 		this.descripcion=descripcion;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	 //PARA REPORTES
	public PresuTransferencia (Long id_presu_proyecto,Long id_cuenta_contable,Long id_cuenta_contable_destino,Long id_empleado,Date fecha,Double valor,String descripcion) throws Exception {
		super();		
		
		this.id=0L;
		this.versionRow=new Date();
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.presutransferenciaOriginal=this;
		
 		this.id_presu_proyecto=id_presu_proyecto;
 		this.id_cuenta_contable=id_cuenta_contable;
 		this.id_cuenta_contable_destino=id_cuenta_contable_destino;
 		this.id_empleado=id_empleado;
 		this.fecha=fecha;
 		this.valor=valor;
 		this.descripcion=descripcion;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	public boolean equals(Object object) {
		boolean equal=false;
		PresuTransferencia presutransferenciaLocal=null;
		
		if(object!=null) {
			presutransferenciaLocal=(PresuTransferencia)object;
			
			if(presutransferenciaLocal!=null) {
				if(this.getId()!=null && presutransferenciaLocal.getId()!=null) {
					if(this.getId().equals(presutransferenciaLocal.getId())) {
						equal=true;
					}
				}
			}
		}
		
		return equal;
	}
	
	public String toString() {
		String sDetalle="";
		
		if(!PresuTransferenciaConstantesFunciones.CON_DESCRIPCION_DETALLADO) {
        	sDetalle=PresuTransferenciaConstantesFunciones.getPresuTransferenciaDescripcion(this);
		} else {
			sDetalle=PresuTransferenciaConstantesFunciones.getPresuTransferenciaDescripcionDetallado(this);
		}
		
		return sDetalle;
    }
	
	public PresuTransferencia getPresuTransferenciaOriginal() {
		return this.presutransferenciaOriginal;
	}
	
	public void setPresuTransferenciaOriginal(PresuTransferencia presutransferencia) {
		try {
			this.presutransferenciaOriginal=presutransferencia;
		} catch(Exception e) {
			;
		}
	}
	
	
	protected PresuTransferenciaAdditional presutransferenciaAdditional=null;
	
	public PresuTransferenciaAdditional getPresuTransferenciaAdditional() {
		return this.presutransferenciaAdditional;
	}
	
	public void setPresuTransferenciaAdditional(PresuTransferenciaAdditional presutransferenciaAdditional) {
		try {
			this.presutransferenciaAdditional=presutransferenciaAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
    
	
	public Long getid_presu_proyecto() {
		return this.id_presu_proyecto;
	}
    
	
	public Long getid_cuenta_contable() {
		return this.id_cuenta_contable;
	}
    
	
	public Long getid_cuenta_contable_destino() {
		return this.id_cuenta_contable_destino;
	}
    
	
	public Long getid_empleado() {
		return this.id_empleado;
	}
    
	
	public Date getfecha() {
		return this.fecha;
	}
    
	
	public Double getvalor() {
		return this.valor;
	}
    
	
	public String getdescripcion() {
		return this.descripcion;
	}
	
    
	public void setid_presu_proyecto(Long newid_presu_proyecto)throws Exception
	{
		try {
			if(this.id_presu_proyecto!=newid_presu_proyecto) {
				if(newid_presu_proyecto==null) {
					//newid_presu_proyecto=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("PresuTransferencia:Valor nulo no permitido en columna id_presu_proyecto");
					}
				}

				this.id_presu_proyecto=newid_presu_proyecto;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_cuenta_contable(Long newid_cuenta_contable)throws Exception
	{
		try {
			if(this.id_cuenta_contable!=newid_cuenta_contable) {
				if(newid_cuenta_contable==null) {
					//newid_cuenta_contable=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("PresuTransferencia:Valor nulo no permitido en columna id_cuenta_contable");
					}
				}

				this.id_cuenta_contable=newid_cuenta_contable;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_cuenta_contable_destino(Long newid_cuenta_contable_destino)throws Exception
	{
		try {
			if(this.id_cuenta_contable_destino!=newid_cuenta_contable_destino) {
				if(newid_cuenta_contable_destino==null) {
					//newid_cuenta_contable_destino=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("PresuTransferencia:Valor nulo no permitido en columna id_cuenta_contable_destino");
					}
				}

				this.id_cuenta_contable_destino=newid_cuenta_contable_destino;
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
						System.out.println("PresuTransferencia:Valor nulo no permitido en columna id_empleado");
					}
				}

				this.id_empleado=newid_empleado;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setfecha(Date newfecha)throws Exception
	{
		try {
			if(this.fecha!=newfecha) {
				if(newfecha==null) {
					//newfecha=new Date();
					if(Constantes.ISDEVELOPING) {
						System.out.println("PresuTransferencia:Valor nulo no permitido en columna fecha");
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
						System.out.println("PresuTransferencia:Valor nulo no permitido en columna valor");
					}
				}

				this.valor=newvalor;
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
						System.out.println("PresuTransferencia:Valor nulo no permitido en columna descripcion");
					}
				}

				if(newdescripcion!=null&&newdescripcion.length()>200) {
					newdescripcion=newdescripcion.substring(0,198);
					System.out.println("PresuTransferencia:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=200 en columna descripcion");
				}

				this.descripcion=newdescripcion;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	
	public PresuProyecto getPresuProyecto() {
		return this.presuproyecto;
	}

	public CuentaContable getCuentaContable() {
		return this.cuentacontable;
	}

	public CuentaContable getCuentaContableDestino() {
		return this.cuentacontabledestino;
	}

	public Empleado getEmpleado() {
		return this.empleado;
	}

	
	
	public String getpresuproyecto_descripcion() {
		return this.presuproyecto_descripcion;
	}

	public String getcuentacontable_descripcion() {
		return this.cuentacontable_descripcion;
	}

	public String getcuentacontabledestino_descripcion() {
		return this.cuentacontabledestino_descripcion;
	}

	public String getempleado_descripcion() {
		return this.empleado_descripcion;
	}

	
	
	public  void  setPresuProyecto(PresuProyecto presuproyecto) {
		try {
			this.presuproyecto=presuproyecto;
		} catch(Exception e) {
			;
		}
	}


	public  void  setCuentaContable(CuentaContable cuentacontable) {
		try {
			this.cuentacontable=cuentacontable;
		} catch(Exception e) {
			;
		}
	}


	public  void  setCuentaContableDestino(CuentaContable cuentacontabledestino) {
		try {
			this.cuentacontabledestino=cuentacontabledestino;
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


	
	
	public  void  setpresuproyecto_descripcion(String presuproyecto_descripcion) {
		try {
			this.presuproyecto_descripcion=presuproyecto_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  setcuentacontable_descripcion(String cuentacontable_descripcion) {
		try {
			this.cuentacontable_descripcion=cuentacontable_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  setcuentacontabledestino_descripcion(String cuentacontabledestino_descripcion) {
		try {
			this.cuentacontabledestino_descripcion=cuentacontabledestino_descripcion;
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


	
	
	
	
	
	/*PARA REPORTES*/
	String id_presu_proyecto_descripcion="";String id_cuenta_contable_descripcion="";String id_cuenta_contable_destino_descripcion="";String id_empleado_descripcion="";
	
	
	public String getid_presu_proyecto_descripcion() {
		return id_presu_proyecto_descripcion;
	}
	public String getid_cuenta_contable_descripcion() {
		return id_cuenta_contable_descripcion;
	}
	public String getid_cuenta_contable_destino_descripcion() {
		return id_cuenta_contable_destino_descripcion;
	}
	public String getid_empleado_descripcion() {
		return id_empleado_descripcion;
	}
	
	
	public void setid_presu_proyecto_descripcion(String newid_presu_proyecto_descripcion)throws Exception {
		try {
			this.id_presu_proyecto_descripcion=newid_presu_proyecto_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_cuenta_contable_descripcion(String newid_cuenta_contable_descripcion)throws Exception {
		try {
			this.id_cuenta_contable_descripcion=newid_cuenta_contable_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_cuenta_contable_destino_descripcion(String newid_cuenta_contable_destino_descripcion)throws Exception {
		try {
			this.id_cuenta_contable_destino_descripcion=newid_cuenta_contable_destino_descripcion;
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
	
	public void inicializarVariablesParaReporte() {
		this.id_presu_proyecto_descripcion="";this.id_cuenta_contable_descripcion="";this.id_cuenta_contable_destino_descripcion="";this.id_empleado_descripcion="";
	}
	
	
	
	
	
	
	/*PARA REPORTES FIN*/		
}

