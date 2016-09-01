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
//import com.bydan.erp.puntoventa.util.CajaIngresoDetalleConstantesFunciones;
import com.bydan.erp.puntoventa.util.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.cartera.util.*;
import com.bydan.erp.facturacion.util.*;



import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;
import com.bydan.erp.facturacion.business.entity.*;




@SuppressWarnings("unused")
public class CajaIngresoDetalle extends CajaIngresoDetalleAdditional implements Serializable ,Cloneable {//CajaIngresoDetalleAdditional,GeneralEntity
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
	
	private CajaIngresoDetalle cajaingresodetalleOriginal;
	
	private Map<String, Object> mapCajaIngresoDetalle;
			
	public Map<String, Object> getMapCajaIngresoDetalle() {
		return mapCajaIngresoDetalle;
	}

	public void setMapCajaIngresoDetalle(Map<String, Object> mapCajaIngresoDetalle) {
		this.mapCajaIngresoDetalle = mapCajaIngresoDetalle;
	}
	
	public void inicializarMapCajaIngresoDetalle() {
		this.mapCajaIngresoDetalle = new HashMap<String,Object>();
	}
	
	public void setMapCajaIngresoDetalleValue(String sKey,Object oValue) {
		this.mapCajaIngresoDetalle.put(sKey, oValue);
	}
	
