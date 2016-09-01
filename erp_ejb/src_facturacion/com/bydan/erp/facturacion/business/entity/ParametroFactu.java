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
//import com.bydan.erp.facturacion.util.ParametroFactuConstantesFunciones;
import com.bydan.erp.facturacion.util.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.contabilidad.util.*;



import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;




@SuppressWarnings("unused")
public class ParametroFactu extends ParametroFactuAdditional implements Serializable ,Cloneable {//ParametroFactuAdditional,GeneralEntity
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
	
	private ParametroFactu parametrofactuOriginal;
	
	private Map<String, Object> mapParametroFactu;
			
	public Map<String, Object> getMapParametroFactu() {
		return mapParametroFactu;
	}

	public void setMapParametroFactu(Map<String, Object> mapParametroFactu) {
		this.mapParametroFactu = mapParametroFactu;
	}
	
	public void inicializarMapParametroFactu() {
		this.mapParametroFactu = new HashMap<String,Object>();
	}
	
	public void setMapParametroFactuValue(String sKey,Object oValue) {
		this.mapParametroFactu.put(sKey, oValue);
	}
	
	public Object getMapParametroFactuValue(String sKey) {
		return this.mapParametroFactu.get(sKey);
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
	private Long id_cuenta_contable_factu;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_cuenta_contable_finan;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_cuenta_contable_otro;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_formato_proforma;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_formato_pedido;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_formato_factura;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_formato_nota_credito;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_formato_inventario;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=50,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=ParametroFactuConstantesFunciones.SREGEXSECUENCIAL_PROFORMA,message=ParametroFactuConstantesFunciones.SMENSAJEREGEXSECUENCIAL_PROFORMA)
	private String secuencial_proforma;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=50,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=ParametroFactuConstantesFunciones.SREGEXSECUANCIAL_PEDIDO,message=ParametroFactuConstantesFunciones.SMENSAJEREGEXSECUANCIAL_PEDIDO)
	private String secuancial_pedido;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=50,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=ParametroFactuConstantesFunciones.SREGEXSECUENCIAL_FACTURA,message=ParametroFactuConstantesFunciones.SMENSAJEREGEXSECUENCIAL_FACTURA)
	private String secuencial_factura;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=50,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=ParametroFactuConstantesFunciones.SREGEXSECUENCIAL_NOTA_CREDITO,message=ParametroFactuConstantesFunciones.SMENSAJEREGEXSECUENCIAL_NOTA_CREDITO)
	private String secuencial_nota_credito;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=10,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONINT)
	private Integer item_proforma;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=10,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONINT)
	private Integer item_pedido;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=10,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONINT)
	private Integer item_factura;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=10,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONINT)
	private Integer item_nota_credito;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=10,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONINT)
	private Integer item_inventario;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Boolean con_detalle_proforma;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Boolean con_detalle_pedido;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Boolean con_detalle_factura;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Boolean con_detalle_nota_credito;
			
	
	public Empresa empresa;
	public Sucursal sucursal;
	public CuentaContable cuentacontablefactu;
	public CuentaContable cuentacontablefinan;
	public CuentaContable cuentacontableotro;
	public Formato formatoproforma;
	public Formato formatopedido;
	public Formato formatofactura;
	public Formato formatonotacredito;
	public Formato formatoinventario;
	
	
	private String empresa_descripcion;
	private String sucursal_descripcion;
	private String cuentacontablefactu_descripcion;
	private String cuentacontablefinan_descripcion;
	private String cuentacontableotro_descripcion;
	private String formatoproforma_descripcion;
	private String formatopedido_descripcion;
	private String formatofactura_descripcion;
	private String formatonotacredito_descripcion;
	private String formatoinventario_descripcion;
	
	
		
	public ParametroFactu () throws Exception {
		super();		
		
		this.id=0L;
		
		
		this.versionRow=new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());//new Date();
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		this.sType="NONE";
		
		this.parametrofactuOriginal=this;
		
 		this.id_empresa=-1L;
 		this.id_sucursal=-1L;
 		this.id_cuenta_contable_factu=-1L;
 		this.id_cuenta_contable_finan=-1L;
 		this.id_cuenta_contable_otro=-1L;
 		this.id_formato_proforma=-1L;
 		this.id_formato_pedido=-1L;
 		this.id_formato_factura=-1L;
 		this.id_formato_nota_credito=-1L;
 		this.id_formato_inventario=-1L;
 		this.secuencial_proforma="";
 		this.secuancial_pedido="";
 		this.secuencial_factura="";
 		this.secuencial_nota_credito="";
 		this.item_proforma=0;
 		this.item_pedido=0;
 		this.item_factura=0;
 		this.item_nota_credito=0;
 		this.item_inventario=0;
 		this.con_detalle_proforma=false;
 		this.con_detalle_pedido=false;
 		this.con_detalle_factura=false;
 		this.con_detalle_nota_credito=false;
		
		
		this.empresa=null;
		this.sucursal=null;
		this.cuentacontablefactu=null;
		this.cuentacontablefinan=null;
		this.cuentacontableotro=null;
		this.formatoproforma=null;
		this.formatopedido=null;
		this.formatofactura=null;
		this.formatonotacredito=null;
		this.formatoinventario=null;
		
		
		this.empresa_descripcion="";
		this.sucursal_descripcion="";
		this.cuentacontablefactu_descripcion="";
		this.cuentacontablefinan_descripcion="";
		this.cuentacontableotro_descripcion="";
		this.formatoproforma_descripcion="";
		this.formatopedido_descripcion="";
		this.formatofactura_descripcion="";
		this.formatonotacredito_descripcion="";
		this.formatoinventario_descripcion="";
		
		
		
			
		
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
    //PARA REPORTES
	public ParametroFactu (Long id,Date versionRow,Long id_empresa,Long id_sucursal,Long id_cuenta_contable_factu,Long id_cuenta_contable_finan,Long id_cuenta_contable_otro,Long id_formato_proforma,Long id_formato_pedido,Long id_formato_factura,Long id_formato_nota_credito,Long id_formato_inventario,String secuencial_proforma,String secuancial_pedido,String secuencial_factura,String secuencial_nota_credito,Integer item_proforma,Integer item_pedido,Integer item_factura,Integer item_nota_credito,Integer item_inventario,Boolean con_detalle_proforma,Boolean con_detalle_pedido,Boolean con_detalle_factura,Boolean con_detalle_nota_credito) throws Exception {
		super();		
		
		this.id=id;
		this.versionRow=versionRow;
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.parametrofactuOriginal=this;
		
 		this.id_empresa=id_empresa;
 		this.id_sucursal=id_sucursal;
 		this.id_cuenta_contable_factu=id_cuenta_contable_factu;
 		this.id_cuenta_contable_finan=id_cuenta_contable_finan;
 		this.id_cuenta_contable_otro=id_cuenta_contable_otro;
 		this.id_formato_proforma=id_formato_proforma;
 		this.id_formato_pedido=id_formato_pedido;
 		this.id_formato_factura=id_formato_factura;
 		this.id_formato_nota_credito=id_formato_nota_credito;
 		this.id_formato_inventario=id_formato_inventario;
 		this.secuencial_proforma=secuencial_proforma;
 		this.secuancial_pedido=secuancial_pedido;
 		this.secuencial_factura=secuencial_factura;
 		this.secuencial_nota_credito=secuencial_nota_credito;
 		this.item_proforma=item_proforma;
 		this.item_pedido=item_pedido;
 		this.item_factura=item_factura;
 		this.item_nota_credito=item_nota_credito;
 		this.item_inventario=item_inventario;
 		this.con_detalle_proforma=con_detalle_proforma;
 		this.con_detalle_pedido=con_detalle_pedido;
 		this.con_detalle_factura=con_detalle_factura;
 		this.con_detalle_nota_credito=con_detalle_nota_credito;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	 //PARA REPORTES
	public ParametroFactu (Long id_empresa,Long id_sucursal,Long id_cuenta_contable_factu,Long id_cuenta_contable_finan,Long id_cuenta_contable_otro,Long id_formato_proforma,Long id_formato_pedido,Long id_formato_factura,Long id_formato_nota_credito,Long id_formato_inventario,String secuencial_proforma,String secuancial_pedido,String secuencial_factura,String secuencial_nota_credito,Integer item_proforma,Integer item_pedido,Integer item_factura,Integer item_nota_credito,Integer item_inventario,Boolean con_detalle_proforma,Boolean con_detalle_pedido,Boolean con_detalle_factura,Boolean con_detalle_nota_credito) throws Exception {
		super();		
		
		this.id=0L;
		this.versionRow=new Date();
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.parametrofactuOriginal=this;
		
 		this.id_empresa=id_empresa;
 		this.id_sucursal=id_sucursal;
 		this.id_cuenta_contable_factu=id_cuenta_contable_factu;
 		this.id_cuenta_contable_finan=id_cuenta_contable_finan;
 		this.id_cuenta_contable_otro=id_cuenta_contable_otro;
 		this.id_formato_proforma=id_formato_proforma;
 		this.id_formato_pedido=id_formato_pedido;
 		this.id_formato_factura=id_formato_factura;
 		this.id_formato_nota_credito=id_formato_nota_credito;
 		this.id_formato_inventario=id_formato_inventario;
 		this.secuencial_proforma=secuencial_proforma;
 		this.secuancial_pedido=secuancial_pedido;
 		this.secuencial_factura=secuencial_factura;
 		this.secuencial_nota_credito=secuencial_nota_credito;
 		this.item_proforma=item_proforma;
 		this.item_pedido=item_pedido;
 		this.item_factura=item_factura;
 		this.item_nota_credito=item_nota_credito;
 		this.item_inventario=item_inventario;
 		this.con_detalle_proforma=con_detalle_proforma;
 		this.con_detalle_pedido=con_detalle_pedido;
 		this.con_detalle_factura=con_detalle_factura;
 		this.con_detalle_nota_credito=con_detalle_nota_credito;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	public boolean equals(Object object) {
		boolean equal=false;
		ParametroFactu parametrofactuLocal=null;
		
		if(object!=null) {
			parametrofactuLocal=(ParametroFactu)object;
			
			if(parametrofactuLocal!=null) {
				if(this.getId()!=null && parametrofactuLocal.getId()!=null) {
					if(this.getId().equals(parametrofactuLocal.getId())) {
						equal=true;
					}
				}
			}
		}
		
		return equal;
	}
	
	public String toString() {
		String sDetalle="";
		
		if(!ParametroFactuConstantesFunciones.CON_DESCRIPCION_DETALLADO) {
        	sDetalle=ParametroFactuConstantesFunciones.getParametroFactuDescripcion(this);
		} else {
			sDetalle=ParametroFactuConstantesFunciones.getParametroFactuDescripcionDetallado(this);
		}
		
		return sDetalle;
    }
	
	public ParametroFactu getParametroFactuOriginal() {
		return this.parametrofactuOriginal;
	}
	
	public void setParametroFactuOriginal(ParametroFactu parametrofactu) {
		try {
			this.parametrofactuOriginal=parametrofactu;
		} catch(Exception e) {
			;
		}
	}
	
	
	protected ParametroFactuAdditional parametrofactuAdditional=null;
	
	public ParametroFactuAdditional getParametroFactuAdditional() {
		return this.parametrofactuAdditional;
	}
	
	public void setParametroFactuAdditional(ParametroFactuAdditional parametrofactuAdditional) {
		try {
			this.parametrofactuAdditional=parametrofactuAdditional;
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
    
	
	public Long getid_cuenta_contable_factu() {
		return this.id_cuenta_contable_factu;
	}
    
	
	public Long getid_cuenta_contable_finan() {
		return this.id_cuenta_contable_finan;
	}
    
	
	public Long getid_cuenta_contable_otro() {
		return this.id_cuenta_contable_otro;
	}
    
	
	public Long getid_formato_proforma() {
		return this.id_formato_proforma;
	}
    
	
	public Long getid_formato_pedido() {
		return this.id_formato_pedido;
	}
    
	
	public Long getid_formato_factura() {
		return this.id_formato_factura;
	}
    
	
	public Long getid_formato_nota_credito() {
		return this.id_formato_nota_credito;
	}
    
	
	public Long getid_formato_inventario() {
		return this.id_formato_inventario;
	}
    
	
	public String getsecuencial_proforma() {
		return this.secuencial_proforma;
	}
    
	
	public String getsecuancial_pedido() {
		return this.secuancial_pedido;
	}
    
	
	public String getsecuencial_factura() {
		return this.secuencial_factura;
	}
    
	
	public String getsecuencial_nota_credito() {
		return this.secuencial_nota_credito;
	}
    
	
	public Integer getitem_proforma() {
		return this.item_proforma;
	}
    
	
	public Integer getitem_pedido() {
		return this.item_pedido;
	}
    
	
	public Integer getitem_factura() {
		return this.item_factura;
	}
    
	
	public Integer getitem_nota_credito() {
		return this.item_nota_credito;
	}
    
	
	public Integer getitem_inventario() {
		return this.item_inventario;
	}
    
	
	public Boolean getcon_detalle_proforma() {
		return this.con_detalle_proforma;
	}
    
	
	public Boolean getcon_detalle_pedido() {
		return this.con_detalle_pedido;
	}
    
	
	public Boolean getcon_detalle_factura() {
		return this.con_detalle_factura;
	}
    
	
	public Boolean getcon_detalle_nota_credito() {
		return this.con_detalle_nota_credito;
	}
	
    
	public void setid_empresa(Long newid_empresa)throws Exception
	{
		try {
			if(this.id_empresa!=newid_empresa) {
				if(newid_empresa==null) {
					//newid_empresa=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ParametroFactu:Valor nulo no permitido en columna id_empresa");
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
						System.out.println("ParametroFactu:Valor nulo no permitido en columna id_sucursal");
					}
				}

				this.id_sucursal=newid_sucursal;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_cuenta_contable_factu(Long newid_cuenta_contable_factu)throws Exception
	{
		try {
			if(this.id_cuenta_contable_factu!=newid_cuenta_contable_factu) {
				if(newid_cuenta_contable_factu==null) {
					//newid_cuenta_contable_factu=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ParametroFactu:Valor nulo no permitido en columna id_cuenta_contable_factu");
					}
				}

				this.id_cuenta_contable_factu=newid_cuenta_contable_factu;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_cuenta_contable_finan(Long newid_cuenta_contable_finan)throws Exception
	{
		try {
			if(this.id_cuenta_contable_finan!=newid_cuenta_contable_finan) {
				if(newid_cuenta_contable_finan==null) {
					//newid_cuenta_contable_finan=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ParametroFactu:Valor nulo no permitido en columna id_cuenta_contable_finan");
					}
				}

				this.id_cuenta_contable_finan=newid_cuenta_contable_finan;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_cuenta_contable_otro(Long newid_cuenta_contable_otro)throws Exception
	{
		try {
			if(this.id_cuenta_contable_otro!=newid_cuenta_contable_otro) {
				if(newid_cuenta_contable_otro==null) {
					//newid_cuenta_contable_otro=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ParametroFactu:Valor nulo no permitido en columna id_cuenta_contable_otro");
					}
				}

				this.id_cuenta_contable_otro=newid_cuenta_contable_otro;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_formato_proforma(Long newid_formato_proforma)throws Exception
	{
		try {
			if(this.id_formato_proforma!=newid_formato_proforma) {
				if(newid_formato_proforma==null) {
					//newid_formato_proforma=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ParametroFactu:Valor nulo no permitido en columna id_formato_proforma");
					}
				}

				this.id_formato_proforma=newid_formato_proforma;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_formato_pedido(Long newid_formato_pedido)throws Exception
	{
		try {
			if(this.id_formato_pedido!=newid_formato_pedido) {
				if(newid_formato_pedido==null) {
					//newid_formato_pedido=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ParametroFactu:Valor nulo no permitido en columna id_formato_pedido");
					}
				}

				this.id_formato_pedido=newid_formato_pedido;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_formato_factura(Long newid_formato_factura)throws Exception
	{
		try {
			if(this.id_formato_factura!=newid_formato_factura) {
				if(newid_formato_factura==null) {
					//newid_formato_factura=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ParametroFactu:Valor nulo no permitido en columna id_formato_factura");
					}
				}

				this.id_formato_factura=newid_formato_factura;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_formato_nota_credito(Long newid_formato_nota_credito)throws Exception
	{
		try {
			if(this.id_formato_nota_credito!=newid_formato_nota_credito) {
				if(newid_formato_nota_credito==null) {
					//newid_formato_nota_credito=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ParametroFactu:Valor nulo no permitido en columna id_formato_nota_credito");
					}
				}

				this.id_formato_nota_credito=newid_formato_nota_credito;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_formato_inventario(Long newid_formato_inventario)throws Exception
	{
		try {
			if(this.id_formato_inventario!=newid_formato_inventario) {
				if(newid_formato_inventario==null) {
					//newid_formato_inventario=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ParametroFactu:Valor nulo no permitido en columna id_formato_inventario");
					}
				}

				this.id_formato_inventario=newid_formato_inventario;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setsecuencial_proforma(String newsecuencial_proforma)throws Exception
	{
		try {
			if(this.secuencial_proforma!=newsecuencial_proforma) {
				if(newsecuencial_proforma==null) {
					//newsecuencial_proforma="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("ParametroFactu:Valor nulo no permitido en columna secuencial_proforma");
					}
				}

				if(newsecuencial_proforma!=null&&newsecuencial_proforma.length()>50) {
					newsecuencial_proforma=newsecuencial_proforma.substring(0,48);
					System.out.println("ParametroFactu:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=50 en columna secuencial_proforma");
				}

				this.secuencial_proforma=newsecuencial_proforma;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setsecuancial_pedido(String newsecuancial_pedido)throws Exception
	{
		try {
			if(this.secuancial_pedido!=newsecuancial_pedido) {
				if(newsecuancial_pedido==null) {
					//newsecuancial_pedido="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("ParametroFactu:Valor nulo no permitido en columna secuancial_pedido");
					}
				}

				if(newsecuancial_pedido!=null&&newsecuancial_pedido.length()>50) {
					newsecuancial_pedido=newsecuancial_pedido.substring(0,48);
					System.out.println("ParametroFactu:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=50 en columna secuancial_pedido");
				}

				this.secuancial_pedido=newsecuancial_pedido;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setsecuencial_factura(String newsecuencial_factura)throws Exception
	{
		try {
			if(this.secuencial_factura!=newsecuencial_factura) {
				if(newsecuencial_factura==null) {
					//newsecuencial_factura="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("ParametroFactu:Valor nulo no permitido en columna secuencial_factura");
					}
				}

				if(newsecuencial_factura!=null&&newsecuencial_factura.length()>50) {
					newsecuencial_factura=newsecuencial_factura.substring(0,48);
					System.out.println("ParametroFactu:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=50 en columna secuencial_factura");
				}

				this.secuencial_factura=newsecuencial_factura;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setsecuencial_nota_credito(String newsecuencial_nota_credito)throws Exception
	{
		try {
			if(this.secuencial_nota_credito!=newsecuencial_nota_credito) {
				if(newsecuencial_nota_credito==null) {
					//newsecuencial_nota_credito="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("ParametroFactu:Valor nulo no permitido en columna secuencial_nota_credito");
					}
				}

				if(newsecuencial_nota_credito!=null&&newsecuencial_nota_credito.length()>50) {
					newsecuencial_nota_credito=newsecuencial_nota_credito.substring(0,48);
					System.out.println("ParametroFactu:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=50 en columna secuencial_nota_credito");
				}

				this.secuencial_nota_credito=newsecuencial_nota_credito;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setitem_proforma(Integer newitem_proforma)throws Exception
	{
		try {
			if(this.item_proforma!=newitem_proforma) {
				if(newitem_proforma==null) {
					//newitem_proforma=0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ParametroFactu:Valor nulo no permitido en columna item_proforma");
					}
				}

				this.item_proforma=newitem_proforma;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setitem_pedido(Integer newitem_pedido)throws Exception
	{
		try {
			if(this.item_pedido!=newitem_pedido) {
				if(newitem_pedido==null) {
					//newitem_pedido=0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ParametroFactu:Valor nulo no permitido en columna item_pedido");
					}
				}

				this.item_pedido=newitem_pedido;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setitem_factura(Integer newitem_factura)throws Exception
	{
		try {
			if(this.item_factura!=newitem_factura) {
				if(newitem_factura==null) {
					//newitem_factura=0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ParametroFactu:Valor nulo no permitido en columna item_factura");
					}
				}

				this.item_factura=newitem_factura;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setitem_nota_credito(Integer newitem_nota_credito)throws Exception
	{
		try {
			if(this.item_nota_credito!=newitem_nota_credito) {
				if(newitem_nota_credito==null) {
					//newitem_nota_credito=0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ParametroFactu:Valor nulo no permitido en columna item_nota_credito");
					}
				}

				this.item_nota_credito=newitem_nota_credito;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setitem_inventario(Integer newitem_inventario)throws Exception
	{
		try {
			if(this.item_inventario!=newitem_inventario) {
				if(newitem_inventario==null) {
					//newitem_inventario=0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ParametroFactu:Valor nulo no permitido en columna item_inventario");
					}
				}

				this.item_inventario=newitem_inventario;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setcon_detalle_proforma(Boolean newcon_detalle_proforma)throws Exception
	{
		try {
			if(this.con_detalle_proforma!=newcon_detalle_proforma) {
				if(newcon_detalle_proforma==null) {
					//newcon_detalle_proforma=false;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ParametroFactu:Valor nulo no permitido en columna con_detalle_proforma");
					}
				}

				this.con_detalle_proforma=newcon_detalle_proforma;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setcon_detalle_pedido(Boolean newcon_detalle_pedido)throws Exception
	{
		try {
			if(this.con_detalle_pedido!=newcon_detalle_pedido) {
				if(newcon_detalle_pedido==null) {
					//newcon_detalle_pedido=false;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ParametroFactu:Valor nulo no permitido en columna con_detalle_pedido");
					}
				}

				this.con_detalle_pedido=newcon_detalle_pedido;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setcon_detalle_factura(Boolean newcon_detalle_factura)throws Exception
	{
		try {
			if(this.con_detalle_factura!=newcon_detalle_factura) {
				if(newcon_detalle_factura==null) {
					//newcon_detalle_factura=false;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ParametroFactu:Valor nulo no permitido en columna con_detalle_factura");
					}
				}

				this.con_detalle_factura=newcon_detalle_factura;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setcon_detalle_nota_credito(Boolean newcon_detalle_nota_credito)throws Exception
	{
		try {
			if(this.con_detalle_nota_credito!=newcon_detalle_nota_credito) {
				if(newcon_detalle_nota_credito==null) {
					//newcon_detalle_nota_credito=false;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ParametroFactu:Valor nulo no permitido en columna con_detalle_nota_credito");
					}
				}

				this.con_detalle_nota_credito=newcon_detalle_nota_credito;
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

	public CuentaContable getCuentaContableFactu() {
		return this.cuentacontablefactu;
	}

	public CuentaContable getCuentaContableFinan() {
		return this.cuentacontablefinan;
	}

	public CuentaContable getCuentaContableOtro() {
		return this.cuentacontableotro;
	}

	public Formato getFormatoProforma() {
		return this.formatoproforma;
	}

	public Formato getFormatoPedido() {
		return this.formatopedido;
	}

	public Formato getFormatoFactura() {
		return this.formatofactura;
	}

	public Formato getFormatoNotaCredito() {
		return this.formatonotacredito;
	}

	public Formato getFormatoInventario() {
		return this.formatoinventario;
	}

	
	
	public String getempresa_descripcion() {
		return this.empresa_descripcion;
	}

	public String getsucursal_descripcion() {
		return this.sucursal_descripcion;
	}

	public String getcuentacontablefactu_descripcion() {
		return this.cuentacontablefactu_descripcion;
	}

	public String getcuentacontablefinan_descripcion() {
		return this.cuentacontablefinan_descripcion;
	}

	public String getcuentacontableotro_descripcion() {
		return this.cuentacontableotro_descripcion;
	}

	public String getformatoproforma_descripcion() {
		return this.formatoproforma_descripcion;
	}

	public String getformatopedido_descripcion() {
		return this.formatopedido_descripcion;
	}

	public String getformatofactura_descripcion() {
		return this.formatofactura_descripcion;
	}

	public String getformatonotacredito_descripcion() {
		return this.formatonotacredito_descripcion;
	}

	public String getformatoinventario_descripcion() {
		return this.formatoinventario_descripcion;
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


	public  void  setCuentaContableFactu(CuentaContable cuentacontablefactu) {
		try {
			this.cuentacontablefactu=cuentacontablefactu;
		} catch(Exception e) {
			;
		}
	}


	public  void  setCuentaContableFinan(CuentaContable cuentacontablefinan) {
		try {
			this.cuentacontablefinan=cuentacontablefinan;
		} catch(Exception e) {
			;
		}
	}


	public  void  setCuentaContableOtro(CuentaContable cuentacontableotro) {
		try {
			this.cuentacontableotro=cuentacontableotro;
		} catch(Exception e) {
			;
		}
	}


	public  void  setFormatoProforma(Formato formatoproforma) {
		try {
			this.formatoproforma=formatoproforma;
		} catch(Exception e) {
			;
		}
	}


	public  void  setFormatoPedido(Formato formatopedido) {
		try {
			this.formatopedido=formatopedido;
		} catch(Exception e) {
			;
		}
	}


	public  void  setFormatoFactura(Formato formatofactura) {
		try {
			this.formatofactura=formatofactura;
		} catch(Exception e) {
			;
		}
	}


	public  void  setFormatoNotaCredito(Formato formatonotacredito) {
		try {
			this.formatonotacredito=formatonotacredito;
		} catch(Exception e) {
			;
		}
	}


	public  void  setFormatoInventario(Formato formatoinventario) {
		try {
			this.formatoinventario=formatoinventario;
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


	public  void  setcuentacontablefactu_descripcion(String cuentacontablefactu_descripcion) {
		try {
			this.cuentacontablefactu_descripcion=cuentacontablefactu_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  setcuentacontablefinan_descripcion(String cuentacontablefinan_descripcion) {
		try {
			this.cuentacontablefinan_descripcion=cuentacontablefinan_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  setcuentacontableotro_descripcion(String cuentacontableotro_descripcion) {
		try {
			this.cuentacontableotro_descripcion=cuentacontableotro_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  setformatoproforma_descripcion(String formatoproforma_descripcion) {
		try {
			this.formatoproforma_descripcion=formatoproforma_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  setformatopedido_descripcion(String formatopedido_descripcion) {
		try {
			this.formatopedido_descripcion=formatopedido_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  setformatofactura_descripcion(String formatofactura_descripcion) {
		try {
			this.formatofactura_descripcion=formatofactura_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  setformatonotacredito_descripcion(String formatonotacredito_descripcion) {
		try {
			this.formatonotacredito_descripcion=formatonotacredito_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  setformatoinventario_descripcion(String formatoinventario_descripcion) {
		try {
			this.formatoinventario_descripcion=formatoinventario_descripcion;
		} catch(Exception e) {
			;
		}
	}


	
	
	
	
	
	/*PARA REPORTES*/
	String id_empresa_descripcion="";String id_sucursal_descripcion="";String id_cuenta_contable_factu_descripcion="";String id_cuenta_contable_finan_descripcion="";String id_cuenta_contable_otro_descripcion="";String id_formato_proforma_descripcion="";String id_formato_pedido_descripcion="";String id_formato_factura_descripcion="";String id_formato_nota_credito_descripcion="";String id_formato_inventario_descripcion="";String con_detalle_proforma_descripcion="";String con_detalle_pedido_descripcion="";String con_detalle_factura_descripcion="";String con_detalle_nota_credito_descripcion="";
	
	
	public String getid_empresa_descripcion() {
		return id_empresa_descripcion;
	}
	public String getid_sucursal_descripcion() {
		return id_sucursal_descripcion;
	}
	public String getid_cuenta_contable_factu_descripcion() {
		return id_cuenta_contable_factu_descripcion;
	}
	public String getid_cuenta_contable_finan_descripcion() {
		return id_cuenta_contable_finan_descripcion;
	}
	public String getid_cuenta_contable_otro_descripcion() {
		return id_cuenta_contable_otro_descripcion;
	}
	public String getid_formato_proforma_descripcion() {
		return id_formato_proforma_descripcion;
	}
	public String getid_formato_pedido_descripcion() {
		return id_formato_pedido_descripcion;
	}
	public String getid_formato_factura_descripcion() {
		return id_formato_factura_descripcion;
	}
	public String getid_formato_nota_credito_descripcion() {
		return id_formato_nota_credito_descripcion;
	}
	public String getid_formato_inventario_descripcion() {
		return id_formato_inventario_descripcion;
	}
	public String getcon_detalle_proforma_descripcion() {
		return con_detalle_proforma_descripcion;
	}
	public String getcon_detalle_pedido_descripcion() {
		return con_detalle_pedido_descripcion;
	}
	public String getcon_detalle_factura_descripcion() {
		return con_detalle_factura_descripcion;
	}
	public String getcon_detalle_nota_credito_descripcion() {
		return con_detalle_nota_credito_descripcion;
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
	public void setid_cuenta_contable_factu_descripcion(String newid_cuenta_contable_factu_descripcion)throws Exception {
		try {
			this.id_cuenta_contable_factu_descripcion=newid_cuenta_contable_factu_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_cuenta_contable_finan_descripcion(String newid_cuenta_contable_finan_descripcion)throws Exception {
		try {
			this.id_cuenta_contable_finan_descripcion=newid_cuenta_contable_finan_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_cuenta_contable_otro_descripcion(String newid_cuenta_contable_otro_descripcion)throws Exception {
		try {
			this.id_cuenta_contable_otro_descripcion=newid_cuenta_contable_otro_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_formato_proforma_descripcion(String newid_formato_proforma_descripcion)throws Exception {
		try {
			this.id_formato_proforma_descripcion=newid_formato_proforma_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_formato_pedido_descripcion(String newid_formato_pedido_descripcion)throws Exception {
		try {
			this.id_formato_pedido_descripcion=newid_formato_pedido_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_formato_factura_descripcion(String newid_formato_factura_descripcion)throws Exception {
		try {
			this.id_formato_factura_descripcion=newid_formato_factura_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_formato_nota_credito_descripcion(String newid_formato_nota_credito_descripcion)throws Exception {
		try {
			this.id_formato_nota_credito_descripcion=newid_formato_nota_credito_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_formato_inventario_descripcion(String newid_formato_inventario_descripcion)throws Exception {
		try {
			this.id_formato_inventario_descripcion=newid_formato_inventario_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setcon_detalle_proforma_descripcion(String newcon_detalle_proforma_descripcion)throws Exception {
		try {
			this.con_detalle_proforma_descripcion=newcon_detalle_proforma_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setcon_detalle_pedido_descripcion(String newcon_detalle_pedido_descripcion)throws Exception {
		try {
			this.con_detalle_pedido_descripcion=newcon_detalle_pedido_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setcon_detalle_factura_descripcion(String newcon_detalle_factura_descripcion)throws Exception {
		try {
			this.con_detalle_factura_descripcion=newcon_detalle_factura_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setcon_detalle_nota_credito_descripcion(String newcon_detalle_nota_credito_descripcion)throws Exception {
		try {
			this.con_detalle_nota_credito_descripcion=newcon_detalle_nota_credito_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	
	public void inicializarVariablesParaReporte() {
		this.id_empresa_descripcion="";this.id_sucursal_descripcion="";this.id_cuenta_contable_factu_descripcion="";this.id_cuenta_contable_finan_descripcion="";this.id_cuenta_contable_otro_descripcion="";this.id_formato_proforma_descripcion="";this.id_formato_pedido_descripcion="";this.id_formato_factura_descripcion="";this.id_formato_nota_credito_descripcion="";this.id_formato_inventario_descripcion="";this.con_detalle_proforma_descripcion="";this.con_detalle_pedido_descripcion="";this.con_detalle_factura_descripcion="";this.con_detalle_nota_credito_descripcion="";
	}
	
	
	
	
	
	
	/*PARA REPORTES FIN*/		
}

