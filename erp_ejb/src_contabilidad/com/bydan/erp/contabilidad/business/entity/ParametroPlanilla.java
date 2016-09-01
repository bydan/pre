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
//import com.bydan.erp.contabilidad.util.ParametroPlanillaConstantesFunciones;
import com.bydan.erp.contabilidad.util.*;


import com.bydan.erp.seguridad.util.*;



import com.bydan.erp.seguridad.business.entity.*;




@SuppressWarnings("unused")
public class ParametroPlanilla extends ParametroPlanillaAdditional implements Serializable ,Cloneable {//ParametroPlanillaAdditional,GeneralEntity
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
	
	private ParametroPlanilla parametroplanillaOriginal;
	
	private Map<String, Object> mapParametroPlanilla;
			
	public Map<String, Object> getMapParametroPlanilla() {
		return mapParametroPlanilla;
	}

	public void setMapParametroPlanilla(Map<String, Object> mapParametroPlanilla) {
		this.mapParametroPlanilla = mapParametroPlanilla;
	}
	
	public void inicializarMapParametroPlanilla() {
		this.mapParametroPlanilla = new HashMap<String,Object>();
	}
	
	public void setMapParametroPlanillaValue(String sKey,Object oValue) {
		this.mapParametroPlanilla.put(sKey, oValue);
	}
	
	public Object getMapParametroPlanillaValue(String sKey) {
		return this.mapParametroPlanilla.get(sKey);
	}
	
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_empresa;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_cuenta_contable_inicial;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_cuenta_contable_final;
			
	
	public Empresa empresa;
	public CuentaContable cuentacontableinicial;
	public CuentaContable cuentacontablefinal;
	
	
	private String empresa_descripcion;
	private String cuentacontableinicial_descripcion;
	private String cuentacontablefinal_descripcion;
	
	
		
	public ParametroPlanilla () throws Exception {
		super();		
		
		this.id=0L;
		
		
		this.versionRow=new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());//new Date();
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		this.sType="NONE";
		
		this.parametroplanillaOriginal=this;
		
