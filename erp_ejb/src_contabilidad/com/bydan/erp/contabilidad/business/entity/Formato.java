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
package com.bydan.erp.contabilidad.business.entity;

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
//import com.bydan.erp.contabilidad.util.FormatoConstantesFunciones;
import com.bydan.erp.contabilidad.util.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.facturacion.util.*;
import com.bydan.erp.contabilidad.util.*;
import com.bydan.erp.nomina.util.*;
import com.bydan.erp.inventario.util.*;
import com.bydan.erp.cartera.util.*;
import com.bydan.erp.comisiones.util.*;
import com.bydan.erp.puntoventa.util.*;
import com.bydan.erp.tesoreria.util.*;
import com.bydan.erp.activosfijos.util.*;
import com.bydan.erp.importaciones.util.*;
import com.bydan.erp.produccion.util.*;



import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.facturacion.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.nomina.business.entity.*;
import com.bydan.erp.inventario.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;
import com.bydan.erp.comisiones.business.entity.*;
import com.bydan.erp.puntoventa.business.entity.*;
import com.bydan.erp.tesoreria.business.entity.*;
import com.bydan.erp.activosfijos.business.entity.*;
import com.bydan.erp.importaciones.business.entity.*;
import com.bydan.erp.produccion.business.entity.*;




@SuppressWarnings("unused")
public class Formato extends FormatoAdditional implements Serializable ,Cloneable {//FormatoAdditional,GeneralEntity
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
	
	private Formato formatoOriginal;
	
	private Map<String, Object> mapFormato;
			
	public Map<String, Object> getMapFormato() {
		return mapFormato;
	}

	public void setMapFormato(Map<String, Object> mapFormato) {
		this.mapFormato = mapFormato;
	}
	
	public void inicializarMapFormato() {
		this.mapFormato = new HashMap<String,Object>();
	}
	
	public void setMapFormatoValue(String sKey,Object oValue) {
		this.mapFormato.put(sKey, oValue);
	}
	
