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
package com.bydan.erp.produccion.business.entity;

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
//import com.bydan.erp.produccion.util.ProductoOrdenDetaProduMermaConstantesFunciones;
import com.bydan.erp.produccion.util.*;


import com.bydan.erp.inventario.util.*;



import com.bydan.erp.inventario.business.entity.*;




@SuppressWarnings("unused")
public class ProductoOrdenDetaProduMerma extends ProductoOrdenDetaProduMermaAdditional implements Serializable ,Cloneable {//ProductoOrdenDetaProduMermaAdditional,GeneralEntity
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
	
	private ProductoOrdenDetaProduMerma productoordendetaprodumermaOriginal;
	
	private Map<String, Object> mapProductoOrdenDetaProduMerma;
			
	public Map<String, Object> getMapProductoOrdenDetaProduMerma() {
		return mapProductoOrdenDetaProduMerma;
	}

	public void setMapProductoOrdenDetaProduMerma(Map<String, Object> mapProductoOrdenDetaProduMerma) {
		this.mapProductoOrdenDetaProduMerma = mapProductoOrdenDetaProduMerma;
	}
	
	public void inicializarMapProductoOrdenDetaProduMerma() {
		this.mapProductoOrdenDetaProduMerma = new HashMap<String,Object>();
	}
	
	public void setMapProductoOrdenDetaProduMermaValue(String sKey,Object oValue) {
		this.mapProductoOrdenDetaProduMerma.put(sKey, oValue);
	}
	
