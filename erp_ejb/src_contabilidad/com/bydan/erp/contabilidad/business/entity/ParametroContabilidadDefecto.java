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
//import com.bydan.erp.contabilidad.util.ParametroContabilidadDefectoConstantesFunciones;
import com.bydan.erp.contabilidad.util.*;


import com.bydan.erp.seguridad.util.*;



import com.bydan.erp.seguridad.business.entity.*;




@SuppressWarnings("unused")
public class ParametroContabilidadDefecto extends ParametroContabilidadDefectoAdditional implements Serializable ,Cloneable {//ParametroContabilidadDefectoAdditional,GeneralEntity
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
	
	private ParametroContabilidadDefecto parametrocontabilidaddefectoOriginal;
	
	private Map<String, Object> mapParametroContabilidadDefecto;
			
	public Map<String, Object> getMapParametroContabilidadDefecto() {
		return mapParametroContabilidadDefecto;
	}

	public void setMapParametroContabilidadDefecto(Map<String, Object> mapParametroContabilidadDefecto) {
		this.mapParametroContabilidadDefecto = mapParametroContabilidadDefecto;
	}
	
	public void inicializarMapParametroContabilidadDefecto() {
		this.mapParametroContabilidadDefecto = new HashMap<String,Object>();
	}
	
	public void setMapParametroContabilidadDefectoValue(String sKey,Object oValue) {
		this.mapParametroContabilidadDefecto.put(sKey, oValue);
	}
	
