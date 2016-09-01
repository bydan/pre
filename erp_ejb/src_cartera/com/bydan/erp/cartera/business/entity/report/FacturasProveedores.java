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
//import com.bydan.erp.cartera.util.FacturasProveedoresConstantesFunciones;
import com.bydan.erp.cartera.util.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.cartera.util.*;

import com.bydan.erp.cartera.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;




@SuppressWarnings("unused")
public class FacturasProveedores extends FacturasProveedoresAdditional implements Serializable ,Cloneable {//FacturasProveedoresAdditional,GeneralEntity
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
	
	private FacturasProveedores facturasproveedoresOriginal;
	
	private Map<String, Object> mapFacturasProveedores;
			
	public Map<String, Object> getMapFacturasProveedores() {
		return mapFacturasProveedores;
	}

	public void setMapFacturasProveedores(Map<String, Object> mapFacturasProveedores) {
		this.mapFacturasProveedores = mapFacturasProveedores;
	}
	
	public void inicializarMapFacturasProveedores() {
		this.mapFacturasProveedores = new HashMap<String,Object>();
	}
	
	public void setMapFacturasProveedoresValue(String sKey,Object oValue) {
		this.mapFacturasProveedores.put(sKey, oValue);
	}
	
	public Object getMapFacturasProveedoresValue(String sKey) {
		return this.mapFacturasProveedores.get(sKey);
	}
	
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_empresa;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_cliente;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Date fecha_emision_inicio;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Date fecha_emision_fin;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=50,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	//@Pattern(regex=FacturasProveedoresConstantesFunciones.SREGEXCODIGO_CLIENTE,message=FacturasProveedoresConstantesFunciones.SMENSAJEREGEXCODIGO_CLIENTE)
	private String codigo_cliente;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=150,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	//@Pattern(regex=FacturasProveedoresConstantesFunciones.SREGEXNOMBRE_CLIENTE,message=FacturasProveedoresConstantesFunciones.SMENSAJEREGEXNOMBRE_CLIENTE)
	private String nombre_cliente;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=50,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	//@Pattern(regex=FacturasProveedoresConstantesFunciones.SREGEXNUMERO_FACTURA,message=FacturasProveedoresConstantesFunciones.SMENSAJEREGEXNUMERO_FACTURA)
	private String numero_factura;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Date fecha_emision;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double total;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=50,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	//@Pattern(regex=FacturasProveedoresConstantesFunciones.SREGEXNUMERO_PRE_IMPRESO,message=FacturasProveedoresConstantesFunciones.SMENSAJEREGEXNUMERO_PRE_IMPRESO)
	private String numero_pre_impreso;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Date fecha;
			
	
	public Empresa empresa;
	public Cliente cliente;
	
	
	private String empresa_descripcion;
	private String cliente_descripcion;
	
	
		
	public FacturasProveedores () throws Exception {
		super();		
		
		this.id=0L;
		
		
		this.versionRow=new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());//new Date();
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		this.sType="NONE";
		
		this.facturasproveedoresOriginal=this;
		
