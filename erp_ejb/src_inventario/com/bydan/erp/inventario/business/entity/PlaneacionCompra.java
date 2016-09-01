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
package com.bydan.erp.inventario.business.entity;

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
//import com.bydan.erp.inventario.util.PlaneacionCompraConstantesFunciones;
import com.bydan.erp.inventario.util.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.contabilidad.util.*;
import com.bydan.erp.nomina.util.*;



import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.nomina.business.entity.*;




@SuppressWarnings("unused")
public class PlaneacionCompra extends PlaneacionCompraAdditional implements Serializable ,Cloneable {//PlaneacionCompraAdditional,GeneralEntity
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
	
	private PlaneacionCompra planeacioncompraOriginal;
	
	private Map<String, Object> mapPlaneacionCompra;
			
	public Map<String, Object> getMapPlaneacionCompra() {
		return mapPlaneacionCompra;
	}

	public void setMapPlaneacionCompra(Map<String, Object> mapPlaneacionCompra) {
		this.mapPlaneacionCompra = mapPlaneacionCompra;
	}
	
	public void inicializarMapPlaneacionCompra() {
		this.mapPlaneacionCompra = new HashMap<String,Object>();
	}
	
	public void setMapPlaneacionCompraValue(String sKey,Object oValue) {
		this.mapPlaneacionCompra.put(sKey, oValue);
	}
	
