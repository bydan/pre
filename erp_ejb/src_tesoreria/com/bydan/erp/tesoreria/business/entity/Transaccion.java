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
package com.bydan.erp.tesoreria.business.entity;

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
//import com.bydan.erp.tesoreria.util.TransaccionConstantesFunciones;
import com.bydan.erp.tesoreria.util.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.cartera.util.*;
import com.bydan.erp.contabilidad.util.*;
import com.bydan.erp.tesoreria.util.*;
import com.bydan.erp.facturacion.util.*;
import com.bydan.erp.produccion.util.*;
import com.bydan.erp.inventario.util.*;
import com.bydan.erp.nomina.util.*;
import com.bydan.erp.importaciones.util.*;
import com.bydan.erp.puntoventa.util.*;



import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.tesoreria.business.entity.*;
import com.bydan.erp.facturacion.business.entity.*;
import com.bydan.erp.produccion.business.entity.*;
import com.bydan.erp.inventario.business.entity.*;
import com.bydan.erp.nomina.business.entity.*;
import com.bydan.erp.importaciones.business.entity.*;
import com.bydan.erp.puntoventa.business.entity.*;




@SuppressWarnings("unused")
public class Transaccion extends TransaccionAdditional implements Serializable ,Cloneable {//TransaccionAdditional,GeneralEntity
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
	
	private Transaccion transaccionOriginal;
	
	private Map<String, Object> mapTransaccion;
			
	public Map<String, Object> getMapTransaccion() {
		return mapTransaccion;
	}

	public void setMapTransaccion(Map<String, Object> mapTransaccion) {
		this.mapTransaccion = mapTransaccion;
	}
	
	public void inicializarMapTransaccion() {
		this.mapTransaccion = new HashMap<String,Object>();
	}
	
	public void setMapTransaccionValue(String sKey,Object oValue) {
		this.mapTransaccion.put(sKey, oValue);
	}
	
	public Object getMapTransaccionValue(String sKey) {
		return this.mapTransaccion.get(sKey);
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
	@Length(min=0,max=50,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=TransaccionConstantesFunciones.SREGEXCODIGO,message=TransaccionConstantesFunciones.SMENSAJEREGEXCODIGO)
	private String codigo;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=150,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=TransaccionConstantesFunciones.SREGEXNOMBRE,message=TransaccionConstantesFunciones.SMENSAJEREGEXNOMBRE)
	private String nombre;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_modulo;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_tipo_transa;
	
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_tipo_comprobante;
	
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_tipo_transaccion_modulo;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_tipo_retencion;
	
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_cuenta_contable;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=200,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@Pattern(regex=TransaccionConstantesFunciones.SREGEXDESCRIPCION,message=TransaccionConstantesFunciones.SMENSAJEREGEXDESCRIPCION)
	private String descripcion;
			
	
	public Empresa empresa;
	public Sucursal sucursal;
	public Modulo modulo;
	public TipoTransa tipotransa;
	public TipoComprobante tipocomprobante;
	public TipoTransaccionModulo tipotransaccionmodulo;
	public TipoRetencion tiporetencion;
	public CuentaContable cuentacontable;
	
	
	private String empresa_descripcion;
	private String sucursal_descripcion;
	private String modulo_descripcion;
	private String tipotransa_descripcion;
	private String tipocomprobante_descripcion;
	private String tipotransaccionmodulo_descripcion;
	private String tiporetencion_descripcion;
	private String cuentacontable_descripcion;
	
	
		
	public Transaccion () throws Exception {
		super();		
		
		this.id=0L;
		
		
		this.versionRow=new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());//new Date();
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		this.sType="NONE";
		
		this.transaccionOriginal=this;
		
