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
package com.bydan.erp.cartera.business.entity.report;

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
//import com.bydan.erp.cartera.util.CobrarMorosidadClientesDetalladosConstantesFunciones;
import com.bydan.erp.cartera.util.*;


import com.bydan.erp.seguridad.util.*;

import com.bydan.erp.cartera.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;




@SuppressWarnings("unused")
public class CobrarMorosidadClientesDetallados extends CobrarMorosidadClientesDetalladosAdditional implements Serializable ,Cloneable {//CobrarMorosidadClientesDetalladosAdditional,GeneralEntity
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
	
	private CobrarMorosidadClientesDetallados cobrarmorosidadclientesdetalladosOriginal;
	
	private Map<String, Object> mapCobrarMorosidadClientesDetallados;
			
	public Map<String, Object> getMapCobrarMorosidadClientesDetallados() {
		return mapCobrarMorosidadClientesDetallados;
	}

	public void setMapCobrarMorosidadClientesDetallados(Map<String, Object> mapCobrarMorosidadClientesDetallados) {
		this.mapCobrarMorosidadClientesDetallados = mapCobrarMorosidadClientesDetallados;
	}
	
	public void inicializarMapCobrarMorosidadClientesDetallados() {
		this.mapCobrarMorosidadClientesDetallados = new HashMap<String,Object>();
	}
	
	public void setMapCobrarMorosidadClientesDetalladosValue(String sKey,Object oValue) {
		this.mapCobrarMorosidadClientesDetallados.put(sKey, oValue);
	}
	
	public Object getMapCobrarMorosidadClientesDetalladosValue(String sKey) {
		return this.mapCobrarMorosidadClientesDetallados.get(sKey);
	}
	
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_empresa;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Date fecha_vence;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=50,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	//@Pattern(regex=CobrarMorosidadClientesDetalladosConstantesFunciones.SREGEXCODIGO,message=CobrarMorosidadClientesDetalladosConstantesFunciones.SMENSAJEREGEXCODIGO)
	private String codigo;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=150,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	//@Pattern(regex=CobrarMorosidadClientesDetalladosConstantesFunciones.SREGEXNOMBRE_COMPLETO,message=CobrarMorosidadClientesDetalladosConstantesFunciones.SMENSAJEREGEXNOMBRE_COMPLETO)
	private String nombre_completo;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=50,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	//@Pattern(regex=CobrarMorosidadClientesDetalladosConstantesFunciones.SREGEXNUMERO_PRE_IMPRESO_FACTURA,message=CobrarMorosidadClientesDetalladosConstantesFunciones.SMENSAJEREGEXNUMERO_PRE_IMPRESO_FACTURA)
	private String numero_pre_impreso_factura;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double saldo_vencido;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double saldo_vencer;
			
	
	public Empresa empresa;
	
	
	private String empresa_descripcion;
	
	
		
	public CobrarMorosidadClientesDetallados () throws Exception {
		super();		
		
		this.id=0L;
		
		
		this.versionRow=new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());//new Date();
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		this.sType="NONE";
		
		this.cobrarmorosidadclientesdetalladosOriginal=this;
		