 		this.id_empresa=-1L;
 		this.id_cuenta_contable_inicial=-1L;
 		this.id_cuenta_contable_final=-1L;
		
		
		this.empresa=null;
		this.cuentacontableinicial=null;
		this.cuentacontablefinal=null;
		
		
		this.empresa_descripcion="";
		this.cuentacontableinicial_descripcion="";
		this.cuentacontablefinal_descripcion="";
		
		
		
			
		
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
    //PARA REPORTES
	public ParametroPlanilla (Long id,Date versionRow,Long id_empresa,Long id_cuenta_contable_inicial,Long id_cuenta_contable_final) throws Exception {
		super();		
		
		this.id=id;
		this.versionRow=versionRow;
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.parametroplanillaOriginal=this;
		
 		this.id_empresa=id_empresa;
 		this.id_cuenta_contable_inicial=id_cuenta_contable_inicial;
 		this.id_cuenta_contable_final=id_cuenta_contable_final;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	 //PARA REPORTES
	public ParametroPlanilla (Long id_empresa,Long id_cuenta_contable_inicial,Long id_cuenta_contable_final) throws Exception {
		super();		
		
		this.id=0L;
		this.versionRow=new Date();
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.parametroplanillaOriginal=this;
		
 		this.id_empresa=id_empresa;
 		this.id_cuenta_contable_inicial=id_cuenta_contable_inicial;
 		this.id_cuenta_contable_final=id_cuenta_contable_final;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	public boolean equals(Object object) {
		boolean equal=false;
		ParametroPlanilla parametroplanillaLocal=null;
		
		if(object!=null) {
			parametroplanillaLocal=(ParametroPlanilla)object;
			
			if(parametroplanillaLocal!=null) {
				if(this.getId()!=null && parametroplanillaLocal.getId()!=null) {
					if(this.getId().equals(parametroplanillaLocal.getId())) {
						equal=true;
					}
				}
			}
		}
		
		return equal;
	}
	
	public String toString() {
		String sDetalle="";
		
		if(!ParametroPlanillaConstantesFunciones.CON_DESCRIPCION_DETALLADO) {
        	sDetalle=ParametroPlanillaConstantesFunciones.getParametroPlanillaDescripcion(this);
		} else {
			sDetalle=ParametroPlanillaConstantesFunciones.getParametroPlanillaDescripcionDetallado(this);
		}
		
		return sDetalle;
    }
	
	public ParametroPlanilla getParametroPlanillaOriginal() {
		return this.parametroplanillaOriginal;
	}
	
	public void setParametroPlanillaOriginal(ParametroPlanilla parametroplanilla) {
		try {
			this.parametroplanillaOriginal=parametroplanilla;
		} catch(Exception e) {
			;
		}
	}
	
	
	protected ParametroPlanillaAdditional parametroplanillaAdditional=null;
	
	public ParametroPlanillaAdditional getParametroPlanillaAdditional() {
		return this.parametroplanillaAdditional;
	}
	
	public void setParametroPlanillaAdditional(ParametroPlanillaAdditional parametroplanillaAdditional) {
		try {
			this.parametroplanillaAdditional=parametroplanillaAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
    
	
	public Long getid_empresa() {
		return this.id_empresa;
	}
    
	
	public Long getid_cuenta_contable_inicial() {
		return this.id_cuenta_contable_inicial;
	}
    
	
	public Long getid_cuenta_contable_final() {
		return this.id_cuenta_contable_final;
	}
	
    
	public void setid_empresa(Long newid_empresa)throws Exception
	{
		try {
			if(this.id_empresa!=newid_empresa) {
				if(newid_empresa==null) {
					//newid_empresa=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ParametroPlanilla:Valor nulo no permitido en columna id_empresa");
					}
				}

				this.id_empresa=newid_empresa;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_cuenta_contable_inicial(Long newid_cuenta_contable_inicial)throws Exception
	{
		try {
			if(this.id_cuenta_contable_inicial!=newid_cuenta_contable_inicial) {
				if(newid_cuenta_contable_inicial==null) {
					//newid_cuenta_contable_inicial=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ParametroPlanilla:Valor nulo no permitido en columna id_cuenta_contable_inicial");
					}
				}

				this.id_cuenta_contable_inicial=newid_cuenta_contable_inicial;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_cuenta_contable_final(Long newid_cuenta_contable_final)throws Exception
	{
		try {
			if(this.id_cuenta_contable_final!=newid_cuenta_contable_final) {
				if(newid_cuenta_contable_final==null) {
					//newid_cuenta_contable_final=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ParametroPlanilla:Valor nulo no permitido en columna id_cuenta_contable_final");
					}
				}

				this.id_cuenta_contable_final=newid_cuenta_contable_final;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	
	public Empresa getEmpresa() {
		return this.empresa;
	}

	public CuentaContable getCuentaContableInicial() {
		return this.cuentacontableinicial;
	}

	public CuentaContable getCuentaContableFinal() {
		return this.cuentacontablefinal;
	}

	
	
	public String getempresa_descripcion() {
		return this.empresa_descripcion;
	}

	public String getcuentacontableinicial_descripcion() {
		return this.cuentacontableinicial_descripcion;
	}

	public String getcuentacontablefinal_descripcion() {
		return this.cuentacontablefinal_descripcion;
	}

	
	
	public  void  setEmpresa(Empresa empresa) {
		try {
			this.empresa=empresa;
		} catch(Exception e) {
			;
		}
	}


	public  void  setCuentaContableInicial(CuentaContable cuentacontableinicial) {
		try {
			this.cuentacontableinicial=cuentacontableinicial;
		} catch(Exception e) {
			;
		}
	}


	public  void  setCuentaContableFinal(CuentaContable cuentacontablefinal) {
		try {
			this.cuentacontablefinal=cuentacontablefinal;
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


	public  void  setcuentacontableinicial_descripcion(String cuentacontableinicial_descripcion) {
		try {
			this.cuentacontableinicial_descripcion=cuentacontableinicial_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  setcuentacontablefinal_descripcion(String cuentacontablefinal_descripcion) {
		try {
			this.cuentacontablefinal_descripcion=cuentacontablefinal_descripcion;
		} catch(Exception e) {
			;
		}
	}


	
	
	
	
	
	/*PARA REPORTES*/
	String id_empresa_descripcion="";String id_cuenta_contable_inicial_descripcion="";String id_cuenta_contable_final_descripcion="";
	
	
	public String getid_empresa_descripcion() {
		return id_empresa_descripcion;
	}
	public String getid_cuenta_contable_inicial_descripcion() {
		return id_cuenta_contable_inicial_descripcion;
	}
	public String getid_cuenta_contable_final_descripcion() {
		return id_cuenta_contable_final_descripcion;
	}
	
	
	public void setid_empresa_descripcion(String newid_empresa_descripcion)throws Exception {
		try {
			this.id_empresa_descripcion=newid_empresa_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_cuenta_contable_inicial_descripcion(String newid_cuenta_contable_inicial_descripcion)throws Exception {
		try {
			this.id_cuenta_contable_inicial_descripcion=newid_cuenta_contable_inicial_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_cuenta_contable_final_descripcion(String newid_cuenta_contable_final_descripcion)throws Exception {
		try {
			this.id_cuenta_contable_final_descripcion=newid_cuenta_contable_final_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	
	public void inicializarVariablesParaReporte() {
		this.id_empresa_descripcion="";this.id_cuenta_contable_inicial_descripcion="";this.id_cuenta_contable_final_descripcion="";
	}
	
	
	
	
	
	
	/*PARA REPORTES FIN*/		
}

