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
package com.bydan.erp.seguridad.business.entity.report;

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
//import com.bydan.erp.seguridad.util.ProcesoCambiarParametroGeneralConstantesFunciones;
import com.bydan.erp.seguridad.util.*;


import com.bydan.erp.seguridad.util.*;

import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;




@SuppressWarnings("unused")
public class ProcesoCambiarParametroGeneral extends ProcesoCambiarParametroGeneralAdditional implements Serializable ,Cloneable {//ProcesoCambiarParametroGeneralAdditional,GeneralEntity
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
	
	private ProcesoCambiarParametroGeneral procesocambiarparametrogeneralOriginal;
	
	private Map<String, Object> mapProcesoCambiarParametroGeneral;
			
	public Map<String, Object> getMapProcesoCambiarParametroGeneral() {
		return mapProcesoCambiarParametroGeneral;
	}

	public void setMapProcesoCambiarParametroGeneral(Map<String, Object> mapProcesoCambiarParametroGeneral) {
		this.mapProcesoCambiarParametroGeneral = mapProcesoCambiarParametroGeneral;
	}
	
	public void inicializarMapProcesoCambiarParametroGeneral() {
		this.mapProcesoCambiarParametroGeneral = new HashMap<String,Object>();
	}
	
	public void setMapProcesoCambiarParametroGeneralValue(String sKey,Object oValue) {
		this.mapProcesoCambiarParametroGeneral.put(sKey, oValue);
	}
	
	public Object getMapProcesoCambiarParametroGeneralValue(String sKey) {
		return this.mapProcesoCambiarParametroGeneral.get(sKey);
	}
	
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_tipo_visual;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_tipo_fondo;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_tipo_fondo_borde;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_tipo_fondo_control;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_tipo_tamanio_control;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Boolean con_mensaje_confirmacion;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Boolean con_botones_tool_bar;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_tipo_exportar;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_tipo_delimiter;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Boolean con_exportar_cabecera;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=100,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	//@Pattern(regex=ProcesoCambiarParametroGeneralConstantesFunciones.SREGEXPATH_EXPORTAR,message=ProcesoCambiarParametroGeneralConstantesFunciones.SMENSAJEREGEXPATH_EXPORTAR)
	private String path_exportar;
			
	
	public TipoVisual tipovisual;
	public TipoFondo tipofondo;
	public TipoFondo tipofondoborde;
	public TipoFondoControl tipofondocontrol;
	public TipoTamanioControl tipotamaniocontrol;
	public TipoExportar tipoexportar;
	public TipoDelimiter tipodelimiter;
	
	
	private String tipovisual_descripcion;
	private String tipofondo_descripcion;
	private String tipofondoborde_descripcion;
	private String tipofondocontrol_descripcion;
	private String tipotamaniocontrol_descripcion;
	private String tipoexportar_descripcion;
	private String tipodelimiter_descripcion;
	
	
		
	public ProcesoCambiarParametroGeneral () throws Exception {
		super();		
		
		this.id=0L;
		
		
		this.versionRow=new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());//new Date();
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		this.sType="NONE";
		
		this.procesocambiarparametrogeneralOriginal=this;
		
 		this.id_tipo_visual=-1L;
 		this.id_tipo_fondo=-1L;
 		this.id_tipo_fondo_borde=-1L;
 		this.id_tipo_fondo_control=-1L;
 		this.id_tipo_tamanio_control=-1L;
 		this.con_mensaje_confirmacion=false;
 		this.con_botones_tool_bar=false;
 		this.id_tipo_exportar=-1L;
 		this.id_tipo_delimiter=-1L;
 		this.con_exportar_cabecera=false;
 		this.path_exportar="";
		
		
		this.tipovisual=null;
		this.tipofondo=null;
		this.tipofondoborde=null;
		this.tipofondocontrol=null;
		this.tipotamaniocontrol=null;
		this.tipoexportar=null;
		this.tipodelimiter=null;
		
		
		this.tipovisual_descripcion="";
		this.tipofondo_descripcion="";
		this.tipofondoborde_descripcion="";
		this.tipofondocontrol_descripcion="";
		this.tipotamaniocontrol_descripcion="";
		this.tipoexportar_descripcion="";
		this.tipodelimiter_descripcion="";
		
		
		
			
		
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	
	
