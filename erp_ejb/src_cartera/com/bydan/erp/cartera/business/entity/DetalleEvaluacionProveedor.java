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
//import com.bydan.erp.cartera.util.DetalleEvaluacionProveedorConstantesFunciones;
import com.bydan.erp.cartera.util.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.contabilidad.util.*;



import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;




@SuppressWarnings("unused")
public class DetalleEvaluacionProveedor extends DetalleEvaluacionProveedorAdditional implements Serializable ,Cloneable {//DetalleEvaluacionProveedorAdditional,GeneralEntity
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
	
	private DetalleEvaluacionProveedor detalleevaluacionproveedorOriginal;
	
	private Map<String, Object> mapDetalleEvaluacionProveedor;
			
	public Map<String, Object> getMapDetalleEvaluacionProveedor() {
		return mapDetalleEvaluacionProveedor;
	}

	public void setMapDetalleEvaluacionProveedor(Map<String, Object> mapDetalleEvaluacionProveedor) {
		this.mapDetalleEvaluacionProveedor = mapDetalleEvaluacionProveedor;
	}
	
	public void inicializarMapDetalleEvaluacionProveedor() {
		this.mapDetalleEvaluacionProveedor = new HashMap<String,Object>();
	}
	
	public void setMapDetalleEvaluacionProveedorValue(String sKey,Object oValue) {
		this.mapDetalleEvaluacionProveedor.put(sKey, oValue);
	}
	
	public Object getMapDetalleEvaluacionProveedorValue(String sKey) {
		return this.mapDetalleEvaluacionProveedor.get(sKey);
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
	private Long id_ejercicio;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_periodo;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_evaluacion_proveedor;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_pregunta_evaluacion;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_sub_pregunta_evaluacion;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_si_no;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=150,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=DetalleEvaluacionProveedorConstantesFunciones.SREGEXDESCRIPCION,message=DetalleEvaluacionProveedorConstantesFunciones.SMENSAJEREGEXDESCRIPCION)
	private String descripcion;
			
	
	public Empresa empresa;
	public Sucursal sucursal;
	public Ejercicio ejercicio;
	public Periodo periodo;
	public EvaluacionProveedor evaluacionproveedor;
	public PreguntaEvaluacion preguntaevaluacion;
	public SubPreguntaEvaluacion subpreguntaevaluacion;
	public SiNo sino;
	
	
	private String empresa_descripcion;
	private String sucursal_descripcion;
	private String ejercicio_descripcion;
	private String periodo_descripcion;
	private String evaluacionproveedor_descripcion;
	private String preguntaevaluacion_descripcion;
	private String subpreguntaevaluacion_descripcion;
	private String sino_descripcion;
	
	
		
	public DetalleEvaluacionProveedor () throws Exception {
		super();		
		
		this.id=0L;
		
		
		this.versionRow=new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());//new Date();
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		this.sType="NONE";
		
		this.detalleevaluacionproveedorOriginal=this;
		
