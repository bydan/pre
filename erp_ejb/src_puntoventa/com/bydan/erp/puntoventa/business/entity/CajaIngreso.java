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
//import com.bydan.erp.puntoventa.util.CajaIngresoConstantesFunciones;
import com.bydan.erp.puntoventa.util.*;


import com.bydan.erp.seguridad.util.*;



import com.bydan.erp.seguridad.business.entity.*;




@SuppressWarnings("unused")
public class CajaIngreso extends CajaIngresoAdditional implements Serializable ,Cloneable {//CajaIngresoAdditional,GeneralEntity
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
	
	private CajaIngreso cajaingresoOriginal;
	
	private Map<String, Object> mapCajaIngreso;
			
	public Map<String, Object> getMapCajaIngreso() {
		return mapCajaIngreso;
	}

	public void setMapCajaIngreso(Map<String, Object> mapCajaIngreso) {
		this.mapCajaIngreso = mapCajaIngreso;
	}
	
	public void inicializarMapCajaIngreso() {
		this.mapCajaIngreso = new HashMap<String,Object>();
	}
	
	public void setMapCajaIngresoValue(String sKey,Object oValue) {
		this.mapCajaIngreso.put(sKey, oValue);
	}
	
	public Object getMapCajaIngresoValue(String sKey) {
		return this.mapCajaIngreso.get(sKey);
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
	private Long id_caja;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_turno_pun_ven;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=50,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=CajaIngresoConstantesFunciones.SREGEXSECUENCIAL,message=CajaIngresoConstantesFunciones.SMENSAJEREGEXSECUENCIAL)
	private String secuencial;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Date fecha;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Time hora;
			
	
	public Empresa empresa;
	public Sucursal sucursal;
	public Usuario usuario;
	public Caja caja;
	public TurnoPunVen turnopunven;
	
	
	private String empresa_descripcion;
	private String sucursal_descripcion;
	private String usuario_descripcion;
	private String caja_descripcion;
	private String turnopunven_descripcion;
	
	
	public List<CajaIngresoDetalle> cajaingresodetalles;
		
	public CajaIngreso () throws Exception {
		super();		
		
		this.id=0L;
		
		
		this.versionRow=new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());//new Date();
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		this.sType="NONE";
		
		this.cajaingresoOriginal=this;
		
