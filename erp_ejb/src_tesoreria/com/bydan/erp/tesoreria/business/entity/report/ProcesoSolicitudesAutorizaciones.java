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
package com.bydan.erp.tesoreria.business.entity.report;

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
//import com.bydan.erp.tesoreria.util.ProcesoSolicitudesAutorizacionesConstantesFunciones;
import com.bydan.erp.tesoreria.util.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.cartera.util.*;

import com.bydan.erp.tesoreria.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;




@SuppressWarnings("unused")
public class ProcesoSolicitudesAutorizaciones extends ProcesoSolicitudesAutorizacionesAdditional implements Serializable ,Cloneable {//ProcesoSolicitudesAutorizacionesAdditional,GeneralEntity
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
	
	private ProcesoSolicitudesAutorizaciones procesosolicitudesautorizacionesOriginal;
	
	private Map<String, Object> mapProcesoSolicitudesAutorizaciones;
			
	public Map<String, Object> getMapProcesoSolicitudesAutorizaciones() {
		return mapProcesoSolicitudesAutorizaciones;
	}

	public void setMapProcesoSolicitudesAutorizaciones(Map<String, Object> mapProcesoSolicitudesAutorizaciones) {
		this.mapProcesoSolicitudesAutorizaciones = mapProcesoSolicitudesAutorizaciones;
	}
	
	public void inicializarMapProcesoSolicitudesAutorizaciones() {
		this.mapProcesoSolicitudesAutorizaciones = new HashMap<String,Object>();
	}
	
	public void setMapProcesoSolicitudesAutorizacionesValue(String sKey,Object oValue) {
		this.mapProcesoSolicitudesAutorizaciones.put(sKey, oValue);
	}
	
