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
//import com.bydan.erp.contabilidad.util.TotalSaldosConstantesFunciones;
import com.bydan.erp.contabilidad.util.*;


import com.bydan.erp.contabilidad.util.*;

import com.bydan.erp.contabilidad.business.entity.*;


import com.bydan.erp.contabilidad.business.entity.*;




@SuppressWarnings("unused")
public class TotalSaldos extends TotalSaldosAdditional implements Serializable ,Cloneable {//TotalSaldosAdditional,GeneralEntity
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
	
	private TotalSaldos totalsaldosOriginal;
	
	private Map<String, Object> mapTotalSaldos;
			
	public Map<String, Object> getMapTotalSaldos() {
		return mapTotalSaldos;
	}

	public void setMapTotalSaldos(Map<String, Object> mapTotalSaldos) {
		this.mapTotalSaldos = mapTotalSaldos;
	}
	
	public void inicializarMapTotalSaldos() {
		this.mapTotalSaldos = new HashMap<String,Object>();
	}
	
	public void setMapTotalSaldosValue(String sKey,Object oValue) {
		this.mapTotalSaldos.put(sKey, oValue);
	}
	
	public Object getMapTotalSaldosValue(String sKey) {
		return this.mapTotalSaldos.get(sKey);
	}
	
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_cuenta_contable;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double total_debito;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double total_credito;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double total_debito_extranjero;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double total_credito_extranjero;
			
	
	public CuentaContable cuentacontable;
	
	
	private String cuentacontable_descripcion;
	
	
		
	public TotalSaldos () throws Exception {
		super();		
		
		this.id=0L;
		
		
		this.versionRow=new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());//new Date();
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		this.sType="NONE";
		
		this.totalsaldosOriginal=this;
		
 		this.id_cuenta_contable=-1L;
 		this.total_debito=0.0;
 		this.total_credito=0.0;
 		this.total_debito_extranjero=0.0;
 		this.total_credito_extranjero=0.0;
		
		
		this.cuentacontable=null;
		
		
		this.cuentacontable_descripcion="";
		
		
		
			
		
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
    //PARA REPORTES
	public TotalSaldos (Long id,Date versionRow,Long id_cuenta_contable,Double total_debito,Double total_credito,Double total_debito_extranjero,Double total_credito_extranjero) throws Exception {
		super();		
		
		this.id=id;
		this.versionRow=versionRow;
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.totalsaldosOriginal=this;
		
 		this.id_cuenta_contable=id_cuenta_contable;
 		this.total_debito=total_debito;
 		this.total_credito=total_credito;
 		this.total_debito_extranjero=total_debito_extranjero;
 		this.total_credito_extranjero=total_credito_extranjero;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	 //PARA REPORTES
	public TotalSaldos (Long id_cuenta_contable,Double total_debito,Double total_credito,Double total_debito_extranjero,Double total_credito_extranjero) throws Exception {
		super();		
		
		this.id=0L;
		this.versionRow=new Date();
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.totalsaldosOriginal=this;
		
 		this.id_cuenta_contable=id_cuenta_contable;
 		this.total_debito=total_debito;
 		this.total_credito=total_credito;
 		this.total_debito_extranjero=total_debito_extranjero;
 		this.total_credito_extranjero=total_credito_extranjero;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	
	public TotalSaldos getTotalSaldosOriginal() {
		return this.totalsaldosOriginal;
	}
	
	public void setTotalSaldosOriginal(TotalSaldos totalsaldos) {
		try {
			this.totalsaldosOriginal=totalsaldos;
		} catch(Exception e) {
			;
		}
	}
	
	
	protected TotalSaldosAdditional totalsaldosAdditional=null;
	
	public TotalSaldosAdditional getTotalSaldosAdditional() {
		return this.totalsaldosAdditional;
	}
	
	public void setTotalSaldosAdditional(TotalSaldosAdditional totalsaldosAdditional) {
		try {
			this.totalsaldosAdditional=totalsaldosAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
    
	
	public Long getid_cuenta_contable() {
		return this.id_cuenta_contable;
	}
    
	
	public Double gettotal_debito() {
		return this.total_debito;
	}
    
	
	public Double gettotal_credito() {
		return this.total_credito;
	}
    
	
	public Double gettotal_debito_extranjero() {
		return this.total_debito_extranjero;
	}
    
	
	public Double gettotal_credito_extranjero() {
		return this.total_credito_extranjero;
	}
	
    
	public void setid_cuenta_contable(Long newid_cuenta_contable)throws Exception
	{
		try {
			if(this.id_cuenta_contable!=newid_cuenta_contable) {
				if(newid_cuenta_contable==null) {
					//newid_cuenta_contable=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("TotalSaldos:Valor nulo no permitido en columna id_cuenta_contable");
					}
				}

				this.id_cuenta_contable=newid_cuenta_contable;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void settotal_debito(Double newtotal_debito)throws Exception
	{
		try {
			if(this.total_debito!=newtotal_debito) {
				if(newtotal_debito==null) {
					//newtotal_debito=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("TotalSaldos:Valor nulo no permitido en columna total_debito");
					}
				}

				this.total_debito=newtotal_debito;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void settotal_credito(Double newtotal_credito)throws Exception
	{
		try {
			if(this.total_credito!=newtotal_credito) {
				if(newtotal_credito==null) {
					//newtotal_credito=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("TotalSaldos:Valor nulo no permitido en columna total_credito");
					}
				}

				this.total_credito=newtotal_credito;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void settotal_debito_extranjero(Double newtotal_debito_extranjero)throws Exception
	{
		try {
			if(this.total_debito_extranjero!=newtotal_debito_extranjero) {
				if(newtotal_debito_extranjero==null) {
					//newtotal_debito_extranjero=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("TotalSaldos:Valor nulo no permitido en columna total_debito_extranjero");
					}
				}

				this.total_debito_extranjero=newtotal_debito_extranjero;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void settotal_credito_extranjero(Double newtotal_credito_extranjero)throws Exception
	{
		try {
			if(this.total_credito_extranjero!=newtotal_credito_extranjero) {
				if(newtotal_credito_extranjero==null) {
					//newtotal_credito_extranjero=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("TotalSaldos:Valor nulo no permitido en columna total_credito_extranjero");
					}
				}

				this.total_credito_extranjero=newtotal_credito_extranjero;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	
	public CuentaContable getCuentaContable() {
		return this.cuentacontable;
	}

	
	
	public String getcuentacontable_descripcion() {
		return this.cuentacontable_descripcion;
	}

	
	
	public  void  setCuentaContable(CuentaContable cuentacontable) {
		try {
			this.cuentacontable=cuentacontable;
		} catch(Exception e) {
			;
		}
	}


	
	
	public  void  setcuentacontable_descripcion(String cuentacontable_descripcion) {
		try {
			this.cuentacontable_descripcion=cuentacontable_descripcion;
		} catch(Exception e) {
			;
		}
	}


	
	
	
	
	
	/*PARA REPORTES*/
	String id_cuenta_contable_descripcion="";
	
	
	public String getid_cuenta_contable_descripcion() {
		return id_cuenta_contable_descripcion;
	}
	
	
	public void setid_cuenta_contable_descripcion(String newid_cuenta_contable_descripcion)throws Exception {
		try {
			this.id_cuenta_contable_descripcion=newid_cuenta_contable_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	
	public void inicializarVariablesParaReporte() {
		this.id_cuenta_contable_descripcion="";
	}
	
	
	
	
	
	
	/*PARA REPORTES FIN*/		
}

