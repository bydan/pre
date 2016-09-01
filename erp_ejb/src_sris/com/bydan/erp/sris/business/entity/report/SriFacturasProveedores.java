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
package com.bydan.erp.sris.business.entity.report;

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
//import com.bydan.erp.sris.util.SriFacturasProveedoresConstantesFunciones;
import com.bydan.erp.sris.util.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.tesoreria.util.*;

import com.bydan.erp.sris.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.tesoreria.business.entity.*;




@SuppressWarnings("unused")
public class SriFacturasProveedores extends SriFacturasProveedoresAdditional implements Serializable ,Cloneable {//SriFacturasProveedoresAdditional,GeneralEntity
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
	
	private SriFacturasProveedores srifacturasproveedoresOriginal;
	
	private Map<String, Object> mapSriFacturasProveedores;
			
	public Map<String, Object> getMapSriFacturasProveedores() {
		return mapSriFacturasProveedores;
	}

	public void setMapSriFacturasProveedores(Map<String, Object> mapSriFacturasProveedores) {
		this.mapSriFacturasProveedores = mapSriFacturasProveedores;
	}
	
	public void inicializarMapSriFacturasProveedores() {
		this.mapSriFacturasProveedores = new HashMap<String,Object>();
	}
	
	public void setMapSriFacturasProveedoresValue(String sKey,Object oValue) {
		this.mapSriFacturasProveedores.put(sKey, oValue);
	}
	
	public Object getMapSriFacturasProveedoresValue(String sKey) {
		return this.mapSriFacturasProveedores.get(sKey);
	}
	
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_empresa;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_transaccion;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Date fecha_emision_desde;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Date fecha_emision_hasta;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=25,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	//@Pattern(regex=SriFacturasProveedoresConstantesFunciones.SREGEXIDENTIFICACION,message=SriFacturasProveedoresConstantesFunciones.SMENSAJEREGEXIDENTIFICACION)
	private String identificacion;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=100,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	//@Pattern(regex=SriFacturasProveedoresConstantesFunciones.SREGEXNOMBRE,message=SriFacturasProveedoresConstantesFunciones.SMENSAJEREGEXNOMBRE)
	private String nombre;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=15,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	//@Pattern(regex=SriFacturasProveedoresConstantesFunciones.SREGEXRUC,message=SriFacturasProveedoresConstantesFunciones.SMENSAJEREGEXRUC)
	private String ruc;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=150,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	//@Pattern(regex=SriFacturasProveedoresConstantesFunciones.SREGEXNOMBRE_MODULO,message=SriFacturasProveedoresConstantesFunciones.SMENSAJEREGEXNOMBRE_MODULO)
	private String nombre_modulo;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=150,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	//@Pattern(regex=SriFacturasProveedoresConstantesFunciones.SREGEXNOMBRE_COMPLETO_CLIENTE,message=SriFacturasProveedoresConstantesFunciones.SMENSAJEREGEXNOMBRE_COMPLETO_CLIENTE)
	private String nombre_completo_cliente;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=150,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	//@Pattern(regex=SriFacturasProveedoresConstantesFunciones.SREGEXNOMBRE_TRANSACCION,message=SriFacturasProveedoresConstantesFunciones.SMENSAJEREGEXNOMBRE_TRANSACCION)
	private String nombre_transaccion;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=50,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	//@Pattern(regex=SriFacturasProveedoresConstantesFunciones.SREGEXCODIGO_ASIENTO_CONTABLE,message=SriFacturasProveedoresConstantesFunciones.SMENSAJEREGEXCODIGO_ASIENTO_CONTABLE)
	private String codigo_asiento_contable;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Date fecha_emision;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=50,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	//@Pattern(regex=SriFacturasProveedoresConstantesFunciones.SREGEXNUMERO_FACTURA,message=SriFacturasProveedoresConstantesFunciones.SMENSAJEREGEXNUMERO_FACTURA)
	private String numero_factura;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double credito_mone_local;
			
	
	public Empresa empresa;
	public Transaccion transaccion;
	
	
	private String empresa_descripcion;
	private String transaccion_descripcion;
	
	
		
	public SriFacturasProveedores () throws Exception {
		super();		
		
		this.id=0L;
		
		
		this.versionRow=new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());//new Date();
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		this.sType="NONE";
		
