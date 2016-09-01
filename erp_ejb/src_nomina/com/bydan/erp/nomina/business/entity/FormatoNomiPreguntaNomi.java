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
package com.bydan.erp.nomina.business.entity;

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
//import com.bydan.erp.nomina.util.FormatoNomiPreguntaNomiConstantesFunciones;
import com.bydan.erp.nomina.util.*;


import com.bydan.erp.seguridad.util.*;



import com.bydan.erp.seguridad.business.entity.*;




@SuppressWarnings("unused")
public class FormatoNomiPreguntaNomi extends FormatoNomiPreguntaNomiAdditional implements Serializable ,Cloneable {//FormatoNomiPreguntaNomiAdditional,GeneralEntity
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
	
	private FormatoNomiPreguntaNomi formatonomipreguntanomiOriginal;
	
	private Map<String, Object> mapFormatoNomiPreguntaNomi;
			
	public Map<String, Object> getMapFormatoNomiPreguntaNomi() {
		return mapFormatoNomiPreguntaNomi;
	}

	public void setMapFormatoNomiPreguntaNomi(Map<String, Object> mapFormatoNomiPreguntaNomi) {
		this.mapFormatoNomiPreguntaNomi = mapFormatoNomiPreguntaNomi;
	}
	
	public void inicializarMapFormatoNomiPreguntaNomi() {
		this.mapFormatoNomiPreguntaNomi = new HashMap<String,Object>();
	}
	
	public void setMapFormatoNomiPreguntaNomiValue(String sKey,Object oValue) {
		this.mapFormatoNomiPreguntaNomi.put(sKey, oValue);
	}
	
