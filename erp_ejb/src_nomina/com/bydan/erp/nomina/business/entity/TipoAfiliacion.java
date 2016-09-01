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
//import com.bydan.erp.nomina.util.TipoAfiliacionConstantesFunciones;
import com.bydan.erp.nomina.util.*;


import com.bydan.erp.seguridad.util.*;



import com.bydan.erp.seguridad.business.entity.*;




@SuppressWarnings("unused")
public class TipoAfiliacion extends TipoAfiliacionAdditional implements Serializable ,Cloneable {//TipoAfiliacionAdditional,GeneralEntity
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
	
	private TipoAfiliacion tipoafiliacionOriginal;
	
	private Map<String, Object> mapTipoAfiliacion;
			
	public Map<String, Object> getMapTipoAfiliacion() {
		return mapTipoAfiliacion;
	}

	public void setMapTipoAfiliacion(Map<String, Object> mapTipoAfiliacion) {
		this.mapTipoAfiliacion = mapTipoAfiliacion;
	}
	
	public void inicializarMapTipoAfiliacion() {
		this.mapTipoAfiliacion = new HashMap<String,Object>();
	}
	
	public void setMapTipoAfiliacionValue(String sKey,Object oValue) {
		this.mapTipoAfiliacion.put(sKey, oValue);
	}
	
