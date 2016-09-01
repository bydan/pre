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
package com.bydan.erp.puntoventa.business.entity;

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
//import com.bydan.erp.puntoventa.util.TarjetaCreditoDescuentoConstantesFunciones;
import com.bydan.erp.puntoventa.util.*;


import com.bydan.erp.seguridad.util.*;



import com.bydan.erp.seguridad.business.entity.*;




@SuppressWarnings("unused")
public class TarjetaCreditoDescuento extends TarjetaCreditoDescuentoAdditional implements Serializable ,Cloneable {//TarjetaCreditoDescuentoAdditional,GeneralEntity
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
	
	private TarjetaCreditoDescuento tarjetacreditodescuentoOriginal;
	
	private Map<String, Object> mapTarjetaCreditoDescuento;
			
	public Map<String, Object> getMapTarjetaCreditoDescuento() {
		return mapTarjetaCreditoDescuento;
	}

	public void setMapTarjetaCreditoDescuento(Map<String, Object> mapTarjetaCreditoDescuento) {
		this.mapTarjetaCreditoDescuento = mapTarjetaCreditoDescuento;
	}
	
	public void inicializarMapTarjetaCreditoDescuento() {
		this.mapTarjetaCreditoDescuento = new HashMap<String,Object>();
	}
	
	public void setMapTarjetaCreditoDescuentoValue(String sKey,Object oValue) {
		this.mapTarjetaCreditoDescuento.put(sKey, oValue);
	}
	
	public Object getMapTarjetaCreditoDescuentoValue(String sKey) {
		return this.mapTarjetaCreditoDescuento.get(sKey);
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
	private Long id_tarjeta_credito;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double porcentaje;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=10,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONINT)
	private Integer numero_meses;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Boolean es_corriente;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Boolean con_interes;
			
	
	public Empresa empresa;
	public Sucursal sucursal;
	public TarjetaCredito tarjetacredito;
	
	
	private String empresa_descripcion;
	private String sucursal_descripcion;
	private String tarjetacredito_descripcion;
	
	
		
	public TarjetaCreditoDescuento () throws Exception {
		super();		
		
		this.id=0L;
		
		
		this.versionRow=new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());//new Date();
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		this.sType="NONE";
		
		this.tarjetacreditodescuentoOriginal=this;
		
