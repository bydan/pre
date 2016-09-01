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
//import com.bydan.erp.seguridad.util.UsuarioConstantesFunciones;
import com.bydan.erp.seguridad.util.*;


import com.bydan.erp.puntoventa.util.*;
import com.bydan.erp.sris.util.*;
import com.bydan.erp.importaciones.util.*;
import com.bydan.erp.facturacion.util.*;
import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.contabilidad.util.*;
import com.bydan.erp.nomina.util.*;
import com.bydan.erp.inventario.util.*;
import com.bydan.erp.cartera.util.*;
import com.bydan.erp.comisiones.util.*;
import com.bydan.erp.tesoreria.util.*;
import com.bydan.erp.activosfijos.util.*;



import com.bydan.erp.puntoventa.business.entity.*;
import com.bydan.erp.sris.business.entity.*;
import com.bydan.erp.importaciones.business.entity.*;
import com.bydan.erp.facturacion.business.entity.*;
import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.nomina.business.entity.*;
import com.bydan.erp.inventario.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;
import com.bydan.erp.comisiones.business.entity.*;
import com.bydan.erp.tesoreria.business.entity.*;
import com.bydan.erp.activosfijos.business.entity.*;




@SuppressWarnings("unused")
public class Usuario extends UsuarioAdditional implements Serializable ,Cloneable {//UsuarioAdditional,GeneralEntity
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
	
	private Usuario usuarioOriginal;
	
	private Map<String, Object> mapUsuario;
			
	public Map<String, Object> getMapUsuario() {
		return mapUsuario;
	}

	public void setMapUsuario(Map<String, Object> mapUsuario) {
		this.mapUsuario = mapUsuario;
	}
	
	public void inicializarMapUsuario() {
		this.mapUsuario = new HashMap<String,Object>();
	}
	
	public void setMapUsuarioValue(String sKey,Object oValue) {
		this.mapUsuario.put(sKey, oValue);
	}
	
