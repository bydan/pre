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
package com.bydan.erp.puntoventa.business.entity.report;

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
//import com.bydan.erp.puntoventa.util.ComprobanteFormaPagoConstantesFunciones;
import com.bydan.erp.puntoventa.util.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.cartera.util.*;
import com.bydan.erp.puntoventa.util.*;

import com.bydan.erp.puntoventa.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;
import com.bydan.erp.puntoventa.business.entity.*;




@SuppressWarnings("unused")
public class ComprobanteFormaPago extends ComprobanteFormaPagoAdditional implements Serializable ,Cloneable {//ComprobanteFormaPagoAdditional,GeneralEntity
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
	
	private ComprobanteFormaPago comprobanteformapagoOriginal;
	
	private Map<String, Object> mapComprobanteFormaPago;
			
	public Map<String, Object> getMapComprobanteFormaPago() {
		return mapComprobanteFormaPago;
	}

	public void setMapComprobanteFormaPago(Map<String, Object> mapComprobanteFormaPago) {
		this.mapComprobanteFormaPago = mapComprobanteFormaPago;
	}
	
	public void inicializarMapComprobanteFormaPago() {
		this.mapComprobanteFormaPago = new HashMap<String,Object>();
	}
	
	public void setMapComprobanteFormaPagoValue(String sKey,Object oValue) {
		this.mapComprobanteFormaPago.put(sKey, oValue);
	}
	
	public Object getMapComprobanteFormaPagoValue(String sKey) {
		return this.mapComprobanteFormaPago.get(sKey);
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
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_caja;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Date fecha_inicio;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Date fecha_fin;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=100,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	//@Pattern(regex=ComprobanteFormaPagoConstantesFunciones.SREGEXNOMBRE_CAJA,message=ComprobanteFormaPagoConstantesFunciones.SMENSAJEREGEXNOMBRE_CAJA)
	private String nombre_caja;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=50,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	//@Pattern(regex=ComprobanteFormaPagoConstantesFunciones.SREGEXSECUENCIAL,message=ComprobanteFormaPagoConstantesFunciones.SMENSAJEREGEXSECUENCIAL)
	private String secuencial;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Date fecha;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=20,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	//@Pattern(regex=ComprobanteFormaPagoConstantesFunciones.SREGEXCODIGO_CLIENTE,message=ComprobanteFormaPagoConstantesFunciones.SMENSAJEREGEXCODIGO_CLIENTE)
	private String codigo_cliente;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=100,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	//@Pattern(regex=ComprobanteFormaPagoConstantesFunciones.SREGEXNOMBRE_CLIENTE,message=ComprobanteFormaPagoConstantesFunciones.SMENSAJEREGEXNOMBRE_CLIENTE)
	private String nombre_cliente;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double subtotal;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double iva;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double descuento;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double financiamiento;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double flete;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double ice;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double total;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=50,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	//@Pattern(regex=ComprobanteFormaPagoConstantesFunciones.SREGEXTIPO,message=ComprobanteFormaPagoConstantesFunciones.SMENSAJEREGEXTIPO)
	private String tipo;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double valor;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Date fecha_forma_pago;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=50,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	//@Pattern(regex=ComprobanteFormaPagoConstantesFunciones.SREGEXNUMERO_CUENTA,message=ComprobanteFormaPagoConstantesFunciones.SMENSAJEREGEXNUMERO_CUENTA)
	private String numero_cuenta;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=50,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	//@Pattern(regex=ComprobanteFormaPagoConstantesFunciones.SREGEXNUMERO_CHEQUE,message=ComprobanteFormaPagoConstantesFunciones.SMENSAJEREGEXNUMERO_CHEQUE)
	private String numero_cheque;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=100,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	//@Pattern(regex=ComprobanteFormaPagoConstantesFunciones.SREGEXGIRADOR,message=ComprobanteFormaPagoConstantesFunciones.SMENSAJEREGEXGIRADOR)
	private String girador;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=10,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONINT)
	private Integer numero_dias_plazo;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=50,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	//@Pattern(regex=ComprobanteFormaPagoConstantesFunciones.SREGEXNUMERO_TARJETA,message=ComprobanteFormaPagoConstantesFunciones.SMENSAJEREGEXNUMERO_TARJETA)
	private String numero_tarjeta;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=100,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	//@Pattern(regex=ComprobanteFormaPagoConstantesFunciones.SREGEXAUTORIZACION,message=ComprobanteFormaPagoConstantesFunciones.SMENSAJEREGEXAUTORIZACION)
	private String autorizacion;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=50,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	//@Pattern(regex=ComprobanteFormaPagoConstantesFunciones.SREGEXLOTE,message=ComprobanteFormaPagoConstantesFunciones.SMENSAJEREGEXLOTE)
	private String lote;
			
	
	public Empresa empresa;
	public Sucursal sucursal;
	public Cliente cliente;
	public Caja caja;
	
	
	private String empresa_descripcion;
	private String sucursal_descripcion;
	private String cliente_descripcion;
	private String caja_descripcion;
	
	
		
