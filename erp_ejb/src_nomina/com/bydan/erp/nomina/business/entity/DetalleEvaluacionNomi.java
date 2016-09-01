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
//import com.bydan.erp.nomina.util.DetalleEvaluacionNomiConstantesFunciones;
import com.bydan.erp.nomina.util.*;


import com.bydan.erp.seguridad.util.*;



import com.bydan.erp.seguridad.business.entity.*;




@SuppressWarnings("unused")
public class DetalleEvaluacionNomi extends DetalleEvaluacionNomiAdditional implements Serializable ,Cloneable {//DetalleEvaluacionNomiAdditional,GeneralEntity
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
	
	private DetalleEvaluacionNomi detalleevaluacionnomiOriginal;
	
	private Map<String, Object> mapDetalleEvaluacionNomi;
			
	public Map<String, Object> getMapDetalleEvaluacionNomi() {
		return mapDetalleEvaluacionNomi;
	}

	public void setMapDetalleEvaluacionNomi(Map<String, Object> mapDetalleEvaluacionNomi) {
		this.mapDetalleEvaluacionNomi = mapDetalleEvaluacionNomi;
	}
	
	public void inicializarMapDetalleEvaluacionNomi() {
		this.mapDetalleEvaluacionNomi = new HashMap<String,Object>();
	}
	
	public void setMapDetalleEvaluacionNomiValue(String sKey,Object oValue) {
		this.mapDetalleEvaluacionNomi.put(sKey, oValue);
	}
	
