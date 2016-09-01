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
//import com.bydan.erp.cartera.util.ParametroCarteraConstantesFunciones;
import com.bydan.erp.cartera.util.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.tesoreria.util.*;
import com.bydan.erp.nomina.util.*;
import com.bydan.erp.inventario.util.*;
import com.bydan.erp.contabilidad.util.*;



import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.tesoreria.business.entity.*;
import com.bydan.erp.nomina.business.entity.*;
import com.bydan.erp.inventario.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;




@SuppressWarnings("unused")
public class ParametroCartera extends ParametroCarteraAdditional implements Serializable ,Cloneable {//ParametroCarteraAdditional,GeneralEntity
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
	
	private ParametroCartera parametrocarteraOriginal;
	
	private Map<String, Object> mapParametroCartera;
			
	public Map<String, Object> getMapParametroCartera() {
		return mapParametroCartera;
	}

	public void setMapParametroCartera(Map<String, Object> mapParametroCartera) {
		this.mapParametroCartera = mapParametroCartera;
	}
	
	public void inicializarMapParametroCartera() {
		this.mapParametroCartera = new HashMap<String,Object>();
	}
	
	public void setMapParametroCarteraValue(String sKey,Object oValue) {
		this.mapParametroCartera.put(sKey, oValue);
	}
	
