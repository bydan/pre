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
//import com.bydan.erp.tesoreria.util.BancoFormaPagoConstantesFunciones;
import com.bydan.erp.tesoreria.util.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.contabilidad.util.*;
import com.bydan.erp.facturacion.util.*;



import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.facturacion.business.entity.*;




@SuppressWarnings("unused")
public class BancoFormaPago extends BancoFormaPagoAdditional implements Serializable ,Cloneable {//BancoFormaPagoAdditional,GeneralEntity
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
	
	private BancoFormaPago bancoformapagoOriginal;
	
	private Map<String, Object> mapBancoFormaPago;
			
	public Map<String, Object> getMapBancoFormaPago() {
		return mapBancoFormaPago;
	}

	public void setMapBancoFormaPago(Map<String, Object> mapBancoFormaPago) {
		this.mapBancoFormaPago = mapBancoFormaPago;
	}
	
	public void inicializarMapBancoFormaPago() {
		this.mapBancoFormaPago = new HashMap<String,Object>();
	}
	
	public void setMapBancoFormaPagoValue(String sKey,Object oValue) {
		this.mapBancoFormaPago.put(sKey, oValue);
	}
	
	public Object getMapBancoFormaPagoValue(String sKey) {
		return this.mapBancoFormaPago.get(sKey);
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
	@Min(value=-100000,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_factura;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_deta_forma_pago;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_tipo_banco_forma_pago;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=50,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=BancoFormaPagoConstantesFunciones.SREGEXNOMBRE_BANCO,message=BancoFormaPagoConstantesFunciones.SMENSAJEREGEXNOMBRE_BANCO)
	private String nombre_banco;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=100,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=BancoFormaPagoConstantesFunciones.SREGEXNOMBRE_GIRADOR,message=BancoFormaPagoConstantesFunciones.SMENSAJEREGEXNOMBRE_GIRADOR)
	private String nombre_girador;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Date fecha_vence;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=50,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=BancoFormaPagoConstantesFunciones.SREGEXNUMERO_CUENTA_BANCO,message=BancoFormaPagoConstantesFunciones.SMENSAJEREGEXNUMERO_CUENTA_BANCO)
	private String numero_cuenta_banco;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=50,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=BancoFormaPagoConstantesFunciones.SREGEXNUMERO_CHEQUE,message=BancoFormaPagoConstantesFunciones.SMENSAJEREGEXNUMERO_CHEQUE)
	private String numero_cheque;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double valor_monto;
	
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_anio;
	
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_mes;
			
	
	public Empresa empresa;
	public Sucursal sucursal;
	public Ejercicio ejercicio;
	public Periodo periodo;
	public Factura factura;
	public DetaFormaPago detaformapago;
	public TipoBancoFormaPago tipobancoformapago;
	public Anio anio;
	public Mes mes;
	
	
	private String empresa_descripcion;
	private String sucursal_descripcion;
	private String ejercicio_descripcion;
	private String periodo_descripcion;
	private String factura_descripcion;
	private String detaformapago_descripcion;
	private String tipobancoformapago_descripcion;
	private String anio_descripcion;
	private String mes_descripcion;
	
	
		
	public BancoFormaPago () throws Exception {
		super();		
		
		this.id=0L;
		
		
		this.versionRow=new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());//new Date();
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		this.sType="NONE";
		
		this.bancoformapagoOriginal=this;
		
 		this.id_empresa=-1L;
 		this.id_sucursal=-1L;
 		this.id_ejercicio=-1L;
 		this.id_periodo=-1L;
 		this.id_factura=-1L;
 		this.id_deta_forma_pago=-1L;
 		this.id_tipo_banco_forma_pago=-1L;
 		this.nombre_banco="";
 		this.nombre_girador="";
 		this.fecha_vence=new Date();
 		this.numero_cuenta_banco="";
 		this.numero_cheque="";
 		this.valor_monto=0.0;
 		this.id_anio=null;
 		this.id_mes=null;
		
		
		this.empresa=null;
		this.sucursal=null;
		this.ejercicio=null;
		this.periodo=null;
		this.factura=null;
		this.detaformapago=null;
		this.tipobancoformapago=null;
		this.anio=null;
		this.mes=null;
		
		
		this.empresa_descripcion="";
		this.sucursal_descripcion="";
		this.ejercicio_descripcion="";
		this.periodo_descripcion="";
		this.factura_descripcion="";
		this.detaformapago_descripcion="";
		this.tipobancoformapago_descripcion="";
		this.anio_descripcion="";
		this.mes_descripcion="";
		
		
		
			
		
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
    //PARA REPORTES
	public BancoFormaPago (Long id,Date versionRow,Long id_empresa,Long id_sucursal,Long id_ejercicio,Long id_periodo,Long id_factura,Long id_deta_forma_pago,Long id_tipo_banco_forma_pago,String nombre_banco,String nombre_girador,Date fecha_vence,String numero_cuenta_banco,String numero_cheque,Double valor_monto,Long id_anio,Long id_mes) throws Exception {
		super();		
		
		this.id=id;
		this.versionRow=versionRow;
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.bancoformapagoOriginal=this;
		
 		this.id_empresa=id_empresa;
 		this.id_sucursal=id_sucursal;
 		this.id_ejercicio=id_ejercicio;
 		this.id_periodo=id_periodo;
 		this.id_factura=id_factura;
 		this.id_deta_forma_pago=id_deta_forma_pago;
 		this.id_tipo_banco_forma_pago=id_tipo_banco_forma_pago;
 		this.nombre_banco=nombre_banco;
 		this.nombre_girador=nombre_girador;
 		this.fecha_vence=fecha_vence;
 		this.numero_cuenta_banco=numero_cuenta_banco;
 		this.numero_cheque=numero_cheque;
 		this.valor_monto=valor_monto;
 		this.id_anio=id_anio;
 		this.id_mes=id_mes;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	 //PARA REPORTES
	public BancoFormaPago (Long id_empresa,Long id_sucursal,Long id_ejercicio,Long id_periodo,Long id_factura,Long id_deta_forma_pago,Long id_tipo_banco_forma_pago,String nombre_banco,String nombre_girador,Date fecha_vence,String numero_cuenta_banco,String numero_cheque,Double valor_monto,Long id_anio,Long id_mes) throws Exception {
		super();		
		
		this.id=0L;
		this.versionRow=new Date();
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.bancoformapagoOriginal=this;
		
 		this.id_empresa=id_empresa;
 		this.id_sucursal=id_sucursal;
 		this.id_ejercicio=id_ejercicio;
 		this.id_periodo=id_periodo;
 		this.id_factura=id_factura;
 		this.id_deta_forma_pago=id_deta_forma_pago;
 		this.id_tipo_banco_forma_pago=id_tipo_banco_forma_pago;
 		this.nombre_banco=nombre_banco;
 		this.nombre_girador=nombre_girador;
 		this.fecha_vence=fecha_vence;
 		this.numero_cuenta_banco=numero_cuenta_banco;
 		this.numero_cheque=numero_cheque;
 		this.valor_monto=valor_monto;
 		this.id_anio=id_anio;
 		this.id_mes=id_mes;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	public boolean equals(Object object) {
		boolean equal=false;
		BancoFormaPago bancoformapagoLocal=null;
		
		if(object!=null) {
			bancoformapagoLocal=(BancoFormaPago)object;
			
			if(bancoformapagoLocal!=null) {
				if(this.getId()!=null && bancoformapagoLocal.getId()!=null) {
					if(this.getId().equals(bancoformapagoLocal.getId())) {
						equal=true;
					}
				}
			}
		}
		
		return equal;
	}
	
	public String toString() {
		String sDetalle="";
		
		if(!BancoFormaPagoConstantesFunciones.CON_DESCRIPCION_DETALLADO) {
        	sDetalle=BancoFormaPagoConstantesFunciones.getBancoFormaPagoDescripcion(this);
		} else {
			sDetalle=BancoFormaPagoConstantesFunciones.getBancoFormaPagoDescripcionDetallado(this);
		}
		
		return sDetalle;
    }
	
	public BancoFormaPago getBancoFormaPagoOriginal() {
		return this.bancoformapagoOriginal;
	}
	
	public void setBancoFormaPagoOriginal(BancoFormaPago bancoformapago) {
		try {
			this.bancoformapagoOriginal=bancoformapago;
		} catch(Exception e) {
			;
		}
	}
	
	
	protected BancoFormaPagoAdditional bancoformapagoAdditional=null;
	
	public BancoFormaPagoAdditional getBancoFormaPagoAdditional() {
		return this.bancoformapagoAdditional;
	}
	
	public void setBancoFormaPagoAdditional(BancoFormaPagoAdditional bancoformapagoAdditional) {
		try {
			this.bancoformapagoAdditional=bancoformapagoAdditional;
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
    
	
	public Long getid_factura() {
		return this.id_factura;
	}
    
	
	public Long getid_deta_forma_pago() {
		return this.id_deta_forma_pago;
	}
    
	
	public Long getid_tipo_banco_forma_pago() {
		return this.id_tipo_banco_forma_pago;
	}
    
	
	public String getnombre_banco() {
		return this.nombre_banco;
	}
    
	
	public String getnombre_girador() {
		return this.nombre_girador;
	}
    
	
	public Date getfecha_vence() {
		return this.fecha_vence;
	}
    
	
	public String getnumero_cuenta_banco() {
		return this.numero_cuenta_banco;
	}
    
	
	public String getnumero_cheque() {
		return this.numero_cheque;
	}
    
	
	public Double getvalor_monto() {
		return this.valor_monto;
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
						System.out.println("BancoFormaPago:Valor nulo no permitido en columna id_empresa");
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
						System.out.println("BancoFormaPago:Valor nulo no permitido en columna id_sucursal");
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
						System.out.println("BancoFormaPago:Valor nulo no permitido en columna id_ejercicio");
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
						System.out.println("BancoFormaPago:Valor nulo no permitido en columna id_periodo");
					}
				}

				this.id_periodo=newid_periodo;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_factura(Long newid_factura)throws Exception
	{
		try {
			if(this.id_factura!=newid_factura) {
				if(newid_factura==null) {
					//newid_factura=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("BancoFormaPago:Valor nulo no permitido en columna id_factura");
					}
				}

				this.id_factura=newid_factura;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_deta_forma_pago(Long newid_deta_forma_pago)throws Exception
	{
		try {
			if(this.id_deta_forma_pago!=newid_deta_forma_pago) {
				if(newid_deta_forma_pago==null) {
					//newid_deta_forma_pago=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("BancoFormaPago:Valor nulo no permitido en columna id_deta_forma_pago");
					}
				}

				this.id_deta_forma_pago=newid_deta_forma_pago;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_tipo_banco_forma_pago(Long newid_tipo_banco_forma_pago)throws Exception
	{
		try {
			if(this.id_tipo_banco_forma_pago!=newid_tipo_banco_forma_pago) {
				if(newid_tipo_banco_forma_pago==null) {
					//newid_tipo_banco_forma_pago=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("BancoFormaPago:Valor nulo no permitido en columna id_tipo_banco_forma_pago");
					}
				}

				this.id_tipo_banco_forma_pago=newid_tipo_banco_forma_pago;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setnombre_banco(String newnombre_banco)throws Exception
	{
		try {
			if(this.nombre_banco!=newnombre_banco) {
				if(newnombre_banco==null) {
					//newnombre_banco="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("BancoFormaPago:Valor nulo no permitido en columna nombre_banco");
					}
				}

				if(newnombre_banco!=null&&newnombre_banco.length()>50) {
					newnombre_banco=newnombre_banco.substring(0,48);
					System.out.println("BancoFormaPago:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=50 en columna nombre_banco");
				}

				this.nombre_banco=newnombre_banco;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setnombre_girador(String newnombre_girador)throws Exception
	{
		try {
			if(this.nombre_girador!=newnombre_girador) {
				if(newnombre_girador==null) {
					//newnombre_girador="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("BancoFormaPago:Valor nulo no permitido en columna nombre_girador");
					}
				}

				if(newnombre_girador!=null&&newnombre_girador.length()>100) {
					newnombre_girador=newnombre_girador.substring(0,98);
					System.out.println("BancoFormaPago:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=100 en columna nombre_girador");
				}

				this.nombre_girador=newnombre_girador;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setfecha_vence(Date newfecha_vence)throws Exception
	{
		try {
			if(this.fecha_vence!=newfecha_vence) {
				if(newfecha_vence==null) {
					//newfecha_vence=new Date();
					if(Constantes.ISDEVELOPING) {
						System.out.println("BancoFormaPago:Valor nulo no permitido en columna fecha_vence");
					}
				}

				this.fecha_vence=newfecha_vence;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setnumero_cuenta_banco(String newnumero_cuenta_banco)throws Exception
	{
		try {
			if(this.numero_cuenta_banco!=newnumero_cuenta_banco) {
				if(newnumero_cuenta_banco==null) {
					//newnumero_cuenta_banco="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("BancoFormaPago:Valor nulo no permitido en columna numero_cuenta_banco");
					}
				}

				if(newnumero_cuenta_banco!=null&&newnumero_cuenta_banco.length()>50) {
					newnumero_cuenta_banco=newnumero_cuenta_banco.substring(0,48);
					System.out.println("BancoFormaPago:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=50 en columna numero_cuenta_banco");
				}

				this.numero_cuenta_banco=newnumero_cuenta_banco;
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
						System.out.println("BancoFormaPago:Valor nulo no permitido en columna numero_cheque");
					}
				}

				if(newnumero_cheque!=null&&newnumero_cheque.length()>50) {
					newnumero_cheque=newnumero_cheque.substring(0,48);
					System.out.println("BancoFormaPago:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=50 en columna numero_cheque");
				}

				this.numero_cheque=newnumero_cheque;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setvalor_monto(Double newvalor_monto)throws Exception
	{
		try {
			if(this.valor_monto!=newvalor_monto) {
				if(newvalor_monto==null) {
					//newvalor_monto=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("BancoFormaPago:Valor nulo no permitido en columna valor_monto");
					}
				}

				this.valor_monto=newvalor_monto;
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

	public Ejercicio getEjercicio() {
		return this.ejercicio;
	}

	public Periodo getPeriodo() {
		return this.periodo;
	}

	public Factura getFactura() {
		return this.factura;
	}

	public DetaFormaPago getDetaFormaPago() {
		return this.detaformapago;
	}

	public TipoBancoFormaPago getTipoBancoFormaPago() {
		return this.tipobancoformapago;
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

	public String getejercicio_descripcion() {
		return this.ejercicio_descripcion;
	}

	public String getperiodo_descripcion() {
		return this.periodo_descripcion;
	}

	public String getfactura_descripcion() {
		return this.factura_descripcion;
	}

	public String getdetaformapago_descripcion() {
		return this.detaformapago_descripcion;
	}

	public String gettipobancoformapago_descripcion() {
		return this.tipobancoformapago_descripcion;
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


	public  void  setFactura(Factura factura) {
		try {
			this.factura=factura;
		} catch(Exception e) {
			;
		}
	}


	public  void  setDetaFormaPago(DetaFormaPago detaformapago) {
		try {
			this.detaformapago=detaformapago;
		} catch(Exception e) {
			;
		}
	}


	public  void  setTipoBancoFormaPago(TipoBancoFormaPago tipobancoformapago) {
		try {
			this.tipobancoformapago=tipobancoformapago;
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


	public  void  setfactura_descripcion(String factura_descripcion) {
		try {
			this.factura_descripcion=factura_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  setdetaformapago_descripcion(String detaformapago_descripcion) {
		try {
			this.detaformapago_descripcion=detaformapago_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  settipobancoformapago_descripcion(String tipobancoformapago_descripcion) {
		try {
			this.tipobancoformapago_descripcion=tipobancoformapago_descripcion;
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
	String id_empresa_descripcion="";String id_sucursal_descripcion="";String id_ejercicio_descripcion="";String id_periodo_descripcion="";String id_factura_descripcion="";String id_deta_forma_pago_descripcion="";String id_tipo_banco_forma_pago_descripcion="";String id_anio_descripcion="";String id_mes_descripcion="";
	
	
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
	public String getid_factura_descripcion() {
		return id_factura_descripcion;
	}
	public String getid_deta_forma_pago_descripcion() {
		return id_deta_forma_pago_descripcion;
	}
	public String getid_tipo_banco_forma_pago_descripcion() {
		return id_tipo_banco_forma_pago_descripcion;
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
	public void setid_factura_descripcion(String newid_factura_descripcion)throws Exception {
		try {
			this.id_factura_descripcion=newid_factura_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_deta_forma_pago_descripcion(String newid_deta_forma_pago_descripcion)throws Exception {
		try {
			this.id_deta_forma_pago_descripcion=newid_deta_forma_pago_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_tipo_banco_forma_pago_descripcion(String newid_tipo_banco_forma_pago_descripcion)throws Exception {
		try {
			this.id_tipo_banco_forma_pago_descripcion=newid_tipo_banco_forma_pago_descripcion;
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
		this.id_empresa_descripcion="";this.id_sucursal_descripcion="";this.id_ejercicio_descripcion="";this.id_periodo_descripcion="";this.id_factura_descripcion="";this.id_deta_forma_pago_descripcion="";this.id_tipo_banco_forma_pago_descripcion="";this.id_anio_descripcion="";this.id_mes_descripcion="";
	}
	
	
	
	
	
	
	/*PARA REPORTES FIN*/		
}

