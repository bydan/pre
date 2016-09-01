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
package com.bydan.erp.cartera.business.entity;

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
//import com.bydan.erp.cartera.util.GarantiaClienteConstantesFunciones;
import com.bydan.erp.cartera.util.*;


import com.bydan.erp.seguridad.util.*;



import com.bydan.erp.seguridad.business.entity.*;




@SuppressWarnings("unused")
public class GarantiaCliente extends GarantiaClienteAdditional implements Serializable ,Cloneable {//GarantiaClienteAdditional,GeneralEntity
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
	
	private GarantiaCliente garantiaclienteOriginal;
	
	private Map<String, Object> mapGarantiaCliente;
			
	public Map<String, Object> getMapGarantiaCliente() {
		return mapGarantiaCliente;
	}

	public void setMapGarantiaCliente(Map<String, Object> mapGarantiaCliente) {
		this.mapGarantiaCliente = mapGarantiaCliente;
	}
	
	public void inicializarMapGarantiaCliente() {
		this.mapGarantiaCliente = new HashMap<String,Object>();
	}
	
	public void setMapGarantiaClienteValue(String sKey,Object oValue) {
		this.mapGarantiaCliente.put(sKey, oValue);
	}
	
	public Object getMapGarantiaClienteValue(String sKey) {
		return this.mapGarantiaCliente.get(sKey);
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
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_tipo_garantia_empresa;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double valor;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Date fecha_recepcion;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Date fecha_firma;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Date fecha_devolucion;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=250,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=GarantiaClienteConstantesFunciones.SREGEXBENEFICIARIO,message=GarantiaClienteConstantesFunciones.SMENSAJEREGEXBENEFICIARIO)
	private String beneficiario;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_estado_garantia_cliente;
			
	
	public Empresa empresa;
	public Sucursal sucursal;
	public Cliente cliente;
	public TipoGarantiaEmpresa tipogarantiaempresa;
	public EstadoGarantiaCliente estadogarantiacliente;
	
	
	private String empresa_descripcion;
	private String sucursal_descripcion;
	private String cliente_descripcion;
	private String tipogarantiaempresa_descripcion;
	private String estadogarantiacliente_descripcion;
	
	
		
	public GarantiaCliente () throws Exception {
		super();		
		
		this.id=0L;
		
		
		this.versionRow=new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());//new Date();
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		this.sType="NONE";
		
		this.garantiaclienteOriginal=this;
		
