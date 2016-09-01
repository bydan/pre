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
//import com.bydan.erp.cartera.util.PlaneacionPagosConstantesFunciones;
import com.bydan.erp.cartera.util.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.cartera.util.*;
import com.bydan.erp.facturacion.util.*;

import com.bydan.erp.cartera.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;
import com.bydan.erp.facturacion.business.entity.*;




@SuppressWarnings("unused")
public class PlaneacionPagos extends PlaneacionPagosAdditional implements Serializable ,Cloneable {//PlaneacionPagosAdditional,GeneralEntity
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
	
	private PlaneacionPagos planeacionpagosOriginal;
	
	private Map<String, Object> mapPlaneacionPagos;
			
	public Map<String, Object> getMapPlaneacionPagos() {
		return mapPlaneacionPagos;
	}

	public void setMapPlaneacionPagos(Map<String, Object> mapPlaneacionPagos) {
		this.mapPlaneacionPagos = mapPlaneacionPagos;
	}
	
	public void inicializarMapPlaneacionPagos() {
		this.mapPlaneacionPagos = new HashMap<String,Object>();
	}
	
	public void setMapPlaneacionPagosValue(String sKey,Object oValue) {
		this.mapPlaneacionPagos.put(sKey, oValue);
	}
	
	public Object getMapPlaneacionPagosValue(String sKey) {
		return this.mapPlaneacionPagos.get(sKey);
	}
	
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_empresa;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_grupo_cliente;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Date fecha_pago_inicio;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Date fecha_pago_fin;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=-100000,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_factura;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_cliente;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=150,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	//@Pattern(regex=PlaneacionPagosConstantesFunciones.SREGEXNOMBRE_CLIENTE,message=PlaneacionPagosConstantesFunciones.SMENSAJEREGEXNOMBRE_CLIENTE)
	private String nombre_cliente;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=50,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	//@Pattern(regex=PlaneacionPagosConstantesFunciones.SREGEXNUMERO_FACTURA,message=PlaneacionPagosConstantesFunciones.SMENSAJEREGEXNUMERO_FACTURA)
	private String numero_factura;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Date fecha_emision;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Date fecha_venta;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Date fecha_pago;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double saldo;
			
	
	public Empresa empresa;
	public GrupoCliente grupocliente;
	public Factura factura;
	public Cliente cliente;
	
	
	private String empresa_descripcion;
	private String grupocliente_descripcion;
	private String factura_descripcion;
	private String cliente_descripcion;
	
	
		
	public PlaneacionPagos () throws Exception {
		super();		
		
		this.id=0L;
		
		
		this.versionRow=new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());//new Date();
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		this.sType="NONE";
		
		this.planeacionpagosOriginal=this;
		