	public ComprobanteFormaPago () throws Exception {
		super();		
		
		this.id=0L;
		
		
		this.versionRow=new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());//new Date();
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		this.sType="NONE";
		
		this.comprobanteformapagoOriginal=this;
		
 		this.id_empresa=-1L;
 		this.id_sucursal=-1L;
 		this.id_cliente=-1L;
 		this.id_caja=-1L;
 		this.fecha_inicio=new Date();
 		this.fecha_fin=new Date();
 		this.nombre_caja="";
 		this.secuencial="";
 		this.fecha=new Date();
 		this.codigo_cliente="";
 		this.nombre_cliente="";
 		this.subtotal=0.0;
 		this.iva=0.0;
 		this.descuento=0.0;
 		this.financiamiento=0.0;
 		this.flete=0.0;
 		this.ice=0.0;
 		this.total=0.0;
 		this.tipo="";
 		this.valor=0.0;
 		this.fecha_forma_pago=new Date();
 		this.numero_cuenta="";
 		this.numero_cheque="";
 		this.girador="";
 		this.numero_dias_plazo=0;
 		this.numero_tarjeta="";
 		this.autorizacion="";
 		this.lote="";
		
		
		this.empresa=null;
		this.sucursal=null;
		this.cliente=null;
		this.caja=null;
		
		
		this.empresa_descripcion="";
		this.sucursal_descripcion="";
		this.cliente_descripcion="";
		this.caja_descripcion="";
		
		
		
			
		
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
    //PARA REPORTES
	public ComprobanteFormaPago (Long id,Date versionRow,Long id_cliente,Long id_caja,String nombre_caja,String secuencial,Date fecha,String codigo_cliente,String nombre_cliente,Double subtotal,Double iva,Double descuento,Double financiamiento,Double flete,Double ice,Double total,String tipo,Double valor,Date fecha_forma_pago,String numero_cuenta,String numero_cheque,String girador,Integer numero_dias_plazo,String numero_tarjeta,String autorizacion,String lote) throws Exception {
		super();		
		
		this.id=id;
		this.versionRow=versionRow;
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.comprobanteformapagoOriginal=this;
		
 		this.id_cliente=id_cliente;
 		this.id_caja=id_caja;
 		this.nombre_caja=nombre_caja;
 		this.secuencial=secuencial;
 		this.fecha=fecha;
 		this.codigo_cliente=codigo_cliente;
 		this.nombre_cliente=nombre_cliente;
 		this.subtotal=subtotal;
 		this.iva=iva;
 		this.descuento=descuento;
 		this.financiamiento=financiamiento;
 		this.flete=flete;
 		this.ice=ice;
 		this.total=total;
 		this.tipo=tipo;
 		this.valor=valor;
 		this.fecha_forma_pago=fecha_forma_pago;
 		this.numero_cuenta=numero_cuenta;
 		this.numero_cheque=numero_cheque;
 		this.girador=girador;
 		this.numero_dias_plazo=numero_dias_plazo;
 		this.numero_tarjeta=numero_tarjeta;
 		this.autorizacion=autorizacion;
 		this.lote=lote;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	 //PARA REPORTES
	public ComprobanteFormaPago (Long id_cliente,Long id_caja,String nombre_caja,String secuencial,Date fecha,String codigo_cliente,String nombre_cliente,Double subtotal,Double iva,Double descuento,Double financiamiento,Double flete,Double ice,Double total,String tipo,Double valor,Date fecha_forma_pago,String numero_cuenta,String numero_cheque,String girador,Integer numero_dias_plazo,String numero_tarjeta,String autorizacion,String lote) throws Exception {
		super();		
		
		this.id=0L;
		this.versionRow=new Date();
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.comprobanteformapagoOriginal=this;
		
 		this.id_cliente=id_cliente;
 		this.id_caja=id_caja;
 		this.nombre_caja=nombre_caja;
 		this.secuencial=secuencial;
 		this.fecha=fecha;
 		this.codigo_cliente=codigo_cliente;
 		this.nombre_cliente=nombre_cliente;
 		this.subtotal=subtotal;
 		this.iva=iva;
 		this.descuento=descuento;
 		this.financiamiento=financiamiento;
 		this.flete=flete;
 		this.ice=ice;
 		this.total=total;
 		this.tipo=tipo;
 		this.valor=valor;
 		this.fecha_forma_pago=fecha_forma_pago;
 		this.numero_cuenta=numero_cuenta;
 		this.numero_cheque=numero_cheque;
 		this.girador=girador;
 		this.numero_dias_plazo=numero_dias_plazo;
 		this.numero_tarjeta=numero_tarjeta;
 		this.autorizacion=autorizacion;
 		this.lote=lote;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	
	public ComprobanteFormaPago getComprobanteFormaPagoOriginal() {
		return this.comprobanteformapagoOriginal;
	}
	
	public void setComprobanteFormaPagoOriginal(ComprobanteFormaPago comprobanteformapago) {
		try {
			this.comprobanteformapagoOriginal=comprobanteformapago;
		} catch(Exception e) {
			;
		}
	}
	
	
	protected ComprobanteFormaPagoAdditional comprobanteformapagoAdditional=null;
	
	public ComprobanteFormaPagoAdditional getComprobanteFormaPagoAdditional() {
		return this.comprobanteformapagoAdditional;
	}
	
	public void setComprobanteFormaPagoAdditional(ComprobanteFormaPagoAdditional comprobanteformapagoAdditional) {
		try {
			this.comprobanteformapagoAdditional=comprobanteformapagoAdditional;
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
    
	
	public Long getid_caja() {
		return this.id_caja;
	}
    
	
	public Date getfecha_inicio() {
		return this.fecha_inicio;
	}
    
	
	public Date getfecha_fin() {
		return this.fecha_fin;
	}
    
	
	public String getnombre_caja() {
		return this.nombre_caja;
	}
    
	
	public String getsecuencial() {
		return this.secuencial;
	}
    
	
	public Date getfecha() {
		return this.fecha;
	}
    
	
	public String getcodigo_cliente() {
		return this.codigo_cliente;
	}
    
	
	public String getnombre_cliente() {
		return this.nombre_cliente;
	}
    
	
	public Double getsubtotal() {
		return this.subtotal;
	}
    
	
	public Double getiva() {
		return this.iva;
	}
    
	
	public Double getdescuento() {
		return this.descuento;
	}
    
	
	public Double getfinanciamiento() {
		return this.financiamiento;
	}
    
	
	public Double getflete() {
		return this.flete;
	}
    
	
	public Double getice() {
		return this.ice;
	}
    
	
	public Double gettotal() {
		return this.total;
	}
    
	
	public String gettipo() {
		return this.tipo;
	}
    
	
	public Double getvalor() {
		return this.valor;
	}
    
	
	public Date getfecha_forma_pago() {
		return this.fecha_forma_pago;
	}
    
	
	public String getnumero_cuenta() {
		return this.numero_cuenta;
	}
    
	
	public String getnumero_cheque() {
		return this.numero_cheque;
	}
    
	
	public String getgirador() {
		return this.girador;
	}
    
	
	public Integer getnumero_dias_plazo() {
		return this.numero_dias_plazo;
	}
    
	
	public String getnumero_tarjeta() {
		return this.numero_tarjeta;
	}
    
	
	public String getautorizacion() {
		return this.autorizacion;
	}
    
	
	public String getlote() {
		return this.lote;
	}
	
    
	public void setid_empresa(Long newid_empresa)throws Exception
	{
		try {
			if(this.id_empresa!=newid_empresa) {
				if(newid_empresa==null) {
					//newid_empresa=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ComprobanteFormaPago:Valor nulo no permitido en columna id_empresa");
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
						System.out.println("ComprobanteFormaPago:Valor nulo no permitido en columna id_sucursal");
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
						System.out.println("ComprobanteFormaPago:Valor nulo no permitido en columna id_cliente");
					}
				}

				this.id_cliente=newid_cliente;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_caja(Long newid_caja)throws Exception
	{
		try {
			if(this.id_caja!=newid_caja) {
				if(newid_caja==null) {
					//newid_caja=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ComprobanteFormaPago:Valor nulo no permitido en columna id_caja");
					}
				}

				this.id_caja=newid_caja;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setfecha_inicio(Date newfecha_inicio)throws Exception
	{
		try {
			if(this.fecha_inicio!=newfecha_inicio) {
				if(newfecha_inicio==null) {
					//newfecha_inicio=new Date();
					if(Constantes.ISDEVELOPING) {
						System.out.println("ComprobanteFormaPago:Valor nulo no permitido en columna fecha_inicio");
					}
				}

				this.fecha_inicio=newfecha_inicio;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setfecha_fin(Date newfecha_fin)throws Exception
	{
		try {
			if(this.fecha_fin!=newfecha_fin) {
				if(newfecha_fin==null) {
					//newfecha_fin=new Date();
					if(Constantes.ISDEVELOPING) {
						System.out.println("ComprobanteFormaPago:Valor nulo no permitido en columna fecha_fin");
					}
				}

				this.fecha_fin=newfecha_fin;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setnombre_caja(String newnombre_caja)throws Exception
	{
		try {
			if(this.nombre_caja!=newnombre_caja) {
				if(newnombre_caja==null) {
					//newnombre_caja="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("ComprobanteFormaPago:Valor nulo no permitido en columna nombre_caja");
					}
				}

				if(newnombre_caja!=null&&newnombre_caja.length()>100) {
					newnombre_caja=newnombre_caja.substring(0,98);
					System.out.println("ComprobanteFormaPago:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=100 en columna nombre_caja");
				}

				this.nombre_caja=newnombre_caja;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setsecuencial(String newsecuencial)throws Exception
	{
		try {
			if(this.secuencial!=newsecuencial) {
				if(newsecuencial==null) {
					//newsecuencial="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("ComprobanteFormaPago:Valor nulo no permitido en columna secuencial");
					}
				}

				if(newsecuencial!=null&&newsecuencial.length()>50) {
					newsecuencial=newsecuencial.substring(0,48);
					System.out.println("ComprobanteFormaPago:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=50 en columna secuencial");
				}

				this.secuencial=newsecuencial;
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
						System.out.println("ComprobanteFormaPago:Valor nulo no permitido en columna fecha");
					}
				}

				this.fecha=newfecha;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setcodigo_cliente(String newcodigo_cliente)throws Exception
	{
		try {
			if(this.codigo_cliente!=newcodigo_cliente) {
				if(newcodigo_cliente==null) {
					//newcodigo_cliente="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("ComprobanteFormaPago:Valor nulo no permitido en columna codigo_cliente");
					}
				}

				if(newcodigo_cliente!=null&&newcodigo_cliente.length()>20) {
					newcodigo_cliente=newcodigo_cliente.substring(0,18);
					System.out.println("ComprobanteFormaPago:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=20 en columna codigo_cliente");
				}

				this.codigo_cliente=newcodigo_cliente;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setnombre_cliente(String newnombre_cliente)throws Exception
	{
		try {
			if(this.nombre_cliente!=newnombre_cliente) {
				if(newnombre_cliente==null) {
					//newnombre_cliente="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("ComprobanteFormaPago:Valor nulo no permitido en columna nombre_cliente");
					}
				}

				if(newnombre_cliente!=null&&newnombre_cliente.length()>100) {
					newnombre_cliente=newnombre_cliente.substring(0,98);
					System.out.println("ComprobanteFormaPago:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=100 en columna nombre_cliente");
				}

				this.nombre_cliente=newnombre_cliente;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setsubtotal(Double newsubtotal)throws Exception
	{
		try {
			if(this.subtotal!=newsubtotal) {
				if(newsubtotal==null) {
					//newsubtotal=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ComprobanteFormaPago:Valor nulo no permitido en columna subtotal");
					}
				}

				this.subtotal=newsubtotal;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setiva(Double newiva)throws Exception
	{
		try {
			if(this.iva!=newiva) {
				if(newiva==null) {
					//newiva=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ComprobanteFormaPago:Valor nulo no permitido en columna iva");
					}
				}

				this.iva=newiva;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setdescuento(Double newdescuento)throws Exception
	{
		try {
			if(this.descuento!=newdescuento) {
				if(newdescuento==null) {
					//newdescuento=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ComprobanteFormaPago:Valor nulo no permitido en columna descuento");
					}
				}

				this.descuento=newdescuento;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setfinanciamiento(Double newfinanciamiento)throws Exception
	{
		try {
			if(this.financiamiento!=newfinanciamiento) {
				if(newfinanciamiento==null) {
					//newfinanciamiento=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ComprobanteFormaPago:Valor nulo no permitido en columna financiamiento");
					}
				}

				this.financiamiento=newfinanciamiento;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setflete(Double newflete)throws Exception
	{
		try {
			if(this.flete!=newflete) {
				if(newflete==null) {
					//newflete=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ComprobanteFormaPago:Valor nulo no permitido en columna flete");
					}
				}

				this.flete=newflete;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setice(Double newice)throws Exception
	{
		try {
			if(this.ice!=newice) {
				if(newice==null) {
					//newice=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ComprobanteFormaPago:Valor nulo no permitido en columna ice");
					}
				}

				this.ice=newice;
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
						System.out.println("ComprobanteFormaPago:Valor nulo no permitido en columna total");
					}
				}

				this.total=newtotal;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void settipo(String newtipo)throws Exception
	{
		try {
			if(this.tipo!=newtipo) {
				if(newtipo==null) {
					//newtipo="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("ComprobanteFormaPago:Valor nulo no permitido en columna tipo");
					}
				}

				if(newtipo!=null&&newtipo.length()>50) {
					newtipo=newtipo.substring(0,48);
					System.out.println("ComprobanteFormaPago:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=50 en columna tipo");
				}

				this.tipo=newtipo;
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
						System.out.println("ComprobanteFormaPago:Valor nulo no permitido en columna valor");
					}
				}

				this.valor=newvalor;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setfecha_forma_pago(Date newfecha_forma_pago)throws Exception
	{
		try {
			if(this.fecha_forma_pago!=newfecha_forma_pago) {
				if(newfecha_forma_pago==null) {
					//newfecha_forma_pago=new Date();
					if(Constantes.ISDEVELOPING) {
						System.out.println("ComprobanteFormaPago:Valor nulo no permitido en columna fecha_forma_pago");
					}
				}

				this.fecha_forma_pago=newfecha_forma_pago;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setnumero_cuenta(String newnumero_cuenta)throws Exception
	{
		try {
			if(this.numero_cuenta!=newnumero_cuenta) {
				if(newnumero_cuenta==null) {
					//newnumero_cuenta="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("ComprobanteFormaPago:Valor nulo no permitido en columna numero_cuenta");
					}
				}

				if(newnumero_cuenta!=null&&newnumero_cuenta.length()>50) {
					newnumero_cuenta=newnumero_cuenta.substring(0,48);
					System.out.println("ComprobanteFormaPago:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=50 en columna numero_cuenta");
				}

				this.numero_cuenta=newnumero_cuenta;
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
						System.out.println("ComprobanteFormaPago:Valor nulo no permitido en columna numero_cheque");
					}
				}

				if(newnumero_cheque!=null&&newnumero_cheque.length()>50) {
					newnumero_cheque=newnumero_cheque.substring(0,48);
					System.out.println("ComprobanteFormaPago:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=50 en columna numero_cheque");
				}

				this.numero_cheque=newnumero_cheque;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setgirador(String newgirador)throws Exception
	{
		try {
			if(this.girador!=newgirador) {
				if(newgirador==null) {
					//newgirador="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("ComprobanteFormaPago:Valor nulo no permitido en columna girador");
					}
				}

				if(newgirador!=null&&newgirador.length()>100) {
					newgirador=newgirador.substring(0,98);
					System.out.println("ComprobanteFormaPago:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=100 en columna girador");
				}

				this.girador=newgirador;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setnumero_dias_plazo(Integer newnumero_dias_plazo)throws Exception
	{
		try {
			if(this.numero_dias_plazo!=newnumero_dias_plazo) {
				if(newnumero_dias_plazo==null) {
					//newnumero_dias_plazo=0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ComprobanteFormaPago:Valor nulo no permitido en columna numero_dias_plazo");
					}
				}

				this.numero_dias_plazo=newnumero_dias_plazo;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setnumero_tarjeta(String newnumero_tarjeta)throws Exception
	{
		try {
			if(this.numero_tarjeta!=newnumero_tarjeta) {
				if(newnumero_tarjeta==null) {
					//newnumero_tarjeta="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("ComprobanteFormaPago:Valor nulo no permitido en columna numero_tarjeta");
					}
				}

				if(newnumero_tarjeta!=null&&newnumero_tarjeta.length()>50) {
					newnumero_tarjeta=newnumero_tarjeta.substring(0,48);
					System.out.println("ComprobanteFormaPago:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=50 en columna numero_tarjeta");
				}

				this.numero_tarjeta=newnumero_tarjeta;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setautorizacion(String newautorizacion)throws Exception
	{
		try {
			if(this.autorizacion!=newautorizacion) {
				if(newautorizacion==null) {
					//newautorizacion="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("ComprobanteFormaPago:Valor nulo no permitido en columna autorizacion");
					}
				}

				if(newautorizacion!=null&&newautorizacion.length()>100) {
					newautorizacion=newautorizacion.substring(0,98);
					System.out.println("ComprobanteFormaPago:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=100 en columna autorizacion");
				}

				this.autorizacion=newautorizacion;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setlote(String newlote)throws Exception
	{
		try {
			if(this.lote!=newlote) {
				if(newlote==null) {
					//newlote="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("ComprobanteFormaPago:Valor nulo no permitido en columna lote");
					}
				}

				if(newlote!=null&&newlote.length()>50) {
					newlote=newlote.substring(0,48);
					System.out.println("ComprobanteFormaPago:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=50 en columna lote");
				}

				this.lote=newlote;
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

	public Cliente getCliente() {
		return this.cliente;
	}

	public Caja getCaja() {
		return this.caja;
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

	public String getcaja_descripcion() {
		return this.caja_descripcion;
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


	public  void  setCaja(Caja caja) {
		try {
			this.caja=caja;
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


	public  void  setcaja_descripcion(String caja_descripcion) {
		try {
			this.caja_descripcion=caja_descripcion;
		} catch(Exception e) {
			;
		}
	}


	
	
	
	
	
	/*PARA REPORTES*/
	String id_empresa_descripcion="";String id_sucursal_descripcion="";String id_cliente_descripcion="";String id_caja_descripcion="";
	
	
	public String getid_empresa_descripcion() {
		return id_empresa_descripcion;
	}
	public String getid_sucursal_descripcion() {
		return id_sucursal_descripcion;
	}
	public String getid_cliente_descripcion() {
		return id_cliente_descripcion;
	}
	public String getid_caja_descripcion() {
		return id_caja_descripcion;
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
	public void setid_caja_descripcion(String newid_caja_descripcion)throws Exception {
		try {
			this.id_caja_descripcion=newid_caja_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	
	public void inicializarVariablesParaReporte() {
		this.id_empresa_descripcion="";this.id_sucursal_descripcion="";this.id_cliente_descripcion="";this.id_caja_descripcion="";
	}
	
	
	
	
	
	
	/*PARA REPORTES FIN*/		
}