	public Object getMapPlaneacionCompraValue(String sKey) {
		return this.mapPlaneacionCompra.get(sKey);
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
	private Long id_ejercicio;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_periodo;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_empleado;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_usuario;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_formato;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=50,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=PlaneacionCompraConstantesFunciones.SREGEXNUMERO_PRE_IMPRESO,message=PlaneacionCompraConstantesFunciones.SMENSAJEREGEXNUMERO_PRE_IMPRESO)
	private String numero_pre_impreso;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Date fecha;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_mes_inicio;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_mes_fin;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=10,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONINT)
	private Integer numero_meses;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Date fecha_corte;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=50,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=PlaneacionCompraConstantesFunciones.SREGEXCODIGO_PEDIDO,message=PlaneacionCompraConstantesFunciones.SMENSAJEREGEXCODIGO_PEDIDO)
	private String codigo_pedido;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=250,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=PlaneacionCompraConstantesFunciones.SREGEXDESCRIPCION1,message=PlaneacionCompraConstantesFunciones.SMENSAJEREGEXDESCRIPCION1)
	private String descripcion1;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=250,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=PlaneacionCompraConstantesFunciones.SREGEXDESCRIPCION2,message=PlaneacionCompraConstantesFunciones.SMENSAJEREGEXDESCRIPCION2)
	private String descripcion2;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=250,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=PlaneacionCompraConstantesFunciones.SREGEXDESCRIPCION3,message=PlaneacionCompraConstantesFunciones.SMENSAJEREGEXDESCRIPCION3)
	private String descripcion3;
			
	
	public Empresa empresa;
	public Sucursal sucursal;
	public Ejercicio ejercicio;
	public Periodo periodo;
	public Empleado empleado;
	public Usuario usuario;
	public Formato formato;
	public Mes mesinicio;
	public Mes mesfin;
	
	
	private String empresa_descripcion;
	private String sucursal_descripcion;
	private String ejercicio_descripcion;
	private String periodo_descripcion;
	private String empleado_descripcion;
	private String usuario_descripcion;
	private String formato_descripcion;
	private String mesinicio_descripcion;
	private String mesfin_descripcion;
	
	
	public List<DetallePlaneacionCompra> detalleplaneacioncompras;
		
	public PlaneacionCompra () throws Exception {
		super();		
		
		this.id=0L;
		
		
		this.versionRow=new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());//new Date();
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		this.sType="NONE";
		
		this.planeacioncompraOriginal=this;
		
 		this.id_empresa=-1L;
 		this.id_sucursal=-1L;
 		this.id_ejercicio=-1L;
 		this.id_periodo=-1L;
 		this.id_empleado=-1L;
 		this.id_usuario=-1L;
 		this.id_formato=-1L;
 		this.numero_pre_impreso="";
 		this.fecha=new Date();
 		this.id_mes_inicio=-1L;
 		this.id_mes_fin=-1L;
 		this.numero_meses=0;
 		this.fecha_corte=new Date();
 		this.codigo_pedido="";
 		this.descripcion1="";
 		this.descripcion2="";
 		this.descripcion3="";
		
		
		this.empresa=null;
		this.sucursal=null;
		this.ejercicio=null;
		this.periodo=null;
		this.empleado=null;
		this.usuario=null;
		this.formato=null;
		this.mesinicio=null;
		this.mesfin=null;
		
		
		this.empresa_descripcion="";
		this.sucursal_descripcion="";
		this.ejercicio_descripcion="";
		this.periodo_descripcion="";
		this.empleado_descripcion="";
		this.usuario_descripcion="";
		this.formato_descripcion="";
		this.mesinicio_descripcion="";
		this.mesfin_descripcion="";
		
		
		this.detalleplaneacioncompras=null;
		
			
		
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
    //PARA REPORTES
	public PlaneacionCompra (Long id,Date versionRow,Long id_empresa,Long id_sucursal,Long id_ejercicio,Long id_periodo,Long id_empleado,Long id_usuario,Long id_formato,String numero_pre_impreso,Date fecha,Long id_mes_inicio,Long id_mes_fin,Integer numero_meses,Date fecha_corte,String codigo_pedido,String descripcion1,String descripcion2,String descripcion3) throws Exception {
		super();		
		
		this.id=id;
		this.versionRow=versionRow;
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.planeacioncompraOriginal=this;
		
 		this.id_empresa=id_empresa;
 		this.id_sucursal=id_sucursal;
 		this.id_ejercicio=id_ejercicio;
 		this.id_periodo=id_periodo;
 		this.id_empleado=id_empleado;
 		this.id_usuario=id_usuario;
 		this.id_formato=id_formato;
 		this.numero_pre_impreso=numero_pre_impreso;
 		this.fecha=fecha;
 		this.id_mes_inicio=id_mes_inicio;
 		this.id_mes_fin=id_mes_fin;
 		this.numero_meses=numero_meses;
 		this.fecha_corte=fecha_corte;
 		this.codigo_pedido=codigo_pedido;
 		this.descripcion1=descripcion1;
 		this.descripcion2=descripcion2;
 		this.descripcion3=descripcion3;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	 //PARA REPORTES
	public PlaneacionCompra (Long id_empresa,Long id_sucursal,Long id_ejercicio,Long id_periodo,Long id_empleado,Long id_usuario,Long id_formato,String numero_pre_impreso,Date fecha,Long id_mes_inicio,Long id_mes_fin,Integer numero_meses,Date fecha_corte,String codigo_pedido,String descripcion1,String descripcion2,String descripcion3) throws Exception {
		super();		
		
		this.id=0L;
		this.versionRow=new Date();
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.planeacioncompraOriginal=this;
		
 		this.id_empresa=id_empresa;
 		this.id_sucursal=id_sucursal;
 		this.id_ejercicio=id_ejercicio;
 		this.id_periodo=id_periodo;
 		this.id_empleado=id_empleado;
 		this.id_usuario=id_usuario;
 		this.id_formato=id_formato;
 		this.numero_pre_impreso=numero_pre_impreso;
 		this.fecha=fecha;
 		this.id_mes_inicio=id_mes_inicio;
 		this.id_mes_fin=id_mes_fin;
 		this.numero_meses=numero_meses;
 		this.fecha_corte=fecha_corte;
 		this.codigo_pedido=codigo_pedido;
 		this.descripcion1=descripcion1;
 		this.descripcion2=descripcion2;
 		this.descripcion3=descripcion3;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	public boolean equals(Object object) {
		boolean equal=false;
		PlaneacionCompra planeacioncompraLocal=null;
		
		if(object!=null) {
			planeacioncompraLocal=(PlaneacionCompra)object;
			
			if(planeacioncompraLocal!=null) {
				if(this.getId()!=null && planeacioncompraLocal.getId()!=null) {
					if(this.getId().equals(planeacioncompraLocal.getId())) {
						equal=true;
					}
				}
			}
		}
		
		return equal;
	}
	
	public String toString() {
		String sDetalle="";
		
		if(!PlaneacionCompraConstantesFunciones.CON_DESCRIPCION_DETALLADO) {
        	sDetalle=PlaneacionCompraConstantesFunciones.getPlaneacionCompraDescripcion(this);
		} else {
			sDetalle=PlaneacionCompraConstantesFunciones.getPlaneacionCompraDescripcionDetallado(this);
		}
		
		return sDetalle;
    }
	
	public PlaneacionCompra getPlaneacionCompraOriginal() {
		return this.planeacioncompraOriginal;
	}
	
	public void setPlaneacionCompraOriginal(PlaneacionCompra planeacioncompra) {
		try {
			this.planeacioncompraOriginal=planeacioncompra;
		} catch(Exception e) {
			;
		}
	}
	
	
	protected PlaneacionCompraAdditional planeacioncompraAdditional=null;
	
	public PlaneacionCompraAdditional getPlaneacionCompraAdditional() {
		return this.planeacioncompraAdditional;
	}
	
	public void setPlaneacionCompraAdditional(PlaneacionCompraAdditional planeacioncompraAdditional) {
		try {
			this.planeacioncompraAdditional=planeacioncompraAdditional;
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
    
	
	public Long getid_ejercicio() {
		return this.id_ejercicio;
	}
    
	
	public Long getid_periodo() {
		return this.id_periodo;
	}
    
	
	public Long getid_empleado() {
		return this.id_empleado;
	}
    
	
	public Long getid_usuario() {
		return this.id_usuario;
	}
    
	
	public Long getid_formato() {
		return this.id_formato;
	}
    
	
	public String getnumero_pre_impreso() {
		return this.numero_pre_impreso;
	}
    
	
	public Date getfecha() {
		return this.fecha;
	}
    
	
	public Long getid_mes_inicio() {
		return this.id_mes_inicio;
	}
    
	
	public Long getid_mes_fin() {
		return this.id_mes_fin;
	}
    
	
	public Integer getnumero_meses() {
		return this.numero_meses;
	}
    
	
	public Date getfecha_corte() {
		return this.fecha_corte;
	}
    
	
	public String getcodigo_pedido() {
		return this.codigo_pedido;
	}
    
	
	public String getdescripcion1() {
		return this.descripcion1;
	}
    
	
	public String getdescripcion2() {
		return this.descripcion2;
	}
    
	
	public String getdescripcion3() {
		return this.descripcion3;
	}
	
    
	public void setid_empresa(Long newid_empresa)throws Exception
	{
		try {
			if(this.id_empresa!=newid_empresa) {
				if(newid_empresa==null) {
					//newid_empresa=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("PlaneacionCompra:Valor nulo no permitido en columna id_empresa");
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
						System.out.println("PlaneacionCompra:Valor nulo no permitido en columna id_sucursal");
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
						System.out.println("PlaneacionCompra:Valor nulo no permitido en columna id_ejercicio");
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
						System.out.println("PlaneacionCompra:Valor nulo no permitido en columna id_periodo");
					}
				}

				this.id_periodo=newid_periodo;
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
						System.out.println("PlaneacionCompra:Valor nulo no permitido en columna id_empleado");
					}
				}

				this.id_empleado=newid_empleado;
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
						System.out.println("PlaneacionCompra:Valor nulo no permitido en columna id_usuario");
					}
				}

				this.id_usuario=newid_usuario;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_formato(Long newid_formato)throws Exception
	{
		try {
			if(this.id_formato!=newid_formato) {
				if(newid_formato==null) {
					//newid_formato=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("PlaneacionCompra:Valor nulo no permitido en columna id_formato");
					}
				}

				this.id_formato=newid_formato;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setnumero_pre_impreso(String newnumero_pre_impreso)throws Exception
	{
		try {
			if(this.numero_pre_impreso!=newnumero_pre_impreso) {
				if(newnumero_pre_impreso==null) {
					//newnumero_pre_impreso="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("PlaneacionCompra:Valor nulo no permitido en columna numero_pre_impreso");
					}
				}

				if(newnumero_pre_impreso!=null&&newnumero_pre_impreso.length()>50) {
					newnumero_pre_impreso=newnumero_pre_impreso.substring(0,48);
					System.out.println("PlaneacionCompra:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=50 en columna numero_pre_impreso");
				}

				this.numero_pre_impreso=newnumero_pre_impreso;
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
						System.out.println("PlaneacionCompra:Valor nulo no permitido en columna fecha");
					}
				}

				this.fecha=newfecha;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_mes_inicio(Long newid_mes_inicio)throws Exception
	{
		try {
			if(this.id_mes_inicio!=newid_mes_inicio) {
				if(newid_mes_inicio==null) {
					//newid_mes_inicio=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("PlaneacionCompra:Valor nulo no permitido en columna id_mes_inicio");
					}
				}

				this.id_mes_inicio=newid_mes_inicio;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_mes_fin(Long newid_mes_fin)throws Exception
	{
		try {
			if(this.id_mes_fin!=newid_mes_fin) {
				if(newid_mes_fin==null) {
					//newid_mes_fin=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("PlaneacionCompra:Valor nulo no permitido en columna id_mes_fin");
					}
				}

				this.id_mes_fin=newid_mes_fin;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setnumero_meses(Integer newnumero_meses)throws Exception
	{
		try {
			if(this.numero_meses!=newnumero_meses) {
				if(newnumero_meses==null) {
					//newnumero_meses=0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("PlaneacionCompra:Valor nulo no permitido en columna numero_meses");
					}
				}

				this.numero_meses=newnumero_meses;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setfecha_corte(Date newfecha_corte)throws Exception
	{
		try {
			if(this.fecha_corte!=newfecha_corte) {
				if(newfecha_corte==null) {
					//newfecha_corte=new Date();
					if(Constantes.ISDEVELOPING) {
						System.out.println("PlaneacionCompra:Valor nulo no permitido en columna fecha_corte");
					}
				}

				this.fecha_corte=newfecha_corte;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setcodigo_pedido(String newcodigo_pedido)throws Exception
	{
		try {
			if(this.codigo_pedido!=newcodigo_pedido) {
				if(newcodigo_pedido==null) {
					//newcodigo_pedido="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("PlaneacionCompra:Valor nulo no permitido en columna codigo_pedido");
					}
				}

				if(newcodigo_pedido!=null&&newcodigo_pedido.length()>50) {
					newcodigo_pedido=newcodigo_pedido.substring(0,48);
					System.out.println("PlaneacionCompra:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=50 en columna codigo_pedido");
				}

				this.codigo_pedido=newcodigo_pedido;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setdescripcion1(String newdescripcion1)throws Exception
	{
		try {
			if(this.descripcion1!=newdescripcion1) {
				if(newdescripcion1==null) {
					//newdescripcion1="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("PlaneacionCompra:Valor nulo no permitido en columna descripcion1");
					}
				}

				if(newdescripcion1!=null&&newdescripcion1.length()>250) {
					newdescripcion1=newdescripcion1.substring(0,248);
					System.out.println("PlaneacionCompra:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=250 en columna descripcion1");
				}

				this.descripcion1=newdescripcion1;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setdescripcion2(String newdescripcion2)throws Exception
	{
		try {
			if(this.descripcion2!=newdescripcion2) {
				if(newdescripcion2==null) {
					//newdescripcion2="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("PlaneacionCompra:Valor nulo no permitido en columna descripcion2");
					}
				}

				if(newdescripcion2!=null&&newdescripcion2.length()>250) {
					newdescripcion2=newdescripcion2.substring(0,248);
					System.out.println("PlaneacionCompra:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=250 en columna descripcion2");
				}

				this.descripcion2=newdescripcion2;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setdescripcion3(String newdescripcion3)throws Exception
	{
		try {
			if(this.descripcion3!=newdescripcion3) {
				if(newdescripcion3==null) {
					//newdescripcion3="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("PlaneacionCompra:Valor nulo no permitido en columna descripcion3");
					}
				}

				if(newdescripcion3!=null&&newdescripcion3.length()>250) {
					newdescripcion3=newdescripcion3.substring(0,248);
					System.out.println("PlaneacionCompra:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=250 en columna descripcion3");
				}

				this.descripcion3=newdescripcion3;
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

	public Ejercicio getEjercicio() {
		return this.ejercicio;
	}

	public Periodo getPeriodo() {
		return this.periodo;
	}

	public Empleado getEmpleado() {
		return this.empleado;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public Formato getFormato() {
		return this.formato;
	}

	public Mes getMesInicio() {
		return this.mesinicio;
	}

	public Mes getMesFin() {
		return this.mesfin;
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

	public String getempleado_descripcion() {
		return this.empleado_descripcion;
	}

	public String getusuario_descripcion() {
		return this.usuario_descripcion;
	}

	public String getformato_descripcion() {
		return this.formato_descripcion;
	}

	public String getmesinicio_descripcion() {
		return this.mesinicio_descripcion;
	}

	public String getmesfin_descripcion() {
		return this.mesfin_descripcion;
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


	public  void  setEmpleado(Empleado empleado) {
		try {
			this.empleado=empleado;
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


	public  void  setFormato(Formato formato) {
		try {
			this.formato=formato;
		} catch(Exception e) {
			;
		}
	}


	public  void  setMesInicio(Mes mesinicio) {
		try {
			this.mesinicio=mesinicio;
		} catch(Exception e) {
			;
		}
	}


	public  void  setMesFin(Mes mesfin) {
		try {
			this.mesfin=mesfin;
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


	public  void  setempleado_descripcion(String empleado_descripcion) {
		try {
			this.empleado_descripcion=empleado_descripcion;
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


	public  void  setformato_descripcion(String formato_descripcion) {
		try {
			this.formato_descripcion=formato_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  setmesinicio_descripcion(String mesinicio_descripcion) {
		try {
			this.mesinicio_descripcion=mesinicio_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  setmesfin_descripcion(String mesfin_descripcion) {
		try {
			this.mesfin_descripcion=mesfin_descripcion;
		} catch(Exception e) {
			;
		}
	}


	
	
	public List<DetallePlaneacionCompra> getDetallePlaneacionCompras() {
		return this.detalleplaneacioncompras;
	}

	
	
	public  void  setDetallePlaneacionCompras(List<DetallePlaneacionCompra> detalleplaneacioncompras) {
		try {
			this.detalleplaneacioncompras=detalleplaneacioncompras;
		} catch(Exception e) {
			;
		}
	}

	
	/*PARA REPORTES*/
	String id_empresa_descripcion="";String id_sucursal_descripcion="";String id_ejercicio_descripcion="";String id_periodo_descripcion="";String id_empleado_descripcion="";String id_usuario_descripcion="";String id_formato_descripcion="";String id_mes_inicio_descripcion="";String id_mes_fin_descripcion="";
	
	
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
	public String getid_empleado_descripcion() {
		return id_empleado_descripcion;
	}
	public String getid_usuario_descripcion() {
		return id_usuario_descripcion;
	}
	public String getid_formato_descripcion() {
		return id_formato_descripcion;
	}
	public String getid_mes_inicio_descripcion() {
		return id_mes_inicio_descripcion;
	}
	public String getid_mes_fin_descripcion() {
		return id_mes_fin_descripcion;
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
	public void setid_empleado_descripcion(String newid_empleado_descripcion)throws Exception {
		try {
			this.id_empleado_descripcion=newid_empleado_descripcion;
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
	public void setid_formato_descripcion(String newid_formato_descripcion)throws Exception {
		try {
			this.id_formato_descripcion=newid_formato_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_mes_inicio_descripcion(String newid_mes_inicio_descripcion)throws Exception {
		try {
			this.id_mes_inicio_descripcion=newid_mes_inicio_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_mes_fin_descripcion(String newid_mes_fin_descripcion)throws Exception {
		try {
			this.id_mes_fin_descripcion=newid_mes_fin_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	
	public void inicializarVariablesParaReporte() {
		this.id_empresa_descripcion="";this.id_sucursal_descripcion="";this.id_ejercicio_descripcion="";this.id_periodo_descripcion="";this.id_empleado_descripcion="";this.id_usuario_descripcion="";this.id_formato_descripcion="";this.id_mes_inicio_descripcion="";this.id_mes_fin_descripcion="";
	}
	
	
	Object detalleplaneacioncomprasDescripcionReporte;
	
	
	public Object getdetalleplaneacioncomprasDescripcionReporte() {
		return detalleplaneacioncomprasDescripcionReporte;
	}

	
	
	public  void  setdetalleplaneacioncomprasDescripcionReporte(Object detalleplaneacioncompras) {
		try {
			this.detalleplaneacioncomprasDescripcionReporte=detalleplaneacioncompras;
		} catch(Exception ex) {
			;
		}
	}

	/*PARA REPORTES FIN*/		
}

