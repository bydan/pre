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
//import com.bydan.erp.nomina.util.CuotaConstantesFunciones;
import com.bydan.erp.nomina.util.*;









@SuppressWarnings("unused")
public class Cuota extends CuotaAdditional implements Serializable ,Cloneable {//CuotaAdditional,GeneralEntity
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
	
	private Cuota cuotaOriginal;
	
	private Map<String, Object> mapCuota;
			
	public Map<String, Object> getMapCuota() {
		return mapCuota;
	}

	public void setMapCuota(Map<String, Object> mapCuota) {
		this.mapCuota = mapCuota;
	}
	
	public void inicializarMapCuota() {
		this.mapCuota = new HashMap<String,Object>();
	}
	
	public void setMapCuotaValue(String sKey,Object oValue) {
		this.mapCuota.put(sKey, oValue);
	}
	
	public Object getMapCuotaValue(String sKey) {
		return this.mapCuota.get(sKey);
	}
	
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=-100000,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_prestamo;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_estado_cuota;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_defi_provision_empleado;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=10,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONINT)
	private Integer numero_cuota;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double capital;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double interes;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double total;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double fecha_liquidacion;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double monto_ajuste;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double interes_ajuste;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Date fecha_vencimiento;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=100,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=CuotaConstantesFunciones.SREGEXDESCRIPCION,message=CuotaConstantesFunciones.SMENSAJEREGEXDESCRIPCION)
	private String descripcion;
			
	
	public Prestamo prestamo;
	public EstadoCuota estadocuota;
	public DefiProvisionEmpleado defiprovisionempleado;
	
	
	private String prestamo_descripcion;
	private String estadocuota_descripcion;
	private String defiprovisionempleado_descripcion;
	
	
		
	public Cuota () throws Exception {
		super();		
		
		this.id=0L;
		
		
		this.versionRow=new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());//new Date();
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		this.sType="NONE";
		
		this.cuotaOriginal=this;
		
 		this.id_prestamo=-1L;
 		this.id_estado_cuota=-1L;
 		this.id_defi_provision_empleado=-1L;
 		this.numero_cuota=0;
 		this.capital=0.0;
 		this.interes=0.0;
 		this.total=0.0;
 		this.fecha_liquidacion=0.0;
 		this.monto_ajuste=0.0;
 		this.interes_ajuste=0.0;
 		this.fecha_vencimiento=new Date();
 		this.descripcion="";
		
		
		this.prestamo=null;
		this.estadocuota=null;
		this.defiprovisionempleado=null;
		
		
		this.prestamo_descripcion="";
		this.estadocuota_descripcion="";
		this.defiprovisionempleado_descripcion="";
		
		
		
			
		
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
    //PARA REPORTES
	public Cuota (Long id,Date versionRow,Long id_prestamo,Long id_estado_cuota,Long id_defi_provision_empleado,Integer numero_cuota,Double capital,Double interes,Double total,Double fecha_liquidacion,Double monto_ajuste,Double interes_ajuste,Date fecha_vencimiento,String descripcion) throws Exception {
		super();		
		
		this.id=id;
		this.versionRow=versionRow;
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.cuotaOriginal=this;
		
 		this.id_prestamo=id_prestamo;
 		this.id_estado_cuota=id_estado_cuota;
 		this.id_defi_provision_empleado=id_defi_provision_empleado;
 		this.numero_cuota=numero_cuota;
 		this.capital=capital;
 		this.interes=interes;
 		this.total=total;
 		this.fecha_liquidacion=fecha_liquidacion;
 		this.monto_ajuste=monto_ajuste;
 		this.interes_ajuste=interes_ajuste;
 		this.fecha_vencimiento=fecha_vencimiento;
 		this.descripcion=descripcion;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	 //PARA REPORTES
	public Cuota (Long id_prestamo,Long id_estado_cuota,Long id_defi_provision_empleado,Integer numero_cuota,Double capital,Double interes,Double total,Double fecha_liquidacion,Double monto_ajuste,Double interes_ajuste,Date fecha_vencimiento,String descripcion) throws Exception {
		super();		
		
		this.id=0L;
		this.versionRow=new Date();
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.cuotaOriginal=this;
		
 		this.id_prestamo=id_prestamo;
 		this.id_estado_cuota=id_estado_cuota;
 		this.id_defi_provision_empleado=id_defi_provision_empleado;
 		this.numero_cuota=numero_cuota;
 		this.capital=capital;
 		this.interes=interes;
 		this.total=total;
 		this.fecha_liquidacion=fecha_liquidacion;
 		this.monto_ajuste=monto_ajuste;
 		this.interes_ajuste=interes_ajuste;
 		this.fecha_vencimiento=fecha_vencimiento;
 		this.descripcion=descripcion;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	public boolean equals(Object object) {
		boolean equal=false;
		Cuota cuotaLocal=null;
		
		if(object!=null) {
			cuotaLocal=(Cuota)object;
			
			if(cuotaLocal!=null) {
				if(this.getId()!=null && cuotaLocal.getId()!=null) {
					if(this.getId().equals(cuotaLocal.getId())) {
						equal=true;
					}
				}
			}
		}
		
		return equal;
	}
	
	public String toString() {
		String sDetalle="";
		
		if(!CuotaConstantesFunciones.CON_DESCRIPCION_DETALLADO) {
        	sDetalle=CuotaConstantesFunciones.getCuotaDescripcion(this);
		} else {
			sDetalle=CuotaConstantesFunciones.getCuotaDescripcionDetallado(this);
		}
		
		return sDetalle;
    }
	
	public Cuota getCuotaOriginal() {
		return this.cuotaOriginal;
	}
	
	public void setCuotaOriginal(Cuota cuota) {
		try {
			this.cuotaOriginal=cuota;
		} catch(Exception e) {
			;
		}
	}
	
	
	protected CuotaAdditional cuotaAdditional=null;
	
	public CuotaAdditional getCuotaAdditional() {
		return this.cuotaAdditional;
	}
	
	public void setCuotaAdditional(CuotaAdditional cuotaAdditional) {
		try {
			this.cuotaAdditional=cuotaAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
    
	
	public Long getid_prestamo() {
		return this.id_prestamo;
	}
    
	
	public Long getid_estado_cuota() {
		return this.id_estado_cuota;
	}
    
	
	public Long getid_defi_provision_empleado() {
		return this.id_defi_provision_empleado;
	}
    
	
	public Integer getnumero_cuota() {
		return this.numero_cuota;
	}
    
	
	public Double getcapital() {
		return this.capital;
	}
    
	
	public Double getinteres() {
		return this.interes;
	}
    
	
	public Double gettotal() {
		return this.total;
	}
    
	
	public Double getfecha_liquidacion() {
		return this.fecha_liquidacion;
	}
    
	
	public Double getmonto_ajuste() {
		return this.monto_ajuste;
	}
    
	
	public Double getinteres_ajuste() {
		return this.interes_ajuste;
	}
    
	
	public Date getfecha_vencimiento() {
		return this.fecha_vencimiento;
	}
    
	
	public String getdescripcion() {
		return this.descripcion;
	}
	
    
	public void setid_prestamo(Long newid_prestamo)throws Exception
	{
		try {
			if(this.id_prestamo!=newid_prestamo) {
				if(newid_prestamo==null) {
					//newid_prestamo=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("Cuota:Valor nulo no permitido en columna id_prestamo");
					}
				}

				this.id_prestamo=newid_prestamo;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_estado_cuota(Long newid_estado_cuota)throws Exception
	{
		try {
			if(this.id_estado_cuota!=newid_estado_cuota) {
				if(newid_estado_cuota==null) {
					//newid_estado_cuota=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("Cuota:Valor nulo no permitido en columna id_estado_cuota");
					}
				}

				this.id_estado_cuota=newid_estado_cuota;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_defi_provision_empleado(Long newid_defi_provision_empleado)throws Exception
	{
		try {
			if(this.id_defi_provision_empleado!=newid_defi_provision_empleado) {
				if(newid_defi_provision_empleado==null) {
					//newid_defi_provision_empleado=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("Cuota:Valor nulo no permitido en columna id_defi_provision_empleado");
					}
				}

				this.id_defi_provision_empleado=newid_defi_provision_empleado;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setnumero_cuota(Integer newnumero_cuota)throws Exception
	{
		try {
			if(this.numero_cuota!=newnumero_cuota) {
				if(newnumero_cuota==null) {
					//newnumero_cuota=0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("Cuota:Valor nulo no permitido en columna numero_cuota");
					}
				}

				this.numero_cuota=newnumero_cuota;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setcapital(Double newcapital)throws Exception
	{
		try {
			if(this.capital!=newcapital) {
				if(newcapital==null) {
					//newcapital=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("Cuota:Valor nulo no permitido en columna capital");
					}
				}

				this.capital=newcapital;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setinteres(Double newinteres)throws Exception
	{
		try {
			if(this.interes!=newinteres) {
				if(newinteres==null) {
					//newinteres=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("Cuota:Valor nulo no permitido en columna interes");
					}
				}

				this.interes=newinteres;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void settotal(Double newtotal)throws Exception
	{
		try {
			if(this.total!=newtotal) {
				if(newtotal==null) {
					//newtotal=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("Cuota:Valor nulo no permitido en columna total");
					}
				}

				this.total=newtotal;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setfecha_liquidacion(Double newfecha_liquidacion)throws Exception
	{
		try {
			if(this.fecha_liquidacion!=newfecha_liquidacion) {
				if(newfecha_liquidacion==null) {
					//newfecha_liquidacion=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("Cuota:Valor nulo no permitido en columna fecha_liquidacion");
					}
				}

				this.fecha_liquidacion=newfecha_liquidacion;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setmonto_ajuste(Double newmonto_ajuste)throws Exception
	{
		try {
			if(this.monto_ajuste!=newmonto_ajuste) {
				if(newmonto_ajuste==null) {
					//newmonto_ajuste=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("Cuota:Valor nulo no permitido en columna monto_ajuste");
					}
				}

				this.monto_ajuste=newmonto_ajuste;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setinteres_ajuste(Double newinteres_ajuste)throws Exception
	{
		try {
			if(this.interes_ajuste!=newinteres_ajuste) {
				if(newinteres_ajuste==null) {
					//newinteres_ajuste=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("Cuota:Valor nulo no permitido en columna interes_ajuste");
					}
				}

				this.interes_ajuste=newinteres_ajuste;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setfecha_vencimiento(Date newfecha_vencimiento)throws Exception
	{
		try {
			if(this.fecha_vencimiento!=newfecha_vencimiento) {
				if(newfecha_vencimiento==null) {
					//newfecha_vencimiento=new Date();
					if(Constantes.ISDEVELOPING) {
						System.out.println("Cuota:Valor nulo no permitido en columna fecha_vencimiento");
					}
				}

				this.fecha_vencimiento=newfecha_vencimiento;
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
						System.out.println("Cuota:Valor nulo no permitido en columna descripcion");
					}
				}

				if(newdescripcion!=null&&newdescripcion.length()>100) {
					newdescripcion=newdescripcion.substring(0,98);
					System.out.println("Cuota:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=100 en columna descripcion");
				}

				this.descripcion=newdescripcion;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	
	public Prestamo getPrestamo() {
		return this.prestamo;
	}

	public EstadoCuota getEstadoCuota() {
		return this.estadocuota;
	}

	public DefiProvisionEmpleado getDefiProvisionEmpleado() {
		return this.defiprovisionempleado;
	}

	
	
	public String getprestamo_descripcion() {
		return this.prestamo_descripcion;
	}

	public String getestadocuota_descripcion() {
		return this.estadocuota_descripcion;
	}

	public String getdefiprovisionempleado_descripcion() {
		return this.defiprovisionempleado_descripcion;
	}

	
	
	public  void  setPrestamo(Prestamo prestamo) {
		try {
			this.prestamo=prestamo;
		} catch(Exception e) {
			;
		}
	}


	public  void  setEstadoCuota(EstadoCuota estadocuota) {
		try {
			this.estadocuota=estadocuota;
		} catch(Exception e) {
			;
		}
	}


	public  void  setDefiProvisionEmpleado(DefiProvisionEmpleado defiprovisionempleado) {
		try {
			this.defiprovisionempleado=defiprovisionempleado;
		} catch(Exception e) {
			;
		}
	}


	
	
	public  void  setprestamo_descripcion(String prestamo_descripcion) {
		try {
			this.prestamo_descripcion=prestamo_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  setestadocuota_descripcion(String estadocuota_descripcion) {
		try {
			this.estadocuota_descripcion=estadocuota_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  setdefiprovisionempleado_descripcion(String defiprovisionempleado_descripcion) {
		try {
			this.defiprovisionempleado_descripcion=defiprovisionempleado_descripcion;
		} catch(Exception e) {
			;
		}
	}


	
	
	
	
	
	/*PARA REPORTES*/
	String id_prestamo_descripcion="";String id_estado_cuota_descripcion="";String id_defi_provision_empleado_descripcion="";
	
	
	public String getid_prestamo_descripcion() {
		return id_prestamo_descripcion;
	}
	public String getid_estado_cuota_descripcion() {
		return id_estado_cuota_descripcion;
	}
	public String getid_defi_provision_empleado_descripcion() {
		return id_defi_provision_empleado_descripcion;
	}
	
	
	public void setid_prestamo_descripcion(String newid_prestamo_descripcion)throws Exception {
		try {
			this.id_prestamo_descripcion=newid_prestamo_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_estado_cuota_descripcion(String newid_estado_cuota_descripcion)throws Exception {
		try {
			this.id_estado_cuota_descripcion=newid_estado_cuota_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_defi_provision_empleado_descripcion(String newid_defi_provision_empleado_descripcion)throws Exception {
		try {
			this.id_defi_provision_empleado_descripcion=newid_defi_provision_empleado_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	
	public void inicializarVariablesParaReporte() {
		this.id_prestamo_descripcion="";this.id_estado_cuota_descripcion="";this.id_defi_provision_empleado_descripcion="";
	}
	
	
	
	
	
	
	/*PARA REPORTES FIN*/		
}

