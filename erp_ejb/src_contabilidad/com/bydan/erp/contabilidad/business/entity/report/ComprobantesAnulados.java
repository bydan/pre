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
//import com.bydan.erp.contabilidad.util.ComprobantesAnuladosConstantesFunciones;
import com.bydan.erp.contabilidad.util.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.contabilidad.util.*;

import com.bydan.erp.contabilidad.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;




@SuppressWarnings("unused")
public class ComprobantesAnulados extends ComprobantesAnuladosAdditional implements Serializable ,Cloneable {//ComprobantesAnuladosAdditional,GeneralEntity
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
	
	private ComprobantesAnulados comprobantesanuladosOriginal;
	
	private Map<String, Object> mapComprobantesAnulados;
			
	public Map<String, Object> getMapComprobantesAnulados() {
		return mapComprobantesAnulados;
	}

	public void setMapComprobantesAnulados(Map<String, Object> mapComprobantesAnulados) {
		this.mapComprobantesAnulados = mapComprobantesAnulados;
	}
	
	public void inicializarMapComprobantesAnulados() {
		this.mapComprobantesAnulados = new HashMap<String,Object>();
	}
	
	public void setMapComprobantesAnuladosValue(String sKey,Object oValue) {
		this.mapComprobantesAnulados.put(sKey, oValue);
	}
	
