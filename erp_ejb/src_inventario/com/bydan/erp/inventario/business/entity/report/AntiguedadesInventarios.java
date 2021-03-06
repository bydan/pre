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
package com.bydan.erp.inventario.business.entity.report;

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
//import com.bydan.erp.inventario.util.AntiguedadesInventariosConstantesFunciones;
import com.bydan.erp.inventario.util.*;


import com.bydan.erp.inventario.util.*;
import com.bydan.erp.seguridad.util.*;

import com.bydan.erp.inventario.business.entity.*;


import com.bydan.erp.inventario.business.entity.*;
import com.bydan.erp.seguridad.business.entity.*;




@SuppressWarnings("unused")
public class AntiguedadesInventarios extends AntiguedadesInventariosAdditional implements Serializable ,Cloneable {//AntiguedadesInventariosAdditional,GeneralEntity
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
	
	private AntiguedadesInventarios antiguedadesinventariosOriginal;
	
	private Map<String, Object> mapAntiguedadesInventarios;
			
	public Map<String, Object> getMapAntiguedadesInventarios() {
		return mapAntiguedadesInventarios;
	}

	public void setMapAntiguedadesInventarios(Map<String, Object> mapAntiguedadesInventarios) {
		this.mapAntiguedadesInventarios = mapAntiguedadesInventarios;
	}
	
	public void inicializarMapAntiguedadesInventarios() {
		this.mapAntiguedadesInventarios = new HashMap<String,Object>();
	}
	
	public void setMapAntiguedadesInventariosValue(String sKey,Object oValue) {
		this.mapAntiguedadesInventarios.put(sKey, oValue);
	}
	
