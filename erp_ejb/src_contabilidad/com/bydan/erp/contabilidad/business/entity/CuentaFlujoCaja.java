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
//import com.bydan.erp.contabilidad.util.CuentaFlujoCajaConstantesFunciones;
import com.bydan.erp.contabilidad.util.*;


import com.bydan.erp.seguridad.util.*;



import com.bydan.erp.seguridad.business.entity.*;




@SuppressWarnings("unused")
public class CuentaFlujoCaja extends CuentaFlujoCajaAdditional implements Serializable ,Cloneable {//CuentaFlujoCajaAdditional,GeneralEntity
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
	
	private CuentaFlujoCaja cuentaflujocajaOriginal;
	
	private Map<String, Object> mapCuentaFlujoCaja;
			
	public Map<String, Object> getMapCuentaFlujoCaja() {
		return mapCuentaFlujoCaja;
	}

	public void setMapCuentaFlujoCaja(Map<String, Object> mapCuentaFlujoCaja) {
		this.mapCuentaFlujoCaja = mapCuentaFlujoCaja;
	}
	
	public void inicializarMapCuentaFlujoCaja() {
		this.mapCuentaFlujoCaja = new HashMap<String,Object>();
	}
	
	public void setMapCuentaFlujoCajaValue(String sKey,Object oValue) {
		this.mapCuentaFlujoCaja.put(sKey, oValue);
	}
	
