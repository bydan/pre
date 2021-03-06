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
//import com.bydan.erp.cartera.util.ConyugeConstantesFunciones;
import com.bydan.erp.cartera.util.*;









@SuppressWarnings("unused")
public class Conyuge extends ConyugeAdditional implements Serializable ,Cloneable {//ConyugeAdditional,GeneralEntity
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
	
	private Conyuge conyugeOriginal;
	
	private Map<String, Object> mapConyuge;
			
	public Map<String, Object> getMapConyuge() {
		return mapConyuge;
	}

	public void setMapConyuge(Map<String, Object> mapConyuge) {
		this.mapConyuge = mapConyuge;
	}
	
	public void inicializarMapConyuge() {
		this.mapConyuge = new HashMap<String,Object>();
	}
	
	public void setMapConyugeValue(String sKey,Object oValue) {
		this.mapConyuge.put(sKey, oValue);
	}
	
	public Object getMapConyugeValue(String sKey) {
		return this.mapConyuge.get(sKey);
	}
	
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_cliente;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long idvaloridentificacion;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=20,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=ConyugeConstantesFunciones.SREGEXIDENTIFICACION,message=ConyugeConstantesFunciones.SMENSAJEREGEXIDENTIFICACION)
	private String identificacion;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=100,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=ConyugeConstantesFunciones.SREGEXAPELLIDOPATERNO,message=ConyugeConstantesFunciones.SMENSAJEREGEXAPELLIDOPATERNO)
	private String apellidopaterno;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=100,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=ConyugeConstantesFunciones.SREGEXAPELLIDOMATERNO,message=ConyugeConstantesFunciones.SMENSAJEREGEXAPELLIDOMATERNO)
	private String apellidomaterno;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=100,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=ConyugeConstantesFunciones.SREGEXPRIMERNOMBRE,message=ConyugeConstantesFunciones.SMENSAJEREGEXPRIMERNOMBRE)
	private String primernombre;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=100,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=ConyugeConstantesFunciones.SREGEXSEGUNDONOMBRE,message=ConyugeConstantesFunciones.SMENSAJEREGEXSEGUNDONOMBRE)
	private String segundonombre;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=250,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=ConyugeConstantesFunciones.SREGEXNOMBRECORTO,message=ConyugeConstantesFunciones.SMENSAJEREGEXNOMBRECORTO)
	private String nombrecorto;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Boolean esactivo;
			
	
	public Cliente cliente;
	public TipoIdentificacion tipoidentificacion;
	
	
	private String cliente_descripcion;
	private String tipoidentificacion_descripcion;
	
	
		
	public Conyuge () throws Exception {
		super();		
		
		this.id=0L;
		this.idOriginal=0L;
		
		
		this.versionRow=new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());//new Date();
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		this.sType="NONE";
		
		this.conyugeOriginal=this;
		
 		this.idvaloridentificacion=-1L;
 		this.identificacion="";
 		this.apellidopaterno="";
 		this.apellidomaterno="";
 		this.primernombre="";
 		this.segundonombre="";
 		this.nombrecorto="";
 		this.esactivo=false;
		
		
		this.cliente=null;
		this.tipoidentificacion=null;
		
		
		this.cliente_descripcion="";
		this.tipoidentificacion_descripcion="";
		
		
		
			
		
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
    //PARA REPORTES
	public Conyuge (Long id,Date versionRow,Long idvaloridentificacion,String identificacion,String apellidopaterno,String apellidomaterno,String primernombre,String segundonombre,String nombrecorto,Boolean esactivo) throws Exception {
		super();		
		
		this.id=id;
		this.idOriginal=this.id;
		this.versionRow=versionRow;
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.conyugeOriginal=this;
		
 		this.idvaloridentificacion=idvaloridentificacion;
 		this.identificacion=identificacion;
 		this.apellidopaterno=apellidopaterno;
 		this.apellidomaterno=apellidomaterno;
 		this.primernombre=primernombre;
 		this.segundonombre=segundonombre;
 		this.nombrecorto=nombrecorto;
 		this.esactivo=esactivo;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	 //PARA REPORTES
	public Conyuge (Long idvaloridentificacion,String identificacion,String apellidopaterno,String apellidomaterno,String primernombre,String segundonombre,String nombrecorto,Boolean esactivo) throws Exception {
		super();		
		
		this.id=0L;
		this.idOriginal=0L;
		this.versionRow=new Date();
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.conyugeOriginal=this;
		
 		
 		this.idvaloridentificacion=idvaloridentificacion;
 		this.identificacion=identificacion;
 		this.apellidopaterno=apellidopaterno;
 		this.apellidomaterno=apellidomaterno;
 		this.primernombre=primernombre;
 		this.segundonombre=segundonombre;
 		this.nombrecorto=nombrecorto;
 		this.esactivo=esactivo;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	public boolean equals(Object object) {
		boolean equal=false;
		Conyuge conyugeLocal=null;
		
		if(object!=null) {
			conyugeLocal=(Conyuge)object;
			
			if(conyugeLocal!=null) {
				if(this.getId()!=null && conyugeLocal.getId()!=null) {
					if(this.getId().equals(conyugeLocal.getId())) {
						equal=true;
					}
				}
			}
		}
		
		return equal;
	}
	
	public String toString() {
		String sDetalle="";
		
		if(!ConyugeConstantesFunciones.CON_DESCRIPCION_DETALLADO) {
        	sDetalle=ConyugeConstantesFunciones.getConyugeDescripcion(this);
		} else {
			sDetalle=ConyugeConstantesFunciones.getConyugeDescripcionDetallado(this);
		}
		
		return sDetalle;
    }
	
	public Conyuge getConyugeOriginal() {
		return this.conyugeOriginal;
	}
	
	public void setConyugeOriginal(Conyuge conyuge) {
		try {
			this.conyugeOriginal=conyuge;
		} catch(Exception e) {
			;
		}
	}
	
	
	protected ConyugeAdditional conyugeAdditional=null;
	
	public ConyugeAdditional getConyugeAdditional() {
		return this.conyugeAdditional;
	}
	
	public void setConyugeAdditional(ConyugeAdditional conyugeAdditional) {
		try {
			this.conyugeAdditional=conyugeAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
    
	
	public Long getid_cliente() {
		this.id_cliente=this.id;

		return this.id_cliente;
	}
    
	
	public Long getidvaloridentificacion() {
		return this.idvaloridentificacion;
	}
    
	
	public String getidentificacion() {
		return this.identificacion;
	}
    
	
	public String getapellidopaterno() {
		return this.apellidopaterno;
	}
    
	
	public String getapellidomaterno() {
		return this.apellidomaterno;
	}
    
	
	public String getprimernombre() {
		return this.primernombre;
	}
    
	
	public String getsegundonombre() {
		return this.segundonombre;
	}
    
	
	public String getnombrecorto() {
		return this.nombrecorto;
	}
    
	
	public Boolean getesactivo() {
		return this.esactivo;
	}
	
    
	public void setid_cliente(Long newid_cliente)throws Exception
	{
		try {
			if(this.id_cliente!=null && this.id_cliente!=newid_cliente) {
				if(newid_cliente==null) {
					//newid_cliente=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("Conyuge:Valor nulo no permitido en columna id_cliente");
					}
				}

				this.id_cliente=newid_cliente;
				this.setIsChanged(true);
			} else if(this.id_cliente==null && newid_cliente!=null) {
				this.id_cliente=newid_cliente;
				this.id=newid_cliente;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setidvaloridentificacion(Long newidvaloridentificacion)throws Exception
	{
		try {
			if(this.idvaloridentificacion!=newidvaloridentificacion) {
				if(newidvaloridentificacion==null) {
					//newidvaloridentificacion=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("Conyuge:Valor nulo no permitido en columna idvaloridentificacion");
					}
				}

				this.idvaloridentificacion=newidvaloridentificacion;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setidentificacion(String newidentificacion)throws Exception
	{
		try {
			if(this.identificacion.trim()!=newidentificacion) {
				if(newidentificacion==null) {
					//newidentificacion="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("Conyuge:Valor nulo no permitido en columna identificacion");
					}
				}

				if(newidentificacion!=null&&newidentificacion.length()>20) {
					newidentificacion=newidentificacion.substring(0,18);
					System.out.println("Conyuge:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=20 en columna identificacion");
				}

				this.identificacion=newidentificacion;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setapellidopaterno(String newapellidopaterno)throws Exception
	{
		try {
			if(this.apellidopaterno!=newapellidopaterno) {
				if(newapellidopaterno==null) {
					//newapellidopaterno="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("Conyuge:Valor nulo no permitido en columna apellidopaterno");
					}
				}

				if(newapellidopaterno!=null&&newapellidopaterno.length()>100) {
					newapellidopaterno=newapellidopaterno.substring(0,98);
					System.out.println("Conyuge:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=100 en columna apellidopaterno");
				}

				this.apellidopaterno=newapellidopaterno;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setapellidomaterno(String newapellidomaterno)throws Exception
	{
		try {
			if(this.apellidomaterno!=newapellidomaterno) {
				if(newapellidomaterno==null) {
					//newapellidomaterno="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("Conyuge:Valor nulo no permitido en columna apellidomaterno");
					}
				}

				if(newapellidomaterno!=null&&newapellidomaterno.length()>100) {
					newapellidomaterno=newapellidomaterno.substring(0,98);
					System.out.println("Conyuge:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=100 en columna apellidomaterno");
				}

				this.apellidomaterno=newapellidomaterno;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setprimernombre(String newprimernombre)throws Exception
	{
		try {
			if(this.primernombre!=newprimernombre) {
				if(newprimernombre==null) {
					//newprimernombre="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("Conyuge:Valor nulo no permitido en columna primernombre");
					}
				}

				if(newprimernombre!=null&&newprimernombre.length()>100) {
					newprimernombre=newprimernombre.substring(0,98);
					System.out.println("Conyuge:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=100 en columna primernombre");
				}

				this.primernombre=newprimernombre;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setsegundonombre(String newsegundonombre)throws Exception
	{
		try {
			if(this.segundonombre!=newsegundonombre) {
				if(newsegundonombre==null) {
					//newsegundonombre="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("Conyuge:Valor nulo no permitido en columna segundonombre");
					}
				}

				if(newsegundonombre!=null&&newsegundonombre.length()>100) {
					newsegundonombre=newsegundonombre.substring(0,98);
					System.out.println("Conyuge:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=100 en columna segundonombre");
				}

				this.segundonombre=newsegundonombre;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setnombrecorto(String newnombrecorto)throws Exception
	{
		try {
			if(this.nombrecorto!=newnombrecorto) {
				if(newnombrecorto==null) {
					//newnombrecorto="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("Conyuge:Valor nulo no permitido en columna nombrecorto");
					}
				}

				if(newnombrecorto!=null&&newnombrecorto.length()>250) {
					newnombrecorto=newnombrecorto.substring(0,248);
					System.out.println("Conyuge:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=250 en columna nombrecorto");
				}

				this.nombrecorto=newnombrecorto;
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
						System.out.println("Conyuge:Valor nulo no permitido en columna esactivo");
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

	public TipoIdentificacion getTipoIdentificacion() {
		return this.tipoidentificacion;
	}

	
	
	public String getcliente_descripcion() {
		return this.cliente_descripcion;
	}

	public String gettipoidentificacion_descripcion() {
		return this.tipoidentificacion_descripcion;
	}

	
	
	public  void  setCliente(Cliente cliente) {
		try {
			this.cliente=cliente;
		} catch(Exception e) {
			;
		}
	}


	public  void  setTipoIdentificacion(TipoIdentificacion tipoidentificacion) {
		try {
			this.tipoidentificacion=tipoidentificacion;
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


	public  void  settipoidentificacion_descripcion(String tipoidentificacion_descripcion) {
		try {
			this.tipoidentificacion_descripcion=tipoidentificacion_descripcion;
		} catch(Exception e) {
			;
		}
	}


	
	
	
	
	
	/*PARA REPORTES*/
	String id_clienteCliente_descripcion="";String idvaloridentificacion_descripcion="";String esactivo_descripcion="";
	
	
	public String getid_clienteCliente_descripcion() {
		return id_clienteCliente_descripcion;
	}
	public String getidvaloridentificacion_descripcion() {
		return idvaloridentificacion_descripcion;
	}
	public String getesactivo_descripcion() {
		return esactivo_descripcion;
	}
	
	
	public void setid_clienteCliente_descripcion(String newid_clienteCliente_descripcion)throws Exception {
		try {
			this.id_clienteCliente_descripcion=newid_clienteCliente_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setidvaloridentificacion_descripcion(String newidvaloridentificacion_descripcion)throws Exception {
		try {
			this.idvaloridentificacion_descripcion=newidvaloridentificacion_descripcion;
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
		this.idvaloridentificacion_descripcion="";this.esactivo_descripcion="";
	}
	
	
	
	
	
	
	/*PARA REPORTES FIN*/		
}

