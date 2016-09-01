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
package com.bydan.erp.facturacion.business.entity;

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
//import com.bydan.erp.facturacion.util.TipoFormaPagoConstantesFunciones;
import com.bydan.erp.facturacion.util.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.contabilidad.util.*;
import com.bydan.erp.tesoreria.util.*;
import com.bydan.erp.puntoventa.util.*;
import com.bydan.erp.facturacion.util.*;
import com.bydan.erp.inventario.util.*;



import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.tesoreria.business.entity.*;
import com.bydan.erp.puntoventa.business.entity.*;
import com.bydan.erp.facturacion.business.entity.*;
import com.bydan.erp.inventario.business.entity.*;




@SuppressWarnings("unused")
public class TipoFormaPago extends TipoFormaPagoAdditional implements Serializable ,Cloneable {//TipoFormaPagoAdditional,GeneralEntity
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
	
	private TipoFormaPago tipoformapagoOriginal;
	
	private Map<String, Object> mapTipoFormaPago;
			
	public Map<String, Object> getMapTipoFormaPago() {
		return mapTipoFormaPago;
	}

	public void setMapTipoFormaPago(Map<String, Object> mapTipoFormaPago) {
		this.mapTipoFormaPago = mapTipoFormaPago;
	}
	
	public void inicializarMapTipoFormaPago() {
		this.mapTipoFormaPago = new HashMap<String,Object>();
	}
	
	public void setMapTipoFormaPagoValue(String sKey,Object oValue) {
		this.mapTipoFormaPago.put(sKey, oValue);
	}
	
