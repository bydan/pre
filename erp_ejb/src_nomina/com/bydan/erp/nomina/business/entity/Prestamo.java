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
//import com.bydan.erp.nomina.util.PrestamoConstantesFunciones;
import com.bydan.erp.nomina.util.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.contabilidad.util.*;



import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;




@SuppressWarnings("unused")
public class Prestamo extends PrestamoAdditional implements Serializable ,Cloneable {//PrestamoAdditional,GeneralEntity
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
	
	private Prestamo prestamoOriginal;
	
	private Map<String, Object> mapPrestamo;
			
	public Map<String, Object> getMapPrestamo() {
		return mapPrestamo;
	}

	public void setMapPrestamo(Map<String, Object> mapPrestamo) {
		this.mapPrestamo = mapPrestamo;
	}
	
	public void inicializarMapPrestamo() {
		this.mapPrestamo = new HashMap<String,Object>();
	}
	
	public void setMapPrestamoValue(String sKey,Object oValue) {
		this.mapPrestamo.put(sKey, oValue);
	}
	
	public Object getMapPrestamoValue(String sKey) {
		return this.mapPrestamo.get(sKey);
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
	private Long id_tipo_prestamo;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_tipo_cuota;
	
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=-100000,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_asiento_contable;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=50,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=PrestamoConstantesFunciones.SREGEXCODIGO,message=PrestamoConstantesFunciones.SMENSAJEREGEXCODIGO)
	private String codigo;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=50,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=PrestamoConstantesFunciones.SREGEXNUMERO_PRE_IMPRESO,message=PrestamoConstantesFunciones.SMENSAJEREGEXNUMERO_PRE_IMPRESO)
	private String numero_pre_impreso;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Date fecha;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double monto;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=10,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONINT)
	private Integer numero_cuotas;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double tasa;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=100,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=PrestamoConstantesFunciones.SREGEXDESCRIPCION,message=PrestamoConstantesFunciones.SMENSAJEREGEXDESCRIPCION)
	private String descripcion;
			
	
	public Empresa empresa;
	public Empleado empleado;
	public TipoPrestamo tipoprestamo;
	public TipoCuota tipocuota;
	public AsientoContable asientocontable;
	
	
	private String empresa_descripcion;
	private String empleado_descripcion;
	private String tipoprestamo_descripcion;
	private String tipocuota_descripcion;
	private String asientocontable_descripcion;
	
	
	public List<AbonoPrestamo> abonoprestamos;
	public List<Cuota> cuotas;
		
	public Prestamo () throws Exception {
		super();		
		
		this.id=0L;
		
		
		this.versionRow=new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());//new Date();
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		this.sType="NONE";
		
		this.prestamoOriginal=this;
		
 		this.id_empresa=-1L;
 		this.id_empleado=-1L;
 		this.id_tipo_prestamo=-1L;
 		this.id_tipo_cuota=-1L;
 		this.id_asiento_contable=null;
 		this.codigo="";
 		this.numero_pre_impreso="";
 		this.fecha=new Date();
 		this.monto=0.0;
 		this.numero_cuotas=0;
 		this.tasa=0.0;
 		this.descripcion="";
		
		
		this.empresa=null;
		this.empleado=null;
		this.tipoprestamo=null;
		this.tipocuota=null;
		this.asientocontable=null;
		
		
		this.empresa_descripcion="";
		this.empleado_descripcion="";
		this.tipoprestamo_descripcion="";
		this.tipocuota_descripcion="";
		this.asientocontable_descripcion="";
		
		
		this.abonoprestamos=null;
		this.cuotas=null;
		
			
		
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
    //PARA REPORTES
	public Prestamo (Long id,Date versionRow,Long id_empresa,Long id_empleado,Long id_tipo_prestamo,Long id_tipo_cuota,Long id_asiento_contable,String codigo,String numero_pre_impreso,Date fecha,Double monto,Integer numero_cuotas,Double tasa,String descripcion) throws Exception {
		super();		
		
		this.id=id;
		this.versionRow=versionRow;
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.prestamoOriginal=this;
		
 		this.id_empresa=id_empresa;
 		this.id_empleado=id_empleado;
 		this.id_tipo_prestamo=id_tipo_prestamo;
 		this.id_tipo_cuota=id_tipo_cuota;
 		this.id_asiento_contable=id_asiento_contable;
 		this.codigo=codigo;
 		this.numero_pre_impreso=numero_pre_impreso;
 		this.fecha=fecha;
 		this.monto=monto;
 		this.numero_cuotas=numero_cuotas;
 		this.tasa=tasa;
 		this.descripcion=descripcion;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	 //PARA REPORTES
	public Prestamo (Long id_empresa,Long id_empleado,Long id_tipo_prestamo,Long id_tipo_cuota,Long id_asiento_contable,String codigo,String numero_pre_impreso,Date fecha,Double monto,Integer numero_cuotas,Double tasa,String descripcion) throws Exception {
		super();		
		
		this.id=0L;
		this.versionRow=new Date();
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.prestamoOriginal=this;
		
 		this.id_empresa=id_empresa;
 		this.id_empleado=id_empleado;
 		this.id_tipo_prestamo=id_tipo_prestamo;
 		this.id_tipo_cuota=id_tipo_cuota;
 		this.id_asiento_contable=id_asiento_contable;
 		this.codigo=codigo;
 		this.numero_pre_impreso=numero_pre_impreso;
 		this.fecha=fecha;
 		this.monto=monto;
 		this.numero_cuotas=numero_cuotas;
 		this.tasa=tasa;
 		this.descripcion=descripcion;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	public boolean equals(Object object) {
		boolean equal=false;
		Prestamo prestamoLocal=null;
		
		if(object!=null) {
			prestamoLocal=(Prestamo)object;
			
			if(prestamoLocal!=null) {
				if(this.getId()!=null && prestamoLocal.getId()!=null) {
					if(this.getId().equals(prestamoLocal.getId())) {
						equal=true;
					}
				}
			}
		}
		
		return equal;
	}
	
	public String toString() {
		String sDetalle="";
		
		if(!PrestamoConstantesFunciones.CON_DESCRIPCION_DETALLADO) {
        	sDetalle=PrestamoConstantesFunciones.getPrestamoDescripcion(this);
		} else {
			sDetalle=PrestamoConstantesFunciones.getPrestamoDescripcionDetallado(this);
		}
		
		return sDetalle;
    }
	
	public Prestamo getPrestamoOriginal() {
		return this.prestamoOriginal;
	}
	
	public void setPrestamoOriginal(Prestamo prestamo) {
		try {
			this.prestamoOriginal=prestamo;
		} catch(Exception e) {
			;
		}
	}
	
	
	protected PrestamoAdditional prestamoAdditional=null;
	
	public PrestamoAdditional getPrestamoAdditional() {
		return this.prestamoAdditional;
	}
	
	public void setPrestamoAdditional(PrestamoAdditional prestamoAdditional) {
		try {
			this.prestamoAdditional=prestamoAdditional;
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
    
	
	public Long getid_tipo_prestamo() {
		return this.id_tipo_prestamo;
	}
    
	
	public Long getid_tipo_cuota() {
		return this.id_tipo_cuota;
	}
    
	
	public Long getid_asiento_contable() {
		return this.id_asiento_contable;
	}
    
	
	public String getcodigo() {
		return this.codigo;
	}
    
	
	public String getnumero_pre_impreso() {
		return this.numero_pre_impreso;
	}
    
	
	public Date getfecha() {
		return this.fecha;
	}
    
	
	public Double getmonto() {
		return this.monto;
	}
    
	
	public Integer getnumero_cuotas() {
		return this.numero_cuotas;
	}
    
	
	public Double gettasa() {
		return this.tasa;
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
						System.out.println("Prestamo:Valor nulo no permitido en columna id_empresa");
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
						System.out.println("Prestamo:Valor nulo no permitido en columna id_empleado");
					}
				}

				this.id_empleado=newid_empleado;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_tipo_prestamo(Long newid_tipo_prestamo)throws Exception
	{
		try {
			if(this.id_tipo_prestamo!=newid_tipo_prestamo) {
				if(newid_tipo_prestamo==null) {
					//newid_tipo_prestamo=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("Prestamo:Valor nulo no permitido en columna id_tipo_prestamo");
					}
				}

				this.id_tipo_prestamo=newid_tipo_prestamo;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_tipo_cuota(Long newid_tipo_cuota)throws Exception
	{
		try {
			if(this.id_tipo_cuota!=newid_tipo_cuota) {
				if(newid_tipo_cuota==null) {
					//newid_tipo_cuota=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("Prestamo:Valor nulo no permitido en columna id_tipo_cuota");
					}
				}

				this.id_tipo_cuota=newid_tipo_cuota;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_asiento_contable(Long newid_asiento_contable) {
		if(this.id_asiento_contable==null&&newid_asiento_contable!=null) {
			this.id_asiento_contable=newid_asiento_contable;
				this.setIsChanged(true);
		}

		if(this.id_asiento_contable!=null&&!this.id_asiento_contable.equals(newid_asiento_contable)) {

			this.id_asiento_contable=newid_asiento_contable;
				this.setIsChanged(true);
		}
	}
    
	public void setcodigo(String newcodigo)throws Exception
	{
		try {
			if(this.codigo!=newcodigo) {
				if(newcodigo==null) {
					//newcodigo="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("Prestamo:Valor nulo no permitido en columna codigo");
					}
				}

				if(newcodigo!=null&&newcodigo.length()>50) {
					newcodigo=newcodigo.substring(0,48);
					System.out.println("Prestamo:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=50 en columna codigo");
				}

				this.codigo=newcodigo;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setnumero_pre_impreso(String newnumero_pre_impreso)throws Exception
	{
		try {
			if(this.numero_pre_impreso!=newnumero_pre_impreso) {
				if(newnumero_pre_impreso==null) {
					//newnumero_pre_impreso="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("Prestamo:Valor nulo no permitido en columna numero_pre_impreso");
					}
				}

				if(newnumero_pre_impreso!=null&&newnumero_pre_impreso.length()>50) {
					newnumero_pre_impreso=newnumero_pre_impreso.substring(0,48);
					System.out.println("Prestamo:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=50 en columna numero_pre_impreso");
				}

				this.numero_pre_impreso=newnumero_pre_impreso;
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
						System.out.println("Prestamo:Valor nulo no permitido en columna fecha");
					}
				}

				this.fecha=newfecha;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setmonto(Double newmonto)throws Exception
	{
		try {
			if(this.monto!=newmonto) {
				if(newmonto==null) {
					//newmonto=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("Prestamo:Valor nulo no permitido en columna monto");
					}
				}

				this.monto=newmonto;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setnumero_cuotas(Integer newnumero_cuotas)throws Exception
	{
		try {
			if(this.numero_cuotas!=newnumero_cuotas) {
				if(newnumero_cuotas==null) {
					//newnumero_cuotas=0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("Prestamo:Valor nulo no permitido en columna numero_cuotas");
					}
				}

				this.numero_cuotas=newnumero_cuotas;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void settasa(Double newtasa)throws Exception
	{
		try {
			if(this.tasa!=newtasa) {
				if(newtasa==null) {
					//newtasa=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("Prestamo:Valor nulo no permitido en columna tasa");
					}
				}

				this.tasa=newtasa;
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
						System.out.println("Prestamo:Valor nulo no permitido en columna descripcion");
					}
				}

				if(newdescripcion!=null&&newdescripcion.length()>100) {
					newdescripcion=newdescripcion.substring(0,98);
					System.out.println("Prestamo:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=100 en columna descripcion");
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

	public TipoPrestamo getTipoPrestamo() {
		return this.tipoprestamo;
	}

	public TipoCuota getTipoCuota() {
		return this.tipocuota;
	}

	public AsientoContable getAsientoContable() {
		return this.asientocontable;
	}

	
	
	public String getempresa_descripcion() {
		return this.empresa_descripcion;
	}

	public String getempleado_descripcion() {
		return this.empleado_descripcion;
	}

	public String gettipoprestamo_descripcion() {
		return this.tipoprestamo_descripcion;
	}

	public String gettipocuota_descripcion() {
		return this.tipocuota_descripcion;
	}

	public String getasientocontable_descripcion() {
		return this.asientocontable_descripcion;
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


	public  void  setTipoPrestamo(TipoPrestamo tipoprestamo) {
		try {
			this.tipoprestamo=tipoprestamo;
		} catch(Exception e) {
			;
		}
	}


	public  void  setTipoCuota(TipoCuota tipocuota) {
		try {
			this.tipocuota=tipocuota;
		} catch(Exception e) {
			;
		}
	}


	public  void  setAsientoContable(AsientoContable asientocontable) {
		try {
			this.asientocontable=asientocontable;
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


	public  void  settipoprestamo_descripcion(String tipoprestamo_descripcion) {
		try {
			this.tipoprestamo_descripcion=tipoprestamo_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  settipocuota_descripcion(String tipocuota_descripcion) {
		try {
			this.tipocuota_descripcion=tipocuota_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  setasientocontable_descripcion(String asientocontable_descripcion) {
		try {
			this.asientocontable_descripcion=asientocontable_descripcion;
		} catch(Exception e) {
			;
		}
	}


	
	
	public List<AbonoPrestamo> getAbonoPrestamos() {
		return this.abonoprestamos;
	}

	public List<Cuota> getCuotas() {
		return this.cuotas;
	}

	
	
	public  void  setAbonoPrestamos(List<AbonoPrestamo> abonoprestamos) {
		try {
			this.abonoprestamos=abonoprestamos;
		} catch(Exception e) {
			;
		}
	}

	public  void  setCuotas(List<Cuota> cuotas) {
		try {
			this.cuotas=cuotas;
		} catch(Exception e) {
			;
		}
	}

	
	/*PARA REPORTES*/
	String id_empresa_descripcion="";String id_empleado_descripcion="";String id_tipo_prestamo_descripcion="";String id_tipo_cuota_descripcion="";String id_asiento_contable_descripcion="";
	
	
	public String getid_empresa_descripcion() {
		return id_empresa_descripcion;
	}
	public String getid_empleado_descripcion() {
		return id_empleado_descripcion;
	}
	public String getid_tipo_prestamo_descripcion() {
		return id_tipo_prestamo_descripcion;
	}
	public String getid_tipo_cuota_descripcion() {
		return id_tipo_cuota_descripcion;
	}
	public String getid_asiento_contable_descripcion() {
		return id_asiento_contable_descripcion;
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
	public void setid_tipo_prestamo_descripcion(String newid_tipo_prestamo_descripcion)throws Exception {
		try {
			this.id_tipo_prestamo_descripcion=newid_tipo_prestamo_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_tipo_cuota_descripcion(String newid_tipo_cuota_descripcion)throws Exception {
		try {
			this.id_tipo_cuota_descripcion=newid_tipo_cuota_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_asiento_contable_descripcion(String newid_asiento_contable_descripcion)throws Exception {
		try {
			this.id_asiento_contable_descripcion=newid_asiento_contable_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	
	public void inicializarVariablesParaReporte() {
		this.id_empresa_descripcion="";this.id_empleado_descripcion="";this.id_tipo_prestamo_descripcion="";this.id_tipo_cuota_descripcion="";this.id_asiento_contable_descripcion="";
	}
	
	
	Object abonoprestamosDescripcionReporte;
	Object cuotasDescripcionReporte;
	
	
	public Object getabonoprestamosDescripcionReporte() {
		return abonoprestamosDescripcionReporte;
	}

	public Object getcuotasDescripcionReporte() {
		return cuotasDescripcionReporte;
	}

	
	
	public  void  setabonoprestamosDescripcionReporte(Object abonoprestamos) {
		try {
			this.abonoprestamosDescripcionReporte=abonoprestamos;
		} catch(Exception ex) {
			;
		}
	}

	public  void  setcuotasDescripcionReporte(Object cuotas) {
		try {
			this.cuotasDescripcionReporte=cuotas;
		} catch(Exception ex) {
			;
		}
	}

	/*PARA REPORTES FIN*/		
}