	public Object getMapFormatoValue(String sKey) {
		return this.mapFormato.get(sKey);
	}
	
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_empresa;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_modulo;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=50,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=FormatoConstantesFunciones.SREGEXNOMBRE,message=FormatoConstantesFunciones.SMENSAJEREGEXNOMBRE)
	private String nombre;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_tipo_movimiento;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_tipo_formato;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=100,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=FormatoConstantesFunciones.SREGEXUBICACION,message=FormatoConstantesFunciones.SMENSAJEREGEXUBICACION)
	private String ubicacion;
			
	
	public Empresa empresa;
	public Modulo modulo;
	public TipoMovimiento tipomovimiento;
	public TipoFormato tipoformato;
	
	
	private String empresa_descripcion;
	private String modulo_descripcion;
	private String tipomovimiento_descripcion;
	private String tipoformato_descripcion;
	
	
		
	public Formato () throws Exception {
		super();		
		
		this.id=0L;
		
		
		this.versionRow=new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());//new Date();
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		this.sType="NONE";
		
		this.formatoOriginal=this;
		
 		this.id_empresa=-1L;
 		this.id_modulo=-1L;
 		this.nombre="";
 		this.id_tipo_movimiento=-1L;
 		this.id_tipo_formato=-1L;
 		this.ubicacion="";
		
		
		this.empresa=null;
		this.modulo=null;
		this.tipomovimiento=null;
		this.tipoformato=null;
		
		
		this.empresa_descripcion="";
		this.modulo_descripcion="";
		this.tipomovimiento_descripcion="";
		this.tipoformato_descripcion="";
		
		
		
			
		
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
    //PARA REPORTES
	public Formato (Long id,Date versionRow,Long id_empresa,Long id_modulo,String nombre,Long id_tipo_movimiento,Long id_tipo_formato,String ubicacion) throws Exception {
		super();		
		
		this.id=id;
		this.versionRow=versionRow;
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.formatoOriginal=this;
		
 		this.id_empresa=id_empresa;
 		this.id_modulo=id_modulo;
 		this.nombre=nombre;
 		this.id_tipo_movimiento=id_tipo_movimiento;
 		this.id_tipo_formato=id_tipo_formato;
 		this.ubicacion=ubicacion;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	 //PARA REPORTES
	public Formato (Long id_empresa,Long id_modulo,String nombre,Long id_tipo_movimiento,Long id_tipo_formato,String ubicacion) throws Exception {
		super();		
		
		this.id=0L;
		this.versionRow=new Date();
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.formatoOriginal=this;
		
 		this.id_empresa=id_empresa;
 		this.id_modulo=id_modulo;
 		this.nombre=nombre;
 		this.id_tipo_movimiento=id_tipo_movimiento;
 		this.id_tipo_formato=id_tipo_formato;
 		this.ubicacion=ubicacion;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	public boolean equals(Object object) {
		boolean equal=false;
		Formato formatoLocal=null;
		
		if(object!=null) {
			formatoLocal=(Formato)object;
			
			if(formatoLocal!=null) {
				if(this.getId()!=null && formatoLocal.getId()!=null) {
					if(this.getId().equals(formatoLocal.getId())) {
						equal=true;
					}
				}
			}
		}
		
		return equal;
	}
	
	public String toString() {
		String sDetalle="";
		
		if(!FormatoConstantesFunciones.CON_DESCRIPCION_DETALLADO) {
        	sDetalle=FormatoConstantesFunciones.getFormatoDescripcion(this);
		} else {
			sDetalle=FormatoConstantesFunciones.getFormatoDescripcionDetallado(this);
		}
		
		return sDetalle;
    }
	
	public Formato getFormatoOriginal() {
		return this.formatoOriginal;
	}
	
	public void setFormatoOriginal(Formato formato) {
		try {
			this.formatoOriginal=formato;
		} catch(Exception e) {
			;
		}
	}
	
	
	protected FormatoAdditional formatoAdditional=null;
	
	public FormatoAdditional getFormatoAdditional() {
		return this.formatoAdditional;
	}
	
	public void setFormatoAdditional(FormatoAdditional formatoAdditional) {
		try {
			this.formatoAdditional=formatoAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
    
	
	public Long getid_empresa() {
		return this.id_empresa;
	}
    
	
	public Long getid_modulo() {
		return this.id_modulo;
	}
    
	
	public String getnombre() {
		return this.nombre;
	}
    
	
	public Long getid_tipo_movimiento() {
		return this.id_tipo_movimiento;
	}
    
	
	public Long getid_tipo_formato() {
		return this.id_tipo_formato;
	}
    
	
	public String getubicacion() {
		return this.ubicacion;
	}
	
    
	public void setid_empresa(Long newid_empresa)throws Exception
	{
		try {
			if(this.id_empresa!=newid_empresa) {
				if(newid_empresa==null) {
					//newid_empresa=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("Formato:Valor nulo no permitido en columna id_empresa");
					}
				}

				this.id_empresa=newid_empresa;
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
						System.out.println("Formato:Valor nulo no permitido en columna id_modulo");
					}
				}

				this.id_modulo=newid_modulo;
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
						System.out.println("Formato:Valor nulo no permitido en columna nombre");
					}
				}

				if(newnombre!=null&&newnombre.length()>50) {
					newnombre=newnombre.substring(0,48);
					System.out.println("Formato:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=50 en columna nombre");
				}

				this.nombre=newnombre;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_tipo_movimiento(Long newid_tipo_movimiento)throws Exception
	{
		try {
			if(this.id_tipo_movimiento!=newid_tipo_movimiento) {
				if(newid_tipo_movimiento==null) {
					//newid_tipo_movimiento=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("Formato:Valor nulo no permitido en columna id_tipo_movimiento");
					}
				}

				this.id_tipo_movimiento=newid_tipo_movimiento;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_tipo_formato(Long newid_tipo_formato)throws Exception
	{
		try {
			if(this.id_tipo_formato!=newid_tipo_formato) {
				if(newid_tipo_formato==null) {
					//newid_tipo_formato=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("Formato:Valor nulo no permitido en columna id_tipo_formato");
					}
				}

				this.id_tipo_formato=newid_tipo_formato;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setubicacion(String newubicacion)throws Exception
	{
		try {
			if(this.ubicacion!=newubicacion) {
				if(newubicacion==null) {
					//newubicacion="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("Formato:Valor nulo no permitido en columna ubicacion");
					}
				}

				if(newubicacion!=null&&newubicacion.length()>100) {
					newubicacion=newubicacion.substring(0,98);
					System.out.println("Formato:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=100 en columna ubicacion");
				}

				this.ubicacion=newubicacion;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	
	public Empresa getEmpresa() {
		return this.empresa;
	}

	public Modulo getModulo() {
		return this.modulo;
	}

	public TipoMovimiento getTipoMovimiento() {
		return this.tipomovimiento;
	}

	public TipoFormato getTipoFormato() {
		return this.tipoformato;
	}

	
	
	public String getempresa_descripcion() {
		return this.empresa_descripcion;
	}

	public String getmodulo_descripcion() {
		return this.modulo_descripcion;
	}

	public String gettipomovimiento_descripcion() {
		return this.tipomovimiento_descripcion;
	}

	public String gettipoformato_descripcion() {
		return this.tipoformato_descripcion;
	}

	
	
	public  void  setEmpresa(Empresa empresa) {
		try {
			this.empresa=empresa;
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


	public  void  setTipoMovimiento(TipoMovimiento tipomovimiento) {
		try {
			this.tipomovimiento=tipomovimiento;
		} catch(Exception e) {
			;
		}
	}


	public  void  setTipoFormato(TipoFormato tipoformato) {
		try {
			this.tipoformato=tipoformato;
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


	public  void  setmodulo_descripcion(String modulo_descripcion) {
		try {
			this.modulo_descripcion=modulo_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  settipomovimiento_descripcion(String tipomovimiento_descripcion) {
		try {
			this.tipomovimiento_descripcion=tipomovimiento_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  settipoformato_descripcion(String tipoformato_descripcion) {
		try {
			this.tipoformato_descripcion=tipoformato_descripcion;
		} catch(Exception e) {
			;
		}
	}


	
	
	
	
	
	/*PARA REPORTES*/
	String id_empresa_descripcion="";String id_modulo_descripcion="";String id_tipo_movimiento_descripcion="";String id_tipo_formato_descripcion="";
	
	
	public String getid_empresa_descripcion() {
		return id_empresa_descripcion;
	}
	public String getid_modulo_descripcion() {
		return id_modulo_descripcion;
	}
	public String getid_tipo_movimiento_descripcion() {
		return id_tipo_movimiento_descripcion;
	}
	public String getid_tipo_formato_descripcion() {
		return id_tipo_formato_descripcion;
	}
	
	
	public void setid_empresa_descripcion(String newid_empresa_descripcion)throws Exception {
		try {
			this.id_empresa_descripcion=newid_empresa_descripcion;
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
	public void setid_tipo_movimiento_descripcion(String newid_tipo_movimiento_descripcion)throws Exception {
		try {
			this.id_tipo_movimiento_descripcion=newid_tipo_movimiento_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_tipo_formato_descripcion(String newid_tipo_formato_descripcion)throws Exception {
		try {
			this.id_tipo_formato_descripcion=newid_tipo_formato_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	
	public void inicializarVariablesParaReporte() {
		this.id_empresa_descripcion="";this.id_modulo_descripcion="";this.id_tipo_movimiento_descripcion="";this.id_tipo_formato_descripcion="";
	}
	
	
	Object tipogastoempresasDescripcionReporte;
	Object notacreditosolisDescripcionReporte;
	Object notacreditopuntoventasDescripcionReporte;
	Object parametrocompraPedidosDescripcionReporte;
	Object configuracionpunvenNotaCreditosDescripcionReporte;
	Object cuentabancoRetencionIvasDescripcionReporte;
	Object parametrofactuInventariosDescripcionReporte;
	Object facturapuntoventasDescripcionReporte;
	Object formatoactivofijosDescripcionReporte;
	Object guiaremisionsDescripcionReporte;
	Object notacreditosDescripcionReporte;
	Object pedidosDescripcionReporte;
	Object parametrofactusecuencialsDescripcionReporte;
	Object pedidocompraimporsDescripcionReporte;
	Object ordencomprasDescripcionReporte;
	Object ordenprodusDescripcionReporte;
	Object pedidocomprasDescripcionReporte;
	Object banco2sDescripcionReporte;
	Object definicionsDescripcionReporte;
	Object requisicionsDescripcionReporte;
	Object pedidoexporsDescripcionReporte;
	Object pedidoprodusDescripcionReporte;
	Object facturasDescripcionReporte;
	Object comprasDescripcionReporte;
	Object parametroimporIngresosDescripcionReporte;
	Object asientocontablesDescripcionReporte;
	Object requisicioncomprasDescripcionReporte;
	Object planeacioncomprasDescripcionReporte;
	Object parametrogenericosDescripcionReporte;
	Object parametrofactuprincipalsDescripcionReporte;
	Object parametroproductosDescripcionReporte;
	Object defiprovisionempleadosDescripcionReporte;
	Object transferenciasDescripcionReporte;
	Object solicitudvacacionsDescripcionReporte;
	Object proformasDescripcionReporte;
	Object movimientoinventariosDescripcionReporte;
	Object consignacionsDescripcionReporte;
	Object tipocontratosDescripcionReporte;
	
	
	public Object gettipogastoempresasDescripcionReporte() {
		return tipogastoempresasDescripcionReporte;
	}

	public Object getnotacreditosolisDescripcionReporte() {
		return notacreditosolisDescripcionReporte;
	}

	public Object getnotacreditopuntoventasDescripcionReporte() {
		return notacreditopuntoventasDescripcionReporte;
	}

	public Object getparametrocompraPedidosDescripcionReporte() {
		return parametrocompraPedidosDescripcionReporte;
	}

	public Object getconfiguracionpunvenNotaCreditosDescripcionReporte() {
		return configuracionpunvenNotaCreditosDescripcionReporte;
	}

	public Object getcuentabancoRetencionIvasDescripcionReporte() {
		return cuentabancoRetencionIvasDescripcionReporte;
	}

	public Object getparametrofactuInventariosDescripcionReporte() {
		return parametrofactuInventariosDescripcionReporte;
	}

	public Object getfacturapuntoventasDescripcionReporte() {
		return facturapuntoventasDescripcionReporte;
	}

	public Object getformatoactivofijosDescripcionReporte() {
		return formatoactivofijosDescripcionReporte;
	}

	public Object getguiaremisionsDescripcionReporte() {
		return guiaremisionsDescripcionReporte;
	}

	public Object getnotacreditosDescripcionReporte() {
		return notacreditosDescripcionReporte;
	}

	public Object getpedidosDescripcionReporte() {
		return pedidosDescripcionReporte;
	}

	public Object getparametrofactusecuencialsDescripcionReporte() {
		return parametrofactusecuencialsDescripcionReporte;
	}

	public Object getpedidocompraimporsDescripcionReporte() {
		return pedidocompraimporsDescripcionReporte;
	}

	public Object getordencomprasDescripcionReporte() {
		return ordencomprasDescripcionReporte;
	}

	public Object getordenprodusDescripcionReporte() {
		return ordenprodusDescripcionReporte;
	}

	public Object getpedidocomprasDescripcionReporte() {
		return pedidocomprasDescripcionReporte;
	}

	public Object getbanco2sDescripcionReporte() {
		return banco2sDescripcionReporte;
	}

	public Object getdefinicionsDescripcionReporte() {
		return definicionsDescripcionReporte;
	}

	public Object getrequisicionsDescripcionReporte() {
		return requisicionsDescripcionReporte;
	}

	public Object getpedidoexporsDescripcionReporte() {
		return pedidoexporsDescripcionReporte;
	}

	public Object getpedidoprodusDescripcionReporte() {
		return pedidoprodusDescripcionReporte;
	}

	public Object getfacturasDescripcionReporte() {
		return facturasDescripcionReporte;
	}

	public Object getcomprasDescripcionReporte() {
		return comprasDescripcionReporte;
	}

	public Object getparametroimporIngresosDescripcionReporte() {
		return parametroimporIngresosDescripcionReporte;
	}

	public Object getasientocontablesDescripcionReporte() {
		return asientocontablesDescripcionReporte;
	}

	public Object getrequisicioncomprasDescripcionReporte() {
		return requisicioncomprasDescripcionReporte;
	}

	public Object getplaneacioncomprasDescripcionReporte() {
		return planeacioncomprasDescripcionReporte;
	}

	public Object getparametrogenericosDescripcionReporte() {
		return parametrogenericosDescripcionReporte;
	}

	public Object getparametrofactuprincipalsDescripcionReporte() {
		return parametrofactuprincipalsDescripcionReporte;
	}

	public Object getparametroproductosDescripcionReporte() {
		return parametroproductosDescripcionReporte;
	}

	public Object getdefiprovisionempleadosDescripcionReporte() {
		return defiprovisionempleadosDescripcionReporte;
	}

	public Object gettransferenciasDescripcionReporte() {
		return transferenciasDescripcionReporte;
	}

	public Object getsolicitudvacacionsDescripcionReporte() {
		return solicitudvacacionsDescripcionReporte;
	}

	public Object getproformasDescripcionReporte() {
		return proformasDescripcionReporte;
	}

	public Object getmovimientoinventariosDescripcionReporte() {
		return movimientoinventariosDescripcionReporte;
	}

	public Object getconsignacionsDescripcionReporte() {
		return consignacionsDescripcionReporte;
	}

	public Object gettipocontratosDescripcionReporte() {
		return tipocontratosDescripcionReporte;
	}

	
	
	public  void  settipogastoempresasDescripcionReporte(Object tipogastoempresas) {
		try {
			this.tipogastoempresasDescripcionReporte=tipogastoempresas;
		} catch(Exception ex) {
			;
		}
	}

	public  void  setnotacreditosolisDescripcionReporte(Object notacreditosolis) {
		try {
			this.notacreditosolisDescripcionReporte=notacreditosolis;
		} catch(Exception ex) {
			;
		}
	}

	public  void  setnotacreditopuntoventasDescripcionReporte(Object notacreditopuntoventas) {
		try {
			this.notacreditopuntoventasDescripcionReporte=notacreditopuntoventas;
		} catch(Exception ex) {
			;
		}
	}

	public  void  setparametrocompraPedidosDescripcionReporte(Object parametrocompras) {
		try {
			this.parametrocompraPedidosDescripcionReporte=parametrocompras;
		} catch(Exception ex) {
			;
		}
	}

	public  void  setconfiguracionpunvenNotaCreditosDescripcionReporte(Object configuracionpunvens) {
		try {
			this.configuracionpunvenNotaCreditosDescripcionReporte=configuracionpunvens;
		} catch(Exception ex) {
			;
		}
	}

	public  void  setcuentabancoRetencionIvasDescripcionReporte(Object cuentabancos) {
		try {
			this.cuentabancoRetencionIvasDescripcionReporte=cuentabancos;
		} catch(Exception ex) {
			;
		}
	}

	public  void  setparametrofactuInventariosDescripcionReporte(Object parametrofactus) {
		try {
			this.parametrofactuInventariosDescripcionReporte=parametrofactus;
		} catch(Exception ex) {
			;
		}
	}

	public  void  setfacturapuntoventasDescripcionReporte(Object facturapuntoventas) {
		try {
			this.facturapuntoventasDescripcionReporte=facturapuntoventas;
		} catch(Exception ex) {
			;
		}
	}

	public  void  setformatoactivofijosDescripcionReporte(Object formatoactivofijos) {
		try {
			this.formatoactivofijosDescripcionReporte=formatoactivofijos;
		} catch(Exception ex) {
			;
		}
	}

	public  void  setguiaremisionsDescripcionReporte(Object guiaremisions) {
		try {
			this.guiaremisionsDescripcionReporte=guiaremisions;
		} catch(Exception ex) {
			;
		}
	}

	public  void  setnotacreditosDescripcionReporte(Object notacreditos) {
		try {
			this.notacreditosDescripcionReporte=notacreditos;
		} catch(Exception ex) {
			;
		}
	}

	public  void  setpedidosDescripcionReporte(Object pedidos) {
		try {
			this.pedidosDescripcionReporte=pedidos;
		} catch(Exception ex) {
			;
		}
	}

	public  void  setparametrofactusecuencialsDescripcionReporte(Object parametrofactusecuencials) {
		try {
			this.parametrofactusecuencialsDescripcionReporte=parametrofactusecuencials;
		} catch(Exception ex) {
			;
		}
	}

	public  void  setpedidocompraimporsDescripcionReporte(Object pedidocompraimpors) {
		try {
			this.pedidocompraimporsDescripcionReporte=pedidocompraimpors;
		} catch(Exception ex) {
			;
		}
	}

	public  void  setordencomprasDescripcionReporte(Object ordencompras) {
		try {
			this.ordencomprasDescripcionReporte=ordencompras;
		} catch(Exception ex) {
			;
		}
	}

	public  void  setordenprodusDescripcionReporte(Object ordenprodus) {
		try {
			this.ordenprodusDescripcionReporte=ordenprodus;
		} catch(Exception ex) {
			;
		}
	}

	public  void  setpedidocomprasDescripcionReporte(Object pedidocompras) {
		try {
			this.pedidocomprasDescripcionReporte=pedidocompras;
		} catch(Exception ex) {
			;
		}
	}

	public  void  setbanco2sDescripcionReporte(Object bancos) {
		try {
			this.banco2sDescripcionReporte=bancos;
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

	public  void  setrequisicionsDescripcionReporte(Object requisicions) {
		try {
			this.requisicionsDescripcionReporte=requisicions;
		} catch(Exception ex) {
			;
		}
	}

	public  void  setpedidoexporsDescripcionReporte(Object pedidoexpors) {
		try {
			this.pedidoexporsDescripcionReporte=pedidoexpors;
		} catch(Exception ex) {
			;
		}
	}

	public  void  setpedidoprodusDescripcionReporte(Object pedidoprodus) {
		try {
			this.pedidoprodusDescripcionReporte=pedidoprodus;
		} catch(Exception ex) {
			;
		}
	}

	public  void  setfacturasDescripcionReporte(Object facturas) {
		try {
			this.facturasDescripcionReporte=facturas;
		} catch(Exception ex) {
			;
		}
	}

	public  void  setcomprasDescripcionReporte(Object compras) {
		try {
			this.comprasDescripcionReporte=compras;
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

	public  void  setasientocontablesDescripcionReporte(Object asientocontables) {
		try {
			this.asientocontablesDescripcionReporte=asientocontables;
		} catch(Exception ex) {
			;
		}
	}

	public  void  setrequisicioncomprasDescripcionReporte(Object requisicioncompras) {
		try {
			this.requisicioncomprasDescripcionReporte=requisicioncompras;
		} catch(Exception ex) {
			;
		}
	}

	public  void  setplaneacioncomprasDescripcionReporte(Object planeacioncompras) {
		try {
			this.planeacioncomprasDescripcionReporte=planeacioncompras;
		} catch(Exception ex) {
			;
		}
	}

	public  void  setparametrogenericosDescripcionReporte(Object parametrogenericos) {
		try {
			this.parametrogenericosDescripcionReporte=parametrogenericos;
		} catch(Exception ex) {
			;
		}
	}

	public  void  setparametrofactuprincipalsDescripcionReporte(Object parametrofactuprincipals) {
		try {
			this.parametrofactuprincipalsDescripcionReporte=parametrofactuprincipals;
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

	public  void  setdefiprovisionempleadosDescripcionReporte(Object defiprovisionempleados) {
		try {
			this.defiprovisionempleadosDescripcionReporte=defiprovisionempleados;
		} catch(Exception ex) {
			;
		}
	}

	public  void  settransferenciasDescripcionReporte(Object transferencias) {
		try {
			this.transferenciasDescripcionReporte=transferencias;
		} catch(Exception ex) {
			;
		}
	}

	public  void  setsolicitudvacacionsDescripcionReporte(Object solicitudvacacions) {
		try {
			this.solicitudvacacionsDescripcionReporte=solicitudvacacions;
		} catch(Exception ex) {
			;
		}
	}

	public  void  setproformasDescripcionReporte(Object proformas) {
		try {
			this.proformasDescripcionReporte=proformas;
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

	public  void  setconsignacionsDescripcionReporte(Object consignacions) {
		try {
			this.consignacionsDescripcionReporte=consignacions;
		} catch(Exception ex) {
			;
		}
	}

	public  void  settipocontratosDescripcionReporte(Object tipocontratos) {
		try {
			this.tipocontratosDescripcionReporte=tipocontratos;
		} catch(Exception ex) {
			;
		}
	}

	/*PARA REPORTES FIN*/		
}