	public Object getMapDetalleEvaluacionNomiValue(String sKey) {
		return this.mapDetalleEvaluacionNomi.get(sKey);
	}
	
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_empresa;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_evaluacion_nomi;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_formato_nomi;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_pregunta_nomi;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=200,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=DetalleEvaluacionNomiConstantesFunciones.SREGEXRESPUESTA,message=DetalleEvaluacionNomiConstantesFunciones.SMENSAJEREGEXRESPUESTA)
	private String respuesta;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double respuesta_valor;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Boolean califica1;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Boolean califica2;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Boolean califica3;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Boolean califica4;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Boolean califica5;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Boolean califica6;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Boolean califica7;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Boolean califica8;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Boolean califica9;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Boolean califica10;
			
	
	public Empresa empresa;
	public EvaluacionNomi evaluacionnomi;
	public FormatoNomi formatonomi;
	public PreguntaNomi preguntanomi;
	
	
	private String empresa_descripcion;
	private String evaluacionnomi_descripcion;
	private String formatonomi_descripcion;
	private String preguntanomi_descripcion;
	
	
		
	public DetalleEvaluacionNomi () throws Exception {
		super();		
		
		this.id=0L;
		
		
		this.versionRow=new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());//new Date();
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		this.sType="NONE";
		
		this.detalleevaluacionnomiOriginal=this;
		
 		this.id_empresa=-1L;
 		this.id_evaluacion_nomi=-1L;
 		this.id_formato_nomi=-1L;
 		this.id_pregunta_nomi=-1L;
 		this.respuesta="";
 		this.respuesta_valor=0.0;
 		this.califica1=false;
 		this.califica2=false;
 		this.califica3=false;
 		this.califica4=false;
 		this.califica5=false;
 		this.califica6=false;
 		this.califica7=false;
 		this.califica8=false;
 		this.califica9=false;
 		this.califica10=false;
		
		
		this.empresa=null;
		this.evaluacionnomi=null;
		this.formatonomi=null;
		this.preguntanomi=null;
		
		
		this.empresa_descripcion="";
		this.evaluacionnomi_descripcion="";
		this.formatonomi_descripcion="";
		this.preguntanomi_descripcion="";
		
		
		
			
		
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
    //PARA REPORTES
	public DetalleEvaluacionNomi (Long id,Date versionRow,Long id_empresa,Long id_evaluacion_nomi,Long id_formato_nomi,Long id_pregunta_nomi,String respuesta,Double respuesta_valor,Boolean califica1,Boolean califica2,Boolean califica3,Boolean califica4,Boolean califica5,Boolean califica6,Boolean califica7,Boolean califica8,Boolean califica9,Boolean califica10) throws Exception {
		super();		
		
		this.id=id;
		this.versionRow=versionRow;
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.detalleevaluacionnomiOriginal=this;
		
 		this.id_empresa=id_empresa;
 		this.id_evaluacion_nomi=id_evaluacion_nomi;
 		this.id_formato_nomi=id_formato_nomi;
 		this.id_pregunta_nomi=id_pregunta_nomi;
 		this.respuesta=respuesta;
 		this.respuesta_valor=respuesta_valor;
 		this.califica1=califica1;
 		this.califica2=califica2;
 		this.califica3=califica3;
 		this.califica4=califica4;
 		this.califica5=califica5;
 		this.califica6=califica6;
 		this.califica7=califica7;
 		this.califica8=califica8;
 		this.califica9=califica9;
 		this.califica10=califica10;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	 //PARA REPORTES
	public DetalleEvaluacionNomi (Long id_empresa,Long id_evaluacion_nomi,Long id_formato_nomi,Long id_pregunta_nomi,String respuesta,Double respuesta_valor,Boolean califica1,Boolean califica2,Boolean califica3,Boolean califica4,Boolean califica5,Boolean califica6,Boolean califica7,Boolean califica8,Boolean califica9,Boolean califica10) throws Exception {
		super();		
		
		this.id=0L;
		this.versionRow=new Date();
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.detalleevaluacionnomiOriginal=this;
		
 		this.id_empresa=id_empresa;
 		this.id_evaluacion_nomi=id_evaluacion_nomi;
 		this.id_formato_nomi=id_formato_nomi;
 		this.id_pregunta_nomi=id_pregunta_nomi;
 		this.respuesta=respuesta;
 		this.respuesta_valor=respuesta_valor;
 		this.califica1=califica1;
 		this.califica2=califica2;
 		this.califica3=califica3;
 		this.califica4=califica4;
 		this.califica5=califica5;
 		this.califica6=califica6;
 		this.califica7=califica7;
 		this.califica8=califica8;
 		this.califica9=califica9;
 		this.califica10=califica10;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	public boolean equals(Object object) {
		boolean equal=false;
		DetalleEvaluacionNomi detalleevaluacionnomiLocal=null;
		
		if(object!=null) {
			detalleevaluacionnomiLocal=(DetalleEvaluacionNomi)object;
			
			if(detalleevaluacionnomiLocal!=null) {
				if(this.getId()!=null && detalleevaluacionnomiLocal.getId()!=null) {
					if(this.getId().equals(detalleevaluacionnomiLocal.getId())) {
						equal=true;
					}
				}
			}
		}
		
		return equal;
	}
	
	public String toString() {
		String sDetalle="";
		
		if(!DetalleEvaluacionNomiConstantesFunciones.CON_DESCRIPCION_DETALLADO) {
        	sDetalle=DetalleEvaluacionNomiConstantesFunciones.getDetalleEvaluacionNomiDescripcion(this);
		} else {
			sDetalle=DetalleEvaluacionNomiConstantesFunciones.getDetalleEvaluacionNomiDescripcionDetallado(this);
		}
		
		return sDetalle;
    }
	
	public DetalleEvaluacionNomi getDetalleEvaluacionNomiOriginal() {
		return this.detalleevaluacionnomiOriginal;
	}
	
	public void setDetalleEvaluacionNomiOriginal(DetalleEvaluacionNomi detalleevaluacionnomi) {
		try {
			this.detalleevaluacionnomiOriginal=detalleevaluacionnomi;
		} catch(Exception e) {
			;
		}
	}
	
	
	protected DetalleEvaluacionNomiAdditional detalleevaluacionnomiAdditional=null;
	
	public DetalleEvaluacionNomiAdditional getDetalleEvaluacionNomiAdditional() {
		return this.detalleevaluacionnomiAdditional;
	}
	
	public void setDetalleEvaluacionNomiAdditional(DetalleEvaluacionNomiAdditional detalleevaluacionnomiAdditional) {
		try {
			this.detalleevaluacionnomiAdditional=detalleevaluacionnomiAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
    
	
	public Long getid_empresa() {
		return this.id_empresa;
	}
    
	
	public Long getid_evaluacion_nomi() {
		return this.id_evaluacion_nomi;
	}
    
	
	public Long getid_formato_nomi() {
		return this.id_formato_nomi;
	}
    
	
	public Long getid_pregunta_nomi() {
		return this.id_pregunta_nomi;
	}
    
	
	public String getrespuesta() {
		return this.respuesta;
	}
    
	
	public Double getrespuesta_valor() {
		return this.respuesta_valor;
	}
    
	
	public Boolean getcalifica1() {
		return this.califica1;
	}
    
	
	public Boolean getcalifica2() {
		return this.califica2;
	}
    
	
	public Boolean getcalifica3() {
		return this.califica3;
	}
    
	
	public Boolean getcalifica4() {
		return this.califica4;
	}
    
	
	public Boolean getcalifica5() {
		return this.califica5;
	}
    
	
	public Boolean getcalifica6() {
		return this.califica6;
	}
    
	
	public Boolean getcalifica7() {
		return this.califica7;
	}
    
	
	public Boolean getcalifica8() {
		return this.califica8;
	}
    
	
	public Boolean getcalifica9() {
		return this.califica9;
	}
    
	
	public Boolean getcalifica10() {
		return this.califica10;
	}
	
    
	public void setid_empresa(Long newid_empresa)throws Exception
	{
		try {
			if(this.id_empresa!=newid_empresa) {
				if(newid_empresa==null) {
					//newid_empresa=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("DetalleEvaluacionNomi:Valor nulo no permitido en columna id_empresa");
					}
				}

				this.id_empresa=newid_empresa;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_evaluacion_nomi(Long newid_evaluacion_nomi)throws Exception
	{
		try {
			if(this.id_evaluacion_nomi!=newid_evaluacion_nomi) {
				if(newid_evaluacion_nomi==null) {
					//newid_evaluacion_nomi=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("DetalleEvaluacionNomi:Valor nulo no permitido en columna id_evaluacion_nomi");
					}
				}

				this.id_evaluacion_nomi=newid_evaluacion_nomi;
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
						System.out.println("DetalleEvaluacionNomi:Valor nulo no permitido en columna id_formato_nomi");
					}
				}

				this.id_formato_nomi=newid_formato_nomi;
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
						System.out.println("DetalleEvaluacionNomi:Valor nulo no permitido en columna id_pregunta_nomi");
					}
				}

				this.id_pregunta_nomi=newid_pregunta_nomi;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setrespuesta(String newrespuesta)throws Exception
	{
		try {
			if(this.respuesta!=newrespuesta) {
				if(newrespuesta==null) {
					//newrespuesta="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("DetalleEvaluacionNomi:Valor nulo no permitido en columna respuesta");
					}
				}

				if(newrespuesta!=null&&newrespuesta.length()>200) {
					newrespuesta=newrespuesta.substring(0,198);
					System.out.println("DetalleEvaluacionNomi:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=200 en columna respuesta");
				}

				this.respuesta=newrespuesta;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setrespuesta_valor(Double newrespuesta_valor)throws Exception
	{
		try {
			if(this.respuesta_valor!=newrespuesta_valor) {
				if(newrespuesta_valor==null) {
					//newrespuesta_valor=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("DetalleEvaluacionNomi:Valor nulo no permitido en columna respuesta_valor");
					}
				}

				this.respuesta_valor=newrespuesta_valor;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setcalifica1(Boolean newcalifica1)throws Exception
	{
		try {
			if(this.califica1!=newcalifica1) {
				if(newcalifica1==null) {
					//newcalifica1=false;
					if(Constantes.ISDEVELOPING) {
						System.out.println("DetalleEvaluacionNomi:Valor nulo no permitido en columna califica1");
					}
				}

				this.califica1=newcalifica1;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setcalifica2(Boolean newcalifica2)throws Exception
	{
		try {
			if(this.califica2!=newcalifica2) {
				if(newcalifica2==null) {
					//newcalifica2=false;
					if(Constantes.ISDEVELOPING) {
						System.out.println("DetalleEvaluacionNomi:Valor nulo no permitido en columna califica2");
					}
				}

				this.califica2=newcalifica2;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setcalifica3(Boolean newcalifica3)throws Exception
	{
		try {
			if(this.califica3!=newcalifica3) {
				if(newcalifica3==null) {
					//newcalifica3=false;
					if(Constantes.ISDEVELOPING) {
						System.out.println("DetalleEvaluacionNomi:Valor nulo no permitido en columna califica3");
					}
				}

				this.califica3=newcalifica3;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setcalifica4(Boolean newcalifica4)throws Exception
	{
		try {
			if(this.califica4!=newcalifica4) {
				if(newcalifica4==null) {
					//newcalifica4=false;
					if(Constantes.ISDEVELOPING) {
						System.out.println("DetalleEvaluacionNomi:Valor nulo no permitido en columna califica4");
					}
				}

				this.califica4=newcalifica4;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setcalifica5(Boolean newcalifica5)throws Exception
	{
		try {
			if(this.califica5!=newcalifica5) {
				if(newcalifica5==null) {
					//newcalifica5=false;
					if(Constantes.ISDEVELOPING) {
						System.out.println("DetalleEvaluacionNomi:Valor nulo no permitido en columna califica5");
					}
				}

				this.califica5=newcalifica5;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setcalifica6(Boolean newcalifica6)throws Exception
	{
		try {
			if(this.califica6!=newcalifica6) {
				if(newcalifica6==null) {
					//newcalifica6=false;
					if(Constantes.ISDEVELOPING) {
						System.out.println("DetalleEvaluacionNomi:Valor nulo no permitido en columna califica6");
					}
				}

				this.califica6=newcalifica6;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setcalifica7(Boolean newcalifica7)throws Exception
	{
		try {
			if(this.califica7!=newcalifica7) {
				if(newcalifica7==null) {
					//newcalifica7=false;
					if(Constantes.ISDEVELOPING) {
						System.out.println("DetalleEvaluacionNomi:Valor nulo no permitido en columna califica7");
					}
				}

				this.califica7=newcalifica7;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setcalifica8(Boolean newcalifica8)throws Exception
	{
		try {
			if(this.califica8!=newcalifica8) {
				if(newcalifica8==null) {
					//newcalifica8=false;
					if(Constantes.ISDEVELOPING) {
						System.out.println("DetalleEvaluacionNomi:Valor nulo no permitido en columna califica8");
					}
				}

				this.califica8=newcalifica8;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setcalifica9(Boolean newcalifica9)throws Exception
	{
		try {
			if(this.califica9!=newcalifica9) {
				if(newcalifica9==null) {
					//newcalifica9=false;
					if(Constantes.ISDEVELOPING) {
						System.out.println("DetalleEvaluacionNomi:Valor nulo no permitido en columna califica9");
					}
				}

				this.califica9=newcalifica9;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setcalifica10(Boolean newcalifica10)throws Exception
	{
		try {
			if(this.califica10!=newcalifica10) {
				if(newcalifica10==null) {
					//newcalifica10=false;
					if(Constantes.ISDEVELOPING) {
						System.out.println("DetalleEvaluacionNomi:Valor nulo no permitido en columna califica10");
					}
				}

				this.califica10=newcalifica10;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	
	public Empresa getEmpresa() {
		return this.empresa;
	}

	public EvaluacionNomi getEvaluacionNomi() {
		return this.evaluacionnomi;
	}

	public FormatoNomi getFormatoNomi() {
		return this.formatonomi;
	}

	public PreguntaNomi getPreguntaNomi() {
		return this.preguntanomi;
	}

	
	
	public String getempresa_descripcion() {
		return this.empresa_descripcion;
	}

	public String getevaluacionnomi_descripcion() {
		return this.evaluacionnomi_descripcion;
	}

	public String getformatonomi_descripcion() {
		return this.formatonomi_descripcion;
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


	public  void  setEvaluacionNomi(EvaluacionNomi evaluacionnomi) {
		try {
			this.evaluacionnomi=evaluacionnomi;
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


	public  void  setevaluacionnomi_descripcion(String evaluacionnomi_descripcion) {
		try {
			this.evaluacionnomi_descripcion=evaluacionnomi_descripcion;
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


	public  void  setpreguntanomi_descripcion(String preguntanomi_descripcion) {
		try {
			this.preguntanomi_descripcion=preguntanomi_descripcion;
		} catch(Exception e) {
			;
		}
	}


	
	
	
	
	
	/*PARA REPORTES*/
	String id_empresa_descripcion="";String id_evaluacion_nomi_descripcion="";String id_formato_nomi_descripcion="";String id_pregunta_nomi_descripcion="";String califica1_descripcion="";String califica2_descripcion="";String califica3_descripcion="";String califica4_descripcion="";String califica5_descripcion="";String califica6_descripcion="";String califica7_descripcion="";String califica8_descripcion="";String califica9_descripcion="";String califica10_descripcion="";
	
	
	public String getid_empresa_descripcion() {
		return id_empresa_descripcion;
	}
	public String getid_evaluacion_nomi_descripcion() {
		return id_evaluacion_nomi_descripcion;
	}
	public String getid_formato_nomi_descripcion() {
		return id_formato_nomi_descripcion;
	}
	public String getid_pregunta_nomi_descripcion() {
		return id_pregunta_nomi_descripcion;
	}
	public String getcalifica1_descripcion() {
		return califica1_descripcion;
	}
	public String getcalifica2_descripcion() {
		return califica2_descripcion;
	}
	public String getcalifica3_descripcion() {
		return califica3_descripcion;
	}
	public String getcalifica4_descripcion() {
		return califica4_descripcion;
	}
	public String getcalifica5_descripcion() {
		return califica5_descripcion;
	}
	public String getcalifica6_descripcion() {
		return califica6_descripcion;
	}
	public String getcalifica7_descripcion() {
		return califica7_descripcion;
	}
	public String getcalifica8_descripcion() {
		return califica8_descripcion;
	}
	public String getcalifica9_descripcion() {
		return califica9_descripcion;
	}
	public String getcalifica10_descripcion() {
		return califica10_descripcion;
	}
	
	
	public void setid_empresa_descripcion(String newid_empresa_descripcion)throws Exception {
		try {
			this.id_empresa_descripcion=newid_empresa_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_evaluacion_nomi_descripcion(String newid_evaluacion_nomi_descripcion)throws Exception {
		try {
			this.id_evaluacion_nomi_descripcion=newid_evaluacion_nomi_descripcion;
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
	public void setid_pregunta_nomi_descripcion(String newid_pregunta_nomi_descripcion)throws Exception {
		try {
			this.id_pregunta_nomi_descripcion=newid_pregunta_nomi_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setcalifica1_descripcion(String newcalifica1_descripcion)throws Exception {
		try {
			this.califica1_descripcion=newcalifica1_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setcalifica2_descripcion(String newcalifica2_descripcion)throws Exception {
		try {
			this.califica2_descripcion=newcalifica2_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setcalifica3_descripcion(String newcalifica3_descripcion)throws Exception {
		try {
			this.califica3_descripcion=newcalifica3_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setcalifica4_descripcion(String newcalifica4_descripcion)throws Exception {
		try {
			this.califica4_descripcion=newcalifica4_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setcalifica5_descripcion(String newcalifica5_descripcion)throws Exception {
		try {
			this.califica5_descripcion=newcalifica5_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setcalifica6_descripcion(String newcalifica6_descripcion)throws Exception {
		try {
			this.califica6_descripcion=newcalifica6_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setcalifica7_descripcion(String newcalifica7_descripcion)throws Exception {
		try {
			this.califica7_descripcion=newcalifica7_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setcalifica8_descripcion(String newcalifica8_descripcion)throws Exception {
		try {
			this.califica8_descripcion=newcalifica8_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setcalifica9_descripcion(String newcalifica9_descripcion)throws Exception {
		try {
			this.califica9_descripcion=newcalifica9_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setcalifica10_descripcion(String newcalifica10_descripcion)throws Exception {
		try {
			this.califica10_descripcion=newcalifica10_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	
	public void inicializarVariablesParaReporte() {
		this.id_empresa_descripcion="";this.id_evaluacion_nomi_descripcion="";this.id_formato_nomi_descripcion="";this.id_pregunta_nomi_descripcion="";this.califica1_descripcion="";this.califica2_descripcion="";this.califica3_descripcion="";this.califica4_descripcion="";this.califica5_descripcion="";this.califica6_descripcion="";this.califica7_descripcion="";this.califica8_descripcion="";this.califica9_descripcion="";this.califica10_descripcion="";
	}
	
	
	
	
	
	
	/*PARA REPORTES FIN*/		
}