	public Object getMapAntiguedadesInventariosValue(String sKey) {
		return this.mapAntiguedadesInventarios.get(sKey);
	}
	
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_bodega;
	
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
	private Long id_linea;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_linea_grupo;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_linea_categoria;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_linea_marca;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Date fecha_ultima_venta_hasta;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=150,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	//@Pattern(regex=AntiguedadesInventariosConstantesFunciones.SREGEXNOMBRE_SUCURSAL,message=AntiguedadesInventariosConstantesFunciones.SMENSAJEREGEXNOMBRE_SUCURSAL)
	private String nombre_sucursal;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=150,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	//@Pattern(regex=AntiguedadesInventariosConstantesFunciones.SREGEXNOMBRE_LINEA,message=AntiguedadesInventariosConstantesFunciones.SMENSAJEREGEXNOMBRE_LINEA)
	private String nombre_linea;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=150,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	//@Pattern(regex=AntiguedadesInventariosConstantesFunciones.SREGEXNOMBRE_LINEA_GRUPO,message=AntiguedadesInventariosConstantesFunciones.SMENSAJEREGEXNOMBRE_LINEA_GRUPO)
	private String nombre_linea_grupo;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=150,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	//@Pattern(regex=AntiguedadesInventariosConstantesFunciones.SREGEXNOMBRE_LINEA_CATEGORIA,message=AntiguedadesInventariosConstantesFunciones.SMENSAJEREGEXNOMBRE_LINEA_CATEGORIA)
	private String nombre_linea_categoria;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=150,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	//@Pattern(regex=AntiguedadesInventariosConstantesFunciones.SREGEXNOMBRE_LINEA_MARCA,message=AntiguedadesInventariosConstantesFunciones.SMENSAJEREGEXNOMBRE_LINEA_MARCA)
	private String nombre_linea_marca;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=50,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	//@Pattern(regex=AntiguedadesInventariosConstantesFunciones.SREGEXCODIGO,message=AntiguedadesInventariosConstantesFunciones.SMENSAJEREGEXCODIGO)
	private String codigo;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=150,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	//@Pattern(regex=AntiguedadesInventariosConstantesFunciones.SREGEXNOMBRE,message=AntiguedadesInventariosConstantesFunciones.SMENSAJEREGEXNOMBRE)
	private String nombre;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=150,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	//@Pattern(regex=AntiguedadesInventariosConstantesFunciones.SREGEXNOMBRE_BODEGA,message=AntiguedadesInventariosConstantesFunciones.SMENSAJEREGEXNOMBRE_BODEGA)
	private String nombre_bodega;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=50,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	//@Pattern(regex=AntiguedadesInventariosConstantesFunciones.SREGEXNOMBRE_UNIDAD,message=AntiguedadesInventariosConstantesFunciones.SMENSAJEREGEXNOMBRE_UNIDAD)
	private String nombre_unidad;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=10,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONINT)
	private Integer cantidad_disponible;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Date fecha_ultima_compra;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Date fecha_ultima_venta;
			
	
	public Bodega bodega;
	public Empresa empresa;
	public Sucursal sucursal;
	public Linea linea;
	public Linea lineagrupo;
	public Linea lineacategoria;
	public Linea lineamarca;
	
	
	private String bodega_descripcion;
	private String empresa_descripcion;
	private String sucursal_descripcion;
	private String linea_descripcion;
	private String lineagrupo_descripcion;
	private String lineacategoria_descripcion;
	private String lineamarca_descripcion;
	
	
		
	public AntiguedadesInventarios () throws Exception {
		super();		
		
		this.id=0L;
		
		
		this.versionRow=new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());//new Date();
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		this.sType="NONE";
		
		this.antiguedadesinventariosOriginal=this;
		
 		this.id_bodega=-1L;
 		this.id_empresa=-1L;
 		this.id_sucursal=-1L;
 		this.id_linea=-1L;
 		this.id_linea_grupo=-1L;
 		this.id_linea_categoria=-1L;
 		this.id_linea_marca=-1L;
 		this.fecha_ultima_venta_hasta=new Date();
 		this.nombre_sucursal="";
 		this.nombre_linea="";
 		this.nombre_linea_grupo="";
 		this.nombre_linea_categoria="";
 		this.nombre_linea_marca="";
 		this.codigo="";
 		this.nombre="";
 		this.nombre_bodega="";
 		this.nombre_unidad="";
 		this.cantidad_disponible=0;
 		this.fecha_ultima_compra=new Date();
 		this.fecha_ultima_venta=new Date();
		
		
		this.bodega=null;
		this.empresa=null;
		this.sucursal=null;
		this.linea=null;
		this.lineagrupo=null;
		this.lineacategoria=null;
		this.lineamarca=null;
		
		
		this.bodega_descripcion="";
		this.empresa_descripcion="";
		this.sucursal_descripcion="";
		this.linea_descripcion="";
		this.lineagrupo_descripcion="";
		this.lineacategoria_descripcion="";
		this.lineamarca_descripcion="";
		
		
		
			
		
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
    //PARA REPORTES
	public AntiguedadesInventarios (Long id,Date versionRow,String nombre_sucursal,String nombre_linea,String nombre_linea_grupo,String nombre_linea_categoria,String nombre_linea_marca,String codigo,String nombre,String nombre_bodega,String nombre_unidad,Integer cantidad_disponible,Date fecha_ultima_compra,Date fecha_ultima_venta) throws Exception {
		super();		
		
		this.id=id;
		this.versionRow=versionRow;
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.antiguedadesinventariosOriginal=this;
		
 		this.nombre_sucursal=nombre_sucursal;
 		this.nombre_linea=nombre_linea;
 		this.nombre_linea_grupo=nombre_linea_grupo;
 		this.nombre_linea_categoria=nombre_linea_categoria;
 		this.nombre_linea_marca=nombre_linea_marca;
 		this.codigo=codigo;
 		this.nombre=nombre;
 		this.nombre_bodega=nombre_bodega;
 		this.nombre_unidad=nombre_unidad;
 		this.cantidad_disponible=cantidad_disponible;
 		this.fecha_ultima_compra=fecha_ultima_compra;
 		this.fecha_ultima_venta=fecha_ultima_venta;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	 //PARA REPORTES
	public AntiguedadesInventarios (String nombre_sucursal,String nombre_linea,String nombre_linea_grupo,String nombre_linea_categoria,String nombre_linea_marca,String codigo,String nombre,String nombre_bodega,String nombre_unidad,Integer cantidad_disponible,Date fecha_ultima_compra,Date fecha_ultima_venta) throws Exception {
		super();		
		
		this.id=0L;
		this.versionRow=new Date();
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.antiguedadesinventariosOriginal=this;
		
 		this.nombre_sucursal=nombre_sucursal;
 		this.nombre_linea=nombre_linea;
 		this.nombre_linea_grupo=nombre_linea_grupo;
 		this.nombre_linea_categoria=nombre_linea_categoria;
 		this.nombre_linea_marca=nombre_linea_marca;
 		this.codigo=codigo;
 		this.nombre=nombre;
 		this.nombre_bodega=nombre_bodega;
 		this.nombre_unidad=nombre_unidad;
 		this.cantidad_disponible=cantidad_disponible;
 		this.fecha_ultima_compra=fecha_ultima_compra;
 		this.fecha_ultima_venta=fecha_ultima_venta;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	
	public AntiguedadesInventarios getAntiguedadesInventariosOriginal() {
		return this.antiguedadesinventariosOriginal;
	}
	
	public void setAntiguedadesInventariosOriginal(AntiguedadesInventarios antiguedadesinventarios) {
		try {
			this.antiguedadesinventariosOriginal=antiguedadesinventarios;
		} catch(Exception e) {
			;
		}
	}
	
	
	protected AntiguedadesInventariosAdditional antiguedadesinventariosAdditional=null;
	
	public AntiguedadesInventariosAdditional getAntiguedadesInventariosAdditional() {
		return this.antiguedadesinventariosAdditional;
	}
	
	public void setAntiguedadesInventariosAdditional(AntiguedadesInventariosAdditional antiguedadesinventariosAdditional) {
		try {
			this.antiguedadesinventariosAdditional=antiguedadesinventariosAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
    
	
	public Long getid_bodega() {
		return this.id_bodega;
	}
    
	
	public Long getid_empresa() {
		return this.id_empresa;
	}
    
	
	public Long getid_sucursal() {
		return this.id_sucursal;
	}
    
	
	public Long getid_linea() {
		return this.id_linea;
	}
    
	
	public Long getid_linea_grupo() {
		return this.id_linea_grupo;
	}
    
	
	public Long getid_linea_categoria() {
		return this.id_linea_categoria;
	}
    
	
	public Long getid_linea_marca() {
		return this.id_linea_marca;
	}
    
	
	public Date getfecha_ultima_venta_hasta() {
		return this.fecha_ultima_venta_hasta;
	}
    
	
	public String getnombre_sucursal() {
		return this.nombre_sucursal;
	}
    
	
	public String getnombre_linea() {
		return this.nombre_linea;
	}
    
	
	public String getnombre_linea_grupo() {
		return this.nombre_linea_grupo;
	}
    
	
	public String getnombre_linea_categoria() {
		return this.nombre_linea_categoria;
	}
    
	
	public String getnombre_linea_marca() {
		return this.nombre_linea_marca;
	}
    
	
	public String getcodigo() {
		return this.codigo;
	}
    
	
	public String getnombre() {
		return this.nombre;
	}
    
	
	public String getnombre_bodega() {
		return this.nombre_bodega;
	}
    
	
	public String getnombre_unidad() {
		return this.nombre_unidad;
	}
    
	
	public Integer getcantidad_disponible() {
		return this.cantidad_disponible;
	}
    
	
	public Date getfecha_ultima_compra() {
		return this.fecha_ultima_compra;
	}
    
	
	public Date getfecha_ultima_venta() {
		return this.fecha_ultima_venta;
	}
	
    
	public void setid_bodega(Long newid_bodega)throws Exception
	{
		try {
			if(this.id_bodega!=newid_bodega) {
				if(newid_bodega==null) {
					//newid_bodega=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("AntiguedadesInventarios:Valor nulo no permitido en columna id_bodega");
					}
				}

				this.id_bodega=newid_bodega;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_empresa(Long newid_empresa)throws Exception
	{
		try {
			if(this.id_empresa!=newid_empresa) {
				if(newid_empresa==null) {
					//newid_empresa=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("AntiguedadesInventarios:Valor nulo no permitido en columna id_empresa");
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
						System.out.println("AntiguedadesInventarios:Valor nulo no permitido en columna id_sucursal");
					}
				}

				this.id_sucursal=newid_sucursal;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_linea(Long newid_linea)throws Exception
	{
		try {
			if(this.id_linea!=newid_linea) {
				if(newid_linea==null) {
					//newid_linea=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("AntiguedadesInventarios:Valor nulo no permitido en columna id_linea");
					}
				}

				this.id_linea=newid_linea;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_linea_grupo(Long newid_linea_grupo)throws Exception
	{
		try {
			if(this.id_linea_grupo!=newid_linea_grupo) {
				if(newid_linea_grupo==null) {
					//newid_linea_grupo=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("AntiguedadesInventarios:Valor nulo no permitido en columna id_linea_grupo");
					}
				}

				this.id_linea_grupo=newid_linea_grupo;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_linea_categoria(Long newid_linea_categoria)throws Exception
	{
		try {
			if(this.id_linea_categoria!=newid_linea_categoria) {
				if(newid_linea_categoria==null) {
					//newid_linea_categoria=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("AntiguedadesInventarios:Valor nulo no permitido en columna id_linea_categoria");
					}
				}

				this.id_linea_categoria=newid_linea_categoria;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_linea_marca(Long newid_linea_marca)throws Exception
	{
		try {
			if(this.id_linea_marca!=newid_linea_marca) {
				if(newid_linea_marca==null) {
					//newid_linea_marca=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("AntiguedadesInventarios:Valor nulo no permitido en columna id_linea_marca");
					}
				}

				this.id_linea_marca=newid_linea_marca;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setfecha_ultima_venta_hasta(Date newfecha_ultima_venta_hasta)throws Exception
	{
		try {
			if(this.fecha_ultima_venta_hasta!=newfecha_ultima_venta_hasta) {
				if(newfecha_ultima_venta_hasta==null) {
					//newfecha_ultima_venta_hasta=new Date();
					if(Constantes.ISDEVELOPING) {
						System.out.println("AntiguedadesInventarios:Valor nulo no permitido en columna fecha_ultima_venta_hasta");
					}
				}

				this.fecha_ultima_venta_hasta=newfecha_ultima_venta_hasta;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setnombre_sucursal(String newnombre_sucursal)throws Exception
	{
		try {
			if(this.nombre_sucursal!=newnombre_sucursal) {
				if(newnombre_sucursal==null) {
					//newnombre_sucursal="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("AntiguedadesInventarios:Valor nulo no permitido en columna nombre_sucursal");
					}
				}

				if(newnombre_sucursal!=null&&newnombre_sucursal.length()>150) {
					newnombre_sucursal=newnombre_sucursal.substring(0,148);
					System.out.println("AntiguedadesInventarios:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=150 en columna nombre_sucursal");
				}

				this.nombre_sucursal=newnombre_sucursal;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setnombre_linea(String newnombre_linea)throws Exception
	{
		try {
			if(this.nombre_linea!=newnombre_linea) {
				if(newnombre_linea==null) {
					//newnombre_linea="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("AntiguedadesInventarios:Valor nulo no permitido en columna nombre_linea");
					}
				}

				if(newnombre_linea!=null&&newnombre_linea.length()>150) {
					newnombre_linea=newnombre_linea.substring(0,148);
					System.out.println("AntiguedadesInventarios:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=150 en columna nombre_linea");
				}

				this.nombre_linea=newnombre_linea;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setnombre_linea_grupo(String newnombre_linea_grupo)throws Exception
	{
		try {
			if(this.nombre_linea_grupo!=newnombre_linea_grupo) {
				if(newnombre_linea_grupo==null) {
					//newnombre_linea_grupo="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("AntiguedadesInventarios:Valor nulo no permitido en columna nombre_linea_grupo");
					}
				}

				if(newnombre_linea_grupo!=null&&newnombre_linea_grupo.length()>150) {
					newnombre_linea_grupo=newnombre_linea_grupo.substring(0,148);
					System.out.println("AntiguedadesInventarios:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=150 en columna nombre_linea_grupo");
				}

				this.nombre_linea_grupo=newnombre_linea_grupo;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setnombre_linea_categoria(String newnombre_linea_categoria)throws Exception
	{
		try {
			if(this.nombre_linea_categoria!=newnombre_linea_categoria) {
				if(newnombre_linea_categoria==null) {
					//newnombre_linea_categoria="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("AntiguedadesInventarios:Valor nulo no permitido en columna nombre_linea_categoria");
					}
				}

				if(newnombre_linea_categoria!=null&&newnombre_linea_categoria.length()>150) {
					newnombre_linea_categoria=newnombre_linea_categoria.substring(0,148);
					System.out.println("AntiguedadesInventarios:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=150 en columna nombre_linea_categoria");
				}

				this.nombre_linea_categoria=newnombre_linea_categoria;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setnombre_linea_marca(String newnombre_linea_marca)throws Exception
	{
		try {
			if(this.nombre_linea_marca!=newnombre_linea_marca) {
				if(newnombre_linea_marca==null) {
					//newnombre_linea_marca="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("AntiguedadesInventarios:Valor nulo no permitido en columna nombre_linea_marca");
					}
				}

				if(newnombre_linea_marca!=null&&newnombre_linea_marca.length()>150) {
					newnombre_linea_marca=newnombre_linea_marca.substring(0,148);
					System.out.println("AntiguedadesInventarios:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=150 en columna nombre_linea_marca");
				}

				this.nombre_linea_marca=newnombre_linea_marca;
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
						System.out.println("AntiguedadesInventarios:Valor nulo no permitido en columna codigo");
					}
				}

				if(newcodigo!=null&&newcodigo.length()>50) {
					newcodigo=newcodigo.substring(0,48);
					System.out.println("AntiguedadesInventarios:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=50 en columna codigo");
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
						System.out.println("AntiguedadesInventarios:Valor nulo no permitido en columna nombre");
					}
				}

				if(newnombre!=null&&newnombre.length()>150) {
					newnombre=newnombre.substring(0,148);
					System.out.println("AntiguedadesInventarios:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=150 en columna nombre");
				}

				this.nombre=newnombre;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setnombre_bodega(String newnombre_bodega)throws Exception
	{
		try {
			if(this.nombre_bodega!=newnombre_bodega) {
				if(newnombre_bodega==null) {
					//newnombre_bodega="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("AntiguedadesInventarios:Valor nulo no permitido en columna nombre_bodega");
					}
				}

				if(newnombre_bodega!=null&&newnombre_bodega.length()>150) {
					newnombre_bodega=newnombre_bodega.substring(0,148);
					System.out.println("AntiguedadesInventarios:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=150 en columna nombre_bodega");
				}

				this.nombre_bodega=newnombre_bodega;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setnombre_unidad(String newnombre_unidad)throws Exception
	{
		try {
			if(this.nombre_unidad!=newnombre_unidad) {
				if(newnombre_unidad==null) {
					//newnombre_unidad="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("AntiguedadesInventarios:Valor nulo no permitido en columna nombre_unidad");
					}
				}

				if(newnombre_unidad!=null&&newnombre_unidad.length()>50) {
					newnombre_unidad=newnombre_unidad.substring(0,48);
					System.out.println("AntiguedadesInventarios:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=50 en columna nombre_unidad");
				}

				this.nombre_unidad=newnombre_unidad;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setcantidad_disponible(Integer newcantidad_disponible)throws Exception
	{
		try {
			if(this.cantidad_disponible!=newcantidad_disponible) {
				if(newcantidad_disponible==null) {
					//newcantidad_disponible=0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("AntiguedadesInventarios:Valor nulo no permitido en columna cantidad_disponible");
					}
				}

				this.cantidad_disponible=newcantidad_disponible;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setfecha_ultima_compra(Date newfecha_ultima_compra)throws Exception
	{
		try {
			if(this.fecha_ultima_compra!=newfecha_ultima_compra) {
				if(newfecha_ultima_compra==null) {
					//newfecha_ultima_compra=new Date();
					if(Constantes.ISDEVELOPING) {
						System.out.println("AntiguedadesInventarios:Valor nulo no permitido en columna fecha_ultima_compra");
					}
				}

				this.fecha_ultima_compra=newfecha_ultima_compra;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setfecha_ultima_venta(Date newfecha_ultima_venta)throws Exception
	{
		try {
			if(this.fecha_ultima_venta!=newfecha_ultima_venta) {
				if(newfecha_ultima_venta==null) {
					//newfecha_ultima_venta=new Date();
					if(Constantes.ISDEVELOPING) {
						System.out.println("AntiguedadesInventarios:Valor nulo no permitido en columna fecha_ultima_venta");
					}
				}

				this.fecha_ultima_venta=newfecha_ultima_venta;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	
	public Bodega getBodega() {
		return this.bodega;
	}

	public Empresa getEmpresa() {
		return this.empresa;
	}

	public Sucursal getSucursal() {
		return this.sucursal;
	}

	public Linea getLinea() {
		return this.linea;
	}

	public Linea getLineaGrupo() {
		return this.lineagrupo;
	}

	public Linea getLineaCategoria() {
		return this.lineacategoria;
	}

	public Linea getLineaMarca() {
		return this.lineamarca;
	}

	
	
	public String getbodega_descripcion() {
		return this.bodega_descripcion;
	}

	public String getempresa_descripcion() {
		return this.empresa_descripcion;
	}

	public String getsucursal_descripcion() {
		return this.sucursal_descripcion;
	}

	public String getlinea_descripcion() {
		return this.linea_descripcion;
	}

	public String getlineagrupo_descripcion() {
		return this.lineagrupo_descripcion;
	}

	public String getlineacategoria_descripcion() {
		return this.lineacategoria_descripcion;
	}

	public String getlineamarca_descripcion() {
		return this.lineamarca_descripcion;
	}

	
	
	public  void  setBodega(Bodega bodega) {
		try {
			this.bodega=bodega;
		} catch(Exception e) {
			;
		}
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


	public  void  setLinea(Linea linea) {
		try {
			this.linea=linea;
		} catch(Exception e) {
			;
		}
	}


	public  void  setLineaGrupo(Linea lineagrupo) {
		try {
			this.lineagrupo=lineagrupo;
		} catch(Exception e) {
			;
		}
	}


	public  void  setLineaCategoria(Linea lineacategoria) {
		try {
			this.lineacategoria=lineacategoria;
		} catch(Exception e) {
			;
		}
	}


	public  void  setLineaMarca(Linea lineamarca) {
		try {
			this.lineamarca=lineamarca;
		} catch(Exception e) {
			;
		}
	}


	
	
	public  void  setbodega_descripcion(String bodega_descripcion) {
		try {
			this.bodega_descripcion=bodega_descripcion;
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


	public  void  setlinea_descripcion(String linea_descripcion) {
		try {
			this.linea_descripcion=linea_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  setlineagrupo_descripcion(String lineagrupo_descripcion) {
		try {
			this.lineagrupo_descripcion=lineagrupo_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  setlineacategoria_descripcion(String lineacategoria_descripcion) {
		try {
			this.lineacategoria_descripcion=lineacategoria_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  setlineamarca_descripcion(String lineamarca_descripcion) {
		try {
			this.lineamarca_descripcion=lineamarca_descripcion;
		} catch(Exception e) {
			;
		}
	}


	
	
	
	
	
	/*PARA REPORTES*/
	String id_bodega_descripcion="";String id_empresa_descripcion="";String id_sucursal_descripcion="";String id_linea_descripcion="";String id_linea_grupo_descripcion="";String id_linea_categoria_descripcion="";String id_linea_marca_descripcion="";
	
	
	public String getid_bodega_descripcion() {
		return id_bodega_descripcion;
	}
	public String getid_empresa_descripcion() {
		return id_empresa_descripcion;
	}
	public String getid_sucursal_descripcion() {
		return id_sucursal_descripcion;
	}
	public String getid_linea_descripcion() {
		return id_linea_descripcion;
	}
	public String getid_linea_grupo_descripcion() {
		return id_linea_grupo_descripcion;
	}
	public String getid_linea_categoria_descripcion() {
		return id_linea_categoria_descripcion;
	}
	public String getid_linea_marca_descripcion() {
		return id_linea_marca_descripcion;
	}
	
	
	public void setid_bodega_descripcion(String newid_bodega_descripcion)throws Exception {
		try {
			this.id_bodega_descripcion=newid_bodega_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
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
	public void setid_linea_descripcion(String newid_linea_descripcion)throws Exception {
		try {
			this.id_linea_descripcion=newid_linea_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_linea_grupo_descripcion(String newid_linea_grupo_descripcion)throws Exception {
		try {
			this.id_linea_grupo_descripcion=newid_linea_grupo_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_linea_categoria_descripcion(String newid_linea_categoria_descripcion)throws Exception {
		try {
			this.id_linea_categoria_descripcion=newid_linea_categoria_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_linea_marca_descripcion(String newid_linea_marca_descripcion)throws Exception {
		try {
			this.id_linea_marca_descripcion=newid_linea_marca_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	
	public void inicializarVariablesParaReporte() {
		this.id_bodega_descripcion="";this.id_empresa_descripcion="";this.id_sucursal_descripcion="";this.id_linea_descripcion="";this.id_linea_grupo_descripcion="";this.id_linea_categoria_descripcion="";this.id_linea_marca_descripcion="";
	}
	
	
	
	
	
	
	/*PARA REPORTES FIN*/		
}