	public Object getMapProductoOrdenDetaProduMermaValue(String sKey) {
		return this.mapProductoOrdenDetaProduMerma.get(sKey);
	}
	
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_orden_deta_produ;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_tipo_merma_empresa;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_unidad;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=10,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONINT)
	private Integer cantidad;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double costo;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double costo_total;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=100,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=ProductoOrdenDetaProduMermaConstantesFunciones.SREGEXDESCRIPCION,message=ProductoOrdenDetaProduMermaConstantesFunciones.SMENSAJEREGEXDESCRIPCION)
	private String descripcion;
			
	
	public OrdenDetaProdu ordendetaprodu;
	public TipoMermaEmpresa tipomermaempresa;
	public Unidad unidad;
	
	
	private String ordendetaprodu_descripcion;
	private String tipomermaempresa_descripcion;
	private String unidad_descripcion;
	
	
		
	public ProductoOrdenDetaProduMerma () throws Exception {
		super();		
		
		this.id=0L;
		
		
		this.versionRow=new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());//new Date();
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		this.sType="NONE";
		
		this.productoordendetaprodumermaOriginal=this;
		
 		this.id_orden_deta_produ=-1L;
 		this.id_tipo_merma_empresa=-1L;
 		this.id_unidad=-1L;
 		this.cantidad=0;
 		this.costo=0.0;
 		this.costo_total=0.0;
 		this.descripcion="";
		
		
		this.ordendetaprodu=null;
		this.tipomermaempresa=null;
		this.unidad=null;
		
		
		this.ordendetaprodu_descripcion="";
		this.tipomermaempresa_descripcion="";
		this.unidad_descripcion="";
		
		
		
			
		
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
    //PARA REPORTES
	public ProductoOrdenDetaProduMerma (Long id,Date versionRow,Long id_orden_deta_produ,Long id_tipo_merma_empresa,Long id_unidad,Integer cantidad,Double costo,Double costo_total,String descripcion) throws Exception {
		super();		
		
		this.id=id;
		this.versionRow=versionRow;
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.productoordendetaprodumermaOriginal=this;
		
 		this.id_orden_deta_produ=id_orden_deta_produ;
 		this.id_tipo_merma_empresa=id_tipo_merma_empresa;
 		this.id_unidad=id_unidad;
 		this.cantidad=cantidad;
 		this.costo=costo;
 		this.costo_total=costo_total;
 		this.descripcion=descripcion;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	 //PARA REPORTES
	public ProductoOrdenDetaProduMerma (Long id_orden_deta_produ,Long id_tipo_merma_empresa,Long id_unidad,Integer cantidad,Double costo,Double costo_total,String descripcion) throws Exception {
		super();		
		
		this.id=0L;
		this.versionRow=new Date();
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.productoordendetaprodumermaOriginal=this;
		
 		this.id_orden_deta_produ=id_orden_deta_produ;
 		this.id_tipo_merma_empresa=id_tipo_merma_empresa;
 		this.id_unidad=id_unidad;
 		this.cantidad=cantidad;
 		this.costo=costo;
 		this.costo_total=costo_total;
 		this.descripcion=descripcion;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	public boolean equals(Object object) {
		boolean equal=false;
		ProductoOrdenDetaProduMerma productoordendetaprodumermaLocal=null;
		
		if(object!=null) {
			productoordendetaprodumermaLocal=(ProductoOrdenDetaProduMerma)object;
			
			if(productoordendetaprodumermaLocal!=null) {
				if(this.getId()!=null && productoordendetaprodumermaLocal.getId()!=null) {
					if(this.getId().equals(productoordendetaprodumermaLocal.getId())) {
						equal=true;
					}
				}
			}
		}
		
		return equal;
	}
	
	public String toString() {
		String sDetalle="";
		
		if(!ProductoOrdenDetaProduMermaConstantesFunciones.CON_DESCRIPCION_DETALLADO) {
        	sDetalle=ProductoOrdenDetaProduMermaConstantesFunciones.getProductoOrdenDetaProduMermaDescripcion(this);
		} else {
			sDetalle=ProductoOrdenDetaProduMermaConstantesFunciones.getProductoOrdenDetaProduMermaDescripcionDetallado(this);
		}
		
		return sDetalle;
    }
	
	public ProductoOrdenDetaProduMerma getProductoOrdenDetaProduMermaOriginal() {
		return this.productoordendetaprodumermaOriginal;
	}
	
	public void setProductoOrdenDetaProduMermaOriginal(ProductoOrdenDetaProduMerma productoordendetaprodumerma) {
		try {
			this.productoordendetaprodumermaOriginal=productoordendetaprodumerma;
		} catch(Exception e) {
			;
		}
	}
	
	
	protected ProductoOrdenDetaProduMermaAdditional productoordendetaprodumermaAdditional=null;
	
	public ProductoOrdenDetaProduMermaAdditional getProductoOrdenDetaProduMermaAdditional() {
		return this.productoordendetaprodumermaAdditional;
	}
	
	public void setProductoOrdenDetaProduMermaAdditional(ProductoOrdenDetaProduMermaAdditional productoordendetaprodumermaAdditional) {
		try {
			this.productoordendetaprodumermaAdditional=productoordendetaprodumermaAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
    
	
	public Long getid_orden_deta_produ() {
		return this.id_orden_deta_produ;
	}
    
	
	public Long getid_tipo_merma_empresa() {
		return this.id_tipo_merma_empresa;
	}
    
	
	public Long getid_unidad() {
		return this.id_unidad;
	}
    
	
	public Integer getcantidad() {
		return this.cantidad;
	}
    
	
	public Double getcosto() {
		return this.costo;
	}
    
	
	public Double getcosto_total() {
		return this.costo_total;
	}
    
	
	public String getdescripcion() {
		return this.descripcion;
	}
	
    
	public void setid_orden_deta_produ(Long newid_orden_deta_produ)throws Exception
	{
		try {
			if(this.id_orden_deta_produ!=newid_orden_deta_produ) {
				if(newid_orden_deta_produ==null) {
					//newid_orden_deta_produ=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ProductoOrdenDetaProduMerma:Valor nulo no permitido en columna id_orden_deta_produ");
					}
				}

				this.id_orden_deta_produ=newid_orden_deta_produ;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_tipo_merma_empresa(Long newid_tipo_merma_empresa)throws Exception
	{
		try {
			if(this.id_tipo_merma_empresa!=newid_tipo_merma_empresa) {
				if(newid_tipo_merma_empresa==null) {
					//newid_tipo_merma_empresa=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ProductoOrdenDetaProduMerma:Valor nulo no permitido en columna id_tipo_merma_empresa");
					}
				}

				this.id_tipo_merma_empresa=newid_tipo_merma_empresa;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_unidad(Long newid_unidad)throws Exception
	{
		try {
			if(this.id_unidad!=newid_unidad) {
				if(newid_unidad==null) {
					//newid_unidad=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ProductoOrdenDetaProduMerma:Valor nulo no permitido en columna id_unidad");
					}
				}

				this.id_unidad=newid_unidad;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setcantidad(Integer newcantidad)throws Exception
	{
		try {
			if(this.cantidad!=newcantidad) {
				if(newcantidad==null) {
					//newcantidad=0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ProductoOrdenDetaProduMerma:Valor nulo no permitido en columna cantidad");
					}
				}

				this.cantidad=newcantidad;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setcosto(Double newcosto)throws Exception
	{
		try {
			if(this.costo!=newcosto) {
				if(newcosto==null) {
					//newcosto=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ProductoOrdenDetaProduMerma:Valor nulo no permitido en columna costo");
					}
				}

				this.costo=newcosto;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setcosto_total(Double newcosto_total)throws Exception
	{
		try {
			if(this.costo_total!=newcosto_total) {
				if(newcosto_total==null) {
					//newcosto_total=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ProductoOrdenDetaProduMerma:Valor nulo no permitido en columna costo_total");
					}
				}

				this.costo_total=newcosto_total;
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
						System.out.println("ProductoOrdenDetaProduMerma:Valor nulo no permitido en columna descripcion");
					}
				}

				if(newdescripcion!=null&&newdescripcion.length()>100) {
					newdescripcion=newdescripcion.substring(0,98);
					System.out.println("ProductoOrdenDetaProduMerma:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=100 en columna descripcion");
				}

				this.descripcion=newdescripcion;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	
	public OrdenDetaProdu getOrdenDetaProdu() {
		return this.ordendetaprodu;
	}

	public TipoMermaEmpresa getTipoMermaEmpresa() {
		return this.tipomermaempresa;
	}

	public Unidad getUnidad() {
		return this.unidad;
	}

	
	
	public String getordendetaprodu_descripcion() {
		return this.ordendetaprodu_descripcion;
	}

	public String gettipomermaempresa_descripcion() {
		return this.tipomermaempresa_descripcion;
	}

	public String getunidad_descripcion() {
		return this.unidad_descripcion;
	}

	
	
	public  void  setOrdenDetaProdu(OrdenDetaProdu ordendetaprodu) {
		try {
			this.ordendetaprodu=ordendetaprodu;
		} catch(Exception e) {
			;
		}
	}


	public  void  setTipoMermaEmpresa(TipoMermaEmpresa tipomermaempresa) {
		try {
			this.tipomermaempresa=tipomermaempresa;
		} catch(Exception e) {
			;
		}
	}


	public  void  setUnidad(Unidad unidad) {
		try {
			this.unidad=unidad;
		} catch(Exception e) {
			;
		}
	}


	
	
	public  void  setordendetaprodu_descripcion(String ordendetaprodu_descripcion) {
		try {
			this.ordendetaprodu_descripcion=ordendetaprodu_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  settipomermaempresa_descripcion(String tipomermaempresa_descripcion) {
		try {
			this.tipomermaempresa_descripcion=tipomermaempresa_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  setunidad_descripcion(String unidad_descripcion) {
		try {
			this.unidad_descripcion=unidad_descripcion;
		} catch(Exception e) {
			;
		}
	}


	
	
	
	
	
	/*PARA REPORTES*/
	String id_orden_deta_produ_descripcion="";String id_tipo_merma_empresa_descripcion="";String id_unidad_descripcion="";
	
	
	public String getid_orden_deta_produ_descripcion() {
		return id_orden_deta_produ_descripcion;
	}
	public String getid_tipo_merma_empresa_descripcion() {
		return id_tipo_merma_empresa_descripcion;
	}
	public String getid_unidad_descripcion() {
		return id_unidad_descripcion;
	}
	
	
	public void setid_orden_deta_produ_descripcion(String newid_orden_deta_produ_descripcion)throws Exception {
		try {
			this.id_orden_deta_produ_descripcion=newid_orden_deta_produ_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_tipo_merma_empresa_descripcion(String newid_tipo_merma_empresa_descripcion)throws Exception {
		try {
			this.id_tipo_merma_empresa_descripcion=newid_tipo_merma_empresa_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_unidad_descripcion(String newid_unidad_descripcion)throws Exception {
		try {
			this.id_unidad_descripcion=newid_unidad_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	
	public void inicializarVariablesParaReporte() {
		this.id_orden_deta_produ_descripcion="";this.id_tipo_merma_empresa_descripcion="";this.id_unidad_descripcion="";
	}
	
	
	
	
	
	
	/*PARA REPORTES FIN*/		
}

