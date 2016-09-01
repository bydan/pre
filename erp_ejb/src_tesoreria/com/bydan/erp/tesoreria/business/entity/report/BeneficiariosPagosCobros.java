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
package com.bydan.erp.tesoreria.business.entity.report;

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
//import com.bydan.erp.tesoreria.util.BeneficiariosPagosCobrosConstantesFunciones;
import com.bydan.erp.tesoreria.util.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.contabilidad.util.*;

import com.bydan.erp.tesoreria.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;




@SuppressWarnings("unused")
public class BeneficiariosPagosCobros extends BeneficiariosPagosCobrosAdditional implements Serializable ,Cloneable {//BeneficiariosPagosCobrosAdditional,GeneralEntity
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
	
	private BeneficiariosPagosCobros beneficiariospagoscobrosOriginal;
	
	private Map<String, Object> mapBeneficiariosPagosCobros;
			
	public Map<String, Object> getMapBeneficiariosPagosCobros() {
		return mapBeneficiariosPagosCobros;
	}

	public void setMapBeneficiariosPagosCobros(Map<String, Object> mapBeneficiariosPagosCobros) {
		this.mapBeneficiariosPagosCobros = mapBeneficiariosPagosCobros;
	}
	
	public void inicializarMapBeneficiariosPagosCobros() {
		this.mapBeneficiariosPagosCobros = new HashMap<String,Object>();
	}
	
	public void setMapBeneficiariosPagosCobrosValue(String sKey,Object oValue) {
		this.mapBeneficiariosPagosCobros.put(sKey, oValue);
	}
	
