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
package com.bydan.erp.facturacion.business.entity.report;

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
//import com.bydan.erp.facturacion.util.VentasLineasConstantesFunciones;
import com.bydan.erp.facturacion.util.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.inventario.util.*;

import com.bydan.erp.facturacion.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.inventario.business.entity.*;




@SuppressWarnings("unused")
public class VentasLineas extends VentasLineasAdditional implements Serializable ,Cloneable {//VentasLineasAdditional,GeneralEntity
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
	
	private VentasLineas ventaslineasOriginal;
	
	private Map<String, Object> mapVentasLineas;
			
	public Map<String, Object> getMapVentasLineas() {
		return mapVentasLineas;
	}

	public void setMapVentasLineas(Map<String, Object> mapVentasLineas) {
		this.mapVentasLineas = mapVentasLineas;
	}
	
	public void inicializarMapVentasLineas() {
		this.mapVentasLineas = new HashMap<String,Object>();
	}
	
	public void setMapVentasLineasValue(String sKey,Object oValue) {
		this.mapVentasLineas.put(sKey, oValue);
	}
	
	public Object getMapVentasLineasValue(String sKey) {
		return this.mapVentasLineas.get(sKey);
	}
	
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_empresa;
	
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
	private Date fecha_emision_desde;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Date fecha_emision_hasta;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=150,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	//@Pattern(regex=VentasLineasConstantesFunciones.SREGEXNOMBRE_LINEA,message=VentasLineasConstantesFunciones.SMENSAJEREGEXNOMBRE_LINEA)
	private String nombre_linea;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=150,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	//@Pattern(regex=VentasLineasConstantesFunciones.SREGEXNOMBRE_GRUPO,message=VentasLineasConstantesFunciones.SMENSAJEREGEXNOMBRE_GRUPO)
	private String nombre_grupo;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=150,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	//@Pattern(regex=VentasLineasConstantesFunciones.SREGEXNOMBRE_CATEGORIA,message=VentasLineasConstantesFunciones.SMENSAJEREGEXNOMBRE_CATEGORIA)
	private String nombre_categoria;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=150,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	//@Pattern(regex=VentasLineasConstantesFunciones.SREGEXNOMBRE_MARCA,message=VentasLineasConstantesFunciones.SMENSAJEREGEXNOMBRE_MARCA)
	private String nombre_marca;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double monto;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double notas_credito;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double venta_neta;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double porcentaje;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double acumulado;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=50,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	//@Pattern(regex=VentasLineasConstantesFunciones.SREGEXTIPO,message=VentasLineasConstantesFunciones.SMENSAJEREGEXTIPO)
	private String tipo;
			
	
	public Empresa empresa;
	public Linea linea;
	public Linea lineagrupo;
	public Linea lineacategoria;
	public Linea lineamarca;
	
	
	private String empresa_descripcion;
	private String linea_descripcion;
	private String lineagrupo_descripcion;
	private String lineacategoria_descripcion;
	private String lineamarca_descripcion;
	
	
		
	public VentasLineas () throws Exception {
		super();		
		
		this.id=0L;
		
		
		this.versionRow=new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());//new Date();
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		this.sType="NONE";
		
		this.ventaslineasOriginal=this;
		
