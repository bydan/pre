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
package com.bydan.erp.facturacion.business.entity;

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
//import com.bydan.erp.facturacion.util.AnticipoClienteConstantesFunciones;
import com.bydan.erp.facturacion.util.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.nomina.util.*;



import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.nomina.business.entity.*;




@SuppressWarnings("unused")
public class AnticipoCliente extends AnticipoClienteAdditional implements Serializable ,Cloneable {//AnticipoClienteAdditional,GeneralEntity
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
	
	private AnticipoCliente anticipoclienteOriginal;
	
	private Map<String, Object> mapAnticipoCliente;
			
	public Map<String, Object> getMapAnticipoCliente() {
		return mapAnticipoCliente;
	}

	public void setMapAnticipoCliente(Map<String, Object> mapAnticipoCliente) {
		this.mapAnticipoCliente = mapAnticipoCliente;
	}
	
	public void inicializarMapAnticipoCliente() {
		this.mapAnticipoCliente = new HashMap<String,Object>();
	}
	
	public void setMapAnticipoClienteValue(String sKey,Object oValue) {
		this.mapAnticipoCliente.put(sKey, oValue);
	}
	
	public Object getMapAnticipoClienteValue(String sKey) {
		return this.mapAnticipoCliente.get(sKey);
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
	private Long id_estado_anti_cliente;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_tipo_grupo_forma_pago;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Date fecha;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double valor;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=150,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=AnticipoClienteConstantesFunciones.SREGEXDESCRIPCION,message=AnticipoClienteConstantesFunciones.SMENSAJEREGEXDESCRIPCION)
	private String descripcion;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double valor_adicional;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double valor_prestamo;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double ingreso1;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double ingreso2;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double ingreso3;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double ingreso4;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double ingreso5;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double descuento1;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double descuento2;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double descuento3;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double descuento4;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double descuento5;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double tipo_ingreso;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double tipo_descuento;
			
	
	public Empresa empresa;
	public Empleado empleado;
	public EstadoAntiCliente estadoanticliente;
	public TipoGrupoFormaPago tipogrupoformapago;
	
	
	private String empresa_descripcion;
	private String empleado_descripcion;
	private String estadoanticliente_descripcion;
	private String tipogrupoformapago_descripcion;
	
	
		
	public AnticipoCliente () throws Exception {
		super();		
		
		this.id=0L;
		
		
		this.versionRow=new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());//new Date();
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		this.sType="NONE";
		
		this.anticipoclienteOriginal=this;
		
