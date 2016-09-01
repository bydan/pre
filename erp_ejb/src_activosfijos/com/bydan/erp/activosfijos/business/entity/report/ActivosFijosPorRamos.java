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
package com.bydan.erp.activosfijos.business.entity.report;

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
//import com.bydan.erp.activosfijos.util.ActivosFijosPorRamosConstantesFunciones;
import com.bydan.erp.activosfijos.util.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.activosfijos.util.*;

import com.bydan.erp.activosfijos.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.activosfijos.business.entity.*;




@SuppressWarnings("unused")
public class ActivosFijosPorRamos extends ActivosFijosPorRamosAdditional implements Serializable ,Cloneable {//ActivosFijosPorRamosAdditional,GeneralEntity
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
	
	private ActivosFijosPorRamos activosfijosporramosOriginal;
	
	private Map<String, Object> mapActivosFijosPorRamos;
			
	public Map<String, Object> getMapActivosFijosPorRamos() {
		return mapActivosFijosPorRamos;
	}

	public void setMapActivosFijosPorRamos(Map<String, Object> mapActivosFijosPorRamos) {
		this.mapActivosFijosPorRamos = mapActivosFijosPorRamos;
	}
	
	public void inicializarMapActivosFijosPorRamos() {
		this.mapActivosFijosPorRamos = new HashMap<String,Object>();
	}
	
	public void setMapActivosFijosPorRamosValue(String sKey,Object oValue) {
		this.mapActivosFijosPorRamos.put(sKey, oValue);
	}
	
	public Object getMapActivosFijosPorRamosValue(String sKey) {
		return this.mapActivosFijosPorRamos.get(sKey);
	}
	
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_empresa;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_tipo_ramo_activo_fijo;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=150,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	//@Pattern(regex=ActivosFijosPorRamosConstantesFunciones.SREGEXNOMBRE_SUB_GRUPO,message=ActivosFijosPorRamosConstantesFunciones.SMENSAJEREGEXNOMBRE_SUB_GRUPO)
	private String nombre_sub_grupo;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=150,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	//@Pattern(regex=ActivosFijosPorRamosConstantesFunciones.SREGEXNOMBRE_DETALLE_GRUPO,message=ActivosFijosPorRamosConstantesFunciones.SMENSAJEREGEXNOMBRE_DETALLE_GRUPO)
	private String nombre_detalle_grupo;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=50,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	//@Pattern(regex=ActivosFijosPorRamosConstantesFunciones.SREGEXCLAVE,message=ActivosFijosPorRamosConstantesFunciones.SMENSAJEREGEXCLAVE)
	private String clave;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=100,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	//@Pattern(regex=ActivosFijosPorRamosConstantesFunciones.SREGEXNOMBRE,message=ActivosFijosPorRamosConstantesFunciones.SMENSAJEREGEXNOMBRE)
	private String nombre;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Date fecha_compra;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double vida_util;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double costo_de_compra;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=100,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	//@Pattern(regex=ActivosFijosPorRamosConstantesFunciones.SREGEXMARCA,message=ActivosFijosPorRamosConstantesFunciones.SMENSAJEREGEXMARCA)
	private String marca;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=100,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	//@Pattern(regex=ActivosFijosPorRamosConstantesFunciones.SREGEXMODELO,message=ActivosFijosPorRamosConstantesFunciones.SMENSAJEREGEXMODELO)
	private String modelo;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=50,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	//@Pattern(regex=ActivosFijosPorRamosConstantesFunciones.SREGEXNUMERO_MATRICULA,message=ActivosFijosPorRamosConstantesFunciones.SMENSAJEREGEXNUMERO_MATRICULA)
	private String numero_matricula;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=50,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	//@Pattern(regex=ActivosFijosPorRamosConstantesFunciones.SREGEXNUMERO_MOTOR,message=ActivosFijosPorRamosConstantesFunciones.SMENSAJEREGEXNUMERO_MOTOR)
	private String numero_motor;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=50,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	//@Pattern(regex=ActivosFijosPorRamosConstantesFunciones.SREGEXNUMERO_CHASIS,message=ActivosFijosPorRamosConstantesFunciones.SMENSAJEREGEXNUMERO_CHASIS)
	private String numero_chasis;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=50,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	//@Pattern(regex=ActivosFijosPorRamosConstantesFunciones.SREGEXNUMERO_PLACA,message=ActivosFijosPorRamosConstantesFunciones.SMENSAJEREGEXNUMERO_PLACA)
	private String numero_placa;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double valor_comercial;
			
	
	public Empresa empresa;
	public TipoRamoActivoFijo tiporamoactivofijo;
	
	
	private String empresa_descripcion;
	private String tiporamoactivofijo_descripcion;
	
	
		
