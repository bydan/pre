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
package com.bydan.erp.puntoventa.business.entity.report;

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
//import com.bydan.erp.puntoventa.util.PagosTarjetasConstantesFunciones;
import com.bydan.erp.puntoventa.util.*;


import com.bydan.erp.seguridad.util.*;

import com.bydan.erp.puntoventa.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;




@SuppressWarnings("unused")
public class PagosTarjetas extends PagosTarjetasAdditional implements Serializable ,Cloneable {//PagosTarjetasAdditional,GeneralEntity
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
	
	private PagosTarjetas pagostarjetasOriginal;
	
	private Map<String, Object> mapPagosTarjetas;
			
	public Map<String, Object> getMapPagosTarjetas() {
		return mapPagosTarjetas;
	}

	public void setMapPagosTarjetas(Map<String, Object> mapPagosTarjetas) {
		this.mapPagosTarjetas = mapPagosTarjetas;
	}
	
	public void inicializarMapPagosTarjetas() {
		this.mapPagosTarjetas = new HashMap<String,Object>();
	}
	
	public void setMapPagosTarjetasValue(String sKey,Object oValue) {
		this.mapPagosTarjetas.put(sKey, oValue);
	}
	
	public Object getMapPagosTarjetasValue(String sKey) {
		return this.mapPagosTarjetas.get(sKey);
	}
	
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_empresa;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Date fecha_hasta;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=50,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	//@Pattern(regex=PagosTarjetasConstantesFunciones.SREGEXCODIGO_ASIENTO_CONTABLE,message=PagosTarjetasConstantesFunciones.SMENSAJEREGEXCODIGO_ASIENTO_CONTABLE)
	private String codigo_asiento_contable;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=50,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	//@Pattern(regex=PagosTarjetasConstantesFunciones.SREGEXCODIGO_TARJETA_CREDITO,message=PagosTarjetasConstantesFunciones.SMENSAJEREGEXCODIGO_TARJETA_CREDITO)
	private String codigo_tarjeta_credito;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=100,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	//@Pattern(regex=PagosTarjetasConstantesFunciones.SREGEXNOMBRE_TIPO_INTERES_TARJETA,message=PagosTarjetasConstantesFunciones.SMENSAJEREGEXNOMBRE_TIPO_INTERES_TARJETA)
	private String nombre_tipo_interes_tarjeta;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=100,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	//@Pattern(regex=PagosTarjetasConstantesFunciones.SREGEXNOMBRE_CONEXION,message=PagosTarjetasConstantesFunciones.SMENSAJEREGEXNOMBRE_CONEXION)
	private String nombre_conexion;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=50,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	//@Pattern(regex=PagosTarjetasConstantesFunciones.SREGEXNOMBRE_MES,message=PagosTarjetasConstantesFunciones.SMENSAJEREGEXNOMBRE_MES)
	private String nombre_mes;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=50,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	//@Pattern(regex=PagosTarjetasConstantesFunciones.SREGEXNUMERO,message=PagosTarjetasConstantesFunciones.SMENSAJEREGEXNUMERO)
	private String numero;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=50,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	//@Pattern(regex=PagosTarjetasConstantesFunciones.SREGEXLOTE,message=PagosTarjetasConstantesFunciones.SMENSAJEREGEXLOTE)
	private String lote;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double valor;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double valor_retencion;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double valor_comision;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double valor_calculado;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double valor_cancelado;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double valor_difiere;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=50,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	//@Pattern(regex=PagosTarjetasConstantesFunciones.SREGEXNUMERO_RETENCION,message=PagosTarjetasConstantesFunciones.SMENSAJEREGEXNUMERO_RETENCION)
	private String numero_retencion;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=50,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	//@Pattern(regex=PagosTarjetasConstantesFunciones.SREGEXNUMERO_LIQUIDACION,message=PagosTarjetasConstantesFunciones.SMENSAJEREGEXNUMERO_LIQUIDACION)
	private String numero_liquidacion;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Date fecha;
			
	
	public Empresa empresa;
	
	
	private String empresa_descripcion;
	
	
		
	public PagosTarjetas () throws Exception {
		super();		
		
		this.id=0L;
		
		
		this.versionRow=new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());//new Date();
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		this.sType="NONE";
		
		this.pagostarjetasOriginal=this;
		
