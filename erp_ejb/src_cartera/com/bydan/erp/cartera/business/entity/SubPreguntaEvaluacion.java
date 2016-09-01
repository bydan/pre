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
package com.bydan.erp.cartera.business.entity;

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
//import com.bydan.erp.cartera.util.SubPreguntaEvaluacionConstantesFunciones;
import com.bydan.erp.cartera.util.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.contabilidad.util.*;



import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;




@SuppressWarnings("unused")
public class SubPreguntaEvaluacion extends SubPreguntaEvaluacionAdditional implements Serializable ,Cloneable {//SubPreguntaEvaluacionAdditional,GeneralEntity
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
	
	private SubPreguntaEvaluacion subpreguntaevaluacionOriginal;
	
	private Map<String, Object> mapSubPreguntaEvaluacion;
			
	public Map<String, Object> getMapSubPreguntaEvaluacion() {
		return mapSubPreguntaEvaluacion;
	}

	public void setMapSubPreguntaEvaluacion(Map<String, Object> mapSubPreguntaEvaluacion) {
		this.mapSubPreguntaEvaluacion = mapSubPreguntaEvaluacion;
	}
	
	public void inicializarMapSubPreguntaEvaluacion() {
		this.mapSubPreguntaEvaluacion = new HashMap<String,Object>();
	}
	
	public void setMapSubPreguntaEvaluacionValue(String sKey,Object oValue) {
		this.mapSubPreguntaEvaluacion.put(sKey, oValue);
	}
	
