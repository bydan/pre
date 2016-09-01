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


import java.sql.Time;

import org.hibernate.validator.*;

import com.bydan.framework.erp.business.entity.*;
import com.bydan.framework.erp.business.entity.DatoGeneral;
import com.bydan.framework.erp.business.dataaccess.ConstantesSql;
//import com.bydan.framework.erp.business.entity.Mensajes;
import com.bydan.framework.erp.util.Constantes;
import com.bydan.framework.erp.util.ConstantesValidacion;
//import com.bydan.erp.nomina.util.TurnoConstantesFunciones;
import com.bydan.erp.nomina.util.*;


import com.bydan.erp.seguridad.util.*;



import com.bydan.erp.seguridad.business.entity.*;




@SuppressWarnings("unused")
public class Turno extends TurnoAdditional implements Serializable ,Cloneable {//TurnoAdditional,GeneralEntity
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
	
	private Turno turnoOriginal;
	
	private Map<String, Object> mapTurno;
			
	public Map<String, Object> getMapTurno() {
		return mapTurno;
	}

	public void setMapTurno(Map<String, Object> mapTurno) {
		this.mapTurno = mapTurno;
	}
	
	public void inicializarMapTurno() {
		this.mapTurno = new HashMap<String,Object>();
	}
	
	public void setMapTurnoValue(String sKey,Object oValue) {
		this.mapTurno.put(sKey, oValue);
	}
	
	public Object getMapTurnoValue(String sKey) {
		return this.mapTurno.get(sKey);
	}
	
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_empresa;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Time hora_entrada;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Time hora_salida;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Time hora_ingreso_receso;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Time hora_salida_receso;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Time hora_durante_receso;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Time hora_ingreso_almuerzo;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Time hora_salida_almuerzo;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Time hora_durante_almuerzo;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Time hora_ingreso25;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Time hora_salida25;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Time hora_ingreso50;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Time hora_salida50;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Time hora_ingreso100;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Time hora_salida100;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Time hora_ingreso200;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Time hora_salida200;
			
	
	public Empresa empresa;
	
	
	private String empresa_descripcion;
	
	
		
	public Turno () throws Exception {
		super();		
		
		this.id=0L;
		
		
		this.versionRow=new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());//new Date();
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		this.sType="NONE";
		
		this.turnoOriginal=this;
		
