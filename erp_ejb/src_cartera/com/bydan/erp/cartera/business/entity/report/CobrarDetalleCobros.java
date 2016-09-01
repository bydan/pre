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
package com.bydan.erp.cartera.business.entity.report;

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
//import com.bydan.erp.cartera.util.CobrarDetalleCobrosConstantesFunciones;
import com.bydan.erp.cartera.util.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.cartera.util.*;
import com.bydan.erp.comisiones.util.*;

import com.bydan.erp.cartera.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;
import com.bydan.erp.comisiones.business.entity.*;




@SuppressWarnings("unused")
public class CobrarDetalleCobros extends CobrarDetalleCobrosAdditional implements Serializable ,Cloneable {//CobrarDetalleCobrosAdditional,GeneralEntity
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
	
	private CobrarDetalleCobros cobrardetallecobrosOriginal;
	
	private Map<String, Object> mapCobrarDetalleCobros;
			
	public Map<String, Object> getMapCobrarDetalleCobros() {
		return mapCobrarDetalleCobros;
	}

	public void setMapCobrarDetalleCobros(Map<String, Object> mapCobrarDetalleCobros) {
		this.mapCobrarDetalleCobros = mapCobrarDetalleCobros;
	}
	
	public void inicializarMapCobrarDetalleCobros() {
		this.mapCobrarDetalleCobros = new HashMap<String,Object>();
	}
	
	public void setMapCobrarDetalleCobrosValue(String sKey,Object oValue) {
		this.mapCobrarDetalleCobros.put(sKey, oValue);
	}
	
	public Object getMapCobrarDetalleCobrosValue(String sKey) {
		return this.mapCobrarDetalleCobros.get(sKey);
	}
	
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_empresa;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_pais;
	
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
	private Long id_grupo_cliente;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_vendedor;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Date fecha_emision;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Date fecha_emision_hasta;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=150,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	//@Pattern(regex=CobrarDetalleCobrosConstantesFunciones.SREGEXNOMBRE_VENDEDOR,message=CobrarDetalleCobrosConstantesFunciones.SMENSAJEREGEXNOMBRE_VENDEDOR)
	private String nombre_vendedor;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=50,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	//@Pattern(regex=CobrarDetalleCobrosConstantesFunciones.SREGEXCODIGO,message=CobrarDetalleCobrosConstantesFunciones.SMENSAJEREGEXCODIGO)
	private String codigo;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=100,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	//@Pattern(regex=CobrarDetalleCobrosConstantesFunciones.SREGEXNOMBRE,message=CobrarDetalleCobrosConstantesFunciones.SMENSAJEREGEXNOMBRE)
	private String nombre;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=100,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	//@Pattern(regex=CobrarDetalleCobrosConstantesFunciones.SREGEXAPELLIDO,message=CobrarDetalleCobrosConstantesFunciones.SMENSAJEREGEXAPELLIDO)
	private String apellido;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double total_facturas;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double total_abonos;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double total_facturas_actual;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double abonos_anterior;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double abonos_actual;
			
	
	public Empresa empresa;
	public Pais pais;
	public Ciudad ciudad;
	public Zona zona;
	public GrupoCliente grupocliente;
	public Vendedor vendedor;
	
	
	private String empresa_descripcion;
	private String pais_descripcion;
	private String ciudad_descripcion;
	private String zona_descripcion;
	private String grupocliente_descripcion;
	private String vendedor_descripcion;
	
	
		
	public CobrarDetalleCobros () throws Exception {
		super();		
		
		this.id=0L;
		
		
		this.versionRow=new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());//new Date();
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		this.sType="NONE";
		
		this.cobrardetallecobrosOriginal=this;
		
