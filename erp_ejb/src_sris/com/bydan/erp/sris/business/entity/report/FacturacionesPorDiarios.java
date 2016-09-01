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
//import com.bydan.erp.sris.util.FacturacionesPorDiariosConstantesFunciones;
import com.bydan.erp.sris.util.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.tesoreria.util.*;
import com.bydan.erp.contabilidad.util.*;

import com.bydan.erp.sris.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.tesoreria.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;




@SuppressWarnings("unused")
public class FacturacionesPorDiarios extends FacturacionesPorDiariosAdditional implements Serializable ,Cloneable {//FacturacionesPorDiariosAdditional,GeneralEntity
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
	
	private FacturacionesPorDiarios facturacionespordiariosOriginal;
	
	private Map<String, Object> mapFacturacionesPorDiarios;
			
	public Map<String, Object> getMapFacturacionesPorDiarios() {
		return mapFacturacionesPorDiarios;
	}

	public void setMapFacturacionesPorDiarios(Map<String, Object> mapFacturacionesPorDiarios) {
		this.mapFacturacionesPorDiarios = mapFacturacionesPorDiarios;
	}
	
	public void inicializarMapFacturacionesPorDiarios() {
		this.mapFacturacionesPorDiarios = new HashMap<String,Object>();
	}
	
	public void setMapFacturacionesPorDiariosValue(String sKey,Object oValue) {
		this.mapFacturacionesPorDiarios.put(sKey, oValue);
	}
	
