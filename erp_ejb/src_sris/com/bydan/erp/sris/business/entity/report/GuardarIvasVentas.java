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
package com.bydan.erp.sris.business.entity.report;

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
//import com.bydan.erp.sris.util.GuardarIvasVentasConstantesFunciones;
import com.bydan.erp.sris.util.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.contabilidad.util.*;

import com.bydan.erp.sris.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;




@SuppressWarnings("unused")
public class GuardarIvasVentas extends GuardarIvasVentasAdditional implements Serializable ,Cloneable {//GuardarIvasVentasAdditional,GeneralEntity
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
	
	private GuardarIvasVentas guardarivasventasOriginal;
	
	private Map<String, Object> mapGuardarIvasVentas;
			
	public Map<String, Object> getMapGuardarIvasVentas() {
		return mapGuardarIvasVentas;
	}

	public void setMapGuardarIvasVentas(Map<String, Object> mapGuardarIvasVentas) {
		this.mapGuardarIvasVentas = mapGuardarIvasVentas;
	}
	
	public void inicializarMapGuardarIvasVentas() {
		this.mapGuardarIvasVentas = new HashMap<String,Object>();
	}
	
	public void setMapGuardarIvasVentasValue(String sKey,Object oValue) {
		this.mapGuardarIvasVentas.put(sKey, oValue);
	}
	
	public Object getMapGuardarIvasVentasValue(String sKey) {
		return this.mapGuardarIvasVentas.get(sKey);
	}
	
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_empresa;
	
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
	private Long id_tipo_retencion_fuente_iva;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=50,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	//@Pattern(regex=GuardarIvasVentasConstantesFunciones.SREGEXCODIGO_ESTADO_ASIENTO_CONTABLE,message=GuardarIvasVentasConstantesFunciones.SMENSAJEREGEXCODIGO_ESTADO_ASIENTO_CONTABLE)
	private String codigo_estado_asiento_contable;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=50,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	//@Pattern(regex=GuardarIvasVentasConstantesFunciones.SREGEXNOMBRE_PERIODO,message=GuardarIvasVentasConstantesFunciones.SMENSAJEREGEXNOMBRE_PERIODO)
	private String nombre_periodo;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=150,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	//@Pattern(regex=GuardarIvasVentasConstantesFunciones.SREGEXNOMBRE_TIPO_RETENCION_FUENTE_IVA,message=GuardarIvasVentasConstantesFunciones.SMENSAJEREGEXNOMBRE_TIPO_RETENCION_FUENTE_IVA)
	private String nombre_tipo_retencion_fuente_iva;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double porcentaje;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double base_imponible;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double valor;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=50,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	//@Pattern(regex=GuardarIvasVentasConstantesFunciones.SREGEXNUMERO,message=GuardarIvasVentasConstantesFunciones.SMENSAJEREGEXNUMERO)
	private String numero;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=15,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	//@Pattern(regex=GuardarIvasVentasConstantesFunciones.SREGEXRUC_BENEF,message=GuardarIvasVentasConstantesFunciones.SMENSAJEREGEXRUC_BENEF)
	private String ruc_benef;
			
	
	public Empresa empresa;
	public Ejercicio ejercicio;
	public Periodo periodo;
	public TipoRetencion tiporetencionfuenteiva;
	
	
	private String empresa_descripcion;
	private String ejercicio_descripcion;
	private String periodo_descripcion;
	private String tiporetencionfuenteiva_descripcion;
	
	
		
	public GuardarIvasVentas () throws Exception {
		super();		
		
		this.id=0L;
		
		
		this.versionRow=new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());//new Date();
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		this.sType="NONE";
		
		this.guardarivasventasOriginal=this;
		