 		this.id_empresa=-1L;
 		this.id_sucursal=-1L;
 		this.id_tarjeta_credito=-1L;
 		this.porcentaje=0.0;
 		this.numero_meses=0;
 		this.es_corriente=false;
 		this.con_interes=false;
		
		
		this.empresa=null;
		this.sucursal=null;
		this.tarjetacredito=null;
		
		
		this.empresa_descripcion="";
		this.sucursal_descripcion="";
		this.tarjetacredito_descripcion="";
		
		
		
			
		
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
    //PARA REPORTES
	public TarjetaCreditoDescuento (Long id,Date versionRow,Long id_empresa,Long id_sucursal,Long id_tarjeta_credito,Double porcentaje,Integer numero_meses,Boolean es_corriente,Boolean con_interes) throws Exception {
		super();		
		
		this.id=id;
		this.versionRow=versionRow;
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.tarjetacreditodescuentoOriginal=this;
		
 		this.id_empresa=id_empresa;
 		this.id_sucursal=id_sucursal;
 		this.id_tarjeta_credito=id_tarjeta_credito;
 		this.porcentaje=porcentaje;
 		this.numero_meses=numero_meses;
 		this.es_corriente=es_corriente;
 		this.con_interes=con_interes;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	 //PARA REPORTES
	public TarjetaCreditoDescuento (Long id_empresa,Long id_sucursal,Long id_tarjeta_credito,Double porcentaje,Integer numero_meses,Boolean es_corriente,Boolean con_interes) throws Exception {
		super();		
		
		this.id=0L;
		this.versionRow=new Date();
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.tarjetacreditodescuentoOriginal=this;
		
 		this.id_empresa=id_empresa;
 		this.id_sucursal=id_sucursal;
 		this.id_tarjeta_credito=id_tarjeta_credito;
 		this.porcentaje=porcentaje;
 		this.numero_meses=numero_meses;
 		this.es_corriente=es_corriente;
 		this.con_interes=con_interes;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	public boolean equals(Object object) {
		boolean equal=false;
		TarjetaCreditoDescuento tarjetacreditodescuentoLocal=null;
		
		if(object!=null) {
			tarjetacreditodescuentoLocal=(TarjetaCreditoDescuento)object;
			
			if(tarjetacreditodescuentoLocal!=null) {
				if(this.getId()!=null && tarjetacreditodescuentoLocal.getId()!=null) {
					if(this.getId().equals(tarjetacreditodescuentoLocal.getId())) {
						equal=true;
					}
				}
			}
		}
		
		return equal;
	}
	
	public String toString() {
		String sDetalle="";
		
		if(!TarjetaCreditoDescuentoConstantesFunciones.CON_DESCRIPCION_DETALLADO) {
        	sDetalle=TarjetaCreditoDescuentoConstantesFunciones.getTarjetaCreditoDescuentoDescripcion(this);
		} else {
			sDetalle=TarjetaCreditoDescuentoConstantesFunciones.getTarjetaCreditoDescuentoDescripcionDetallado(this);
		}
		
		return sDetalle;
    }
	
	public TarjetaCreditoDescuento getTarjetaCreditoDescuentoOriginal() {
		return this.tarjetacreditodescuentoOriginal;
	}
	
	public void setTarjetaCreditoDescuentoOriginal(TarjetaCreditoDescuento tarjetacreditodescuento) {
		try {
			this.tarjetacreditodescuentoOriginal=tarjetacreditodescuento;
		} catch(Exception e) {
			;
		}
	}
	
	
	protected TarjetaCreditoDescuentoAdditional tarjetacreditodescuentoAdditional=null;
	
	public TarjetaCreditoDescuentoAdditional getTarjetaCreditoDescuentoAdditional() {
		return this.tarjetacreditodescuentoAdditional;
	}
	
	public void setTarjetaCreditoDescuentoAdditional(TarjetaCreditoDescuentoAdditional tarjetacreditodescuentoAdditional) {
		try {
			this.tarjetacreditodescuentoAdditional=tarjetacreditodescuentoAdditional;
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
    
	
	public Long getid_tarjeta_credito() {
		return this.id_tarjeta_credito;
	}
    
	
	public Double getporcentaje() {
		return this.porcentaje;
	}
    
	
	public Integer getnumero_meses() {
		return this.numero_meses;
	}
    
	
	public Boolean getes_corriente() {
		return this.es_corriente;
	}
    
	
	public Boolean getcon_interes() {
		return this.con_interes;
	}
	
    
	public void setid_empresa(Long newid_empresa)throws Exception
	{
		try {
			if(this.id_empresa!=newid_empresa) {
				if(newid_empresa==null) {
					//newid_empresa=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("TarjetaCreditoDescuento:Valor nulo no permitido en columna id_empresa");
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
						System.out.println("TarjetaCreditoDescuento:Valor nulo no permitido en columna id_sucursal");
					}
				}

				this.id_sucursal=newid_sucursal;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_tarjeta_credito(Long newid_tarjeta_credito)throws Exception
	{
		try {
			if(this.id_tarjeta_credito!=newid_tarjeta_credito) {
				if(newid_tarjeta_credito==null) {
					//newid_tarjeta_credito=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("TarjetaCreditoDescuento:Valor nulo no permitido en columna id_tarjeta_credito");
					}
				}

				this.id_tarjeta_credito=newid_tarjeta_credito;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setporcentaje(Double newporcentaje)throws Exception
	{
		try {
			if(this.porcentaje!=newporcentaje) {
				if(newporcentaje==null) {
					//newporcentaje=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("TarjetaCreditoDescuento:Valor nulo no permitido en columna porcentaje");
					}
				}

				this.porcentaje=newporcentaje;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setnumero_meses(Integer newnumero_meses)throws Exception
	{
		try {
			if(this.numero_meses!=newnumero_meses) {
				if(newnumero_meses==null) {
					//newnumero_meses=0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("TarjetaCreditoDescuento:Valor nulo no permitido en columna numero_meses");
					}
				}

				this.numero_meses=newnumero_meses;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setes_corriente(Boolean newes_corriente)throws Exception
	{
		try {
			if(this.es_corriente!=newes_corriente) {
				if(newes_corriente==null) {
					//newes_corriente=false;
					if(Constantes.ISDEVELOPING) {
						System.out.println("TarjetaCreditoDescuento:Valor nulo no permitido en columna es_corriente");
					}
				}

				this.es_corriente=newes_corriente;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setcon_interes(Boolean newcon_interes)throws Exception
	{
		try {
			if(this.con_interes!=newcon_interes) {
				if(newcon_interes==null) {
					//newcon_interes=false;
					if(Constantes.ISDEVELOPING) {
						System.out.println("TarjetaCreditoDescuento:Valor nulo no permitido en columna con_interes");
					}
				}

				this.con_interes=newcon_interes;
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

	public TarjetaCredito getTarjetaCredito() {
		return this.tarjetacredito;
	}

	
	
	public String getempresa_descripcion() {
		return this.empresa_descripcion;
	}

	public String getsucursal_descripcion() {
		return this.sucursal_descripcion;
	}

	public String gettarjetacredito_descripcion() {
		return this.tarjetacredito_descripcion;
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


	public  void  setTarjetaCredito(TarjetaCredito tarjetacredito) {
		try {
			this.tarjetacredito=tarjetacredito;
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


	public  void  settarjetacredito_descripcion(String tarjetacredito_descripcion) {
		try {
			this.tarjetacredito_descripcion=tarjetacredito_descripcion;
		} catch(Exception e) {
			;
		}
	}


	
	
	
	
	
	/*PARA REPORTES*/
	String id_empresa_descripcion="";String id_sucursal_descripcion="";String id_tarjeta_credito_descripcion="";String es_corriente_descripcion="";String con_interes_descripcion="";
	
	
	public String getid_empresa_descripcion() {
		return id_empresa_descripcion;
	}
	public String getid_sucursal_descripcion() {
		return id_sucursal_descripcion;
	}
	public String getid_tarjeta_credito_descripcion() {
		return id_tarjeta_credito_descripcion;
	}
	public String getes_corriente_descripcion() {
		return es_corriente_descripcion;
	}
	public String getcon_interes_descripcion() {
		return con_interes_descripcion;
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
	public void setid_tarjeta_credito_descripcion(String newid_tarjeta_credito_descripcion)throws Exception {
		try {
			this.id_tarjeta_credito_descripcion=newid_tarjeta_credito_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setes_corriente_descripcion(String newes_corriente_descripcion)throws Exception {
		try {
			this.es_corriente_descripcion=newes_corriente_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setcon_interes_descripcion(String newcon_interes_descripcion)throws Exception {
		try {
			this.con_interes_descripcion=newcon_interes_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	
	public void inicializarVariablesParaReporte() {
		this.id_empresa_descripcion="";this.id_sucursal_descripcion="";this.id_tarjeta_credito_descripcion="";this.es_corriente_descripcion="";this.con_interes_descripcion="";
	}
	
	
	
	
	
	
	/*PARA REPORTES FIN*/		
}