	public Object getMapFacturacionesPorDiariosValue(String sKey) {
		return this.mapFacturacionesPorDiarios.get(sKey);
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
	private Date fecha_emision;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=150,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	//@Pattern(regex=FacturacionesPorDiariosConstantesFunciones.SREGEXNOMBRE_SUCURSAL,message=FacturacionesPorDiariosConstantesFunciones.SMENSAJEREGEXNOMBRE_SUCURSAL)
	private String nombre_sucursal;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=150,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	//@Pattern(regex=FacturacionesPorDiariosConstantesFunciones.SREGEXNOMBRE_COMPLETO_CLIENTE,message=FacturacionesPorDiariosConstantesFunciones.SMENSAJEREGEXNOMBRE_COMPLETO_CLIENTE)
	private String nombre_completo_cliente;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_tipo_transaccion_modulo;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=50,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	//@Pattern(regex=FacturacionesPorDiariosConstantesFunciones.SREGEXCODIGO_ASIENTO_CONTABLE,message=FacturacionesPorDiariosConstantesFunciones.SMENSAJEREGEXCODIGO_ASIENTO_CONTABLE)
	private String codigo_asiento_contable;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Date fecha_vence;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Date fecha_emision_detalle_cliente;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double monto_mone_local;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=50,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	//@Pattern(regex=FacturacionesPorDiariosConstantesFunciones.SREGEXNUMERO_FACTURA,message=FacturacionesPorDiariosConstantesFunciones.SMENSAJEREGEXNUMERO_FACTURA)
	private String numero_factura;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=15,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	//@Pattern(regex=FacturacionesPorDiariosConstantesFunciones.SREGEXRUC_CLIENTE,message=FacturacionesPorDiariosConstantesFunciones.SMENSAJEREGEXRUC_CLIENTE)
	private String ruc_cliente;
			
	
	public Empresa empresa;
	public Transaccion transaccion;
	public TipoTransaccionModulo tipotransaccionmodulo;
	
	
	private String empresa_descripcion;
	private String transaccion_descripcion;
	private String tipotransaccionmodulo_descripcion;
	
	
		
	public FacturacionesPorDiarios () throws Exception {
		super();		
		
		this.id=0L;
		
		
		this.versionRow=new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());//new Date();
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		this.sType="NONE";
		
		this.facturacionespordiariosOriginal=this;
		
 		this.id_empresa=-1L;
 		this.id_transaccion=-1L;
 		this.fecha_emision_desde=new Date();
 		this.fecha_emision_hasta=new Date();
 		this.fecha_emision=new Date();
 		this.nombre_sucursal="";
 		this.nombre_completo_cliente="";
 		this.id_tipo_transaccion_modulo=-1L;
 		this.codigo_asiento_contable="";
 		this.fecha_vence=new Date();
 		this.fecha_emision_detalle_cliente=new Date();
 		this.monto_mone_local=0.0;
 		this.numero_factura="";
 		this.ruc_cliente="";
		
		
		this.empresa=null;
		this.transaccion=null;
		this.tipotransaccionmodulo=null;
		
		
		this.empresa_descripcion="";
		this.transaccion_descripcion="";
		this.tipotransaccionmodulo_descripcion="";
		
		
		
			
		
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
    //PARA REPORTES
	public FacturacionesPorDiarios (Long id,Date versionRow,Date fecha_emision,String nombre_sucursal,String nombre_completo_cliente,Long id_tipo_transaccion_modulo,String codigo_asiento_contable,Date fecha_vence,Date fecha_emision_detalle_cliente,Double monto_mone_local,String numero_factura,String ruc_cliente) throws Exception {
		super();		
		
		this.id=id;
		this.versionRow=versionRow;
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.facturacionespordiariosOriginal=this;
		
 		this.fecha_emision=fecha_emision;
 		this.nombre_sucursal=nombre_sucursal;
 		this.nombre_completo_cliente=nombre_completo_cliente;
 		this.id_tipo_transaccion_modulo=id_tipo_transaccion_modulo;
 		this.codigo_asiento_contable=codigo_asiento_contable;
 		this.fecha_vence=fecha_vence;
 		this.fecha_emision_detalle_cliente=fecha_emision_detalle_cliente;
 		this.monto_mone_local=monto_mone_local;
 		this.numero_factura=numero_factura;
 		this.ruc_cliente=ruc_cliente;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	 //PARA REPORTES
	public FacturacionesPorDiarios (Date fecha_emision,String nombre_sucursal,String nombre_completo_cliente,Long id_tipo_transaccion_modulo,String codigo_asiento_contable,Date fecha_vence,Date fecha_emision_detalle_cliente,Double monto_mone_local,String numero_factura,String ruc_cliente) throws Exception {
		super();		
		
		this.id=0L;
		this.versionRow=new Date();
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.facturacionespordiariosOriginal=this;
		
 		this.fecha_emision=fecha_emision;
 		this.nombre_sucursal=nombre_sucursal;
 		this.nombre_completo_cliente=nombre_completo_cliente;
 		this.id_tipo_transaccion_modulo=id_tipo_transaccion_modulo;
 		this.codigo_asiento_contable=codigo_asiento_contable;
 		this.fecha_vence=fecha_vence;
 		this.fecha_emision_detalle_cliente=fecha_emision_detalle_cliente;
 		this.monto_mone_local=monto_mone_local;
 		this.numero_factura=numero_factura;
 		this.ruc_cliente=ruc_cliente;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	
	public FacturacionesPorDiarios getFacturacionesPorDiariosOriginal() {
		return this.facturacionespordiariosOriginal;
	}
	
	public void setFacturacionesPorDiariosOriginal(FacturacionesPorDiarios facturacionespordiarios) {
		try {
			this.facturacionespordiariosOriginal=facturacionespordiarios;
		} catch(Exception e) {
			;
		}
	}
	
	
	protected FacturacionesPorDiariosAdditional facturacionespordiariosAdditional=null;
	
	public FacturacionesPorDiariosAdditional getFacturacionesPorDiariosAdditional() {
		return this.facturacionespordiariosAdditional;
	}
	
	public void setFacturacionesPorDiariosAdditional(FacturacionesPorDiariosAdditional facturacionespordiariosAdditional) {
		try {
			this.facturacionespordiariosAdditional=facturacionespordiariosAdditional;
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
    
	
	public Date getfecha_emision() {
		return this.fecha_emision;
	}
    
	
	public String getnombre_sucursal() {
		return this.nombre_sucursal;
	}
    
	
	public String getnombre_completo_cliente() {
		return this.nombre_completo_cliente;
	}
    
	
	public Long getid_tipo_transaccion_modulo() {
		return this.id_tipo_transaccion_modulo;
	}
    
	
	public String getcodigo_asiento_contable() {
		return this.codigo_asiento_contable;
	}
    
	
	public Date getfecha_vence() {
		return this.fecha_vence;
	}
    
	
	public Date getfecha_emision_detalle_cliente() {
		return this.fecha_emision_detalle_cliente;
	}
    
	
	public Double getmonto_mone_local() {
		return this.monto_mone_local;
	}
    
	
	public String getnumero_factura() {
		return this.numero_factura;
	}
    
	
	public String getruc_cliente() {
		return this.ruc_cliente;
	}
	
    
	public void setid_empresa(Long newid_empresa)throws Exception
	{
		try {
			if(this.id_empresa!=newid_empresa) {
				if(newid_empresa==null) {
					//newid_empresa=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("FacturacionesPorDiarios:Valor nulo no permitido en columna id_empresa");
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
						System.out.println("FacturacionesPorDiarios:Valor nulo no permitido en columna id_transaccion");
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
						System.out.println("FacturacionesPorDiarios:Valor nulo no permitido en columna fecha_emision_desde");
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
						System.out.println("FacturacionesPorDiarios:Valor nulo no permitido en columna fecha_emision_hasta");
					}
				}

				this.fecha_emision_hasta=newfecha_emision_hasta;
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
						System.out.println("FacturacionesPorDiarios:Valor nulo no permitido en columna fecha_emision");
					}
				}

				this.fecha_emision=newfecha_emision;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setnombre_sucursal(String newnombre_sucursal)throws Exception
	{
		try {
			if(this.nombre_sucursal!=newnombre_sucursal) {
				if(newnombre_sucursal==null) {
					//newnombre_sucursal="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("FacturacionesPorDiarios:Valor nulo no permitido en columna nombre_sucursal");
					}
				}

				if(newnombre_sucursal!=null&&newnombre_sucursal.length()>150) {
					newnombre_sucursal=newnombre_sucursal.substring(0,148);
					System.out.println("FacturacionesPorDiarios:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=150 en columna nombre_sucursal");
				}

				this.nombre_sucursal=newnombre_sucursal;
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
						System.out.println("FacturacionesPorDiarios:Valor nulo no permitido en columna nombre_completo_cliente");
					}
				}

				if(newnombre_completo_cliente!=null&&newnombre_completo_cliente.length()>150) {
					newnombre_completo_cliente=newnombre_completo_cliente.substring(0,148);
					System.out.println("FacturacionesPorDiarios:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=150 en columna nombre_completo_cliente");
				}

				this.nombre_completo_cliente=newnombre_completo_cliente;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_tipo_transaccion_modulo(Long newid_tipo_transaccion_modulo)throws Exception
	{
		try {
			if(this.id_tipo_transaccion_modulo!=newid_tipo_transaccion_modulo) {
				if(newid_tipo_transaccion_modulo==null) {
					//newid_tipo_transaccion_modulo=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("FacturacionesPorDiarios:Valor nulo no permitido en columna id_tipo_transaccion_modulo");
					}
				}

				this.id_tipo_transaccion_modulo=newid_tipo_transaccion_modulo;
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
						System.out.println("FacturacionesPorDiarios:Valor nulo no permitido en columna codigo_asiento_contable");
					}
				}

				if(newcodigo_asiento_contable!=null&&newcodigo_asiento_contable.length()>50) {
					newcodigo_asiento_contable=newcodigo_asiento_contable.substring(0,48);
					System.out.println("FacturacionesPorDiarios:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=50 en columna codigo_asiento_contable");
				}

				this.codigo_asiento_contable=newcodigo_asiento_contable;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setfecha_vence(Date newfecha_vence)throws Exception
	{
		try {
			if(this.fecha_vence!=newfecha_vence) {
				if(newfecha_vence==null) {
					//newfecha_vence=new Date();
					if(Constantes.ISDEVELOPING) {
						System.out.println("FacturacionesPorDiarios:Valor nulo no permitido en columna fecha_vence");
					}
				}

				this.fecha_vence=newfecha_vence;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setfecha_emision_detalle_cliente(Date newfecha_emision_detalle_cliente)throws Exception
	{
		try {
			if(this.fecha_emision_detalle_cliente!=newfecha_emision_detalle_cliente) {
				if(newfecha_emision_detalle_cliente==null) {
					//newfecha_emision_detalle_cliente=new Date();
					if(Constantes.ISDEVELOPING) {
						System.out.println("FacturacionesPorDiarios:Valor nulo no permitido en columna fecha_emision_detalle_cliente");
					}
				}

				this.fecha_emision_detalle_cliente=newfecha_emision_detalle_cliente;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setmonto_mone_local(Double newmonto_mone_local)throws Exception
	{
		try {
			if(this.monto_mone_local!=newmonto_mone_local) {
				if(newmonto_mone_local==null) {
					//newmonto_mone_local=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("FacturacionesPorDiarios:Valor nulo no permitido en columna monto_mone_local");
					}
				}

				this.monto_mone_local=newmonto_mone_local;
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
						System.out.println("FacturacionesPorDiarios:Valor nulo no permitido en columna numero_factura");
					}
				}

				if(newnumero_factura!=null&&newnumero_factura.length()>50) {
					newnumero_factura=newnumero_factura.substring(0,48);
					System.out.println("FacturacionesPorDiarios:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=50 en columna numero_factura");
				}

				this.numero_factura=newnumero_factura;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setruc_cliente(String newruc_cliente)throws Exception
	{
		try {
			if(this.ruc_cliente!=newruc_cliente) {
				if(newruc_cliente==null) {
					//newruc_cliente="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("FacturacionesPorDiarios:Valor nulo no permitido en columna ruc_cliente");
					}
				}

				if(newruc_cliente!=null&&newruc_cliente.length()>15) {
					newruc_cliente=newruc_cliente.substring(0,13);
					System.out.println("FacturacionesPorDiarios:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=15 en columna ruc_cliente");
				}

				this.ruc_cliente=newruc_cliente;
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

	public TipoTransaccionModulo getTipoTransaccionModulo() {
		return this.tipotransaccionmodulo;
	}

	
	
	public String getempresa_descripcion() {
		return this.empresa_descripcion;
	}

	public String gettransaccion_descripcion() {
		return this.transaccion_descripcion;
	}

	public String gettipotransaccionmodulo_descripcion() {
		return this.tipotransaccionmodulo_descripcion;
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


	public  void  setTipoTransaccionModulo(TipoTransaccionModulo tipotransaccionmodulo) {
		try {
			this.tipotransaccionmodulo=tipotransaccionmodulo;
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


	public  void  settipotransaccionmodulo_descripcion(String tipotransaccionmodulo_descripcion) {
		try {
			this.tipotransaccionmodulo_descripcion=tipotransaccionmodulo_descripcion;
		} catch(Exception e) {
			;
		}
	}


	
	
	
	
	
	/*PARA REPORTES*/
	String id_empresa_descripcion="";String id_transaccion_descripcion="";String id_tipo_transaccion_modulo_descripcion="";
	
	
	public String getid_empresa_descripcion() {
		return id_empresa_descripcion;
	}
	public String getid_transaccion_descripcion() {
		return id_transaccion_descripcion;
	}
	public String getid_tipo_transaccion_modulo_descripcion() {
		return id_tipo_transaccion_modulo_descripcion;
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
	public void setid_tipo_transaccion_modulo_descripcion(String newid_tipo_transaccion_modulo_descripcion)throws Exception {
		try {
			this.id_tipo_transaccion_modulo_descripcion=newid_tipo_transaccion_modulo_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	
	public void inicializarVariablesParaReporte() {
		this.id_empresa_descripcion="";this.id_transaccion_descripcion="";this.id_tipo_transaccion_modulo_descripcion="";
	}
	
	
	
	
	
	
	/*PARA REPORTES FIN*/		
}