 		this.id_empresa=-1L;
 		this.id_cliente=-1L;
 		this.fecha_emision_inicio=new Date();
 		this.fecha_emision_fin=new Date();
 		this.codigo_cliente="";
 		this.nombre_cliente="";
 		this.numero_factura="";
 		this.fecha_emision=new Date();
 		this.total=0.0;
 		this.numero_pre_impreso="";
 		this.fecha=new Date();
		
		
		this.empresa=null;
		this.cliente=null;
		
		
		this.empresa_descripcion="";
		this.cliente_descripcion="";
		
		
		
			
		
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
    //PARA REPORTES
	public FacturasProveedores (Long id,Date versionRow,String codigo_cliente,String nombre_cliente,String numero_factura,Date fecha_emision,Double total,String numero_pre_impreso,Date fecha) throws Exception {
		super();		
		
		this.id=id;
		this.versionRow=versionRow;
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.facturasproveedoresOriginal=this;
		
 		this.codigo_cliente=codigo_cliente;
 		this.nombre_cliente=nombre_cliente;
 		this.numero_factura=numero_factura;
 		this.fecha_emision=fecha_emision;
 		this.total=total;
 		this.numero_pre_impreso=numero_pre_impreso;
 		this.fecha=fecha;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	 //PARA REPORTES
	public FacturasProveedores (String codigo_cliente,String nombre_cliente,String numero_factura,Date fecha_emision,Double total,String numero_pre_impreso,Date fecha) throws Exception {
		super();		
		
		this.id=0L;
		this.versionRow=new Date();
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.facturasproveedoresOriginal=this;
		
 		this.codigo_cliente=codigo_cliente;
 		this.nombre_cliente=nombre_cliente;
 		this.numero_factura=numero_factura;
 		this.fecha_emision=fecha_emision;
 		this.total=total;
 		this.numero_pre_impreso=numero_pre_impreso;
 		this.fecha=fecha;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	
	public FacturasProveedores getFacturasProveedoresOriginal() {
		return this.facturasproveedoresOriginal;
	}
	
	public void setFacturasProveedoresOriginal(FacturasProveedores facturasproveedores) {
		try {
			this.facturasproveedoresOriginal=facturasproveedores;
		} catch(Exception e) {
			;
		}
	}
	
	
	protected FacturasProveedoresAdditional facturasproveedoresAdditional=null;
	
	public FacturasProveedoresAdditional getFacturasProveedoresAdditional() {
		return this.facturasproveedoresAdditional;
	}
	
	public void setFacturasProveedoresAdditional(FacturasProveedoresAdditional facturasproveedoresAdditional) {
		try {
			this.facturasproveedoresAdditional=facturasproveedoresAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
    
	
	public Long getid_empresa() {
		return this.id_empresa;
	}
    
	
	public Long getid_cliente() {
		return this.id_cliente;
	}
    
	
	public Date getfecha_emision_inicio() {
		return this.fecha_emision_inicio;
	}
    
	
	public Date getfecha_emision_fin() {
		return this.fecha_emision_fin;
	}
    
	
	public String getcodigo_cliente() {
		return this.codigo_cliente;
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
    
	
	public Double gettotal() {
		return this.total;
	}
    
	
	public String getnumero_pre_impreso() {
		return this.numero_pre_impreso;
	}
    
	
	public Date getfecha() {
		return this.fecha;
	}
	
    
	public void setid_empresa(Long newid_empresa)throws Exception
	{
		try {
			if(this.id_empresa!=newid_empresa) {
				if(newid_empresa==null) {
					//newid_empresa=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("FacturasProveedores:Valor nulo no permitido en columna id_empresa");
					}
				}

				this.id_empresa=newid_empresa;
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
						System.out.println("FacturasProveedores:Valor nulo no permitido en columna id_cliente");
					}
				}

				this.id_cliente=newid_cliente;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setfecha_emision_inicio(Date newfecha_emision_inicio)throws Exception
	{
		try {
			if(this.fecha_emision_inicio!=newfecha_emision_inicio) {
				if(newfecha_emision_inicio==null) {
					//newfecha_emision_inicio=new Date();
					if(Constantes.ISDEVELOPING) {
						System.out.println("FacturasProveedores:Valor nulo no permitido en columna fecha_emision_inicio");
					}
				}

				this.fecha_emision_inicio=newfecha_emision_inicio;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setfecha_emision_fin(Date newfecha_emision_fin)throws Exception
	{
		try {
			if(this.fecha_emision_fin!=newfecha_emision_fin) {
				if(newfecha_emision_fin==null) {
					//newfecha_emision_fin=new Date();
					if(Constantes.ISDEVELOPING) {
						System.out.println("FacturasProveedores:Valor nulo no permitido en columna fecha_emision_fin");
					}
				}

				this.fecha_emision_fin=newfecha_emision_fin;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setcodigo_cliente(String newcodigo_cliente)throws Exception
	{
		try {
			if(this.codigo_cliente!=newcodigo_cliente) {
				if(newcodigo_cliente==null) {
					//newcodigo_cliente="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("FacturasProveedores:Valor nulo no permitido en columna codigo_cliente");
					}
				}

				if(newcodigo_cliente!=null&&newcodigo_cliente.length()>50) {
					newcodigo_cliente=newcodigo_cliente.substring(0,48);
					System.out.println("FacturasProveedores:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=50 en columna codigo_cliente");
				}

				this.codigo_cliente=newcodigo_cliente;
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
						System.out.println("FacturasProveedores:Valor nulo no permitido en columna nombre_cliente");
					}
				}

				if(newnombre_cliente!=null&&newnombre_cliente.length()>150) {
					newnombre_cliente=newnombre_cliente.substring(0,148);
					System.out.println("FacturasProveedores:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=150 en columna nombre_cliente");
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
						System.out.println("FacturasProveedores:Valor nulo no permitido en columna numero_factura");
					}
				}

				if(newnumero_factura!=null&&newnumero_factura.length()>50) {
					newnumero_factura=newnumero_factura.substring(0,48);
					System.out.println("FacturasProveedores:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=50 en columna numero_factura");
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
						System.out.println("FacturasProveedores:Valor nulo no permitido en columna fecha_emision");
					}
				}

				this.fecha_emision=newfecha_emision;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void settotal(Double newtotal)throws Exception
	{
		try {
			if(this.total!=newtotal) {
				if(newtotal==null) {
					//newtotal=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("FacturasProveedores:Valor nulo no permitido en columna total");
					}
				}

				this.total=newtotal;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setnumero_pre_impreso(String newnumero_pre_impreso)throws Exception
	{
		try {
			if(this.numero_pre_impreso!=newnumero_pre_impreso) {
				if(newnumero_pre_impreso==null) {
					//newnumero_pre_impreso="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("FacturasProveedores:Valor nulo no permitido en columna numero_pre_impreso");
					}
				}

				if(newnumero_pre_impreso!=null&&newnumero_pre_impreso.length()>50) {
					newnumero_pre_impreso=newnumero_pre_impreso.substring(0,48);
					System.out.println("FacturasProveedores:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=50 en columna numero_pre_impreso");
				}

				this.numero_pre_impreso=newnumero_pre_impreso;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setfecha(Date newfecha)throws Exception
	{
		try {
			if(this.fecha!=newfecha) {
				if(newfecha==null) {
					//newfecha=new Date();
					if(Constantes.ISDEVELOPING) {
						System.out.println("FacturasProveedores:Valor nulo no permitido en columna fecha");
					}
				}

				this.fecha=newfecha;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	
	public Empresa getEmpresa() {
		return this.empresa;
	}

	public Cliente getCliente() {
		return this.cliente;
	}

	
	
	public String getempresa_descripcion() {
		return this.empresa_descripcion;
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


	public  void  setcliente_descripcion(String cliente_descripcion) {
		try {
			this.cliente_descripcion=cliente_descripcion;
		} catch(Exception e) {
			;
		}
	}


	
	
	
	
	
	/*PARA REPORTES*/
	String id_empresa_descripcion="";String id_cliente_descripcion="";
	
	
	public String getid_empresa_descripcion() {
		return id_empresa_descripcion;
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
	public void setid_cliente_descripcion(String newid_cliente_descripcion)throws Exception {
		try {
			this.id_cliente_descripcion=newid_cliente_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	
	public void inicializarVariablesParaReporte() {
		this.id_empresa_descripcion="";this.id_cliente_descripcion="";
	}
	
	
	
	
	
	
	/*PARA REPORTES FIN*/		
}