	public Object getMapParametroCarteraValue(String sKey) {
		return this.mapParametroCartera.get(sKey);
	}
	
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_empresa;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_transaccion_factura;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=10,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONINT)
	private Integer numero_digitos_factura;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Boolean por_lotes;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_empleado;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_transaccion_deshabilita;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_transaccion_habilita;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_bodega;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_tipo_factura;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_tipo_auto_pago;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=50,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=ParametroCarteraConstantesFunciones.SREGEXNUMERO_ORDEN_PAGO,message=ParametroCarteraConstantesFunciones.SMENSAJEREGEXNUMERO_ORDEN_PAGO)
	private String numero_orden_pago;
	
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_cuenta_contable_credito_fiscal;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=150,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@Pattern(regex=ParametroCarteraConstantesFunciones.SREGEXDESCRIPCION,message=ParametroCarteraConstantesFunciones.SMENSAJEREGEXDESCRIPCION)
	private String descripcion;
			
	
	public Empresa empresa;
	public Transaccion transaccionfactura;
	public Empleado empleado;
	public Transaccion transacciondeshabilita;
	public Transaccion transaccionhabilita;
	public Bodega bodega;
	public TipoFactura tipofactura;
	public TipoAutoPago tipoautopago;
	public CuentaContable cuentacontablecreditofiscal;
	
	
	private String empresa_descripcion;
	private String transaccionfactura_descripcion;
	private String empleado_descripcion;
	private String transacciondeshabilita_descripcion;
	private String transaccionhabilita_descripcion;
	private String bodega_descripcion;
	private String tipofactura_descripcion;
	private String tipoautopago_descripcion;
	private String cuentacontablecreditofiscal_descripcion;
	
	
		
	public ParametroCartera () throws Exception {
		super();		
		
		this.id=0L;
		
		
		this.versionRow=new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());//new Date();
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		this.sType="NONE";
		
		this.parametrocarteraOriginal=this;
		
 		this.id_empresa=-1L;
 		this.id_transaccion_factura=-1L;
 		this.numero_digitos_factura=0;
 		this.por_lotes=false;
 		this.id_empleado=-1L;
 		this.id_transaccion_deshabilita=-1L;
 		this.id_transaccion_habilita=-1L;
 		this.id_bodega=-1L;
 		this.id_tipo_factura=-1L;
 		this.id_tipo_auto_pago=-1L;
 		this.numero_orden_pago="";
 		this.id_cuenta_contable_credito_fiscal=null;
 		this.descripcion="";
		
		
		this.empresa=null;
		this.transaccionfactura=null;
		this.empleado=null;
		this.transacciondeshabilita=null;
		this.transaccionhabilita=null;
		this.bodega=null;
		this.tipofactura=null;
		this.tipoautopago=null;
		this.cuentacontablecreditofiscal=null;
		
		
		this.empresa_descripcion="";
		this.transaccionfactura_descripcion="";
		this.empleado_descripcion="";
		this.transacciondeshabilita_descripcion="";
		this.transaccionhabilita_descripcion="";
		this.bodega_descripcion="";
		this.tipofactura_descripcion="";
		this.tipoautopago_descripcion="";
		this.cuentacontablecreditofiscal_descripcion="";
		
		
		
			
		
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
    //PARA REPORTES
	public ParametroCartera (Long id,Date versionRow,Long id_empresa,Long id_transaccion_factura,Integer numero_digitos_factura,Boolean por_lotes,Long id_empleado,Long id_transaccion_deshabilita,Long id_transaccion_habilita,Long id_bodega,Long id_tipo_factura,Long id_tipo_auto_pago,String numero_orden_pago,Long id_cuenta_contable_credito_fiscal,String descripcion) throws Exception {
		super();		
		
		this.id=id;
		this.versionRow=versionRow;
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.parametrocarteraOriginal=this;
		
 		this.id_empresa=id_empresa;
 		this.id_transaccion_factura=id_transaccion_factura;
 		this.numero_digitos_factura=numero_digitos_factura;
 		this.por_lotes=por_lotes;
 		this.id_empleado=id_empleado;
 		this.id_transaccion_deshabilita=id_transaccion_deshabilita;
 		this.id_transaccion_habilita=id_transaccion_habilita;
 		this.id_bodega=id_bodega;
 		this.id_tipo_factura=id_tipo_factura;
 		this.id_tipo_auto_pago=id_tipo_auto_pago;
 		this.numero_orden_pago=numero_orden_pago;
 		this.id_cuenta_contable_credito_fiscal=id_cuenta_contable_credito_fiscal;
 		this.descripcion=descripcion;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	 //PARA REPORTES
	public ParametroCartera (Long id_empresa,Long id_transaccion_factura,Integer numero_digitos_factura,Boolean por_lotes,Long id_empleado,Long id_transaccion_deshabilita,Long id_transaccion_habilita,Long id_bodega,Long id_tipo_factura,Long id_tipo_auto_pago,String numero_orden_pago,Long id_cuenta_contable_credito_fiscal,String descripcion) throws Exception {
		super();		
		
		this.id=0L;
		this.versionRow=new Date();
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.parametrocarteraOriginal=this;
		
 		this.id_empresa=id_empresa;
 		this.id_transaccion_factura=id_transaccion_factura;
 		this.numero_digitos_factura=numero_digitos_factura;
 		this.por_lotes=por_lotes;
 		this.id_empleado=id_empleado;
 		this.id_transaccion_deshabilita=id_transaccion_deshabilita;
 		this.id_transaccion_habilita=id_transaccion_habilita;
 		this.id_bodega=id_bodega;
 		this.id_tipo_factura=id_tipo_factura;
 		this.id_tipo_auto_pago=id_tipo_auto_pago;
 		this.numero_orden_pago=numero_orden_pago;
 		this.id_cuenta_contable_credito_fiscal=id_cuenta_contable_credito_fiscal;
 		this.descripcion=descripcion;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	public boolean equals(Object object) {
		boolean equal=false;
		ParametroCartera parametrocarteraLocal=null;
		
		if(object!=null) {
			parametrocarteraLocal=(ParametroCartera)object;
			
			if(parametrocarteraLocal!=null) {
				if(this.getId()!=null && parametrocarteraLocal.getId()!=null) {
					if(this.getId().equals(parametrocarteraLocal.getId())) {
						equal=true;
					}
				}
			}
		}
		
		return equal;
	}
	
	public String toString() {
		String sDetalle="";
		
		if(!ParametroCarteraConstantesFunciones.CON_DESCRIPCION_DETALLADO) {
        	sDetalle=ParametroCarteraConstantesFunciones.getParametroCarteraDescripcion(this);
		} else {
			sDetalle=ParametroCarteraConstantesFunciones.getParametroCarteraDescripcionDetallado(this);
		}
		
		return sDetalle;
    }
	
	public ParametroCartera getParametroCarteraOriginal() {
		return this.parametrocarteraOriginal;
	}
	
	public void setParametroCarteraOriginal(ParametroCartera parametrocartera) {
		try {
			this.parametrocarteraOriginal=parametrocartera;
		} catch(Exception e) {
			;
		}
	}
	
	
	protected ParametroCarteraAdditional parametrocarteraAdditional=null;
	
	public ParametroCarteraAdditional getParametroCarteraAdditional() {
		return this.parametrocarteraAdditional;
	}
	
	public void setParametroCarteraAdditional(ParametroCarteraAdditional parametrocarteraAdditional) {
		try {
			this.parametrocarteraAdditional=parametrocarteraAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
    
	
	public Long getid_empresa() {
		return this.id_empresa;
	}
    
	
	public Long getid_transaccion_factura() {
		return this.id_transaccion_factura;
	}
    
	
	public Integer getnumero_digitos_factura() {
		return this.numero_digitos_factura;
	}
    
	
	public Boolean getpor_lotes() {
		return this.por_lotes;
	}
    
	
	public Long getid_empleado() {
		return this.id_empleado;
	}
    
	
	public Long getid_transaccion_deshabilita() {
		return this.id_transaccion_deshabilita;
	}
    
	
	public Long getid_transaccion_habilita() {
		return this.id_transaccion_habilita;
	}
    
	
	public Long getid_bodega() {
		return this.id_bodega;
	}
    
	
	public Long getid_tipo_factura() {
		return this.id_tipo_factura;
	}
    
	
	public Long getid_tipo_auto_pago() {
		return this.id_tipo_auto_pago;
	}
    
	
	public String getnumero_orden_pago() {
		return this.numero_orden_pago;
	}
    
	
	public Long getid_cuenta_contable_credito_fiscal() {
		return this.id_cuenta_contable_credito_fiscal;
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
						System.out.println("ParametroCartera:Valor nulo no permitido en columna id_empresa");
					}
				}

				this.id_empresa=newid_empresa;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_transaccion_factura(Long newid_transaccion_factura)throws Exception
	{
		try {
			if(this.id_transaccion_factura!=newid_transaccion_factura) {
				if(newid_transaccion_factura==null) {
					//newid_transaccion_factura=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ParametroCartera:Valor nulo no permitido en columna id_transaccion_factura");
					}
				}

				this.id_transaccion_factura=newid_transaccion_factura;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setnumero_digitos_factura(Integer newnumero_digitos_factura)throws Exception
	{
		try {
			if(this.numero_digitos_factura!=newnumero_digitos_factura) {
				if(newnumero_digitos_factura==null) {
					//newnumero_digitos_factura=0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ParametroCartera:Valor nulo no permitido en columna numero_digitos_factura");
					}
				}

				this.numero_digitos_factura=newnumero_digitos_factura;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setpor_lotes(Boolean newpor_lotes)throws Exception
	{
		try {
			if(this.por_lotes!=newpor_lotes) {
				if(newpor_lotes==null) {
					//newpor_lotes=false;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ParametroCartera:Valor nulo no permitido en columna por_lotes");
					}
				}

				this.por_lotes=newpor_lotes;
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
						System.out.println("ParametroCartera:Valor nulo no permitido en columna id_empleado");
					}
				}

				this.id_empleado=newid_empleado;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_transaccion_deshabilita(Long newid_transaccion_deshabilita)throws Exception
	{
		try {
			if(this.id_transaccion_deshabilita!=newid_transaccion_deshabilita) {
				if(newid_transaccion_deshabilita==null) {
					//newid_transaccion_deshabilita=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ParametroCartera:Valor nulo no permitido en columna id_transaccion_deshabilita");
					}
				}

				this.id_transaccion_deshabilita=newid_transaccion_deshabilita;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_transaccion_habilita(Long newid_transaccion_habilita)throws Exception
	{
		try {
			if(this.id_transaccion_habilita!=newid_transaccion_habilita) {
				if(newid_transaccion_habilita==null) {
					//newid_transaccion_habilita=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ParametroCartera:Valor nulo no permitido en columna id_transaccion_habilita");
					}
				}

				this.id_transaccion_habilita=newid_transaccion_habilita;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_bodega(Long newid_bodega)throws Exception
	{
		try {
			if(this.id_bodega!=newid_bodega) {
				if(newid_bodega==null) {
					//newid_bodega=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ParametroCartera:Valor nulo no permitido en columna id_bodega");
					}
				}

				this.id_bodega=newid_bodega;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_tipo_factura(Long newid_tipo_factura)throws Exception
	{
		try {
			if(this.id_tipo_factura!=newid_tipo_factura) {
				if(newid_tipo_factura==null) {
					//newid_tipo_factura=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ParametroCartera:Valor nulo no permitido en columna id_tipo_factura");
					}
				}

				this.id_tipo_factura=newid_tipo_factura;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_tipo_auto_pago(Long newid_tipo_auto_pago)throws Exception
	{
		try {
			if(this.id_tipo_auto_pago!=newid_tipo_auto_pago) {
				if(newid_tipo_auto_pago==null) {
					//newid_tipo_auto_pago=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ParametroCartera:Valor nulo no permitido en columna id_tipo_auto_pago");
					}
				}

				this.id_tipo_auto_pago=newid_tipo_auto_pago;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setnumero_orden_pago(String newnumero_orden_pago)throws Exception
	{
		try {
			if(this.numero_orden_pago!=newnumero_orden_pago) {
				if(newnumero_orden_pago==null) {
					//newnumero_orden_pago="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("ParametroCartera:Valor nulo no permitido en columna numero_orden_pago");
					}
				}

				if(newnumero_orden_pago!=null&&newnumero_orden_pago.length()>50) {
					newnumero_orden_pago=newnumero_orden_pago.substring(0,48);
					System.out.println("ParametroCartera:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=50 en columna numero_orden_pago");
				}

				this.numero_orden_pago=newnumero_orden_pago;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_cuenta_contable_credito_fiscal(Long newid_cuenta_contable_credito_fiscal) {
		if(this.id_cuenta_contable_credito_fiscal==null&&newid_cuenta_contable_credito_fiscal!=null) {
			this.id_cuenta_contable_credito_fiscal=newid_cuenta_contable_credito_fiscal;
				this.setIsChanged(true);
		}

		if(this.id_cuenta_contable_credito_fiscal!=null&&!this.id_cuenta_contable_credito_fiscal.equals(newid_cuenta_contable_credito_fiscal)) {

			this.id_cuenta_contable_credito_fiscal=newid_cuenta_contable_credito_fiscal;
				this.setIsChanged(true);
		}
	}
    
	public void setdescripcion(String newdescripcion)throws Exception
	{
		try {
			if(this.descripcion!=newdescripcion) {
				if(newdescripcion==null) {
					//newdescripcion="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("ParametroCartera:Valor nulo no permitido en columna descripcion");
					}
				}

				if(newdescripcion!=null&&newdescripcion.length()>150) {
					newdescripcion=newdescripcion.substring(0,148);
					System.out.println("ParametroCartera:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=150 en columna descripcion");
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

	public Transaccion getTransaccionFactura() {
		return this.transaccionfactura;
	}

	public Empleado getEmpleado() {
		return this.empleado;
	}

	public Transaccion getTransaccionDeshabilita() {
		return this.transacciondeshabilita;
	}

	public Transaccion getTransaccionHabilita() {
		return this.transaccionhabilita;
	}

	public Bodega getBodega() {
		return this.bodega;
	}

	public TipoFactura getTipoFactura() {
		return this.tipofactura;
	}

	public TipoAutoPago getTipoAutoPago() {
		return this.tipoautopago;
	}

	public CuentaContable getCuentaContableCreditoFiscal() {
		return this.cuentacontablecreditofiscal;
	}

	
	
	public String getempresa_descripcion() {
		return this.empresa_descripcion;
	}

	public String gettransaccionfactura_descripcion() {
		return this.transaccionfactura_descripcion;
	}

	public String getempleado_descripcion() {
		return this.empleado_descripcion;
	}

	public String gettransacciondeshabilita_descripcion() {
		return this.transacciondeshabilita_descripcion;
	}

	public String gettransaccionhabilita_descripcion() {
		return this.transaccionhabilita_descripcion;
	}

	public String getbodega_descripcion() {
		return this.bodega_descripcion;
	}

	public String gettipofactura_descripcion() {
		return this.tipofactura_descripcion;
	}

	public String gettipoautopago_descripcion() {
		return this.tipoautopago_descripcion;
	}

	public String getcuentacontablecreditofiscal_descripcion() {
		return this.cuentacontablecreditofiscal_descripcion;
	}

	
	
	public  void  setEmpresa(Empresa empresa) {
		try {
			this.empresa=empresa;
		} catch(Exception e) {
			;
		}
	}


	public  void  setTransaccionFactura(Transaccion transaccionfactura) {
		try {
			this.transaccionfactura=transaccionfactura;
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


	public  void  setTransaccionDeshabilita(Transaccion transacciondeshabilita) {
		try {
			this.transacciondeshabilita=transacciondeshabilita;
		} catch(Exception e) {
			;
		}
	}


	public  void  setTransaccionHabilita(Transaccion transaccionhabilita) {
		try {
			this.transaccionhabilita=transaccionhabilita;
		} catch(Exception e) {
			;
		}
	}


	public  void  setBodega(Bodega bodega) {
		try {
			this.bodega=bodega;
		} catch(Exception e) {
			;
		}
	}


	public  void  setTipoFactura(TipoFactura tipofactura) {
		try {
			this.tipofactura=tipofactura;
		} catch(Exception e) {
			;
		}
	}


	public  void  setTipoAutoPago(TipoAutoPago tipoautopago) {
		try {
			this.tipoautopago=tipoautopago;
		} catch(Exception e) {
			;
		}
	}


	public  void  setCuentaContableCreditoFiscal(CuentaContable cuentacontablecreditofiscal) {
		try {
			this.cuentacontablecreditofiscal=cuentacontablecreditofiscal;
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


	public  void  settransaccionfactura_descripcion(String transaccionfactura_descripcion) {
		try {
			this.transaccionfactura_descripcion=transaccionfactura_descripcion;
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


	public  void  settransacciondeshabilita_descripcion(String transacciondeshabilita_descripcion) {
		try {
			this.transacciondeshabilita_descripcion=transacciondeshabilita_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  settransaccionhabilita_descripcion(String transaccionhabilita_descripcion) {
		try {
			this.transaccionhabilita_descripcion=transaccionhabilita_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  setbodega_descripcion(String bodega_descripcion) {
		try {
			this.bodega_descripcion=bodega_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  settipofactura_descripcion(String tipofactura_descripcion) {
		try {
			this.tipofactura_descripcion=tipofactura_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  settipoautopago_descripcion(String tipoautopago_descripcion) {
		try {
			this.tipoautopago_descripcion=tipoautopago_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  setcuentacontablecreditofiscal_descripcion(String cuentacontablecreditofiscal_descripcion) {
		try {
			this.cuentacontablecreditofiscal_descripcion=cuentacontablecreditofiscal_descripcion;
		} catch(Exception e) {
			;
		}
	}


	
	
	
	
	
	/*PARA REPORTES*/
	String id_empresa_descripcion="";String id_transaccion_factura_descripcion="";String por_lotes_descripcion="";String id_empleado_descripcion="";String id_transaccion_deshabilita_descripcion="";String id_transaccion_habilita_descripcion="";String id_bodega_descripcion="";String id_tipo_factura_descripcion="";String id_tipo_auto_pago_descripcion="";String id_cuenta_contable_credito_fiscal_descripcion="";
	
	
	public String getid_empresa_descripcion() {
		return id_empresa_descripcion;
	}
	public String getid_transaccion_factura_descripcion() {
		return id_transaccion_factura_descripcion;
	}
	public String getpor_lotes_descripcion() {
		return por_lotes_descripcion;
	}
	public String getid_empleado_descripcion() {
		return id_empleado_descripcion;
	}
	public String getid_transaccion_deshabilita_descripcion() {
		return id_transaccion_deshabilita_descripcion;
	}
	public String getid_transaccion_habilita_descripcion() {
		return id_transaccion_habilita_descripcion;
	}
	public String getid_bodega_descripcion() {
		return id_bodega_descripcion;
	}
	public String getid_tipo_factura_descripcion() {
		return id_tipo_factura_descripcion;
	}
	public String getid_tipo_auto_pago_descripcion() {
		return id_tipo_auto_pago_descripcion;
	}
	public String getid_cuenta_contable_credito_fiscal_descripcion() {
		return id_cuenta_contable_credito_fiscal_descripcion;
	}
	
	
	public void setid_empresa_descripcion(String newid_empresa_descripcion)throws Exception {
		try {
			this.id_empresa_descripcion=newid_empresa_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_transaccion_factura_descripcion(String newid_transaccion_factura_descripcion)throws Exception {
		try {
			this.id_transaccion_factura_descripcion=newid_transaccion_factura_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setpor_lotes_descripcion(String newpor_lotes_descripcion)throws Exception {
		try {
			this.por_lotes_descripcion=newpor_lotes_descripcion;
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
	public void setid_transaccion_deshabilita_descripcion(String newid_transaccion_deshabilita_descripcion)throws Exception {
		try {
			this.id_transaccion_deshabilita_descripcion=newid_transaccion_deshabilita_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_transaccion_habilita_descripcion(String newid_transaccion_habilita_descripcion)throws Exception {
		try {
			this.id_transaccion_habilita_descripcion=newid_transaccion_habilita_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_bodega_descripcion(String newid_bodega_descripcion)throws Exception {
		try {
			this.id_bodega_descripcion=newid_bodega_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_tipo_factura_descripcion(String newid_tipo_factura_descripcion)throws Exception {
		try {
			this.id_tipo_factura_descripcion=newid_tipo_factura_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_tipo_auto_pago_descripcion(String newid_tipo_auto_pago_descripcion)throws Exception {
		try {
			this.id_tipo_auto_pago_descripcion=newid_tipo_auto_pago_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_cuenta_contable_credito_fiscal_descripcion(String newid_cuenta_contable_credito_fiscal_descripcion)throws Exception {
		try {
			this.id_cuenta_contable_credito_fiscal_descripcion=newid_cuenta_contable_credito_fiscal_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	
	public void inicializarVariablesParaReporte() {
		this.id_empresa_descripcion="";this.id_transaccion_factura_descripcion="";this.por_lotes_descripcion="";this.id_empleado_descripcion="";this.id_transaccion_deshabilita_descripcion="";this.id_transaccion_habilita_descripcion="";this.id_bodega_descripcion="";this.id_tipo_factura_descripcion="";this.id_tipo_auto_pago_descripcion="";this.id_cuenta_contable_credito_fiscal_descripcion="";
	}
	
	
	
	
	
	
	/*PARA REPORTES FIN*/		
}