	public Object getMapFormatoNomiPreguntaNomiValue(String sKey) {
		return this.mapFormatoNomiPreguntaNomi.get(sKey);
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
	private Long id_formato_nomi;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_factor_nomi;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_pregunta_nomi;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double ponderacion;
			
	
	public Empresa empresa;
	public Sucursal sucursal;
	public FormatoNomi formatonomi;
	public FactorNomi factornomi;
	public PreguntaNomi preguntanomi;
	
	
	private String empresa_descripcion;
	private String sucursal_descripcion;
	private String formatonomi_descripcion;
	private String factornomi_descripcion;
	private String preguntanomi_descripcion;
	
	
	public List<CalificacionEmpleado> calificacionempleados;
		
	public FormatoNomiPreguntaNomi () throws Exception {
		super();		
		
		this.id=0L;
		
		
		this.versionRow=new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());//new Date();
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		this.sType="NONE";
		
		this.formatonomipreguntanomiOriginal=this;
		
 		this.id_empresa=-1L;
 		this.id_sucursal=-1L;
 		this.id_formato_nomi=-1L;
 		this.id_factor_nomi=-1L;
 		this.id_pregunta_nomi=-1L;
 		this.ponderacion=0.0;
		
		
		this.empresa=null;
		this.sucursal=null;
		this.formatonomi=null;
		this.factornomi=null;
		this.preguntanomi=null;
		
		
		this.empresa_descripcion="";
		this.sucursal_descripcion="";
		this.formatonomi_descripcion="";
		this.factornomi_descripcion="";
		this.preguntanomi_descripcion="";
		
		
		this.calificacionempleados=null;
		
			
		
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
    //PARA REPORTES
	public FormatoNomiPreguntaNomi (Long id,Date versionRow,Long id_empresa,Long id_sucursal,Long id_formato_nomi,Long id_factor_nomi,Long id_pregunta_nomi,Double ponderacion) throws Exception {
		super();		
		
		this.id=id;
		this.versionRow=versionRow;
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.formatonomipreguntanomiOriginal=this;
		
 		this.id_empresa=id_empresa;
 		this.id_sucursal=id_sucursal;
 		this.id_formato_nomi=id_formato_nomi;
 		this.id_factor_nomi=id_factor_nomi;
 		this.id_pregunta_nomi=id_pregunta_nomi;
 		this.ponderacion=ponderacion;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	 //PARA REPORTES
	public FormatoNomiPreguntaNomi (Long id_empresa,Long id_sucursal,Long id_formato_nomi,Long id_factor_nomi,Long id_pregunta_nomi,Double ponderacion) throws Exception {
		super();		
		
		this.id=0L;
		this.versionRow=new Date();
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.formatonomipreguntanomiOriginal=this;
		
 		this.id_empresa=id_empresa;
 		this.id_sucursal=id_sucursal;
 		this.id_formato_nomi=id_formato_nomi;
 		this.id_factor_nomi=id_factor_nomi;
 		this.id_pregunta_nomi=id_pregunta_nomi;
 		this.ponderacion=ponderacion;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	public boolean equals(Object object) {
		boolean equal=false;
		FormatoNomiPreguntaNomi formatonomipreguntanomiLocal=null;
		
		if(object!=null) {
			formatonomipreguntanomiLocal=(FormatoNomiPreguntaNomi)object;
			
			if(formatonomipreguntanomiLocal!=null) {
				if(this.getId()!=null && formatonomipreguntanomiLocal.getId()!=null) {
					if(this.getId().equals(formatonomipreguntanomiLocal.getId())) {
						equal=true;
					}
				}
			}
		}
		
		return equal;
	}
	
	public String toString() {
		String sDetalle="";
		
		if(!FormatoNomiPreguntaNomiConstantesFunciones.CON_DESCRIPCION_DETALLADO) {
        	sDetalle=FormatoNomiPreguntaNomiConstantesFunciones.getFormatoNomiPreguntaNomiDescripcion(this);
		} else {
			sDetalle=FormatoNomiPreguntaNomiConstantesFunciones.getFormatoNomiPreguntaNomiDescripcionDetallado(this);
		}
		
		return sDetalle;
    }
	
	public FormatoNomiPreguntaNomi getFormatoNomiPreguntaNomiOriginal() {
		return this.formatonomipreguntanomiOriginal;
	}
	
	public void setFormatoNomiPreguntaNomiOriginal(FormatoNomiPreguntaNomi formatonomipreguntanomi) {
		try {
			this.formatonomipreguntanomiOriginal=formatonomipreguntanomi;
		} catch(Exception e) {
			;
		}
	}
	
	
	protected FormatoNomiPreguntaNomiAdditional formatonomipreguntanomiAdditional=null;
	
	public FormatoNomiPreguntaNomiAdditional getFormatoNomiPreguntaNomiAdditional() {
		return this.formatonomipreguntanomiAdditional;
	}
	
	public void setFormatoNomiPreguntaNomiAdditional(FormatoNomiPreguntaNomiAdditional formatonomipreguntanomiAdditional) {
		try {
			this.formatonomipreguntanomiAdditional=formatonomipreguntanomiAdditional;
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
    
	
	public Long getid_formato_nomi() {
		return this.id_formato_nomi;
	}
    
	
	public Long getid_factor_nomi() {
		return this.id_factor_nomi;
	}
    
	
	public Long getid_pregunta_nomi() {
		return this.id_pregunta_nomi;
	}
    
	
	public Double getponderacion() {
		return this.ponderacion;
	}
	
    
	public void setid_empresa(Long newid_empresa)throws Exception
	{
		try {
			if(this.id_empresa!=newid_empresa) {
				if(newid_empresa==null) {
					//newid_empresa=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("FormatoNomiPreguntaNomi:Valor nulo no permitido en columna id_empresa");
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
						System.out.println("FormatoNomiPreguntaNomi:Valor nulo no permitido en columna id_sucursal");
					}
				}

				this.id_sucursal=newid_sucursal;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_formato_nomi(Long newid_formato_nomi)throws Exception
	{
		try {
			if(this.id_formato_nomi!=newid_formato_nomi) {
				if(newid_formato_nomi==null) {
					//newid_formato_nomi=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("FormatoNomiPreguntaNomi:Valor nulo no permitido en columna id_formato_nomi");
					}
				}

				this.id_formato_nomi=newid_formato_nomi;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_factor_nomi(Long newid_factor_nomi)throws Exception
	{
		try {
			if(this.id_factor_nomi!=newid_factor_nomi) {
				if(newid_factor_nomi==null) {
					//newid_factor_nomi=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("FormatoNomiPreguntaNomi:Valor nulo no permitido en columna id_factor_nomi");
					}
				}

				this.id_factor_nomi=newid_factor_nomi;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_pregunta_nomi(Long newid_pregunta_nomi)throws Exception
	{
		try {
			if(this.id_pregunta_nomi!=newid_pregunta_nomi) {
				if(newid_pregunta_nomi==null) {
					//newid_pregunta_nomi=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("FormatoNomiPreguntaNomi:Valor nulo no permitido en columna id_pregunta_nomi");
					}
				}

				this.id_pregunta_nomi=newid_pregunta_nomi;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setponderacion(Double newponderacion)throws Exception
	{
		try {
			if(this.ponderacion!=newponderacion) {
				if(newponderacion==null) {
					//newponderacion=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("FormatoNomiPreguntaNomi:Valor nulo no permitido en columna ponderacion");
					}
				}

				this.ponderacion=newponderacion;
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

	public FormatoNomi getFormatoNomi() {
		return this.formatonomi;
	}

	public FactorNomi getFactorNomi() {
		return this.factornomi;
	}

	public PreguntaNomi getPreguntaNomi() {
		return this.preguntanomi;
	}

	
	
	public String getempresa_descripcion() {
		return this.empresa_descripcion;
	}

	public String getsucursal_descripcion() {
		return this.sucursal_descripcion;
	}

	public String getformatonomi_descripcion() {
		return this.formatonomi_descripcion;
	}

	public String getfactornomi_descripcion() {
		return this.factornomi_descripcion;
	}

	public String getpreguntanomi_descripcion() {
		return this.preguntanomi_descripcion;
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


	public  void  setFormatoNomi(FormatoNomi formatonomi) {
		try {
			this.formatonomi=formatonomi;
		} catch(Exception e) {
			;
		}
	}


	public  void  setFactorNomi(FactorNomi factornomi) {
		try {
			this.factornomi=factornomi;
		} catch(Exception e) {
			;
		}
	}


	public  void  setPreguntaNomi(PreguntaNomi preguntanomi) {
		try {
			this.preguntanomi=preguntanomi;
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


	public  void  setformatonomi_descripcion(String formatonomi_descripcion) {
		try {
			this.formatonomi_descripcion=formatonomi_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  setfactornomi_descripcion(String factornomi_descripcion) {
		try {
			this.factornomi_descripcion=factornomi_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  setpreguntanomi_descripcion(String preguntanomi_descripcion) {
		try {
			this.preguntanomi_descripcion=preguntanomi_descripcion;
		} catch(Exception e) {
			;
		}
	}


	
	
	public List<CalificacionEmpleado> getCalificacionEmpleados() {
		return this.calificacionempleados;
	}

	
	
	public  void  setCalificacionEmpleados(List<CalificacionEmpleado> calificacionempleados) {
		try {
			this.calificacionempleados=calificacionempleados;
		} catch(Exception e) {
			;
		}
	}

	
	/*PARA REPORTES*/
	String id_empresa_descripcion="";String id_sucursal_descripcion="";String id_formato_nomi_descripcion="";String id_factor_nomi_descripcion="";String id_pregunta_nomi_descripcion="";
	
	
	public String getid_empresa_descripcion() {
		return id_empresa_descripcion;
	}
	public String getid_sucursal_descripcion() {
		return id_sucursal_descripcion;
	}
	public String getid_formato_nomi_descripcion() {
		return id_formato_nomi_descripcion;
	}
	public String getid_factor_nomi_descripcion() {
		return id_factor_nomi_descripcion;
	}
	public String getid_pregunta_nomi_descripcion() {
		return id_pregunta_nomi_descripcion;
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
	public void setid_formato_nomi_descripcion(String newid_formato_nomi_descripcion)throws Exception {
		try {
			this.id_formato_nomi_descripcion=newid_formato_nomi_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_factor_nomi_descripcion(String newid_factor_nomi_descripcion)throws Exception {
		try {
			this.id_factor_nomi_descripcion=newid_factor_nomi_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_pregunta_nomi_descripcion(String newid_pregunta_nomi_descripcion)throws Exception {
		try {
			this.id_pregunta_nomi_descripcion=newid_pregunta_nomi_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	
	public void inicializarVariablesParaReporte() {
		this.id_empresa_descripcion="";this.id_sucursal_descripcion="";this.id_formato_nomi_descripcion="";this.id_factor_nomi_descripcion="";this.id_pregunta_nomi_descripcion="";
	}
	
	
	Object calificacionempleadosDescripcionReporte;
	
	
	public Object getcalificacionempleadosDescripcionReporte() {
		return calificacionempleadosDescripcionReporte;
	}

	
	
	public  void  setcalificacionempleadosDescripcionReporte(Object calificacionempleados) {
		try {
			this.calificacionempleadosDescripcionReporte=calificacionempleados;
		} catch(Exception ex) {
			;
		}
	}

	/*PARA REPORTES FIN*/		
}

