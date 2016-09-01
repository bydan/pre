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
package com.bydan.erp.puntoventa.business.entity;

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
//import com.bydan.erp.puntoventa.util.CajeroTurnoConstantesFunciones;
import com.bydan.erp.puntoventa.util.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.comisiones.util.*;



import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.comisiones.business.entity.*;




@SuppressWarnings("unused")
public class CajeroTurno extends CajeroTurnoAdditional implements Serializable ,Cloneable {//CajeroTurnoAdditional,GeneralEntity
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
	
	private CajeroTurno cajeroturnoOriginal;
	
	private Map<String, Object> mapCajeroTurno;
			
	public Map<String, Object> getMapCajeroTurno() {
		return mapCajeroTurno;
	}

	public void setMapCajeroTurno(Map<String, Object> mapCajeroTurno) {
		this.mapCajeroTurno = mapCajeroTurno;
	}
	
	public void inicializarMapCajeroTurno() {
		this.mapCajeroTurno = new HashMap<String,Object>();
	}
	
	public void setMapCajeroTurnoValue(String sKey,Object oValue) {
		this.mapCajeroTurno.put(sKey, oValue);
	}
	
	public Object getMapCajeroTurnoValue(String sKey) {
		return this.mapCajeroTurno.get(sKey);
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
	private Long id_usuario;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_vendedor;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_caja;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_mesa;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_turno_pun_ven;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Time hora_inicio;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Time hora_fin;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Time hora_servicio;
			
	
	public Empresa empresa;
	public Sucursal sucursal;
	public Usuario usuario;
	public Vendedor vendedor;
	public Caja caja;
	public Mesa mesa;
	public TurnoPunVen turnopunven;
	
	
	private String empresa_descripcion;
	private String sucursal_descripcion;
	private String usuario_descripcion;
	private String vendedor_descripcion;
	private String caja_descripcion;
	private String mesa_descripcion;
	private String turnopunven_descripcion;
	
	
		
	public CajeroTurno () throws Exception {
		super();		
		
		this.id=0L;
		
		
		this.versionRow=new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());//new Date();
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		this.sType="NONE";
		
		this.cajeroturnoOriginal=this;
		
 		this.id_empresa=-1L;
 		this.id_sucursal=-1L;
 		this.id_usuario=-1L;
 		this.id_vendedor=-1L;
 		this.id_caja=-1L;
 		this.id_mesa=-1L;
 		this.id_turno_pun_ven=-1L;
 		this.hora_inicio=new Time((new Date()).getTime());
 		this.hora_fin=new Time((new Date()).getTime());
 		this.hora_servicio=new Time((new Date()).getTime());
		
		
		this.empresa=null;
		this.sucursal=null;
		this.usuario=null;
		this.vendedor=null;
		this.caja=null;
		this.mesa=null;
		this.turnopunven=null;
		
		
		this.empresa_descripcion="";
		this.sucursal_descripcion="";
		this.usuario_descripcion="";
		this.vendedor_descripcion="";
		this.caja_descripcion="";
		this.mesa_descripcion="";
		this.turnopunven_descripcion="";
		
		
		
			
		
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
    //PARA REPORTES
	public CajeroTurno (Long id,Date versionRow,Long id_empresa,Long id_sucursal,Long id_usuario,Long id_vendedor,Long id_caja,Long id_mesa,Long id_turno_pun_ven,Time hora_inicio,Time hora_fin,Time hora_servicio) throws Exception {
		super();		
		
		this.id=id;
		this.versionRow=versionRow;
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.cajeroturnoOriginal=this;
		
 		this.id_empresa=id_empresa;
 		this.id_sucursal=id_sucursal;
 		this.id_usuario=id_usuario;
 		this.id_vendedor=id_vendedor;
 		this.id_caja=id_caja;
 		this.id_mesa=id_mesa;
 		this.id_turno_pun_ven=id_turno_pun_ven;
 		this.hora_inicio=hora_inicio;
 		this.hora_fin=hora_fin;
 		this.hora_servicio=hora_servicio;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	 //PARA REPORTES
	public CajeroTurno (Long id_empresa,Long id_sucursal,Long id_usuario,Long id_vendedor,Long id_caja,Long id_mesa,Long id_turno_pun_ven,Time hora_inicio,Time hora_fin,Time hora_servicio) throws Exception {
		super();		
		
		this.id=0L;
		this.versionRow=new Date();
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.cajeroturnoOriginal=this;
		
 		this.id_empresa=id_empresa;
 		this.id_sucursal=id_sucursal;
 		this.id_usuario=id_usuario;
 		this.id_vendedor=id_vendedor;
 		this.id_caja=id_caja;
 		this.id_mesa=id_mesa;
 		this.id_turno_pun_ven=id_turno_pun_ven;
 		this.hora_inicio=hora_inicio;
 		this.hora_fin=hora_fin;
 		this.hora_servicio=hora_servicio;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	public boolean equals(Object object) {
		boolean equal=false;
		CajeroTurno cajeroturnoLocal=null;
		
		if(object!=null) {
			cajeroturnoLocal=(CajeroTurno)object;
			
			if(cajeroturnoLocal!=null) {
				if(this.getId()!=null && cajeroturnoLocal.getId()!=null) {
					if(this.getId().equals(cajeroturnoLocal.getId())) {
						equal=true;
					}
				}
			}
		}
		
		return equal;
	}
	
	public String toString() {
		String sDetalle="";
		
		if(!CajeroTurnoConstantesFunciones.CON_DESCRIPCION_DETALLADO) {
        	sDetalle=CajeroTurnoConstantesFunciones.getCajeroTurnoDescripcion(this);
		} else {
			sDetalle=CajeroTurnoConstantesFunciones.getCajeroTurnoDescripcionDetallado(this);
		}
		
		return sDetalle;
    }
	
	public CajeroTurno getCajeroTurnoOriginal() {
		return this.cajeroturnoOriginal;
	}
	
	public void setCajeroTurnoOriginal(CajeroTurno cajeroturno) {
		try {
			this.cajeroturnoOriginal=cajeroturno;
		} catch(Exception e) {
			;
		}
	}
	
	
	protected CajeroTurnoAdditional cajeroturnoAdditional=null;
	
	public CajeroTurnoAdditional getCajeroTurnoAdditional() {
		return this.cajeroturnoAdditional;
	}
	
	public void setCajeroTurnoAdditional(CajeroTurnoAdditional cajeroturnoAdditional) {
		try {
			this.cajeroturnoAdditional=cajeroturnoAdditional;
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
    
	
	public Long getid_usuario() {
		return this.id_usuario;
	}
    
	
	public Long getid_vendedor() {
		return this.id_vendedor;
	}
    
	
	public Long getid_caja() {
		return this.id_caja;
	}
    
	
	public Long getid_mesa() {
		return this.id_mesa;
	}
    
	
	public Long getid_turno_pun_ven() {
		return this.id_turno_pun_ven;
	}
    
	
	public Time gethora_inicio() {
		return this.hora_inicio;
	}
    
	
	public Time gethora_fin() {
		return this.hora_fin;
	}
    
	
	public Time gethora_servicio() {
		return this.hora_servicio;
	}
	
    
	public void setid_empresa(Long newid_empresa)throws Exception
	{
		try {
			if(this.id_empresa!=newid_empresa) {
				if(newid_empresa==null) {
					//newid_empresa=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("CajeroTurno:Valor nulo no permitido en columna id_empresa");
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
						System.out.println("CajeroTurno:Valor nulo no permitido en columna id_sucursal");
					}
				}

				this.id_sucursal=newid_sucursal;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_usuario(Long newid_usuario)throws Exception
	{
		try {
			if(this.id_usuario!=newid_usuario) {
				if(newid_usuario==null) {
					//newid_usuario=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("CajeroTurno:Valor nulo no permitido en columna id_usuario");
					}
				}

				this.id_usuario=newid_usuario;
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
						System.out.println("CajeroTurno:Valor nulo no permitido en columna id_vendedor");
					}
				}

				this.id_vendedor=newid_vendedor;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_caja(Long newid_caja)throws Exception
	{
		try {
			if(this.id_caja!=newid_caja) {
				if(newid_caja==null) {
					//newid_caja=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("CajeroTurno:Valor nulo no permitido en columna id_caja");
					}
				}

				this.id_caja=newid_caja;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_mesa(Long newid_mesa)throws Exception
	{
		try {
			if(this.id_mesa!=newid_mesa) {
				if(newid_mesa==null) {
					//newid_mesa=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("CajeroTurno:Valor nulo no permitido en columna id_mesa");
					}
				}

				this.id_mesa=newid_mesa;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_turno_pun_ven(Long newid_turno_pun_ven)throws Exception
	{
		try {
			if(this.id_turno_pun_ven!=newid_turno_pun_ven) {
				if(newid_turno_pun_ven==null) {
					//newid_turno_pun_ven=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("CajeroTurno:Valor nulo no permitido en columna id_turno_pun_ven");
					}
				}

				this.id_turno_pun_ven=newid_turno_pun_ven;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void sethora_inicio(Time newhora_inicio)throws Exception
	{
		try {
			if(this.hora_inicio!=newhora_inicio) {
				if(newhora_inicio==null) {
					//newhora_inicio=new Time((new Date()).getTime());
					if(Constantes.ISDEVELOPING) {
						System.out.println("CajeroTurno:Valor nulo no permitido en columna hora_inicio");
					}
				}

				this.hora_inicio=newhora_inicio;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void sethora_fin(Time newhora_fin)throws Exception
	{
		try {
			if(this.hora_fin!=newhora_fin) {
				if(newhora_fin==null) {
					//newhora_fin=new Time((new Date()).getTime());
					if(Constantes.ISDEVELOPING) {
						System.out.println("CajeroTurno:Valor nulo no permitido en columna hora_fin");
					}
				}

				this.hora_fin=newhora_fin;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void sethora_servicio(Time newhora_servicio)throws Exception
	{
		try {
			if(this.hora_servicio!=newhora_servicio) {
				if(newhora_servicio==null) {
					//newhora_servicio=new Time((new Date()).getTime());
					if(Constantes.ISDEVELOPING) {
						System.out.println("CajeroTurno:Valor nulo no permitido en columna hora_servicio");
					}
				}

				this.hora_servicio=newhora_servicio;
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

	public Usuario getUsuario() {
		return this.usuario;
	}

	public Vendedor getVendedor() {
		return this.vendedor;
	}

	public Caja getCaja() {
		return this.caja;
	}

	public Mesa getMesa() {
		return this.mesa;
	}

	public TurnoPunVen getTurnoPunVen() {
		return this.turnopunven;
	}

	
	
	public String getempresa_descripcion() {
		return this.empresa_descripcion;
	}

	public String getsucursal_descripcion() {
		return this.sucursal_descripcion;
	}

	public String getusuario_descripcion() {
		return this.usuario_descripcion;
	}

	public String getvendedor_descripcion() {
		return this.vendedor_descripcion;
	}

	public String getcaja_descripcion() {
		return this.caja_descripcion;
	}

	public String getmesa_descripcion() {
		return this.mesa_descripcion;
	}

	public String getturnopunven_descripcion() {
		return this.turnopunven_descripcion;
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


	public  void  setUsuario(Usuario usuario) {
		try {
			this.usuario=usuario;
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


	public  void  setCaja(Caja caja) {
		try {
			this.caja=caja;
		} catch(Exception e) {
			;
		}
	}


	public  void  setMesa(Mesa mesa) {
		try {
			this.mesa=mesa;
		} catch(Exception e) {
			;
		}
	}


	public  void  setTurnoPunVen(TurnoPunVen turnopunven) {
		try {
			this.turnopunven=turnopunven;
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


	public  void  setusuario_descripcion(String usuario_descripcion) {
		try {
			this.usuario_descripcion=usuario_descripcion;
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


	public  void  setcaja_descripcion(String caja_descripcion) {
		try {
			this.caja_descripcion=caja_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  setmesa_descripcion(String mesa_descripcion) {
		try {
			this.mesa_descripcion=mesa_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  setturnopunven_descripcion(String turnopunven_descripcion) {
		try {
			this.turnopunven_descripcion=turnopunven_descripcion;
		} catch(Exception e) {
			;
		}
	}


	
	
	
	
	
	/*PARA REPORTES*/
	String id_empresa_descripcion="";String id_sucursal_descripcion="";String id_usuario_descripcion="";String id_vendedor_descripcion="";String id_caja_descripcion="";String id_mesa_descripcion="";String id_turno_pun_ven_descripcion="";
	
	
	public String getid_empresa_descripcion() {
		return id_empresa_descripcion;
	}
	public String getid_sucursal_descripcion() {
		return id_sucursal_descripcion;
	}
	public String getid_usuario_descripcion() {
		return id_usuario_descripcion;
	}
	public String getid_vendedor_descripcion() {
		return id_vendedor_descripcion;
	}
	public String getid_caja_descripcion() {
		return id_caja_descripcion;
	}
	public String getid_mesa_descripcion() {
		return id_mesa_descripcion;
	}
	public String getid_turno_pun_ven_descripcion() {
		return id_turno_pun_ven_descripcion;
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
	public void setid_usuario_descripcion(String newid_usuario_descripcion)throws Exception {
		try {
			this.id_usuario_descripcion=newid_usuario_descripcion;
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
	public void setid_caja_descripcion(String newid_caja_descripcion)throws Exception {
		try {
			this.id_caja_descripcion=newid_caja_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_mesa_descripcion(String newid_mesa_descripcion)throws Exception {
		try {
			this.id_mesa_descripcion=newid_mesa_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_turno_pun_ven_descripcion(String newid_turno_pun_ven_descripcion)throws Exception {
		try {
			this.id_turno_pun_ven_descripcion=newid_turno_pun_ven_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	
	public void inicializarVariablesParaReporte() {
		this.id_empresa_descripcion="";this.id_sucursal_descripcion="";this.id_usuario_descripcion="";this.id_vendedor_descripcion="";this.id_caja_descripcion="";this.id_mesa_descripcion="";this.id_turno_pun_ven_descripcion="";
	}
	
	
	
	
	
	
	/*PARA REPORTES FIN*/		
}

