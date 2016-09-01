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
package com.bydan.erp.tesoreria.business.entity;

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
//import com.bydan.erp.tesoreria.util.ChequePostFechadoConstantesFunciones;
import com.bydan.erp.tesoreria.util.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.cartera.util.*;
import com.bydan.erp.contabilidad.util.*;
import com.bydan.erp.facturacion.util.*;



import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.facturacion.business.entity.*;




@SuppressWarnings("unused")
public class ChequePostFechado extends ChequePostFechadoAdditional implements Serializable ,Cloneable {//ChequePostFechadoAdditional,GeneralEntity
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
	
	private ChequePostFechado chequepostfechadoOriginal;
	
	private Map<String, Object> mapChequePostFechado;
			
	public Map<String, Object> getMapChequePostFechado() {
		return mapChequePostFechado;
	}

	public void setMapChequePostFechado(Map<String, Object> mapChequePostFechado) {
		this.mapChequePostFechado = mapChequePostFechado;
	}
	
	public void inicializarMapChequePostFechado() {
		this.mapChequePostFechado = new HashMap<String,Object>();
	}
	
	public void setMapChequePostFechadoValue(String sKey,Object oValue) {
		this.mapChequePostFechado.put(sKey, oValue);
	}
	
	public Object getMapChequePostFechadoValue(String sKey) {
		return this.mapChequePostFechado.get(sKey);
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
	private Long id_cliente;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=-100000,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_asiento_contable;
	
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
	private Long id_tipo_forma_pago;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=150,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=ChequePostFechadoConstantesFunciones.SREGEXNOMBRE_GIRA,message=ChequePostFechadoConstantesFunciones.SMENSAJEREGEXNOMBRE_GIRA)
	private String nombre_gira;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Date fecha_vencimiento;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Date fecha_vencimiento_original;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=50,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=ChequePostFechadoConstantesFunciones.SREGEXNUMERO,message=ChequePostFechadoConstantesFunciones.SMENSAJEREGEXNUMERO)
	private String numero;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=50,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=ChequePostFechadoConstantesFunciones.SREGEXNUMERO_CHEQUE,message=ChequePostFechadoConstantesFunciones.SMENSAJEREGEXNUMERO_CHEQUE)
	private String numero_cheque;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=100,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=ChequePostFechadoConstantesFunciones.SREGEXDESCRIPCION,message=ChequePostFechadoConstantesFunciones.SMENSAJEREGEXDESCRIPCION)
	private String descripcion;
	
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_anio;
	
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_mes;
			
	
	public Empresa empresa;
	public Sucursal sucursal;
	public Cliente cliente;
	public AsientoContable asientocontable;
	public Ejercicio ejercicio;
	public Periodo periodo;
	public TipoFormaPago tipoformapago;
	public Anio anio;
	public Mes mes;
	
	
	private String empresa_descripcion;
	private String sucursal_descripcion;
	private String cliente_descripcion;
	private String asientocontable_descripcion;
	private String ejercicio_descripcion;
	private String periodo_descripcion;
	private String tipoformapago_descripcion;
	private String anio_descripcion;
	private String mes_descripcion;
	
	
		
	public ChequePostFechado () throws Exception {
		super();		
		
		this.id=0L;
		
		
		this.versionRow=new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());//new Date();
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		this.sType="NONE";
		
		this.chequepostfechadoOriginal=this;
		
 		this.id_empresa=-1L;
 		this.id_sucursal=-1L;
 		this.id_cliente=-1L;
 		this.id_asiento_contable=-1L;
 		this.id_ejercicio=-1L;
 		this.id_periodo=-1L;
 		this.id_tipo_forma_pago=-1L;
 		this.nombre_gira="";
 		this.fecha_vencimiento=new Date();
 		this.fecha_vencimiento_original=new Date();
 		this.numero="";
 		this.numero_cheque="";
 		this.descripcion="";
 		this.id_anio=null;
 		this.id_mes=null;
		
		
		this.empresa=null;
		this.sucursal=null;
		this.cliente=null;
		this.asientocontable=null;
		this.ejercicio=null;
		this.periodo=null;
		this.tipoformapago=null;
		this.anio=null;
		this.mes=null;
		
		
		this.empresa_descripcion="";
		this.sucursal_descripcion="";
		this.cliente_descripcion="";
		this.asientocontable_descripcion="";
		this.ejercicio_descripcion="";
		this.periodo_descripcion="";
		this.tipoformapago_descripcion="";
		this.anio_descripcion="";
		this.mes_descripcion="";
		
		
		
			
		
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
    //PARA REPORTES
	public ChequePostFechado (Long id,Date versionRow,Long id_empresa,Long id_sucursal,Long id_cliente,Long id_asiento_contable,Long id_ejercicio,Long id_periodo,Long id_tipo_forma_pago,String nombre_gira,Date fecha_vencimiento,Date fecha_vencimiento_original,String numero,String numero_cheque,String descripcion,Long id_anio,Long id_mes) throws Exception {
		super();		
		
		this.id=id;
		this.versionRow=versionRow;
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.chequepostfechadoOriginal=this;
		
 		this.id_empresa=id_empresa;
 		this.id_sucursal=id_sucursal;
 		this.id_cliente=id_cliente;
 		this.id_asiento_contable=id_asiento_contable;
 		this.id_ejercicio=id_ejercicio;
 		this.id_periodo=id_periodo;
 		this.id_tipo_forma_pago=id_tipo_forma_pago;
 		this.nombre_gira=nombre_gira;
 		this.fecha_vencimiento=fecha_vencimiento;
 		this.fecha_vencimiento_original=fecha_vencimiento_original;
 		this.numero=numero;
 		this.numero_cheque=numero_cheque;
 		this.descripcion=descripcion;
 		this.id_anio=id_anio;
 		this.id_mes=id_mes;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	 //PARA REPORTES
	public ChequePostFechado (Long id_empresa,Long id_sucursal,Long id_cliente,Long id_asiento_contable,Long id_ejercicio,Long id_periodo,Long id_tipo_forma_pago,String nombre_gira,Date fecha_vencimiento,Date fecha_vencimiento_original,String numero,String numero_cheque,String descripcion,Long id_anio,Long id_mes) throws Exception {
		super();		
		
		this.id=0L;
		this.versionRow=new Date();
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.chequepostfechadoOriginal=this;
		
 		this.id_empresa=id_empresa;
 		this.id_sucursal=id_sucursal;
 		this.id_cliente=id_cliente;
 		this.id_asiento_contable=id_asiento_contable;
 		this.id_ejercicio=id_ejercicio;
 		this.id_periodo=id_periodo;
 		this.id_tipo_forma_pago=id_tipo_forma_pago;
 		this.nombre_gira=nombre_gira;
 		this.fecha_vencimiento=fecha_vencimiento;
 		this.fecha_vencimiento_original=fecha_vencimiento_original;
 		this.numero=numero;
 		this.numero_cheque=numero_cheque;
 		this.descripcion=descripcion;
 		this.id_anio=id_anio;
 		this.id_mes=id_mes;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	public boolean equals(Object object) {
		boolean equal=false;
		ChequePostFechado chequepostfechadoLocal=null;
		
		if(object!=null) {
			chequepostfechadoLocal=(ChequePostFechado)object;
			
			if(chequepostfechadoLocal!=null) {
				if(this.getId()!=null && chequepostfechadoLocal.getId()!=null) {
					if(this.getId().equals(chequepostfechadoLocal.getId())) {
						equal=true;
					}
				}
			}
		}
		
		return equal;
	}
	
	public String toString() {
		String sDetalle="";
		
		if(!ChequePostFechadoConstantesFunciones.CON_DESCRIPCION_DETALLADO) {
        	sDetalle=ChequePostFechadoConstantesFunciones.getChequePostFechadoDescripcion(this);
		} else {
			sDetalle=ChequePostFechadoConstantesFunciones.getChequePostFechadoDescripcionDetallado(this);
		}
		
		return sDetalle;
    }
	
	public ChequePostFechado getChequePostFechadoOriginal() {
		return this.chequepostfechadoOriginal;
	}
	
	public void setChequePostFechadoOriginal(ChequePostFechado chequepostfechado) {
		try {
			this.chequepostfechadoOriginal=chequepostfechado;
		} catch(Exception e) {
			;
		}
	}
	
	
	protected ChequePostFechadoAdditional chequepostfechadoAdditional=null;
	
	public ChequePostFechadoAdditional getChequePostFechadoAdditional() {
		return this.chequepostfechadoAdditional;
	}
	
	public void setChequePostFechadoAdditional(ChequePostFechadoAdditional chequepostfechadoAdditional) {
		try {
			this.chequepostfechadoAdditional=chequepostfechadoAdditional;
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
    
	
	public Long getid_cliente() {
		return this.id_cliente;
	}
    
	
	public Long getid_asiento_contable() {
		return this.id_asiento_contable;
	}
    
	
	public Long getid_ejercicio() {
		return this.id_ejercicio;
	}
    
	
	public Long getid_periodo() {
		return this.id_periodo;
	}
    
	
	public Long getid_tipo_forma_pago() {
		return this.id_tipo_forma_pago;
	}
    
	
	public String getnombre_gira() {
		return this.nombre_gira;
	}
    
	
	public Date getfecha_vencimiento() {
		return this.fecha_vencimiento;
	}
    
	
	public Date getfecha_vencimiento_original() {
		return this.fecha_vencimiento_original;
	}
    
	
	public String getnumero() {
		return this.numero;
	}
    
	
	public String getnumero_cheque() {
		return this.numero_cheque;
	}
    
	
	public String getdescripcion() {
		return this.descripcion;
	}
    
	
	public Long getid_anio() {
		return this.id_anio;
	}
    
	
	public Long getid_mes() {
		return this.id_mes;
	}
	
    
	public void setid_empresa(Long newid_empresa)throws Exception
	{
		try {
			if(this.id_empresa!=newid_empresa) {
				if(newid_empresa==null) {
					//newid_empresa=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ChequePostFechado:Valor nulo no permitido en columna id_empresa");
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
						System.out.println("ChequePostFechado:Valor nulo no permitido en columna id_sucursal");
					}
				}

				this.id_sucursal=newid_sucursal;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_cliente(Long newid_cliente)throws Exception
	{
		try {
			if(this.id_cliente!=newid_cliente) {
				if(newid_cliente==null) {
					//newid_cliente=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ChequePostFechado:Valor nulo no permitido en columna id_cliente");
					}
				}

				this.id_cliente=newid_cliente;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_asiento_contable(Long newid_asiento_contable)throws Exception
	{
		try {
			if(this.id_asiento_contable!=newid_asiento_contable) {
				if(newid_asiento_contable==null) {
					//newid_asiento_contable=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ChequePostFechado:Valor nulo no permitido en columna id_asiento_contable");
					}
				}

				this.id_asiento_contable=newid_asiento_contable;
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
						System.out.println("ChequePostFechado:Valor nulo no permitido en columna id_ejercicio");
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
						System.out.println("ChequePostFechado:Valor nulo no permitido en columna id_periodo");
					}
				}

				this.id_periodo=newid_periodo;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_tipo_forma_pago(Long newid_tipo_forma_pago)throws Exception
	{
		try {
			if(this.id_tipo_forma_pago!=newid_tipo_forma_pago) {
				if(newid_tipo_forma_pago==null) {
					//newid_tipo_forma_pago=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ChequePostFechado:Valor nulo no permitido en columna id_tipo_forma_pago");
					}
				}

				this.id_tipo_forma_pago=newid_tipo_forma_pago;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setnombre_gira(String newnombre_gira)throws Exception
	{
		try {
			if(this.nombre_gira!=newnombre_gira) {
				if(newnombre_gira==null) {
					//newnombre_gira="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("ChequePostFechado:Valor nulo no permitido en columna nombre_gira");
					}
				}

				if(newnombre_gira!=null&&newnombre_gira.length()>150) {
					newnombre_gira=newnombre_gira.substring(0,148);
					System.out.println("ChequePostFechado:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=150 en columna nombre_gira");
				}

				this.nombre_gira=newnombre_gira;
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
						System.out.println("ChequePostFechado:Valor nulo no permitido en columna fecha_vencimiento");
					}
				}

				this.fecha_vencimiento=newfecha_vencimiento;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setfecha_vencimiento_original(Date newfecha_vencimiento_original)throws Exception
	{
		try {
			if(this.fecha_vencimiento_original!=newfecha_vencimiento_original) {
				if(newfecha_vencimiento_original==null) {
					//newfecha_vencimiento_original=new Date();
					if(Constantes.ISDEVELOPING) {
						System.out.println("ChequePostFechado:Valor nulo no permitido en columna fecha_vencimiento_original");
					}
				}

				this.fecha_vencimiento_original=newfecha_vencimiento_original;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setnumero(String newnumero)throws Exception
	{
		try {
			if(this.numero!=newnumero) {
				if(newnumero==null) {
					//newnumero="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("ChequePostFechado:Valor nulo no permitido en columna numero");
					}
				}

				if(newnumero!=null&&newnumero.length()>50) {
					newnumero=newnumero.substring(0,48);
					System.out.println("ChequePostFechado:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=50 en columna numero");
				}

				this.numero=newnumero;
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
						System.out.println("ChequePostFechado:Valor nulo no permitido en columna numero_cheque");
					}
				}

				if(newnumero_cheque!=null&&newnumero_cheque.length()>50) {
					newnumero_cheque=newnumero_cheque.substring(0,48);
					System.out.println("ChequePostFechado:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=50 en columna numero_cheque");
				}

				this.numero_cheque=newnumero_cheque;
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
						System.out.println("ChequePostFechado:Valor nulo no permitido en columna descripcion");
					}
				}

				if(newdescripcion!=null&&newdescripcion.length()>100) {
					newdescripcion=newdescripcion.substring(0,98);
					System.out.println("ChequePostFechado:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=100 en columna descripcion");
				}

				this.descripcion=newdescripcion;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_anio(Long newid_anio) {
		if(this.id_anio==null&&newid_anio!=null) {
			this.id_anio=newid_anio;
				this.setIsChanged(true);
		}

		if(this.id_anio!=null&&!this.id_anio.equals(newid_anio)) {

			this.id_anio=newid_anio;
				this.setIsChanged(true);
		}
	}
    
	public void setid_mes(Long newid_mes) {
		if(this.id_mes==null&&newid_mes!=null) {
			this.id_mes=newid_mes;
				this.setIsChanged(true);
		}

		if(this.id_mes!=null&&!this.id_mes.equals(newid_mes)) {

			this.id_mes=newid_mes;
				this.setIsChanged(true);
		}
	}
	
	
	public Empresa getEmpresa() {
		return this.empresa;
	}

	public Sucursal getSucursal() {
		return this.sucursal;
	}

	public Cliente getCliente() {
		return this.cliente;
	}

	public AsientoContable getAsientoContable() {
		return this.asientocontable;
	}

	public Ejercicio getEjercicio() {
		return this.ejercicio;
	}

	public Periodo getPeriodo() {
		return this.periodo;
	}

	public TipoFormaPago getTipoFormaPago() {
		return this.tipoformapago;
	}

	public Anio getAnio() {
		return this.anio;
	}

	public Mes getMes() {
		return this.mes;
	}

	
	
	public String getempresa_descripcion() {
		return this.empresa_descripcion;
	}

	public String getsucursal_descripcion() {
		return this.sucursal_descripcion;
	}

	public String getcliente_descripcion() {
		return this.cliente_descripcion;
	}

	public String getasientocontable_descripcion() {
		return this.asientocontable_descripcion;
	}

	public String getejercicio_descripcion() {
		return this.ejercicio_descripcion;
	}

	public String getperiodo_descripcion() {
		return this.periodo_descripcion;
	}

	public String gettipoformapago_descripcion() {
		return this.tipoformapago_descripcion;
	}

	public String getanio_descripcion() {
		return this.anio_descripcion;
	}

	public String getmes_descripcion() {
		return this.mes_descripcion;
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


	public  void  setCliente(Cliente cliente) {
		try {
			this.cliente=cliente;
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


	public  void  setTipoFormaPago(TipoFormaPago tipoformapago) {
		try {
			this.tipoformapago=tipoformapago;
		} catch(Exception e) {
			;
		}
	}


	public  void  setAnio(Anio anio) {
		try {
			this.anio=anio;
		} catch(Exception e) {
			;
		}
	}


	public  void  setMes(Mes mes) {
		try {
			this.mes=mes;
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


	public  void  setcliente_descripcion(String cliente_descripcion) {
		try {
			this.cliente_descripcion=cliente_descripcion;
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


	public  void  settipoformapago_descripcion(String tipoformapago_descripcion) {
		try {
			this.tipoformapago_descripcion=tipoformapago_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  setanio_descripcion(String anio_descripcion) {
		try {
			this.anio_descripcion=anio_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  setmes_descripcion(String mes_descripcion) {
		try {
			this.mes_descripcion=mes_descripcion;
		} catch(Exception e) {
			;
		}
	}


	
	
	
	
	
	/*PARA REPORTES*/
	String id_empresa_descripcion="";String id_sucursal_descripcion="";String id_cliente_descripcion="";String id_asiento_contable_descripcion="";String id_ejercicio_descripcion="";String id_periodo_descripcion="";String id_tipo_forma_pago_descripcion="";String id_anio_descripcion="";String id_mes_descripcion="";
	
	
	public String getid_empresa_descripcion() {
		return id_empresa_descripcion;
	}
	public String getid_sucursal_descripcion() {
		return id_sucursal_descripcion;
	}
	public String getid_cliente_descripcion() {
		return id_cliente_descripcion;
	}
	public String getid_asiento_contable_descripcion() {
		return id_asiento_contable_descripcion;
	}
	public String getid_ejercicio_descripcion() {
		return id_ejercicio_descripcion;
	}
	public String getid_periodo_descripcion() {
		return id_periodo_descripcion;
	}
	public String getid_tipo_forma_pago_descripcion() {
		return id_tipo_forma_pago_descripcion;
	}
	public String getid_anio_descripcion() {
		return id_anio_descripcion;
	}
	public String getid_mes_descripcion() {
		return id_mes_descripcion;
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
	public void setid_cliente_descripcion(String newid_cliente_descripcion)throws Exception {
		try {
			this.id_cliente_descripcion=newid_cliente_descripcion;
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
	public void setid_tipo_forma_pago_descripcion(String newid_tipo_forma_pago_descripcion)throws Exception {
		try {
			this.id_tipo_forma_pago_descripcion=newid_tipo_forma_pago_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_anio_descripcion(String newid_anio_descripcion)throws Exception {
		try {
			this.id_anio_descripcion=newid_anio_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_mes_descripcion(String newid_mes_descripcion)throws Exception {
		try {
			this.id_mes_descripcion=newid_mes_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	
	public void inicializarVariablesParaReporte() {
		this.id_empresa_descripcion="";this.id_sucursal_descripcion="";this.id_cliente_descripcion="";this.id_asiento_contable_descripcion="";this.id_ejercicio_descripcion="";this.id_periodo_descripcion="";this.id_tipo_forma_pago_descripcion="";this.id_anio_descripcion="";this.id_mes_descripcion="";
	}
	
	
	
	
	
	
	/*PARA REPORTES FIN*/		
}

