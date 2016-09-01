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
package com.bydan.erp.cartera.business.entity;

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
//import com.bydan.erp.cartera.util.BalanceGeneralClienteConstantesFunciones;
import com.bydan.erp.cartera.util.*;


import com.bydan.erp.seguridad.util.*;



import com.bydan.erp.seguridad.business.entity.*;




@SuppressWarnings("unused")
public class BalanceGeneralCliente extends BalanceGeneralClienteAdditional implements Serializable ,Cloneable {//BalanceGeneralClienteAdditional,GeneralEntity
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
	
	private BalanceGeneralCliente balancegeneralclienteOriginal;
	
	private Map<String, Object> mapBalanceGeneralCliente;
			
	public Map<String, Object> getMapBalanceGeneralCliente() {
		return mapBalanceGeneralCliente;
	}

	public void setMapBalanceGeneralCliente(Map<String, Object> mapBalanceGeneralCliente) {
		this.mapBalanceGeneralCliente = mapBalanceGeneralCliente;
	}
	
	public void inicializarMapBalanceGeneralCliente() {
		this.mapBalanceGeneralCliente = new HashMap<String,Object>();
	}
	
	public void setMapBalanceGeneralClienteValue(String sKey,Object oValue) {
		this.mapBalanceGeneralCliente.put(sKey, oValue);
	}
	
