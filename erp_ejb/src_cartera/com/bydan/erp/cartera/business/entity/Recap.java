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



import org.hibernate.validator.*;

import com.bydan.framework.erp.business.entity.*;
import com.bydan.framework.erp.business.entity.DatoGeneral;
import com.bydan.framework.erp.business.dataaccess.ConstantesSql;
//import com.bydan.framework.erp.business.entity.Mensajes;
import com.bydan.framework.erp.util.Constantes;
import com.bydan.framework.erp.util.ConstantesValidacion;
//import com.bydan.erp.cartera.util.RecapConstantesFunciones;
import com.bydan.erp.cartera.util.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.contabilidad.util.*;



import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;




@SuppressWarnings("unused")
public class Recap extends RecapAdditional implements Serializable ,Cloneable {//RecapAdditional,GeneralEntity
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
	
	private Recap recapOriginal;
	
	private Map<String, Object> mapRecap;
			
	public Map<String, Object> getMapRecap() {
		return mapRecap;
	}

	public void setMapRecap(Map<String, Object> mapRecap) {
		this.mapRecap = mapRecap;
	}
	
	public void inicializarMapRecap() {
		this.mapRecap = new HashMap<String,Object>();
	}
	
	public void setMapRecapValue(String sKey,Object oValue) {
		this.mapRecap.put(sKey, oValue);
	}
	
	public Object getMapRecapValue(String sKey) {
		return this.mapRecap.get(sKey);
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
	@Length(min=0,max=50,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=RecapConstantesFunciones.SREGEXNUMERO,message=RecapConstantesFunciones.SMENSAJEREGEXNUMERO)
	private String numero;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=50,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=RecapConstantesFunciones.SREGEXNUMERO_AUTORIZACION,message=RecapConstantesFunciones.SMENSAJEREGEXNUMERO_AUTORIZACION)
	private String numero_autorizacion;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Date fecha_inicio;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Date fecha_final;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Date fecha_elaboracion;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Date fecha_caducidad;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double monto_iva;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double sin_monto_iva;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double iva;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double otro_impuesto;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double valor_propuesto;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double subtotal;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double financiero;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double total;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double valor_cambio;
			
	
	public Empresa empresa;
	public Sucursal sucursal;
	public Ejercicio ejercicio;
	
	
	private String empresa_descripcion;
	private String sucursal_descripcion;
	private String ejercicio_descripcion;
	
	
	public List<DetalleRecap> detallerecaps;
		
	public Recap () throws Exception {
		super();		
		
		this.id=0L;
		
		
		this.versionRow=new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());//new Date();
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		this.sType="NONE";
		
		this.recapOriginal=this;
		
