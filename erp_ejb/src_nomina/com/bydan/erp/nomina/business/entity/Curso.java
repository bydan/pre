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
//import com.bydan.erp.nomina.util.CursoConstantesFunciones;
import com.bydan.erp.nomina.util.*;


import com.bydan.erp.seguridad.util.*;



import com.bydan.erp.seguridad.business.entity.*;




@SuppressWarnings("unused")
public class Curso extends CursoAdditional implements Serializable ,Cloneable {//CursoAdditional,GeneralEntity
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
	
	private Curso cursoOriginal;
	
	private Map<String, Object> mapCurso;
			
	public Map<String, Object> getMapCurso() {
		return mapCurso;
	}

	public void setMapCurso(Map<String, Object> mapCurso) {
		this.mapCurso = mapCurso;
	}
	
	public void inicializarMapCurso() {
		this.mapCurso = new HashMap<String,Object>();
	}
	
	public void setMapCursoValue(String sKey,Object oValue) {
		this.mapCurso.put(sKey, oValue);
	}
	
	public Object getMapCursoValue(String sKey) {
		return this.mapCurso.get(sKey);
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
	private Long id_tipo_curso;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_tipo_institucion;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=100,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=CursoConstantesFunciones.SREGEXNOMBRE,message=CursoConstantesFunciones.SMENSAJEREGEXNOMBRE)
	private String nombre;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=50,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=CursoConstantesFunciones.SREGEXCODIGO_INSCRIPCION,message=CursoConstantesFunciones.SMENSAJEREGEXCODIGO_INSCRIPCION)
	private String codigo_inscripcion;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Date fecha_inicio;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Date fecha_fin;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=10,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONINT)
	private Integer numero_horas;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Boolean es_aprobado;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Boolean es_auspicio_empresa;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=100,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=CursoConstantesFunciones.SREGEXDESCRIPCION,message=CursoConstantesFunciones.SMENSAJEREGEXDESCRIPCION)
	private String descripcion;
			
	
	public Empresa empresa;
	public Empleado empleado;
	public TipoCurso tipocurso;
	public TipoInstitucion tipoinstitucion;
	
	
	private String empresa_descripcion;
	private String empleado_descripcion;
	private String tipocurso_descripcion;
	private String tipoinstitucion_descripcion;
	
	
	public List<DetalleCurso> detallecursos;
		
	public Curso () throws Exception {
		super();		
		
		this.id=0L;
		
		
		this.versionRow=new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());//new Date();
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		this.sType="NONE";
		
		this.cursoOriginal=this;
		
 		this.id_empresa=-1L;
 		this.id_empleado=-1L;
 		this.id_tipo_curso=-1L;
 		this.id_tipo_institucion=-1L;
 		this.nombre="";
 		this.codigo_inscripcion="";
 		this.fecha_inicio=new Date();
 		this.fecha_fin=new Date();
 		this.numero_horas=0;
 		this.es_aprobado=false;
 		this.es_auspicio_empresa=false;
 		this.descripcion="";
		
		
		this.empresa=null;
		this.empleado=null;
		this.tipocurso=null;
		this.tipoinstitucion=null;
		
		
		this.empresa_descripcion="";
		this.empleado_descripcion="";
		this.tipocurso_descripcion="";
		this.tipoinstitucion_descripcion="";
		
		
		this.detallecursos=null;
		
			
		
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
    //PARA REPORTES
	public Curso (Long id,Date versionRow,Long id_empresa,Long id_empleado,Long id_tipo_curso,Long id_tipo_institucion,String nombre,String codigo_inscripcion,Date fecha_inicio,Date fecha_fin,Integer numero_horas,Boolean es_aprobado,Boolean es_auspicio_empresa,String descripcion) throws Exception {
		super();		
		
		this.id=id;
		this.versionRow=versionRow;
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.cursoOriginal=this;
		
 		this.id_empresa=id_empresa;
 		this.id_empleado=id_empleado;
 		this.id_tipo_curso=id_tipo_curso;
 		this.id_tipo_institucion=id_tipo_institucion;
 		this.nombre=nombre;
 		this.codigo_inscripcion=codigo_inscripcion;
 		this.fecha_inicio=fecha_inicio;
 		this.fecha_fin=fecha_fin;
 		this.numero_horas=numero_horas;
 		this.es_aprobado=es_aprobado;
 		this.es_auspicio_empresa=es_auspicio_empresa;
 		this.descripcion=descripcion;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	 //PARA REPORTES
	public Curso (Long id_empresa,Long id_empleado,Long id_tipo_curso,Long id_tipo_institucion,String nombre,String codigo_inscripcion,Date fecha_inicio,Date fecha_fin,Integer numero_horas,Boolean es_aprobado,Boolean es_auspicio_empresa,String descripcion) throws Exception {
		super();		
		
		this.id=0L;
		this.versionRow=new Date();
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.cursoOriginal=this;
		
 		this.id_empresa=id_empresa;
 		this.id_empleado=id_empleado;
 		this.id_tipo_curso=id_tipo_curso;
 		this.id_tipo_institucion=id_tipo_institucion;
 		this.nombre=nombre;
 		this.codigo_inscripcion=codigo_inscripcion;
 		this.fecha_inicio=fecha_inicio;
 		this.fecha_fin=fecha_fin;
 		this.numero_horas=numero_horas;
 		this.es_aprobado=es_aprobado;
 		this.es_auspicio_empresa=es_auspicio_empresa;
 		this.descripcion=descripcion;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	public boolean equals(Object object) {
		boolean equal=false;
		Curso cursoLocal=null;
		
		if(object!=null) {
			cursoLocal=(Curso)object;
			
			if(cursoLocal!=null) {
				if(this.getId()!=null && cursoLocal.getId()!=null) {
					if(this.getId().equals(cursoLocal.getId())) {
						equal=true;
					}
				}
			}
		}
		
		return equal;
	}
	
	public String toString() {
		String sDetalle="";
		
		if(!CursoConstantesFunciones.CON_DESCRIPCION_DETALLADO) {
        	sDetalle=CursoConstantesFunciones.getCursoDescripcion(this);
		} else {
			sDetalle=CursoConstantesFunciones.getCursoDescripcionDetallado(this);
		}
		
		return sDetalle;
    }
	
	public Curso getCursoOriginal() {
		return this.cursoOriginal;
	}
	
	public void setCursoOriginal(Curso curso) {
		try {
			this.cursoOriginal=curso;
		} catch(Exception e) {
			;
		}
	}
	
	
	protected CursoAdditional cursoAdditional=null;
	
	public CursoAdditional getCursoAdditional() {
		return this.cursoAdditional;
	}
	
	public void setCursoAdditional(CursoAdditional cursoAdditional) {
		try {
			this.cursoAdditional=cursoAdditional;
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
    
	
	public Long getid_tipo_curso() {
		return this.id_tipo_curso;
	}
    
	
	public Long getid_tipo_institucion() {
		return this.id_tipo_institucion;
	}
    
	
	public String getnombre() {
		return this.nombre;
	}
    
	
	public String getcodigo_inscripcion() {
		return this.codigo_inscripcion;
	}
    
	
	public Date getfecha_inicio() {
		return this.fecha_inicio;
	}
    
	
	public Date getfecha_fin() {
		return this.fecha_fin;
	}
    
	
	public Integer getnumero_horas() {
		return this.numero_horas;
	}
    
	
	public Boolean getes_aprobado() {
		return this.es_aprobado;
	}
    
	
	public Boolean getes_auspicio_empresa() {
		return this.es_auspicio_empresa;
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
						System.out.println("Curso:Valor nulo no permitido en columna id_empresa");
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
						System.out.println("Curso:Valor nulo no permitido en columna id_empleado");
					}
				}

				this.id_empleado=newid_empleado;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_tipo_curso(Long newid_tipo_curso)throws Exception
	{
		try {
			if(this.id_tipo_curso!=newid_tipo_curso) {
				if(newid_tipo_curso==null) {
					//newid_tipo_curso=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("Curso:Valor nulo no permitido en columna id_tipo_curso");
					}
				}

				this.id_tipo_curso=newid_tipo_curso;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_tipo_institucion(Long newid_tipo_institucion)throws Exception
	{
		try {
			if(this.id_tipo_institucion!=newid_tipo_institucion) {
				if(newid_tipo_institucion==null) {
					//newid_tipo_institucion=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("Curso:Valor nulo no permitido en columna id_tipo_institucion");
					}
				}

				this.id_tipo_institucion=newid_tipo_institucion;
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
						System.out.println("Curso:Valor nulo no permitido en columna nombre");
					}
				}

				if(newnombre!=null&&newnombre.length()>100) {
					newnombre=newnombre.substring(0,98);
					System.out.println("Curso:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=100 en columna nombre");
				}

				this.nombre=newnombre;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setcodigo_inscripcion(String newcodigo_inscripcion)throws Exception
	{
		try {
			if(this.codigo_inscripcion!=newcodigo_inscripcion) {
				if(newcodigo_inscripcion==null) {
					//newcodigo_inscripcion="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("Curso:Valor nulo no permitido en columna codigo_inscripcion");
					}
				}

				if(newcodigo_inscripcion!=null&&newcodigo_inscripcion.length()>50) {
					newcodigo_inscripcion=newcodigo_inscripcion.substring(0,48);
					System.out.println("Curso:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=50 en columna codigo_inscripcion");
				}

				this.codigo_inscripcion=newcodigo_inscripcion;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setfecha_inicio(Date newfecha_inicio)throws Exception
	{
		try {
			if(this.fecha_inicio!=newfecha_inicio) {
				if(newfecha_inicio==null) {
					//newfecha_inicio=new Date();
					if(Constantes.ISDEVELOPING) {
						System.out.println("Curso:Valor nulo no permitido en columna fecha_inicio");
					}
				}

				this.fecha_inicio=newfecha_inicio;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setfecha_fin(Date newfecha_fin)throws Exception
	{
		try {
			if(this.fecha_fin!=newfecha_fin) {
				if(newfecha_fin==null) {
					//newfecha_fin=new Date();
					if(Constantes.ISDEVELOPING) {
						System.out.println("Curso:Valor nulo no permitido en columna fecha_fin");
					}
				}

				this.fecha_fin=newfecha_fin;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setnumero_horas(Integer newnumero_horas)throws Exception
	{
		try {
			if(this.numero_horas!=newnumero_horas) {
				if(newnumero_horas==null) {
					//newnumero_horas=0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("Curso:Valor nulo no permitido en columna numero_horas");
					}
				}

				this.numero_horas=newnumero_horas;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setes_aprobado(Boolean newes_aprobado)throws Exception
	{
		try {
			if(this.es_aprobado!=newes_aprobado) {
				if(newes_aprobado==null) {
					//newes_aprobado=false;
					if(Constantes.ISDEVELOPING) {
						System.out.println("Curso:Valor nulo no permitido en columna es_aprobado");
					}
				}

				this.es_aprobado=newes_aprobado;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setes_auspicio_empresa(Boolean newes_auspicio_empresa)throws Exception
	{
		try {
			if(this.es_auspicio_empresa!=newes_auspicio_empresa) {
				if(newes_auspicio_empresa==null) {
					//newes_auspicio_empresa=false;
					if(Constantes.ISDEVELOPING) {
						System.out.println("Curso:Valor nulo no permitido en columna es_auspicio_empresa");
					}
				}

				this.es_auspicio_empresa=newes_auspicio_empresa;
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
						System.out.println("Curso:Valor nulo no permitido en columna descripcion");
					}
				}

				if(newdescripcion!=null&&newdescripcion.length()>100) {
					newdescripcion=newdescripcion.substring(0,98);
					System.out.println("Curso:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=100 en columna descripcion");
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

	public TipoCurso getTipoCurso() {
		return this.tipocurso;
	}

	public TipoInstitucion getTipoInstitucion() {
		return this.tipoinstitucion;
	}

	
	
	public String getempresa_descripcion() {
		return this.empresa_descripcion;
	}

	public String getempleado_descripcion() {
		return this.empleado_descripcion;
	}

	public String gettipocurso_descripcion() {
		return this.tipocurso_descripcion;
	}

	public String gettipoinstitucion_descripcion() {
		return this.tipoinstitucion_descripcion;
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


	public  void  setTipoCurso(TipoCurso tipocurso) {
		try {
			this.tipocurso=tipocurso;
		} catch(Exception e) {
			;
		}
	}


	public  void  setTipoInstitucion(TipoInstitucion tipoinstitucion) {
		try {
			this.tipoinstitucion=tipoinstitucion;
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


	public  void  settipocurso_descripcion(String tipocurso_descripcion) {
		try {
			this.tipocurso_descripcion=tipocurso_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  settipoinstitucion_descripcion(String tipoinstitucion_descripcion) {
		try {
			this.tipoinstitucion_descripcion=tipoinstitucion_descripcion;
		} catch(Exception e) {
			;
		}
	}


	
	
	public List<DetalleCurso> getDetalleCursos() {
		return this.detallecursos;
	}

	
	
	public  void  setDetalleCursos(List<DetalleCurso> detallecursos) {
		try {
			this.detallecursos=detallecursos;
		} catch(Exception e) {
			;
		}
	}

	
	/*PARA REPORTES*/
	String id_empresa_descripcion="";String id_empleado_descripcion="";String id_tipo_curso_descripcion="";String id_tipo_institucion_descripcion="";String es_aprobado_descripcion="";String es_auspicio_empresa_descripcion="";
	
	
	public String getid_empresa_descripcion() {
		return id_empresa_descripcion;
	}
	public String getid_empleado_descripcion() {
		return id_empleado_descripcion;
	}
	public String getid_tipo_curso_descripcion() {
		return id_tipo_curso_descripcion;
	}
	public String getid_tipo_institucion_descripcion() {
		return id_tipo_institucion_descripcion;
	}
	public String getes_aprobado_descripcion() {
		return es_aprobado_descripcion;
	}
	public String getes_auspicio_empresa_descripcion() {
		return es_auspicio_empresa_descripcion;
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
	public void setid_tipo_curso_descripcion(String newid_tipo_curso_descripcion)throws Exception {
		try {
			this.id_tipo_curso_descripcion=newid_tipo_curso_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_tipo_institucion_descripcion(String newid_tipo_institucion_descripcion)throws Exception {
		try {
			this.id_tipo_institucion_descripcion=newid_tipo_institucion_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setes_aprobado_descripcion(String newes_aprobado_descripcion)throws Exception {
		try {
			this.es_aprobado_descripcion=newes_aprobado_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setes_auspicio_empresa_descripcion(String newes_auspicio_empresa_descripcion)throws Exception {
		try {
			this.es_auspicio_empresa_descripcion=newes_auspicio_empresa_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	
	public void inicializarVariablesParaReporte() {
		this.id_empresa_descripcion="";this.id_empleado_descripcion="";this.id_tipo_curso_descripcion="";this.id_tipo_institucion_descripcion="";this.es_aprobado_descripcion="";this.es_auspicio_empresa_descripcion="";
	}
	
	
	Object detallecursosDescripcionReporte;
	
	
	public Object getdetallecursosDescripcionReporte() {
		return detallecursosDescripcionReporte;
	}

	
	
	public  void  setdetallecursosDescripcionReporte(Object detallecursos) {
		try {
			this.detallecursosDescripcionReporte=detallecursos;
		} catch(Exception ex) {
			;
		}
	}

	/*PARA REPORTES FIN*/		
}

