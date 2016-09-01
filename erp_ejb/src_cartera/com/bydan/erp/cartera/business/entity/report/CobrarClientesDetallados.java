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
//import com.bydan.erp.cartera.util.CobrarClientesDetalladosConstantesFunciones;
import com.bydan.erp.cartera.util.*;


import com.bydan.erp.seguridad.util.*;

import com.bydan.erp.cartera.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;




@SuppressWarnings("unused")
public class CobrarClientesDetallados extends CobrarClientesDetalladosAdditional implements Serializable ,Cloneable {//CobrarClientesDetalladosAdditional,GeneralEntity
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
	
	private CobrarClientesDetallados cobrarclientesdetalladosOriginal;
	
	private Map<String, Object> mapCobrarClientesDetallados;
			
	public Map<String, Object> getMapCobrarClientesDetallados() {
		return mapCobrarClientesDetallados;
	}

	public void setMapCobrarClientesDetallados(Map<String, Object> mapCobrarClientesDetallados) {
		this.mapCobrarClientesDetallados = mapCobrarClientesDetallados;
	}
	
	public void inicializarMapCobrarClientesDetallados() {
		this.mapCobrarClientesDetallados = new HashMap<String,Object>();
	}
	
	public void setMapCobrarClientesDetalladosValue(String sKey,Object oValue) {
		this.mapCobrarClientesDetallados.put(sKey, oValue);
	}
	
	public Object getMapCobrarClientesDetalladosValue(String sKey) {
		return this.mapCobrarClientesDetallados.get(sKey);
	}
	
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_empresa;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=200,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	//@Pattern(regex=CobrarClientesDetalladosConstantesFunciones.SREGEXNOMBRE_CIUDAD,message=CobrarClientesDetalladosConstantesFunciones.SMENSAJEREGEXNOMBRE_CIUDAD)
	private String nombre_ciudad;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=50,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	//@Pattern(regex=CobrarClientesDetalladosConstantesFunciones.SREGEXNOMBRE_ZONA,message=CobrarClientesDetalladosConstantesFunciones.SMENSAJEREGEXNOMBRE_ZONA)
	private String nombre_zona;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=150,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	//@Pattern(regex=CobrarClientesDetalladosConstantesFunciones.SREGEXNOMBRE_GRUPO_CLIENTE,message=CobrarClientesDetalladosConstantesFunciones.SMENSAJEREGEXNOMBRE_GRUPO_CLIENTE)
	private String nombre_grupo_cliente;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=100,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	//@Pattern(regex=CobrarClientesDetalladosConstantesFunciones.SREGEXNOMBRE_TITULO_CLIENTE,message=CobrarClientesDetalladosConstantesFunciones.SMENSAJEREGEXNOMBRE_TITULO_CLIENTE)
	private String nombre_titulo_cliente;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=50,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	//@Pattern(regex=CobrarClientesDetalladosConstantesFunciones.SREGEXCODIGO,message=CobrarClientesDetalladosConstantesFunciones.SMENSAJEREGEXCODIGO)
	private String codigo;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=100,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	//@Pattern(regex=CobrarClientesDetalladosConstantesFunciones.SREGEXNOMBRE,message=CobrarClientesDetalladosConstantesFunciones.SMENSAJEREGEXNOMBRE)
	private String nombre;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=100,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	//@Pattern(regex=CobrarClientesDetalladosConstantesFunciones.SREGEXAPELLIDO,message=CobrarClientesDetalladosConstantesFunciones.SMENSAJEREGEXAPELLIDO)
	private String apellido;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=15,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	//@Pattern(regex=CobrarClientesDetalladosConstantesFunciones.SREGEXRUC,message=CobrarClientesDetalladosConstantesFunciones.SMENSAJEREGEXRUC)
	private String ruc;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=150,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	//@Pattern(regex=CobrarClientesDetalladosConstantesFunciones.SREGEXNOMBRE_CONTACTO_CLIENTE,message=CobrarClientesDetalladosConstantesFunciones.SMENSAJEREGEXNOMBRE_CONTACTO_CLIENTE)
	private String nombre_contacto_cliente;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=200,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	//@Pattern(regex=CobrarClientesDetalladosConstantesFunciones.SREGEXDIRECCION_DIRECCION,message=CobrarClientesDetalladosConstantesFunciones.SMENSAJEREGEXDIRECCION_DIRECCION)
	private String direccion_direccion;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=200,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	//@Pattern(regex=CobrarClientesDetalladosConstantesFunciones.SREGEXE_MAIL_E_MAIL,message=CobrarClientesDetalladosConstantesFunciones.SMENSAJEREGEXE_MAIL_E_MAIL)
	private String e_mail_e_mail;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=200,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	//@Pattern(regex=CobrarClientesDetalladosConstantesFunciones.SREGEXTELEFONO_TELEFONO,message=CobrarClientesDetalladosConstantesFunciones.SMENSAJEREGEXTELEFONO_TELEFONO)
	private String telefono_telefono;
			
	
	public Empresa empresa;
	
	
	private String empresa_descripcion;
	
	
		