 		this.id_empresa=-1L;
 		this.hora_entrada=new Time((new Date()).getTime());
 		this.hora_salida=new Time((new Date()).getTime());
 		this.hora_ingreso_receso=new Time((new Date()).getTime());
 		this.hora_salida_receso=new Time((new Date()).getTime());
 		this.hora_durante_receso=new Time((new Date()).getTime());
 		this.hora_ingreso_almuerzo=new Time((new Date()).getTime());
 		this.hora_salida_almuerzo=new Time((new Date()).getTime());
 		this.hora_durante_almuerzo=new Time((new Date()).getTime());
 		this.hora_ingreso25=new Time((new Date()).getTime());
 		this.hora_salida25=new Time((new Date()).getTime());
 		this.hora_ingreso50=new Time((new Date()).getTime());
 		this.hora_salida50=new Time((new Date()).getTime());
 		this.hora_ingreso100=new Time((new Date()).getTime());
 		this.hora_salida100=new Time((new Date()).getTime());
 		this.hora_ingreso200=new Time((new Date()).getTime());
 		this.hora_salida200=new Time((new Date()).getTime());
		
		
		this.empresa=null;
		
		
		this.empresa_descripcion="";
		
		
		
			
		
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
    //PARA REPORTES
	public Turno (Long id,Date versionRow,Long id_empresa,Time hora_entrada,Time hora_salida,Time hora_ingreso_receso,Time hora_salida_receso,Time hora_durante_receso,Time hora_ingreso_almuerzo,Time hora_salida_almuerzo,Time hora_durante_almuerzo,Time hora_ingreso25,Time hora_salida25,Time hora_ingreso50,Time hora_salida50,Time hora_ingreso100,Time hora_salida100,Time hora_ingreso200,Time hora_salida200) throws Exception {
		super();		
		
		this.id=id;
		this.versionRow=versionRow;
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.turnoOriginal=this;
		
 		this.id_empresa=id_empresa;
 		this.hora_entrada=hora_entrada;
 		this.hora_salida=hora_salida;
 		this.hora_ingreso_receso=hora_ingreso_receso;
 		this.hora_salida_receso=hora_salida_receso;
 		this.hora_durante_receso=hora_durante_receso;
 		this.hora_ingreso_almuerzo=hora_ingreso_almuerzo;
 		this.hora_salida_almuerzo=hora_salida_almuerzo;
 		this.hora_durante_almuerzo=hora_durante_almuerzo;
 		this.hora_ingreso25=hora_ingreso25;
 		this.hora_salida25=hora_salida25;
 		this.hora_ingreso50=hora_ingreso50;
 		this.hora_salida50=hora_salida50;
 		this.hora_ingreso100=hora_ingreso100;
 		this.hora_salida100=hora_salida100;
 		this.hora_ingreso200=hora_ingreso200;
 		this.hora_salida200=hora_salida200;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	 //PARA REPORTES
	public Turno (Long id_empresa,Time hora_entrada,Time hora_salida,Time hora_ingreso_receso,Time hora_salida_receso,Time hora_durante_receso,Time hora_ingreso_almuerzo,Time hora_salida_almuerzo,Time hora_durante_almuerzo,Time hora_ingreso25,Time hora_salida25,Time hora_ingreso50,Time hora_salida50,Time hora_ingreso100,Time hora_salida100,Time hora_ingreso200,Time hora_salida200) throws Exception {
		super();		
		
		this.id=0L;
		this.versionRow=new Date();
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.turnoOriginal=this;
		
 		this.id_empresa=id_empresa;
 		this.hora_entrada=hora_entrada;
 		this.hora_salida=hora_salida;
 		this.hora_ingreso_receso=hora_ingreso_receso;
 		this.hora_salida_receso=hora_salida_receso;
 		this.hora_durante_receso=hora_durante_receso;
 		this.hora_ingreso_almuerzo=hora_ingreso_almuerzo;
 		this.hora_salida_almuerzo=hora_salida_almuerzo;
 		this.hora_durante_almuerzo=hora_durante_almuerzo;
 		this.hora_ingreso25=hora_ingreso25;
 		this.hora_salida25=hora_salida25;
 		this.hora_ingreso50=hora_ingreso50;
 		this.hora_salida50=hora_salida50;
 		this.hora_ingreso100=hora_ingreso100;
 		this.hora_salida100=hora_salida100;
 		this.hora_ingreso200=hora_ingreso200;
 		this.hora_salida200=hora_salida200;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	public boolean equals(Object object) {
		boolean equal=false;
		Turno turnoLocal=null;
		
		if(object!=null) {
			turnoLocal=(Turno)object;
			
			if(turnoLocal!=null) {
				if(this.getId()!=null && turnoLocal.getId()!=null) {
					if(this.getId().equals(turnoLocal.getId())) {
						equal=true;
					}
				}
			}
		}
		
		return equal;
	}
	
	public String toString() {
		String sDetalle="";
		
		if(!TurnoConstantesFunciones.CON_DESCRIPCION_DETALLADO) {
        	sDetalle=TurnoConstantesFunciones.getTurnoDescripcion(this);
		} else {
			sDetalle=TurnoConstantesFunciones.getTurnoDescripcionDetallado(this);
		}
		
		return sDetalle;
    }
	
	public Turno getTurnoOriginal() {
		return this.turnoOriginal;
	}
	
	public void setTurnoOriginal(Turno turno) {
		try {
			this.turnoOriginal=turno;
		} catch(Exception e) {
			;
		}
	}
	
	
	protected TurnoAdditional turnoAdditional=null;
	
	public TurnoAdditional getTurnoAdditional() {
		return this.turnoAdditional;
	}
	
	public void setTurnoAdditional(TurnoAdditional turnoAdditional) {
		try {
			this.turnoAdditional=turnoAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
    
	
	public Long getid_empresa() {
		return this.id_empresa;
	}
    
	
	public Time gethora_entrada() {
		return this.hora_entrada;
	}
    
	
	public Time gethora_salida() {
		return this.hora_salida;
	}
    
	
	public Time gethora_ingreso_receso() {
		return this.hora_ingreso_receso;
	}
    
	
	public Time gethora_salida_receso() {
		return this.hora_salida_receso;
	}
    
	
	public Time gethora_durante_receso() {
		return this.hora_durante_receso;
	}
    
	
	public Time gethora_ingreso_almuerzo() {
		return this.hora_ingreso_almuerzo;
	}
    
	
	public Time gethora_salida_almuerzo() {
		return this.hora_salida_almuerzo;
	}
    
	
	public Time gethora_durante_almuerzo() {
		return this.hora_durante_almuerzo;
	}
    
	
	public Time gethora_ingreso25() {
		return this.hora_ingreso25;
	}
    
	
	public Time gethora_salida25() {
		return this.hora_salida25;
	}
    
	
	public Time gethora_ingreso50() {
		return this.hora_ingreso50;
	}
    
	
	public Time gethora_salida50() {
		return this.hora_salida50;
	}
    
	
	public Time gethora_ingreso100() {
		return this.hora_ingreso100;
	}
    
	
	public Time gethora_salida100() {
		return this.hora_salida100;
	}
    
	
	public Time gethora_ingreso200() {
		return this.hora_ingreso200;
	}
    
	
	public Time gethora_salida200() {
		return this.hora_salida200;
	}
	
    
	public void setid_empresa(Long newid_empresa)throws Exception
	{
		try {
			if(this.id_empresa!=newid_empresa) {
				if(newid_empresa==null) {
					//newid_empresa=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("Turno:Valor nulo no permitido en columna id_empresa");
					}
				}

				this.id_empresa=newid_empresa;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void sethora_entrada(Time newhora_entrada)throws Exception
	{
		try {
			if(this.hora_entrada!=newhora_entrada) {
				if(newhora_entrada==null) {
					//newhora_entrada=new Time((new Date()).getTime());
					if(Constantes.ISDEVELOPING) {
						System.out.println("Turno:Valor nulo no permitido en columna hora_entrada");
					}
				}

				this.hora_entrada=newhora_entrada;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void sethora_salida(Time newhora_salida)throws Exception
	{
		try {
			if(this.hora_salida!=newhora_salida) {
				if(newhora_salida==null) {
					//newhora_salida=new Time((new Date()).getTime());
					if(Constantes.ISDEVELOPING) {
						System.out.println("Turno:Valor nulo no permitido en columna hora_salida");
					}
				}

				this.hora_salida=newhora_salida;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void sethora_ingreso_receso(Time newhora_ingreso_receso)throws Exception
	{
		try {
			if(this.hora_ingreso_receso!=newhora_ingreso_receso) {
				if(newhora_ingreso_receso==null) {
					//newhora_ingreso_receso=new Time((new Date()).getTime());
					if(Constantes.ISDEVELOPING) {
						System.out.println("Turno:Valor nulo no permitido en columna hora_ingreso_receso");
					}
				}

				this.hora_ingreso_receso=newhora_ingreso_receso;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void sethora_salida_receso(Time newhora_salida_receso)throws Exception
	{
		try {
			if(this.hora_salida_receso!=newhora_salida_receso) {
				if(newhora_salida_receso==null) {
					//newhora_salida_receso=new Time((new Date()).getTime());
					if(Constantes.ISDEVELOPING) {
						System.out.println("Turno:Valor nulo no permitido en columna hora_salida_receso");
					}
				}

				this.hora_salida_receso=newhora_salida_receso;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void sethora_durante_receso(Time newhora_durante_receso)throws Exception
	{
		try {
			if(this.hora_durante_receso!=newhora_durante_receso) {
				if(newhora_durante_receso==null) {
					//newhora_durante_receso=new Time((new Date()).getTime());
					if(Constantes.ISDEVELOPING) {
						System.out.println("Turno:Valor nulo no permitido en columna hora_durante_receso");
					}
				}

				this.hora_durante_receso=newhora_durante_receso;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void sethora_ingreso_almuerzo(Time newhora_ingreso_almuerzo)throws Exception
	{
		try {
			if(this.hora_ingreso_almuerzo!=newhora_ingreso_almuerzo) {
				if(newhora_ingreso_almuerzo==null) {
					//newhora_ingreso_almuerzo=new Time((new Date()).getTime());
					if(Constantes.ISDEVELOPING) {
						System.out.println("Turno:Valor nulo no permitido en columna hora_ingreso_almuerzo");
					}
				}

				this.hora_ingreso_almuerzo=newhora_ingreso_almuerzo;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void sethora_salida_almuerzo(Time newhora_salida_almuerzo)throws Exception
	{
		try {
			if(this.hora_salida_almuerzo!=newhora_salida_almuerzo) {
				if(newhora_salida_almuerzo==null) {
					//newhora_salida_almuerzo=new Time((new Date()).getTime());
					if(Constantes.ISDEVELOPING) {
						System.out.println("Turno:Valor nulo no permitido en columna hora_salida_almuerzo");
					}
				}

				this.hora_salida_almuerzo=newhora_salida_almuerzo;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void sethora_durante_almuerzo(Time newhora_durante_almuerzo)throws Exception
	{
		try {
			if(this.hora_durante_almuerzo!=newhora_durante_almuerzo) {
				if(newhora_durante_almuerzo==null) {
					//newhora_durante_almuerzo=new Time((new Date()).getTime());
					if(Constantes.ISDEVELOPING) {
						System.out.println("Turno:Valor nulo no permitido en columna hora_durante_almuerzo");
					}
				}

				this.hora_durante_almuerzo=newhora_durante_almuerzo;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void sethora_ingreso25(Time newhora_ingreso25)throws Exception
	{
		try {
			if(this.hora_ingreso25!=newhora_ingreso25) {
				if(newhora_ingreso25==null) {
					//newhora_ingreso25=new Time((new Date()).getTime());
					if(Constantes.ISDEVELOPING) {
						System.out.println("Turno:Valor nulo no permitido en columna hora_ingreso25");
					}
				}

				this.hora_ingreso25=newhora_ingreso25;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void sethora_salida25(Time newhora_salida25)throws Exception
	{
		try {
			if(this.hora_salida25!=newhora_salida25) {
				if(newhora_salida25==null) {
					//newhora_salida25=new Time((new Date()).getTime());
					if(Constantes.ISDEVELOPING) {
						System.out.println("Turno:Valor nulo no permitido en columna hora_salida25");
					}
				}

				this.hora_salida25=newhora_salida25;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void sethora_ingreso50(Time newhora_ingreso50)throws Exception
	{
		try {
			if(this.hora_ingreso50!=newhora_ingreso50) {
				if(newhora_ingreso50==null) {
					//newhora_ingreso50=new Time((new Date()).getTime());
					if(Constantes.ISDEVELOPING) {
						System.out.println("Turno:Valor nulo no permitido en columna hora_ingreso50");
					}
				}

				this.hora_ingreso50=newhora_ingreso50;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void sethora_salida50(Time newhora_salida50)throws Exception
	{
		try {
			if(this.hora_salida50!=newhora_salida50) {
				if(newhora_salida50==null) {
					//newhora_salida50=new Time((new Date()).getTime());
					if(Constantes.ISDEVELOPING) {
						System.out.println("Turno:Valor nulo no permitido en columna hora_salida50");
					}
				}

				this.hora_salida50=newhora_salida50;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void sethora_ingreso100(Time newhora_ingreso100)throws Exception
	{
		try {
			if(this.hora_ingreso100!=newhora_ingreso100) {
				if(newhora_ingreso100==null) {
					//newhora_ingreso100=new Time((new Date()).getTime());
					if(Constantes.ISDEVELOPING) {
						System.out.println("Turno:Valor nulo no permitido en columna hora_ingreso100");
					}
				}

				this.hora_ingreso100=newhora_ingreso100;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void sethora_salida100(Time newhora_salida100)throws Exception
	{
		try {
			if(this.hora_salida100!=newhora_salida100) {
				if(newhora_salida100==null) {
					//newhora_salida100=new Time((new Date()).getTime());
					if(Constantes.ISDEVELOPING) {
						System.out.println("Turno:Valor nulo no permitido en columna hora_salida100");
					}
				}

				this.hora_salida100=newhora_salida100;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void sethora_ingreso200(Time newhora_ingreso200)throws Exception
	{
		try {
			if(this.hora_ingreso200!=newhora_ingreso200) {
				if(newhora_ingreso200==null) {
					//newhora_ingreso200=new Time((new Date()).getTime());
					if(Constantes.ISDEVELOPING) {
						System.out.println("Turno:Valor nulo no permitido en columna hora_ingreso200");
					}
				}

				this.hora_ingreso200=newhora_ingreso200;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void sethora_salida200(Time newhora_salida200)throws Exception
	{
		try {
			if(this.hora_salida200!=newhora_salida200) {
				if(newhora_salida200==null) {
					//newhora_salida200=new Time((new Date()).getTime());
					if(Constantes.ISDEVELOPING) {
						System.out.println("Turno:Valor nulo no permitido en columna hora_salida200");
					}
				}

				this.hora_salida200=newhora_salida200;
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

