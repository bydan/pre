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
//import com.bydan.erp.contabilidad.util.LineaFlujoCajaConstantesFunciones;
import com.bydan.erp.contabilidad.util.*;


import com.bydan.erp.seguridad.util.*;



import com.bydan.erp.seguridad.business.entity.*;




@SuppressWarnings("unused")
public class LineaFlujoCaja extends LineaFlujoCajaAdditional implements Serializable ,Cloneable {//LineaFlujoCajaAdditional,GeneralEntity
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
	
	private LineaFlujoCaja lineaflujocajaOriginal;
	
	private Map<String, Object> mapLineaFlujoCaja;
			
	public Map<String, Object> getMapLineaFlujoCaja() {
		return mapLineaFlujoCaja;
	}

	public void setMapLineaFlujoCaja(Map<String, Object> mapLineaFlujoCaja) {
		this.mapLineaFlujoCaja = mapLineaFlujoCaja;
	}
	
	public void inicializarMapLineaFlujoCaja() {
		this.mapLineaFlujoCaja = new HashMap<String,Object>();
	}
	
	public void setMapLineaFlujoCajaValue(String sKey,Object oValue) {
		this.mapLineaFlujoCaja.put(sKey, oValue);
	}
	
	public Object getMapLineaFlujoCajaValue(String sKey) {
		return this.mapLineaFlujoCaja.get(sKey);
	}
	
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_empresa;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_tipo_grupo_flujo_caja;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=50,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=LineaFlujoCajaConstantesFunciones.SREGEXCODIGO,message=LineaFlujoCajaConstantesFunciones.SMENSAJEREGEXCODIGO)
	private String codigo;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=100,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=LineaFlujoCajaConstantesFunciones.SREGEXNOMBRE,message=LineaFlujoCajaConstantesFunciones.SMENSAJEREGEXNOMBRE)
	private String nombre;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_tipo_linea_flujo_caja;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Boolean es_consolidado;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Boolean esta_proyeccion;
			
	
	public Empresa empresa;
	public TipoGrupoFlujoCaja tipogrupoflujocaja;
	public TipoLineaFlujoCaja tipolineaflujocaja;
	
	
	private String empresa_descripcion;
	private String tipogrupoflujocaja_descripcion;
	private String tipolineaflujocaja_descripcion;
	
	
		
	public LineaFlujoCaja () throws Exception {
		super();		
		
		this.id=0L;
		
		
		this.versionRow=new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());//new Date();
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		this.sType="NONE";
		
		this.lineaflujocajaOriginal=this;
		
 		this.id_empresa=-1L;
 		this.id_tipo_grupo_flujo_caja=-1L;
 		this.codigo="";
 		this.nombre="";
 		this.id_tipo_linea_flujo_caja=-1L;
 		this.es_consolidado=false;
 		this.esta_proyeccion=false;
		
		
		this.empresa=null;
		this.tipogrupoflujocaja=null;
		this.tipolineaflujocaja=null;
		
		
		this.empresa_descripcion="";
		this.tipogrupoflujocaja_descripcion="";
		this.tipolineaflujocaja_descripcion="";
		
		
		
			
		
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
    //PARA REPORTES
	public LineaFlujoCaja (Long id,Date versionRow,Long id_empresa,Long id_tipo_grupo_flujo_caja,String codigo,String nombre,Long id_tipo_linea_flujo_caja,Boolean es_consolidado,Boolean esta_proyeccion) throws Exception {
		super();		
		
		this.id=id;
		this.versionRow=versionRow;
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.lineaflujocajaOriginal=this;
		
 		this.id_empresa=id_empresa;
 		this.id_tipo_grupo_flujo_caja=id_tipo_grupo_flujo_caja;
 		this.codigo=codigo;
 		this.nombre=nombre;
 		this.id_tipo_linea_flujo_caja=id_tipo_linea_flujo_caja;
 		this.es_consolidado=es_consolidado;
 		this.esta_proyeccion=esta_proyeccion;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	 //PARA REPORTES
	public LineaFlujoCaja (Long id_empresa,Long id_tipo_grupo_flujo_caja,String codigo,String nombre,Long id_tipo_linea_flujo_caja,Boolean es_consolidado,Boolean esta_proyeccion) throws Exception {
		super();		
		
		this.id=0L;
		this.versionRow=new Date();
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.lineaflujocajaOriginal=this;
		
 		this.id_empresa=id_empresa;
 		this.id_tipo_grupo_flujo_caja=id_tipo_grupo_flujo_caja;
 		this.codigo=codigo;
 		this.nombre=nombre;
 		this.id_tipo_linea_flujo_caja=id_tipo_linea_flujo_caja;
 		this.es_consolidado=es_consolidado;
 		this.esta_proyeccion=esta_proyeccion;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	public boolean equals(Object object) {
		boolean equal=false;
		LineaFlujoCaja lineaflujocajaLocal=null;
		
		if(object!=null) {
			lineaflujocajaLocal=(LineaFlujoCaja)object;
			
			if(lineaflujocajaLocal!=null) {
				if(this.getId()!=null && lineaflujocajaLocal.getId()!=null) {
					if(this.getId().equals(lineaflujocajaLocal.getId())) {
						equal=true;
					}
				}
			}
		}
		
		return equal;
	}
	
	public String toString() {
		String sDetalle="";
		
		if(!LineaFlujoCajaConstantesFunciones.CON_DESCRIPCION_DETALLADO) {
        	sDetalle=LineaFlujoCajaConstantesFunciones.getLineaFlujoCajaDescripcion(this);
		} else {
			sDetalle=LineaFlujoCajaConstantesFunciones.getLineaFlujoCajaDescripcionDetallado(this);
		}
		
		return sDetalle;
    }
	
	public LineaFlujoCaja getLineaFlujoCajaOriginal() {
		return this.lineaflujocajaOriginal;
	}
	
	public void setLineaFlujoCajaOriginal(LineaFlujoCaja lineaflujocaja) {
		try {
			this.lineaflujocajaOriginal=lineaflujocaja;
		} catch(Exception e) {
			;
		}
	}
	
	
	protected LineaFlujoCajaAdditional lineaflujocajaAdditional=null;
	
	public LineaFlujoCajaAdditional getLineaFlujoCajaAdditional() {
		return this.lineaflujocajaAdditional;
	}
	
	public void setLineaFlujoCajaAdditional(LineaFlujoCajaAdditional lineaflujocajaAdditional) {
		try {
			this.lineaflujocajaAdditional=lineaflujocajaAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
    
	
	public Long getid_empresa() {
		return this.id_empresa;
	}
    
	
	public Long getid_tipo_grupo_flujo_caja() {
		return this.id_tipo_grupo_flujo_caja;
	}
    
	
	public String getcodigo() {
		return this.codigo;
	}
    
	
	public String getnombre() {
		return this.nombre;
	}
    
	
	public Long getid_tipo_linea_flujo_caja() {
		return this.id_tipo_linea_flujo_caja;
	}
    
	
	public Boolean getes_consolidado() {
		return this.es_consolidado;
	}
    
	
	public Boolean getesta_proyeccion() {
		return this.esta_proyeccion;
	}
	
    
	public void setid_empresa(Long newid_empresa)throws Exception
	{
		try {
			if(this.id_empresa!=newid_empresa) {
				if(newid_empresa==null) {
					//newid_empresa=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("LineaFlujoCaja:Valor nulo no permitido en columna id_empresa");
					}
				}

				this.id_empresa=newid_empresa;
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
						System.out.println("LineaFlujoCaja:Valor nulo no permitido en columna id_tipo_grupo_flujo_caja");
					}
				}

				this.id_tipo_grupo_flujo_caja=newid_tipo_grupo_flujo_caja;
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
						System.out.println("LineaFlujoCaja:Valor nulo no permitido en columna codigo");
					}
				}

				if(newcodigo!=null&&newcodigo.length()>50) {
					newcodigo=newcodigo.substring(0,48);
					System.out.println("LineaFlujoCaja:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=50 en columna codigo");
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
						System.out.println("LineaFlujoCaja:Valor nulo no permitido en columna nombre");
					}
				}

				if(newnombre!=null&&newnombre.length()>100) {
					newnombre=newnombre.substring(0,98);
					System.out.println("LineaFlujoCaja:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=100 en columna nombre");
				}

				this.nombre=newnombre;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_tipo_linea_flujo_caja(Long newid_tipo_linea_flujo_caja)throws Exception
	{
		try {
			if(this.id_tipo_linea_flujo_caja!=newid_tipo_linea_flujo_caja) {
				if(newid_tipo_linea_flujo_caja==null) {
					//newid_tipo_linea_flujo_caja=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("LineaFlujoCaja:Valor nulo no permitido en columna id_tipo_linea_flujo_caja");
					}
				}

				this.id_tipo_linea_flujo_caja=newid_tipo_linea_flujo_caja;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setes_consolidado(Boolean newes_consolidado)throws Exception
	{
		try {
			if(this.es_consolidado!=newes_consolidado) {
				if(newes_consolidado==null) {
					//newes_consolidado=false;
					if(Constantes.ISDEVELOPING) {
						System.out.println("LineaFlujoCaja:Valor nulo no permitido en columna es_consolidado");
					}
				}

				this.es_consolidado=newes_consolidado;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setesta_proyeccion(Boolean newesta_proyeccion)throws Exception
	{
		try {
			if(this.esta_proyeccion!=newesta_proyeccion) {
				if(newesta_proyeccion==null) {
					//newesta_proyeccion=false;
					if(Constantes.ISDEVELOPING) {
						System.out.println("LineaFlujoCaja:Valor nulo no permitido en columna esta_proyeccion");
					}
				}

				this.esta_proyeccion=newesta_proyeccion;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	
	public Empresa getEmpresa() {
		return this.empresa;
	}

	public TipoGrupoFlujoCaja getTipoGrupoFlujoCaja() {
		return this.tipogrupoflujocaja;
	}

	public TipoLineaFlujoCaja getTipoLineaFlujoCaja() {
		return this.tipolineaflujocaja;
	}

	
	
	public String getempresa_descripcion() {
		return this.empresa_descripcion;
	}

	public String gettipogrupoflujocaja_descripcion() {
		return this.tipogrupoflujocaja_descripcion;
	}

	public String gettipolineaflujocaja_descripcion() {
		return this.tipolineaflujocaja_descripcion;
	}

	
	
	public  void  setEmpresa(Empresa empresa) {
		try {
			this.empresa=empresa;
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


	public  void  setTipoLineaFlujoCaja(TipoLineaFlujoCaja tipolineaflujocaja) {
		try {
			this.tipolineaflujocaja=tipolineaflujocaja;
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


	public  void  settipogrupoflujocaja_descripcion(String tipogrupoflujocaja_descripcion) {
		try {
			this.tipogrupoflujocaja_descripcion=tipogrupoflujocaja_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  settipolineaflujocaja_descripcion(String tipolineaflujocaja_descripcion) {
		try {
			this.tipolineaflujocaja_descripcion=tipolineaflujocaja_descripcion;
		} catch(Exception e) {
			;
		}
	}


	
	
	
	
	
	/*PARA REPORTES*/
	String id_empresa_descripcion="";String id_tipo_grupo_flujo_caja_descripcion="";String id_tipo_linea_flujo_caja_descripcion="";String es_consolidado_descripcion="";String esta_proyeccion_descripcion="";
	
	
	public String getid_empresa_descripcion() {
		return id_empresa_descripcion;
	}
	public String getid_tipo_grupo_flujo_caja_descripcion() {
		return id_tipo_grupo_flujo_caja_descripcion;
	}
	public String getid_tipo_linea_flujo_caja_descripcion() {
		return id_tipo_linea_flujo_caja_descripcion;
	}
	public String getes_consolidado_descripcion() {
		return es_consolidado_descripcion;
	}
	public String getesta_proyeccion_descripcion() {
		return esta_proyeccion_descripcion;
	}
	
	
	public void setid_empresa_descripcion(String newid_empresa_descripcion)throws Exception {
		try {
			this.id_empresa_descripcion=newid_empresa_descripcion;
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
	public void setid_tipo_linea_flujo_caja_descripcion(String newid_tipo_linea_flujo_caja_descripcion)throws Exception {
		try {
			this.id_tipo_linea_flujo_caja_descripcion=newid_tipo_linea_flujo_caja_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setes_consolidado_descripcion(String newes_consolidado_descripcion)throws Exception {
		try {
			this.es_consolidado_descripcion=newes_consolidado_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setesta_proyeccion_descripcion(String newesta_proyeccion_descripcion)throws Exception {
		try {
			this.esta_proyeccion_descripcion=newesta_proyeccion_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	
	public void inicializarVariablesParaReporte() {
		this.id_empresa_descripcion="";this.id_tipo_grupo_flujo_caja_descripcion="";this.id_tipo_linea_flujo_caja_descripcion="";this.es_consolidado_descripcion="";this.esta_proyeccion_descripcion="";
	}
	
	
	
	
	
	
	/*PARA REPORTES FIN*/		
}