	public CobrarClientesDetallados () throws Exception {
		super();		
		
		this.id=0L;
		
		
		this.versionRow=new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());//new Date();
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		this.sType="NONE";
		
		this.cobrarclientesdetalladosOriginal=this;
		
 		this.id_empresa=-1L;
 		this.nombre_ciudad="";
 		this.nombre_zona="";
 		this.nombre_grupo_cliente="";
 		this.nombre_titulo_cliente="";
 		this.codigo="";
 		this.nombre="";
 		this.apellido="";
 		this.ruc="";
 		this.nombre_contacto_cliente="";
 		this.direccion_direccion="";
 		this.e_mail_e_mail="";
 		this.telefono_telefono="";
		
		
		this.empresa=null;
		
		
		this.empresa_descripcion="";
		
		
		
			
		
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
    //PARA REPORTES
	public CobrarClientesDetallados (Long id,Date versionRow,String nombre_ciudad,String nombre_zona,String nombre_grupo_cliente,String nombre_titulo_cliente,String codigo,String nombre,String apellido,String ruc,String nombre_contacto_cliente,String direccion_direccion,String e_mail_e_mail,String telefono_telefono) throws Exception {
		super();		
		
		this.id=id;
		this.versionRow=versionRow;
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.cobrarclientesdetalladosOriginal=this;
		
 		this.nombre_ciudad=nombre_ciudad;
 		this.nombre_zona=nombre_zona;
 		this.nombre_grupo_cliente=nombre_grupo_cliente;
 		this.nombre_titulo_cliente=nombre_titulo_cliente;
 		this.codigo=codigo;
 		this.nombre=nombre;
 		this.apellido=apellido;
 		this.ruc=ruc;
 		this.nombre_contacto_cliente=nombre_contacto_cliente;
 		this.direccion_direccion=direccion_direccion;
 		this.e_mail_e_mail=e_mail_e_mail;
 		this.telefono_telefono=telefono_telefono;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	 //PARA REPORTES
	public CobrarClientesDetallados (String nombre_ciudad,String nombre_zona,String nombre_grupo_cliente,String nombre_titulo_cliente,String codigo,String nombre,String apellido,String ruc,String nombre_contacto_cliente,String direccion_direccion,String e_mail_e_mail,String telefono_telefono) throws Exception {
		super();		
		
		this.id=0L;
		this.versionRow=new Date();
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.cobrarclientesdetalladosOriginal=this;
		
 		this.nombre_ciudad=nombre_ciudad;
 		this.nombre_zona=nombre_zona;
 		this.nombre_grupo_cliente=nombre_grupo_cliente;
 		this.nombre_titulo_cliente=nombre_titulo_cliente;
 		this.codigo=codigo;
 		this.nombre=nombre;
 		this.apellido=apellido;
 		this.ruc=ruc;
 		this.nombre_contacto_cliente=nombre_contacto_cliente;
 		this.direccion_direccion=direccion_direccion;
 		this.e_mail_e_mail=e_mail_e_mail;
 		this.telefono_telefono=telefono_telefono;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	
	public CobrarClientesDetallados getCobrarClientesDetalladosOriginal() {
		return this.cobrarclientesdetalladosOriginal;
	}
	
	public void setCobrarClientesDetalladosOriginal(CobrarClientesDetallados cobrarclientesdetallados) {
		try {
			this.cobrarclientesdetalladosOriginal=cobrarclientesdetallados;
		} catch(Exception e) {
			;
		}
	}
	
	
	protected CobrarClientesDetalladosAdditional cobrarclientesdetalladosAdditional=null;
	
	public CobrarClientesDetalladosAdditional getCobrarClientesDetalladosAdditional() {
		return this.cobrarclientesdetalladosAdditional;
	}
	
	public void setCobrarClientesDetalladosAdditional(CobrarClientesDetalladosAdditional cobrarclientesdetalladosAdditional) {
		try {
			this.cobrarclientesdetalladosAdditional=cobrarclientesdetalladosAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
    
	
	public Long getid_empresa() {
		return this.id_empresa;
	}
    
	
	public String getnombre_ciudad() {
		return this.nombre_ciudad;
	}
    
	
	public String getnombre_zona() {
		return this.nombre_zona;
	}
    
	
	public String getnombre_grupo_cliente() {
		return this.nombre_grupo_cliente;
	}
    
	
	public String getnombre_titulo_cliente() {
		return this.nombre_titulo_cliente;
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
    
	
	public String getruc() {
		return this.ruc;
	}
    
	
	public String getnombre_contacto_cliente() {
		return this.nombre_contacto_cliente;
	}
    
	
	public String getdireccion_direccion() {
		return this.direccion_direccion;
	}
    
	
	public String gete_mail_e_mail() {
		return this.e_mail_e_mail;
	}
    
	
	public String gettelefono_telefono() {
		return this.telefono_telefono;
	}
	
    
	public void setid_empresa(Long newid_empresa)throws Exception
	{
		try {
			if(this.id_empresa!=newid_empresa) {
				if(newid_empresa==null) {
					//newid_empresa=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("CobrarClientesDetallados:Valor nulo no permitido en columna id_empresa");
					}
				}

				this.id_empresa=newid_empresa;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setnombre_ciudad(String newnombre_ciudad)throws Exception
	{
		try {
			if(this.nombre_ciudad!=newnombre_ciudad) {
				if(newnombre_ciudad==null) {
					//newnombre_ciudad="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("CobrarClientesDetallados:Valor nulo no permitido en columna nombre_ciudad");
					}
				}

				if(newnombre_ciudad!=null&&newnombre_ciudad.length()>200) {
					newnombre_ciudad=newnombre_ciudad.substring(0,198);
					System.out.println("CobrarClientesDetallados:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=200 en columna nombre_ciudad");
				}

				this.nombre_ciudad=newnombre_ciudad;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setnombre_zona(String newnombre_zona)throws Exception
	{
		try {
			if(this.nombre_zona!=newnombre_zona) {
				if(newnombre_zona==null) {
					//newnombre_zona="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("CobrarClientesDetallados:Valor nulo no permitido en columna nombre_zona");
					}
				}

				if(newnombre_zona!=null&&newnombre_zona.length()>50) {
					newnombre_zona=newnombre_zona.substring(0,48);
					System.out.println("CobrarClientesDetallados:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=50 en columna nombre_zona");
				}

				this.nombre_zona=newnombre_zona;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setnombre_grupo_cliente(String newnombre_grupo_cliente)throws Exception
	{
		try {
			if(this.nombre_grupo_cliente!=newnombre_grupo_cliente) {
				if(newnombre_grupo_cliente==null) {
					//newnombre_grupo_cliente="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("CobrarClientesDetallados:Valor nulo no permitido en columna nombre_grupo_cliente");
					}
				}

				if(newnombre_grupo_cliente!=null&&newnombre_grupo_cliente.length()>150) {
					newnombre_grupo_cliente=newnombre_grupo_cliente.substring(0,148);
					System.out.println("CobrarClientesDetallados:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=150 en columna nombre_grupo_cliente");
				}

				this.nombre_grupo_cliente=newnombre_grupo_cliente;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setnombre_titulo_cliente(String newnombre_titulo_cliente)throws Exception
	{
		try {
			if(this.nombre_titulo_cliente!=newnombre_titulo_cliente) {
				if(newnombre_titulo_cliente==null) {
					//newnombre_titulo_cliente="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("CobrarClientesDetallados:Valor nulo no permitido en columna nombre_titulo_cliente");
					}
				}

				if(newnombre_titulo_cliente!=null&&newnombre_titulo_cliente.length()>100) {
					newnombre_titulo_cliente=newnombre_titulo_cliente.substring(0,98);
					System.out.println("CobrarClientesDetallados:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=100 en columna nombre_titulo_cliente");
				}

				this.nombre_titulo_cliente=newnombre_titulo_cliente;
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
						System.out.println("CobrarClientesDetallados:Valor nulo no permitido en columna codigo");
					}
				}

				if(newcodigo!=null&&newcodigo.length()>50) {
					newcodigo=newcodigo.substring(0,48);
					System.out.println("CobrarClientesDetallados:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=50 en columna codigo");
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
						System.out.println("CobrarClientesDetallados:Valor nulo no permitido en columna nombre");
					}
				}

				if(newnombre!=null&&newnombre.length()>100) {
					newnombre=newnombre.substring(0,98);
					System.out.println("CobrarClientesDetallados:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=100 en columna nombre");
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
						System.out.println("CobrarClientesDetallados:Valor nulo no permitido en columna apellido");
					}
				}

				if(newapellido!=null&&newapellido.length()>100) {
					newapellido=newapellido.substring(0,98);
					System.out.println("CobrarClientesDetallados:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=100 en columna apellido");
				}

				this.apellido=newapellido;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setruc(String newruc)throws Exception
	{
		try {
			if(this.ruc!=newruc) {
				if(newruc==null) {
					//newruc="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("CobrarClientesDetallados:Valor nulo no permitido en columna ruc");
					}
				}

				if(newruc!=null&&newruc.length()>15) {
					newruc=newruc.substring(0,13);
					System.out.println("CobrarClientesDetallados:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=15 en columna ruc");
				}

				this.ruc=newruc;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setnombre_contacto_cliente(String newnombre_contacto_cliente)throws Exception
	{
		try {
			if(this.nombre_contacto_cliente!=newnombre_contacto_cliente) {
				if(newnombre_contacto_cliente==null) {
					//newnombre_contacto_cliente="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("CobrarClientesDetallados:Valor nulo no permitido en columna nombre_contacto_cliente");
					}
				}

				if(newnombre_contacto_cliente!=null&&newnombre_contacto_cliente.length()>150) {
					newnombre_contacto_cliente=newnombre_contacto_cliente.substring(0,148);
					System.out.println("CobrarClientesDetallados:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=150 en columna nombre_contacto_cliente");
				}

				this.nombre_contacto_cliente=newnombre_contacto_cliente;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setdireccion_direccion(String newdireccion_direccion)throws Exception
	{
		try {
			if(this.direccion_direccion!=newdireccion_direccion) {
				if(newdireccion_direccion==null) {
					//newdireccion_direccion="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("CobrarClientesDetallados:Valor nulo no permitido en columna direccion_direccion");
					}
				}

				if(newdireccion_direccion!=null&&newdireccion_direccion.length()>200) {
					newdireccion_direccion=newdireccion_direccion.substring(0,198);
					System.out.println("CobrarClientesDetallados:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=200 en columna direccion_direccion");
				}

				this.direccion_direccion=newdireccion_direccion;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void sete_mail_e_mail(String newe_mail_e_mail)throws Exception
	{
		try {
			if(this.e_mail_e_mail!=newe_mail_e_mail) {
				if(newe_mail_e_mail==null) {
					//newe_mail_e_mail="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("CobrarClientesDetallados:Valor nulo no permitido en columna e_mail_e_mail");
					}
				}

				if(newe_mail_e_mail!=null&&newe_mail_e_mail.length()>200) {
					newe_mail_e_mail=newe_mail_e_mail.substring(0,198);
					System.out.println("CobrarClientesDetallados:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=200 en columna e_mail_e_mail");
				}

				this.e_mail_e_mail=newe_mail_e_mail;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void settelefono_telefono(String newtelefono_telefono)throws Exception
	{
		try {
			if(this.telefono_telefono!=newtelefono_telefono) {
				if(newtelefono_telefono==null) {
					//newtelefono_telefono="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("CobrarClientesDetallados:Valor nulo no permitido en columna telefono_telefono");
					}
				}

				if(newtelefono_telefono!=null&&newtelefono_telefono.length()>200) {
					newtelefono_telefono=newtelefono_telefono.substring(0,198);
					System.out.println("CobrarClientesDetallados:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=200 en columna telefono_telefono");
				}

				this.telefono_telefono=newtelefono_telefono;
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