	public Object getMapSubPreguntaEvaluacionValue(String sKey) {
		return this.mapSubPreguntaEvaluacion.get(sKey);
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
	private Long id_pregunta_evaluacion;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_ejercicio;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_periodo;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=10,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONINT)
	private Integer orden;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=150,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=SubPreguntaEvaluacionConstantesFunciones.SREGEXPREGUNTA,message=SubPreguntaEvaluacionConstantesFunciones.SMENSAJEREGEXPREGUNTA)
	private String pregunta;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double porcentaje_si;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Boolean con_factura;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Boolean con_orden_compra;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Boolean con_completo;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Boolean con_a_tiempo;
			
	
	public Empresa empresa;
	public Sucursal sucursal;
	public PreguntaEvaluacion preguntaevaluacion;
	public Ejercicio ejercicio;
	public Periodo periodo;
	
	
	private String empresa_descripcion;
	private String sucursal_descripcion;
	private String preguntaevaluacion_descripcion;
	private String ejercicio_descripcion;
	private String periodo_descripcion;
	
	
	public List<DetalleEvaluacionProveedor> detalleevaluacionproveedors;
		
	public SubPreguntaEvaluacion () throws Exception {
		super();		
		
		this.id=0L;
		
		
		this.versionRow=new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());//new Date();
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		this.sType="NONE";
		
		this.subpreguntaevaluacionOriginal=this;
		
 		this.id_empresa=-1L;
 		this.id_sucursal=-1L;
 		this.id_pregunta_evaluacion=-1L;
 		this.id_ejercicio=-1L;
 		this.id_periodo=-1L;
 		this.orden=0;
 		this.pregunta="";
 		this.porcentaje_si=0.0;
 		this.con_factura=false;
 		this.con_orden_compra=false;
 		this.con_completo=false;
 		this.con_a_tiempo=false;
		
		
		this.empresa=null;
		this.sucursal=null;
		this.preguntaevaluacion=null;
		this.ejercicio=null;
		this.periodo=null;
		
		
		this.empresa_descripcion="";
		this.sucursal_descripcion="";
		this.preguntaevaluacion_descripcion="";
		this.ejercicio_descripcion="";
		this.periodo_descripcion="";
		
		
		this.detalleevaluacionproveedors=null;
		
			
		
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
    //PARA REPORTES
	public SubPreguntaEvaluacion (Long id,Date versionRow,Long id_empresa,Long id_sucursal,Long id_pregunta_evaluacion,Long id_ejercicio,Long id_periodo,Integer orden,String pregunta,Double porcentaje_si,Boolean con_factura,Boolean con_orden_compra,Boolean con_completo,Boolean con_a_tiempo) throws Exception {
		super();		
		
		this.id=id;
		this.versionRow=versionRow;
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.subpreguntaevaluacionOriginal=this;
		
 		this.id_empresa=id_empresa;
 		this.id_sucursal=id_sucursal;
 		this.id_pregunta_evaluacion=id_pregunta_evaluacion;
 		this.id_ejercicio=id_ejercicio;
 		this.id_periodo=id_periodo;
 		this.orden=orden;
 		this.pregunta=pregunta;
 		this.porcentaje_si=porcentaje_si;
 		this.con_factura=con_factura;
 		this.con_orden_compra=con_orden_compra;
 		this.con_completo=con_completo;
 		this.con_a_tiempo=con_a_tiempo;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	 //PARA REPORTES
	public SubPreguntaEvaluacion (Long id_empresa,Long id_sucursal,Long id_pregunta_evaluacion,Long id_ejercicio,Long id_periodo,Integer orden,String pregunta,Double porcentaje_si,Boolean con_factura,Boolean con_orden_compra,Boolean con_completo,Boolean con_a_tiempo) throws Exception {
		super();		
		
		this.id=0L;
		this.versionRow=new Date();
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.subpreguntaevaluacionOriginal=this;
		
 		this.id_empresa=id_empresa;
 		this.id_sucursal=id_sucursal;
 		this.id_pregunta_evaluacion=id_pregunta_evaluacion;
 		this.id_ejercicio=id_ejercicio;
 		this.id_periodo=id_periodo;
 		this.orden=orden;
 		this.pregunta=pregunta;
 		this.porcentaje_si=porcentaje_si;
 		this.con_factura=con_factura;
 		this.con_orden_compra=con_orden_compra;
 		this.con_completo=con_completo;
 		this.con_a_tiempo=con_a_tiempo;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	public boolean equals(Object object) {
		boolean equal=false;
		SubPreguntaEvaluacion subpreguntaevaluacionLocal=null;
		
		if(object!=null) {
			subpreguntaevaluacionLocal=(SubPreguntaEvaluacion)object;
			
			if(subpreguntaevaluacionLocal!=null) {
				if(this.getId()!=null && subpreguntaevaluacionLocal.getId()!=null) {
					if(this.getId().equals(subpreguntaevaluacionLocal.getId())) {
						equal=true;
					}
				}
			}
		}
		
		return equal;
	}
	
	public String toString() {
		String sDetalle="";
		
		if(!SubPreguntaEvaluacionConstantesFunciones.CON_DESCRIPCION_DETALLADO) {
        	sDetalle=SubPreguntaEvaluacionConstantesFunciones.getSubPreguntaEvaluacionDescripcion(this);
		} else {
			sDetalle=SubPreguntaEvaluacionConstantesFunciones.getSubPreguntaEvaluacionDescripcionDetallado(this);
		}
		
		return sDetalle;
    }
	
	public SubPreguntaEvaluacion getSubPreguntaEvaluacionOriginal() {
		return this.subpreguntaevaluacionOriginal;
	}
	
	public void setSubPreguntaEvaluacionOriginal(SubPreguntaEvaluacion subpreguntaevaluacion) {
		try {
			this.subpreguntaevaluacionOriginal=subpreguntaevaluacion;
		} catch(Exception e) {
			;
		}
	}
	
	
	protected SubPreguntaEvaluacionAdditional subpreguntaevaluacionAdditional=null;
	
	public SubPreguntaEvaluacionAdditional getSubPreguntaEvaluacionAdditional() {
		return this.subpreguntaevaluacionAdditional;
	}
	
	public void setSubPreguntaEvaluacionAdditional(SubPreguntaEvaluacionAdditional subpreguntaevaluacionAdditional) {
		try {
			this.subpreguntaevaluacionAdditional=subpreguntaevaluacionAdditional;
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
    
	
	public Long getid_pregunta_evaluacion() {
		return this.id_pregunta_evaluacion;
	}
    
	
	public Long getid_ejercicio() {
		return this.id_ejercicio;
	}
    
	
	public Long getid_periodo() {
		return this.id_periodo;
	}
    
	
	public Integer getorden() {
		return this.orden;
	}
    
	
	public String getpregunta() {
		return this.pregunta;
	}
    
	
	public Double getporcentaje_si() {
		return this.porcentaje_si;
	}
    
	
	public Boolean getcon_factura() {
		return this.con_factura;
	}
    
	
	public Boolean getcon_orden_compra() {
		return this.con_orden_compra;
	}
    
	
	public Boolean getcon_completo() {
		return this.con_completo;
	}
    
	
	public Boolean getcon_a_tiempo() {
		return this.con_a_tiempo;
	}
	
    
	public void setid_empresa(Long newid_empresa)throws Exception
	{
		try {
			if(this.id_empresa!=newid_empresa) {
				if(newid_empresa==null) {
					//newid_empresa=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("SubPreguntaEvaluacion:Valor nulo no permitido en columna id_empresa");
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
						System.out.println("SubPreguntaEvaluacion:Valor nulo no permitido en columna id_sucursal");
					}
				}

				this.id_sucursal=newid_sucursal;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_pregunta_evaluacion(Long newid_pregunta_evaluacion)throws Exception
	{
		try {
			if(this.id_pregunta_evaluacion!=newid_pregunta_evaluacion) {
				if(newid_pregunta_evaluacion==null) {
					//newid_pregunta_evaluacion=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("SubPreguntaEvaluacion:Valor nulo no permitido en columna id_pregunta_evaluacion");
					}
				}

				this.id_pregunta_evaluacion=newid_pregunta_evaluacion;
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
						System.out.println("SubPreguntaEvaluacion:Valor nulo no permitido en columna id_ejercicio");
					}
				}

				this.id_ejercicio=newid_ejercicio;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_periodo(Long newid_periodo)throws Exception
	{
		try {
			if(this.id_periodo!=newid_periodo) {
				if(newid_periodo==null) {
					//newid_periodo=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("SubPreguntaEvaluacion:Valor nulo no permitido en columna id_periodo");
					}
				}

				this.id_periodo=newid_periodo;
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
						System.out.println("SubPreguntaEvaluacion:Valor nulo no permitido en columna orden");
					}
				}

				this.orden=neworden;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setpregunta(String newpregunta)throws Exception
	{
		try {
			if(this.pregunta!=newpregunta) {
				if(newpregunta==null) {
					//newpregunta="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("SubPreguntaEvaluacion:Valor nulo no permitido en columna pregunta");
					}
				}

				if(newpregunta!=null&&newpregunta.length()>150) {
					newpregunta=newpregunta.substring(0,148);
					System.out.println("SubPreguntaEvaluacion:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=150 en columna pregunta");
				}

				this.pregunta=newpregunta;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setporcentaje_si(Double newporcentaje_si)throws Exception
	{
		try {
			if(this.porcentaje_si!=newporcentaje_si) {
				if(newporcentaje_si==null) {
					//newporcentaje_si=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("SubPreguntaEvaluacion:Valor nulo no permitido en columna porcentaje_si");
					}
				}

				this.porcentaje_si=newporcentaje_si;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setcon_factura(Boolean newcon_factura)throws Exception
	{
		try {
			if(this.con_factura!=newcon_factura) {
				if(newcon_factura==null) {
					//newcon_factura=false;
					if(Constantes.ISDEVELOPING) {
						System.out.println("SubPreguntaEvaluacion:Valor nulo no permitido en columna con_factura");
					}
				}

				this.con_factura=newcon_factura;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setcon_orden_compra(Boolean newcon_orden_compra)throws Exception
	{
		try {
			if(this.con_orden_compra!=newcon_orden_compra) {
				if(newcon_orden_compra==null) {
					//newcon_orden_compra=false;
					if(Constantes.ISDEVELOPING) {
						System.out.println("SubPreguntaEvaluacion:Valor nulo no permitido en columna con_orden_compra");
					}
				}

				this.con_orden_compra=newcon_orden_compra;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setcon_completo(Boolean newcon_completo)throws Exception
	{
		try {
			if(this.con_completo!=newcon_completo) {
				if(newcon_completo==null) {
					//newcon_completo=false;
					if(Constantes.ISDEVELOPING) {
						System.out.println("SubPreguntaEvaluacion:Valor nulo no permitido en columna con_completo");
					}
				}

				this.con_completo=newcon_completo;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setcon_a_tiempo(Boolean newcon_a_tiempo)throws Exception
	{
		try {
			if(this.con_a_tiempo!=newcon_a_tiempo) {
				if(newcon_a_tiempo==null) {
					//newcon_a_tiempo=false;
					if(Constantes.ISDEVELOPING) {
						System.out.println("SubPreguntaEvaluacion:Valor nulo no permitido en columna con_a_tiempo");
					}
				}

				this.con_a_tiempo=newcon_a_tiempo;
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

	public PreguntaEvaluacion getPreguntaEvaluacion() {
		return this.preguntaevaluacion;
	}

	public Ejercicio getEjercicio() {
		return this.ejercicio;
	}

	public Periodo getPeriodo() {
		return this.periodo;
	}

	
	
	public String getempresa_descripcion() {
		return this.empresa_descripcion;
	}

	public String getsucursal_descripcion() {
		return this.sucursal_descripcion;
	}

	public String getpreguntaevaluacion_descripcion() {
		return this.preguntaevaluacion_descripcion;
	}

	public String getejercicio_descripcion() {
		return this.ejercicio_descripcion;
	}

	public String getperiodo_descripcion() {
		return this.periodo_descripcion;
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


	public  void  setPreguntaEvaluacion(PreguntaEvaluacion preguntaevaluacion) {
		try {
			this.preguntaevaluacion=preguntaevaluacion;
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


	public  void  setPeriodo(Periodo periodo) {
		try {
			this.periodo=periodo;
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


	public  void  setpreguntaevaluacion_descripcion(String preguntaevaluacion_descripcion) {
		try {
			this.preguntaevaluacion_descripcion=preguntaevaluacion_descripcion;
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


	public  void  setperiodo_descripcion(String periodo_descripcion) {
		try {
			this.periodo_descripcion=periodo_descripcion;
		} catch(Exception e) {
			;
		}
	}


	
	
	public List<DetalleEvaluacionProveedor> getDetalleEvaluacionProveedors() {
		return this.detalleevaluacionproveedors;
	}

	
	
	public  void  setDetalleEvaluacionProveedors(List<DetalleEvaluacionProveedor> detalleevaluacionproveedors) {
		try {
			this.detalleevaluacionproveedors=detalleevaluacionproveedors;
		} catch(Exception e) {
			;
		}
	}

	
	/*PARA REPORTES*/
	String id_empresa_descripcion="";String id_sucursal_descripcion="";String id_pregunta_evaluacion_descripcion="";String id_ejercicio_descripcion="";String id_periodo_descripcion="";String con_factura_descripcion="";String con_orden_compra_descripcion="";String con_completo_descripcion="";String con_a_tiempo_descripcion="";
	
	
	public String getid_empresa_descripcion() {
		return id_empresa_descripcion;
	}
	public String getid_sucursal_descripcion() {
		return id_sucursal_descripcion;
	}
	public String getid_pregunta_evaluacion_descripcion() {
		return id_pregunta_evaluacion_descripcion;
	}
	public String getid_ejercicio_descripcion() {
		return id_ejercicio_descripcion;
	}
	public String getid_periodo_descripcion() {
		return id_periodo_descripcion;
	}
	public String getcon_factura_descripcion() {
		return con_factura_descripcion;
	}
	public String getcon_orden_compra_descripcion() {
		return con_orden_compra_descripcion;
	}
	public String getcon_completo_descripcion() {
		return con_completo_descripcion;
	}
	public String getcon_a_tiempo_descripcion() {
		return con_a_tiempo_descripcion;
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
	public void setid_pregunta_evaluacion_descripcion(String newid_pregunta_evaluacion_descripcion)throws Exception {
		try {
			this.id_pregunta_evaluacion_descripcion=newid_pregunta_evaluacion_descripcion;
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
	public void setid_periodo_descripcion(String newid_periodo_descripcion)throws Exception {
		try {
			this.id_periodo_descripcion=newid_periodo_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setcon_factura_descripcion(String newcon_factura_descripcion)throws Exception {
		try {
			this.con_factura_descripcion=newcon_factura_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setcon_orden_compra_descripcion(String newcon_orden_compra_descripcion)throws Exception {
		try {
			this.con_orden_compra_descripcion=newcon_orden_compra_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setcon_completo_descripcion(String newcon_completo_descripcion)throws Exception {
		try {
			this.con_completo_descripcion=newcon_completo_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setcon_a_tiempo_descripcion(String newcon_a_tiempo_descripcion)throws Exception {
		try {
			this.con_a_tiempo_descripcion=newcon_a_tiempo_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	
	public void inicializarVariablesParaReporte() {
		this.id_empresa_descripcion="";this.id_sucursal_descripcion="";this.id_pregunta_evaluacion_descripcion="";this.id_ejercicio_descripcion="";this.id_periodo_descripcion="";this.con_factura_descripcion="";this.con_orden_compra_descripcion="";this.con_completo_descripcion="";this.con_a_tiempo_descripcion="";
	}
	
	
	Object detalleevaluacionproveedorsDescripcionReporte;
	
	
	public Object getdetalleevaluacionproveedorsDescripcionReporte() {
		return detalleevaluacionproveedorsDescripcionReporte;
	}

	
	
	public  void  setdetalleevaluacionproveedorsDescripcionReporte(Object detalleevaluacionproveedors) {
		try {
			this.detalleevaluacionproveedorsDescripcionReporte=detalleevaluacionproveedors;
		} catch(Exception ex) {
			;
		}
	}

	/*PARA REPORTES FIN*/		
}

