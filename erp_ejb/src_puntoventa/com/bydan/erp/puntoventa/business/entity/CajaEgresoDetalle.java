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
//import com.bydan.erp.puntoventa.util.CajaEgresoDetalleConstantesFunciones;
import com.bydan.erp.puntoventa.util.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.cartera.util.*;
import com.bydan.erp.facturacion.util.*;



import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;
import com.bydan.erp.facturacion.business.entity.*;




@SuppressWarnings("unused")
public class CajaEgresoDetalle extends CajaEgresoDetalleAdditional implements Serializable ,Cloneable {//CajaEgresoDetalleAdditional,GeneralEntity
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
	
	private CajaEgresoDetalle cajaegresodetalleOriginal;
	
	private Map<String, Object> mapCajaEgresoDetalle;
			
	public Map<String, Object> getMapCajaEgresoDetalle() {
		return mapCajaEgresoDetalle;
	}

	public void setMapCajaEgresoDetalle(Map<String, Object> mapCajaEgresoDetalle) {
		this.mapCajaEgresoDetalle = mapCajaEgresoDetalle;
	}
	
	public void inicializarMapCajaEgresoDetalle() {
		this.mapCajaEgresoDetalle = new HashMap<String,Object>();
	}
	
	public void setMapCajaEgresoDetalleValue(String sKey,Object oValue) {
		this.mapCajaEgresoDetalle.put(sKey, oValue);
	}
	
	public Object getMapCajaEgresoDetalleValue(String sKey) {
		return this.mapCajaEgresoDetalle.get(sKey);
	}
	
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_caja_egreso;
	
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
	@Pattern(regex=CajaEgresoDetalleConstantesFunciones.SREGEXCONCEPTO,message=CajaEgresoDetalleConstantesFunciones.SMENSAJEREGEXCONCEPTO)
	private String concepto;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double valor;
			
	
	public CajaEgreso cajaegreso;
	public Empresa empresa;
	public Sucursal sucursal;
	public Cliente cliente;
	public Factura factura;
	
	
	private String cajaegreso_descripcion;
	private String empresa_descripcion;
	private String sucursal_descripcion;
	private String cliente_descripcion;
	private String factura_descripcion;
	
	
		
	public CajaEgresoDetalle () throws Exception {
		super();		
		
		this.id=0L;
		
		
		this.versionRow=new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());//new Date();
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		this.sType="NONE";
		
		this.cajaegresodetalleOriginal=this;
		
