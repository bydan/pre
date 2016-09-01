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
package com.bydan.erp.nomina.business.entity.report;

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
//import com.bydan.erp.nomina.util.AnticiposConstantesFunciones;
import com.bydan.erp.nomina.util.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.nomina.util.*;

import com.bydan.erp.nomina.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.nomina.business.entity.*;




@SuppressWarnings("unused")
public class Anticipos extends AnticiposAdditional implements Serializable ,Cloneable {//AnticiposAdditional,GeneralEntity
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
	
	private Anticipos anticiposOriginal;
	
	private Map<String, Object> mapAnticipos;
			
	public Map<String, Object> getMapAnticipos() {
		return mapAnticipos;
	}

	public void setMapAnticipos(Map<String, Object> mapAnticipos) {
		this.mapAnticipos = mapAnticipos;
	}
	
	public void inicializarMapAnticipos() {
		this.mapAnticipos = new HashMap<String,Object>();
	}
	
	public void setMapAnticiposValue(String sKey,Object oValue) {
		this.mapAnticipos.put(sKey, oValue);
	}
	
	public Object getMapAnticiposValue(String sKey) {
		return this.mapAnticipos.get(sKey);
	}
	
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_empresa;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_tipo_contrato;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=50,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	//@Pattern(regex=AnticiposConstantesFunciones.SREGEXCODIGO,message=AnticiposConstantesFunciones.SMENSAJEREGEXCODIGO)
	private String codigo;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Date fecha_desde;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Date fecha_hasta;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=50,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	//@Pattern(regex=AnticiposConstantesFunciones.SREGEXCODIGO_CARGO,message=AnticiposConstantesFunciones.SMENSAJEREGEXCODIGO_CARGO)
	private String codigo_cargo;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=100,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	//@Pattern(regex=AnticiposConstantesFunciones.SREGEXNOMBRE_ESTRUCTURA,message=AnticiposConstantesFunciones.SMENSAJEREGEXNOMBRE_ESTRUCTURA)
	private String nombre_estructura;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=50,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	//@Pattern(regex=AnticiposConstantesFunciones.SREGEXCODIGO_DATO,message=AnticiposConstantesFunciones.SMENSAJEREGEXCODIGO_DATO)
	private String codigo_dato;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=200,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	//@Pattern(regex=AnticiposConstantesFunciones.SREGEXNOMBRE_COMPLETO,message=AnticiposConstantesFunciones.SMENSAJEREGEXNOMBRE_COMPLETO)
	private String nombre_completo;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double sueldo;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Date fecha;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double valor;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double valor_adicional;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double valor_prestamo;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double total;
			
	
	public Empresa empresa;
	public TipoContrato tipocontrato;
	
	
	private String empresa_descripcion;
	private String tipocontrato_descripcion;
	
	
		
	public Anticipos () throws Exception {
		super();		
		
		this.id=0L;
		
		
		this.versionRow=new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());//new Date();
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		this.sType="NONE";
		
		this.anticiposOriginal=this;
		
