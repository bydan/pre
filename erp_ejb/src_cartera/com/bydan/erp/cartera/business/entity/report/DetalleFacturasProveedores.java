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
//import com.bydan.erp.cartera.util.DetalleFacturasProveedoresConstantesFunciones;
import com.bydan.erp.cartera.util.*;


import com.bydan.erp.seguridad.util.*;

import com.bydan.erp.cartera.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;




@SuppressWarnings("unused")
public class DetalleFacturasProveedores extends DetalleFacturasProveedoresAdditional implements Serializable ,Cloneable {//DetalleFacturasProveedoresAdditional,GeneralEntity
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
	
	private DetalleFacturasProveedores detallefacturasproveedoresOriginal;
	
	private Map<String, Object> mapDetalleFacturasProveedores;
			
	public Map<String, Object> getMapDetalleFacturasProveedores() {
		return mapDetalleFacturasProveedores;
	}

	public void setMapDetalleFacturasProveedores(Map<String, Object> mapDetalleFacturasProveedores) {
		this.mapDetalleFacturasProveedores = mapDetalleFacturasProveedores;
	}
	
	public void inicializarMapDetalleFacturasProveedores() {
		this.mapDetalleFacturasProveedores = new HashMap<String,Object>();
	}
	
	public void setMapDetalleFacturasProveedoresValue(String sKey,Object oValue) {
		this.mapDetalleFacturasProveedores.put(sKey, oValue);
	}
	
	public Object getMapDetalleFacturasProveedoresValue(String sKey) {
		return this.mapDetalleFacturasProveedores.get(sKey);
	}
	
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_empresa;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=150,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	//@Pattern(regex=DetalleFacturasProveedoresConstantesFunciones.SREGEXNOMBRE_CLIENTE,message=DetalleFacturasProveedoresConstantesFunciones.SMENSAJEREGEXNOMBRE_CLIENTE)
	private String nombre_cliente;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=10,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONINT)
	private Integer cantidad_facturas;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double total_valor;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=10,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONINT)
	private Integer mes;
			
	
	public Empresa empresa;
	
	
	private String empresa_descripcion;
	
	
		
	public DetalleFacturasProveedores () throws Exception {
		super();		
		
		this.id=0L;
		
		
		this.versionRow=new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());//new Date();
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		this.sType="NONE";
		
		this.detallefacturasproveedoresOriginal=this;
		
 		this.id_empresa=-1L;
 		this.nombre_cliente="";
 		this.cantidad_facturas=0;
 		this.total_valor=0.0;
 		this.mes=0;
		
		
		this.empresa=null;
		
		
		this.empresa_descripcion="";
		
		
		
			
		
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
    //PARA REPORTES
	public DetalleFacturasProveedores (Long id,Date versionRow,String nombre_cliente,Integer cantidad_facturas,Double total_valor,Integer mes) throws Exception {
		super();		
		
		this.id=id;
		this.versionRow=versionRow;
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.detallefacturasproveedoresOriginal=this;
		
 		this.nombre_cliente=nombre_cliente;
 		this.cantidad_facturas=cantidad_facturas;
 		this.total_valor=total_valor;
 		this.mes=mes;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	 //PARA REPORTES
	public DetalleFacturasProveedores (String nombre_cliente,Integer cantidad_facturas,Double total_valor,Integer mes) throws Exception {
		super();		
		
		this.id=0L;
		this.versionRow=new Date();
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.detallefacturasproveedoresOriginal=this;
		
 		this.nombre_cliente=nombre_cliente;
 		this.cantidad_facturas=cantidad_facturas;
 		this.total_valor=total_valor;
 		this.mes=mes;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	
	public DetalleFacturasProveedores getDetalleFacturasProveedoresOriginal() {
		return this.detallefacturasproveedoresOriginal;
	}
	
	public void setDetalleFacturasProveedoresOriginal(DetalleFacturasProveedores detallefacturasproveedores) {
		try {
			this.detallefacturasproveedoresOriginal=detallefacturasproveedores;
		} catch(Exception e) {
			;
		}
	}
	
	
	protected DetalleFacturasProveedoresAdditional detallefacturasproveedoresAdditional=null;
	
	public DetalleFacturasProveedoresAdditional getDetalleFacturasProveedoresAdditional() {
		return this.detallefacturasproveedoresAdditional;
	}
	
	public void setDetalleFacturasProveedoresAdditional(DetalleFacturasProveedoresAdditional detallefacturasproveedoresAdditional) {
		try {
			this.detallefacturasproveedoresAdditional=detallefacturasproveedoresAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
    
	
	public Long getid_empresa() {
		return this.id_empresa;
	}
    
	
	public String getnombre_cliente() {
		return this.nombre_cliente;
	}
    
	
	public Integer getcantidad_facturas() {
		return this.cantidad_facturas;
	}
    
	
	public Double gettotal_valor() {
		return this.total_valor;
	}
    
	
	public Integer getmes() {
		return this.mes;
	}
	
    
	public void setid_empresa(Long newid_empresa)throws Exception
	{
		try {
			if(this.id_empresa!=newid_empresa) {
				if(newid_empresa==null) {
					//newid_empresa=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("DetalleFacturasProveedores:Valor nulo no permitido en columna id_empresa");
					}
				}

				this.id_empresa=newid_empresa;
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
						System.out.println("DetalleFacturasProveedores:Valor nulo no permitido en columna nombre_cliente");
					}
				}

				if(newnombre_cliente!=null&&newnombre_cliente.length()>150) {
					newnombre_cliente=newnombre_cliente.substring(0,148);
					System.out.println("DetalleFacturasProveedores:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=150 en columna nombre_cliente");
				}

				this.nombre_cliente=newnombre_cliente;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setcantidad_facturas(Integer newcantidad_facturas)throws Exception
	{
		try {
			if(this.cantidad_facturas!=newcantidad_facturas) {
				if(newcantidad_facturas==null) {
					//newcantidad_facturas=0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("DetalleFacturasProveedores:Valor nulo no permitido en columna cantidad_facturas");
					}
				}

				this.cantidad_facturas=newcantidad_facturas;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void settotal_valor(Double newtotal_valor)throws Exception
	{
		try {
			if(this.total_valor!=newtotal_valor) {
				if(newtotal_valor==null) {
					//newtotal_valor=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("DetalleFacturasProveedores:Valor nulo no permitido en columna total_valor");
					}
				}

				this.total_valor=newtotal_valor;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setmes(Integer newmes)throws Exception
	{
		try {
			if(this.mes!=newmes) {
				if(newmes==null) {
					//newmes=0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("DetalleFacturasProveedores:Valor nulo no permitido en columna mes");
					}
				}

				this.mes=newmes;
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

