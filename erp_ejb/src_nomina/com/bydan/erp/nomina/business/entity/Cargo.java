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
//import com.bydan.erp.nomina.util.CargoConstantesFunciones;
import com.bydan.erp.nomina.util.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.contabilidad.util.*;
import com.bydan.erp.tesoreria.util.*;
import com.bydan.erp.cartera.util.*;



import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.tesoreria.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;




@SuppressWarnings("unused")
public class Cargo extends CargoAdditional implements Serializable ,Cloneable {//CargoAdditional,GeneralEntity
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
	
	private Cargo cargoOriginal;
	
	private Map<String, Object> mapCargo;
			
	public Map<String, Object> getMapCargo() {
		return mapCargo;
	}

	public void setMapCargo(Map<String, Object> mapCargo) {
		this.mapCargo = mapCargo;
	}
	
	public void inicializarMapCargo() {
		this.mapCargo = new HashMap<String,Object>();
	}
	
	public void setMapCargoValue(String sKey,Object oValue) {
		this.mapCargo.put(sKey, oValue);
	}
	
	public Object getMapCargoValue(String sKey) {
		return this.mapCargo.get(sKey);
	}
	
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_empresa;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_cargo;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_cuenta_contable;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_numero_patronal;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_tipo_pago__n_m;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_cargo_grupo;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=50,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=CargoConstantesFunciones.SREGEXCODIGO,message=CargoConstantesFunciones.SMENSAJEREGEXCODIGO)
	private String codigo;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=150,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=CargoConstantesFunciones.SREGEXNOMBRE,message=CargoConstantesFunciones.SMENSAJEREGEXNOMBRE)
	private String nombre;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double valor_anticipo;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double porcentaje_anticipo;
	
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
	public Cargo cargo;
	public CuentaContable cuentacontable;
	public NumeroPatronal numeropatronal;
	public TipoPago_NM tipopago_nm;
	public CargoGrupo cargogrupo;
	
	
	private String empresa_descripcion;
	private String cargo_descripcion;
	private String cuentacontable_descripcion;
	private String numeropatronal_descripcion;
	private String tipopago_nm_descripcion;
	private String cargogrupo_descripcion;
	
	
	public List<AsistenciaMensual> asistenciamensuals;
	public List<EmpleadoEstructura> empleadoestructuras;
	public List<Empleado> empleados;
	public List<Cargo> cargos;
		
	public Cargo () throws Exception {
		super();		
		
		this.id=0L;
		
		
		this.versionRow=new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());//new Date();
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		this.sType="NONE";
		
		this.cargoOriginal=this;
		
 		this.id_empresa=-1L;
 		this.id_cargo=-1L;
 		this.id_cuenta_contable=-1L;
 		this.id_numero_patronal=-1L;
 		this.id_tipo_pago__n_m=-1L;
 		this.id_cargo_grupo=-1L;
 		this.codigo="";
 		this.nombre="";
 		this.valor_anticipo=0.0;
 		this.porcentaje_anticipo=0.0;
 		this.es_jefe=false;
 		this.es_anual=false;
 		this.porcentaje=0.0;
 		this.valor=0.0;
		
		
		this.empresa=null;
		this.cuentacontable=null;
		this.numeropatronal=null;
		this.tipopago_nm=null;
		this.cargogrupo=null;
		
		
		this.empresa_descripcion="";
		this.cuentacontable_descripcion="";
		this.numeropatronal_descripcion="";
		this.tipopago_nm_descripcion="";
		this.cargogrupo_descripcion="";
		
		
		this.asistenciamensuals=null;
		this.empleadoestructuras=null;
		this.empleados=null;
		this.cargos=null;
		
			
		
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
    //PARA REPORTES
	public Cargo (Long id,Date versionRow,Long id_empresa,Long id_cargo,Long id_cuenta_contable,Long id_numero_patronal,Long id_tipo_pago__n_m,Long id_cargo_grupo,String codigo,String nombre,Double valor_anticipo,Double porcentaje_anticipo,Boolean es_jefe,Boolean es_anual,Double porcentaje,Double valor) throws Exception {
		super();		
		
		this.id=id;
		this.versionRow=versionRow;
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.cargoOriginal=this;
		
 		this.id_empresa=id_empresa;
 		this.id_cargo=id_cargo;
 		this.id_cuenta_contable=id_cuenta_contable;
 		this.id_numero_patronal=id_numero_patronal;
 		this.id_tipo_pago__n_m=id_tipo_pago__n_m;
 		this.id_cargo_grupo=id_cargo_grupo;
 		this.codigo=codigo;
 		this.nombre=nombre;
 		this.valor_anticipo=valor_anticipo;
 		this.porcentaje_anticipo=porcentaje_anticipo;
 		this.es_jefe=es_jefe;
 		this.es_anual=es_anual;
 		this.porcentaje=porcentaje;
 		this.valor=valor;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	 //PARA REPORTES
	public Cargo (Long id_empresa,Long id_cargo,Long id_cuenta_contable,Long id_numero_patronal,Long id_tipo_pago__n_m,Long id_cargo_grupo,String codigo,String nombre,Double valor_anticipo,Double porcentaje_anticipo,Boolean es_jefe,Boolean es_anual,Double porcentaje,Double valor) throws Exception {
		super();		
		
		this.id=0L;
		this.versionRow=new Date();
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.cargoOriginal=this;
		
 		this.id_empresa=id_empresa;
 		this.id_cargo=id_cargo;
 		this.id_cuenta_contable=id_cuenta_contable;
 		this.id_numero_patronal=id_numero_patronal;
 		this.id_tipo_pago__n_m=id_tipo_pago__n_m;
 		this.id_cargo_grupo=id_cargo_grupo;
 		this.codigo=codigo;
 		this.nombre=nombre;
 		this.valor_anticipo=valor_anticipo;
 		this.porcentaje_anticipo=porcentaje_anticipo;
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
		Cargo cargoLocal=null;
		
		if(object!=null) {
			cargoLocal=(Cargo)object;
			
			if(cargoLocal!=null) {
				if(this.getId()!=null && cargoLocal.getId()!=null) {
					if(this.getId().equals(cargoLocal.getId())) {
						equal=true;
					}
				}
			}
		}
		
		return equal;
	}
	
	public String toString() {
		String sDetalle="";
		
		if(!CargoConstantesFunciones.CON_DESCRIPCION_DETALLADO) {
        	sDetalle=CargoConstantesFunciones.getCargoDescripcion(this);
		} else {
			sDetalle=CargoConstantesFunciones.getCargoDescripcionDetallado(this);
		}
		
		return sDetalle;
    }
	
	public Cargo getCargoOriginal() {
		return this.cargoOriginal;
	}
	
	public void setCargoOriginal(Cargo cargo) {
		try {
			this.cargoOriginal=cargo;
		} catch(Exception e) {
			;
		}
	}
	
	
	protected CargoAdditional cargoAdditional=null;
	
	public CargoAdditional getCargoAdditional() {
		return this.cargoAdditional;
	}
	
	public void setCargoAdditional(CargoAdditional cargoAdditional) {
		try {
			this.cargoAdditional=cargoAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
    
	
	public Long getid_empresa() {
		return this.id_empresa;
	}
    
	
	public Long getid_cargo() {
		return this.id_cargo;
	}
    
	
	public Long getid_cuenta_contable() {
		return this.id_cuenta_contable;
	}
    
	
	public Long getid_numero_patronal() {
		return this.id_numero_patronal;
	}
    
	
	public Long getid_tipo_pago__n_m() {
		return this.id_tipo_pago__n_m;
	}
    
	
	public Long getid_cargo_grupo() {
		return this.id_cargo_grupo;
	}
    
	
	public String getcodigo() {
		return this.codigo;
	}
    
	
	public String getnombre() {
		return this.nombre;
	}
    
	
	public Double getvalor_anticipo() {
		return this.valor_anticipo;
	}
    
	
	public Double getporcentaje_anticipo() {
		return this.porcentaje_anticipo;
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
						System.out.println("Cargo:Valor nulo no permitido en columna id_empresa");
					}
				}

				this.id_empresa=newid_empresa;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_cargo(Long newid_cargo)throws Exception
	{
		try {
			if(this.id_cargo!=newid_cargo) {
				if(newid_cargo==null) {
					//newid_cargo=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("Cargo:Valor nulo no permitido en columna id_cargo");
					}
				}

				this.id_cargo=newid_cargo;
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
						System.out.println("Cargo:Valor nulo no permitido en columna id_cuenta_contable");
					}
				}

				this.id_cuenta_contable=newid_cuenta_contable;
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
						System.out.println("Cargo:Valor nulo no permitido en columna id_numero_patronal");
					}
				}

				this.id_numero_patronal=newid_numero_patronal;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_tipo_pago__n_m(Long newid_tipo_pago__n_m)throws Exception
	{
		try {
			if(this.id_tipo_pago__n_m!=newid_tipo_pago__n_m) {
				if(newid_tipo_pago__n_m==null) {
					//newid_tipo_pago__n_m=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("Cargo:Valor nulo no permitido en columna id_tipo_pago__n_m");
					}
				}

				this.id_tipo_pago__n_m=newid_tipo_pago__n_m;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_cargo_grupo(Long newid_cargo_grupo)throws Exception
	{
		try {
			if(this.id_cargo_grupo!=newid_cargo_grupo) {
				if(newid_cargo_grupo==null) {
					//newid_cargo_grupo=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("Cargo:Valor nulo no permitido en columna id_cargo_grupo");
					}
				}

				this.id_cargo_grupo=newid_cargo_grupo;
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
						System.out.println("Cargo:Valor nulo no permitido en columna codigo");
					}
				}

				if(newcodigo!=null&&newcodigo.length()>50) {
					newcodigo=newcodigo.substring(0,48);
					System.out.println("Cargo:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=50 en columna codigo");
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
						System.out.println("Cargo:Valor nulo no permitido en columna nombre");
					}
				}

				if(newnombre!=null&&newnombre.length()>150) {
					newnombre=newnombre.substring(0,148);
					System.out.println("Cargo:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=150 en columna nombre");
				}

				this.nombre=newnombre;
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
						System.out.println("Cargo:Valor nulo no permitido en columna valor_anticipo");
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
						System.out.println("Cargo:Valor nulo no permitido en columna porcentaje_anticipo");
					}
				}

				this.porcentaje_anticipo=newporcentaje_anticipo;
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
						System.out.println("Cargo:Valor nulo no permitido en columna es_jefe");
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
						System.out.println("Cargo:Valor nulo no permitido en columna es_anual");
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
						System.out.println("Cargo:Valor nulo no permitido en columna porcentaje");
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
						System.out.println("Cargo:Valor nulo no permitido en columna valor");
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

	public Cargo getCargo() {
		return this.cargo;
	}

	public CuentaContable getCuentaContable() {
		return this.cuentacontable;
	}

	public NumeroPatronal getNumeroPatronal() {
		return this.numeropatronal;
	}

	public TipoPago_NM getTipoPago_NM() {
		return this.tipopago_nm;
	}

	public CargoGrupo getCargoGrupo() {
		return this.cargogrupo;
	}

	
	
	public String getempresa_descripcion() {
		return this.empresa_descripcion;
	}

	public String getcargo_descripcion() {
		return this.cargo_descripcion;
	}

	public String getcuentacontable_descripcion() {
		return this.cuentacontable_descripcion;
	}

	public String getnumeropatronal_descripcion() {
		return this.numeropatronal_descripcion;
	}

	public String gettipopago_nm_descripcion() {
		return this.tipopago_nm_descripcion;
	}

	public String getcargogrupo_descripcion() {
		return this.cargogrupo_descripcion;
	}

	
	
	public  void  setEmpresa(Empresa empresa) {
		try {
			this.empresa=empresa;
		} catch(Exception e) {
			;
		}
	}


	public  void  setCargo(Cargo cargo) {
		try {
			this.cargo=cargo;
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


	public  void  setNumeroPatronal(NumeroPatronal numeropatronal) {
		try {
			this.numeropatronal=numeropatronal;
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


	public  void  setCargoGrupo(CargoGrupo cargogrupo) {
		try {
			this.cargogrupo=cargogrupo;
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


	public  void  setcargo_descripcion(String cargo_descripcion) {
		try {
			this.cargo_descripcion=cargo_descripcion;
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


	public  void  setnumeropatronal_descripcion(String numeropatronal_descripcion) {
		try {
			this.numeropatronal_descripcion=numeropatronal_descripcion;
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


	public  void  setcargogrupo_descripcion(String cargogrupo_descripcion) {
		try {
			this.cargogrupo_descripcion=cargogrupo_descripcion;
		} catch(Exception e) {
			;
		}
	}


	
	
	public List<AsistenciaMensual> getAsistenciaMensuals() {
		return this.asistenciamensuals;
	}

	public List<EmpleadoEstructura> getEmpleadoEstructuras() {
		return this.empleadoestructuras;
	}

	public List<Empleado> getEmpleados() {
		return this.empleados;
	}

	public List<Cargo> getCargos() {
		return this.cargos;
	}

	
	
	public  void  setAsistenciaMensuals(List<AsistenciaMensual> asistenciamensuals) {
		try {
			this.asistenciamensuals=asistenciamensuals;
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

	public  void  setEmpleados(List<Empleado> empleados) {
		try {
			this.empleados=empleados;
		} catch(Exception e) {
			;
		}
	}

	public  void  setCargos(List<Cargo> cargos) {
		try {
			this.cargos=cargos;
		} catch(Exception e) {
			;
		}
	}

	
	/*PARA REPORTES*/
	String id_empresa_descripcion="";String id_cargo_descripcion="";String id_cuenta_contable_descripcion="";String id_numero_patronal_descripcion="";String id_tipo_pago__n_m_descripcion="";String id_cargo_grupo_descripcion="";String es_jefe_descripcion="";String es_anual_descripcion="";
	
	
	public String getid_empresa_descripcion() {
		return id_empresa_descripcion;
	}
	public String getid_cargo_descripcion() {
		return id_cargo_descripcion;
	}
	public String getid_cuenta_contable_descripcion() {
		return id_cuenta_contable_descripcion;
	}
	public String getid_numero_patronal_descripcion() {
		return id_numero_patronal_descripcion;
	}
	public String getid_tipo_pago__n_m_descripcion() {
		return id_tipo_pago__n_m_descripcion;
	}
	public String getid_cargo_grupo_descripcion() {
		return id_cargo_grupo_descripcion;
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
	public void setid_cargo_descripcion(String newid_cargo_descripcion)throws Exception {
		try {
			this.id_cargo_descripcion=newid_cargo_descripcion;
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
	public void setid_numero_patronal_descripcion(String newid_numero_patronal_descripcion)throws Exception {
		try {
			this.id_numero_patronal_descripcion=newid_numero_patronal_descripcion;
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
	public void setid_cargo_grupo_descripcion(String newid_cargo_grupo_descripcion)throws Exception {
		try {
			this.id_cargo_grupo_descripcion=newid_cargo_grupo_descripcion;
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
		this.id_empresa_descripcion="";this.id_cargo_descripcion="";this.id_cuenta_contable_descripcion="";this.id_numero_patronal_descripcion="";this.id_tipo_pago__n_m_descripcion="";this.id_cargo_grupo_descripcion="";this.es_jefe_descripcion="";this.es_anual_descripcion="";
	}
	
	
	Object asistenciamensualsDescripcionReporte;
	Object empleadoestructurasDescripcionReporte;
	Object empleadosDescripcionReporte;
	Object cargosDescripcionReporte;
	
	
	public Object getasistenciamensualsDescripcionReporte() {
		return asistenciamensualsDescripcionReporte;
	}

	public Object getempleadoestructurasDescripcionReporte() {
		return empleadoestructurasDescripcionReporte;
	}

	public Object getempleadosDescripcionReporte() {
		return empleadosDescripcionReporte;
	}

	public Object getcargosDescripcionReporte() {
		return cargosDescripcionReporte;
	}

	
	
	public  void  setasistenciamensualsDescripcionReporte(Object asistenciamensuals) {
		try {
			this.asistenciamensualsDescripcionReporte=asistenciamensuals;
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

	public  void  setempleadosDescripcionReporte(Object empleados) {
		try {
			this.empleadosDescripcionReporte=empleados;
		} catch(Exception ex) {
			;
		}
	}

	public  void  setcargosDescripcionReporte(Object cargos) {
		try {
			this.cargosDescripcionReporte=cargos;
		} catch(Exception ex) {
			;
		}
	}

	/*PARA REPORTES FIN*/		
}

