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
//import com.bydan.erp.cartera.util.ReferenciaComercialConstantesFunciones;
import com.bydan.erp.cartera.util.*;


import com.bydan.erp.seguridad.util.*;



import com.bydan.erp.seguridad.business.entity.*;




@SuppressWarnings("unused")
public class ReferenciaComercial extends ReferenciaComercialAdditional implements Serializable ,Cloneable {//ReferenciaComercialAdditional,GeneralEntity
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
	
	private ReferenciaComercial referenciacomercialOriginal;
	
	private Map<String, Object> mapReferenciaComercial;
			
	public Map<String, Object> getMapReferenciaComercial() {
		return mapReferenciaComercial;
	}

	public void setMapReferenciaComercial(Map<String, Object> mapReferenciaComercial) {
		this.mapReferenciaComercial = mapReferenciaComercial;
	}
	
	public void inicializarMapReferenciaComercial() {
		this.mapReferenciaComercial = new HashMap<String,Object>();
	}
	
	public void setMapReferenciaComercialValue(String sKey,Object oValue) {
		this.mapReferenciaComercial.put(sKey, oValue);
	}
	
	public Object getMapReferenciaComercialValue(String sKey) {
		return this.mapReferenciaComercial.get(sKey);
	}
	
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_empresa;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long idcliente;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long idvalorclientesectoreconomico;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_pais;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long idciudad;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=200,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=ReferenciaComercialConstantesFunciones.SREGEXNOMBREEMPRESA,message=ReferenciaComercialConstantesFunciones.SMENSAJEREGEXNOMBREEMPRESA)
	private String nombreempresa;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=20,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=ReferenciaComercialConstantesFunciones.SREGEXCODIGO_CLIENTE,message=ReferenciaComercialConstantesFunciones.SMENSAJEREGEXCODIGO_CLIENTE)
	private String codigo_cliente;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=150,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=ReferenciaComercialConstantesFunciones.SREGEXCONTACTO,message=ReferenciaComercialConstantesFunciones.SMENSAJEREGEXCONTACTO)
	private String contacto;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=150,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=ReferenciaComercialConstantesFunciones.SREGEXARTICULO_COMPRA,message=ReferenciaComercialConstantesFunciones.SMENSAJEREGEXARTICULO_COMPRA)
	private String articulo_compra;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=10,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONINT)
	private Integer numero_anios;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=10,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONINT)
	private Integer numero_meses;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_tipo_valoracion;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=250,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=ReferenciaComercialConstantesFunciones.SREGEXDIRECCION,message=ReferenciaComercialConstantesFunciones.SMENSAJEREGEXDIRECCION)
	private String direccion;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=200,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=ReferenciaComercialConstantesFunciones.SREGEXTELEFONO,message=ReferenciaComercialConstantesFunciones.SMENSAJEREGEXTELEFONO)
	private String telefono;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=200,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=ReferenciaComercialConstantesFunciones.SREGEXTELEFONOMOVIL,message=ReferenciaComercialConstantesFunciones.SMENSAJEREGEXTELEFONOMOVIL)
	private String telefonomovil;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=50,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=ReferenciaComercialConstantesFunciones.SREGEXTELEFONOCODIGOAREA,message=ReferenciaComercialConstantesFunciones.SMENSAJEREGEXTELEFONOCODIGOAREA)
	private String telefonocodigoarea;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=200,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=ReferenciaComercialConstantesFunciones.SREGEXEMAIL,message=ReferenciaComercialConstantesFunciones.SMENSAJEREGEXEMAIL)
	private String email;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double monto;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Boolean esactivo;
			
	
	public Empresa empresa;
	public Cliente cliente;
	public TipoSectorEcono tiposectorecono;
	public Pais pais;
	public Ciudad ciudad;
	public TipoValoracion tipovaloracion;
	
	
	private String empresa_descripcion;
	private String cliente_descripcion;
	private String tiposectorecono_descripcion;
	private String pais_descripcion;
	private String ciudad_descripcion;
	private String tipovaloracion_descripcion;
	
	
		
	public ReferenciaComercial () throws Exception {
		super();		
		
		this.id=0L;
		
		
		this.versionRow=new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());//new Date();
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		this.sType="NONE";
		
		this.referenciacomercialOriginal=this;
		
 		this.id_empresa=-1L;
 		this.idcliente=-1L;
 		this.idvalorclientesectoreconomico=-1L;
 		this.id_pais=-1L;
 		this.idciudad=-1L;
 		this.nombreempresa="";
 		this.codigo_cliente="";
 		this.contacto="";
 		this.articulo_compra="";
 		this.numero_anios=0;
 		this.numero_meses=0;
 		this.id_tipo_valoracion=-1L;
 		this.direccion="";
 		this.telefono="";
 		this.telefonomovil="";
 		this.telefonocodigoarea="";
 		this.email="";
 		this.monto=0.0;
 		this.esactivo=false;
		
		
		this.empresa=null;
		this.cliente=null;
		this.tiposectorecono=null;
		this.pais=null;
		this.ciudad=null;
		this.tipovaloracion=null;
		
		
		this.empresa_descripcion="";
		this.cliente_descripcion="";
		this.tiposectorecono_descripcion="";
		this.pais_descripcion="";
		this.ciudad_descripcion="";
		this.tipovaloracion_descripcion="";
		
		
		
			
		
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
    //PARA REPORTES
	public ReferenciaComercial (Long id,Date versionRow,Long id_empresa,Long idcliente,Long idvalorclientesectoreconomico,Long id_pais,Long idciudad,String nombreempresa,String codigo_cliente,String contacto,String articulo_compra,Integer numero_anios,Integer numero_meses,Long id_tipo_valoracion,String direccion,String telefono,String telefonomovil,String telefonocodigoarea,String email,Double monto,Boolean esactivo) throws Exception {
		super();		
		
		this.id=id;
		this.versionRow=versionRow;
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.referenciacomercialOriginal=this;
		
 		this.id_empresa=id_empresa;
 		this.idcliente=idcliente;
 		this.idvalorclientesectoreconomico=idvalorclientesectoreconomico;
 		this.id_pais=id_pais;
 		this.idciudad=idciudad;
 		this.nombreempresa=nombreempresa;
 		this.codigo_cliente=codigo_cliente;
 		this.contacto=contacto;
 		this.articulo_compra=articulo_compra;
 		this.numero_anios=numero_anios;
 		this.numero_meses=numero_meses;
 		this.id_tipo_valoracion=id_tipo_valoracion;
 		this.direccion=direccion;
 		this.telefono=telefono;
 		this.telefonomovil=telefonomovil;
 		this.telefonocodigoarea=telefonocodigoarea;
 		this.email=email;
 		this.monto=monto;
 		this.esactivo=esactivo;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	 //PARA REPORTES
	public ReferenciaComercial (Long id_empresa,Long idcliente,Long idvalorclientesectoreconomico,Long id_pais,Long idciudad,String nombreempresa,String codigo_cliente,String contacto,String articulo_compra,Integer numero_anios,Integer numero_meses,Long id_tipo_valoracion,String direccion,String telefono,String telefonomovil,String telefonocodigoarea,String email,Double monto,Boolean esactivo) throws Exception {
		super();		
		
		this.id=0L;
		this.versionRow=new Date();
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.referenciacomercialOriginal=this;
		
 		this.id_empresa=id_empresa;
 		this.idcliente=idcliente;
 		this.idvalorclientesectoreconomico=idvalorclientesectoreconomico;
 		this.id_pais=id_pais;
 		this.idciudad=idciudad;
 		this.nombreempresa=nombreempresa;
 		this.codigo_cliente=codigo_cliente;
 		this.contacto=contacto;
 		this.articulo_compra=articulo_compra;
 		this.numero_anios=numero_anios;
 		this.numero_meses=numero_meses;
 		this.id_tipo_valoracion=id_tipo_valoracion;
 		this.direccion=direccion;
 		this.telefono=telefono;
 		this.telefonomovil=telefonomovil;
 		this.telefonocodigoarea=telefonocodigoarea;
 		this.email=email;
 		this.monto=monto;
 		this.esactivo=esactivo;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	public boolean equals(Object object) {
		boolean equal=false;
		ReferenciaComercial referenciacomercialLocal=null;
		
		if(object!=null) {
			referenciacomercialLocal=(ReferenciaComercial)object;
			
			if(referenciacomercialLocal!=null) {
				if(this.getId()!=null && referenciacomercialLocal.getId()!=null) {
					if(this.getId().equals(referenciacomercialLocal.getId())) {
						equal=true;
					}
				}
			}
		}
		
		return equal;
	}
	
	public String toString() {
		String sDetalle="";
		
		if(!ReferenciaComercialConstantesFunciones.CON_DESCRIPCION_DETALLADO) {
        	sDetalle=ReferenciaComercialConstantesFunciones.getReferenciaComercialDescripcion(this);
		} else {
			sDetalle=ReferenciaComercialConstantesFunciones.getReferenciaComercialDescripcionDetallado(this);
		}
		
		return sDetalle;
    }
	
	public ReferenciaComercial getReferenciaComercialOriginal() {
		return this.referenciacomercialOriginal;
	}
	
	public void setReferenciaComercialOriginal(ReferenciaComercial referenciacomercial) {
		try {
			this.referenciacomercialOriginal=referenciacomercial;
		} catch(Exception e) {
			;
		}
	}
	
	
	protected ReferenciaComercialAdditional referenciacomercialAdditional=null;
	
	public ReferenciaComercialAdditional getReferenciaComercialAdditional() {
		return this.referenciacomercialAdditional;
	}
	
	public void setReferenciaComercialAdditional(ReferenciaComercialAdditional referenciacomercialAdditional) {
		try {
			this.referenciacomercialAdditional=referenciacomercialAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
    
	
	public Long getid_empresa() {
		return this.id_empresa;
	}
    
	
	public Long getidcliente() {
		return this.idcliente;
	}
    
	
	public Long getidvalorclientesectoreconomico() {
		return this.idvalorclientesectoreconomico;
	}
    
	
	public Long getid_pais() {
		return this.id_pais;
	}
    
	
	public Long getidciudad() {
		return this.idciudad;
	}
    
	
	public String getnombreempresa() {
		return this.nombreempresa;
	}
    
	
	public String getcodigo_cliente() {
		return this.codigo_cliente;
	}
    
	
	public String getcontacto() {
		return this.contacto;
	}
    
	
	public String getarticulo_compra() {
		return this.articulo_compra;
	}
    
	
	public Integer getnumero_anios() {
		return this.numero_anios;
	}
    
	
	public Integer getnumero_meses() {
		return this.numero_meses;
	}
    
	
	public Long getid_tipo_valoracion() {
		return this.id_tipo_valoracion;
	}
    
	
	public String getdireccion() {
		return this.direccion;
	}
    
	
	public String gettelefono() {
		return this.telefono;
	}
    
	
	public String gettelefonomovil() {
		return this.telefonomovil;
	}
    
	
	public String gettelefonocodigoarea() {
		return this.telefonocodigoarea;
	}
    
	
	public String getemail() {
		return this.email;
	}
    
	
	public Double getmonto() {
		return this.monto;
	}
    
	
	public Boolean getesactivo() {
		return this.esactivo;
	}
	
    
	public void setid_empresa(Long newid_empresa)throws Exception
	{
		try {
			if(this.id_empresa!=newid_empresa) {
				if(newid_empresa==null) {
					//newid_empresa=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ReferenciaComercial:Valor nulo no permitido en columna id_empresa");
					}
				}

				this.id_empresa=newid_empresa;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setidcliente(Long newidcliente)throws Exception
	{
		try {
			if(this.idcliente!=newidcliente) {
				if(newidcliente==null) {
					//newidcliente=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ReferenciaComercial:Valor nulo no permitido en columna idcliente");
					}
				}

				this.idcliente=newidcliente;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setidvalorclientesectoreconomico(Long newidvalorclientesectoreconomico)throws Exception
	{
		try {
			if(this.idvalorclientesectoreconomico!=newidvalorclientesectoreconomico) {
				if(newidvalorclientesectoreconomico==null) {
					//newidvalorclientesectoreconomico=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ReferenciaComercial:Valor nulo no permitido en columna idvalorclientesectoreconomico");
					}
				}

				this.idvalorclientesectoreconomico=newidvalorclientesectoreconomico;
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
						System.out.println("ReferenciaComercial:Valor nulo no permitido en columna id_pais");
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
						System.out.println("ReferenciaComercial:Valor nulo no permitido en columna idciudad");
					}
				}

				this.idciudad=newidciudad;
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
						System.out.println("ReferenciaComercial:Valor nulo no permitido en columna nombreempresa");
					}
				}

				if(newnombreempresa!=null&&newnombreempresa.length()>200) {
					newnombreempresa=newnombreempresa.substring(0,198);
					System.out.println("ReferenciaComercial:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=200 en columna nombreempresa");
				}

				this.nombreempresa=newnombreempresa;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setcodigo_cliente(String newcodigo_cliente)throws Exception
	{
		try {
			if(this.codigo_cliente!=newcodigo_cliente) {
				if(newcodigo_cliente==null) {
					//newcodigo_cliente="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("ReferenciaComercial:Valor nulo no permitido en columna codigo_cliente");
					}
				}

				if(newcodigo_cliente!=null&&newcodigo_cliente.length()>20) {
					newcodigo_cliente=newcodigo_cliente.substring(0,18);
					System.out.println("ReferenciaComercial:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=20 en columna codigo_cliente");
				}

				this.codigo_cliente=newcodigo_cliente;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setcontacto(String newcontacto)throws Exception
	{
		try {
			if(this.contacto!=newcontacto) {
				if(newcontacto==null) {
					//newcontacto="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("ReferenciaComercial:Valor nulo no permitido en columna contacto");
					}
				}

				if(newcontacto!=null&&newcontacto.length()>150) {
					newcontacto=newcontacto.substring(0,148);
					System.out.println("ReferenciaComercial:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=150 en columna contacto");
				}

				this.contacto=newcontacto;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setarticulo_compra(String newarticulo_compra)throws Exception
	{
		try {
			if(this.articulo_compra!=newarticulo_compra) {
				if(newarticulo_compra==null) {
					//newarticulo_compra="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("ReferenciaComercial:Valor nulo no permitido en columna articulo_compra");
					}
				}

				if(newarticulo_compra!=null&&newarticulo_compra.length()>150) {
					newarticulo_compra=newarticulo_compra.substring(0,148);
					System.out.println("ReferenciaComercial:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=150 en columna articulo_compra");
				}

				this.articulo_compra=newarticulo_compra;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setnumero_anios(Integer newnumero_anios)throws Exception
	{
		try {
			if(this.numero_anios!=newnumero_anios) {
				if(newnumero_anios==null) {
					//newnumero_anios=0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ReferenciaComercial:Valor nulo no permitido en columna numero_anios");
					}
				}

				this.numero_anios=newnumero_anios;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setnumero_meses(Integer newnumero_meses)throws Exception
	{
		try {
			if(this.numero_meses!=newnumero_meses) {
				if(newnumero_meses==null) {
					//newnumero_meses=0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ReferenciaComercial:Valor nulo no permitido en columna numero_meses");
					}
				}

				this.numero_meses=newnumero_meses;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_tipo_valoracion(Long newid_tipo_valoracion)throws Exception
	{
		try {
			if(this.id_tipo_valoracion!=newid_tipo_valoracion) {
				if(newid_tipo_valoracion==null) {
					//newid_tipo_valoracion=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ReferenciaComercial:Valor nulo no permitido en columna id_tipo_valoracion");
					}
				}

				this.id_tipo_valoracion=newid_tipo_valoracion;
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
						System.out.println("ReferenciaComercial:Valor nulo no permitido en columna direccion");
					}
				}

				if(newdireccion!=null&&newdireccion.length()>250) {
					newdireccion=newdireccion.substring(0,248);
					System.out.println("ReferenciaComercial:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=250 en columna direccion");
				}

				this.direccion=newdireccion;
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
						System.out.println("ReferenciaComercial:Valor nulo no permitido en columna telefono");
					}
				}

				if(newtelefono!=null&&newtelefono.length()>200) {
					newtelefono=newtelefono.substring(0,198);
					System.out.println("ReferenciaComercial:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=200 en columna telefono");
				}

				this.telefono=newtelefono;
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
						System.out.println("ReferenciaComercial:Valor nulo no permitido en columna telefonomovil");
					}
				}

				if(newtelefonomovil!=null&&newtelefonomovil.length()>200) {
					newtelefonomovil=newtelefonomovil.substring(0,198);
					System.out.println("ReferenciaComercial:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=200 en columna telefonomovil");
				}

				this.telefonomovil=newtelefonomovil;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void settelefonocodigoarea(String newtelefonocodigoarea)throws Exception
	{
		try {
			if(this.telefonocodigoarea!=newtelefonocodigoarea) {
				if(newtelefonocodigoarea==null) {
					//newtelefonocodigoarea="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("ReferenciaComercial:Valor nulo no permitido en columna telefonocodigoarea");
					}
				}

				if(newtelefonocodigoarea!=null&&newtelefonocodigoarea.length()>50) {
					newtelefonocodigoarea=newtelefonocodigoarea.substring(0,48);
					System.out.println("ReferenciaComercial:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=50 en columna telefonocodigoarea");
				}

				this.telefonocodigoarea=newtelefonocodigoarea;
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
						System.out.println("ReferenciaComercial:Valor nulo no permitido en columna email");
					}
				}

				if(newemail!=null&&newemail.length()>200) {
					newemail=newemail.substring(0,198);
					System.out.println("ReferenciaComercial:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=200 en columna email");
				}

				this.email=newemail;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setmonto(Double newmonto)throws Exception
	{
		try {
			if(this.monto!=newmonto) {
				if(newmonto==null) {
					//newmonto=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ReferenciaComercial:Valor nulo no permitido en columna monto");
					}
				}

				this.monto=newmonto;
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
						System.out.println("ReferenciaComercial:Valor nulo no permitido en columna esactivo");
					}
				}

				this.esactivo=newesactivo;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	
	public Empresa getEmpresa() {
		return this.empresa;
	}

	public Cliente getCliente() {
		return this.cliente;
	}

	public TipoSectorEcono getTipoSectorEcono() {
		return this.tiposectorecono;
	}

	public Pais getPais() {
		return this.pais;
	}

	public Ciudad getCiudad() {
		return this.ciudad;
	}

	public TipoValoracion getTipoValoracion() {
		return this.tipovaloracion;
	}

	
	
	public String getempresa_descripcion() {
		return this.empresa_descripcion;
	}

	public String getcliente_descripcion() {
		return this.cliente_descripcion;
	}

	public String gettiposectorecono_descripcion() {
		return this.tiposectorecono_descripcion;
	}

	public String getpais_descripcion() {
		return this.pais_descripcion;
	}

	public String getciudad_descripcion() {
		return this.ciudad_descripcion;
	}

	public String gettipovaloracion_descripcion() {
		return this.tipovaloracion_descripcion;
	}

	
	
	public  void  setEmpresa(Empresa empresa) {
		try {
			this.empresa=empresa;
		} catch(Exception e) {
			;
		}
	}


	public  void  setCliente(Cliente cliente) {
		try {
			this.cliente=cliente;
		} catch(Exception e) {
			;
		}
	}


	public  void  setTipoSectorEcono(TipoSectorEcono tiposectorecono) {
		try {
			this.tiposectorecono=tiposectorecono;
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


	public  void  setTipoValoracion(TipoValoracion tipovaloracion) {
		try {
			this.tipovaloracion=tipovaloracion;
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


	public  void  setcliente_descripcion(String cliente_descripcion) {
		try {
			this.cliente_descripcion=cliente_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  settiposectorecono_descripcion(String tiposectorecono_descripcion) {
		try {
			this.tiposectorecono_descripcion=tiposectorecono_descripcion;
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


	public  void  settipovaloracion_descripcion(String tipovaloracion_descripcion) {
		try {
			this.tipovaloracion_descripcion=tipovaloracion_descripcion;
		} catch(Exception e) {
			;
		}
	}


	
	
	
	
	
	/*PARA REPORTES*/
	String id_empresa_descripcion="";String idcliente_descripcion="";String idvalorclientesectoreconomico_descripcion="";String id_pais_descripcion="";String idciudad_descripcion="";String id_tipo_valoracion_descripcion="";String esactivo_descripcion="";
	
	
	public String getid_empresa_descripcion() {
		return id_empresa_descripcion;
	}
	public String getidcliente_descripcion() {
		return idcliente_descripcion;
	}
	public String getidvalorclientesectoreconomico_descripcion() {
		return idvalorclientesectoreconomico_descripcion;
	}
	public String getid_pais_descripcion() {
		return id_pais_descripcion;
	}
	public String getidciudad_descripcion() {
		return idciudad_descripcion;
	}
	public String getid_tipo_valoracion_descripcion() {
		return id_tipo_valoracion_descripcion;
	}
	public String getesactivo_descripcion() {
		return esactivo_descripcion;
	}
	
	
	public void setid_empresa_descripcion(String newid_empresa_descripcion)throws Exception {
		try {
			this.id_empresa_descripcion=newid_empresa_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setidcliente_descripcion(String newidcliente_descripcion)throws Exception {
		try {
			this.idcliente_descripcion=newidcliente_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setidvalorclientesectoreconomico_descripcion(String newidvalorclientesectoreconomico_descripcion)throws Exception {
		try {
			this.idvalorclientesectoreconomico_descripcion=newidvalorclientesectoreconomico_descripcion;
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
	public void setid_tipo_valoracion_descripcion(String newid_tipo_valoracion_descripcion)throws Exception {
		try {
			this.id_tipo_valoracion_descripcion=newid_tipo_valoracion_descripcion;
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
		this.id_empresa_descripcion="";this.idcliente_descripcion="";this.idvalorclientesectoreconomico_descripcion="";this.id_pais_descripcion="";this.idciudad_descripcion="";this.id_tipo_valoracion_descripcion="";this.esactivo_descripcion="";
	}
	
	
	
	
	
	
	/*PARA REPORTES FIN*/		
}

