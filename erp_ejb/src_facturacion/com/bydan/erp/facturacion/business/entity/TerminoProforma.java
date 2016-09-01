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
package com.bydan.erp.facturacion.business.entity;

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
//import com.bydan.erp.facturacion.util.TerminoProformaConstantesFunciones;
import com.bydan.erp.facturacion.util.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.contabilidad.util.*;



import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;




@SuppressWarnings("unused")
public class TerminoProforma extends TerminoProformaAdditional implements Serializable ,Cloneable {//TerminoProformaAdditional,GeneralEntity
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
	
	private TerminoProforma terminoproformaOriginal;
	
	private Map<String, Object> mapTerminoProforma;
			
	public Map<String, Object> getMapTerminoProforma() {
		return mapTerminoProforma;
	}

	public void setMapTerminoProforma(Map<String, Object> mapTerminoProforma) {
		this.mapTerminoProforma = mapTerminoProforma;
	}
	
	public void inicializarMapTerminoProforma() {
		this.mapTerminoProforma = new HashMap<String,Object>();
	}
	
	public void setMapTerminoProformaValue(String sKey,Object oValue) {
		this.mapTerminoProforma.put(sKey, oValue);
	}
	
	public Object getMapTerminoProformaValue(String sKey) {
		return this.mapTerminoProforma.get(sKey);
	}
	
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_empresa;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_sucursal;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_moneda;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=-100000,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_proforma;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=150,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=TerminoProformaConstantesFunciones.SREGEXATENCION,message=TerminoProformaConstantesFunciones.SMENSAJEREGEXATENCION)
	private String atencion;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=50,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=TerminoProformaConstantesFunciones.SREGEXREGISTRO_SANITARIO,message=TerminoProformaConstantesFunciones.SMENSAJEREGEXREGISTRO_SANITARIO)
	private String registro_sanitario;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=250,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=TerminoProformaConstantesFunciones.SREGEXREFERENCIA,message=TerminoProformaConstantesFunciones.SMENSAJEREGEXREFERENCIA)
	private String referencia;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=250,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=TerminoProformaConstantesFunciones.SREGEXDESCRIPCION,message=TerminoProformaConstantesFunciones.SMENSAJEREGEXDESCRIPCION)
	private String descripcion;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=250,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=TerminoProformaConstantesFunciones.SREGEXDESCRIPCION2,message=TerminoProformaConstantesFunciones.SMENSAJEREGEXDESCRIPCION2)
	private String descripcion2;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=50,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=TerminoProformaConstantesFunciones.SREGEXMARCA,message=TerminoProformaConstantesFunciones.SMENSAJEREGEXMARCA)
	private String marca;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=50,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=TerminoProformaConstantesFunciones.SREGEXORIGEN,message=TerminoProformaConstantesFunciones.SMENSAJEREGEXORIGEN)
	private String origen;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=50,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=TerminoProformaConstantesFunciones.SREGEXGARANTIA_TECNICA,message=TerminoProformaConstantesFunciones.SMENSAJEREGEXGARANTIA_TECNICA)
	private String garantia_tecnica;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=50,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=TerminoProformaConstantesFunciones.SREGEXFECHA_PAGO,message=TerminoProformaConstantesFunciones.SMENSAJEREGEXFECHA_PAGO)
	private String fecha_pago;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=50,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=TerminoProformaConstantesFunciones.SREGEXFECHA_ENTREGA,message=TerminoProformaConstantesFunciones.SMENSAJEREGEXFECHA_ENTREGA)
	private String fecha_entrega;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=250,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=TerminoProformaConstantesFunciones.SREGEXADJUNTO,message=TerminoProformaConstantesFunciones.SMENSAJEREGEXADJUNTO)
	private String adjunto;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=100,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=TerminoProformaConstantesFunciones.SREGEXRESPONSABLE,message=TerminoProformaConstantesFunciones.SMENSAJEREGEXRESPONSABLE)
	private String responsable;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=50,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=TerminoProformaConstantesFunciones.SREGEXCARGO,message=TerminoProformaConstantesFunciones.SMENSAJEREGEXCARGO)
	private String cargo;
			
	
	public Empresa empresa;
	public Sucursal sucursal;
	public Moneda moneda;
	public Proforma proforma;
	
	
	private String empresa_descripcion;
	private String sucursal_descripcion;
	private String moneda_descripcion;
	private String proforma_descripcion;
	
	
	public List<DetalleTerminoProforma> detalleterminoproformas;
		
	public TerminoProforma () throws Exception {
		super();		
		
		this.id=0L;
		
		
		this.versionRow=new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());//new Date();
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		this.sType="NONE";
		
		this.terminoproformaOriginal=this;
		
 		this.id_empresa=-1L;
 		this.id_sucursal=-1L;
 		this.id_moneda=-1L;
 		this.id_proforma=-1L;
 		this.atencion="";
 		this.registro_sanitario="";
 		this.referencia="";
 		this.descripcion="";
 		this.descripcion2="";
 		this.marca="";
 		this.origen="";
 		this.garantia_tecnica="";
 		this.fecha_pago="";
 		this.fecha_entrega="";
 		this.adjunto="";
 		this.responsable="";
 		this.cargo="";
		
		
		this.empresa=null;
		this.sucursal=null;
		this.moneda=null;
		this.proforma=null;
		
		
		this.empresa_descripcion="";
		this.sucursal_descripcion="";
		this.moneda_descripcion="";
		this.proforma_descripcion="";
		
		
		this.detalleterminoproformas=null;
		
			
		
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
    //PARA REPORTES
	public TerminoProforma (Long id,Date versionRow,Long id_empresa,Long id_sucursal,Long id_moneda,Long id_proforma,String atencion,String registro_sanitario,String referencia,String descripcion,String descripcion2,String marca,String origen,String garantia_tecnica,String fecha_pago,String fecha_entrega,String adjunto,String responsable,String cargo) throws Exception {
		super();		
		
		this.id=id;
		this.versionRow=versionRow;
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.terminoproformaOriginal=this;
		
 		this.id_empresa=id_empresa;
 		this.id_sucursal=id_sucursal;
 		this.id_moneda=id_moneda;
 		this.id_proforma=id_proforma;
 		this.atencion=atencion;
 		this.registro_sanitario=registro_sanitario;
 		this.referencia=referencia;
 		this.descripcion=descripcion;
 		this.descripcion2=descripcion2;
 		this.marca=marca;
 		this.origen=origen;
 		this.garantia_tecnica=garantia_tecnica;
 		this.fecha_pago=fecha_pago;
 		this.fecha_entrega=fecha_entrega;
 		this.adjunto=adjunto;
 		this.responsable=responsable;
 		this.cargo=cargo;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	 //PARA REPORTES
	public TerminoProforma (Long id_empresa,Long id_sucursal,Long id_moneda,Long id_proforma,String atencion,String registro_sanitario,String referencia,String descripcion,String descripcion2,String marca,String origen,String garantia_tecnica,String fecha_pago,String fecha_entrega,String adjunto,String responsable,String cargo) throws Exception {
		super();		
		
		this.id=0L;
		this.versionRow=new Date();
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.terminoproformaOriginal=this;
		
 		this.id_empresa=id_empresa;
 		this.id_sucursal=id_sucursal;
 		this.id_moneda=id_moneda;
 		this.id_proforma=id_proforma;
 		this.atencion=atencion;
 		this.registro_sanitario=registro_sanitario;
 		this.referencia=referencia;
 		this.descripcion=descripcion;
 		this.descripcion2=descripcion2;
 		this.marca=marca;
 		this.origen=origen;
 		this.garantia_tecnica=garantia_tecnica;
 		this.fecha_pago=fecha_pago;
 		this.fecha_entrega=fecha_entrega;
 		this.adjunto=adjunto;
 		this.responsable=responsable;
 		this.cargo=cargo;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	public boolean equals(Object object) {
		boolean equal=false;
		TerminoProforma terminoproformaLocal=null;
		
		if(object!=null) {
			terminoproformaLocal=(TerminoProforma)object;
			
			if(terminoproformaLocal!=null) {
				if(this.getId()!=null && terminoproformaLocal.getId()!=null) {
					if(this.getId().equals(terminoproformaLocal.getId())) {
						equal=true;
					}
				}
			}
		}
		
		return equal;
	}
	
	public String toString() {
		String sDetalle="";
		
		if(!TerminoProformaConstantesFunciones.CON_DESCRIPCION_DETALLADO) {
        	sDetalle=TerminoProformaConstantesFunciones.getTerminoProformaDescripcion(this);
		} else {
			sDetalle=TerminoProformaConstantesFunciones.getTerminoProformaDescripcionDetallado(this);
		}
		
		return sDetalle;
    }
	
	public TerminoProforma getTerminoProformaOriginal() {
		return this.terminoproformaOriginal;
	}
	
	public void setTerminoProformaOriginal(TerminoProforma terminoproforma) {
		try {
			this.terminoproformaOriginal=terminoproforma;
		} catch(Exception e) {
			;
		}
	}
	
	
	protected TerminoProformaAdditional terminoproformaAdditional=null;
	
	public TerminoProformaAdditional getTerminoProformaAdditional() {
		return this.terminoproformaAdditional;
	}
	
	public void setTerminoProformaAdditional(TerminoProformaAdditional terminoproformaAdditional) {
		try {
			this.terminoproformaAdditional=terminoproformaAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
    
	
	public Long getid_empresa() {
		return this.id_empresa;
	}
    
	
	public Long getid_sucursal() {
		return this.id_sucursal;
	}
    
	
	public Long getid_moneda() {
		return this.id_moneda;
	}
    
	
	public Long getid_proforma() {
		return this.id_proforma;
	}
    
	
	public String getatencion() {
		return this.atencion;
	}
    
	
	public String getregistro_sanitario() {
		return this.registro_sanitario;
	}
    
	
	public String getreferencia() {
		return this.referencia;
	}
    
	
	public String getdescripcion() {
		return this.descripcion;
	}
    
	
	public String getdescripcion2() {
		return this.descripcion2;
	}
    
	
	public String getmarca() {
		return this.marca;
	}
    
	
	public String getorigen() {
		return this.origen;
	}
    
	
	public String getgarantia_tecnica() {
		return this.garantia_tecnica;
	}
    
	
	public String getfecha_pago() {
		return this.fecha_pago;
	}
    
	
	public String getfecha_entrega() {
		return this.fecha_entrega;
	}
    
	
	public String getadjunto() {
		return this.adjunto;
	}
    
	
	public String getresponsable() {
		return this.responsable;
	}
    
	
	public String getcargo() {
		return this.cargo;
	}
	
    
	public void setid_empresa(Long newid_empresa)throws Exception
	{
		try {
			if(this.id_empresa!=newid_empresa) {
				if(newid_empresa==null) {
					//newid_empresa=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("TerminoProforma:Valor nulo no permitido en columna id_empresa");
					}
				}

				this.id_empresa=newid_empresa;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_sucursal(Long newid_sucursal)throws Exception
	{
		try {
			if(this.id_sucursal!=newid_sucursal) {
				if(newid_sucursal==null) {
					//newid_sucursal=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("TerminoProforma:Valor nulo no permitido en columna id_sucursal");
					}
				}

				this.id_sucursal=newid_sucursal;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_moneda(Long newid_moneda)throws Exception
	{
		try {
			if(this.id_moneda!=newid_moneda) {
				if(newid_moneda==null) {
					//newid_moneda=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("TerminoProforma:Valor nulo no permitido en columna id_moneda");
					}
				}

				this.id_moneda=newid_moneda;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_proforma(Long newid_proforma)throws Exception
	{
		try {
			if(this.id_proforma!=newid_proforma) {
				if(newid_proforma==null) {
					//newid_proforma=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("TerminoProforma:Valor nulo no permitido en columna id_proforma");
					}
				}

				this.id_proforma=newid_proforma;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setatencion(String newatencion)throws Exception
	{
		try {
			if(this.atencion!=newatencion) {
				if(newatencion==null) {
					//newatencion="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("TerminoProforma:Valor nulo no permitido en columna atencion");
					}
				}

				if(newatencion!=null&&newatencion.length()>150) {
					newatencion=newatencion.substring(0,148);
					System.out.println("TerminoProforma:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=150 en columna atencion");
				}

				this.atencion=newatencion;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setregistro_sanitario(String newregistro_sanitario)throws Exception
	{
		try {
			if(this.registro_sanitario!=newregistro_sanitario) {
				if(newregistro_sanitario==null) {
					//newregistro_sanitario="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("TerminoProforma:Valor nulo no permitido en columna registro_sanitario");
					}
				}

				if(newregistro_sanitario!=null&&newregistro_sanitario.length()>50) {
					newregistro_sanitario=newregistro_sanitario.substring(0,48);
					System.out.println("TerminoProforma:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=50 en columna registro_sanitario");
				}

				this.registro_sanitario=newregistro_sanitario;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setreferencia(String newreferencia)throws Exception
	{
		try {
			if(this.referencia!=newreferencia) {
				if(newreferencia==null) {
					//newreferencia="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("TerminoProforma:Valor nulo no permitido en columna referencia");
					}
				}

				if(newreferencia!=null&&newreferencia.length()>250) {
					newreferencia=newreferencia.substring(0,248);
					System.out.println("TerminoProforma:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=250 en columna referencia");
				}

				this.referencia=newreferencia;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setdescripcion(String newdescripcion)throws Exception
	{
		try {
			if(this.descripcion!=newdescripcion) {
				if(newdescripcion==null) {
					//newdescripcion="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("TerminoProforma:Valor nulo no permitido en columna descripcion");
					}
				}

				if(newdescripcion!=null&&newdescripcion.length()>250) {
					newdescripcion=newdescripcion.substring(0,248);
					System.out.println("TerminoProforma:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=250 en columna descripcion");
				}

				this.descripcion=newdescripcion;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setdescripcion2(String newdescripcion2)throws Exception
	{
		try {
			if(this.descripcion2!=newdescripcion2) {
				if(newdescripcion2==null) {
					//newdescripcion2="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("TerminoProforma:Valor nulo no permitido en columna descripcion2");
					}
				}

				if(newdescripcion2!=null&&newdescripcion2.length()>250) {
					newdescripcion2=newdescripcion2.substring(0,248);
					System.out.println("TerminoProforma:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=250 en columna descripcion2");
				}

				this.descripcion2=newdescripcion2;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setmarca(String newmarca)throws Exception
	{
		try {
			if(this.marca!=newmarca) {
				if(newmarca==null) {
					//newmarca="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("TerminoProforma:Valor nulo no permitido en columna marca");
					}
				}

				if(newmarca!=null&&newmarca.length()>50) {
					newmarca=newmarca.substring(0,48);
					System.out.println("TerminoProforma:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=50 en columna marca");
				}

				this.marca=newmarca;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setorigen(String neworigen)throws Exception
	{
		try {
			if(this.origen!=neworigen) {
				if(neworigen==null) {
					//neworigen="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("TerminoProforma:Valor nulo no permitido en columna origen");
					}
				}

				if(neworigen!=null&&neworigen.length()>50) {
					neworigen=neworigen.substring(0,48);
					System.out.println("TerminoProforma:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=50 en columna origen");
				}

				this.origen=neworigen;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setgarantia_tecnica(String newgarantia_tecnica)throws Exception
	{
		try {
			if(this.garantia_tecnica!=newgarantia_tecnica) {
				if(newgarantia_tecnica==null) {
					//newgarantia_tecnica="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("TerminoProforma:Valor nulo no permitido en columna garantia_tecnica");
					}
				}

				if(newgarantia_tecnica!=null&&newgarantia_tecnica.length()>50) {
					newgarantia_tecnica=newgarantia_tecnica.substring(0,48);
					System.out.println("TerminoProforma:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=50 en columna garantia_tecnica");
				}

				this.garantia_tecnica=newgarantia_tecnica;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setfecha_pago(String newfecha_pago)throws Exception
	{
		try {
			if(this.fecha_pago!=newfecha_pago) {
				if(newfecha_pago==null) {
					//newfecha_pago="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("TerminoProforma:Valor nulo no permitido en columna fecha_pago");
					}
				}

				if(newfecha_pago!=null&&newfecha_pago.length()>50) {
					newfecha_pago=newfecha_pago.substring(0,48);
					System.out.println("TerminoProforma:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=50 en columna fecha_pago");
				}

				this.fecha_pago=newfecha_pago;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setfecha_entrega(String newfecha_entrega)throws Exception
	{
		try {
			if(this.fecha_entrega!=newfecha_entrega) {
				if(newfecha_entrega==null) {
					//newfecha_entrega="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("TerminoProforma:Valor nulo no permitido en columna fecha_entrega");
					}
				}

				if(newfecha_entrega!=null&&newfecha_entrega.length()>50) {
					newfecha_entrega=newfecha_entrega.substring(0,48);
					System.out.println("TerminoProforma:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=50 en columna fecha_entrega");
				}

				this.fecha_entrega=newfecha_entrega;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setadjunto(String newadjunto)throws Exception
	{
		try {
			if(this.adjunto!=newadjunto) {
				if(newadjunto==null) {
					//newadjunto="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("TerminoProforma:Valor nulo no permitido en columna adjunto");
					}
				}

				if(newadjunto!=null&&newadjunto.length()>250) {
					newadjunto=newadjunto.substring(0,248);
					System.out.println("TerminoProforma:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=250 en columna adjunto");
				}

				this.adjunto=newadjunto;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setresponsable(String newresponsable)throws Exception
	{
		try {
			if(this.responsable!=newresponsable) {
				if(newresponsable==null) {
					//newresponsable="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("TerminoProforma:Valor nulo no permitido en columna responsable");
					}
				}

				if(newresponsable!=null&&newresponsable.length()>100) {
					newresponsable=newresponsable.substring(0,98);
					System.out.println("TerminoProforma:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=100 en columna responsable");
				}

				this.responsable=newresponsable;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setcargo(String newcargo)throws Exception
	{
		try {
			if(this.cargo!=newcargo) {
				if(newcargo==null) {
					//newcargo="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("TerminoProforma:Valor nulo no permitido en columna cargo");
					}
				}

				if(newcargo!=null&&newcargo.length()>50) {
					newcargo=newcargo.substring(0,48);
					System.out.println("TerminoProforma:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=50 en columna cargo");
				}

				this.cargo=newcargo;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	
	public Empresa getEmpresa() {
		return this.empresa;
	}

	public Sucursal getSucursal() {
		return this.sucursal;
	}

	public Moneda getMoneda() {
		return this.moneda;
	}

	public Proforma getProforma() {
		return this.proforma;
	}

	
	
	public String getempresa_descripcion() {
		return this.empresa_descripcion;
	}

	public String getsucursal_descripcion() {
		return this.sucursal_descripcion;
	}

	public String getmoneda_descripcion() {
		return this.moneda_descripcion;
	}

	public String getproforma_descripcion() {
		return this.proforma_descripcion;
	}

	
	
	public  void  setEmpresa(Empresa empresa) {
		try {
			this.empresa=empresa;
		} catch(Exception e) {
			;
		}
	}


	public  void  setSucursal(Sucursal sucursal) {
		try {
			this.sucursal=sucursal;
		} catch(Exception e) {
			;
		}
	}


	public  void  setMoneda(Moneda moneda) {
		try {
			this.moneda=moneda;
		} catch(Exception e) {
			;
		}
	}


	public  void  setProforma(Proforma proforma) {
		try {
			this.proforma=proforma;
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


	public  void  setsucursal_descripcion(String sucursal_descripcion) {
		try {
			this.sucursal_descripcion=sucursal_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  setmoneda_descripcion(String moneda_descripcion) {
		try {
			this.moneda_descripcion=moneda_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  setproforma_descripcion(String proforma_descripcion) {
		try {
			this.proforma_descripcion=proforma_descripcion;
		} catch(Exception e) {
			;
		}
	}


	
	
	public List<DetalleTerminoProforma> getDetalleTerminoProformas() {
		return this.detalleterminoproformas;
	}

	
	
	public  void  setDetalleTerminoProformas(List<DetalleTerminoProforma> detalleterminoproformas) {
		try {
			this.detalleterminoproformas=detalleterminoproformas;
		} catch(Exception e) {
			;
		}
	}

	
	/*PARA REPORTES*/
	String id_empresa_descripcion="";String id_sucursal_descripcion="";String id_moneda_descripcion="";String id_proforma_descripcion="";
	
	
	public String getid_empresa_descripcion() {
		return id_empresa_descripcion;
	}
	public String getid_sucursal_descripcion() {
		return id_sucursal_descripcion;
	}
	public String getid_moneda_descripcion() {
		return id_moneda_descripcion;
	}
	public String getid_proforma_descripcion() {
		return id_proforma_descripcion;
	}
	
	
	public void setid_empresa_descripcion(String newid_empresa_descripcion)throws Exception {
		try {
			this.id_empresa_descripcion=newid_empresa_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_sucursal_descripcion(String newid_sucursal_descripcion)throws Exception {
		try {
			this.id_sucursal_descripcion=newid_sucursal_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_moneda_descripcion(String newid_moneda_descripcion)throws Exception {
		try {
			this.id_moneda_descripcion=newid_moneda_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_proforma_descripcion(String newid_proforma_descripcion)throws Exception {
		try {
			this.id_proforma_descripcion=newid_proforma_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	
	public void inicializarVariablesParaReporte() {
		this.id_empresa_descripcion="";this.id_sucursal_descripcion="";this.id_moneda_descripcion="";this.id_proforma_descripcion="";
	}
	
	
	Object detalleterminoproformasDescripcionReporte;
	
	
	public Object getdetalleterminoproformasDescripcionReporte() {
		return detalleterminoproformasDescripcionReporte;
	}

	
	
	public  void  setdetalleterminoproformasDescripcionReporte(Object detalleterminoproformas) {
		try {
			this.detalleterminoproformasDescripcionReporte=detalleterminoproformas;
		} catch(Exception ex) {
			;
		}
	}

	/*PARA REPORTES FIN*/		
}

