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
//import com.bydan.erp.produccion.util.TipoProcesoEmpresaProduConstantesFunciones;
import com.bydan.erp.produccion.util.*;


import com.bydan.erp.seguridad.util.*;



import com.bydan.erp.seguridad.business.entity.*;




@SuppressWarnings("unused")
public class TipoProcesoEmpresaProdu extends TipoProcesoEmpresaProduAdditional implements Serializable ,Cloneable {//TipoProcesoEmpresaProduAdditional,GeneralEntity
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
	
	private TipoProcesoEmpresaProdu tipoprocesoempresaproduOriginal;
	
	private Map<String, Object> mapTipoProcesoEmpresaProdu;
			
	public Map<String, Object> getMapTipoProcesoEmpresaProdu() {
		return mapTipoProcesoEmpresaProdu;
	}

	public void setMapTipoProcesoEmpresaProdu(Map<String, Object> mapTipoProcesoEmpresaProdu) {
		this.mapTipoProcesoEmpresaProdu = mapTipoProcesoEmpresaProdu;
	}
	
	public void inicializarMapTipoProcesoEmpresaProdu() {
		this.mapTipoProcesoEmpresaProdu = new HashMap<String,Object>();
	}
	
	public void setMapTipoProcesoEmpresaProduValue(String sKey,Object oValue) {
		this.mapTipoProcesoEmpresaProdu.put(sKey, oValue);
	}
	
