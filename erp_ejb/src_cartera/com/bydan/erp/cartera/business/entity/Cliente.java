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
package com.bydan.erp.cartera.business.entity;

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


import java.sql.Time;

import org.hibernate.validator.*;

import com.bydan.framework.erp.business.entity.*;
import com.bydan.framework.erp.business.entity.DatoGeneral;
import com.bydan.framework.erp.business.dataaccess.ConstantesSql;
//import com.bydan.framework.erp.business.entity.Mensajes;
import com.bydan.framework.erp.util.Constantes;
import com.bydan.framework.erp.util.ConstantesValidacion;
//import com.bydan.erp.cartera.util.ClienteConstantesFunciones;
import com.bydan.erp.cartera.util.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.nomina.util.*;
import com.bydan.erp.contabilidad.util.*;
import com.bydan.erp.comisiones.util.*;
import com.bydan.erp.inventario.util.*;
import com.bydan.erp.sris.util.*;
import com.bydan.erp.facturacion.util.*;
import com.bydan.erp.cartera.util.*;
import com.bydan.erp.tesoreria.util.*;
import com.bydan.erp.puntoventa.util.*;
import com.bydan.erp.activosfijos.util.*;
import com.bydan.erp.importaciones.util.*;
import com.bydan.erp.produccion.util.*;



import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.nomina.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.comisiones.business.entity.*;
import com.bydan.erp.inventario.business.entity.*;
import com.bydan.erp.sris.business.entity.*;
import com.bydan.erp.facturacion.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;
import com.bydan.erp.tesoreria.business.entity.*;
import com.bydan.erp.puntoventa.business.entity.*;
import com.bydan.erp.activosfijos.business.entity.*;
import com.bydan.erp.importaciones.business.entity.*;
import com.bydan.erp.produccion.business.entity.*;




@SuppressWarnings("unused")
public class Cliente extends ClienteAdditional implements Serializable ,Cloneable {//ClienteAdditional,GeneralEntity
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
	
	private Cliente clienteOriginal;
	
	private Map<String, Object> mapCliente;
			
	public Map<String, Object> getMapCliente() {
		return mapCliente;
	}

	public void setMapCliente(Map<String, Object> mapCliente) {
		this.mapCliente = mapCliente;
	}
	
	public void inicializarMapCliente() {
		this.mapCliente = new HashMap<String,Object>();
	}
	
	public void setMapClienteValue(String sKey,Object oValue) {
		this.mapCliente.put(sKey, oValue);
	}
	
