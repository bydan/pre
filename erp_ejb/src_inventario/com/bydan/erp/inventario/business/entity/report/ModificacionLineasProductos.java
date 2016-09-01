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
//import com.bydan.erp.inventario.util.ModificacionLineasProductosConstantesFunciones;
import com.bydan.erp.inventario.util.*;


import com.bydan.erp.inventario.util.*;

import com.bydan.erp.inventario.business.entity.*;


import com.bydan.erp.inventario.business.entity.*;




@SuppressWarnings("unused")
public class ModificacionLineasProductos extends ModificacionLineasProductosAdditional implements Serializable ,Cloneable {//ModificacionLineasProductosAdditional,GeneralEntity
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
	
	private ModificacionLineasProductos modificacionlineasproductosOriginal;
	
	private Map<String, Object> mapModificacionLineasProductos;
			
	public Map<String, Object> getMapModificacionLineasProductos() {
		return mapModificacionLineasProductos;
	}

	public void setMapModificacionLineasProductos(Map<String, Object> mapModificacionLineasProductos) {
		this.mapModificacionLineasProductos = mapModificacionLineasProductos;
	}
	
	public void inicializarMapModificacionLineasProductos() {
		this.mapModificacionLineasProductos = new HashMap<String,Object>();
	}
	
	public void setMapModificacionLineasProductosValue(String sKey,Object oValue) {
		this.mapModificacionLineasProductos.put(sKey, oValue);
	}
	
	public Object getMapModificacionLineasProductosValue(String sKey) {
		return this.mapModificacionLineasProductos.get(sKey);
	}
	
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_producto;
	
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
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_linea_destino;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_linea_grupo_destino;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_linea_categoria_destino;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_linea_marca_destino;
			
	
	public Producto producto;
	public Linea linea;
	public Linea lineagrupo;
	public Linea lineacategoria;
	public Linea lineamarca;
	public Linea lineadestino;
	public Linea lineagrupodestino;
	public Linea lineacategoriadestino;
	public Linea lineamarcadestino;
	
	
	private String producto_descripcion;
	private String linea_descripcion;
	private String lineagrupo_descripcion;
	private String lineacategoria_descripcion;
	private String lineamarca_descripcion;
	private String lineadestino_descripcion;
	private String lineagrupodestino_descripcion;
	private String lineacategoriadestino_descripcion;
	private String lineamarcadestino_descripcion;
	
	
		
	public ModificacionLineasProductos () throws Exception {
		super();		
		
		this.id=0L;
		
		
		this.versionRow=new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());//new Date();
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		this.sType="NONE";
		
		this.modificacionlineasproductosOriginal=this;
		
 		this.id_producto=-1L;
 		this.id_linea=-1L;
 		this.id_linea_grupo=-1L;
 		this.id_linea_categoria=-1L;
 		this.id_linea_marca=-1L;
 		this.id_linea_destino=-1L;
 		this.id_linea_grupo_destino=-1L;
 		this.id_linea_categoria_destino=-1L;
 		this.id_linea_marca_destino=-1L;
		
		
		this.producto=null;
		this.linea=null;
		this.lineagrupo=null;
		this.lineacategoria=null;
		this.lineamarca=null;
		this.lineadestino=null;
		this.lineagrupodestino=null;
		this.lineacategoriadestino=null;
		this.lineamarcadestino=null;
		
		
		this.producto_descripcion="";
		this.linea_descripcion="";
		this.lineagrupo_descripcion="";
		this.lineacategoria_descripcion="";
		this.lineamarca_descripcion="";
		this.lineadestino_descripcion="";
		this.lineagrupodestino_descripcion="";
		this.lineacategoriadestino_descripcion="";
		this.lineamarcadestino_descripcion="";
		
		
		
			
		
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	
	
	public ModificacionLineasProductos getModificacionLineasProductosOriginal() {
		return this.modificacionlineasproductosOriginal;
	}
	
	public void setModificacionLineasProductosOriginal(ModificacionLineasProductos modificacionlineasproductos) {
		try {
			this.modificacionlineasproductosOriginal=modificacionlineasproductos;
		} catch(Exception e) {
			;
		}
	}
	
	
	protected ModificacionLineasProductosAdditional modificacionlineasproductosAdditional=null;
	
