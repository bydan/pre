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
package com.bydan.erp.tesoreria.business.entity;

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
//import com.bydan.erp.tesoreria.util.TipoRetencionFuenteIvaConstantesFunciones;
import com.bydan.erp.tesoreria.util.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.contabilidad.util.*;



import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;




@SuppressWarnings("unused")
public class TipoRetencionFuenteIva extends TipoRetencionFuenteIvaAdditional implements Serializable ,Cloneable {//TipoRetencionFuenteIvaAdditional,GeneralEntity
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
	
	private TipoRetencionFuenteIva tiporetencionfuenteivaOriginal;
	
	private Map<String, Object> mapTipoRetencionFuenteIva;
			
	public Map<String, Object> getMapTipoRetencionFuenteIva() {
		return mapTipoRetencionFuenteIva;
	}

	public void setMapTipoRetencionFuenteIva(Map<String, Object> mapTipoRetencionFuenteIva) {
		this.mapTipoRetencionFuenteIva = mapTipoRetencionFuenteIva;
	}
	
	public void inicializarMapTipoRetencionFuenteIva() {
		this.mapTipoRetencionFuenteIva = new HashMap<String,Object>();
	}
	
	public void setMapTipoRetencionFuenteIvaValue(String sKey,Object oValue) {
		this.mapTipoRetencionFuenteIva.put(sKey, oValue);
	}
	