 		this.id_empresa=-1L;
 		this.fecha_hasta=new Date();
 		this.codigo_asiento_contable="";
 		this.codigo_tarjeta_credito="";
 		this.nombre_tipo_interes_tarjeta="";
 		this.nombre_conexion="";
 		this.nombre_mes="";
 		this.numero="";
 		this.lote="";
 		this.valor=0.0;
 		this.valor_retencion=0.0;
 		this.valor_comision=0.0;
 		this.valor_calculado=0.0;
 		this.valor_cancelado=0.0;
 		this.valor_difiere=0.0;
 		this.numero_retencion="";
 		this.numero_liquidacion="";
 		this.fecha=new Date();
		
		
		this.empresa=null;
		
		
		this.empresa_descripcion="";
		
		
		
			
		
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
    //PARA REPORTES
	public PagosTarjetas (Long id,Date versionRow,String codigo_asiento_contable,String codigo_tarjeta_credito,String nombre_tipo_interes_tarjeta,String nombre_conexion,String nombre_mes,String numero,String lote,Double valor,Double valor_retencion,Double valor_comision,Double valor_calculado,Double valor_cancelado,Double valor_difiere,String numero_retencion,String numero_liquidacion,Date fecha) throws Exception {
		super();		
		
		this.id=id;
		this.versionRow=versionRow;
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.pagostarjetasOriginal=this;
		
 		this.codigo_asiento_contable=codigo_asiento_contable;
 		this.codigo_tarjeta_credito=codigo_tarjeta_credito;
 		this.nombre_tipo_interes_tarjeta=nombre_tipo_interes_tarjeta;
 		this.nombre_conexion=nombre_conexion;
 		this.nombre_mes=nombre_mes;
 		this.numero=numero;
 		this.lote=lote;
 		this.valor=valor;
 		this.valor_retencion=valor_retencion;
 		this.valor_comision=valor_comision;
 		this.valor_calculado=valor_calculado;
 		this.valor_cancelado=valor_cancelado;
 		this.valor_difiere=valor_difiere;
 		this.numero_retencion=numero_retencion;
 		this.numero_liquidacion=numero_liquidacion;
 		this.fecha=fecha;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	 //PARA REPORTES
	public PagosTarjetas (String codigo_asiento_contable,String codigo_tarjeta_credito,String nombre_tipo_interes_tarjeta,String nombre_conexion,String nombre_mes,String numero,String lote,Double valor,Double valor_retencion,Double valor_comision,Double valor_calculado,Double valor_cancelado,Double valor_difiere,String numero_retencion,String numero_liquidacion,Date fecha) throws Exception {
		super();		
		
		this.id=0L;
		this.versionRow=new Date();
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.pagostarjetasOriginal=this;
		
 		this.codigo_asiento_contable=codigo_asiento_contable;
 		this.codigo_tarjeta_credito=codigo_tarjeta_credito;
 		this.nombre_tipo_interes_tarjeta=nombre_tipo_interes_tarjeta;
 		this.nombre_conexion=nombre_conexion;
 		this.nombre_mes=nombre_mes;
 		this.numero=numero;
 		this.lote=lote;
 		this.valor=valor;
 		this.valor_retencion=valor_retencion;
 		this.valor_comision=valor_comision;
 		this.valor_calculado=valor_calculado;
 		this.valor_cancelado=valor_cancelado;
 		this.valor_difiere=valor_difiere;
 		this.numero_retencion=numero_retencion;
 		this.numero_liquidacion=numero_liquidacion;
 		this.fecha=fecha;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	
	public PagosTarjetas getPagosTarjetasOriginal() {
		return this.pagostarjetasOriginal;
	}
	
	public void setPagosTarjetasOriginal(PagosTarjetas pagostarjetas) {
		try {
			this.pagostarjetasOriginal=pagostarjetas;
		} catch(Exception e) {
			;
		}
	}
	
	
	protected PagosTarjetasAdditional pagostarjetasAdditional=null;
	
	public PagosTarjetasAdditional getPagosTarjetasAdditional() {
		return this.pagostarjetasAdditional;
	}
	
	public void setPagosTarjetasAdditional(PagosTarjetasAdditional pagostarjetasAdditional) {
		try {
			this.pagostarjetasAdditional=pagostarjetasAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
    
	
	public Long getid_empresa() {
		return this.id_empresa;
	}
    
	
	public Date getfecha_hasta() {
		return this.fecha_hasta;
	}
    
	
	public String getcodigo_asiento_contable() {
		return this.codigo_asiento_contable;
	}
    
	
	public String getcodigo_tarjeta_credito() {
		return this.codigo_tarjeta_credito;
	}
    
	
	public String getnombre_tipo_interes_tarjeta() {
		return this.nombre_tipo_interes_tarjeta;
	}
    
	
	public String getnombre_conexion() {
		return this.nombre_conexion;
	}
    
	
	public String getnombre_mes() {
		return this.nombre_mes;
	}
    
	
	public String getnumero() {
		return this.numero;
	}
    
	
	public String getlote() {
		return this.lote;
	}
    
	
	public Double getvalor() {
		return this.valor;
	}
    
	
	public Double getvalor_retencion() {
		return this.valor_retencion;
	}
    
	
	public Double getvalor_comision() {
		return this.valor_comision;
	}
    
	
	public Double getvalor_calculado() {
		return this.valor_calculado;
	}
    
	
	public Double getvalor_cancelado() {
		return this.valor_cancelado;
	}
    
	
	public Double getvalor_difiere() {
		return this.valor_difiere;
	}
    
	
	public String getnumero_retencion() {
		return this.numero_retencion;
	}
    
	
	public String getnumero_liquidacion() {
		return this.numero_liquidacion;
	}
    
	
	public Date getfecha() {
		return this.fecha;
	}
	
    
	public void setid_empresa(Long newid_empresa)throws Exception
	{
		try {
			if(this.id_empresa!=newid_empresa) {
				if(newid_empresa==null) {
					//newid_empresa=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("PagosTarjetas:Valor nulo no permitido en columna id_empresa");
					}
				}

				this.id_empresa=newid_empresa;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setfecha_hasta(Date newfecha_hasta)throws Exception
	{
		try {
			if(this.fecha_hasta!=newfecha_hasta) {
				if(newfecha_hasta==null) {
					//newfecha_hasta=new Date();
					if(Constantes.ISDEVELOPING) {
						System.out.println("PagosTarjetas:Valor nulo no permitido en columna fecha_hasta");
					}
				}

				this.fecha_hasta=newfecha_hasta;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setcodigo_asiento_contable(String newcodigo_asiento_contable)throws Exception
	{
		try {
			if(this.codigo_asiento_contable!=newcodigo_asiento_contable) {
				if(newcodigo_asiento_contable==null) {
					//newcodigo_asiento_contable="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("PagosTarjetas:Valor nulo no permitido en columna codigo_asiento_contable");
					}
				}

				if(newcodigo_asiento_contable!=null&&newcodigo_asiento_contable.length()>50) {
					newcodigo_asiento_contable=newcodigo_asiento_contable.substring(0,48);
					System.out.println("PagosTarjetas:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=50 en columna codigo_asiento_contable");
				}

				this.codigo_asiento_contable=newcodigo_asiento_contable;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setcodigo_tarjeta_credito(String newcodigo_tarjeta_credito)throws Exception
	{
		try {
			if(this.codigo_tarjeta_credito!=newcodigo_tarjeta_credito) {
				if(newcodigo_tarjeta_credito==null) {
					//newcodigo_tarjeta_credito="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("PagosTarjetas:Valor nulo no permitido en columna codigo_tarjeta_credito");
					}
				}

				if(newcodigo_tarjeta_credito!=null&&newcodigo_tarjeta_credito.length()>50) {
					newcodigo_tarjeta_credito=newcodigo_tarjeta_credito.substring(0,48);
					System.out.println("PagosTarjetas:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=50 en columna codigo_tarjeta_credito");
				}

				this.codigo_tarjeta_credito=newcodigo_tarjeta_credito;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setnombre_tipo_interes_tarjeta(String newnombre_tipo_interes_tarjeta)throws Exception
	{
		try {
			if(this.nombre_tipo_interes_tarjeta!=newnombre_tipo_interes_tarjeta) {
				if(newnombre_tipo_interes_tarjeta==null) {
					//newnombre_tipo_interes_tarjeta="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("PagosTarjetas:Valor nulo no permitido en columna nombre_tipo_interes_tarjeta");
					}
				}

				if(newnombre_tipo_interes_tarjeta!=null&&newnombre_tipo_interes_tarjeta.length()>100) {
					newnombre_tipo_interes_tarjeta=newnombre_tipo_interes_tarjeta.substring(0,98);
					System.out.println("PagosTarjetas:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=100 en columna nombre_tipo_interes_tarjeta");
				}

				this.nombre_tipo_interes_tarjeta=newnombre_tipo_interes_tarjeta;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setnombre_conexion(String newnombre_conexion)throws Exception
	{
		try {
			if(this.nombre_conexion!=newnombre_conexion) {
				if(newnombre_conexion==null) {
					//newnombre_conexion="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("PagosTarjetas:Valor nulo no permitido en columna nombre_conexion");
					}
				}

				if(newnombre_conexion!=null&&newnombre_conexion.length()>100) {
					newnombre_conexion=newnombre_conexion.substring(0,98);
					System.out.println("PagosTarjetas:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=100 en columna nombre_conexion");
				}

				this.nombre_conexion=newnombre_conexion;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setnombre_mes(String newnombre_mes)throws Exception
	{
		try {
			if(this.nombre_mes!=newnombre_mes) {
				if(newnombre_mes==null) {
					//newnombre_mes="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("PagosTarjetas:Valor nulo no permitido en columna nombre_mes");
					}
				}

				if(newnombre_mes!=null&&newnombre_mes.length()>50) {
					newnombre_mes=newnombre_mes.substring(0,48);
					System.out.println("PagosTarjetas:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=50 en columna nombre_mes");
				}

				this.nombre_mes=newnombre_mes;
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
						System.out.println("PagosTarjetas:Valor nulo no permitido en columna numero");
					}
				}

				if(newnumero!=null&&newnumero.length()>50) {
					newnumero=newnumero.substring(0,48);
					System.out.println("PagosTarjetas:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=50 en columna numero");
				}

				this.numero=newnumero;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setlote(String newlote)throws Exception
	{
		try {
			if(this.lote!=newlote) {
				if(newlote==null) {
					//newlote="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("PagosTarjetas:Valor nulo no permitido en columna lote");
					}
				}

				if(newlote!=null&&newlote.length()>50) {
					newlote=newlote.substring(0,48);
					System.out.println("PagosTarjetas:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=50 en columna lote");
				}

				this.lote=newlote;
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
						System.out.println("PagosTarjetas:Valor nulo no permitido en columna valor");
					}
				}

				this.valor=newvalor;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setvalor_retencion(Double newvalor_retencion)throws Exception
	{
		try {
			if(this.valor_retencion!=newvalor_retencion) {
				if(newvalor_retencion==null) {
					//newvalor_retencion=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("PagosTarjetas:Valor nulo no permitido en columna valor_retencion");
					}
				}

				this.valor_retencion=newvalor_retencion;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setvalor_comision(Double newvalor_comision)throws Exception
	{
		try {
			if(this.valor_comision!=newvalor_comision) {
				if(newvalor_comision==null) {
					//newvalor_comision=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("PagosTarjetas:Valor nulo no permitido en columna valor_comision");
					}
				}

				this.valor_comision=newvalor_comision;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setvalor_calculado(Double newvalor_calculado)throws Exception
	{
		try {
			if(this.valor_calculado!=newvalor_calculado) {
				if(newvalor_calculado==null) {
					//newvalor_calculado=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("PagosTarjetas:Valor nulo no permitido en columna valor_calculado");
					}
				}

				this.valor_calculado=newvalor_calculado;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setvalor_cancelado(Double newvalor_cancelado)throws Exception
	{
		try {
			if(this.valor_cancelado!=newvalor_cancelado) {
				if(newvalor_cancelado==null) {
					//newvalor_cancelado=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("PagosTarjetas:Valor nulo no permitido en columna valor_cancelado");
					}
				}

				this.valor_cancelado=newvalor_cancelado;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setvalor_difiere(Double newvalor_difiere)throws Exception
	{
		try {
			if(this.valor_difiere!=newvalor_difiere) {
				if(newvalor_difiere==null) {
					//newvalor_difiere=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("PagosTarjetas:Valor nulo no permitido en columna valor_difiere");
					}
				}

				this.valor_difiere=newvalor_difiere;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setnumero_retencion(String newnumero_retencion)throws Exception
	{
		try {
			if(this.numero_retencion!=newnumero_retencion) {
				if(newnumero_retencion==null) {
					//newnumero_retencion="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("PagosTarjetas:Valor nulo no permitido en columna numero_retencion");
					}
				}

				if(newnumero_retencion!=null&&newnumero_retencion.length()>50) {
					newnumero_retencion=newnumero_retencion.substring(0,48);
					System.out.println("PagosTarjetas:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=50 en columna numero_retencion");
				}

				this.numero_retencion=newnumero_retencion;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setnumero_liquidacion(String newnumero_liquidacion)throws Exception
	{
		try {
			if(this.numero_liquidacion!=newnumero_liquidacion) {
				if(newnumero_liquidacion==null) {
					//newnumero_liquidacion="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("PagosTarjetas:Valor nulo no permitido en columna numero_liquidacion");
					}
				}

				if(newnumero_liquidacion!=null&&newnumero_liquidacion.length()>50) {
					newnumero_liquidacion=newnumero_liquidacion.substring(0,48);
					System.out.println("PagosTarjetas:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=50 en columna numero_liquidacion");
				}

				this.numero_liquidacion=newnumero_liquidacion;
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
						System.out.println("PagosTarjetas:Valor nulo no permitido en columna fecha");
					}
				}

				this.fecha=newfecha;
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


	
	
	
	
	
	/*PARA REPORTES*/
	String id_empresa_descripcion="";
	
	
	public String getid_empresa_descripcion() {
		return id_empresa_descripcion;
	}
	
	
	public void setid_empresa_descripcion(String newid_empresa_descripcion)throws Exception {
		try {
			this.id_empresa_descripcion=newid_empresa_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	
	public void inicializarVariablesParaReporte() {
		this.id_empresa_descripcion="";
	}
	
	
	
	
	
	
	/*PARA REPORTES FIN*/		
}

