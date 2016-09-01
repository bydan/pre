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
package com.bydan.erp.activosfijos.business.entity;

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
//import com.bydan.erp.activosfijos.util.VehiculoConstantesFunciones;
import com.bydan.erp.activosfijos.util.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.cartera.util.*;
import com.bydan.erp.contabilidad.util.*;
import com.bydan.erp.facturacion.util.*;
import com.bydan.erp.activosfijos.util.*;



import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.facturacion.business.entity.*;
import com.bydan.erp.activosfijos.business.entity.*;




@SuppressWarnings("unused")
public class Vehiculo extends VehiculoAdditional implements Serializable ,Cloneable {//VehiculoAdditional,GeneralEntity
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
	
	private Vehiculo vehiculoOriginal;
	
	private Map<String, Object> mapVehiculo;
			
	public Map<String, Object> getMapVehiculo() {
		return mapVehiculo;
	}

	public void setMapVehiculo(Map<String, Object> mapVehiculo) {
		this.mapVehiculo = mapVehiculo;
	}
	
	public void inicializarMapVehiculo() {
		this.mapVehiculo = new HashMap<String,Object>();
	}
	
	public void setMapVehiculoValue(String sKey,Object oValue) {
		this.mapVehiculo.put(sKey, oValue);
	}
	