	public ProcesoCambiarParametroGeneral getProcesoCambiarParametroGeneralOriginal() {
		return this.procesocambiarparametrogeneralOriginal;
	}
	
	public void setProcesoCambiarParametroGeneralOriginal(ProcesoCambiarParametroGeneral procesocambiarparametrogeneral) {
		try {
			this.procesocambiarparametrogeneralOriginal=procesocambiarparametrogeneral;
		} catch(Exception e) {
			;
		}
	}
	
	
	protected ProcesoCambiarParametroGeneralAdditional procesocambiarparametrogeneralAdditional=null;
	
	public ProcesoCambiarParametroGeneralAdditional getProcesoCambiarParametroGeneralAdditional() {
		return this.procesocambiarparametrogeneralAdditional;
	}
	
	public void setProcesoCambiarParametroGeneralAdditional(ProcesoCambiarParametroGeneralAdditional procesocambiarparametrogeneralAdditional) {
		try {
			this.procesocambiarparametrogeneralAdditional=procesocambiarparametrogeneralAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
    
	
	public Long getid_tipo_visual() {
		return this.id_tipo_visual;
	}
    
	
	public Long getid_tipo_fondo() {
		return this.id_tipo_fondo;
	}
    
	
	public Long getid_tipo_fondo_borde() {
		return this.id_tipo_fondo_borde;
	}
    
	
	public Long getid_tipo_fondo_control() {
		return this.id_tipo_fondo_control;
	}
    
	
	public Long getid_tipo_tamanio_control() {
		return this.id_tipo_tamanio_control;
	}
    
	
	public Boolean getcon_mensaje_confirmacion() {
		return this.con_mensaje_confirmacion;
	}
    
	
	public Boolean getcon_botones_tool_bar() {
		return this.con_botones_tool_bar;
	}
    
	
	public Long getid_tipo_exportar() {
		return this.id_tipo_exportar;
	}
    
	
	public Long getid_tipo_delimiter() {
		return this.id_tipo_delimiter;
	}
    
	
	public Boolean getcon_exportar_cabecera() {
		return this.con_exportar_cabecera;
	}
    
	
	public String getpath_exportar() {
		return this.path_exportar;
	}
	
    
	public void setid_tipo_visual(Long newid_tipo_visual)throws Exception
	{
		try {
			if(this.id_tipo_visual!=newid_tipo_visual) {
				if(newid_tipo_visual==null) {
					//newid_tipo_visual=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ProcesoCambiarParametroGeneral:Valor nulo no permitido en columna id_tipo_visual");
					}
				}

				this.id_tipo_visual=newid_tipo_visual;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_tipo_fondo(Long newid_tipo_fondo)throws Exception
	{
		try {
			if(this.id_tipo_fondo!=newid_tipo_fondo) {
				if(newid_tipo_fondo==null) {
					//newid_tipo_fondo=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ProcesoCambiarParametroGeneral:Valor nulo no permitido en columna id_tipo_fondo");
					}
				}

				this.id_tipo_fondo=newid_tipo_fondo;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_tipo_fondo_borde(Long newid_tipo_fondo_borde)throws Exception
	{
		try {
			if(this.id_tipo_fondo_borde!=newid_tipo_fondo_borde) {
				if(newid_tipo_fondo_borde==null) {
					//newid_tipo_fondo_borde=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ProcesoCambiarParametroGeneral:Valor nulo no permitido en columna id_tipo_fondo_borde");
					}
				}

				this.id_tipo_fondo_borde=newid_tipo_fondo_borde;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_tipo_fondo_control(Long newid_tipo_fondo_control)throws Exception
	{
		try {
			if(this.id_tipo_fondo_control!=newid_tipo_fondo_control) {
				if(newid_tipo_fondo_control==null) {
					//newid_tipo_fondo_control=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ProcesoCambiarParametroGeneral:Valor nulo no permitido en columna id_tipo_fondo_control");
					}
				}

				this.id_tipo_fondo_control=newid_tipo_fondo_control;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_tipo_tamanio_control(Long newid_tipo_tamanio_control)throws Exception
	{
		try {
			if(this.id_tipo_tamanio_control!=newid_tipo_tamanio_control) {
				if(newid_tipo_tamanio_control==null) {
					//newid_tipo_tamanio_control=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ProcesoCambiarParametroGeneral:Valor nulo no permitido en columna id_tipo_tamanio_control");
					}
				}

				this.id_tipo_tamanio_control=newid_tipo_tamanio_control;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setcon_mensaje_confirmacion(Boolean newcon_mensaje_confirmacion)throws Exception
	{
		try {
			if(this.con_mensaje_confirmacion!=newcon_mensaje_confirmacion) {
				if(newcon_mensaje_confirmacion==null) {
					//newcon_mensaje_confirmacion=false;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ProcesoCambiarParametroGeneral:Valor nulo no permitido en columna con_mensaje_confirmacion");
					}
				}

				this.con_mensaje_confirmacion=newcon_mensaje_confirmacion;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setcon_botones_tool_bar(Boolean newcon_botones_tool_bar)throws Exception
	{
		try {
			if(this.con_botones_tool_bar!=newcon_botones_tool_bar) {
				if(newcon_botones_tool_bar==null) {
					//newcon_botones_tool_bar=false;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ProcesoCambiarParametroGeneral:Valor nulo no permitido en columna con_botones_tool_bar");
					}
				}

				this.con_botones_tool_bar=newcon_botones_tool_bar;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_tipo_exportar(Long newid_tipo_exportar)throws Exception
	{
		try {
			if(this.id_tipo_exportar!=newid_tipo_exportar) {
				if(newid_tipo_exportar==null) {
					//newid_tipo_exportar=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ProcesoCambiarParametroGeneral:Valor nulo no permitido en columna id_tipo_exportar");
					}
				}

				this.id_tipo_exportar=newid_tipo_exportar;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_tipo_delimiter(Long newid_tipo_delimiter)throws Exception
	{
		try {
			if(this.id_tipo_delimiter!=newid_tipo_delimiter) {
				if(newid_tipo_delimiter==null) {
					//newid_tipo_delimiter=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ProcesoCambiarParametroGeneral:Valor nulo no permitido en columna id_tipo_delimiter");
					}
				}

				this.id_tipo_delimiter=newid_tipo_delimiter;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setcon_exportar_cabecera(Boolean newcon_exportar_cabecera)throws Exception
	{
		try {
			if(this.con_exportar_cabecera!=newcon_exportar_cabecera) {
				if(newcon_exportar_cabecera==null) {
					//newcon_exportar_cabecera=false;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ProcesoCambiarParametroGeneral:Valor nulo no permitido en columna con_exportar_cabecera");
					}
				}

				this.con_exportar_cabecera=newcon_exportar_cabecera;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setpath_exportar(String newpath_exportar)throws Exception
	{
		try {
			if(this.path_exportar!=newpath_exportar) {
				if(newpath_exportar==null) {
					//newpath_exportar="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("ProcesoCambiarParametroGeneral:Valor nulo no permitido en columna path_exportar");
					}
				}

				if(newpath_exportar!=null&&newpath_exportar.length()>100) {
					newpath_exportar=newpath_exportar.substring(0,98);
					System.out.println("ProcesoCambiarParametroGeneral:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=100 en columna path_exportar");
				}

				this.path_exportar=newpath_exportar;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	
	public TipoVisual getTipoVisual() {
		return this.tipovisual;
	}

	public TipoFondo getTipoFondo() {
		return this.tipofondo;
	}

	public TipoFondo getTipoFondoBorde() {
		return this.tipofondoborde;
	}

	public TipoFondoControl getTipoFondoControl() {
		return this.tipofondocontrol;
	}

	public TipoTamanioControl getTipoTamanioControl() {
		return this.tipotamaniocontrol;
	}

	public TipoExportar getTipoExportar() {
		return this.tipoexportar;
	}

	public TipoDelimiter getTipoDelimiter() {
		return this.tipodelimiter;
	}

	
	
	public String gettipovisual_descripcion() {
		return this.tipovisual_descripcion;
	}

	public String gettipofondo_descripcion() {
		return this.tipofondo_descripcion;
	}

	public String gettipofondoborde_descripcion() {
		return this.tipofondoborde_descripcion;
	}

	public String gettipofondocontrol_descripcion() {
		return this.tipofondocontrol_descripcion;
	}

	public String gettipotamaniocontrol_descripcion() {
		return this.tipotamaniocontrol_descripcion;
	}

	public String gettipoexportar_descripcion() {
		return this.tipoexportar_descripcion;
	}

	public String gettipodelimiter_descripcion() {
		return this.tipodelimiter_descripcion;
	}

	
	
	public  void  setTipoVisual(TipoVisual tipovisual) {
		try {
			this.tipovisual=tipovisual;
		} catch(Exception e) {
			;
		}
	}


	public  void  setTipoFondo(TipoFondo tipofondo) {
		try {
			this.tipofondo=tipofondo;
		} catch(Exception e) {
			;
		}
	}


	public  void  setTipoFondoBorde(TipoFondo tipofondoborde) {
		try {
			this.tipofondoborde=tipofondoborde;
		} catch(Exception e) {
			;
		}
	}


	public  void  setTipoFondoControl(TipoFondoControl tipofondocontrol) {
		try {
			this.tipofondocontrol=tipofondocontrol;
		} catch(Exception e) {
			;
		}
	}


	public  void  setTipoTamanioControl(TipoTamanioControl tipotamaniocontrol) {
		try {
			this.tipotamaniocontrol=tipotamaniocontrol;
		} catch(Exception e) {
			;
		}
	}


	public  void  setTipoExportar(TipoExportar tipoexportar) {
		try {
			this.tipoexportar=tipoexportar;
		} catch(Exception e) {
			;
		}
	}


	public  void  setTipoDelimiter(TipoDelimiter tipodelimiter) {
		try {
			this.tipodelimiter=tipodelimiter;
		} catch(Exception e) {
			;
		}
	}


	
	
	public  void  settipovisual_descripcion(String tipovisual_descripcion) {
		try {
			this.tipovisual_descripcion=tipovisual_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  settipofondo_descripcion(String tipofondo_descripcion) {
		try {
			this.tipofondo_descripcion=tipofondo_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  settipofondoborde_descripcion(String tipofondoborde_descripcion) {
		try {
			this.tipofondoborde_descripcion=tipofondoborde_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  settipofondocontrol_descripcion(String tipofondocontrol_descripcion) {
		try {
			this.tipofondocontrol_descripcion=tipofondocontrol_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  settipotamaniocontrol_descripcion(String tipotamaniocontrol_descripcion) {
		try {
			this.tipotamaniocontrol_descripcion=tipotamaniocontrol_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  settipoexportar_descripcion(String tipoexportar_descripcion) {
		try {
			this.tipoexportar_descripcion=tipoexportar_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  settipodelimiter_descripcion(String tipodelimiter_descripcion) {
		try {
			this.tipodelimiter_descripcion=tipodelimiter_descripcion;
		} catch(Exception e) {
			;
		}
	}


	
	
	
	
	
	/*PARA REPORTES*/
	String id_tipo_visual_descripcion="";String id_tipo_fondo_descripcion="";String id_tipo_fondo_borde_descripcion="";String id_tipo_fondo_control_descripcion="";String id_tipo_tamanio_control_descripcion="";String con_mensaje_confirmacion_descripcion="";String con_botones_tool_bar_descripcion="";String id_tipo_exportar_descripcion="";String id_tipo_delimiter_descripcion="";String con_exportar_cabecera_descripcion="";
	
	
	public String getid_tipo_visual_descripcion() {
		return id_tipo_visual_descripcion;
	}
	public String getid_tipo_fondo_descripcion() {
		return id_tipo_fondo_descripcion;
	}
	public String getid_tipo_fondo_borde_descripcion() {
		return id_tipo_fondo_borde_descripcion;
	}
	public String getid_tipo_fondo_control_descripcion() {
		return id_tipo_fondo_control_descripcion;
	}
	public String getid_tipo_tamanio_control_descripcion() {
		return id_tipo_tamanio_control_descripcion;
	}
	public String getcon_mensaje_confirmacion_descripcion() {
		return con_mensaje_confirmacion_descripcion;
	}
	public String getcon_botones_tool_bar_descripcion() {
		return con_botones_tool_bar_descripcion;
	}
	public String getid_tipo_exportar_descripcion() {
		return id_tipo_exportar_descripcion;
	}
	public String getid_tipo_delimiter_descripcion() {
		return id_tipo_delimiter_descripcion;
	}
	public String getcon_exportar_cabecera_descripcion() {
		return con_exportar_cabecera_descripcion;
	}
	
	
	public void setid_tipo_visual_descripcion(String newid_tipo_visual_descripcion)throws Exception {
		try {
			this.id_tipo_visual_descripcion=newid_tipo_visual_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_tipo_fondo_descripcion(String newid_tipo_fondo_descripcion)throws Exception {
		try {
			this.id_tipo_fondo_descripcion=newid_tipo_fondo_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_tipo_fondo_borde_descripcion(String newid_tipo_fondo_borde_descripcion)throws Exception {
		try {
			this.id_tipo_fondo_borde_descripcion=newid_tipo_fondo_borde_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_tipo_fondo_control_descripcion(String newid_tipo_fondo_control_descripcion)throws Exception {
		try {
			this.id_tipo_fondo_control_descripcion=newid_tipo_fondo_control_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_tipo_tamanio_control_descripcion(String newid_tipo_tamanio_control_descripcion)throws Exception {
		try {
			this.id_tipo_tamanio_control_descripcion=newid_tipo_tamanio_control_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setcon_mensaje_confirmacion_descripcion(String newcon_mensaje_confirmacion_descripcion)throws Exception {
		try {
			this.con_mensaje_confirmacion_descripcion=newcon_mensaje_confirmacion_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setcon_botones_tool_bar_descripcion(String newcon_botones_tool_bar_descripcion)throws Exception {
		try {
			this.con_botones_tool_bar_descripcion=newcon_botones_tool_bar_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_tipo_exportar_descripcion(String newid_tipo_exportar_descripcion)throws Exception {
		try {
			this.id_tipo_exportar_descripcion=newid_tipo_exportar_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_tipo_delimiter_descripcion(String newid_tipo_delimiter_descripcion)throws Exception {
		try {
			this.id_tipo_delimiter_descripcion=newid_tipo_delimiter_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setcon_exportar_cabecera_descripcion(String newcon_exportar_cabecera_descripcion)throws Exception {
		try {
			this.con_exportar_cabecera_descripcion=newcon_exportar_cabecera_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	
	public void inicializarVariablesParaReporte() {
		this.id_tipo_visual_descripcion="";this.id_tipo_fondo_descripcion="";this.id_tipo_fondo_borde_descripcion="";this.id_tipo_fondo_control_descripcion="";this.id_tipo_tamanio_control_descripcion="";this.con_mensaje_confirmacion_descripcion="";this.con_botones_tool_bar_descripcion="";this.id_tipo_exportar_descripcion="";this.id_tipo_delimiter_descripcion="";this.con_exportar_cabecera_descripcion="";
	}
	
	
	
	
	
	
	/*PARA REPORTES FIN*/		
}

