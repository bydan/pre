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
package com.bydan.erp.nomina.business.entity.report;

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
//import com.bydan.erp.nomina.util.CreditosPendientesConstantesFunciones;
import com.bydan.erp.nomina.util.*;


import com.bydan.erp.nomina.util.*;
import com.bydan.erp.seguridad.util.*;

import com.bydan.erp.nomina.business.entity.*;


import com.bydan.erp.nomina.business.entity.*;
import com.bydan.erp.seguridad.business.entity.*;




@SuppressWarnings("unused")
public class CreditosPendientes extends CreditosPendientesAdditional implements Serializable ,Cloneable {//CreditosPendientesAdditional,GeneralEntity
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
	
	private CreditosPendientes creditospendientesOriginal;
	
	private Map<String, Object> mapCreditosPendientes;
			
	public Map<String, Object> getMapCreditosPendientes() {
		return mapCreditosPendientes;
	}

	public void setMapCreditosPendientes(Map<String, Object> mapCreditosPendientes) {
		this.mapCreditosPendientes = mapCreditosPendientes;
	}
	
	public void inicializarMapCreditosPendientes() {
		this.mapCreditosPendientes = new HashMap<String,Object>();
	}
	
	public void setMapCreditosPendientesValue(String sKey,Object oValue) {
		this.mapCreditosPendientes.put(sKey, oValue);
	}
	