	public Object getMapVehiculoValue(String sKey) {
		return this.mapVehiculo.get(sKey);
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
	private Long id_detalle_activo_fijo;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_aseguradora;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=50,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=VehiculoConstantesFunciones.SREGEXNUMERO_POLIZA,message=VehiculoConstantesFunciones.SMENSAJEREGEXNUMERO_POLIZA)
	private String numero_poliza;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Date fecha_emision;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Date fecha_vencimiento;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double valor_asegurado;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double valor_deducible;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=50,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=VehiculoConstantesFunciones.SREGEXNUMERO_MATRICULA,message=VehiculoConstantesFunciones.SMENSAJEREGEXNUMERO_MATRICULA)
	private String numero_matricula;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=50,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=VehiculoConstantesFunciones.SREGEXNUMERO_MOTOR,message=VehiculoConstantesFunciones.SMENSAJEREGEXNUMERO_MOTOR)
	private String numero_motor;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=50,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=VehiculoConstantesFunciones.SREGEXNUMERO_CHASIS,message=VehiculoConstantesFunciones.SMENSAJEREGEXNUMERO_CHASIS)
	private String numero_chasis;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=50,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=VehiculoConstantesFunciones.SREGEXNUMERO_PLACA,message=VehiculoConstantesFunciones.SMENSAJEREGEXNUMERO_PLACA)
	private String numero_placa;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double valor_comercial;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=150,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=VehiculoConstantesFunciones.SREGEXDESCRIPCION,message=VehiculoConstantesFunciones.SMENSAJEREGEXDESCRIPCION)
	private String descripcion;
			
	
	public Empresa empresa;
	public Sucursal sucursal;
	public DetalleActivoFijo detalleactivofijo;
	public Aseguradora aseguradora;
	
	
	private String empresa_descripcion;
	private String sucursal_descripcion;
	private String detalleactivofijo_descripcion;
	private String aseguradora_descripcion;
	
	
	public List<ServicioTransporte> serviciotransportes;
		
	public Vehiculo () throws Exception {
		super();		
		
		this.id=0L;
		
		
		this.versionRow=new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());//new Date();
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		this.sType="NONE";
		
		this.vehiculoOriginal=this;
		
 		this.id_empresa=-1L;
 		this.id_sucursal=-1L;
 		this.id_detalle_activo_fijo=-1L;
 		this.id_aseguradora=-1L;
 		this.numero_poliza="";
 		this.fecha_emision=new Date();
 		this.fecha_vencimiento=new Date();
 		this.valor_asegurado=0.0;
 		this.valor_deducible=0.0;
 		this.numero_matricula="";
 		this.numero_motor="";
 		this.numero_chasis="";
 		this.numero_placa="";
 		this.valor_comercial=0.0;
 		this.descripcion="";
		
		
		this.empresa=null;
		this.sucursal=null;
		this.detalleactivofijo=null;
		this.aseguradora=null;
		
		
		this.empresa_descripcion="";
		this.sucursal_descripcion="";
		this.detalleactivofijo_descripcion="";
		this.aseguradora_descripcion="";
		
		
		this.serviciotransportes=null;
		
			
		
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
    //PARA REPORTES
	public Vehiculo (Long id,Date versionRow,Long id_empresa,Long id_sucursal,Long id_detalle_activo_fijo,Long id_aseguradora,String numero_poliza,Date fecha_emision,Date fecha_vencimiento,Double valor_asegurado,Double valor_deducible,String numero_matricula,String numero_motor,String numero_chasis,String numero_placa,Double valor_comercial,String descripcion) throws Exception {
		super();		
		
		this.id=id;
		this.versionRow=versionRow;
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.vehiculoOriginal=this;
		
 		this.id_empresa=id_empresa;
 		this.id_sucursal=id_sucursal;
 		this.id_detalle_activo_fijo=id_detalle_activo_fijo;
 		this.id_aseguradora=id_aseguradora;
 		this.numero_poliza=numero_poliza;
 		this.fecha_emision=fecha_emision;
 		this.fecha_vencimiento=fecha_vencimiento;
 		this.valor_asegurado=valor_asegurado;
 		this.valor_deducible=valor_deducible;
 		this.numero_matricula=numero_matricula;
 		this.numero_motor=numero_motor;
 		this.numero_chasis=numero_chasis;
 		this.numero_placa=numero_placa;
 		this.valor_comercial=valor_comercial;
 		this.descripcion=descripcion;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	 //PARA REPORTES
	public Vehiculo (Long id_empresa,Long id_sucursal,Long id_detalle_activo_fijo,Long id_aseguradora,String numero_poliza,Date fecha_emision,Date fecha_vencimiento,Double valor_asegurado,Double valor_deducible,String numero_matricula,String numero_motor,String numero_chasis,String numero_placa,Double valor_comercial,String descripcion) throws Exception {
		super();		
		
		this.id=0L;
		this.versionRow=new Date();
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.vehiculoOriginal=this;
		
 		this.id_empresa=id_empresa;
 		this.id_sucursal=id_sucursal;
 		this.id_detalle_activo_fijo=id_detalle_activo_fijo;
 		this.id_aseguradora=id_aseguradora;
 		this.numero_poliza=numero_poliza;
 		this.fecha_emision=fecha_emision;
 		this.fecha_vencimiento=fecha_vencimiento;
 		this.valor_asegurado=valor_asegurado;
 		this.valor_deducible=valor_deducible;
 		this.numero_matricula=numero_matricula;
 		this.numero_motor=numero_motor;
 		this.numero_chasis=numero_chasis;
 		this.numero_placa=numero_placa;
 		this.valor_comercial=valor_comercial;
 		this.descripcion=descripcion;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	public boolean equals(Object object) {
		boolean equal=false;
		Vehiculo vehiculoLocal=null;
		
		if(object!=null) {
			vehiculoLocal=(Vehiculo)object;
			
			if(vehiculoLocal!=null) {
				if(this.getId()!=null && vehiculoLocal.getId()!=null) {
					if(this.getId().equals(vehiculoLocal.getId())) {
						equal=true;
					}
				}
			}
		}
		
		return equal;
	}
	
	public String toString() {
		String sDetalle="";
		
		if(!VehiculoConstantesFunciones.CON_DESCRIPCION_DETALLADO) {
        	sDetalle=VehiculoConstantesFunciones.getVehiculoDescripcion(this);
		} else {
			sDetalle=VehiculoConstantesFunciones.getVehiculoDescripcionDetallado(this);
		}
		
		return sDetalle;
    }
	
	public Vehiculo getVehiculoOriginal() {
		return this.vehiculoOriginal;
	}
	
	public void setVehiculoOriginal(Vehiculo vehiculo) {
		try {
			this.vehiculoOriginal=vehiculo;
		} catch(Exception e) {
			;
		}
	}
	
	
	protected VehiculoAdditional vehiculoAdditional=null;
	
	public VehiculoAdditional getVehiculoAdditional() {
		return this.vehiculoAdditional;
	}
	
	public void setVehiculoAdditional(VehiculoAdditional vehiculoAdditional) {
		try {
			this.vehiculoAdditional=vehiculoAdditional;
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
    
	
	public Long getid_detalle_activo_fijo() {
		return this.id_detalle_activo_fijo;
	}
    
	
	public Long getid_aseguradora() {
		return this.id_aseguradora;
	}
    
	
	public String getnumero_poliza() {
		return this.numero_poliza;
	}
    
	
	public Date getfecha_emision() {
		return this.fecha_emision;
	}
    
	
	public Date getfecha_vencimiento() {
		return this.fecha_vencimiento;
	}
    
	
	public Double getvalor_asegurado() {
		return this.valor_asegurado;
	}
    
	
	public Double getvalor_deducible() {
		return this.valor_deducible;
	}
    
	
	public String getnumero_matricula() {
		return this.numero_matricula;
	}
    
	
	public String getnumero_motor() {
		return this.numero_motor;
	}
    
	
	public String getnumero_chasis() {
		return this.numero_chasis;
	}
    
	
	public String getnumero_placa() {
		return this.numero_placa;
	}
    
	
	public Double getvalor_comercial() {
		return this.valor_comercial;
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
						System.out.println("Vehiculo:Valor nulo no permitido en columna id_empresa");
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
						System.out.println("Vehiculo:Valor nulo no permitido en columna id_sucursal");
					}
				}

				this.id_sucursal=newid_sucursal;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_detalle_activo_fijo(Long newid_detalle_activo_fijo)throws Exception
	{
		try {
			if(this.id_detalle_activo_fijo!=newid_detalle_activo_fijo) {
				if(newid_detalle_activo_fijo==null) {
					//newid_detalle_activo_fijo=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("Vehiculo:Valor nulo no permitido en columna id_detalle_activo_fijo");
					}
				}

				this.id_detalle_activo_fijo=newid_detalle_activo_fijo;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_aseguradora(Long newid_aseguradora)throws Exception
	{
		try {
			if(this.id_aseguradora!=newid_aseguradora) {
				if(newid_aseguradora==null) {
					//newid_aseguradora=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("Vehiculo:Valor nulo no permitido en columna id_aseguradora");
					}
				}

				this.id_aseguradora=newid_aseguradora;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setnumero_poliza(String newnumero_poliza)throws Exception
	{
		try {
			if(this.numero_poliza!=newnumero_poliza) {
				if(newnumero_poliza==null) {
					//newnumero_poliza="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("Vehiculo:Valor nulo no permitido en columna numero_poliza");
					}
				}

				if(newnumero_poliza!=null&&newnumero_poliza.length()>50) {
					newnumero_poliza=newnumero_poliza.substring(0,48);
					System.out.println("Vehiculo:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=50 en columna numero_poliza");
				}

				this.numero_poliza=newnumero_poliza;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setfecha_emision(Date newfecha_emision)throws Exception
	{
		try {
			if(this.fecha_emision!=newfecha_emision) {
				if(newfecha_emision==null) {
					//newfecha_emision=new Date();
					if(Constantes.ISDEVELOPING) {
						System.out.println("Vehiculo:Valor nulo no permitido en columna fecha_emision");
					}
				}

				this.fecha_emision=newfecha_emision;
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
						System.out.println("Vehiculo:Valor nulo no permitido en columna fecha_vencimiento");
					}
				}

				this.fecha_vencimiento=newfecha_vencimiento;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setvalor_asegurado(Double newvalor_asegurado)throws Exception
	{
		try {
			if(this.valor_asegurado!=newvalor_asegurado) {
				if(newvalor_asegurado==null) {
					//newvalor_asegurado=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("Vehiculo:Valor nulo no permitido en columna valor_asegurado");
					}
				}

				this.valor_asegurado=newvalor_asegurado;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setvalor_deducible(Double newvalor_deducible)throws Exception
	{
		try {
			if(this.valor_deducible!=newvalor_deducible) {
				if(newvalor_deducible==null) {
					//newvalor_deducible=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("Vehiculo:Valor nulo no permitido en columna valor_deducible");
					}
				}

				this.valor_deducible=newvalor_deducible;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setnumero_matricula(String newnumero_matricula)throws Exception
	{
		try {
			if(this.numero_matricula!=newnumero_matricula) {
				if(newnumero_matricula==null) {
					//newnumero_matricula="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("Vehiculo:Valor nulo no permitido en columna numero_matricula");
					}
				}

				if(newnumero_matricula!=null&&newnumero_matricula.length()>50) {
					newnumero_matricula=newnumero_matricula.substring(0,48);
					System.out.println("Vehiculo:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=50 en columna numero_matricula");
				}

				this.numero_matricula=newnumero_matricula;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setnumero_motor(String newnumero_motor)throws Exception
	{
		try {
			if(this.numero_motor!=newnumero_motor) {
				if(newnumero_motor==null) {
					//newnumero_motor="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("Vehiculo:Valor nulo no permitido en columna numero_motor");
					}
				}

				if(newnumero_motor!=null&&newnumero_motor.length()>50) {
					newnumero_motor=newnumero_motor.substring(0,48);
					System.out.println("Vehiculo:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=50 en columna numero_motor");
				}

				this.numero_motor=newnumero_motor;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setnumero_chasis(String newnumero_chasis)throws Exception
	{
		try {
			if(this.numero_chasis!=newnumero_chasis) {
				if(newnumero_chasis==null) {
					//newnumero_chasis="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("Vehiculo:Valor nulo no permitido en columna numero_chasis");
					}
				}

				if(newnumero_chasis!=null&&newnumero_chasis.length()>50) {
					newnumero_chasis=newnumero_chasis.substring(0,48);
					System.out.println("Vehiculo:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=50 en columna numero_chasis");
				}

				this.numero_chasis=newnumero_chasis;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setnumero_placa(String newnumero_placa)throws Exception
	{
		try {
			if(this.numero_placa!=newnumero_placa) {
				if(newnumero_placa==null) {
					//newnumero_placa="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("Vehiculo:Valor nulo no permitido en columna numero_placa");
					}
				}

				if(newnumero_placa!=null&&newnumero_placa.length()>50) {
					newnumero_placa=newnumero_placa.substring(0,48);
					System.out.println("Vehiculo:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=50 en columna numero_placa");
				}

				this.numero_placa=newnumero_placa;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setvalor_comercial(Double newvalor_comercial)throws Exception
	{
		try {
			if(this.valor_comercial!=newvalor_comercial) {
				if(newvalor_comercial==null) {
					//newvalor_comercial=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("Vehiculo:Valor nulo no permitido en columna valor_comercial");
					}
				}

				this.valor_comercial=newvalor_comercial;
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
						System.out.println("Vehiculo:Valor nulo no permitido en columna descripcion");
					}
				}

				if(newdescripcion!=null&&newdescripcion.length()>150) {
					newdescripcion=newdescripcion.substring(0,148);
					System.out.println("Vehiculo:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=150 en columna descripcion");
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

	public DetalleActivoFijo getDetalleActivoFijo() {
		return this.detalleactivofijo;
	}

	public Aseguradora getAseguradora() {
		return this.aseguradora;
	}

	
	
	public String getempresa_descripcion() {
		return this.empresa_descripcion;
	}

	public String getsucursal_descripcion() {
		return this.sucursal_descripcion;
	}

	public String getdetalleactivofijo_descripcion() {
		return this.detalleactivofijo_descripcion;
	}

	public String getaseguradora_descripcion() {
		return this.aseguradora_descripcion;
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


	public  void  setDetalleActivoFijo(DetalleActivoFijo detalleactivofijo) {
		try {
			this.detalleactivofijo=detalleactivofijo;
		} catch(Exception e) {
			;
		}
	}


	public  void  setAseguradora(Aseguradora aseguradora) {
		try {
			this.aseguradora=aseguradora;
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


	public  void  setdetalleactivofijo_descripcion(String detalleactivofijo_descripcion) {
		try {
			this.detalleactivofijo_descripcion=detalleactivofijo_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  setaseguradora_descripcion(String aseguradora_descripcion) {
		try {
			this.aseguradora_descripcion=aseguradora_descripcion;
		} catch(Exception e) {
			;
		}
	}


	
	
	public List<ServicioTransporte> getServicioTransportes() {
		return this.serviciotransportes;
	}

	
	
	public  void  setServicioTransportes(List<ServicioTransporte> serviciotransportes) {
		try {
			this.serviciotransportes=serviciotransportes;
		} catch(Exception e) {
			;
		}
	}

	
	/*PARA REPORTES*/
	String id_empresa_descripcion="";String id_sucursal_descripcion="";String id_detalle_activo_fijo_descripcion="";String id_aseguradora_descripcion="";
	
	
	public String getid_empresa_descripcion() {
		return id_empresa_descripcion;
	}
	public String getid_sucursal_descripcion() {
		return id_sucursal_descripcion;
	}
	public String getid_detalle_activo_fijo_descripcion() {
		return id_detalle_activo_fijo_descripcion;
	}
	public String getid_aseguradora_descripcion() {
		return id_aseguradora_descripcion;
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
	public void setid_detalle_activo_fijo_descripcion(String newid_detalle_activo_fijo_descripcion)throws Exception {
		try {
			this.id_detalle_activo_fijo_descripcion=newid_detalle_activo_fijo_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_aseguradora_descripcion(String newid_aseguradora_descripcion)throws Exception {
		try {
			this.id_aseguradora_descripcion=newid_aseguradora_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	
	public void inicializarVariablesParaReporte() {
		this.id_empresa_descripcion="";this.id_sucursal_descripcion="";this.id_detalle_activo_fijo_descripcion="";this.id_aseguradora_descripcion="";
	}
	
	
	Object serviciotransportesDescripcionReporte;
	
	
	public Object getserviciotransportesDescripcionReporte() {
		return serviciotransportesDescripcionReporte;
	}

	
	
	public  void  setserviciotransportesDescripcionReporte(Object serviciotransportes) {
		try {
			this.serviciotransportesDescripcionReporte=serviciotransportes;
		} catch(Exception ex) {
			;
		}
	}

	/*PARA REPORTES FIN*/		
}

