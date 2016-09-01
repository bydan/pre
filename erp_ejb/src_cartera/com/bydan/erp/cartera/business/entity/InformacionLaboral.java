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
//import com.bydan.erp.cartera.util.InformacionLaboralConstantesFunciones;
import com.bydan.erp.cartera.util.*;


import com.bydan.erp.seguridad.util.*;



import com.bydan.erp.seguridad.business.entity.*;




@SuppressWarnings("unused")
public class InformacionLaboral extends InformacionLaboralAdditional implements Serializable ,Cloneable {//InformacionLaboralAdditional,GeneralEntity
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
	
	private InformacionLaboral informacionlaboralOriginal;
	
	private Map<String, Object> mapInformacionLaboral;
			
	public Map<String, Object> getMapInformacionLaboral() {
		return mapInformacionLaboral;
	}

	public void setMapInformacionLaboral(Map<String, Object> mapInformacionLaboral) {
		this.mapInformacionLaboral = mapInformacionLaboral;
	}
	
	public void inicializarMapInformacionLaboral() {
		this.mapInformacionLaboral = new HashMap<String,Object>();
	}
	
	public void setMapInformacionLaboralValue(String sKey,Object oValue) {
		this.mapInformacionLaboral.put(sKey, oValue);
	}
	
	public Object getMapInformacionLaboralValue(String sKey) {
		return this.mapInformacionLaboral.get(sKey);
	}
	
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long idcliente;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long idvalorempresa;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long idvalorclienterelacionlaboral;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long idvalorclientearealaboral;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long idvalorclientecargolaboral;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_pais;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long idciudad;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=10,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONINT)
	private Integer tiempoa;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=10,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONINT)
	private Integer tiempom;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=100,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=InformacionLaboralConstantesFunciones.SREGEXNOMBREEMPRESA,message=InformacionLaboralConstantesFunciones.SMENSAJEREGEXNOMBREEMPRESA)
	private String nombreempresa;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=250,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=InformacionLaboralConstantesFunciones.SREGEXDIRECCION,message=InformacionLaboralConstantesFunciones.SMENSAJEREGEXDIRECCION)
	private String direccion;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=200,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=InformacionLaboralConstantesFunciones.SREGEXNOMBREREFERENCIA,message=InformacionLaboralConstantesFunciones.SMENSAJEREGEXNOMBREREFERENCIA)
	private String nombrereferencia;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=200,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=InformacionLaboralConstantesFunciones.SREGEXTELEFONO,message=InformacionLaboralConstantesFunciones.SMENSAJEREGEXTELEFONO)
	private String telefono;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=20,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=InformacionLaboralConstantesFunciones.SREGEXTELEFONOCODIGOAREA,message=InformacionLaboralConstantesFunciones.SMENSAJEREGEXTELEFONOCODIGOAREA)
	private String telefonocodigoarea;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=200,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=InformacionLaboralConstantesFunciones.SREGEXTELEFONOMOVIL,message=InformacionLaboralConstantesFunciones.SMENSAJEREGEXTELEFONOMOVIL)
	private String telefonomovil;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=200,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=InformacionLaboralConstantesFunciones.SREGEXEMAIL,message=InformacionLaboralConstantesFunciones.SMENSAJEREGEXEMAIL)
	private String email;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Boolean esactivo;
			
	
	public Cliente cliente;
	public TipoEmpresa tipoempresa;
	public TipoRelaLabo tiporelalabo;
	public TipoAreaLabo tipoarealabo;
	public TipoCargoLabo tipocargolabo;
	public Pais pais;
	public Ciudad ciudad;
	
	
	private String cliente_descripcion;
	private String tipoempresa_descripcion;
	private String tiporelalabo_descripcion;
	private String tipoarealabo_descripcion;
	private String tipocargolabo_descripcion;
	private String pais_descripcion;
	private String ciudad_descripcion;
	
	
		
	public InformacionLaboral () throws Exception {
		super();		
		
		this.id=0L;
		
		
		this.versionRow=new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());//new Date();
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		this.sType="NONE";
		
		this.informacionlaboralOriginal=this;
		
 		this.idcliente=-1L;
 		this.idvalorempresa=-1L;
 		this.idvalorclienterelacionlaboral=-1L;
 		this.idvalorclientearealaboral=-1L;
 		this.idvalorclientecargolaboral=-1L;
 		this.id_pais=-1L;
 		this.idciudad=-1L;
 		this.tiempoa=0;
 		this.tiempom=0;
 		this.nombreempresa="";
 		this.direccion="";
 		this.nombrereferencia="";
 		this.telefono="";
 		this.telefonocodigoarea="";
 		this.telefonomovil="";
 		this.email="";
 		this.esactivo=false;
		
		
		this.cliente=null;
		this.tipoempresa=null;
		this.tiporelalabo=null;
		this.tipoarealabo=null;
		this.tipocargolabo=null;
		this.pais=null;
		this.ciudad=null;
		
		
		this.cliente_descripcion="";
		this.tipoempresa_descripcion="";
		this.tiporelalabo_descripcion="";
		this.tipoarealabo_descripcion="";
		this.tipocargolabo_descripcion="";
		this.pais_descripcion="";
		this.ciudad_descripcion="";
		
		
		
			
		
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
    //PARA REPORTES
	public InformacionLaboral (Long id,Date versionRow,Long idcliente,Long idvalorempresa,Long idvalorclienterelacionlaboral,Long idvalorclientearealaboral,Long idvalorclientecargolaboral,Long id_pais,Long idciudad,Integer tiempoa,Integer tiempom,String nombreempresa,String direccion,String nombrereferencia,String telefono,String telefonocodigoarea,String telefonomovil,String email,Boolean esactivo) throws Exception {
		super();		
		
		this.id=id;
		this.versionRow=versionRow;
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.informacionlaboralOriginal=this;
		
 		this.idcliente=idcliente;
 		this.idvalorempresa=idvalorempresa;
 		this.idvalorclienterelacionlaboral=idvalorclienterelacionlaboral;
 		this.idvalorclientearealaboral=idvalorclientearealaboral;
 		this.idvalorclientecargolaboral=idvalorclientecargolaboral;
 		this.id_pais=id_pais;
 		this.idciudad=idciudad;
 		this.tiempoa=tiempoa;
 		this.tiempom=tiempom;
 		this.nombreempresa=nombreempresa;
 		this.direccion=direccion;
 		this.nombrereferencia=nombrereferencia;
 		this.telefono=telefono;
 		this.telefonocodigoarea=telefonocodigoarea;
 		this.telefonomovil=telefonomovil;
 		this.email=email;
 		this.esactivo=esactivo;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	 //PARA REPORTES
	public InformacionLaboral (Long idcliente,Long idvalorempresa,Long idvalorclienterelacionlaboral,Long idvalorclientearealaboral,Long idvalorclientecargolaboral,Long id_pais,Long idciudad,Integer tiempoa,Integer tiempom,String nombreempresa,String direccion,String nombrereferencia,String telefono,String telefonocodigoarea,String telefonomovil,String email,Boolean esactivo) throws Exception {
		super();		
		
		this.id=0L;
		this.versionRow=new Date();
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.informacionlaboralOriginal=this;
		
 		this.idcliente=idcliente;
 		this.idvalorempresa=idvalorempresa;
 		this.idvalorclienterelacionlaboral=idvalorclienterelacionlaboral;
 		this.idvalorclientearealaboral=idvalorclientearealaboral;
 		this.idvalorclientecargolaboral=idvalorclientecargolaboral;
 		this.id_pais=id_pais;
 		this.idciudad=idciudad;
 		this.tiempoa=tiempoa;
 		this.tiempom=tiempom;
 		this.nombreempresa=nombreempresa;
 		this.direccion=direccion;
 		this.nombrereferencia=nombrereferencia;
 		this.telefono=telefono;
 		this.telefonocodigoarea=telefonocodigoarea;
 		this.telefonomovil=telefonomovil;
 		this.email=email;
 		this.esactivo=esactivo;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	public boolean equals(Object object) {
		boolean equal=false;
		InformacionLaboral informacionlaboralLocal=null;
		
		if(object!=null) {
			informacionlaboralLocal=(InformacionLaboral)object;
			
			if(informacionlaboralLocal!=null) {
				if(this.getId()!=null && informacionlaboralLocal.getId()!=null) {
					if(this.getId().equals(informacionlaboralLocal.getId())) {
						equal=true;
					}
				}
			}
		}
		
		return equal;
	}
	
	public String toString() {
		String sDetalle="";
		
		if(!InformacionLaboralConstantesFunciones.CON_DESCRIPCION_DETALLADO) {
        	sDetalle=InformacionLaboralConstantesFunciones.getInformacionLaboralDescripcion(this);
		} else {
			sDetalle=InformacionLaboralConstantesFunciones.getInformacionLaboralDescripcionDetallado(this);
		}
		
		return sDetalle;
    }
	
	public InformacionLaboral getInformacionLaboralOriginal() {
		return this.informacionlaboralOriginal;
	}
	
	public void setInformacionLaboralOriginal(InformacionLaboral informacionlaboral) {
		try {
			this.informacionlaboralOriginal=informacionlaboral;
		} catch(Exception e) {
			;
		}
	}
	
	
	protected InformacionLaboralAdditional informacionlaboralAdditional=null;
	
	public InformacionLaboralAdditional getInformacionLaboralAdditional() {
		return this.informacionlaboralAdditional;
	}
	
	public void setInformacionLaboralAdditional(InformacionLaboralAdditional informacionlaboralAdditional) {
		try {
			this.informacionlaboralAdditional=informacionlaboralAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
    
	
	public Long getidcliente() {
		return this.idcliente;
	}
    
	
	public Long getidvalorempresa() {
		return this.idvalorempresa;
	}
    
	
	public Long getidvalorclienterelacionlaboral() {
		return this.idvalorclienterelacionlaboral;
	}
    
	
	public Long getidvalorclientearealaboral() {
		return this.idvalorclientearealaboral;
	}
    
	
	public Long getidvalorclientecargolaboral() {
		return this.idvalorclientecargolaboral;
	}
    
	
	public Long getid_pais() {
		return this.id_pais;
	}
    
	
	public Long getidciudad() {
		return this.idciudad;
	}
    
	
	public Integer gettiempoa() {
		return this.tiempoa;
	}
    
	
	public Integer gettiempom() {
		return this.tiempom;
	}
    
	
	public String getnombreempresa() {
		return this.nombreempresa;
	}
    
	
	public String getdireccion() {
		return this.direccion;
	}
    
	
	public String getnombrereferencia() {
		return this.nombrereferencia;
	}
    
	
	public String gettelefono() {
		return this.telefono;
	}
    
	
	public String gettelefonocodigoarea() {
		return this.telefonocodigoarea;
	}
    
	
	public String gettelefonomovil() {
		return this.telefonomovil;
	}
    
	
	public String getemail() {
		return this.email;
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
						System.out.println("InformacionLaboral:Valor nulo no permitido en columna idcliente");
					}
				}

				this.idcliente=newidcliente;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setidvalorempresa(Long newidvalorempresa)throws Exception
	{
		try {
			if(this.idvalorempresa!=newidvalorempresa) {
				if(newidvalorempresa==null) {
					//newidvalorempresa=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("InformacionLaboral:Valor nulo no permitido en columna idvalorempresa");
					}
				}

				this.idvalorempresa=newidvalorempresa;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setidvalorclienterelacionlaboral(Long newidvalorclienterelacionlaboral)throws Exception
	{
		try {
			if(this.idvalorclienterelacionlaboral!=newidvalorclienterelacionlaboral) {
				if(newidvalorclienterelacionlaboral==null) {
					//newidvalorclienterelacionlaboral=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("InformacionLaboral:Valor nulo no permitido en columna idvalorclienterelacionlaboral");
					}
				}

				this.idvalorclienterelacionlaboral=newidvalorclienterelacionlaboral;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setidvalorclientearealaboral(Long newidvalorclientearealaboral)throws Exception
	{
		try {
			if(this.idvalorclientearealaboral!=newidvalorclientearealaboral) {
				if(newidvalorclientearealaboral==null) {
					//newidvalorclientearealaboral=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("InformacionLaboral:Valor nulo no permitido en columna idvalorclientearealaboral");
					}
				}

				this.idvalorclientearealaboral=newidvalorclientearealaboral;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setidvalorclientecargolaboral(Long newidvalorclientecargolaboral)throws Exception
	{
		try {
			if(this.idvalorclientecargolaboral!=newidvalorclientecargolaboral) {
				if(newidvalorclientecargolaboral==null) {
					//newidvalorclientecargolaboral=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("InformacionLaboral:Valor nulo no permitido en columna idvalorclientecargolaboral");
					}
				}

				this.idvalorclientecargolaboral=newidvalorclientecargolaboral;
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
						System.out.println("InformacionLaboral:Valor nulo no permitido en columna id_pais");
					}
				}

				this.id_pais=newid_pais;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setidciudad(Long newidciudad)throws Exception
	{
		try {
			if(this.idciudad!=newidciudad) {
				if(newidciudad==null) {
					//newidciudad=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("InformacionLaboral:Valor nulo no permitido en columna idciudad");
					}
				}

				this.idciudad=newidciudad;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void settiempoa(Integer newtiempoa)throws Exception
	{
		try {
			if(this.tiempoa!=newtiempoa) {
				if(newtiempoa==null) {
					//newtiempoa=0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("InformacionLaboral:Valor nulo no permitido en columna tiempoa");
					}
				}

				this.tiempoa=newtiempoa;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void settiempom(Integer newtiempom)throws Exception
	{
		try {
			if(this.tiempom!=newtiempom) {
				if(newtiempom==null) {
					//newtiempom=0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("InformacionLaboral:Valor nulo no permitido en columna tiempom");
					}
				}

				this.tiempom=newtiempom;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setnombreempresa(String newnombreempresa)throws Exception
	{
		try {
			if(this.nombreempresa!=newnombreempresa) {
				if(newnombreempresa==null) {
					//newnombreempresa="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("InformacionLaboral:Valor nulo no permitido en columna nombreempresa");
					}
				}

				if(newnombreempresa!=null&&newnombreempresa.length()>100) {
					newnombreempresa=newnombreempresa.substring(0,98);
					System.out.println("InformacionLaboral:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=100 en columna nombreempresa");
				}

				this.nombreempresa=newnombreempresa;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setdireccion(String newdireccion)throws Exception
	{
		try {
			if(this.direccion!=newdireccion) {
				if(newdireccion==null) {
					//newdireccion="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("InformacionLaboral:Valor nulo no permitido en columna direccion");
					}
				}

				if(newdireccion!=null&&newdireccion.length()>250) {
					newdireccion=newdireccion.substring(0,248);
					System.out.println("InformacionLaboral:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=250 en columna direccion");
				}

				this.direccion=newdireccion;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setnombrereferencia(String newnombrereferencia)throws Exception
	{
		try {
			if(this.nombrereferencia!=newnombrereferencia) {
				if(newnombrereferencia==null) {
					//newnombrereferencia="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("InformacionLaboral:Valor nulo no permitido en columna nombrereferencia");
					}
				}

				if(newnombrereferencia!=null&&newnombrereferencia.length()>200) {
					newnombrereferencia=newnombrereferencia.substring(0,198);
					System.out.println("InformacionLaboral:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=200 en columna nombrereferencia");
				}

				this.nombrereferencia=newnombrereferencia;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void settelefono(String newtelefono)throws Exception
	{
		try {
			if(this.telefono!=newtelefono) {
				if(newtelefono==null) {
					//newtelefono="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("InformacionLaboral:Valor nulo no permitido en columna telefono");
					}
				}

				if(newtelefono!=null&&newtelefono.length()>200) {
					newtelefono=newtelefono.substring(0,198);
					System.out.println("InformacionLaboral:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=200 en columna telefono");
				}

				this.telefono=newtelefono;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void settelefonocodigoarea(String newtelefonocodigoarea)throws Exception
	{
		try {
			if(this.telefonocodigoarea.trim()!=newtelefonocodigoarea) {
				if(newtelefonocodigoarea==null) {
					//newtelefonocodigoarea="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("InformacionLaboral:Valor nulo no permitido en columna telefonocodigoarea");
					}
				}

				if(newtelefonocodigoarea!=null&&newtelefonocodigoarea.length()>20) {
					newtelefonocodigoarea=newtelefonocodigoarea.substring(0,18);
					System.out.println("InformacionLaboral:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=20 en columna telefonocodigoarea");
				}

				this.telefonocodigoarea=newtelefonocodigoarea;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void settelefonomovil(String newtelefonomovil)throws Exception
	{
		try {
			if(this.telefonomovil!=newtelefonomovil) {
				if(newtelefonomovil==null) {
					//newtelefonomovil="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("InformacionLaboral:Valor nulo no permitido en columna telefonomovil");
					}
				}

				if(newtelefonomovil!=null&&newtelefonomovil.length()>200) {
					newtelefonomovil=newtelefonomovil.substring(0,198);
					System.out.println("InformacionLaboral:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=200 en columna telefonomovil");
				}

				this.telefonomovil=newtelefonomovil;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setemail(String newemail)throws Exception
	{
		try {
			if(this.email!=newemail) {
				if(newemail==null) {
					//newemail="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("InformacionLaboral:Valor nulo no permitido en columna email");
					}
				}

				if(newemail!=null&&newemail.length()>200) {
					newemail=newemail.substring(0,198);
					System.out.println("InformacionLaboral:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=200 en columna email");
				}

				this.email=newemail;
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
						System.out.println("InformacionLaboral:Valor nulo no permitido en columna esactivo");
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

	public TipoEmpresa getTipoEmpresa() {
		return this.tipoempresa;
	}

	public TipoRelaLabo getTipoRelaLabo() {
		return this.tiporelalabo;
	}

	public TipoAreaLabo getTipoAreaLabo() {
		return this.tipoarealabo;
	}

	public TipoCargoLabo getTipoCargoLabo() {
		return this.tipocargolabo;
	}

	public Pais getPais() {
		return this.pais;
	}

	public Ciudad getCiudad() {
		return this.ciudad;
	}

	
	
	public String getcliente_descripcion() {
		return this.cliente_descripcion;
	}

	public String gettipoempresa_descripcion() {
		return this.tipoempresa_descripcion;
	}

	public String gettiporelalabo_descripcion() {
		return this.tiporelalabo_descripcion;
	}

	public String gettipoarealabo_descripcion() {
		return this.tipoarealabo_descripcion;
	}

	public String gettipocargolabo_descripcion() {
		return this.tipocargolabo_descripcion;
	}

	public String getpais_descripcion() {
		return this.pais_descripcion;
	}

	public String getciudad_descripcion() {
		return this.ciudad_descripcion;
	}

	
	
	public  void  setCliente(Cliente cliente) {
		try {
			this.cliente=cliente;
		} catch(Exception e) {
			;
		}
	}


	public  void  setTipoEmpresa(TipoEmpresa tipoempresa) {
		try {
			this.tipoempresa=tipoempresa;
		} catch(Exception e) {
			;
		}
	}


	public  void  setTipoRelaLabo(TipoRelaLabo tiporelalabo) {
		try {
			this.tiporelalabo=tiporelalabo;
		} catch(Exception e) {
			;
		}
	}


	public  void  setTipoAreaLabo(TipoAreaLabo tipoarealabo) {
		try {
			this.tipoarealabo=tipoarealabo;
		} catch(Exception e) {
			;
		}
	}


	public  void  setTipoCargoLabo(TipoCargoLabo tipocargolabo) {
		try {
			this.tipocargolabo=tipocargolabo;
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


	
	
	public  void  setcliente_descripcion(String cliente_descripcion) {
		try {
			this.cliente_descripcion=cliente_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  settipoempresa_descripcion(String tipoempresa_descripcion) {
		try {
			this.tipoempresa_descripcion=tipoempresa_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  settiporelalabo_descripcion(String tiporelalabo_descripcion) {
		try {
			this.tiporelalabo_descripcion=tiporelalabo_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  settipoarealabo_descripcion(String tipoarealabo_descripcion) {
		try {
			this.tipoarealabo_descripcion=tipoarealabo_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  settipocargolabo_descripcion(String tipocargolabo_descripcion) {
		try {
			this.tipocargolabo_descripcion=tipocargolabo_descripcion;
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


	
	
	
	
	
	/*PARA REPORTES*/
	String idcliente_descripcion="";String idvalorempresa_descripcion="";String idvalorclienterelacionlaboral_descripcion="";String idvalorclientearealaboral_descripcion="";String idvalorclientecargolaboral_descripcion="";String id_pais_descripcion="";String idciudad_descripcion="";String esactivo_descripcion="";
	
	
	public String getidcliente_descripcion() {
		return idcliente_descripcion;
	}
	public String getidvalorempresa_descripcion() {
		return idvalorempresa_descripcion;
	}
	public String getidvalorclienterelacionlaboral_descripcion() {
		return idvalorclienterelacionlaboral_descripcion;
	}
	public String getidvalorclientearealaboral_descripcion() {
		return idvalorclientearealaboral_descripcion;
	}
	public String getidvalorclientecargolaboral_descripcion() {
		return idvalorclientecargolaboral_descripcion;
	}
	public String getid_pais_descripcion() {
		return id_pais_descripcion;
	}
	public String getidciudad_descripcion() {
		return idciudad_descripcion;
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
	public void setidvalorempresa_descripcion(String newidvalorempresa_descripcion)throws Exception {
		try {
			this.idvalorempresa_descripcion=newidvalorempresa_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setidvalorclienterelacionlaboral_descripcion(String newidvalorclienterelacionlaboral_descripcion)throws Exception {
		try {
			this.idvalorclienterelacionlaboral_descripcion=newidvalorclienterelacionlaboral_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setidvalorclientearealaboral_descripcion(String newidvalorclientearealaboral_descripcion)throws Exception {
		try {
			this.idvalorclientearealaboral_descripcion=newidvalorclientearealaboral_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setidvalorclientecargolaboral_descripcion(String newidvalorclientecargolaboral_descripcion)throws Exception {
		try {
			this.idvalorclientecargolaboral_descripcion=newidvalorclientecargolaboral_descripcion;
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
	public void setidciudad_descripcion(String newidciudad_descripcion)throws Exception {
		try {
			this.idciudad_descripcion=newidciudad_descripcion;
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
		this.idcliente_descripcion="";this.idvalorempresa_descripcion="";this.idvalorclienterelacionlaboral_descripcion="";this.idvalorclientearealaboral_descripcion="";this.idvalorclientecargolaboral_descripcion="";this.id_pais_descripcion="";this.idciudad_descripcion="";this.esactivo_descripcion="";
	}
	
	
	
	
	
	
	/*PARA REPORTES FIN*/		
}