	public Object getMapParametroContabilidadDefectoValue(String sKey) {
		return this.mapParametroContabilidadDefecto.get(sKey);
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
	private Long id_tipo_moneda;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_moneda;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_modulo;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_tipo_intervalo;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_tipo_movimiento;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_tipo_documento;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_estado_asiento_contable;
			
	
	public Empresa empresa;
	public Sucursal sucursal;
	public TipoMoneda tipomoneda;
	public Moneda moneda;
	public Modulo modulo;
	public TipoIntervalo tipointervalo;
	public TipoMovimiento tipomovimiento;
	public TipoDocumento tipodocumento;
	public EstadoAsientoContable estadoasientocontable;
	
	
	private String empresa_descripcion;
	private String sucursal_descripcion;
	private String tipomoneda_descripcion;
	private String moneda_descripcion;
	private String modulo_descripcion;
	private String tipointervalo_descripcion;
	private String tipomovimiento_descripcion;
	private String tipodocumento_descripcion;
	private String estadoasientocontable_descripcion;
	
	
		
	public ParametroContabilidadDefecto () throws Exception {
		super();		
		
		this.id=0L;
		
		
		this.versionRow=new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());//new Date();
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		this.sType="NONE";
		
		this.parametrocontabilidaddefectoOriginal=this;
		
 		this.id_empresa=-1L;
 		this.id_sucursal=-1L;
 		this.id_tipo_moneda=-1L;
 		this.id_moneda=-1L;
 		this.id_modulo=-1L;
 		this.id_tipo_intervalo=-1L;
 		this.id_tipo_movimiento=-1L;
 		this.id_tipo_documento=-1L;
 		this.id_estado_asiento_contable=-1L;
		
		
		this.empresa=null;
		this.sucursal=null;
		this.tipomoneda=null;
		this.moneda=null;
		this.modulo=null;
		this.tipointervalo=null;
		this.tipomovimiento=null;
		this.tipodocumento=null;
		this.estadoasientocontable=null;
		
		
		this.empresa_descripcion="";
		this.sucursal_descripcion="";
		this.tipomoneda_descripcion="";
		this.moneda_descripcion="";
		this.modulo_descripcion="";
		this.tipointervalo_descripcion="";
		this.tipomovimiento_descripcion="";
		this.tipodocumento_descripcion="";
		this.estadoasientocontable_descripcion="";
		
		
		
			
		
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
    //PARA REPORTES
	public ParametroContabilidadDefecto (Long id,Date versionRow,Long id_empresa,Long id_sucursal,Long id_tipo_moneda,Long id_moneda,Long id_modulo,Long id_tipo_intervalo,Long id_tipo_movimiento,Long id_tipo_documento,Long id_estado_asiento_contable) throws Exception {
		super();		
		
		this.id=id;
		this.versionRow=versionRow;
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.parametrocontabilidaddefectoOriginal=this;
		
 		this.id_empresa=id_empresa;
 		this.id_sucursal=id_sucursal;
 		this.id_tipo_moneda=id_tipo_moneda;
 		this.id_moneda=id_moneda;
 		this.id_modulo=id_modulo;
 		this.id_tipo_intervalo=id_tipo_intervalo;
 		this.id_tipo_movimiento=id_tipo_movimiento;
 		this.id_tipo_documento=id_tipo_documento;
 		this.id_estado_asiento_contable=id_estado_asiento_contable;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	 //PARA REPORTES
	public ParametroContabilidadDefecto (Long id_empresa,Long id_sucursal,Long id_tipo_moneda,Long id_moneda,Long id_modulo,Long id_tipo_intervalo,Long id_tipo_movimiento,Long id_tipo_documento,Long id_estado_asiento_contable) throws Exception {
		super();		
		
		this.id=0L;
		this.versionRow=new Date();
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.parametrocontabilidaddefectoOriginal=this;
		
 		this.id_empresa=id_empresa;
 		this.id_sucursal=id_sucursal;
 		this.id_tipo_moneda=id_tipo_moneda;
 		this.id_moneda=id_moneda;
 		this.id_modulo=id_modulo;
 		this.id_tipo_intervalo=id_tipo_intervalo;
 		this.id_tipo_movimiento=id_tipo_movimiento;
 		this.id_tipo_documento=id_tipo_documento;
 		this.id_estado_asiento_contable=id_estado_asiento_contable;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	public boolean equals(Object object) {
		boolean equal=false;
		ParametroContabilidadDefecto parametrocontabilidaddefectoLocal=null;
		
		if(object!=null) {
			parametrocontabilidaddefectoLocal=(ParametroContabilidadDefecto)object;
			
			if(parametrocontabilidaddefectoLocal!=null) {
				if(this.getId()!=null && parametrocontabilidaddefectoLocal.getId()!=null) {
					if(this.getId().equals(parametrocontabilidaddefectoLocal.getId())) {
						equal=true;
					}
				}
			}
		}
		
		return equal;
	}
	
	public String toString() {
		String sDetalle="";
		
		if(!ParametroContabilidadDefectoConstantesFunciones.CON_DESCRIPCION_DETALLADO) {
        	sDetalle=ParametroContabilidadDefectoConstantesFunciones.getParametroContabilidadDefectoDescripcion(this);
		} else {
			sDetalle=ParametroContabilidadDefectoConstantesFunciones.getParametroContabilidadDefectoDescripcionDetallado(this);
		}
		
		return sDetalle;
    }
	
	public ParametroContabilidadDefecto getParametroContabilidadDefectoOriginal() {
		return this.parametrocontabilidaddefectoOriginal;
	}
	
	public void setParametroContabilidadDefectoOriginal(ParametroContabilidadDefecto parametrocontabilidaddefecto) {
		try {
			this.parametrocontabilidaddefectoOriginal=parametrocontabilidaddefecto;
		} catch(Exception e) {
			;
		}
	}
	
	
	protected ParametroContabilidadDefectoAdditional parametrocontabilidaddefectoAdditional=null;
	
	public ParametroContabilidadDefectoAdditional getParametroContabilidadDefectoAdditional() {
		return this.parametrocontabilidaddefectoAdditional;
	}
	
	public void setParametroContabilidadDefectoAdditional(ParametroContabilidadDefectoAdditional parametrocontabilidaddefectoAdditional) {
		try {
			this.parametrocontabilidaddefectoAdditional=parametrocontabilidaddefectoAdditional;
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
    
	
	public Long getid_tipo_moneda() {
		return this.id_tipo_moneda;
	}
    
	
	public Long getid_moneda() {
		return this.id_moneda;
	}
    
	
	public Long getid_modulo() {
		return this.id_modulo;
	}
    
	
	public Long getid_tipo_intervalo() {
		return this.id_tipo_intervalo;
	}
    
	
	public Long getid_tipo_movimiento() {
		return this.id_tipo_movimiento;
	}
    
	
	public Long getid_tipo_documento() {
		return this.id_tipo_documento;
	}
    
	
	public Long getid_estado_asiento_contable() {
		return this.id_estado_asiento_contable;
	}
	
    
	public void setid_empresa(Long newid_empresa)throws Exception
	{
		try {
			if(this.id_empresa!=newid_empresa) {
				if(newid_empresa==null) {
					//newid_empresa=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ParametroContabilidadDefecto:Valor nulo no permitido en columna id_empresa");
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
						System.out.println("ParametroContabilidadDefecto:Valor nulo no permitido en columna id_sucursal");
					}
				}

				this.id_sucursal=newid_sucursal;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_tipo_moneda(Long newid_tipo_moneda)throws Exception
	{
		try {
			if(this.id_tipo_moneda!=newid_tipo_moneda) {
				if(newid_tipo_moneda==null) {
					//newid_tipo_moneda=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ParametroContabilidadDefecto:Valor nulo no permitido en columna id_tipo_moneda");
					}
				}

				this.id_tipo_moneda=newid_tipo_moneda;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_moneda(Long newid_moneda)throws Exception
	{
		try {
			if(this.id_moneda!=newid_moneda) {
				if(newid_moneda==null) {
					//newid_moneda=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ParametroContabilidadDefecto:Valor nulo no permitido en columna id_moneda");
					}
				}

				this.id_moneda=newid_moneda;
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
						System.out.println("ParametroContabilidadDefecto:Valor nulo no permitido en columna id_modulo");
					}
				}

				this.id_modulo=newid_modulo;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_tipo_intervalo(Long newid_tipo_intervalo)throws Exception
	{
		try {
			if(this.id_tipo_intervalo!=newid_tipo_intervalo) {
				if(newid_tipo_intervalo==null) {
					//newid_tipo_intervalo=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ParametroContabilidadDefecto:Valor nulo no permitido en columna id_tipo_intervalo");
					}
				}

				this.id_tipo_intervalo=newid_tipo_intervalo;
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
						System.out.println("ParametroContabilidadDefecto:Valor nulo no permitido en columna id_tipo_movimiento");
					}
				}

				this.id_tipo_movimiento=newid_tipo_movimiento;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_tipo_documento(Long newid_tipo_documento)throws Exception
	{
		try {
			if(this.id_tipo_documento!=newid_tipo_documento) {
				if(newid_tipo_documento==null) {
					//newid_tipo_documento=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ParametroContabilidadDefecto:Valor nulo no permitido en columna id_tipo_documento");
					}
				}

				this.id_tipo_documento=newid_tipo_documento;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_estado_asiento_contable(Long newid_estado_asiento_contable)throws Exception
	{
		try {
			if(this.id_estado_asiento_contable!=newid_estado_asiento_contable) {
				if(newid_estado_asiento_contable==null) {
					//newid_estado_asiento_contable=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ParametroContabilidadDefecto:Valor nulo no permitido en columna id_estado_asiento_contable");
					}
				}

				this.id_estado_asiento_contable=newid_estado_asiento_contable;
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

	public TipoMoneda getTipoMoneda() {
		return this.tipomoneda;
	}

	public Moneda getMoneda() {
		return this.moneda;
	}

	public Modulo getModulo() {
		return this.modulo;
	}

	public TipoIntervalo getTipoIntervalo() {
		return this.tipointervalo;
	}

	public TipoMovimiento getTipoMovimiento() {
		return this.tipomovimiento;
	}

	public TipoDocumento getTipoDocumento() {
		return this.tipodocumento;
	}

	public EstadoAsientoContable getEstadoAsientoContable() {
		return this.estadoasientocontable;
	}

	
	
	public String getempresa_descripcion() {
		return this.empresa_descripcion;
	}

	public String getsucursal_descripcion() {
		return this.sucursal_descripcion;
	}

	public String gettipomoneda_descripcion() {
		return this.tipomoneda_descripcion;
	}

	public String getmoneda_descripcion() {
		return this.moneda_descripcion;
	}

	public String getmodulo_descripcion() {
		return this.modulo_descripcion;
	}

	public String gettipointervalo_descripcion() {
		return this.tipointervalo_descripcion;
	}

	public String gettipomovimiento_descripcion() {
		return this.tipomovimiento_descripcion;
	}

	public String gettipodocumento_descripcion() {
		return this.tipodocumento_descripcion;
	}

	public String getestadoasientocontable_descripcion() {
		return this.estadoasientocontable_descripcion;
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


	public  void  setTipoMoneda(TipoMoneda tipomoneda) {
		try {
			this.tipomoneda=tipomoneda;
		} catch(Exception e) {
			;
		}
	}


	public  void  setMoneda(Moneda moneda) {
		try {
			this.moneda=moneda;
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


	public  void  setTipoIntervalo(TipoIntervalo tipointervalo) {
		try {
			this.tipointervalo=tipointervalo;
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


	public  void  setTipoDocumento(TipoDocumento tipodocumento) {
		try {
			this.tipodocumento=tipodocumento;
		} catch(Exception e) {
			;
		}
	}


	public  void  setEstadoAsientoContable(EstadoAsientoContable estadoasientocontable) {
		try {
			this.estadoasientocontable=estadoasientocontable;
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


	public  void  settipomoneda_descripcion(String tipomoneda_descripcion) {
		try {
			this.tipomoneda_descripcion=tipomoneda_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  setmoneda_descripcion(String moneda_descripcion) {
		try {
			this.moneda_descripcion=moneda_descripcion;
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


	public  void  settipointervalo_descripcion(String tipointervalo_descripcion) {
		try {
			this.tipointervalo_descripcion=tipointervalo_descripcion;
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


	public  void  settipodocumento_descripcion(String tipodocumento_descripcion) {
		try {
			this.tipodocumento_descripcion=tipodocumento_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  setestadoasientocontable_descripcion(String estadoasientocontable_descripcion) {
		try {
			this.estadoasientocontable_descripcion=estadoasientocontable_descripcion;
		} catch(Exception e) {
			;
		}
	}


	
	
	
	
	
	/*PARA REPORTES*/
	String id_empresa_descripcion="";String id_sucursal_descripcion="";String id_tipo_moneda_descripcion="";String id_moneda_descripcion="";String id_modulo_descripcion="";String id_tipo_intervalo_descripcion="";String id_tipo_movimiento_descripcion="";String id_tipo_documento_descripcion="";String id_estado_asiento_contable_descripcion="";
	
	
	public String getid_empresa_descripcion() {
		return id_empresa_descripcion;
	}
	public String getid_sucursal_descripcion() {
		return id_sucursal_descripcion;
	}
	public String getid_tipo_moneda_descripcion() {
		return id_tipo_moneda_descripcion;
	}
	public String getid_moneda_descripcion() {
		return id_moneda_descripcion;
	}
	public String getid_modulo_descripcion() {
		return id_modulo_descripcion;
	}
	public String getid_tipo_intervalo_descripcion() {
		return id_tipo_intervalo_descripcion;
	}
	public String getid_tipo_movimiento_descripcion() {
		return id_tipo_movimiento_descripcion;
	}
	public String getid_tipo_documento_descripcion() {
		return id_tipo_documento_descripcion;
	}
	public String getid_estado_asiento_contable_descripcion() {
		return id_estado_asiento_contable_descripcion;
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
	public void setid_tipo_moneda_descripcion(String newid_tipo_moneda_descripcion)throws Exception {
		try {
			this.id_tipo_moneda_descripcion=newid_tipo_moneda_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_moneda_descripcion(String newid_moneda_descripcion)throws Exception {
		try {
			this.id_moneda_descripcion=newid_moneda_descripcion;
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
	public void setid_tipo_intervalo_descripcion(String newid_tipo_intervalo_descripcion)throws Exception {
		try {
			this.id_tipo_intervalo_descripcion=newid_tipo_intervalo_descripcion;
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
	public void setid_tipo_documento_descripcion(String newid_tipo_documento_descripcion)throws Exception {
		try {
			this.id_tipo_documento_descripcion=newid_tipo_documento_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_estado_asiento_contable_descripcion(String newid_estado_asiento_contable_descripcion)throws Exception {
		try {
			this.id_estado_asiento_contable_descripcion=newid_estado_asiento_contable_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	
	public void inicializarVariablesParaReporte() {
		this.id_empresa_descripcion="";this.id_sucursal_descripcion="";this.id_tipo_moneda_descripcion="";this.id_moneda_descripcion="";this.id_modulo_descripcion="";this.id_tipo_intervalo_descripcion="";this.id_tipo_movimiento_descripcion="";this.id_tipo_documento_descripcion="";this.id_estado_asiento_contable_descripcion="";
	}
	
	
	
	
	
	
	/*PARA REPORTES FIN*/		
}