 		this.id_empresa=-1L;
 		this.id_ejercicio=-1L;
 		this.id_periodo=-1L;
 		this.id_tipo_retencion_fuente_iva=-1L;
 		this.codigo_estado_asiento_contable="";
 		this.nombre_periodo="";
 		this.nombre_tipo_retencion_fuente_iva="";
 		this.porcentaje=0.0;
 		this.base_imponible=0.0;
 		this.valor=0.0;
 		this.numero="";
 		this.ruc_benef="";
		
		
		this.empresa=null;
		this.ejercicio=null;
		this.periodo=null;
		this.tiporetencionfuenteiva=null;
		
		
		this.empresa_descripcion="";
		this.ejercicio_descripcion="";
		this.periodo_descripcion="";
		this.tiporetencionfuenteiva_descripcion="";
		
		
		
			
		
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
    //PARA REPORTES
	public GuardarIvasVentas (Long id,Date versionRow,String codigo_estado_asiento_contable,String nombre_periodo,String nombre_tipo_retencion_fuente_iva,Double porcentaje,Double base_imponible,Double valor,String numero,String ruc_benef) throws Exception {
		super();		
		
		this.id=id;
		this.versionRow=versionRow;
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.guardarivasventasOriginal=this;
		
 		this.codigo_estado_asiento_contable=codigo_estado_asiento_contable;
 		this.nombre_periodo=nombre_periodo;
 		this.nombre_tipo_retencion_fuente_iva=nombre_tipo_retencion_fuente_iva;
 		this.porcentaje=porcentaje;
 		this.base_imponible=base_imponible;
 		this.valor=valor;
 		this.numero=numero;
 		this.ruc_benef=ruc_benef;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	 //PARA REPORTES
	public GuardarIvasVentas (String codigo_estado_asiento_contable,String nombre_periodo,String nombre_tipo_retencion_fuente_iva,Double porcentaje,Double base_imponible,Double valor,String numero,String ruc_benef) throws Exception {
		super();		
		
		this.id=0L;
		this.versionRow=new Date();
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.guardarivasventasOriginal=this;
		
 		this.codigo_estado_asiento_contable=codigo_estado_asiento_contable;
 		this.nombre_periodo=nombre_periodo;
 		this.nombre_tipo_retencion_fuente_iva=nombre_tipo_retencion_fuente_iva;
 		this.porcentaje=porcentaje;
 		this.base_imponible=base_imponible;
 		this.valor=valor;
 		this.numero=numero;
 		this.ruc_benef=ruc_benef;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	
	public GuardarIvasVentas getGuardarIvasVentasOriginal() {
		return this.guardarivasventasOriginal;
	}
	
	public void setGuardarIvasVentasOriginal(GuardarIvasVentas guardarivasventas) {
		try {
			this.guardarivasventasOriginal=guardarivasventas;
		} catch(Exception e) {
			;
		}
	}
	
	
	protected GuardarIvasVentasAdditional guardarivasventasAdditional=null;
	
	public GuardarIvasVentasAdditional getGuardarIvasVentasAdditional() {
		return this.guardarivasventasAdditional;
	}
	
	public void setGuardarIvasVentasAdditional(GuardarIvasVentasAdditional guardarivasventasAdditional) {
		try {
			this.guardarivasventasAdditional=guardarivasventasAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
    
	
	public Long getid_empresa() {
		return this.id_empresa;
	}
    
	
	public Long getid_ejercicio() {
		return this.id_ejercicio;
	}
    
	
	public Long getid_periodo() {
		return this.id_periodo;
	}
    
	
	public Long getid_tipo_retencion_fuente_iva() {
		return this.id_tipo_retencion_fuente_iva;
	}
    
	
	public String getcodigo_estado_asiento_contable() {
		return this.codigo_estado_asiento_contable;
	}
    
	
	public String getnombre_periodo() {
		return this.nombre_periodo;
	}
    
	
	public String getnombre_tipo_retencion_fuente_iva() {
		return this.nombre_tipo_retencion_fuente_iva;
	}
    
	
	public Double getporcentaje() {
		return this.porcentaje;
	}
    
	
	public Double getbase_imponible() {
		return this.base_imponible;
	}
    
	
	public Double getvalor() {
		return this.valor;
	}
    
	
	public String getnumero() {
		return this.numero;
	}
    
	
	public String getruc_benef() {
		return this.ruc_benef;
	}
	
    
	public void setid_empresa(Long newid_empresa)throws Exception
	{
		try {
			if(this.id_empresa!=newid_empresa) {
				if(newid_empresa==null) {
					//newid_empresa=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("GuardarIvasVentas:Valor nulo no permitido en columna id_empresa");
					}
				}

				this.id_empresa=newid_empresa;
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
						System.out.println("GuardarIvasVentas:Valor nulo no permitido en columna id_ejercicio");
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
						System.out.println("GuardarIvasVentas:Valor nulo no permitido en columna id_periodo");
					}
				}

				this.id_periodo=newid_periodo;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_tipo_retencion_fuente_iva(Long newid_tipo_retencion_fuente_iva)throws Exception
	{
		try {
			if(this.id_tipo_retencion_fuente_iva!=newid_tipo_retencion_fuente_iva) {
				if(newid_tipo_retencion_fuente_iva==null) {
					//newid_tipo_retencion_fuente_iva=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("GuardarIvasVentas:Valor nulo no permitido en columna id_tipo_retencion_fuente_iva");
					}
				}

				this.id_tipo_retencion_fuente_iva=newid_tipo_retencion_fuente_iva;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setcodigo_estado_asiento_contable(String newcodigo_estado_asiento_contable)throws Exception
	{
		try {
			if(this.codigo_estado_asiento_contable!=newcodigo_estado_asiento_contable) {
				if(newcodigo_estado_asiento_contable==null) {
					//newcodigo_estado_asiento_contable="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("GuardarIvasVentas:Valor nulo no permitido en columna codigo_estado_asiento_contable");
					}
				}

				if(newcodigo_estado_asiento_contable!=null&&newcodigo_estado_asiento_contable.length()>50) {
					newcodigo_estado_asiento_contable=newcodigo_estado_asiento_contable.substring(0,48);
					System.out.println("GuardarIvasVentas:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=50 en columna codigo_estado_asiento_contable");
				}

				this.codigo_estado_asiento_contable=newcodigo_estado_asiento_contable;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setnombre_periodo(String newnombre_periodo)throws Exception
	{
		try {
			if(this.nombre_periodo!=newnombre_periodo) {
				if(newnombre_periodo==null) {
					//newnombre_periodo="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("GuardarIvasVentas:Valor nulo no permitido en columna nombre_periodo");
					}
				}

				if(newnombre_periodo!=null&&newnombre_periodo.length()>50) {
					newnombre_periodo=newnombre_periodo.substring(0,48);
					System.out.println("GuardarIvasVentas:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=50 en columna nombre_periodo");
				}

				this.nombre_periodo=newnombre_periodo;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setnombre_tipo_retencion_fuente_iva(String newnombre_tipo_retencion_fuente_iva)throws Exception
	{
		try {
			if(this.nombre_tipo_retencion_fuente_iva!=newnombre_tipo_retencion_fuente_iva) {
				if(newnombre_tipo_retencion_fuente_iva==null) {
					//newnombre_tipo_retencion_fuente_iva="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("GuardarIvasVentas:Valor nulo no permitido en columna nombre_tipo_retencion_fuente_iva");
					}
				}

				if(newnombre_tipo_retencion_fuente_iva!=null&&newnombre_tipo_retencion_fuente_iva.length()>150) {
					newnombre_tipo_retencion_fuente_iva=newnombre_tipo_retencion_fuente_iva.substring(0,148);
					System.out.println("GuardarIvasVentas:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=150 en columna nombre_tipo_retencion_fuente_iva");
				}

				this.nombre_tipo_retencion_fuente_iva=newnombre_tipo_retencion_fuente_iva;
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
						System.out.println("GuardarIvasVentas:Valor nulo no permitido en columna porcentaje");
					}
				}

				this.porcentaje=newporcentaje;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setbase_imponible(Double newbase_imponible)throws Exception
	{
		try {
			if(this.base_imponible!=newbase_imponible) {
				if(newbase_imponible==null) {
					//newbase_imponible=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("GuardarIvasVentas:Valor nulo no permitido en columna base_imponible");
					}
				}

				this.base_imponible=newbase_imponible;
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
						System.out.println("GuardarIvasVentas:Valor nulo no permitido en columna valor");
					}
				}

				this.valor=newvalor;
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
						System.out.println("GuardarIvasVentas:Valor nulo no permitido en columna numero");
					}
				}

				if(newnumero!=null&&newnumero.length()>50) {
					newnumero=newnumero.substring(0,48);
					System.out.println("GuardarIvasVentas:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=50 en columna numero");
				}

				this.numero=newnumero;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setruc_benef(String newruc_benef)throws Exception
	{
		try {
			if(this.ruc_benef!=newruc_benef) {
				if(newruc_benef==null) {
					//newruc_benef="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("GuardarIvasVentas:Valor nulo no permitido en columna ruc_benef");
					}
				}

				if(newruc_benef!=null&&newruc_benef.length()>15) {
					newruc_benef=newruc_benef.substring(0,13);
					System.out.println("GuardarIvasVentas:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=15 en columna ruc_benef");
				}

				this.ruc_benef=newruc_benef;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	
	public Empresa getEmpresa() {
		return this.empresa;
	}

	public Ejercicio getEjercicio() {
		return this.ejercicio;
	}

	public Periodo getPeriodo() {
		return this.periodo;
	}

	public TipoRetencion getTipoRetencionFuenteIva() {
		return this.tiporetencionfuenteiva;
	}

	
	
	public String getempresa_descripcion() {
		return this.empresa_descripcion;
	}

	public String getejercicio_descripcion() {
		return this.ejercicio_descripcion;
	}

	public String getperiodo_descripcion() {
		return this.periodo_descripcion;
	}

	public String gettiporetencionfuenteiva_descripcion() {
		return this.tiporetencionfuenteiva_descripcion;
	}

	
	
	public  void  setEmpresa(Empresa empresa) {
		try {
			this.empresa=empresa;
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


	public  void  setTipoRetencionFuenteIva(TipoRetencion tiporetencionfuenteiva) {
		try {
			this.tiporetencionfuenteiva=tiporetencionfuenteiva;
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


	public  void  settiporetencionfuenteiva_descripcion(String tiporetencionfuenteiva_descripcion) {
		try {
			this.tiporetencionfuenteiva_descripcion=tiporetencionfuenteiva_descripcion;
		} catch(Exception e) {
			;
		}
	}


	
	
	
	
	
	/*PARA REPORTES*/
	String id_empresa_descripcion="";String id_ejercicio_descripcion="";String id_periodo_descripcion="";String id_tipo_retencion_fuente_iva_descripcion="";
	
	
	public String getid_empresa_descripcion() {
		return id_empresa_descripcion;
	}
	public String getid_ejercicio_descripcion() {
		return id_ejercicio_descripcion;
	}
	public String getid_periodo_descripcion() {
		return id_periodo_descripcion;
	}
	public String getid_tipo_retencion_fuente_iva_descripcion() {
		return id_tipo_retencion_fuente_iva_descripcion;
	}
	
	
	public void setid_empresa_descripcion(String newid_empresa_descripcion)throws Exception {
		try {
			this.id_empresa_descripcion=newid_empresa_descripcion;
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
	public void setid_tipo_retencion_fuente_iva_descripcion(String newid_tipo_retencion_fuente_iva_descripcion)throws Exception {
		try {
			this.id_tipo_retencion_fuente_iva_descripcion=newid_tipo_retencion_fuente_iva_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	
	public void inicializarVariablesParaReporte() {
		this.id_empresa_descripcion="";this.id_ejercicio_descripcion="";this.id_periodo_descripcion="";this.id_tipo_retencion_fuente_iva_descripcion="";
	}
	
	
	
	
	
	
	/*PARA REPORTES FIN*/		
}