	public Object getMapComprobantesAnuladosValue(String sKey) {
		return this.mapComprobantesAnulados.get(sKey);
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
	private Long id_tipo_documento;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_tipo_movimiento;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=100,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	//@Pattern(regex=ComprobantesAnuladosConstantesFunciones.SREGEXNUMERO_MAYOR,message=ComprobantesAnuladosConstantesFunciones.SMENSAJEREGEXNUMERO_MAYOR)
	private String numero_mayor;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Date fecha_emision_desde;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Date fecha_emision_hasta;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=50,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	//@Pattern(regex=ComprobantesAnuladosConstantesFunciones.SREGEXUSER_NAME_USUARIO,message=ComprobantesAnuladosConstantesFunciones.SMENSAJEREGEXUSER_NAME_USUARIO)
	private String user_name_usuario;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=150,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	//@Pattern(regex=ComprobantesAnuladosConstantesFunciones.SREGEXNOMBRE_MODULO,message=ComprobantesAnuladosConstantesFunciones.SMENSAJEREGEXNOMBRE_MODULO)
	private String nombre_modulo;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=50,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	//@Pattern(regex=ComprobantesAnuladosConstantesFunciones.SREGEXCODIGO,message=ComprobantesAnuladosConstantesFunciones.SMENSAJEREGEXCODIGO)
	private String codigo;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=200,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	//@Pattern(regex=ComprobantesAnuladosConstantesFunciones.SREGEXBENEFICIARIO,message=ComprobantesAnuladosConstantesFunciones.SMENSAJEREGEXBENEFICIARIO)
	private String beneficiario;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=250,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	//@Pattern(regex=ComprobantesAnuladosConstantesFunciones.SREGEXDETALLE,message=ComprobantesAnuladosConstantesFunciones.SMENSAJEREGEXDETALLE)
	private String detalle;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Date fecha_emision;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=50,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	//@Pattern(regex=ComprobantesAnuladosConstantesFunciones.SREGEXCODIGO_TIPO_MOVIMIENTO,message=ComprobantesAnuladosConstantesFunciones.SMENSAJEREGEXCODIGO_TIPO_MOVIMIENTO)
	private String codigo_tipo_movimiento;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=100,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	//@Pattern(regex=ComprobantesAnuladosConstantesFunciones.SREGEXNUMERO_MAYOR_DATO,message=ComprobantesAnuladosConstantesFunciones.SMENSAJEREGEXNUMERO_MAYOR_DATO)
	private String numero_mayor_dato;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=150,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	//@Pattern(regex=ComprobantesAnuladosConstantesFunciones.SREGEXNOMBRE_CUENTA_CONTABLE,message=ComprobantesAnuladosConstantesFunciones.SMENSAJEREGEXNOMBRE_CUENTA_CONTABLE)
	private String nombre_cuenta_contable;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double debito_local;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double credito_local;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=50,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	//@Pattern(regex=ComprobantesAnuladosConstantesFunciones.SREGEXCODIGO_CUENTA_CONTABLE,message=ComprobantesAnuladosConstantesFunciones.SMENSAJEREGEXCODIGO_CUENTA_CONTABLE)
	private String codigo_cuenta_contable;
			
	
	public Empresa empresa;
	public Sucursal sucursal;
	public Ejercicio ejercicio;
	public TipoDocumento tipodocumento;
	public TipoMovimiento tipomovimiento;
	
	
	private String empresa_descripcion;
	private String sucursal_descripcion;
	private String ejercicio_descripcion;
	private String tipodocumento_descripcion;
	private String tipomovimiento_descripcion;
	
	
		
	public ComprobantesAnulados () throws Exception {
		super();		
		
		this.id=0L;
		
		
		this.versionRow=new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());//new Date();
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		this.sType="NONE";
		
		this.comprobantesanuladosOriginal=this;
		
 		this.id_empresa=-1L;
 		this.id_sucursal=-1L;
 		this.id_ejercicio=-1L;
 		this.id_tipo_documento=-1L;
 		this.id_tipo_movimiento=-1L;
 		this.numero_mayor="";
 		this.fecha_emision_desde=new Date();
 		this.fecha_emision_hasta=new Date();
 		this.user_name_usuario="";
 		this.nombre_modulo="";
 		this.codigo="";
 		this.beneficiario="";
 		this.detalle="";
 		this.fecha_emision=new Date();
 		this.codigo_tipo_movimiento="";
 		this.numero_mayor_dato="";
 		this.nombre_cuenta_contable="";
 		this.debito_local=0.0;
 		this.credito_local=0.0;
 		this.codigo_cuenta_contable="";
		
		
		this.empresa=null;
		this.sucursal=null;
		this.ejercicio=null;
		this.tipodocumento=null;
		this.tipomovimiento=null;
		
		
		this.empresa_descripcion="";
		this.sucursal_descripcion="";
		this.ejercicio_descripcion="";
		this.tipodocumento_descripcion="";
		this.tipomovimiento_descripcion="";
		
		
		
			
		
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
    //PARA REPORTES
	public ComprobantesAnulados (Long id,Date versionRow,String user_name_usuario,String nombre_modulo,String codigo,String beneficiario,String detalle,Date fecha_emision,String codigo_tipo_movimiento,String numero_mayor_dato,String nombre_cuenta_contable,Double debito_local,Double credito_local,String codigo_cuenta_contable) throws Exception {
		super();		
		
		this.id=id;
		this.versionRow=versionRow;
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.comprobantesanuladosOriginal=this;
		
 		this.user_name_usuario=user_name_usuario;
 		this.nombre_modulo=nombre_modulo;
 		this.codigo=codigo;
 		this.beneficiario=beneficiario;
 		this.detalle=detalle;
 		this.fecha_emision=fecha_emision;
 		this.codigo_tipo_movimiento=codigo_tipo_movimiento;
 		this.numero_mayor_dato=numero_mayor_dato;
 		this.nombre_cuenta_contable=nombre_cuenta_contable;
 		this.debito_local=debito_local;
 		this.credito_local=credito_local;
 		this.codigo_cuenta_contable=codigo_cuenta_contable;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	 //PARA REPORTES
	public ComprobantesAnulados (String user_name_usuario,String nombre_modulo,String codigo,String beneficiario,String detalle,Date fecha_emision,String codigo_tipo_movimiento,String numero_mayor_dato,String nombre_cuenta_contable,Double debito_local,Double credito_local,String codigo_cuenta_contable) throws Exception {
		super();		
		
		this.id=0L;
		this.versionRow=new Date();
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.comprobantesanuladosOriginal=this;
		
 		this.user_name_usuario=user_name_usuario;
 		this.nombre_modulo=nombre_modulo;
 		this.codigo=codigo;
 		this.beneficiario=beneficiario;
 		this.detalle=detalle;
 		this.fecha_emision=fecha_emision;
 		this.codigo_tipo_movimiento=codigo_tipo_movimiento;
 		this.numero_mayor_dato=numero_mayor_dato;
 		this.nombre_cuenta_contable=nombre_cuenta_contable;
 		this.debito_local=debito_local;
 		this.credito_local=credito_local;
 		this.codigo_cuenta_contable=codigo_cuenta_contable;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	
	public ComprobantesAnulados getComprobantesAnuladosOriginal() {
		return this.comprobantesanuladosOriginal;
	}
	
	public void setComprobantesAnuladosOriginal(ComprobantesAnulados comprobantesanulados) {
		try {
			this.comprobantesanuladosOriginal=comprobantesanulados;
		} catch(Exception e) {
			;
		}
	}
	
	
	protected ComprobantesAnuladosAdditional comprobantesanuladosAdditional=null;
	
	public ComprobantesAnuladosAdditional getComprobantesAnuladosAdditional() {
		return this.comprobantesanuladosAdditional;
	}
	
	public void setComprobantesAnuladosAdditional(ComprobantesAnuladosAdditional comprobantesanuladosAdditional) {
		try {
			this.comprobantesanuladosAdditional=comprobantesanuladosAdditional;
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
    
	
	public Long getid_tipo_documento() {
		return this.id_tipo_documento;
	}
    
	
	public Long getid_tipo_movimiento() {
		return this.id_tipo_movimiento;
	}
    
	
	public String getnumero_mayor() {
		return this.numero_mayor;
	}
    
	
	public Date getfecha_emision_desde() {
		return this.fecha_emision_desde;
	}
    
	
	public Date getfecha_emision_hasta() {
		return this.fecha_emision_hasta;
	}
    
	
	public String getuser_name_usuario() {
		return this.user_name_usuario;
	}
    
	
	public String getnombre_modulo() {
		return this.nombre_modulo;
	}
    
	
	public String getcodigo() {
		return this.codigo;
	}
    
	
	public String getbeneficiario() {
		return this.beneficiario;
	}
    
	
	public String getdetalle() {
		return this.detalle;
	}
    
	
	public Date getfecha_emision() {
		return this.fecha_emision;
	}
    
	
	public String getcodigo_tipo_movimiento() {
		return this.codigo_tipo_movimiento;
	}
    
	
	public String getnumero_mayor_dato() {
		return this.numero_mayor_dato;
	}
    
	
	public String getnombre_cuenta_contable() {
		return this.nombre_cuenta_contable;
	}
    
	
	public Double getdebito_local() {
		return this.debito_local;
	}
    
	
	public Double getcredito_local() {
		return this.credito_local;
	}
    
	
	public String getcodigo_cuenta_contable() {
		return this.codigo_cuenta_contable;
	}
	
    
	public void setid_empresa(Long newid_empresa)throws Exception
	{
		try {
			if(this.id_empresa!=newid_empresa) {
				if(newid_empresa==null) {
					//newid_empresa=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ComprobantesAnulados:Valor nulo no permitido en columna id_empresa");
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
						System.out.println("ComprobantesAnulados:Valor nulo no permitido en columna id_sucursal");
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
						System.out.println("ComprobantesAnulados:Valor nulo no permitido en columna id_ejercicio");
					}
				}

				this.id_ejercicio=newid_ejercicio;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_tipo_documento(Long newid_tipo_documento)throws Exception
	{
		try {
			if(this.id_tipo_documento!=newid_tipo_documento) {
				if(newid_tipo_documento==null) {
					//newid_tipo_documento=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ComprobantesAnulados:Valor nulo no permitido en columna id_tipo_documento");
					}
				}

				this.id_tipo_documento=newid_tipo_documento;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_tipo_movimiento(Long newid_tipo_movimiento)throws Exception
	{
		try {
			if(this.id_tipo_movimiento!=newid_tipo_movimiento) {
				if(newid_tipo_movimiento==null) {
					//newid_tipo_movimiento=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ComprobantesAnulados:Valor nulo no permitido en columna id_tipo_movimiento");
					}
				}

				this.id_tipo_movimiento=newid_tipo_movimiento;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setnumero_mayor(String newnumero_mayor)throws Exception
	{
		try {
			if(this.numero_mayor!=newnumero_mayor) {
				if(newnumero_mayor==null) {
					//newnumero_mayor="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("ComprobantesAnulados:Valor nulo no permitido en columna numero_mayor");
					}
				}

				if(newnumero_mayor!=null&&newnumero_mayor.length()>100) {
					newnumero_mayor=newnumero_mayor.substring(0,98);
					System.out.println("ComprobantesAnulados:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=100 en columna numero_mayor");
				}

				this.numero_mayor=newnumero_mayor;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setfecha_emision_desde(Date newfecha_emision_desde)throws Exception
	{
		try {
			if(this.fecha_emision_desde!=newfecha_emision_desde) {
				if(newfecha_emision_desde==null) {
					//newfecha_emision_desde=new Date();
					if(Constantes.ISDEVELOPING) {
						System.out.println("ComprobantesAnulados:Valor nulo no permitido en columna fecha_emision_desde");
					}
				}

				this.fecha_emision_desde=newfecha_emision_desde;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setfecha_emision_hasta(Date newfecha_emision_hasta)throws Exception
	{
		try {
			if(this.fecha_emision_hasta!=newfecha_emision_hasta) {
				if(newfecha_emision_hasta==null) {
					//newfecha_emision_hasta=new Date();
					if(Constantes.ISDEVELOPING) {
						System.out.println("ComprobantesAnulados:Valor nulo no permitido en columna fecha_emision_hasta");
					}
				}

				this.fecha_emision_hasta=newfecha_emision_hasta;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setuser_name_usuario(String newuser_name_usuario)throws Exception
	{
		try {
			if(this.user_name_usuario!=newuser_name_usuario) {
				if(newuser_name_usuario==null) {
					//newuser_name_usuario="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("ComprobantesAnulados:Valor nulo no permitido en columna user_name_usuario");
					}
				}

				if(newuser_name_usuario!=null&&newuser_name_usuario.length()>50) {
					newuser_name_usuario=newuser_name_usuario.substring(0,48);
					System.out.println("ComprobantesAnulados:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=50 en columna user_name_usuario");
				}

				this.user_name_usuario=newuser_name_usuario;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setnombre_modulo(String newnombre_modulo)throws Exception
	{
		try {
			if(this.nombre_modulo!=newnombre_modulo) {
				if(newnombre_modulo==null) {
					//newnombre_modulo="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("ComprobantesAnulados:Valor nulo no permitido en columna nombre_modulo");
					}
				}

				if(newnombre_modulo!=null&&newnombre_modulo.length()>150) {
					newnombre_modulo=newnombre_modulo.substring(0,148);
					System.out.println("ComprobantesAnulados:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=150 en columna nombre_modulo");
				}

				this.nombre_modulo=newnombre_modulo;
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
						System.out.println("ComprobantesAnulados:Valor nulo no permitido en columna codigo");
					}
				}

				if(newcodigo!=null&&newcodigo.length()>50) {
					newcodigo=newcodigo.substring(0,48);
					System.out.println("ComprobantesAnulados:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=50 en columna codigo");
				}

				this.codigo=newcodigo;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setbeneficiario(String newbeneficiario)throws Exception
	{
		try {
			if(this.beneficiario!=newbeneficiario) {
				if(newbeneficiario==null) {
					//newbeneficiario="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("ComprobantesAnulados:Valor nulo no permitido en columna beneficiario");
					}
				}

				if(newbeneficiario!=null&&newbeneficiario.length()>200) {
					newbeneficiario=newbeneficiario.substring(0,198);
					System.out.println("ComprobantesAnulados:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=200 en columna beneficiario");
				}

				this.beneficiario=newbeneficiario;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setdetalle(String newdetalle)throws Exception
	{
		try {
			if(this.detalle!=newdetalle) {
				if(newdetalle==null) {
					//newdetalle="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("ComprobantesAnulados:Valor nulo no permitido en columna detalle");
					}
				}

				if(newdetalle!=null&&newdetalle.length()>250) {
					newdetalle=newdetalle.substring(0,248);
					System.out.println("ComprobantesAnulados:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=250 en columna detalle");
				}

				this.detalle=newdetalle;
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
						System.out.println("ComprobantesAnulados:Valor nulo no permitido en columna fecha_emision");
					}
				}

				this.fecha_emision=newfecha_emision;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setcodigo_tipo_movimiento(String newcodigo_tipo_movimiento)throws Exception
	{
		try {
			if(this.codigo_tipo_movimiento!=newcodigo_tipo_movimiento) {
				if(newcodigo_tipo_movimiento==null) {
					//newcodigo_tipo_movimiento="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("ComprobantesAnulados:Valor nulo no permitido en columna codigo_tipo_movimiento");
					}
				}

				if(newcodigo_tipo_movimiento!=null&&newcodigo_tipo_movimiento.length()>50) {
					newcodigo_tipo_movimiento=newcodigo_tipo_movimiento.substring(0,48);
					System.out.println("ComprobantesAnulados:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=50 en columna codigo_tipo_movimiento");
				}

				this.codigo_tipo_movimiento=newcodigo_tipo_movimiento;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setnumero_mayor_dato(String newnumero_mayor_dato)throws Exception
	{
		try {
			if(this.numero_mayor_dato!=newnumero_mayor_dato) {
				if(newnumero_mayor_dato==null) {
					//newnumero_mayor_dato="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("ComprobantesAnulados:Valor nulo no permitido en columna numero_mayor_dato");
					}
				}

				if(newnumero_mayor_dato!=null&&newnumero_mayor_dato.length()>100) {
					newnumero_mayor_dato=newnumero_mayor_dato.substring(0,98);
					System.out.println("ComprobantesAnulados:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=100 en columna numero_mayor_dato");
				}

				this.numero_mayor_dato=newnumero_mayor_dato;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setnombre_cuenta_contable(String newnombre_cuenta_contable)throws Exception
	{
		try {
			if(this.nombre_cuenta_contable!=newnombre_cuenta_contable) {
				if(newnombre_cuenta_contable==null) {
					//newnombre_cuenta_contable="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("ComprobantesAnulados:Valor nulo no permitido en columna nombre_cuenta_contable");
					}
				}

				if(newnombre_cuenta_contable!=null&&newnombre_cuenta_contable.length()>150) {
					newnombre_cuenta_contable=newnombre_cuenta_contable.substring(0,148);
					System.out.println("ComprobantesAnulados:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=150 en columna nombre_cuenta_contable");
				}

				this.nombre_cuenta_contable=newnombre_cuenta_contable;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setdebito_local(Double newdebito_local)throws Exception
	{
		try {
			if(this.debito_local!=newdebito_local) {
				if(newdebito_local==null) {
					//newdebito_local=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ComprobantesAnulados:Valor nulo no permitido en columna debito_local");
					}
				}

				this.debito_local=newdebito_local;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setcredito_local(Double newcredito_local)throws Exception
	{
		try {
			if(this.credito_local!=newcredito_local) {
				if(newcredito_local==null) {
					//newcredito_local=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ComprobantesAnulados:Valor nulo no permitido en columna credito_local");
					}
				}

				this.credito_local=newcredito_local;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setcodigo_cuenta_contable(String newcodigo_cuenta_contable)throws Exception
	{
		try {
			if(this.codigo_cuenta_contable!=newcodigo_cuenta_contable) {
				if(newcodigo_cuenta_contable==null) {
					//newcodigo_cuenta_contable="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("ComprobantesAnulados:Valor nulo no permitido en columna codigo_cuenta_contable");
					}
				}

				if(newcodigo_cuenta_contable!=null&&newcodigo_cuenta_contable.length()>50) {
					newcodigo_cuenta_contable=newcodigo_cuenta_contable.substring(0,48);
					System.out.println("ComprobantesAnulados:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=50 en columna codigo_cuenta_contable");
				}

				this.codigo_cuenta_contable=newcodigo_cuenta_contable;
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

	public TipoDocumento getTipoDocumento() {
		return this.tipodocumento;
	}

	public TipoMovimiento getTipoMovimiento() {
		return this.tipomovimiento;
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

	public String gettipodocumento_descripcion() {
		return this.tipodocumento_descripcion;
	}

	public String gettipomovimiento_descripcion() {
		return this.tipomovimiento_descripcion;
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


	public  void  setTipoDocumento(TipoDocumento tipodocumento) {
		try {
			this.tipodocumento=tipodocumento;
		} catch(Exception e) {
			;
		}
	}


	public  void  setTipoMovimiento(TipoMovimiento tipomovimiento) {
		try {
			this.tipomovimiento=tipomovimiento;
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


	public  void  settipodocumento_descripcion(String tipodocumento_descripcion) {
		try {
			this.tipodocumento_descripcion=tipodocumento_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  settipomovimiento_descripcion(String tipomovimiento_descripcion) {
		try {
			this.tipomovimiento_descripcion=tipomovimiento_descripcion;
		} catch(Exception e) {
			;
		}
	}


	
	
	
	
	
	/*PARA REPORTES*/
	String id_empresa_descripcion="";String id_sucursal_descripcion="";String id_ejercicio_descripcion="";String id_tipo_documento_descripcion="";String id_tipo_movimiento_descripcion="";
	
	
	public String getid_empresa_descripcion() {
		return id_empresa_descripcion;
	}
	public String getid_sucursal_descripcion() {
		return id_sucursal_descripcion;
	}
	public String getid_ejercicio_descripcion() {
		return id_ejercicio_descripcion;
	}
	public String getid_tipo_documento_descripcion() {
		return id_tipo_documento_descripcion;
	}
	public String getid_tipo_movimiento_descripcion() {
		return id_tipo_movimiento_descripcion;
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
	public void setid_tipo_documento_descripcion(String newid_tipo_documento_descripcion)throws Exception {
		try {
			this.id_tipo_documento_descripcion=newid_tipo_documento_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_tipo_movimiento_descripcion(String newid_tipo_movimiento_descripcion)throws Exception {
		try {
			this.id_tipo_movimiento_descripcion=newid_tipo_movimiento_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	
	public void inicializarVariablesParaReporte() {
		this.id_empresa_descripcion="";this.id_sucursal_descripcion="";this.id_ejercicio_descripcion="";this.id_tipo_documento_descripcion="";this.id_tipo_movimiento_descripcion="";
	}
	
	
	
	
	
	
	/*PARA REPORTES FIN*/		
}