 		this.id_caja_egreso=-1L;
 		this.id_empresa=-1L;
 		this.id_sucursal=-1L;
 		this.id_cliente=-1L;
 		this.id_factura=-1L;
 		this.concepto="";
 		this.valor=0.0;
		
		
		this.cajaegreso=null;
		this.empresa=null;
		this.sucursal=null;
		this.cliente=null;
		this.factura=null;
		
		
		this.cajaegreso_descripcion="";
		this.empresa_descripcion="";
		this.sucursal_descripcion="";
		this.cliente_descripcion="";
		this.factura_descripcion="";
		
		
		
			
		
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
    //PARA REPORTES
	public CajaEgresoDetalle (Long id,Date versionRow,Long id_caja_egreso,Long id_empresa,Long id_sucursal,Long id_cliente,Long id_factura,String concepto,Double valor) throws Exception {
		super();		
		
		this.id=id;
		this.versionRow=versionRow;
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.cajaegresodetalleOriginal=this;
		
 		this.id_caja_egreso=id_caja_egreso;
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
	public CajaEgresoDetalle (Long id_caja_egreso,Long id_empresa,Long id_sucursal,Long id_cliente,Long id_factura,String concepto,Double valor) throws Exception {
		super();		
		
		this.id=0L;
		this.versionRow=new Date();
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.cajaegresodetalleOriginal=this;
		
 		this.id_caja_egreso=id_caja_egreso;
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
		CajaEgresoDetalle cajaegresodetalleLocal=null;
		
		if(object!=null) {
			cajaegresodetalleLocal=(CajaEgresoDetalle)object;
			
			if(cajaegresodetalleLocal!=null) {
				if(this.getId()!=null && cajaegresodetalleLocal.getId()!=null) {
					if(this.getId().equals(cajaegresodetalleLocal.getId())) {
						equal=true;
					}
				}
			}
		}
		
		return equal;
	}
	
	public String toString() {
		String sDetalle="";
		
		if(!CajaEgresoDetalleConstantesFunciones.CON_DESCRIPCION_DETALLADO) {
        	sDetalle=CajaEgresoDetalleConstantesFunciones.getCajaEgresoDetalleDescripcion(this);
		} else {
			sDetalle=CajaEgresoDetalleConstantesFunciones.getCajaEgresoDetalleDescripcionDetallado(this);
		}
		
		return sDetalle;
    }
	
	public CajaEgresoDetalle getCajaEgresoDetalleOriginal() {
		return this.cajaegresodetalleOriginal;
	}
	
	public void setCajaEgresoDetalleOriginal(CajaEgresoDetalle cajaegresodetalle) {
		try {
			this.cajaegresodetalleOriginal=cajaegresodetalle;
		} catch(Exception e) {
			;
		}
	}
	
	
	protected CajaEgresoDetalleAdditional cajaegresodetalleAdditional=null;
	
	public CajaEgresoDetalleAdditional getCajaEgresoDetalleAdditional() {
		return this.cajaegresodetalleAdditional;
	}
	
	public void setCajaEgresoDetalleAdditional(CajaEgresoDetalleAdditional cajaegresodetalleAdditional) {
		try {
			this.cajaegresodetalleAdditional=cajaegresodetalleAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
    
	
	public Long getid_caja_egreso() {
		return this.id_caja_egreso;
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
	
    
	public void setid_caja_egreso(Long newid_caja_egreso)throws Exception
	{
		try {
			if(this.id_caja_egreso!=newid_caja_egreso) {
				if(newid_caja_egreso==null) {
					//newid_caja_egreso=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("CajaEgresoDetalle:Valor nulo no permitido en columna id_caja_egreso");
					}
				}

				this.id_caja_egreso=newid_caja_egreso;
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
						System.out.println("CajaEgresoDetalle:Valor nulo no permitido en columna id_empresa");
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
						System.out.println("CajaEgresoDetalle:Valor nulo no permitido en columna id_sucursal");
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
						System.out.println("CajaEgresoDetalle:Valor nulo no permitido en columna id_cliente");
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
						System.out.println("CajaEgresoDetalle:Valor nulo no permitido en columna id_factura");
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
						System.out.println("CajaEgresoDetalle:Valor nulo no permitido en columna concepto");
					}
				}

				if(newconcepto!=null&&newconcepto.length()>150) {
					newconcepto=newconcepto.substring(0,148);
					System.out.println("CajaEgresoDetalle:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=150 en columna concepto");
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
						System.out.println("CajaEgresoDetalle:Valor nulo no permitido en columna valor");
					}
				}

				this.valor=newvalor;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	
	public CajaEgreso getCajaEgreso() {
		return this.cajaegreso;
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

	
	
	public String getcajaegreso_descripcion() {
		return this.cajaegreso_descripcion;
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

	
	
	public  void  setCajaEgreso(CajaEgreso cajaegreso) {
		try {
			this.cajaegreso=cajaegreso;
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


	
	
	public  void  setcajaegreso_descripcion(String cajaegreso_descripcion) {
		try {
			this.cajaegreso_descripcion=cajaegreso_descripcion;
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
	String id_caja_egreso_descripcion="";String id_empresa_descripcion="";String id_sucursal_descripcion="";String id_cliente_descripcion="";String id_factura_descripcion="";
	
	
	public String getid_caja_egreso_descripcion() {
		return id_caja_egreso_descripcion;
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
	
	
	public void setid_caja_egreso_descripcion(String newid_caja_egreso_descripcion)throws Exception {
		try {
			this.id_caja_egreso_descripcion=newid_caja_egreso_descripcion;
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
		this.id_caja_egreso_descripcion="";this.id_empresa_descripcion="";this.id_sucursal_descripcion="";this.id_cliente_descripcion="";this.id_factura_descripcion="";
	}
	
	
	
	
	
	
	/*PARA REPORTES FIN*/		
}