	public Object getMapCuentaFlujoCajaValue(String sKey) {
		return this.mapCuentaFlujoCaja.get(sKey);
	}
	
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_empresa;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=150,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=CuentaFlujoCajaConstantesFunciones.SREGEXNOMBRE,message=CuentaFlujoCajaConstantesFunciones.SMENSAJEREGEXNOMBRE)
	private String nombre;
	
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_mes;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_dia;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_cuenta_contable;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=200,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@Pattern(regex=CuentaFlujoCajaConstantesFunciones.SREGEXFORMULA,message=CuentaFlujoCajaConstantesFunciones.SMENSAJEREGEXFORMULA)
	private String formula;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Boolean es_flujo_caja;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Boolean con_agrupar;
			
	
	public Empresa empresa;
	public Mes mes;
	public Dia dia;
	public CuentaContable cuentacontable;
	
	
	private String empresa_descripcion;
	private String mes_descripcion;
	private String dia_descripcion;
	private String cuentacontable_descripcion;
	
	
	public List<DetalleCuentaFlujoCaja> detallecuentaflujocajas;
		
	public CuentaFlujoCaja () throws Exception {
		super();		
		
		this.id=0L;
		
		
		this.versionRow=new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());//new Date();
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		this.sType="NONE";
		
		this.cuentaflujocajaOriginal=this;
		
 		this.id_empresa=-1L;
 		this.nombre="";
 		this.id_mes=null;
 		this.id_dia=-1L;
 		this.id_cuenta_contable=-1L;
 		this.formula="";
 		this.es_flujo_caja=false;
 		this.con_agrupar=false;
		
		
		this.empresa=null;
		this.mes=null;
		this.dia=null;
		this.cuentacontable=null;
		
		
		this.empresa_descripcion="";
		this.mes_descripcion="";
		this.dia_descripcion="";
		this.cuentacontable_descripcion="";
		
		
		this.detallecuentaflujocajas=null;
		
			
		
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
    //PARA REPORTES
	public CuentaFlujoCaja (Long id,Date versionRow,Long id_empresa,String nombre,Long id_mes,Long id_dia,Long id_cuenta_contable,String formula,Boolean es_flujo_caja,Boolean con_agrupar) throws Exception {
		super();		
		
		this.id=id;
		this.versionRow=versionRow;
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.cuentaflujocajaOriginal=this;
		
 		this.id_empresa=id_empresa;
 		this.nombre=nombre;
 		this.id_mes=id_mes;
 		this.id_dia=id_dia;
 		this.id_cuenta_contable=id_cuenta_contable;
 		this.formula=formula;
 		this.es_flujo_caja=es_flujo_caja;
 		this.con_agrupar=con_agrupar;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	 //PARA REPORTES
	public CuentaFlujoCaja (Long id_empresa,String nombre,Long id_mes,Long id_dia,Long id_cuenta_contable,String formula,Boolean es_flujo_caja,Boolean con_agrupar) throws Exception {
		super();		
		
		this.id=0L;
		this.versionRow=new Date();
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.cuentaflujocajaOriginal=this;
		
 		this.id_empresa=id_empresa;
 		this.nombre=nombre;
 		this.id_mes=id_mes;
 		this.id_dia=id_dia;
 		this.id_cuenta_contable=id_cuenta_contable;
 		this.formula=formula;
 		this.es_flujo_caja=es_flujo_caja;
 		this.con_agrupar=con_agrupar;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	public boolean equals(Object object) {
		boolean equal=false;
		CuentaFlujoCaja cuentaflujocajaLocal=null;
		
		if(object!=null) {
			cuentaflujocajaLocal=(CuentaFlujoCaja)object;
			
			if(cuentaflujocajaLocal!=null) {
				if(this.getId()!=null && cuentaflujocajaLocal.getId()!=null) {
					if(this.getId().equals(cuentaflujocajaLocal.getId())) {
						equal=true;
					}
				}
			}
		}
		
		return equal;
	}
	
	public String toString() {
		String sDetalle="";
		
		if(!CuentaFlujoCajaConstantesFunciones.CON_DESCRIPCION_DETALLADO) {
        	sDetalle=CuentaFlujoCajaConstantesFunciones.getCuentaFlujoCajaDescripcion(this);
		} else {
			sDetalle=CuentaFlujoCajaConstantesFunciones.getCuentaFlujoCajaDescripcionDetallado(this);
		}
		
		return sDetalle;
    }
	
	public CuentaFlujoCaja getCuentaFlujoCajaOriginal() {
		return this.cuentaflujocajaOriginal;
	}
	
	public void setCuentaFlujoCajaOriginal(CuentaFlujoCaja cuentaflujocaja) {
		try {
			this.cuentaflujocajaOriginal=cuentaflujocaja;
		} catch(Exception e) {
			;
		}
	}
	
	
	protected CuentaFlujoCajaAdditional cuentaflujocajaAdditional=null;
	
	public CuentaFlujoCajaAdditional getCuentaFlujoCajaAdditional() {
		return this.cuentaflujocajaAdditional;
	}
	
	public void setCuentaFlujoCajaAdditional(CuentaFlujoCajaAdditional cuentaflujocajaAdditional) {
		try {
			this.cuentaflujocajaAdditional=cuentaflujocajaAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
    
	
	public Long getid_empresa() {
		return this.id_empresa;
	}
    
	
	public String getnombre() {
		return this.nombre;
	}
    
	
	public Long getid_mes() {
		return this.id_mes;
	}
    
	
	public Long getid_dia() {
		return this.id_dia;
	}
    
	
	public Long getid_cuenta_contable() {
		return this.id_cuenta_contable;
	}
    
	
	public String getformula() {
		return this.formula;
	}
    
	
	public Boolean getes_flujo_caja() {
		return this.es_flujo_caja;
	}
    
	
	public Boolean getcon_agrupar() {
		return this.con_agrupar;
	}
	
    
	public void setid_empresa(Long newid_empresa)throws Exception
	{
		try {
			if(this.id_empresa!=newid_empresa) {
				if(newid_empresa==null) {
					//newid_empresa=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("CuentaFlujoCaja:Valor nulo no permitido en columna id_empresa");
					}
				}

				this.id_empresa=newid_empresa;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setnombre(String newnombre)throws Exception
	{
		try {
			if(this.nombre!=newnombre) {
				if(newnombre==null) {
					//newnombre="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("CuentaFlujoCaja:Valor nulo no permitido en columna nombre");
					}
				}

				if(newnombre!=null&&newnombre.length()>150) {
					newnombre=newnombre.substring(0,148);
					System.out.println("CuentaFlujoCaja:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=150 en columna nombre");
				}

				this.nombre=newnombre;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
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
    
	public void setid_dia(Long newid_dia)throws Exception
	{
		try {
			if(this.id_dia!=newid_dia) {
				if(newid_dia==null) {
					//newid_dia=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("CuentaFlujoCaja:Valor nulo no permitido en columna id_dia");
					}
				}

				this.id_dia=newid_dia;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_cuenta_contable(Long newid_cuenta_contable)throws Exception
	{
		try {
			if(this.id_cuenta_contable!=newid_cuenta_contable) {
				if(newid_cuenta_contable==null) {
					//newid_cuenta_contable=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("CuentaFlujoCaja:Valor nulo no permitido en columna id_cuenta_contable");
					}
				}

				this.id_cuenta_contable=newid_cuenta_contable;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setformula(String newformula)throws Exception
	{
		try {
			if(this.formula!=newformula) {
				if(newformula==null) {
					//newformula="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("CuentaFlujoCaja:Valor nulo no permitido en columna formula");
					}
				}

				if(newformula!=null&&newformula.length()>200) {
					newformula=newformula.substring(0,198);
					System.out.println("CuentaFlujoCaja:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=200 en columna formula");
				}

				this.formula=newformula;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setes_flujo_caja(Boolean newes_flujo_caja)throws Exception
	{
		try {
			if(this.es_flujo_caja!=newes_flujo_caja) {
				if(newes_flujo_caja==null) {
					//newes_flujo_caja=false;
					if(Constantes.ISDEVELOPING) {
						System.out.println("CuentaFlujoCaja:Valor nulo no permitido en columna es_flujo_caja");
					}
				}

				this.es_flujo_caja=newes_flujo_caja;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setcon_agrupar(Boolean newcon_agrupar)throws Exception
	{
		try {
			if(this.con_agrupar!=newcon_agrupar) {
				if(newcon_agrupar==null) {
					//newcon_agrupar=false;
					if(Constantes.ISDEVELOPING) {
						System.out.println("CuentaFlujoCaja:Valor nulo no permitido en columna con_agrupar");
					}
				}

				this.con_agrupar=newcon_agrupar;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	
	public Empresa getEmpresa() {
		return this.empresa;
	}

	public Mes getMes() {
		return this.mes;
	}

	public Dia getDia() {
		return this.dia;
	}

	public CuentaContable getCuentaContable() {
		return this.cuentacontable;
	}

	
	
	public String getempresa_descripcion() {
		return this.empresa_descripcion;
	}

	public String getmes_descripcion() {
		return this.mes_descripcion;
	}

	public String getdia_descripcion() {
		return this.dia_descripcion;
	}

	public String getcuentacontable_descripcion() {
		return this.cuentacontable_descripcion;
	}

	
	
	public  void  setEmpresa(Empresa empresa) {
		try {
			this.empresa=empresa;
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


	public  void  setDia(Dia dia) {
		try {
			this.dia=dia;
		} catch(Exception e) {
			;
		}
	}


	public  void  setCuentaContable(CuentaContable cuentacontable) {
		try {
			this.cuentacontable=cuentacontable;
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


	public  void  setmes_descripcion(String mes_descripcion) {
		try {
			this.mes_descripcion=mes_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  setdia_descripcion(String dia_descripcion) {
		try {
			this.dia_descripcion=dia_descripcion;
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


	
	
	public List<DetalleCuentaFlujoCaja> getDetalleCuentaFlujoCajas() {
		return this.detallecuentaflujocajas;
	}

	
	
	public  void  setDetalleCuentaFlujoCajas(List<DetalleCuentaFlujoCaja> detallecuentaflujocajas) {
		try {
			this.detallecuentaflujocajas=detallecuentaflujocajas;
		} catch(Exception e) {
			;
		}
	}

	
	/*PARA REPORTES*/
	String id_empresa_descripcion="";String id_mes_descripcion="";String id_dia_descripcion="";String id_cuenta_contable_descripcion="";String es_flujo_caja_descripcion="";String con_agrupar_descripcion="";
	
	
	public String getid_empresa_descripcion() {
		return id_empresa_descripcion;
	}
	public String getid_mes_descripcion() {
		return id_mes_descripcion;
	}
	public String getid_dia_descripcion() {
		return id_dia_descripcion;
	}
	public String getid_cuenta_contable_descripcion() {
		return id_cuenta_contable_descripcion;
	}
	public String getes_flujo_caja_descripcion() {
		return es_flujo_caja_descripcion;
	}
	public String getcon_agrupar_descripcion() {
		return con_agrupar_descripcion;
	}
	
	
	public void setid_empresa_descripcion(String newid_empresa_descripcion)throws Exception {
		try {
			this.id_empresa_descripcion=newid_empresa_descripcion;
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
	public void setid_dia_descripcion(String newid_dia_descripcion)throws Exception {
		try {
			this.id_dia_descripcion=newid_dia_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_cuenta_contable_descripcion(String newid_cuenta_contable_descripcion)throws Exception {
		try {
			this.id_cuenta_contable_descripcion=newid_cuenta_contable_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setes_flujo_caja_descripcion(String newes_flujo_caja_descripcion)throws Exception {
		try {
			this.es_flujo_caja_descripcion=newes_flujo_caja_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setcon_agrupar_descripcion(String newcon_agrupar_descripcion)throws Exception {
		try {
			this.con_agrupar_descripcion=newcon_agrupar_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	
	public void inicializarVariablesParaReporte() {
		this.id_empresa_descripcion="";this.id_mes_descripcion="";this.id_dia_descripcion="";this.id_cuenta_contable_descripcion="";this.es_flujo_caja_descripcion="";this.con_agrupar_descripcion="";
	}
	
	
	Object detallecuentaflujocajasDescripcionReporte;
	
	
	public Object getdetallecuentaflujocajasDescripcionReporte() {
		return detallecuentaflujocajasDescripcionReporte;
	}

	
	
	public  void  setdetallecuentaflujocajasDescripcionReporte(Object detallecuentaflujocajas) {
		try {
			this.detallecuentaflujocajasDescripcionReporte=detallecuentaflujocajas;
		} catch(Exception ex) {
			;
		}
	}

	/*PARA REPORTES FIN*/		
}

