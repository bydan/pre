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
//import com.bydan.erp.nomina.util.EmpleadoConstantesFunciones;
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
public class Empleado extends EmpleadoAdditional implements Serializable ,Cloneable {//EmpleadoAdditional,GeneralEntity
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
	
	private Empleado empleadoOriginal;
	
	private Map<String, Object> mapEmpleado;
			
	public Map<String, Object> getMapEmpleado() {
		return mapEmpleado;
	}

	public void setMapEmpleado(Map<String, Object> mapEmpleado) {
		this.mapEmpleado = mapEmpleado;
	}
	
	public void inicializarMapEmpleado() {
		this.mapEmpleado = new HashMap<String,Object>();
	}
	
	public void setMapEmpleadoValue(String sKey,Object oValue) {
		this.mapEmpleado.put(sKey, oValue);
	}
	
	public Object getMapEmpleadoValue(String sKey) {
		return this.mapEmpleado.get(sKey);
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
	private Long id_pais;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_provincia;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_ciudad;
	
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_centro_costo;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_religion;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_estado_civil;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_tipo_genero;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_tipo_empleado;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_tipo_instruccion;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_cargo;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_estructura;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_estructura_seccion;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_estado_empleado;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_tipo_contrato;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=50,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=EmpleadoConstantesFunciones.SREGEXCODIGO,message=EmpleadoConstantesFunciones.SMENSAJEREGEXCODIGO)
	private String codigo;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=150,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=EmpleadoConstantesFunciones.SREGEXNOMBRE,message=EmpleadoConstantesFunciones.SMENSAJEREGEXNOMBRE)
	private String nombre;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=150,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=EmpleadoConstantesFunciones.SREGEXAPELLIDO,message=EmpleadoConstantesFunciones.SMENSAJEREGEXAPELLIDO)
	private String apellido;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=200,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=EmpleadoConstantesFunciones.SREGEXNOMBRE_COMPLETO,message=EmpleadoConstantesFunciones.SMENSAJEREGEXNOMBRE_COMPLETO)
	private String nombre_completo;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=150,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=EmpleadoConstantesFunciones.SREGEXMAIL,message=EmpleadoConstantesFunciones.SMENSAJEREGEXMAIL)
	private String mail;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=200,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=EmpleadoConstantesFunciones.SREGEXDIRECCION,message=EmpleadoConstantesFunciones.SMENSAJEREGEXDIRECCION)
	private String direccion;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double sueldo;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=150,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=EmpleadoConstantesFunciones.SREGEXTELEFONO,message=EmpleadoConstantesFunciones.SMENSAJEREGEXTELEFONO)
	private String telefono;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_tipo_cuenta_banco_global;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=50,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=EmpleadoConstantesFunciones.SREGEXNUMERO_CUENTA,message=EmpleadoConstantesFunciones.SMENSAJEREGEXNUMERO_CUENTA)
	private String numero_cuenta;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Boolean tiene_casa;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Boolean tiene_vehiculo;
			
	
	public Empresa empresa;
	public Sucursal sucursal;
	public Pais pais;
	public Provincia provincia;
	public Ciudad ciudad;
	public CentroCosto centrocosto;
	public Religion religion;
	public EstadoCivil estadocivil;
	public TipoGenero tipogenero;
	public TipoEmpleado tipoempleado;
	public TipoInstruccion tipoinstruccion;
	public Cargo cargo;
	public Estructura estructura;
	public Estructura estructuraseccion;
	public EstadoEmpleado estadoempleado;
	public TipoContrato tipocontrato;
	public TipoCuentaBancoGlobal tipocuentabancoglobal;
	
	
	private String empresa_descripcion;
	private String sucursal_descripcion;
	private String pais_descripcion;
	private String provincia_descripcion;
	private String ciudad_descripcion;
	private String centrocosto_descripcion;
	private String religion_descripcion;
	private String estadocivil_descripcion;
	private String tipogenero_descripcion;
	private String tipoempleado_descripcion;
	private String tipoinstruccion_descripcion;
	private String cargo_descripcion;
	private String estructura_descripcion;
	private String estructuraseccion_descripcion;
	private String estadoempleado_descripcion;
	private String tipocontrato_descripcion;
	private String tipocuentabancoglobal_descripcion;
	
	
	public List<CargaFamiliar_NM> cargafamiliar_nms;
	public List<Curso> cursos;
	public List<Prestamo> prestamos;
	public List<EmpleadoIdioma> empleadoidiomas;
	public List<HistorialPagoMesNomi> historialpagomesnomis;
	public List<EmpleadoImpuestoRenta> empleadoimpuestorentas;
	public DatoGeneralEmpleado datogeneralempleado;
	public List<Area> areas;
	public List<GastoEmpleado> gastoempleados;
	public List<EmpleadoHobby> empleadohobbys;
	public List<EmpleadoEMail> empleadoemails;
	public List<RasgoPersonal> rasgopersonals;
	public List<Referencia> referencias;
	public List<Telefono_NM> telefono_nms;
	public List<Novedad> novedads;
	public List<EmpleadoHerra> empleadoherras;
	public List<EmpleadoEnfer> empleadoenfers;
	public List<Visa> visas;
	public List<Seguro> seguros;
	public List<AsistenciaMensual> asistenciamensuals;
	public List<EmpleadoDisca> empleadodiscas;
	public List<ProfesionEmplea> profesionempleas;
	public List<RubroEmpleado> rubroempleados;
	public List<EmpleadoConstante> empleadoconstantes;
	public List<TallaVestido> tallavestidos;
	public List<NovedadNomi> novedadnomis;
		
	public Empleado () throws Exception {
		super();		
		
		this.id=0L;
		
		
		this.versionRow=new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());//new Date();
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		this.sType="NONE";
		
		this.empleadoOriginal=this;
		
 		this.id_empresa=-1L;
 		this.id_sucursal=-1L;
 		this.id_pais=-1L;
 		this.id_provincia=-1L;
 		this.id_ciudad=-1L;
 		this.id_centro_costo=null;
 		this.id_religion=-1L;
 		this.id_estado_civil=-1L;
 		this.id_tipo_genero=-1L;
 		this.id_tipo_empleado=-1L;
 		this.id_tipo_instruccion=-1L;
 		this.id_cargo=-1L;
 		this.id_estructura=-1L;
 		this.id_estructura_seccion=-1L;
 		this.id_estado_empleado=-1L;
 		this.id_tipo_contrato=-1L;
 		this.codigo="";
 		this.nombre="";
 		this.apellido="";
 		this.nombre_completo="";
 		this.mail="";
 		this.direccion="";
 		this.sueldo=0.0;
 		this.telefono="";
 		this.id_tipo_cuenta_banco_global=-1L;
 		this.numero_cuenta="";
 		this.tiene_casa=false;
 		this.tiene_vehiculo=false;
		
		
		this.empresa=null;
		this.sucursal=null;
		this.pais=null;
		this.provincia=null;
		this.ciudad=null;
		this.centrocosto=null;
		this.religion=null;
		this.estadocivil=null;
		this.tipogenero=null;
		this.tipoempleado=null;
		this.tipoinstruccion=null;
		this.cargo=null;
		this.estructura=null;
		this.estructuraseccion=null;
		this.estadoempleado=null;
		this.tipocontrato=null;
		this.tipocuentabancoglobal=null;
		
		
		this.empresa_descripcion="";
		this.sucursal_descripcion="";
		this.pais_descripcion="";
		this.provincia_descripcion="";
		this.ciudad_descripcion="";
		this.centrocosto_descripcion="";
		this.religion_descripcion="";
		this.estadocivil_descripcion="";
		this.tipogenero_descripcion="";
		this.tipoempleado_descripcion="";
		this.tipoinstruccion_descripcion="";
		this.cargo_descripcion="";
		this.estructura_descripcion="";
		this.estructuraseccion_descripcion="";
		this.estadoempleado_descripcion="";
		this.tipocontrato_descripcion="";
		this.tipocuentabancoglobal_descripcion="";
		
		
		this.cargafamiliar_nms=null;
		this.cursos=null;
		this.prestamos=null;
		this.empleadoidiomas=null;
		this.historialpagomesnomis=null;
		this.empleadoimpuestorentas=null;
		this.areas=null;
		this.gastoempleados=null;
		this.empleadohobbys=null;
		this.empleadoemails=null;
		this.rasgopersonals=null;
		this.referencias=null;
		this.telefono_nms=null;
		this.novedads=null;
		this.empleadoherras=null;
		this.empleadoenfers=null;
		this.visas=null;
		this.seguros=null;
		this.asistenciamensuals=null;
		this.empleadodiscas=null;
		this.profesionempleas=null;
		this.rubroempleados=null;
		this.empleadoconstantes=null;
		this.tallavestidos=null;
		this.novedadnomis=null;
		
			
		
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
    //PARA REPORTES
	public Empleado (Long id,Date versionRow,Long id_empresa,Long id_sucursal,Long id_pais,Long id_provincia,Long id_ciudad,Long id_centro_costo,Long id_religion,Long id_estado_civil,Long id_tipo_genero,Long id_tipo_empleado,Long id_tipo_instruccion,Long id_cargo,Long id_estructura,Long id_estructura_seccion,Long id_estado_empleado,Long id_tipo_contrato,String codigo,String nombre,String apellido,String nombre_completo,String mail,String direccion,Double sueldo,String telefono,Long id_tipo_cuenta_banco_global,String numero_cuenta,Boolean tiene_casa,Boolean tiene_vehiculo) throws Exception {
		super();		
		
		this.id=id;
		this.versionRow=versionRow;
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.empleadoOriginal=this;
		
 		this.id_empresa=id_empresa;
 		this.id_sucursal=id_sucursal;
 		this.id_pais=id_pais;
 		this.id_provincia=id_provincia;
 		this.id_ciudad=id_ciudad;
 		this.id_centro_costo=id_centro_costo;
 		this.id_religion=id_religion;
 		this.id_estado_civil=id_estado_civil;
 		this.id_tipo_genero=id_tipo_genero;
 		this.id_tipo_empleado=id_tipo_empleado;
 		this.id_tipo_instruccion=id_tipo_instruccion;
 		this.id_cargo=id_cargo;
 		this.id_estructura=id_estructura;
 		this.id_estructura_seccion=id_estructura_seccion;
 		this.id_estado_empleado=id_estado_empleado;
 		this.id_tipo_contrato=id_tipo_contrato;
 		this.codigo=codigo;
 		this.nombre=nombre;
 		this.apellido=apellido;
 		this.nombre_completo=nombre_completo;
 		this.mail=mail;
 		this.direccion=direccion;
 		this.sueldo=sueldo;
 		this.telefono=telefono;
 		this.id_tipo_cuenta_banco_global=id_tipo_cuenta_banco_global;
 		this.numero_cuenta=numero_cuenta;
 		this.tiene_casa=tiene_casa;
 		this.tiene_vehiculo=tiene_vehiculo;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	 //PARA REPORTES
	public Empleado (Long id_empresa,Long id_sucursal,Long id_pais,Long id_provincia,Long id_ciudad,Long id_centro_costo,Long id_religion,Long id_estado_civil,Long id_tipo_genero,Long id_tipo_empleado,Long id_tipo_instruccion,Long id_cargo,Long id_estructura,Long id_estructura_seccion,Long id_estado_empleado,Long id_tipo_contrato,String codigo,String nombre,String apellido,String nombre_completo,String mail,String direccion,Double sueldo,String telefono,Long id_tipo_cuenta_banco_global,String numero_cuenta,Boolean tiene_casa,Boolean tiene_vehiculo) throws Exception {
		super();		
		
		this.id=0L;
		this.versionRow=new Date();
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.empleadoOriginal=this;
		
 		this.id_empresa=id_empresa;
 		this.id_sucursal=id_sucursal;
 		this.id_pais=id_pais;
 		this.id_provincia=id_provincia;
 		this.id_ciudad=id_ciudad;
 		this.id_centro_costo=id_centro_costo;
 		this.id_religion=id_religion;
 		this.id_estado_civil=id_estado_civil;
 		this.id_tipo_genero=id_tipo_genero;
 		this.id_tipo_empleado=id_tipo_empleado;
 		this.id_tipo_instruccion=id_tipo_instruccion;
 		this.id_cargo=id_cargo;
 		this.id_estructura=id_estructura;
 		this.id_estructura_seccion=id_estructura_seccion;
 		this.id_estado_empleado=id_estado_empleado;
 		this.id_tipo_contrato=id_tipo_contrato;
 		this.codigo=codigo;
 		this.nombre=nombre;
 		this.apellido=apellido;
 		this.nombre_completo=nombre_completo;
 		this.mail=mail;
 		this.direccion=direccion;
 		this.sueldo=sueldo;
 		this.telefono=telefono;
 		this.id_tipo_cuenta_banco_global=id_tipo_cuenta_banco_global;
 		this.numero_cuenta=numero_cuenta;
 		this.tiene_casa=tiene_casa;
 		this.tiene_vehiculo=tiene_vehiculo;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	public boolean equals(Object object) {
		boolean equal=false;
		Empleado empleadoLocal=null;
		
		if(object!=null) {
			empleadoLocal=(Empleado)object;
			
			if(empleadoLocal!=null) {
				if(this.getId()!=null && empleadoLocal.getId()!=null) {
					if(this.getId().equals(empleadoLocal.getId())) {
						equal=true;
					}
				}
			}
		}
		
		return equal;
	}
	
	public String toString() {
		String sDetalle="";
		
		if(!EmpleadoConstantesFunciones.CON_DESCRIPCION_DETALLADO) {
        	sDetalle=EmpleadoConstantesFunciones.getEmpleadoDescripcion(this);
		} else {
			sDetalle=EmpleadoConstantesFunciones.getEmpleadoDescripcionDetallado(this);
		}
		
		return sDetalle;
    }
	
	public Empleado getEmpleadoOriginal() {
		return this.empleadoOriginal;
	}
	
	public void setEmpleadoOriginal(Empleado empleado) {
		try {
			this.empleadoOriginal=empleado;
		} catch(Exception e) {
			;
		}
	}
	
	
	protected EmpleadoAdditional empleadoAdditional=null;
	
	public EmpleadoAdditional getEmpleadoAdditional() {
		return this.empleadoAdditional;
	}
	
	public void setEmpleadoAdditional(EmpleadoAdditional empleadoAdditional) {
		try {
			this.empleadoAdditional=empleadoAdditional;
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
    
	
	public Long getid_pais() {
		return this.id_pais;
	}
    
	
	public Long getid_provincia() {
		return this.id_provincia;
	}
    
	
	public Long getid_ciudad() {
		return this.id_ciudad;
	}
    
	
	public Long getid_centro_costo() {
		return this.id_centro_costo;
	}
    
	
	public Long getid_religion() {
		return this.id_religion;
	}
    
	
	public Long getid_estado_civil() {
		return this.id_estado_civil;
	}
    
	
	public Long getid_tipo_genero() {
		return this.id_tipo_genero;
	}
    
	
	public Long getid_tipo_empleado() {
		return this.id_tipo_empleado;
	}
    
	
	public Long getid_tipo_instruccion() {
		return this.id_tipo_instruccion;
	}
    
	
	public Long getid_cargo() {
		return this.id_cargo;
	}
    
	
	public Long getid_estructura() {
		return this.id_estructura;
	}
    
	
	public Long getid_estructura_seccion() {
		return this.id_estructura_seccion;
	}
    
	
	public Long getid_estado_empleado() {
		return this.id_estado_empleado;
	}
    
	
	public Long getid_tipo_contrato() {
		return this.id_tipo_contrato;
	}
    
	
	public String getcodigo() {
		return this.codigo;
	}
    
	
	public String getnombre() {
		return this.nombre;
	}
    
	
	public String getapellido() {
		return this.apellido;
	}
    
	
	public String getnombre_completo() {
		return this.nombre_completo;
	}
    
	
	public String getmail() {
		return this.mail;
	}
    
	
	public String getdireccion() {
		return this.direccion;
	}
    
	
	public Double getsueldo() {
		return this.sueldo;
	}
    
	
	public String gettelefono() {
		return this.telefono;
	}
    
	
	public Long getid_tipo_cuenta_banco_global() {
		return this.id_tipo_cuenta_banco_global;
	}
    
	
	public String getnumero_cuenta() {
		return this.numero_cuenta;
	}
    
	
	public Boolean gettiene_casa() {
		return this.tiene_casa;
	}
    
	
	public Boolean gettiene_vehiculo() {
		return this.tiene_vehiculo;
	}
	
    
	public void setid_empresa(Long newid_empresa)throws Exception
	{
		try {
			if(this.id_empresa!=newid_empresa) {
				if(newid_empresa==null) {
					//newid_empresa=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("Empleado:Valor nulo no permitido en columna id_empresa");
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
						System.out.println("Empleado:Valor nulo no permitido en columna id_sucursal");
					}
				}

				this.id_sucursal=newid_sucursal;
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
						System.out.println("Empleado:Valor nulo no permitido en columna id_pais");
					}
				}

				this.id_pais=newid_pais;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_provincia(Long newid_provincia)throws Exception
	{
		try {
			if(this.id_provincia!=newid_provincia) {
				if(newid_provincia==null) {
					//newid_provincia=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("Empleado:Valor nulo no permitido en columna id_provincia");
					}
				}

				this.id_provincia=newid_provincia;
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
						System.out.println("Empleado:Valor nulo no permitido en columna id_ciudad");
					}
				}

				this.id_ciudad=newid_ciudad;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_centro_costo(Long newid_centro_costo) {
		if(this.id_centro_costo==null&&newid_centro_costo!=null) {
			this.id_centro_costo=newid_centro_costo;
				this.setIsChanged(true);
		}

		if(this.id_centro_costo!=null&&!this.id_centro_costo.equals(newid_centro_costo)) {

			this.id_centro_costo=newid_centro_costo;
				this.setIsChanged(true);
		}
	}
    
	public void setid_religion(Long newid_religion)throws Exception
	{
		try {
			if(this.id_religion!=newid_religion) {
				if(newid_religion==null) {
					//newid_religion=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("Empleado:Valor nulo no permitido en columna id_religion");
					}
				}

				this.id_religion=newid_religion;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_estado_civil(Long newid_estado_civil)throws Exception
	{
		try {
			if(this.id_estado_civil!=newid_estado_civil) {
				if(newid_estado_civil==null) {
					//newid_estado_civil=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("Empleado:Valor nulo no permitido en columna id_estado_civil");
					}
				}

				this.id_estado_civil=newid_estado_civil;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_tipo_genero(Long newid_tipo_genero)throws Exception
	{
		try {
			if(this.id_tipo_genero!=newid_tipo_genero) {
				if(newid_tipo_genero==null) {
					//newid_tipo_genero=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("Empleado:Valor nulo no permitido en columna id_tipo_genero");
					}
				}

				this.id_tipo_genero=newid_tipo_genero;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_tipo_empleado(Long newid_tipo_empleado)throws Exception
	{
		try {
			if(this.id_tipo_empleado!=newid_tipo_empleado) {
				if(newid_tipo_empleado==null) {
					//newid_tipo_empleado=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("Empleado:Valor nulo no permitido en columna id_tipo_empleado");
					}
				}

				this.id_tipo_empleado=newid_tipo_empleado;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_tipo_instruccion(Long newid_tipo_instruccion)throws Exception
	{
		try {
			if(this.id_tipo_instruccion!=newid_tipo_instruccion) {
				if(newid_tipo_instruccion==null) {
					//newid_tipo_instruccion=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("Empleado:Valor nulo no permitido en columna id_tipo_instruccion");
					}
				}

				this.id_tipo_instruccion=newid_tipo_instruccion;
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
						System.out.println("Empleado:Valor nulo no permitido en columna id_cargo");
					}
				}

				this.id_cargo=newid_cargo;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_estructura(Long newid_estructura)throws Exception
	{
		try {
			if(this.id_estructura!=newid_estructura) {
				if(newid_estructura==null) {
					//newid_estructura=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("Empleado:Valor nulo no permitido en columna id_estructura");
					}
				}

				this.id_estructura=newid_estructura;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_estructura_seccion(Long newid_estructura_seccion)throws Exception
	{
		try {
			if(this.id_estructura_seccion!=newid_estructura_seccion) {
				if(newid_estructura_seccion==null) {
					//newid_estructura_seccion=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("Empleado:Valor nulo no permitido en columna id_estructura_seccion");
					}
				}

				this.id_estructura_seccion=newid_estructura_seccion;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_estado_empleado(Long newid_estado_empleado)throws Exception
	{
		try {
			if(this.id_estado_empleado!=newid_estado_empleado) {
				if(newid_estado_empleado==null) {
					//newid_estado_empleado=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("Empleado:Valor nulo no permitido en columna id_estado_empleado");
					}
				}

				this.id_estado_empleado=newid_estado_empleado;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_tipo_contrato(Long newid_tipo_contrato)throws Exception
	{
		try {
			if(this.id_tipo_contrato!=newid_tipo_contrato) {
				if(newid_tipo_contrato==null) {
					//newid_tipo_contrato=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("Empleado:Valor nulo no permitido en columna id_tipo_contrato");
					}
				}

				this.id_tipo_contrato=newid_tipo_contrato;
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
						System.out.println("Empleado:Valor nulo no permitido en columna codigo");
					}
				}

				if(newcodigo!=null&&newcodigo.length()>50) {
					newcodigo=newcodigo.substring(0,48);
					System.out.println("Empleado:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=50 en columna codigo");
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
						System.out.println("Empleado:Valor nulo no permitido en columna nombre");
					}
				}

				if(newnombre!=null&&newnombre.length()>150) {
					newnombre=newnombre.substring(0,148);
					System.out.println("Empleado:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=150 en columna nombre");
				}

				this.nombre=newnombre;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setapellido(String newapellido)throws Exception
	{
		try {
			if(this.apellido!=newapellido) {
				if(newapellido==null) {
					//newapellido="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("Empleado:Valor nulo no permitido en columna apellido");
					}
				}

				if(newapellido!=null&&newapellido.length()>150) {
					newapellido=newapellido.substring(0,148);
					System.out.println("Empleado:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=150 en columna apellido");
				}

				this.apellido=newapellido;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setnombre_completo(String newnombre_completo)throws Exception
	{
		try {
			if(this.nombre_completo!=newnombre_completo) {
				if(newnombre_completo==null) {
					//newnombre_completo="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("Empleado:Valor nulo no permitido en columna nombre_completo");
					}
				}

				if(newnombre_completo!=null&&newnombre_completo.length()>200) {
					newnombre_completo=newnombre_completo.substring(0,198);
					System.out.println("Empleado:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=200 en columna nombre_completo");
				}

				this.nombre_completo=newnombre_completo;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setmail(String newmail)throws Exception
	{
		try {
			if(this.mail!=newmail) {
				if(newmail==null) {
					//newmail="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("Empleado:Valor nulo no permitido en columna mail");
					}
				}

				if(newmail!=null&&newmail.length()>150) {
					newmail=newmail.substring(0,148);
					System.out.println("Empleado:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=150 en columna mail");
				}

				this.mail=newmail;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setdireccion(String newdireccion)throws Exception
	{
		try {
			if(this.direccion!=newdireccion) {
				if(newdireccion==null) {
					//newdireccion="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("Empleado:Valor nulo no permitido en columna direccion");
					}
				}

				if(newdireccion!=null&&newdireccion.length()>200) {
					newdireccion=newdireccion.substring(0,198);
					System.out.println("Empleado:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=200 en columna direccion");
				}

				this.direccion=newdireccion;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setsueldo(Double newsueldo)throws Exception
	{
		try {
			if(this.sueldo!=newsueldo) {
				if(newsueldo==null) {
					//newsueldo=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("Empleado:Valor nulo no permitido en columna sueldo");
					}
				}

				this.sueldo=newsueldo;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void settelefono(String newtelefono)throws Exception
	{
		try {
			if(this.telefono!=newtelefono) {
				if(newtelefono==null) {
					//newtelefono="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("Empleado:Valor nulo no permitido en columna telefono");
					}
				}

				if(newtelefono!=null&&newtelefono.length()>150) {
					newtelefono=newtelefono.substring(0,148);
					System.out.println("Empleado:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=150 en columna telefono");
				}

				this.telefono=newtelefono;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_tipo_cuenta_banco_global(Long newid_tipo_cuenta_banco_global)throws Exception
	{
		try {
			if(this.id_tipo_cuenta_banco_global!=newid_tipo_cuenta_banco_global) {
				if(newid_tipo_cuenta_banco_global==null) {
					//newid_tipo_cuenta_banco_global=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("Empleado:Valor nulo no permitido en columna id_tipo_cuenta_banco_global");
					}
				}

				this.id_tipo_cuenta_banco_global=newid_tipo_cuenta_banco_global;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setnumero_cuenta(String newnumero_cuenta)throws Exception
	{
		try {
			if(this.numero_cuenta!=newnumero_cuenta) {
				if(newnumero_cuenta==null) {
					//newnumero_cuenta="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("Empleado:Valor nulo no permitido en columna numero_cuenta");
					}
				}

				if(newnumero_cuenta!=null&&newnumero_cuenta.length()>50) {
					newnumero_cuenta=newnumero_cuenta.substring(0,48);
					System.out.println("Empleado:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=50 en columna numero_cuenta");
				}

				this.numero_cuenta=newnumero_cuenta;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void settiene_casa(Boolean newtiene_casa)throws Exception
	{
		try {
			if(this.tiene_casa!=newtiene_casa) {
				if(newtiene_casa==null) {
					//newtiene_casa=false;
					if(Constantes.ISDEVELOPING) {
						System.out.println("Empleado:Valor nulo no permitido en columna tiene_casa");
					}
				}

				this.tiene_casa=newtiene_casa;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void settiene_vehiculo(Boolean newtiene_vehiculo)throws Exception
	{
		try {
			if(this.tiene_vehiculo!=newtiene_vehiculo) {
				if(newtiene_vehiculo==null) {
					//newtiene_vehiculo=false;
					if(Constantes.ISDEVELOPING) {
						System.out.println("Empleado:Valor nulo no permitido en columna tiene_vehiculo");
					}
				}

				this.tiene_vehiculo=newtiene_vehiculo;
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

	public Pais getPais() {
		return this.pais;
	}

	public Provincia getProvincia() {
		return this.provincia;
	}

	public Ciudad getCiudad() {
		return this.ciudad;
	}

	public CentroCosto getCentroCosto() {
		return this.centrocosto;
	}

	public Religion getReligion() {
		return this.religion;
	}

	public EstadoCivil getEstadoCivil() {
		return this.estadocivil;
	}

	public TipoGenero getTipoGenero() {
		return this.tipogenero;
	}

	public TipoEmpleado getTipoEmpleado() {
		return this.tipoempleado;
	}

	public TipoInstruccion getTipoInstruccion() {
		return this.tipoinstruccion;
	}

	public Cargo getCargo() {
		return this.cargo;
	}

	public Estructura getEstructura() {
		return this.estructura;
	}

	public Estructura getEstructuraSeccion() {
		return this.estructuraseccion;
	}

	public EstadoEmpleado getEstadoEmpleado() {
		return this.estadoempleado;
	}

	public TipoContrato getTipoContrato() {
		return this.tipocontrato;
	}

	public TipoCuentaBancoGlobal getTipoCuentaBancoGlobal() {
		return this.tipocuentabancoglobal;
	}

	
	
	public String getempresa_descripcion() {
		return this.empresa_descripcion;
	}

	public String getsucursal_descripcion() {
		return this.sucursal_descripcion;
	}

	public String getpais_descripcion() {
		return this.pais_descripcion;
	}

	public String getprovincia_descripcion() {
		return this.provincia_descripcion;
	}

	public String getciudad_descripcion() {
		return this.ciudad_descripcion;
	}

	public String getcentrocosto_descripcion() {
		return this.centrocosto_descripcion;
	}

	public String getreligion_descripcion() {
		return this.religion_descripcion;
	}

	public String getestadocivil_descripcion() {
		return this.estadocivil_descripcion;
	}

	public String gettipogenero_descripcion() {
		return this.tipogenero_descripcion;
	}

	public String gettipoempleado_descripcion() {
		return this.tipoempleado_descripcion;
	}

	public String gettipoinstruccion_descripcion() {
		return this.tipoinstruccion_descripcion;
	}

	public String getcargo_descripcion() {
		return this.cargo_descripcion;
	}

	public String getestructura_descripcion() {
		return this.estructura_descripcion;
	}

	public String getestructuraseccion_descripcion() {
		return this.estructuraseccion_descripcion;
	}

	public String getestadoempleado_descripcion() {
		return this.estadoempleado_descripcion;
	}

	public String gettipocontrato_descripcion() {
		return this.tipocontrato_descripcion;
	}

	public String gettipocuentabancoglobal_descripcion() {
		return this.tipocuentabancoglobal_descripcion;
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


	public  void  setPais(Pais pais) {
		try {
			this.pais=pais;
		} catch(Exception e) {
			;
		}
	}


	public  void  setProvincia(Provincia provincia) {
		try {
			this.provincia=provincia;
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


	public  void  setCentroCosto(CentroCosto centrocosto) {
		try {
			this.centrocosto=centrocosto;
		} catch(Exception e) {
			;
		}
	}


	public  void  setReligion(Religion religion) {
		try {
			this.religion=religion;
		} catch(Exception e) {
			;
		}
	}


	public  void  setEstadoCivil(EstadoCivil estadocivil) {
		try {
			this.estadocivil=estadocivil;
		} catch(Exception e) {
			;
		}
	}


	public  void  setTipoGenero(TipoGenero tipogenero) {
		try {
			this.tipogenero=tipogenero;
		} catch(Exception e) {
			;
		}
	}


	public  void  setTipoEmpleado(TipoEmpleado tipoempleado) {
		try {
			this.tipoempleado=tipoempleado;
		} catch(Exception e) {
			;
		}
	}


	public  void  setTipoInstruccion(TipoInstruccion tipoinstruccion) {
		try {
			this.tipoinstruccion=tipoinstruccion;
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


	public  void  setEstructura(Estructura estructura) {
		try {
			this.estructura=estructura;
		} catch(Exception e) {
			;
		}
	}


	public  void  setEstructuraSeccion(Estructura estructuraseccion) {
		try {
			this.estructuraseccion=estructuraseccion;
		} catch(Exception e) {
			;
		}
	}


	public  void  setEstadoEmpleado(EstadoEmpleado estadoempleado) {
		try {
			this.estadoempleado=estadoempleado;
		} catch(Exception e) {
			;
		}
	}


	public  void  setTipoContrato(TipoContrato tipocontrato) {
		try {
			this.tipocontrato=tipocontrato;
		} catch(Exception e) {
			;
		}
	}


	public  void  setTipoCuentaBancoGlobal(TipoCuentaBancoGlobal tipocuentabancoglobal) {
		try {
			this.tipocuentabancoglobal=tipocuentabancoglobal;
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


	public  void  setpais_descripcion(String pais_descripcion) {
		try {
			this.pais_descripcion=pais_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  setprovincia_descripcion(String provincia_descripcion) {
		try {
			this.provincia_descripcion=provincia_descripcion;
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


	public  void  setcentrocosto_descripcion(String centrocosto_descripcion) {
		try {
			this.centrocosto_descripcion=centrocosto_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  setreligion_descripcion(String religion_descripcion) {
		try {
			this.religion_descripcion=religion_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  setestadocivil_descripcion(String estadocivil_descripcion) {
		try {
			this.estadocivil_descripcion=estadocivil_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  settipogenero_descripcion(String tipogenero_descripcion) {
		try {
			this.tipogenero_descripcion=tipogenero_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  settipoempleado_descripcion(String tipoempleado_descripcion) {
		try {
			this.tipoempleado_descripcion=tipoempleado_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  settipoinstruccion_descripcion(String tipoinstruccion_descripcion) {
		try {
			this.tipoinstruccion_descripcion=tipoinstruccion_descripcion;
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


	public  void  setestructura_descripcion(String estructura_descripcion) {
		try {
			this.estructura_descripcion=estructura_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  setestructuraseccion_descripcion(String estructuraseccion_descripcion) {
		try {
			this.estructuraseccion_descripcion=estructuraseccion_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  setestadoempleado_descripcion(String estadoempleado_descripcion) {
		try {
			this.estadoempleado_descripcion=estadoempleado_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  settipocontrato_descripcion(String tipocontrato_descripcion) {
		try {
			this.tipocontrato_descripcion=tipocontrato_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  settipocuentabancoglobal_descripcion(String tipocuentabancoglobal_descripcion) {
		try {
			this.tipocuentabancoglobal_descripcion=tipocuentabancoglobal_descripcion;
		} catch(Exception e) {
			;
		}
	}


	
	
	public List<CargaFamiliar_NM> getCargaFamiliar_NMs() {
		return this.cargafamiliar_nms;
	}

	public List<Curso> getCursos() {
		return this.cursos;
	}

	public List<Prestamo> getPrestamos() {
		return this.prestamos;
	}

	public List<EmpleadoIdioma> getEmpleadoIdiomas() {
		return this.empleadoidiomas;
	}

	public List<HistorialPagoMesNomi> getHistorialPagoMesNomis() {
		return this.historialpagomesnomis;
	}

	public List<EmpleadoImpuestoRenta> getEmpleadoImpuestoRentas() {
		return this.empleadoimpuestorentas;
	}

	public DatoGeneralEmpleado getDatoGeneralEmpleado() {
		return this.datogeneralempleado;
	}

	public List<Area> getAreas() {
		return this.areas;
	}

	public List<GastoEmpleado> getGastoEmpleados() {
		return this.gastoempleados;
	}

	public List<EmpleadoHobby> getEmpleadoHobbys() {
		return this.empleadohobbys;
	}

	public List<EmpleadoEMail> getEmpleadoEMails() {
		return this.empleadoemails;
	}

	public List<RasgoPersonal> getRasgoPersonals() {
		return this.rasgopersonals;
	}

	public List<Referencia> getReferencias() {
		return this.referencias;
	}

	public List<Telefono_NM> getTelefono_NMs() {
		return this.telefono_nms;
	}

	public List<Novedad> getNovedads() {
		return this.novedads;
	}

	public List<EmpleadoHerra> getEmpleadoHerras() {
		return this.empleadoherras;
	}

	public List<EmpleadoEnfer> getEmpleadoEnfers() {
		return this.empleadoenfers;
	}

	public List<Visa> getVisas() {
		return this.visas;
	}

	public List<Seguro> getSeguros() {
		return this.seguros;
	}

	public List<AsistenciaMensual> getAsistenciaMensuals() {
		return this.asistenciamensuals;
	}

	public List<EmpleadoDisca> getEmpleadoDiscas() {
		return this.empleadodiscas;
	}

	public List<ProfesionEmplea> getProfesionEmpleas() {
		return this.profesionempleas;
	}

	public List<RubroEmpleado> getRubroEmpleados() {
		return this.rubroempleados;
	}

	public List<EmpleadoConstante> getEmpleadoConstantes() {
		return this.empleadoconstantes;
	}

	public List<TallaVestido> getTallaVestidos() {
		return this.tallavestidos;
	}

	public List<NovedadNomi> getNovedadNomis() {
		return this.novedadnomis;
	}

	
	
	public  void  setCargaFamiliar_NMs(List<CargaFamiliar_NM> cargafamiliar_nms) {
		try {
			this.cargafamiliar_nms=cargafamiliar_nms;
		} catch(Exception e) {
			;
		}
	}

	public  void  setCursos(List<Curso> cursos) {
		try {
			this.cursos=cursos;
		} catch(Exception e) {
			;
		}
	}

	public  void  setPrestamos(List<Prestamo> prestamos) {
		try {
			this.prestamos=prestamos;
		} catch(Exception e) {
			;
		}
	}

	public  void  setEmpleadoIdiomas(List<EmpleadoIdioma> empleadoidiomas) {
		try {
			this.empleadoidiomas=empleadoidiomas;
		} catch(Exception e) {
			;
		}
	}

	public  void  setHistorialPagoMesNomis(List<HistorialPagoMesNomi> historialpagomesnomis) {
		try {
			this.historialpagomesnomis=historialpagomesnomis;
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

	public  void  setDatoGeneralEmpleado(DatoGeneralEmpleado datogeneralempleado) {
	try {
			this.datogeneralempleado=datogeneralempleado;
		} catch(Exception e) {
			;
		}
	}

	public  void  setAreas(List<Area> areas) {
		try {
			this.areas=areas;
		} catch(Exception e) {
			;
		}
	}

	public  void  setGastoEmpleados(List<GastoEmpleado> gastoempleados) {
		try {
			this.gastoempleados=gastoempleados;
		} catch(Exception e) {
			;
		}
	}

	public  void  setEmpleadoHobbys(List<EmpleadoHobby> empleadohobbys) {
		try {
			this.empleadohobbys=empleadohobbys;
		} catch(Exception e) {
			;
		}
	}

	public  void  setEmpleadoEMails(List<EmpleadoEMail> empleadoemails) {
		try {
			this.empleadoemails=empleadoemails;
		} catch(Exception e) {
			;
		}
	}

	public  void  setRasgoPersonals(List<RasgoPersonal> rasgopersonals) {
		try {
			this.rasgopersonals=rasgopersonals;
		} catch(Exception e) {
			;
		}
	}

	public  void  setReferencias(List<Referencia> referencias) {
		try {
			this.referencias=referencias;
		} catch(Exception e) {
			;
		}
	}

	public  void  setTelefono_NMs(List<Telefono_NM> telefono_nms) {
		try {
			this.telefono_nms=telefono_nms;
		} catch(Exception e) {
			;
		}
	}

	public  void  setNovedads(List<Novedad> novedads) {
		try {
			this.novedads=novedads;
		} catch(Exception e) {
			;
		}
	}

	public  void  setEmpleadoHerras(List<EmpleadoHerra> empleadoherras) {
		try {
			this.empleadoherras=empleadoherras;
		} catch(Exception e) {
			;
		}
	}

	public  void  setEmpleadoEnfers(List<EmpleadoEnfer> empleadoenfers) {
		try {
			this.empleadoenfers=empleadoenfers;
		} catch(Exception e) {
			;
		}
	}

	public  void  setVisas(List<Visa> visas) {
		try {
			this.visas=visas;
		} catch(Exception e) {
			;
		}
	}

	public  void  setSeguros(List<Seguro> seguros) {
		try {
			this.seguros=seguros;
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

	public  void  setEmpleadoDiscas(List<EmpleadoDisca> empleadodiscas) {
		try {
			this.empleadodiscas=empleadodiscas;
		} catch(Exception e) {
			;
		}
	}

	public  void  setProfesionEmpleas(List<ProfesionEmplea> profesionempleas) {
		try {
			this.profesionempleas=profesionempleas;
		} catch(Exception e) {
			;
		}
	}

	public  void  setRubroEmpleados(List<RubroEmpleado> rubroempleados) {
		try {
			this.rubroempleados=rubroempleados;
		} catch(Exception e) {
			;
		}
	}

	public  void  setEmpleadoConstantes(List<EmpleadoConstante> empleadoconstantes) {
		try {
			this.empleadoconstantes=empleadoconstantes;
		} catch(Exception e) {
			;
		}
	}

	public  void  setTallaVestidos(List<TallaVestido> tallavestidos) {
		try {
			this.tallavestidos=tallavestidos;
		} catch(Exception e) {
			;
		}
	}

	public  void  setNovedadNomis(List<NovedadNomi> novedadnomis) {
		try {
			this.novedadnomis=novedadnomis;
		} catch(Exception e) {
			;
		}
	}

	
	/*PARA REPORTES*/
	String id_empresa_descripcion="";String id_sucursal_descripcion="";String id_pais_descripcion="";String id_provincia_descripcion="";String id_ciudad_descripcion="";String id_centro_costo_descripcion="";String id_religion_descripcion="";String id_estado_civil_descripcion="";String id_tipo_genero_descripcion="";String id_tipo_empleado_descripcion="";String id_tipo_instruccion_descripcion="";String id_cargo_descripcion="";String id_estructura_descripcion="";String id_estructura_seccion_descripcion="";String id_estado_empleado_descripcion="";String id_tipo_contrato_descripcion="";String id_tipo_cuenta_banco_global_descripcion="";String tiene_casa_descripcion="";String tiene_vehiculo_descripcion="";
	
	
	public String getid_empresa_descripcion() {
		return id_empresa_descripcion;
	}
	public String getid_sucursal_descripcion() {
		return id_sucursal_descripcion;
	}
	public String getid_pais_descripcion() {
		return id_pais_descripcion;
	}
	public String getid_provincia_descripcion() {
		return id_provincia_descripcion;
	}
	public String getid_ciudad_descripcion() {
		return id_ciudad_descripcion;
	}
	public String getid_centro_costo_descripcion() {
		return id_centro_costo_descripcion;
	}
	public String getid_religion_descripcion() {
		return id_religion_descripcion;
	}
	public String getid_estado_civil_descripcion() {
		return id_estado_civil_descripcion;
	}
	public String getid_tipo_genero_descripcion() {
		return id_tipo_genero_descripcion;
	}
	public String getid_tipo_empleado_descripcion() {
		return id_tipo_empleado_descripcion;
	}
	public String getid_tipo_instruccion_descripcion() {
		return id_tipo_instruccion_descripcion;
	}
	public String getid_cargo_descripcion() {
		return id_cargo_descripcion;
	}
	public String getid_estructura_descripcion() {
		return id_estructura_descripcion;
	}
	public String getid_estructura_seccion_descripcion() {
		return id_estructura_seccion_descripcion;
	}
	public String getid_estado_empleado_descripcion() {
		return id_estado_empleado_descripcion;
	}
	public String getid_tipo_contrato_descripcion() {
		return id_tipo_contrato_descripcion;
	}
	public String getid_tipo_cuenta_banco_global_descripcion() {
		return id_tipo_cuenta_banco_global_descripcion;
	}
	public String gettiene_casa_descripcion() {
		return tiene_casa_descripcion;
	}
	public String gettiene_vehiculo_descripcion() {
		return tiene_vehiculo_descripcion;
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
	public void setid_pais_descripcion(String newid_pais_descripcion)throws Exception {
		try {
			this.id_pais_descripcion=newid_pais_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_provincia_descripcion(String newid_provincia_descripcion)throws Exception {
		try {
			this.id_provincia_descripcion=newid_provincia_descripcion;
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
	public void setid_centro_costo_descripcion(String newid_centro_costo_descripcion)throws Exception {
		try {
			this.id_centro_costo_descripcion=newid_centro_costo_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_religion_descripcion(String newid_religion_descripcion)throws Exception {
		try {
			this.id_religion_descripcion=newid_religion_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_estado_civil_descripcion(String newid_estado_civil_descripcion)throws Exception {
		try {
			this.id_estado_civil_descripcion=newid_estado_civil_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_tipo_genero_descripcion(String newid_tipo_genero_descripcion)throws Exception {
		try {
			this.id_tipo_genero_descripcion=newid_tipo_genero_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_tipo_empleado_descripcion(String newid_tipo_empleado_descripcion)throws Exception {
		try {
			this.id_tipo_empleado_descripcion=newid_tipo_empleado_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_tipo_instruccion_descripcion(String newid_tipo_instruccion_descripcion)throws Exception {
		try {
			this.id_tipo_instruccion_descripcion=newid_tipo_instruccion_descripcion;
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
	public void setid_estructura_descripcion(String newid_estructura_descripcion)throws Exception {
		try {
			this.id_estructura_descripcion=newid_estructura_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_estructura_seccion_descripcion(String newid_estructura_seccion_descripcion)throws Exception {
		try {
			this.id_estructura_seccion_descripcion=newid_estructura_seccion_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_estado_empleado_descripcion(String newid_estado_empleado_descripcion)throws Exception {
		try {
			this.id_estado_empleado_descripcion=newid_estado_empleado_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_tipo_contrato_descripcion(String newid_tipo_contrato_descripcion)throws Exception {
		try {
			this.id_tipo_contrato_descripcion=newid_tipo_contrato_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_tipo_cuenta_banco_global_descripcion(String newid_tipo_cuenta_banco_global_descripcion)throws Exception {
		try {
			this.id_tipo_cuenta_banco_global_descripcion=newid_tipo_cuenta_banco_global_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void settiene_casa_descripcion(String newtiene_casa_descripcion)throws Exception {
		try {
			this.tiene_casa_descripcion=newtiene_casa_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void settiene_vehiculo_descripcion(String newtiene_vehiculo_descripcion)throws Exception {
		try {
			this.tiene_vehiculo_descripcion=newtiene_vehiculo_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	
	public void inicializarVariablesParaReporte() {
		this.id_empresa_descripcion="";this.id_sucursal_descripcion="";this.id_pais_descripcion="";this.id_provincia_descripcion="";this.id_ciudad_descripcion="";this.id_centro_costo_descripcion="";this.id_religion_descripcion="";this.id_estado_civil_descripcion="";this.id_tipo_genero_descripcion="";this.id_tipo_empleado_descripcion="";this.id_tipo_instruccion_descripcion="";this.id_cargo_descripcion="";this.id_estructura_descripcion="";this.id_estructura_seccion_descripcion="";this.id_estado_empleado_descripcion="";this.id_tipo_contrato_descripcion="";this.id_tipo_cuenta_banco_global_descripcion="";this.tiene_casa_descripcion="";this.tiene_vehiculo_descripcion="";
	}
	
	
	Object cargafamiliar_nmsDescripcionReporte;
	Object cursosDescripcionReporte;
	Object prestamosDescripcionReporte;
	Object empleadoidiomasDescripcionReporte;
	Object historialpagomesnomisDescripcionReporte;
	Object empleadoimpuestorentasDescripcionReporte;
	Object DatoGeneralEmpleadoDescripcionReporte;
	Object areasDescripcionReporte;
	Object gastoempleadosDescripcionReporte;
	Object empleadohobbysDescripcionReporte;
	Object empleadoemailsDescripcionReporte;
	Object rasgopersonalsDescripcionReporte;
	Object referenciasDescripcionReporte;
	Object telefono_nmsDescripcionReporte;
	Object novedadsDescripcionReporte;
	Object empleadoherrasDescripcionReporte;
	Object empleadoenfersDescripcionReporte;
	Object visasDescripcionReporte;
	Object segurosDescripcionReporte;
	Object asistenciamensualsDescripcionReporte;
	Object empleadodiscasDescripcionReporte;
	Object profesionempleasDescripcionReporte;
	Object rubroempleadosDescripcionReporte;
	Object empleadoconstantesDescripcionReporte;
	Object tallavestidosDescripcionReporte;
	Object novedadnomisDescripcionReporte;
	
	
	public Object getcargafamiliar_nmsDescripcionReporte() {
		return cargafamiliar_nmsDescripcionReporte;
	}

	public Object getcursosDescripcionReporte() {
		return cursosDescripcionReporte;
	}

	public Object getprestamosDescripcionReporte() {
		return prestamosDescripcionReporte;
	}

	public Object getempleadoidiomasDescripcionReporte() {
		return empleadoidiomasDescripcionReporte;
	}

	public Object gethistorialpagomesnomisDescripcionReporte() {
		return historialpagomesnomisDescripcionReporte;
	}

	public Object getempleadoimpuestorentasDescripcionReporte() {
		return empleadoimpuestorentasDescripcionReporte;
	}

	public Object getDatoGeneralEmpleadoDescripcionReporte()
	{
		return DatoGeneralEmpleadoDescripcionReporte;
	}

	public Object getareasDescripcionReporte() {
		return areasDescripcionReporte;
	}

	public Object getgastoempleadosDescripcionReporte() {
		return gastoempleadosDescripcionReporte;
	}

	public Object getempleadohobbysDescripcionReporte() {
		return empleadohobbysDescripcionReporte;
	}

	public Object getempleadoemailsDescripcionReporte() {
		return empleadoemailsDescripcionReporte;
	}

	public Object getrasgopersonalsDescripcionReporte() {
		return rasgopersonalsDescripcionReporte;
	}

	public Object getreferenciasDescripcionReporte() {
		return referenciasDescripcionReporte;
	}

	public Object gettelefono_nmsDescripcionReporte() {
		return telefono_nmsDescripcionReporte;
	}

	public Object getnovedadsDescripcionReporte() {
		return novedadsDescripcionReporte;
	}

	public Object getempleadoherrasDescripcionReporte() {
		return empleadoherrasDescripcionReporte;
	}

	public Object getempleadoenfersDescripcionReporte() {
		return empleadoenfersDescripcionReporte;
	}

	public Object getvisasDescripcionReporte() {
		return visasDescripcionReporte;
	}

	public Object getsegurosDescripcionReporte() {
		return segurosDescripcionReporte;
	}

	public Object getasistenciamensualsDescripcionReporte() {
		return asistenciamensualsDescripcionReporte;
	}

	public Object getempleadodiscasDescripcionReporte() {
		return empleadodiscasDescripcionReporte;
	}

	public Object getprofesionempleasDescripcionReporte() {
		return profesionempleasDescripcionReporte;
	}

	public Object getrubroempleadosDescripcionReporte() {
		return rubroempleadosDescripcionReporte;
	}

	public Object getempleadoconstantesDescripcionReporte() {
		return empleadoconstantesDescripcionReporte;
	}

	public Object gettallavestidosDescripcionReporte() {
		return tallavestidosDescripcionReporte;
	}

	public Object getnovedadnomisDescripcionReporte() {
		return novedadnomisDescripcionReporte;
	}

	
	
	public  void  setcargafamiliar_nmsDescripcionReporte(Object cargafamiliar_nms) {
		try {
			this.cargafamiliar_nmsDescripcionReporte=cargafamiliar_nms;
		} catch(Exception ex) {
			;
		}
	}

	public  void  setcursosDescripcionReporte(Object cursos) {
		try {
			this.cursosDescripcionReporte=cursos;
		} catch(Exception ex) {
			;
		}
	}

	public  void  setprestamosDescripcionReporte(Object prestamos) {
		try {
			this.prestamosDescripcionReporte=prestamos;
		} catch(Exception ex) {
			;
		}
	}

	public  void  setempleadoidiomasDescripcionReporte(Object empleadoidiomas) {
		try {
			this.empleadoidiomasDescripcionReporte=empleadoidiomas;
		} catch(Exception ex) {
			;
		}
	}

	public  void  sethistorialpagomesnomisDescripcionReporte(Object historialpagomesnomis) {
		try {
			this.historialpagomesnomisDescripcionReporte=historialpagomesnomis;
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

	public  void  setDatoGeneralEmpleadoDescripcionReporte(Object datogeneralempleado) {
	try {
			this.DatoGeneralEmpleadoDescripcionReporte=datogeneralempleado;
		} catch(Exception ex) {
			;
		}
	}

	public  void  setareasDescripcionReporte(Object areas) {
		try {
			this.areasDescripcionReporte=areas;
		} catch(Exception ex) {
			;
		}
	}

	public  void  setgastoempleadosDescripcionReporte(Object gastoempleados) {
		try {
			this.gastoempleadosDescripcionReporte=gastoempleados;
		} catch(Exception ex) {
			;
		}
	}

	public  void  setempleadohobbysDescripcionReporte(Object empleadohobbys) {
		try {
			this.empleadohobbysDescripcionReporte=empleadohobbys;
		} catch(Exception ex) {
			;
		}
	}

	public  void  setempleadoemailsDescripcionReporte(Object empleadoemails) {
		try {
			this.empleadoemailsDescripcionReporte=empleadoemails;
		} catch(Exception ex) {
			;
		}
	}

	public  void  setrasgopersonalsDescripcionReporte(Object rasgopersonals) {
		try {
			this.rasgopersonalsDescripcionReporte=rasgopersonals;
		} catch(Exception ex) {
			;
		}
	}

	public  void  setreferenciasDescripcionReporte(Object referencias) {
		try {
			this.referenciasDescripcionReporte=referencias;
		} catch(Exception ex) {
			;
		}
	}

	public  void  settelefono_nmsDescripcionReporte(Object telefono_nms) {
		try {
			this.telefono_nmsDescripcionReporte=telefono_nms;
		} catch(Exception ex) {
			;
		}
	}

	public  void  setnovedadsDescripcionReporte(Object novedads) {
		try {
			this.novedadsDescripcionReporte=novedads;
		} catch(Exception ex) {
			;
		}
	}

	public  void  setempleadoherrasDescripcionReporte(Object empleadoherras) {
		try {
			this.empleadoherrasDescripcionReporte=empleadoherras;
		} catch(Exception ex) {
			;
		}
	}

	public  void  setempleadoenfersDescripcionReporte(Object empleadoenfers) {
		try {
			this.empleadoenfersDescripcionReporte=empleadoenfers;
		} catch(Exception ex) {
			;
		}
	}

	public  void  setvisasDescripcionReporte(Object visas) {
		try {
			this.visasDescripcionReporte=visas;
		} catch(Exception ex) {
			;
		}
	}

	public  void  setsegurosDescripcionReporte(Object seguros) {
		try {
			this.segurosDescripcionReporte=seguros;
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

	public  void  setempleadodiscasDescripcionReporte(Object empleadodiscas) {
		try {
			this.empleadodiscasDescripcionReporte=empleadodiscas;
		} catch(Exception ex) {
			;
		}
	}

	public  void  setprofesionempleasDescripcionReporte(Object profesionempleas) {
		try {
			this.profesionempleasDescripcionReporte=profesionempleas;
		} catch(Exception ex) {
			;
		}
	}

	public  void  setrubroempleadosDescripcionReporte(Object rubroempleados) {
		try {
			this.rubroempleadosDescripcionReporte=rubroempleados;
		} catch(Exception ex) {
			;
		}
	}

	public  void  setempleadoconstantesDescripcionReporte(Object empleadoconstantes) {
		try {
			this.empleadoconstantesDescripcionReporte=empleadoconstantes;
		} catch(Exception ex) {
			;
		}
	}

	public  void  settallavestidosDescripcionReporte(Object tallavestidos) {
		try {
			this.tallavestidosDescripcionReporte=tallavestidos;
		} catch(Exception ex) {
			;
		}
	}

	public  void  setnovedadnomisDescripcionReporte(Object novedadnomis) {
		try {
			this.novedadnomisDescripcionReporte=novedadnomis;
		} catch(Exception ex) {
			;
		}
	}

	/*PARA REPORTES FIN*/		
}

