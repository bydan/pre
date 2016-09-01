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
package com.bydan.erp.inventario.business.entity;

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
//import com.bydan.erp.inventario.util.ControlVehiculoConstantesFunciones;
import com.bydan.erp.inventario.util.*;


import com.bydan.erp.seguridad.util.*;



import com.bydan.erp.seguridad.business.entity.*;




@SuppressWarnings("unused")
public class ControlVehiculo extends ControlVehiculoAdditional implements Serializable ,Cloneable {//ControlVehiculoAdditional,GeneralEntity
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
	
	private ControlVehiculo controlvehiculoOriginal;
	
	private Map<String, Object> mapControlVehiculo;
			
	public Map<String, Object> getMapControlVehiculo() {
		return mapControlVehiculo;
	}

	public void setMapControlVehiculo(Map<String, Object> mapControlVehiculo) {
		this.mapControlVehiculo = mapControlVehiculo;
	}
	
	public void inicializarMapControlVehiculo() {
		this.mapControlVehiculo = new HashMap<String,Object>();
	}
	
	public void setMapControlVehiculoValue(String sKey,Object oValue) {
		this.mapControlVehiculo.put(sKey, oValue);
	}
	
	public Object getMapControlVehiculoValue(String sKey) {
		return this.mapControlVehiculo.get(sKey);
	}
	
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_empresa;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=150,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=ControlVehiculoConstantesFunciones.SREGEXNOMBRE_CONDUCTOR,message=ControlVehiculoConstantesFunciones.SMENSAJEREGEXNOMBRE_CONDUCTOR)
	private String nombre_conductor;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=150,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=ControlVehiculoConstantesFunciones.SREGEXNUMERO_PLACA,message=ControlVehiculoConstantesFunciones.SMENSAJEREGEXNUMERO_PLACA)
	private String numero_placa;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Date fecha_entrada;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Date fecha_salida;
			
	
	public Empresa empresa;
	
	
	private String empresa_descripcion;
	
	
		
	public ControlVehiculo () throws Exception {
		super();		
		
		this.id=0L;
		
		
		this.versionRow=new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());//new Date();
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		this.sType="NONE";
		
		this.controlvehiculoOriginal=this;
		
 		this.id_empresa=-1L;
 		this.nombre_conductor="";
 		this.numero_placa="";
 		this.fecha_entrada=new Date();
 		this.fecha_salida=new Date();
		
		
		this.empresa=null;
		
		
		this.empresa_descripcion="";
		
		
		
			
		
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
    //PARA REPORTES
	public ControlVehiculo (Long id,Date versionRow,Long id_empresa,String nombre_conductor,String numero_placa,Date fecha_entrada,Date fecha_salida) throws Exception {
		super();		
		
		this.id=id;
		this.versionRow=versionRow;
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.controlvehiculoOriginal=this;
		
 		this.id_empresa=id_empresa;
 		this.nombre_conductor=nombre_conductor;
 		this.numero_placa=numero_placa;
 		this.fecha_entrada=fecha_entrada;
 		this.fecha_salida=fecha_salida;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	 //PARA REPORTES
	public ControlVehiculo (Long id_empresa,String nombre_conductor,String numero_placa,Date fecha_entrada,Date fecha_salida) throws Exception {
		super();		
		
		this.id=0L;
		this.versionRow=new Date();
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.controlvehiculoOriginal=this;
		
 		this.id_empresa=id_empresa;
 		this.nombre_conductor=nombre_conductor;
 		this.numero_placa=numero_placa;
 		this.fecha_entrada=fecha_entrada;
 		this.fecha_salida=fecha_salida;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	public boolean equals(Object object) {
		boolean equal=false;
		ControlVehiculo controlvehiculoLocal=null;
		
		if(object!=null) {
			controlvehiculoLocal=(ControlVehiculo)object;
			
			if(controlvehiculoLocal!=null) {
				if(this.getId()!=null && controlvehiculoLocal.getId()!=null) {
					if(this.getId().equals(controlvehiculoLocal.getId())) {
						equal=true;
					}
				}
			}
		}
		
		return equal;
	}
	
	public String toString() {
		String sDetalle="";
		
		if(!ControlVehiculoConstantesFunciones.CON_DESCRIPCION_DETALLADO) {
        	sDetalle=ControlVehiculoConstantesFunciones.getControlVehiculoDescripcion(this);
		} else {
			sDetalle=ControlVehiculoConstantesFunciones.getControlVehiculoDescripcionDetallado(this);
		}
		
		return sDetalle;
    }
	
	public ControlVehiculo getControlVehiculoOriginal() {
		return this.controlvehiculoOriginal;
	}
	
	public void setControlVehiculoOriginal(ControlVehiculo controlvehiculo) {
		try {
			this.controlvehiculoOriginal=controlvehiculo;
		} catch(Exception e) {
			;
		}
	}
	
	
	protected ControlVehiculoAdditional controlvehiculoAdditional=null;
	
	public ControlVehiculoAdditional getControlVehiculoAdditional() {
		return this.controlvehiculoAdditional;
	}
	
	public void setControlVehiculoAdditional(ControlVehiculoAdditional controlvehiculoAdditional) {
		try {
			this.controlvehiculoAdditional=controlvehiculoAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
    
	
	public Long getid_empresa() {
		return this.id_empresa;
	}
    
	
	public String getnombre_conductor() {
		return this.nombre_conductor;
	}
    
	
	public String getnumero_placa() {
		return this.numero_placa;
	}
    
	
	public Date getfecha_entrada() {
		return this.fecha_entrada;
	}
    
	
	public Date getfecha_salida() {
		return this.fecha_salida;
	}
	
    
	public void setid_empresa(Long newid_empresa)throws Exception
	{
		try {
			if(this.id_empresa!=newid_empresa) {
				if(newid_empresa==null) {
					//newid_empresa=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ControlVehiculo:Valor nulo no permitido en columna id_empresa");
					}
				}

				this.id_empresa=newid_empresa;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setnombre_conductor(String newnombre_conductor)throws Exception
	{
		try {
			if(this.nombre_conductor!=newnombre_conductor) {
				if(newnombre_conductor==null) {
					//newnombre_conductor="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("ControlVehiculo:Valor nulo no permitido en columna nombre_conductor");
					}
				}

				if(newnombre_conductor!=null&&newnombre_conductor.length()>150) {
					newnombre_conductor=newnombre_conductor.substring(0,148);
					System.out.println("ControlVehiculo:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=150 en columna nombre_conductor");
				}

				this.nombre_conductor=newnombre_conductor;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setnumero_placa(String newnumero_placa)throws Exception
	{
		try {
			if(this.numero_placa!=newnumero_placa) {
				if(newnumero_placa==null) {
					//newnumero_placa="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("ControlVehiculo:Valor nulo no permitido en columna numero_placa");
					}
				}

				if(newnumero_placa!=null&&newnumero_placa.length()>150) {
					newnumero_placa=newnumero_placa.substring(0,148);
					System.out.println("ControlVehiculo:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=150 en columna numero_placa");
				}

				this.numero_placa=newnumero_placa;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setfecha_entrada(Date newfecha_entrada)throws Exception
	{
		try {
			if(this.fecha_entrada!=newfecha_entrada) {
				if(newfecha_entrada==null) {
					//newfecha_entrada=new Date();
					if(Constantes.ISDEVELOPING) {
						System.out.println("ControlVehiculo:Valor nulo no permitido en columna fecha_entrada");
					}
				}

				this.fecha_entrada=newfecha_entrada;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setfecha_salida(Date newfecha_salida)throws Exception
	{
		try {
			if(this.fecha_salida!=newfecha_salida) {
				if(newfecha_salida==null) {
					//newfecha_salida=new Date();
					if(Constantes.ISDEVELOPING) {
						System.out.println("ControlVehiculo:Valor nulo no permitido en columna fecha_salida");
					}
				}

				this.fecha_salida=newfecha_salida;
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
	String id_empresa_descripcion="";
	
	
	public String getid_empresa_descripcion() {
		return id_empresa_descripcion;
	}
	
	
	public void setid_empresa_descripcion(String newid_empresa_descripcion)throws Exception {
		try {
			this.id_empresa_descripcion=newid_empresa_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	
	public void inicializarVariablesParaReporte() {
		this.id_empresa_descripcion="";
	}
	
	
	
	
	
	
	/*PARA REPORTES FIN*/		
}

