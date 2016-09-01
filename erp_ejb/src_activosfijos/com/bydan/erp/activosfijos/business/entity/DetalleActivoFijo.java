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
package com.bydan.erp.activosfijos.business.entity;

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
//import com.bydan.erp.activosfijos.util.DetalleActivoFijoConstantesFunciones;
import com.bydan.erp.activosfijos.util.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.cartera.util.*;
import com.bydan.erp.contabilidad.util.*;
import com.bydan.erp.facturacion.util.*;
import com.bydan.erp.activosfijos.util.*;



import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.facturacion.business.entity.*;
import com.bydan.erp.activosfijos.business.entity.*;




@SuppressWarnings("unused")
public class DetalleActivoFijo extends DetalleActivoFijoAdditional implements Serializable ,Cloneable {//DetalleActivoFijoAdditional,GeneralEntity
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
	
	private DetalleActivoFijo detalleactivofijoOriginal;
	
	private Map<String, Object> mapDetalleActivoFijo;
			
	public Map<String, Object> getMapDetalleActivoFijo() {
		return mapDetalleActivoFijo;
	}

	public void setMapDetalleActivoFijo(Map<String, Object> mapDetalleActivoFijo) {
		this.mapDetalleActivoFijo = mapDetalleActivoFijo;
	}
	
	public void inicializarMapDetalleActivoFijo() {
		this.mapDetalleActivoFijo = new HashMap<String,Object>();
	}
	
	public void setMapDetalleActivoFijoValue(String sKey,Object oValue) {
		this.mapDetalleActivoFijo.put(sKey, oValue);
	}
	
