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
package com.bydan.erp.contabilidad.business.entity.report;

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
//import com.bydan.erp.contabilidad.util.ListadosPlanCuentasConstantesFunciones;
import com.bydan.erp.contabilidad.util.*;


import com.bydan.erp.seguridad.util.*;

import com.bydan.erp.contabilidad.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;




@SuppressWarnings("unused")
public class ListadosPlanCuentas extends ListadosPlanCuentasAdditional implements Serializable ,Cloneable {//ListadosPlanCuentasAdditional,GeneralEntity
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
	
	private ListadosPlanCuentas listadosplancuentasOriginal;
	
	private Map<String, Object> mapListadosPlanCuentas;
			
	public Map<String, Object> getMapListadosPlanCuentas() {
		return mapListadosPlanCuentas;
	}

	public void setMapListadosPlanCuentas(Map<String, Object> mapListadosPlanCuentas) {
		this.mapListadosPlanCuentas = mapListadosPlanCuentas;
	}
	
	public void inicializarMapListadosPlanCuentas() {
		this.mapListadosPlanCuentas = new HashMap<String,Object>();
	}
	
	public void setMapListadosPlanCuentasValue(String sKey,Object oValue) {
		this.mapListadosPlanCuentas.put(sKey, oValue);
	}
	
	public Object getMapListadosPlanCuentasValue(String sKey) {
		return this.mapListadosPlanCuentas.get(sKey);
	}
	
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_empresa;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=50,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	//@Pattern(regex=ListadosPlanCuentasConstantesFunciones.SREGEXNOMBRE_MONEDA,message=ListadosPlanCuentasConstantesFunciones.SMENSAJEREGEXNOMBRE_MONEDA)
	private String nombre_moneda;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=50,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	//@Pattern(regex=ListadosPlanCuentasConstantesFunciones.SREGEXCODIGO,message=ListadosPlanCuentasConstantesFunciones.SMENSAJEREGEXCODIGO)
	private String codigo;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=150,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	//@Pattern(regex=ListadosPlanCuentasConstantesFunciones.SREGEXNOMBRE,message=ListadosPlanCuentasConstantesFunciones.SMENSAJEREGEXNOMBRE)
	private String nombre;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=150,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	//@Pattern(regex=ListadosPlanCuentasConstantesFunciones.SREGEXNOMBRE_NIVEL_CUENTA,message=ListadosPlanCuentasConstantesFunciones.SMENSAJEREGEXNOMBRE_NIVEL_CUENTA)
	private String nombre_nivel_cuenta;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Boolean es_movimiento;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Boolean es_centro_costo;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Boolean es_centro_actividad;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Boolean es_para_f52;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=10,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONINT)
	private Integer orden;
			
	
	public Empresa empresa;
	
	
	private String empresa_descripcion;
	
	
		
	public ListadosPlanCuentas () throws Exception {
		super();		
		
		this.id=0L;
		
		
		this.versionRow=new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());//new Date();
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		this.sType="NONE";
		
		this.listadosplancuentasOriginal=this;
		
 		this.id_empresa=-1L;
 		this.nombre_moneda="";
 		this.codigo="";
 		this.nombre="";
 		this.nombre_nivel_cuenta="";
 		this.es_movimiento=false;
 		this.es_centro_costo=false;
 		this.es_centro_actividad=false;
 		this.es_para_f52=false;
 		this.orden=0;
		
		
		this.empresa=null;
		
		
		this.empresa_descripcion="";
		
		
		
			
		
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
    //PARA REPORTES
	public ListadosPlanCuentas (Long id,Date versionRow,String nombre_moneda,String codigo,String nombre,String nombre_nivel_cuenta,Boolean es_movimiento,Boolean es_centro_costo,Boolean es_centro_actividad,Boolean es_para_f52,Integer orden) throws Exception {
		super();		
		
		this.id=id;
		this.versionRow=versionRow;
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.listadosplancuentasOriginal=this;
		
 		this.nombre_moneda=nombre_moneda;
 		this.codigo=codigo;
 		this.nombre=nombre;
 		this.nombre_nivel_cuenta=nombre_nivel_cuenta;
 		this.es_movimiento=es_movimiento;
 		this.es_centro_costo=es_centro_costo;
 		this.es_centro_actividad=es_centro_actividad;
 		this.es_para_f52=es_para_f52;
 		this.orden=orden;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	 //PARA REPORTES
	public ListadosPlanCuentas (String nombre_moneda,String codigo,String nombre,String nombre_nivel_cuenta,Boolean es_movimiento,Boolean es_centro_costo,Boolean es_centro_actividad,Boolean es_para_f52,Integer orden) throws Exception {
		super();		
		
		this.id=0L;
		this.versionRow=new Date();
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.listadosplancuentasOriginal=this;
		
 		this.nombre_moneda=nombre_moneda;
 		this.codigo=codigo;
 		this.nombre=nombre;
 		this.nombre_nivel_cuenta=nombre_nivel_cuenta;
 		this.es_movimiento=es_movimiento;
 		this.es_centro_costo=es_centro_costo;
 		this.es_centro_actividad=es_centro_actividad;
 		this.es_para_f52=es_para_f52;
 		this.orden=orden;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	
	public ListadosPlanCuentas getListadosPlanCuentasOriginal() {
		return this.listadosplancuentasOriginal;
	}
	
	public void setListadosPlanCuentasOriginal(ListadosPlanCuentas listadosplancuentas) {
		try {
			this.listadosplancuentasOriginal=listadosplancuentas;
		} catch(Exception e) {
			;
		}
	}
	
	
	protected ListadosPlanCuentasAdditional listadosplancuentasAdditional=null;
	
	public ListadosPlanCuentasAdditional getListadosPlanCuentasAdditional() {
		return this.listadosplancuentasAdditional;
	}
	
	public void setListadosPlanCuentasAdditional(ListadosPlanCuentasAdditional listadosplancuentasAdditional) {
		try {
			this.listadosplancuentasAdditional=listadosplancuentasAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
    
	
	public Long getid_empresa() {
		return this.id_empresa;
	}
    
	
	public String getnombre_moneda() {
		return this.nombre_moneda;
	}
    
	
	public String getcodigo() {
		return this.codigo;
	}
    
	
	public String getnombre() {
		return this.nombre;
	}
    
	
	public String getnombre_nivel_cuenta() {
		return this.nombre_nivel_cuenta;
	}
    
	
	public Boolean getes_movimiento() {
		return this.es_movimiento;
	}
    
	
	public Boolean getes_centro_costo() {
		return this.es_centro_costo;
	}
    
	
	public Boolean getes_centro_actividad() {
		return this.es_centro_actividad;
	}
    
	
	public Boolean getes_para_f52() {
		return this.es_para_f52;
	}
    
	
	public Integer getorden() {
		return this.orden;
	}
	
    
	public void setid_empresa(Long newid_empresa)throws Exception
	{
		try {
			if(this.id_empresa!=newid_empresa) {
				if(newid_empresa==null) {
					//newid_empresa=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ListadosPlanCuentas:Valor nulo no permitido en columna id_empresa");
					}
				}

				this.id_empresa=newid_empresa;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setnombre_moneda(String newnombre_moneda)throws Exception
	{
		try {
			if(this.nombre_moneda!=newnombre_moneda) {
				if(newnombre_moneda==null) {
					//newnombre_moneda="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("ListadosPlanCuentas:Valor nulo no permitido en columna nombre_moneda");
					}
				}

				if(newnombre_moneda!=null&&newnombre_moneda.length()>50) {
					newnombre_moneda=newnombre_moneda.substring(0,48);
					System.out.println("ListadosPlanCuentas:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=50 en columna nombre_moneda");
				}

				this.nombre_moneda=newnombre_moneda;
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
						System.out.println("ListadosPlanCuentas:Valor nulo no permitido en columna codigo");
					}
				}

				if(newcodigo!=null&&newcodigo.length()>50) {
					newcodigo=newcodigo.substring(0,48);
					System.out.println("ListadosPlanCuentas:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=50 en columna codigo");
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
						System.out.println("ListadosPlanCuentas:Valor nulo no permitido en columna nombre");
					}
				}

				if(newnombre!=null&&newnombre.length()>150) {
					newnombre=newnombre.substring(0,148);
					System.out.println("ListadosPlanCuentas:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=150 en columna nombre");
				}

				this.nombre=newnombre;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setnombre_nivel_cuenta(String newnombre_nivel_cuenta)throws Exception
	{
		try {
			if(this.nombre_nivel_cuenta!=newnombre_nivel_cuenta) {
				if(newnombre_nivel_cuenta==null) {
					//newnombre_nivel_cuenta="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("ListadosPlanCuentas:Valor nulo no permitido en columna nombre_nivel_cuenta");
					}
				}

				if(newnombre_nivel_cuenta!=null&&newnombre_nivel_cuenta.length()>150) {
					newnombre_nivel_cuenta=newnombre_nivel_cuenta.substring(0,148);
					System.out.println("ListadosPlanCuentas:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=150 en columna nombre_nivel_cuenta");
				}

				this.nombre_nivel_cuenta=newnombre_nivel_cuenta;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setes_movimiento(Boolean newes_movimiento)throws Exception
	{
		try {
			if(this.es_movimiento!=newes_movimiento) {
				if(newes_movimiento==null) {
					//newes_movimiento=false;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ListadosPlanCuentas:Valor nulo no permitido en columna es_movimiento");
					}
				}

				this.es_movimiento=newes_movimiento;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setes_centro_costo(Boolean newes_centro_costo)throws Exception
	{
		try {
			if(this.es_centro_costo!=newes_centro_costo) {
				if(newes_centro_costo==null) {
					//newes_centro_costo=false;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ListadosPlanCuentas:Valor nulo no permitido en columna es_centro_costo");
					}
				}

				this.es_centro_costo=newes_centro_costo;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setes_centro_actividad(Boolean newes_centro_actividad)throws Exception
	{
		try {
			if(this.es_centro_actividad!=newes_centro_actividad) {
				if(newes_centro_actividad==null) {
					//newes_centro_actividad=false;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ListadosPlanCuentas:Valor nulo no permitido en columna es_centro_actividad");
					}
				}

				this.es_centro_actividad=newes_centro_actividad;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setes_para_f52(Boolean newes_para_f52)throws Exception
	{
		try {
			if(this.es_para_f52!=newes_para_f52) {
				if(newes_para_f52==null) {
					//newes_para_f52=false;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ListadosPlanCuentas:Valor nulo no permitido en columna es_para_f52");
					}
				}

				this.es_para_f52=newes_para_f52;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setorden(Integer neworden)throws Exception
	{
		try {
			if(this.orden!=neworden) {
				if(neworden==null) {
					//neworden=0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ListadosPlanCuentas:Valor nulo no permitido en columna orden");
					}
				}

				this.orden=neworden;
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
	String id_empresa_descripcion="";String es_movimiento_descripcion="";String es_centro_costo_descripcion="";String es_centro_actividad_descripcion="";String es_para_f52_descripcion="";
	
	
	public String getid_empresa_descripcion() {
		return id_empresa_descripcion;
	}
	public String getes_movimiento_descripcion() {
		return es_movimiento_descripcion;
	}
	public String getes_centro_costo_descripcion() {
		return es_centro_costo_descripcion;
	}
	public String getes_centro_actividad_descripcion() {
		return es_centro_actividad_descripcion;
	}
	public String getes_para_f52_descripcion() {
		return es_para_f52_descripcion;
	}
	
	
	public void setid_empresa_descripcion(String newid_empresa_descripcion)throws Exception {
		try {
			this.id_empresa_descripcion=newid_empresa_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setes_movimiento_descripcion(String newes_movimiento_descripcion)throws Exception {
		try {
			this.es_movimiento_descripcion=newes_movimiento_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setes_centro_costo_descripcion(String newes_centro_costo_descripcion)throws Exception {
		try {
			this.es_centro_costo_descripcion=newes_centro_costo_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setes_centro_actividad_descripcion(String newes_centro_actividad_descripcion)throws Exception {
		try {
			this.es_centro_actividad_descripcion=newes_centro_actividad_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setes_para_f52_descripcion(String newes_para_f52_descripcion)throws Exception {
		try {
			this.es_para_f52_descripcion=newes_para_f52_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	
	public void inicializarVariablesParaReporte() {
		this.id_empresa_descripcion="";this.es_movimiento_descripcion="";this.es_centro_costo_descripcion="";this.es_centro_actividad_descripcion="";this.es_para_f52_descripcion="";
	}
	
	
	
	
	
	
	/*PARA REPORTES FIN*/		
}