		this.srifacturasproveedoresOriginal=this;
		
 		this.id_empresa=-1L;
 		this.id_transaccion=-1L;
 		this.fecha_emision_desde=new Date();
 		this.fecha_emision_hasta=new Date();
 		this.identificacion="";
 		this.nombre="";
 		this.ruc="";
 		this.nombre_modulo="";
 		this.nombre_completo_cliente="";
 		this.nombre_transaccion="";
 		this.codigo_asiento_contable="";
 		this.fecha_emision=new Date();
 		this.numero_factura="";
 		this.credito_mone_local=0.0;
		
		
		this.empresa=null;
		this.transaccion=null;
		
		
		this.empresa_descripcion="";
		this.transaccion_descripcion="";
		
		
		
			
		
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
    //PARA REPORTES
	public SriFacturasProveedores (Long id,Date versionRow,String identificacion,String nombre,String ruc,String nombre_modulo,String nombre_completo_cliente,String nombre_transaccion,String codigo_asiento_contable,Date fecha_emision,String numero_factura,Double credito_mone_local) throws Exception {
		super();		
		
		this.id=id;
		this.versionRow=versionRow;
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.srifacturasproveedoresOriginal=this;
		
 		this.identificacion=identificacion;
 		this.nombre=nombre;
 		this.ruc=ruc;
 		this.nombre_modulo=nombre_modulo;
 		this.nombre_completo_cliente=nombre_completo_cliente;
 		this.nombre_transaccion=nombre_transaccion;
 		this.codigo_asiento_contable=codigo_asiento_contable;
 		this.fecha_emision=fecha_emision;
 		this.numero_factura=numero_factura;
 		this.credito_mone_local=credito_mone_local;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	 //PARA REPORTES
	public SriFacturasProveedores (String identificacion,String nombre,String ruc,String nombre_modulo,String nombre_completo_cliente,String nombre_transaccion,String codigo_asiento_contable,Date fecha_emision,String numero_factura,Double credito_mone_local) throws Exception {
		super();		
		
		this.id=0L;
		this.versionRow=new Date();
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.srifacturasproveedoresOriginal=this;
		
 		this.identificacion=identificacion;
 		this.nombre=nombre;
 		this.ruc=ruc;
 		this.nombre_modulo=nombre_modulo;
 		this.nombre_completo_cliente=nombre_completo_cliente;
 		this.nombre_transaccion=nombre_transaccion;
 		this.codigo_asiento_contable=codigo_asiento_contable;
 		this.fecha_emision=fecha_emision;
 		this.numero_factura=numero_factura;
 		this.credito_mone_local=credito_mone_local;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	
	public SriFacturasProveedores getSriFacturasProveedoresOriginal() {
		return this.srifacturasproveedoresOriginal;
	}
	
	public void setSriFacturasProveedoresOriginal(SriFacturasProveedores srifacturasproveedores) {
		try {
			this.srifacturasproveedoresOriginal=srifacturasproveedores;
		} catch(Exception e) {
			;
		}
	}
	
	
	protected SriFacturasProveedoresAdditional srifacturasproveedoresAdditional=null;
	
	public SriFacturasProveedoresAdditional getSriFacturasProveedoresAdditional() {
		return this.srifacturasproveedoresAdditional;
	}
	
	public void setSriFacturasProveedoresAdditional(SriFacturasProveedoresAdditional srifacturasproveedoresAdditional) {
		try {
			this.srifacturasproveedoresAdditional=srifacturasproveedoresAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
    
	
	public Long getid_empresa() {
		return this.id_empresa;
	}
    
	
	public Long getid_transaccion() {
		return this.id_transaccion;
	}
    
	
	public Date getfecha_emision_desde() {
		return this.fecha_emision_desde;
	}
    
	
	public Date getfecha_emision_hasta() {
		return this.fecha_emision_hasta;
	}
    
	
	public String getidentificacion() {
		return this.identificacion;
	}
    
	
	public String getnombre() {
		return this.nombre;
	}
    
	
	public String getruc() {
		return this.ruc;
	}
    
	
	public String getnombre_modulo() {
		return this.nombre_modulo;
	}
    
	
	public String getnombre_completo_cliente() {
		return this.nombre_completo_cliente;
	}
    
	
	public String getnombre_transaccion() {
		return this.nombre_transaccion;
	}
    
	
	public String getcodigo_asiento_contable() {
		return this.codigo_asiento_contable;
	}
    
	
	public Date getfecha_emision() {
		return this.fecha_emision;
	}
    
	
	public String getnumero_factura() {
		return this.numero_factura;
	}
    
	
	public Double getcredito_mone_local() {
		return this.credito_mone_local;
	}
	
    
	public void setid_empresa(Long newid_empresa)throws Exception
	{
		try {
			if(this.id_empresa!=newid_empresa) {
				if(newid_empresa==null) {
					//newid_empresa=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("SriFacturasProveedores:Valor nulo no permitido en columna id_empresa");
					}
				}

				this.id_empresa=newid_empresa;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_transaccion(Long newid_transaccion)throws Exception
	{
		try {
			if(this.id_transaccion!=newid_transaccion) {
				if(newid_transaccion==null) {
					//newid_transaccion=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("SriFacturasProveedores:Valor nulo no permitido en columna id_transaccion");
					}
				}

				this.id_transaccion=newid_transaccion;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setfecha_emision_desde(Date newfecha_emision_desde)throws Exception
	{
		try {
			if(this.fecha_emision_desde!=newfecha_emision_desde) {
				if(newfecha_emision_desde==null) {
					//newfecha_emision_desde=new Date();
					if(Constantes.ISDEVELOPING) {
						System.out.println("SriFacturasProveedores:Valor nulo no permitido en columna fecha_emision_desde");
					}
				}

				this.fecha_emision_desde=newfecha_emision_desde;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setfecha_emision_hasta(Date newfecha_emision_hasta)throws Exception
	{
		try {
			if(this.fecha_emision_hasta!=newfecha_emision_hasta) {
				if(newfecha_emision_hasta==null) {
					//newfecha_emision_hasta=new Date();
					if(Constantes.ISDEVELOPING) {
						System.out.println("SriFacturasProveedores:Valor nulo no permitido en columna fecha_emision_hasta");
					}
				}

				this.fecha_emision_hasta=newfecha_emision_hasta;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setidentificacion(String newidentificacion)throws Exception
	{
		try {
			if(this.identificacion!=newidentificacion) {
				if(newidentificacion==null) {
					//newidentificacion="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("SriFacturasProveedores:Valor nulo no permitido en columna identificacion");
					}
				}

				if(newidentificacion!=null&&newidentificacion.length()>25) {
					newidentificacion=newidentificacion.substring(0,23);
					System.out.println("SriFacturasProveedores:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=25 en columna identificacion");
				}

				this.identificacion=newidentificacion;
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
						System.out.println("SriFacturasProveedores:Valor nulo no permitido en columna nombre");
					}
				}

				if(newnombre!=null&&newnombre.length()>100) {
					newnombre=newnombre.substring(0,98);
					System.out.println("SriFacturasProveedores:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=100 en columna nombre");
				}

				this.nombre=newnombre;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setruc(String newruc)throws Exception
	{
		try {
			if(this.ruc!=newruc) {
				if(newruc==null) {
					//newruc="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("SriFacturasProveedores:Valor nulo no permitido en columna ruc");
					}
				}

				if(newruc!=null&&newruc.length()>15) {
					newruc=newruc.substring(0,13);
					System.out.println("SriFacturasProveedores:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=15 en columna ruc");
				}

				this.ruc=newruc;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setnombre_modulo(String newnombre_modulo)throws Exception
	{
		try {
			if(this.nombre_modulo!=newnombre_modulo) {
				if(newnombre_modulo==null) {
					//newnombre_modulo="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("SriFacturasProveedores:Valor nulo no permitido en columna nombre_modulo");
					}
				}

				if(newnombre_modulo!=null&&newnombre_modulo.length()>150) {
					newnombre_modulo=newnombre_modulo.substring(0,148);
					System.out.println("SriFacturasProveedores:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=150 en columna nombre_modulo");
				}

				this.nombre_modulo=newnombre_modulo;
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
						System.out.println("SriFacturasProveedores:Valor nulo no permitido en columna nombre_completo_cliente");
					}
				}

				if(newnombre_completo_cliente!=null&&newnombre_completo_cliente.length()>150) {
					newnombre_completo_cliente=newnombre_completo_cliente.substring(0,148);
					System.out.println("SriFacturasProveedores:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=150 en columna nombre_completo_cliente");
				}

				this.nombre_completo_cliente=newnombre_completo_cliente;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setnombre_transaccion(String newnombre_transaccion)throws Exception
	{
		try {
			if(this.nombre_transaccion!=newnombre_transaccion) {
				if(newnombre_transaccion==null) {
					//newnombre_transaccion="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("SriFacturasProveedores:Valor nulo no permitido en columna nombre_transaccion");
					}
				}

				if(newnombre_transaccion!=null&&newnombre_transaccion.length()>150) {
					newnombre_transaccion=newnombre_transaccion.substring(0,148);
					System.out.println("SriFacturasProveedores:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=150 en columna nombre_transaccion");
				}

				this.nombre_transaccion=newnombre_transaccion;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setcodigo_asiento_contable(String newcodigo_asiento_contable)throws Exception
	{
		try {
			if(this.codigo_asiento_contable!=newcodigo_asiento_contable) {
				if(newcodigo_asiento_contable==null) {
					//newcodigo_asiento_contable="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("SriFacturasProveedores:Valor nulo no permitido en columna codigo_asiento_contable");
					}
				}

				if(newcodigo_asiento_contable!=null&&newcodigo_asiento_contable.length()>50) {
					newcodigo_asiento_contable=newcodigo_asiento_contable.substring(0,48);
					System.out.println("SriFacturasProveedores:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=50 en columna codigo_asiento_contable");
				}

				this.codigo_asiento_contable=newcodigo_asiento_contable;
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
						System.out.println("SriFacturasProveedores:Valor nulo no permitido en columna fecha_emision");
					}
				}

				this.fecha_emision=newfecha_emision;
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
						System.out.println("SriFacturasProveedores:Valor nulo no permitido en columna numero_factura");
					}
				}

				if(newnumero_factura!=null&&newnumero_factura.length()>50) {
					newnumero_factura=newnumero_factura.substring(0,48);
					System.out.println("SriFacturasProveedores:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=50 en columna numero_factura");
				}

				this.numero_factura=newnumero_factura;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setcredito_mone_local(Double newcredito_mone_local)throws Exception
	{
		try {
			if(this.credito_mone_local!=newcredito_mone_local) {
				if(newcredito_mone_local==null) {
					//newcredito_mone_local=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("SriFacturasProveedores:Valor nulo no permitido en columna credito_mone_local");
					}
				}

				this.credito_mone_local=newcredito_mone_local;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	
	public Empresa getEmpresa() {
		return this.empresa;
	}

	public Transaccion getTransaccion() {
		return this.transaccion;
	}

	
	
	public String getempresa_descripcion() {
		return this.empresa_descripcion;
	}

	public String gettransaccion_descripcion() {
		return this.transaccion_descripcion;
	}

	
	
	public  void  setEmpresa(Empresa empresa) {
		try {
			this.empresa=empresa;
		} catch(Exception e) {
			;
		}
	}


	public  void  setTransaccion(Transaccion transaccion) {
		try {
			this.transaccion=transaccion;
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


	public  void  settransaccion_descripcion(String transaccion_descripcion) {
		try {
			this.transaccion_descripcion=transaccion_descripcion;
		} catch(Exception e) {
			;
		}
	}


	
	
	
	
	
	/*PARA REPORTES*/
	String id_empresa_descripcion="";String id_transaccion_descripcion="";
	
	
	public String getid_empresa_descripcion() {
		return id_empresa_descripcion;
	}
	public String getid_transaccion_descripcion() {
		return id_transaccion_descripcion;
	}
	
	
	public void setid_empresa_descripcion(String newid_empresa_descripcion)throws Exception {
		try {
			this.id_empresa_descripcion=newid_empresa_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_transaccion_descripcion(String newid_transaccion_descripcion)throws Exception {
		try {
			this.id_transaccion_descripcion=newid_transaccion_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	
	public void inicializarVariablesParaReporte() {
		this.id_empresa_descripcion="";this.id_transaccion_descripcion="";
	}
	
	
	
	
	
	
	/*PARA REPORTES FIN*/		
}