	public ActivosFijosPorRamos () throws Exception {
		super();		
		
		this.id=0L;
		
		
		this.versionRow=new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());//new Date();
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		this.sType="NONE";
		
		this.activosfijosporramosOriginal=this;
		
 		this.id_empresa=-1L;
 		this.id_tipo_ramo_activo_fijo=-1L;
 		this.nombre_sub_grupo="";
 		this.nombre_detalle_grupo="";
 		this.clave="";
 		this.nombre="";
 		this.fecha_compra=new Date();
 		this.vida_util=0.0;
 		this.costo_de_compra=0.0;
 		this.marca="";
 		this.modelo="";
 		this.numero_matricula="";
 		this.numero_motor="";
 		this.numero_chasis="";
 		this.numero_placa="";
 		this.valor_comercial=0.0;
		
		
		this.empresa=null;
		this.tiporamoactivofijo=null;
		
		
		this.empresa_descripcion="";
		this.tiporamoactivofijo_descripcion="";
		
		
		
			
		
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
    //PARA REPORTES
	public ActivosFijosPorRamos (Long id,Date versionRow,String nombre_sub_grupo,String nombre_detalle_grupo,String clave,String nombre,Date fecha_compra,Double vida_util,Double costo_de_compra,String marca,String modelo,String numero_matricula,String numero_motor,String numero_chasis,String numero_placa,Double valor_comercial) throws Exception {
		super();		
		
		this.id=id;
		this.versionRow=versionRow;
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.activosfijosporramosOriginal=this;
		
 		this.nombre_sub_grupo=nombre_sub_grupo;
 		this.nombre_detalle_grupo=nombre_detalle_grupo;
 		this.clave=clave;
 		this.nombre=nombre;
 		this.fecha_compra=fecha_compra;
 		this.vida_util=vida_util;
 		this.costo_de_compra=costo_de_compra;
 		this.marca=marca;
 		this.modelo=modelo;
 		this.numero_matricula=numero_matricula;
 		this.numero_motor=numero_motor;
 		this.numero_chasis=numero_chasis;
 		this.numero_placa=numero_placa;
 		this.valor_comercial=valor_comercial;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	 //PARA REPORTES
	public ActivosFijosPorRamos (String nombre_sub_grupo,String nombre_detalle_grupo,String clave,String nombre,Date fecha_compra,Double vida_util,Double costo_de_compra,String marca,String modelo,String numero_matricula,String numero_motor,String numero_chasis,String numero_placa,Double valor_comercial) throws Exception {
		super();		
		
		this.id=0L;
		this.versionRow=new Date();
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.activosfijosporramosOriginal=this;
		
 		this.nombre_sub_grupo=nombre_sub_grupo;
 		this.nombre_detalle_grupo=nombre_detalle_grupo;
 		this.clave=clave;
 		this.nombre=nombre;
 		this.fecha_compra=fecha_compra;
 		this.vida_util=vida_util;
 		this.costo_de_compra=costo_de_compra;
 		this.marca=marca;
 		this.modelo=modelo;
 		this.numero_matricula=numero_matricula;
 		this.numero_motor=numero_motor;
 		this.numero_chasis=numero_chasis;
 		this.numero_placa=numero_placa;
 		this.valor_comercial=valor_comercial;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	
	public ActivosFijosPorRamos getActivosFijosPorRamosOriginal() {
		return this.activosfijosporramosOriginal;
	}
	
	public void setActivosFijosPorRamosOriginal(ActivosFijosPorRamos activosfijosporramos) {
		try {
			this.activosfijosporramosOriginal=activosfijosporramos;
		} catch(Exception e) {
			;
		}
	}
	
	
	protected ActivosFijosPorRamosAdditional activosfijosporramosAdditional=null;
	
	public ActivosFijosPorRamosAdditional getActivosFijosPorRamosAdditional() {
		return this.activosfijosporramosAdditional;
	}
	
	public void setActivosFijosPorRamosAdditional(ActivosFijosPorRamosAdditional activosfijosporramosAdditional) {
		try {
			this.activosfijosporramosAdditional=activosfijosporramosAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
    
	
	public Long getid_empresa() {
		return this.id_empresa;
	}
    
	
	public Long getid_tipo_ramo_activo_fijo() {
		return this.id_tipo_ramo_activo_fijo;
	}
    
	
	public String getnombre_sub_grupo() {
		return this.nombre_sub_grupo;
	}
    
	
	public String getnombre_detalle_grupo() {
		return this.nombre_detalle_grupo;
	}
    
	
	public String getclave() {
		return this.clave;
	}
    
	
	public String getnombre() {
		return this.nombre;
	}
    
	
	public Date getfecha_compra() {
		return this.fecha_compra;
	}
    
	
	public Double getvida_util() {
		return this.vida_util;
	}
    
	
	public Double getcosto_de_compra() {
		return this.costo_de_compra;
	}
    
	
	public String getmarca() {
		return this.marca;
	}
    
	
	public String getmodelo() {
		return this.modelo;
	}
    
	
	public String getnumero_matricula() {
		return this.numero_matricula;
	}
    
	
	public String getnumero_motor() {
		return this.numero_motor;
	}
    
	
	public String getnumero_chasis() {
		return this.numero_chasis;
	}
    
	
	public String getnumero_placa() {
		return this.numero_placa;
	}
    
	
	public Double getvalor_comercial() {
		return this.valor_comercial;
	}
	
    
	public void setid_empresa(Long newid_empresa)throws Exception
	{
		try {
			if(this.id_empresa!=newid_empresa) {
				if(newid_empresa==null) {
					//newid_empresa=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ActivosFijosPorRamos:Valor nulo no permitido en columna id_empresa");
					}
				}

				this.id_empresa=newid_empresa;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_tipo_ramo_activo_fijo(Long newid_tipo_ramo_activo_fijo)throws Exception
	{
		try {
			if(this.id_tipo_ramo_activo_fijo!=newid_tipo_ramo_activo_fijo) {
				if(newid_tipo_ramo_activo_fijo==null) {
					//newid_tipo_ramo_activo_fijo=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ActivosFijosPorRamos:Valor nulo no permitido en columna id_tipo_ramo_activo_fijo");
					}
				}

				this.id_tipo_ramo_activo_fijo=newid_tipo_ramo_activo_fijo;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setnombre_sub_grupo(String newnombre_sub_grupo)throws Exception
	{
		try {
			if(this.nombre_sub_grupo!=newnombre_sub_grupo) {
				if(newnombre_sub_grupo==null) {
					//newnombre_sub_grupo="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("ActivosFijosPorRamos:Valor nulo no permitido en columna nombre_sub_grupo");
					}
				}

				if(newnombre_sub_grupo!=null&&newnombre_sub_grupo.length()>150) {
					newnombre_sub_grupo=newnombre_sub_grupo.substring(0,148);
					System.out.println("ActivosFijosPorRamos:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=150 en columna nombre_sub_grupo");
				}

				this.nombre_sub_grupo=newnombre_sub_grupo;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setnombre_detalle_grupo(String newnombre_detalle_grupo)throws Exception
	{
		try {
			if(this.nombre_detalle_grupo!=newnombre_detalle_grupo) {
				if(newnombre_detalle_grupo==null) {
					//newnombre_detalle_grupo="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("ActivosFijosPorRamos:Valor nulo no permitido en columna nombre_detalle_grupo");
					}
				}

				if(newnombre_detalle_grupo!=null&&newnombre_detalle_grupo.length()>150) {
					newnombre_detalle_grupo=newnombre_detalle_grupo.substring(0,148);
					System.out.println("ActivosFijosPorRamos:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=150 en columna nombre_detalle_grupo");
				}

				this.nombre_detalle_grupo=newnombre_detalle_grupo;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setclave(String newclave)throws Exception
	{
		try {
			if(this.clave!=newclave) {
				if(newclave==null) {
					//newclave="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("ActivosFijosPorRamos:Valor nulo no permitido en columna clave");
					}
				}

				if(newclave!=null&&newclave.length()>50) {
					newclave=newclave.substring(0,48);
					System.out.println("ActivosFijosPorRamos:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=50 en columna clave");
				}

				this.clave=newclave;
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
						System.out.println("ActivosFijosPorRamos:Valor nulo no permitido en columna nombre");
					}
				}

				if(newnombre!=null&&newnombre.length()>100) {
					newnombre=newnombre.substring(0,98);
					System.out.println("ActivosFijosPorRamos:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=100 en columna nombre");
				}

				this.nombre=newnombre;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setfecha_compra(Date newfecha_compra)throws Exception
	{
		try {
			if(this.fecha_compra!=newfecha_compra) {
				if(newfecha_compra==null) {
					//newfecha_compra=new Date();
					if(Constantes.ISDEVELOPING) {
						System.out.println("ActivosFijosPorRamos:Valor nulo no permitido en columna fecha_compra");
					}
				}

				this.fecha_compra=newfecha_compra;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setvida_util(Double newvida_util)throws Exception
	{
		try {
			if(this.vida_util!=newvida_util) {
				if(newvida_util==null) {
					//newvida_util=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ActivosFijosPorRamos:Valor nulo no permitido en columna vida_util");
					}
				}

				this.vida_util=newvida_util;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setcosto_de_compra(Double newcosto_de_compra)throws Exception
	{
		try {
			if(this.costo_de_compra!=newcosto_de_compra) {
				if(newcosto_de_compra==null) {
					//newcosto_de_compra=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ActivosFijosPorRamos:Valor nulo no permitido en columna costo_de_compra");
					}
				}

				this.costo_de_compra=newcosto_de_compra;
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
						System.out.println("ActivosFijosPorRamos:Valor nulo no permitido en columna marca");
					}
				}

				if(newmarca!=null&&newmarca.length()>100) {
					newmarca=newmarca.substring(0,98);
					System.out.println("ActivosFijosPorRamos:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=100 en columna marca");
				}

				this.marca=newmarca;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setmodelo(String newmodelo)throws Exception
	{
		try {
			if(this.modelo!=newmodelo) {
				if(newmodelo==null) {
					//newmodelo="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("ActivosFijosPorRamos:Valor nulo no permitido en columna modelo");
					}
				}

				if(newmodelo!=null&&newmodelo.length()>100) {
					newmodelo=newmodelo.substring(0,98);
					System.out.println("ActivosFijosPorRamos:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=100 en columna modelo");
				}

				this.modelo=newmodelo;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setnumero_matricula(String newnumero_matricula)throws Exception
	{
		try {
			if(this.numero_matricula!=newnumero_matricula) {
				if(newnumero_matricula==null) {
					//newnumero_matricula="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("ActivosFijosPorRamos:Valor nulo no permitido en columna numero_matricula");
					}
				}

				if(newnumero_matricula!=null&&newnumero_matricula.length()>50) {
					newnumero_matricula=newnumero_matricula.substring(0,48);
					System.out.println("ActivosFijosPorRamos:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=50 en columna numero_matricula");
				}

				this.numero_matricula=newnumero_matricula;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setnumero_motor(String newnumero_motor)throws Exception
	{
		try {
			if(this.numero_motor!=newnumero_motor) {
				if(newnumero_motor==null) {
					//newnumero_motor="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("ActivosFijosPorRamos:Valor nulo no permitido en columna numero_motor");
					}
				}

				if(newnumero_motor!=null&&newnumero_motor.length()>50) {
					newnumero_motor=newnumero_motor.substring(0,48);
					System.out.println("ActivosFijosPorRamos:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=50 en columna numero_motor");
				}

				this.numero_motor=newnumero_motor;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setnumero_chasis(String newnumero_chasis)throws Exception
	{
		try {
			if(this.numero_chasis!=newnumero_chasis) {
				if(newnumero_chasis==null) {
					//newnumero_chasis="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("ActivosFijosPorRamos:Valor nulo no permitido en columna numero_chasis");
					}
				}

				if(newnumero_chasis!=null&&newnumero_chasis.length()>50) {
					newnumero_chasis=newnumero_chasis.substring(0,48);
					System.out.println("ActivosFijosPorRamos:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=50 en columna numero_chasis");
				}

				this.numero_chasis=newnumero_chasis;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setnumero_placa(String newnumero_placa)throws Exception
	{
		try {
			if(this.numero_placa!=newnumero_placa) {
				if(newnumero_placa==null) {
					//newnumero_placa="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("ActivosFijosPorRamos:Valor nulo no permitido en columna numero_placa");
					}
				}

				if(newnumero_placa!=null&&newnumero_placa.length()>50) {
					newnumero_placa=newnumero_placa.substring(0,48);
					System.out.println("ActivosFijosPorRamos:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=50 en columna numero_placa");
				}

				this.numero_placa=newnumero_placa;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setvalor_comercial(Double newvalor_comercial)throws Exception
	{
		try {
			if(this.valor_comercial!=newvalor_comercial) {
				if(newvalor_comercial==null) {
					//newvalor_comercial=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ActivosFijosPorRamos:Valor nulo no permitido en columna valor_comercial");
					}
				}

				this.valor_comercial=newvalor_comercial;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	
	public Empresa getEmpresa() {
		return this.empresa;
	}

	public TipoRamoActivoFijo getTipoRamoActivoFijo() {
		return this.tiporamoactivofijo;
	}

	
	
	public String getempresa_descripcion() {
		return this.empresa_descripcion;
	}

	public String gettiporamoactivofijo_descripcion() {
		return this.tiporamoactivofijo_descripcion;
	}

	
	
	public  void  setEmpresa(Empresa empresa) {
		try {
			this.empresa=empresa;
		} catch(Exception e) {
			;
		}
	}


	public  void  setTipoRamoActivoFijo(TipoRamoActivoFijo tiporamoactivofijo) {
		try {
			this.tiporamoactivofijo=tiporamoactivofijo;
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


	public  void  settiporamoactivofijo_descripcion(String tiporamoactivofijo_descripcion) {
		try {
			this.tiporamoactivofijo_descripcion=tiporamoactivofijo_descripcion;
		} catch(Exception e) {
			;
		}
	}


	
	
	
	
	
	/*PARA REPORTES*/
	String id_empresa_descripcion="";String id_tipo_ramo_activo_fijo_descripcion="";
	
	
	public String getid_empresa_descripcion() {
		return id_empresa_descripcion;
	}
	public String getid_tipo_ramo_activo_fijo_descripcion() {
		return id_tipo_ramo_activo_fijo_descripcion;
	}
	
	
	public void setid_empresa_descripcion(String newid_empresa_descripcion)throws Exception {
		try {
			this.id_empresa_descripcion=newid_empresa_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_tipo_ramo_activo_fijo_descripcion(String newid_tipo_ramo_activo_fijo_descripcion)throws Exception {
		try {
			this.id_tipo_ramo_activo_fijo_descripcion=newid_tipo_ramo_activo_fijo_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	
	public void inicializarVariablesParaReporte() {
		this.id_empresa_descripcion="";this.id_tipo_ramo_activo_fijo_descripcion="";
	}
	
	
	
	
	
	
	/*PARA REPORTES FIN*/		
}

