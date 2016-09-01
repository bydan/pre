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
//import com.bydan.erp.nomina.util.NovedadNomiConstantesFunciones;
import com.bydan.erp.nomina.util.*;


import com.bydan.erp.seguridad.util.*;



import com.bydan.erp.seguridad.business.entity.*;




@SuppressWarnings("unused")
public class NovedadNomi extends NovedadNomiAdditional implements Serializable ,Cloneable {//NovedadNomiAdditional,GeneralEntity
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
	
	private NovedadNomi novedadnomiOriginal;
	
	private Map<String, Object> mapNovedadNomi;
			
	public Map<String, Object> getMapNovedadNomi() {
		return mapNovedadNomi;
	}

	public void setMapNovedadNomi(Map<String, Object> mapNovedadNomi) {
		this.mapNovedadNomi = mapNovedadNomi;
	}
	
	public void inicializarMapNovedadNomi() {
		this.mapNovedadNomi = new HashMap<String,Object>();
	}
	
	public void setMapNovedadNomiValue(String sKey,Object oValue) {
		this.mapNovedadNomi.put(sKey, oValue);
	}
	
	public Object getMapNovedadNomiValue(String sKey) {
		return this.mapNovedadNomi.get(sKey);
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
	private Long id_empleado_autoriza;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_tipo_novedad_nomi;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_estado_novedad_nomi;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Date fecha;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=10,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONINT)
	private Integer numero_hora;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=10,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONINT)
	private Integer numero_minuto;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=10,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONINT)
	private Integer numero_jornada_trabajo;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=10,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONINT)
	private Integer anio_vacacion;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=250,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=NovedadNomiConstantesFunciones.SREGEXDESCRIPCION,message=NovedadNomiConstantesFunciones.SMENSAJEREGEXDESCRIPCION)
	private String descripcion;
			
	
	public Empresa empresa;
	public Empleado empleado;
	public Empleado empleadoautoriza;
	public TipoNovedadNomi tiponovedadnomi;
	public EstadoNovedadNomi estadonovedadnomi;
	
	
	private String empresa_descripcion;
	private String empleado_descripcion;
	private String empleadoautoriza_descripcion;
	private String tiponovedadnomi_descripcion;
	private String estadonovedadnomi_descripcion;
	
	
		
	public NovedadNomi () throws Exception {
		super();		
		
		this.id=0L;
		
		
		this.versionRow=new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());//new Date();
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		this.sType="NONE";
		
		this.novedadnomiOriginal=this;
		
 		this.id_empresa=-1L;
 		this.id_empleado=-1L;
 		this.id_empleado_autoriza=-1L;
 		this.id_tipo_novedad_nomi=-1L;
 		this.id_estado_novedad_nomi=-1L;
 		this.fecha=new Date();
 		this.numero_hora=0;
 		this.numero_minuto=0;
 		this.numero_jornada_trabajo=0;
 		this.anio_vacacion=0;
 		this.descripcion="";
		
		
		this.empresa=null;
		this.empleado=null;
		this.empleadoautoriza=null;
		this.tiponovedadnomi=null;
		this.estadonovedadnomi=null;
		
		
		this.empresa_descripcion="";
		this.empleado_descripcion="";
		this.empleadoautoriza_descripcion="";
		this.tiponovedadnomi_descripcion="";
		this.estadonovedadnomi_descripcion="";
		
		
		
			
		
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
    //PARA REPORTES
	public NovedadNomi (Long id,Date versionRow,Long id_empresa,Long id_empleado,Long id_empleado_autoriza,Long id_tipo_novedad_nomi,Long id_estado_novedad_nomi,Date fecha,Integer numero_hora,Integer numero_minuto,Integer numero_jornada_trabajo,Integer anio_vacacion,String descripcion) throws Exception {
		super();		
		
		this.id=id;
		this.versionRow=versionRow;
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.novedadnomiOriginal=this;
		
 		this.id_empresa=id_empresa;
 		this.id_empleado=id_empleado;
 		this.id_empleado_autoriza=id_empleado_autoriza;
 		this.id_tipo_novedad_nomi=id_tipo_novedad_nomi;
 		this.id_estado_novedad_nomi=id_estado_novedad_nomi;
 		this.fecha=fecha;
 		this.numero_hora=numero_hora;
 		this.numero_minuto=numero_minuto;
 		this.numero_jornada_trabajo=numero_jornada_trabajo;
 		this.anio_vacacion=anio_vacacion;
 		this.descripcion=descripcion;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	 //PARA REPORTES
	public NovedadNomi (Long id_empresa,Long id_empleado,Long id_empleado_autoriza,Long id_tipo_novedad_nomi,Long id_estado_novedad_nomi,Date fecha,Integer numero_hora,Integer numero_minuto,Integer numero_jornada_trabajo,Integer anio_vacacion,String descripcion) throws Exception {
		super();		
		
		this.id=0L;
		this.versionRow=new Date();
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.novedadnomiOriginal=this;
		
 		this.id_empresa=id_empresa;
 		this.id_empleado=id_empleado;
 		this.id_empleado_autoriza=id_empleado_autoriza;
 		this.id_tipo_novedad_nomi=id_tipo_novedad_nomi;
 		this.id_estado_novedad_nomi=id_estado_novedad_nomi;
 		this.fecha=fecha;
 		this.numero_hora=numero_hora;
 		this.numero_minuto=numero_minuto;
 		this.numero_jornada_trabajo=numero_jornada_trabajo;
 		this.anio_vacacion=anio_vacacion;
 		this.descripcion=descripcion;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	public boolean equals(Object object) {
		boolean equal=false;
		NovedadNomi novedadnomiLocal=null;
		
		if(object!=null) {
			novedadnomiLocal=(NovedadNomi)object;
			
			if(novedadnomiLocal!=null) {
				if(this.getId()!=null && novedadnomiLocal.getId()!=null) {
					if(this.getId().equals(novedadnomiLocal.getId())) {
						equal=true;
					}
				}
			}
		}
		
		return equal;
	}
	
	public String toString() {
		String sDetalle="";
		
		if(!NovedadNomiConstantesFunciones.CON_DESCRIPCION_DETALLADO) {
        	sDetalle=NovedadNomiConstantesFunciones.getNovedadNomiDescripcion(this);
		} else {
			sDetalle=NovedadNomiConstantesFunciones.getNovedadNomiDescripcionDetallado(this);
		}
		
		return sDetalle;
    }
	
	public NovedadNomi getNovedadNomiOriginal() {
		return this.novedadnomiOriginal;
	}
	
	public void setNovedadNomiOriginal(NovedadNomi novedadnomi) {
		try {
			this.novedadnomiOriginal=novedadnomi;
		} catch(Exception e) {
			;
		}
	}
	
	
	protected NovedadNomiAdditional novedadnomiAdditional=null;
	
	public NovedadNomiAdditional getNovedadNomiAdditional() {
		return this.novedadnomiAdditional;
	}
	
	public void setNovedadNomiAdditional(NovedadNomiAdditional novedadnomiAdditional) {
		try {
			this.novedadnomiAdditional=novedadnomiAdditional;
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
    
	
	public Long getid_empleado_autoriza() {
		return this.id_empleado_autoriza;
	}
    
	
	public Long getid_tipo_novedad_nomi() {
		return this.id_tipo_novedad_nomi;
	}
    
	
	public Long getid_estado_novedad_nomi() {
		return this.id_estado_novedad_nomi;
	}
    
	
	public Date getfecha() {
		return this.fecha;
	}
    
	
	public Integer getnumero_hora() {
		return this.numero_hora;
	}
    
	
	public Integer getnumero_minuto() {
		return this.numero_minuto;
	}
    
	
	public Integer getnumero_jornada_trabajo() {
		return this.numero_jornada_trabajo;
	}
    
	
	public Integer getanio_vacacion() {
		return this.anio_vacacion;
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
						System.out.println("NovedadNomi:Valor nulo no permitido en columna id_empresa");
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
						System.out.println("NovedadNomi:Valor nulo no permitido en columna id_empleado");
					}
				}

				this.id_empleado=newid_empleado;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_empleado_autoriza(Long newid_empleado_autoriza)throws Exception
	{
		try {
			if(this.id_empleado_autoriza!=newid_empleado_autoriza) {
				if(newid_empleado_autoriza==null) {
					//newid_empleado_autoriza=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("NovedadNomi:Valor nulo no permitido en columna id_empleado_autoriza");
					}
				}

				this.id_empleado_autoriza=newid_empleado_autoriza;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_tipo_novedad_nomi(Long newid_tipo_novedad_nomi)throws Exception
	{
		try {
			if(this.id_tipo_novedad_nomi!=newid_tipo_novedad_nomi) {
				if(newid_tipo_novedad_nomi==null) {
					//newid_tipo_novedad_nomi=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("NovedadNomi:Valor nulo no permitido en columna id_tipo_novedad_nomi");
					}
				}

				this.id_tipo_novedad_nomi=newid_tipo_novedad_nomi;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_estado_novedad_nomi(Long newid_estado_novedad_nomi)throws Exception
	{
		try {
			if(this.id_estado_novedad_nomi!=newid_estado_novedad_nomi) {
				if(newid_estado_novedad_nomi==null) {
					//newid_estado_novedad_nomi=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("NovedadNomi:Valor nulo no permitido en columna id_estado_novedad_nomi");
					}
				}

				this.id_estado_novedad_nomi=newid_estado_novedad_nomi;
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
						System.out.println("NovedadNomi:Valor nulo no permitido en columna fecha");
					}
				}

				this.fecha=newfecha;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setnumero_hora(Integer newnumero_hora)throws Exception
	{
		try {
			if(this.numero_hora!=newnumero_hora) {
				if(newnumero_hora==null) {
					//newnumero_hora=0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("NovedadNomi:Valor nulo no permitido en columna numero_hora");
					}
				}

				this.numero_hora=newnumero_hora;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setnumero_minuto(Integer newnumero_minuto)throws Exception
	{
		try {
			if(this.numero_minuto!=newnumero_minuto) {
				if(newnumero_minuto==null) {
					//newnumero_minuto=0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("NovedadNomi:Valor nulo no permitido en columna numero_minuto");
					}
				}

				this.numero_minuto=newnumero_minuto;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setnumero_jornada_trabajo(Integer newnumero_jornada_trabajo)throws Exception
	{
		try {
			if(this.numero_jornada_trabajo!=newnumero_jornada_trabajo) {
				if(newnumero_jornada_trabajo==null) {
					//newnumero_jornada_trabajo=0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("NovedadNomi:Valor nulo no permitido en columna numero_jornada_trabajo");
					}
				}

				this.numero_jornada_trabajo=newnumero_jornada_trabajo;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setanio_vacacion(Integer newanio_vacacion)throws Exception
	{
		try {
			if(this.anio_vacacion!=newanio_vacacion) {
				if(newanio_vacacion==null) {
					//newanio_vacacion=0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("NovedadNomi:Valor nulo no permitido en columna anio_vacacion");
					}
				}

				this.anio_vacacion=newanio_vacacion;
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
						System.out.println("NovedadNomi:Valor nulo no permitido en columna descripcion");
					}
				}

				if(newdescripcion!=null&&newdescripcion.length()>250) {
					newdescripcion=newdescripcion.substring(0,248);
					System.out.println("NovedadNomi:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=250 en columna descripcion");
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

	public Empleado getEmpleado() {
		return this.empleado;
	}

	public Empleado getEmpleadoAutoriza() {
		return this.empleadoautoriza;
	}

	public TipoNovedadNomi getTipoNovedadNomi() {
		return this.tiponovedadnomi;
	}

	public EstadoNovedadNomi getEstadoNovedadNomi() {
		return this.estadonovedadnomi;
	}

	
	
	public String getempresa_descripcion() {
		return this.empresa_descripcion;
	}

	public String getempleado_descripcion() {
		return this.empleado_descripcion;
	}

	public String getempleadoautoriza_descripcion() {
		return this.empleadoautoriza_descripcion;
	}

	public String gettiponovedadnomi_descripcion() {
		return this.tiponovedadnomi_descripcion;
	}

	public String getestadonovedadnomi_descripcion() {
		return this.estadonovedadnomi_descripcion;
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


	public  void  setEmpleadoAutoriza(Empleado empleadoautoriza) {
		try {
			this.empleadoautoriza=empleadoautoriza;
		} catch(Exception e) {
			;
		}
	}


	public  void  setTipoNovedadNomi(TipoNovedadNomi tiponovedadnomi) {
		try {
			this.tiponovedadnomi=tiponovedadnomi;
		} catch(Exception e) {
			;
		}
	}


	public  void  setEstadoNovedadNomi(EstadoNovedadNomi estadonovedadnomi) {
		try {
			this.estadonovedadnomi=estadonovedadnomi;
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


	public  void  setempleadoautoriza_descripcion(String empleadoautoriza_descripcion) {
		try {
			this.empleadoautoriza_descripcion=empleadoautoriza_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  settiponovedadnomi_descripcion(String tiponovedadnomi_descripcion) {
		try {
			this.tiponovedadnomi_descripcion=tiponovedadnomi_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  setestadonovedadnomi_descripcion(String estadonovedadnomi_descripcion) {
		try {
			this.estadonovedadnomi_descripcion=estadonovedadnomi_descripcion;
		} catch(Exception e) {
			;
		}
	}


	
	
	
	
	
	/*PARA REPORTES*/
	String id_empresa_descripcion="";String id_empleado_descripcion="";String id_empleado_autoriza_descripcion="";String id_tipo_novedad_nomi_descripcion="";String id_estado_novedad_nomi_descripcion="";
	
	
	public String getid_empresa_descripcion() {
		return id_empresa_descripcion;
	}
	public String getid_empleado_descripcion() {
		return id_empleado_descripcion;
	}
	public String getid_empleado_autoriza_descripcion() {
		return id_empleado_autoriza_descripcion;
	}
	public String getid_tipo_novedad_nomi_descripcion() {
		return id_tipo_novedad_nomi_descripcion;
	}
	public String getid_estado_novedad_nomi_descripcion() {
		return id_estado_novedad_nomi_descripcion;
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
	public void setid_empleado_autoriza_descripcion(String newid_empleado_autoriza_descripcion)throws Exception {
		try {
			this.id_empleado_autoriza_descripcion=newid_empleado_autoriza_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_tipo_novedad_nomi_descripcion(String newid_tipo_novedad_nomi_descripcion)throws Exception {
		try {
			this.id_tipo_novedad_nomi_descripcion=newid_tipo_novedad_nomi_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_estado_novedad_nomi_descripcion(String newid_estado_novedad_nomi_descripcion)throws Exception {
		try {
			this.id_estado_novedad_nomi_descripcion=newid_estado_novedad_nomi_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	
	public void inicializarVariablesParaReporte() {
		this.id_empresa_descripcion="";this.id_empleado_descripcion="";this.id_empleado_autoriza_descripcion="";this.id_tipo_novedad_nomi_descripcion="";this.id_estado_novedad_nomi_descripcion="";
	}
	
	
	
	
	
	
	/*PARA REPORTES FIN*/		
}

