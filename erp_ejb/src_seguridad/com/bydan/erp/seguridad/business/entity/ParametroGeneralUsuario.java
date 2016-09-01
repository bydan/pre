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
package com.bydan.erp.seguridad.business.entity;

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
//import com.bydan.erp.seguridad.util.ParametroGeneralUsuarioConstantesFunciones;
import com.bydan.erp.seguridad.util.*;


import com.bydan.erp.contabilidad.util.*;



import com.bydan.erp.contabilidad.business.entity.*;




@SuppressWarnings("unused")
public class ParametroGeneralUsuario extends ParametroGeneralUsuarioAdditional implements Serializable ,Cloneable {//ParametroGeneralUsuarioAdditional,GeneralEntity
	private static final long serialVersionUID=1L;
	
	public Object clone() {
        return super.clone();
    }
	
	protected Long id;
	protected Long idOriginal;
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
	
	public Long getIdOriginal() {
		return this.idOriginal;
	}
	
	public void setIdOriginal(Long newIdOriginal) {		
		this.idOriginal=newIdOriginal;
		super.setIdOriginal(newIdOriginal);
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
	
	private ParametroGeneralUsuario parametrogeneralusuarioOriginal;
	
	private Map<String, Object> mapParametroGeneralUsuario;
			
	public Map<String, Object> getMapParametroGeneralUsuario() {
		return mapParametroGeneralUsuario;
	}

	public void setMapParametroGeneralUsuario(Map<String, Object> mapParametroGeneralUsuario) {
		this.mapParametroGeneralUsuario = mapParametroGeneralUsuario;
	}
	
	public void inicializarMapParametroGeneralUsuario() {
		this.mapParametroGeneralUsuario = new HashMap<String,Object>();
	}
	
	public void setMapParametroGeneralUsuarioValue(String sKey,Object oValue) {
		this.mapParametroGeneralUsuario.put(sKey, oValue);
	}
	
	public Object getMapParametroGeneralUsuarioValue(String sKey) {
		return this.mapParametroGeneralUsuario.get(sKey);
	}
	
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_usuario;
	
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
	private Long id_ejercicio;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_periodo;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_moneda;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Date fecha_sistema;
	
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_anio;
	
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_mes;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=10,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONINT)
	private Integer dia;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_tipo_visual;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_tipo_fondo;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_tipo_fondo_borde;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_tipo_fondo_control;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_tipo_fuente;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_tipo_tamanio_control_normal;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_tipo_tamanio_control_relacion;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Boolean con_tamanio_control_manual;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Boolean con_tamanio_control_todo_relacion;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Boolean con_guardar_relaciones;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Boolean con_mensaje_confirmacion;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Boolean con_botones_tool_bar;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Boolean con_mostrar_acciones_campo_general;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Boolean con_mostrar_acciones_campo_relaciones;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_tipo_exportar;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_tipo_delimiter;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Boolean con_exportar_cabecera;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Boolean con_exportar_campo_version;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=100,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=ParametroGeneralUsuarioConstantesFunciones.SREGEXPATH_EXPORTAR,message=ParametroGeneralUsuarioConstantesFunciones.SMENSAJEREGEXPATH_EXPORTAR)
	private String path_exportar;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Boolean con_precargar_ventanas;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Boolean con_precargar_por_usuario;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Boolean con_cargar_por_parte;
			
	
	public Usuario usuario;
	public Empresa empresa;
	public Sucursal sucursal;
	public Ejercicio ejercicio;
	public Periodo periodo;
	public Moneda moneda;
	public Anio anio;
	public Mes mes;
	public TipoVisual tipovisual;
	public TipoFondo tipofondo;
	public TipoFondo tipofondoborde;
	public TipoFondoControl tipofondocontrol;
	public TipoFuente tipofuente;
	public TipoTamanioControl tipotamaniocontrolnormal;
	public TipoTamanioControl tipotamaniocontrolrelacion;
	public TipoExportar tipoexportar;
	public TipoDelimiter tipodelimiter;
	
	
	private String usuario_descripcion;
	private String empresa_descripcion;
	private String sucursal_descripcion;
	private String ejercicio_descripcion;
	private String periodo_descripcion;
	private String moneda_descripcion;
	private String anio_descripcion;
	private String mes_descripcion;
	private String tipovisual_descripcion;
	private String tipofondo_descripcion;
	private String tipofondoborde_descripcion;
	private String tipofondocontrol_descripcion;
	private String tipofuente_descripcion;
	private String tipotamaniocontrolnormal_descripcion;
	private String tipotamaniocontrolrelacion_descripcion;
	private String tipoexportar_descripcion;
	private String tipodelimiter_descripcion;
	
	
		
	public ParametroGeneralUsuario () throws Exception {
		super();		
		
		this.id=0L;
		this.idOriginal=0L;
		
		
		this.versionRow=new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());//new Date();
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		this.sType="NONE";
		
		this.parametrogeneralusuarioOriginal=this;
		
 		this.id_empresa=-1L;
 		this.id_sucursal=-1L;
 		this.id_ejercicio=-1L;
 		this.id_periodo=-1L;
 		this.id_moneda=-1L;
 		this.fecha_sistema=new Date();
 		this.id_anio=null;
 		this.id_mes=null;
 		this.dia=0;
 		this.id_tipo_visual=-1L;
 		this.id_tipo_fondo=-1L;
 		this.id_tipo_fondo_borde=-1L;
 		this.id_tipo_fondo_control=-1L;
 		this.id_tipo_fuente=-1L;
 		this.id_tipo_tamanio_control_normal=-1L;
 		this.id_tipo_tamanio_control_relacion=-1L;
 		this.con_tamanio_control_manual=false;
 		this.con_tamanio_control_todo_relacion=false;
 		this.con_guardar_relaciones=false;
 		this.con_mensaje_confirmacion=false;
 		this.con_botones_tool_bar=false;
 		this.con_mostrar_acciones_campo_general=false;
 		this.con_mostrar_acciones_campo_relaciones=false;
 		this.id_tipo_exportar=-1L;
 		this.id_tipo_delimiter=-1L;
 		this.con_exportar_cabecera=false;
 		this.con_exportar_campo_version=false;
 		this.path_exportar="";
 		this.con_precargar_ventanas=false;
 		this.con_precargar_por_usuario=false;
 		this.con_cargar_por_parte=false;
		
		
		this.usuario=null;
		this.empresa=null;
		this.sucursal=null;
		this.ejercicio=null;
		this.periodo=null;
		this.moneda=null;
		this.anio=null;
		this.mes=null;
		this.tipovisual=null;
		this.tipofondo=null;
		this.tipofondoborde=null;
		this.tipofondocontrol=null;
		this.tipofuente=null;
		this.tipotamaniocontrolnormal=null;
		this.tipotamaniocontrolrelacion=null;
		this.tipoexportar=null;
		this.tipodelimiter=null;
		
		
		this.usuario_descripcion="";
		this.empresa_descripcion="";
		this.sucursal_descripcion="";
		this.ejercicio_descripcion="";
		this.periodo_descripcion="";
		this.moneda_descripcion="";
		this.anio_descripcion="";
		this.mes_descripcion="";
		this.tipovisual_descripcion="";
		this.tipofondo_descripcion="";
		this.tipofondoborde_descripcion="";
		this.tipofondocontrol_descripcion="";
		this.tipofuente_descripcion="";
		this.tipotamaniocontrolnormal_descripcion="";
		this.tipotamaniocontrolrelacion_descripcion="";
		this.tipoexportar_descripcion="";
		this.tipodelimiter_descripcion="";
		
		
		
			
		
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
    //PARA REPORTES
	public ParametroGeneralUsuario (Long id,Date versionRow,Long id_empresa,Long id_sucursal,Long id_ejercicio,Long id_periodo,Long id_moneda,Date fecha_sistema,Long id_anio,Long id_mes,Integer dia,Long id_tipo_visual,Long id_tipo_fondo,Long id_tipo_fondo_borde,Long id_tipo_fondo_control,Long id_tipo_fuente,Long id_tipo_tamanio_control_normal,Long id_tipo_tamanio_control_relacion,Boolean con_tamanio_control_manual,Boolean con_tamanio_control_todo_relacion,Boolean con_guardar_relaciones,Boolean con_mensaje_confirmacion,Boolean con_botones_tool_bar,Boolean con_mostrar_acciones_campo_general,Boolean con_mostrar_acciones_campo_relaciones,Long id_tipo_exportar,Long id_tipo_delimiter,Boolean con_exportar_cabecera,Boolean con_exportar_campo_version,String path_exportar,Boolean con_precargar_ventanas,Boolean con_precargar_por_usuario,Boolean con_cargar_por_parte) throws Exception {
		super();		
		
		this.id=id;
		this.idOriginal=this.id;
		this.versionRow=versionRow;
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.parametrogeneralusuarioOriginal=this;
		
 		this.id_empresa=id_empresa;
 		this.id_sucursal=id_sucursal;
 		this.id_ejercicio=id_ejercicio;
 		this.id_periodo=id_periodo;
 		this.id_moneda=id_moneda;
 		this.fecha_sistema=fecha_sistema;
 		this.id_anio=id_anio;
 		this.id_mes=id_mes;
 		this.dia=dia;
 		this.id_tipo_visual=id_tipo_visual;
 		this.id_tipo_fondo=id_tipo_fondo;
 		this.id_tipo_fondo_borde=id_tipo_fondo_borde;
 		this.id_tipo_fondo_control=id_tipo_fondo_control;
 		this.id_tipo_fuente=id_tipo_fuente;
 		this.id_tipo_tamanio_control_normal=id_tipo_tamanio_control_normal;
 		this.id_tipo_tamanio_control_relacion=id_tipo_tamanio_control_relacion;
 		this.con_tamanio_control_manual=con_tamanio_control_manual;
 		this.con_tamanio_control_todo_relacion=con_tamanio_control_todo_relacion;
 		this.con_guardar_relaciones=con_guardar_relaciones;
 		this.con_mensaje_confirmacion=con_mensaje_confirmacion;
 		this.con_botones_tool_bar=con_botones_tool_bar;
 		this.con_mostrar_acciones_campo_general=con_mostrar_acciones_campo_general;
 		this.con_mostrar_acciones_campo_relaciones=con_mostrar_acciones_campo_relaciones;
 		this.id_tipo_exportar=id_tipo_exportar;
 		this.id_tipo_delimiter=id_tipo_delimiter;
 		this.con_exportar_cabecera=con_exportar_cabecera;
 		this.con_exportar_campo_version=con_exportar_campo_version;
 		this.path_exportar=path_exportar;
 		this.con_precargar_ventanas=con_precargar_ventanas;
 		this.con_precargar_por_usuario=con_precargar_por_usuario;
 		this.con_cargar_por_parte=con_cargar_por_parte;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	 //PARA REPORTES
	public ParametroGeneralUsuario (Long id_empresa,Long id_sucursal,Long id_ejercicio,Long id_periodo,Long id_moneda,Date fecha_sistema,Long id_anio,Long id_mes,Integer dia,Long id_tipo_visual,Long id_tipo_fondo,Long id_tipo_fondo_borde,Long id_tipo_fondo_control,Long id_tipo_fuente,Long id_tipo_tamanio_control_normal,Long id_tipo_tamanio_control_relacion,Boolean con_tamanio_control_manual,Boolean con_tamanio_control_todo_relacion,Boolean con_guardar_relaciones,Boolean con_mensaje_confirmacion,Boolean con_botones_tool_bar,Boolean con_mostrar_acciones_campo_general,Boolean con_mostrar_acciones_campo_relaciones,Long id_tipo_exportar,Long id_tipo_delimiter,Boolean con_exportar_cabecera,Boolean con_exportar_campo_version,String path_exportar,Boolean con_precargar_ventanas,Boolean con_precargar_por_usuario,Boolean con_cargar_por_parte) throws Exception {
		super();		
		
		this.id=0L;
		this.idOriginal=0L;
		this.versionRow=new Date();
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.parametrogeneralusuarioOriginal=this;
		
 		
 		this.id_empresa=id_empresa;
 		this.id_sucursal=id_sucursal;
 		this.id_ejercicio=id_ejercicio;
 		this.id_periodo=id_periodo;
 		this.id_moneda=id_moneda;
 		this.fecha_sistema=fecha_sistema;
 		this.id_anio=id_anio;
 		this.id_mes=id_mes;
 		this.dia=dia;
 		this.id_tipo_visual=id_tipo_visual;
 		this.id_tipo_fondo=id_tipo_fondo;
 		this.id_tipo_fondo_borde=id_tipo_fondo_borde;
 		this.id_tipo_fondo_control=id_tipo_fondo_control;
 		this.id_tipo_fuente=id_tipo_fuente;
 		this.id_tipo_tamanio_control_normal=id_tipo_tamanio_control_normal;
 		this.id_tipo_tamanio_control_relacion=id_tipo_tamanio_control_relacion;
 		this.con_tamanio_control_manual=con_tamanio_control_manual;
 		this.con_tamanio_control_todo_relacion=con_tamanio_control_todo_relacion;
 		this.con_guardar_relaciones=con_guardar_relaciones;
 		this.con_mensaje_confirmacion=con_mensaje_confirmacion;
 		this.con_botones_tool_bar=con_botones_tool_bar;
 		this.con_mostrar_acciones_campo_general=con_mostrar_acciones_campo_general;
 		this.con_mostrar_acciones_campo_relaciones=con_mostrar_acciones_campo_relaciones;
 		this.id_tipo_exportar=id_tipo_exportar;
 		this.id_tipo_delimiter=id_tipo_delimiter;
 		this.con_exportar_cabecera=con_exportar_cabecera;
 		this.con_exportar_campo_version=con_exportar_campo_version;
 		this.path_exportar=path_exportar;
 		this.con_precargar_ventanas=con_precargar_ventanas;
 		this.con_precargar_por_usuario=con_precargar_por_usuario;
 		this.con_cargar_por_parte=con_cargar_por_parte;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	public boolean equals(Object object) {
		boolean equal=false;
		ParametroGeneralUsuario parametrogeneralusuarioLocal=null;
		
		if(object!=null) {
			parametrogeneralusuarioLocal=(ParametroGeneralUsuario)object;
			
			if(parametrogeneralusuarioLocal!=null) {
				if(this.getId()!=null && parametrogeneralusuarioLocal.getId()!=null) {
					if(this.getId().equals(parametrogeneralusuarioLocal.getId())) {
						equal=true;
					}
				}
			}
		}
		
		return equal;
	}
	
	public String toString() {
		String sDetalle="";
		
		if(!ParametroGeneralUsuarioConstantesFunciones.CON_DESCRIPCION_DETALLADO) {
        	sDetalle=ParametroGeneralUsuarioConstantesFunciones.getParametroGeneralUsuarioDescripcion(this);
		} else {
			sDetalle=ParametroGeneralUsuarioConstantesFunciones.getParametroGeneralUsuarioDescripcionDetallado(this);
		}
		
		return sDetalle;
    }
	
	public ParametroGeneralUsuario getParametroGeneralUsuarioOriginal() {
		return this.parametrogeneralusuarioOriginal;
	}
	
	public void setParametroGeneralUsuarioOriginal(ParametroGeneralUsuario parametrogeneralusuario) {
		try {
			this.parametrogeneralusuarioOriginal=parametrogeneralusuario;
		} catch(Exception e) {
			;
		}
	}
	
	
	protected ParametroGeneralUsuarioAdditional parametrogeneralusuarioAdditional=null;
	
	public ParametroGeneralUsuarioAdditional getParametroGeneralUsuarioAdditional() {
		return this.parametrogeneralusuarioAdditional;
	}
	
	public void setParametroGeneralUsuarioAdditional(ParametroGeneralUsuarioAdditional parametrogeneralusuarioAdditional) {
		try {
			this.parametrogeneralusuarioAdditional=parametrogeneralusuarioAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
    
	
	public Long getid_usuario() {
		this.id_usuario=this.id;

		return this.id_usuario;
	}
    
	
	public Long getid_empresa() {
		return this.id_empresa;
	}
    
	
	public Long getid_sucursal() {
		return this.id_sucursal;
	}
    
	
	public Long getid_ejercicio() {
		return this.id_ejercicio;
	}
    
	
	public Long getid_periodo() {
		return this.id_periodo;
	}
    
	
	public Long getid_moneda() {
		return this.id_moneda;
	}
    
	
	public Date getfecha_sistema() {
		return this.fecha_sistema;
	}
    
	
	public Long getid_anio() {
		return this.id_anio;
	}
    
	
	public Long getid_mes() {
		return this.id_mes;
	}
    
	
	public Integer getdia() {
		return this.dia;
	}
    
	
	public Long getid_tipo_visual() {
		return this.id_tipo_visual;
	}
    
	
	public Long getid_tipo_fondo() {
		return this.id_tipo_fondo;
	}
    
	
	public Long getid_tipo_fondo_borde() {
		return this.id_tipo_fondo_borde;
	}
    
	
	public Long getid_tipo_fondo_control() {
		return this.id_tipo_fondo_control;
	}
    
	
	public Long getid_tipo_fuente() {
		return this.id_tipo_fuente;
	}
    
	
	public Long getid_tipo_tamanio_control_normal() {
		return this.id_tipo_tamanio_control_normal;
	}
    
	
	public Long getid_tipo_tamanio_control_relacion() {
		return this.id_tipo_tamanio_control_relacion;
	}
    
	
	public Boolean getcon_tamanio_control_manual() {
		return this.con_tamanio_control_manual;
	}
    
	
	public Boolean getcon_tamanio_control_todo_relacion() {
		return this.con_tamanio_control_todo_relacion;
	}
    
	
	public Boolean getcon_guardar_relaciones() {
		return this.con_guardar_relaciones;
	}
    
	
	public Boolean getcon_mensaje_confirmacion() {
		return this.con_mensaje_confirmacion;
	}
    
	
	public Boolean getcon_botones_tool_bar() {
		return this.con_botones_tool_bar;
	}
    
	
	public Boolean getcon_mostrar_acciones_campo_general() {
		return this.con_mostrar_acciones_campo_general;
	}
    
	
	public Boolean getcon_mostrar_acciones_campo_relaciones() {
		return this.con_mostrar_acciones_campo_relaciones;
	}
    
	
	public Long getid_tipo_exportar() {
		return this.id_tipo_exportar;
	}
    
	
	public Long getid_tipo_delimiter() {
		return this.id_tipo_delimiter;
	}
    
	
	public Boolean getcon_exportar_cabecera() {
		return this.con_exportar_cabecera;
	}
    
	
	public Boolean getcon_exportar_campo_version() {
		return this.con_exportar_campo_version;
	}
    
	
	public String getpath_exportar() {
		return this.path_exportar;
	}
    
	
	public Boolean getcon_precargar_ventanas() {
		return this.con_precargar_ventanas;
	}
    
	
	public Boolean getcon_precargar_por_usuario() {
		return this.con_precargar_por_usuario;
	}
    
	
	public Boolean getcon_cargar_por_parte() {
		return this.con_cargar_por_parte;
	}
	
    
	public void setid_usuario(Long newid_usuario)throws Exception
	{
		try {
			if(this.id_usuario!=null && this.id_usuario!=newid_usuario) {
				if(newid_usuario==null) {
					//newid_usuario=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ParametroGeneralUsuario:Valor nulo no permitido en columna id_usuario");
					}
				}

				this.id_usuario=newid_usuario;
				this.setIsChanged(true);
			} else if(this.id_usuario==null && newid_usuario!=null) {
				this.id_usuario=newid_usuario;
				this.id=newid_usuario;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_empresa(Long newid_empresa)throws Exception
	{
		try {
			if(this.id_empresa!=newid_empresa) {
				if(newid_empresa==null) {
					//newid_empresa=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ParametroGeneralUsuario:Valor nulo no permitido en columna id_empresa");
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
						System.out.println("ParametroGeneralUsuario:Valor nulo no permitido en columna id_sucursal");
					}
				}

				this.id_sucursal=newid_sucursal;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_ejercicio(Long newid_ejercicio)throws Exception
	{
		try {
			if(this.id_ejercicio!=newid_ejercicio) {
				if(newid_ejercicio==null) {
					//newid_ejercicio=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ParametroGeneralUsuario:Valor nulo no permitido en columna id_ejercicio");
					}
				}

				this.id_ejercicio=newid_ejercicio;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_periodo(Long newid_periodo)throws Exception
	{
		try {
			if(this.id_periodo!=newid_periodo) {
				if(newid_periodo==null) {
					//newid_periodo=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ParametroGeneralUsuario:Valor nulo no permitido en columna id_periodo");
					}
				}

				this.id_periodo=newid_periodo;
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
						System.out.println("ParametroGeneralUsuario:Valor nulo no permitido en columna id_moneda");
					}
				}

				this.id_moneda=newid_moneda;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setfecha_sistema(Date newfecha_sistema)throws Exception
	{
		try {
			if(this.fecha_sistema!=newfecha_sistema) {
				if(newfecha_sistema==null) {
					//newfecha_sistema=new Date();
					if(Constantes.ISDEVELOPING) {
						System.out.println("ParametroGeneralUsuario:Valor nulo no permitido en columna fecha_sistema");
					}
				}

				this.fecha_sistema=newfecha_sistema;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_anio(Long newid_anio) {
		if(this.id_anio==null&&newid_anio!=null) {
			this.id_anio=newid_anio;
				this.setIsChanged(true);
		}

		if(this.id_anio!=null&&!this.id_anio.equals(newid_anio)) {

			this.id_anio=newid_anio;
				this.setIsChanged(true);
		}
	}
    
	public void setid_mes(Long newid_mes) {
		if(this.id_mes==null&&newid_mes!=null) {
			this.id_mes=newid_mes;
				this.setIsChanged(true);
		}

		if(this.id_mes!=null&&!this.id_mes.equals(newid_mes)) {

			this.id_mes=newid_mes;
				this.setIsChanged(true);
		}
	}
    
	public void setdia(Integer newdia)throws Exception
	{
		try {
			if(this.dia!=newdia) {
				if(newdia==null) {
					//newdia=0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ParametroGeneralUsuario:Valor nulo no permitido en columna dia");
					}
				}

				this.dia=newdia;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_tipo_visual(Long newid_tipo_visual)throws Exception
	{
		try {
			if(this.id_tipo_visual!=newid_tipo_visual) {
				if(newid_tipo_visual==null) {
					//newid_tipo_visual=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ParametroGeneralUsuario:Valor nulo no permitido en columna id_tipo_visual");
					}
				}

				this.id_tipo_visual=newid_tipo_visual;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_tipo_fondo(Long newid_tipo_fondo)throws Exception
	{
		try {
			if(this.id_tipo_fondo!=newid_tipo_fondo) {
				if(newid_tipo_fondo==null) {
					//newid_tipo_fondo=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ParametroGeneralUsuario:Valor nulo no permitido en columna id_tipo_fondo");
					}
				}

				this.id_tipo_fondo=newid_tipo_fondo;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_tipo_fondo_borde(Long newid_tipo_fondo_borde)throws Exception
	{
		try {
			if(this.id_tipo_fondo_borde!=newid_tipo_fondo_borde) {
				if(newid_tipo_fondo_borde==null) {
					//newid_tipo_fondo_borde=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ParametroGeneralUsuario:Valor nulo no permitido en columna id_tipo_fondo_borde");
					}
				}

				this.id_tipo_fondo_borde=newid_tipo_fondo_borde;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_tipo_fondo_control(Long newid_tipo_fondo_control)throws Exception
	{
		try {
			if(this.id_tipo_fondo_control!=newid_tipo_fondo_control) {
				if(newid_tipo_fondo_control==null) {
					//newid_tipo_fondo_control=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ParametroGeneralUsuario:Valor nulo no permitido en columna id_tipo_fondo_control");
					}
				}

				this.id_tipo_fondo_control=newid_tipo_fondo_control;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_tipo_fuente(Long newid_tipo_fuente)throws Exception
	{
		try {
			if(this.id_tipo_fuente!=newid_tipo_fuente) {
				if(newid_tipo_fuente==null) {
					//newid_tipo_fuente=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ParametroGeneralUsuario:Valor nulo no permitido en columna id_tipo_fuente");
					}
				}

				this.id_tipo_fuente=newid_tipo_fuente;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_tipo_tamanio_control_normal(Long newid_tipo_tamanio_control_normal)throws Exception
	{
		try {
			if(this.id_tipo_tamanio_control_normal!=newid_tipo_tamanio_control_normal) {
				if(newid_tipo_tamanio_control_normal==null) {
					//newid_tipo_tamanio_control_normal=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ParametroGeneralUsuario:Valor nulo no permitido en columna id_tipo_tamanio_control_normal");
					}
				}

				this.id_tipo_tamanio_control_normal=newid_tipo_tamanio_control_normal;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_tipo_tamanio_control_relacion(Long newid_tipo_tamanio_control_relacion)throws Exception
	{
		try {
			if(this.id_tipo_tamanio_control_relacion!=newid_tipo_tamanio_control_relacion) {
				if(newid_tipo_tamanio_control_relacion==null) {
					//newid_tipo_tamanio_control_relacion=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ParametroGeneralUsuario:Valor nulo no permitido en columna id_tipo_tamanio_control_relacion");
					}
				}

				this.id_tipo_tamanio_control_relacion=newid_tipo_tamanio_control_relacion;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setcon_tamanio_control_manual(Boolean newcon_tamanio_control_manual)throws Exception
	{
		try {
			if(this.con_tamanio_control_manual!=newcon_tamanio_control_manual) {
				if(newcon_tamanio_control_manual==null) {
					//newcon_tamanio_control_manual=false;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ParametroGeneralUsuario:Valor nulo no permitido en columna con_tamanio_control_manual");
					}
				}

				this.con_tamanio_control_manual=newcon_tamanio_control_manual;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setcon_tamanio_control_todo_relacion(Boolean newcon_tamanio_control_todo_relacion)throws Exception
	{
		try {
			if(this.con_tamanio_control_todo_relacion!=newcon_tamanio_control_todo_relacion) {
				if(newcon_tamanio_control_todo_relacion==null) {
					//newcon_tamanio_control_todo_relacion=false;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ParametroGeneralUsuario:Valor nulo no permitido en columna con_tamanio_control_todo_relacion");
					}
				}

				this.con_tamanio_control_todo_relacion=newcon_tamanio_control_todo_relacion;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setcon_guardar_relaciones(Boolean newcon_guardar_relaciones)throws Exception
	{
		try {
			if(this.con_guardar_relaciones!=newcon_guardar_relaciones) {
				if(newcon_guardar_relaciones==null) {
					//newcon_guardar_relaciones=false;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ParametroGeneralUsuario:Valor nulo no permitido en columna con_guardar_relaciones");
					}
				}

				this.con_guardar_relaciones=newcon_guardar_relaciones;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setcon_mensaje_confirmacion(Boolean newcon_mensaje_confirmacion)throws Exception
	{
		try {
			if(this.con_mensaje_confirmacion!=newcon_mensaje_confirmacion) {
				if(newcon_mensaje_confirmacion==null) {
					//newcon_mensaje_confirmacion=false;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ParametroGeneralUsuario:Valor nulo no permitido en columna con_mensaje_confirmacion");
					}
				}

				this.con_mensaje_confirmacion=newcon_mensaje_confirmacion;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setcon_botones_tool_bar(Boolean newcon_botones_tool_bar)throws Exception
	{
		try {
			if(this.con_botones_tool_bar!=newcon_botones_tool_bar) {
				if(newcon_botones_tool_bar==null) {
					//newcon_botones_tool_bar=false;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ParametroGeneralUsuario:Valor nulo no permitido en columna con_botones_tool_bar");
					}
				}

				this.con_botones_tool_bar=newcon_botones_tool_bar;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setcon_mostrar_acciones_campo_general(Boolean newcon_mostrar_acciones_campo_general)throws Exception
	{
		try {
			if(this.con_mostrar_acciones_campo_general!=newcon_mostrar_acciones_campo_general) {
				if(newcon_mostrar_acciones_campo_general==null) {
					//newcon_mostrar_acciones_campo_general=false;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ParametroGeneralUsuario:Valor nulo no permitido en columna con_mostrar_acciones_campo_general");
					}
				}

				this.con_mostrar_acciones_campo_general=newcon_mostrar_acciones_campo_general;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setcon_mostrar_acciones_campo_relaciones(Boolean newcon_mostrar_acciones_campo_relaciones)throws Exception
	{
		try {
			if(this.con_mostrar_acciones_campo_relaciones!=newcon_mostrar_acciones_campo_relaciones) {
				if(newcon_mostrar_acciones_campo_relaciones==null) {
					//newcon_mostrar_acciones_campo_relaciones=false;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ParametroGeneralUsuario:Valor nulo no permitido en columna con_mostrar_acciones_campo_relaciones");
					}
				}

				this.con_mostrar_acciones_campo_relaciones=newcon_mostrar_acciones_campo_relaciones;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_tipo_exportar(Long newid_tipo_exportar)throws Exception
	{
		try {
			if(this.id_tipo_exportar!=newid_tipo_exportar) {
				if(newid_tipo_exportar==null) {
					//newid_tipo_exportar=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ParametroGeneralUsuario:Valor nulo no permitido en columna id_tipo_exportar");
					}
				}

				this.id_tipo_exportar=newid_tipo_exportar;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_tipo_delimiter(Long newid_tipo_delimiter)throws Exception
	{
		try {
			if(this.id_tipo_delimiter!=newid_tipo_delimiter) {
				if(newid_tipo_delimiter==null) {
					//newid_tipo_delimiter=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ParametroGeneralUsuario:Valor nulo no permitido en columna id_tipo_delimiter");
					}
				}

				this.id_tipo_delimiter=newid_tipo_delimiter;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setcon_exportar_cabecera(Boolean newcon_exportar_cabecera)throws Exception
	{
		try {
			if(this.con_exportar_cabecera!=newcon_exportar_cabecera) {
				if(newcon_exportar_cabecera==null) {
					//newcon_exportar_cabecera=false;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ParametroGeneralUsuario:Valor nulo no permitido en columna con_exportar_cabecera");
					}
				}

				this.con_exportar_cabecera=newcon_exportar_cabecera;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setcon_exportar_campo_version(Boolean newcon_exportar_campo_version)throws Exception
	{
		try {
			if(this.con_exportar_campo_version!=newcon_exportar_campo_version) {
				if(newcon_exportar_campo_version==null) {
					//newcon_exportar_campo_version=false;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ParametroGeneralUsuario:Valor nulo no permitido en columna con_exportar_campo_version");
					}
				}

				this.con_exportar_campo_version=newcon_exportar_campo_version;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setpath_exportar(String newpath_exportar)throws Exception
	{
		try {
			if(this.path_exportar!=newpath_exportar) {
				if(newpath_exportar==null) {
					//newpath_exportar="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("ParametroGeneralUsuario:Valor nulo no permitido en columna path_exportar");
					}
				}

				if(newpath_exportar!=null&&newpath_exportar.length()>100) {
					newpath_exportar=newpath_exportar.substring(0,98);
					System.out.println("ParametroGeneralUsuario:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=100 en columna path_exportar");
				}

				this.path_exportar=newpath_exportar;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setcon_precargar_ventanas(Boolean newcon_precargar_ventanas)throws Exception
	{
		try {
			if(this.con_precargar_ventanas!=newcon_precargar_ventanas) {
				if(newcon_precargar_ventanas==null) {
					//newcon_precargar_ventanas=false;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ParametroGeneralUsuario:Valor nulo no permitido en columna con_precargar_ventanas");
					}
				}

				this.con_precargar_ventanas=newcon_precargar_ventanas;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setcon_precargar_por_usuario(Boolean newcon_precargar_por_usuario)throws Exception
	{
		try {
			if(this.con_precargar_por_usuario!=newcon_precargar_por_usuario) {
				if(newcon_precargar_por_usuario==null) {
					//newcon_precargar_por_usuario=false;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ParametroGeneralUsuario:Valor nulo no permitido en columna con_precargar_por_usuario");
					}
				}

				this.con_precargar_por_usuario=newcon_precargar_por_usuario;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setcon_cargar_por_parte(Boolean newcon_cargar_por_parte)throws Exception
	{
		try {
			if(this.con_cargar_por_parte!=newcon_cargar_por_parte) {
				if(newcon_cargar_por_parte==null) {
					//newcon_cargar_por_parte=false;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ParametroGeneralUsuario:Valor nulo no permitido en columna con_cargar_por_parte");
					}
				}

				this.con_cargar_por_parte=newcon_cargar_por_parte;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	
	public Usuario getUsuario() {
		return this.usuario;
	}

	public Empresa getEmpresa() {
		return this.empresa;
	}

	public Sucursal getSucursal() {
		return this.sucursal;
	}

	public Ejercicio getEjercicio() {
		return this.ejercicio;
	}

	public Periodo getPeriodo() {
		return this.periodo;
	}

	public Moneda getMoneda() {
		return this.moneda;
	}

	public Anio getAnio() {
		return this.anio;
	}

	public Mes getMes() {
		return this.mes;
	}

	public TipoVisual getTipoVisual() {
		return this.tipovisual;
	}

	public TipoFondo getTipoFondo() {
		return this.tipofondo;
	}

	public TipoFondo getTipoFondoBorde() {
		return this.tipofondoborde;
	}

	public TipoFondoControl getTipoFondoControl() {
		return this.tipofondocontrol;
	}

	public TipoFuente getTipoFuente() {
		return this.tipofuente;
	}

	public TipoTamanioControl getTipoTamanioControlNormal() {
		return this.tipotamaniocontrolnormal;
	}

	public TipoTamanioControl getTipoTamanioControlRelacion() {
		return this.tipotamaniocontrolrelacion;
	}

	public TipoExportar getTipoExportar() {
		return this.tipoexportar;
	}

	public TipoDelimiter getTipoDelimiter() {
		return this.tipodelimiter;
	}

	
	
	public String getusuario_descripcion() {
		return this.usuario_descripcion;
	}

	public String getempresa_descripcion() {
		return this.empresa_descripcion;
	}

	public String getsucursal_descripcion() {
		return this.sucursal_descripcion;
	}

	public String getejercicio_descripcion() {
		return this.ejercicio_descripcion;
	}

	public String getperiodo_descripcion() {
		return this.periodo_descripcion;
	}

	public String getmoneda_descripcion() {
		return this.moneda_descripcion;
	}

	public String getanio_descripcion() {
		return this.anio_descripcion;
	}

	public String getmes_descripcion() {
		return this.mes_descripcion;
	}

	public String gettipovisual_descripcion() {
		return this.tipovisual_descripcion;
	}

	public String gettipofondo_descripcion() {
		return this.tipofondo_descripcion;
	}

	public String gettipofondoborde_descripcion() {
		return this.tipofondoborde_descripcion;
	}

	public String gettipofondocontrol_descripcion() {
		return this.tipofondocontrol_descripcion;
	}

	public String gettipofuente_descripcion() {
		return this.tipofuente_descripcion;
	}

	public String gettipotamaniocontrolnormal_descripcion() {
		return this.tipotamaniocontrolnormal_descripcion;
	}

	public String gettipotamaniocontrolrelacion_descripcion() {
		return this.tipotamaniocontrolrelacion_descripcion;
	}

	public String gettipoexportar_descripcion() {
		return this.tipoexportar_descripcion;
	}

	public String gettipodelimiter_descripcion() {
		return this.tipodelimiter_descripcion;
	}

	
	
	public  void  setUsuario(Usuario usuario) {
		try {
			this.usuario=usuario;
		} catch(Exception e) {
			;
		}
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


	public  void  setEjercicio(Ejercicio ejercicio) {
		try {
			this.ejercicio=ejercicio;
		} catch(Exception e) {
			;
		}
	}


	public  void  setPeriodo(Periodo periodo) {
		try {
			this.periodo=periodo;
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


	public  void  setAnio(Anio anio) {
		try {
			this.anio=anio;
		} catch(Exception e) {
			;
		}
	}


	public  void  setMes(Mes mes) {
		try {
			this.mes=mes;
		} catch(Exception e) {
			;
		}
	}


	public  void  setTipoVisual(TipoVisual tipovisual) {
		try {
			this.tipovisual=tipovisual;
		} catch(Exception e) {
			;
		}
	}


	public  void  setTipoFondo(TipoFondo tipofondo) {
		try {
			this.tipofondo=tipofondo;
		} catch(Exception e) {
			;
		}
	}


	public  void  setTipoFondoBorde(TipoFondo tipofondoborde) {
		try {
			this.tipofondoborde=tipofondoborde;
		} catch(Exception e) {
			;
		}
	}


	public  void  setTipoFondoControl(TipoFondoControl tipofondocontrol) {
		try {
			this.tipofondocontrol=tipofondocontrol;
		} catch(Exception e) {
			;
		}
	}


	public  void  setTipoFuente(TipoFuente tipofuente) {
		try {
			this.tipofuente=tipofuente;
		} catch(Exception e) {
			;
		}
	}


	public  void  setTipoTamanioControlNormal(TipoTamanioControl tipotamaniocontrolnormal) {
		try {
			this.tipotamaniocontrolnormal=tipotamaniocontrolnormal;
		} catch(Exception e) {
			;
		}
	}


	public  void  setTipoTamanioControlRelacion(TipoTamanioControl tipotamaniocontrolrelacion) {
		try {
			this.tipotamaniocontrolrelacion=tipotamaniocontrolrelacion;
		} catch(Exception e) {
			;
		}
	}


	public  void  setTipoExportar(TipoExportar tipoexportar) {
		try {
			this.tipoexportar=tipoexportar;
		} catch(Exception e) {
			;
		}
	}


	public  void  setTipoDelimiter(TipoDelimiter tipodelimiter) {
		try {
			this.tipodelimiter=tipodelimiter;
		} catch(Exception e) {
			;
		}
	}


	
	
	public  void  setusuario_descripcion(String usuario_descripcion) {
		try {
			this.usuario_descripcion=usuario_descripcion;
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


	public  void  setejercicio_descripcion(String ejercicio_descripcion) {
		try {
			this.ejercicio_descripcion=ejercicio_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  setperiodo_descripcion(String periodo_descripcion) {
		try {
			this.periodo_descripcion=periodo_descripcion;
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


	public  void  setanio_descripcion(String anio_descripcion) {
		try {
			this.anio_descripcion=anio_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  setmes_descripcion(String mes_descripcion) {
		try {
			this.mes_descripcion=mes_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  settipovisual_descripcion(String tipovisual_descripcion) {
		try {
			this.tipovisual_descripcion=tipovisual_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  settipofondo_descripcion(String tipofondo_descripcion) {
		try {
			this.tipofondo_descripcion=tipofondo_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  settipofondoborde_descripcion(String tipofondoborde_descripcion) {
		try {
			this.tipofondoborde_descripcion=tipofondoborde_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  settipofondocontrol_descripcion(String tipofondocontrol_descripcion) {
		try {
			this.tipofondocontrol_descripcion=tipofondocontrol_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  settipofuente_descripcion(String tipofuente_descripcion) {
		try {
			this.tipofuente_descripcion=tipofuente_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  settipotamaniocontrolnormal_descripcion(String tipotamaniocontrolnormal_descripcion) {
		try {
			this.tipotamaniocontrolnormal_descripcion=tipotamaniocontrolnormal_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  settipotamaniocontrolrelacion_descripcion(String tipotamaniocontrolrelacion_descripcion) {
		try {
			this.tipotamaniocontrolrelacion_descripcion=tipotamaniocontrolrelacion_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  settipoexportar_descripcion(String tipoexportar_descripcion) {
		try {
			this.tipoexportar_descripcion=tipoexportar_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  settipodelimiter_descripcion(String tipodelimiter_descripcion) {
		try {
			this.tipodelimiter_descripcion=tipodelimiter_descripcion;
		} catch(Exception e) {
			;
		}
	}


	
	
	
	
	
	/*PARA REPORTES*/
	String id_usuarioNONE_descripcion="";String id_empresa_descripcion="";String id_sucursal_descripcion="";String id_ejercicio_descripcion="";String id_periodo_descripcion="";String id_moneda_descripcion="";String id_anio_descripcion="";String id_mes_descripcion="";String id_tipo_visual_descripcion="";String id_tipo_fondo_descripcion="";String id_tipo_fondo_borde_descripcion="";String id_tipo_fondo_control_descripcion="";String id_tipo_fuente_descripcion="";String id_tipo_tamanio_control_normal_descripcion="";String id_tipo_tamanio_control_relacion_descripcion="";String con_tamanio_control_manual_descripcion="";String con_tamanio_control_todo_relacion_descripcion="";String con_guardar_relaciones_descripcion="";String con_mensaje_confirmacion_descripcion="";String con_botones_tool_bar_descripcion="";String con_mostrar_acciones_campo_general_descripcion="";String con_mostrar_acciones_campo_relaciones_descripcion="";String id_tipo_exportar_descripcion="";String id_tipo_delimiter_descripcion="";String con_exportar_cabecera_descripcion="";String con_exportar_campo_version_descripcion="";String con_precargar_ventanas_descripcion="";String con_precargar_por_usuario_descripcion="";String con_cargar_por_parte_descripcion="";
	
	
	public String getid_usuarioNONE_descripcion() {
		return id_usuarioNONE_descripcion;
	}
	public String getid_empresa_descripcion() {
		return id_empresa_descripcion;
	}
	public String getid_sucursal_descripcion() {
		return id_sucursal_descripcion;
	}
	public String getid_ejercicio_descripcion() {
		return id_ejercicio_descripcion;
	}
	public String getid_periodo_descripcion() {
		return id_periodo_descripcion;
	}
	public String getid_moneda_descripcion() {
		return id_moneda_descripcion;
	}
	public String getid_anio_descripcion() {
		return id_anio_descripcion;
	}
	public String getid_mes_descripcion() {
		return id_mes_descripcion;
	}
	public String getid_tipo_visual_descripcion() {
		return id_tipo_visual_descripcion;
	}
	public String getid_tipo_fondo_descripcion() {
		return id_tipo_fondo_descripcion;
	}
	public String getid_tipo_fondo_borde_descripcion() {
		return id_tipo_fondo_borde_descripcion;
	}
	public String getid_tipo_fondo_control_descripcion() {
		return id_tipo_fondo_control_descripcion;
	}
	public String getid_tipo_fuente_descripcion() {
		return id_tipo_fuente_descripcion;
	}
	public String getid_tipo_tamanio_control_normal_descripcion() {
		return id_tipo_tamanio_control_normal_descripcion;
	}
	public String getid_tipo_tamanio_control_relacion_descripcion() {
		return id_tipo_tamanio_control_relacion_descripcion;
	}
	public String getcon_tamanio_control_manual_descripcion() {
		return con_tamanio_control_manual_descripcion;
	}
	public String getcon_tamanio_control_todo_relacion_descripcion() {
		return con_tamanio_control_todo_relacion_descripcion;
	}
	public String getcon_guardar_relaciones_descripcion() {
		return con_guardar_relaciones_descripcion;
	}
	public String getcon_mensaje_confirmacion_descripcion() {
		return con_mensaje_confirmacion_descripcion;
	}
	public String getcon_botones_tool_bar_descripcion() {
		return con_botones_tool_bar_descripcion;
	}
	public String getcon_mostrar_acciones_campo_general_descripcion() {
		return con_mostrar_acciones_campo_general_descripcion;
	}
	public String getcon_mostrar_acciones_campo_relaciones_descripcion() {
		return con_mostrar_acciones_campo_relaciones_descripcion;
	}
	public String getid_tipo_exportar_descripcion() {
		return id_tipo_exportar_descripcion;
	}
	public String getid_tipo_delimiter_descripcion() {
		return id_tipo_delimiter_descripcion;
	}
	public String getcon_exportar_cabecera_descripcion() {
		return con_exportar_cabecera_descripcion;
	}
	public String getcon_exportar_campo_version_descripcion() {
		return con_exportar_campo_version_descripcion;
	}
	public String getcon_precargar_ventanas_descripcion() {
		return con_precargar_ventanas_descripcion;
	}
	public String getcon_precargar_por_usuario_descripcion() {
		return con_precargar_por_usuario_descripcion;
	}
	public String getcon_cargar_por_parte_descripcion() {
		return con_cargar_por_parte_descripcion;
	}
	
	
	public void setid_usuarioNONE_descripcion(String newid_usuarioNONE_descripcion)throws Exception {
		try {
			this.id_usuarioNONE_descripcion=newid_usuarioNONE_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
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
	public void setid_ejercicio_descripcion(String newid_ejercicio_descripcion)throws Exception {
		try {
			this.id_ejercicio_descripcion=newid_ejercicio_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_periodo_descripcion(String newid_periodo_descripcion)throws Exception {
		try {
			this.id_periodo_descripcion=newid_periodo_descripcion;
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
	public void setid_anio_descripcion(String newid_anio_descripcion)throws Exception {
		try {
			this.id_anio_descripcion=newid_anio_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_mes_descripcion(String newid_mes_descripcion)throws Exception {
		try {
			this.id_mes_descripcion=newid_mes_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_tipo_visual_descripcion(String newid_tipo_visual_descripcion)throws Exception {
		try {
			this.id_tipo_visual_descripcion=newid_tipo_visual_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_tipo_fondo_descripcion(String newid_tipo_fondo_descripcion)throws Exception {
		try {
			this.id_tipo_fondo_descripcion=newid_tipo_fondo_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_tipo_fondo_borde_descripcion(String newid_tipo_fondo_borde_descripcion)throws Exception {
		try {
			this.id_tipo_fondo_borde_descripcion=newid_tipo_fondo_borde_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_tipo_fondo_control_descripcion(String newid_tipo_fondo_control_descripcion)throws Exception {
		try {
			this.id_tipo_fondo_control_descripcion=newid_tipo_fondo_control_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_tipo_fuente_descripcion(String newid_tipo_fuente_descripcion)throws Exception {
		try {
			this.id_tipo_fuente_descripcion=newid_tipo_fuente_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_tipo_tamanio_control_normal_descripcion(String newid_tipo_tamanio_control_normal_descripcion)throws Exception {
		try {
			this.id_tipo_tamanio_control_normal_descripcion=newid_tipo_tamanio_control_normal_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_tipo_tamanio_control_relacion_descripcion(String newid_tipo_tamanio_control_relacion_descripcion)throws Exception {
		try {
			this.id_tipo_tamanio_control_relacion_descripcion=newid_tipo_tamanio_control_relacion_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setcon_tamanio_control_manual_descripcion(String newcon_tamanio_control_manual_descripcion)throws Exception {
		try {
			this.con_tamanio_control_manual_descripcion=newcon_tamanio_control_manual_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setcon_tamanio_control_todo_relacion_descripcion(String newcon_tamanio_control_todo_relacion_descripcion)throws Exception {
		try {
			this.con_tamanio_control_todo_relacion_descripcion=newcon_tamanio_control_todo_relacion_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setcon_guardar_relaciones_descripcion(String newcon_guardar_relaciones_descripcion)throws Exception {
		try {
			this.con_guardar_relaciones_descripcion=newcon_guardar_relaciones_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setcon_mensaje_confirmacion_descripcion(String newcon_mensaje_confirmacion_descripcion)throws Exception {
		try {
			this.con_mensaje_confirmacion_descripcion=newcon_mensaje_confirmacion_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setcon_botones_tool_bar_descripcion(String newcon_botones_tool_bar_descripcion)throws Exception {
		try {
			this.con_botones_tool_bar_descripcion=newcon_botones_tool_bar_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setcon_mostrar_acciones_campo_general_descripcion(String newcon_mostrar_acciones_campo_general_descripcion)throws Exception {
		try {
			this.con_mostrar_acciones_campo_general_descripcion=newcon_mostrar_acciones_campo_general_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setcon_mostrar_acciones_campo_relaciones_descripcion(String newcon_mostrar_acciones_campo_relaciones_descripcion)throws Exception {
		try {
			this.con_mostrar_acciones_campo_relaciones_descripcion=newcon_mostrar_acciones_campo_relaciones_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_tipo_exportar_descripcion(String newid_tipo_exportar_descripcion)throws Exception {
		try {
			this.id_tipo_exportar_descripcion=newid_tipo_exportar_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_tipo_delimiter_descripcion(String newid_tipo_delimiter_descripcion)throws Exception {
		try {
			this.id_tipo_delimiter_descripcion=newid_tipo_delimiter_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setcon_exportar_cabecera_descripcion(String newcon_exportar_cabecera_descripcion)throws Exception {
		try {
			this.con_exportar_cabecera_descripcion=newcon_exportar_cabecera_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setcon_exportar_campo_version_descripcion(String newcon_exportar_campo_version_descripcion)throws Exception {
		try {
			this.con_exportar_campo_version_descripcion=newcon_exportar_campo_version_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setcon_precargar_ventanas_descripcion(String newcon_precargar_ventanas_descripcion)throws Exception {
		try {
			this.con_precargar_ventanas_descripcion=newcon_precargar_ventanas_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setcon_precargar_por_usuario_descripcion(String newcon_precargar_por_usuario_descripcion)throws Exception {
		try {
			this.con_precargar_por_usuario_descripcion=newcon_precargar_por_usuario_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setcon_cargar_por_parte_descripcion(String newcon_cargar_por_parte_descripcion)throws Exception {
		try {
			this.con_cargar_por_parte_descripcion=newcon_cargar_por_parte_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	
	public void inicializarVariablesParaReporte() {
		this.id_empresa_descripcion="";this.id_sucursal_descripcion="";this.id_ejercicio_descripcion="";this.id_periodo_descripcion="";this.id_moneda_descripcion="";this.id_anio_descripcion="";this.id_mes_descripcion="";this.id_tipo_visual_descripcion="";this.id_tipo_fondo_descripcion="";this.id_tipo_fondo_borde_descripcion="";this.id_tipo_fondo_control_descripcion="";this.id_tipo_fuente_descripcion="";this.id_tipo_tamanio_control_normal_descripcion="";this.id_tipo_tamanio_control_relacion_descripcion="";this.con_tamanio_control_manual_descripcion="";this.con_tamanio_control_todo_relacion_descripcion="";this.con_guardar_relaciones_descripcion="";this.con_mensaje_confirmacion_descripcion="";this.con_botones_tool_bar_descripcion="";this.con_mostrar_acciones_campo_general_descripcion="";this.con_mostrar_acciones_campo_relaciones_descripcion="";this.id_tipo_exportar_descripcion="";this.id_tipo_delimiter_descripcion="";this.con_exportar_cabecera_descripcion="";this.con_exportar_campo_version_descripcion="";this.con_precargar_ventanas_descripcion="";this.con_precargar_por_usuario_descripcion="";this.con_cargar_por_parte_descripcion="";
	}
	
	
	
	
	
	
	/*PARA REPORTES FIN*/		
}