	public ModificacionLineasProductosAdditional getModificacionLineasProductosAdditional() {
		return this.modificacionlineasproductosAdditional;
	}
	
	public void setModificacionLineasProductosAdditional(ModificacionLineasProductosAdditional modificacionlineasproductosAdditional) {
		try {
			this.modificacionlineasproductosAdditional=modificacionlineasproductosAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
    
	
	public Long getid_producto() {
		return this.id_producto;
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
    
	
	public Long getid_linea_destino() {
		return this.id_linea_destino;
	}
    
	
	public Long getid_linea_grupo_destino() {
		return this.id_linea_grupo_destino;
	}
    
	
	public Long getid_linea_categoria_destino() {
		return this.id_linea_categoria_destino;
	}
    
	
	public Long getid_linea_marca_destino() {
		return this.id_linea_marca_destino;
	}
	
    
	public void setid_producto(Long newid_producto)throws Exception
	{
		try {
			if(this.id_producto!=newid_producto) {
				if(newid_producto==null) {
					//newid_producto=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ModificacionLineasProductos:Valor nulo no permitido en columna id_producto");
					}
				}

				this.id_producto=newid_producto;
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
						System.out.println("ModificacionLineasProductos:Valor nulo no permitido en columna id_linea");
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
						System.out.println("ModificacionLineasProductos:Valor nulo no permitido en columna id_linea_grupo");
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
						System.out.println("ModificacionLineasProductos:Valor nulo no permitido en columna id_linea_categoria");
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
						System.out.println("ModificacionLineasProductos:Valor nulo no permitido en columna id_linea_marca");
					}
				}

				this.id_linea_marca=newid_linea_marca;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_linea_destino(Long newid_linea_destino)throws Exception
	{
		try {
			if(this.id_linea_destino!=newid_linea_destino) {
				if(newid_linea_destino==null) {
					//newid_linea_destino=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ModificacionLineasProductos:Valor nulo no permitido en columna id_linea_destino");
					}
				}

				this.id_linea_destino=newid_linea_destino;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_linea_grupo_destino(Long newid_linea_grupo_destino)throws Exception
	{
		try {
			if(this.id_linea_grupo_destino!=newid_linea_grupo_destino) {
				if(newid_linea_grupo_destino==null) {
					//newid_linea_grupo_destino=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ModificacionLineasProductos:Valor nulo no permitido en columna id_linea_grupo_destino");
					}
				}

				this.id_linea_grupo_destino=newid_linea_grupo_destino;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_linea_categoria_destino(Long newid_linea_categoria_destino)throws Exception
	{
		try {
			if(this.id_linea_categoria_destino!=newid_linea_categoria_destino) {
				if(newid_linea_categoria_destino==null) {
					//newid_linea_categoria_destino=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ModificacionLineasProductos:Valor nulo no permitido en columna id_linea_categoria_destino");
					}
				}

				this.id_linea_categoria_destino=newid_linea_categoria_destino;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_linea_marca_destino(Long newid_linea_marca_destino)throws Exception
	{
		try {
			if(this.id_linea_marca_destino!=newid_linea_marca_destino) {
				if(newid_linea_marca_destino==null) {
					//newid_linea_marca_destino=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ModificacionLineasProductos:Valor nulo no permitido en columna id_linea_marca_destino");
					}
				}

				this.id_linea_marca_destino=newid_linea_marca_destino;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	
	public Producto getProducto() {
		return this.producto;
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

	public Linea getLineaDestino() {
		return this.lineadestino;
	}

	public Linea getLineaGrupoDestino() {
		return this.lineagrupodestino;
	}

	public Linea getLineaCategoriaDestino() {
		return this.lineacategoriadestino;
	}

	public Linea getLineaMarcaDestino() {
		return this.lineamarcadestino;
	}

	
	
	public String getproducto_descripcion() {
		return this.producto_descripcion;
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

	public String getlineadestino_descripcion() {
		return this.lineadestino_descripcion;
	}

	public String getlineagrupodestino_descripcion() {
		return this.lineagrupodestino_descripcion;
	}

	public String getlineacategoriadestino_descripcion() {
		return this.lineacategoriadestino_descripcion;
	}

	public String getlineamarcadestino_descripcion() {
		return this.lineamarcadestino_descripcion;
	}

	
	
	public  void  setProducto(Producto producto) {
		try {
			this.producto=producto;
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


	public  void  setLineaDestino(Linea lineadestino) {
		try {
			this.lineadestino=lineadestino;
		} catch(Exception e) {
			;
		}
	}


	public  void  setLineaGrupoDestino(Linea lineagrupodestino) {
		try {
			this.lineagrupodestino=lineagrupodestino;
		} catch(Exception e) {
			;
		}
	}


	public  void  setLineaCategoriaDestino(Linea lineacategoriadestino) {
		try {
			this.lineacategoriadestino=lineacategoriadestino;
		} catch(Exception e) {
			;
		}
	}


	public  void  setLineaMarcaDestino(Linea lineamarcadestino) {
		try {
			this.lineamarcadestino=lineamarcadestino;
		} catch(Exception e) {
			;
		}
	}


	
	
	public  void  setproducto_descripcion(String producto_descripcion) {
		try {
			this.producto_descripcion=producto_descripcion;
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


	public  void  setlineadestino_descripcion(String lineadestino_descripcion) {
		try {
			this.lineadestino_descripcion=lineadestino_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  setlineagrupodestino_descripcion(String lineagrupodestino_descripcion) {
		try {
			this.lineagrupodestino_descripcion=lineagrupodestino_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  setlineacategoriadestino_descripcion(String lineacategoriadestino_descripcion) {
		try {
			this.lineacategoriadestino_descripcion=lineacategoriadestino_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  setlineamarcadestino_descripcion(String lineamarcadestino_descripcion) {
		try {
			this.lineamarcadestino_descripcion=lineamarcadestino_descripcion;
		} catch(Exception e) {
			;
		}
	}


	
	
	
	
	
	/*PARA REPORTES*/
	String id_producto_descripcion="";String id_linea_descripcion="";String id_linea_grupo_descripcion="";String id_linea_categoria_descripcion="";String id_linea_marca_descripcion="";String id_linea_destino_descripcion="";String id_linea_grupo_destino_descripcion="";String id_linea_categoria_destino_descripcion="";String id_linea_marca_destino_descripcion="";
	
	
	public String getid_producto_descripcion() {
		return id_producto_descripcion;
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
	public String getid_linea_destino_descripcion() {
		return id_linea_destino_descripcion;
	}
	public String getid_linea_grupo_destino_descripcion() {
		return id_linea_grupo_destino_descripcion;
	}
	public String getid_linea_categoria_destino_descripcion() {
		return id_linea_categoria_destino_descripcion;
	}
	public String getid_linea_marca_destino_descripcion() {
		return id_linea_marca_destino_descripcion;
	}
	
	
	public void setid_producto_descripcion(String newid_producto_descripcion)throws Exception {
		try {
			this.id_producto_descripcion=newid_producto_descripcion;
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
	public void setid_linea_destino_descripcion(String newid_linea_destino_descripcion)throws Exception {
		try {
			this.id_linea_destino_descripcion=newid_linea_destino_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_linea_grupo_destino_descripcion(String newid_linea_grupo_destino_descripcion)throws Exception {
		try {
			this.id_linea_grupo_destino_descripcion=newid_linea_grupo_destino_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_linea_categoria_destino_descripcion(String newid_linea_categoria_destino_descripcion)throws Exception {
		try {
			this.id_linea_categoria_destino_descripcion=newid_linea_categoria_destino_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_linea_marca_destino_descripcion(String newid_linea_marca_destino_descripcion)throws Exception {
		try {
			this.id_linea_marca_destino_descripcion=newid_linea_marca_destino_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	
	public void inicializarVariablesParaReporte() {
		this.id_producto_descripcion="";this.id_linea_descripcion="";this.id_linea_grupo_descripcion="";this.id_linea_categoria_descripcion="";this.id_linea_marca_descripcion="";this.id_linea_destino_descripcion="";this.id_linea_grupo_destino_descripcion="";this.id_linea_categoria_destino_descripcion="";this.id_linea_marca_destino_descripcion="";
	}
	
	
	
	
	
	
	/*PARA REPORTES FIN*/		
}