	public Object getMapProcesoSolicitudesAutorizacionesValue(String sKey) {
		return this.mapProcesoSolicitudesAutorizaciones.get(sKey);
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
	private Long id_cliente;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Date fecha_vencimiento_hasta;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=50,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	//@Pattern(regex=ProcesoSolicitudesAutorizacionesConstantesFunciones.SREGEXNOMBRE_MONEDA,message=ProcesoSolicitudesAutorizacionesConstantesFunciones.SMENSAJEREGEXNOMBRE_MONEDA)
	private String nombre_moneda;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=150,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	//@Pattern(regex=ProcesoSolicitudesAutorizacionesConstantesFunciones.SREGEXNOMBRE_COMPLETO_CLIENTE,message=ProcesoSolicitudesAutorizacionesConstantesFunciones.SMENSAJEREGEXNOMBRE_COMPLETO_CLIENTE)
	private String nombre_completo_cliente;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=50,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	//@Pattern(regex=ProcesoSolicitudesAutorizacionesConstantesFunciones.SREGEXNUMERO_PRE_IMPRESO_FACTURA,message=ProcesoSolicitudesAutorizacionesConstantesFunciones.SMENSAJEREGEXNUMERO_PRE_IMPRESO_FACTURA)
	private String numero_pre_impreso_factura;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Date fecha_emision;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Date fecha_pago;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Date fecha_vencimiento;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double debito_mone_local;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double debito_mone_extra;
			
	
	public Empresa empresa;
	public Sucursal sucursal;
	public Cliente cliente;
	
	
	private String empresa_descripcion;
	private String sucursal_descripcion;
	private String cliente_descripcion;
	
	
		
	public ProcesoSolicitudesAutorizaciones () throws Exception {
		super();		
		
		this.id=0L;
		
		
		this.versionRow=new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());//new Date();
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		this.sType="NONE";
		
		this.procesosolicitudesautorizacionesOriginal=this;
		
 		this.id_empresa=-1L;
 		this.id_sucursal=-1L;
 		this.id_cliente=-1L;
 		this.fecha_vencimiento_hasta=new Date();
 		this.nombre_moneda="";
 		this.nombre_completo_cliente="";
 		this.numero_pre_impreso_factura="";
 		this.fecha_emision=new Date();
 		this.fecha_pago=new Date();
 		this.fecha_vencimiento=new Date();
 		this.debito_mone_local=0.0;
 		this.debito_mone_extra=0.0;
		
		
		this.empresa=null;
		this.sucursal=null;
		this.cliente=null;
		
		
		this.empresa_descripcion="";
		this.sucursal_descripcion="";
		this.cliente_descripcion="";
		
		
		
			
		
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
    //PARA REPORTES
	public ProcesoSolicitudesAutorizaciones (Long id,Date versionRow,String nombre_moneda,String nombre_completo_cliente,String numero_pre_impreso_factura,Date fecha_emision,Date fecha_pago,Date fecha_vencimiento,Double debito_mone_local,Double debito_mone_extra) throws Exception {
		super();		
		
		this.id=id;
		this.versionRow=versionRow;
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.procesosolicitudesautorizacionesOriginal=this;
		
 		this.nombre_moneda=nombre_moneda;
 		this.nombre_completo_cliente=nombre_completo_cliente;
 		this.numero_pre_impreso_factura=numero_pre_impreso_factura;
 		this.fecha_emision=fecha_emision;
 		this.fecha_pago=fecha_pago;
 		this.fecha_vencimiento=fecha_vencimiento;
 		this.debito_mone_local=debito_mone_local;
 		this.debito_mone_extra=debito_mone_extra;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	 //PARA REPORTES
	public ProcesoSolicitudesAutorizaciones (String nombre_moneda,String nombre_completo_cliente,String numero_pre_impreso_factura,Date fecha_emision,Date fecha_pago,Date fecha_vencimiento,Double debito_mone_local,Double debito_mone_extra) throws Exception {
		super();		
		
		this.id=0L;
		this.versionRow=new Date();
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.procesosolicitudesautorizacionesOriginal=this;
		
 		this.nombre_moneda=nombre_moneda;
 		this.nombre_completo_cliente=nombre_completo_cliente;
 		this.numero_pre_impreso_factura=numero_pre_impreso_factura;
 		this.fecha_emision=fecha_emision;
 		this.fecha_pago=fecha_pago;
 		this.fecha_vencimiento=fecha_vencimiento;
 		this.debito_mone_local=debito_mone_local;
 		this.debito_mone_extra=debito_mone_extra;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	
	public ProcesoSolicitudesAutorizaciones getProcesoSolicitudesAutorizacionesOriginal() {
		return this.procesosolicitudesautorizacionesOriginal;
	}
	
	public void setProcesoSolicitudesAutorizacionesOriginal(ProcesoSolicitudesAutorizaciones procesosolicitudesautorizaciones) {
		try {
			this.procesosolicitudesautorizacionesOriginal=procesosolicitudesautorizaciones;
		} catch(Exception e) {
			;
		}
	}
	
	
	protected ProcesoSolicitudesAutorizacionesAdditional procesosolicitudesautorizacionesAdditional=null;
	
	public ProcesoSolicitudesAutorizacionesAdditional getProcesoSolicitudesAutorizacionesAdditional() {
		return this.procesosolicitudesautorizacionesAdditional;
	}
	
	public void setProcesoSolicitudesAutorizacionesAdditional(ProcesoSolicitudesAutorizacionesAdditional procesosolicitudesautorizacionesAdditional) {
		try {
			this.procesosolicitudesautorizacionesAdditional=procesosolicitudesautorizacionesAdditional;
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
    
	
	public Long getid_cliente() {
		return this.id_cliente;
	}
    
	
	public Date getfecha_vencimiento_hasta() {
		return this.fecha_vencimiento_hasta;
	}
    
	
	public String getnombre_moneda() {
		return this.nombre_moneda;
	}
    
	
	public String getnombre_completo_cliente() {
		return this.nombre_completo_cliente;
	}
    
	
	public String getnumero_pre_impreso_factura() {
		return this.numero_pre_impreso_factura;
	}
    
	
	public Date getfecha_emision() {
		return this.fecha_emision;
	}
    
	
	public Date getfecha_pago() {
		return this.fecha_pago;
	}
    
	
	public Date getfecha_vencimiento() {
		return this.fecha_vencimiento;
	}
    
	
	public Double getdebito_mone_local() {
		return this.debito_mone_local;
	}
    
	
	public Double getdebito_mone_extra() {
		return this.debito_mone_extra;
	}
	
    
	public void setid_empresa(Long newid_empresa)throws Exception
	{
		try {
			if(this.id_empresa!=newid_empresa) {
				if(newid_empresa==null) {
					//newid_empresa=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ProcesoSolicitudesAutorizaciones:Valor nulo no permitido en columna id_empresa");
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
						System.out.println("ProcesoSolicitudesAutorizaciones:Valor nulo no permitido en columna id_sucursal");
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
						System.out.println("ProcesoSolicitudesAutorizaciones:Valor nulo no permitido en columna id_cliente");
					}
				}

				this.id_cliente=newid_cliente;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setfecha_vencimiento_hasta(Date newfecha_vencimiento_hasta)throws Exception
	{
		try {
			if(this.fecha_vencimiento_hasta!=newfecha_vencimiento_hasta) {
				if(newfecha_vencimiento_hasta==null) {
					//newfecha_vencimiento_hasta=new Date();
					if(Constantes.ISDEVELOPING) {
						System.out.println("ProcesoSolicitudesAutorizaciones:Valor nulo no permitido en columna fecha_vencimiento_hasta");
					}
				}

				this.fecha_vencimiento_hasta=newfecha_vencimiento_hasta;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setnombre_moneda(String newnombre_moneda)throws Exception
	{
		try {
			if(this.nombre_moneda!=newnombre_moneda) {
				if(newnombre_moneda==null) {
					//newnombre_moneda="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("ProcesoSolicitudesAutorizaciones:Valor nulo no permitido en columna nombre_moneda");
					}
				}

				if(newnombre_moneda!=null&&newnombre_moneda.length()>50) {
					newnombre_moneda=newnombre_moneda.substring(0,48);
					System.out.println("ProcesoSolicitudesAutorizaciones:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=50 en columna nombre_moneda");
				}

				this.nombre_moneda=newnombre_moneda;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setnombre_completo_cliente(String newnombre_completo_cliente)throws Exception
	{
		try {
			if(this.nombre_completo_cliente!=newnombre_completo_cliente) {
				if(newnombre_completo_cliente==null) {
					//newnombre_completo_cliente="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("ProcesoSolicitudesAutorizaciones:Valor nulo no permitido en columna nombre_completo_cliente");
					}
				}

				if(newnombre_completo_cliente!=null&&newnombre_completo_cliente.length()>150) {
					newnombre_completo_cliente=newnombre_completo_cliente.substring(0,148);
					System.out.println("ProcesoSolicitudesAutorizaciones:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=150 en columna nombre_completo_cliente");
				}

				this.nombre_completo_cliente=newnombre_completo_cliente;
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
						System.out.println("ProcesoSolicitudesAutorizaciones:Valor nulo no permitido en columna numero_pre_impreso_factura");
					}
				}

				if(newnumero_pre_impreso_factura!=null&&newnumero_pre_impreso_factura.length()>50) {
					newnumero_pre_impreso_factura=newnumero_pre_impreso_factura.substring(0,48);
					System.out.println("ProcesoSolicitudesAutorizaciones:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=50 en columna numero_pre_impreso_factura");
				}

				this.numero_pre_impreso_factura=newnumero_pre_impreso_factura;
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
						System.out.println("ProcesoSolicitudesAutorizaciones:Valor nulo no permitido en columna fecha_emision");
					}
				}

				this.fecha_emision=newfecha_emision;
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
						System.out.println("ProcesoSolicitudesAutorizaciones:Valor nulo no permitido en columna fecha_pago");
					}
				}

				this.fecha_pago=newfecha_pago;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setfecha_vencimiento(Date newfecha_vencimiento)throws Exception
	{
		try {
			if(this.fecha_vencimiento!=newfecha_vencimiento) {
				if(newfecha_vencimiento==null) {
					//newfecha_vencimiento=new Date();
					if(Constantes.ISDEVELOPING) {
						System.out.println("ProcesoSolicitudesAutorizaciones:Valor nulo no permitido en columna fecha_vencimiento");
					}
				}

				this.fecha_vencimiento=newfecha_vencimiento;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setdebito_mone_local(Double newdebito_mone_local)throws Exception
	{
		try {
			if(this.debito_mone_local!=newdebito_mone_local) {
				if(newdebito_mone_local==null) {
					//newdebito_mone_local=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ProcesoSolicitudesAutorizaciones:Valor nulo no permitido en columna debito_mone_local");
					}
				}

				this.debito_mone_local=newdebito_mone_local;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setdebito_mone_extra(Double newdebito_mone_extra)throws Exception
	{
		try {
			if(this.debito_mone_extra!=newdebito_mone_extra) {
				if(newdebito_mone_extra==null) {
					//newdebito_mone_extra=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ProcesoSolicitudesAutorizaciones:Valor nulo no permitido en columna debito_mone_extra");
					}
				}

				this.debito_mone_extra=newdebito_mone_extra;
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

	public Cliente getCliente() {
		return this.cliente;
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


	
	
	
	
	
	/*PARA REPORTES*/
	String id_empresa_descripcion="";String id_sucursal_descripcion="";String id_cliente_descripcion="";
	
	
	public String getid_empresa_descripcion() {
		return id_empresa_descripcion;
	}
	public String getid_sucursal_descripcion() {
		return id_sucursal_descripcion;
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
	
	public void inicializarVariablesParaReporte() {
		this.id_empresa_descripcion="";this.id_sucursal_descripcion="";this.id_cliente_descripcion="";
	}
	
	
	
	
	
	
	/*PARA REPORTES FIN*/		
}

