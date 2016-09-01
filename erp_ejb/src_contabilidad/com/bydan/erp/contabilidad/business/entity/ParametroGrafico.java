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
package com.bydan.erp.contabilidad.business.entity;

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
//import com.bydan.erp.contabilidad.util.ParametroGraficoConstantesFunciones;
import com.bydan.erp.contabilidad.util.*;


import com.bydan.erp.seguridad.util.*;



import com.bydan.erp.seguridad.business.entity.*;




@SuppressWarnings("unused")
public class ParametroGrafico extends ParametroGraficoAdditional implements Serializable ,Cloneable {//ParametroGraficoAdditional,GeneralEntity
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
	
	private ParametroGrafico parametrograficoOriginal;
	
	private Map<String, Object> mapParametroGrafico;
			
	public Map<String, Object> getMapParametroGrafico() {
		return mapParametroGrafico;
	}

	public void setMapParametroGrafico(Map<String, Object> mapParametroGrafico) {
		this.mapParametroGrafico = mapParametroGrafico;
	}
	
	public void inicializarMapParametroGrafico() {
		this.mapParametroGrafico = new HashMap<String,Object>();
	}
	
	public void setMapParametroGraficoValue(String sKey,Object oValue) {
		this.mapParametroGrafico.put(sKey, oValue);
	}
	
	public Object getMapParametroGraficoValue(String sKey) {
		return this.mapParametroGrafico.get(sKey);
	}
	
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_empresa;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_cuenta_contable_activo;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_cuenta_contable_pasivo;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_cuenta_contable_inventario;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_cuenta_contable_disponibilidad;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_cuenta_contable_costo_venta;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_cuenta_contable_inventario_ini;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_cuenta_contable_inventario_fin;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_cuenta_contable_cuenta_cobrar;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_cuenta_contable_venta_credito;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_cuenta_contable_activo_total;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_cuenta_contable_pasivo_total;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_cuenta_contable_patrimonio;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_cuenta_contable_patrimonio_total;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_cuenta_contable_venta;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double inventario_inicial;
			
	
	public Empresa empresa;
	public CuentaContable cuentacontableactivo;
	public CuentaContable cuentacontablepasivo;
	public CuentaContable cuentacontableinventario;
	public CuentaContable cuentacontabledisponibilidad;
	public CuentaContable cuentacontablecostoventa;
	public CuentaContable cuentacontableinventarioini;
	public CuentaContable cuentacontableinventariofin;
	public CuentaContable cuentacontablecuentascobrar;
	public CuentaContable cuentacontableventacredito;
	public CuentaContable cuentacontableactivototal;
	public CuentaContable cuentacontablepasivototal;
	public CuentaContable cuentacontablepatrimonio;
	public CuentaContable cuentacontablepatrimoniototal;
	public CuentaContable cuentacontableventa;
	
	
	private String empresa_descripcion;
	private String cuentacontableactivo_descripcion;
	private String cuentacontablepasivo_descripcion;
	private String cuentacontableinventario_descripcion;
	private String cuentacontabledisponibilidad_descripcion;
	private String cuentacontablecostoventa_descripcion;
	private String cuentacontableinventarioini_descripcion;
	private String cuentacontableinventariofin_descripcion;
	private String cuentacontablecuentascobrar_descripcion;
	private String cuentacontableventacredito_descripcion;
	private String cuentacontableactivototal_descripcion;
	private String cuentacontablepasivototal_descripcion;
	private String cuentacontablepatrimonio_descripcion;
	private String cuentacontablepatrimoniototal_descripcion;
	private String cuentacontableventa_descripcion;
	
	
		
	public ParametroGrafico () throws Exception {
		super();		
		
		this.id=0L;
		
		
		this.versionRow=new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());//new Date();
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		this.sType="NONE";
		
		this.parametrograficoOriginal=this;
		