 		this.id_empresa=-1L;
 		this.id_sucursal=-1L;
 		this.codigo="";
 		this.nombre="";
 		this.id_modulo=-1L;
 		this.id_tipo_transa=-1L;
 		this.id_tipo_comprobante=null;
 		this.id_tipo_transaccion_modulo=null;
 		this.id_tipo_retencion=-1L;
 		this.id_cuenta_contable=null;
 		this.descripcion="";
		
		
		this.empresa=null;
		this.sucursal=null;
		this.modulo=null;
		this.tipotransa=null;
		this.tipocomprobante=null;
		this.tipotransaccionmodulo=null;
		this.tiporetencion=null;
		this.cuentacontable=null;
		
		
		this.empresa_descripcion="";
		this.sucursal_descripcion="";
		this.modulo_descripcion="";
		this.tipotransa_descripcion="";
		this.tipocomprobante_descripcion="";
		this.tipotransaccionmodulo_descripcion="";
		this.tiporetencion_descripcion="";
		this.cuentacontable_descripcion="";
		
		
		
			
		
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
    //PARA REPORTES
	public Transaccion (Long id,Date versionRow,Long id_empresa,Long id_sucursal,String codigo,String nombre,Long id_modulo,Long id_tipo_transa,Long id_tipo_comprobante,Long id_tipo_transaccion_modulo,Long id_tipo_retencion,Long id_cuenta_contable,String descripcion) throws Exception {
		super();		
		
		this.id=id;
		this.versionRow=versionRow;
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.transaccionOriginal=this;
		
 		this.id_empresa=id_empresa;
 		this.id_sucursal=id_sucursal;
 		this.codigo=codigo;
 		this.nombre=nombre;
 		this.id_modulo=id_modulo;
 		this.id_tipo_transa=id_tipo_transa;
 		this.id_tipo_comprobante=id_tipo_comprobante;
 		this.id_tipo_transaccion_modulo=id_tipo_transaccion_modulo;
 		this.id_tipo_retencion=id_tipo_retencion;
 		this.id_cuenta_contable=id_cuenta_contable;
 		this.descripcion=descripcion;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	 //PARA REPORTES
	public Transaccion (Long id_empresa,Long id_sucursal,String codigo,String nombre,Long id_modulo,Long id_tipo_transa,Long id_tipo_comprobante,Long id_tipo_transaccion_modulo,Long id_tipo_retencion,Long id_cuenta_contable,String descripcion) throws Exception {
		super();		
		
		this.id=0L;
		this.versionRow=new Date();
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.transaccionOriginal=this;
		
 		this.id_empresa=id_empresa;
 		this.id_sucursal=id_sucursal;
 		this.codigo=codigo;
 		this.nombre=nombre;
 		this.id_modulo=id_modulo;
 		this.id_tipo_transa=id_tipo_transa;
 		this.id_tipo_comprobante=id_tipo_comprobante;
 		this.id_tipo_transaccion_modulo=id_tipo_transaccion_modulo;
 		this.id_tipo_retencion=id_tipo_retencion;
 		this.id_cuenta_contable=id_cuenta_contable;
 		this.descripcion=descripcion;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	public boolean equals(Object object) {
		boolean equal=false;
		Transaccion transaccionLocal=null;
		
		if(object!=null) {
			transaccionLocal=(Transaccion)object;
			
			if(transaccionLocal!=null) {
				if(this.getId()!=null && transaccionLocal.getId()!=null) {
					if(this.getId().equals(transaccionLocal.getId())) {
						equal=true;
					}
				}
			}
		}
		
		return equal;
	}
	
	public String toString() {
		String sDetalle="";
		
		if(!TransaccionConstantesFunciones.CON_DESCRIPCION_DETALLADO) {
        	sDetalle=TransaccionConstantesFunciones.getTransaccionDescripcion(this);
		} else {
			sDetalle=TransaccionConstantesFunciones.getTransaccionDescripcionDetallado(this);
		}
		
		return sDetalle;
    }
	
	public Transaccion getTransaccionOriginal() {
		return this.transaccionOriginal;
	}
	
	public void setTransaccionOriginal(Transaccion transaccion) {
		try {
			this.transaccionOriginal=transaccion;
		} catch(Exception e) {
			;
		}
	}
	
	
	protected TransaccionAdditional transaccionAdditional=null;
	
	public TransaccionAdditional getTransaccionAdditional() {
		return this.transaccionAdditional;
	}
	
	public void setTransaccionAdditional(TransaccionAdditional transaccionAdditional) {
		try {
			this.transaccionAdditional=transaccionAdditional;
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
    
	
	public String getcodigo() {
		return this.codigo;
	}
    
	
	public String getnombre() {
		return this.nombre;
	}
    
	
	public Long getid_modulo() {
		return this.id_modulo;
	}
    
	
	public Long getid_tipo_transa() {
		return this.id_tipo_transa;
	}
    
	
	public Long getid_tipo_comprobante() {
		return this.id_tipo_comprobante;
	}
    
	
	public Long getid_tipo_transaccion_modulo() {
		return this.id_tipo_transaccion_modulo;
	}
    
	
	public Long getid_tipo_retencion() {
		return this.id_tipo_retencion;
	}
    
	
	public Long getid_cuenta_contable() {
		return this.id_cuenta_contable;
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
						System.out.println("Transaccion:Valor nulo no permitido en columna id_empresa");
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
						System.out.println("Transaccion:Valor nulo no permitido en columna id_sucursal");
					}
				}

				this.id_sucursal=newid_sucursal;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setcodigo(String newcodigo)throws Exception
	{
		try {
			if(this.codigo!=newcodigo) {
				if(newcodigo==null) {
					//newcodigo="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("Transaccion:Valor nulo no permitido en columna codigo");
					}
				}

				if(newcodigo!=null&&newcodigo.length()>50) {
					newcodigo=newcodigo.substring(0,48);
					System.out.println("Transaccion:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=50 en columna codigo");
				}

				this.codigo=newcodigo;
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
						System.out.println("Transaccion:Valor nulo no permitido en columna nombre");
					}
				}

				if(newnombre!=null&&newnombre.length()>150) {
					newnombre=newnombre.substring(0,148);
					System.out.println("Transaccion:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=150 en columna nombre");
				}

				this.nombre=newnombre;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_modulo(Long newid_modulo)throws Exception
	{
		try {
			if(this.id_modulo!=newid_modulo) {
				if(newid_modulo==null) {
					//newid_modulo=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("Transaccion:Valor nulo no permitido en columna id_modulo");
					}
				}

				this.id_modulo=newid_modulo;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_tipo_transa(Long newid_tipo_transa)throws Exception
	{
		try {
			if(this.id_tipo_transa!=newid_tipo_transa) {
				if(newid_tipo_transa==null) {
					//newid_tipo_transa=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("Transaccion:Valor nulo no permitido en columna id_tipo_transa");
					}
				}

				this.id_tipo_transa=newid_tipo_transa;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_tipo_comprobante(Long newid_tipo_comprobante) {
		if(this.id_tipo_comprobante==null&&newid_tipo_comprobante!=null) {
			this.id_tipo_comprobante=newid_tipo_comprobante;
				this.setIsChanged(true);
		}

		if(this.id_tipo_comprobante!=null&&!this.id_tipo_comprobante.equals(newid_tipo_comprobante)) {

			this.id_tipo_comprobante=newid_tipo_comprobante;
				this.setIsChanged(true);
		}
	}
    
	public void setid_tipo_transaccion_modulo(Long newid_tipo_transaccion_modulo) {
		if(this.id_tipo_transaccion_modulo==null&&newid_tipo_transaccion_modulo!=null) {
			this.id_tipo_transaccion_modulo=newid_tipo_transaccion_modulo;
				this.setIsChanged(true);
		}

		if(this.id_tipo_transaccion_modulo!=null&&!this.id_tipo_transaccion_modulo.equals(newid_tipo_transaccion_modulo)) {

			this.id_tipo_transaccion_modulo=newid_tipo_transaccion_modulo;
				this.setIsChanged(true);
		}
	}
    
	public void setid_tipo_retencion(Long newid_tipo_retencion)throws Exception
	{
		try {
			if(this.id_tipo_retencion!=newid_tipo_retencion) {
				if(newid_tipo_retencion==null) {
					//newid_tipo_retencion=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("Transaccion:Valor nulo no permitido en columna id_tipo_retencion");
					}
				}

				this.id_tipo_retencion=newid_tipo_retencion;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_cuenta_contable(Long newid_cuenta_contable) {
		if(this.id_cuenta_contable==null&&newid_cuenta_contable!=null) {
			this.id_cuenta_contable=newid_cuenta_contable;
				this.setIsChanged(true);
		}

		if(this.id_cuenta_contable!=null&&!this.id_cuenta_contable.equals(newid_cuenta_contable)) {

			this.id_cuenta_contable=newid_cuenta_contable;
				this.setIsChanged(true);
		}
	}
    
	public void setdescripcion(String newdescripcion)throws Exception
	{
		try {
			if(this.descripcion!=newdescripcion) {
				if(newdescripcion==null) {
					//newdescripcion="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("Transaccion:Valor nulo no permitido en columna descripcion");
					}
				}

				if(newdescripcion!=null&&newdescripcion.length()>200) {
					newdescripcion=newdescripcion.substring(0,198);
					System.out.println("Transaccion:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=200 en columna descripcion");
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

	public Sucursal getSucursal() {
		return this.sucursal;
	}

	public Modulo getModulo() {
		return this.modulo;
	}

	public TipoTransa getTipoTransa() {
		return this.tipotransa;
	}

	public TipoComprobante getTipoComprobante() {
		return this.tipocomprobante;
	}

	public TipoTransaccionModulo getTipoTransaccionModulo() {
		return this.tipotransaccionmodulo;
	}

	public TipoRetencion getTipoRetencion() {
		return this.tiporetencion;
	}

	public CuentaContable getCuentaContable() {
		return this.cuentacontable;
	}

	
	
	public String getempresa_descripcion() {
		return this.empresa_descripcion;
	}

	public String getsucursal_descripcion() {
		return this.sucursal_descripcion;
	}

	public String getmodulo_descripcion() {
		return this.modulo_descripcion;
	}

	public String gettipotransa_descripcion() {
		return this.tipotransa_descripcion;
	}

	public String gettipocomprobante_descripcion() {
		return this.tipocomprobante_descripcion;
	}

	public String gettipotransaccionmodulo_descripcion() {
		return this.tipotransaccionmodulo_descripcion;
	}

	public String gettiporetencion_descripcion() {
		return this.tiporetencion_descripcion;
	}

	public String getcuentacontable_descripcion() {
		return this.cuentacontable_descripcion;
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


	public  void  setModulo(Modulo modulo) {
		try {
			this.modulo=modulo;
		} catch(Exception e) {
			;
		}
	}


	public  void  setTipoTransa(TipoTransa tipotransa) {
		try {
			this.tipotransa=tipotransa;
		} catch(Exception e) {
			;
		}
	}


	public  void  setTipoComprobante(TipoComprobante tipocomprobante) {
		try {
			this.tipocomprobante=tipocomprobante;
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


	public  void  setTipoRetencion(TipoRetencion tiporetencion) {
		try {
			this.tiporetencion=tiporetencion;
		} catch(Exception e) {
			;
		}
	}


	public  void  setCuentaContable(CuentaContable cuentacontable) {
		try {
			this.cuentacontable=cuentacontable;
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


	public  void  setmodulo_descripcion(String modulo_descripcion) {
		try {
			this.modulo_descripcion=modulo_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  settipotransa_descripcion(String tipotransa_descripcion) {
		try {
			this.tipotransa_descripcion=tipotransa_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  settipocomprobante_descripcion(String tipocomprobante_descripcion) {
		try {
			this.tipocomprobante_descripcion=tipocomprobante_descripcion;
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


	public  void  settiporetencion_descripcion(String tiporetencion_descripcion) {
		try {
			this.tiporetencion_descripcion=tiporetencion_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  setcuentacontable_descripcion(String cuentacontable_descripcion) {
		try {
			this.cuentacontable_descripcion=cuentacontable_descripcion;
		} catch(Exception e) {
			;
		}
	}


	
	
	
	
	
	/*PARA REPORTES*/
	String id_empresa_descripcion="";String id_sucursal_descripcion="";String id_modulo_descripcion="";String id_tipo_transa_descripcion="";String id_tipo_comprobante_descripcion="";String id_tipo_transaccion_modulo_descripcion="";String id_tipo_retencion_descripcion="";String id_cuenta_contable_descripcion="";
	
	
	public String getid_empresa_descripcion() {
		return id_empresa_descripcion;
	}
	public String getid_sucursal_descripcion() {
		return id_sucursal_descripcion;
	}
	public String getid_modulo_descripcion() {
		return id_modulo_descripcion;
	}
	public String getid_tipo_transa_descripcion() {
		return id_tipo_transa_descripcion;
	}
	public String getid_tipo_comprobante_descripcion() {
		return id_tipo_comprobante_descripcion;
	}
	public String getid_tipo_transaccion_modulo_descripcion() {
		return id_tipo_transaccion_modulo_descripcion;
	}
	public String getid_tipo_retencion_descripcion() {
		return id_tipo_retencion_descripcion;
	}
	public String getid_cuenta_contable_descripcion() {
		return id_cuenta_contable_descripcion;
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
	public void setid_modulo_descripcion(String newid_modulo_descripcion)throws Exception {
		try {
			this.id_modulo_descripcion=newid_modulo_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_tipo_transa_descripcion(String newid_tipo_transa_descripcion)throws Exception {
		try {
			this.id_tipo_transa_descripcion=newid_tipo_transa_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_tipo_comprobante_descripcion(String newid_tipo_comprobante_descripcion)throws Exception {
		try {
			this.id_tipo_comprobante_descripcion=newid_tipo_comprobante_descripcion;
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
	public void setid_tipo_retencion_descripcion(String newid_tipo_retencion_descripcion)throws Exception {
		try {
			this.id_tipo_retencion_descripcion=newid_tipo_retencion_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_cuenta_contable_descripcion(String newid_cuenta_contable_descripcion)throws Exception {
		try {
			this.id_cuenta_contable_descripcion=newid_cuenta_contable_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	
	public void inicializarVariablesParaReporte() {
		this.id_empresa_descripcion="";this.id_sucursal_descripcion="";this.id_modulo_descripcion="";this.id_tipo_transa_descripcion="";this.id_tipo_comprobante_descripcion="";this.id_tipo_transaccion_modulo_descripcion="";this.id_tipo_retencion_descripcion="";this.id_cuenta_contable_descripcion="";
	}
	
	
	Object detalleclientesDescripcionReporte;
	Object parametroproduEgresosDescripcionReporte;
	Object movimientoinventariosDescripcionReporte;
	Object formapagosDescripcionReporte;
	Object autoripagoordencomprasDescripcionReporte;
	Object autoripagosDescripcionReporte;
	Object parametroimporIngresosDescripcionReporte;
	Object facturaproveedorsDescripcionReporte;
	Object parametrofactusecuencialTransferenciasDescripcionReporte;
	Object facturaproveedorserviciosDescripcionReporte;
	Object clienteretencionsDescripcionReporte;
	Object parametrofactutransaccionCuentaCoNotaCreditosDescripcionReporte;
	Object definicionsDescripcionReporte;
	Object parametroproductosDescripcionReporte;
	Object parametrocarteraHabilitasDescripcionReporte;
	Object asientocontablecajachicasDescripcionReporte;
	Object parametrofactuempresaOrigensDescripcionReporte;
	Object pagoautosDescripcionReporte;
	Object parametrogenericoRecibosDescripcionReporte;
	Object detalleprovesDescripcionReporte;
	Object configuracionpunvenCuentaNotaCreditosDescripcionReporte;
	Object detalleasientocontablecajachicasDescripcionReporte;
	Object cuentaporcobrarsDescripcionReporte;
	Object detallemoviclienprovesDescripcionReporte;
	Object parametrotesoreriaPagarPagosDescripcionReporte;
	Object transaccioningresoegresosDescripcionReporte;
	Object transaccioncliente2sDescripcionReporte;
	Object tipoformapagosDescripcionReporte;
	Object analisistransaclientesDescripcionReporte;
	
	
	public Object getdetalleclientesDescripcionReporte() {
		return detalleclientesDescripcionReporte;
	}

	public Object getparametroproduEgresosDescripcionReporte() {
		return parametroproduEgresosDescripcionReporte;
	}

	public Object getmovimientoinventariosDescripcionReporte() {
		return movimientoinventariosDescripcionReporte;
	}

	public Object getformapagosDescripcionReporte() {
		return formapagosDescripcionReporte;
	}

	public Object getautoripagoordencomprasDescripcionReporte() {
		return autoripagoordencomprasDescripcionReporte;
	}

	public Object getautoripagosDescripcionReporte() {
		return autoripagosDescripcionReporte;
	}

	public Object getparametroimporIngresosDescripcionReporte() {
		return parametroimporIngresosDescripcionReporte;
	}

	public Object getfacturaproveedorsDescripcionReporte() {
		return facturaproveedorsDescripcionReporte;
	}

	public Object getparametrofactusecuencialTransferenciasDescripcionReporte() {
		return parametrofactusecuencialTransferenciasDescripcionReporte;
	}

	public Object getfacturaproveedorserviciosDescripcionReporte() {
		return facturaproveedorserviciosDescripcionReporte;
	}

	public Object getclienteretencionsDescripcionReporte() {
		return clienteretencionsDescripcionReporte;
	}

	public Object getparametrofactutransaccionCuentaCoNotaCreditosDescripcionReporte() {
		return parametrofactutransaccionCuentaCoNotaCreditosDescripcionReporte;
	}

	public Object getdefinicionsDescripcionReporte() {
		return definicionsDescripcionReporte;
	}

	public Object getparametroproductosDescripcionReporte() {
		return parametroproductosDescripcionReporte;
	}

	public Object getparametrocarteraHabilitasDescripcionReporte() {
		return parametrocarteraHabilitasDescripcionReporte;
	}

	public Object getasientocontablecajachicasDescripcionReporte() {
		return asientocontablecajachicasDescripcionReporte;
	}

	public Object getparametrofactuempresaOrigensDescripcionReporte() {
		return parametrofactuempresaOrigensDescripcionReporte;
	}

	public Object getpagoautosDescripcionReporte() {
		return pagoautosDescripcionReporte;
	}

	public Object getparametrogenericoRecibosDescripcionReporte() {
		return parametrogenericoRecibosDescripcionReporte;
	}

	public Object getdetalleprovesDescripcionReporte() {
		return detalleprovesDescripcionReporte;
	}

	public Object getconfiguracionpunvenCuentaNotaCreditosDescripcionReporte() {
		return configuracionpunvenCuentaNotaCreditosDescripcionReporte;
	}

	public Object getdetalleasientocontablecajachicasDescripcionReporte() {
		return detalleasientocontablecajachicasDescripcionReporte;
	}

	public Object getcuentaporcobrarsDescripcionReporte() {
		return cuentaporcobrarsDescripcionReporte;
	}

	public Object getdetallemoviclienprovesDescripcionReporte() {
		return detallemoviclienprovesDescripcionReporte;
	}

	public Object getparametrotesoreriaPagarPagosDescripcionReporte() {
		return parametrotesoreriaPagarPagosDescripcionReporte;
	}

	public Object gettransaccioningresoegresosDescripcionReporte() {
		return transaccioningresoegresosDescripcionReporte;
	}

	public Object gettransaccioncliente2sDescripcionReporte() {
		return transaccioncliente2sDescripcionReporte;
	}

	public Object gettipoformapagosDescripcionReporte() {
		return tipoformapagosDescripcionReporte;
	}

	public Object getanalisistransaclientesDescripcionReporte() {
		return analisistransaclientesDescripcionReporte;
	}

	
	
	public  void  setdetalleclientesDescripcionReporte(Object detalleclientes) {
		try {
			this.detalleclientesDescripcionReporte=detalleclientes;
		} catch(Exception ex) {
			;
		}
	}

	public  void  setparametroproduEgresosDescripcionReporte(Object parametroprodus) {
		try {
			this.parametroproduEgresosDescripcionReporte=parametroprodus;
		} catch(Exception ex) {
			;
		}
	}

	public  void  setmovimientoinventariosDescripcionReporte(Object movimientoinventarios) {
		try {
			this.movimientoinventariosDescripcionReporte=movimientoinventarios;
		} catch(Exception ex) {
			;
		}
	}

	public  void  setformapagosDescripcionReporte(Object formapagos) {
		try {
			this.formapagosDescripcionReporte=formapagos;
		} catch(Exception ex) {
			;
		}
	}

	public  void  setautoripagoordencomprasDescripcionReporte(Object autoripagoordencompras) {
		try {
			this.autoripagoordencomprasDescripcionReporte=autoripagoordencompras;
		} catch(Exception ex) {
			;
		}
	}

	public  void  setautoripagosDescripcionReporte(Object autoripagos) {
		try {
			this.autoripagosDescripcionReporte=autoripagos;
		} catch(Exception ex) {
			;
		}
	}

	public  void  setparametroimporIngresosDescripcionReporte(Object parametroimpors) {
		try {
			this.parametroimporIngresosDescripcionReporte=parametroimpors;
		} catch(Exception ex) {
			;
		}
	}

	public  void  setfacturaproveedorsDescripcionReporte(Object facturaproveedors) {
		try {
			this.facturaproveedorsDescripcionReporte=facturaproveedors;
		} catch(Exception ex) {
			;
		}
	}

	public  void  setparametrofactusecuencialTransferenciasDescripcionReporte(Object parametrofactusecuencials) {
		try {
			this.parametrofactusecuencialTransferenciasDescripcionReporte=parametrofactusecuencials;
		} catch(Exception ex) {
			;
		}
	}

	public  void  setfacturaproveedorserviciosDescripcionReporte(Object facturaproveedorservicios) {
		try {
			this.facturaproveedorserviciosDescripcionReporte=facturaproveedorservicios;
		} catch(Exception ex) {
			;
		}
	}

	public  void  setclienteretencionsDescripcionReporte(Object clienteretencions) {
		try {
			this.clienteretencionsDescripcionReporte=clienteretencions;
		} catch(Exception ex) {
			;
		}
	}

	public  void  setparametrofactutransaccionCuentaCoNotaCreditosDescripcionReporte(Object parametrofactutransaccions) {
		try {
			this.parametrofactutransaccionCuentaCoNotaCreditosDescripcionReporte=parametrofactutransaccions;
		} catch(Exception ex) {
			;
		}
	}

	public  void  setdefinicionsDescripcionReporte(Object definicions) {
		try {
			this.definicionsDescripcionReporte=definicions;
		} catch(Exception ex) {
			;
		}
	}

	public  void  setparametroproductosDescripcionReporte(Object parametroproductos) {
		try {
			this.parametroproductosDescripcionReporte=parametroproductos;
		} catch(Exception ex) {
			;
		}
	}

	public  void  setparametrocarteraHabilitasDescripcionReporte(Object parametrocarteras) {
		try {
			this.parametrocarteraHabilitasDescripcionReporte=parametrocarteras;
		} catch(Exception ex) {
			;
		}
	}

	public  void  setasientocontablecajachicasDescripcionReporte(Object asientocontablecajachicas) {
		try {
			this.asientocontablecajachicasDescripcionReporte=asientocontablecajachicas;
		} catch(Exception ex) {
			;
		}
	}

	public  void  setparametrofactuempresaOrigensDescripcionReporte(Object parametrofactuempresas) {
		try {
			this.parametrofactuempresaOrigensDescripcionReporte=parametrofactuempresas;
		} catch(Exception ex) {
			;
		}
	}

	public  void  setpagoautosDescripcionReporte(Object pagoautos) {
		try {
			this.pagoautosDescripcionReporte=pagoautos;
		} catch(Exception ex) {
			;
		}
	}

	public  void  setparametrogenericoRecibosDescripcionReporte(Object parametrogenericos) {
		try {
			this.parametrogenericoRecibosDescripcionReporte=parametrogenericos;
		} catch(Exception ex) {
			;
		}
	}

	public  void  setdetalleprovesDescripcionReporte(Object detalleproves) {
		try {
			this.detalleprovesDescripcionReporte=detalleproves;
		} catch(Exception ex) {
			;
		}
	}

	public  void  setconfiguracionpunvenCuentaNotaCreditosDescripcionReporte(Object configuracionpunvens) {
		try {
			this.configuracionpunvenCuentaNotaCreditosDescripcionReporte=configuracionpunvens;
		} catch(Exception ex) {
			;
		}
	}

	public  void  setdetalleasientocontablecajachicasDescripcionReporte(Object detalleasientocontablecajachicas) {
		try {
			this.detalleasientocontablecajachicasDescripcionReporte=detalleasientocontablecajachicas;
		} catch(Exception ex) {
			;
		}
	}

	public  void  setcuentaporcobrarsDescripcionReporte(Object cuentaporcobrars) {
		try {
			this.cuentaporcobrarsDescripcionReporte=cuentaporcobrars;
		} catch(Exception ex) {
			;
		}
	}

	public  void  setdetallemoviclienprovesDescripcionReporte(Object detallemoviclienproves) {
		try {
			this.detallemoviclienprovesDescripcionReporte=detallemoviclienproves;
		} catch(Exception ex) {
			;
		}
	}

	public  void  setparametrotesoreriaPagarPagosDescripcionReporte(Object parametrotesorerias) {
		try {
			this.parametrotesoreriaPagarPagosDescripcionReporte=parametrotesorerias;
		} catch(Exception ex) {
			;
		}
	}

	public  void  settransaccioningresoegresosDescripcionReporte(Object transaccioningresoegresos) {
		try {
			this.transaccioningresoegresosDescripcionReporte=transaccioningresoegresos;
		} catch(Exception ex) {
			;
		}
	}

	public  void  settransaccioncliente2sDescripcionReporte(Object transaccionclientes) {
		try {
			this.transaccioncliente2sDescripcionReporte=transaccionclientes;
		} catch(Exception ex) {
			;
		}
	}

	public  void  settipoformapagosDescripcionReporte(Object tipoformapagos) {
		try {
			this.tipoformapagosDescripcionReporte=tipoformapagos;
		} catch(Exception ex) {
			;
		}
	}

	public  void  setanalisistransaclientesDescripcionReporte(Object analisistransaclientes) {
		try {
			this.analisistransaclientesDescripcionReporte=analisistransaclientes;
		} catch(Exception ex) {
			;
		}
	}

	/*PARA REPORTES FIN*/		
}