	public Object getMapBeneficiariosPagosCobrosValue(String sKey) {
		return this.mapBeneficiariosPagosCobros.get(sKey);
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
	private Long id_tipo_movimiento;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Date fecha_desde;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Date fecha_hasta;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=50,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	//@Pattern(regex=BeneficiariosPagosCobrosConstantesFunciones.SREGEXCODIGO_CUENTA_CONTABLE,message=BeneficiariosPagosCobrosConstantesFunciones.SMENSAJEREGEXCODIGO_CUENTA_CONTABLE)
	private String codigo_cuenta_contable;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=150,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	//@Pattern(regex=BeneficiariosPagosCobrosConstantesFunciones.SREGEXNOMBRE_CUENTA_CONTABLE,message=BeneficiariosPagosCobrosConstantesFunciones.SMENSAJEREGEXNOMBRE_CUENTA_CONTABLE)
	private String nombre_cuenta_contable;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=100,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	//@Pattern(regex=BeneficiariosPagosCobrosConstantesFunciones.SREGEXNUMERO_MAYOR,message=BeneficiariosPagosCobrosConstantesFunciones.SMENSAJEREGEXNUMERO_MAYOR)
	private String numero_mayor;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=50,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	//@Pattern(regex=BeneficiariosPagosCobrosConstantesFunciones.SREGEXNUMERO_CHEQUE,message=BeneficiariosPagosCobrosConstantesFunciones.SMENSAJEREGEXNUMERO_CHEQUE)
	private String numero_cheque;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=100,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	//@Pattern(regex=BeneficiariosPagosCobrosConstantesFunciones.SREGEXBENEFICIARIO,message=BeneficiariosPagosCobrosConstantesFunciones.SMENSAJEREGEXBENEFICIARIO)
	private String beneficiario;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double debito_local;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double credito_local;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=250,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	//@Pattern(regex=BeneficiariosPagosCobrosConstantesFunciones.SREGEXDETALLE,message=BeneficiariosPagosCobrosConstantesFunciones.SMENSAJEREGEXDETALLE)
	private String detalle;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=100,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	//@Pattern(regex=BeneficiariosPagosCobrosConstantesFunciones.SREGEXTIPO_MOVIMIENTO,message=BeneficiariosPagosCobrosConstantesFunciones.SMENSAJEREGEXTIPO_MOVIMIENTO)
	private String tipo_movimiento;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double valor;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=50,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	//@Pattern(regex=BeneficiariosPagosCobrosConstantesFunciones.SREGEXCUENTA,message=BeneficiariosPagosCobrosConstantesFunciones.SMENSAJEREGEXCUENTA)
	private String cuenta;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Date fecha;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=200,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	//@Pattern(regex=BeneficiariosPagosCobrosConstantesFunciones.SREGEXBENEFICIARIO_ASIENTO,message=BeneficiariosPagosCobrosConstantesFunciones.SMENSAJEREGEXBENEFICIARIO_ASIENTO)
	private String beneficiario_asiento;
			
	
	public Empresa empresa;
	public Sucursal sucursal;
	public Ejercicio ejercicio;
	public TipoMovimiento tipomovimiento;
	
	
	private String empresa_descripcion;
	private String sucursal_descripcion;
	private String ejercicio_descripcion;
	private String tipomovimiento_descripcion;
	
	
		
	public BeneficiariosPagosCobros () throws Exception {
		super();		
		
		this.id=0L;
		
		
		this.versionRow=new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());//new Date();
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		this.sType="NONE";
		
		this.beneficiariospagoscobrosOriginal=this;
		
 		this.id_empresa=-1L;
 		this.id_sucursal=-1L;
 		this.id_ejercicio=-1L;
 		this.id_tipo_movimiento=-1L;
 		this.fecha_desde=new Date();
 		this.fecha_hasta=new Date();
 		this.codigo_cuenta_contable="";
 		this.nombre_cuenta_contable="";
 		this.numero_mayor="";
 		this.numero_cheque="";
 		this.beneficiario="";
 		this.debito_local=0.0;
 		this.credito_local=0.0;
 		this.detalle="";
 		this.tipo_movimiento="";
 		this.valor=0.0;
 		this.cuenta="";
 		this.fecha=new Date();
 		this.beneficiario_asiento="";
		
		
		this.empresa=null;
		this.sucursal=null;
		this.ejercicio=null;
		this.tipomovimiento=null;
		
		
		this.empresa_descripcion="";
		this.sucursal_descripcion="";
		this.ejercicio_descripcion="";
		this.tipomovimiento_descripcion="";
		
		
		
			
		
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
    //PARA REPORTES
	public BeneficiariosPagosCobros (Long id,Date versionRow,String codigo_cuenta_contable,String nombre_cuenta_contable,String numero_mayor,String numero_cheque,String beneficiario,Double debito_local,Double credito_local,String detalle,String tipo_movimiento,Double valor,String cuenta,Date fecha,String beneficiario_asiento) throws Exception {
		super();		
		
		this.id=id;
		this.versionRow=versionRow;
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.beneficiariospagoscobrosOriginal=this;
		
 		this.codigo_cuenta_contable=codigo_cuenta_contable;
 		this.nombre_cuenta_contable=nombre_cuenta_contable;
 		this.numero_mayor=numero_mayor;
 		this.numero_cheque=numero_cheque;
 		this.beneficiario=beneficiario;
 		this.debito_local=debito_local;
 		this.credito_local=credito_local;
 		this.detalle=detalle;
 		this.tipo_movimiento=tipo_movimiento;
 		this.valor=valor;
 		this.cuenta=cuenta;
 		this.fecha=fecha;
 		this.beneficiario_asiento=beneficiario_asiento;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	 //PARA REPORTES
	public BeneficiariosPagosCobros (String codigo_cuenta_contable,String nombre_cuenta_contable,String numero_mayor,String numero_cheque,String beneficiario,Double debito_local,Double credito_local,String detalle,String tipo_movimiento,Double valor,String cuenta,Date fecha,String beneficiario_asiento) throws Exception {
		super();		
		
		this.id=0L;
		this.versionRow=new Date();
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.beneficiariospagoscobrosOriginal=this;
		
 		this.codigo_cuenta_contable=codigo_cuenta_contable;
 		this.nombre_cuenta_contable=nombre_cuenta_contable;
 		this.numero_mayor=numero_mayor;
 		this.numero_cheque=numero_cheque;
 		this.beneficiario=beneficiario;
 		this.debito_local=debito_local;
 		this.credito_local=credito_local;
 		this.detalle=detalle;
 		this.tipo_movimiento=tipo_movimiento;
 		this.valor=valor;
 		this.cuenta=cuenta;
 		this.fecha=fecha;
 		this.beneficiario_asiento=beneficiario_asiento;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	
	public BeneficiariosPagosCobros getBeneficiariosPagosCobrosOriginal() {
		return this.beneficiariospagoscobrosOriginal;
	}
	
	public void setBeneficiariosPagosCobrosOriginal(BeneficiariosPagosCobros beneficiariospagoscobros) {
		try {
			this.beneficiariospagoscobrosOriginal=beneficiariospagoscobros;
		} catch(Exception e) {
			;
		}
	}
	
	
	protected BeneficiariosPagosCobrosAdditional beneficiariospagoscobrosAdditional=null;
	
	public BeneficiariosPagosCobrosAdditional getBeneficiariosPagosCobrosAdditional() {
		return this.beneficiariospagoscobrosAdditional;
	}
	
	public void setBeneficiariosPagosCobrosAdditional(BeneficiariosPagosCobrosAdditional beneficiariospagoscobrosAdditional) {
		try {
			this.beneficiariospagoscobrosAdditional=beneficiariospagoscobrosAdditional;
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
    
	
	public Long getid_tipo_movimiento() {
		return this.id_tipo_movimiento;
	}
    
	
	public Date getfecha_desde() {
		return this.fecha_desde;
	}
    
	
	public Date getfecha_hasta() {
		return this.fecha_hasta;
	}
    
	
	public String getcodigo_cuenta_contable() {
		return this.codigo_cuenta_contable;
	}
    
	
	public String getnombre_cuenta_contable() {
		return this.nombre_cuenta_contable;
	}
    
	
	public String getnumero_mayor() {
		return this.numero_mayor;
	}
    
	
	public String getnumero_cheque() {
		return this.numero_cheque;
	}
    
	
	public String getbeneficiario() {
		return this.beneficiario;
	}
    
	
	public Double getdebito_local() {
		return this.debito_local;
	}
    
	
	public Double getcredito_local() {
		return this.credito_local;
	}
    
	
	public String getdetalle() {
		return this.detalle;
	}
    
	
	public String gettipo_movimiento() {
		return this.tipo_movimiento;
	}
    
	
	public Double getvalor() {
		return this.valor;
	}
    
	
	public String getcuenta() {
		return this.cuenta;
	}
    
	
	public Date getfecha() {
		return this.fecha;
	}
    
	
	public String getbeneficiario_asiento() {
		return this.beneficiario_asiento;
	}
	
    
	public void setid_empresa(Long newid_empresa)throws Exception
	{
		try {
			if(this.id_empresa!=newid_empresa) {
				if(newid_empresa==null) {
					//newid_empresa=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("BeneficiariosPagosCobros:Valor nulo no permitido en columna id_empresa");
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
						System.out.println("BeneficiariosPagosCobros:Valor nulo no permitido en columna id_sucursal");
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
						System.out.println("BeneficiariosPagosCobros:Valor nulo no permitido en columna id_ejercicio");
					}
				}

				this.id_ejercicio=newid_ejercicio;
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
						System.out.println("BeneficiariosPagosCobros:Valor nulo no permitido en columna id_tipo_movimiento");
					}
				}

				this.id_tipo_movimiento=newid_tipo_movimiento;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setfecha_desde(Date newfecha_desde)throws Exception
	{
		try {
			if(this.fecha_desde!=newfecha_desde) {
				if(newfecha_desde==null) {
					//newfecha_desde=new Date();
					if(Constantes.ISDEVELOPING) {
						System.out.println("BeneficiariosPagosCobros:Valor nulo no permitido en columna fecha_desde");
					}
				}

				this.fecha_desde=newfecha_desde;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setfecha_hasta(Date newfecha_hasta)throws Exception
	{
		try {
			if(this.fecha_hasta!=newfecha_hasta) {
				if(newfecha_hasta==null) {
					//newfecha_hasta=new Date();
					if(Constantes.ISDEVELOPING) {
						System.out.println("BeneficiariosPagosCobros:Valor nulo no permitido en columna fecha_hasta");
					}
				}

				this.fecha_hasta=newfecha_hasta;
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
						System.out.println("BeneficiariosPagosCobros:Valor nulo no permitido en columna codigo_cuenta_contable");
					}
				}

				if(newcodigo_cuenta_contable!=null&&newcodigo_cuenta_contable.length()>50) {
					newcodigo_cuenta_contable=newcodigo_cuenta_contable.substring(0,48);
					System.out.println("BeneficiariosPagosCobros:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=50 en columna codigo_cuenta_contable");
				}

				this.codigo_cuenta_contable=newcodigo_cuenta_contable;
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
						System.out.println("BeneficiariosPagosCobros:Valor nulo no permitido en columna nombre_cuenta_contable");
					}
				}

				if(newnombre_cuenta_contable!=null&&newnombre_cuenta_contable.length()>150) {
					newnombre_cuenta_contable=newnombre_cuenta_contable.substring(0,148);
					System.out.println("BeneficiariosPagosCobros:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=150 en columna nombre_cuenta_contable");
				}

				this.nombre_cuenta_contable=newnombre_cuenta_contable;
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
						System.out.println("BeneficiariosPagosCobros:Valor nulo no permitido en columna numero_mayor");
					}
				}

				if(newnumero_mayor!=null&&newnumero_mayor.length()>100) {
					newnumero_mayor=newnumero_mayor.substring(0,98);
					System.out.println("BeneficiariosPagosCobros:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=100 en columna numero_mayor");
				}

				this.numero_mayor=newnumero_mayor;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setnumero_cheque(String newnumero_cheque)throws Exception
	{
		try {
			if(this.numero_cheque!=newnumero_cheque) {
				if(newnumero_cheque==null) {
					//newnumero_cheque="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("BeneficiariosPagosCobros:Valor nulo no permitido en columna numero_cheque");
					}
				}

				if(newnumero_cheque!=null&&newnumero_cheque.length()>50) {
					newnumero_cheque=newnumero_cheque.substring(0,48);
					System.out.println("BeneficiariosPagosCobros:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=50 en columna numero_cheque");
				}

				this.numero_cheque=newnumero_cheque;
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
						System.out.println("BeneficiariosPagosCobros:Valor nulo no permitido en columna beneficiario");
					}
				}

				if(newbeneficiario!=null&&newbeneficiario.length()>100) {
					newbeneficiario=newbeneficiario.substring(0,98);
					System.out.println("BeneficiariosPagosCobros:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=100 en columna beneficiario");
				}

				this.beneficiario=newbeneficiario;
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
						System.out.println("BeneficiariosPagosCobros:Valor nulo no permitido en columna debito_local");
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
						System.out.println("BeneficiariosPagosCobros:Valor nulo no permitido en columna credito_local");
					}
				}

				this.credito_local=newcredito_local;
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
						System.out.println("BeneficiariosPagosCobros:Valor nulo no permitido en columna detalle");
					}
				}

				if(newdetalle!=null&&newdetalle.length()>250) {
					newdetalle=newdetalle.substring(0,248);
					System.out.println("BeneficiariosPagosCobros:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=250 en columna detalle");
				}

				this.detalle=newdetalle;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void settipo_movimiento(String newtipo_movimiento)throws Exception
	{
		try {
			if(this.tipo_movimiento!=newtipo_movimiento) {
				if(newtipo_movimiento==null) {
					//newtipo_movimiento="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("BeneficiariosPagosCobros:Valor nulo no permitido en columna tipo_movimiento");
					}
				}

				if(newtipo_movimiento!=null&&newtipo_movimiento.length()>100) {
					newtipo_movimiento=newtipo_movimiento.substring(0,98);
					System.out.println("BeneficiariosPagosCobros:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=100 en columna tipo_movimiento");
				}

				this.tipo_movimiento=newtipo_movimiento;
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
						System.out.println("BeneficiariosPagosCobros:Valor nulo no permitido en columna valor");
					}
				}

				this.valor=newvalor;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setcuenta(String newcuenta)throws Exception
	{
		try {
			if(this.cuenta!=newcuenta) {
				if(newcuenta==null) {
					//newcuenta="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("BeneficiariosPagosCobros:Valor nulo no permitido en columna cuenta");
					}
				}

				if(newcuenta!=null&&newcuenta.length()>50) {
					newcuenta=newcuenta.substring(0,48);
					System.out.println("BeneficiariosPagosCobros:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=50 en columna cuenta");
				}

				this.cuenta=newcuenta;
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
						System.out.println("BeneficiariosPagosCobros:Valor nulo no permitido en columna fecha");
					}
				}

				this.fecha=newfecha;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setbeneficiario_asiento(String newbeneficiario_asiento)throws Exception
	{
		try {
			if(this.beneficiario_asiento!=newbeneficiario_asiento) {
				if(newbeneficiario_asiento==null) {
					//newbeneficiario_asiento="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("BeneficiariosPagosCobros:Valor nulo no permitido en columna beneficiario_asiento");
					}
				}

				if(newbeneficiario_asiento!=null&&newbeneficiario_asiento.length()>200) {
					newbeneficiario_asiento=newbeneficiario_asiento.substring(0,198);
					System.out.println("BeneficiariosPagosCobros:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=200 en columna beneficiario_asiento");
				}

				this.beneficiario_asiento=newbeneficiario_asiento;
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


	public  void  settipomovimiento_descripcion(String tipomovimiento_descripcion) {
		try {
			this.tipomovimiento_descripcion=tipomovimiento_descripcion;
		} catch(Exception e) {
			;
		}
	}


	
	
	
	
	
	/*PARA REPORTES*/
	String id_empresa_descripcion="";String id_sucursal_descripcion="";String id_ejercicio_descripcion="";String id_tipo_movimiento_descripcion="";
	
	
	public String getid_empresa_descripcion() {
		return id_empresa_descripcion;
	}
	public String getid_sucursal_descripcion() {
		return id_sucursal_descripcion;
	}
	public String getid_ejercicio_descripcion() {
		return id_ejercicio_descripcion;
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
	public void setid_tipo_movimiento_descripcion(String newid_tipo_movimiento_descripcion)throws Exception {
		try {
			this.id_tipo_movimiento_descripcion=newid_tipo_movimiento_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	
	public void inicializarVariablesParaReporte() {
		this.id_empresa_descripcion="";this.id_sucursal_descripcion="";this.id_ejercicio_descripcion="";this.id_tipo_movimiento_descripcion="";
	}
	
	
	
	
	
	
	/*PARA REPORTES FIN*/		
}