 		this.id_empresa=-1L;
 		this.id_pais=-1L;
 		this.id_ciudad=-1L;
 		this.id_zona=-1L;
 		this.id_grupo_cliente=-1L;
 		this.id_vendedor=-1L;
 		this.fecha_emision=new Date();
 		this.fecha_emision_hasta=new Date();
 		this.nombre_vendedor="";
 		this.codigo="";
 		this.nombre="";
 		this.apellido="";
 		this.total_facturas=0.0;
 		this.total_abonos=0.0;
 		this.total_facturas_actual=0.0;
 		this.abonos_anterior=0.0;
 		this.abonos_actual=0.0;
		
		
		this.empresa=null;
		this.pais=null;
		this.ciudad=null;
		this.zona=null;
		this.grupocliente=null;
		this.vendedor=null;
		
		
		this.empresa_descripcion="";
		this.pais_descripcion="";
		this.ciudad_descripcion="";
		this.zona_descripcion="";
		this.grupocliente_descripcion="";
		this.vendedor_descripcion="";
		
		
		
			
		
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
    //PARA REPORTES
	public CobrarDetalleCobros (Long id,Date versionRow,String nombre_vendedor,String codigo,String nombre,String apellido,Double total_facturas,Double total_abonos,Double total_facturas_actual,Double abonos_anterior,Double abonos_actual) throws Exception {
		super();		
		
		this.id=id;
		this.versionRow=versionRow;
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.cobrardetallecobrosOriginal=this;
		
 		this.nombre_vendedor=nombre_vendedor;
 		this.codigo=codigo;
 		this.nombre=nombre;
 		this.apellido=apellido;
 		this.total_facturas=total_facturas;
 		this.total_abonos=total_abonos;
 		this.total_facturas_actual=total_facturas_actual;
 		this.abonos_anterior=abonos_anterior;
 		this.abonos_actual=abonos_actual;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	 //PARA REPORTES
	public CobrarDetalleCobros (String nombre_vendedor,String codigo,String nombre,String apellido,Double total_facturas,Double total_abonos,Double total_facturas_actual,Double abonos_anterior,Double abonos_actual) throws Exception {
		super();		
		
		this.id=0L;
		this.versionRow=new Date();
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.cobrardetallecobrosOriginal=this;
		
 		this.nombre_vendedor=nombre_vendedor;
 		this.codigo=codigo;
 		this.nombre=nombre;
 		this.apellido=apellido;
 		this.total_facturas=total_facturas;
 		this.total_abonos=total_abonos;
 		this.total_facturas_actual=total_facturas_actual;
 		this.abonos_anterior=abonos_anterior;
 		this.abonos_actual=abonos_actual;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	
	public CobrarDetalleCobros getCobrarDetalleCobrosOriginal() {
		return this.cobrardetallecobrosOriginal;
	}
	
	public void setCobrarDetalleCobrosOriginal(CobrarDetalleCobros cobrardetallecobros) {
		try {
			this.cobrardetallecobrosOriginal=cobrardetallecobros;
		} catch(Exception e) {
			;
		}
	}
	
	
	protected CobrarDetalleCobrosAdditional cobrardetallecobrosAdditional=null;
	
	public CobrarDetalleCobrosAdditional getCobrarDetalleCobrosAdditional() {
		return this.cobrardetallecobrosAdditional;
	}
	
	public void setCobrarDetalleCobrosAdditional(CobrarDetalleCobrosAdditional cobrardetallecobrosAdditional) {
		try {
			this.cobrardetallecobrosAdditional=cobrardetallecobrosAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
    
	
	public Long getid_empresa() {
		return this.id_empresa;
	}
    
	
	public Long getid_pais() {
		return this.id_pais;
	}
    
	
	public Long getid_ciudad() {
		return this.id_ciudad;
	}
    
	
	public Long getid_zona() {
		return this.id_zona;
	}
    
	
	public Long getid_grupo_cliente() {
		return this.id_grupo_cliente;
	}
    
	
	public Long getid_vendedor() {
		return this.id_vendedor;
	}
    
	
	public Date getfecha_emision() {
		return this.fecha_emision;
	}
    
	
	public Date getfecha_emision_hasta() {
		return this.fecha_emision_hasta;
	}
    
	
	public String getnombre_vendedor() {
		return this.nombre_vendedor;
	}
    
	
	public String getcodigo() {
		return this.codigo;
	}
    
	
	public String getnombre() {
		return this.nombre;
	}
    
	
	public String getapellido() {
		return this.apellido;
	}
    
	
	public Double gettotal_facturas() {
		return this.total_facturas;
	}
    
	
	public Double gettotal_abonos() {
		return this.total_abonos;
	}
    
	
	public Double gettotal_facturas_actual() {
		return this.total_facturas_actual;
	}
    
	
	public Double getabonos_anterior() {
		return this.abonos_anterior;
	}
    
	
	public Double getabonos_actual() {
		return this.abonos_actual;
	}
	
    
	public void setid_empresa(Long newid_empresa)throws Exception
	{
		try {
			if(this.id_empresa!=newid_empresa) {
				if(newid_empresa==null) {
					//newid_empresa=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("CobrarDetalleCobros:Valor nulo no permitido en columna id_empresa");
					}
				}

				this.id_empresa=newid_empresa;
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
						System.out.println("CobrarDetalleCobros:Valor nulo no permitido en columna id_pais");
					}
				}

				this.id_pais=newid_pais;
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
						System.out.println("CobrarDetalleCobros:Valor nulo no permitido en columna id_ciudad");
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
						System.out.println("CobrarDetalleCobros:Valor nulo no permitido en columna id_zona");
					}
				}

				this.id_zona=newid_zona;
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
						System.out.println("CobrarDetalleCobros:Valor nulo no permitido en columna id_grupo_cliente");
					}
				}