 		this.id_empresa=-1L;
 		this.id_empleado=-1L;
 		this.id_estado_anti_cliente=-1L;
 		this.id_tipo_grupo_forma_pago=-1L;
 		this.fecha=new Date();
 		this.valor=0.0;
 		this.descripcion="";
 		this.valor_adicional=0.0;
 		this.valor_prestamo=0.0;
 		this.ingreso1=0.0;
 		this.ingreso2=0.0;
 		this.ingreso3=0.0;
 		this.ingreso4=0.0;
 		this.ingreso5=0.0;
 		this.descuento1=0.0;
 		this.descuento2=0.0;
 		this.descuento3=0.0;
 		this.descuento4=0.0;
 		this.descuento5=0.0;
 		this.tipo_ingreso=0.0;
 		this.tipo_descuento=0.0;
		
		
		this.empresa=null;
		this.empleado=null;
		this.estadoanticliente=null;
		this.tipogrupoformapago=null;
		
		
		this.empresa_descripcion="";
		this.empleado_descripcion="";
		this.estadoanticliente_descripcion="";
		this.tipogrupoformapago_descripcion="";
		
		
		
			
		
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
    //PARA REPORTES
	public AnticipoCliente (Long id,Date versionRow,Long id_empresa,Long id_empleado,Long id_estado_anti_cliente,Long id_tipo_grupo_forma_pago,Date fecha,Double valor,String descripcion,Double valor_adicional,Double valor_prestamo,Double ingreso1,Double ingreso2,Double ingreso3,Double ingreso4,Double ingreso5,Double descuento1,Double descuento2,Double descuento3,Double descuento4,Double descuento5,Double tipo_ingreso,Double tipo_descuento) throws Exception {
		super();		
		
		this.id=id;
		this.versionRow=versionRow;
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.anticipoclienteOriginal=this;
		
 		this.id_empresa=id_empresa;
 		this.id_empleado=id_empleado;
 		this.id_estado_anti_cliente=id_estado_anti_cliente;
 		this.id_tipo_grupo_forma_pago=id_tipo_grupo_forma_pago;
 		this.fecha=fecha;
 		this.valor=valor;
 		this.descripcion=descripcion;
 		this.valor_adicional=valor_adicional;
 		this.valor_prestamo=valor_prestamo;
 		this.ingreso1=ingreso1;
 		this.ingreso2=ingreso2;
 		this.ingreso3=ingreso3;
 		this.ingreso4=ingreso4;
 		this.ingreso5=ingreso5;
 		this.descuento1=descuento1;
 		this.descuento2=descuento2;
 		this.descuento3=descuento3;
 		this.descuento4=descuento4;
 		this.descuento5=descuento5;
 		this.tipo_ingreso=tipo_ingreso;
 		this.tipo_descuento=tipo_descuento;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	 //PARA REPORTES
	public AnticipoCliente (Long id_empresa,Long id_empleado,Long id_estado_anti_cliente,Long id_tipo_grupo_forma_pago,Date fecha,Double valor,String descripcion,Double valor_adicional,Double valor_prestamo,Double ingreso1,Double ingreso2,Double ingreso3,Double ingreso4,Double ingreso5,Double descuento1,Double descuento2,Double descuento3,Double descuento4,Double descuento5,Double tipo_ingreso,Double tipo_descuento) throws Exception {
		super();		
		
		this.id=0L;
		this.versionRow=new Date();
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.anticipoclienteOriginal=this;
		
 		this.id_empresa=id_empresa;
 		this.id_empleado=id_empleado;
 		this.id_estado_anti_cliente=id_estado_anti_cliente;
 		this.id_tipo_grupo_forma_pago=id_tipo_grupo_forma_pago;
 		this.fecha=fecha;
 		this.valor=valor;
 		this.descripcion=descripcion;
 		this.valor_adicional=valor_adicional;
 		this.valor_prestamo=valor_prestamo;
 		this.ingreso1=ingreso1;
 		this.ingreso2=ingreso2;
 		this.ingreso3=ingreso3;
 		this.ingreso4=ingreso4;
 		this.ingreso5=ingreso5;
 		this.descuento1=descuento1;
 		this.descuento2=descuento2;
 		this.descuento3=descuento3;
 		this.descuento4=descuento4;
 		this.descuento5=descuento5;
 		this.tipo_ingreso=tipo_ingreso;
 		this.tipo_descuento=tipo_descuento;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	public boolean equals(Object object) {
		boolean equal=false;
		AnticipoCliente anticipoclienteLocal=null;
		
		if(object!=null) {
			anticipoclienteLocal=(AnticipoCliente)object;
			
			if(anticipoclienteLocal!=null) {
				if(this.getId()!=null && anticipoclienteLocal.getId()!=null) {
					if(this.getId().equals(anticipoclienteLocal.getId())) {
						equal=true;
					}
				}
			}
		}
		
		return equal;
	}
	
	public String toString() {
		String sDetalle="";
		
		if(!AnticipoClienteConstantesFunciones.CON_DESCRIPCION_DETALLADO) {
        	sDetalle=AnticipoClienteConstantesFunciones.getAnticipoClienteDescripcion(this);
		} else {
			sDetalle=AnticipoClienteConstantesFunciones.getAnticipoClienteDescripcionDetallado(this);
		}
		
		return sDetalle;
    }
	
	public AnticipoCliente getAnticipoClienteOriginal() {
		return this.anticipoclienteOriginal;
	}
	
	public void setAnticipoClienteOriginal(AnticipoCliente anticipocliente) {
		try {
			this.anticipoclienteOriginal=anticipocliente;
		} catch(Exception e) {
			;
		}
	}
	
	
	protected AnticipoClienteAdditional anticipoclienteAdditional=null;
	
	public AnticipoClienteAdditional getAnticipoClienteAdditional() {
		return this.anticipoclienteAdditional;
	}
	
	public void setAnticipoClienteAdditional(AnticipoClienteAdditional anticipoclienteAdditional) {
		try {
			this.anticipoclienteAdditional=anticipoclienteAdditional;
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
    
	
	public Long getid_estado_anti_cliente() {
		return this.id_estado_anti_cliente;
	}
    
	
	public Long getid_tipo_grupo_forma_pago() {
		return this.id_tipo_grupo_forma_pago;
	}
    
	
	public Date getfecha() {
		return this.fecha;
	}
    
	
	public Double getvalor() {
		return this.valor;
	}
    
	
	public String getdescripcion() {
		return this.descripcion;
	}
    
	
	public Double getvalor_adicional() {
		return this.valor_adicional;
	}
    
	
	public Double getvalor_prestamo() {
		return this.valor_prestamo;
	}
    
	
	public Double getingreso1() {
		return this.ingreso1;
	}
    
	
	public Double getingreso2() {
		return this.ingreso2;
	}
    
	
	public Double getingreso3() {
		return this.ingreso3;
	}
    
	
	public Double getingreso4() {
		return this.ingreso4;
	}
    
	
	public Double getingreso5() {
		return this.ingreso5;
	}
    
	
	public Double getdescuento1() {
		return this.descuento1;
	}
    
	
	public Double getdescuento2() {
		return this.descuento2;
	}
    
	
	public Double getdescuento3() {
		return this.descuento3;
	}
    
	
	public Double getdescuento4() {
		return this.descuento4;
	}
    
	
	public Double getdescuento5() {
		return this.descuento5;
	}
    
	
	public Double gettipo_ingreso() {
		return this.tipo_ingreso;
	}
    
	
	public Double gettipo_descuento() {
		return this.tipo_descuento;
	}
	
    
	public void setid_empresa(Long newid_empresa)throws Exception
	{
		try {
			if(this.id_empresa!=newid_empresa) {
				if(newid_empresa==null) {
					//newid_empresa=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("AnticipoCliente:Valor nulo no permitido en columna id_empresa");
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
						System.out.println("AnticipoCliente:Valor nulo no permitido en columna id_empleado");
					}
				}

				this.id_empleado=newid_empleado;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_estado_anti_cliente(Long newid_estado_anti_cliente)throws Exception
	{
		try {
			if(this.id_estado_anti_cliente!=newid_estado_anti_cliente) {
				if(newid_estado_anti_cliente==null) {
					//newid_estado_anti_cliente=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("AnticipoCliente:Valor nulo no permitido en columna id_estado_anti_cliente");
					}
				}

				this.id_estado_anti_cliente=newid_estado_anti_cliente;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_tipo_grupo_forma_pago(Long newid_tipo_grupo_forma_pago)throws Exception
	{
		try {
			if(this.id_tipo_grupo_forma_pago!=newid_tipo_grupo_forma_pago) {
				if(newid_tipo_grupo_forma_pago==null) {
					//newid_tipo_grupo_forma_pago=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("AnticipoCliente:Valor nulo no permitido en columna id_tipo_grupo_forma_pago");
					}
				}

				this.id_tipo_grupo_forma_pago=newid_tipo_grupo_forma_pago;
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
						System.out.println("AnticipoCliente:Valor nulo no permitido en columna fecha");
					}
				}

				this.fecha=newfecha;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setvalor(Double newvalor)throws Exception
	{
		try {
			if(this.valor!=newvalor) {
				if(newvalor==null) {
					//newvalor=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("AnticipoCliente:Valor nulo no permitido en columna valor");
					}
				}

				this.valor=newvalor;
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
						System.out.println("AnticipoCliente:Valor nulo no permitido en columna descripcion");
					}
				}

				if(newdescripcion!=null&&newdescripcion.length()>150) {
					newdescripcion=newdescripcion.substring(0,148);
					System.out.println("AnticipoCliente:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=150 en columna descripcion");
				}

				this.descripcion=newdescripcion;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setvalor_adicional(Double newvalor_adicional)throws Exception
	{
		try {
			if(this.valor_adicional!=newvalor_adicional) {
				if(newvalor_adicional==null) {
					//newvalor_adicional=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("AnticipoCliente:Valor nulo no permitido en columna valor_adicional");
					}
				}

				this.valor_adicional=newvalor_adicional;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setvalor_prestamo(Double newvalor_prestamo)throws Exception
	{
		try {
			if(this.valor_prestamo!=newvalor_prestamo) {
				if(newvalor_prestamo==null) {
					//newvalor_prestamo=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("AnticipoCliente:Valor nulo no permitido en columna valor_prestamo");
					}
				}

				this.valor_prestamo=newvalor_prestamo;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setingreso1(Double newingreso1)throws Exception
	{
		try {
			if(this.ingreso1!=newingreso1) {
				if(newingreso1==null) {
					//newingreso1=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("AnticipoCliente:Valor nulo no permitido en columna ingreso1");
					}
				}

				this.ingreso1=newingreso1;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setingreso2(Double newingreso2)throws Exception
	{
		try {
			if(this.ingreso2!=newingreso2) {
				if(newingreso2==null) {
					//newingreso2=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("AnticipoCliente:Valor nulo no permitido en columna ingreso2");
					}
				}

				this.ingreso2=newingreso2;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setingreso3(Double newingreso3)throws Exception
	{
		try {
			if(this.ingreso3!=newingreso3) {
				if(newingreso3==null) {
					//newingreso3=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("AnticipoCliente:Valor nulo no permitido en columna ingreso3");
					}
				}

				this.ingreso3=newingreso3;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setingreso4(Double newingreso4)throws Exception
	{
		try {
			if(this.ingreso4!=newingreso4) {
				if(newingreso4==null) {
					//newingreso4=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("AnticipoCliente:Valor nulo no permitido en columna ingreso4");
					}
				}

				this.ingreso4=newingreso4;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setingreso5(Double newingreso5)throws Exception
	{
		try {
			if(this.ingreso5!=newingreso5) {
				if(newingreso5==null) {
					//newingreso5=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("AnticipoCliente:Valor nulo no permitido en columna ingreso5");
					}
				}

				this.ingreso5=newingreso5;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setdescuento1(Double newdescuento1)throws Exception
	{
		try {
			if(this.descuento1!=newdescuento1) {
				if(newdescuento1==null) {
					//newdescuento1=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("AnticipoCliente:Valor nulo no permitido en columna descuento1");
					}
				}

				this.descuento1=newdescuento1;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setdescuento2(Double newdescuento2)throws Exception
	{
		try {
			if(this.descuento2!=newdescuento2) {
				if(newdescuento2==null) {
					//newdescuento2=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("AnticipoCliente:Valor nulo no permitido en columna descuento2");
					}
				}

				this.descuento2=newdescuento2;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setdescuento3(Double newdescuento3)throws Exception
	{
		try {
			if(this.descuento3!=newdescuento3) {
				if(newdescuento3==null) {
					//newdescuento3=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("AnticipoCliente:Valor nulo no permitido en columna descuento3");
					}
				}

				this.descuento3=newdescuento3;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setdescuento4(Double newdescuento4)throws Exception
	{
		try {
			if(this.descuento4!=newdescuento4) {
				if(newdescuento4==null) {
					//newdescuento4=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("AnticipoCliente:Valor nulo no permitido en columna descuento4");
					}
				}

				this.descuento4=newdescuento4;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setdescuento5(Double newdescuento5)throws Exception
	{
		try {
			if(this.descuento5!=newdescuento5) {
				if(newdescuento5==null) {
					//newdescuento5=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("AnticipoCliente:Valor nulo no permitido en columna descuento5");
					}
				}

				this.descuento5=newdescuento5;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void settipo_ingreso(Double newtipo_ingreso)throws Exception
	{
		try {
			if(this.tipo_ingreso!=newtipo_ingreso) {
				if(newtipo_ingreso==null) {
					//newtipo_ingreso=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("AnticipoCliente:Valor nulo no permitido en columna tipo_ingreso");
					}
				}

				this.tipo_ingreso=newtipo_ingreso;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void settipo_descuento(Double newtipo_descuento)throws Exception
	{
		try {
			if(this.tipo_descuento!=newtipo_descuento) {
				if(newtipo_descuento==null) {
					//newtipo_descuento=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("AnticipoCliente:Valor nulo no permitido en columna tipo_descuento");
					}
				}

				this.tipo_descuento=newtipo_descuento;
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

	public EstadoAntiCliente getEstadoAntiCliente() {
		return this.estadoanticliente;
	}

	public TipoGrupoFormaPago getTipoGrupoFormaPago() {
		return this.tipogrupoformapago;
	}

	
	
	public String getempresa_descripcion() {
		return this.empresa_descripcion;
	}

	public String getempleado_descripcion() {
		return this.empleado_descripcion;
	}

	public String getestadoanticliente_descripcion() {
		return this.estadoanticliente_descripcion;
	}

	public String gettipogrupoformapago_descripcion() {
		return this.tipogrupoformapago_descripcion;
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


	public  void  setEstadoAntiCliente(EstadoAntiCliente estadoanticliente) {
		try {
			this.estadoanticliente=estadoanticliente;
		} catch(Exception e) {
			;
		}
	}


	public  void  setTipoGrupoFormaPago(TipoGrupoFormaPago tipogrupoformapago) {
		try {
			this.tipogrupoformapago=tipogrupoformapago;
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


	public  void  setestadoanticliente_descripcion(String estadoanticliente_descripcion) {
		try {
			this.estadoanticliente_descripcion=estadoanticliente_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  settipogrupoformapago_descripcion(String tipogrupoformapago_descripcion) {
		try {
			this.tipogrupoformapago_descripcion=tipogrupoformapago_descripcion;
		} catch(Exception e) {
			;
		}
	}


	
	
	
	
	
	/*PARA REPORTES*/
	String id_empresa_descripcion="";String id_empleado_descripcion="";String id_estado_anti_cliente_descripcion="";String id_tipo_grupo_forma_pago_descripcion="";
	
	
	public String getid_empresa_descripcion() {
		return id_empresa_descripcion;
	}
	public String getid_empleado_descripcion() {
		return id_empleado_descripcion;
	}
	public String getid_estado_anti_cliente_descripcion() {
		return id_estado_anti_cliente_descripcion;
	}
	public String getid_tipo_grupo_forma_pago_descripcion() {
		return id_tipo_grupo_forma_pago_descripcion;
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
	public void setid_estado_anti_cliente_descripcion(String newid_estado_anti_cliente_descripcion)throws Exception {
		try {
			this.id_estado_anti_cliente_descripcion=newid_estado_anti_cliente_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_tipo_grupo_forma_pago_descripcion(String newid_tipo_grupo_forma_pago_descripcion)throws Exception {
		try {
			this.id_tipo_grupo_forma_pago_descripcion=newid_tipo_grupo_forma_pago_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	
	public void inicializarVariablesParaReporte() {
		this.id_empresa_descripcion="";this.id_empleado_descripcion="";this.id_estado_anti_cliente_descripcion="";this.id_tipo_grupo_forma_pago_descripcion="";
	}
	
	
	
	
	
	
	/*PARA REPORTES FIN*/		
}