	public Object getMapClienteValue(String sKey) {
		return this.mapCliente.get(sKey);
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
	@Pattern(regex=ClienteConstantesFunciones.SREGEXCODIGO,message=ClienteConstantesFunciones.SMENSAJEREGEXCODIGO)
	private String codigo;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_tipo_identificacion;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=25,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=ClienteConstantesFunciones.SREGEXIDENTIFICACION,message=ClienteConstantesFunciones.SMENSAJEREGEXIDENTIFICACION)
	private String identificacion;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=15,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=ClienteConstantesFunciones.SREGEXRUC,message=ClienteConstantesFunciones.SMENSAJEREGEXRUC)
	private String ruc;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=100,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=ClienteConstantesFunciones.SREGEXNOMBRE,message=ClienteConstantesFunciones.SMENSAJEREGEXNOMBRE)
	private String nombre;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=100,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=ClienteConstantesFunciones.SREGEXAPELLIDO,message=ClienteConstantesFunciones.SMENSAJEREGEXAPELLIDO)
	private String apellido;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=150,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@Pattern(regex=ClienteConstantesFunciones.SREGEXNOMBRE_COMPLETO,message=ClienteConstantesFunciones.SMENSAJEREGEXNOMBRE_COMPLETO)
	private String nombre_completo;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=150,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@Pattern(regex=ClienteConstantesFunciones.SREGEXNOMBRE_COMERCIAL,message=ClienteConstantesFunciones.SMENSAJEREGEXNOMBRE_COMERCIAL)
	private String nombre_comercial;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=50,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@Pattern(regex=ClienteConstantesFunciones.SREGEXTELEFONO,message=ClienteConstantesFunciones.SMENSAJEREGEXTELEFONO)
	private String telefono;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=150,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@Pattern(regex=ClienteConstantesFunciones.SREGEXDIRECCION,message=ClienteConstantesFunciones.SMENSAJEREGEXDIRECCION)
	private String direccion;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Boolean es_prove;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_grupo_cliente;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_titulo_cliente;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_area_cr;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_estado_cliente;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=250,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@Pattern(regex=ClienteConstantesFunciones.SREGEXOBSERVACION,message=ClienteConstantesFunciones.SMENSAJEREGEXOBSERVACION)
	private String observacion;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_pais;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_region;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_provincia;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_ciudad;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_zona;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_pais_nacionalidad;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_tipo_cargo_labo;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_tipo_nivel_edu;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_profesion;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_tipo_genero;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_estado_civil;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_estado_legal;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Date fecha_nacimiento;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=100,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@Pattern(regex=ClienteConstantesFunciones.SREGEXPATH_IMAGEN_FIRMA,message=ClienteConstantesFunciones.SMENSAJEREGEXPATH_IMAGEN_FIRMA)
	private String path_imagen_firma;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=150,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@Pattern(regex=ClienteConstantesFunciones.SREGEXCONTACTO,message=ClienteConstantesFunciones.SMENSAJEREGEXCONTACTO)
	private String contacto;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_cuenta_contable;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_ruta;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_vendedor;
	
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_centro_actividad;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=100,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@Pattern(regex=ClienteConstantesFunciones.SREGEXREPRESENTANTE,message=ClienteConstantesFunciones.SMENSAJEREGEXREPRESENTANTE)
	private String representante;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_tipo_garantia_empresa;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=150,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@Pattern(regex=ClienteConstantesFunciones.SREGEXNOMBRE_GARANTIA,message=ClienteConstantesFunciones.SMENSAJEREGEXNOMBRE_GARANTIA)
	private String nombre_garantia;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double valor_garantia;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_cate_tipo_afiliacion;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=10,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONINT)
	private Integer numero_carga;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double credito_usado;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double limite_credito;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double credito_disponible;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double total_documentos;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Date fecha_ultima_factura;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double descuento;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_dia;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Time hora_pago;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_empleado;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=150,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@Pattern(regex=ClienteConstantesFunciones.SREGEXCOBRANZAS,message=ClienteConstantesFunciones.SMENSAJEREGEXCOBRANZAS)
	private String cobranzas;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=150,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@Pattern(regex=ClienteConstantesFunciones.SREGEXMOTIVO,message=ClienteConstantesFunciones.SMENSAJEREGEXMOTIVO)
	private String motivo;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=150,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@Pattern(regex=ClienteConstantesFunciones.SREGEXPREFERENCIA,message=ClienteConstantesFunciones.SMENSAJEREGEXPREFERENCIA)
	private String preferencia;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Boolean con_separacion_bienes;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_tipo_precio;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_tipo_lista_precio;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=150,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@Pattern(regex=ClienteConstantesFunciones.SREGEXDETALLE_ESTADO,message=ClienteConstantesFunciones.SMENSAJEREGEXDETALLE_ESTADO)
	private String detalle_estado;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Boolean es_contribuyente_especial;
			
	
	public Empresa empresa;
	public Sucursal sucursal;
	public TipoIdentificacion tipoidentificacion;
	public GrupoCliente grupocliente;
	public TituloCliente titulocliente;
	public AreaCr areacr;
	public EstadoCliente estadocliente;
	public Pais pais;
	public Region region;
	public Provincia provincia;
	public Ciudad ciudad;
	public Zona zona;
	public Pais paisnacionalidad;
	public TipoCargoLabo tipocargolabo;
	public TipoNivelEdu tiponiveledu;
	public Profesion profesion;
	public TipoGenero tipogenero;
	public EstadoCivil estadocivil;
	public EstadoLegal estadolegal;
	public CuentaContable cuentacontable;
	public Ruta ruta;
	public Vendedor vendedor;
	public CentroActividad centroactividad;
	public TipoGarantiaEmpresa tipogarantiaempresa;
	public CateTipoAfiliacion catetipoafiliacion;
	public Dia dia;
	public Empleado empleado;
	public TipoPrecio tipoprecio;
	public TipoListaPrecio tipolistaprecio;
	
	
	private String empresa_descripcion;
	private String sucursal_descripcion;
	private String tipoidentificacion_descripcion;
	private String grupocliente_descripcion;
	private String titulocliente_descripcion;
	private String areacr_descripcion;
	private String estadocliente_descripcion;
	private String pais_descripcion;
	private String region_descripcion;
	private String provincia_descripcion;
	private String ciudad_descripcion;
	private String zona_descripcion;
	private String paisnacionalidad_descripcion;
	private String tipocargolabo_descripcion;
	private String tiponiveledu_descripcion;
	private String profesion_descripcion;
	private String tipogenero_descripcion;
	private String estadocivil_descripcion;
	private String estadolegal_descripcion;
	private String cuentacontable_descripcion;
	private String ruta_descripcion;
	private String vendedor_descripcion;
	private String centroactividad_descripcion;
	private String tipogarantiaempresa_descripcion;
	private String catetipoafiliacion_descripcion;
	private String dia_descripcion;
	private String empleado_descripcion;
	private String tipoprecio_descripcion;
	private String tipolistaprecio_descripcion;
	
	
	public List<ContactoCliente> contactoclientes;
	public List<Bien> biens;
	public List<CargaFamiliar> cargafamiliars;
	public List<ChequePostFechado> chequepostfechados;
	public List<EMail> emails;
	public List<ReferenciaPersonal> referenciapersonals;
	public List<GarantiaCliente> garantiaclientes;
	public List<ClienteArchivo> clientearchivos;
	public PoliticasCliente politicascliente;
	public List<FirmaCliente> firmaclientes;
	public List<ReferenciaComercial> referenciacomercials;
	public List<Novedad> novedads;
	public List<InformacionLaboral> informacionlaborals;
	public List<InformacionFinanciera> informacionfinancieras;
	public List<Telefono> telefonos;
	public List<CuentaPorCobrar> cuentaporcobrars;
	public List<Responsable> responsables;
	public List<Transportista> transportistas;
	public List<PoliticaCliente> politicaclientes;
	public Conyuge conyuge;
	public List<ReferenciaBancaria> referenciabancarias;
	public List<BalanceGeneralCliente> balancegeneralclientes;
	public List<DatoConstitucion> datoconstitucions;
	public List<ActividadEconomica> actividadeconomicas;
	public List<ProveedorProducto> proveedorproductos;
	public List<Consignatario> consignatarios;
	public List<HobbyCliente> hobbyclientes;
	public List<RepresentanteLegal> representantelegals;
	public List<ClienteCoa> clientecoas;
	public List<Direccion> direccions;
	public List<ClienteImagen> clienteimagens;
	public List<SubCliente> subclientes;
	public List<ServicioCliente> servicioclientes;
	public List<InformacionEconomica> informacioneconomicas;
	public List<VehiculoCliente> vehiculoclientes;
	public List<NegocioCliente> negocioclientes;
	public List<Monto> montos;
		
	public Cliente () throws Exception {
		super();		
		
		this.id=0L;
		
		
		this.versionRow=new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());//new Date();
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		this.sType="NONE";
		
		this.clienteOriginal=this;
		
 		this.id_empresa=-1L;
 		this.id_sucursal=-1L;
 		this.codigo="";
 		this.id_tipo_identificacion=-1L;
 		this.identificacion="";
 		this.ruc="";
 		this.nombre="";
 		this.apellido="";
 		this.nombre_completo="";
 		this.nombre_comercial="";
 		this.telefono="";
 		this.direccion="";
 		this.es_prove=false;
 		this.id_grupo_cliente=-1L;
 		this.id_titulo_cliente=-1L;
 		this.id_area_cr=-1L;
 		this.id_estado_cliente=-1L;
 		this.observacion="";
 		this.id_pais=-1L;
 		this.id_region=-1L;
 		this.id_provincia=-1L;
 		this.id_ciudad=-1L;
 		this.id_zona=-1L;
 		this.id_pais_nacionalidad=-1L;
 		this.id_tipo_cargo_labo=-1L;
 		this.id_tipo_nivel_edu=-1L;
 		this.id_profesion=-1L;
 		this.id_tipo_genero=-1L;
 		this.id_estado_civil=-1L;
 		this.id_estado_legal=-1L;
 		this.fecha_nacimiento=new Date();
 		this.path_imagen_firma="";
 		this.contacto="";
 		this.id_cuenta_contable=-1L;
 		this.id_ruta=-1L;
 		this.id_vendedor=-1L;
 		this.id_centro_actividad=null;
 		this.representante="";
 		this.id_tipo_garantia_empresa=-1L;
 		this.nombre_garantia="";
 		this.valor_garantia=0.0;
 		this.id_cate_tipo_afiliacion=-1L;
 		this.numero_carga=0;
 		this.credito_usado=0.0;
 		this.limite_credito=0.0;
 		this.credito_disponible=0.0;
 		this.total_documentos=0.0;
 		this.fecha_ultima_factura=new Date();
 		this.descuento=0.0;
 		this.id_dia=-1L;
 		this.hora_pago=new Time((new Date()).getTime());
 		this.id_empleado=-1L;
 		this.cobranzas="";
 		this.motivo="";
 		this.preferencia="";
 		this.con_separacion_bienes=false;
 		this.id_tipo_precio=-1L;
 		this.id_tipo_lista_precio=-1L;
 		this.detalle_estado="";
 		this.es_contribuyente_especial=false;
		
		
		this.empresa=null;
		this.sucursal=null;
		this.tipoidentificacion=null;
		this.grupocliente=null;
		this.titulocliente=null;
		this.areacr=null;
		this.estadocliente=null;
		this.pais=null;
		this.region=null;
		this.provincia=null;
		this.ciudad=null;
		this.zona=null;
		this.paisnacionalidad=null;
		this.tipocargolabo=null;
		this.tiponiveledu=null;
		this.profesion=null;
		this.tipogenero=null;
		this.estadocivil=null;
		this.estadolegal=null;
		this.cuentacontable=null;
		this.ruta=null;
		this.vendedor=null;
		this.centroactividad=null;
		this.tipogarantiaempresa=null;
		this.catetipoafiliacion=null;
		this.dia=null;
		this.empleado=null;
		this.tipoprecio=null;
		this.tipolistaprecio=null;
		
		
		this.empresa_descripcion="";
		this.sucursal_descripcion="";
		this.tipoidentificacion_descripcion="";
		this.grupocliente_descripcion="";
		this.titulocliente_descripcion="";
		this.areacr_descripcion="";
		this.estadocliente_descripcion="";
		this.pais_descripcion="";
		this.region_descripcion="";
		this.provincia_descripcion="";
		this.ciudad_descripcion="";
		this.zona_descripcion="";
		this.paisnacionalidad_descripcion="";
		this.tipocargolabo_descripcion="";
		this.tiponiveledu_descripcion="";
		this.profesion_descripcion="";
		this.tipogenero_descripcion="";
		this.estadocivil_descripcion="";
		this.estadolegal_descripcion="";
		this.cuentacontable_descripcion="";
		this.ruta_descripcion="";
		this.vendedor_descripcion="";
		this.centroactividad_descripcion="";
		this.tipogarantiaempresa_descripcion="";
		this.catetipoafiliacion_descripcion="";
		this.dia_descripcion="";
		this.empleado_descripcion="";
		this.tipoprecio_descripcion="";
		this.tipolistaprecio_descripcion="";
		
		
		this.contactoclientes=null;
		this.biens=null;
		this.cargafamiliars=null;
		this.chequepostfechados=null;
		this.emails=null;
		this.referenciapersonals=null;
		this.garantiaclientes=null;
		this.clientearchivos=null;
		this.firmaclientes=null;
		this.referenciacomercials=null;
		this.novedads=null;
		this.informacionlaborals=null;
		this.informacionfinancieras=null;
		this.telefonos=null;
		this.cuentaporcobrars=null;
		this.responsables=null;
		this.transportistas=null;
		this.politicaclientes=null;
		this.referenciabancarias=null;
		this.balancegeneralclientes=null;
		this.datoconstitucions=null;
		this.actividadeconomicas=null;
		this.proveedorproductos=null;
		this.consignatarios=null;
		this.hobbyclientes=null;
		this.representantelegals=null;
		this.clientecoas=null;
		this.direccions=null;
		this.clienteimagens=null;
		this.subclientes=null;
		this.servicioclientes=null;
		this.informacioneconomicas=null;
		this.vehiculoclientes=null;
		this.negocioclientes=null;
		this.montos=null;
		
			
		
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
    //PARA REPORTES
	public Cliente (Long id,Date versionRow,Long id_empresa,Long id_sucursal,String codigo,Long id_tipo_identificacion,String identificacion,String ruc,String nombre,String apellido,String nombre_completo,String nombre_comercial,String telefono,String direccion,Boolean es_prove,Long id_grupo_cliente,Long id_titulo_cliente,Long id_area_cr,Long id_estado_cliente,String observacion,Long id_pais,Long id_region,Long id_provincia,Long id_ciudad,Long id_zona,Long id_pais_nacionalidad,Long id_tipo_cargo_labo,Long id_tipo_nivel_edu,Long id_profesion,Long id_tipo_genero,Long id_estado_civil,Long id_estado_legal,Date fecha_nacimiento,String path_imagen_firma,String contacto,Long id_cuenta_contable,Long id_ruta,Long id_vendedor,Long id_centro_actividad,String representante,Long id_tipo_garantia_empresa,String nombre_garantia,Double valor_garantia,Long id_cate_tipo_afiliacion,Integer numero_carga,Double credito_usado,Double limite_credito,Double credito_disponible,Double total_documentos,Date fecha_ultima_factura,Double descuento,Long id_dia,Time hora_pago,Long id_empleado,String cobranzas,String motivo,String preferencia,Boolean con_separacion_bienes,Long id_tipo_precio,Long id_tipo_lista_precio,String detalle_estado,Boolean es_contribuyente_especial) throws Exception {
		super();		
		
		this.id=id;
		this.versionRow=versionRow;
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.clienteOriginal=this;
		
 		this.id_empresa=id_empresa;
 		this.id_sucursal=id_sucursal;
 		this.codigo=codigo;
 		this.id_tipo_identificacion=id_tipo_identificacion;
 		this.identificacion=identificacion;
 		this.ruc=ruc;
 		this.nombre=nombre;
 		this.apellido=apellido;
 		this.nombre_completo=nombre_completo;
 		this.nombre_comercial=nombre_comercial;
 		this.telefono=telefono;
 		this.direccion=direccion;
 		this.es_prove=es_prove;
 		this.id_grupo_cliente=id_grupo_cliente;
 		this.id_titulo_cliente=id_titulo_cliente;
 		this.id_area_cr=id_area_cr;
 		this.id_estado_cliente=id_estado_cliente;
 		this.observacion=observacion;
 		this.id_pais=id_pais;
 		this.id_region=id_region;
 		this.id_provincia=id_provincia;
 		this.id_ciudad=id_ciudad;
 		this.id_zona=id_zona;
 		this.id_pais_nacionalidad=id_pais_nacionalidad;
 		this.id_tipo_cargo_labo=id_tipo_cargo_labo;
 		this.id_tipo_nivel_edu=id_tipo_nivel_edu;
 		this.id_profesion=id_profesion;
 		this.id_tipo_genero=id_tipo_genero;
 		this.id_estado_civil=id_estado_civil;
 		this.id_estado_legal=id_estado_legal;
 		this.fecha_nacimiento=fecha_nacimiento;
 		this.path_imagen_firma=path_imagen_firma;
 		this.contacto=contacto;
 		this.id_cuenta_contable=id_cuenta_contable;
 		this.id_ruta=id_ruta;
 		this.id_vendedor=id_vendedor;
 		this.id_centro_actividad=id_centro_actividad;
 		this.representante=representante;
 		this.id_tipo_garantia_empresa=id_tipo_garantia_empresa;
 		this.nombre_garantia=nombre_garantia;
 		this.valor_garantia=valor_garantia;
 		this.id_cate_tipo_afiliacion=id_cate_tipo_afiliacion;
 		this.numero_carga=numero_carga;
 		this.credito_usado=credito_usado;
 		this.limite_credito=limite_credito;
 		this.credito_disponible=credito_disponible;
 		this.total_documentos=total_documentos;
 		this.fecha_ultima_factura=fecha_ultima_factura;
 		this.descuento=descuento;
 		this.id_dia=id_dia;
 		this.hora_pago=hora_pago;
 		this.id_empleado=id_empleado;
 		this.cobranzas=cobranzas;
 		this.motivo=motivo;
 		this.preferencia=preferencia;
 		this.con_separacion_bienes=con_separacion_bienes;
 		this.id_tipo_precio=id_tipo_precio;
 		this.id_tipo_lista_precio=id_tipo_lista_precio;
 		this.detalle_estado=detalle_estado;
 		this.es_contribuyente_especial=es_contribuyente_especial;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	 //PARA REPORTES
	public Cliente (Long id_empresa,Long id_sucursal,String codigo,Long id_tipo_identificacion,String identificacion,String ruc,String nombre,String apellido,String nombre_completo,String nombre_comercial,String telefono,String direccion,Boolean es_prove,Long id_grupo_cliente,Long id_titulo_cliente,Long id_area_cr,Long id_estado_cliente,String observacion,Long id_pais,Long id_region,Long id_provincia,Long id_ciudad,Long id_zona,Long id_pais_nacionalidad,Long id_tipo_cargo_labo,Long id_tipo_nivel_edu,Long id_profesion,Long id_tipo_genero,Long id_estado_civil,Long id_estado_legal,Date fecha_nacimiento,String path_imagen_firma,String contacto,Long id_cuenta_contable,Long id_ruta,Long id_vendedor,Long id_centro_actividad,String representante,Long id_tipo_garantia_empresa,String nombre_garantia,Double valor_garantia,Long id_cate_tipo_afiliacion,Integer numero_carga,Double credito_usado,Double limite_credito,Double credito_disponible,Double total_documentos,Date fecha_ultima_factura,Double descuento,Long id_dia,Time hora_pago,Long id_empleado,String cobranzas,String motivo,String preferencia,Boolean con_separacion_bienes,Long id_tipo_precio,Long id_tipo_lista_precio,String detalle_estado,Boolean es_contribuyente_especial) throws Exception {
		super();		
		
		this.id=0L;
		this.versionRow=new Date();
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.clienteOriginal=this;
		
 		this.id_empresa=id_empresa;
 		this.id_sucursal=id_sucursal;
 		this.codigo=codigo;
 		this.id_tipo_identificacion=id_tipo_identificacion;
 		this.identificacion=identificacion;
 		this.ruc=ruc;
 		this.nombre=nombre;
 		this.apellido=apellido;
 		this.nombre_completo=nombre_completo;
 		this.nombre_comercial=nombre_comercial;
 		this.telefono=telefono;
 		this.direccion=direccion;
 		this.es_prove=es_prove;
 		this.id_grupo_cliente=id_grupo_cliente;
 		this.id_titulo_cliente=id_titulo_cliente;
 		this.id_area_cr=id_area_cr;
 		this.id_estado_cliente=id_estado_cliente;
 		this.observacion=observacion;
 		this.id_pais=id_pais;
 		this.id_region=id_region;
 		this.id_provincia=id_provincia;
 		this.id_ciudad=id_ciudad;
 		this.id_zona=id_zona;
 		this.id_pais_nacionalidad=id_pais_nacionalidad;
 		this.id_tipo_cargo_labo=id_tipo_cargo_labo;
 		this.id_tipo_nivel_edu=id_tipo_nivel_edu;
 		this.id_profesion=id_profesion;
 		this.id_tipo_genero=id_tipo_genero;
 		this.id_estado_civil=id_estado_civil;
 		this.id_estado_legal=id_estado_legal;
 		this.fecha_nacimiento=fecha_nacimiento;
 		this.path_imagen_firma=path_imagen_firma;
 		this.contacto=contacto;
 		this.id_cuenta_contable=id_cuenta_contable;
 		this.id_ruta=id_ruta;
 		this.id_vendedor=id_vendedor;
 		this.id_centro_actividad=id_centro_actividad;
 		this.representante=representante;
 		this.id_tipo_garantia_empresa=id_tipo_garantia_empresa;
 		this.nombre_garantia=nombre_garantia;
 		this.valor_garantia=valor_garantia;
 		this.id_cate_tipo_afiliacion=id_cate_tipo_afiliacion;
 		this.numero_carga=numero_carga;
 		this.credito_usado=credito_usado;
 		this.limite_credito=limite_credito;
 		this.credito_disponible=credito_disponible;
 		this.total_documentos=total_documentos;
 		this.fecha_ultima_factura=fecha_ultima_factura;
 		this.descuento=descuento;
 		this.id_dia=id_dia;
 		this.hora_pago=hora_pago;
 		this.id_empleado=id_empleado;
 		this.cobranzas=cobranzas;
 		this.motivo=motivo;
 		this.preferencia=preferencia;
 		this.con_separacion_bienes=con_separacion_bienes;
 		this.id_tipo_precio=id_tipo_precio;
 		this.id_tipo_lista_precio=id_tipo_lista_precio;
 		this.detalle_estado=detalle_estado;
 		this.es_contribuyente_especial=es_contribuyente_especial;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	public boolean equals(Object object) {
		boolean equal=false;
		Cliente clienteLocal=null;
		
		if(object!=null) {
			clienteLocal=(Cliente)object;
			
			if(clienteLocal!=null) {
				if(this.getId()!=null && clienteLocal.getId()!=null) {
					if(this.getId().equals(clienteLocal.getId())) {
						equal=true;
					}
				}
			}
		}
		
		return equal;
	}
	
	public String toString() {
		String sDetalle="";
		
		if(!ClienteConstantesFunciones.CON_DESCRIPCION_DETALLADO) {
        	sDetalle=ClienteConstantesFunciones.getClienteDescripcion(this);
		} else {
			sDetalle=ClienteConstantesFunciones.getClienteDescripcionDetallado(this);
		}
		
		return sDetalle;
    }
	
	public Cliente getClienteOriginal() {
		return this.clienteOriginal;
	}
	
	public void setClienteOriginal(Cliente cliente) {
		try {
			this.clienteOriginal=cliente;
		} catch(Exception e) {
			;
		}
	}
	
	
	protected ClienteAdditional clienteAdditional=null;
	
	public ClienteAdditional getClienteAdditional() {
		return this.clienteAdditional;
	}
	
	public void setClienteAdditional(ClienteAdditional clienteAdditional) {
		try {
			this.clienteAdditional=clienteAdditional;
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
    
	
	public Long getid_tipo_identificacion() {
		return this.id_tipo_identificacion;
	}
    
	
	public String getidentificacion() {
		return this.identificacion;
	}
    
	
	public String getruc() {
		return this.ruc;
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
    
	
	public String getnombre_comercial() {
		return this.nombre_comercial;
	}
    
	
	public String gettelefono() {
		return this.telefono;
	}
    
	
	public String getdireccion() {
		return this.direccion;
	}
    
	
	public Boolean getes_prove() {
		return this.es_prove;
	}
    
	
	public Long getid_grupo_cliente() {
		return this.id_grupo_cliente;
	}
    
	
	public Long getid_titulo_cliente() {
		return this.id_titulo_cliente;
	}
    
	
	public Long getid_area_cr() {
		return this.id_area_cr;
	}
    
	
	public Long getid_estado_cliente() {
		return this.id_estado_cliente;
	}
    
	
	public String getobservacion() {
		return this.observacion;
	}
    
	
	public Long getid_pais() {
		return this.id_pais;
	}
    
	
	public Long getid_region() {
		return this.id_region;
	}
    
	
	public Long getid_provincia() {
		return this.id_provincia;
	}
    
	
	public Long getid_ciudad() {
		return this.id_ciudad;
	}
    
	
	public Long getid_zona() {
		return this.id_zona;
	}
    
	
	public Long getid_pais_nacionalidad() {
		return this.id_pais_nacionalidad;
	}
    
	
	public Long getid_tipo_cargo_labo() {
		return this.id_tipo_cargo_labo;
	}
    
	
	public Long getid_tipo_nivel_edu() {
		return this.id_tipo_nivel_edu;
	}
    
	
	public Long getid_profesion() {
		return this.id_profesion;
	}
    
	
	public Long getid_tipo_genero() {
		return this.id_tipo_genero;
	}
    
	
	public Long getid_estado_civil() {
		return this.id_estado_civil;
	}
    
	
	public Long getid_estado_legal() {
		return this.id_estado_legal;
	}
    
	
	public Date getfecha_nacimiento() {
		return this.fecha_nacimiento;
	}
    
	
	public String getpath_imagen_firma() {
		return this.path_imagen_firma;
	}
    
	
	public String getcontacto() {
		return this.contacto;
	}
    
	
	public Long getid_cuenta_contable() {
		return this.id_cuenta_contable;
	}
    
	
	public Long getid_ruta() {
		return this.id_ruta;
	}
    
	
	public Long getid_vendedor() {
		return this.id_vendedor;
	}
    
	
	public Long getid_centro_actividad() {
		return this.id_centro_actividad;
	}
    
	
	public String getrepresentante() {
		return this.representante;
	}
    
	
	public Long getid_tipo_garantia_empresa() {
		return this.id_tipo_garantia_empresa;
	}
    
	
	public String getnombre_garantia() {
		return this.nombre_garantia;
	}
    
	
	public Double getvalor_garantia() {
		return this.valor_garantia;
	}
    
	
	public Long getid_cate_tipo_afiliacion() {
		return this.id_cate_tipo_afiliacion;
	}
    
	
	public Integer getnumero_carga() {
		return this.numero_carga;
	}
    
	
	public Double getcredito_usado() {
		return this.credito_usado;
	}
    
	
	public Double getlimite_credito() {
		return this.limite_credito;
	}
    
	
	public Double getcredito_disponible() {
		return this.credito_disponible;
	}
    
	
	public Double gettotal_documentos() {
		return this.total_documentos;
	}
    
	
	public Date getfecha_ultima_factura() {
		return this.fecha_ultima_factura;
	}
    
	
	public Double getdescuento() {
		return this.descuento;
	}
    
	
	public Long getid_dia() {
		return this.id_dia;
	}
    
	
	public Time gethora_pago() {
		return this.hora_pago;
	}
    
	
	public Long getid_empleado() {
		return this.id_empleado;
	}
    
	
	public String getcobranzas() {
		return this.cobranzas;
	}
    
	
	public String getmotivo() {
		return this.motivo;
	}
    
	
	public String getpreferencia() {
		return this.preferencia;
	}
    
	
	public Boolean getcon_separacion_bienes() {
		return this.con_separacion_bienes;
	}
    
	
	public Long getid_tipo_precio() {
		return this.id_tipo_precio;
	}
    
	
	public Long getid_tipo_lista_precio() {
		return this.id_tipo_lista_precio;
	}
    
	
	public String getdetalle_estado() {
		return this.detalle_estado;
	}
    
	
	public Boolean getes_contribuyente_especial() {
		return this.es_contribuyente_especial;
	}
	
    
	public void setid_empresa(Long newid_empresa)throws Exception
	{
		try {
			if(this.id_empresa!=newid_empresa) {
				if(newid_empresa==null) {
					//newid_empresa=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("Cliente:Valor nulo no permitido en columna id_empresa");
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
						System.out.println("Cliente:Valor nulo no permitido en columna id_sucursal");
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
						System.out.println("Cliente:Valor nulo no permitido en columna codigo");
					}
				}

				if(newcodigo!=null&&newcodigo.length()>50) {
					newcodigo=newcodigo.substring(0,48);
					System.out.println("Cliente:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=50 en columna codigo");
				}

				this.codigo=newcodigo;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_tipo_identificacion(Long newid_tipo_identificacion)throws Exception
	{
		try {
			if(this.id_tipo_identificacion!=newid_tipo_identificacion) {
				if(newid_tipo_identificacion==null) {
					//newid_tipo_identificacion=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("Cliente:Valor nulo no permitido en columna id_tipo_identificacion");
					}
				}

				this.id_tipo_identificacion=newid_tipo_identificacion;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setidentificacion(String newidentificacion)throws Exception
	{
		try {
			if(this.identificacion!=newidentificacion) {
				if(newidentificacion==null) {
					//newidentificacion="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("Cliente:Valor nulo no permitido en columna identificacion");
					}
				}

				if(newidentificacion!=null&&newidentificacion.length()>25) {
					newidentificacion=newidentificacion.substring(0,23);
					System.out.println("Cliente:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=25 en columna identificacion");
				}

				this.identificacion=newidentificacion;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setruc(String newruc)throws Exception
	{
		try {
			if(this.ruc!=newruc) {
				if(newruc==null) {
					//newruc="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("Cliente:Valor nulo no permitido en columna ruc");
					}
				}

				if(newruc!=null&&newruc.length()>15) {
					newruc=newruc.substring(0,13);
					System.out.println("Cliente:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=15 en columna ruc");
				}

				this.ruc=newruc;
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
						System.out.println("Cliente:Valor nulo no permitido en columna nombre");
					}
				}

				if(newnombre!=null&&newnombre.length()>100) {
					newnombre=newnombre.substring(0,98);
					System.out.println("Cliente:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=100 en columna nombre");
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
						System.out.println("Cliente:Valor nulo no permitido en columna apellido");
					}
				}

				if(newapellido!=null&&newapellido.length()>100) {
					newapellido=newapellido.substring(0,98);
					System.out.println("Cliente:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=100 en columna apellido");
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
						System.out.println("Cliente:Valor nulo no permitido en columna nombre_completo");
					}
				}

				if(newnombre_completo!=null&&newnombre_completo.length()>150) {
					newnombre_completo=newnombre_completo.substring(0,148);
					System.out.println("Cliente:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=150 en columna nombre_completo");
				}

				this.nombre_completo=newnombre_completo;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setnombre_comercial(String newnombre_comercial)throws Exception
	{
		try {
			if(this.nombre_comercial!=newnombre_comercial) {
				if(newnombre_comercial==null) {
					//newnombre_comercial="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("Cliente:Valor nulo no permitido en columna nombre_comercial");
					}
				}

				if(newnombre_comercial!=null&&newnombre_comercial.length()>150) {
					newnombre_comercial=newnombre_comercial.substring(0,148);
					System.out.println("Cliente:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=150 en columna nombre_comercial");
				}

				this.nombre_comercial=newnombre_comercial;
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
						System.out.println("Cliente:Valor nulo no permitido en columna telefono");
					}
				}

				if(newtelefono!=null&&newtelefono.length()>50) {
					newtelefono=newtelefono.substring(0,48);
					System.out.println("Cliente:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=50 en columna telefono");
				}

				this.telefono=newtelefono;
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
						System.out.println("Cliente:Valor nulo no permitido en columna direccion");
					}
				}

				if(newdireccion!=null&&newdireccion.length()>150) {
					newdireccion=newdireccion.substring(0,148);
					System.out.println("Cliente:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=150 en columna direccion");
				}

				this.direccion=newdireccion;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setes_prove(Boolean newes_prove)throws Exception
	{
		try {
			if(this.es_prove!=newes_prove) {
				if(newes_prove==null) {
					//newes_prove=false;
					if(Constantes.ISDEVELOPING) {
						System.out.println("Cliente:Valor nulo no permitido en columna es_prove");
					}
				}

				this.es_prove=newes_prove;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_grupo_cliente(Long newid_grupo_cliente)throws Exception
	{
		try {
			if(this.id_grupo_cliente!=newid_grupo_cliente) {
				if(newid_grupo_cliente==null) {
					//newid_grupo_cliente=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("Cliente:Valor nulo no permitido en columna id_grupo_cliente");
					}
				}

				this.id_grupo_cliente=newid_grupo_cliente;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_titulo_cliente(Long newid_titulo_cliente)throws Exception
	{
		try {
			if(this.id_titulo_cliente!=newid_titulo_cliente) {
				if(newid_titulo_cliente==null) {
					//newid_titulo_cliente=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("Cliente:Valor nulo no permitido en columna id_titulo_cliente");
					}
				}

				this.id_titulo_cliente=newid_titulo_cliente;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_area_cr(Long newid_area_cr)throws Exception
	{
		try {
			if(this.id_area_cr!=newid_area_cr) {
				if(newid_area_cr==null) {
					//newid_area_cr=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("Cliente:Valor nulo no permitido en columna id_area_cr");
					}
				}

				this.id_area_cr=newid_area_cr;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_estado_cliente(Long newid_estado_cliente)throws Exception
	{
		try {
			if(this.id_estado_cliente!=newid_estado_cliente) {
				if(newid_estado_cliente==null) {
					//newid_estado_cliente=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("Cliente:Valor nulo no permitido en columna id_estado_cliente");
					}
				}

				this.id_estado_cliente=newid_estado_cliente;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setobservacion(String newobservacion)throws Exception
	{
		try {
			if(this.observacion!=newobservacion) {
				if(newobservacion==null) {
					//newobservacion="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("Cliente:Valor nulo no permitido en columna observacion");
					}
				}

				if(newobservacion!=null&&newobservacion.length()>250) {
					newobservacion=newobservacion.substring(0,248);
					System.out.println("Cliente:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=250 en columna observacion");
				}

				this.observacion=newobservacion;
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
						System.out.println("Cliente:Valor nulo no permitido en columna id_pais");
					}
				}

				this.id_pais=newid_pais;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_region(Long newid_region)throws Exception
	{
		try {
			if(this.id_region!=newid_region) {
				if(newid_region==null) {
					//newid_region=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("Cliente:Valor nulo no permitido en columna id_region");
					}
				}

				this.id_region=newid_region;
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
						System.out.println("Cliente:Valor nulo no permitido en columna id_provincia");
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
						System.out.println("Cliente:Valor nulo no permitido en columna id_ciudad");
					}
				}

				this.id_ciudad=newid_ciudad;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_zona(Long newid_zona)throws Exception
	{
		try {
			if(this.id_zona!=newid_zona) {
				if(newid_zona==null) {
					//newid_zona=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("Cliente:Valor nulo no permitido en columna id_zona");
					}
				}

				this.id_zona=newid_zona;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_pais_nacionalidad(Long newid_pais_nacionalidad)throws Exception
	{
		try {
			if(this.id_pais_nacionalidad!=newid_pais_nacionalidad) {
				if(newid_pais_nacionalidad==null) {
					//newid_pais_nacionalidad=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("Cliente:Valor nulo no permitido en columna id_pais_nacionalidad");
					}
				}

				this.id_pais_nacionalidad=newid_pais_nacionalidad;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_tipo_cargo_labo(Long newid_tipo_cargo_labo)throws Exception
	{
		try {
			if(this.id_tipo_cargo_labo!=newid_tipo_cargo_labo) {
				if(newid_tipo_cargo_labo==null) {
					//newid_tipo_cargo_labo=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("Cliente:Valor nulo no permitido en columna id_tipo_cargo_labo");
					}
				}

				this.id_tipo_cargo_labo=newid_tipo_cargo_labo;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_tipo_nivel_edu(Long newid_tipo_nivel_edu)throws Exception
	{
		try {
			if(this.id_tipo_nivel_edu!=newid_tipo_nivel_edu) {
				if(newid_tipo_nivel_edu==null) {
					//newid_tipo_nivel_edu=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("Cliente:Valor nulo no permitido en columna id_tipo_nivel_edu");
					}
				}

				this.id_tipo_nivel_edu=newid_tipo_nivel_edu;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_profesion(Long newid_profesion)throws Exception
	{
		try {
			if(this.id_profesion!=newid_profesion) {
				if(newid_profesion==null) {
					//newid_profesion=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("Cliente:Valor nulo no permitido en columna id_profesion");
					}
				}

				this.id_profesion=newid_profesion;
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
						System.out.println("Cliente:Valor nulo no permitido en columna id_tipo_genero");
					}
				}

				this.id_tipo_genero=newid_tipo_genero;
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
						System.out.println("Cliente:Valor nulo no permitido en columna id_estado_civil");
					}
				}

				this.id_estado_civil=newid_estado_civil;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_estado_legal(Long newid_estado_legal)throws Exception
	{
		try {
			if(this.id_estado_legal!=newid_estado_legal) {
				if(newid_estado_legal==null) {
					//newid_estado_legal=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("Cliente:Valor nulo no permitido en columna id_estado_legal");
					}
				}

				this.id_estado_legal=newid_estado_legal;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setfecha_nacimiento(Date newfecha_nacimiento)throws Exception
	{
		try {
			if(this.fecha_nacimiento!=newfecha_nacimiento) {
				if(newfecha_nacimiento==null) {
					//newfecha_nacimiento=new Date();
					if(Constantes.ISDEVELOPING) {
						System.out.println("Cliente:Valor nulo no permitido en columna fecha_nacimiento");
					}
				}

				this.fecha_nacimiento=newfecha_nacimiento;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setpath_imagen_firma(String newpath_imagen_firma)throws Exception
	{
		try {
			if(this.path_imagen_firma!=newpath_imagen_firma) {
				if(newpath_imagen_firma==null) {
					//newpath_imagen_firma="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("Cliente:Valor nulo no permitido en columna path_imagen_firma");
					}
				}

				if(newpath_imagen_firma!=null&&newpath_imagen_firma.length()>100) {
					newpath_imagen_firma=newpath_imagen_firma.substring(0,98);
					System.out.println("Cliente:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=100 en columna path_imagen_firma");
				}

				this.path_imagen_firma=newpath_imagen_firma;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setcontacto(String newcontacto)throws Exception
	{
		try {
			if(this.contacto!=newcontacto) {
				if(newcontacto==null) {
					//newcontacto="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("Cliente:Valor nulo no permitido en columna contacto");
					}
				}

				if(newcontacto!=null&&newcontacto.length()>150) {
					newcontacto=newcontacto.substring(0,148);
					System.out.println("Cliente:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=150 en columna contacto");
				}

				this.contacto=newcontacto;
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
						System.out.println("Cliente:Valor nulo no permitido en columna id_cuenta_contable");
					}
				}

				this.id_cuenta_contable=newid_cuenta_contable;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_ruta(Long newid_ruta)throws Exception
	{
		try {
			if(this.id_ruta!=newid_ruta) {
				if(newid_ruta==null) {
					//newid_ruta=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("Cliente:Valor nulo no permitido en columna id_ruta");
					}
				}

				this.id_ruta=newid_ruta;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_vendedor(Long newid_vendedor)throws Exception
	{
		try {
			if(this.id_vendedor!=newid_vendedor) {
				if(newid_vendedor==null) {
					//newid_vendedor=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("Cliente:Valor nulo no permitido en columna id_vendedor");
					}
				}

				this.id_vendedor=newid_vendedor;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_centro_actividad(Long newid_centro_actividad) {
		if(this.id_centro_actividad==null&&newid_centro_actividad!=null) {
			this.id_centro_actividad=newid_centro_actividad;
				this.setIsChanged(true);
		}

		if(this.id_centro_actividad!=null&&!this.id_centro_actividad.equals(newid_centro_actividad)) {

			this.id_centro_actividad=newid_centro_actividad;
				this.setIsChanged(true);
		}
	}
    
	public void setrepresentante(String newrepresentante)throws Exception
	{
		try {
			if(this.representante!=newrepresentante) {
				if(newrepresentante==null) {
					//newrepresentante="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("Cliente:Valor nulo no permitido en columna representante");
					}
				}

				if(newrepresentante!=null&&newrepresentante.length()>100) {
					newrepresentante=newrepresentante.substring(0,98);
					System.out.println("Cliente:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=100 en columna representante");
				}

				this.representante=newrepresentante;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_tipo_garantia_empresa(Long newid_tipo_garantia_empresa)throws Exception
	{
		try {
			if(this.id_tipo_garantia_empresa!=newid_tipo_garantia_empresa) {
				if(newid_tipo_garantia_empresa==null) {
					//newid_tipo_garantia_empresa=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("Cliente:Valor nulo no permitido en columna id_tipo_garantia_empresa");
					}
				}

				this.id_tipo_garantia_empresa=newid_tipo_garantia_empresa;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setnombre_garantia(String newnombre_garantia)throws Exception
	{
		try {
			if(this.nombre_garantia!=newnombre_garantia) {
				if(newnombre_garantia==null) {
					//newnombre_garantia="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("Cliente:Valor nulo no permitido en columna nombre_garantia");
					}
				}

				if(newnombre_garantia!=null&&newnombre_garantia.length()>150) {
					newnombre_garantia=newnombre_garantia.substring(0,148);
					System.out.println("Cliente:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=150 en columna nombre_garantia");
				}

				this.nombre_garantia=newnombre_garantia;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setvalor_garantia(Double newvalor_garantia)throws Exception
	{
		try {
			if(this.valor_garantia!=newvalor_garantia) {
				if(newvalor_garantia==null) {
					//newvalor_garantia=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("Cliente:Valor nulo no permitido en columna valor_garantia");
					}
				}

				this.valor_garantia=newvalor_garantia;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_cate_tipo_afiliacion(Long newid_cate_tipo_afiliacion)throws Exception
	{
		try {
			if(this.id_cate_tipo_afiliacion!=newid_cate_tipo_afiliacion) {
				if(newid_cate_tipo_afiliacion==null) {
					//newid_cate_tipo_afiliacion=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("Cliente:Valor nulo no permitido en columna id_cate_tipo_afiliacion");
					}
				}

				this.id_cate_tipo_afiliacion=newid_cate_tipo_afiliacion;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setnumero_carga(Integer newnumero_carga)throws Exception
	{
		try {
			if(this.numero_carga!=newnumero_carga) {
				if(newnumero_carga==null) {
					//newnumero_carga=0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("Cliente:Valor nulo no permitido en columna numero_carga");
					}
				}

				this.numero_carga=newnumero_carga;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setcredito_usado(Double newcredito_usado)throws Exception
	{
		try {
			if(this.credito_usado!=newcredito_usado) {
				if(newcredito_usado==null) {
					//newcredito_usado=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("Cliente:Valor nulo no permitido en columna credito_usado");
					}
				}

				this.credito_usado=newcredito_usado;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setlimite_credito(Double newlimite_credito)throws Exception
	{
		try {
			if(this.limite_credito!=newlimite_credito) {
				if(newlimite_credito==null) {
					//newlimite_credito=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("Cliente:Valor nulo no permitido en columna limite_credito");
					}
				}

				this.limite_credito=newlimite_credito;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setcredito_disponible(Double newcredito_disponible)throws Exception
	{
		try {
			if(this.credito_disponible!=newcredito_disponible) {
				if(newcredito_disponible==null) {
					//newcredito_disponible=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("Cliente:Valor nulo no permitido en columna credito_disponible");
					}
				}

				this.credito_disponible=newcredito_disponible;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void settotal_documentos(Double newtotal_documentos)throws Exception
	{
		try {
			if(this.total_documentos!=newtotal_documentos) {
				if(newtotal_documentos==null) {
					//newtotal_documentos=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("Cliente:Valor nulo no permitido en columna total_documentos");
					}
				}

				this.total_documentos=newtotal_documentos;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setfecha_ultima_factura(Date newfecha_ultima_factura)throws Exception
	{
		try {
			if(this.fecha_ultima_factura!=newfecha_ultima_factura) {
				if(newfecha_ultima_factura==null) {
					//newfecha_ultima_factura=new Date();
					if(Constantes.ISDEVELOPING) {
						System.out.println("Cliente:Valor nulo no permitido en columna fecha_ultima_factura");
					}
				}

				this.fecha_ultima_factura=newfecha_ultima_factura;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setdescuento(Double newdescuento)throws Exception
	{
		try {
			if(this.descuento!=newdescuento) {
				if(newdescuento==null) {
					//newdescuento=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("Cliente:Valor nulo no permitido en columna descuento");
					}
				}

				this.descuento=newdescuento;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_dia(Long newid_dia)throws Exception
	{
		try {
			if(this.id_dia!=newid_dia) {
				if(newid_dia==null) {
					//newid_dia=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("Cliente:Valor nulo no permitido en columna id_dia");
					}
				}

				this.id_dia=newid_dia;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void sethora_pago(Time newhora_pago)throws Exception
	{
		try {
			if(this.hora_pago!=newhora_pago) {
				if(newhora_pago==null) {
					//newhora_pago=new Time((new Date()).getTime());
					if(Constantes.ISDEVELOPING) {
						System.out.println("Cliente:Valor nulo no permitido en columna hora_pago");
					}
				}

				this.hora_pago=newhora_pago;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_empleado(Long newid_empleado)throws Exception
	{
		try {
			if(this.id_empleado!=newid_empleado) {
				if(newid_empleado==null) {
					//newid_empleado=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("Cliente:Valor nulo no permitido en columna id_empleado");
					}
				}

				this.id_empleado=newid_empleado;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setcobranzas(String newcobranzas)throws Exception
	{
		try {
			if(this.cobranzas!=newcobranzas) {
				if(newcobranzas==null) {
					//newcobranzas="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("Cliente:Valor nulo no permitido en columna cobranzas");
					}
				}

				if(newcobranzas!=null&&newcobranzas.length()>150) {
					newcobranzas=newcobranzas.substring(0,148);
					System.out.println("Cliente:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=150 en columna cobranzas");
				}

				this.cobranzas=newcobranzas;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setmotivo(String newmotivo)throws Exception
	{
		try {
			if(this.motivo!=newmotivo) {
				if(newmotivo==null) {
					//newmotivo="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("Cliente:Valor nulo no permitido en columna motivo");
					}
				}

				if(newmotivo!=null&&newmotivo.length()>150) {
					newmotivo=newmotivo.substring(0,148);
					System.out.println("Cliente:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=150 en columna motivo");
				}

				this.motivo=newmotivo;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setpreferencia(String newpreferencia)throws Exception
	{
		try {
			if(this.preferencia!=newpreferencia) {
				if(newpreferencia==null) {
					//newpreferencia="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("Cliente:Valor nulo no permitido en columna preferencia");
					}
				}

				if(newpreferencia!=null&&newpreferencia.length()>150) {
					newpreferencia=newpreferencia.substring(0,148);
					System.out.println("Cliente:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=150 en columna preferencia");
				}

				this.preferencia=newpreferencia;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setcon_separacion_bienes(Boolean newcon_separacion_bienes)throws Exception
	{
		try {
			if(this.con_separacion_bienes!=newcon_separacion_bienes) {
				if(newcon_separacion_bienes==null) {
					//newcon_separacion_bienes=false;
					if(Constantes.ISDEVELOPING) {
						System.out.println("Cliente:Valor nulo no permitido en columna con_separacion_bienes");
					}
				}

				this.con_separacion_bienes=newcon_separacion_bienes;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_tipo_precio(Long newid_tipo_precio)throws Exception
	{
		try {
			if(this.id_tipo_precio!=newid_tipo_precio) {
				if(newid_tipo_precio==null) {
					//newid_tipo_precio=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("Cliente:Valor nulo no permitido en columna id_tipo_precio");
					}
				}

				this.id_tipo_precio=newid_tipo_precio;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_tipo_lista_precio(Long newid_tipo_lista_precio)throws Exception
	{
		try {
			if(this.id_tipo_lista_precio!=newid_tipo_lista_precio) {
				if(newid_tipo_lista_precio==null) {
					//newid_tipo_lista_precio=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("Cliente:Valor nulo no permitido en columna id_tipo_lista_precio");
					}
				}

				this.id_tipo_lista_precio=newid_tipo_lista_precio;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setdetalle_estado(String newdetalle_estado)throws Exception
	{
		try {
			if(this.detalle_estado!=newdetalle_estado) {
				if(newdetalle_estado==null) {
					//newdetalle_estado="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("Cliente:Valor nulo no permitido en columna detalle_estado");
					}
				}

				if(newdetalle_estado!=null&&newdetalle_estado.length()>150) {
					newdetalle_estado=newdetalle_estado.substring(0,148);
					System.out.println("Cliente:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=150 en columna detalle_estado");
				}

				this.detalle_estado=newdetalle_estado;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setes_contribuyente_especial(Boolean newes_contribuyente_especial)throws Exception
	{
		try {
			if(this.es_contribuyente_especial!=newes_contribuyente_especial) {
				if(newes_contribuyente_especial==null) {
					//newes_contribuyente_especial=false;
					if(Constantes.ISDEVELOPING) {
						System.out.println("Cliente:Valor nulo no permitido en columna es_contribuyente_especial");
					}
				}

				this.es_contribuyente_especial=newes_contribuyente_especial;
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

	public TipoIdentificacion getTipoIdentificacion() {
		return this.tipoidentificacion;
	}

	public GrupoCliente getGrupoCliente() {
		return this.grupocliente;
	}

	public TituloCliente getTituloCliente() {
		return this.titulocliente;
	}

	public AreaCr getAreaCr() {
		return this.areacr;
	}

	public EstadoCliente getEstadoCliente() {
		return this.estadocliente;
	}

	public Pais getPais() {
		return this.pais;
	}

	public Region getRegion() {
		return this.region;
	}

	public Provincia getProvincia() {
		return this.provincia;
	}

	public Ciudad getCiudad() {
		return this.ciudad;
	}

	public Zona getZona() {
		return this.zona;
	}

	public Pais getPaisNacionalidad() {
		return this.paisnacionalidad;
	}

	public TipoCargoLabo getTipoCargoLabo() {
		return this.tipocargolabo;
	}

	public TipoNivelEdu getTipoNivelEdu() {
		return this.tiponiveledu;
	}

	public Profesion getProfesion() {
		return this.profesion;
	}

	public TipoGenero getTipoGenero() {
		return this.tipogenero;
	}

	public EstadoCivil getEstadoCivil() {
		return this.estadocivil;
	}

	public EstadoLegal getEstadoLegal() {
		return this.estadolegal;
	}

	public CuentaContable getCuentaContable() {
		return this.cuentacontable;
	}

	public Ruta getRuta() {
		return this.ruta;
	}

	public Vendedor getVendedor() {
		return this.vendedor;
	}

	public CentroActividad getCentroActividad() {
		return this.centroactividad;
	}

	public TipoGarantiaEmpresa getTipoGarantiaEmpresa() {
		return this.tipogarantiaempresa;
	}

	public CateTipoAfiliacion getCateTipoAfiliacion() {
		return this.catetipoafiliacion;
	}

	public Dia getDia() {
		return this.dia;
	}

	public Empleado getEmpleado() {
		return this.empleado;
	}

	public TipoPrecio getTipoPrecio() {
		return this.tipoprecio;
	}

	public TipoListaPrecio getTipoListaPrecio() {
		return this.tipolistaprecio;
	}

	
	
	public String getempresa_descripcion() {
		return this.empresa_descripcion;
	}

	public String getsucursal_descripcion() {
		return this.sucursal_descripcion;
	}

	public String gettipoidentificacion_descripcion() {
		return this.tipoidentificacion_descripcion;
	}

	public String getgrupocliente_descripcion() {
		return this.grupocliente_descripcion;
	}

	public String gettitulocliente_descripcion() {
		return this.titulocliente_descripcion;
	}

	public String getareacr_descripcion() {
		return this.areacr_descripcion;
	}

	public String getestadocliente_descripcion() {
		return this.estadocliente_descripcion;
	}

	public String getpais_descripcion() {
		return this.pais_descripcion;
	}

	public String getregion_descripcion() {
		return this.region_descripcion;
	}

	public String getprovincia_descripcion() {
		return this.provincia_descripcion;
	}

	public String getciudad_descripcion() {
		return this.ciudad_descripcion;
	}

	public String getzona_descripcion() {
		return this.zona_descripcion;
	}

	public String getpaisnacionalidad_descripcion() {
		return this.paisnacionalidad_descripcion;
	}

	public String gettipocargolabo_descripcion() {
		return this.tipocargolabo_descripcion;
	}

	public String gettiponiveledu_descripcion() {
		return this.tiponiveledu_descripcion;
	}

	public String getprofesion_descripcion() {
		return this.profesion_descripcion;
	}

	public String gettipogenero_descripcion() {
		return this.tipogenero_descripcion;
	}

	public String getestadocivil_descripcion() {
		return this.estadocivil_descripcion;
	}

	public String getestadolegal_descripcion() {
		return this.estadolegal_descripcion;
	}

	public String getcuentacontable_descripcion() {
		return this.cuentacontable_descripcion;
	}

	public String getruta_descripcion() {
		return this.ruta_descripcion;
	}

	public String getvendedor_descripcion() {
		return this.vendedor_descripcion;
	}

	public String getcentroactividad_descripcion() {
		return this.centroactividad_descripcion;
	}

	public String gettipogarantiaempresa_descripcion() {
		return this.tipogarantiaempresa_descripcion;
	}

	public String getcatetipoafiliacion_descripcion() {
		return this.catetipoafiliacion_descripcion;
	}

	public String getdia_descripcion() {
		return this.dia_descripcion;
	}

	public String getempleado_descripcion() {
		return this.empleado_descripcion;
	}

	public String gettipoprecio_descripcion() {
		return this.tipoprecio_descripcion;
	}

	public String gettipolistaprecio_descripcion() {
		return this.tipolistaprecio_descripcion;
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


	public  void  setTipoIdentificacion(TipoIdentificacion tipoidentificacion) {
		try {
			this.tipoidentificacion=tipoidentificacion;
		} catch(Exception e) {
			;
		}
	}


	public  void  setGrupoCliente(GrupoCliente grupocliente) {
		try {
			this.grupocliente=grupocliente;
		} catch(Exception e) {
			;
		}
	}


	public  void  setTituloCliente(TituloCliente titulocliente) {
		try {
			this.titulocliente=titulocliente;
		} catch(Exception e) {
			;
		}
	}


	public  void  setAreaCr(AreaCr areacr) {
		try {
			this.areacr=areacr;
		} catch(Exception e) {
			;
		}
	}


	public  void  setEstadoCliente(EstadoCliente estadocliente) {
		try {
			this.estadocliente=estadocliente;
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


	public  void  setRegion(Region region) {
		try {
			this.region=region;
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


	public  void  setZona(Zona zona) {
		try {
			this.zona=zona;
		} catch(Exception e) {
			;
		}
	}


	public  void  setPaisNacionalidad(Pais paisnacionalidad) {
		try {
			this.paisnacionalidad=paisnacionalidad;
		} catch(Exception e) {
			;
		}
	}


	public  void  setTipoCargoLabo(TipoCargoLabo tipocargolabo) {
		try {
			this.tipocargolabo=tipocargolabo;
		} catch(Exception e) {
			;
		}
	}


	public  void  setTipoNivelEdu(TipoNivelEdu tiponiveledu) {
		try {
			this.tiponiveledu=tiponiveledu;
		} catch(Exception e) {
			;
		}
	}


	public  void  setProfesion(Profesion profesion) {
		try {
			this.profesion=profesion;
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


	public  void  setEstadoCivil(EstadoCivil estadocivil) {
		try {
			this.estadocivil=estadocivil;
		} catch(Exception e) {
			;
		}
	}


	public  void  setEstadoLegal(EstadoLegal estadolegal) {
		try {
			this.estadolegal=estadolegal;
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


	public  void  setRuta(Ruta ruta) {
		try {
			this.ruta=ruta;
		} catch(Exception e) {
			;
		}
	}


	public  void  setVendedor(Vendedor vendedor) {
		try {
			this.vendedor=vendedor;
		} catch(Exception e) {
			;
		}
	}


	public  void  setCentroActividad(CentroActividad centroactividad) {
		try {
			this.centroactividad=centroactividad;
		} catch(Exception e) {
			;
		}
	}


	public  void  setTipoGarantiaEmpresa(TipoGarantiaEmpresa tipogarantiaempresa) {
		try {
			this.tipogarantiaempresa=tipogarantiaempresa;
		} catch(Exception e) {
			;
		}
	}


	public  void  setCateTipoAfiliacion(CateTipoAfiliacion catetipoafiliacion) {
		try {
			this.catetipoafiliacion=catetipoafiliacion;
		} catch(Exception e) {
			;
		}
	}


	public  void  setDia(Dia dia) {
		try {
			this.dia=dia;
		} catch(Exception e) {
			;
		}
	}


	public  void  setEmpleado(Empleado empleado) {
		try {
			this.empleado=empleado;
		} catch(Exception e) {
			;
		}
	}


	public  void  setTipoPrecio(TipoPrecio tipoprecio) {
		try {
			this.tipoprecio=tipoprecio;
		} catch(Exception e) {
			;
		}
	}


	public  void  setTipoListaPrecio(TipoListaPrecio tipolistaprecio) {
		try {
			this.tipolistaprecio=tipolistaprecio;
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


	public  void  settipoidentificacion_descripcion(String tipoidentificacion_descripcion) {
		try {
			this.tipoidentificacion_descripcion=tipoidentificacion_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  setgrupocliente_descripcion(String grupocliente_descripcion) {
		try {
			this.grupocliente_descripcion=grupocliente_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  settitulocliente_descripcion(String titulocliente_descripcion) {
		try {
			this.titulocliente_descripcion=titulocliente_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  setareacr_descripcion(String areacr_descripcion) {
		try {
			this.areacr_descripcion=areacr_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  setestadocliente_descripcion(String estadocliente_descripcion) {
		try {
			this.estadocliente_descripcion=estadocliente_descripcion;
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


	public  void  setregion_descripcion(String region_descripcion) {
		try {
			this.region_descripcion=region_descripcion;
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


	public  void  setzona_descripcion(String zona_descripcion) {
		try {
			this.zona_descripcion=zona_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  setpaisnacionalidad_descripcion(String paisnacionalidad_descripcion) {
		try {
			this.paisnacionalidad_descripcion=paisnacionalidad_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  settipocargolabo_descripcion(String tipocargolabo_descripcion) {
		try {
			this.tipocargolabo_descripcion=tipocargolabo_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  settiponiveledu_descripcion(String tiponiveledu_descripcion) {
		try {
			this.tiponiveledu_descripcion=tiponiveledu_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  setprofesion_descripcion(String profesion_descripcion) {
		try {
			this.profesion_descripcion=profesion_descripcion;
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


	public  void  setestadocivil_descripcion(String estadocivil_descripcion) {
		try {
			this.estadocivil_descripcion=estadocivil_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  setestadolegal_descripcion(String estadolegal_descripcion) {
		try {
			this.estadolegal_descripcion=estadolegal_descripcion;
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


	public  void  setruta_descripcion(String ruta_descripcion) {
		try {
			this.ruta_descripcion=ruta_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  setvendedor_descripcion(String vendedor_descripcion) {
		try {
			this.vendedor_descripcion=vendedor_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  setcentroactividad_descripcion(String centroactividad_descripcion) {
		try {
			this.centroactividad_descripcion=centroactividad_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  settipogarantiaempresa_descripcion(String tipogarantiaempresa_descripcion) {
		try {
			this.tipogarantiaempresa_descripcion=tipogarantiaempresa_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  setcatetipoafiliacion_descripcion(String catetipoafiliacion_descripcion) {
		try {
			this.catetipoafiliacion_descripcion=catetipoafiliacion_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  setdia_descripcion(String dia_descripcion) {
		try {
			this.dia_descripcion=dia_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  setempleado_descripcion(String empleado_descripcion) {
		try {
			this.empleado_descripcion=empleado_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  settipoprecio_descripcion(String tipoprecio_descripcion) {
		try {
			this.tipoprecio_descripcion=tipoprecio_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  settipolistaprecio_descripcion(String tipolistaprecio_descripcion) {
		try {
			this.tipolistaprecio_descripcion=tipolistaprecio_descripcion;
		} catch(Exception e) {
			;
		}
	}


	
	
	public List<ContactoCliente> getContactoClientes() {
		return this.contactoclientes;
	}

	public List<Bien> getBiens() {
		return this.biens;
	}

	public List<CargaFamiliar> getCargaFamiliars() {
		return this.cargafamiliars;
	}

	public List<ChequePostFechado> getChequePostFechados() {
		return this.chequepostfechados;
	}

	public List<EMail> getEMails() {
		return this.emails;
	}

	public List<ReferenciaPersonal> getReferenciaPersonals() {
		return this.referenciapersonals;
	}

	public List<GarantiaCliente> getGarantiaClientes() {
		return this.garantiaclientes;
	}

	public List<ClienteArchivo> getClienteArchivos() {
		return this.clientearchivos;
	}

	public PoliticasCliente getPoliticasCliente() {
		return this.politicascliente;
	}

	public List<FirmaCliente> getFirmaClientes() {
		return this.firmaclientes;
	}

	public List<ReferenciaComercial> getReferenciaComercials() {
		return this.referenciacomercials;
	}

	public List<Novedad> getNovedads() {
		return this.novedads;
	}

	public List<InformacionLaboral> getInformacionLaborals() {
		return this.informacionlaborals;
	}

	public List<InformacionFinanciera> getInformacionFinancieras() {
		return this.informacionfinancieras;
	}

	public List<Telefono> getTelefonos() {
		return this.telefonos;
	}

	public List<CuentaPorCobrar> getCuentaPorCobrars() {
		return this.cuentaporcobrars;
	}

	public List<Responsable> getResponsables() {
		return this.responsables;
	}

	public List<Transportista> getTransportistas() {
		return this.transportistas;
	}

	public List<PoliticaCliente> getPoliticaClientes() {
		return this.politicaclientes;
	}

	public Conyuge getConyuge() {
		return this.conyuge;
	}

	public List<ReferenciaBancaria> getReferenciaBancarias() {
		return this.referenciabancarias;
	}

	public List<BalanceGeneralCliente> getBalanceGeneralClientes() {
		return this.balancegeneralclientes;
	}

	public List<DatoConstitucion> getDatoConstitucions() {
		return this.datoconstitucions;
	}

	public List<ActividadEconomica> getActividadEconomicas() {
		return this.actividadeconomicas;
	}

	public List<ProveedorProducto> getProveedorProductos() {
		return this.proveedorproductos;
	}

	public List<Consignatario> getConsignatarios() {
		return this.consignatarios;
	}

	public List<HobbyCliente> getHobbyClientes() {
		return this.hobbyclientes;
	}

	public List<RepresentanteLegal> getRepresentanteLegals() {
		return this.representantelegals;
	}

	public List<ClienteCoa> getClienteCoas() {
		return this.clientecoas;
	}

	public List<Direccion> getDireccions() {
		return this.direccions;
	}

	public List<ClienteImagen> getClienteImagens() {
		return this.clienteimagens;
	}

	public List<SubCliente> getSubClientes() {
		return this.subclientes;
	}

	public List<ServicioCliente> getServicioClientes() {
		return this.servicioclientes;
	}

	public List<InformacionEconomica> getInformacionEconomicas() {
		return this.informacioneconomicas;
	}

	public List<VehiculoCliente> getVehiculoClientes() {
		return this.vehiculoclientes;
	}

	public List<NegocioCliente> getNegocioClientes() {
		return this.negocioclientes;
	}

	public List<Monto> getMontos() {
		return this.montos;
	}

	
	
	public  void  setContactoClientes(List<ContactoCliente> contactoclientes) {
		try {
			this.contactoclientes=contactoclientes;
		} catch(Exception e) {
			;
		}
	}

	public  void  setBiens(List<Bien> biens) {
		try {
			this.biens=biens;
		} catch(Exception e) {
			;
		}
	}

	public  void  setCargaFamiliars(List<CargaFamiliar> cargafamiliars) {
		try {
			this.cargafamiliars=cargafamiliars;
		} catch(Exception e) {
			;
		}
	}

	public  void  setChequePostFechados(List<ChequePostFechado> chequepostfechados) {
		try {
			this.chequepostfechados=chequepostfechados;
		} catch(Exception e) {
			;
		}
	}

	public  void  setEMails(List<EMail> emails) {
		try {
			this.emails=emails;
		} catch(Exception e) {
			;
		}
	}

	public  void  setReferenciaPersonals(List<ReferenciaPersonal> referenciapersonals) {
		try {
			this.referenciapersonals=referenciapersonals;
		} catch(Exception e) {
			;
		}
	}

	public  void  setGarantiaClientes(List<GarantiaCliente> garantiaclientes) {
		try {
			this.garantiaclientes=garantiaclientes;
		} catch(Exception e) {
			;
		}
	}

	public  void  setClienteArchivos(List<ClienteArchivo> clientearchivos) {
		try {
			this.clientearchivos=clientearchivos;
		} catch(Exception e) {
			;
		}
	}

	public  void  setPoliticasCliente(PoliticasCliente politicascliente) {
	try {
			this.politicascliente=politicascliente;
		} catch(Exception e) {
			;
		}
	}

	public  void  setFirmaClientes(List<FirmaCliente> firmaclientes) {
		try {
			this.firmaclientes=firmaclientes;
		} catch(Exception e) {
			;
		}
	}

	public  void  setReferenciaComercials(List<ReferenciaComercial> referenciacomercials) {
		try {
			this.referenciacomercials=referenciacomercials;
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

	public  void  setInformacionLaborals(List<InformacionLaboral> informacionlaborals) {
		try {
			this.informacionlaborals=informacionlaborals;
		} catch(Exception e) {
			;
		}
	}

	public  void  setInformacionFinancieras(List<InformacionFinanciera> informacionfinancieras) {
		try {
			this.informacionfinancieras=informacionfinancieras;
		} catch(Exception e) {
			;
		}
	}

	public  void  setTelefonos(List<Telefono> telefonos) {
		try {
			this.telefonos=telefonos;
		} catch(Exception e) {
			;
		}
	}

	public  void  setCuentaPorCobrars(List<CuentaPorCobrar> cuentaporcobrars) {
		try {
			this.cuentaporcobrars=cuentaporcobrars;
		} catch(Exception e) {
			;
		}
	}

	public  void  setResponsables(List<Responsable> responsables) {
		try {
			this.responsables=responsables;
		} catch(Exception e) {
			;
		}
	}

	public  void  setTransportistas(List<Transportista> transportistas) {
		try {
			this.transportistas=transportistas;
		} catch(Exception e) {
			;
		}
	}

	public  void  setPoliticaClientes(List<PoliticaCliente> politicaclientes) {
		try {
			this.politicaclientes=politicaclientes;
		} catch(Exception e) {
			;
		}
	}

	public  void  setConyuge(Conyuge conyuge) {
	try {
			this.conyuge=conyuge;
		} catch(Exception e) {
			;
		}
	}

	public  void  setReferenciaBancarias(List<ReferenciaBancaria> referenciabancarias) {
		try {
			this.referenciabancarias=referenciabancarias;
		} catch(Exception e) {
			;
		}
	}

	public  void  setBalanceGeneralClientes(List<BalanceGeneralCliente> balancegeneralclientes) {
		try {
			this.balancegeneralclientes=balancegeneralclientes;
		} catch(Exception e) {
			;
		}
	}

	public  void  setDatoConstitucions(List<DatoConstitucion> datoconstitucions) {
		try {
			this.datoconstitucions=datoconstitucions;
		} catch(Exception e) {
			;
		}
	}

	public  void  setActividadEconomicas(List<ActividadEconomica> actividadeconomicas) {
		try {
			this.actividadeconomicas=actividadeconomicas;
		} catch(Exception e) {
			;
		}
	}

	public  void  setProveedorProductos(List<ProveedorProducto> proveedorproductos) {
		try {
			this.proveedorproductos=proveedorproductos;
		} catch(Exception e) {
			;
		}
	}

	public  void  setConsignatarios(List<Consignatario> consignatarios) {
		try {
			this.consignatarios=consignatarios;
		} catch(Exception e) {
			;
		}
	}

	public  void  setHobbyClientes(List<HobbyCliente> hobbyclientes) {
		try {
			this.hobbyclientes=hobbyclientes;
		} catch(Exception e) {
			;
		}
	}

	public  void  setRepresentanteLegals(List<RepresentanteLegal> representantelegals) {
		try {
			this.representantelegals=representantelegals;
		} catch(Exception e) {
			;
		}
	}

	public  void  setClienteCoas(List<ClienteCoa> clientecoas) {
		try {
			this.clientecoas=clientecoas;
		} catch(Exception e) {
			;
		}
	}

	public  void  setDireccions(List<Direccion> direccions) {
		try {
			this.direccions=direccions;
		} catch(Exception e) {
			;
		}
	}

	public  void  setClienteImagens(List<ClienteImagen> clienteimagens) {
		try {
			this.clienteimagens=clienteimagens;
		} catch(Exception e) {
			;
		}
	}

	public  void  setSubClientes(List<SubCliente> subclientes) {
		try {
			this.subclientes=subclientes;
		} catch(Exception e) {
			;
		}
	}

	public  void  setServicioClientes(List<ServicioCliente> servicioclientes) {
		try {
			this.servicioclientes=servicioclientes;
		} catch(Exception e) {
			;
		}
	}

	public  void  setInformacionEconomicas(List<InformacionEconomica> informacioneconomicas) {
		try {
			this.informacioneconomicas=informacioneconomicas;
		} catch(Exception e) {
			;
		}
	}

	public  void  setVehiculoClientes(List<VehiculoCliente> vehiculoclientes) {
		try {
			this.vehiculoclientes=vehiculoclientes;
		} catch(Exception e) {
			;
		}
	}

	public  void  setNegocioClientes(List<NegocioCliente> negocioclientes) {
		try {
			this.negocioclientes=negocioclientes;
		} catch(Exception e) {
			;
		}
	}

	public  void  setMontos(List<Monto> montos) {
		try {
			this.montos=montos;
		} catch(Exception e) {
			;
		}
	}

	
	/*PARA REPORTES*/
	String id_empresa_descripcion="";String id_sucursal_descripcion="";String id_tipo_identificacion_descripcion="";String es_prove_descripcion="";String id_grupo_cliente_descripcion="";String id_titulo_cliente_descripcion="";String id_area_cr_descripcion="";String id_estado_cliente_descripcion="";String id_pais_descripcion="";String id_region_descripcion="";String id_provincia_descripcion="";String id_ciudad_descripcion="";String id_zona_descripcion="";String id_pais_nacionalidad_descripcion="";String id_tipo_cargo_labo_descripcion="";String id_tipo_nivel_edu_descripcion="";String id_profesion_descripcion="";String id_tipo_genero_descripcion="";String id_estado_civil_descripcion="";String id_estado_legal_descripcion="";String id_cuenta_contable_descripcion="";String id_ruta_descripcion="";String id_vendedor_descripcion="";String id_centro_actividad_descripcion="";String id_tipo_garantia_empresa_descripcion="";String id_cate_tipo_afiliacion_descripcion="";String id_dia_descripcion="";String id_empleado_descripcion="";String con_separacion_bienes_descripcion="";String id_tipo_precio_descripcion="";String id_tipo_lista_precio_descripcion="";String es_contribuyente_especial_descripcion="";
	
	
	public String getid_empresa_descripcion() {
		return id_empresa_descripcion;
	}
	public String getid_sucursal_descripcion() {
		return id_sucursal_descripcion;
	}
	public String getid_tipo_identificacion_descripcion() {
		return id_tipo_identificacion_descripcion;
	}
	public String getes_prove_descripcion() {
		return es_prove_descripcion;
	}
	public String getid_grupo_cliente_descripcion() {
		return id_grupo_cliente_descripcion;
	}
	public String getid_titulo_cliente_descripcion() {
		return id_titulo_cliente_descripcion;
	}
	public String getid_area_cr_descripcion() {
		return id_area_cr_descripcion;
	}
	public String getid_estado_cliente_descripcion() {
		return id_estado_cliente_descripcion;
	}
	public String getid_pais_descripcion() {
		return id_pais_descripcion;
	}
	public String getid_region_descripcion() {
		return id_region_descripcion;
	}
	public String getid_provincia_descripcion() {
		return id_provincia_descripcion;
	}
	public String getid_ciudad_descripcion() {
		return id_ciudad_descripcion;
	}
	public String getid_zona_descripcion() {
		return id_zona_descripcion;
	}
	public String getid_pais_nacionalidad_descripcion() {
		return id_pais_nacionalidad_descripcion;
	}
	public String getid_tipo_cargo_labo_descripcion() {
		return id_tipo_cargo_labo_descripcion;
	}
	public String getid_tipo_nivel_edu_descripcion() {
		return id_tipo_nivel_edu_descripcion;
	}
	public String getid_profesion_descripcion() {
		return id_profesion_descripcion;
	}
	public String getid_tipo_genero_descripcion() {
		return id_tipo_genero_descripcion;
	}
	public String getid_estado_civil_descripcion() {
		return id_estado_civil_descripcion;
	}
	public String getid_estado_legal_descripcion() {
		return id_estado_legal_descripcion;
	}
	public String getid_cuenta_contable_descripcion() {
		return id_cuenta_contable_descripcion;
	}
	public String getid_ruta_descripcion() {
		return id_ruta_descripcion;
	}
	public String getid_vendedor_descripcion() {
		return id_vendedor_descripcion;
	}
	public String getid_centro_actividad_descripcion() {
		return id_centro_actividad_descripcion;
	}
	public String getid_tipo_garantia_empresa_descripcion() {
		return id_tipo_garantia_empresa_descripcion;
	}
	public String getid_cate_tipo_afiliacion_descripcion() {
		return id_cate_tipo_afiliacion_descripcion;
	}
	public String getid_dia_descripcion() {
		return id_dia_descripcion;
	}
	public String getid_empleado_descripcion() {
		return id_empleado_descripcion;
	}
	public String getcon_separacion_bienes_descripcion() {
		return con_separacion_bienes_descripcion;
	}
	public String getid_tipo_precio_descripcion() {
		return id_tipo_precio_descripcion;
	}
	public String getid_tipo_lista_precio_descripcion() {
		return id_tipo_lista_precio_descripcion;
	}
	public String getes_contribuyente_especial_descripcion() {
		return es_contribuyente_especial_descripcion;
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
	public void setid_tipo_identificacion_descripcion(String newid_tipo_identificacion_descripcion)throws Exception {
		try {
			this.id_tipo_identificacion_descripcion=newid_tipo_identificacion_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setes_prove_descripcion(String newes_prove_descripcion)throws Exception {
		try {
			this.es_prove_descripcion=newes_prove_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_grupo_cliente_descripcion(String newid_grupo_cliente_descripcion)throws Exception {
		try {
			this.id_grupo_cliente_descripcion=newid_grupo_cliente_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_titulo_cliente_descripcion(String newid_titulo_cliente_descripcion)throws Exception {
		try {
			this.id_titulo_cliente_descripcion=newid_titulo_cliente_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_area_cr_descripcion(String newid_area_cr_descripcion)throws Exception {
		try {
			this.id_area_cr_descripcion=newid_area_cr_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_estado_cliente_descripcion(String newid_estado_cliente_descripcion)throws Exception {
		try {
			this.id_estado_cliente_descripcion=newid_estado_cliente_descripcion;
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
	public void setid_region_descripcion(String newid_region_descripcion)throws Exception {
		try {
			this.id_region_descripcion=newid_region_descripcion;
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
	public void setid_zona_descripcion(String newid_zona_descripcion)throws Exception {
		try {
			this.id_zona_descripcion=newid_zona_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_pais_nacionalidad_descripcion(String newid_pais_nacionalidad_descripcion)throws Exception {
		try {
			this.id_pais_nacionalidad_descripcion=newid_pais_nacionalidad_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_tipo_cargo_labo_descripcion(String newid_tipo_cargo_labo_descripcion)throws Exception {
		try {
			this.id_tipo_cargo_labo_descripcion=newid_tipo_cargo_labo_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_tipo_nivel_edu_descripcion(String newid_tipo_nivel_edu_descripcion)throws Exception {
		try {
			this.id_tipo_nivel_edu_descripcion=newid_tipo_nivel_edu_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_profesion_descripcion(String newid_profesion_descripcion)throws Exception {
		try {
			this.id_profesion_descripcion=newid_profesion_descripcion;
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
	public void setid_estado_civil_descripcion(String newid_estado_civil_descripcion)throws Exception {
		try {
			this.id_estado_civil_descripcion=newid_estado_civil_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_estado_legal_descripcion(String newid_estado_legal_descripcion)throws Exception {
		try {
			this.id_estado_legal_descripcion=newid_estado_legal_descripcion;
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
	public void setid_ruta_descripcion(String newid_ruta_descripcion)throws Exception {
		try {
			this.id_ruta_descripcion=newid_ruta_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_vendedor_descripcion(String newid_vendedor_descripcion)throws Exception {
		try {
			this.id_vendedor_descripcion=newid_vendedor_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_centro_actividad_descripcion(String newid_centro_actividad_descripcion)throws Exception {
		try {
			this.id_centro_actividad_descripcion=newid_centro_actividad_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_tipo_garantia_empresa_descripcion(String newid_tipo_garantia_empresa_descripcion)throws Exception {
		try {
			this.id_tipo_garantia_empresa_descripcion=newid_tipo_garantia_empresa_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_cate_tipo_afiliacion_descripcion(String newid_cate_tipo_afiliacion_descripcion)throws Exception {
		try {
			this.id_cate_tipo_afiliacion_descripcion=newid_cate_tipo_afiliacion_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_dia_descripcion(String newid_dia_descripcion)throws Exception {
		try {
			this.id_dia_descripcion=newid_dia_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_empleado_descripcion(String newid_empleado_descripcion)throws Exception {
		try {
			this.id_empleado_descripcion=newid_empleado_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setcon_separacion_bienes_descripcion(String newcon_separacion_bienes_descripcion)throws Exception {
		try {
			this.con_separacion_bienes_descripcion=newcon_separacion_bienes_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_tipo_precio_descripcion(String newid_tipo_precio_descripcion)throws Exception {
		try {
			this.id_tipo_precio_descripcion=newid_tipo_precio_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_tipo_lista_precio_descripcion(String newid_tipo_lista_precio_descripcion)throws Exception {
		try {
			this.id_tipo_lista_precio_descripcion=newid_tipo_lista_precio_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setes_contribuyente_especial_descripcion(String newes_contribuyente_especial_descripcion)throws Exception {
		try {
			this.es_contribuyente_especial_descripcion=newes_contribuyente_especial_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	
	public void inicializarVariablesParaReporte() {
		this.id_empresa_descripcion="";this.id_sucursal_descripcion="";this.id_tipo_identificacion_descripcion="";this.es_prove_descripcion="";this.id_grupo_cliente_descripcion="";this.id_titulo_cliente_descripcion="";this.id_area_cr_descripcion="";this.id_estado_cliente_descripcion="";this.id_pais_descripcion="";this.id_region_descripcion="";this.id_provincia_descripcion="";this.id_ciudad_descripcion="";this.id_zona_descripcion="";this.id_pais_nacionalidad_descripcion="";this.id_tipo_cargo_labo_descripcion="";this.id_tipo_nivel_edu_descripcion="";this.id_profesion_descripcion="";this.id_tipo_genero_descripcion="";this.id_estado_civil_descripcion="";this.id_estado_legal_descripcion="";this.id_cuenta_contable_descripcion="";this.id_ruta_descripcion="";this.id_vendedor_descripcion="";this.id_centro_actividad_descripcion="";this.id_tipo_garantia_empresa_descripcion="";this.id_cate_tipo_afiliacion_descripcion="";this.id_dia_descripcion="";this.id_empleado_descripcion="";this.con_separacion_bienes_descripcion="";this.id_tipo_precio_descripcion="";this.id_tipo_lista_precio_descripcion="";this.es_contribuyente_especial_descripcion="";
	}
	
	
	Object transaccionlocalsDescripcionReporte;
	Object proformasDescripcionReporte;
	Object productosDescripcionReporte;
	Object informacionlaboralsDescripcionReporte;
	Object transportistasDescripcionReporte;
	Object registroformapagobancosDescripcionReporte;
	Object novedadsDescripcionReporte;
	Object PoliticasClienteDescripcionReporte;
	Object facturaproveedorsDescripcionReporte;
	Object referenciapersonalsDescripcionReporte;
	Object balancegeneralclientesDescripcionReporte;
	Object cajaingresodetallesDescripcionReporte;
	Object politicaclientesDescripcionReporte;
	Object autoriconsepsDescripcionReporte;
	Object detalleactivofijosDescripcionReporte;
	Object recibopuntoventasDescripcionReporte;
	Object clienteretencionsDescripcionReporte;
	Object asientocontablesDescripcionReporte;
	Object autoripagoordencomprasDescripcionReporte;
	Object ordencomprasDescripcionReporte;
	Object asientocontablecajachicasDescripcionReporte;
	Object retencionsDescripcionReporte;
	Object notacreditosDescripcionReporte;
	Object detallerecapsDescripcionReporte;
	Object vehiculoclientesDescripcionReporte;
	Object productoproveedorsDescripcionReporte;
	Object requisicioncomprasDescripcionReporte;
	Object responsablesDescripcionReporte;
	Object facturapuntoventasDescripcionReporte;
	Object informacionfinancierasDescripcionReporte;
	Object cajaegresodetallesDescripcionReporte;
	Object consignatariosDescripcionReporte;
	Object clienteimagensDescripcionReporte;
	Object facturadiariosDescripcionReporte;
	Object garantiaclientesDescripcionReporte;
	Object informacioneconomicasDescripcionReporte;
	Object referenciacomercialsDescripcionReporte;
	Object biensDescripcionReporte;
	Object serviciotransporteProveedorsDescripcionReporte;
	Object pedidopuntoventasDescripcionReporte;
	Object notacreditosolisDescripcionReporte;
	Object proveedorproductosDescripcionReporte;
	Object servicioclientesDescripcionReporte;
	Object consignacionsDescripcionReporte;
	Object contactoclientesDescripcionReporte;
	Object liquidacionimpuestoimporsDescripcionReporte;
	Object detalleclientesDescripcionReporte;
	Object pedidosDescripcionReporte;
	Object datoconstitucionsDescripcionReporte;
	Object clientecoasDescripcionReporte;
	Object hobbyclientesDescripcionReporte;
	Object pagoautosDescripcionReporte;
	Object tareaclientesDescripcionReporte;
	Object cargafamiliarsDescripcionReporte;
	Object pedidocompraimporProveedorsDescripcionReporte;
	Object evaluacionproveedorsDescripcionReporte;
	Object emailsDescripcionReporte;
	Object ConyugeDescripcionReporte;
	Object pedidocomprasDescripcionReporte;
	Object pedidoexporsDescripcionReporte;
	Object detalleprovesDescripcionReporte;
	Object cuentaporcobrarsDescripcionReporte;
	Object facturasDescripcionReporte;
	Object importarexportarsDescripcionReporte;
	Object firmaclientesDescripcionReporte;
	Object detalledescuenpoliventasDescripcionReporte;
	Object productoprodugastoProveedorsDescripcionReporte;
	Object srisDescripcionReporte;
	Object guiaremisionsDescripcionReporte;
	Object cuentabancopunvensDescripcionReporte;
	Object representantelegalsDescripcionReporte;
	Object telefonosDescripcionReporte;
	Object notacreditopuntoventasDescripcionReporte;
	Object negocioclientesDescripcionReporte;
	Object referenciabancariasDescripcionReporte;
	Object montosDescripcionReporte;
	Object configuracionpunvenConsumidorFinalsDescripcionReporte;
	Object parametrofactuempresaOrigensDescripcionReporte;
	Object productoordendetaprodugastoProveedorsDescripcionReporte;
	Object clientearchivosDescripcionReporte;
	Object accionistasDescripcionReporte;
	Object actividadeconomicasDescripcionReporte;
	Object ordenprodusDescripcionReporte;
	Object autoripagosDescripcionReporte;
	Object detallemoviclienprovesDescripcionReporte;
	Object facturaproveedorserviciosDescripcionReporte;
	Object comprasDescripcionReporte;
	Object pedidoprodusDescripcionReporte;
	Object direccionsDescripcionReporte;
	Object chequepostfechadosDescripcionReporte;
	Object subclientesDescripcionReporte;
	
	
	public Object gettransaccionlocalsDescripcionReporte() {
		return transaccionlocalsDescripcionReporte;
	}

	public Object getproformasDescripcionReporte() {
		return proformasDescripcionReporte;
	}

	public Object getproductosDescripcionReporte() {
		return productosDescripcionReporte;
	}

	public Object getinformacionlaboralsDescripcionReporte() {
		return informacionlaboralsDescripcionReporte;
	}

	public Object gettransportistasDescripcionReporte() {
		return transportistasDescripcionReporte;
	}

	public Object getregistroformapagobancosDescripcionReporte() {
		return registroformapagobancosDescripcionReporte;
	}

	public Object getnovedadsDescripcionReporte() {
		return novedadsDescripcionReporte;
	}

	public Object getPoliticasClienteDescripcionReporte()
	{
		return PoliticasClienteDescripcionReporte;
	}

	public Object getfacturaproveedorsDescripcionReporte() {
		return facturaproveedorsDescripcionReporte;
	}

	public Object getreferenciapersonalsDescripcionReporte() {
		return referenciapersonalsDescripcionReporte;
	}

	public Object getbalancegeneralclientesDescripcionReporte() {
		return balancegeneralclientesDescripcionReporte;
	}

	public Object getcajaingresodetallesDescripcionReporte() {
		return cajaingresodetallesDescripcionReporte;
	}

	public Object getpoliticaclientesDescripcionReporte() {
		return politicaclientesDescripcionReporte;
	}

	public Object getautoriconsepsDescripcionReporte() {
		return autoriconsepsDescripcionReporte;
	}

	public Object getdetalleactivofijosDescripcionReporte() {
		return detalleactivofijosDescripcionReporte;
	}

	public Object getrecibopuntoventasDescripcionReporte() {
		return recibopuntoventasDescripcionReporte;
	}

	public Object getclienteretencionsDescripcionReporte() {
		return clienteretencionsDescripcionReporte;
	}

	public Object getasientocontablesDescripcionReporte() {
		return asientocontablesDescripcionReporte;
	}

	public Object getautoripagoordencomprasDescripcionReporte() {
		return autoripagoordencomprasDescripcionReporte;
	}

	public Object getordencomprasDescripcionReporte() {
		return ordencomprasDescripcionReporte;
	}

	public Object getasientocontablecajachicasDescripcionReporte() {
		return asientocontablecajachicasDescripcionReporte;
	}

	public Object getretencionsDescripcionReporte() {
		return retencionsDescripcionReporte;
	}

	public Object getnotacreditosDescripcionReporte() {
		return notacreditosDescripcionReporte;
	}

	public Object getdetallerecapsDescripcionReporte() {
		return detallerecapsDescripcionReporte;
	}

	public Object getvehiculoclientesDescripcionReporte() {
		return vehiculoclientesDescripcionReporte;
	}

	public Object getproductoproveedorsDescripcionReporte() {
		return productoproveedorsDescripcionReporte;
	}

	public Object getrequisicioncomprasDescripcionReporte() {
		return requisicioncomprasDescripcionReporte;
	}

	public Object getresponsablesDescripcionReporte() {
		return responsablesDescripcionReporte;
	}

	public Object getfacturapuntoventasDescripcionReporte() {
		return facturapuntoventasDescripcionReporte;
	}

	public Object getinformacionfinancierasDescripcionReporte() {
		return informacionfinancierasDescripcionReporte;
	}

	public Object getcajaegresodetallesDescripcionReporte() {
		return cajaegresodetallesDescripcionReporte;
	}

	public Object getconsignatariosDescripcionReporte() {
		return consignatariosDescripcionReporte;
	}

	public Object getclienteimagensDescripcionReporte() {
		return clienteimagensDescripcionReporte;
	}

	public Object getfacturadiariosDescripcionReporte() {
		return facturadiariosDescripcionReporte;
	}

	public Object getgarantiaclientesDescripcionReporte() {
		return garantiaclientesDescripcionReporte;
	}

	public Object getinformacioneconomicasDescripcionReporte() {
		return informacioneconomicasDescripcionReporte;
	}

	public Object getreferenciacomercialsDescripcionReporte() {
		return referenciacomercialsDescripcionReporte;
	}

	public Object getbiensDescripcionReporte() {
		return biensDescripcionReporte;
	}

	public Object getserviciotransporteProveedorsDescripcionReporte() {
		return serviciotransporteProveedorsDescripcionReporte;
	}

	public Object getpedidopuntoventasDescripcionReporte() {
		return pedidopuntoventasDescripcionReporte;
	}

	public Object getnotacreditosolisDescripcionReporte() {
		return notacreditosolisDescripcionReporte;
	}

	public Object getproveedorproductosDescripcionReporte() {
		return proveedorproductosDescripcionReporte;
	}

	public Object getservicioclientesDescripcionReporte() {
		return servicioclientesDescripcionReporte;
	}

	public Object getconsignacionsDescripcionReporte() {
		return consignacionsDescripcionReporte;
	}

	public Object getcontactoclientesDescripcionReporte() {
		return contactoclientesDescripcionReporte;
	}

	public Object getliquidacionimpuestoimporsDescripcionReporte() {
		return liquidacionimpuestoimporsDescripcionReporte;
	}

	public Object getdetalleclientesDescripcionReporte() {
		return detalleclientesDescripcionReporte;
	}

	public Object getpedidosDescripcionReporte() {
		return pedidosDescripcionReporte;
	}

	public Object getdatoconstitucionsDescripcionReporte() {
		return datoconstitucionsDescripcionReporte;
	}

	public Object getclientecoasDescripcionReporte() {
		return clientecoasDescripcionReporte;
	}

	public Object gethobbyclientesDescripcionReporte() {
		return hobbyclientesDescripcionReporte;
	}

	public Object getpagoautosDescripcionReporte() {
		return pagoautosDescripcionReporte;
	}

	public Object gettareaclientesDescripcionReporte() {
		return tareaclientesDescripcionReporte;
	}

	public Object getcargafamiliarsDescripcionReporte() {
		return cargafamiliarsDescripcionReporte;
	}

	public Object getpedidocompraimporProveedorsDescripcionReporte() {
		return pedidocompraimporProveedorsDescripcionReporte;
	}

	public Object getevaluacionproveedorsDescripcionReporte() {
		return evaluacionproveedorsDescripcionReporte;
	}

	public Object getemailsDescripcionReporte() {
		return emailsDescripcionReporte;
	}

	public Object getConyugeDescripcionReporte()
	{
		return ConyugeDescripcionReporte;
	}

	public Object getpedidocomprasDescripcionReporte() {
		return pedidocomprasDescripcionReporte;
	}

	public Object getpedidoexporsDescripcionReporte() {
		return pedidoexporsDescripcionReporte;
	}

	public Object getdetalleprovesDescripcionReporte() {
		return detalleprovesDescripcionReporte;
	}

	public Object getcuentaporcobrarsDescripcionReporte() {
		return cuentaporcobrarsDescripcionReporte;
	}

	public Object getfacturasDescripcionReporte() {
		return facturasDescripcionReporte;
	}

	public Object getimportarexportarsDescripcionReporte() {
		return importarexportarsDescripcionReporte;
	}

	public Object getfirmaclientesDescripcionReporte() {
		return firmaclientesDescripcionReporte;
	}

	public Object getdetalledescuenpoliventasDescripcionReporte() {
		return detalledescuenpoliventasDescripcionReporte;
	}

	public Object getproductoprodugastoProveedorsDescripcionReporte() {
		return productoprodugastoProveedorsDescripcionReporte;
	}

	public Object getsrisDescripcionReporte() {
		return srisDescripcionReporte;
	}

	public Object getguiaremisionsDescripcionReporte() {
		return guiaremisionsDescripcionReporte;
	}

	public Object getcuentabancopunvensDescripcionReporte() {
		return cuentabancopunvensDescripcionReporte;
	}

	public Object getrepresentantelegalsDescripcionReporte() {
		return representantelegalsDescripcionReporte;
	}

	public Object gettelefonosDescripcionReporte() {
		return telefonosDescripcionReporte;
	}

	public Object getnotacreditopuntoventasDescripcionReporte() {
		return notacreditopuntoventasDescripcionReporte;
	}

	public Object getnegocioclientesDescripcionReporte() {
		return negocioclientesDescripcionReporte;
	}

	public Object getreferenciabancariasDescripcionReporte() {
		return referenciabancariasDescripcionReporte;
	}

	public Object getmontosDescripcionReporte() {
		return montosDescripcionReporte;
	}

	public Object getconfiguracionpunvenConsumidorFinalsDescripcionReporte() {
		return configuracionpunvenConsumidorFinalsDescripcionReporte;
	}

	public Object getparametrofactuempresaOrigensDescripcionReporte() {
		return parametrofactuempresaOrigensDescripcionReporte;
	}

	public Object getproductoordendetaprodugastoProveedorsDescripcionReporte() {
		return productoordendetaprodugastoProveedorsDescripcionReporte;
	}

	public Object getclientearchivosDescripcionReporte() {
		return clientearchivosDescripcionReporte;
	}

	public Object getaccionistasDescripcionReporte() {
		return accionistasDescripcionReporte;
	}

	public Object getactividadeconomicasDescripcionReporte() {
		return actividadeconomicasDescripcionReporte;
	}

	public Object getordenprodusDescripcionReporte() {
		return ordenprodusDescripcionReporte;
	}

	public Object getautoripagosDescripcionReporte() {
		return autoripagosDescripcionReporte;
	}

	public Object getdetallemoviclienprovesDescripcionReporte() {
		return detallemoviclienprovesDescripcionReporte;
	}

	public Object getfacturaproveedorserviciosDescripcionReporte() {
		return facturaproveedorserviciosDescripcionReporte;
	}

	public Object getcomprasDescripcionReporte() {
		return comprasDescripcionReporte;
	}

	public Object getpedidoprodusDescripcionReporte() {
		return pedidoprodusDescripcionReporte;
	}

	public Object getdireccionsDescripcionReporte() {
		return direccionsDescripcionReporte;
	}

	public Object getchequepostfechadosDescripcionReporte() {
		return chequepostfechadosDescripcionReporte;
	}

	public Object getsubclientesDescripcionReporte() {
		return subclientesDescripcionReporte;
	}

	
	
	public  void  settransaccionlocalsDescripcionReporte(Object transaccionlocals) {
		try {
			this.transaccionlocalsDescripcionReporte=transaccionlocals;
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

	public  void  setproductosDescripcionReporte(Object productos) {
		try {
			this.productosDescripcionReporte=productos;
		} catch(Exception ex) {
			;
		}
	}

	public  void  setinformacionlaboralsDescripcionReporte(Object informacionlaborals) {
		try {
			this.informacionlaboralsDescripcionReporte=informacionlaborals;
		} catch(Exception ex) {
			;
		}
	}

	public  void  settransportistasDescripcionReporte(Object transportistas) {
		try {
			this.transportistasDescripcionReporte=transportistas;
		} catch(Exception ex) {
			;
		}
	}

	public  void  setregistroformapagobancosDescripcionReporte(Object registroformapagobancos) {
		try {
			this.registroformapagobancosDescripcionReporte=registroformapagobancos;
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

	public  void  setPoliticasClienteDescripcionReporte(Object politicascliente) {
	try {
			this.PoliticasClienteDescripcionReporte=politicascliente;
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

	public  void  setreferenciapersonalsDescripcionReporte(Object referenciapersonals) {
		try {
			this.referenciapersonalsDescripcionReporte=referenciapersonals;
		} catch(Exception ex) {
			;
		}
	}

	public  void  setbalancegeneralclientesDescripcionReporte(Object balancegeneralclientes) {
		try {
			this.balancegeneralclientesDescripcionReporte=balancegeneralclientes;
		} catch(Exception ex) {
			;
		}
	}

	public  void  setcajaingresodetallesDescripcionReporte(Object cajaingresodetalles) {
		try {
			this.cajaingresodetallesDescripcionReporte=cajaingresodetalles;
		} catch(Exception ex) {
			;
		}
	}

	public  void  setpoliticaclientesDescripcionReporte(Object politicaclientes) {
		try {
			this.politicaclientesDescripcionReporte=politicaclientes;
		} catch(Exception ex) {
			;
		}
	}

	public  void  setautoriconsepsDescripcionReporte(Object autoriconseps) {
		try {
			this.autoriconsepsDescripcionReporte=autoriconseps;
		} catch(Exception ex) {
			;
		}
	}

	public  void  setdetalleactivofijosDescripcionReporte(Object detalleactivofijos) {
		try {
			this.detalleactivofijosDescripcionReporte=detalleactivofijos;
		} catch(Exception ex) {
			;
		}
	}

	public  void  setrecibopuntoventasDescripcionReporte(Object recibopuntoventas) {
		try {
			this.recibopuntoventasDescripcionReporte=recibopuntoventas;
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

	public  void  setasientocontablesDescripcionReporte(Object asientocontables) {
		try {
			this.asientocontablesDescripcionReporte=asientocontables;
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

	public  void  setordencomprasDescripcionReporte(Object ordencompras) {
		try {
			this.ordencomprasDescripcionReporte=ordencompras;
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

	public  void  setretencionsDescripcionReporte(Object retencions) {
		try {
			this.retencionsDescripcionReporte=retencions;
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

	public  void  setdetallerecapsDescripcionReporte(Object detallerecaps) {
		try {
			this.detallerecapsDescripcionReporte=detallerecaps;
		} catch(Exception ex) {
			;
		}
	}

	public  void  setvehiculoclientesDescripcionReporte(Object vehiculoclientes) {
		try {
			this.vehiculoclientesDescripcionReporte=vehiculoclientes;
		} catch(Exception ex) {
			;
		}
	}

	public  void  setproductoproveedorsDescripcionReporte(Object productoproveedors) {
		try {
			this.productoproveedorsDescripcionReporte=productoproveedors;
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

	public  void  setresponsablesDescripcionReporte(Object responsables) {
		try {
			this.responsablesDescripcionReporte=responsables;
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

	public  void  setinformacionfinancierasDescripcionReporte(Object informacionfinancieras) {
		try {
			this.informacionfinancierasDescripcionReporte=informacionfinancieras;
		} catch(Exception ex) {
			;
		}
	}

	public  void  setcajaegresodetallesDescripcionReporte(Object cajaegresodetalles) {
		try {
			this.cajaegresodetallesDescripcionReporte=cajaegresodetalles;
		} catch(Exception ex) {
			;
		}
	}

	public  void  setconsignatariosDescripcionReporte(Object consignatarios) {
		try {
			this.consignatariosDescripcionReporte=consignatarios;
		} catch(Exception ex) {
			;
		}
	}

	public  void  setclienteimagensDescripcionReporte(Object clienteimagens) {
		try {
			this.clienteimagensDescripcionReporte=clienteimagens;
		} catch(Exception ex) {
			;
		}
	}

	public  void  setfacturadiariosDescripcionReporte(Object facturadiarios) {
		try {
			this.facturadiariosDescripcionReporte=facturadiarios;
		} catch(Exception ex) {
			;
		}
	}

	public  void  setgarantiaclientesDescripcionReporte(Object garantiaclientes) {
		try {
			this.garantiaclientesDescripcionReporte=garantiaclientes;
		} catch(Exception ex) {
			;
		}
	}

	public  void  setinformacioneconomicasDescripcionReporte(Object informacioneconomicas) {
		try {
			this.informacioneconomicasDescripcionReporte=informacioneconomicas;
		} catch(Exception ex) {
			;
		}
	}

	public  void  setreferenciacomercialsDescripcionReporte(Object referenciacomercials) {
		try {
			this.referenciacomercialsDescripcionReporte=referenciacomercials;
		} catch(Exception ex) {
			;
		}
	}

	public  void  setbiensDescripcionReporte(Object biens) {
		try {
			this.biensDescripcionReporte=biens;
		} catch(Exception ex) {
			;
		}
	}

	public  void  setserviciotransporteProveedorsDescripcionReporte(Object serviciotransportes) {
		try {
			this.serviciotransporteProveedorsDescripcionReporte=serviciotransportes;
		} catch(Exception ex) {
			;
		}
	}

	public  void  setpedidopuntoventasDescripcionReporte(Object pedidopuntoventas) {
		try {
			this.pedidopuntoventasDescripcionReporte=pedidopuntoventas;
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

	public  void  setproveedorproductosDescripcionReporte(Object proveedorproductos) {
		try {
			this.proveedorproductosDescripcionReporte=proveedorproductos;
		} catch(Exception ex) {
			;
		}
	}

	public  void  setservicioclientesDescripcionReporte(Object servicioclientes) {
		try {
			this.servicioclientesDescripcionReporte=servicioclientes;
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

	public  void  setcontactoclientesDescripcionReporte(Object contactoclientes) {
		try {
			this.contactoclientesDescripcionReporte=contactoclientes;
		} catch(Exception ex) {
			;
		}
	}

	public  void  setliquidacionimpuestoimporsDescripcionReporte(Object liquidacionimpuestoimpors) {
		try {
			this.liquidacionimpuestoimporsDescripcionReporte=liquidacionimpuestoimpors;
		} catch(Exception ex) {
			;
		}
	}

	public  void  setdetalleclientesDescripcionReporte(Object detalleclientes) {
		try {
			this.detalleclientesDescripcionReporte=detalleclientes;
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

	public  void  setdatoconstitucionsDescripcionReporte(Object datoconstitucions) {
		try {
			this.datoconstitucionsDescripcionReporte=datoconstitucions;
		} catch(Exception ex) {
			;
		}
	}

	public  void  setclientecoasDescripcionReporte(Object clientecoas) {
		try {
			this.clientecoasDescripcionReporte=clientecoas;
		} catch(Exception ex) {
			;
		}
	}

	public  void  sethobbyclientesDescripcionReporte(Object hobbyclientes) {
		try {
			this.hobbyclientesDescripcionReporte=hobbyclientes;
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

	public  void  settareaclientesDescripcionReporte(Object tareaclientes) {
		try {
			this.tareaclientesDescripcionReporte=tareaclientes;
		} catch(Exception ex) {
			;
		}
	}

	public  void  setcargafamiliarsDescripcionReporte(Object cargafamiliars) {
		try {
			this.cargafamiliarsDescripcionReporte=cargafamiliars;
		} catch(Exception ex) {
			;
		}
	}

	public  void  setpedidocompraimporProveedorsDescripcionReporte(Object pedidocompraimpors) {
		try {
			this.pedidocompraimporProveedorsDescripcionReporte=pedidocompraimpors;
		} catch(Exception ex) {
			;
		}
	}

	public  void  setevaluacionproveedorsDescripcionReporte(Object evaluacionproveedors) {
		try {
			this.evaluacionproveedorsDescripcionReporte=evaluacionproveedors;
		} catch(Exception ex) {
			;
		}
	}

	public  void  setemailsDescripcionReporte(Object emails) {
		try {
			this.emailsDescripcionReporte=emails;
		} catch(Exception ex) {
			;
		}
	}

	public  void  setConyugeDescripcionReporte(Object conyuge) {
	try {
			this.ConyugeDescripcionReporte=conyuge;
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

	public  void  setpedidoexporsDescripcionReporte(Object pedidoexpors) {
		try {
			this.pedidoexporsDescripcionReporte=pedidoexpors;
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

	public  void  setcuentaporcobrarsDescripcionReporte(Object cuentaporcobrars) {
		try {
			this.cuentaporcobrarsDescripcionReporte=cuentaporcobrars;
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

	public  void  setimportarexportarsDescripcionReporte(Object importarexportars) {
		try {
			this.importarexportarsDescripcionReporte=importarexportars;
		} catch(Exception ex) {
			;
		}
	}

	public  void  setfirmaclientesDescripcionReporte(Object firmaclientes) {
		try {
			this.firmaclientesDescripcionReporte=firmaclientes;
		} catch(Exception ex) {
			;
		}
	}

	public  void  setdetalledescuenpoliventasDescripcionReporte(Object detalledescuenpoliventas) {
		try {
			this.detalledescuenpoliventasDescripcionReporte=detalledescuenpoliventas;
		} catch(Exception ex) {
			;
		}
	}

	public  void  setproductoprodugastoProveedorsDescripcionReporte(Object productoprodugastos) {
		try {
			this.productoprodugastoProveedorsDescripcionReporte=productoprodugastos;
		} catch(Exception ex) {
			;
		}
	}

	public  void  setsrisDescripcionReporte(Object sris) {
		try {
			this.srisDescripcionReporte=sris;
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

	public  void  setcuentabancopunvensDescripcionReporte(Object cuentabancopunvens) {
		try {
			this.cuentabancopunvensDescripcionReporte=cuentabancopunvens;
		} catch(Exception ex) {
			;
		}
	}

	public  void  setrepresentantelegalsDescripcionReporte(Object representantelegals) {
		try {
			this.representantelegalsDescripcionReporte=representantelegals;
		} catch(Exception ex) {
			;
		}
	}

	public  void  settelefonosDescripcionReporte(Object telefonos) {
		try {
			this.telefonosDescripcionReporte=telefonos;
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

	public  void  setnegocioclientesDescripcionReporte(Object negocioclientes) {
		try {
			this.negocioclientesDescripcionReporte=negocioclientes;
		} catch(Exception ex) {
			;
		}
	}

	public  void  setreferenciabancariasDescripcionReporte(Object referenciabancarias) {
		try {
			this.referenciabancariasDescripcionReporte=referenciabancarias;
		} catch(Exception ex) {
			;
		}
	}

	public  void  setmontosDescripcionReporte(Object montos) {
		try {
			this.montosDescripcionReporte=montos;
		} catch(Exception ex) {
			;
		}
	}

	public  void  setconfiguracionpunvenConsumidorFinalsDescripcionReporte(Object configuracionpunvens) {
		try {
			this.configuracionpunvenConsumidorFinalsDescripcionReporte=configuracionpunvens;
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

	public  void  setproductoordendetaprodugastoProveedorsDescripcionReporte(Object productoordendetaprodugastos) {
		try {
			this.productoordendetaprodugastoProveedorsDescripcionReporte=productoordendetaprodugastos;
		} catch(Exception ex) {
			;
		}
	}

	public  void  setclientearchivosDescripcionReporte(Object clientearchivos) {
		try {
			this.clientearchivosDescripcionReporte=clientearchivos;
		} catch(Exception ex) {
			;
		}
	}

	public  void  setaccionistasDescripcionReporte(Object accionistas) {
		try {
			this.accionistasDescripcionReporte=accionistas;
		} catch(Exception ex) {
			;
		}
	}

	public  void  setactividadeconomicasDescripcionReporte(Object actividadeconomicas) {
		try {
			this.actividadeconomicasDescripcionReporte=actividadeconomicas;
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

	public  void  setautoripagosDescripcionReporte(Object autoripagos) {
		try {
			this.autoripagosDescripcionReporte=autoripagos;
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

	public  void  setfacturaproveedorserviciosDescripcionReporte(Object facturaproveedorservicios) {
		try {
			this.facturaproveedorserviciosDescripcionReporte=facturaproveedorservicios;
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

	public  void  setpedidoprodusDescripcionReporte(Object pedidoprodus) {
		try {
			this.pedidoprodusDescripcionReporte=pedidoprodus;
		} catch(Exception ex) {
			;
		}
	}

	public  void  setdireccionsDescripcionReporte(Object direccions) {
		try {
			this.direccionsDescripcionReporte=direccions;
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

	public  void  setsubclientesDescripcionReporte(Object subclientes) {
		try {
			this.subclientesDescripcionReporte=subclientes;
		} catch(Exception ex) {
			;
		}
	}

	/*PARA REPORTES FIN*/		
}