 		this.id_empresa=-1L;
 		this.id_sucursal=-1L;
 		this.id_ejercicio=-1L;
 		this.numero="";
 		this.numero_autorizacion="";
 		this.fecha_inicio=new Date();
 		this.fecha_final=new Date();
 		this.fecha_elaboracion=new Date();
 		this.fecha_caducidad=new Date();
 		this.monto_iva=0.0;
 		this.sin_monto_iva=0.0;
 		this.iva=0.0;
 		this.otro_impuesto=0.0;
 		this.valor_propuesto=0.0;
 		this.subtotal=0.0;
 		this.financiero=0.0;
 		this.total=0.0;
 		this.valor_cambio=0.0;
		
		
		this.empresa=null;
		this.sucursal=null;
		this.ejercicio=null;
		
		
		this.empresa_descripcion="";
		this.sucursal_descripcion="";
		this.ejercicio_descripcion="";
		
		
		this.detallerecaps=null;
		
			
		
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
    //PARA REPORTES
	public Recap (Long id,Date versionRow,Long id_empresa,Long id_sucursal,Long id_ejercicio,String numero,String numero_autorizacion,Date fecha_inicio,Date fecha_final,Date fecha_elaboracion,Date fecha_caducidad,Double monto_iva,Double sin_monto_iva,Double iva,Double otro_impuesto,Double valor_propuesto,Double subtotal,Double financiero,Double total,Double valor_cambio) throws Exception {
		super();		
		
		this.id=id;
		this.versionRow=versionRow;
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.recapOriginal=this;
		
 		this.id_empresa=id_empresa;
 		this.id_sucursal=id_sucursal;
 		this.id_ejercicio=id_ejercicio;
 		this.numero=numero;
 		this.numero_autorizacion=numero_autorizacion;
 		this.fecha_inicio=fecha_inicio;
 		this.fecha_final=fecha_final;
 		this.fecha_elaboracion=fecha_elaboracion;
 		this.fecha_caducidad=fecha_caducidad;
 		this.monto_iva=monto_iva;
 		this.sin_monto_iva=sin_monto_iva;
 		this.iva=iva;
 		this.otro_impuesto=otro_impuesto;
 		this.valor_propuesto=valor_propuesto;
 		this.subtotal=subtotal;
 		this.financiero=financiero;
 		this.total=total;
 		this.valor_cambio=valor_cambio;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	 //PARA REPORTES
	public Recap (Long id_empresa,Long id_sucursal,Long id_ejercicio,String numero,String numero_autorizacion,Date fecha_inicio,Date fecha_final,Date fecha_elaboracion,Date fecha_caducidad,Double monto_iva,Double sin_monto_iva,Double iva,Double otro_impuesto,Double valor_propuesto,Double subtotal,Double financiero,Double total,Double valor_cambio) throws Exception {
		super();		
		
		this.id=0L;
		this.versionRow=new Date();
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.recapOriginal=this;
		
 		this.id_empresa=id_empresa;
 		this.id_sucursal=id_sucursal;
 		this.id_ejercicio=id_ejercicio;
 		this.numero=numero;
 		this.numero_autorizacion=numero_autorizacion;
 		this.fecha_inicio=fecha_inicio;
 		this.fecha_final=fecha_final;
 		this.fecha_elaboracion=fecha_elaboracion;
 		this.fecha_caducidad=fecha_caducidad;
 		this.monto_iva=monto_iva;
 		this.sin_monto_iva=sin_monto_iva;
 		this.iva=iva;
 		this.otro_impuesto=otro_impuesto;
 		this.valor_propuesto=valor_propuesto;
 		this.subtotal=subtotal;
 		this.financiero=financiero;
 		this.total=total;
 		this.valor_cambio=valor_cambio;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	public boolean equals(Object object) {
		boolean equal=false;
		Recap recapLocal=null;
		
		if(object!=null) {
			recapLocal=(Recap)object;
			
			if(recapLocal!=null) {
				if(this.getId()!=null && recapLocal.getId()!=null) {
					if(this.getId().equals(recapLocal.getId())) {
						equal=true;
					}
				}
			}
		}
		
		return equal;
	}
	
	public String toString() {
		String sDetalle="";
		
		if(!RecapConstantesFunciones.CON_DESCRIPCION_DETALLADO) {
        	sDetalle=RecapConstantesFunciones.getRecapDescripcion(this);
		} else {
			sDetalle=RecapConstantesFunciones.getRecapDescripcionDetallado(this);
		}
		
		return sDetalle;
    }
	
	public Recap getRecapOriginal() {
		return this.recapOriginal;
	}
	
	public void setRecapOriginal(Recap recap) {
		try {
			this.recapOriginal=recap;
		} catch(Exception e) {
			;
		}
	}
	
	
	protected RecapAdditional recapAdditional=null;
	
	public RecapAdditional getRecapAdditional() {
		return this.recapAdditional;
	}
	
	public void setRecapAdditional(RecapAdditional recapAdditional) {
		try {
			this.recapAdditional=recapAdditional;
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
    
	
	public String getnumero() {
		return this.numero;
	}
    
	
	public String getnumero_autorizacion() {
		return this.numero_autorizacion;
	}
    
	
	public Date getfecha_inicio() {
		return this.fecha_inicio;
	}
    
	
	public Date getfecha_final() {
		return this.fecha_final;
	}
    
	
	public Date getfecha_elaboracion() {
		return this.fecha_elaboracion;
	}
    
	
	public Date getfecha_caducidad() {
		return this.fecha_caducidad;
	}
    
	
	public Double getmonto_iva() {
		return this.monto_iva;
	}
    
	
	public Double getsin_monto_iva() {
		return this.sin_monto_iva;
	}
    
	
	public Double getiva() {
		return this.iva;
	}
    
	
	public Double getotro_impuesto() {
		return this.otro_impuesto;
	}
    
	
	public Double getvalor_propuesto() {
		return this.valor_propuesto;
	}
    
	
	public Double getsubtotal() {
		return this.subtotal;
	}
    
	
	public Double getfinanciero() {
		return this.financiero;
	}
    
	
	public Double gettotal() {
		return this.total;
	}
    
	
	public Double getvalor_cambio() {
		return this.valor_cambio;
	}
	
    
	public void setid_empresa(Long newid_empresa)throws Exception
	{
		try {
			if(this.id_empresa!=newid_empresa) {
				if(newid_empresa==null) {
					//newid_empresa=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("Recap:Valor nulo no permitido en columna id_empresa");
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
						System.out.println("Recap:Valor nulo no permitido en columna id_sucursal");
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
						System.out.println("Recap:Valor nulo no permitido en columna id_ejercicio");
					}
				}

				this.id_ejercicio=newid_ejercicio;
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
						System.out.println("Recap:Valor nulo no permitido en columna numero");
					}
				}

				if(newnumero!=null&&newnumero.length()>50) {
					newnumero=newnumero.substring(0,48);
					System.out.println("Recap:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=50 en columna numero");
				}

				this.numero=newnumero;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setnumero_autorizacion(String newnumero_autorizacion)throws Exception
	{
		try {
			if(this.numero_autorizacion!=newnumero_autorizacion) {
				if(newnumero_autorizacion==null) {
					//newnumero_autorizacion="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("Recap:Valor nulo no permitido en columna numero_autorizacion");
					}
				}

				if(newnumero_autorizacion!=null&&newnumero_autorizacion.length()>50) {
					newnumero_autorizacion=newnumero_autorizacion.substring(0,48);
					System.out.println("Recap:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=50 en columna numero_autorizacion");
				}

				this.numero_autorizacion=newnumero_autorizacion;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setfecha_inicio(Date newfecha_inicio)throws Exception
	{
		try {
			if(this.fecha_inicio!=newfecha_inicio) {
				if(newfecha_inicio==null) {
					//newfecha_inicio=new Date();
					if(Constantes.ISDEVELOPING) {
						System.out.println("Recap:Valor nulo no permitido en columna fecha_inicio");
					}
				}

				this.fecha_inicio=newfecha_inicio;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setfecha_final(Date newfecha_final)throws Exception
	{
		try {
			if(this.fecha_final!=newfecha_final) {
				if(newfecha_final==null) {
					//newfecha_final=new Date();
					if(Constantes.ISDEVELOPING) {
						System.out.println("Recap:Valor nulo no permitido en columna fecha_final");
					}
				}

				this.fecha_final=newfecha_final;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setfecha_elaboracion(Date newfecha_elaboracion)throws Exception
	{
		try {
			if(this.fecha_elaboracion!=newfecha_elaboracion) {
				if(newfecha_elaboracion==null) {
					//newfecha_elaboracion=new Date();
					if(Constantes.ISDEVELOPING) {
						System.out.println("Recap:Valor nulo no permitido en columna fecha_elaboracion");
					}
				}

				this.fecha_elaboracion=newfecha_elaboracion;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setfecha_caducidad(Date newfecha_caducidad)throws Exception
	{
		try {
			if(this.fecha_caducidad!=newfecha_caducidad) {
				if(newfecha_caducidad==null) {
					//newfecha_caducidad=new Date();
					if(Constantes.ISDEVELOPING) {
						System.out.println("Recap:Valor nulo no permitido en columna fecha_caducidad");
					}
				}

				this.fecha_caducidad=newfecha_caducidad;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setmonto_iva(Double newmonto_iva)throws Exception
	{
		try {
			if(this.monto_iva!=newmonto_iva) {
				if(newmonto_iva==null) {
					//newmonto_iva=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("Recap:Valor nulo no permitido en columna monto_iva");
					}
				}

				this.monto_iva=newmonto_iva;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setsin_monto_iva(Double newsin_monto_iva)throws Exception
	{
		try {
			if(this.sin_monto_iva!=newsin_monto_iva) {
				if(newsin_monto_iva==null) {
					//newsin_monto_iva=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("Recap:Valor nulo no permitido en columna sin_monto_iva");
					}
				}

				this.sin_monto_iva=newsin_monto_iva;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setiva(Double newiva)throws Exception
	{
		try {
			if(this.iva!=newiva) {
				if(newiva==null) {
					//newiva=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("Recap:Valor nulo no permitido en columna iva");
					}
				}

				this.iva=newiva;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setotro_impuesto(Double newotro_impuesto)throws Exception
	{
		try {
			if(this.otro_impuesto!=newotro_impuesto) {
				if(newotro_impuesto==null) {
					//newotro_impuesto=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("Recap:Valor nulo no permitido en columna otro_impuesto");
					}
				}

				this.otro_impuesto=newotro_impuesto;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setvalor_propuesto(Double newvalor_propuesto)throws Exception
	{
		try {
			if(this.valor_propuesto!=newvalor_propuesto) {
				if(newvalor_propuesto==null) {
					//newvalor_propuesto=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("Recap:Valor nulo no permitido en columna valor_propuesto");
					}
				}

				this.valor_propuesto=newvalor_propuesto;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setsubtotal(Double newsubtotal)throws Exception
	{
		try {
			if(this.subtotal!=newsubtotal) {
				if(newsubtotal==null) {
					//newsubtotal=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("Recap:Valor nulo no permitido en columna subtotal");
					}
				}

				this.subtotal=newsubtotal;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setfinanciero(Double newfinanciero)throws Exception
	{
		try {
			if(this.financiero!=newfinanciero) {
				if(newfinanciero==null) {
					//newfinanciero=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("Recap:Valor nulo no permitido en columna financiero");
					}
				}

				this.financiero=newfinanciero;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void settotal(Double newtotal)throws Exception
	{
		try {
			if(this.total!=newtotal) {
				if(newtotal==null) {
					//newtotal=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("Recap:Valor nulo no permitido en columna total");
					}
				}

				this.total=newtotal;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setvalor_cambio(Double newvalor_cambio)throws Exception
	{
		try {
			if(this.valor_cambio!=newvalor_cambio) {
				if(newvalor_cambio==null) {
					//newvalor_cambio=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("Recap:Valor nulo no permitido en columna valor_cambio");
					}
				}

				this.valor_cambio=newvalor_cambio;
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

	
	
	public String getempresa_descripcion() {
		return this.empresa_descripcion;
	}

	public String getsucursal_descripcion() {
		return this.sucursal_descripcion;
	}

	public String getejercicio_descripcion() {
		return this.ejercicio_descripcion;
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


	
	
	public List<DetalleRecap> getDetalleRecaps() {
		return this.detallerecaps;
	}

	
	
	public  void  setDetalleRecaps(List<DetalleRecap> detallerecaps) {
		try {
			this.detallerecaps=detallerecaps;
		} catch(Exception e) {
			;
		}
	}

	
	/*PARA REPORTES*/
	String id_empresa_descripcion="";String id_sucursal_descripcion="";String id_ejercicio_descripcion="";
	
	
	public String getid_empresa_descripcion() {
		return id_empresa_descripcion;
	}
	public String getid_sucursal_descripcion() {
		return id_sucursal_descripcion;
	}
	public String getid_ejercicio_descripcion() {
		return id_ejercicio_descripcion;
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
	
	public void inicializarVariablesParaReporte() {
		this.id_empresa_descripcion="";this.id_sucursal_descripcion="";this.id_ejercicio_descripcion="";
	}
	
	
	Object detallerecapsDescripcionReporte;
	
	
	public Object getdetallerecapsDescripcionReporte() {
		return detallerecapsDescripcionReporte;
	}

	
	
	public  void  setdetallerecapsDescripcionReporte(Object detallerecaps) {
		try {
			this.detallerecapsDescripcionReporte=detallerecaps;
		} catch(Exception ex) {
			;
		}
	}

	/*PARA REPORTES FIN*/		
}