	public Object getMapTipoRetencionFuenteIvaValue(String sKey) {
		return this.mapTipoRetencionFuenteIva.get(sKey);
	}
	
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_pais;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=50,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=TipoRetencionFuenteIvaConstantesFunciones.SREGEXCODIGO,message=TipoRetencionFuenteIvaConstantesFunciones.SMENSAJEREGEXCODIGO)
	private String codigo;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=150,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=TipoRetencionFuenteIvaConstantesFunciones.SREGEXNOMBRE,message=TipoRetencionFuenteIvaConstantesFunciones.SMENSAJEREGEXNOMBRE)
	private String nombre;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double porcentaje;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double monto_minimo;
	
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_cuenta_contable;
	
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_cuenta_contable_credito;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Boolean es_retencion_iva;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Boolean es_debito;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Boolean es_con_iva_factura;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Boolean es_con_sub_total_factura;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Boolean es_con_secuencial;
			
	
	public Pais pais;
	public CuentaContable cuentacontable;
	public CuentaContable cuentacontablecredito;
	
	
	private String pais_descripcion;
	private String cuentacontable_descripcion;
	private String cuentacontablecredito_descripcion;
	
	
		
	public TipoRetencionFuenteIva () throws Exception {
		super();		
		
		this.id=0L;
		this.idOriginal=0L;
		
		
		this.versionRow=new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());//new Date();
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		this.sType="NONE";
		
		this.tiporetencionfuenteivaOriginal=this;
		
 		this.id_pais=-1L;
 		this.codigo="";
 		this.nombre="";
 		this.porcentaje=0.0;
 		this.monto_minimo=0.0;
 		this.id_cuenta_contable=null;
 		this.id_cuenta_contable_credito=null;
 		this.es_retencion_iva=false;
 		this.es_debito=false;
 		this.es_con_iva_factura=false;
 		this.es_con_sub_total_factura=false;
 		this.es_con_secuencial=false;
		
		
		this.pais=null;
		this.cuentacontable=null;
		this.cuentacontablecredito=null;
		
		
		this.pais_descripcion="";
		this.cuentacontable_descripcion="";
		this.cuentacontablecredito_descripcion="";
		
		
		
			
		
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
    //PARA REPORTES
	public TipoRetencionFuenteIva (Long id,Date versionRow,Long id_pais,String codigo,String nombre,Double porcentaje,Double monto_minimo,Long id_cuenta_contable,Long id_cuenta_contable_credito,Boolean es_retencion_iva,Boolean es_debito,Boolean es_con_iva_factura,Boolean es_con_sub_total_factura,Boolean es_con_secuencial) throws Exception {
		super();		
		
		this.id=id;
		this.idOriginal=this.id;
		this.versionRow=versionRow;
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.tiporetencionfuenteivaOriginal=this;
		
 		this.id_pais=id_pais;
 		this.codigo=codigo;
 		this.nombre=nombre;
 		this.porcentaje=porcentaje;
 		this.monto_minimo=monto_minimo;
 		this.id_cuenta_contable=id_cuenta_contable;
 		this.id_cuenta_contable_credito=id_cuenta_contable_credito;
 		this.es_retencion_iva=es_retencion_iva;
 		this.es_debito=es_debito;
 		this.es_con_iva_factura=es_con_iva_factura;
 		this.es_con_sub_total_factura=es_con_sub_total_factura;
 		this.es_con_secuencial=es_con_secuencial;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	 //PARA REPORTES
	public TipoRetencionFuenteIva (Long id_pais,String codigo,String nombre,Double porcentaje,Double monto_minimo,Long id_cuenta_contable,Long id_cuenta_contable_credito,Boolean es_retencion_iva,Boolean es_debito,Boolean es_con_iva_factura,Boolean es_con_sub_total_factura,Boolean es_con_secuencial) throws Exception {
		super();		
		
		this.id=0L;
		this.idOriginal=0L;
		this.versionRow=new Date();
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.tiporetencionfuenteivaOriginal=this;
		
 		this.id_pais=id_pais;
 		this.codigo=codigo;
 		this.nombre=nombre;
 		this.porcentaje=porcentaje;
 		this.monto_minimo=monto_minimo;
 		this.id_cuenta_contable=id_cuenta_contable;
 		this.id_cuenta_contable_credito=id_cuenta_contable_credito;
 		this.es_retencion_iva=es_retencion_iva;
 		this.es_debito=es_debito;
 		this.es_con_iva_factura=es_con_iva_factura;
 		this.es_con_sub_total_factura=es_con_sub_total_factura;
 		this.es_con_secuencial=es_con_secuencial;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	public boolean equals(Object object) {
		boolean equal=false;
		TipoRetencionFuenteIva tiporetencionfuenteivaLocal=null;
		
		if(object!=null) {
			tiporetencionfuenteivaLocal=(TipoRetencionFuenteIva)object;
			
			if(tiporetencionfuenteivaLocal!=null) {
				if(this.getId()!=null && tiporetencionfuenteivaLocal.getId()!=null) {
					if(this.getId().equals(tiporetencionfuenteivaLocal.getId())) {
						equal=true;
					}
				}
			}
		}
		
		return equal;
	}
	
	public String toString() {
		String sDetalle="";
		
		if(!TipoRetencionFuenteIvaConstantesFunciones.CON_DESCRIPCION_DETALLADO) {
        	sDetalle=TipoRetencionFuenteIvaConstantesFunciones.getTipoRetencionFuenteIvaDescripcion(this);
		} else {
			sDetalle=TipoRetencionFuenteIvaConstantesFunciones.getTipoRetencionFuenteIvaDescripcionDetallado(this);
		}
		
		return sDetalle;
    }
	
	public TipoRetencionFuenteIva getTipoRetencionFuenteIvaOriginal() {
		return this.tiporetencionfuenteivaOriginal;
	}
	
	public void setTipoRetencionFuenteIvaOriginal(TipoRetencionFuenteIva tiporetencionfuenteiva) {
		try {
			this.tiporetencionfuenteivaOriginal=tiporetencionfuenteiva;
		} catch(Exception e) {
			;
		}
	}
	
	
	protected TipoRetencionFuenteIvaAdditional tiporetencionfuenteivaAdditional=null;
	
	public TipoRetencionFuenteIvaAdditional getTipoRetencionFuenteIvaAdditional() {
		return this.tiporetencionfuenteivaAdditional;
	}
	
	public void setTipoRetencionFuenteIvaAdditional(TipoRetencionFuenteIvaAdditional tiporetencionfuenteivaAdditional) {
		try {
			this.tiporetencionfuenteivaAdditional=tiporetencionfuenteivaAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
    
	
	public Long getid_pais() {
		return this.id_pais;
	}
    
	
	public String getcodigo() {
		return this.codigo;
	}
    
	
	public String getnombre() {
		return this.nombre;
	}
    
	
	public Double getporcentaje() {
		return this.porcentaje;
	}
    
	
	public Double getmonto_minimo() {
		return this.monto_minimo;
	}
    
	
	public Long getid_cuenta_contable() {
		return this.id_cuenta_contable;
	}
    
	
	public Long getid_cuenta_contable_credito() {
		return this.id_cuenta_contable_credito;
	}
    
	
	public Boolean getes_retencion_iva() {
		return this.es_retencion_iva;
	}
    
	
	public Boolean getes_debito() {
		return this.es_debito;
	}
    
	
	public Boolean getes_con_iva_factura() {
		return this.es_con_iva_factura;
	}
    
	
	public Boolean getes_con_sub_total_factura() {
		return this.es_con_sub_total_factura;
	}
    
	
	public Boolean getes_con_secuencial() {
		return this.es_con_secuencial;
	}
	
    
	public void setid_pais(Long newid_pais)throws Exception
	{
		try {
			if(this.id_pais!=newid_pais) {
				if(newid_pais==null) {
					//newid_pais=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("TipoRetencionFuenteIva:Valor nulo no permitido en columna id_pais");
					}
				}

				this.id_pais=newid_pais;
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
						System.out.println("TipoRetencionFuenteIva:Valor nulo no permitido en columna codigo");
					}
				}

				if(newcodigo!=null&&newcodigo.length()>50) {
					newcodigo=newcodigo.substring(0,48);
					System.out.println("TipoRetencionFuenteIva:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=50 en columna codigo");
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
						System.out.println("TipoRetencionFuenteIva:Valor nulo no permitido en columna nombre");
					}
				}

				if(newnombre!=null&&newnombre.length()>150) {
					newnombre=newnombre.substring(0,148);
					System.out.println("TipoRetencionFuenteIva:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=150 en columna nombre");
				}

				this.nombre=newnombre;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setporcentaje(Double newporcentaje)throws Exception
	{
		try {
			if(this.porcentaje!=newporcentaje) {
				if(newporcentaje==null) {
					//newporcentaje=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("TipoRetencionFuenteIva:Valor nulo no permitido en columna porcentaje");
					}
				}

				this.porcentaje=newporcentaje;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setmonto_minimo(Double newmonto_minimo)throws Exception
	{
		try {
			if(this.monto_minimo!=newmonto_minimo) {
				if(newmonto_minimo==null) {
					//newmonto_minimo=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("TipoRetencionFuenteIva:Valor nulo no permitido en columna monto_minimo");
					}
				}

				this.monto_minimo=newmonto_minimo;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_cuenta_contable(Long newid_cuenta_contable) {
		if(this.id_cuenta_contable==null&&newid_cuenta_contable!=null) {
			this.id_cuenta_contable=newid_cuenta_contable;
				this.setIsChanged(true);
		}

		if(this.id_cuenta_contable!=null&&!this.id_cuenta_contable.equals(newid_cuenta_contable)) {

			this.id_cuenta_contable=newid_cuenta_contable;
				this.setIsChanged(true);
		}
	}
    
	public void setid_cuenta_contable_credito(Long newid_cuenta_contable_credito) {
		if(this.id_cuenta_contable_credito==null&&newid_cuenta_contable_credito!=null) {
			this.id_cuenta_contable_credito=newid_cuenta_contable_credito;
				this.setIsChanged(true);
		}

		if(this.id_cuenta_contable_credito!=null&&!this.id_cuenta_contable_credito.equals(newid_cuenta_contable_credito)) {

			this.id_cuenta_contable_credito=newid_cuenta_contable_credito;
				this.setIsChanged(true);
		}
	}
    
	public void setes_retencion_iva(Boolean newes_retencion_iva)throws Exception
	{
		try {
			if(this.es_retencion_iva!=newes_retencion_iva) {
				if(newes_retencion_iva==null) {
					//newes_retencion_iva=false;
					if(Constantes.ISDEVELOPING) {
						System.out.println("TipoRetencionFuenteIva:Valor nulo no permitido en columna es_retencion_iva");
					}
				}

				this.es_retencion_iva=newes_retencion_iva;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setes_debito(Boolean newes_debito)throws Exception
	{
		try {
			if(this.es_debito!=newes_debito) {
				if(newes_debito==null) {
					//newes_debito=false;
					if(Constantes.ISDEVELOPING) {
						System.out.println("TipoRetencionFuenteIva:Valor nulo no permitido en columna es_debito");
					}
				}

				this.es_debito=newes_debito;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setes_con_iva_factura(Boolean newes_con_iva_factura)throws Exception
	{
		try {
			if(this.es_con_iva_factura!=newes_con_iva_factura) {
				if(newes_con_iva_factura==null) {
					//newes_con_iva_factura=false;
					if(Constantes.ISDEVELOPING) {
						System.out.println("TipoRetencionFuenteIva:Valor nulo no permitido en columna es_con_iva_factura");
					}
				}

				this.es_con_iva_factura=newes_con_iva_factura;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setes_con_sub_total_factura(Boolean newes_con_sub_total_factura)throws Exception
	{
		try {
			if(this.es_con_sub_total_factura!=newes_con_sub_total_factura) {
				if(newes_con_sub_total_factura==null) {
					//newes_con_sub_total_factura=false;
					if(Constantes.ISDEVELOPING) {
						System.out.println("TipoRetencionFuenteIva:Valor nulo no permitido en columna es_con_sub_total_factura");
					}
				}

				this.es_con_sub_total_factura=newes_con_sub_total_factura;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setes_con_secuencial(Boolean newes_con_secuencial)throws Exception
	{
		try {
			if(this.es_con_secuencial!=newes_con_secuencial) {
				if(newes_con_secuencial==null) {
					//newes_con_secuencial=false;
					if(Constantes.ISDEVELOPING) {
						System.out.println("TipoRetencionFuenteIva:Valor nulo no permitido en columna es_con_secuencial");
					}
				}

				this.es_con_secuencial=newes_con_secuencial;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	
	public Pais getPais() {
		return this.pais;
	}

	public CuentaContable getCuentaContable() {
		return this.cuentacontable;
	}

	public CuentaContable getCuentaContableCredito() {
		return this.cuentacontablecredito;
	}

	
	
	public String getpais_descripcion() {
		return this.pais_descripcion;
	}

	public String getcuentacontable_descripcion() {
		return this.cuentacontable_descripcion;
	}

	public String getcuentacontablecredito_descripcion() {
		return this.cuentacontablecredito_descripcion;
	}

	
	
	public  void  setPais(Pais pais) {
		try {
			this.pais=pais;
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


	public  void  setCuentaContableCredito(CuentaContable cuentacontablecredito) {
		try {
			this.cuentacontablecredito=cuentacontablecredito;
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


	public  void  setcuentacontable_descripcion(String cuentacontable_descripcion) {
		try {
			this.cuentacontable_descripcion=cuentacontable_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  setcuentacontablecredito_descripcion(String cuentacontablecredito_descripcion) {
		try {
			this.cuentacontablecredito_descripcion=cuentacontablecredito_descripcion;
		} catch(Exception e) {
			;
		}
	}


	
	
	
	
	
	/*PARA REPORTES*/
	String id_pais_descripcion="";String id_cuenta_contable_descripcion="";String id_cuenta_contable_credito_descripcion="";String es_retencion_iva_descripcion="";String es_debito_descripcion="";String es_con_iva_factura_descripcion="";String es_con_sub_total_factura_descripcion="";String es_con_secuencial_descripcion="";
	
	
	public String getid_pais_descripcion() {
		return id_pais_descripcion;
	}
	public String getid_cuenta_contable_descripcion() {
		return id_cuenta_contable_descripcion;
	}
	public String getid_cuenta_contable_credito_descripcion() {
		return id_cuenta_contable_credito_descripcion;
	}
	public String getes_retencion_iva_descripcion() {
		return es_retencion_iva_descripcion;
	}
	public String getes_debito_descripcion() {
		return es_debito_descripcion;
	}
	public String getes_con_iva_factura_descripcion() {
		return es_con_iva_factura_descripcion;
	}
	public String getes_con_sub_total_factura_descripcion() {
		return es_con_sub_total_factura_descripcion;
	}
	public String getes_con_secuencial_descripcion() {
		return es_con_secuencial_descripcion;
	}
	
	
	public void setid_pais_descripcion(String newid_pais_descripcion)throws Exception {
		try {
			this.id_pais_descripcion=newid_pais_descripcion;
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
	public void setid_cuenta_contable_credito_descripcion(String newid_cuenta_contable_credito_descripcion)throws Exception {
		try {
			this.id_cuenta_contable_credito_descripcion=newid_cuenta_contable_credito_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setes_retencion_iva_descripcion(String newes_retencion_iva_descripcion)throws Exception {
		try {
			this.es_retencion_iva_descripcion=newes_retencion_iva_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setes_debito_descripcion(String newes_debito_descripcion)throws Exception {
		try {
			this.es_debito_descripcion=newes_debito_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setes_con_iva_factura_descripcion(String newes_con_iva_factura_descripcion)throws Exception {
		try {
			this.es_con_iva_factura_descripcion=newes_con_iva_factura_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setes_con_sub_total_factura_descripcion(String newes_con_sub_total_factura_descripcion)throws Exception {
		try {
			this.es_con_sub_total_factura_descripcion=newes_con_sub_total_factura_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setes_con_secuencial_descripcion(String newes_con_secuencial_descripcion)throws Exception {
		try {
			this.es_con_secuencial_descripcion=newes_con_secuencial_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	
	public void inicializarVariablesParaReporte() {
		this.id_pais_descripcion="";this.id_cuenta_contable_descripcion="";this.id_cuenta_contable_credito_descripcion="";this.es_retencion_iva_descripcion="";this.es_debito_descripcion="";this.es_con_iva_factura_descripcion="";this.es_con_sub_total_factura_descripcion="";this.es_con_secuencial_descripcion="";
	}
	
	
	
	
	
	
	/*PARA REPORTES FIN*/		
}