	public Object getMapCreditosPendientesValue(String sKey) {
		return this.mapCreditosPendientes.get(sKey);
	}
	
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_cargo;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_estructura;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_empresa;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_empleado;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Date fecha_vencimiento_desde;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Date fecha_vencimiento_hasta;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=50,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	//@Pattern(regex=CreditosPendientesConstantesFunciones.SREGEXCODIGO,message=CreditosPendientesConstantesFunciones.SMENSAJEREGEXCODIGO)
	private String codigo;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=200,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	//@Pattern(regex=CreditosPendientesConstantesFunciones.SREGEXNOMBRE_COMPLETO,message=CreditosPendientesConstantesFunciones.SMENSAJEREGEXNOMBRE_COMPLETO)
	private String nombre_completo;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=50,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	//@Pattern(regex=CreditosPendientesConstantesFunciones.SREGEXCODIGO_TIPO_PRESTAMO,message=CreditosPendientesConstantesFunciones.SMENSAJEREGEXCODIGO_TIPO_PRESTAMO)
	private String codigo_tipo_prestamo;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=50,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	//@Pattern(regex=CreditosPendientesConstantesFunciones.SREGEXCODIGO_PRESTAMO,message=CreditosPendientesConstantesFunciones.SMENSAJEREGEXCODIGO_PRESTAMO)
	private String codigo_prestamo;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=10,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONINT)
	private Integer numero;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double monto_capital;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double monto_interes;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double valor;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double saldo;
			
	
	public Cargo cargo;
	public Estructura estructura;
	public Empresa empresa;
	public Empleado empleado;
	
	
	private String cargo_descripcion;
	private String estructura_descripcion;
	private String empresa_descripcion;
	private String empleado_descripcion;
	
	
		
	public CreditosPendientes () throws Exception {
		super();		
		
		this.id=0L;
		
		
		this.versionRow=new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());//new Date();
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		this.sType="NONE";
		
		this.creditospendientesOriginal=this;
		
 		this.id_cargo=-1L;
 		this.id_estructura=-1L;
 		this.id_empresa=-1L;
 		this.id_empleado=-1L;
 		this.fecha_vencimiento_desde=new Date();
 		this.fecha_vencimiento_hasta=new Date();
 		this.codigo="";
 		this.nombre_completo="";
 		this.codigo_tipo_prestamo="";
 		this.codigo_prestamo="";
 		this.numero=0;
 		this.monto_capital=0.0;
 		this.monto_interes=0.0;
 		this.valor=0.0;
 		this.saldo=0.0;
		
		
		this.cargo=null;
		this.estructura=null;
		this.empresa=null;
		this.empleado=null;
		
		
		this.cargo_descripcion="";
		this.estructura_descripcion="";
		this.empresa_descripcion="";
		this.empleado_descripcion="";
		
		
		
			
		
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
    //PARA REPORTES
	public CreditosPendientes (Long id,Date versionRow,String codigo,String nombre_completo,String codigo_tipo_prestamo,String codigo_prestamo,Integer numero,Double monto_capital,Double monto_interes,Double valor,Double saldo) throws Exception {
		super();		
		
		this.id=id;
		this.versionRow=versionRow;
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.creditospendientesOriginal=this;
		
 		this.codigo=codigo;
 		this.nombre_completo=nombre_completo;
 		this.codigo_tipo_prestamo=codigo_tipo_prestamo;
 		this.codigo_prestamo=codigo_prestamo;
 		this.numero=numero;
 		this.monto_capital=monto_capital;
 		this.monto_interes=monto_interes;
 		this.valor=valor;
 		this.saldo=saldo;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	 //PARA REPORTES
	public CreditosPendientes (String codigo,String nombre_completo,String codigo_tipo_prestamo,String codigo_prestamo,Integer numero,Double monto_capital,Double monto_interes,Double valor,Double saldo) throws Exception {
		super();		
		
		this.id=0L;
		this.versionRow=new Date();
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.creditospendientesOriginal=this;
		
 		this.codigo=codigo;
 		this.nombre_completo=nombre_completo;
 		this.codigo_tipo_prestamo=codigo_tipo_prestamo;
 		this.codigo_prestamo=codigo_prestamo;
 		this.numero=numero;
 		this.monto_capital=monto_capital;
 		this.monto_interes=monto_interes;
 		this.valor=valor;
 		this.saldo=saldo;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	
	public CreditosPendientes getCreditosPendientesOriginal() {
		return this.creditospendientesOriginal;
	}
	
	public void setCreditosPendientesOriginal(CreditosPendientes creditospendientes) {
		try {
			this.creditospendientesOriginal=creditospendientes;
		} catch(Exception e) {
			;
		}
	}
	
	
	protected CreditosPendientesAdditional creditospendientesAdditional=null;
	
	public CreditosPendientesAdditional getCreditosPendientesAdditional() {
		return this.creditospendientesAdditional;
	}
	
	public void setCreditosPendientesAdditional(CreditosPendientesAdditional creditospendientesAdditional) {
		try {
			this.creditospendientesAdditional=creditospendientesAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
    
	
	public Long getid_cargo() {
		return this.id_cargo;
	}
    
	
	public Long getid_estructura() {
		return this.id_estructura;
	}
    
	
	public Long getid_empresa() {
		return this.id_empresa;
	}
    
	
	public Long getid_empleado() {
		return this.id_empleado;
	}
    
	
	public Date getfecha_vencimiento_desde() {
		return this.fecha_vencimiento_desde;
	}
    
	
	public Date getfecha_vencimiento_hasta() {
		return this.fecha_vencimiento_hasta;
	}
    
	
	public String getcodigo() {
		return this.codigo;
	}
    
	
	public String getnombre_completo() {
		return this.nombre_completo;
	}
    
	
	public String getcodigo_tipo_prestamo() {
		return this.codigo_tipo_prestamo;
	}
    
	
	public String getcodigo_prestamo() {
		return this.codigo_prestamo;
	}
    
	
	public Integer getnumero() {
		return this.numero;
	}
    
	
	public Double getmonto_capital() {
		return this.monto_capital;
	}
    
	
	public Double getmonto_interes() {
		return this.monto_interes;
	}
    
	
	public Double getvalor() {
		return this.valor;
	}
    
	
	public Double getsaldo() {
		return this.saldo;
	}
	
    
	public void setid_cargo(Long newid_cargo)throws Exception
	{
		try {
			if(this.id_cargo!=newid_cargo) {
				if(newid_cargo==null) {
					//newid_cargo=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("CreditosPendientes:Valor nulo no permitido en columna id_cargo");
					}
				}

				this.id_cargo=newid_cargo;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_estructura(Long newid_estructura)throws Exception
	{
		try {
			if(this.id_estructura!=newid_estructura) {
				if(newid_estructura==null) {
					//newid_estructura=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("CreditosPendientes:Valor nulo no permitido en columna id_estructura");
					}
				}

				this.id_estructura=newid_estructura;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_empresa(Long newid_empresa)throws Exception
	{
		try {
			if(this.id_empresa!=newid_empresa) {
				if(newid_empresa==null) {
					//newid_empresa=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("CreditosPendientes:Valor nulo no permitido en columna id_empresa");
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
						System.out.println("CreditosPendientes:Valor nulo no permitido en columna id_empleado");
					}
				}

				this.id_empleado=newid_empleado;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setfecha_vencimiento_desde(Date newfecha_vencimiento_desde)throws Exception
	{
		try {
			if(this.fecha_vencimiento_desde!=newfecha_vencimiento_desde) {
				if(newfecha_vencimiento_desde==null) {
					//newfecha_vencimiento_desde=new Date();
					if(Constantes.ISDEVELOPING) {
						System.out.println("CreditosPendientes:Valor nulo no permitido en columna fecha_vencimiento_desde");
					}
				}

				this.fecha_vencimiento_desde=newfecha_vencimiento_desde;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setfecha_vencimiento_hasta(Date newfecha_vencimiento_hasta)throws Exception
	{
		try {
			if(this.fecha_vencimiento_hasta!=newfecha_vencimiento_hasta) {
				if(newfecha_vencimiento_hasta==null) {
					//newfecha_vencimiento_hasta=new Date();
					if(Constantes.ISDEVELOPING) {
						System.out.println("CreditosPendientes:Valor nulo no permitido en columna fecha_vencimiento_hasta");
					}
				}

				this.fecha_vencimiento_hasta=newfecha_vencimiento_hasta;
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
						System.out.println("CreditosPendientes:Valor nulo no permitido en columna codigo");
					}
				}

				if(newcodigo!=null&&newcodigo.length()>50) {
					newcodigo=newcodigo.substring(0,48);
					System.out.println("CreditosPendientes:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=50 en columna codigo");
				}

				this.codigo=newcodigo;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setnombre_completo(String newnombre_completo)throws Exception
	{
		try {
			if(this.nombre_completo!=newnombre_completo) {
				if(newnombre_completo==null) {
					//newnombre_completo="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("CreditosPendientes:Valor nulo no permitido en columna nombre_completo");
					}
				}

				if(newnombre_completo!=null&&newnombre_completo.length()>200) {
					newnombre_completo=newnombre_completo.substring(0,198);
					System.out.println("CreditosPendientes:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=200 en columna nombre_completo");
				}

				this.nombre_completo=newnombre_completo;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setcodigo_tipo_prestamo(String newcodigo_tipo_prestamo)throws Exception
	{
		try {
			if(this.codigo_tipo_prestamo!=newcodigo_tipo_prestamo) {
				if(newcodigo_tipo_prestamo==null) {
					//newcodigo_tipo_prestamo="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("CreditosPendientes:Valor nulo no permitido en columna codigo_tipo_prestamo");
					}
				}

				if(newcodigo_tipo_prestamo!=null&&newcodigo_tipo_prestamo.length()>50) {
					newcodigo_tipo_prestamo=newcodigo_tipo_prestamo.substring(0,48);
					System.out.println("CreditosPendientes:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=50 en columna codigo_tipo_prestamo");
				}

				this.codigo_tipo_prestamo=newcodigo_tipo_prestamo;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setcodigo_prestamo(String newcodigo_prestamo)throws Exception
	{
		try {
			if(this.codigo_prestamo!=newcodigo_prestamo) {
				if(newcodigo_prestamo==null) {
					//newcodigo_prestamo="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("CreditosPendientes:Valor nulo no permitido en columna codigo_prestamo");
					}
				}

				if(newcodigo_prestamo!=null&&newcodigo_prestamo.length()>50) {
					newcodigo_prestamo=newcodigo_prestamo.substring(0,48);
					System.out.println("CreditosPendientes:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=50 en columna codigo_prestamo");
				}

				this.codigo_prestamo=newcodigo_prestamo;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setnumero(Integer newnumero)throws Exception
	{
		try {
			if(this.numero!=newnumero) {
				if(newnumero==null) {
					//newnumero=0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("CreditosPendientes:Valor nulo no permitido en columna numero");
					}
				}

				this.numero=newnumero;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setmonto_capital(Double newmonto_capital)throws Exception
	{
		try {
			if(this.monto_capital!=newmonto_capital) {
				if(newmonto_capital==null) {
					//newmonto_capital=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("CreditosPendientes:Valor nulo no permitido en columna monto_capital");
					}
				}

				this.monto_capital=newmonto_capital;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setmonto_interes(Double newmonto_interes)throws Exception
	{
		try {
			if(this.monto_interes!=newmonto_interes) {
				if(newmonto_interes==null) {
					//newmonto_interes=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("CreditosPendientes:Valor nulo no permitido en columna monto_interes");
					}
				}

				this.monto_interes=newmonto_interes;
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
						System.out.println("CreditosPendientes:Valor nulo no permitido en columna valor");
					}
				}

				this.valor=newvalor;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setsaldo(Double newsaldo)throws Exception
	{
		try {
			if(this.saldo!=newsaldo) {
				if(newsaldo==null) {
					//newsaldo=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("CreditosPendientes:Valor nulo no permitido en columna saldo");
					}
				}

				this.saldo=newsaldo;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	
	public Cargo getCargo() {
		return this.cargo;
	}

	public Estructura getEstructura() {
		return this.estructura;
	}

	public Empresa getEmpresa() {
		return this.empresa;
	}

	public Empleado getEmpleado() {
		return this.empleado;
	}

	
	
	public String getcargo_descripcion() {
		return this.cargo_descripcion;
	}

	public String getestructura_descripcion() {
		return this.estructura_descripcion;
	}

	public String getempresa_descripcion() {
		return this.empresa_descripcion;
	}

	public String getempleado_descripcion() {
		return this.empleado_descripcion;
	}

	
	
	public  void  setCargo(Cargo cargo) {
		try {
			this.cargo=cargo;
		} catch(Exception e) {
			;
		}
	}


	public  void  setEstructura(Estructura estructura) {
		try {
			this.estructura=estructura;
		} catch(Exception e) {
			;
		}
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


	
	
	public  void  setcargo_descripcion(String cargo_descripcion) {
		try {
			this.cargo_descripcion=cargo_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  setestructura_descripcion(String estructura_descripcion) {
		try {
			this.estructura_descripcion=estructura_descripcion;
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


	
	
	
	
	
	/*PARA REPORTES*/
	String id_cargo_descripcion="";String id_estructura_descripcion="";String id_empresa_descripcion="";String id_empleado_descripcion="";
	
	
	public String getid_cargo_descripcion() {
		return id_cargo_descripcion;
	}
	public String getid_estructura_descripcion() {
		return id_estructura_descripcion;
	}
	public String getid_empresa_descripcion() {
		return id_empresa_descripcion;
	}
	public String getid_empleado_descripcion() {
		return id_empleado_descripcion;
	}
	
	
	public void setid_cargo_descripcion(String newid_cargo_descripcion)throws Exception {
		try {
			this.id_cargo_descripcion=newid_cargo_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_estructura_descripcion(String newid_estructura_descripcion)throws Exception {
		try {
			this.id_estructura_descripcion=newid_estructura_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
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
	
	public void inicializarVariablesParaReporte() {
		this.id_cargo_descripcion="";this.id_estructura_descripcion="";this.id_empresa_descripcion="";this.id_empleado_descripcion="";
	}
	
	
	
	
	
	
	/*PARA REPORTES FIN*/		
}