				this.id_grupo_cliente=newid_grupo_cliente;
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
						System.out.println("CobrarDetalleCobros:Valor nulo no permitido en columna id_vendedor");
					}
				}

				this.id_vendedor=newid_vendedor;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setfecha_emision(Date newfecha_emision)throws Exception
	{
		try {
			if(this.fecha_emision!=newfecha_emision) {
				if(newfecha_emision==null) {
					//newfecha_emision=new Date();
					if(Constantes.ISDEVELOPING) {
						System.out.println("CobrarDetalleCobros:Valor nulo no permitido en columna fecha_emision");
					}
				}

				this.fecha_emision=newfecha_emision;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setfecha_emision_hasta(Date newfecha_emision_hasta)throws Exception
	{
		try {
			if(this.fecha_emision_hasta!=newfecha_emision_hasta) {
				if(newfecha_emision_hasta==null) {
					//newfecha_emision_hasta=new Date();
					if(Constantes.ISDEVELOPING) {
						System.out.println("CobrarDetalleCobros:Valor nulo no permitido en columna fecha_emision_hasta");
					}
				}

				this.fecha_emision_hasta=newfecha_emision_hasta;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setnombre_vendedor(String newnombre_vendedor)throws Exception
	{
		try {
			if(this.nombre_vendedor!=newnombre_vendedor) {
				if(newnombre_vendedor==null) {
					//newnombre_vendedor="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("CobrarDetalleCobros:Valor nulo no permitido en columna nombre_vendedor");
					}
				}

				if(newnombre_vendedor!=null&&newnombre_vendedor.length()>150) {
					newnombre_vendedor=newnombre_vendedor.substring(0,148);
					System.out.println("CobrarDetalleCobros:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=150 en columna nombre_vendedor");
				}

				this.nombre_vendedor=newnombre_vendedor;
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
						System.out.println("CobrarDetalleCobros:Valor nulo no permitido en columna codigo");
					}
				}

				if(newcodigo!=null&&newcodigo.length()>50) {
					newcodigo=newcodigo.substring(0,48);
					System.out.println("CobrarDetalleCobros:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=50 en columna codigo");
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
						System.out.println("CobrarDetalleCobros:Valor nulo no permitido en columna nombre");
					}
				}

				if(newnombre!=null&&newnombre.length()>100) {
					newnombre=newnombre.substring(0,98);
					System.out.println("CobrarDetalleCobros:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=100 en columna nombre");
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
						System.out.println("CobrarDetalleCobros:Valor nulo no permitido en columna apellido");
					}
				}

				if(newapellido!=null&&newapellido.length()>100) {
					newapellido=newapellido.substring(0,98);
					System.out.println("CobrarDetalleCobros:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=100 en columna apellido");
				}

				this.apellido=newapellido;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void settotal_facturas(Double newtotal_facturas)throws Exception
	{
		try {
			if(this.total_facturas!=newtotal_facturas) {
				if(newtotal_facturas==null) {
					//newtotal_facturas=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("CobrarDetalleCobros:Valor nulo no permitido en columna total_facturas");
					}
				}

				this.total_facturas=newtotal_facturas;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void settotal_abonos(Double newtotal_abonos)throws Exception
	{
		try {
			if(this.total_abonos!=newtotal_abonos) {
				if(newtotal_abonos==null) {
					//newtotal_abonos=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("CobrarDetalleCobros:Valor nulo no permitido en columna total_abonos");
					}
				}

				this.total_abonos=newtotal_abonos;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void settotal_facturas_actual(Double newtotal_facturas_actual)throws Exception
	{
		try {
			if(this.total_facturas_actual!=newtotal_facturas_actual) {
				if(newtotal_facturas_actual==null) {
					//newtotal_facturas_actual=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("CobrarDetalleCobros:Valor nulo no permitido en columna total_facturas_actual");
					}
				}

				this.total_facturas_actual=newtotal_facturas_actual;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setabonos_anterior(Double newabonos_anterior)throws Exception
	{
		try {
			if(this.abonos_anterior!=newabonos_anterior) {
				if(newabonos_anterior==null) {
					//newabonos_anterior=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("CobrarDetalleCobros:Valor nulo no permitido en columna abonos_anterior");
					}
				}

				this.abonos_anterior=newabonos_anterior;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setabonos_actual(Double newabonos_actual)throws Exception
	{
		try {
			if(this.abonos_actual!=newabonos_actual) {
				if(newabonos_actual==null) {
					//newabonos_actual=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("CobrarDetalleCobros:Valor nulo no permitido en columna abonos_actual");
					}
				}

				this.abonos_actual=newabonos_actual;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	
	public Empresa getEmpresa() {
		return this.empresa;
	}

	public Pais getPais() {
		return this.pais;
	}

	public Ciudad getCiudad() {
		return this.ciudad;
	}

	public Zona getZona() {
		return this.zona;
	}

	public GrupoCliente getGrupoCliente() {
		return this.grupocliente;
	}

	public Vendedor getVendedor() {
		return this.vendedor;
	}

	
	
	public String getempresa_descripcion() {
		return this.empresa_descripcion;
	}

	public String getpais_descripcion() {
		return this.pais_descripcion;
	}

	public String getciudad_descripcion() {
		return this.ciudad_descripcion;
	}

	public String getzona_descripcion() {
		return this.zona_descripcion;
	}

	public String getgrupocliente_descripcion() {
		return this.grupocliente_descripcion;
	}

	public String getvendedor_descripcion() {
		return this.vendedor_descripcion;
	}

	
	
	public  void  setEmpresa(Empresa empresa) {
		try {
			this.empresa=empresa;
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


	public  void  setGrupoCliente(GrupoCliente grupocliente) {
		try {
			this.grupocliente=grupocliente;
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


	
	
	public  void  setempresa_descripcion(String empresa_descripcion) {
		try {
			this.empresa_descripcion=empresa_descripcion;
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


	public  void  setgrupocliente_descripcion(String grupocliente_descripcion) {
		try {
			this.grupocliente_descripcion=grupocliente_descripcion;
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


	
	
	
	
	
	/*PARA REPORTES*/
	String id_empresa_descripcion="";String id_pais_descripcion="";String id_ciudad_descripcion="";String id_zona_descripcion="";String id_grupo_cliente_descripcion="";String id_vendedor_descripcion="";
	
	
	public String getid_empresa_descripcion() {
		return id_empresa_descripcion;
	}
	public String getid_pais_descripcion() {
		return id_pais_descripcion;
	}
	public String getid_ciudad_descripcion() {
		return id_ciudad_descripcion;
	}
	public String getid_zona_descripcion() {
		return id_zona_descripcion;
	}
	public String getid_grupo_cliente_descripcion() {
		return id_grupo_cliente_descripcion;
	}
	public String getid_vendedor_descripcion() {
		return id_vendedor_descripcion;
	}
	
	
	public void setid_empresa_descripcion(String newid_empresa_descripcion)throws Exception {
		try {
			this.id_empresa_descripcion=newid_empresa_descripcion;
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
	public void setid_grupo_cliente_descripcion(String newid_grupo_cliente_descripcion)throws Exception {
		try {
			this.id_grupo_cliente_descripcion=newid_grupo_cliente_descripcion;
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
	
	public void inicializarVariablesParaReporte() {
		this.id_empresa_descripcion="";this.id_pais_descripcion="";this.id_ciudad_descripcion="";this.id_zona_descripcion="";this.id_grupo_cliente_descripcion="";this.id_vendedor_descripcion="";
	}
	
	
	
	
	
	
	/*PARA REPORTES FIN*/		
}