 		this.id_empresa=-1L;
 		this.id_tipo_contrato=-1L;
 		this.codigo="";
 		this.fecha_desde=new Date();
 		this.fecha_hasta=new Date();
 		this.codigo_cargo="";
 		this.nombre_estructura="";
 		this.codigo_dato="";
 		this.nombre_completo="";
 		this.sueldo=0.0;
 		this.fecha=new Date();
 		this.valor=0.0;
 		this.valor_adicional=0.0;
 		this.valor_prestamo=0.0;
 		this.total=0.0;
		
		
		this.empresa=null;
		this.tipocontrato=null;
		
		
		this.empresa_descripcion="";
		this.tipocontrato_descripcion="";
		
		
		
			
		
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
    //PARA REPORTES
	public Anticipos (Long id,Date versionRow,String codigo_cargo,String nombre_estructura,String codigo_dato,String nombre_completo,Double sueldo,Date fecha,Double valor,Double valor_adicional,Double valor_prestamo,Double total) throws Exception {
		super();		
		
		this.id=id;
		this.versionRow=versionRow;
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.anticiposOriginal=this;
		
 		this.codigo_cargo=codigo_cargo;
 		this.nombre_estructura=nombre_estructura;
 		this.codigo_dato=codigo_dato;
 		this.nombre_completo=nombre_completo;
 		this.sueldo=sueldo;
 		this.fecha=fecha;
 		this.valor=valor;
 		this.valor_adicional=valor_adicional;
 		this.valor_prestamo=valor_prestamo;
 		this.total=total;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	 //PARA REPORTES
	public Anticipos (String codigo_cargo,String nombre_estructura,String codigo_dato,String nombre_completo,Double sueldo,Date fecha,Double valor,Double valor_adicional,Double valor_prestamo,Double total) throws Exception {
		super();		
		
		this.id=0L;
		this.versionRow=new Date();
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.anticiposOriginal=this;
		
 		this.codigo_cargo=codigo_cargo;
 		this.nombre_estructura=nombre_estructura;
 		this.codigo_dato=codigo_dato;
 		this.nombre_completo=nombre_completo;
 		this.sueldo=sueldo;
 		this.fecha=fecha;
 		this.valor=valor;
 		this.valor_adicional=valor_adicional;
 		this.valor_prestamo=valor_prestamo;
 		this.total=total;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	
	public Anticipos getAnticiposOriginal() {
		return this.anticiposOriginal;
	}
	
	public void setAnticiposOriginal(Anticipos anticipos) {
		try {
			this.anticiposOriginal=anticipos;
		} catch(Exception e) {
			;
		}
	}
	
	
	protected AnticiposAdditional anticiposAdditional=null;
	
	public AnticiposAdditional getAnticiposAdditional() {
		return this.anticiposAdditional;
	}
	
	public void setAnticiposAdditional(AnticiposAdditional anticiposAdditional) {
		try {
			this.anticiposAdditional=anticiposAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
    
	
	public Long getid_empresa() {
		return this.id_empresa;
	}
    
	
	public Long getid_tipo_contrato() {
		return this.id_tipo_contrato;
	}
    
	
	public String getcodigo() {
		return this.codigo;
	}
    
	
	public Date getfecha_desde() {
		return this.fecha_desde;
	}
    
	
	public Date getfecha_hasta() {
		return this.fecha_hasta;
	}
    
	
	public String getcodigo_cargo() {
		return this.codigo_cargo;
	}
    
	
	public String getnombre_estructura() {
		return this.nombre_estructura;
	}
    
	
	public String getcodigo_dato() {
		return this.codigo_dato;
	}
    
	
	public String getnombre_completo() {
		return this.nombre_completo;
	}
    
	
	public Double getsueldo() {
		return this.sueldo;
	}
    
	
	public Date getfecha() {
		return this.fecha;
	}
    
	
	public Double getvalor() {
		return this.valor;
	}
    
	
	public Double getvalor_adicional() {
		return this.valor_adicional;
	}
    
	
	public Double getvalor_prestamo() {
		return this.valor_prestamo;
	}
    
	
	public Double gettotal() {
		return this.total;
	}
	
    
	public void setid_empresa(Long newid_empresa)throws Exception
	{
		try {
			if(this.id_empresa!=newid_empresa) {
				if(newid_empresa==null) {
					//newid_empresa=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("Anticipos:Valor nulo no permitido en columna id_empresa");
					}
				}

				this.id_empresa=newid_empresa;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_tipo_contrato(Long newid_tipo_contrato)throws Exception
	{
		try {
			if(this.id_tipo_contrato!=newid_tipo_contrato) {
				if(newid_tipo_contrato==null) {
					//newid_tipo_contrato=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("Anticipos:Valor nulo no permitido en columna id_tipo_contrato");
					}
				}

				this.id_tipo_contrato=newid_tipo_contrato;
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
						System.out.println("Anticipos:Valor nulo no permitido en columna codigo");
					}
				}

				if(newcodigo!=null&&newcodigo.length()>50) {
					newcodigo=newcodigo.substring(0,48);
					System.out.println("Anticipos:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=50 en columna codigo");
				}

				this.codigo=newcodigo;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setfecha_desde(Date newfecha_desde)throws Exception
	{
		try {
			if(this.fecha_desde!=newfecha_desde) {
				if(newfecha_desde==null) {
					//newfecha_desde=new Date();
					if(Constantes.ISDEVELOPING) {
						System.out.println("Anticipos:Valor nulo no permitido en columna fecha_desde");
					}
				}

				this.fecha_desde=newfecha_desde;
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
						System.out.println("Anticipos:Valor nulo no permitido en columna fecha_hasta");
					}
				}

				this.fecha_hasta=newfecha_hasta;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setcodigo_cargo(String newcodigo_cargo)throws Exception
	{
		try {
			if(this.codigo_cargo!=newcodigo_cargo) {
				if(newcodigo_cargo==null) {
					//newcodigo_cargo="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("Anticipos:Valor nulo no permitido en columna codigo_cargo");
					}
				}

				if(newcodigo_cargo!=null&&newcodigo_cargo.length()>50) {
					newcodigo_cargo=newcodigo_cargo.substring(0,48);
					System.out.println("Anticipos:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=50 en columna codigo_cargo");
				}

				this.codigo_cargo=newcodigo_cargo;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setnombre_estructura(String newnombre_estructura)throws Exception
	{
		try {
			if(this.nombre_estructura!=newnombre_estructura) {
				if(newnombre_estructura==null) {
					//newnombre_estructura="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("Anticipos:Valor nulo no permitido en columna nombre_estructura");
					}
				}

				if(newnombre_estructura!=null&&newnombre_estructura.length()>100) {
					newnombre_estructura=newnombre_estructura.substring(0,98);
					System.out.println("Anticipos:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=100 en columna nombre_estructura");
				}

				this.nombre_estructura=newnombre_estructura;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setcodigo_dato(String newcodigo_dato)throws Exception
	{
		try {
			if(this.codigo_dato!=newcodigo_dato) {
				if(newcodigo_dato==null) {
					//newcodigo_dato="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("Anticipos:Valor nulo no permitido en columna codigo_dato");
					}
				}

				if(newcodigo_dato!=null&&newcodigo_dato.length()>50) {
					newcodigo_dato=newcodigo_dato.substring(0,48);
					System.out.println("Anticipos:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=50 en columna codigo_dato");
				}

				this.codigo_dato=newcodigo_dato;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setnombre_completo(String newnombre_completo)throws Exception
	{
		try {
			if(this.nombre_completo!=newnombre_completo) {
				if(newnombre_completo==null) {
					//newnombre_completo="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("Anticipos:Valor nulo no permitido en columna nombre_completo");
					}
				}

				if(newnombre_completo!=null&&newnombre_completo.length()>200) {
					newnombre_completo=newnombre_completo.substring(0,198);
					System.out.println("Anticipos:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=200 en columna nombre_completo");
				}

				this.nombre_completo=newnombre_completo;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setsueldo(Double newsueldo)throws Exception
	{
		try {
			if(this.sueldo!=newsueldo) {
				if(newsueldo==null) {
					//newsueldo=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("Anticipos:Valor nulo no permitido en columna sueldo");
					}
				}

				this.sueldo=newsueldo;
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
						System.out.println("Anticipos:Valor nulo no permitido en columna fecha");
					}
				}

				this.fecha=newfecha;
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
						System.out.println("Anticipos:Valor nulo no permitido en columna valor");
					}
				}

				this.valor=newvalor;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setvalor_adicional(Double newvalor_adicional)throws Exception
	{
		try {
			if(this.valor_adicional!=newvalor_adicional) {
				if(newvalor_adicional==null) {
					//newvalor_adicional=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("Anticipos:Valor nulo no permitido en columna valor_adicional");
					}
				}

				this.valor_adicional=newvalor_adicional;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setvalor_prestamo(Double newvalor_prestamo)throws Exception
	{
		try {
			if(this.valor_prestamo!=newvalor_prestamo) {
				if(newvalor_prestamo==null) {
					//newvalor_prestamo=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("Anticipos:Valor nulo no permitido en columna valor_prestamo");
					}
				}

				this.valor_prestamo=newvalor_prestamo;
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
						System.out.println("Anticipos:Valor nulo no permitido en columna total");
					}
				}

				this.total=newtotal;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	
	public Empresa getEmpresa() {
		return this.empresa;
	}

	public TipoContrato getTipoContrato() {
		return this.tipocontrato;
	}

	
	
	public String getempresa_descripcion() {
		return this.empresa_descripcion;
	}

	public String gettipocontrato_descripcion() {
		return this.tipocontrato_descripcion;
	}

	
	
	public  void  setEmpresa(Empresa empresa) {
		try {
			this.empresa=empresa;
		} catch(Exception e) {
			;
		}
	}


	public  void  setTipoContrato(TipoContrato tipocontrato) {
		try {
			this.tipocontrato=tipocontrato;
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


	public  void  settipocontrato_descripcion(String tipocontrato_descripcion) {
		try {
			this.tipocontrato_descripcion=tipocontrato_descripcion;
		} catch(Exception e) {
			;
		}
	}


	
	
	
	
	
	/*PARA REPORTES*/
	String id_empresa_descripcion="";String id_tipo_contrato_descripcion="";
	
	
	public String getid_empresa_descripcion() {
		return id_empresa_descripcion;
	}
	public String getid_tipo_contrato_descripcion() {
		return id_tipo_contrato_descripcion;
	}
	
	
	public void setid_empresa_descripcion(String newid_empresa_descripcion)throws Exception {
		try {
			this.id_empresa_descripcion=newid_empresa_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_tipo_contrato_descripcion(String newid_tipo_contrato_descripcion)throws Exception {
		try {
			this.id_tipo_contrato_descripcion=newid_tipo_contrato_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	
	public void inicializarVariablesParaReporte() {
		this.id_empresa_descripcion="";this.id_tipo_contrato_descripcion="";
	}
	
	
	
	
	
	
	/*PARA REPORTES FIN*/		
}