	public Object getMapCajaIngresoDetalleValue(String sKey) {
		return this.mapCajaIngresoDetalle.get(sKey);
	}
	
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_caja_ingreso;
	
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
	private Long id_cliente;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=-100000,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_factura;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=150,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=CajaIngresoDetalleConstantesFunciones.SREGEXCONCEPTO,message=CajaIngresoDetalleConstantesFunciones.SMENSAJEREGEXCONCEPTO)
	private String concepto;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double valor;
			
	
	public CajaIngreso cajaingreso;
	public Empresa empresa;
	public Sucursal sucursal;
	public Cliente cliente;
	public Factura factura;
	
	
	private String cajaingreso_descripcion;
	private String empresa_descripcion;
	private String sucursal_descripcion;
	private String cliente_descripcion;
	private String factura_descripcion;
	
	
		
	public CajaIngresoDetalle () throws Exception {
		super();		
		
		this.id=0L;
		
		
		this.versionRow=new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());//new Date();
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		this.sType="NONE";
		
		this.cajaingresodetalleOriginal=this;
		
 		this.id_caja_ingreso=-1L;
 		this.id_empresa=-1L;
 		this.id_sucursal=-1L;
 		this.id_cliente=-1L;
 		this.id_factura=-1L;
 		this.concepto="";
 		this.valor=0.0;
		
		
		this.cajaingreso=null;
		this.empresa=null;
		this.sucursal=null;
		this.cliente=null;
		this.factura=null;
		
		
		this.cajaingreso_descripcion="";
		this.empresa_descripcion="";
		this.sucursal_descripcion="";
		this.cliente_descripcion="";
		this.factura_descripcion="";
		
		
		
			
		
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
    //PARA REPORTES
	public CajaIngresoDetalle (Long id,Date versionRow,Long id_caja_ingreso,Long id_empresa,Long id_sucursal,Long id_cliente,Long id_factura,String concepto,Double valor) throws Exception {
		super();		
		
		this.id=id;
		this.versionRow=versionRow;
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.cajaingresodetalleOriginal=this;
		
 		this.id_caja_ingreso=id_caja_ingreso;
 		this.id_empresa=id_empresa;
 		this.id_sucursal=id_sucursal;
 		this.id_cliente=id_cliente;
 		this.id_factura=id_factura;
 		this.concepto=concepto;
 		this.valor=valor;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	 //PARA REPORTES
	public CajaIngresoDetalle (Long id_caja_ingreso,Long id_empresa,Long id_sucursal,Long id_cliente,Long id_factura,String concepto,Double valor) throws Exception {
		super();		
		
		this.id=0L;
		this.versionRow=new Date();
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.cajaingresodetalleOriginal=this;
		
 		this.id_caja_ingreso=id_caja_ingreso;
 		this.id_empresa=id_empresa;
 		this.id_sucursal=id_sucursal;
 		this.id_cliente=id_cliente;
 		this.id_factura=id_factura;
 		this.concepto=concepto;
 		this.valor=valor;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	public boolean equals(Object object) {
		boolean equal=false;
		CajaIngresoDetalle cajaingresodetalleLocal=null;
		
		if(object!=null) {
			cajaingresodetalleLocal=(CajaIngresoDetalle)object;
			
			if(cajaingresodetalleLocal!=null) {
				if(this.getId()!=null && cajaingresodetalleLocal.getId()!=null) {
					if(this.getId().equals(cajaingresodetalleLocal.getId())) {
						equal=true;
					}
				}
			}
		}
		
		return equal;
	}
	
	public String toString() {
		String sDetalle="";
		
		if(!CajaIngresoDetalleConstantesFunciones.CON_DESCRIPCION_DETALLADO) {
        	sDetalle=CajaIngresoDetalleConstantesFunciones.getCajaIngresoDetalleDescripcion(this);
		} else {
			sDetalle=CajaIngresoDetalleConstantesFunciones.getCajaIngresoDetalleDescripcionDetallado(this);
		}
		
		return sDetalle;
    }
	
	public CajaIngresoDetalle getCajaIngresoDetalleOriginal() {
		return this.cajaingresodetalleOriginal;
	}
	
	public void setCajaIngresoDetalleOriginal(CajaIngresoDetalle cajaingresodetalle) {
		try {
			this.cajaingresodetalleOriginal=cajaingresodetalle;
		} catch(Exception e) {
			;
		}
	}
	
	
	protected CajaIngresoDetalleAdditional cajaingresodetalleAdditional=null;
	
	public CajaIngresoDetalleAdditional getCajaIngresoDetalleAdditional() {
		return this.cajaingresodetalleAdditional;
	}
	
	public void setCajaIngresoDetalleAdditional(CajaIngresoDetalleAdditional cajaingresodetalleAdditional) {
		try {
			this.cajaingresodetalleAdditional=cajaingresodetalleAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
    
	
	public Long getid_caja_ingreso() {
		return this.id_caja_ingreso;
	}
    
	
	public Long getid_empresa() {
		return this.id_empresa;
	}
    
	
	public Long getid_sucursal() {
		return this.id_sucursal;
	}
    
	
	public Long getid_cliente() {
		return this.id_cliente;
	}
    
	
	public Long getid_factura() {
		return this.id_factura;
	}
    
	
	public String getconcepto() {
		return this.concepto;
	}
    
	
	public Double getvalor() {
		return this.valor;
	}
	
    
	public void setid_caja_ingreso(Long newid_caja_ingreso)throws Exception
	{
		try {
			if(this.id_caja_ingreso!=newid_caja_ingreso) {
				if(newid_caja_ingreso==null) {
					//newid_caja_ingreso=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("CajaIngresoDetalle:Valor nulo no permitido en columna id_caja_ingreso");
					}
				}

				this.id_caja_ingreso=newid_caja_ingreso;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_empresa(Long newid_empresa)throws Exception
	{
		try {
			if(this.id_empresa!=newid_empresa) {
				if(newid_empresa==null) {
					//newid_empresa=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("CajaIngresoDetalle:Valor nulo no permitido en columna id_empresa");
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
						System.out.println("CajaIngresoDetalle:Valor nulo no permitido en columna id_sucursal");
					}
				}

				this.id_sucursal=newid_sucursal;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_cliente(Long newid_cliente)throws Exception
	{
		try {
			if(this.id_cliente!=newid_cliente) {
				if(newid_cliente==null) {
					//newid_cliente=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("CajaIngresoDetalle:Valor nulo no permitido en columna id_cliente");
					}
				}

				this.id_cliente=newid_cliente;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_factura(Long newid_factura)throws Exception
	{
		try {
			if(this.id_factura!=newid_factura) {
				if(newid_factura==null) {
					//newid_factura=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("CajaIngresoDetalle:Valor nulo no permitido en columna id_factura");
					}
				}

				this.id_factura=newid_factura;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setconcepto(String newconcepto)throws Exception
	{
		try {
			if(this.concepto!=newconcepto) {
				if(newconcepto==null) {
					//newconcepto="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("CajaIngresoDetalle:Valor nulo no permitido en columna concepto");
					}
				}

				if(newconcepto!=null&&newconcepto.length()>150) {
					newconcepto=newconcepto.substring(0,148);
					System.out.println("CajaIngresoDetalle:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=150 en columna concepto");
				}

				this.concepto=newconcepto;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setvalor(Double newvalor)throws Exception
	{
		try {
			if(this.valor!=newvalor) {
				if(newvalor==null) {
					//newvalor=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("CajaIngresoDetalle:Valor nulo no permitido en columna valor");
					}
				}

				this.valor=newvalor;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	
	public CajaIngreso getCajaIngreso() {
		return this.cajaingreso;
	}

	public Empresa getEmpresa() {
		return this.empresa;
	}

	public Sucursal getSucursal() {
		return this.sucursal;
	}

	public Cliente getCliente() {
		return this.cliente;
	}

	public Factura getFactura() {
		return this.factura;
	}

	
	
	public String getcajaingreso_descripcion() {
		return this.cajaingreso_descripcion;
	}

	public String getempresa_descripcion() {
		return this.empresa_descripcion;
	}

	public String getsucursal_descripcion() {
		return this.sucursal_descripcion;
	}

	public String getcliente_descripcion() {
		return this.cliente_descripcion;
	}

	public String getfactura_descripcion() {
		return this.factura_descripcion;
	}

	
	
	public  void  setCajaIngreso(CajaIngreso cajaingreso) {
		try {
			this.cajaingreso=cajaingreso;
		} catch(Exception e) {
			;
		}
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


	public  void  setCliente(Cliente cliente) {
		try {
			this.cliente=cliente;
		} catch(Exception e) {
			;
		}
	}


	public  void  setFactura(Factura factura) {
		try {
			this.factura=factura;
		} catch(Exception e) {
			;
		}
	}


	
	
	public  void  setcajaingreso_descripcion(String cajaingreso_descripcion) {
		try {
			this.cajaingreso_descripcion=cajaingreso_descripcion;
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


	public  void  setcliente_descripcion(String cliente_descripcion) {
		try {
			this.cliente_descripcion=cliente_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  setfactura_descripcion(String factura_descripcion) {
		try {
			this.factura_descripcion=factura_descripcion;
		} catch(Exception e) {
			;
		}
	}


	
	
	
	
	
	/*PARA REPORTES*/
	String id_caja_ingreso_descripcion="";String id_empresa_descripcion="";String id_sucursal_descripcion="";String id_cliente_descripcion="";String id_factura_descripcion="";
	
	
	public String getid_caja_ingreso_descripcion() {
		return id_caja_ingreso_descripcion;
	}
	public String getid_empresa_descripcion() {
		return id_empresa_descripcion;
	}
	public String getid_sucursal_descripcion() {
		return id_sucursal_descripcion;
	}
	public String getid_cliente_descripcion() {
		return id_cliente_descripcion;
	}
	public String getid_factura_descripcion() {
		return id_factura_descripcion;
	}
	
	
	public void setid_caja_ingreso_descripcion(String newid_caja_ingreso_descripcion)throws Exception {
		try {
			this.id_caja_ingreso_descripcion=newid_caja_ingreso_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
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
	public void setid_cliente_descripcion(String newid_cliente_descripcion)throws Exception {
		try {
			this.id_cliente_descripcion=newid_cliente_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_factura_descripcion(String newid_factura_descripcion)throws Exception {
		try {
			this.id_factura_descripcion=newid_factura_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	
	public void inicializarVariablesParaReporte() {
		this.id_caja_ingreso_descripcion="";this.id_empresa_descripcion="";this.id_sucursal_descripcion="";this.id_cliente_descripcion="";this.id_factura_descripcion="";
	}
	
	
	
	
	
	
	/*PARA REPORTES FIN*/		
}