 		this.id_empresa=-1L;
 		this.id_sucursal=-1L;
 		this.id_cliente=-1L;
 		this.id_tipo_garantia_empresa=-1L;
 		this.valor=0.0;
 		this.fecha_recepcion=new Date();
 		this.fecha_firma=new Date();
 		this.fecha_devolucion=new Date();
 		this.beneficiario="";
 		this.id_estado_garantia_cliente=-1L;
		
		
		this.empresa=null;
		this.sucursal=null;
		this.cliente=null;
		this.tipogarantiaempresa=null;
		this.estadogarantiacliente=null;
		
		
		this.empresa_descripcion="";
		this.sucursal_descripcion="";
		this.cliente_descripcion="";
		this.tipogarantiaempresa_descripcion="";
		this.estadogarantiacliente_descripcion="";
		
		
		
			
		
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
    //PARA REPORTES
	public GarantiaCliente (Long id,Date versionRow,Long id_empresa,Long id_sucursal,Long id_cliente,Long id_tipo_garantia_empresa,Double valor,Date fecha_recepcion,Date fecha_firma,Date fecha_devolucion,String beneficiario,Long id_estado_garantia_cliente) throws Exception {
		super();		
		
		this.id=id;
		this.versionRow=versionRow;
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.garantiaclienteOriginal=this;
		
 		this.id_empresa=id_empresa;
 		this.id_sucursal=id_sucursal;
 		this.id_cliente=id_cliente;
 		this.id_tipo_garantia_empresa=id_tipo_garantia_empresa;
 		this.valor=valor;
 		this.fecha_recepcion=fecha_recepcion;
 		this.fecha_firma=fecha_firma;
 		this.fecha_devolucion=fecha_devolucion;
 		this.beneficiario=beneficiario;
 		this.id_estado_garantia_cliente=id_estado_garantia_cliente;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	 //PARA REPORTES
	public GarantiaCliente (Long id_empresa,Long id_sucursal,Long id_cliente,Long id_tipo_garantia_empresa,Double valor,Date fecha_recepcion,Date fecha_firma,Date fecha_devolucion,String beneficiario,Long id_estado_garantia_cliente) throws Exception {
		super();		
		
		this.id=0L;
		this.versionRow=new Date();
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.garantiaclienteOriginal=this;
		
 		this.id_empresa=id_empresa;
 		this.id_sucursal=id_sucursal;
 		this.id_cliente=id_cliente;
 		this.id_tipo_garantia_empresa=id_tipo_garantia_empresa;
 		this.valor=valor;
 		this.fecha_recepcion=fecha_recepcion;
 		this.fecha_firma=fecha_firma;
 		this.fecha_devolucion=fecha_devolucion;
 		this.beneficiario=beneficiario;
 		this.id_estado_garantia_cliente=id_estado_garantia_cliente;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	public boolean equals(Object object) {
		boolean equal=false;
		GarantiaCliente garantiaclienteLocal=null;
		
		if(object!=null) {
			garantiaclienteLocal=(GarantiaCliente)object;
			
			if(garantiaclienteLocal!=null) {
				if(this.getId()!=null && garantiaclienteLocal.getId()!=null) {
					if(this.getId().equals(garantiaclienteLocal.getId())) {
						equal=true;
					}
				}
			}
		}
		
		return equal;
	}
	
	public String toString() {
		String sDetalle="";
		
		if(!GarantiaClienteConstantesFunciones.CON_DESCRIPCION_DETALLADO) {
        	sDetalle=GarantiaClienteConstantesFunciones.getGarantiaClienteDescripcion(this);
		} else {
			sDetalle=GarantiaClienteConstantesFunciones.getGarantiaClienteDescripcionDetallado(this);
		}
		
		return sDetalle;
    }
	
	public GarantiaCliente getGarantiaClienteOriginal() {
		return this.garantiaclienteOriginal;
	}
	
	public void setGarantiaClienteOriginal(GarantiaCliente garantiacliente) {
		try {
			this.garantiaclienteOriginal=garantiacliente;
		} catch(Exception e) {
			;
		}
	}
	
	
	protected GarantiaClienteAdditional garantiaclienteAdditional=null;
	
	public GarantiaClienteAdditional getGarantiaClienteAdditional() {
		return this.garantiaclienteAdditional;
	}
	
	public void setGarantiaClienteAdditional(GarantiaClienteAdditional garantiaclienteAdditional) {
		try {
			this.garantiaclienteAdditional=garantiaclienteAdditional;
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
    
	
	public Long getid_tipo_garantia_empresa() {
		return this.id_tipo_garantia_empresa;
	}
    
	
	public Double getvalor() {
		return this.valor;
	}
    
	
	public Date getfecha_recepcion() {
		return this.fecha_recepcion;
	}
    
	
	public Date getfecha_firma() {
		return this.fecha_firma;
	}
    
	
	public Date getfecha_devolucion() {
		return this.fecha_devolucion;
	}
    
	
	public String getbeneficiario() {
		return this.beneficiario;
	}
    
	
	public Long getid_estado_garantia_cliente() {
		return this.id_estado_garantia_cliente;
	}
	
    
	public void setid_empresa(Long newid_empresa)throws Exception
	{
		try {
			if(this.id_empresa!=newid_empresa) {
				if(newid_empresa==null) {
					//newid_empresa=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("GarantiaCliente:Valor nulo no permitido en columna id_empresa");
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
						System.out.println("GarantiaCliente:Valor nulo no permitido en columna id_sucursal");
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
						System.out.println("GarantiaCliente:Valor nulo no permitido en columna id_cliente");
					}
				}

				this.id_cliente=newid_cliente;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_tipo_garantia_empresa(Long newid_tipo_garantia_empresa)throws Exception
	{
		try {
			if(this.id_tipo_garantia_empresa!=newid_tipo_garantia_empresa) {
				if(newid_tipo_garantia_empresa==null) {
					//newid_tipo_garantia_empresa=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("GarantiaCliente:Valor nulo no permitido en columna id_tipo_garantia_empresa");
					}
				}

				this.id_tipo_garantia_empresa=newid_tipo_garantia_empresa;
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
						System.out.println("GarantiaCliente:Valor nulo no permitido en columna valor");
					}
				}

				this.valor=newvalor;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setfecha_recepcion(Date newfecha_recepcion)throws Exception
	{
		try {
			if(this.fecha_recepcion!=newfecha_recepcion) {
				if(newfecha_recepcion==null) {
					//newfecha_recepcion=new Date();
					if(Constantes.ISDEVELOPING) {
						System.out.println("GarantiaCliente:Valor nulo no permitido en columna fecha_recepcion");
					}
				}

				this.fecha_recepcion=newfecha_recepcion;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setfecha_firma(Date newfecha_firma)throws Exception
	{
		try {
			if(this.fecha_firma!=newfecha_firma) {
				if(newfecha_firma==null) {
					//newfecha_firma=new Date();
					if(Constantes.ISDEVELOPING) {
						System.out.println("GarantiaCliente:Valor nulo no permitido en columna fecha_firma");
					}
				}

				this.fecha_firma=newfecha_firma;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setfecha_devolucion(Date newfecha_devolucion)throws Exception
	{
		try {
			if(this.fecha_devolucion!=newfecha_devolucion) {
				if(newfecha_devolucion==null) {
					//newfecha_devolucion=new Date();
					if(Constantes.ISDEVELOPING) {
						System.out.println("GarantiaCliente:Valor nulo no permitido en columna fecha_devolucion");
					}
				}

				this.fecha_devolucion=newfecha_devolucion;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setbeneficiario(String newbeneficiario)throws Exception
	{
		try {
			if(this.beneficiario!=newbeneficiario) {
				if(newbeneficiario==null) {
					//newbeneficiario="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("GarantiaCliente:Valor nulo no permitido en columna beneficiario");
					}
				}

				if(newbeneficiario!=null&&newbeneficiario.length()>250) {
					newbeneficiario=newbeneficiario.substring(0,248);
					System.out.println("GarantiaCliente:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=250 en columna beneficiario");
				}

				this.beneficiario=newbeneficiario;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_estado_garantia_cliente(Long newid_estado_garantia_cliente)throws Exception
	{
		try {
			if(this.id_estado_garantia_cliente!=newid_estado_garantia_cliente) {
				if(newid_estado_garantia_cliente==null) {
					//newid_estado_garantia_cliente=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("GarantiaCliente:Valor nulo no permitido en columna id_estado_garantia_cliente");
					}
				}

				this.id_estado_garantia_cliente=newid_estado_garantia_cliente;
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

	public TipoGarantiaEmpresa getTipoGarantiaEmpresa() {
		return this.tipogarantiaempresa;
	}

	public EstadoGarantiaCliente getEstadoGarantiaCliente() {
		return this.estadogarantiacliente;
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

	public String gettipogarantiaempresa_descripcion() {
		return this.tipogarantiaempresa_descripcion;
	}

	public String getestadogarantiacliente_descripcion() {
		return this.estadogarantiacliente_descripcion;
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


	public  void  setTipoGarantiaEmpresa(TipoGarantiaEmpresa tipogarantiaempresa) {
		try {
			this.tipogarantiaempresa=tipogarantiaempresa;
		} catch(Exception e) {
			;
		}
	}


	public  void  setEstadoGarantiaCliente(EstadoGarantiaCliente estadogarantiacliente) {
		try {
			this.estadogarantiacliente=estadogarantiacliente;
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


	public  void  settipogarantiaempresa_descripcion(String tipogarantiaempresa_descripcion) {
		try {
			this.tipogarantiaempresa_descripcion=tipogarantiaempresa_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  setestadogarantiacliente_descripcion(String estadogarantiacliente_descripcion) {
		try {
			this.estadogarantiacliente_descripcion=estadogarantiacliente_descripcion;
		} catch(Exception e) {
			;
		}
	}


	
	
	
	
	
	/*PARA REPORTES*/
	String id_empresa_descripcion="";String id_sucursal_descripcion="";String id_cliente_descripcion="";String id_tipo_garantia_empresa_descripcion="";String id_estado_garantia_cliente_descripcion="";
	
	
	public String getid_empresa_descripcion() {
		return id_empresa_descripcion;
	}
	public String getid_sucursal_descripcion() {
		return id_sucursal_descripcion;
	}
	public String getid_cliente_descripcion() {
		return id_cliente_descripcion;
	}
	public String getid_tipo_garantia_empresa_descripcion() {
		return id_tipo_garantia_empresa_descripcion;
	}
	public String getid_estado_garantia_cliente_descripcion() {
		return id_estado_garantia_cliente_descripcion;
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
	public void setid_tipo_garantia_empresa_descripcion(String newid_tipo_garantia_empresa_descripcion)throws Exception {
		try {
			this.id_tipo_garantia_empresa_descripcion=newid_tipo_garantia_empresa_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_estado_garantia_cliente_descripcion(String newid_estado_garantia_cliente_descripcion)throws Exception {
		try {
			this.id_estado_garantia_cliente_descripcion=newid_estado_garantia_cliente_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	
	public void inicializarVariablesParaReporte() {
		this.id_empresa_descripcion="";this.id_sucursal_descripcion="";this.id_cliente_descripcion="";this.id_tipo_garantia_empresa_descripcion="";this.id_estado_garantia_cliente_descripcion="";
	}
	
	
	
	
	
	
	/*PARA REPORTES FIN*/		
}