	public Object getMapTipoFormaPagoValue(String sKey) {
		return this.mapTipoFormaPago.get(sKey);
	}
	
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_empresa;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_sucursal;
	
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_modulo;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_tipo_grupo_forma_pago;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=100,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=TipoFormaPagoConstantesFunciones.SREGEXNOMBRE,message=TipoFormaPagoConstantesFunciones.SMENSAJEREGEXNOMBRE)
	private String nombre;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=20,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=TipoFormaPagoConstantesFunciones.SREGEXSIGLAS,message=TipoFormaPagoConstantesFunciones.SMENSAJEREGEXSIGLAS)
	private String siglas;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Boolean con_detalle;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Boolean con_cuotas;
	
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_tipo_transaccion_modulo;
	
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_transaccion;
	
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_cuenta_contable;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=100,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@Pattern(regex=TipoFormaPagoConstantesFunciones.SREGEXDESCRIPCION,message=TipoFormaPagoConstantesFunciones.SMENSAJEREGEXDESCRIPCION)
	private String descripcion;
			
	
	public Empresa empresa;
	public Sucursal sucursal;
	public Modulo modulo;
	public TipoGrupoFormaPago tipogrupoformapago;
	public TipoTransaccionModulo tipotransaccionmodulo;
	public Transaccion transaccion;
	public CuentaContable cuentacontable;
	
	
	private String empresa_descripcion;
	private String sucursal_descripcion;
	private String modulo_descripcion;
	private String tipogrupoformapago_descripcion;
	private String tipotransaccionmodulo_descripcion;
	private String transaccion_descripcion;
	private String cuentacontable_descripcion;
	
	
	public List<RegistroFormaPagoBanco> registroformapagobancos;
	public List<DetaFormaPagoFactu> detaformapagofactus;
	public List<GrupoClienteFormaPago> grupoclienteformapagos;
	public List<DetaFormaPago> detaformapagos;
	public List<FormaPagoPuntoVenta> formapagopuntoventas;
	public List<FormaPago> formapagos;
	public List<FormaPagoInven> formapagoinvens;
	public List<CierreCaja> cierrecajas;
		
	public TipoFormaPago () throws Exception {
		super();		
		
		this.id=0L;
		
		
		this.versionRow=new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());//new Date();
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		this.sType="NONE";
		
		this.tipoformapagoOriginal=this;
		
 		this.id_empresa=-1L;
 		this.id_sucursal=-1L;
 		this.id_modulo=null;
 		this.id_tipo_grupo_forma_pago=-1L;
 		this.nombre="";
 		this.siglas="";
 		this.con_detalle=false;
 		this.con_cuotas=false;
 		this.id_tipo_transaccion_modulo=null;
 		this.id_transaccion=null;
 		this.id_cuenta_contable=null;
 		this.descripcion="";
		
		
		this.empresa=null;
		this.sucursal=null;
		this.modulo=null;
		this.tipogrupoformapago=null;
		this.tipotransaccionmodulo=null;
		this.transaccion=null;
		this.cuentacontable=null;
		
		
		this.empresa_descripcion="";
		this.sucursal_descripcion="";
		this.modulo_descripcion="";
		this.tipogrupoformapago_descripcion="";
		this.tipotransaccionmodulo_descripcion="";
		this.transaccion_descripcion="";
		this.cuentacontable_descripcion="";
		
		
		this.registroformapagobancos=null;
		this.detaformapagofactus=null;
		this.grupoclienteformapagos=null;
		this.detaformapagos=null;
		this.formapagopuntoventas=null;
		this.formapagos=null;
		this.formapagoinvens=null;
		this.cierrecajas=null;
		
			
		
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
    //PARA REPORTES
	public TipoFormaPago (Long id,Date versionRow,Long id_empresa,Long id_sucursal,Long id_modulo,Long id_tipo_grupo_forma_pago,String nombre,String siglas,Boolean con_detalle,Boolean con_cuotas,Long id_tipo_transaccion_modulo,Long id_transaccion,Long id_cuenta_contable,String descripcion) throws Exception {
		super();		
		
		this.id=id;
		this.versionRow=versionRow;
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.tipoformapagoOriginal=this;
		
 		this.id_empresa=id_empresa;
 		this.id_sucursal=id_sucursal;
 		this.id_modulo=id_modulo;
 		this.id_tipo_grupo_forma_pago=id_tipo_grupo_forma_pago;
 		this.nombre=nombre;
 		this.siglas=siglas;
 		this.con_detalle=con_detalle;
 		this.con_cuotas=con_cuotas;
 		this.id_tipo_transaccion_modulo=id_tipo_transaccion_modulo;
 		this.id_transaccion=id_transaccion;
 		this.id_cuenta_contable=id_cuenta_contable;
 		this.descripcion=descripcion;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	 //PARA REPORTES
	public TipoFormaPago (Long id_empresa,Long id_sucursal,Long id_modulo,Long id_tipo_grupo_forma_pago,String nombre,String siglas,Boolean con_detalle,Boolean con_cuotas,Long id_tipo_transaccion_modulo,Long id_transaccion,Long id_cuenta_contable,String descripcion) throws Exception {
		super();		
		
		this.id=0L;
		this.versionRow=new Date();
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.tipoformapagoOriginal=this;
		
 		this.id_empresa=id_empresa;
 		this.id_sucursal=id_sucursal;
 		this.id_modulo=id_modulo;
 		this.id_tipo_grupo_forma_pago=id_tipo_grupo_forma_pago;
 		this.nombre=nombre;
 		this.siglas=siglas;
 		this.con_detalle=con_detalle;
 		this.con_cuotas=con_cuotas;
 		this.id_tipo_transaccion_modulo=id_tipo_transaccion_modulo;
 		this.id_transaccion=id_transaccion;
 		this.id_cuenta_contable=id_cuenta_contable;
 		this.descripcion=descripcion;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	public boolean equals(Object object) {
		boolean equal=false;
		TipoFormaPago tipoformapagoLocal=null;
		
		if(object!=null) {
			tipoformapagoLocal=(TipoFormaPago)object;
			
			if(tipoformapagoLocal!=null) {
				if(this.getId()!=null && tipoformapagoLocal.getId()!=null) {
					if(this.getId().equals(tipoformapagoLocal.getId())) {
						equal=true;
					}
				}
			}
		}
		
		return equal;
	}
	
	public String toString() {
		String sDetalle="";
		
		if(!TipoFormaPagoConstantesFunciones.CON_DESCRIPCION_DETALLADO) {
        	sDetalle=TipoFormaPagoConstantesFunciones.getTipoFormaPagoDescripcion(this);
		} else {
			sDetalle=TipoFormaPagoConstantesFunciones.getTipoFormaPagoDescripcionDetallado(this);
		}
		
		return sDetalle;
    }
	
	public TipoFormaPago getTipoFormaPagoOriginal() {
		return this.tipoformapagoOriginal;
	}
	
	public void setTipoFormaPagoOriginal(TipoFormaPago tipoformapago) {
		try {
			this.tipoformapagoOriginal=tipoformapago;
		} catch(Exception e) {
			;
		}
	}
	
	
	protected TipoFormaPagoAdditional tipoformapagoAdditional=null;
	
	public TipoFormaPagoAdditional getTipoFormaPagoAdditional() {
		return this.tipoformapagoAdditional;
	}
	
	public void setTipoFormaPagoAdditional(TipoFormaPagoAdditional tipoformapagoAdditional) {
		try {
			this.tipoformapagoAdditional=tipoformapagoAdditional;
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
    
	
	public Long getid_modulo() {
		return this.id_modulo;
	}
    
	
	public Long getid_tipo_grupo_forma_pago() {
		return this.id_tipo_grupo_forma_pago;
	}
    
	
	public String getnombre() {
		return this.nombre;
	}
    
	
	public String getsiglas() {
		return this.siglas;
	}
    
	
	public Boolean getcon_detalle() {
		return this.con_detalle;
	}
    
	
	public Boolean getcon_cuotas() {
		return this.con_cuotas;
	}
    
	
	public Long getid_tipo_transaccion_modulo() {
		return this.id_tipo_transaccion_modulo;
	}
    
	
	public Long getid_transaccion() {
		return this.id_transaccion;
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
						System.out.println("TipoFormaPago:Valor nulo no permitido en columna id_empresa");
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
						System.out.println("TipoFormaPago:Valor nulo no permitido en columna id_sucursal");
					}
				}

				this.id_sucursal=newid_sucursal;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_modulo(Long newid_modulo) {
		if(this.id_modulo==null&&newid_modulo!=null) {
			this.id_modulo=newid_modulo;
				this.setIsChanged(true);
		}

		if(this.id_modulo!=null&&!this.id_modulo.equals(newid_modulo)) {

			this.id_modulo=newid_modulo;
				this.setIsChanged(true);
		}
	}
    
	public void setid_tipo_grupo_forma_pago(Long newid_tipo_grupo_forma_pago)throws Exception
	{
		try {
			if(this.id_tipo_grupo_forma_pago!=newid_tipo_grupo_forma_pago) {
				if(newid_tipo_grupo_forma_pago==null) {
					//newid_tipo_grupo_forma_pago=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("TipoFormaPago:Valor nulo no permitido en columna id_tipo_grupo_forma_pago");
					}
				}

				this.id_tipo_grupo_forma_pago=newid_tipo_grupo_forma_pago;
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
						System.out.println("TipoFormaPago:Valor nulo no permitido en columna nombre");
					}
				}

				if(newnombre!=null&&newnombre.length()>100) {
					newnombre=newnombre.substring(0,98);
					System.out.println("TipoFormaPago:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=100 en columna nombre");
				}

				this.nombre=newnombre;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setsiglas(String newsiglas)throws Exception
	{
		try {
			if(this.siglas!=newsiglas) {
				if(newsiglas==null) {
					//newsiglas="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("TipoFormaPago:Valor nulo no permitido en columna siglas");
					}
				}

				if(newsiglas!=null&&newsiglas.length()>20) {
					newsiglas=newsiglas.substring(0,18);
					System.out.println("TipoFormaPago:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=20 en columna siglas");
				}

				this.siglas=newsiglas;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setcon_detalle(Boolean newcon_detalle)throws Exception
	{
		try {
			if(this.con_detalle!=newcon_detalle) {
				if(newcon_detalle==null) {
					//newcon_detalle=false;
					if(Constantes.ISDEVELOPING) {
						System.out.println("TipoFormaPago:Valor nulo no permitido en columna con_detalle");
					}
				}

				this.con_detalle=newcon_detalle;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setcon_cuotas(Boolean newcon_cuotas)throws Exception
	{
		try {
			if(this.con_cuotas!=newcon_cuotas) {
				if(newcon_cuotas==null) {
					//newcon_cuotas=false;
					if(Constantes.ISDEVELOPING) {
						System.out.println("TipoFormaPago:Valor nulo no permitido en columna con_cuotas");
					}
				}

				this.con_cuotas=newcon_cuotas;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
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
    
	public void setid_transaccion(Long newid_transaccion) {
		if(this.id_transaccion==null&&newid_transaccion!=null) {
			this.id_transaccion=newid_transaccion;
				this.setIsChanged(true);
		}

		if(this.id_transaccion!=null&&!this.id_transaccion.equals(newid_transaccion)) {

			this.id_transaccion=newid_transaccion;
				this.setIsChanged(true);
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
						System.out.println("TipoFormaPago:Valor nulo no permitido en columna descripcion");
					}
				}

				if(newdescripcion!=null&&newdescripcion.length()>100) {
					newdescripcion=newdescripcion.substring(0,98);
					System.out.println("TipoFormaPago:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=100 en columna descripcion");
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

	public TipoGrupoFormaPago getTipoGrupoFormaPago() {
		return this.tipogrupoformapago;
	}

	public TipoTransaccionModulo getTipoTransaccionModulo() {
		return this.tipotransaccionmodulo;
	}

	public Transaccion getTransaccion() {
		return this.transaccion;
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

	public String gettipogrupoformapago_descripcion() {
		return this.tipogrupoformapago_descripcion;
	}

	public String gettipotransaccionmodulo_descripcion() {
		return this.tipotransaccionmodulo_descripcion;
	}

	public String gettransaccion_descripcion() {
		return this.transaccion_descripcion;
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


	public  void  setTipoGrupoFormaPago(TipoGrupoFormaPago tipogrupoformapago) {
		try {
			this.tipogrupoformapago=tipogrupoformapago;
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


	public  void  setTransaccion(Transaccion transaccion) {
		try {
			this.transaccion=transaccion;
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


	public  void  settipogrupoformapago_descripcion(String tipogrupoformapago_descripcion) {
		try {
			this.tipogrupoformapago_descripcion=tipogrupoformapago_descripcion;
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


	public  void  settransaccion_descripcion(String transaccion_descripcion) {
		try {
			this.transaccion_descripcion=transaccion_descripcion;
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


	
	
	public List<RegistroFormaPagoBanco> getRegistroFormaPagoBancos() {
		return this.registroformapagobancos;
	}

	public List<DetaFormaPagoFactu> getDetaFormaPagoFactus() {
		return this.detaformapagofactus;
	}

	public List<GrupoClienteFormaPago> getGrupoClienteFormaPagos() {
		return this.grupoclienteformapagos;
	}

	public List<DetaFormaPago> getDetaFormaPagos() {
		return this.detaformapagos;
	}

	public List<FormaPagoPuntoVenta> getFormaPagoPuntoVentas() {
		return this.formapagopuntoventas;
	}

	public List<FormaPago> getFormaPagos() {
		return this.formapagos;
	}

	public List<FormaPagoInven> getFormaPagoInvens() {
		return this.formapagoinvens;
	}

	public List<CierreCaja> getCierreCajas() {
		return this.cierrecajas;
	}

	
	
	public  void  setRegistroFormaPagoBancos(List<RegistroFormaPagoBanco> registroformapagobancos) {
		try {
			this.registroformapagobancos=registroformapagobancos;
		} catch(Exception e) {
			;
		}
	}

	public  void  setDetaFormaPagoFactus(List<DetaFormaPagoFactu> detaformapagofactus) {
		try {
			this.detaformapagofactus=detaformapagofactus;
		} catch(Exception e) {
			;
		}
	}

	public  void  setGrupoClienteFormaPagos(List<GrupoClienteFormaPago> grupoclienteformapagos) {
		try {
			this.grupoclienteformapagos=grupoclienteformapagos;
		} catch(Exception e) {
			;
		}
	}

	public  void  setDetaFormaPagos(List<DetaFormaPago> detaformapagos) {
		try {
			this.detaformapagos=detaformapagos;
		} catch(Exception e) {
			;
		}
	}

	public  void  setFormaPagoPuntoVentas(List<FormaPagoPuntoVenta> formapagopuntoventas) {
		try {
			this.formapagopuntoventas=formapagopuntoventas;
		} catch(Exception e) {
			;
		}
	}

	public  void  setFormaPagos(List<FormaPago> formapagos) {
		try {
			this.formapagos=formapagos;
		} catch(Exception e) {
			;
		}
	}

	public  void  setFormaPagoInvens(List<FormaPagoInven> formapagoinvens) {
		try {
			this.formapagoinvens=formapagoinvens;
		} catch(Exception e) {
			;
		}
	}

	public  void  setCierreCajas(List<CierreCaja> cierrecajas) {
		try {
			this.cierrecajas=cierrecajas;
		} catch(Exception e) {
			;
		}
	}

	
	/*PARA REPORTES*/
	String id_empresa_descripcion="";String id_sucursal_descripcion="";String id_modulo_descripcion="";String id_tipo_grupo_forma_pago_descripcion="";String con_detalle_descripcion="";String con_cuotas_descripcion="";String id_tipo_transaccion_modulo_descripcion="";String id_transaccion_descripcion="";String id_cuenta_contable_descripcion="";
	
	
	public String getid_empresa_descripcion() {
		return id_empresa_descripcion;
	}
	public String getid_sucursal_descripcion() {
		return id_sucursal_descripcion;
	}
	public String getid_modulo_descripcion() {
		return id_modulo_descripcion;
	}
	public String getid_tipo_grupo_forma_pago_descripcion() {
		return id_tipo_grupo_forma_pago_descripcion;
	}
	public String getcon_detalle_descripcion() {
		return con_detalle_descripcion;
	}
	public String getcon_cuotas_descripcion() {
		return con_cuotas_descripcion;
	}
	public String getid_tipo_transaccion_modulo_descripcion() {
		return id_tipo_transaccion_modulo_descripcion;
	}
	public String getid_transaccion_descripcion() {
		return id_transaccion_descripcion;
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
	public void setid_tipo_grupo_forma_pago_descripcion(String newid_tipo_grupo_forma_pago_descripcion)throws Exception {
		try {
			this.id_tipo_grupo_forma_pago_descripcion=newid_tipo_grupo_forma_pago_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setcon_detalle_descripcion(String newcon_detalle_descripcion)throws Exception {
		try {
			this.con_detalle_descripcion=newcon_detalle_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setcon_cuotas_descripcion(String newcon_cuotas_descripcion)throws Exception {
		try {
			this.con_cuotas_descripcion=newcon_cuotas_descripcion;
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
	public void setid_transaccion_descripcion(String newid_transaccion_descripcion)throws Exception {
		try {
			this.id_transaccion_descripcion=newid_transaccion_descripcion;
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
		this.id_empresa_descripcion="";this.id_sucursal_descripcion="";this.id_modulo_descripcion="";this.id_tipo_grupo_forma_pago_descripcion="";this.con_detalle_descripcion="";this.con_cuotas_descripcion="";this.id_tipo_transaccion_modulo_descripcion="";this.id_transaccion_descripcion="";this.id_cuenta_contable_descripcion="";
	}
	
	
	Object registroformapagobancosDescripcionReporte;
	Object detaformapagofactusDescripcionReporte;
	Object grupoclienteformapagosDescripcionReporte;
	Object detaformapagosDescripcionReporte;
	Object formapagopuntoventasDescripcionReporte;
	Object chequepostfechadosDescripcionReporte;
	Object formapagosDescripcionReporte;
	Object formapagoinvensDescripcionReporte;
	Object detallepagosDescripcionReporte;
	Object cierrecajasDescripcionReporte;
	Object historialformapagosDescripcionReporte;
	
	
	public Object getregistroformapagobancosDescripcionReporte() {
		return registroformapagobancosDescripcionReporte;
	}

	public Object getdetaformapagofactusDescripcionReporte() {
		return detaformapagofactusDescripcionReporte;
	}

	public Object getgrupoclienteformapagosDescripcionReporte() {
		return grupoclienteformapagosDescripcionReporte;
	}

	public Object getdetaformapagosDescripcionReporte() {
		return detaformapagosDescripcionReporte;
	}

	public Object getformapagopuntoventasDescripcionReporte() {
		return formapagopuntoventasDescripcionReporte;
	}

	public Object getchequepostfechadosDescripcionReporte() {
		return chequepostfechadosDescripcionReporte;
	}

	public Object getformapagosDescripcionReporte() {
		return formapagosDescripcionReporte;
	}

	public Object getformapagoinvensDescripcionReporte() {
		return formapagoinvensDescripcionReporte;
	}

	public Object getdetallepagosDescripcionReporte() {
		return detallepagosDescripcionReporte;
	}

	public Object getcierrecajasDescripcionReporte() {
		return cierrecajasDescripcionReporte;
	}

	public Object gethistorialformapagosDescripcionReporte() {
		return historialformapagosDescripcionReporte;
	}

	
	
	public  void  setregistroformapagobancosDescripcionReporte(Object registroformapagobancos) {
		try {
			this.registroformapagobancosDescripcionReporte=registroformapagobancos;
		} catch(Exception ex) {
			;
		}
	}

	public  void  setdetaformapagofactusDescripcionReporte(Object detaformapagofactus) {
		try {
			this.detaformapagofactusDescripcionReporte=detaformapagofactus;
		} catch(Exception ex) {
			;
		}
	}

	public  void  setgrupoclienteformapagosDescripcionReporte(Object grupoclienteformapagos) {
		try {
			this.grupoclienteformapagosDescripcionReporte=grupoclienteformapagos;
		} catch(Exception ex) {
			;
		}
	}

	public  void  setdetaformapagosDescripcionReporte(Object detaformapagos) {
		try {
			this.detaformapagosDescripcionReporte=detaformapagos;
		} catch(Exception ex) {
			;
		}
	}

	public  void  setformapagopuntoventasDescripcionReporte(Object formapagopuntoventas) {
		try {
			this.formapagopuntoventasDescripcionReporte=formapagopuntoventas;
		} catch(Exception ex) {
			;
		}
	}

	public  void  setchequepostfechadosDescripcionReporte(Object chequepostfechados) {
		try {
			this.chequepostfechadosDescripcionReporte=chequepostfechados;
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

	public  void  setformapagoinvensDescripcionReporte(Object formapagoinvens) {
		try {
			this.formapagoinvensDescripcionReporte=formapagoinvens;
		} catch(Exception ex) {
			;
		}
	}

	public  void  setdetallepagosDescripcionReporte(Object detallepagos) {
		try {
			this.detallepagosDescripcionReporte=detallepagos;
		} catch(Exception ex) {
			;
		}
	}

	public  void  setcierrecajasDescripcionReporte(Object cierrecajas) {
		try {
			this.cierrecajasDescripcionReporte=cierrecajas;
		} catch(Exception ex) {
			;
		}
	}

	public  void  sethistorialformapagosDescripcionReporte(Object historialformapagos) {
		try {
			this.historialformapagosDescripcionReporte=historialformapagos;
		} catch(Exception ex) {
			;
		}
	}

	/*PARA REPORTES FIN*/		
}