 		this.id_empresa=-1L;
 		this.id_linea=-1L;
 		this.id_linea_grupo=-1L;
 		this.id_linea_categoria=-1L;
 		this.id_linea_marca=-1L;
 		this.fecha_emision_desde=new Date();
 		this.fecha_emision_hasta=new Date();
 		this.nombre_linea="";
 		this.nombre_grupo="";
 		this.nombre_categoria="";
 		this.nombre_marca="";
 		this.monto=0.0;
 		this.notas_credito=0.0;
 		this.venta_neta=0.0;
 		this.porcentaje=0.0;
 		this.acumulado=0.0;
 		this.tipo="";
		
		
		this.empresa=null;
		this.linea=null;
		this.lineagrupo=null;
		this.lineacategoria=null;
		this.lineamarca=null;
		
		
		this.empresa_descripcion="";
		this.linea_descripcion="";
		this.lineagrupo_descripcion="";
		this.lineacategoria_descripcion="";
		this.lineamarca_descripcion="";
		
		
		
			
		
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
    //PARA REPORTES
	public VentasLineas (Long id,Date versionRow,String nombre_linea,String nombre_grupo,String nombre_categoria,String nombre_marca,Double monto,Double notas_credito,Double venta_neta,Double porcentaje,Double acumulado,String tipo) throws Exception {
		super();		
		
		this.id=id;
		this.versionRow=versionRow;
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.ventaslineasOriginal=this;
		
 		this.nombre_linea=nombre_linea;
 		this.nombre_grupo=nombre_grupo;
 		this.nombre_categoria=nombre_categoria;
 		this.nombre_marca=nombre_marca;
 		this.monto=monto;
 		this.notas_credito=notas_credito;
 		this.venta_neta=venta_neta;
 		this.porcentaje=porcentaje;
 		this.acumulado=acumulado;
 		this.tipo=tipo;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	 //PARA REPORTES
	public VentasLineas (String nombre_linea,String nombre_grupo,String nombre_categoria,String nombre_marca,Double monto,Double notas_credito,Double venta_neta,Double porcentaje,Double acumulado,String tipo) throws Exception {
		super();		
		
		this.id=0L;
		this.versionRow=new Date();
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.ventaslineasOriginal=this;
		
 		this.nombre_linea=nombre_linea;
 		this.nombre_grupo=nombre_grupo;
 		this.nombre_categoria=nombre_categoria;
 		this.nombre_marca=nombre_marca;
 		this.monto=monto;
 		this.notas_credito=notas_credito;
 		this.venta_neta=venta_neta;
 		this.porcentaje=porcentaje;
 		this.acumulado=acumulado;
 		this.tipo=tipo;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	
	public VentasLineas getVentasLineasOriginal() {
		return this.ventaslineasOriginal;
	}
	
	public void setVentasLineasOriginal(VentasLineas ventaslineas) {
		try {
			this.ventaslineasOriginal=ventaslineas;
		} catch(Exception e) {
			;
		}
	}
	
	
	protected VentasLineasAdditional ventaslineasAdditional=null;
	
	public VentasLineasAdditional getVentasLineasAdditional() {
		return this.ventaslineasAdditional;
	}
	
	public void setVentasLineasAdditional(VentasLineasAdditional ventaslineasAdditional) {
		try {
			this.ventaslineasAdditional=ventaslineasAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
    
	
	public Long getid_empresa() {
		return this.id_empresa;
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
    
	
	public Date getfecha_emision_desde() {
		return this.fecha_emision_desde;
	}
    
	
	public Date getfecha_emision_hasta() {
		return this.fecha_emision_hasta;
	}
    
	
	public String getnombre_linea() {
		return this.nombre_linea;
	}
    
	
	public String getnombre_grupo() {
		return this.nombre_grupo;
	}
    
	
	public String getnombre_categoria() {
		return this.nombre_categoria;
	}
    
	
	public String getnombre_marca() {
		return this.nombre_marca;
	}
    
	
	public Double getmonto() {
		return this.monto;
	}
    
	
	public Double getnotas_credito() {
		return this.notas_credito;
	}
    
	
	public Double getventa_neta() {
		return this.venta_neta;
	}
    
	
	public Double getporcentaje() {
		return this.porcentaje;
	}
    
	
	public Double getacumulado() {
		return this.acumulado;
	}
    
	
	public String gettipo() {
		return this.tipo;
	}
	
    
	public void setid_empresa(Long newid_empresa)throws Exception
	{
		try {
			if(this.id_empresa!=newid_empresa) {
				if(newid_empresa==null) {
					//newid_empresa=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("VentasLineas:Valor nulo no permitido en columna id_empresa");
					}
				}

				this.id_empresa=newid_empresa;
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
						System.out.println("VentasLineas:Valor nulo no permitido en columna id_linea");
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
						System.out.println("VentasLineas:Valor nulo no permitido en columna id_linea_grupo");
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
						System.out.println("VentasLineas:Valor nulo no permitido en columna id_linea_categoria");
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
						System.out.println("VentasLineas:Valor nulo no permitido en columna id_linea_marca");
					}
				}

				this.id_linea_marca=newid_linea_marca;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setfecha_emision_desde(Date newfecha_emision_desde)throws Exception
	{
		try {
			if(this.fecha_emision_desde!=newfecha_emision_desde) {
				if(newfecha_emision_desde==null) {
					//newfecha_emision_desde=new Date();
					if(Constantes.ISDEVELOPING) {
						System.out.println("VentasLineas:Valor nulo no permitido en columna fecha_emision_desde");
					}
				}

				this.fecha_emision_desde=newfecha_emision_desde;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setfecha_emision_hasta(Date newfecha_emision_hasta)throws Exception
	{
		try {
			if(this.fecha_emision_hasta!=newfecha_emision_hasta) {
				if(newfecha_emision_hasta==null) {
					//newfecha_emision_hasta=new Date();
					if(Constantes.ISDEVELOPING) {
						System.out.println("VentasLineas:Valor nulo no permitido en columna fecha_emision_hasta");
					}
				}

				this.fecha_emision_hasta=newfecha_emision_hasta;
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
						System.out.println("VentasLineas:Valor nulo no permitido en columna nombre_linea");
					}
				}

				if(newnombre_linea!=null&&newnombre_linea.length()>150) {
					newnombre_linea=newnombre_linea.substring(0,148);
					System.out.println("VentasLineas:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=150 en columna nombre_linea");
				}

				this.nombre_linea=newnombre_linea;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setnombre_grupo(String newnombre_grupo)throws Exception
	{
		try {
			if(this.nombre_grupo!=newnombre_grupo) {
				if(newnombre_grupo==null) {
					//newnombre_grupo="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("VentasLineas:Valor nulo no permitido en columna nombre_grupo");
					}
				}

				if(newnombre_grupo!=null&&newnombre_grupo.length()>150) {
					newnombre_grupo=newnombre_grupo.substring(0,148);
					System.out.println("VentasLineas:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=150 en columna nombre_grupo");
				}

				this.nombre_grupo=newnombre_grupo;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setnombre_categoria(String newnombre_categoria)throws Exception
	{
		try {
			if(this.nombre_categoria!=newnombre_categoria) {
				if(newnombre_categoria==null) {
					//newnombre_categoria="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("VentasLineas:Valor nulo no permitido en columna nombre_categoria");
					}
				}

				if(newnombre_categoria!=null&&newnombre_categoria.length()>150) {
					newnombre_categoria=newnombre_categoria.substring(0,148);
					System.out.println("VentasLineas:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=150 en columna nombre_categoria");
				}

				this.nombre_categoria=newnombre_categoria;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setnombre_marca(String newnombre_marca)throws Exception
	{
		try {
			if(this.nombre_marca!=newnombre_marca) {
				if(newnombre_marca==null) {
					//newnombre_marca="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("VentasLineas:Valor nulo no permitido en columna nombre_marca");
					}
				}

				if(newnombre_marca!=null&&newnombre_marca.length()>150) {
					newnombre_marca=newnombre_marca.substring(0,148);
					System.out.println("VentasLineas:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=150 en columna nombre_marca");
				}

				this.nombre_marca=newnombre_marca;
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
						System.out.println("VentasLineas:Valor nulo no permitido en columna monto");
					}
				}

				this.monto=newmonto;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setnotas_credito(Double newnotas_credito)throws Exception
	{
		try {
			if(this.notas_credito!=newnotas_credito) {
				if(newnotas_credito==null) {
					//newnotas_credito=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("VentasLineas:Valor nulo no permitido en columna notas_credito");
					}
				}

				this.notas_credito=newnotas_credito;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setventa_neta(Double newventa_neta)throws Exception
	{
		try {
			if(this.venta_neta!=newventa_neta) {
				if(newventa_neta==null) {
					//newventa_neta=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("VentasLineas:Valor nulo no permitido en columna venta_neta");
					}
				}

				this.venta_neta=newventa_neta;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setporcentaje(Double newporcentaje)throws Exception
	{
		try {
			if(this.porcentaje!=newporcentaje) {
				if(newporcentaje==null) {
					//newporcentaje=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("VentasLineas:Valor nulo no permitido en columna porcentaje");
					}
				}

				this.porcentaje=newporcentaje;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setacumulado(Double newacumulado)throws Exception
	{
		try {
			if(this.acumulado!=newacumulado) {
				if(newacumulado==null) {
					//newacumulado=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("VentasLineas:Valor nulo no permitido en columna acumulado");
					}
				}

				this.acumulado=newacumulado;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void settipo(String newtipo)throws Exception
	{
		try {
			if(this.tipo!=newtipo) {
				if(newtipo==null) {
					//newtipo="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("VentasLineas:Valor nulo no permitido en columna tipo");
					}
				}

				if(newtipo!=null&&newtipo.length()>50) {
					newtipo=newtipo.substring(0,48);
					System.out.println("VentasLineas:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=50 en columna tipo");
				}

				this.tipo=newtipo;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	
	public Empresa getEmpresa() {
		return this.empresa;
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

	
	
	public String getempresa_descripcion() {
		return this.empresa_descripcion;
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

	
	
	public  void  setEmpresa(Empresa empresa) {
		try {
			this.empresa=empresa;
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


	
	
	public  void  setempresa_descripcion(String empresa_descripcion) {
		try {
			this.empresa_descripcion=empresa_descripcion;
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
	String id_empresa_descripcion="";String id_linea_descripcion="";String id_linea_grupo_descripcion="";String id_linea_categoria_descripcion="";String id_linea_marca_descripcion="";
	
	
	public String getid_empresa_descripcion() {
		return id_empresa_descripcion;
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
	
	
	public void setid_empresa_descripcion(String newid_empresa_descripcion)throws Exception {
		try {
			this.id_empresa_descripcion=newid_empresa_descripcion;
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
		this.id_empresa_descripcion="";this.id_linea_descripcion="";this.id_linea_grupo_descripcion="";this.id_linea_categoria_descripcion="";this.id_linea_marca_descripcion="";
	}
	
	
	
	
	
	
	/*PARA REPORTES FIN*/		
}