 		this.id_empresa=-1L;
 		this.id_grupo_cliente=-1L;
 		this.fecha_pago_inicio=new Date();
 		this.fecha_pago_fin=new Date();
 		this.id_factura=-1L;
 		this.id_cliente=-1L;
 		this.nombre_cliente="";
 		this.numero_factura="";
 		this.fecha_emision=new Date();
 		this.fecha_venta=new Date();
 		this.fecha_pago=new Date();
 		this.saldo=0.0;
		
		
		this.empresa=null;
		this.grupocliente=null;
		this.factura=null;
		this.cliente=null;
		
		
		this.empresa_descripcion="";
		this.grupocliente_descripcion="";
		this.factura_descripcion="";
		this.cliente_descripcion="";
		
		
		
			
		
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
    //PARA REPORTES
	public PlaneacionPagos (Long id,Date versionRow,Long id_factura,Long id_cliente,String nombre_cliente,String numero_factura,Date fecha_emision,Date fecha_venta,Date fecha_pago,Double saldo) throws Exception {
		super();		
		
		this.id=id;
		this.versionRow=versionRow;
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.planeacionpagosOriginal=this;
		
 		this.id_factura=id_factura;
 		this.id_cliente=id_cliente;
 		this.nombre_cliente=nombre_cliente;
 		this.numero_factura=numero_factura;
 		this.fecha_emision=fecha_emision;
 		this.fecha_venta=fecha_venta;
 		this.fecha_pago=fecha_pago;
 		this.saldo=saldo;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	 //PARA REPORTES
	public PlaneacionPagos (Long id_factura,Long id_cliente,String nombre_cliente,String numero_factura,Date fecha_emision,Date fecha_venta,Date fecha_pago,Double saldo) throws Exception {
		super();		
		
		this.id=0L;
		this.versionRow=new Date();
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.planeacionpagosOriginal=this;
		
 		this.id_factura=id_factura;
 		this.id_cliente=id_cliente;
 		this.nombre_cliente=nombre_cliente;
 		this.numero_factura=numero_factura;
 		this.fecha_emision=fecha_emision;
 		this.fecha_venta=fecha_venta;
 		this.fecha_pago=fecha_pago;
 		this.saldo=saldo;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	
	public PlaneacionPagos getPlaneacionPagosOriginal() {
		return this.planeacionpagosOriginal;
	}
	
	public void setPlaneacionPagosOriginal(PlaneacionPagos planeacionpagos) {
		try {
			this.planeacionpagosOriginal=planeacionpagos;
		} catch(Exception e) {
			;
		}
	}
	
	
	protected PlaneacionPagosAdditional planeacionpagosAdditional=null;
	
	public PlaneacionPagosAdditional getPlaneacionPagosAdditional() {
		return this.planeacionpagosAdditional;
	}
	
	public void setPlaneacionPagosAdditional(PlaneacionPagosAdditional planeacionpagosAdditional) {
		try {
			this.planeacionpagosAdditional=planeacionpagosAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
    
	
	public Long getid_empresa() {
		return this.id_empresa;
	}
    
	
	public Long getid_grupo_cliente() {
		return this.id_grupo_cliente;
	}
    
	
	public Date getfecha_pago_inicio() {
		return this.fecha_pago_inicio;
	}
    
	
	public Date getfecha_pago_fin() {
		return this.fecha_pago_fin;
	}
    
	
	public Long getid_factura() {
		return this.id_factura;
	}
    
	
	public Long getid_cliente() {
		return this.id_cliente;
	}
    
	
	public String getnombre_cliente() {
		return this.nombre_cliente;
	}
    
	
	public String getnumero_factura() {
		return this.numero_factura;
	}
    
	
	public Date getfecha_emision() {
		return this.fecha_emision;
	}
    
	
	public Date getfecha_venta() {
		return this.fecha_venta;
	}
    
	
	public Date getfecha_pago() {
		return this.fecha_pago;
	}
    
	
	public Double getsaldo() {
		return this.saldo;
	}
	
    
	public void setid_empresa(Long newid_empresa)throws Exception
	{
		try {
			if(this.id_empresa!=newid_empresa) {
				if(newid_empresa==null) {
					//newid_empresa=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("PlaneacionPagos:Valor nulo no permitido en columna id_empresa");
					}
				}

				this.id_empresa=newid_empresa;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_grupo_cliente(Long newid_grupo_cliente)throws Exception
	{
		try {
			if(this.id_grupo_cliente!=newid_grupo_cliente) {
				if(newid_grupo_cliente==null) {
					//newid_grupo_cliente=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("PlaneacionPagos:Valor nulo no permitido en columna id_grupo_cliente");
					}
				}

				this.id_grupo_cliente=newid_grupo_cliente;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setfecha_pago_inicio(Date newfecha_pago_inicio)throws Exception
	{
		try {
			if(this.fecha_pago_inicio!=newfecha_pago_inicio) {
				if(newfecha_pago_inicio==null) {
					//newfecha_pago_inicio=new Date();
					if(Constantes.ISDEVELOPING) {
						System.out.println("PlaneacionPagos:Valor nulo no permitido en columna fecha_pago_inicio");
					}
				}

				this.fecha_pago_inicio=newfecha_pago_inicio;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setfecha_pago_fin(Date newfecha_pago_fin)throws Exception
	{
		try {
			if(this.fecha_pago_fin!=newfecha_pago_fin) {
				if(newfecha_pago_fin==null) {
					//newfecha_pago_fin=new Date();
					if(Constantes.ISDEVELOPING) {
						System.out.println("PlaneacionPagos:Valor nulo no permitido en columna fecha_pago_fin");
					}
				}

				this.fecha_pago_fin=newfecha_pago_fin;
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
						System.out.println("PlaneacionPagos:Valor nulo no permitido en columna id_factura");
					}
				}

				this.id_factura=newid_factura;
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
						System.out.println("PlaneacionPagos:Valor nulo no permitido en columna id_cliente");
					}
				}

				this.id_cliente=newid_cliente;
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
						System.out.println("PlaneacionPagos:Valor nulo no permitido en columna nombre_cliente");
					}
				}

				if(newnombre_cliente!=null&&newnombre_cliente.length()>150) {
					newnombre_cliente=newnombre_cliente.substring(0,148);
					System.out.println("PlaneacionPagos:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=150 en columna nombre_cliente");
				}

				this.nombre_cliente=newnombre_cliente;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setnumero_factura(String newnumero_factura)throws Exception
	{
		try {
			if(this.numero_factura!=newnumero_factura) {
				if(newnumero_factura==null) {
					//newnumero_factura="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("PlaneacionPagos:Valor nulo no permitido en columna numero_factura");
					}
				}

				if(newnumero_factura!=null&&newnumero_factura.length()>50) {
					newnumero_factura=newnumero_factura.substring(0,48);
					System.out.println("PlaneacionPagos:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=50 en columna numero_factura");
				}

				this.numero_factura=newnumero_factura;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setfecha_emision(Date newfecha_emision)throws Exception
	{
		try {
			if(this.fecha_emision!=newfecha_emision) {
				if(newfecha_emision==null) {
					//newfecha_emision=new Date();
					if(Constantes.ISDEVELOPING) {
						System.out.println("PlaneacionPagos:Valor nulo no permitido en columna fecha_emision");
					}
				}

				this.fecha_emision=newfecha_emision;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setfecha_venta(Date newfecha_venta)throws Exception
	{
		try {
			if(this.fecha_venta!=newfecha_venta) {
				if(newfecha_venta==null) {
					//newfecha_venta=new Date();
					if(Constantes.ISDEVELOPING) {
						System.out.println("PlaneacionPagos:Valor nulo no permitido en columna fecha_venta");
					}
				}

				this.fecha_venta=newfecha_venta;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setfecha_pago(Date newfecha_pago)throws Exception
	{
		try {
			if(this.fecha_pago!=newfecha_pago) {
				if(newfecha_pago==null) {
					//newfecha_pago=new Date();
					if(Constantes.ISDEVELOPING) {
						System.out.println("PlaneacionPagos:Valor nulo no permitido en columna fecha_pago");
					}
				}

				this.fecha_pago=newfecha_pago;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setsaldo(Double newsaldo)throws Exception
	{
		try {
			if(this.saldo!=newsaldo) {
				if(newsaldo==null) {
					//newsaldo=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("PlaneacionPagos:Valor nulo no permitido en columna saldo");
					}
				}

				this.saldo=newsaldo;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	
	public Empresa getEmpresa() {
		return this.empresa;
	}

	public GrupoCliente getGrupoCliente() {
		return this.grupocliente;
	}

	public Factura getFactura() {
		return this.factura;
	}

	public Cliente getCliente() {
		return this.cliente;
	}

	
	
	public String getempresa_descripcion() {
		return this.empresa_descripcion;
	}

	public String getgrupocliente_descripcion() {
		return this.grupocliente_descripcion;
	}

	public String getfactura_descripcion() {
		return this.factura_descripcion;
	}

	public String getcliente_descripcion() {
		return this.cliente_descripcion;
	}

	
	
	public  void  setEmpresa(Empresa empresa) {
		try {
			this.empresa=empresa;
		} catch(Exception e) {
			;
		}
	}


	public  void  setGrupoCliente(GrupoCliente grupocliente) {
		try {
			this.grupocliente=grupocliente;
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


	public  void  setCliente(Cliente cliente) {
		try {
			this.cliente=cliente;
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


	public  void  setgrupocliente_descripcion(String grupocliente_descripcion) {
		try {
			this.grupocliente_descripcion=grupocliente_descripcion;
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


	public  void  setcliente_descripcion(String cliente_descripcion) {
		try {
			this.cliente_descripcion=cliente_descripcion;
		} catch(Exception e) {
			;
		}
	}


	
	
	
	
	
	/*PARA REPORTES*/
	String id_empresa_descripcion="";String id_grupo_cliente_descripcion="";String id_factura_descripcion="";String id_cliente_descripcion="";
	
	
	public String getid_empresa_descripcion() {
		return id_empresa_descripcion;
	}
	public String getid_grupo_cliente_descripcion() {
		return id_grupo_cliente_descripcion;
	}
	public String getid_factura_descripcion() {
		return id_factura_descripcion;
	}
	public String getid_cliente_descripcion() {
		return id_cliente_descripcion;
	}
	
	
	public void setid_empresa_descripcion(String newid_empresa_descripcion)throws Exception {
		try {
			this.id_empresa_descripcion=newid_empresa_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_grupo_cliente_descripcion(String newid_grupo_cliente_descripcion)throws Exception {
		try {
			this.id_grupo_cliente_descripcion=newid_grupo_cliente_descripcion;
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
	public void setid_cliente_descripcion(String newid_cliente_descripcion)throws Exception {
		try {
			this.id_cliente_descripcion=newid_cliente_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	
	public void inicializarVariablesParaReporte() {
		this.id_empresa_descripcion="";this.id_grupo_cliente_descripcion="";this.id_factura_descripcion="";this.id_cliente_descripcion="";
	}
	
	
	
	
	
	
	/*PARA REPORTES FIN*/		
}

