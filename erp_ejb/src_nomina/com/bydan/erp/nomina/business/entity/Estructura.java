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
package com.bydan.erp.nomina.business.entity;

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
//import com.bydan.erp.nomina.util.EstructuraConstantesFunciones;
import com.bydan.erp.nomina.util.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.contabilidad.util.*;
import com.bydan.erp.inventario.util.*;
import com.bydan.erp.tesoreria.util.*;
import com.bydan.erp.cartera.util.*;
import com.bydan.erp.activosfijos.util.*;



import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.inventario.business.entity.*;
import com.bydan.erp.tesoreria.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;
import com.bydan.erp.activosfijos.business.entity.*;




@SuppressWarnings("unused")
public class Estructura extends EstructuraAdditional implements Serializable ,Cloneable {//EstructuraAdditional,GeneralEntity
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
	
	private Estructura estructuraOriginal;
	
	private Map<String, Object> mapEstructura;
			
	public Map<String, Object> getMapEstructura() {
		return mapEstructura;
	}

	public void setMapEstructura(Map<String, Object> mapEstructura) {
		this.mapEstructura = mapEstructura;
	}
	
	public void inicializarMapEstructura() {
		this.mapEstructura = new HashMap<String,Object>();
	}
	
	public void setMapEstructuraValue(String sKey,Object oValue) {
		this.mapEstructura.put(sKey, oValue);
	}
	