	public Object getMapDetalleActivoFijoValue(String sKey) {
		return this.mapDetalleActivoFijo.get(sKey);
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
	private Long id_detalle_grupo_activo_fijo;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_sub_grupo_activo_fijo;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_tipo_ramo_activo_fijo;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_tipo_activo_fijo_empresa;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_tipo_depreciacion_empresa;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_estado_activo_fijo;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_cliente;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_partida_presu;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=50,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=DetalleActivoFijoConstantesFunciones.SREGEXCODIGO,message=DetalleActivoFijoConstantesFunciones.SMENSAJEREGEXCODIGO)
	private String codigo;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=100,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=DetalleActivoFijoConstantesFunciones.SREGEXNOMBRE,message=DetalleActivoFijoConstantesFunciones.SMENSAJEREGEXNOMBRE)
	private String nombre;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=20,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=DetalleActivoFijoConstantesFunciones.SREGEXSERIE,message=DetalleActivoFijoConstantesFunciones.SMENSAJEREGEXSERIE)
	private String serie;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Date fecha_compra;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Date fecha_mantenimiento;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Date fecha_correccion;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Date fecha_depreciacion;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=50,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=DetalleActivoFijoConstantesFunciones.SREGEXCLAVE,message=DetalleActivoFijoConstantesFunciones.SMENSAJEREGEXCLAVE)
	private String clave;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=100,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=DetalleActivoFijoConstantesFunciones.SREGEXMARCA,message=DetalleActivoFijoConstantesFunciones.SMENSAJEREGEXMARCA)
	private String marca;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=100,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=DetalleActivoFijoConstantesFunciones.SREGEXMODELO,message=DetalleActivoFijoConstantesFunciones.SMENSAJEREGEXMODELO)
	private String modelo;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=50,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=DetalleActivoFijoConstantesFunciones.SREGEXCOLOR,message=DetalleActivoFijoConstantesFunciones.SMENSAJEREGEXCOLOR)
	private String color;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Date fecha;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double valor_util;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double costo_de_compra;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double vida_util;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double valor_residual;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=10,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONINT)
	private Integer cantidad;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=150,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=DetalleActivoFijoConstantesFunciones.SREGEXNOMBRE_PROPIETARIO,message=DetalleActivoFijoConstantesFunciones.SMENSAJEREGEXNOMBRE_PROPIETARIO)
	private String nombre_propietario;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=100,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=DetalleActivoFijoConstantesFunciones.SREGEXRESPONSABLE,message=DetalleActivoFijoConstantesFunciones.SMENSAJEREGEXRESPONSABLE)
	private String responsable;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=150,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=DetalleActivoFijoConstantesFunciones.SREGEXPATH_FOTO,message=DetalleActivoFijoConstantesFunciones.SMENSAJEREGEXPATH_FOTO)
	private String path_foto;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=50,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=DetalleActivoFijoConstantesFunciones.SREGEXNUMERO_COMPROBANTE,message=DetalleActivoFijoConstantesFunciones.SMENSAJEREGEXNUMERO_COMPROBANTE)
	private String numero_comprobante;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=150,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=DetalleActivoFijoConstantesFunciones.SREGEXREFERENCIA,message=DetalleActivoFijoConstantesFunciones.SMENSAJEREGEXREFERENCIA)
	private String referencia;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double valor_cotizacion;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Boolean con_partes;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Boolean con_garantia;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Boolean con_existencia;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Date fecha_baja;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=150,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=DetalleActivoFijoConstantesFunciones.SREGEXPATH_FOTO2,message=DetalleActivoFijoConstantesFunciones.SMENSAJEREGEXPATH_FOTO2)
	private String path_foto2;
			
	
	public Empresa empresa;
	public Sucursal sucursal;
	public DetalleGrupoActivoFijo detallegrupoactivofijo;
	public SubGrupoActivoFijo subgrupoactivofijo;
	public TipoRamoActivoFijo tiporamoactivofijo;
	public TipoActivoFijoEmpresa tipoactivofijoempresa;
	public TipoDepreciacionEmpresa tipodepreciacionempresa;
	public EstadoActivoFijo estadoactivofijo;
	public Cliente cliente;
	public PartidaPresu partidapresu;
	
	
	private String empresa_descripcion;
	private String sucursal_descripcion;
	private String detallegrupoactivofijo_descripcion;
	private String subgrupoactivofijo_descripcion;
	private String tiporamoactivofijo_descripcion;
	private String tipoactivofijoempresa_descripcion;
	private String tipodepreciacionempresa_descripcion;
	private String estadoactivofijo_descripcion;
	private String cliente_descripcion;
	private String partidapresu_descripcion;
	
	
	public List<MantenimientoActivoFijo> mantenimientoactivofijos;
	public List<ServicioTransporte> serviciotransportes;
	public List<MovimientoActivoFijo> movimientoactivofijoDestinos;
	public List<Vehiculo> vehiculos;
	public List<MetodoDepreciacion> metododepreciacions;
	public List<ResponsableActivoFijo> responsableactivofijos;
	public List<DepreciacionActivoFijo> depreciacionactivofijos;
	public List<GastoDepreciacionCentroCosto> gastodepreciacioncentrocostos;
	public List<ParteActivoFijo> parteactivofijos;
		
	public DetalleActivoFijo () throws Exception {
		super();		
		
		this.id=0L;
		
		
		this.versionRow=new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());//new Date();
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		this.sType="NONE";
		
		this.detalleactivofijoOriginal=this;
		
 		this.id_empresa=-1L;
 		this.id_sucursal=-1L;
 		this.id_detalle_grupo_activo_fijo=-1L;
 		this.id_sub_grupo_activo_fijo=-1L;
 		this.id_tipo_ramo_activo_fijo=-1L;
 		this.id_tipo_activo_fijo_empresa=-1L;
 		this.id_tipo_depreciacion_empresa=-1L;
 		this.id_estado_activo_fijo=-1L;
 		this.id_cliente=-1L;
 		this.id_partida_presu=-1L;
 		this.codigo="";
 		this.nombre="";
 		this.serie="";
 		this.fecha_compra=new Date();
 		this.fecha_mantenimiento=new Date();
 		this.fecha_correccion=new Date();
 		this.fecha_depreciacion=new Date();
 		this.clave="";
 		this.marca="";
 		this.modelo="";
 		this.color="";
 		this.fecha=new Date();
 		this.valor_util=0.0;
 		this.costo_de_compra=0.0;
 		this.vida_util=0.0;
 		this.valor_residual=0.0;
 		this.cantidad=0;
 		this.nombre_propietario="";
 		this.responsable="";
 		this.path_foto="";
 		this.numero_comprobante="";
 		this.referencia="";
 		this.valor_cotizacion=0.0;
 		this.con_partes=false;
 		this.con_garantia=false;
 		this.con_existencia=false;
 		this.fecha_baja=new Date();
 		this.path_foto2="";
		
		
		this.empresa=null;
		this.sucursal=null;
		this.detallegrupoactivofijo=null;
		this.subgrupoactivofijo=null;
		this.tiporamoactivofijo=null;
		this.tipoactivofijoempresa=null;
		this.tipodepreciacionempresa=null;
		this.estadoactivofijo=null;
		this.cliente=null;
		this.partidapresu=null;
		
		
		this.empresa_descripcion="";
		this.sucursal_descripcion="";
		this.detallegrupoactivofijo_descripcion="";
		this.subgrupoactivofijo_descripcion="";
		this.tiporamoactivofijo_descripcion="";
		this.tipoactivofijoempresa_descripcion="";
		this.tipodepreciacionempresa_descripcion="";
		this.estadoactivofijo_descripcion="";
		this.cliente_descripcion="";
		this.partidapresu_descripcion="";
		
		
		this.mantenimientoactivofijos=null;
		this.serviciotransportes=null;
		this.movimientoactivofijoDestinos=null;
		this.vehiculos=null;
		this.metododepreciacions=null;
		this.responsableactivofijos=null;
		this.depreciacionactivofijos=null;
		this.gastodepreciacioncentrocostos=null;
		this.parteactivofijos=null;
		
			
		
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
    //PARA REPORTES
	public DetalleActivoFijo (Long id,Date versionRow,Long id_empresa,Long id_sucursal,Long id_detalle_grupo_activo_fijo,Long id_sub_grupo_activo_fijo,Long id_tipo_ramo_activo_fijo,Long id_tipo_activo_fijo_empresa,Long id_tipo_depreciacion_empresa,Long id_estado_activo_fijo,Long id_cliente,Long id_partida_presu,String codigo,String nombre,String serie,Date fecha_compra,Date fecha_mantenimiento,Date fecha_correccion,Date fecha_depreciacion,String clave,String marca,String modelo,String color,Date fecha,Double valor_util,Double costo_de_compra,Double vida_util,Double valor_residual,Integer cantidad,String nombre_propietario,String responsable,String path_foto,String numero_comprobante,String referencia,Double valor_cotizacion,Boolean con_partes,Boolean con_garantia,Boolean con_existencia,Date fecha_baja,String path_foto2) throws Exception {
		super();		
		
		this.id=id;
		this.versionRow=versionRow;
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.detalleactivofijoOriginal=this;
		
 		this.id_empresa=id_empresa;
 		this.id_sucursal=id_sucursal;
 		this.id_detalle_grupo_activo_fijo=id_detalle_grupo_activo_fijo;
 		this.id_sub_grupo_activo_fijo=id_sub_grupo_activo_fijo;
 		this.id_tipo_ramo_activo_fijo=id_tipo_ramo_activo_fijo;
 		this.id_tipo_activo_fijo_empresa=id_tipo_activo_fijo_empresa;
 		this.id_tipo_depreciacion_empresa=id_tipo_depreciacion_empresa;
 		this.id_estado_activo_fijo=id_estado_activo_fijo;
 		this.id_cliente=id_cliente;
 		this.id_partida_presu=id_partida_presu;
 		this.codigo=codigo;
 		this.nombre=nombre;
 		this.serie=serie;
 		this.fecha_compra=fecha_compra;
 		this.fecha_mantenimiento=fecha_mantenimiento;
 		this.fecha_correccion=fecha_correccion;
 		this.fecha_depreciacion=fecha_depreciacion;
 		this.clave=clave;
 		this.marca=marca;
 		this.modelo=modelo;
 		this.color=color;
 		this.fecha=fecha;
 		this.valor_util=valor_util;
 		this.costo_de_compra=costo_de_compra;
 		this.vida_util=vida_util;
 		this.valor_residual=valor_residual;
 		this.cantidad=cantidad;
 		this.nombre_propietario=nombre_propietario;
 		this.responsable=responsable;
 		this.path_foto=path_foto;
 		this.numero_comprobante=numero_comprobante;
 		this.referencia=referencia;
 		this.valor_cotizacion=valor_cotizacion;
 		this.con_partes=con_partes;
 		this.con_garantia=con_garantia;
 		this.con_existencia=con_existencia;
 		this.fecha_baja=fecha_baja;
 		this.path_foto2=path_foto2;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	 //PARA REPORTES
	public DetalleActivoFijo (Long id_empresa,Long id_sucursal,Long id_detalle_grupo_activo_fijo,Long id_sub_grupo_activo_fijo,Long id_tipo_ramo_activo_fijo,Long id_tipo_activo_fijo_empresa,Long id_tipo_depreciacion_empresa,Long id_estado_activo_fijo,Long id_cliente,Long id_partida_presu,String codigo,String nombre,String serie,Date fecha_compra,Date fecha_mantenimiento,Date fecha_correccion,Date fecha_depreciacion,String clave,String marca,String modelo,String color,Date fecha,Double valor_util,Double costo_de_compra,Double vida_util,Double valor_residual,Integer cantidad,String nombre_propietario,String responsable,String path_foto,String numero_comprobante,String referencia,Double valor_cotizacion,Boolean con_partes,Boolean con_garantia,Boolean con_existencia,Date fecha_baja,String path_foto2) throws Exception {
		super();		
		
		this.id=0L;
		this.versionRow=new Date();
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.detalleactivofijoOriginal=this;
		
 		this.id_empresa=id_empresa;
 		this.id_sucursal=id_sucursal;
 		this.id_detalle_grupo_activo_fijo=id_detalle_grupo_activo_fijo;
 		this.id_sub_grupo_activo_fijo=id_sub_grupo_activo_fijo;
 		this.id_tipo_ramo_activo_fijo=id_tipo_ramo_activo_fijo;
 		this.id_tipo_activo_fijo_empresa=id_tipo_activo_fijo_empresa;
 		this.id_tipo_depreciacion_empresa=id_tipo_depreciacion_empresa;
 		this.id_estado_activo_fijo=id_estado_activo_fijo;
 		this.id_cliente=id_cliente;
 		this.id_partida_presu=id_partida_presu;
 		this.codigo=codigo;
 		this.nombre=nombre;
 		this.serie=serie;
 		this.fecha_compra=fecha_compra;
 		this.fecha_mantenimiento=fecha_mantenimiento;
 		this.fecha_correccion=fecha_correccion;
 		this.fecha_depreciacion=fecha_depreciacion;
 		this.clave=clave;
 		this.marca=marca;
 		this.modelo=modelo;
 		this.color=color;
 		this.fecha=fecha;
 		this.valor_util=valor_util;
 		this.costo_de_compra=costo_de_compra;
 		this.vida_util=vida_util;
 		this.valor_residual=valor_residual;
 		this.cantidad=cantidad;
 		this.nombre_propietario=nombre_propietario;
 		this.responsable=responsable;
 		this.path_foto=path_foto;
 		this.numero_comprobante=numero_comprobante;
 		this.referencia=referencia;
 		this.valor_cotizacion=valor_cotizacion;
 		this.con_partes=con_partes;
 		this.con_garantia=con_garantia;
 		this.con_existencia=con_existencia;
 		this.fecha_baja=fecha_baja;
 		this.path_foto2=path_foto2;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	public boolean equals(Object object) {
		boolean equal=false;
		DetalleActivoFijo detalleactivofijoLocal=null;
		
		if(object!=null) {
			detalleactivofijoLocal=(DetalleActivoFijo)object;
			
			if(detalleactivofijoLocal!=null) {
				if(this.getId()!=null && detalleactivofijoLocal.getId()!=null) {
					if(this.getId().equals(detalleactivofijoLocal.getId())) {
						equal=true;
					}
				}
			}
		}
		
		return equal;
	}
	
	public String toString() {
		String sDetalle="";
		
		if(!DetalleActivoFijoConstantesFunciones.CON_DESCRIPCION_DETALLADO) {
        	sDetalle=DetalleActivoFijoConstantesFunciones.getDetalleActivoFijoDescripcion(this);
		} else {
			sDetalle=DetalleActivoFijoConstantesFunciones.getDetalleActivoFijoDescripcionDetallado(this);
		}
		
		return sDetalle;
    }
	
	public DetalleActivoFijo getDetalleActivoFijoOriginal() {
		return this.detalleactivofijoOriginal;
	}
	
	public void setDetalleActivoFijoOriginal(DetalleActivoFijo detalleactivofijo) {
		try {
			this.detalleactivofijoOriginal=detalleactivofijo;
		} catch(Exception e) {
			;
		}
	}
	
	
	protected DetalleActivoFijoAdditional detalleactivofijoAdditional=null;
	
	public DetalleActivoFijoAdditional getDetalleActivoFijoAdditional() {
		return this.detalleactivofijoAdditional;
	}
	
	public void setDetalleActivoFijoAdditional(DetalleActivoFijoAdditional detalleactivofijoAdditional) {
		try {
			this.detalleactivofijoAdditional=detalleactivofijoAdditional;
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
    
	
	public Long getid_detalle_grupo_activo_fijo() {
		return this.id_detalle_grupo_activo_fijo;
	}
    
	
	public Long getid_sub_grupo_activo_fijo() {
		return this.id_sub_grupo_activo_fijo;
	}
    
	
	public Long getid_tipo_ramo_activo_fijo() {
		return this.id_tipo_ramo_activo_fijo;
	}
    
	
	public Long getid_tipo_activo_fijo_empresa() {
		return this.id_tipo_activo_fijo_empresa;
	}
    
	
	public Long getid_tipo_depreciacion_empresa() {
		return this.id_tipo_depreciacion_empresa;
	}
    
	
	public Long getid_estado_activo_fijo() {
		return this.id_estado_activo_fijo;
	}
    
	
	public Long getid_cliente() {
		return this.id_cliente;
	}
    
	
	public Long getid_partida_presu() {
		return this.id_partida_presu;
	}
    
	
	public String getcodigo() {
		return this.codigo;
	}
    
	
	public String getnombre() {
		return this.nombre;
	}
    
	
	public String getserie() {
		return this.serie;
	}
    
	
	public Date getfecha_compra() {
		return this.fecha_compra;
	}
    
	
	public Date getfecha_mantenimiento() {
		return this.fecha_mantenimiento;
	}
    
	
	public Date getfecha_correccion() {
		return this.fecha_correccion;
	}
    
	
	public Date getfecha_depreciacion() {
		return this.fecha_depreciacion;
	}
    
	
	public String getclave() {
		return this.clave;
	}
    
	
	public String getmarca() {
		return this.marca;
	}
    
	
	public String getmodelo() {
		return this.modelo;
	}
    
	
	public String getcolor() {
		return this.color;
	}
    
	
	public Date getfecha() {
		return this.fecha;
	}
    
	
	public Double getvalor_util() {
		return this.valor_util;
	}
    
	
	public Double getcosto_de_compra() {
		return this.costo_de_compra;
	}
    
	
	public Double getvida_util() {
		return this.vida_util;
	}
    
	
	public Double getvalor_residual() {
		return this.valor_residual;
	}
    
	
	public Integer getcantidad() {
		return this.cantidad;
	}
    
	
	public String getnombre_propietario() {
		return this.nombre_propietario;
	}
    
	
	public String getresponsable() {
		return this.responsable;
	}
    
	
	public String getpath_foto() {
		return this.path_foto;
	}
    
	
	public String getnumero_comprobante() {
		return this.numero_comprobante;
	}
    
	
	public String getreferencia() {
		return this.referencia;
	}
    
	
	public Double getvalor_cotizacion() {
		return this.valor_cotizacion;
	}
    
	
	public Boolean getcon_partes() {
		return this.con_partes;
	}
    
	
	public Boolean getcon_garantia() {
		return this.con_garantia;
	}
    
	
	public Boolean getcon_existencia() {
		return this.con_existencia;
	}
    
	
	public Date getfecha_baja() {
		return this.fecha_baja;
	}
    
	
	public String getpath_foto2() {
		return this.path_foto2;
	}
	
    
	public void setid_empresa(Long newid_empresa)throws Exception
	{
		try {
			if(this.id_empresa!=newid_empresa) {
				if(newid_empresa==null) {
					//newid_empresa=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("DetalleActivoFijo:Valor nulo no permitido en columna id_empresa");
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
						System.out.println("DetalleActivoFijo:Valor nulo no permitido en columna id_sucursal");
					}
				}

				this.id_sucursal=newid_sucursal;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_detalle_grupo_activo_fijo(Long newid_detalle_grupo_activo_fijo)throws Exception
	{
		try {
			if(this.id_detalle_grupo_activo_fijo!=newid_detalle_grupo_activo_fijo) {
				if(newid_detalle_grupo_activo_fijo==null) {
					//newid_detalle_grupo_activo_fijo=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("DetalleActivoFijo:Valor nulo no permitido en columna id_detalle_grupo_activo_fijo");
					}
				}

				this.id_detalle_grupo_activo_fijo=newid_detalle_grupo_activo_fijo;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_sub_grupo_activo_fijo(Long newid_sub_grupo_activo_fijo)throws Exception
	{
		try {
			if(this.id_sub_grupo_activo_fijo!=newid_sub_grupo_activo_fijo) {
				if(newid_sub_grupo_activo_fijo==null) {
					//newid_sub_grupo_activo_fijo=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("DetalleActivoFijo:Valor nulo no permitido en columna id_sub_grupo_activo_fijo");
					}
				}

				this.id_sub_grupo_activo_fijo=newid_sub_grupo_activo_fijo;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_tipo_ramo_activo_fijo(Long newid_tipo_ramo_activo_fijo)throws Exception
	{
		try {
			if(this.id_tipo_ramo_activo_fijo!=newid_tipo_ramo_activo_fijo) {
				if(newid_tipo_ramo_activo_fijo==null) {
					//newid_tipo_ramo_activo_fijo=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("DetalleActivoFijo:Valor nulo no permitido en columna id_tipo_ramo_activo_fijo");
					}
				}

				this.id_tipo_ramo_activo_fijo=newid_tipo_ramo_activo_fijo;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_tipo_activo_fijo_empresa(Long newid_tipo_activo_fijo_empresa)throws Exception
	{
		try {
			if(this.id_tipo_activo_fijo_empresa!=newid_tipo_activo_fijo_empresa) {
				if(newid_tipo_activo_fijo_empresa==null) {
					//newid_tipo_activo_fijo_empresa=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("DetalleActivoFijo:Valor nulo no permitido en columna id_tipo_activo_fijo_empresa");
					}
				}

				this.id_tipo_activo_fijo_empresa=newid_tipo_activo_fijo_empresa;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_tipo_depreciacion_empresa(Long newid_tipo_depreciacion_empresa)throws Exception
	{
		try {
			if(this.id_tipo_depreciacion_empresa!=newid_tipo_depreciacion_empresa) {
				if(newid_tipo_depreciacion_empresa==null) {
					//newid_tipo_depreciacion_empresa=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("DetalleActivoFijo:Valor nulo no permitido en columna id_tipo_depreciacion_empresa");
					}
				}

				this.id_tipo_depreciacion_empresa=newid_tipo_depreciacion_empresa;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_estado_activo_fijo(Long newid_estado_activo_fijo)throws Exception
	{
		try {
			if(this.id_estado_activo_fijo!=newid_estado_activo_fijo) {
				if(newid_estado_activo_fijo==null) {
					//newid_estado_activo_fijo=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("DetalleActivoFijo:Valor nulo no permitido en columna id_estado_activo_fijo");
					}
				}

				this.id_estado_activo_fijo=newid_estado_activo_fijo;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_cliente(Long newid_cliente)throws Exception
	{
		try {
			if(this.id_cliente!=newid_cliente) {
				if(newid_cliente==null) {
					//newid_cliente=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("DetalleActivoFijo:Valor nulo no permitido en columna id_cliente");
					}
				}

				this.id_cliente=newid_cliente;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_partida_presu(Long newid_partida_presu)throws Exception
	{
		try {
			if(this.id_partida_presu!=newid_partida_presu) {
				if(newid_partida_presu==null) {
					//newid_partida_presu=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("DetalleActivoFijo:Valor nulo no permitido en columna id_partida_presu");
					}
				}

				this.id_partida_presu=newid_partida_presu;
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
						System.out.println("DetalleActivoFijo:Valor nulo no permitido en columna codigo");
					}
				}

				if(newcodigo!=null&&newcodigo.length()>50) {
					newcodigo=newcodigo.substring(0,48);
					System.out.println("DetalleActivoFijo:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=50 en columna codigo");
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
						System.out.println("DetalleActivoFijo:Valor nulo no permitido en columna nombre");
					}
				}

				if(newnombre!=null&&newnombre.length()>100) {
					newnombre=newnombre.substring(0,98);
					System.out.println("DetalleActivoFijo:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=100 en columna nombre");
				}

				this.nombre=newnombre;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setserie(String newserie)throws Exception
	{
		try {
			if(this.serie!=newserie) {
				if(newserie==null) {
					//newserie="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("DetalleActivoFijo:Valor nulo no permitido en columna serie");
					}
				}

				if(newserie!=null&&newserie.length()>20) {
					newserie=newserie.substring(0,18);
					System.out.println("DetalleActivoFijo:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=20 en columna serie");
				}

				this.serie=newserie;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setfecha_compra(Date newfecha_compra)throws Exception
	{
		try {
			if(this.fecha_compra!=newfecha_compra) {
				if(newfecha_compra==null) {
					//newfecha_compra=new Date();
					if(Constantes.ISDEVELOPING) {
						System.out.println("DetalleActivoFijo:Valor nulo no permitido en columna fecha_compra");
					}
				}

				this.fecha_compra=newfecha_compra;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setfecha_mantenimiento(Date newfecha_mantenimiento)throws Exception
	{
		try {
			if(this.fecha_mantenimiento!=newfecha_mantenimiento) {
				if(newfecha_mantenimiento==null) {
					//newfecha_mantenimiento=new Date();
					if(Constantes.ISDEVELOPING) {
						System.out.println("DetalleActivoFijo:Valor nulo no permitido en columna fecha_mantenimiento");
					}
				}

				this.fecha_mantenimiento=newfecha_mantenimiento;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setfecha_correccion(Date newfecha_correccion)throws Exception
	{
		try {
			if(this.fecha_correccion!=newfecha_correccion) {
				if(newfecha_correccion==null) {
					//newfecha_correccion=new Date();
					if(Constantes.ISDEVELOPING) {
						System.out.println("DetalleActivoFijo:Valor nulo no permitido en columna fecha_correccion");
					}
				}

				this.fecha_correccion=newfecha_correccion;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setfecha_depreciacion(Date newfecha_depreciacion)throws Exception
	{
		try {
			if(this.fecha_depreciacion!=newfecha_depreciacion) {
				if(newfecha_depreciacion==null) {
					//newfecha_depreciacion=new Date();
					if(Constantes.ISDEVELOPING) {
						System.out.println("DetalleActivoFijo:Valor nulo no permitido en columna fecha_depreciacion");
					}
				}

				this.fecha_depreciacion=newfecha_depreciacion;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setclave(String newclave)throws Exception
	{
		try {
			if(this.clave!=newclave) {
				if(newclave==null) {
					//newclave="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("DetalleActivoFijo:Valor nulo no permitido en columna clave");
					}
				}

				if(newclave!=null&&newclave.length()>50) {
					newclave=newclave.substring(0,48);
					System.out.println("DetalleActivoFijo:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=50 en columna clave");
				}

				this.clave=newclave;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setmarca(String newmarca)throws Exception
	{
		try {
			if(this.marca!=newmarca) {
				if(newmarca==null) {
					//newmarca="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("DetalleActivoFijo:Valor nulo no permitido en columna marca");
					}
				}

				if(newmarca!=null&&newmarca.length()>100) {
					newmarca=newmarca.substring(0,98);
					System.out.println("DetalleActivoFijo:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=100 en columna marca");
				}

				this.marca=newmarca;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setmodelo(String newmodelo)throws Exception
	{
		try {
			if(this.modelo!=newmodelo) {
				if(newmodelo==null) {
					//newmodelo="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("DetalleActivoFijo:Valor nulo no permitido en columna modelo");
					}
				}

				if(newmodelo!=null&&newmodelo.length()>100) {
					newmodelo=newmodelo.substring(0,98);
					System.out.println("DetalleActivoFijo:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=100 en columna modelo");
				}

				this.modelo=newmodelo;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setcolor(String newcolor)throws Exception
	{
		try {
			if(this.color!=newcolor) {
				if(newcolor==null) {
					//newcolor="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("DetalleActivoFijo:Valor nulo no permitido en columna color");
					}
				}

				if(newcolor!=null&&newcolor.length()>50) {
					newcolor=newcolor.substring(0,48);
					System.out.println("DetalleActivoFijo:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=50 en columna color");
				}

				this.color=newcolor;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setfecha(Date newfecha)throws Exception
	{
		try {
			if(this.fecha!=newfecha) {
				if(newfecha==null) {
					//newfecha=new Date();
					if(Constantes.ISDEVELOPING) {
						System.out.println("DetalleActivoFijo:Valor nulo no permitido en columna fecha");
					}
				}

				this.fecha=newfecha;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setvalor_util(Double newvalor_util)throws Exception
	{
		try {
			if(this.valor_util!=newvalor_util) {
				if(newvalor_util==null) {
					//newvalor_util=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("DetalleActivoFijo:Valor nulo no permitido en columna valor_util");
					}
				}

				this.valor_util=newvalor_util;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setcosto_de_compra(Double newcosto_de_compra)throws Exception
	{
		try {
			if(this.costo_de_compra!=newcosto_de_compra) {
				if(newcosto_de_compra==null) {
					//newcosto_de_compra=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("DetalleActivoFijo:Valor nulo no permitido en columna costo_de_compra");
					}
				}

				this.costo_de_compra=newcosto_de_compra;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setvida_util(Double newvida_util)throws Exception
	{
		try {
			if(this.vida_util!=newvida_util) {
				if(newvida_util==null) {
					//newvida_util=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("DetalleActivoFijo:Valor nulo no permitido en columna vida_util");
					}
				}

				this.vida_util=newvida_util;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setvalor_residual(Double newvalor_residual)throws Exception
	{
		try {
			if(this.valor_residual!=newvalor_residual) {
				if(newvalor_residual==null) {
					//newvalor_residual=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("DetalleActivoFijo:Valor nulo no permitido en columna valor_residual");
					}
				}

				this.valor_residual=newvalor_residual;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setcantidad(Integer newcantidad)throws Exception
	{
		try {
			if(this.cantidad!=newcantidad) {
				if(newcantidad==null) {
					//newcantidad=0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("DetalleActivoFijo:Valor nulo no permitido en columna cantidad");
					}
				}

				this.cantidad=newcantidad;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setnombre_propietario(String newnombre_propietario)throws Exception
	{
		try {
			if(this.nombre_propietario!=newnombre_propietario) {
				if(newnombre_propietario==null) {
					//newnombre_propietario="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("DetalleActivoFijo:Valor nulo no permitido en columna nombre_propietario");
					}
				}

				if(newnombre_propietario!=null&&newnombre_propietario.length()>150) {
					newnombre_propietario=newnombre_propietario.substring(0,148);
					System.out.println("DetalleActivoFijo:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=150 en columna nombre_propietario");
				}

				this.nombre_propietario=newnombre_propietario;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setresponsable(String newresponsable)throws Exception
	{
		try {
			if(this.responsable!=newresponsable) {
				if(newresponsable==null) {
					//newresponsable="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("DetalleActivoFijo:Valor nulo no permitido en columna responsable");
					}
				}

				if(newresponsable!=null&&newresponsable.length()>100) {
					newresponsable=newresponsable.substring(0,98);
					System.out.println("DetalleActivoFijo:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=100 en columna responsable");
				}

				this.responsable=newresponsable;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setpath_foto(String newpath_foto)throws Exception
	{
		try {
			if(this.path_foto!=newpath_foto) {
				if(newpath_foto==null) {
					//newpath_foto="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("DetalleActivoFijo:Valor nulo no permitido en columna path_foto");
					}
				}

				if(newpath_foto!=null&&newpath_foto.length()>150) {
					newpath_foto=newpath_foto.substring(0,148);
					System.out.println("DetalleActivoFijo:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=150 en columna path_foto");
				}

				this.path_foto=newpath_foto;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setnumero_comprobante(String newnumero_comprobante)throws Exception
	{
		try {
			if(this.numero_comprobante!=newnumero_comprobante) {
				if(newnumero_comprobante==null) {
					//newnumero_comprobante="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("DetalleActivoFijo:Valor nulo no permitido en columna numero_comprobante");
					}
				}

				if(newnumero_comprobante!=null&&newnumero_comprobante.length()>50) {
					newnumero_comprobante=newnumero_comprobante.substring(0,48);
					System.out.println("DetalleActivoFijo:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=50 en columna numero_comprobante");
				}

				this.numero_comprobante=newnumero_comprobante;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setreferencia(String newreferencia)throws Exception
	{
		try {
			if(this.referencia!=newreferencia) {
				if(newreferencia==null) {
					//newreferencia="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("DetalleActivoFijo:Valor nulo no permitido en columna referencia");
					}
				}

				if(newreferencia!=null&&newreferencia.length()>150) {
					newreferencia=newreferencia.substring(0,148);
					System.out.println("DetalleActivoFijo:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=150 en columna referencia");
				}

				this.referencia=newreferencia;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setvalor_cotizacion(Double newvalor_cotizacion)throws Exception
	{
		try {
			if(this.valor_cotizacion!=newvalor_cotizacion) {
				if(newvalor_cotizacion==null) {
					//newvalor_cotizacion=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("DetalleActivoFijo:Valor nulo no permitido en columna valor_cotizacion");
					}
				}

				this.valor_cotizacion=newvalor_cotizacion;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setcon_partes(Boolean newcon_partes)throws Exception
	{
		try {
			if(this.con_partes!=newcon_partes) {
				if(newcon_partes==null) {
					//newcon_partes=false;
					if(Constantes.ISDEVELOPING) {
						System.out.println("DetalleActivoFijo:Valor nulo no permitido en columna con_partes");
					}
				}

				this.con_partes=newcon_partes;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setcon_garantia(Boolean newcon_garantia)throws Exception
	{
		try {
			if(this.con_garantia!=newcon_garantia) {
				if(newcon_garantia==null) {
					//newcon_garantia=false;
					if(Constantes.ISDEVELOPING) {
						System.out.println("DetalleActivoFijo:Valor nulo no permitido en columna con_garantia");
					}
				}

				this.con_garantia=newcon_garantia;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setcon_existencia(Boolean newcon_existencia)throws Exception
	{
		try {
			if(this.con_existencia!=newcon_existencia) {
				if(newcon_existencia==null) {
					//newcon_existencia=false;
					if(Constantes.ISDEVELOPING) {
						System.out.println("DetalleActivoFijo:Valor nulo no permitido en columna con_existencia");
					}
				}

				this.con_existencia=newcon_existencia;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setfecha_baja(Date newfecha_baja)throws Exception
	{
		try {
			if(this.fecha_baja!=newfecha_baja) {
				if(newfecha_baja==null) {
					//newfecha_baja=new Date();
					if(Constantes.ISDEVELOPING) {
						System.out.println("DetalleActivoFijo:Valor nulo no permitido en columna fecha_baja");
					}
				}

				this.fecha_baja=newfecha_baja;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setpath_foto2(String newpath_foto2)throws Exception
	{
		try {
			if(this.path_foto2!=newpath_foto2) {
				if(newpath_foto2==null) {
					//newpath_foto2="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("DetalleActivoFijo:Valor nulo no permitido en columna path_foto2");
					}
				}

				if(newpath_foto2!=null&&newpath_foto2.length()>150) {
					newpath_foto2=newpath_foto2.substring(0,148);
					System.out.println("DetalleActivoFijo:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=150 en columna path_foto2");
				}

				this.path_foto2=newpath_foto2;
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

	public DetalleGrupoActivoFijo getDetalleGrupoActivoFijo() {
		return this.detallegrupoactivofijo;
	}

	public SubGrupoActivoFijo getSubGrupoActivoFijo() {
		return this.subgrupoactivofijo;
	}

	public TipoRamoActivoFijo getTipoRamoActivoFijo() {
		return this.tiporamoactivofijo;
	}

	public TipoActivoFijoEmpresa getTipoActivoFijoEmpresa() {
		return this.tipoactivofijoempresa;
	}

	public TipoDepreciacionEmpresa getTipoDepreciacionEmpresa() {
		return this.tipodepreciacionempresa;
	}

	public EstadoActivoFijo getEstadoActivoFijo() {
		return this.estadoactivofijo;
	}

	public Cliente getCliente() {
		return this.cliente;
	}

	public PartidaPresu getPartidaPresu() {
		return this.partidapresu;
	}

	
	
	public String getempresa_descripcion() {
		return this.empresa_descripcion;
	}

	public String getsucursal_descripcion() {
		return this.sucursal_descripcion;
	}

	public String getdetallegrupoactivofijo_descripcion() {
		return this.detallegrupoactivofijo_descripcion;
	}

	public String getsubgrupoactivofijo_descripcion() {
		return this.subgrupoactivofijo_descripcion;
	}

	public String gettiporamoactivofijo_descripcion() {
		return this.tiporamoactivofijo_descripcion;
	}

	public String gettipoactivofijoempresa_descripcion() {
		return this.tipoactivofijoempresa_descripcion;
	}

	public String gettipodepreciacionempresa_descripcion() {
		return this.tipodepreciacionempresa_descripcion;
	}

	public String getestadoactivofijo_descripcion() {
		return this.estadoactivofijo_descripcion;
	}

	public String getcliente_descripcion() {
		return this.cliente_descripcion;
	}

	public String getpartidapresu_descripcion() {
		return this.partidapresu_descripcion;
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


	public  void  setDetalleGrupoActivoFijo(DetalleGrupoActivoFijo detallegrupoactivofijo) {
		try {
			this.detallegrupoactivofijo=detallegrupoactivofijo;
		} catch(Exception e) {
			;
		}
	}


	public  void  setSubGrupoActivoFijo(SubGrupoActivoFijo subgrupoactivofijo) {
		try {
			this.subgrupoactivofijo=subgrupoactivofijo;
		} catch(Exception e) {
			;
		}
	}


	public  void  setTipoRamoActivoFijo(TipoRamoActivoFijo tiporamoactivofijo) {
		try {
			this.tiporamoactivofijo=tiporamoactivofijo;
		} catch(Exception e) {
			;
		}
	}


	public  void  setTipoActivoFijoEmpresa(TipoActivoFijoEmpresa tipoactivofijoempresa) {
		try {
			this.tipoactivofijoempresa=tipoactivofijoempresa;
		} catch(Exception e) {
			;
		}
	}


	public  void  setTipoDepreciacionEmpresa(TipoDepreciacionEmpresa tipodepreciacionempresa) {
		try {
			this.tipodepreciacionempresa=tipodepreciacionempresa;
		} catch(Exception e) {
			;
		}
	}


	public  void  setEstadoActivoFijo(EstadoActivoFijo estadoactivofijo) {
		try {
			this.estadoactivofijo=estadoactivofijo;
		} catch(Exception e) {
			;
		}
	}


	public  void  setCliente(Cliente cliente) {
		try {
			this.cliente=cliente;
		} catch(Exception e) {
			;
		}
	}


	public  void  setPartidaPresu(PartidaPresu partidapresu) {
		try {
			this.partidapresu=partidapresu;
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


	public  void  setdetallegrupoactivofijo_descripcion(String detallegrupoactivofijo_descripcion) {
		try {
			this.detallegrupoactivofijo_descripcion=detallegrupoactivofijo_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  setsubgrupoactivofijo_descripcion(String subgrupoactivofijo_descripcion) {
		try {
			this.subgrupoactivofijo_descripcion=subgrupoactivofijo_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  settiporamoactivofijo_descripcion(String tiporamoactivofijo_descripcion) {
		try {
			this.tiporamoactivofijo_descripcion=tiporamoactivofijo_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  settipoactivofijoempresa_descripcion(String tipoactivofijoempresa_descripcion) {
		try {
			this.tipoactivofijoempresa_descripcion=tipoactivofijoempresa_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  settipodepreciacionempresa_descripcion(String tipodepreciacionempresa_descripcion) {
		try {
			this.tipodepreciacionempresa_descripcion=tipodepreciacionempresa_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  setestadoactivofijo_descripcion(String estadoactivofijo_descripcion) {
		try {
			this.estadoactivofijo_descripcion=estadoactivofijo_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  setcliente_descripcion(String cliente_descripcion) {
		try {
			this.cliente_descripcion=cliente_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  setpartidapresu_descripcion(String partidapresu_descripcion) {
		try {
			this.partidapresu_descripcion=partidapresu_descripcion;
		} catch(Exception e) {
			;
		}
	}


	
	
	public List<MantenimientoActivoFijo> getMantenimientoActivoFijos() {
		return this.mantenimientoactivofijos;
	}

	public List<ServicioTransporte> getServicioTransportes() {
		return this.serviciotransportes;
	}

	public List<MovimientoActivoFijo> getMovimientoActivoFijoDestinos() {
		return this.movimientoactivofijoDestinos;
	}

	public List<Vehiculo> getVehiculos() {
		return this.vehiculos;
	}

	public List<MetodoDepreciacion> getMetodoDepreciacions() {
		return this.metododepreciacions;
	}

	public List<ResponsableActivoFijo> getResponsableActivoFijos() {
		return this.responsableactivofijos;
	}

	public List<DepreciacionActivoFijo> getDepreciacionActivoFijos() {
		return this.depreciacionactivofijos;
	}

	public List<GastoDepreciacionCentroCosto> getGastoDepreciacionCentroCostos() {
		return this.gastodepreciacioncentrocostos;
	}

	public List<ParteActivoFijo> getParteActivoFijos() {
		return this.parteactivofijos;
	}

	
	
	public  void  setMantenimientoActivoFijos(List<MantenimientoActivoFijo> mantenimientoactivofijos) {
		try {
			this.mantenimientoactivofijos=mantenimientoactivofijos;
		} catch(Exception e) {
			;
		}
	}

	public  void  setServicioTransportes(List<ServicioTransporte> serviciotransportes) {
		try {
			this.serviciotransportes=serviciotransportes;
		} catch(Exception e) {
			;
		}
	}

	public  void  setMovimientoActivoFijoDestinos(List<MovimientoActivoFijo> movimientoactivofijoDestinos) {
		try {
			this.movimientoactivofijoDestinos=movimientoactivofijoDestinos;
		} catch(Exception e) {
			;
		}
	}

	public  void  setVehiculos(List<Vehiculo> vehiculos) {
		try {
			this.vehiculos=vehiculos;
		} catch(Exception e) {
			;
		}
	}

	public  void  setMetodoDepreciacions(List<MetodoDepreciacion> metododepreciacions) {
		try {
			this.metododepreciacions=metododepreciacions;
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

	public  void  setDepreciacionActivoFijos(List<DepreciacionActivoFijo> depreciacionactivofijos) {
		try {
			this.depreciacionactivofijos=depreciacionactivofijos;
		} catch(Exception e) {
			;
		}
	}

	public  void  setGastoDepreciacionCentroCostos(List<GastoDepreciacionCentroCosto> gastodepreciacioncentrocostos) {
		try {
			this.gastodepreciacioncentrocostos=gastodepreciacioncentrocostos;
		} catch(Exception e) {
			;
		}
	}

	public  void  setParteActivoFijos(List<ParteActivoFijo> parteactivofijos) {
		try {
			this.parteactivofijos=parteactivofijos;
		} catch(Exception e) {
			;
		}
	}

	
	/*PARA REPORTES*/
	String id_empresa_descripcion="";String id_sucursal_descripcion="";String id_detalle_grupo_activo_fijo_descripcion="";String id_sub_grupo_activo_fijo_descripcion="";String id_tipo_ramo_activo_fijo_descripcion="";String id_tipo_activo_fijo_empresa_descripcion="";String id_tipo_depreciacion_empresa_descripcion="";String id_estado_activo_fijo_descripcion="";String id_cliente_descripcion="";String id_partida_presu_descripcion="";String con_partes_descripcion="";String con_garantia_descripcion="";String con_existencia_descripcion="";
	
	
	public String getid_empresa_descripcion() {
		return id_empresa_descripcion;
	}
	public String getid_sucursal_descripcion() {
		return id_sucursal_descripcion;
	}
	public String getid_detalle_grupo_activo_fijo_descripcion() {
		return id_detalle_grupo_activo_fijo_descripcion;
	}
	public String getid_sub_grupo_activo_fijo_descripcion() {
		return id_sub_grupo_activo_fijo_descripcion;
	}
	public String getid_tipo_ramo_activo_fijo_descripcion() {
		return id_tipo_ramo_activo_fijo_descripcion;
	}
	public String getid_tipo_activo_fijo_empresa_descripcion() {
		return id_tipo_activo_fijo_empresa_descripcion;
	}
	public String getid_tipo_depreciacion_empresa_descripcion() {
		return id_tipo_depreciacion_empresa_descripcion;
	}
	public String getid_estado_activo_fijo_descripcion() {
		return id_estado_activo_fijo_descripcion;
	}
	public String getid_cliente_descripcion() {
		return id_cliente_descripcion;
	}
	public String getid_partida_presu_descripcion() {
		return id_partida_presu_descripcion;
	}
	public String getcon_partes_descripcion() {
		return con_partes_descripcion;
	}
	public String getcon_garantia_descripcion() {
		return con_garantia_descripcion;
	}
	public String getcon_existencia_descripcion() {
		return con_existencia_descripcion;
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
	public void setid_detalle_grupo_activo_fijo_descripcion(String newid_detalle_grupo_activo_fijo_descripcion)throws Exception {
		try {
			this.id_detalle_grupo_activo_fijo_descripcion=newid_detalle_grupo_activo_fijo_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_sub_grupo_activo_fijo_descripcion(String newid_sub_grupo_activo_fijo_descripcion)throws Exception {
		try {
			this.id_sub_grupo_activo_fijo_descripcion=newid_sub_grupo_activo_fijo_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_tipo_ramo_activo_fijo_descripcion(String newid_tipo_ramo_activo_fijo_descripcion)throws Exception {
		try {
			this.id_tipo_ramo_activo_fijo_descripcion=newid_tipo_ramo_activo_fijo_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_tipo_activo_fijo_empresa_descripcion(String newid_tipo_activo_fijo_empresa_descripcion)throws Exception {
		try {
			this.id_tipo_activo_fijo_empresa_descripcion=newid_tipo_activo_fijo_empresa_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_tipo_depreciacion_empresa_descripcion(String newid_tipo_depreciacion_empresa_descripcion)throws Exception {
		try {
			this.id_tipo_depreciacion_empresa_descripcion=newid_tipo_depreciacion_empresa_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_estado_activo_fijo_descripcion(String newid_estado_activo_fijo_descripcion)throws Exception {
		try {
			this.id_estado_activo_fijo_descripcion=newid_estado_activo_fijo_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_cliente_descripcion(String newid_cliente_descripcion)throws Exception {
		try {
			this.id_cliente_descripcion=newid_cliente_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_partida_presu_descripcion(String newid_partida_presu_descripcion)throws Exception {
		try {
			this.id_partida_presu_descripcion=newid_partida_presu_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setcon_partes_descripcion(String newcon_partes_descripcion)throws Exception {
		try {
			this.con_partes_descripcion=newcon_partes_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setcon_garantia_descripcion(String newcon_garantia_descripcion)throws Exception {
		try {
			this.con_garantia_descripcion=newcon_garantia_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setcon_existencia_descripcion(String newcon_existencia_descripcion)throws Exception {
		try {
			this.con_existencia_descripcion=newcon_existencia_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	
	public void inicializarVariablesParaReporte() {
		this.id_empresa_descripcion="";this.id_sucursal_descripcion="";this.id_detalle_grupo_activo_fijo_descripcion="";this.id_sub_grupo_activo_fijo_descripcion="";this.id_tipo_ramo_activo_fijo_descripcion="";this.id_tipo_activo_fijo_empresa_descripcion="";this.id_tipo_depreciacion_empresa_descripcion="";this.id_estado_activo_fijo_descripcion="";this.id_cliente_descripcion="";this.id_partida_presu_descripcion="";this.con_partes_descripcion="";this.con_garantia_descripcion="";this.con_existencia_descripcion="";
	}
	
	
	Object mantenimientoactivofijosDescripcionReporte;
	Object serviciotransportesDescripcionReporte;
	Object movimientoactivofijoDestinosDescripcionReporte;
	Object vehiculosDescripcionReporte;
	Object metododepreciacionsDescripcionReporte;
	Object responsableactivofijosDescripcionReporte;
	Object depreciacionactivofijosDescripcionReporte;
	Object gastodepreciacioncentrocostosDescripcionReporte;
	Object parteactivofijosDescripcionReporte;
	
	
	public Object getmantenimientoactivofijosDescripcionReporte() {
		return mantenimientoactivofijosDescripcionReporte;
	}

	public Object getserviciotransportesDescripcionReporte() {
		return serviciotransportesDescripcionReporte;
	}

	public Object getmovimientoactivofijoDestinosDescripcionReporte() {
		return movimientoactivofijoDestinosDescripcionReporte;
	}

	public Object getvehiculosDescripcionReporte() {
		return vehiculosDescripcionReporte;
	}

	public Object getmetododepreciacionsDescripcionReporte() {
		return metododepreciacionsDescripcionReporte;
	}

	public Object getresponsableactivofijosDescripcionReporte() {
		return responsableactivofijosDescripcionReporte;
	}

	public Object getdepreciacionactivofijosDescripcionReporte() {
		return depreciacionactivofijosDescripcionReporte;
	}

	public Object getgastodepreciacioncentrocostosDescripcionReporte() {
		return gastodepreciacioncentrocostosDescripcionReporte;
	}

	public Object getparteactivofijosDescripcionReporte() {
		return parteactivofijosDescripcionReporte;
	}

	
	
	public  void  setmantenimientoactivofijosDescripcionReporte(Object mantenimientoactivofijos) {
		try {
			this.mantenimientoactivofijosDescripcionReporte=mantenimientoactivofijos;
		} catch(Exception ex) {
			;
		}
	}

	public  void  setserviciotransportesDescripcionReporte(Object serviciotransportes) {
		try {
			this.serviciotransportesDescripcionReporte=serviciotransportes;
		} catch(Exception ex) {
			;
		}
	}

	public  void  setmovimientoactivofijoDestinosDescripcionReporte(Object movimientoactivofijos) {
		try {
			this.movimientoactivofijoDestinosDescripcionReporte=movimientoactivofijos;
		} catch(Exception ex) {
			;
		}
	}

	public  void  setvehiculosDescripcionReporte(Object vehiculos) {
		try {
			this.vehiculosDescripcionReporte=vehiculos;
		} catch(Exception ex) {
			;
		}
	}

	public  void  setmetododepreciacionsDescripcionReporte(Object metododepreciacions) {
		try {
			this.metododepreciacionsDescripcionReporte=metododepreciacions;
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

	public  void  setdepreciacionactivofijosDescripcionReporte(Object depreciacionactivofijos) {
		try {
			this.depreciacionactivofijosDescripcionReporte=depreciacionactivofijos;
		} catch(Exception ex) {
			;
		}
	}

	public  void  setgastodepreciacioncentrocostosDescripcionReporte(Object gastodepreciacioncentrocostos) {
		try {
			this.gastodepreciacioncentrocostosDescripcionReporte=gastodepreciacioncentrocostos;
		} catch(Exception ex) {
			;
		}
	}

	public  void  setparteactivofijosDescripcionReporte(Object parteactivofijos) {
		try {
			this.parteactivofijosDescripcionReporte=parteactivofijos;
		} catch(Exception ex) {
			;
		}
	}

	/*PARA REPORTES FIN*/		
}