 		this.id_empresa=-1L;
 		this.id_cuenta_contable_activo=-1L;
 		this.id_cuenta_contable_pasivo=-1L;
 		this.id_cuenta_contable_inventario=-1L;
 		this.id_cuenta_contable_disponibilidad=-1L;
 		this.id_cuenta_contable_costo_venta=-1L;
 		this.id_cuenta_contable_inventario_ini=-1L;
 		this.id_cuenta_contable_inventario_fin=-1L;
 		this.id_cuenta_contable_cuenta_cobrar=-1L;
 		this.id_cuenta_contable_venta_credito=-1L;
 		this.id_cuenta_contable_activo_total=-1L;
 		this.id_cuenta_contable_pasivo_total=-1L;
 		this.id_cuenta_contable_patrimonio=-1L;
 		this.id_cuenta_contable_patrimonio_total=-1L;
 		this.id_cuenta_contable_venta=-1L;
 		this.inventario_inicial=0.0;
		
		
		this.empresa=null;
		this.cuentacontableactivo=null;
		this.cuentacontablepasivo=null;
		this.cuentacontableinventario=null;
		this.cuentacontabledisponibilidad=null;
		this.cuentacontablecostoventa=null;
		this.cuentacontableinventarioini=null;
		this.cuentacontableinventariofin=null;
		this.cuentacontablecuentascobrar=null;
		this.cuentacontableventacredito=null;
		this.cuentacontableactivototal=null;
		this.cuentacontablepasivototal=null;
		this.cuentacontablepatrimonio=null;
		this.cuentacontablepatrimoniototal=null;
		this.cuentacontableventa=null;
		
		
		this.empresa_descripcion="";
		this.cuentacontableactivo_descripcion="";
		this.cuentacontablepasivo_descripcion="";
		this.cuentacontableinventario_descripcion="";
		this.cuentacontabledisponibilidad_descripcion="";
		this.cuentacontablecostoventa_descripcion="";
		this.cuentacontableinventarioini_descripcion="";
		this.cuentacontableinventariofin_descripcion="";
		this.cuentacontablecuentascobrar_descripcion="";
		this.cuentacontableventacredito_descripcion="";
		this.cuentacontableactivototal_descripcion="";
		this.cuentacontablepasivototal_descripcion="";
		this.cuentacontablepatrimonio_descripcion="";
		this.cuentacontablepatrimoniototal_descripcion="";
		this.cuentacontableventa_descripcion="";
		
		
		
			
		
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
    //PARA REPORTES
	public ParametroGrafico (Long id,Date versionRow,Long id_empresa,Long id_cuenta_contable_activo,Long id_cuenta_contable_pasivo,Long id_cuenta_contable_inventario,Long id_cuenta_contable_disponibilidad,Long id_cuenta_contable_costo_venta,Long id_cuenta_contable_inventario_ini,Long id_cuenta_contable_inventario_fin,Long id_cuenta_contable_cuenta_cobrar,Long id_cuenta_contable_venta_credito,Long id_cuenta_contable_activo_total,Long id_cuenta_contable_pasivo_total,Long id_cuenta_contable_patrimonio,Long id_cuenta_contable_patrimonio_total,Long id_cuenta_contable_venta,Double inventario_inicial) throws Exception {
		super();		
		
		this.id=id;
		this.versionRow=versionRow;
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.parametrograficoOriginal=this;
		
 		this.id_empresa=id_empresa;
 		this.id_cuenta_contable_activo=id_cuenta_contable_activo;
 		this.id_cuenta_contable_pasivo=id_cuenta_contable_pasivo;
 		this.id_cuenta_contable_inventario=id_cuenta_contable_inventario;
 		this.id_cuenta_contable_disponibilidad=id_cuenta_contable_disponibilidad;
 		this.id_cuenta_contable_costo_venta=id_cuenta_contable_costo_venta;
 		this.id_cuenta_contable_inventario_ini=id_cuenta_contable_inventario_ini;
 		this.id_cuenta_contable_inventario_fin=id_cuenta_contable_inventario_fin;
 		this.id_cuenta_contable_cuenta_cobrar=id_cuenta_contable_cuenta_cobrar;
 		this.id_cuenta_contable_venta_credito=id_cuenta_contable_venta_credito;
 		this.id_cuenta_contable_activo_total=id_cuenta_contable_activo_total;
 		this.id_cuenta_contable_pasivo_total=id_cuenta_contable_pasivo_total;
 		this.id_cuenta_contable_patrimonio=id_cuenta_contable_patrimonio;
 		this.id_cuenta_contable_patrimonio_total=id_cuenta_contable_patrimonio_total;
 		this.id_cuenta_contable_venta=id_cuenta_contable_venta;
 		this.inventario_inicial=inventario_inicial;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	 //PARA REPORTES
	public ParametroGrafico (Long id_empresa,Long id_cuenta_contable_activo,Long id_cuenta_contable_pasivo,Long id_cuenta_contable_inventario,Long id_cuenta_contable_disponibilidad,Long id_cuenta_contable_costo_venta,Long id_cuenta_contable_inventario_ini,Long id_cuenta_contable_inventario_fin,Long id_cuenta_contable_cuenta_cobrar,Long id_cuenta_contable_venta_credito,Long id_cuenta_contable_activo_total,Long id_cuenta_contable_pasivo_total,Long id_cuenta_contable_patrimonio,Long id_cuenta_contable_patrimonio_total,Long id_cuenta_contable_venta,Double inventario_inicial) throws Exception {
		super();		
		
		this.id=0L;
		this.versionRow=new Date();
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.parametrograficoOriginal=this;
		
 		this.id_empresa=id_empresa;
 		this.id_cuenta_contable_activo=id_cuenta_contable_activo;
 		this.id_cuenta_contable_pasivo=id_cuenta_contable_pasivo;
 		this.id_cuenta_contable_inventario=id_cuenta_contable_inventario;
 		this.id_cuenta_contable_disponibilidad=id_cuenta_contable_disponibilidad;
 		this.id_cuenta_contable_costo_venta=id_cuenta_contable_costo_venta;
 		this.id_cuenta_contable_inventario_ini=id_cuenta_contable_inventario_ini;
 		this.id_cuenta_contable_inventario_fin=id_cuenta_contable_inventario_fin;
 		this.id_cuenta_contable_cuenta_cobrar=id_cuenta_contable_cuenta_cobrar;
 		this.id_cuenta_contable_venta_credito=id_cuenta_contable_venta_credito;
 		this.id_cuenta_contable_activo_total=id_cuenta_contable_activo_total;
 		this.id_cuenta_contable_pasivo_total=id_cuenta_contable_pasivo_total;
 		this.id_cuenta_contable_patrimonio=id_cuenta_contable_patrimonio;
 		this.id_cuenta_contable_patrimonio_total=id_cuenta_contable_patrimonio_total;
 		this.id_cuenta_contable_venta=id_cuenta_contable_venta;
 		this.inventario_inicial=inventario_inicial;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	public boolean equals(Object object) {
		boolean equal=false;
		ParametroGrafico parametrograficoLocal=null;
		
		if(object!=null) {
			parametrograficoLocal=(ParametroGrafico)object;
			
			if(parametrograficoLocal!=null) {
				if(this.getId()!=null && parametrograficoLocal.getId()!=null) {
					if(this.getId().equals(parametrograficoLocal.getId())) {
						equal=true;
					}
				}
			}
		}
		
		return equal;
	}
	
	public String toString() {
		String sDetalle="";
		
		if(!ParametroGraficoConstantesFunciones.CON_DESCRIPCION_DETALLADO) {
        	sDetalle=ParametroGraficoConstantesFunciones.getParametroGraficoDescripcion(this);
		} else {
			sDetalle=ParametroGraficoConstantesFunciones.getParametroGraficoDescripcionDetallado(this);
		}
		
		return sDetalle;
    }
	
	public ParametroGrafico getParametroGraficoOriginal() {
		return this.parametrograficoOriginal;
	}
	
	public void setParametroGraficoOriginal(ParametroGrafico parametrografico) {
		try {
			this.parametrograficoOriginal=parametrografico;
		} catch(Exception e) {
			;
		}
	}
	
	
	protected ParametroGraficoAdditional parametrograficoAdditional=null;
	
	public ParametroGraficoAdditional getParametroGraficoAdditional() {
		return this.parametrograficoAdditional;
	}
	
	public void setParametroGraficoAdditional(ParametroGraficoAdditional parametrograficoAdditional) {
		try {
			this.parametrograficoAdditional=parametrograficoAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
    
	
	public Long getid_empresa() {
		return this.id_empresa;
	}
    
	
	public Long getid_cuenta_contable_activo() {
		return this.id_cuenta_contable_activo;
	}
    
	
	public Long getid_cuenta_contable_pasivo() {
		return this.id_cuenta_contable_pasivo;
	}
    
	
	public Long getid_cuenta_contable_inventario() {
		return this.id_cuenta_contable_inventario;
	}
    
	
	public Long getid_cuenta_contable_disponibilidad() {
		return this.id_cuenta_contable_disponibilidad;
	}
    
	
	public Long getid_cuenta_contable_costo_venta() {
		return this.id_cuenta_contable_costo_venta;
	}
    
	
	public Long getid_cuenta_contable_inventario_ini() {
		return this.id_cuenta_contable_inventario_ini;
	}
    
	
	public Long getid_cuenta_contable_inventario_fin() {
		return this.id_cuenta_contable_inventario_fin;
	}
    
	
	public Long getid_cuenta_contable_cuenta_cobrar() {
		return this.id_cuenta_contable_cuenta_cobrar;
	}
    
	
	public Long getid_cuenta_contable_venta_credito() {
		return this.id_cuenta_contable_venta_credito;
	}
    
	
	public Long getid_cuenta_contable_activo_total() {
		return this.id_cuenta_contable_activo_total;
	}
    
	
	public Long getid_cuenta_contable_pasivo_total() {
		return this.id_cuenta_contable_pasivo_total;
	}
    
	
	public Long getid_cuenta_contable_patrimonio() {
		return this.id_cuenta_contable_patrimonio;
	}
    
	
	public Long getid_cuenta_contable_patrimonio_total() {
		return this.id_cuenta_contable_patrimonio_total;
	}
    
	
	public Long getid_cuenta_contable_venta() {
		return this.id_cuenta_contable_venta;
	}
    
	
	public Double getinventario_inicial() {
		return this.inventario_inicial;
	}
	
    
	public void setid_empresa(Long newid_empresa)throws Exception
	{
		try {
			if(this.id_empresa!=newid_empresa) {
				if(newid_empresa==null) {
					//newid_empresa=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ParametroGrafico:Valor nulo no permitido en columna id_empresa");
					}
				}

				this.id_empresa=newid_empresa;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_cuenta_contable_activo(Long newid_cuenta_contable_activo)throws Exception
	{
		try {
			if(this.id_cuenta_contable_activo!=newid_cuenta_contable_activo) {
				if(newid_cuenta_contable_activo==null) {
					//newid_cuenta_contable_activo=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ParametroGrafico:Valor nulo no permitido en columna id_cuenta_contable_activo");
					}
				}

				this.id_cuenta_contable_activo=newid_cuenta_contable_activo;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_cuenta_contable_pasivo(Long newid_cuenta_contable_pasivo)throws Exception
	{
		try {
			if(this.id_cuenta_contable_pasivo!=newid_cuenta_contable_pasivo) {
				if(newid_cuenta_contable_pasivo==null) {
					//newid_cuenta_contable_pasivo=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ParametroGrafico:Valor nulo no permitido en columna id_cuenta_contable_pasivo");
					}
				}

				this.id_cuenta_contable_pasivo=newid_cuenta_contable_pasivo;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_cuenta_contable_inventario(Long newid_cuenta_contable_inventario)throws Exception
	{
		try {
			if(this.id_cuenta_contable_inventario!=newid_cuenta_contable_inventario) {
				if(newid_cuenta_contable_inventario==null) {
					//newid_cuenta_contable_inventario=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ParametroGrafico:Valor nulo no permitido en columna id_cuenta_contable_inventario");
					}
				}

				this.id_cuenta_contable_inventario=newid_cuenta_contable_inventario;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_cuenta_contable_disponibilidad(Long newid_cuenta_contable_disponibilidad)throws Exception
	{
		try {
			if(this.id_cuenta_contable_disponibilidad!=newid_cuenta_contable_disponibilidad) {
				if(newid_cuenta_contable_disponibilidad==null) {
					//newid_cuenta_contable_disponibilidad=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ParametroGrafico:Valor nulo no permitido en columna id_cuenta_contable_disponibilidad");
					}
				}

				this.id_cuenta_contable_disponibilidad=newid_cuenta_contable_disponibilidad;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_cuenta_contable_costo_venta(Long newid_cuenta_contable_costo_venta)throws Exception
	{
		try {
			if(this.id_cuenta_contable_costo_venta!=newid_cuenta_contable_costo_venta) {
				if(newid_cuenta_contable_costo_venta==null) {
					//newid_cuenta_contable_costo_venta=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ParametroGrafico:Valor nulo no permitido en columna id_cuenta_contable_costo_venta");
					}
				}

				this.id_cuenta_contable_costo_venta=newid_cuenta_contable_costo_venta;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_cuenta_contable_inventario_ini(Long newid_cuenta_contable_inventario_ini)throws Exception
	{
		try {
			if(this.id_cuenta_contable_inventario_ini!=newid_cuenta_contable_inventario_ini) {
				if(newid_cuenta_contable_inventario_ini==null) {
					//newid_cuenta_contable_inventario_ini=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ParametroGrafico:Valor nulo no permitido en columna id_cuenta_contable_inventario_ini");
					}
				}

				this.id_cuenta_contable_inventario_ini=newid_cuenta_contable_inventario_ini;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_cuenta_contable_inventario_fin(Long newid_cuenta_contable_inventario_fin)throws Exception
	{
		try {
			if(this.id_cuenta_contable_inventario_fin!=newid_cuenta_contable_inventario_fin) {
				if(newid_cuenta_contable_inventario_fin==null) {
					//newid_cuenta_contable_inventario_fin=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ParametroGrafico:Valor nulo no permitido en columna id_cuenta_contable_inventario_fin");
					}
				}

				this.id_cuenta_contable_inventario_fin=newid_cuenta_contable_inventario_fin;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_cuenta_contable_cuenta_cobrar(Long newid_cuenta_contable_cuenta_cobrar)throws Exception
	{
		try {
			if(this.id_cuenta_contable_cuenta_cobrar!=newid_cuenta_contable_cuenta_cobrar) {
				if(newid_cuenta_contable_cuenta_cobrar==null) {
					//newid_cuenta_contable_cuenta_cobrar=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ParametroGrafico:Valor nulo no permitido en columna id_cuenta_contable_cuenta_cobrar");
					}
				}

				this.id_cuenta_contable_cuenta_cobrar=newid_cuenta_contable_cuenta_cobrar;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_cuenta_contable_venta_credito(Long newid_cuenta_contable_venta_credito)throws Exception
	{
		try {
			if(this.id_cuenta_contable_venta_credito!=newid_cuenta_contable_venta_credito) {
				if(newid_cuenta_contable_venta_credito==null) {
					//newid_cuenta_contable_venta_credito=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ParametroGrafico:Valor nulo no permitido en columna id_cuenta_contable_venta_credito");
					}
				}

				this.id_cuenta_contable_venta_credito=newid_cuenta_contable_venta_credito;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_cuenta_contable_activo_total(Long newid_cuenta_contable_activo_total)throws Exception
	{
		try {
			if(this.id_cuenta_contable_activo_total!=newid_cuenta_contable_activo_total) {
				if(newid_cuenta_contable_activo_total==null) {
					//newid_cuenta_contable_activo_total=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ParametroGrafico:Valor nulo no permitido en columna id_cuenta_contable_activo_total");
					}
				}

				this.id_cuenta_contable_activo_total=newid_cuenta_contable_activo_total;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_cuenta_contable_pasivo_total(Long newid_cuenta_contable_pasivo_total)throws Exception
	{
		try {
			if(this.id_cuenta_contable_pasivo_total!=newid_cuenta_contable_pasivo_total) {
				if(newid_cuenta_contable_pasivo_total==null) {
					//newid_cuenta_contable_pasivo_total=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ParametroGrafico:Valor nulo no permitido en columna id_cuenta_contable_pasivo_total");
					}
				}

				this.id_cuenta_contable_pasivo_total=newid_cuenta_contable_pasivo_total;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_cuenta_contable_patrimonio(Long newid_cuenta_contable_patrimonio)throws Exception
	{
		try {
			if(this.id_cuenta_contable_patrimonio!=newid_cuenta_contable_patrimonio) {
				if(newid_cuenta_contable_patrimonio==null) {
					//newid_cuenta_contable_patrimonio=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ParametroGrafico:Valor nulo no permitido en columna id_cuenta_contable_patrimonio");
					}
				}

				this.id_cuenta_contable_patrimonio=newid_cuenta_contable_patrimonio;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_cuenta_contable_patrimonio_total(Long newid_cuenta_contable_patrimonio_total)throws Exception
	{
		try {
			if(this.id_cuenta_contable_patrimonio_total!=newid_cuenta_contable_patrimonio_total) {
				if(newid_cuenta_contable_patrimonio_total==null) {
					//newid_cuenta_contable_patrimonio_total=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ParametroGrafico:Valor nulo no permitido en columna id_cuenta_contable_patrimonio_total");
					}
				}

				this.id_cuenta_contable_patrimonio_total=newid_cuenta_contable_patrimonio_total;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_cuenta_contable_venta(Long newid_cuenta_contable_venta)throws Exception
	{
		try {
			if(this.id_cuenta_contable_venta!=newid_cuenta_contable_venta) {
				if(newid_cuenta_contable_venta==null) {
					//newid_cuenta_contable_venta=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ParametroGrafico:Valor nulo no permitido en columna id_cuenta_contable_venta");
					}
				}

				this.id_cuenta_contable_venta=newid_cuenta_contable_venta;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setinventario_inicial(Double newinventario_inicial)throws Exception
	{
		try {
			if(this.inventario_inicial!=newinventario_inicial) {
				if(newinventario_inicial==null) {
					//newinventario_inicial=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ParametroGrafico:Valor nulo no permitido en columna inventario_inicial");
					}
				}

				this.inventario_inicial=newinventario_inicial;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	
	public Empresa getEmpresa() {
		return this.empresa;
	}

	public CuentaContable getCuentaContableActivo() {
		return this.cuentacontableactivo;
	}

	public CuentaContable getCuentaContablePasivo() {
		return this.cuentacontablepasivo;
	}

	public CuentaContable getCuentaContableInventario() {
		return this.cuentacontableinventario;
	}

	public CuentaContable getCuentaContableDisponibilidad() {
		return this.cuentacontabledisponibilidad;
	}

	public CuentaContable getCuentaContableCostoVenta() {
		return this.cuentacontablecostoventa;
	}

	public CuentaContable getCuentaContableInventarioIni() {
		return this.cuentacontableinventarioini;
	}

	public CuentaContable getCuentaContableInventarioFin() {
		return this.cuentacontableinventariofin;
	}

	public CuentaContable getCuentaContableCuentasCobrar() {
		return this.cuentacontablecuentascobrar;
	}

	public CuentaContable getCuentaContableVentaCredito() {
		return this.cuentacontableventacredito;
	}

	public CuentaContable getCuentaContableActivoTotal() {
		return this.cuentacontableactivototal;
	}

	public CuentaContable getCuentaContablePasivoTotal() {
		return this.cuentacontablepasivototal;
	}

	public CuentaContable getCuentaContablePatrimonio() {
		return this.cuentacontablepatrimonio;
	}

	public CuentaContable getCuentaContablePatrimonioTotal() {
		return this.cuentacontablepatrimoniototal;
	}

	public CuentaContable getCuentaContableVenta() {
		return this.cuentacontableventa;
	}

	
	
	public String getempresa_descripcion() {
		return this.empresa_descripcion;
	}

	public String getcuentacontableactivo_descripcion() {
		return this.cuentacontableactivo_descripcion;
	}

	public String getcuentacontablepasivo_descripcion() {
		return this.cuentacontablepasivo_descripcion;
	}

	public String getcuentacontableinventario_descripcion() {
		return this.cuentacontableinventario_descripcion;
	}

	public String getcuentacontabledisponibilidad_descripcion() {
		return this.cuentacontabledisponibilidad_descripcion;
	}

	public String getcuentacontablecostoventa_descripcion() {
		return this.cuentacontablecostoventa_descripcion;
	}

	public String getcuentacontableinventarioini_descripcion() {
		return this.cuentacontableinventarioini_descripcion;
	}

	public String getcuentacontableinventariofin_descripcion() {
		return this.cuentacontableinventariofin_descripcion;
	}

	public String getcuentacontablecuentascobrar_descripcion() {
		return this.cuentacontablecuentascobrar_descripcion;
	}

	public String getcuentacontableventacredito_descripcion() {
		return this.cuentacontableventacredito_descripcion;
	}

	public String getcuentacontableactivototal_descripcion() {
		return this.cuentacontableactivototal_descripcion;
	}

	public String getcuentacontablepasivototal_descripcion() {
		return this.cuentacontablepasivototal_descripcion;
	}

	public String getcuentacontablepatrimonio_descripcion() {
		return this.cuentacontablepatrimonio_descripcion;
	}

	public String getcuentacontablepatrimoniototal_descripcion() {
		return this.cuentacontablepatrimoniototal_descripcion;
	}

	public String getcuentacontableventa_descripcion() {
		return this.cuentacontableventa_descripcion;
	}

	
	
	public  void  setEmpresa(Empresa empresa) {
		try {
			this.empresa=empresa;
		} catch(Exception e) {
			;
		}
	}


	public  void  setCuentaContableActivo(CuentaContable cuentacontableactivo) {
		try {
			this.cuentacontableactivo=cuentacontableactivo;
		} catch(Exception e) {
			;
		}
	}


	public  void  setCuentaContablePasivo(CuentaContable cuentacontablepasivo) {
		try {
			this.cuentacontablepasivo=cuentacontablepasivo;
		} catch(Exception e) {
			;
		}
	}


	public  void  setCuentaContableInventario(CuentaContable cuentacontableinventario) {
		try {
			this.cuentacontableinventario=cuentacontableinventario;
		} catch(Exception e) {
			;
		}
	}


	public  void  setCuentaContableDisponibilidad(CuentaContable cuentacontabledisponibilidad) {
		try {
			this.cuentacontabledisponibilidad=cuentacontabledisponibilidad;
		} catch(Exception e) {
			;
		}
	}


	public  void  setCuentaContableCostoVenta(CuentaContable cuentacontablecostoventa) {
		try {
			this.cuentacontablecostoventa=cuentacontablecostoventa;
		} catch(Exception e) {
			;
		}
	}


	public  void  setCuentaContableInventarioIni(CuentaContable cuentacontableinventarioini) {
		try {
			this.cuentacontableinventarioini=cuentacontableinventarioini;
		} catch(Exception e) {
			;
		}
	}


	public  void  setCuentaContableInventarioFin(CuentaContable cuentacontableinventariofin) {
		try {
			this.cuentacontableinventariofin=cuentacontableinventariofin;
		} catch(Exception e) {
			;
		}
	}


	public  void  setCuentaContableCuentasCobrar(CuentaContable cuentacontablecuentascobrar) {
		try {
			this.cuentacontablecuentascobrar=cuentacontablecuentascobrar;
		} catch(Exception e) {
			;
		}
	}


	public  void  setCuentaContableVentaCredito(CuentaContable cuentacontableventacredito) {
		try {
			this.cuentacontableventacredito=cuentacontableventacredito;
		} catch(Exception e) {
			;
		}
	}


	public  void  setCuentaContableActivoTotal(CuentaContable cuentacontableactivototal) {
		try {
			this.cuentacontableactivototal=cuentacontableactivototal;
		} catch(Exception e) {
			;
		}
	}


	public  void  setCuentaContablePasivoTotal(CuentaContable cuentacontablepasivototal) {
		try {
			this.cuentacontablepasivototal=cuentacontablepasivototal;
		} catch(Exception e) {
			;
		}
	}


	public  void  setCuentaContablePatrimonio(CuentaContable cuentacontablepatrimonio) {
		try {
			this.cuentacontablepatrimonio=cuentacontablepatrimonio;
		} catch(Exception e) {
			;
		}
	}


	public  void  setCuentaContablePatrimonioTotal(CuentaContable cuentacontablepatrimoniototal) {
		try {
			this.cuentacontablepatrimoniototal=cuentacontablepatrimoniototal;
		} catch(Exception e) {
			;
		}
	}


	public  void  setCuentaContableVenta(CuentaContable cuentacontableventa) {
		try {
			this.cuentacontableventa=cuentacontableventa;
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


	public  void  setcuentacontableactivo_descripcion(String cuentacontableactivo_descripcion) {
		try {
			this.cuentacontableactivo_descripcion=cuentacontableactivo_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  setcuentacontablepasivo_descripcion(String cuentacontablepasivo_descripcion) {
		try {
			this.cuentacontablepasivo_descripcion=cuentacontablepasivo_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  setcuentacontableinventario_descripcion(String cuentacontableinventario_descripcion) {
		try {
			this.cuentacontableinventario_descripcion=cuentacontableinventario_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  setcuentacontabledisponibilidad_descripcion(String cuentacontabledisponibilidad_descripcion) {
		try {
			this.cuentacontabledisponibilidad_descripcion=cuentacontabledisponibilidad_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  setcuentacontablecostoventa_descripcion(String cuentacontablecostoventa_descripcion) {
		try {
			this.cuentacontablecostoventa_descripcion=cuentacontablecostoventa_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  setcuentacontableinventarioini_descripcion(String cuentacontableinventarioini_descripcion) {
		try {
			this.cuentacontableinventarioini_descripcion=cuentacontableinventarioini_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  setcuentacontableinventariofin_descripcion(String cuentacontableinventariofin_descripcion) {
		try {
			this.cuentacontableinventariofin_descripcion=cuentacontableinventariofin_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  setcuentacontablecuentascobrar_descripcion(String cuentacontablecuentascobrar_descripcion) {
		try {
			this.cuentacontablecuentascobrar_descripcion=cuentacontablecuentascobrar_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  setcuentacontableventacredito_descripcion(String cuentacontableventacredito_descripcion) {
		try {
			this.cuentacontableventacredito_descripcion=cuentacontableventacredito_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  setcuentacontableactivototal_descripcion(String cuentacontableactivototal_descripcion) {
		try {
			this.cuentacontableactivototal_descripcion=cuentacontableactivototal_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  setcuentacontablepasivototal_descripcion(String cuentacontablepasivototal_descripcion) {
		try {
			this.cuentacontablepasivototal_descripcion=cuentacontablepasivototal_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  setcuentacontablepatrimonio_descripcion(String cuentacontablepatrimonio_descripcion) {
		try {
			this.cuentacontablepatrimonio_descripcion=cuentacontablepatrimonio_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  setcuentacontablepatrimoniototal_descripcion(String cuentacontablepatrimoniototal_descripcion) {
		try {
			this.cuentacontablepatrimoniototal_descripcion=cuentacontablepatrimoniototal_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  setcuentacontableventa_descripcion(String cuentacontableventa_descripcion) {
		try {
			this.cuentacontableventa_descripcion=cuentacontableventa_descripcion;
		} catch(Exception e) {
			;
		}
	}


	
	
	
	
	
	/*PARA REPORTES*/
	String id_empresa_descripcion="";String id_cuenta_contable_activo_descripcion="";String id_cuenta_contable_pasivo_descripcion="";String id_cuenta_contable_inventario_descripcion="";String id_cuenta_contable_disponibilidad_descripcion="";String id_cuenta_contable_costo_venta_descripcion="";String id_cuenta_contable_inventario_ini_descripcion="";String id_cuenta_contable_inventario_fin_descripcion="";String id_cuenta_contable_cuenta_cobrar_descripcion="";String id_cuenta_contable_venta_credito_descripcion="";String id_cuenta_contable_activo_total_descripcion="";String id_cuenta_contable_pasivo_total_descripcion="";String id_cuenta_contable_patrimonio_descripcion="";String id_cuenta_contable_patrimonio_total_descripcion="";String id_cuenta_contable_venta_descripcion="";
	
	
	public String getid_empresa_descripcion() {
		return id_empresa_descripcion;
	}
	public String getid_cuenta_contable_activo_descripcion() {
		return id_cuenta_contable_activo_descripcion;
	}
	public String getid_cuenta_contable_pasivo_descripcion() {
		return id_cuenta_contable_pasivo_descripcion;
	}
	public String getid_cuenta_contable_inventario_descripcion() {
		return id_cuenta_contable_inventario_descripcion;
	}
	public String getid_cuenta_contable_disponibilidad_descripcion() {
		return id_cuenta_contable_disponibilidad_descripcion;
	}
	public String getid_cuenta_contable_costo_venta_descripcion() {
		return id_cuenta_contable_costo_venta_descripcion;
	}
	public String getid_cuenta_contable_inventario_ini_descripcion() {
		return id_cuenta_contable_inventario_ini_descripcion;
	}
	public String getid_cuenta_contable_inventario_fin_descripcion() {
		return id_cuenta_contable_inventario_fin_descripcion;
	}
	public String getid_cuenta_contable_cuenta_cobrar_descripcion() {
		return id_cuenta_contable_cuenta_cobrar_descripcion;
	}
	public String getid_cuenta_contable_venta_credito_descripcion() {
		return id_cuenta_contable_venta_credito_descripcion;
	}
	public String getid_cuenta_contable_activo_total_descripcion() {
		return id_cuenta_contable_activo_total_descripcion;
	}
	public String getid_cuenta_contable_pasivo_total_descripcion() {
		return id_cuenta_contable_pasivo_total_descripcion;
	}
	public String getid_cuenta_contable_patrimonio_descripcion() {
		return id_cuenta_contable_patrimonio_descripcion;
	}
	public String getid_cuenta_contable_patrimonio_total_descripcion() {
		return id_cuenta_contable_patrimonio_total_descripcion;
	}
	public String getid_cuenta_contable_venta_descripcion() {
		return id_cuenta_contable_venta_descripcion;
	}
	
	
	public void setid_empresa_descripcion(String newid_empresa_descripcion)throws Exception {
		try {
			this.id_empresa_descripcion=newid_empresa_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_cuenta_contable_activo_descripcion(String newid_cuenta_contable_activo_descripcion)throws Exception {
		try {
			this.id_cuenta_contable_activo_descripcion=newid_cuenta_contable_activo_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_cuenta_contable_pasivo_descripcion(String newid_cuenta_contable_pasivo_descripcion)throws Exception {
		try {
			this.id_cuenta_contable_pasivo_descripcion=newid_cuenta_contable_pasivo_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_cuenta_contable_inventario_descripcion(String newid_cuenta_contable_inventario_descripcion)throws Exception {
		try {
			this.id_cuenta_contable_inventario_descripcion=newid_cuenta_contable_inventario_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_cuenta_contable_disponibilidad_descripcion(String newid_cuenta_contable_disponibilidad_descripcion)throws Exception {
		try {
			this.id_cuenta_contable_disponibilidad_descripcion=newid_cuenta_contable_disponibilidad_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_cuenta_contable_costo_venta_descripcion(String newid_cuenta_contable_costo_venta_descripcion)throws Exception {
		try {
			this.id_cuenta_contable_costo_venta_descripcion=newid_cuenta_contable_costo_venta_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_cuenta_contable_inventario_ini_descripcion(String newid_cuenta_contable_inventario_ini_descripcion)throws Exception {
		try {
			this.id_cuenta_contable_inventario_ini_descripcion=newid_cuenta_contable_inventario_ini_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_cuenta_contable_inventario_fin_descripcion(String newid_cuenta_contable_inventario_fin_descripcion)throws Exception {
		try {
			this.id_cuenta_contable_inventario_fin_descripcion=newid_cuenta_contable_inventario_fin_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_cuenta_contable_cuenta_cobrar_descripcion(String newid_cuenta_contable_cuenta_cobrar_descripcion)throws Exception {
		try {
			this.id_cuenta_contable_cuenta_cobrar_descripcion=newid_cuenta_contable_cuenta_cobrar_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_cuenta_contable_venta_credito_descripcion(String newid_cuenta_contable_venta_credito_descripcion)throws Exception {
		try {
			this.id_cuenta_contable_venta_credito_descripcion=newid_cuenta_contable_venta_credito_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_cuenta_contable_activo_total_descripcion(String newid_cuenta_contable_activo_total_descripcion)throws Exception {
		try {
			this.id_cuenta_contable_activo_total_descripcion=newid_cuenta_contable_activo_total_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_cuenta_contable_pasivo_total_descripcion(String newid_cuenta_contable_pasivo_total_descripcion)throws Exception {
		try {
			this.id_cuenta_contable_pasivo_total_descripcion=newid_cuenta_contable_pasivo_total_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_cuenta_contable_patrimonio_descripcion(String newid_cuenta_contable_patrimonio_descripcion)throws Exception {
		try {
			this.id_cuenta_contable_patrimonio_descripcion=newid_cuenta_contable_patrimonio_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_cuenta_contable_patrimonio_total_descripcion(String newid_cuenta_contable_patrimonio_total_descripcion)throws Exception {
		try {
			this.id_cuenta_contable_patrimonio_total_descripcion=newid_cuenta_contable_patrimonio_total_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_cuenta_contable_venta_descripcion(String newid_cuenta_contable_venta_descripcion)throws Exception {
		try {
			this.id_cuenta_contable_venta_descripcion=newid_cuenta_contable_venta_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	
	public void inicializarVariablesParaReporte() {
		this.id_empresa_descripcion="";this.id_cuenta_contable_activo_descripcion="";this.id_cuenta_contable_pasivo_descripcion="";this.id_cuenta_contable_inventario_descripcion="";this.id_cuenta_contable_disponibilidad_descripcion="";this.id_cuenta_contable_costo_venta_descripcion="";this.id_cuenta_contable_inventario_ini_descripcion="";this.id_cuenta_contable_inventario_fin_descripcion="";this.id_cuenta_contable_cuenta_cobrar_descripcion="";this.id_cuenta_contable_venta_credito_descripcion="";this.id_cuenta_contable_activo_total_descripcion="";this.id_cuenta_contable_pasivo_total_descripcion="";this.id_cuenta_contable_patrimonio_descripcion="";this.id_cuenta_contable_patrimonio_total_descripcion="";this.id_cuenta_contable_venta_descripcion="";
	}
	
	
	
	
	
	
	/*PARA REPORTES FIN*/		
}

