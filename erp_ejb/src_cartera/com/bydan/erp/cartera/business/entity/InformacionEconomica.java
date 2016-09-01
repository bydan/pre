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
//import com.bydan.erp.cartera.util.InformacionEconomicaConstantesFunciones;
import com.bydan.erp.cartera.util.*;









@SuppressWarnings("unused")
public class InformacionEconomica extends InformacionEconomicaAdditional implements Serializable ,Cloneable {//InformacionEconomicaAdditional,GeneralEntity
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
	
	private InformacionEconomica informacioneconomicaOriginal;
	
	private Map<String, Object> mapInformacionEconomica;
			
	public Map<String, Object> getMapInformacionEconomica() {
		return mapInformacionEconomica;
	}

	public void setMapInformacionEconomica(Map<String, Object> mapInformacionEconomica) {
		this.mapInformacionEconomica = mapInformacionEconomica;
	}
	
	public void inicializarMapInformacionEconomica() {
		this.mapInformacionEconomica = new HashMap<String,Object>();
	}
	
	public void setMapInformacionEconomicaValue(String sKey,Object oValue) {
		this.mapInformacionEconomica.put(sKey, oValue);
	}
	
	public Object getMapInformacionEconomicaValue(String sKey) {
		return this.mapInformacionEconomica.get(sKey);
	}
	
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long idcliente;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long idvalorclientevinculacion;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=50,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=InformacionEconomicaConstantesFunciones.SREGEXCODIGOACTUALIZACION,message=InformacionEconomicaConstantesFunciones.SMENSAJEREGEXCODIGOACTUALIZACION)
	private String codigoactualizacion;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=50,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=InformacionEconomicaConstantesFunciones.SREGEXCODIGODESTINOFINANCIERO,message=InformacionEconomicaConstantesFunciones.SMENSAJEREGEXCODIGODESTINOFINANCIERO)
	private String codigodestinofinanciero;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=50,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=InformacionEconomicaConstantesFunciones.SREGEXORIGENRECURSOS,message=InformacionEconomicaConstantesFunciones.SMENSAJEREGEXORIGENRECURSOS)
	private String origenrecursos;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=50,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=InformacionEconomicaConstantesFunciones.SREGEXCUASAVINCULACION,message=InformacionEconomicaConstantesFunciones.SMENSAJEREGEXCUASAVINCULACION)
	private String cuasavinculacion;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=50,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=InformacionEconomicaConstantesFunciones.SREGEXSECTORIZACION,message=InformacionEconomicaConstantesFunciones.SMENSAJEREGEXSECTORIZACION)
	private String sectorizacion;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Boolean esactivo;
			
	
	public Cliente cliente;
	public TipoVinculacion tipovinculacion;
	
	
	private String cliente_descripcion;
	private String tipovinculacion_descripcion;
	
	
		
	public InformacionEconomica () throws Exception {
		super();		
		
		this.id=0L;
		
		
		this.versionRow=new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());//new Date();
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		this.sType="NONE";
		
		this.informacioneconomicaOriginal=this;
		
 		this.idcliente=-1L;
 		this.idvalorclientevinculacion=-1L;
 		this.codigoactualizacion="";
 		this.codigodestinofinanciero="";
 		this.origenrecursos="";
 		this.cuasavinculacion="";
 		this.sectorizacion="";
 		this.esactivo=false;
		
		
		this.cliente=null;
		this.tipovinculacion=null;
		
		
		this.cliente_descripcion="";
		this.tipovinculacion_descripcion="";
		
		
		
			
		
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
    //PARA REPORTES
	public InformacionEconomica (Long id,Date versionRow,Long idcliente,Long idvalorclientevinculacion,String codigoactualizacion,String codigodestinofinanciero,String origenrecursos,String cuasavinculacion,String sectorizacion,Boolean esactivo) throws Exception {
		super();		
		
		this.id=id;
		this.versionRow=versionRow;
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.informacioneconomicaOriginal=this;
		
 		this.idcliente=idcliente;
 		this.idvalorclientevinculacion=idvalorclientevinculacion;
 		this.codigoactualizacion=codigoactualizacion;
 		this.codigodestinofinanciero=codigodestinofinanciero;
 		this.origenrecursos=origenrecursos;
 		this.cuasavinculacion=cuasavinculacion;
 		this.sectorizacion=sectorizacion;
 		this.esactivo=esactivo;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	 //PARA REPORTES
	public InformacionEconomica (Long idcliente,Long idvalorclientevinculacion,String codigoactualizacion,String codigodestinofinanciero,String origenrecursos,String cuasavinculacion,String sectorizacion,Boolean esactivo) throws Exception {
		super();		
		
		this.id=0L;
		this.versionRow=new Date();
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.informacioneconomicaOriginal=this;
		
 		this.idcliente=idcliente;
 		this.idvalorclientevinculacion=idvalorclientevinculacion;
 		this.codigoactualizacion=codigoactualizacion;
 		this.codigodestinofinanciero=codigodestinofinanciero;
 		this.origenrecursos=origenrecursos;
 		this.cuasavinculacion=cuasavinculacion;
 		this.sectorizacion=sectorizacion;
 		this.esactivo=esactivo;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	public boolean equals(Object object) {
		boolean equal=false;
		InformacionEconomica informacioneconomicaLocal=null;
		
		if(object!=null) {
			informacioneconomicaLocal=(InformacionEconomica)object;
			
			if(informacioneconomicaLocal!=null) {
				if(this.getId()!=null && informacioneconomicaLocal.getId()!=null) {
					if(this.getId().equals(informacioneconomicaLocal.getId())) {
						equal=true;
					}
				}
			}
		}
		
		return equal;
	}
	
	public String toString() {
		String sDetalle="";
		
		if(!InformacionEconomicaConstantesFunciones.CON_DESCRIPCION_DETALLADO) {
        	sDetalle=InformacionEconomicaConstantesFunciones.getInformacionEconomicaDescripcion(this);
		} else {
			sDetalle=InformacionEconomicaConstantesFunciones.getInformacionEconomicaDescripcionDetallado(this);
		}
		
		return sDetalle;
    }
	
	public InformacionEconomica getInformacionEconomicaOriginal() {
		return this.informacioneconomicaOriginal;
	}
	
	public void setInformacionEconomicaOriginal(InformacionEconomica informacioneconomica) {
		try {
			this.informacioneconomicaOriginal=informacioneconomica;
		} catch(Exception e) {
			;
		}
	}
	
	
	protected InformacionEconomicaAdditional informacioneconomicaAdditional=null;
	
	public InformacionEconomicaAdditional getInformacionEconomicaAdditional() {
		return this.informacioneconomicaAdditional;
	}
	
	public void setInformacionEconomicaAdditional(InformacionEconomicaAdditional informacioneconomicaAdditional) {
		try {
			this.informacioneconomicaAdditional=informacioneconomicaAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
    
	
	public Long getidcliente() {
		return this.idcliente;
	}
    
	
	public Long getidvalorclientevinculacion() {
		return this.idvalorclientevinculacion;
	}
    
	
	public String getcodigoactualizacion() {
		return this.codigoactualizacion;
	}
    
	
	public String getcodigodestinofinanciero() {
		return this.codigodestinofinanciero;
	}
    
	
	public String getorigenrecursos() {
		return this.origenrecursos;
	}
    
	
	public String getcuasavinculacion() {
		return this.cuasavinculacion;
	}
    
	
	public String getsectorizacion() {
		return this.sectorizacion;
	}
    
	
	public Boolean getesactivo() {
		return this.esactivo;
	}
	
    
	public void setidcliente(Long newidcliente)throws Exception
	{
		try {
			if(this.idcliente!=newidcliente) {
				if(newidcliente==null) {
					//newidcliente=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("InformacionEconomica:Valor nulo no permitido en columna idcliente");
					}
				}

				this.idcliente=newidcliente;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setidvalorclientevinculacion(Long newidvalorclientevinculacion)throws Exception
	{
		try {
			if(this.idvalorclientevinculacion!=newidvalorclientevinculacion) {
				if(newidvalorclientevinculacion==null) {
					//newidvalorclientevinculacion=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("InformacionEconomica:Valor nulo no permitido en columna idvalorclientevinculacion");
					}
				}

				this.idvalorclientevinculacion=newidvalorclientevinculacion;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setcodigoactualizacion(String newcodigoactualizacion)throws Exception
	{
		try {
			if(this.codigoactualizacion!=newcodigoactualizacion) {
				if(newcodigoactualizacion==null) {
					//newcodigoactualizacion="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("InformacionEconomica:Valor nulo no permitido en columna codigoactualizacion");
					}
				}

				if(newcodigoactualizacion!=null&&newcodigoactualizacion.length()>50) {
					newcodigoactualizacion=newcodigoactualizacion.substring(0,48);
					System.out.println("InformacionEconomica:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=50 en columna codigoactualizacion");
				}

				this.codigoactualizacion=newcodigoactualizacion;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setcodigodestinofinanciero(String newcodigodestinofinanciero)throws Exception
	{
		try {
			if(this.codigodestinofinanciero!=newcodigodestinofinanciero) {
				if(newcodigodestinofinanciero==null) {
					//newcodigodestinofinanciero="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("InformacionEconomica:Valor nulo no permitido en columna codigodestinofinanciero");
					}
				}

				if(newcodigodestinofinanciero!=null&&newcodigodestinofinanciero.length()>50) {
					newcodigodestinofinanciero=newcodigodestinofinanciero.substring(0,48);
					System.out.println("InformacionEconomica:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=50 en columna codigodestinofinanciero");
				}

				this.codigodestinofinanciero=newcodigodestinofinanciero;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setorigenrecursos(String neworigenrecursos)throws Exception
	{
		try {
			if(this.origenrecursos!=neworigenrecursos) {
				if(neworigenrecursos==null) {
					//neworigenrecursos="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("InformacionEconomica:Valor nulo no permitido en columna origenrecursos");
					}
				}

				if(neworigenrecursos!=null&&neworigenrecursos.length()>50) {
					neworigenrecursos=neworigenrecursos.substring(0,48);
					System.out.println("InformacionEconomica:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=50 en columna origenrecursos");
				}

				this.origenrecursos=neworigenrecursos;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setcuasavinculacion(String newcuasavinculacion)throws Exception
	{
		try {
			if(this.cuasavinculacion!=newcuasavinculacion) {
				if(newcuasavinculacion==null) {
					//newcuasavinculacion="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("InformacionEconomica:Valor nulo no permitido en columna cuasavinculacion");
					}
				}

				if(newcuasavinculacion!=null&&newcuasavinculacion.length()>50) {
					newcuasavinculacion=newcuasavinculacion.substring(0,48);
					System.out.println("InformacionEconomica:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=50 en columna cuasavinculacion");
				}

				this.cuasavinculacion=newcuasavinculacion;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setsectorizacion(String newsectorizacion)throws Exception
	{
		try {
			if(this.sectorizacion!=newsectorizacion) {
				if(newsectorizacion==null) {
					//newsectorizacion="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("InformacionEconomica:Valor nulo no permitido en columna sectorizacion");
					}
				}

				if(newsectorizacion!=null&&newsectorizacion.length()>50) {
					newsectorizacion=newsectorizacion.substring(0,48);
					System.out.println("InformacionEconomica:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=50 en columna sectorizacion");
				}

				this.sectorizacion=newsectorizacion;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setesactivo(Boolean newesactivo)throws Exception
	{
		try {
			if(this.esactivo!=newesactivo) {
				if(newesactivo==null) {
					//newesactivo=false;
					if(Constantes.ISDEVELOPING) {
						System.out.println("InformacionEconomica:Valor nulo no permitido en columna esactivo");
					}
				}

				this.esactivo=newesactivo;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	
	public Cliente getCliente() {
		return this.cliente;
	}

	public TipoVinculacion getTipoVinculacion() {
		return this.tipovinculacion;
	}

	
	
	public String getcliente_descripcion() {
		return this.cliente_descripcion;
	}

	public String gettipovinculacion_descripcion() {
		return this.tipovinculacion_descripcion;
	}

	
	
	public  void  setCliente(Cliente cliente) {
		try {
			this.cliente=cliente;
		} catch(Exception e) {
			;
		}
	}


	public  void  setTipoVinculacion(TipoVinculacion tipovinculacion) {
		try {
			this.tipovinculacion=tipovinculacion;
		} catch(Exception e) {
			;
		}
	}


	
	
	public  void  setcliente_descripcion(String cliente_descripcion) {
		try {
			this.cliente_descripcion=cliente_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  settipovinculacion_descripcion(String tipovinculacion_descripcion) {
		try {
			this.tipovinculacion_descripcion=tipovinculacion_descripcion;
		} catch(Exception e) {
			;
		}
	}


	
	
	
	
	
	/*PARA REPORTES*/
	String idcliente_descripcion="";String idvalorclientevinculacion_descripcion="";String esactivo_descripcion="";
	
	
	public String getidcliente_descripcion() {
		return idcliente_descripcion;
	}
	public String getidvalorclientevinculacion_descripcion() {
		return idvalorclientevinculacion_descripcion;
	}
	public String getesactivo_descripcion() {
		return esactivo_descripcion;
	}
	
	
	public void setidcliente_descripcion(String newidcliente_descripcion)throws Exception {
		try {
			this.idcliente_descripcion=newidcliente_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setidvalorclientevinculacion_descripcion(String newidvalorclientevinculacion_descripcion)throws Exception {
		try {
			this.idvalorclientevinculacion_descripcion=newidvalorclientevinculacion_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setesactivo_descripcion(String newesactivo_descripcion)throws Exception {
		try {
			this.esactivo_descripcion=newesactivo_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	
	public void inicializarVariablesParaReporte() {
		this.idcliente_descripcion="";this.idvalorclientevinculacion_descripcion="";this.esactivo_descripcion="";
	}
	
	
	
	
	
	
	/*PARA REPORTES FIN*/		
}

