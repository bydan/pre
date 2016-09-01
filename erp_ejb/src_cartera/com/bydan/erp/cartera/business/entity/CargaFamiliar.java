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
//import com.bydan.erp.cartera.util.CargaFamiliarConstantesFunciones;
import com.bydan.erp.cartera.util.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.nomina.util.*;



import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.nomina.business.entity.*;




@SuppressWarnings("unused")
public class CargaFamiliar extends CargaFamiliarAdditional implements Serializable ,Cloneable {//CargaFamiliarAdditional,GeneralEntity
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
	
	private CargaFamiliar cargafamiliarOriginal;
	
	private Map<String, Object> mapCargaFamiliar;
			
	public Map<String, Object> getMapCargaFamiliar() {
		return mapCargaFamiliar;
	}

	public void setMapCargaFamiliar(Map<String, Object> mapCargaFamiliar) {
		this.mapCargaFamiliar = mapCargaFamiliar;
	}
	
	public void inicializarMapCargaFamiliar() {
		this.mapCargaFamiliar = new HashMap<String,Object>();
	}
	
	public void setMapCargaFamiliarValue(String sKey,Object oValue) {
		this.mapCargaFamiliar.put(sKey, oValue);
	}
	
	public Object getMapCargaFamiliarValue(String sKey) {
		return this.mapCargaFamiliar.get(sKey);
	}
	
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_empresa;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_cliente;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_tipo_carga_fami;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_tipo_genero;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_estado_civil;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=15,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=CargaFamiliarConstantesFunciones.SREGEXCEDULA,message=CargaFamiliarConstantesFunciones.SMENSAJEREGEXCEDULA)
	private String cedula;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=100,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=CargaFamiliarConstantesFunciones.SREGEXAPELLIDO,message=CargaFamiliarConstantesFunciones.SMENSAJEREGEXAPELLIDO)
	private String apellido;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=100,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=CargaFamiliarConstantesFunciones.SREGEXNOMBRE,message=CargaFamiliarConstantesFunciones.SMENSAJEREGEXNOMBRE)
	private String nombre;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=200,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=CargaFamiliarConstantesFunciones.SREGEXDIRECCION,message=CargaFamiliarConstantesFunciones.SMENSAJEREGEXDIRECCION)
	private String direccion;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Date fecha_nacimiento;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double valor_cupo;
			
	
	public Empresa empresa;
	public Cliente cliente;
	public TipoCargaFami tipocargafami;
	public TipoGenero tipogenero;
	public EstadoCivil estadocivil;
	
	
	private String empresa_descripcion;
	private String cliente_descripcion;
	private String tipocargafami_descripcion;
	private String tipogenero_descripcion;
	private String estadocivil_descripcion;
	
	
		
	public CargaFamiliar () throws Exception {
		super();		
		
		this.id=0L;
		
		
		this.versionRow=new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());//new Date();
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		this.sType="NONE";
		
		this.cargafamiliarOriginal=this;
		
 		this.id_empresa=-1L;
 		this.id_cliente=-1L;
 		this.id_tipo_carga_fami=-1L;
 		this.id_tipo_genero=-1L;
 		this.id_estado_civil=-1L;
 		this.cedula="";
 		this.apellido="";
 		this.nombre="";
 		this.direccion="";
 		this.fecha_nacimiento=new Date();
 		this.valor_cupo=0.0;
		
		
		this.empresa=null;
		this.cliente=null;
		this.tipocargafami=null;
		this.tipogenero=null;
		this.estadocivil=null;
		
		
		this.empresa_descripcion="";
		this.cliente_descripcion="";
		this.tipocargafami_descripcion="";
		this.tipogenero_descripcion="";
		this.estadocivil_descripcion="";
		
		
		
			
		
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
    //PARA REPORTES
	public CargaFamiliar (Long id,Date versionRow,Long id_empresa,Long id_cliente,Long id_tipo_carga_fami,Long id_tipo_genero,Long id_estado_civil,String cedula,String apellido,String nombre,String direccion,Date fecha_nacimiento,Double valor_cupo) throws Exception {
		super();		
		
		this.id=id;
		this.versionRow=versionRow;
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.cargafamiliarOriginal=this;
		
 		this.id_empresa=id_empresa;
 		this.id_cliente=id_cliente;
 		this.id_tipo_carga_fami=id_tipo_carga_fami;
 		this.id_tipo_genero=id_tipo_genero;
 		this.id_estado_civil=id_estado_civil;
 		this.cedula=cedula;
 		this.apellido=apellido;
 		this.nombre=nombre;
 		this.direccion=direccion;
 		this.fecha_nacimiento=fecha_nacimiento;
 		this.valor_cupo=valor_cupo;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	 //PARA REPORTES
	public CargaFamiliar (Long id_empresa,Long id_cliente,Long id_tipo_carga_fami,Long id_tipo_genero,Long id_estado_civil,String cedula,String apellido,String nombre,String direccion,Date fecha_nacimiento,Double valor_cupo) throws Exception {
		super();		
		
		this.id=0L;
		this.versionRow=new Date();
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.cargafamiliarOriginal=this;
		
 		this.id_empresa=id_empresa;
 		this.id_cliente=id_cliente;
 		this.id_tipo_carga_fami=id_tipo_carga_fami;
 		this.id_tipo_genero=id_tipo_genero;
 		this.id_estado_civil=id_estado_civil;
 		this.cedula=cedula;
 		this.apellido=apellido;
 		this.nombre=nombre;
 		this.direccion=direccion;
 		this.fecha_nacimiento=fecha_nacimiento;
 		this.valor_cupo=valor_cupo;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	public boolean equals(Object object) {
		boolean equal=false;
		CargaFamiliar cargafamiliarLocal=null;
		
		if(object!=null) {
			cargafamiliarLocal=(CargaFamiliar)object;
			
			if(cargafamiliarLocal!=null) {
				if(this.getId()!=null && cargafamiliarLocal.getId()!=null) {
					if(this.getId().equals(cargafamiliarLocal.getId())) {
						equal=true;
					}
				}
			}
		}
		
		return equal;
	}
	
	public String toString() {
		String sDetalle="";
		
		if(!CargaFamiliarConstantesFunciones.CON_DESCRIPCION_DETALLADO) {
        	sDetalle=CargaFamiliarConstantesFunciones.getCargaFamiliarDescripcion(this);
		} else {
			sDetalle=CargaFamiliarConstantesFunciones.getCargaFamiliarDescripcionDetallado(this);
		}
		
		return sDetalle;
    }
	
	public CargaFamiliar getCargaFamiliarOriginal() {
		return this.cargafamiliarOriginal;
	}
	
	public void setCargaFamiliarOriginal(CargaFamiliar cargafamiliar) {
		try {
			this.cargafamiliarOriginal=cargafamiliar;
		} catch(Exception e) {
			;
		}
	}
	
	
	protected CargaFamiliarAdditional cargafamiliarAdditional=null;
	
	public CargaFamiliarAdditional getCargaFamiliarAdditional() {
		return this.cargafamiliarAdditional;
	}
	
	public void setCargaFamiliarAdditional(CargaFamiliarAdditional cargafamiliarAdditional) {
		try {
			this.cargafamiliarAdditional=cargafamiliarAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
    
	
	public Long getid_empresa() {
		return this.id_empresa;
	}
    
	
	public Long getid_cliente() {
		return this.id_cliente;
	}
    
	
	public Long getid_tipo_carga_fami() {
		return this.id_tipo_carga_fami;
	}
    
	
	public Long getid_tipo_genero() {
		return this.id_tipo_genero;
	}
    
	
	public Long getid_estado_civil() {
		return this.id_estado_civil;
	}
    
	
	public String getcedula() {
		return this.cedula;
	}
    
	
	public String getapellido() {
		return this.apellido;
	}
    
	
	public String getnombre() {
		return this.nombre;
	}
    
	
	public String getdireccion() {
		return this.direccion;
	}
    
	
	public Date getfecha_nacimiento() {
		return this.fecha_nacimiento;
	}
    
	
	public Double getvalor_cupo() {
		return this.valor_cupo;
	}
	
    
	public void setid_empresa(Long newid_empresa)throws Exception
	{
		try {
			if(this.id_empresa!=newid_empresa) {
				if(newid_empresa==null) {
					//newid_empresa=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("CargaFamiliar:Valor nulo no permitido en columna id_empresa");
					}
				}

				this.id_empresa=newid_empresa;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_cliente(Long newid_cliente)throws Exception
	{
		try {
			if(this.id_cliente!=newid_cliente) {
				if(newid_cliente==null) {
					//newid_cliente=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("CargaFamiliar:Valor nulo no permitido en columna id_cliente");
					}
				}

				this.id_cliente=newid_cliente;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_tipo_carga_fami(Long newid_tipo_carga_fami)throws Exception
	{
		try {
			if(this.id_tipo_carga_fami!=newid_tipo_carga_fami) {
				if(newid_tipo_carga_fami==null) {
					//newid_tipo_carga_fami=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("CargaFamiliar:Valor nulo no permitido en columna id_tipo_carga_fami");
					}
				}

				this.id_tipo_carga_fami=newid_tipo_carga_fami;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_tipo_genero(Long newid_tipo_genero)throws Exception
	{
		try {
			if(this.id_tipo_genero!=newid_tipo_genero) {
				if(newid_tipo_genero==null) {
					//newid_tipo_genero=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("CargaFamiliar:Valor nulo no permitido en columna id_tipo_genero");
					}
				}

				this.id_tipo_genero=newid_tipo_genero;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_estado_civil(Long newid_estado_civil)throws Exception
	{
		try {
			if(this.id_estado_civil!=newid_estado_civil) {
				if(newid_estado_civil==null) {
					//newid_estado_civil=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("CargaFamiliar:Valor nulo no permitido en columna id_estado_civil");
					}
				}

				this.id_estado_civil=newid_estado_civil;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setcedula(String newcedula)throws Exception
	{
		try {
			if(this.cedula!=newcedula) {
				if(newcedula==null) {
					//newcedula="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("CargaFamiliar:Valor nulo no permitido en columna cedula");
					}
				}

				if(newcedula!=null&&newcedula.length()>15) {
					newcedula=newcedula.substring(0,13);
					System.out.println("CargaFamiliar:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=15 en columna cedula");
				}

				this.cedula=newcedula;
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
						System.out.println("CargaFamiliar:Valor nulo no permitido en columna apellido");
					}
				}

				if(newapellido!=null&&newapellido.length()>100) {
					newapellido=newapellido.substring(0,98);
					System.out.println("CargaFamiliar:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=100 en columna apellido");
				}

				this.apellido=newapellido;
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
						System.out.println("CargaFamiliar:Valor nulo no permitido en columna nombre");
					}
				}

				if(newnombre!=null&&newnombre.length()>100) {
					newnombre=newnombre.substring(0,98);
					System.out.println("CargaFamiliar:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=100 en columna nombre");
				}

				this.nombre=newnombre;
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
						System.out.println("CargaFamiliar:Valor nulo no permitido en columna direccion");
					}
				}

				if(newdireccion!=null&&newdireccion.length()>200) {
					newdireccion=newdireccion.substring(0,198);
					System.out.println("CargaFamiliar:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=200 en columna direccion");
				}

				this.direccion=newdireccion;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setfecha_nacimiento(Date newfecha_nacimiento)throws Exception
	{
		try {
			if(this.fecha_nacimiento!=newfecha_nacimiento) {
				if(newfecha_nacimiento==null) {
					//newfecha_nacimiento=new Date();
					if(Constantes.ISDEVELOPING) {
						System.out.println("CargaFamiliar:Valor nulo no permitido en columna fecha_nacimiento");
					}
				}

				this.fecha_nacimiento=newfecha_nacimiento;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setvalor_cupo(Double newvalor_cupo)throws Exception
	{
		try {
			if(this.valor_cupo!=newvalor_cupo) {
				if(newvalor_cupo==null) {
					//newvalor_cupo=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("CargaFamiliar:Valor nulo no permitido en columna valor_cupo");
					}
				}

				this.valor_cupo=newvalor_cupo;
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

	public TipoCargaFami getTipoCargaFami() {
		return this.tipocargafami;
	}

	public TipoGenero getTipoGenero() {
		return this.tipogenero;
	}

	public EstadoCivil getEstadoCivil() {
		return this.estadocivil;
	}

	
	
	public String getempresa_descripcion() {
		return this.empresa_descripcion;
	}

	public String getcliente_descripcion() {
		return this.cliente_descripcion;
	}

	public String gettipocargafami_descripcion() {
		return this.tipocargafami_descripcion;
	}

	public String gettipogenero_descripcion() {
		return this.tipogenero_descripcion;
	}

	public String getestadocivil_descripcion() {
		return this.estadocivil_descripcion;
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


	public  void  setTipoCargaFami(TipoCargaFami tipocargafami) {
		try {
			this.tipocargafami=tipocargafami;
		} catch(Exception e) {
			;
		}
	}


	public  void  setTipoGenero(TipoGenero tipogenero) {
		try {
			this.tipogenero=tipogenero;
		} catch(Exception e) {
			;
		}
	}


	public  void  setEstadoCivil(EstadoCivil estadocivil) {
		try {
			this.estadocivil=estadocivil;
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


	public  void  settipocargafami_descripcion(String tipocargafami_descripcion) {
		try {
			this.tipocargafami_descripcion=tipocargafami_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  settipogenero_descripcion(String tipogenero_descripcion) {
		try {
			this.tipogenero_descripcion=tipogenero_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  setestadocivil_descripcion(String estadocivil_descripcion) {
		try {
			this.estadocivil_descripcion=estadocivil_descripcion;
		} catch(Exception e) {
			;
		}
	}


	
	
	
	
	
	/*PARA REPORTES*/
	String id_empresa_descripcion="";String id_cliente_descripcion="";String id_tipo_carga_fami_descripcion="";String id_tipo_genero_descripcion="";String id_estado_civil_descripcion="";
	
	
	public String getid_empresa_descripcion() {
		return id_empresa_descripcion;
	}
	public String getid_cliente_descripcion() {
		return id_cliente_descripcion;
	}
	public String getid_tipo_carga_fami_descripcion() {
		return id_tipo_carga_fami_descripcion;
	}
	public String getid_tipo_genero_descripcion() {
		return id_tipo_genero_descripcion;
	}
	public String getid_estado_civil_descripcion() {
		return id_estado_civil_descripcion;
	}
	
	
	public void setid_empresa_descripcion(String newid_empresa_descripcion)throws Exception {
		try {
			this.id_empresa_descripcion=newid_empresa_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_cliente_descripcion(String newid_cliente_descripcion)throws Exception {
		try {
			this.id_cliente_descripcion=newid_cliente_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_tipo_carga_fami_descripcion(String newid_tipo_carga_fami_descripcion)throws Exception {
		try {
			this.id_tipo_carga_fami_descripcion=newid_tipo_carga_fami_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_tipo_genero_descripcion(String newid_tipo_genero_descripcion)throws Exception {
		try {
			this.id_tipo_genero_descripcion=newid_tipo_genero_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_estado_civil_descripcion(String newid_estado_civil_descripcion)throws Exception {
		try {
			this.id_estado_civil_descripcion=newid_estado_civil_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	
	public void inicializarVariablesParaReporte() {
		this.id_empresa_descripcion="";this.id_cliente_descripcion="";this.id_tipo_carga_fami_descripcion="";this.id_tipo_genero_descripcion="";this.id_estado_civil_descripcion="";
	}
	
	
	
	
	
	
	/*PARA REPORTES FIN*/		
}