 		this.id_empresa=-1L;
 		this.fecha_vence=new Date();
 		this.codigo="";
 		this.nombre_completo="";
 		this.numero_pre_impreso_factura="";
 		this.saldo_vencido=0.0;
 		this.saldo_vencer=0.0;
		
		
		this.empresa=null;
		
		
		this.empresa_descripcion="";
		
		
		
			
		
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
    //PARA REPORTES
	public CobrarMorosidadClientesDetallados (Long id,Date versionRow,String codigo,String nombre_completo,String numero_pre_impreso_factura,Double saldo_vencido,Double saldo_vencer) throws Exception {
		super();		
		
		this.id=id;
		this.versionRow=versionRow;
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.cobrarmorosidadclientesdetalladosOriginal=this;
		
 		this.codigo=codigo;
 		this.nombre_completo=nombre_completo;
 		this.numero_pre_impreso_factura=numero_pre_impreso_factura;
 		this.saldo_vencido=saldo_vencido;
 		this.saldo_vencer=saldo_vencer;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	 //PARA REPORTES
	public CobrarMorosidadClientesDetallados (String codigo,String nombre_completo,String numero_pre_impreso_factura,Double saldo_vencido,Double saldo_vencer) throws Exception {
		super();		
		
		this.id=0L;
		this.versionRow=new Date();
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.cobrarmorosidadclientesdetalladosOriginal=this;
		
 		this.codigo=codigo;
 		this.nombre_completo=nombre_completo;
 		this.numero_pre_impreso_factura=numero_pre_impreso_factura;
 		this.saldo_vencido=saldo_vencido;
 		this.saldo_vencer=saldo_vencer;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	
	public CobrarMorosidadClientesDetallados getCobrarMorosidadClientesDetalladosOriginal() {
		return this.cobrarmorosidadclientesdetalladosOriginal;
	}
	
	public void setCobrarMorosidadClientesDetalladosOriginal(CobrarMorosidadClientesDetallados cobrarmorosidadclientesdetallados) {
		try {
			this.cobrarmorosidadclientesdetalladosOriginal=cobrarmorosidadclientesdetallados;
		} catch(Exception e) {
			;
		}
	}
	
	
	protected CobrarMorosidadClientesDetalladosAdditional cobrarmorosidadclientesdetalladosAdditional=null;
	
	public CobrarMorosidadClientesDetalladosAdditional getCobrarMorosidadClientesDetalladosAdditional() {
		return this.cobrarmorosidadclientesdetalladosAdditional;
	}
	
	public void setCobrarMorosidadClientesDetalladosAdditional(CobrarMorosidadClientesDetalladosAdditional cobrarmorosidadclientesdetalladosAdditional) {
		try {
			this.cobrarmorosidadclientesdetalladosAdditional=cobrarmorosidadclientesdetalladosAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
    
	
	public Long getid_empresa() {
		return this.id_empresa;
	}
    
	
	public Date getfecha_vence() {
		return this.fecha_vence;
	}
    
	
	public String getcodigo() {
		return this.codigo;
	}
    
	
	public String getnombre_completo() {
		return this.nombre_completo;
	}
    
	
	public String getnumero_pre_impreso_factura() {
		return this.numero_pre_impreso_factura;
	}
    
	
	public Double getsaldo_vencido() {
		return this.saldo_vencido;
	}
    
	
	public Double getsaldo_vencer() {
		return this.saldo_vencer;
	}
	
    
	public void setid_empresa(Long newid_empresa)throws Exception
	{
		try {
			if(this.id_empresa!=newid_empresa) {
				if(newid_empresa==null) {
					//newid_empresa=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("CobrarMorosidadClientesDetallados:Valor nulo no permitido en columna id_empresa");
					}
				}

				this.id_empresa=newid_empresa;
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
						System.out.println("CobrarMorosidadClientesDetallados:Valor nulo no permitido en columna fecha_vence");
					}
				}

				this.fecha_vence=newfecha_vence;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setcodigo(String newcodigo)throws Exception
	{
		try {
			if(this.codigo!=newcodigo) {
				if(newcodigo==null) {
					//newcodigo="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("CobrarMorosidadClientesDetallados:Valor nulo no permitido en columna codigo");
					}
				}

				if(newcodigo!=null&&newcodigo.length()>50) {
					newcodigo=newcodigo.substring(0,48);
					System.out.println("CobrarMorosidadClientesDetallados:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=50 en columna codigo");
				}

				this.codigo=newcodigo;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setnombre_completo(String newnombre_completo)throws Exception
	{
		try {
			if(this.nombre_completo!=newnombre_completo) {
				if(newnombre_completo==null) {
					//newnombre_completo="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("CobrarMorosidadClientesDetallados:Valor nulo no permitido en columna nombre_completo");
					}
				}

				if(newnombre_completo!=null&&newnombre_completo.length()>150) {
					newnombre_completo=newnombre_completo.substring(0,148);
					System.out.println("CobrarMorosidadClientesDetallados:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=150 en columna nombre_completo");
				}

				this.nombre_completo=newnombre_completo;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setnumero_pre_impreso_factura(String newnumero_pre_impreso_factura)throws Exception
	{
		try {
			if(this.numero_pre_impreso_factura!=newnumero_pre_impreso_factura) {
				if(newnumero_pre_impreso_factura==null) {
					//newnumero_pre_impreso_factura="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("CobrarMorosidadClientesDetallados:Valor nulo no permitido en columna numero_pre_impreso_factura");
					}
				}

				if(newnumero_pre_impreso_factura!=null&&newnumero_pre_impreso_factura.length()>50) {
					newnumero_pre_impreso_factura=newnumero_pre_impreso_factura.substring(0,48);
					System.out.println("CobrarMorosidadClientesDetallados:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=50 en columna numero_pre_impreso_factura");
				}

				this.numero_pre_impreso_factura=newnumero_pre_impreso_factura;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setsaldo_vencido(Double newsaldo_vencido)throws Exception
	{
		try {
			if(this.saldo_vencido!=newsaldo_vencido) {
				if(newsaldo_vencido==null) {
					//newsaldo_vencido=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("CobrarMorosidadClientesDetallados:Valor nulo no permitido en columna saldo_vencido");
					}
				}

				this.saldo_vencido=newsaldo_vencido;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setsaldo_vencer(Double newsaldo_vencer)throws Exception
	{
		try {
			if(this.saldo_vencer!=newsaldo_vencer) {
				if(newsaldo_vencer==null) {
					//newsaldo_vencer=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("CobrarMorosidadClientesDetallados:Valor nulo no permitido en columna saldo_vencer");
					}
				}

				this.saldo_vencer=newsaldo_vencer;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	
	public Empresa getEmpresa() {
		return this.empresa;
	}

	
	
	public String getempresa_descripcion() {
		return this.empresa_descripcion;
	}

	
	
	public  void  setEmpresa(Empresa empresa) {
		try {
			this.empresa=empresa;
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


	
	
	
	
	
	/*PARA REPORTES*/
	String id_empresa_descripcion="";
	
	
	public String getid_empresa_descripcion() {
		return id_empresa_descripcion;
	}
	
	
	public void setid_empresa_descripcion(String newid_empresa_descripcion)throws Exception {
		try {
			this.id_empresa_descripcion=newid_empresa_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	
	public void inicializarVariablesParaReporte() {
		this.id_empresa_descripcion="";
	}
	
	
	
	
	
	
	/*PARA REPORTES FIN*/		
}

