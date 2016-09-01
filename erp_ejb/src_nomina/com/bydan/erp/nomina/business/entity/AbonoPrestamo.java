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
//import com.bydan.erp.nomina.util.AbonoPrestamoConstantesFunciones;
import com.bydan.erp.nomina.util.*;









@SuppressWarnings("unused")
public class AbonoPrestamo extends AbonoPrestamoAdditional implements Serializable ,Cloneable {//AbonoPrestamoAdditional,GeneralEntity
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
	
	private AbonoPrestamo abonoprestamoOriginal;
	
	private Map<String, Object> mapAbonoPrestamo;
			
	public Map<String, Object> getMapAbonoPrestamo() {
		return mapAbonoPrestamo;
	}

	public void setMapAbonoPrestamo(Map<String, Object> mapAbonoPrestamo) {
		this.mapAbonoPrestamo = mapAbonoPrestamo;
	}
	
	public void inicializarMapAbonoPrestamo() {
		this.mapAbonoPrestamo = new HashMap<String,Object>();
	}
	
	public void setMapAbonoPrestamoValue(String sKey,Object oValue) {
		this.mapAbonoPrestamo.put(sKey, oValue);
	}
	
	public Object getMapAbonoPrestamoValue(String sKey) {
		return this.mapAbonoPrestamo.get(sKey);
	}
	
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=-100000,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_prestamo;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=10,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONINT)
	private Integer numero;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double monto_capital;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double monto_interes;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double valor;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Date fecha_vencimiento;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=50,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=AbonoPrestamoConstantesFunciones.SREGEXCODIGO_QUINCENA,message=AbonoPrestamoConstantesFunciones.SMENSAJEREGEXCODIGO_QUINCENA)
	private String codigo_quincena;
			
	
	public Prestamo prestamo;
	
	
	private String prestamo_descripcion;
	
	
		
	public AbonoPrestamo () throws Exception {
		super();		
		
		this.id=0L;
		
		
		this.versionRow=new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());//new Date();
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		this.sType="NONE";
		
		this.abonoprestamoOriginal=this;
		
 		this.id_prestamo=-1L;
 		this.numero=0;
 		this.monto_capital=0.0;
 		this.monto_interes=0.0;
 		this.valor=0.0;
 		this.fecha_vencimiento=new Date();
 		this.codigo_quincena="";
		
		
		this.prestamo=null;
		
		
		this.prestamo_descripcion="";
		
		
		
			
		
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
    //PARA REPORTES
	public AbonoPrestamo (Long id,Date versionRow,Long id_prestamo,Integer numero,Double monto_capital,Double monto_interes,Double valor,Date fecha_vencimiento,String codigo_quincena) throws Exception {
		super();		
		
		this.id=id;
		this.versionRow=versionRow;
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.abonoprestamoOriginal=this;
		
 		this.id_prestamo=id_prestamo;
 		this.numero=numero;
 		this.monto_capital=monto_capital;
 		this.monto_interes=monto_interes;
 		this.valor=valor;
 		this.fecha_vencimiento=fecha_vencimiento;
 		this.codigo_quincena=codigo_quincena;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	 //PARA REPORTES
	public AbonoPrestamo (Long id_prestamo,Integer numero,Double monto_capital,Double monto_interes,Double valor,Date fecha_vencimiento,String codigo_quincena) throws Exception {
		super();		
		
		this.id=0L;
		this.versionRow=new Date();
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.abonoprestamoOriginal=this;
		
 		this.id_prestamo=id_prestamo;
 		this.numero=numero;
 		this.monto_capital=monto_capital;
 		this.monto_interes=monto_interes;
 		this.valor=valor;
 		this.fecha_vencimiento=fecha_vencimiento;
 		this.codigo_quincena=codigo_quincena;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	public boolean equals(Object object) {
		boolean equal=false;
		AbonoPrestamo abonoprestamoLocal=null;
		
		if(object!=null) {
			abonoprestamoLocal=(AbonoPrestamo)object;
			
			if(abonoprestamoLocal!=null) {
				if(this.getId()!=null && abonoprestamoLocal.getId()!=null) {
					if(this.getId().equals(abonoprestamoLocal.getId())) {
						equal=true;
					}
				}
			}
		}
		
		return equal;
	}
	
	public String toString() {
		String sDetalle="";
		
		if(!AbonoPrestamoConstantesFunciones.CON_DESCRIPCION_DETALLADO) {
        	sDetalle=AbonoPrestamoConstantesFunciones.getAbonoPrestamoDescripcion(this);
		} else {
			sDetalle=AbonoPrestamoConstantesFunciones.getAbonoPrestamoDescripcionDetallado(this);
		}
		
		return sDetalle;
    }
	
	public AbonoPrestamo getAbonoPrestamoOriginal() {
		return this.abonoprestamoOriginal;
	}
	
	public void setAbonoPrestamoOriginal(AbonoPrestamo abonoprestamo) {
		try {
			this.abonoprestamoOriginal=abonoprestamo;
		} catch(Exception e) {
			;
		}
	}
	
	
	protected AbonoPrestamoAdditional abonoprestamoAdditional=null;
	
	public AbonoPrestamoAdditional getAbonoPrestamoAdditional() {
		return this.abonoprestamoAdditional;
	}
	
	public void setAbonoPrestamoAdditional(AbonoPrestamoAdditional abonoprestamoAdditional) {
		try {
			this.abonoprestamoAdditional=abonoprestamoAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
    
	
	public Long getid_prestamo() {
		return this.id_prestamo;
	}
    
	
	public Integer getnumero() {
		return this.numero;
	}
    
	
	public Double getmonto_capital() {
		return this.monto_capital;
	}
    
	
	public Double getmonto_interes() {
		return this.monto_interes;
	}
    
	
	public Double getvalor() {
		return this.valor;
	}
    
	
	public Date getfecha_vencimiento() {
		return this.fecha_vencimiento;
	}
    
	
	public String getcodigo_quincena() {
		return this.codigo_quincena;
	}
	
    
	public void setid_prestamo(Long newid_prestamo)throws Exception
	{
		try {
			if(this.id_prestamo!=newid_prestamo) {
				if(newid_prestamo==null) {
					//newid_prestamo=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("AbonoPrestamo:Valor nulo no permitido en columna id_prestamo");
					}
				}

				this.id_prestamo=newid_prestamo;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setnumero(Integer newnumero)throws Exception
	{
		try {
			if(this.numero!=newnumero) {
				if(newnumero==null) {
					//newnumero=0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("AbonoPrestamo:Valor nulo no permitido en columna numero");
					}
				}

				this.numero=newnumero;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setmonto_capital(Double newmonto_capital)throws Exception
	{
		try {
			if(this.monto_capital!=newmonto_capital) {
				if(newmonto_capital==null) {
					//newmonto_capital=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("AbonoPrestamo:Valor nulo no permitido en columna monto_capital");
					}
				}

				this.monto_capital=newmonto_capital;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setmonto_interes(Double newmonto_interes)throws Exception
	{
		try {
			if(this.monto_interes!=newmonto_interes) {
				if(newmonto_interes==null) {
					//newmonto_interes=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("AbonoPrestamo:Valor nulo no permitido en columna monto_interes");
					}
				}

				this.monto_interes=newmonto_interes;
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
						System.out.println("AbonoPrestamo:Valor nulo no permitido en columna valor");
					}
				}

				this.valor=newvalor;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setfecha_vencimiento(Date newfecha_vencimiento)throws Exception
	{
		try {
			if(this.fecha_vencimiento!=newfecha_vencimiento) {
				if(newfecha_vencimiento==null) {
					//newfecha_vencimiento=new Date();
					if(Constantes.ISDEVELOPING) {
						System.out.println("AbonoPrestamo:Valor nulo no permitido en columna fecha_vencimiento");
					}
				}

				this.fecha_vencimiento=newfecha_vencimiento;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setcodigo_quincena(String newcodigo_quincena)throws Exception
	{
		try {
			if(this.codigo_quincena!=newcodigo_quincena) {
				if(newcodigo_quincena==null) {
					//newcodigo_quincena="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("AbonoPrestamo:Valor nulo no permitido en columna codigo_quincena");
					}
				}

				if(newcodigo_quincena!=null&&newcodigo_quincena.length()>50) {
					newcodigo_quincena=newcodigo_quincena.substring(0,48);
					System.out.println("AbonoPrestamo:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=50 en columna codigo_quincena");
				}

				this.codigo_quincena=newcodigo_quincena;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	
	public Prestamo getPrestamo() {
		return this.prestamo;
	}

	
	
	public String getprestamo_descripcion() {
		return this.prestamo_descripcion;
	}

	
	
	public  void  setPrestamo(Prestamo prestamo) {
		try {
			this.prestamo=prestamo;
		} catch(Exception e) {
			;
		}
	}


	
	
	public  void  setprestamo_descripcion(String prestamo_descripcion) {
		try {
			this.prestamo_descripcion=prestamo_descripcion;
		} catch(Exception e) {
			;
		}
	}


	
	
	
	
	
	/*PARA REPORTES*/
	String id_prestamo_descripcion="";
	
	
	public String getid_prestamo_descripcion() {
		return id_prestamo_descripcion;
	}
	
	
	public void setid_prestamo_descripcion(String newid_prestamo_descripcion)throws Exception {
		try {
			this.id_prestamo_descripcion=newid_prestamo_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	
	public void inicializarVariablesParaReporte() {
		this.id_prestamo_descripcion="";
	}
	
	
	
	
	
	
	/*PARA REPORTES FIN*/		
}