	public Object getMapBalanceGeneralClienteValue(String sKey) {
		return this.mapBalanceGeneralCliente.get(sKey);
	}
	
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_empresa;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_cliente;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double caja_bancos_disponible;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double cuentas_por_cobrar_clientes;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double inventario;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double otros_activos_corrientes;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double total_activos_corrientes;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double bienes_inmuebles;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double bienes_muebles;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double otros_activos_no_corrientes;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double total_activos_no_corrientes;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double ventas_mensuales;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double costo_ventas_mensuales;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double utilidad_bruta;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double gastos_operativos;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double sueldos;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double servicios;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double arriendos;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double impuestos;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double utilidad_operativa;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double gastos_familiares;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double excedente_antes_dividendos;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double dividendos_bancos_otros;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double exedente_neto_mensual;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double deudas_bancarias;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double cuentas_por_pagar;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double anticipos_recibos;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double otras_cuentas_por_pagar;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double otras_deudas_familiares;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double total_pasivo_corriente;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double deudas_bancarias_largo_plazo;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double otros_pasivos_largo_plazo;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double total_pasivo_no_corriente;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double total_pasivo;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double patrimonio;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=150,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=BalanceGeneralClienteConstantesFunciones.SREGEXDESCRIPCION,message=BalanceGeneralClienteConstantesFunciones.SMENSAJEREGEXDESCRIPCION)
	private String descripcion;
			
	
	public Empresa empresa;
	public Cliente cliente;
	
	
	private String empresa_descripcion;
	private String cliente_descripcion;
	
	
		
	public BalanceGeneralCliente () throws Exception {
		super();		
		
		this.id=0L;
		
		
		this.versionRow=new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());//new Date();
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		this.sType="NONE";
		
		this.balancegeneralclienteOriginal=this;
		
 		this.id_empresa=-1L;
 		this.id_cliente=-1L;
 		this.caja_bancos_disponible=0.0;
 		this.cuentas_por_cobrar_clientes=0.0;
 		this.inventario=0.0;
 		this.otros_activos_corrientes=0.0;
 		this.total_activos_corrientes=0.0;
 		this.bienes_inmuebles=0.0;
 		this.bienes_muebles=0.0;
 		this.otros_activos_no_corrientes=0.0;
 		this.total_activos_no_corrientes=0.0;
 		this.ventas_mensuales=0.0;
 		this.costo_ventas_mensuales=0.0;
 		this.utilidad_bruta=0.0;
 		this.gastos_operativos=0.0;
 		this.sueldos=0.0;
 		this.servicios=0.0;
 		this.arriendos=0.0;
 		this.impuestos=0.0;
 		this.utilidad_operativa=0.0;
 		this.gastos_familiares=0.0;
 		this.excedente_antes_dividendos=0.0;
 		this.dividendos_bancos_otros=0.0;
 		this.exedente_neto_mensual=0.0;
 		this.deudas_bancarias=0.0;
 		this.cuentas_por_pagar=0.0;
 		this.anticipos_recibos=0.0;
 		this.otras_cuentas_por_pagar=0.0;
 		this.otras_deudas_familiares=0.0;
 		this.total_pasivo_corriente=0.0;
 		this.deudas_bancarias_largo_plazo=0.0;
 		this.otros_pasivos_largo_plazo=0.0;
 		this.total_pasivo_no_corriente=0.0;
 		this.total_pasivo=0.0;
 		this.patrimonio=0.0;
 		this.descripcion="";
		
		
		this.empresa=null;
		this.cliente=null;
		
		
		this.empresa_descripcion="";
		this.cliente_descripcion="";
		
		
		
			
		
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
    //PARA REPORTES
	public BalanceGeneralCliente (Long id,Date versionRow,Long id_empresa,Long id_cliente,Double caja_bancos_disponible,Double cuentas_por_cobrar_clientes,Double inventario,Double otros_activos_corrientes,Double total_activos_corrientes,Double bienes_inmuebles,Double bienes_muebles,Double otros_activos_no_corrientes,Double total_activos_no_corrientes,Double ventas_mensuales,Double costo_ventas_mensuales,Double utilidad_bruta,Double gastos_operativos,Double sueldos,Double servicios,Double arriendos,Double impuestos,Double utilidad_operativa,Double gastos_familiares,Double excedente_antes_dividendos,Double dividendos_bancos_otros,Double exedente_neto_mensual,Double deudas_bancarias,Double cuentas_por_pagar,Double anticipos_recibos,Double otras_cuentas_por_pagar,Double otras_deudas_familiares,Double total_pasivo_corriente,Double deudas_bancarias_largo_plazo,Double otros_pasivos_largo_plazo,Double total_pasivo_no_corriente,Double total_pasivo,Double patrimonio,String descripcion) throws Exception {
		super();		
		
		this.id=id;
		this.versionRow=versionRow;
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.balancegeneralclienteOriginal=this;
		
 		this.id_empresa=id_empresa;
 		this.id_cliente=id_cliente;
 		this.caja_bancos_disponible=caja_bancos_disponible;
 		this.cuentas_por_cobrar_clientes=cuentas_por_cobrar_clientes;
 		this.inventario=inventario;
 		this.otros_activos_corrientes=otros_activos_corrientes;
 		this.total_activos_corrientes=total_activos_corrientes;
 		this.bienes_inmuebles=bienes_inmuebles;
 		this.bienes_muebles=bienes_muebles;
 		this.otros_activos_no_corrientes=otros_activos_no_corrientes;
 		this.total_activos_no_corrientes=total_activos_no_corrientes;
 		this.ventas_mensuales=ventas_mensuales;
 		this.costo_ventas_mensuales=costo_ventas_mensuales;
 		this.utilidad_bruta=utilidad_bruta;
 		this.gastos_operativos=gastos_operativos;
 		this.sueldos=sueldos;
 		this.servicios=servicios;
 		this.arriendos=arriendos;
 		this.impuestos=impuestos;
 		this.utilidad_operativa=utilidad_operativa;
 		this.gastos_familiares=gastos_familiares;
 		this.excedente_antes_dividendos=excedente_antes_dividendos;
 		this.dividendos_bancos_otros=dividendos_bancos_otros;
 		this.exedente_neto_mensual=exedente_neto_mensual;
 		this.deudas_bancarias=deudas_bancarias;
 		this.cuentas_por_pagar=cuentas_por_pagar;
 		this.anticipos_recibos=anticipos_recibos;
 		this.otras_cuentas_por_pagar=otras_cuentas_por_pagar;
 		this.otras_deudas_familiares=otras_deudas_familiares;
 		this.total_pasivo_corriente=total_pasivo_corriente;
 		this.deudas_bancarias_largo_plazo=deudas_bancarias_largo_plazo;
 		this.otros_pasivos_largo_plazo=otros_pasivos_largo_plazo;
 		this.total_pasivo_no_corriente=total_pasivo_no_corriente;
 		this.total_pasivo=total_pasivo;
 		this.patrimonio=patrimonio;
 		this.descripcion=descripcion;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	 //PARA REPORTES
	public BalanceGeneralCliente (Long id_empresa,Long id_cliente,Double caja_bancos_disponible,Double cuentas_por_cobrar_clientes,Double inventario,Double otros_activos_corrientes,Double total_activos_corrientes,Double bienes_inmuebles,Double bienes_muebles,Double otros_activos_no_corrientes,Double total_activos_no_corrientes,Double ventas_mensuales,Double costo_ventas_mensuales,Double utilidad_bruta,Double gastos_operativos,Double sueldos,Double servicios,Double arriendos,Double impuestos,Double utilidad_operativa,Double gastos_familiares,Double excedente_antes_dividendos,Double dividendos_bancos_otros,Double exedente_neto_mensual,Double deudas_bancarias,Double cuentas_por_pagar,Double anticipos_recibos,Double otras_cuentas_por_pagar,Double otras_deudas_familiares,Double total_pasivo_corriente,Double deudas_bancarias_largo_plazo,Double otros_pasivos_largo_plazo,Double total_pasivo_no_corriente,Double total_pasivo,Double patrimonio,String descripcion) throws Exception {
		super();		
		
		this.id=0L;
		this.versionRow=new Date();
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.balancegeneralclienteOriginal=this;
		
 		this.id_empresa=id_empresa;
 		this.id_cliente=id_cliente;
 		this.caja_bancos_disponible=caja_bancos_disponible;
 		this.cuentas_por_cobrar_clientes=cuentas_por_cobrar_clientes;
 		this.inventario=inventario;
 		this.otros_activos_corrientes=otros_activos_corrientes;
 		this.total_activos_corrientes=total_activos_corrientes;
 		this.bienes_inmuebles=bienes_inmuebles;
 		this.bienes_muebles=bienes_muebles;
 		this.otros_activos_no_corrientes=otros_activos_no_corrientes;
 		this.total_activos_no_corrientes=total_activos_no_corrientes;
 		this.ventas_mensuales=ventas_mensuales;
 		this.costo_ventas_mensuales=costo_ventas_mensuales;
 		this.utilidad_bruta=utilidad_bruta;
 		this.gastos_operativos=gastos_operativos;
 		this.sueldos=sueldos;
 		this.servicios=servicios;
 		this.arriendos=arriendos;
 		this.impuestos=impuestos;
 		this.utilidad_operativa=utilidad_operativa;
 		this.gastos_familiares=gastos_familiares;
 		this.excedente_antes_dividendos=excedente_antes_dividendos;
 		this.dividendos_bancos_otros=dividendos_bancos_otros;
 		this.exedente_neto_mensual=exedente_neto_mensual;
 		this.deudas_bancarias=deudas_bancarias;
 		this.cuentas_por_pagar=cuentas_por_pagar;
 		this.anticipos_recibos=anticipos_recibos;
 		this.otras_cuentas_por_pagar=otras_cuentas_por_pagar;
 		this.otras_deudas_familiares=otras_deudas_familiares;
 		this.total_pasivo_corriente=total_pasivo_corriente;
 		this.deudas_bancarias_largo_plazo=deudas_bancarias_largo_plazo;
 		this.otros_pasivos_largo_plazo=otros_pasivos_largo_plazo;
 		this.total_pasivo_no_corriente=total_pasivo_no_corriente;
 		this.total_pasivo=total_pasivo;
 		this.patrimonio=patrimonio;
 		this.descripcion=descripcion;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	public boolean equals(Object object) {
		boolean equal=false;
		BalanceGeneralCliente balancegeneralclienteLocal=null;
		
		if(object!=null) {
			balancegeneralclienteLocal=(BalanceGeneralCliente)object;
			
			if(balancegeneralclienteLocal!=null) {
				if(this.getId()!=null && balancegeneralclienteLocal.getId()!=null) {
					if(this.getId().equals(balancegeneralclienteLocal.getId())) {
						equal=true;
					}
				}
			}
		}
		
		return equal;
	}
	
	public String toString() {
		String sDetalle="";
		
		if(!BalanceGeneralClienteConstantesFunciones.CON_DESCRIPCION_DETALLADO) {
        	sDetalle=BalanceGeneralClienteConstantesFunciones.getBalanceGeneralClienteDescripcion(this);
		} else {
			sDetalle=BalanceGeneralClienteConstantesFunciones.getBalanceGeneralClienteDescripcionDetallado(this);
		}
		
		return sDetalle;
    }
	
	public BalanceGeneralCliente getBalanceGeneralClienteOriginal() {
		return this.balancegeneralclienteOriginal;
	}
	
	public void setBalanceGeneralClienteOriginal(BalanceGeneralCliente balancegeneralcliente) {
		try {
			this.balancegeneralclienteOriginal=balancegeneralcliente;
		} catch(Exception e) {
			;
		}
	}
	
	
	protected BalanceGeneralClienteAdditional balancegeneralclienteAdditional=null;
	
	public BalanceGeneralClienteAdditional getBalanceGeneralClienteAdditional() {
		return this.balancegeneralclienteAdditional;
	}
	
	public void setBalanceGeneralClienteAdditional(BalanceGeneralClienteAdditional balancegeneralclienteAdditional) {
		try {
			this.balancegeneralclienteAdditional=balancegeneralclienteAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
    
	
	public Long getid_empresa() {
		return this.id_empresa;
	}
    
	
	public Long getid_cliente() {
		return this.id_cliente;
	}
    
	
	public Double getcaja_bancos_disponible() {
		return this.caja_bancos_disponible;
	}
    
	
	public Double getcuentas_por_cobrar_clientes() {
		return this.cuentas_por_cobrar_clientes;
	}
    
	
	public Double getinventario() {
		return this.inventario;
	}
    
	
	public Double getotros_activos_corrientes() {
		return this.otros_activos_corrientes;
	}
    
	
	public Double gettotal_activos_corrientes() {
		return this.total_activos_corrientes;
	}
    
	
	public Double getbienes_inmuebles() {
		return this.bienes_inmuebles;
	}
    
	
	public Double getbienes_muebles() {
		return this.bienes_muebles;
	}
    
	
	public Double getotros_activos_no_corrientes() {
		return this.otros_activos_no_corrientes;
	}
    
	
	public Double gettotal_activos_no_corrientes() {
		return this.total_activos_no_corrientes;
	}
    
	
	public Double getventas_mensuales() {
		return this.ventas_mensuales;
	}
    
	
	public Double getcosto_ventas_mensuales() {
		return this.costo_ventas_mensuales;
	}
    
	
	public Double getutilidad_bruta() {
		return this.utilidad_bruta;
	}
    
	
	public Double getgastos_operativos() {
		return this.gastos_operativos;
	}
    
	
	public Double getsueldos() {
		return this.sueldos;
	}
    
	
	public Double getservicios() {
		return this.servicios;
	}
    
	
	public Double getarriendos() {
		return this.arriendos;
	}
    
	
	public Double getimpuestos() {
		return this.impuestos;
	}
    
	
	public Double getutilidad_operativa() {
		return this.utilidad_operativa;
	}
    
	
	public Double getgastos_familiares() {
		return this.gastos_familiares;
	}
    
	
	public Double getexcedente_antes_dividendos() {
		return this.excedente_antes_dividendos;
	}
    
	
	public Double getdividendos_bancos_otros() {
		return this.dividendos_bancos_otros;
	}
    
	
	public Double getexedente_neto_mensual() {
		return this.exedente_neto_mensual;
	}
    
	
	public Double getdeudas_bancarias() {
		return this.deudas_bancarias;
	}
    
	
	public Double getcuentas_por_pagar() {
		return this.cuentas_por_pagar;
	}
    
	
	public Double getanticipos_recibos() {
		return this.anticipos_recibos;
	}
    
	
	public Double getotras_cuentas_por_pagar() {
		return this.otras_cuentas_por_pagar;
	}
    
	
	public Double getotras_deudas_familiares() {
		return this.otras_deudas_familiares;
	}
    
	
	public Double gettotal_pasivo_corriente() {
		return this.total_pasivo_corriente;
	}
    
	
	public Double getdeudas_bancarias_largo_plazo() {
		return this.deudas_bancarias_largo_plazo;
	}
    
	
	public Double getotros_pasivos_largo_plazo() {
		return this.otros_pasivos_largo_plazo;
	}
    
	
	public Double gettotal_pasivo_no_corriente() {
		return this.total_pasivo_no_corriente;
	}
    
	
	public Double gettotal_pasivo() {
		return this.total_pasivo;
	}
    
	
	public Double getpatrimonio() {
		return this.patrimonio;
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
						System.out.println("BalanceGeneralCliente:Valor nulo no permitido en columna id_empresa");
					}
				}

				this.id_empresa=newid_empresa;
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
						System.out.println("BalanceGeneralCliente:Valor nulo no permitido en columna id_cliente");
					}
				}

				this.id_cliente=newid_cliente;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setcaja_bancos_disponible(Double newcaja_bancos_disponible)throws Exception
	{
		try {
			if(this.caja_bancos_disponible!=newcaja_bancos_disponible) {
				if(newcaja_bancos_disponible==null) {
					//newcaja_bancos_disponible=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("BalanceGeneralCliente:Valor nulo no permitido en columna caja_bancos_disponible");
					}
				}

				this.caja_bancos_disponible=newcaja_bancos_disponible;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setcuentas_por_cobrar_clientes(Double newcuentas_por_cobrar_clientes)throws Exception
	{
		try {
			if(this.cuentas_por_cobrar_clientes!=newcuentas_por_cobrar_clientes) {
				if(newcuentas_por_cobrar_clientes==null) {
					//newcuentas_por_cobrar_clientes=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("BalanceGeneralCliente:Valor nulo no permitido en columna cuentas_por_cobrar_clientes");
					}
				}

				this.cuentas_por_cobrar_clientes=newcuentas_por_cobrar_clientes;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setinventario(Double newinventario)throws Exception
	{
		try {
			if(this.inventario!=newinventario) {
				if(newinventario==null) {
					//newinventario=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("BalanceGeneralCliente:Valor nulo no permitido en columna inventario");
					}
				}

				this.inventario=newinventario;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setotros_activos_corrientes(Double newotros_activos_corrientes)throws Exception
	{
		try {
			if(this.otros_activos_corrientes!=newotros_activos_corrientes) {
				if(newotros_activos_corrientes==null) {
					//newotros_activos_corrientes=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("BalanceGeneralCliente:Valor nulo no permitido en columna otros_activos_corrientes");
					}
				}

				this.otros_activos_corrientes=newotros_activos_corrientes;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void settotal_activos_corrientes(Double newtotal_activos_corrientes)throws Exception
	{
		try {
			if(this.total_activos_corrientes!=newtotal_activos_corrientes) {
				if(newtotal_activos_corrientes==null) {
					//newtotal_activos_corrientes=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("BalanceGeneralCliente:Valor nulo no permitido en columna total_activos_corrientes");
					}
				}

				this.total_activos_corrientes=newtotal_activos_corrientes;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setbienes_inmuebles(Double newbienes_inmuebles)throws Exception
	{
		try {
			if(this.bienes_inmuebles!=newbienes_inmuebles) {
				if(newbienes_inmuebles==null) {
					//newbienes_inmuebles=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("BalanceGeneralCliente:Valor nulo no permitido en columna bienes_inmuebles");
					}
				}

				this.bienes_inmuebles=newbienes_inmuebles;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setbienes_muebles(Double newbienes_muebles)throws Exception
	{
		try {
			if(this.bienes_muebles!=newbienes_muebles) {
				if(newbienes_muebles==null) {
					//newbienes_muebles=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("BalanceGeneralCliente:Valor nulo no permitido en columna bienes_muebles");
					}
				}

				this.bienes_muebles=newbienes_muebles;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setotros_activos_no_corrientes(Double newotros_activos_no_corrientes)throws Exception
	{
		try {
			if(this.otros_activos_no_corrientes!=newotros_activos_no_corrientes) {
				if(newotros_activos_no_corrientes==null) {
					//newotros_activos_no_corrientes=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("BalanceGeneralCliente:Valor nulo no permitido en columna otros_activos_no_corrientes");
					}
				}

				this.otros_activos_no_corrientes=newotros_activos_no_corrientes;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void settotal_activos_no_corrientes(Double newtotal_activos_no_corrientes)throws Exception
	{
		try {
			if(this.total_activos_no_corrientes!=newtotal_activos_no_corrientes) {
				if(newtotal_activos_no_corrientes==null) {
					//newtotal_activos_no_corrientes=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("BalanceGeneralCliente:Valor nulo no permitido en columna total_activos_no_corrientes");
					}
				}

				this.total_activos_no_corrientes=newtotal_activos_no_corrientes;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setventas_mensuales(Double newventas_mensuales)throws Exception
	{
		try {
			if(this.ventas_mensuales!=newventas_mensuales) {
				if(newventas_mensuales==null) {
					//newventas_mensuales=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("BalanceGeneralCliente:Valor nulo no permitido en columna ventas_mensuales");
					}
				}

				this.ventas_mensuales=newventas_mensuales;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setcosto_ventas_mensuales(Double newcosto_ventas_mensuales)throws Exception
	{
		try {
			if(this.costo_ventas_mensuales!=newcosto_ventas_mensuales) {
				if(newcosto_ventas_mensuales==null) {
					//newcosto_ventas_mensuales=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("BalanceGeneralCliente:Valor nulo no permitido en columna costo_ventas_mensuales");
					}
				}

				this.costo_ventas_mensuales=newcosto_ventas_mensuales;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setutilidad_bruta(Double newutilidad_bruta)throws Exception
	{
		try {
			if(this.utilidad_bruta!=newutilidad_bruta) {
				if(newutilidad_bruta==null) {
					//newutilidad_bruta=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("BalanceGeneralCliente:Valor nulo no permitido en columna utilidad_bruta");
					}
				}

				this.utilidad_bruta=newutilidad_bruta;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setgastos_operativos(Double newgastos_operativos)throws Exception
	{
		try {
			if(this.gastos_operativos!=newgastos_operativos) {
				if(newgastos_operativos==null) {
					//newgastos_operativos=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("BalanceGeneralCliente:Valor nulo no permitido en columna gastos_operativos");
					}
				}

				this.gastos_operativos=newgastos_operativos;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setsueldos(Double newsueldos)throws Exception
	{
		try {
			if(this.sueldos!=newsueldos) {
				if(newsueldos==null) {
					//newsueldos=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("BalanceGeneralCliente:Valor nulo no permitido en columna sueldos");
					}
				}

				this.sueldos=newsueldos;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setservicios(Double newservicios)throws Exception
	{
		try {
			if(this.servicios!=newservicios) {
				if(newservicios==null) {
					//newservicios=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("BalanceGeneralCliente:Valor nulo no permitido en columna servicios");
					}
				}

				this.servicios=newservicios;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setarriendos(Double newarriendos)throws Exception
	{
		try {
			if(this.arriendos!=newarriendos) {
				if(newarriendos==null) {
					//newarriendos=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("BalanceGeneralCliente:Valor nulo no permitido en columna arriendos");
					}
				}

				this.arriendos=newarriendos;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setimpuestos(Double newimpuestos)throws Exception
	{
		try {
			if(this.impuestos!=newimpuestos) {
				if(newimpuestos==null) {
					//newimpuestos=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("BalanceGeneralCliente:Valor nulo no permitido en columna impuestos");
					}
				}

				this.impuestos=newimpuestos;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setutilidad_operativa(Double newutilidad_operativa)throws Exception
	{
		try {
			if(this.utilidad_operativa!=newutilidad_operativa) {
				if(newutilidad_operativa==null) {
					//newutilidad_operativa=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("BalanceGeneralCliente:Valor nulo no permitido en columna utilidad_operativa");
					}
				}

				this.utilidad_operativa=newutilidad_operativa;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setgastos_familiares(Double newgastos_familiares)throws Exception
	{
		try {
			if(this.gastos_familiares!=newgastos_familiares) {
				if(newgastos_familiares==null) {
					//newgastos_familiares=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("BalanceGeneralCliente:Valor nulo no permitido en columna gastos_familiares");
					}
				}

				this.gastos_familiares=newgastos_familiares;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setexcedente_antes_dividendos(Double newexcedente_antes_dividendos)throws Exception
	{
		try {
			if(this.excedente_antes_dividendos!=newexcedente_antes_dividendos) {
				if(newexcedente_antes_dividendos==null) {
					//newexcedente_antes_dividendos=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("BalanceGeneralCliente:Valor nulo no permitido en columna excedente_antes_dividendos");
					}
				}

				this.excedente_antes_dividendos=newexcedente_antes_dividendos;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setdividendos_bancos_otros(Double newdividendos_bancos_otros)throws Exception
	{
		try {
			if(this.dividendos_bancos_otros!=newdividendos_bancos_otros) {
				if(newdividendos_bancos_otros==null) {
					//newdividendos_bancos_otros=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("BalanceGeneralCliente:Valor nulo no permitido en columna dividendos_bancos_otros");
					}
				}

				this.dividendos_bancos_otros=newdividendos_bancos_otros;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setexedente_neto_mensual(Double newexedente_neto_mensual)throws Exception
	{
		try {
			if(this.exedente_neto_mensual!=newexedente_neto_mensual) {
				if(newexedente_neto_mensual==null) {
					//newexedente_neto_mensual=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("BalanceGeneralCliente:Valor nulo no permitido en columna exedente_neto_mensual");
					}
				}

				this.exedente_neto_mensual=newexedente_neto_mensual;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setdeudas_bancarias(Double newdeudas_bancarias)throws Exception
	{
		try {
			if(this.deudas_bancarias!=newdeudas_bancarias) {
				if(newdeudas_bancarias==null) {
					//newdeudas_bancarias=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("BalanceGeneralCliente:Valor nulo no permitido en columna deudas_bancarias");
					}
				}

				this.deudas_bancarias=newdeudas_bancarias;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setcuentas_por_pagar(Double newcuentas_por_pagar)throws Exception
	{
		try {
			if(this.cuentas_por_pagar!=newcuentas_por_pagar) {
				if(newcuentas_por_pagar==null) {
					//newcuentas_por_pagar=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("BalanceGeneralCliente:Valor nulo no permitido en columna cuentas_por_pagar");
					}
				}

				this.cuentas_por_pagar=newcuentas_por_pagar;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setanticipos_recibos(Double newanticipos_recibos)throws Exception
	{
		try {
			if(this.anticipos_recibos!=newanticipos_recibos) {
				if(newanticipos_recibos==null) {
					//newanticipos_recibos=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("BalanceGeneralCliente:Valor nulo no permitido en columna anticipos_recibos");
					}
				}

				this.anticipos_recibos=newanticipos_recibos;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setotras_cuentas_por_pagar(Double newotras_cuentas_por_pagar)throws Exception
	{
		try {
			if(this.otras_cuentas_por_pagar!=newotras_cuentas_por_pagar) {
				if(newotras_cuentas_por_pagar==null) {
					//newotras_cuentas_por_pagar=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("BalanceGeneralCliente:Valor nulo no permitido en columna otras_cuentas_por_pagar");
					}
				}

				this.otras_cuentas_por_pagar=newotras_cuentas_por_pagar;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setotras_deudas_familiares(Double newotras_deudas_familiares)throws Exception
	{
		try {
			if(this.otras_deudas_familiares!=newotras_deudas_familiares) {
				if(newotras_deudas_familiares==null) {
					//newotras_deudas_familiares=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("BalanceGeneralCliente:Valor nulo no permitido en columna otras_deudas_familiares");
					}
				}

				this.otras_deudas_familiares=newotras_deudas_familiares;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void settotal_pasivo_corriente(Double newtotal_pasivo_corriente)throws Exception
	{
		try {
			if(this.total_pasivo_corriente!=newtotal_pasivo_corriente) {
				if(newtotal_pasivo_corriente==null) {
					//newtotal_pasivo_corriente=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("BalanceGeneralCliente:Valor nulo no permitido en columna total_pasivo_corriente");
					}
				}

				this.total_pasivo_corriente=newtotal_pasivo_corriente;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setdeudas_bancarias_largo_plazo(Double newdeudas_bancarias_largo_plazo)throws Exception
	{
		try {
			if(this.deudas_bancarias_largo_plazo!=newdeudas_bancarias_largo_plazo) {
				if(newdeudas_bancarias_largo_plazo==null) {
					//newdeudas_bancarias_largo_plazo=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("BalanceGeneralCliente:Valor nulo no permitido en columna deudas_bancarias_largo_plazo");
					}
				}

				this.deudas_bancarias_largo_plazo=newdeudas_bancarias_largo_plazo;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setotros_pasivos_largo_plazo(Double newotros_pasivos_largo_plazo)throws Exception
	{
		try {
			if(this.otros_pasivos_largo_plazo!=newotros_pasivos_largo_plazo) {
				if(newotros_pasivos_largo_plazo==null) {
					//newotros_pasivos_largo_plazo=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("BalanceGeneralCliente:Valor nulo no permitido en columna otros_pasivos_largo_plazo");
					}
				}

				this.otros_pasivos_largo_plazo=newotros_pasivos_largo_plazo;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void settotal_pasivo_no_corriente(Double newtotal_pasivo_no_corriente)throws Exception
	{
		try {
			if(this.total_pasivo_no_corriente!=newtotal_pasivo_no_corriente) {
				if(newtotal_pasivo_no_corriente==null) {
					//newtotal_pasivo_no_corriente=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("BalanceGeneralCliente:Valor nulo no permitido en columna total_pasivo_no_corriente");
					}
				}

				this.total_pasivo_no_corriente=newtotal_pasivo_no_corriente;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void settotal_pasivo(Double newtotal_pasivo)throws Exception
	{
		try {
			if(this.total_pasivo!=newtotal_pasivo) {
				if(newtotal_pasivo==null) {
					//newtotal_pasivo=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("BalanceGeneralCliente:Valor nulo no permitido en columna total_pasivo");
					}
				}

				this.total_pasivo=newtotal_pasivo;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setpatrimonio(Double newpatrimonio)throws Exception
	{
		try {
			if(this.patrimonio!=newpatrimonio) {
				if(newpatrimonio==null) {
					//newpatrimonio=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("BalanceGeneralCliente:Valor nulo no permitido en columna patrimonio");
					}
				}

				this.patrimonio=newpatrimonio;
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
						System.out.println("BalanceGeneralCliente:Valor nulo no permitido en columna descripcion");
					}
				}

				if(newdescripcion!=null&&newdescripcion.length()>150) {
					newdescripcion=newdescripcion.substring(0,148);
					System.out.println("BalanceGeneralCliente:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=150 en columna descripcion");
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

	public Cliente getCliente() {
		return this.cliente;
	}

	
	
	public String getempresa_descripcion() {
		return this.empresa_descripcion;
	}

	public String getcliente_descripcion() {
		return this.cliente_descripcion;
	}

	
	
	public  void  setEmpresa(Empresa empresa) {
		try {
			this.empresa=empresa;
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


	
	
	public  void  setempresa_descripcion(String empresa_descripcion) {
		try {
			this.empresa_descripcion=empresa_descripcion;
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


	
	
	
	
	
	/*PARA REPORTES*/
	String id_empresa_descripcion="";String id_cliente_descripcion="";
	
	
	public String getid_empresa_descripcion() {
		return id_empresa_descripcion;
	}
	public String getid_cliente_descripcion() {
		return id_cliente_descripcion;
	}
	
	
	public void setid_empresa_descripcion(String newid_empresa_descripcion)throws Exception {
		try {
			this.id_empresa_descripcion=newid_empresa_descripcion;
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
	
	public void inicializarVariablesParaReporte() {
		this.id_empresa_descripcion="";this.id_cliente_descripcion="";
	}
	
	
	
	
	
	
	/*PARA REPORTES FIN*/		
}