 		this.id_empresa=-1L;
 		this.id_sucursal=-1L;
 		this.id_usuario=-1L;
 		this.id_caja=-1L;
 		this.id_turno_pun_ven=-1L;
 		this.secuencial="";
 		this.fecha=new Date();
 		this.hora=new Time((new Date()).getTime());
		
		
		this.empresa=null;
		this.sucursal=null;
		this.usuario=null;
		this.caja=null;
		this.turnopunven=null;
		
		
		this.empresa_descripcion="";
		this.sucursal_descripcion="";
		this.usuario_descripcion="";
		this.caja_descripcion="";
		this.turnopunven_descripcion="";
		
		
		this.cajaingresodetalles=null;
		
			
		
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
    //PARA REPORTES
	public CajaIngreso (Long id,Date versionRow,Long id_empresa,Long id_sucursal,Long id_usuario,Long id_caja,Long id_turno_pun_ven,String secuencial,Date fecha,Time hora) throws Exception {
		super();		
		
		this.id=id;
		this.versionRow=versionRow;
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.cajaingresoOriginal=this;
		
 		this.id_empresa=id_empresa;
 		this.id_sucursal=id_sucursal;
 		this.id_usuario=id_usuario;
 		this.id_caja=id_caja;
 		this.id_turno_pun_ven=id_turno_pun_ven;
 		this.secuencial=secuencial;
 		this.fecha=fecha;
 		this.hora=hora;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	 //PARA REPORTES
	public CajaIngreso (Long id_empresa,Long id_sucursal,Long id_usuario,Long id_caja,Long id_turno_pun_ven,String secuencial,Date fecha,Time hora) throws Exception {
		super();		
		
		this.id=0L;
		this.versionRow=new Date();
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.cajaingresoOriginal=this;
		
 		this.id_empresa=id_empresa;
 		this.id_sucursal=id_sucursal;
 		this.id_usuario=id_usuario;
 		this.id_caja=id_caja;
 		this.id_turno_pun_ven=id_turno_pun_ven;
 		this.secuencial=secuencial;
 		this.fecha=fecha;
 		this.hora=hora;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	public boolean equals(Object object) {
		boolean equal=false;
		CajaIngreso cajaingresoLocal=null;
		
		if(object!=null) {
			cajaingresoLocal=(CajaIngreso)object;
			
			if(cajaingresoLocal!=null) {
				if(this.getId()!=null && cajaingresoLocal.getId()!=null) {
					if(this.getId().equals(cajaingresoLocal.getId())) {
						equal=true;
					}
				}
			}
		}
		
		return equal;
	}
	
	public String toString() {
		String sDetalle="";
		
		if(!CajaIngresoConstantesFunciones.CON_DESCRIPCION_DETALLADO) {
        	sDetalle=CajaIngresoConstantesFunciones.getCajaIngresoDescripcion(this);
		} else {
			sDetalle=CajaIngresoConstantesFunciones.getCajaIngresoDescripcionDetallado(this);
		}
		
		return sDetalle;
    }
	
	public CajaIngreso getCajaIngresoOriginal() {
		return this.cajaingresoOriginal;
	}
	
	public void setCajaIngresoOriginal(CajaIngreso cajaingreso) {
		try {
			this.cajaingresoOriginal=cajaingreso;
		} catch(Exception e) {
			;
		}
	}
	
	
	protected CajaIngresoAdditional cajaingresoAdditional=null;
	
	public CajaIngresoAdditional getCajaIngresoAdditional() {
		return this.cajaingresoAdditional;
	}
	
	public void setCajaIngresoAdditional(CajaIngresoAdditional cajaingresoAdditional) {
		try {
			this.cajaingresoAdditional=cajaingresoAdditional;
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
    
	
	public Long getid_caja() {
		return this.id_caja;
	}
    
	
	public Long getid_turno_pun_ven() {
		return this.id_turno_pun_ven;
	}
    
	
	public String getsecuencial() {
		return this.secuencial;
	}
    
	
	public Date getfecha() {
		return this.fecha;
	}
    
	
	public Time gethora() {
		return this.hora;
	}
	
    
	public void setid_empresa(Long newid_empresa)throws Exception
	{
		try {
			if(this.id_empresa!=newid_empresa) {
				if(newid_empresa==null) {
					//newid_empresa=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("CajaIngreso:Valor nulo no permitido en columna id_empresa");
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
						System.out.println("CajaIngreso:Valor nulo no permitido en columna id_sucursal");
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
						System.out.println("CajaIngreso:Valor nulo no permitido en columna id_usuario");
					}
				}

				this.id_usuario=newid_usuario;
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
						System.out.println("CajaIngreso:Valor nulo no permitido en columna id_caja");
					}
				}

				this.id_caja=newid_caja;
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
						System.out.println("CajaIngreso:Valor nulo no permitido en columna id_turno_pun_ven");
					}
				}

				this.id_turno_pun_ven=newid_turno_pun_ven;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setsecuencial(String newsecuencial)throws Exception
	{
		try {
			if(this.secuencial!=newsecuencial) {
				if(newsecuencial==null) {
					//newsecuencial="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("CajaIngreso:Valor nulo no permitido en columna secuencial");
					}
				}

				if(newsecuencial!=null&&newsecuencial.length()>50) {
					newsecuencial=newsecuencial.substring(0,48);
					System.out.println("CajaIngreso:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=50 en columna secuencial");
				}

				this.secuencial=newsecuencial;
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
						System.out.println("CajaIngreso:Valor nulo no permitido en columna fecha");
					}
				}

				this.fecha=newfecha;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void sethora(Time newhora)throws Exception
	{
		try {
			if(this.hora!=newhora) {
				if(newhora==null) {
					//newhora=new Time((new Date()).getTime());
					if(Constantes.ISDEVELOPING) {
						System.out.println("CajaIngreso:Valor nulo no permitido en columna hora");
					}
				}

				this.hora=newhora;
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

	public Caja getCaja() {
		return this.caja;
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

	public String getcaja_descripcion() {
		return this.caja_descripcion;
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


	public  void  setCaja(Caja caja) {
		try {
			this.caja=caja;
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


	public  void  setcaja_descripcion(String caja_descripcion) {
		try {
			this.caja_descripcion=caja_descripcion;
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


	
	
	public List<CajaIngresoDetalle> getCajaIngresoDetalles() {
		return this.cajaingresodetalles;
	}

	
	
	public  void  setCajaIngresoDetalles(List<CajaIngresoDetalle> cajaingresodetalles) {
		try {
			this.cajaingresodetalles=cajaingresodetalles;
		} catch(Exception e) {
			;
		}
	}

	
	/*PARA REPORTES*/
	String id_empresa_descripcion="";String id_sucursal_descripcion="";String id_usuario_descripcion="";String id_caja_descripcion="";String id_turno_pun_ven_descripcion="";
	
	
	public String getid_empresa_descripcion() {
		return id_empresa_descripcion;
	}
	public String getid_sucursal_descripcion() {
		return id_sucursal_descripcion;
	}
	public String getid_usuario_descripcion() {
		return id_usuario_descripcion;
	}
	public String getid_caja_descripcion() {
		return id_caja_descripcion;
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
	public void setid_caja_descripcion(String newid_caja_descripcion)throws Exception {
		try {
			this.id_caja_descripcion=newid_caja_descripcion;
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
		this.id_empresa_descripcion="";this.id_sucursal_descripcion="";this.id_usuario_descripcion="";this.id_caja_descripcion="";this.id_turno_pun_ven_descripcion="";
	}
	
	
	Object cajaingresodetallesDescripcionReporte;
	
	
	public Object getcajaingresodetallesDescripcionReporte() {
		return cajaingresodetallesDescripcionReporte;
	}

	
	
	public  void  setcajaingresodetallesDescripcionReporte(Object cajaingresodetalles) {
		try {
			this.cajaingresodetallesDescripcionReporte=cajaingresodetalles;
		} catch(Exception ex) {
			;
		}
	}

	/*PARA REPORTES FIN*/		
}