	public Object getMapUsuarioValue(String sKey) {
		return this.mapUsuario.get(sKey);
	}
	
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_empresa;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=50,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=UsuarioConstantesFunciones.SREGEXUSER_NAME,message=UsuarioConstantesFunciones.SMENSAJEREGEXUSER_NAME)
	private String user_name;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=500,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=UsuarioConstantesFunciones.SREGEXCLAVE,message=UsuarioConstantesFunciones.SMENSAJEREGEXCLAVE)
	private String clave;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=500,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=UsuarioConstantesFunciones.SREGEXCONFIRMAR_CLAVE,message=UsuarioConstantesFunciones.SMENSAJEREGEXCONFIRMAR_CLAVE)
	private String confirmar_clave;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=100,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=UsuarioConstantesFunciones.SREGEXNOMBRE,message=UsuarioConstantesFunciones.SMENSAJEREGEXNOMBRE)
	private String nombre;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=50,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=UsuarioConstantesFunciones.SREGEXCODIGO_ALTERNO,message=UsuarioConstantesFunciones.SMENSAJEREGEXCODIGO_ALTERNO)
	private String codigo_alterno;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Boolean tipo;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Boolean estado;
			
	
	public Empresa empresa;
	
	
	private String empresa_descripcion;
	
	
	public List<DepositoBanco> depositobancos;
	public List<HistorialCambioClave> historialcambioclaves;
	public List<AutoriRetencion> autoriretencions;
	public List<CajeroTurno> cajeroturnos;
	public List<DetalleLiquidacionImpor> detalleliquidacionimpors;
	public List<NotaCreditoSoli> notacreditosolis;
	public List<PedidoExpor> pedidoexpors;
	public List<DescuentoTipoPrecio> descuentotipoprecios;
	public List<GuiaRemision> guiaremisions;
	public List<PedidoPuntoVenta> pedidopuntoventas;
	public List<GastoEmpleado> gastoempleados;
	public List<SecuencialUsuario> secuencialusuarios;
	public List<MovimientoActivoFijo> movimientoactivofijos;
	public List<UsuarioOpcion> usuarioopcions;
	public List<PedidoCompraImpor> pedidocompraimpors;
	public List<OrdenCompra> ordencompras;
	public List<TurnoPunVen> turnopunvens;
	public List<Novedad> novedads;
	public ParametroGeneralUsuario parametrogeneralusuario;
	public List<AutoriPagoOrdenCompra> autoripagoordencompras;
	public List<CierreCaja> cierrecajas;
	public List<DescuentoMonto> descuentomontos;
	public List<CajaEgreso> cajaegresos;
	public List<RequisicionCompra> requisicioncompras;
	public List<NotaCreditoPuntoVenta> notacreditopuntoventas;
	public List<PlaneacionCompra> planeacioncompras;
	public List<PedidoCompra> pedidocompras;
	public List<PerfilUsuario> perfilusuarios;
	public List<Consignatario> consignatarios;
	public List<Transferencia> transferencias;
	public DatoGeneralUsuario datogeneralusuario;
	public List<CajaIngreso> cajaingresos;
	public List<ClienteCoa> clientecoas;
	public List<Consignacion> consignacions;
	public List<DetalleMensajeCorreoInven> detallemensajecorreoinvens;
		
	public Usuario () throws Exception {
		super();		
		
		this.id=0L;
		
		
		this.versionRow=new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());//new Date();
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		this.sType="NONE";
		
		this.usuarioOriginal=this;
		
 		this.id_empresa=-1L;
 		this.user_name="";
 		this.clave="";
 		this.confirmar_clave="";
 		this.nombre="";
 		this.codigo_alterno="";
 		this.tipo=false;
 		this.estado=false;
		
		
		this.empresa=null;
		
		
		this.empresa_descripcion="";
		
		
		this.depositobancos=null;
		this.historialcambioclaves=null;
		this.autoriretencions=null;
		this.cajeroturnos=null;
		this.detalleliquidacionimpors=null;
		this.notacreditosolis=null;
		this.pedidoexpors=null;
		this.descuentotipoprecios=null;
		this.guiaremisions=null;
		this.pedidopuntoventas=null;
		this.gastoempleados=null;
		this.secuencialusuarios=null;
		this.movimientoactivofijos=null;
		this.usuarioopcions=null;
		this.pedidocompraimpors=null;
		this.ordencompras=null;
		this.turnopunvens=null;
		this.novedads=null;
		this.autoripagoordencompras=null;
		this.cierrecajas=null;
		this.descuentomontos=null;
		this.cajaegresos=null;
		this.requisicioncompras=null;
		this.notacreditopuntoventas=null;
		this.planeacioncompras=null;
		this.pedidocompras=null;
		this.perfilusuarios=null;
		this.consignatarios=null;
		this.transferencias=null;
		this.cajaingresos=null;
		this.clientecoas=null;
		this.consignacions=null;
		this.detallemensajecorreoinvens=null;
		
			
		
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
    //PARA REPORTES
	public Usuario (Long id,Date versionRow,Long id_empresa,String user_name,String clave,String confirmar_clave,String nombre,String codigo_alterno,Boolean tipo,Boolean estado) throws Exception {
		super();		
		
		this.id=id;
		this.versionRow=versionRow;
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.usuarioOriginal=this;
		
 		this.id_empresa=id_empresa;
 		this.user_name=user_name;
 		this.clave=clave;
 		this.confirmar_clave=confirmar_clave;
 		this.nombre=nombre;
 		this.codigo_alterno=codigo_alterno;
 		this.tipo=tipo;
 		this.estado=estado;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	 //PARA REPORTES
	public Usuario (Long id_empresa,String user_name,String clave,String confirmar_clave,String nombre,String codigo_alterno,Boolean tipo,Boolean estado) throws Exception {
		super();		
		
		this.id=0L;
		this.versionRow=new Date();
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.usuarioOriginal=this;
		
 		this.id_empresa=id_empresa;
 		this.user_name=user_name;
 		this.clave=clave;
 		this.confirmar_clave=confirmar_clave;
 		this.nombre=nombre;
 		this.codigo_alterno=codigo_alterno;
 		this.tipo=tipo;
 		this.estado=estado;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	public boolean equals(Object object) {
		boolean equal=false;
		Usuario usuarioLocal=null;
		
		if(object!=null) {
			usuarioLocal=(Usuario)object;
			
			if(usuarioLocal!=null) {
				if(this.getId()!=null && usuarioLocal.getId()!=null) {
					if(this.getId().equals(usuarioLocal.getId())) {
						equal=true;
					}
				}
			}
		}
		
		return equal;
	}
	
	public String toString() {
		String sDetalle="";
		
		if(!UsuarioConstantesFunciones.CON_DESCRIPCION_DETALLADO) {
        	sDetalle=UsuarioConstantesFunciones.getUsuarioDescripcion(this);
		} else {
			sDetalle=UsuarioConstantesFunciones.getUsuarioDescripcionDetallado(this);
		}
		
		return sDetalle;
    }
	
	public Usuario getUsuarioOriginal() {
		return this.usuarioOriginal;
	}
	
	public void setUsuarioOriginal(Usuario usuario) {
		try {
			this.usuarioOriginal=usuario;
		} catch(Exception e) {
			;
		}
	}
	
	
	protected UsuarioAdditional usuarioAdditional=null;
	
	public UsuarioAdditional getUsuarioAdditional() {
		return this.usuarioAdditional;
	}
	
	public void setUsuarioAdditional(UsuarioAdditional usuarioAdditional) {
		try {
			this.usuarioAdditional=usuarioAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
    
	
	public Long getid_empresa() {
		return this.id_empresa;
	}
    
	
	public String getuser_name() {
		return this.user_name;
	}
    
	
	public String getclave() {
		return this.clave;
	}
    
	
	public String getconfirmar_clave() {
		return this.confirmar_clave;
	}
    
	
	public String getnombre() {
		return this.nombre;
	}
    
	
	public String getcodigo_alterno() {
		return this.codigo_alterno;
	}
    
	
	public Boolean gettipo() {
		return this.tipo;
	}
    
	
	public Boolean getestado() {
		return this.estado;
	}
	
    
	public void setid_empresa(Long newid_empresa)throws Exception
	{
		try {
			if(this.id_empresa!=newid_empresa) {
				if(newid_empresa==null) {
					//newid_empresa=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("Usuario:Valor nulo no permitido en columna id_empresa");
					}
				}

				this.id_empresa=newid_empresa;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setuser_name(String newuser_name)throws Exception
	{
		try {
			if(this.user_name!=newuser_name) {
				if(newuser_name==null) {
					//newuser_name="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("Usuario:Valor nulo no permitido en columna user_name");
					}
				}

				if(newuser_name!=null&&newuser_name.length()>50) {
					newuser_name=newuser_name.substring(0,48);
					System.out.println("Usuario:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=50 en columna user_name");
				}

				this.user_name=newuser_name;
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
						System.out.println("Usuario:Valor nulo no permitido en columna clave");
					}
				}

				if(newclave!=null&&newclave.length()>500) {
					newclave=newclave.substring(0,498);
					System.out.println("Usuario:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=500 en columna clave");
				}

				this.clave=newclave;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setconfirmar_clave(String newconfirmar_clave)throws Exception
	{
		try {
			if(this.confirmar_clave!=newconfirmar_clave) {
				if(newconfirmar_clave==null) {
					//newconfirmar_clave="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("Usuario:Valor nulo no permitido en columna confirmar_clave");
					}
				}

				if(newconfirmar_clave!=null&&newconfirmar_clave.length()>500) {
					newconfirmar_clave=newconfirmar_clave.substring(0,498);
					System.out.println("Usuario:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=500 en columna confirmar_clave");
				}

				this.confirmar_clave=newconfirmar_clave;
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
						System.out.println("Usuario:Valor nulo no permitido en columna nombre");
					}
				}

				if(newnombre!=null&&newnombre.length()>100) {
					newnombre=newnombre.substring(0,98);
					System.out.println("Usuario:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=100 en columna nombre");
				}

				this.nombre=newnombre;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setcodigo_alterno(String newcodigo_alterno)throws Exception
	{
		try {
			if(this.codigo_alterno!=newcodigo_alterno) {
				if(newcodigo_alterno==null) {
					//newcodigo_alterno="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("Usuario:Valor nulo no permitido en columna codigo_alterno");
					}
				}

				if(newcodigo_alterno!=null&&newcodigo_alterno.length()>50) {
					newcodigo_alterno=newcodigo_alterno.substring(0,48);
					System.out.println("Usuario:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=50 en columna codigo_alterno");
				}

				this.codigo_alterno=newcodigo_alterno;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void settipo(Boolean newtipo)throws Exception
	{
		try {
			if(this.tipo!=newtipo) {
				if(newtipo==null) {
					//newtipo=false;
					if(Constantes.ISDEVELOPING) {
						System.out.println("Usuario:Valor nulo no permitido en columna tipo");
					}
				}

				this.tipo=newtipo;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setestado(Boolean newestado)throws Exception
	{
		try {
			if(this.estado!=newestado) {
				if(newestado==null) {
					//newestado=false;
					if(Constantes.ISDEVELOPING) {
						System.out.println("Usuario:Valor nulo no permitido en columna estado");
					}
				}

				this.estado=newestado;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	
	public Empresa getEmpresa() {
		return this.empresa;
	}

	
	
	public String getempresa_descripcion() {
		return this.empresa_descripcion;
	}

	
	
	public  void  setEmpresa(Empresa empresa) {
		try {
			this.empresa=empresa;
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


	
	
	public List<DepositoBanco> getDepositoBancos() {
		return this.depositobancos;
	}

	public List<HistorialCambioClave> getHistorialCambioClaves() {
		return this.historialcambioclaves;
	}

	public List<AutoriRetencion> getAutoriRetencions() {
		return this.autoriretencions;
	}

	public List<CajeroTurno> getCajeroTurnos() {
		return this.cajeroturnos;
	}

	public List<DetalleLiquidacionImpor> getDetalleLiquidacionImpors() {
		return this.detalleliquidacionimpors;
	}

	public List<NotaCreditoSoli> getNotaCreditoSolis() {
		return this.notacreditosolis;
	}

	public List<PedidoExpor> getPedidoExpors() {
		return this.pedidoexpors;
	}

	public List<DescuentoTipoPrecio> getDescuentoTipoPrecios() {
		return this.descuentotipoprecios;
	}

	public List<GuiaRemision> getGuiaRemisions() {
		return this.guiaremisions;
	}

	public List<PedidoPuntoVenta> getPedidoPuntoVentas() {
		return this.pedidopuntoventas;
	}

	public List<GastoEmpleado> getGastoEmpleados() {
		return this.gastoempleados;
	}

	public List<SecuencialUsuario> getSecuencialUsuarios() {
		return this.secuencialusuarios;
	}

	public List<MovimientoActivoFijo> getMovimientoActivoFijos() {
		return this.movimientoactivofijos;
	}

	public List<UsuarioOpcion> getUsuarioOpcions() {
		return this.usuarioopcions;
	}

	public List<PedidoCompraImpor> getPedidoCompraImpors() {
		return this.pedidocompraimpors;
	}

	public List<OrdenCompra> getOrdenCompras() {
		return this.ordencompras;
	}

	public List<TurnoPunVen> getTurnoPunVens() {
		return this.turnopunvens;
	}

	public List<Novedad> getNovedads() {
		return this.novedads;
	}

	public ParametroGeneralUsuario getParametroGeneralUsuario() {
		return this.parametrogeneralusuario;
	}

	public List<AutoriPagoOrdenCompra> getAutoriPagoOrdenCompras() {
		return this.autoripagoordencompras;
	}

	public List<CierreCaja> getCierreCajas() {
		return this.cierrecajas;
	}

	public List<DescuentoMonto> getDescuentoMontos() {
		return this.descuentomontos;
	}

	public List<CajaEgreso> getCajaEgresos() {
		return this.cajaegresos;
	}

	public List<RequisicionCompra> getRequisicionCompras() {
		return this.requisicioncompras;
	}

	public List<NotaCreditoPuntoVenta> getNotaCreditoPuntoVentas() {
		return this.notacreditopuntoventas;
	}

	public List<PlaneacionCompra> getPlaneacionCompras() {
		return this.planeacioncompras;
	}

	public List<PedidoCompra> getPedidoCompras() {
		return this.pedidocompras;
	}

	public List<PerfilUsuario> getPerfilUsuarios() {
		return this.perfilusuarios;
	}

	public List<Consignatario> getConsignatarios() {
		return this.consignatarios;
	}

	public List<Transferencia> getTransferencias() {
		return this.transferencias;
	}

	public DatoGeneralUsuario getDatoGeneralUsuario() {
		return this.datogeneralusuario;
	}

	public List<CajaIngreso> getCajaIngresos() {
		return this.cajaingresos;
	}

	public List<ClienteCoa> getClienteCoas() {
		return this.clientecoas;
	}

	public List<Consignacion> getConsignacions() {
		return this.consignacions;
	}

	public List<DetalleMensajeCorreoInven> getDetalleMensajeCorreoInvens() {
		return this.detallemensajecorreoinvens;
	}

	
	
	public  void  setDepositoBancos(List<DepositoBanco> depositobancos) {
		try {
			this.depositobancos=depositobancos;
		} catch(Exception e) {
			;
		}
	}

	public  void  setHistorialCambioClaves(List<HistorialCambioClave> historialcambioclaves) {
		try {
			this.historialcambioclaves=historialcambioclaves;
		} catch(Exception e) {
			;
		}
	}

	public  void  setAutoriRetencions(List<AutoriRetencion> autoriretencions) {
		try {
			this.autoriretencions=autoriretencions;
		} catch(Exception e) {
			;
		}
	}

	public  void  setCajeroTurnos(List<CajeroTurno> cajeroturnos) {
		try {
			this.cajeroturnos=cajeroturnos;
		} catch(Exception e) {
			;
		}
	}

	public  void  setDetalleLiquidacionImpors(List<DetalleLiquidacionImpor> detalleliquidacionimpors) {
		try {
			this.detalleliquidacionimpors=detalleliquidacionimpors;
		} catch(Exception e) {
			;
		}
	}

	public  void  setNotaCreditoSolis(List<NotaCreditoSoli> notacreditosolis) {
		try {
			this.notacreditosolis=notacreditosolis;
		} catch(Exception e) {
			;
		}
	}

	public  void  setPedidoExpors(List<PedidoExpor> pedidoexpors) {
		try {
			this.pedidoexpors=pedidoexpors;
		} catch(Exception e) {
			;
		}
	}

	public  void  setDescuentoTipoPrecios(List<DescuentoTipoPrecio> descuentotipoprecios) {
		try {
			this.descuentotipoprecios=descuentotipoprecios;
		} catch(Exception e) {
			;
		}
	}

	public  void  setGuiaRemisions(List<GuiaRemision> guiaremisions) {
		try {
			this.guiaremisions=guiaremisions;
		} catch(Exception e) {
			;
		}
	}

	public  void  setPedidoPuntoVentas(List<PedidoPuntoVenta> pedidopuntoventas) {
		try {
			this.pedidopuntoventas=pedidopuntoventas;
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

	public  void  setSecuencialUsuarios(List<SecuencialUsuario> secuencialusuarios) {
		try {
			this.secuencialusuarios=secuencialusuarios;
		} catch(Exception e) {
			;
		}
	}

	public  void  setMovimientoActivoFijos(List<MovimientoActivoFijo> movimientoactivofijos) {
		try {
			this.movimientoactivofijos=movimientoactivofijos;
		} catch(Exception e) {
			;
		}
	}

	public  void  setUsuarioOpcions(List<UsuarioOpcion> usuarioopcions) {
		try {
			this.usuarioopcions=usuarioopcions;
		} catch(Exception e) {
			;
		}
	}

	public  void  setPedidoCompraImpors(List<PedidoCompraImpor> pedidocompraimpors) {
		try {
			this.pedidocompraimpors=pedidocompraimpors;
		} catch(Exception e) {
			;
		}
	}

	public  void  setOrdenCompras(List<OrdenCompra> ordencompras) {
		try {
			this.ordencompras=ordencompras;
		} catch(Exception e) {
			;
		}
	}

	public  void  setTurnoPunVens(List<TurnoPunVen> turnopunvens) {
		try {
			this.turnopunvens=turnopunvens;
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

	public  void  setParametroGeneralUsuario(ParametroGeneralUsuario parametrogeneralusuario) {
	try {
			this.parametrogeneralusuario=parametrogeneralusuario;
		} catch(Exception e) {
			;
		}
	}

	public  void  setAutoriPagoOrdenCompras(List<AutoriPagoOrdenCompra> autoripagoordencompras) {
		try {
			this.autoripagoordencompras=autoripagoordencompras;
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

	public  void  setDescuentoMontos(List<DescuentoMonto> descuentomontos) {
		try {
			this.descuentomontos=descuentomontos;
		} catch(Exception e) {
			;
		}
	}

	public  void  setCajaEgresos(List<CajaEgreso> cajaegresos) {
		try {
			this.cajaegresos=cajaegresos;
		} catch(Exception e) {
			;
		}
	}

	public  void  setRequisicionCompras(List<RequisicionCompra> requisicioncompras) {
		try {
			this.requisicioncompras=requisicioncompras;
		} catch(Exception e) {
			;
		}
	}

	public  void  setNotaCreditoPuntoVentas(List<NotaCreditoPuntoVenta> notacreditopuntoventas) {
		try {
			this.notacreditopuntoventas=notacreditopuntoventas;
		} catch(Exception e) {
			;
		}
	}

	public  void  setPlaneacionCompras(List<PlaneacionCompra> planeacioncompras) {
		try {
			this.planeacioncompras=planeacioncompras;
		} catch(Exception e) {
			;
		}
	}

	public  void  setPedidoCompras(List<PedidoCompra> pedidocompras) {
		try {
			this.pedidocompras=pedidocompras;
		} catch(Exception e) {
			;
		}
	}

	public  void  setPerfilUsuarios(List<PerfilUsuario> perfilusuarios) {
		try {
			this.perfilusuarios=perfilusuarios;
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

	public  void  setTransferencias(List<Transferencia> transferencias) {
		try {
			this.transferencias=transferencias;
		} catch(Exception e) {
			;
		}
	}

	public  void  setDatoGeneralUsuario(DatoGeneralUsuario datogeneralusuario) {
	try {
			this.datogeneralusuario=datogeneralusuario;
		} catch(Exception e) {
			;
		}
	}

	public  void  setCajaIngresos(List<CajaIngreso> cajaingresos) {
		try {
			this.cajaingresos=cajaingresos;
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

	public  void  setConsignacions(List<Consignacion> consignacions) {
		try {
			this.consignacions=consignacions;
		} catch(Exception e) {
			;
		}
	}

	public  void  setDetalleMensajeCorreoInvens(List<DetalleMensajeCorreoInven> detallemensajecorreoinvens) {
		try {
			this.detallemensajecorreoinvens=detallemensajecorreoinvens;
		} catch(Exception e) {
			;
		}
	}

	
	/*PARA REPORTES*/
	String id_empresa_descripcion="";String tipo_descripcion="";String estado_descripcion="";
	
	
	public String getid_empresa_descripcion() {
		return id_empresa_descripcion;
	}
	public String gettipo_descripcion() {
		return tipo_descripcion;
	}
	public String getestado_descripcion() {
		return estado_descripcion;
	}
	
	
	public void setid_empresa_descripcion(String newid_empresa_descripcion)throws Exception {
		try {
			this.id_empresa_descripcion=newid_empresa_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void settipo_descripcion(String newtipo_descripcion)throws Exception {
		try {
			this.tipo_descripcion=newtipo_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setestado_descripcion(String newestado_descripcion)throws Exception {
		try {
			this.estado_descripcion=newestado_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	
	public void inicializarVariablesParaReporte() {
		this.id_empresa_descripcion="";this.tipo_descripcion="";this.estado_descripcion="";
	}
	
	
	Object depositobancosDescripcionReporte;
	Object historialcambioclavesDescripcionReporte;
	Object autoriretencionsDescripcionReporte;
	Object cajeroturnosDescripcionReporte;
	Object detalleliquidacionimporsDescripcionReporte;
	Object notacreditosolisDescripcionReporte;
	Object pedidoexporsDescripcionReporte;
	Object descuentotipopreciosDescripcionReporte;
	Object guiaremisionsDescripcionReporte;
	Object pedidopuntoventasDescripcionReporte;
	Object gastoempleadosDescripcionReporte;
	Object secuencialusuariosDescripcionReporte;
	Object movimientoactivofijosDescripcionReporte;
	Object usuarioopcionsDescripcionReporte;
	Object pedidocompraimporsDescripcionReporte;
	Object ordencomprasDescripcionReporte;
	Object turnopunvensDescripcionReporte;
	Object novedadsDescripcionReporte;
	Object ParametroGeneralUsuarioDescripcionReporte;
	Object autoripagoordencomprasDescripcionReporte;
	Object cierrecajasDescripcionReporte;
	Object descuentomontosDescripcionReporte;
	Object cajaegresosDescripcionReporte;
	Object requisicioncomprasDescripcionReporte;
	Object notacreditopuntoventasDescripcionReporte;
	Object planeacioncomprasDescripcionReporte;
	Object pedidocomprasDescripcionReporte;
	Object perfilusuariosDescripcionReporte;
	Object consignatariosDescripcionReporte;
	Object transferenciasDescripcionReporte;
	Object DatoGeneralUsuarioDescripcionReporte;
	Object cajaingresosDescripcionReporte;
	Object clientecoasDescripcionReporte;
	Object consignacionsDescripcionReporte;
	Object detallemensajecorreoinvensDescripcionReporte;
	
	
	public Object getdepositobancosDescripcionReporte() {
		return depositobancosDescripcionReporte;
	}

	public Object gethistorialcambioclavesDescripcionReporte() {
		return historialcambioclavesDescripcionReporte;
	}

	public Object getautoriretencionsDescripcionReporte() {
		return autoriretencionsDescripcionReporte;
	}

	public Object getcajeroturnosDescripcionReporte() {
		return cajeroturnosDescripcionReporte;
	}

	public Object getdetalleliquidacionimporsDescripcionReporte() {
		return detalleliquidacionimporsDescripcionReporte;
	}

	public Object getnotacreditosolisDescripcionReporte() {
		return notacreditosolisDescripcionReporte;
	}

	public Object getpedidoexporsDescripcionReporte() {
		return pedidoexporsDescripcionReporte;
	}

	public Object getdescuentotipopreciosDescripcionReporte() {
		return descuentotipopreciosDescripcionReporte;
	}

	public Object getguiaremisionsDescripcionReporte() {
		return guiaremisionsDescripcionReporte;
	}

	public Object getpedidopuntoventasDescripcionReporte() {
		return pedidopuntoventasDescripcionReporte;
	}

	public Object getgastoempleadosDescripcionReporte() {
		return gastoempleadosDescripcionReporte;
	}

	public Object getsecuencialusuariosDescripcionReporte() {
		return secuencialusuariosDescripcionReporte;
	}

	public Object getmovimientoactivofijosDescripcionReporte() {
		return movimientoactivofijosDescripcionReporte;
	}

	public Object getusuarioopcionsDescripcionReporte() {
		return usuarioopcionsDescripcionReporte;
	}

	public Object getpedidocompraimporsDescripcionReporte() {
		return pedidocompraimporsDescripcionReporte;
	}

	public Object getordencomprasDescripcionReporte() {
		return ordencomprasDescripcionReporte;
	}

	public Object getturnopunvensDescripcionReporte() {
		return turnopunvensDescripcionReporte;
	}

	public Object getnovedadsDescripcionReporte() {
		return novedadsDescripcionReporte;
	}

	public Object getParametroGeneralUsuarioDescripcionReporte()
	{
		return ParametroGeneralUsuarioDescripcionReporte;
	}

	public Object getautoripagoordencomprasDescripcionReporte() {
		return autoripagoordencomprasDescripcionReporte;
	}

	public Object getcierrecajasDescripcionReporte() {
		return cierrecajasDescripcionReporte;
	}

	public Object getdescuentomontosDescripcionReporte() {
		return descuentomontosDescripcionReporte;
	}

	public Object getcajaegresosDescripcionReporte() {
		return cajaegresosDescripcionReporte;
	}

	public Object getrequisicioncomprasDescripcionReporte() {
		return requisicioncomprasDescripcionReporte;
	}

	public Object getnotacreditopuntoventasDescripcionReporte() {
		return notacreditopuntoventasDescripcionReporte;
	}

	public Object getplaneacioncomprasDescripcionReporte() {
		return planeacioncomprasDescripcionReporte;
	}

	public Object getpedidocomprasDescripcionReporte() {
		return pedidocomprasDescripcionReporte;
	}

	public Object getperfilusuariosDescripcionReporte() {
		return perfilusuariosDescripcionReporte;
	}

	public Object getconsignatariosDescripcionReporte() {
		return consignatariosDescripcionReporte;
	}

	public Object gettransferenciasDescripcionReporte() {
		return transferenciasDescripcionReporte;
	}

	public Object getDatoGeneralUsuarioDescripcionReporte()
	{
		return DatoGeneralUsuarioDescripcionReporte;
	}

	public Object getcajaingresosDescripcionReporte() {
		return cajaingresosDescripcionReporte;
	}

	public Object getclientecoasDescripcionReporte() {
		return clientecoasDescripcionReporte;
	}

	public Object getconsignacionsDescripcionReporte() {
		return consignacionsDescripcionReporte;
	}

	public Object getdetallemensajecorreoinvensDescripcionReporte() {
		return detallemensajecorreoinvensDescripcionReporte;
	}

	
	
	public  void  setdepositobancosDescripcionReporte(Object depositobancos) {
		try {
			this.depositobancosDescripcionReporte=depositobancos;
		} catch(Exception ex) {
			;
		}
	}

	public  void  sethistorialcambioclavesDescripcionReporte(Object historialcambioclaves) {
		try {
			this.historialcambioclavesDescripcionReporte=historialcambioclaves;
		} catch(Exception ex) {
			;
		}
	}

	public  void  setautoriretencionsDescripcionReporte(Object autoriretencions) {
		try {
			this.autoriretencionsDescripcionReporte=autoriretencions;
		} catch(Exception ex) {
			;
		}
	}

	public  void  setcajeroturnosDescripcionReporte(Object cajeroturnos) {
		try {
			this.cajeroturnosDescripcionReporte=cajeroturnos;
		} catch(Exception ex) {
			;
		}
	}

	public  void  setdetalleliquidacionimporsDescripcionReporte(Object detalleliquidacionimpors) {
		try {
			this.detalleliquidacionimporsDescripcionReporte=detalleliquidacionimpors;
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

	public  void  setpedidoexporsDescripcionReporte(Object pedidoexpors) {
		try {
			this.pedidoexporsDescripcionReporte=pedidoexpors;
		} catch(Exception ex) {
			;
		}
	}

	public  void  setdescuentotipopreciosDescripcionReporte(Object descuentotipoprecios) {
		try {
			this.descuentotipopreciosDescripcionReporte=descuentotipoprecios;
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

	public  void  setpedidopuntoventasDescripcionReporte(Object pedidopuntoventas) {
		try {
			this.pedidopuntoventasDescripcionReporte=pedidopuntoventas;
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

	public  void  setsecuencialusuariosDescripcionReporte(Object secuencialusuarios) {
		try {
			this.secuencialusuariosDescripcionReporte=secuencialusuarios;
		} catch(Exception ex) {
			;
		}
	}

	public  void  setmovimientoactivofijosDescripcionReporte(Object movimientoactivofijos) {
		try {
			this.movimientoactivofijosDescripcionReporte=movimientoactivofijos;
		} catch(Exception ex) {
			;
		}
	}

	public  void  setusuarioopcionsDescripcionReporte(Object usuarioopcions) {
		try {
			this.usuarioopcionsDescripcionReporte=usuarioopcions;
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

	public  void  setturnopunvensDescripcionReporte(Object turnopunvens) {
		try {
			this.turnopunvensDescripcionReporte=turnopunvens;
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

	public  void  setParametroGeneralUsuarioDescripcionReporte(Object parametrogeneralusuario) {
	try {
			this.ParametroGeneralUsuarioDescripcionReporte=parametrogeneralusuario;
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

	public  void  setcierrecajasDescripcionReporte(Object cierrecajas) {
		try {
			this.cierrecajasDescripcionReporte=cierrecajas;
		} catch(Exception ex) {
			;
		}
	}

	public  void  setdescuentomontosDescripcionReporte(Object descuentomontos) {
		try {
			this.descuentomontosDescripcionReporte=descuentomontos;
		} catch(Exception ex) {
			;
		}
	}

	public  void  setcajaegresosDescripcionReporte(Object cajaegresos) {
		try {
			this.cajaegresosDescripcionReporte=cajaegresos;
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

	public  void  setnotacreditopuntoventasDescripcionReporte(Object notacreditopuntoventas) {
		try {
			this.notacreditopuntoventasDescripcionReporte=notacreditopuntoventas;
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

	public  void  setpedidocomprasDescripcionReporte(Object pedidocompras) {
		try {
			this.pedidocomprasDescripcionReporte=pedidocompras;
		} catch(Exception ex) {
			;
		}
	}

	public  void  setperfilusuariosDescripcionReporte(Object perfilusuarios) {
		try {
			this.perfilusuariosDescripcionReporte=perfilusuarios;
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

	public  void  settransferenciasDescripcionReporte(Object transferencias) {
		try {
			this.transferenciasDescripcionReporte=transferencias;
		} catch(Exception ex) {
			;
		}
	}

	public  void  setDatoGeneralUsuarioDescripcionReporte(Object datogeneralusuario) {
	try {
			this.DatoGeneralUsuarioDescripcionReporte=datogeneralusuario;
		} catch(Exception ex) {
			;
		}
	}

	public  void  setcajaingresosDescripcionReporte(Object cajaingresos) {
		try {
			this.cajaingresosDescripcionReporte=cajaingresos;
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

	public  void  setconsignacionsDescripcionReporte(Object consignacions) {
		try {
			this.consignacionsDescripcionReporte=consignacions;
		} catch(Exception ex) {
			;
		}
	}

	public  void  setdetallemensajecorreoinvensDescripcionReporte(Object detallemensajecorreoinvens) {
		try {
			this.detallemensajecorreoinvensDescripcionReporte=detallemensajecorreoinvens;
		} catch(Exception ex) {
			;
		}
	}

	/*PARA REPORTES FIN*/		
}