	public Object getMapEstructuraValue(String sKey) {
		return this.mapEstructura.get(sKey);
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
	private Long id_estructura;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_tipo_pago__n_m;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_numero_patronal;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_cuenta_contable;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_tipo_estructura;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_pais;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_ciudad;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=50,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=EstructuraConstantesFunciones.SREGEXCODIGO,message=EstructuraConstantesFunciones.SMENSAJEREGEXCODIGO)
	private String codigo;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=50,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=EstructuraConstantesFunciones.SREGEXNUMERO,message=EstructuraConstantesFunciones.SMENSAJEREGEXNUMERO)
	private String numero;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double valor_anticipo;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double porcentaje_anticipo;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=100,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=EstructuraConstantesFunciones.SREGEXNOMBRE,message=EstructuraConstantesFunciones.SMENSAJEREGEXNOMBRE)
	private String nombre;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Boolean es_jefe;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Boolean es_anual;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double porcentaje;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double valor;
			
	
	public Empresa empresa;
	public Sucursal sucursal;
	public Estructura estructura;
	public TipoPago_NM tipopago_nm;
	public NumeroPatronal numeropatronal;
	public CuentaContable cuentacontable;
	public TipoEstructura tipoestructura;
	public Pais pais;
	public Ciudad ciudad;
	
	
	private String empresa_descripcion;
	private String sucursal_descripcion;
	private String estructura_descripcion;
	private String tipopago_nm_descripcion;
	private String numeropatronal_descripcion;
	private String cuentacontable_descripcion;
	private String tipoestructura_descripcion;
	private String pais_descripcion;
	private String ciudad_descripcion;
	
	
	public List<CentroCostoEstructura> centrocostoestructuras;
	public List<PlaniVacacion> planivacacionCargos;
	public List<AsistenciaMensual> asistenciamensuals;
	public List<EmpleadoProcesoRubro> empleadoprocesorubros;
	public List<EmpleadoPagoRubro> empleadopagorubros;
	public List<ProvisionEmpleado> provisionempleados;
	public List<Empleado> empleados;
	public List<Estructura> estructuras;
	public List<EvaluacionEmpleado> evaluacionempleados;
	public List<EmpleadoImpuestoRenta> empleadoimpuestorentas;
	public List<RubroEstructura> rubroestructuras;
	public List<CierreRolMensual> cierrerolmensuals;
	public List<FormatoNomi> formatonomis;
	public List<EmpleadoEstructura> empleadoestructuras;
	public List<HistorialPagoNomi> historialpagonomis;
	public List<AsistenciaDiaria> asistenciadiarias;
	public List<FuncionEstruc> funcionestrucs;
	public List<SolicitudReemplazo> solicitudreemplazos;
	public List<SolicitudHoraExtra> solicitudhoraextras;
	public List<EvaluacionNomi> evaluacionnomis;
	public List<SolicitudVacacion> solicitudvacacions;
	public List<ResponsableActivoFijo> responsableactivofijos;
	public List<RubroEmpleaCuentaContable> rubroempleacuentacontables;
		
	public Estructura () throws Exception {
		super();		
		
		this.id=0L;
		
		
		this.versionRow=new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());//new Date();
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		this.sType="NONE";
		
		this.estructuraOriginal=this;
		
 		this.id_empresa=-1L;
 		this.id_sucursal=-1L;
 		this.id_estructura=null;
 		this.id_tipo_pago__n_m=-1L;
 		this.id_numero_patronal=-1L;
 		this.id_cuenta_contable=-1L;
 		this.id_tipo_estructura=-1L;
 		this.id_pais=-1L;
 		this.id_ciudad=-1L;
 		this.codigo="";
 		this.numero="";
 		this.valor_anticipo=0.0;
 		this.porcentaje_anticipo=0.0;
 		this.nombre="";
 		this.es_jefe=false;
 		this.es_anual=false;
 		this.porcentaje=0.0;
 		this.valor=0.0;
		
		
		this.empresa=null;
		this.sucursal=null;
		this.tipopago_nm=null;
		this.numeropatronal=null;
		this.cuentacontable=null;
		this.tipoestructura=null;
		this.pais=null;
		this.ciudad=null;
		
		
		this.empresa_descripcion="";
		this.sucursal_descripcion="";
		this.tipopago_nm_descripcion="";
		this.numeropatronal_descripcion="";
		this.cuentacontable_descripcion="";
		this.tipoestructura_descripcion="";
		this.pais_descripcion="";
		this.ciudad_descripcion="";
		
		
		this.centrocostoestructuras=null;
		this.planivacacionCargos=null;
		this.asistenciamensuals=null;
		this.empleadoprocesorubros=null;
		this.empleadopagorubros=null;
		this.provisionempleados=null;
		this.empleados=null;
		this.estructuras=null;
		this.evaluacionempleados=null;
		this.empleadoimpuestorentas=null;
		this.rubroestructuras=null;
		this.cierrerolmensuals=null;
		this.formatonomis=null;
		this.empleadoestructuras=null;
		this.historialpagonomis=null;
		this.asistenciadiarias=null;
		this.funcionestrucs=null;
		this.solicitudreemplazos=null;
		this.solicitudhoraextras=null;
		this.evaluacionnomis=null;
		this.solicitudvacacions=null;
		this.responsableactivofijos=null;
		this.rubroempleacuentacontables=null;
		
			
		
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
    //PARA REPORTES
	public Estructura (Long id,Date versionRow,Long id_empresa,Long id_sucursal,Long id_estructura,Long id_tipo_pago__n_m,Long id_numero_patronal,Long id_cuenta_contable,Long id_tipo_estructura,Long id_pais,Long id_ciudad,String codigo,String numero,Double valor_anticipo,Double porcentaje_anticipo,String nombre,Boolean es_jefe,Boolean es_anual,Double porcentaje,Double valor) throws Exception {
		super();		
		
		this.id=id;
		this.versionRow=versionRow;
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.estructuraOriginal=this;
		
 		this.id_empresa=id_empresa;
 		this.id_sucursal=id_sucursal;
 		this.id_estructura=id_estructura;
 		this.id_tipo_pago__n_m=id_tipo_pago__n_m;
 		this.id_numero_patronal=id_numero_patronal;
 		this.id_cuenta_contable=id_cuenta_contable;
 		this.id_tipo_estructura=id_tipo_estructura;
 		this.id_pais=id_pais;
 		this.id_ciudad=id_ciudad;
 		this.codigo=codigo;
 		this.numero=numero;
 		this.valor_anticipo=valor_anticipo;
 		this.porcentaje_anticipo=porcentaje_anticipo;
 		this.nombre=nombre;
 		this.es_jefe=es_jefe;
 		this.es_anual=es_anual;
 		this.porcentaje=porcentaje;
 		this.valor=valor;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	 //PARA REPORTES
	public Estructura (Long id_empresa,Long id_sucursal,Long id_estructura,Long id_tipo_pago__n_m,Long id_numero_patronal,Long id_cuenta_contable,Long id_tipo_estructura,Long id_pais,Long id_ciudad,String codigo,String numero,Double valor_anticipo,Double porcentaje_anticipo,String nombre,Boolean es_jefe,Boolean es_anual,Double porcentaje,Double valor) throws Exception {
		super();		
		
		this.id=0L;
		this.versionRow=new Date();
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.estructuraOriginal=this;
		
 		this.id_empresa=id_empresa;
 		this.id_sucursal=id_sucursal;
 		this.id_estructura=id_estructura;
 		this.id_tipo_pago__n_m=id_tipo_pago__n_m;
 		this.id_numero_patronal=id_numero_patronal;
 		this.id_cuenta_contable=id_cuenta_contable;
 		this.id_tipo_estructura=id_tipo_estructura;
 		this.id_pais=id_pais;
 		this.id_ciudad=id_ciudad;
 		this.codigo=codigo;
 		this.numero=numero;
 		this.valor_anticipo=valor_anticipo;
 		this.porcentaje_anticipo=porcentaje_anticipo;
 		this.nombre=nombre;
 		this.es_jefe=es_jefe;
 		this.es_anual=es_anual;
 		this.porcentaje=porcentaje;
 		this.valor=valor;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	public boolean equals(Object object) {
		boolean equal=false;
		Estructura estructuraLocal=null;
		
		if(object!=null) {
			estructuraLocal=(Estructura)object;
			
			if(estructuraLocal!=null) {
				if(this.getId()!=null && estructuraLocal.getId()!=null) {
					if(this.getId().equals(estructuraLocal.getId())) {
						equal=true;
					}
				}
			}
		}
		
		return equal;
	}
	
	public String toString() {
		String sDetalle="";
		
		if(!EstructuraConstantesFunciones.CON_DESCRIPCION_DETALLADO) {
        	sDetalle=EstructuraConstantesFunciones.getEstructuraDescripcion(this);
		} else {
			sDetalle=EstructuraConstantesFunciones.getEstructuraDescripcionDetallado(this);
		}
		
		return sDetalle;
    }
	
	public Estructura getEstructuraOriginal() {
		return this.estructuraOriginal;
	}
	
	public void setEstructuraOriginal(Estructura estructura) {
		try {
			this.estructuraOriginal=estructura;
		} catch(Exception e) {
			;
		}
	}
	
	
	protected EstructuraAdditional estructuraAdditional=null;
	
	public EstructuraAdditional getEstructuraAdditional() {
		return this.estructuraAdditional;
	}
	
	public void setEstructuraAdditional(EstructuraAdditional estructuraAdditional) {
		try {
			this.estructuraAdditional=estructuraAdditional;
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
    
	
	public Long getid_estructura() {
		return this.id_estructura;
	}
    
	
	public Long getid_tipo_pago__n_m() {
		return this.id_tipo_pago__n_m;
	}
    
	
	public Long getid_numero_patronal() {
		return this.id_numero_patronal;
	}
    
	
	public Long getid_cuenta_contable() {
		return this.id_cuenta_contable;
	}
    
	
	public Long getid_tipo_estructura() {
		return this.id_tipo_estructura;
	}
    
	
	public Long getid_pais() {
		return this.id_pais;
	}
    
	
	public Long getid_ciudad() {
		return this.id_ciudad;
	}
    
	
	public String getcodigo() {
		return this.codigo;
	}
    
	
	public String getnumero() {
		return this.numero;
	}
    
	
	public Double getvalor_anticipo() {
		return this.valor_anticipo;
	}
    
	
	public Double getporcentaje_anticipo() {
		return this.porcentaje_anticipo;
	}
    
	
	public String getnombre() {
		return this.nombre;
	}
    
	
	public Boolean getes_jefe() {
		return this.es_jefe;
	}
    
	
	public Boolean getes_anual() {
		return this.es_anual;
	}
    
	
	public Double getporcentaje() {
		return this.porcentaje;
	}
    
	
	public Double getvalor() {
		return this.valor;
	}
	
    
	public void setid_empresa(Long newid_empresa)throws Exception
	{
		try {
			if(this.id_empresa!=newid_empresa) {
				if(newid_empresa==null) {
					//newid_empresa=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("Estructura:Valor nulo no permitido en columna id_empresa");
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
						System.out.println("Estructura:Valor nulo no permitido en columna id_sucursal");
					}
				}

				this.id_sucursal=newid_sucursal;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_estructura(Long newid_estructura) {
		if(this.id_estructura==null&&newid_estructura!=null) {
			this.id_estructura=newid_estructura;
				this.setIsChanged(true);
		}

		if(this.id_estructura!=null&&!this.id_estructura.equals(newid_estructura)) {

			this.id_estructura=newid_estructura;
				this.setIsChanged(true);
		}
	}
    
	public void setid_tipo_pago__n_m(Long newid_tipo_pago__n_m)throws Exception
	{
		try {
			if(this.id_tipo_pago__n_m!=newid_tipo_pago__n_m) {
				if(newid_tipo_pago__n_m==null) {
					//newid_tipo_pago__n_m=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("Estructura:Valor nulo no permitido en columna id_tipo_pago__n_m");
					}
				}

				this.id_tipo_pago__n_m=newid_tipo_pago__n_m;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_numero_patronal(Long newid_numero_patronal)throws Exception
	{
		try {
			if(this.id_numero_patronal!=newid_numero_patronal) {
				if(newid_numero_patronal==null) {
					//newid_numero_patronal=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("Estructura:Valor nulo no permitido en columna id_numero_patronal");
					}
				}

				this.id_numero_patronal=newid_numero_patronal;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_cuenta_contable(Long newid_cuenta_contable)throws Exception
	{
		try {
			if(this.id_cuenta_contable!=newid_cuenta_contable) {
				if(newid_cuenta_contable==null) {
					//newid_cuenta_contable=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("Estructura:Valor nulo no permitido en columna id_cuenta_contable");
					}
				}

				this.id_cuenta_contable=newid_cuenta_contable;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_tipo_estructura(Long newid_tipo_estructura)throws Exception
	{
		try {
			if(this.id_tipo_estructura!=newid_tipo_estructura) {
				if(newid_tipo_estructura==null) {
					//newid_tipo_estructura=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("Estructura:Valor nulo no permitido en columna id_tipo_estructura");
					}
				}

				this.id_tipo_estructura=newid_tipo_estructura;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_pais(Long newid_pais)throws Exception
	{
		try {
			if(this.id_pais!=newid_pais) {
				if(newid_pais==null) {
					//newid_pais=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("Estructura:Valor nulo no permitido en columna id_pais");
					}
				}

				this.id_pais=newid_pais;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_ciudad(Long newid_ciudad)throws Exception
	{
		try {
			if(this.id_ciudad!=newid_ciudad) {
				if(newid_ciudad==null) {
					//newid_ciudad=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("Estructura:Valor nulo no permitido en columna id_ciudad");
					}
				}

				this.id_ciudad=newid_ciudad;
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
						System.out.println("Estructura:Valor nulo no permitido en columna codigo");
					}
				}

				if(newcodigo!=null&&newcodigo.length()>50) {
					newcodigo=newcodigo.substring(0,48);
					System.out.println("Estructura:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=50 en columna codigo");
				}

				this.codigo=newcodigo;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setnumero(String newnumero)throws Exception
	{
		try {
			if(this.numero!=newnumero) {
				if(newnumero==null) {
					//newnumero="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("Estructura:Valor nulo no permitido en columna numero");
					}
				}

				if(newnumero!=null&&newnumero.length()>50) {
					newnumero=newnumero.substring(0,48);
					System.out.println("Estructura:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=50 en columna numero");
				}

				this.numero=newnumero;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setvalor_anticipo(Double newvalor_anticipo)throws Exception
	{
		try {
			if(this.valor_anticipo!=newvalor_anticipo) {
				if(newvalor_anticipo==null) {
					//newvalor_anticipo=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("Estructura:Valor nulo no permitido en columna valor_anticipo");
					}
				}

				this.valor_anticipo=newvalor_anticipo;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setporcentaje_anticipo(Double newporcentaje_anticipo)throws Exception
	{
		try {
			if(this.porcentaje_anticipo!=newporcentaje_anticipo) {
				if(newporcentaje_anticipo==null) {
					//newporcentaje_anticipo=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("Estructura:Valor nulo no permitido en columna porcentaje_anticipo");
					}
				}

				this.porcentaje_anticipo=newporcentaje_anticipo;
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
						System.out.println("Estructura:Valor nulo no permitido en columna nombre");
					}
				}

				if(newnombre!=null&&newnombre.length()>100) {
					newnombre=newnombre.substring(0,98);
					System.out.println("Estructura:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=100 en columna nombre");
				}

				this.nombre=newnombre;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setes_jefe(Boolean newes_jefe)throws Exception
	{
		try {
			if(this.es_jefe!=newes_jefe) {
				if(newes_jefe==null) {
					//newes_jefe=false;
					if(Constantes.ISDEVELOPING) {
						System.out.println("Estructura:Valor nulo no permitido en columna es_jefe");
					}
				}

				this.es_jefe=newes_jefe;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setes_anual(Boolean newes_anual)throws Exception
	{
		try {
			if(this.es_anual!=newes_anual) {
				if(newes_anual==null) {
					//newes_anual=false;
					if(Constantes.ISDEVELOPING) {
						System.out.println("Estructura:Valor nulo no permitido en columna es_anual");
					}
				}

				this.es_anual=newes_anual;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setporcentaje(Double newporcentaje)throws Exception
	{
		try {
			if(this.porcentaje!=newporcentaje) {
				if(newporcentaje==null) {
					//newporcentaje=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("Estructura:Valor nulo no permitido en columna porcentaje");
					}
				}

				this.porcentaje=newporcentaje;
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
						System.out.println("Estructura:Valor nulo no permitido en columna valor");
					}
				}

				this.valor=newvalor;
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

	public Estructura getEstructura() {
		return this.estructura;
	}

	public TipoPago_NM getTipoPago_NM() {
		return this.tipopago_nm;
	}

	public NumeroPatronal getNumeroPatronal() {
		return this.numeropatronal;
	}

	public CuentaContable getCuentaContable() {
		return this.cuentacontable;
	}

	public TipoEstructura getTipoEstructura() {
		return this.tipoestructura;
	}

	public Pais getPais() {
		return this.pais;
	}

	public Ciudad getCiudad() {
		return this.ciudad;
	}

	
	
	public String getempresa_descripcion() {
		return this.empresa_descripcion;
	}

	public String getsucursal_descripcion() {
		return this.sucursal_descripcion;
	}

	public String getestructura_descripcion() {
		return this.estructura_descripcion;
	}

	public String gettipopago_nm_descripcion() {
		return this.tipopago_nm_descripcion;
	}

	public String getnumeropatronal_descripcion() {
		return this.numeropatronal_descripcion;
	}

	public String getcuentacontable_descripcion() {
		return this.cuentacontable_descripcion;
	}

	public String gettipoestructura_descripcion() {
		return this.tipoestructura_descripcion;
	}

	public String getpais_descripcion() {
		return this.pais_descripcion;
	}

	public String getciudad_descripcion() {
		return this.ciudad_descripcion;
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


	public  void  setEstructura(Estructura estructura) {
		try {
			this.estructura=estructura;
		} catch(Exception e) {
			;
		}
	}


	public  void  setTipoPago_NM(TipoPago_NM tipopago_nm) {
		try {
			this.tipopago_nm=tipopago_nm;
		} catch(Exception e) {
			;
		}
	}


	public  void  setNumeroPatronal(NumeroPatronal numeropatronal) {
		try {
			this.numeropatronal=numeropatronal;
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


	public  void  setTipoEstructura(TipoEstructura tipoestructura) {
		try {
			this.tipoestructura=tipoestructura;
		} catch(Exception e) {
			;
		}
	}


	public  void  setPais(Pais pais) {
		try {
			this.pais=pais;
		} catch(Exception e) {
			;
		}
	}


	public  void  setCiudad(Ciudad ciudad) {
		try {
			this.ciudad=ciudad;
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


	public  void  setestructura_descripcion(String estructura_descripcion) {
		try {
			this.estructura_descripcion=estructura_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  settipopago_nm_descripcion(String tipopago_nm_descripcion) {
		try {
			this.tipopago_nm_descripcion=tipopago_nm_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  setnumeropatronal_descripcion(String numeropatronal_descripcion) {
		try {
			this.numeropatronal_descripcion=numeropatronal_descripcion;
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


	public  void  settipoestructura_descripcion(String tipoestructura_descripcion) {
		try {
			this.tipoestructura_descripcion=tipoestructura_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  setpais_descripcion(String pais_descripcion) {
		try {
			this.pais_descripcion=pais_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  setciudad_descripcion(String ciudad_descripcion) {
		try {
			this.ciudad_descripcion=ciudad_descripcion;
		} catch(Exception e) {
			;
		}
	}


	
	
	public List<CentroCostoEstructura> getCentroCostoEstructuras() {
		return this.centrocostoestructuras;
	}

	public List<PlaniVacacion> getPlaniVacacionCargos() {
		return this.planivacacionCargos;
	}

	public List<AsistenciaMensual> getAsistenciaMensuals() {
		return this.asistenciamensuals;
	}

	public List<EmpleadoProcesoRubro> getEmpleadoProcesoRubros() {
		return this.empleadoprocesorubros;
	}

	public List<EmpleadoPagoRubro> getEmpleadoPagoRubros() {
		return this.empleadopagorubros;
	}

	public List<ProvisionEmpleado> getProvisionEmpleados() {
		return this.provisionempleados;
	}

	public List<Empleado> getEmpleados() {
		return this.empleados;
	}

	public List<Estructura> getEstructuras() {
		return this.estructuras;
	}

	public List<EvaluacionEmpleado> getEvaluacionEmpleados() {
		return this.evaluacionempleados;
	}

	public List<EmpleadoImpuestoRenta> getEmpleadoImpuestoRentas() {
		return this.empleadoimpuestorentas;
	}

	public List<RubroEstructura> getRubroEstructuras() {
		return this.rubroestructuras;
	}

	public List<CierreRolMensual> getCierreRolMensuals() {
		return this.cierrerolmensuals;
	}

	public List<FormatoNomi> getFormatoNomis() {
		return this.formatonomis;
	}

	public List<EmpleadoEstructura> getEmpleadoEstructuras() {
		return this.empleadoestructuras;
	}

	public List<HistorialPagoNomi> getHistorialPagoNomis() {
		return this.historialpagonomis;
	}

	public List<AsistenciaDiaria> getAsistenciaDiarias() {
		return this.asistenciadiarias;
	}

	public List<FuncionEstruc> getFuncionEstrucs() {
		return this.funcionestrucs;
	}

	public List<SolicitudReemplazo> getSolicitudReemplazos() {
		return this.solicitudreemplazos;
	}

	public List<SolicitudHoraExtra> getSolicitudHoraExtras() {
		return this.solicitudhoraextras;
	}

	public List<EvaluacionNomi> getEvaluacionNomis() {
		return this.evaluacionnomis;
	}

	public List<SolicitudVacacion> getSolicitudVacacions() {
		return this.solicitudvacacions;
	}

	public List<ResponsableActivoFijo> getResponsableActivoFijos() {
		return this.responsableactivofijos;
	}

	public List<RubroEmpleaCuentaContable> getRubroEmpleaCuentaContables() {
		return this.rubroempleacuentacontables;
	}

	
	
	public  void  setCentroCostoEstructuras(List<CentroCostoEstructura> centrocostoestructuras) {
		try {
			this.centrocostoestructuras=centrocostoestructuras;
		} catch(Exception e) {
			;
		}
	}

	public  void  setPlaniVacacionCargos(List<PlaniVacacion> planivacacionCargos) {
		try {
			this.planivacacionCargos=planivacacionCargos;
		} catch(Exception e) {
			;
		}
	}

	public  void  setAsistenciaMensuals(List<AsistenciaMensual> asistenciamensuals) {
		try {
			this.asistenciamensuals=asistenciamensuals;
		} catch(Exception e) {
			;
		}
	}

	public  void  setEmpleadoProcesoRubros(List<EmpleadoProcesoRubro> empleadoprocesorubros) {
		try {
			this.empleadoprocesorubros=empleadoprocesorubros;
		} catch(Exception e) {
			;
		}
	}

	public  void  setEmpleadoPagoRubros(List<EmpleadoPagoRubro> empleadopagorubros) {
		try {
			this.empleadopagorubros=empleadopagorubros;
		} catch(Exception e) {
			;
		}
	}

	public  void  setProvisionEmpleados(List<ProvisionEmpleado> provisionempleados) {
		try {
			this.provisionempleados=provisionempleados;
		} catch(Exception e) {
			;
		}
	}

	public  void  setEmpleados(List<Empleado> empleados) {
		try {
			this.empleados=empleados;
		} catch(Exception e) {
			;
		}
	}

	public  void  setEstructuras(List<Estructura> estructuras) {
		try {
			this.estructuras=estructuras;
		} catch(Exception e) {
			;
		}
	}

	public  void  setEvaluacionEmpleados(List<EvaluacionEmpleado> evaluacionempleados) {
		try {
			this.evaluacionempleados=evaluacionempleados;
		} catch(Exception e) {
			;
		}
	}

	public  void  setEmpleadoImpuestoRentas(List<EmpleadoImpuestoRenta> empleadoimpuestorentas) {
		try {
			this.empleadoimpuestorentas=empleadoimpuestorentas;
		} catch(Exception e) {
			;
		}
	}

	public  void  setRubroEstructuras(List<RubroEstructura> rubroestructuras) {
		try {
			this.rubroestructuras=rubroestructuras;
		} catch(Exception e) {
			;
		}
	}

	public  void  setCierreRolMensuals(List<CierreRolMensual> cierrerolmensuals) {
		try {
			this.cierrerolmensuals=cierrerolmensuals;
		} catch(Exception e) {
			;
		}
	}

	public  void  setFormatoNomis(List<FormatoNomi> formatonomis) {
		try {
			this.formatonomis=formatonomis;
		} catch(Exception e) {
			;
		}
	}

	public  void  setEmpleadoEstructuras(List<EmpleadoEstructura> empleadoestructuras) {
		try {
			this.empleadoestructuras=empleadoestructuras;
		} catch(Exception e) {
			;
		}
	}

	public  void  setHistorialPagoNomis(List<HistorialPagoNomi> historialpagonomis) {
		try {
			this.historialpagonomis=historialpagonomis;
		} catch(Exception e) {
			;
		}
	}

	public  void  setAsistenciaDiarias(List<AsistenciaDiaria> asistenciadiarias) {
		try {
			this.asistenciadiarias=asistenciadiarias;
		} catch(Exception e) {
			;
		}
	}

	public  void  setFuncionEstrucs(List<FuncionEstruc> funcionestrucs) {
		try {
			this.funcionestrucs=funcionestrucs;
		} catch(Exception e) {
			;
		}
	}

	public  void  setSolicitudReemplazos(List<SolicitudReemplazo> solicitudreemplazos) {
		try {
			this.solicitudreemplazos=solicitudreemplazos;
		} catch(Exception e) {
			;
		}
	}

	public  void  setSolicitudHoraExtras(List<SolicitudHoraExtra> solicitudhoraextras) {
		try {
			this.solicitudhoraextras=solicitudhoraextras;
		} catch(Exception e) {
			;
		}
	}

	public  void  setEvaluacionNomis(List<EvaluacionNomi> evaluacionnomis) {
		try {
			this.evaluacionnomis=evaluacionnomis;
		} catch(Exception e) {
			;
		}
	}

	public  void  setSolicitudVacacions(List<SolicitudVacacion> solicitudvacacions) {
		try {
			this.solicitudvacacions=solicitudvacacions;
		} catch(Exception e) {
			;
		}
	}

	public  void  setResponsableActivoFijos(List<ResponsableActivoFijo> responsableactivofijos) {
		try {
			this.responsableactivofijos=responsableactivofijos;
		} catch(Exception e) {
			;
		}
	}

	public  void  setRubroEmpleaCuentaContables(List<RubroEmpleaCuentaContable> rubroempleacuentacontables) {
		try {
			this.rubroempleacuentacontables=rubroempleacuentacontables;
		} catch(Exception e) {
			;
		}
	}

	
	/*PARA REPORTES*/
	String id_empresa_descripcion="";String id_sucursal_descripcion="";String id_estructura_descripcion="";String id_tipo_pago__n_m_descripcion="";String id_numero_patronal_descripcion="";String id_cuenta_contable_descripcion="";String id_tipo_estructura_descripcion="";String id_pais_descripcion="";String id_ciudad_descripcion="";String es_jefe_descripcion="";String es_anual_descripcion="";
	
	
	public String getid_empresa_descripcion() {
		return id_empresa_descripcion;
	}
	public String getid_sucursal_descripcion() {
		return id_sucursal_descripcion;
	}
	public String getid_estructura_descripcion() {
		return id_estructura_descripcion;
	}
	public String getid_tipo_pago__n_m_descripcion() {
		return id_tipo_pago__n_m_descripcion;
	}
	public String getid_numero_patronal_descripcion() {
		return id_numero_patronal_descripcion;
	}
	public String getid_cuenta_contable_descripcion() {
		return id_cuenta_contable_descripcion;
	}
	public String getid_tipo_estructura_descripcion() {
		return id_tipo_estructura_descripcion;
	}
	public String getid_pais_descripcion() {
		return id_pais_descripcion;
	}
	public String getid_ciudad_descripcion() {
		return id_ciudad_descripcion;
	}
	public String getes_jefe_descripcion() {
		return es_jefe_descripcion;
	}
	public String getes_anual_descripcion() {
		return es_anual_descripcion;
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
	public void setid_estructura_descripcion(String newid_estructura_descripcion)throws Exception {
		try {
			this.id_estructura_descripcion=newid_estructura_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_tipo_pago__n_m_descripcion(String newid_tipo_pago__n_m_descripcion)throws Exception {
		try {
			this.id_tipo_pago__n_m_descripcion=newid_tipo_pago__n_m_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_numero_patronal_descripcion(String newid_numero_patronal_descripcion)throws Exception {
		try {
			this.id_numero_patronal_descripcion=newid_numero_patronal_descripcion;
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
	public void setid_tipo_estructura_descripcion(String newid_tipo_estructura_descripcion)throws Exception {
		try {
			this.id_tipo_estructura_descripcion=newid_tipo_estructura_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_pais_descripcion(String newid_pais_descripcion)throws Exception {
		try {
			this.id_pais_descripcion=newid_pais_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_ciudad_descripcion(String newid_ciudad_descripcion)throws Exception {
		try {
			this.id_ciudad_descripcion=newid_ciudad_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setes_jefe_descripcion(String newes_jefe_descripcion)throws Exception {
		try {
			this.es_jefe_descripcion=newes_jefe_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setes_anual_descripcion(String newes_anual_descripcion)throws Exception {
		try {
			this.es_anual_descripcion=newes_anual_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	
	public void inicializarVariablesParaReporte() {
		this.id_empresa_descripcion="";this.id_sucursal_descripcion="";this.id_estructura_descripcion="";this.id_tipo_pago__n_m_descripcion="";this.id_numero_patronal_descripcion="";this.id_cuenta_contable_descripcion="";this.id_tipo_estructura_descripcion="";this.id_pais_descripcion="";this.id_ciudad_descripcion="";this.es_jefe_descripcion="";this.es_anual_descripcion="";
	}
	
	
	Object centrocostoestructurasDescripcionReporte;
	Object planivacacionCargosDescripcionReporte;
	Object asistenciamensualsDescripcionReporte;
	Object empleadoprocesorubrosDescripcionReporte;
	Object empleadopagorubrosDescripcionReporte;
	Object provisionempleadosDescripcionReporte;
	Object empleadosDescripcionReporte;
	Object estructurasDescripcionReporte;
	Object evaluacionempleadosDescripcionReporte;
	Object empleadoimpuestorentasDescripcionReporte;
	Object rubroestructurasDescripcionReporte;
	Object cierrerolmensualsDescripcionReporte;
	Object formatonomisDescripcionReporte;
	Object empleadoestructurasDescripcionReporte;
	Object historialpagonomisDescripcionReporte;
	Object asistenciadiariasDescripcionReporte;
	Object funcionestrucsDescripcionReporte;
	Object solicitudreemplazosDescripcionReporte;
	Object solicitudhoraextrasDescripcionReporte;
	Object evaluacionnomisDescripcionReporte;
	Object solicitudvacacionsDescripcionReporte;
	Object responsableactivofijosDescripcionReporte;
	Object rubroempleacuentacontablesDescripcionReporte;
	
	
	public Object getcentrocostoestructurasDescripcionReporte() {
		return centrocostoestructurasDescripcionReporte;
	}

	public Object getplanivacacionCargosDescripcionReporte() {
		return planivacacionCargosDescripcionReporte;
	}

	public Object getasistenciamensualsDescripcionReporte() {
		return asistenciamensualsDescripcionReporte;
	}

	public Object getempleadoprocesorubrosDescripcionReporte() {
		return empleadoprocesorubrosDescripcionReporte;
	}

	public Object getempleadopagorubrosDescripcionReporte() {
		return empleadopagorubrosDescripcionReporte;
	}

	public Object getprovisionempleadosDescripcionReporte() {
		return provisionempleadosDescripcionReporte;
	}

	public Object getempleadosDescripcionReporte() {
		return empleadosDescripcionReporte;
	}

	public Object getestructurasDescripcionReporte() {
		return estructurasDescripcionReporte;
	}

	public Object getevaluacionempleadosDescripcionReporte() {
		return evaluacionempleadosDescripcionReporte;
	}

	public Object getempleadoimpuestorentasDescripcionReporte() {
		return empleadoimpuestorentasDescripcionReporte;
	}

	public Object getrubroestructurasDescripcionReporte() {
		return rubroestructurasDescripcionReporte;
	}

	public Object getcierrerolmensualsDescripcionReporte() {
		return cierrerolmensualsDescripcionReporte;
	}

	public Object getformatonomisDescripcionReporte() {
		return formatonomisDescripcionReporte;
	}

	public Object getempleadoestructurasDescripcionReporte() {
		return empleadoestructurasDescripcionReporte;
	}

	public Object gethistorialpagonomisDescripcionReporte() {
		return historialpagonomisDescripcionReporte;
	}

	public Object getasistenciadiariasDescripcionReporte() {
		return asistenciadiariasDescripcionReporte;
	}

	public Object getfuncionestrucsDescripcionReporte() {
		return funcionestrucsDescripcionReporte;
	}

	public Object getsolicitudreemplazosDescripcionReporte() {
		return solicitudreemplazosDescripcionReporte;
	}

	public Object getsolicitudhoraextrasDescripcionReporte() {
		return solicitudhoraextrasDescripcionReporte;
	}

	public Object getevaluacionnomisDescripcionReporte() {
		return evaluacionnomisDescripcionReporte;
	}

	public Object getsolicitudvacacionsDescripcionReporte() {
		return solicitudvacacionsDescripcionReporte;
	}

	public Object getresponsableactivofijosDescripcionReporte() {
		return responsableactivofijosDescripcionReporte;
	}

	public Object getrubroempleacuentacontablesDescripcionReporte() {
		return rubroempleacuentacontablesDescripcionReporte;
	}

	
	
	public  void  setcentrocostoestructurasDescripcionReporte(Object centrocostoestructuras) {
		try {
			this.centrocostoestructurasDescripcionReporte=centrocostoestructuras;
		} catch(Exception ex) {
			;
		}
	}

	public  void  setplanivacacionCargosDescripcionReporte(Object planivacacions) {
		try {
			this.planivacacionCargosDescripcionReporte=planivacacions;
		} catch(Exception ex) {
			;
		}
	}

	public  void  setasistenciamensualsDescripcionReporte(Object asistenciamensuals) {
		try {
			this.asistenciamensualsDescripcionReporte=asistenciamensuals;
		} catch(Exception ex) {
			;
		}
	}

	public  void  setempleadoprocesorubrosDescripcionReporte(Object empleadoprocesorubros) {
		try {
			this.empleadoprocesorubrosDescripcionReporte=empleadoprocesorubros;
		} catch(Exception ex) {
			;
		}
	}

	public  void  setempleadopagorubrosDescripcionReporte(Object empleadopagorubros) {
		try {
			this.empleadopagorubrosDescripcionReporte=empleadopagorubros;
		} catch(Exception ex) {
			;
		}
	}

	public  void  setprovisionempleadosDescripcionReporte(Object provisionempleados) {
		try {
			this.provisionempleadosDescripcionReporte=provisionempleados;
		} catch(Exception ex) {
			;
		}
	}

	public  void  setempleadosDescripcionReporte(Object empleados) {
		try {
			this.empleadosDescripcionReporte=empleados;
		} catch(Exception ex) {
			;
		}
	}

	public  void  setestructurasDescripcionReporte(Object estructuras) {
		try {
			this.estructurasDescripcionReporte=estructuras;
		} catch(Exception ex) {
			;
		}
	}

	public  void  setevaluacionempleadosDescripcionReporte(Object evaluacionempleados) {
		try {
			this.evaluacionempleadosDescripcionReporte=evaluacionempleados;
		} catch(Exception ex) {
			;
		}
	}

	public  void  setempleadoimpuestorentasDescripcionReporte(Object empleadoimpuestorentas) {
		try {
			this.empleadoimpuestorentasDescripcionReporte=empleadoimpuestorentas;
		} catch(Exception ex) {
			;
		}
	}

	public  void  setrubroestructurasDescripcionReporte(Object rubroestructuras) {
		try {
			this.rubroestructurasDescripcionReporte=rubroestructuras;
		} catch(Exception ex) {
			;
		}
	}

	public  void  setcierrerolmensualsDescripcionReporte(Object cierrerolmensuals) {
		try {
			this.cierrerolmensualsDescripcionReporte=cierrerolmensuals;
		} catch(Exception ex) {
			;
		}
	}

	public  void  setformatonomisDescripcionReporte(Object formatonomis) {
		try {
			this.formatonomisDescripcionReporte=formatonomis;
		} catch(Exception ex) {
			;
		}
	}

	public  void  setempleadoestructurasDescripcionReporte(Object empleadoestructuras) {
		try {
			this.empleadoestructurasDescripcionReporte=empleadoestructuras;
		} catch(Exception ex) {
			;
		}
	}

	public  void  sethistorialpagonomisDescripcionReporte(Object historialpagonomis) {
		try {
			this.historialpagonomisDescripcionReporte=historialpagonomis;
		} catch(Exception ex) {
			;
		}
	}

	public  void  setasistenciadiariasDescripcionReporte(Object asistenciadiarias) {
		try {
			this.asistenciadiariasDescripcionReporte=asistenciadiarias;
		} catch(Exception ex) {
			;
		}
	}

	public  void  setfuncionestrucsDescripcionReporte(Object funcionestrucs) {
		try {
			this.funcionestrucsDescripcionReporte=funcionestrucs;
		} catch(Exception ex) {
			;
		}
	}

	public  void  setsolicitudreemplazosDescripcionReporte(Object solicitudreemplazos) {
		try {
			this.solicitudreemplazosDescripcionReporte=solicitudreemplazos;
		} catch(Exception ex) {
			;
		}
	}

	public  void  setsolicitudhoraextrasDescripcionReporte(Object solicitudhoraextras) {
		try {
			this.solicitudhoraextrasDescripcionReporte=solicitudhoraextras;
		} catch(Exception ex) {
			;
		}
	}

	public  void  setevaluacionnomisDescripcionReporte(Object evaluacionnomis) {
		try {
			this.evaluacionnomisDescripcionReporte=evaluacionnomis;
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

	public  void  setresponsableactivofijosDescripcionReporte(Object responsableactivofijos) {
		try {
			this.responsableactivofijosDescripcionReporte=responsableactivofijos;
		} catch(Exception ex) {
			;
		}
	}

	public  void  setrubroempleacuentacontablesDescripcionReporte(Object rubroempleacuentacontables) {
		try {
			this.rubroempleacuentacontablesDescripcionReporte=rubroempleacuentacontables;
		} catch(Exception ex) {
			;
		}
	}

	/*PARA REPORTES FIN*/		
}