 		this.id_empresa=-1L;
 		this.id_sucursal=-1L;
 		this.id_ejercicio=-1L;
 		this.id_periodo=-1L;
 		this.id_evaluacion_proveedor=-1L;
 		this.id_pregunta_evaluacion=-1L;
 		this.id_sub_pregunta_evaluacion=-1L;
 		this.id_si_no=-1L;
 		this.descripcion="";
		
		
		this.empresa=null;
		this.sucursal=null;
		this.ejercicio=null;
		this.periodo=null;
		this.evaluacionproveedor=null;
		this.preguntaevaluacion=null;
		this.subpreguntaevaluacion=null;
		this.sino=null;
		
		
		this.empresa_descripcion="";
		this.sucursal_descripcion="";
		this.ejercicio_descripcion="";
		this.periodo_descripcion="";
		this.evaluacionproveedor_descripcion="";
		this.preguntaevaluacion_descripcion="";
		this.subpreguntaevaluacion_descripcion="";
		this.sino_descripcion="";
		
		
		
			
		
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
    //PARA REPORTES
	public DetalleEvaluacionProveedor (Long id,Date versionRow,Long id_empresa,Long id_sucursal,Long id_ejercicio,Long id_periodo,Long id_evaluacion_proveedor,Long id_pregunta_evaluacion,Long id_sub_pregunta_evaluacion,Long id_si_no,String descripcion) throws Exception {
		super();		
		
		this.id=id;
		this.versionRow=versionRow;
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.detalleevaluacionproveedorOriginal=this;
		
 		this.id_empresa=id_empresa;
 		this.id_sucursal=id_sucursal;
 		this.id_ejercicio=id_ejercicio;
 		this.id_periodo=id_periodo;
 		this.id_evaluacion_proveedor=id_evaluacion_proveedor;
 		this.id_pregunta_evaluacion=id_pregunta_evaluacion;
 		this.id_sub_pregunta_evaluacion=id_sub_pregunta_evaluacion;
 		this.id_si_no=id_si_no;
 		this.descripcion=descripcion;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	 //PARA REPORTES
	public DetalleEvaluacionProveedor (Long id_empresa,Long id_sucursal,Long id_ejercicio,Long id_periodo,Long id_evaluacion_proveedor,Long id_pregunta_evaluacion,Long id_sub_pregunta_evaluacion,Long id_si_no,String descripcion) throws Exception {
		super();		
		
		this.id=0L;
		this.versionRow=new Date();
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.detalleevaluacionproveedorOriginal=this;
		
 		this.id_empresa=id_empresa;
 		this.id_sucursal=id_sucursal;
 		this.id_ejercicio=id_ejercicio;
 		this.id_periodo=id_periodo;
 		this.id_evaluacion_proveedor=id_evaluacion_proveedor;
 		this.id_pregunta_evaluacion=id_pregunta_evaluacion;
 		this.id_sub_pregunta_evaluacion=id_sub_pregunta_evaluacion;
 		this.id_si_no=id_si_no;
 		this.descripcion=descripcion;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	public boolean equals(Object object) {
		boolean equal=false;
		DetalleEvaluacionProveedor detalleevaluacionproveedorLocal=null;
		
		if(object!=null) {
			detalleevaluacionproveedorLocal=(DetalleEvaluacionProveedor)object;
			
			if(detalleevaluacionproveedorLocal!=null) {
				if(this.getId()!=null && detalleevaluacionproveedorLocal.getId()!=null) {
					if(this.getId().equals(detalleevaluacionproveedorLocal.getId())) {
						equal=true;
					}
				}
			}
		}
		
		return equal;
	}
	
	public String toString() {
		String sDetalle="";
		
		if(!DetalleEvaluacionProveedorConstantesFunciones.CON_DESCRIPCION_DETALLADO) {
        	sDetalle=DetalleEvaluacionProveedorConstantesFunciones.getDetalleEvaluacionProveedorDescripcion(this);
		} else {
			sDetalle=DetalleEvaluacionProveedorConstantesFunciones.getDetalleEvaluacionProveedorDescripcionDetallado(this);
		}
		
		return sDetalle;
    }
	
	public DetalleEvaluacionProveedor getDetalleEvaluacionProveedorOriginal() {
		return this.detalleevaluacionproveedorOriginal;
	}
	
	public void setDetalleEvaluacionProveedorOriginal(DetalleEvaluacionProveedor detalleevaluacionproveedor) {
		try {
			this.detalleevaluacionproveedorOriginal=detalleevaluacionproveedor;
		} catch(Exception e) {
			;
		}
	}
	
	
	protected DetalleEvaluacionProveedorAdditional detalleevaluacionproveedorAdditional=null;
	
	public DetalleEvaluacionProveedorAdditional getDetalleEvaluacionProveedorAdditional() {
		return this.detalleevaluacionproveedorAdditional;
	}
	
	public void setDetalleEvaluacionProveedorAdditional(DetalleEvaluacionProveedorAdditional detalleevaluacionproveedorAdditional) {
		try {
			this.detalleevaluacionproveedorAdditional=detalleevaluacionproveedorAdditional;
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
    
	
	public Long getid_ejercicio() {
		return this.id_ejercicio;
	}
    
	
	public Long getid_periodo() {
		return this.id_periodo;
	}
    
	
	public Long getid_evaluacion_proveedor() {
		return this.id_evaluacion_proveedor;
	}
    
	
	public Long getid_pregunta_evaluacion() {
		return this.id_pregunta_evaluacion;
	}
    
	
	public Long getid_sub_pregunta_evaluacion() {
		return this.id_sub_pregunta_evaluacion;
	}
    
	
	public Long getid_si_no() {
		return this.id_si_no;
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
						System.out.println("DetalleEvaluacionProveedor:Valor nulo no permitido en columna id_empresa");
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
						System.out.println("DetalleEvaluacionProveedor:Valor nulo no permitido en columna id_sucursal");
					}
				}

				this.id_sucursal=newid_sucursal;
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
						System.out.println("DetalleEvaluacionProveedor:Valor nulo no permitido en columna id_ejercicio");
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
						System.out.println("DetalleEvaluacionProveedor:Valor nulo no permitido en columna id_periodo");
					}
				}

				this.id_periodo=newid_periodo;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_evaluacion_proveedor(Long newid_evaluacion_proveedor)throws Exception
	{
		try {
			if(this.id_evaluacion_proveedor!=newid_evaluacion_proveedor) {
				if(newid_evaluacion_proveedor==null) {
					//newid_evaluacion_proveedor=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("DetalleEvaluacionProveedor:Valor nulo no permitido en columna id_evaluacion_proveedor");
					}
				}

				this.id_evaluacion_proveedor=newid_evaluacion_proveedor;
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
						System.out.println("DetalleEvaluacionProveedor:Valor nulo no permitido en columna id_pregunta_evaluacion");
					}
				}

				this.id_pregunta_evaluacion=newid_pregunta_evaluacion;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_sub_pregunta_evaluacion(Long newid_sub_pregunta_evaluacion)throws Exception
	{
		try {
			if(this.id_sub_pregunta_evaluacion!=newid_sub_pregunta_evaluacion) {
				if(newid_sub_pregunta_evaluacion==null) {
					//newid_sub_pregunta_evaluacion=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("DetalleEvaluacionProveedor:Valor nulo no permitido en columna id_sub_pregunta_evaluacion");
					}
				}

				this.id_sub_pregunta_evaluacion=newid_sub_pregunta_evaluacion;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_si_no(Long newid_si_no)throws Exception
	{
		try {
			if(this.id_si_no!=newid_si_no) {
				if(newid_si_no==null) {
					//newid_si_no=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("DetalleEvaluacionProveedor:Valor nulo no permitido en columna id_si_no");
					}
				}

				this.id_si_no=newid_si_no;
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
						System.out.println("DetalleEvaluacionProveedor:Valor nulo no permitido en columna descripcion");
					}
				}

				if(newdescripcion!=null&&newdescripcion.length()>150) {
					newdescripcion=newdescripcion.substring(0,148);
					System.out.println("DetalleEvaluacionProveedor:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=150 en columna descripcion");
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

	public Sucursal getSucursal() {
		return this.sucursal;
	}

	public Ejercicio getEjercicio() {
		return this.ejercicio;
	}

	public Periodo getPeriodo() {
		return this.periodo;
	}

	public EvaluacionProveedor getEvaluacionProveedor() {
		return this.evaluacionproveedor;
	}

	public PreguntaEvaluacion getPreguntaEvaluacion() {
		return this.preguntaevaluacion;
	}

	public SubPreguntaEvaluacion getSubPreguntaEvaluacion() {
		return this.subpreguntaevaluacion;
	}

	public SiNo getSiNo() {
		return this.sino;
	}

	
	
	public String getempresa_descripcion() {
		return this.empresa_descripcion;
	}

	public String getsucursal_descripcion() {
		return this.sucursal_descripcion;
	}

	public String getejercicio_descripcion() {
		return this.ejercicio_descripcion;
	}

	public String getperiodo_descripcion() {
		return this.periodo_descripcion;
	}

	public String getevaluacionproveedor_descripcion() {
		return this.evaluacionproveedor_descripcion;
	}

	public String getpreguntaevaluacion_descripcion() {
		return this.preguntaevaluacion_descripcion;
	}

	public String getsubpreguntaevaluacion_descripcion() {
		return this.subpreguntaevaluacion_descripcion;
	}

	public String getsino_descripcion() {
		return this.sino_descripcion;
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


	public  void  setEvaluacionProveedor(EvaluacionProveedor evaluacionproveedor) {
		try {
			this.evaluacionproveedor=evaluacionproveedor;
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


	public  void  setSubPreguntaEvaluacion(SubPreguntaEvaluacion subpreguntaevaluacion) {
		try {
			this.subpreguntaevaluacion=subpreguntaevaluacion;
		} catch(Exception e) {
			;
		}
	}


	public  void  setSiNo(SiNo sino) {
		try {
			this.sino=sino;
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


	public  void  setevaluacionproveedor_descripcion(String evaluacionproveedor_descripcion) {
		try {
			this.evaluacionproveedor_descripcion=evaluacionproveedor_descripcion;
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


	public  void  setsubpreguntaevaluacion_descripcion(String subpreguntaevaluacion_descripcion) {
		try {
			this.subpreguntaevaluacion_descripcion=subpreguntaevaluacion_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  setsino_descripcion(String sino_descripcion) {
		try {
			this.sino_descripcion=sino_descripcion;
		} catch(Exception e) {
			;
		}
	}


	
	
	
	
	
	/*PARA REPORTES*/
	String id_empresa_descripcion="";String id_sucursal_descripcion="";String id_ejercicio_descripcion="";String id_periodo_descripcion="";String id_evaluacion_proveedor_descripcion="";String id_pregunta_evaluacion_descripcion="";String id_sub_pregunta_evaluacion_descripcion="";String id_si_no_descripcion="";
	
	
	public String getid_empresa_descripcion() {
		return id_empresa_descripcion;
	}
	public String getid_sucursal_descripcion() {
		return id_sucursal_descripcion;
	}
	public String getid_ejercicio_descripcion() {
		return id_ejercicio_descripcion;
	}
	public String getid_periodo_descripcion() {
		return id_periodo_descripcion;
	}
	public String getid_evaluacion_proveedor_descripcion() {
		return id_evaluacion_proveedor_descripcion;
	}
	public String getid_pregunta_evaluacion_descripcion() {
		return id_pregunta_evaluacion_descripcion;
	}
	public String getid_sub_pregunta_evaluacion_descripcion() {
		return id_sub_pregunta_evaluacion_descripcion;
	}
	public String getid_si_no_descripcion() {
		return id_si_no_descripcion;
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
	public void setid_evaluacion_proveedor_descripcion(String newid_evaluacion_proveedor_descripcion)throws Exception {
		try {
			this.id_evaluacion_proveedor_descripcion=newid_evaluacion_proveedor_descripcion;
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
	public void setid_sub_pregunta_evaluacion_descripcion(String newid_sub_pregunta_evaluacion_descripcion)throws Exception {
		try {
			this.id_sub_pregunta_evaluacion_descripcion=newid_sub_pregunta_evaluacion_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_si_no_descripcion(String newid_si_no_descripcion)throws Exception {
		try {
			this.id_si_no_descripcion=newid_si_no_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	
	public void inicializarVariablesParaReporte() {
		this.id_empresa_descripcion="";this.id_sucursal_descripcion="";this.id_ejercicio_descripcion="";this.id_periodo_descripcion="";this.id_evaluacion_proveedor_descripcion="";this.id_pregunta_evaluacion_descripcion="";this.id_sub_pregunta_evaluacion_descripcion="";this.id_si_no_descripcion="";
	}
	
	
	
	
	
	
	/*PARA REPORTES FIN*/		
}