	public Object getMapTipoProcesoEmpresaProduValue(String sKey) {
		return this.mapTipoProcesoEmpresaProdu.get(sKey);
	}
	
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_empresa;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=100,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=TipoProcesoEmpresaProduConstantesFunciones.SREGEXNOMBRE,message=TipoProcesoEmpresaProduConstantesFunciones.SMENSAJEREGEXNOMBRE)
	private String nombre;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=150,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=TipoProcesoEmpresaProduConstantesFunciones.SREGEXDESCRIPCION,message=TipoProcesoEmpresaProduConstantesFunciones.SMENSAJEREGEXDESCRIPCION)
	private String descripcion;
			
	
	public Empresa empresa;
	
	
	private String empresa_descripcion;
	
	
	public List<ProductoProduMano> productoprodumanos;
	public List<ProductoOrdenDetaProduMano> productoordendetaprodumanos;
	public List<ProductoOrdenDetaProduMaquina> productoordendetaprodumaquinas;
	public List<ProductoProduMaquina> productoprodumaquinas;
		
	public TipoProcesoEmpresaProdu () throws Exception {
		super();		
		
		this.id=0L;
		
		
		this.versionRow=new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());//new Date();
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		this.sType="NONE";
		
		this.tipoprocesoempresaproduOriginal=this;
		
 		this.id_empresa=-1L;
 		this.nombre="";
 		this.descripcion="";
		
		
		this.empresa=null;
		
		
		this.empresa_descripcion="";
		
		
		this.productoprodumanos=null;
		this.productoordendetaprodumanos=null;
		this.productoordendetaprodumaquinas=null;
		this.productoprodumaquinas=null;
		
			
		
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
    //PARA REPORTES
	public TipoProcesoEmpresaProdu (Long id,Date versionRow,Long id_empresa,String nombre,String descripcion) throws Exception {
		super();		
		
		this.id=id;
		this.versionRow=versionRow;
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.tipoprocesoempresaproduOriginal=this;
		
 		this.id_empresa=id_empresa;
 		this.nombre=nombre;
 		this.descripcion=descripcion;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	 //PARA REPORTES
	public TipoProcesoEmpresaProdu (Long id_empresa,String nombre,String descripcion) throws Exception {
		super();		
		
		this.id=0L;
		this.versionRow=new Date();
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.tipoprocesoempresaproduOriginal=this;
		
 		this.id_empresa=id_empresa;
 		this.nombre=nombre;
 		this.descripcion=descripcion;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	public boolean equals(Object object) {
		boolean equal=false;
		TipoProcesoEmpresaProdu tipoprocesoempresaproduLocal=null;
		
		if(object!=null) {
			tipoprocesoempresaproduLocal=(TipoProcesoEmpresaProdu)object;
			
			if(tipoprocesoempresaproduLocal!=null) {
				if(this.getId()!=null && tipoprocesoempresaproduLocal.getId()!=null) {
					if(this.getId().equals(tipoprocesoempresaproduLocal.getId())) {
						equal=true;
					}
				}
			}
		}
		
		return equal;
	}
	
	public String toString() {
		String sDetalle="";
		
		if(!TipoProcesoEmpresaProduConstantesFunciones.CON_DESCRIPCION_DETALLADO) {
        	sDetalle=TipoProcesoEmpresaProduConstantesFunciones.getTipoProcesoEmpresaProduDescripcion(this);
		} else {
			sDetalle=TipoProcesoEmpresaProduConstantesFunciones.getTipoProcesoEmpresaProduDescripcionDetallado(this);
		}
		
		return sDetalle;
    }
	
	public TipoProcesoEmpresaProdu getTipoProcesoEmpresaProduOriginal() {
		return this.tipoprocesoempresaproduOriginal;
	}
	
	public void setTipoProcesoEmpresaProduOriginal(TipoProcesoEmpresaProdu tipoprocesoempresaprodu) {
		try {
			this.tipoprocesoempresaproduOriginal=tipoprocesoempresaprodu;
		} catch(Exception e) {
			;
		}
	}
	
	
	protected TipoProcesoEmpresaProduAdditional tipoprocesoempresaproduAdditional=null;
	
	public TipoProcesoEmpresaProduAdditional getTipoProcesoEmpresaProduAdditional() {
		return this.tipoprocesoempresaproduAdditional;
	}
	
	public void setTipoProcesoEmpresaProduAdditional(TipoProcesoEmpresaProduAdditional tipoprocesoempresaproduAdditional) {
		try {
			this.tipoprocesoempresaproduAdditional=tipoprocesoempresaproduAdditional;
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
						System.out.println("TipoProcesoEmpresaProdu:Valor nulo no permitido en columna id_empresa");
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
						System.out.println("TipoProcesoEmpresaProdu:Valor nulo no permitido en columna nombre");
					}
				}

				if(newnombre!=null&&newnombre.length()>100) {
					newnombre=newnombre.substring(0,98);
					System.out.println("TipoProcesoEmpresaProdu:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=100 en columna nombre");
				}

				this.nombre=newnombre;
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
						System.out.println("TipoProcesoEmpresaProdu:Valor nulo no permitido en columna descripcion");
					}
				}

				if(newdescripcion!=null&&newdescripcion.length()>150) {
					newdescripcion=newdescripcion.substring(0,148);
					System.out.println("TipoProcesoEmpresaProdu:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=150 en columna descripcion");
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


	
	
	public List<ProductoProduMano> getProductoProduManos() {
		return this.productoprodumanos;
	}

	public List<ProductoOrdenDetaProduMano> getProductoOrdenDetaProduManos() {
		return this.productoordendetaprodumanos;
	}

	public List<ProductoOrdenDetaProduMaquina> getProductoOrdenDetaProduMaquinas() {
		return this.productoordendetaprodumaquinas;
	}

	public List<ProductoProduMaquina> getProductoProduMaquinas() {
		return this.productoprodumaquinas;
	}

	
	
	public  void  setProductoProduManos(List<ProductoProduMano> productoprodumanos) {
		try {
			this.productoprodumanos=productoprodumanos;
		} catch(Exception e) {
			;
		}
	}

	public  void  setProductoOrdenDetaProduManos(List<ProductoOrdenDetaProduMano> productoordendetaprodumanos) {
		try {
			this.productoordendetaprodumanos=productoordendetaprodumanos;
		} catch(Exception e) {
			;
		}
	}

	public  void  setProductoOrdenDetaProduMaquinas(List<ProductoOrdenDetaProduMaquina> productoordendetaprodumaquinas) {
		try {
			this.productoordendetaprodumaquinas=productoordendetaprodumaquinas;
		} catch(Exception e) {
			;
		}
	}

	public  void  setProductoProduMaquinas(List<ProductoProduMaquina> productoprodumaquinas) {
		try {
			this.productoprodumaquinas=productoprodumaquinas;
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
	
	
	Object productoprodumanosDescripcionReporte;
	Object productoordendetaprodumanosDescripcionReporte;
	Object productoordendetaprodumaquinasDescripcionReporte;
	Object productoprodumaquinasDescripcionReporte;
	
	
	public Object getproductoprodumanosDescripcionReporte() {
		return productoprodumanosDescripcionReporte;
	}

	public Object getproductoordendetaprodumanosDescripcionReporte() {
		return productoordendetaprodumanosDescripcionReporte;
	}

	public Object getproductoordendetaprodumaquinasDescripcionReporte() {
		return productoordendetaprodumaquinasDescripcionReporte;
	}

	public Object getproductoprodumaquinasDescripcionReporte() {
		return productoprodumaquinasDescripcionReporte;
	}

	
	
	public  void  setproductoprodumanosDescripcionReporte(Object productoprodumanos) {
		try {
			this.productoprodumanosDescripcionReporte=productoprodumanos;
		} catch(Exception ex) {
			;
		}
	}

	public  void  setproductoordendetaprodumanosDescripcionReporte(Object productoordendetaprodumanos) {
		try {
			this.productoordendetaprodumanosDescripcionReporte=productoordendetaprodumanos;
		} catch(Exception ex) {
			;
		}
	}

	public  void  setproductoordendetaprodumaquinasDescripcionReporte(Object productoordendetaprodumaquinas) {
		try {
			this.productoordendetaprodumaquinasDescripcionReporte=productoordendetaprodumaquinas;
		} catch(Exception ex) {
			;
		}
	}

	public  void  setproductoprodumaquinasDescripcionReporte(Object productoprodumaquinas) {
		try {
			this.productoprodumaquinasDescripcionReporte=productoprodumaquinas;
		} catch(Exception ex) {
			;
		}
	}

	/*PARA REPORTES FIN*/		
}