	public Object getMapTipoAfiliacionValue(String sKey) {
		return this.mapTipoAfiliacion.get(sKey);
	}
	
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_empresa;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_cate_tipo_afiliacion;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=50,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=TipoAfiliacionConstantesFunciones.SREGEXCODIGO,message=TipoAfiliacionConstantesFunciones.SMENSAJEREGEXCODIGO)
	private String codigo;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=150,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=TipoAfiliacionConstantesFunciones.SREGEXNOMBRE,message=TipoAfiliacionConstantesFunciones.SMENSAJEREGEXNOMBRE)
	private String nombre;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double porcen_emplea;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double porcen_patro;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double porcen_gene_emplea;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double porcen_gene_patro;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double porcen_secu;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double porcen_iece;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=200,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=TipoAfiliacionConstantesFunciones.SREGEXDESCRIPCION,message=TipoAfiliacionConstantesFunciones.SMENSAJEREGEXDESCRIPCION)
	private String descripcion;
			
	
	public Empresa empresa;
	public CateTipoAfiliacion catetipoafiliacion;
	
	
	private String empresa_descripcion;
	private String catetipoafiliacion_descripcion;
	
	
	public List<DatoGeneralEmpleado> datogeneralempleados;
		
	public TipoAfiliacion () throws Exception {
		super();		
		
		this.id=0L;
		
		
		this.versionRow=new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());//new Date();
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		this.sType="NONE";
		
		this.tipoafiliacionOriginal=this;
		
 		this.id_empresa=-1L;
 		this.id_cate_tipo_afiliacion=-1L;
 		this.codigo="";
 		this.nombre="";
 		this.porcen_emplea=0.0;
 		this.porcen_patro=0.0;
 		this.porcen_gene_emplea=0.0;
 		this.porcen_gene_patro=0.0;
 		this.porcen_secu=0.0;
 		this.porcen_iece=0.0;
 		this.descripcion="";
		
		
		this.empresa=null;
		this.catetipoafiliacion=null;
		
		
		this.empresa_descripcion="";
		this.catetipoafiliacion_descripcion="";
		
		
		this.datogeneralempleados=null;
		
			
		
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
    //PARA REPORTES
	public TipoAfiliacion (Long id,Date versionRow,Long id_empresa,Long id_cate_tipo_afiliacion,String codigo,String nombre,Double porcen_emplea,Double porcen_patro,Double porcen_gene_emplea,Double porcen_gene_patro,Double porcen_secu,Double porcen_iece,String descripcion) throws Exception {
		super();		
		
		this.id=id;
		this.versionRow=versionRow;
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.tipoafiliacionOriginal=this;
		
 		this.id_empresa=id_empresa;
 		this.id_cate_tipo_afiliacion=id_cate_tipo_afiliacion;
 		this.codigo=codigo;
 		this.nombre=nombre;
 		this.porcen_emplea=porcen_emplea;
 		this.porcen_patro=porcen_patro;
 		this.porcen_gene_emplea=porcen_gene_emplea;
 		this.porcen_gene_patro=porcen_gene_patro;
 		this.porcen_secu=porcen_secu;
 		this.porcen_iece=porcen_iece;
 		this.descripcion=descripcion;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	 //PARA REPORTES
	public TipoAfiliacion (Long id_empresa,Long id_cate_tipo_afiliacion,String codigo,String nombre,Double porcen_emplea,Double porcen_patro,Double porcen_gene_emplea,Double porcen_gene_patro,Double porcen_secu,Double porcen_iece,String descripcion) throws Exception {
		super();		
		
		this.id=0L;
		this.versionRow=new Date();
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.tipoafiliacionOriginal=this;
		
 		this.id_empresa=id_empresa;
 		this.id_cate_tipo_afiliacion=id_cate_tipo_afiliacion;
 		this.codigo=codigo;
 		this.nombre=nombre;
 		this.porcen_emplea=porcen_emplea;
 		this.porcen_patro=porcen_patro;
 		this.porcen_gene_emplea=porcen_gene_emplea;
 		this.porcen_gene_patro=porcen_gene_patro;
 		this.porcen_secu=porcen_secu;
 		this.porcen_iece=porcen_iece;
 		this.descripcion=descripcion;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	public boolean equals(Object object) {
		boolean equal=false;
		TipoAfiliacion tipoafiliacionLocal=null;
		
		if(object!=null) {
			tipoafiliacionLocal=(TipoAfiliacion)object;
			
			if(tipoafiliacionLocal!=null) {
				if(this.getId()!=null && tipoafiliacionLocal.getId()!=null) {
					if(this.getId().equals(tipoafiliacionLocal.getId())) {
						equal=true;
					}
				}
			}
		}
		
		return equal;
	}
	
	public String toString() {
		String sDetalle="";
		
		if(!TipoAfiliacionConstantesFunciones.CON_DESCRIPCION_DETALLADO) {
        	sDetalle=TipoAfiliacionConstantesFunciones.getTipoAfiliacionDescripcion(this);
		} else {
			sDetalle=TipoAfiliacionConstantesFunciones.getTipoAfiliacionDescripcionDetallado(this);
		}
		
		return sDetalle;
    }
	
	public TipoAfiliacion getTipoAfiliacionOriginal() {
		return this.tipoafiliacionOriginal;
	}
	
	public void setTipoAfiliacionOriginal(TipoAfiliacion tipoafiliacion) {
		try {
			this.tipoafiliacionOriginal=tipoafiliacion;
		} catch(Exception e) {
			;
		}
	}
	
	
	protected TipoAfiliacionAdditional tipoafiliacionAdditional=null;
	
	public TipoAfiliacionAdditional getTipoAfiliacionAdditional() {
		return this.tipoafiliacionAdditional;
	}
	
	public void setTipoAfiliacionAdditional(TipoAfiliacionAdditional tipoafiliacionAdditional) {
		try {
			this.tipoafiliacionAdditional=tipoafiliacionAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
    
	
	public Long getid_empresa() {
		return this.id_empresa;
	}
    
	
	public Long getid_cate_tipo_afiliacion() {
		return this.id_cate_tipo_afiliacion;
	}
    
	
	public String getcodigo() {
		return this.codigo;
	}
    
	
	public String getnombre() {
		return this.nombre;
	}
    
	
	public Double getporcen_emplea() {
		return this.porcen_emplea;
	}
    
	
	public Double getporcen_patro() {
		return this.porcen_patro;
	}
    
	
	public Double getporcen_gene_emplea() {
		return this.porcen_gene_emplea;
	}
    
	
	public Double getporcen_gene_patro() {
		return this.porcen_gene_patro;
	}
    
	
	public Double getporcen_secu() {
		return this.porcen_secu;
	}
    
	
	public Double getporcen_iece() {
		return this.porcen_iece;
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
						System.out.println("TipoAfiliacion:Valor nulo no permitido en columna id_empresa");
					}
				}

				this.id_empresa=newid_empresa;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_cate_tipo_afiliacion(Long newid_cate_tipo_afiliacion)throws Exception
	{
		try {
			if(this.id_cate_tipo_afiliacion!=newid_cate_tipo_afiliacion) {
				if(newid_cate_tipo_afiliacion==null) {
					//newid_cate_tipo_afiliacion=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("TipoAfiliacion:Valor nulo no permitido en columna id_cate_tipo_afiliacion");
					}
				}

				this.id_cate_tipo_afiliacion=newid_cate_tipo_afiliacion;
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
						System.out.println("TipoAfiliacion:Valor nulo no permitido en columna codigo");
					}
				}

				if(newcodigo!=null&&newcodigo.length()>50) {
					newcodigo=newcodigo.substring(0,48);
					System.out.println("TipoAfiliacion:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=50 en columna codigo");
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
						System.out.println("TipoAfiliacion:Valor nulo no permitido en columna nombre");
					}
				}

				if(newnombre!=null&&newnombre.length()>150) {
					newnombre=newnombre.substring(0,148);
					System.out.println("TipoAfiliacion:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=150 en columna nombre");
				}

				this.nombre=newnombre;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setporcen_emplea(Double newporcen_emplea)throws Exception
	{
		try {
			if(this.porcen_emplea!=newporcen_emplea) {
				if(newporcen_emplea==null) {
					//newporcen_emplea=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("TipoAfiliacion:Valor nulo no permitido en columna porcen_emplea");
					}
				}

				this.porcen_emplea=newporcen_emplea;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setporcen_patro(Double newporcen_patro)throws Exception
	{
		try {
			if(this.porcen_patro!=newporcen_patro) {
				if(newporcen_patro==null) {
					//newporcen_patro=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("TipoAfiliacion:Valor nulo no permitido en columna porcen_patro");
					}
				}

				this.porcen_patro=newporcen_patro;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setporcen_gene_emplea(Double newporcen_gene_emplea)throws Exception
	{
		try {
			if(this.porcen_gene_emplea!=newporcen_gene_emplea) {
				if(newporcen_gene_emplea==null) {
					//newporcen_gene_emplea=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("TipoAfiliacion:Valor nulo no permitido en columna porcen_gene_emplea");
					}
				}

				this.porcen_gene_emplea=newporcen_gene_emplea;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setporcen_gene_patro(Double newporcen_gene_patro)throws Exception
	{
		try {
			if(this.porcen_gene_patro!=newporcen_gene_patro) {
				if(newporcen_gene_patro==null) {
					//newporcen_gene_patro=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("TipoAfiliacion:Valor nulo no permitido en columna porcen_gene_patro");
					}
				}

				this.porcen_gene_patro=newporcen_gene_patro;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setporcen_secu(Double newporcen_secu)throws Exception
	{
		try {
			if(this.porcen_secu!=newporcen_secu) {
				if(newporcen_secu==null) {
					//newporcen_secu=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("TipoAfiliacion:Valor nulo no permitido en columna porcen_secu");
					}
				}

				this.porcen_secu=newporcen_secu;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setporcen_iece(Double newporcen_iece)throws Exception
	{
		try {
			if(this.porcen_iece!=newporcen_iece) {
				if(newporcen_iece==null) {
					//newporcen_iece=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("TipoAfiliacion:Valor nulo no permitido en columna porcen_iece");
					}
				}

				this.porcen_iece=newporcen_iece;
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
						System.out.println("TipoAfiliacion:Valor nulo no permitido en columna descripcion");
					}
				}

				if(newdescripcion!=null&&newdescripcion.length()>200) {
					newdescripcion=newdescripcion.substring(0,198);
					System.out.println("TipoAfiliacion:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=200 en columna descripcion");
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

	public CateTipoAfiliacion getCateTipoAfiliacion() {
		return this.catetipoafiliacion;
	}

	
	
	public String getempresa_descripcion() {
		return this.empresa_descripcion;
	}

	public String getcatetipoafiliacion_descripcion() {
		return this.catetipoafiliacion_descripcion;
	}

	
	
	public  void  setEmpresa(Empresa empresa) {
		try {
			this.empresa=empresa;
		} catch(Exception e) {
			;
		}
	}


	public  void  setCateTipoAfiliacion(CateTipoAfiliacion catetipoafiliacion) {
		try {
			this.catetipoafiliacion=catetipoafiliacion;
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


	public  void  setcatetipoafiliacion_descripcion(String catetipoafiliacion_descripcion) {
		try {
			this.catetipoafiliacion_descripcion=catetipoafiliacion_descripcion;
		} catch(Exception e) {
			;
		}
	}


	
	
	public List<DatoGeneralEmpleado> getDatoGeneralEmpleados() {
		return this.datogeneralempleados;
	}

	
	
	public  void  setDatoGeneralEmpleados(List<DatoGeneralEmpleado> datogeneralempleados) {
		try {
			this.datogeneralempleados=datogeneralempleados;
		} catch(Exception e) {
			;
		}
	}

	
	/*PARA REPORTES*/
	String id_empresa_descripcion="";String id_cate_tipo_afiliacion_descripcion="";
	
	
	public String getid_empresa_descripcion() {
		return id_empresa_descripcion;
	}
	public String getid_cate_tipo_afiliacion_descripcion() {
		return id_cate_tipo_afiliacion_descripcion;
	}
	
	
	public void setid_empresa_descripcion(String newid_empresa_descripcion)throws Exception {
		try {
			this.id_empresa_descripcion=newid_empresa_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_cate_tipo_afiliacion_descripcion(String newid_cate_tipo_afiliacion_descripcion)throws Exception {
		try {
			this.id_cate_tipo_afiliacion_descripcion=newid_cate_tipo_afiliacion_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	
	public void inicializarVariablesParaReporte() {
		this.id_empresa_descripcion="";this.id_cate_tipo_afiliacion_descripcion="";
	}
	
	
	Object datogeneralempleadosDescripcionReporte;
	
	
	public Object getdatogeneralempleadosDescripcionReporte() {
		return datogeneralempleadosDescripcionReporte;
	}

	
	
	public  void  setdatogeneralempleadosDescripcionReporte(Object datogeneralempleados) {
		try {
			this.datogeneralempleadosDescripcionReporte=datogeneralempleados;
		} catch(Exception ex) {
			;
		}
	}

	/*PARA REPORTES FIN*/		
}

