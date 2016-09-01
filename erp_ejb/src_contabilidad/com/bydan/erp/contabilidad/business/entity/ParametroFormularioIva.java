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
package com.bydan.erp.contabilidad.business.entity;

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
//import com.bydan.erp.contabilidad.util.ParametroFormularioIvaConstantesFunciones;
import com.bydan.erp.contabilidad.util.*;


import com.bydan.erp.seguridad.util.*;



import com.bydan.erp.seguridad.business.entity.*;




@SuppressWarnings("unused")
public class ParametroFormularioIva extends ParametroFormularioIvaAdditional implements Serializable ,Cloneable {//ParametroFormularioIvaAdditional,GeneralEntity
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
	
	private ParametroFormularioIva parametroformularioivaOriginal;
	
	private Map<String, Object> mapParametroFormularioIva;
			
	public Map<String, Object> getMapParametroFormularioIva() {
		return mapParametroFormularioIva;
	}

	public void setMapParametroFormularioIva(Map<String, Object> mapParametroFormularioIva) {
		this.mapParametroFormularioIva = mapParametroFormularioIva;
	}
	
	public void inicializarMapParametroFormularioIva() {
		this.mapParametroFormularioIva = new HashMap<String,Object>();
	}
	
	public void setMapParametroFormularioIvaValue(String sKey,Object oValue) {
		this.mapParametroFormularioIva.put(sKey, oValue);
	}
	
	public Object getMapParametroFormularioIvaValue(String sKey) {
		return this.mapParametroFormularioIva.get(sKey);
	}
	
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_empresa;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_tipo_parametro_formulario_iva;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_grupo_parametro_formulario_iva;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_sub_grupo_parametro_formulario_iva;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=10,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONINT)
	private Integer grupo;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=10,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONINT)
	private Integer grupo2;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=50,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=ParametroFormularioIvaConstantesFunciones.SREGEXCODIGO_SRI,message=ParametroFormularioIvaConstantesFunciones.SMENSAJEREGEXCODIGO_SRI)
	private String codigo_sri;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=150,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=ParametroFormularioIvaConstantesFunciones.SREGEXNOMBRE,message=ParametroFormularioIvaConstantesFunciones.SMENSAJEREGEXNOMBRE)
	private String nombre;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double porcentaje;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Boolean con_total;
	
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_cuenta_contable1;
	
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_cuenta_contable2;
	
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_cuenta_contable3;
	
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_cuenta_contable4;
	
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_cuenta_contable5;
			
	
	public Empresa empresa;
	public TipoParametroFormularioIva tipoparametroformularioiva;
	public GrupoParametroFormularioIva grupoparametroformularioiva;
	public SubGrupoParametroFormularioIva subgrupoparametroformularioiva;
	public CuentaContable cuentacontable1;
	public CuentaContable cuentacontable2;
	public CuentaContable cuentacontable3;
	public CuentaContable cuentacontable4;
	public CuentaContable cuentacontable5;
	
	
	private String empresa_descripcion;
	private String tipoparametroformularioiva_descripcion;
	private String grupoparametroformularioiva_descripcion;
	private String subgrupoparametroformularioiva_descripcion;
	private String cuentacontable1_descripcion;
	private String cuentacontable2_descripcion;
	private String cuentacontable3_descripcion;
	private String cuentacontable4_descripcion;
	private String cuentacontable5_descripcion;
	
	
	public List<FormularioRenta> formulariorentas;
	public List<FormularioIva> formularioivas;
		
	public ParametroFormularioIva () throws Exception {
		super();		
		
		this.id=0L;
		
		
		this.versionRow=new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());//new Date();
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		this.sType="NONE";
		
		this.parametroformularioivaOriginal=this;
		
 		this.id_empresa=-1L;
 		this.id_tipo_parametro_formulario_iva=-1L;
 		this.id_grupo_parametro_formulario_iva=-1L;
 		this.id_sub_grupo_parametro_formulario_iva=-1L;
 		this.grupo=0;
 		this.grupo2=0;
 		this.codigo_sri="";
 		this.nombre="";
 		this.porcentaje=0.0;
 		this.con_total=false;
 		this.id_cuenta_contable1=null;
 		this.id_cuenta_contable2=null;
 		this.id_cuenta_contable3=null;
 		this.id_cuenta_contable4=null;
 		this.id_cuenta_contable5=null;
		
		
		this.empresa=null;
		this.tipoparametroformularioiva=null;
		this.grupoparametroformularioiva=null;
		this.subgrupoparametroformularioiva=null;
		this.cuentacontable1=null;
		this.cuentacontable2=null;
		this.cuentacontable3=null;
		this.cuentacontable4=null;
		this.cuentacontable5=null;
		
		
		this.empresa_descripcion="";
		this.tipoparametroformularioiva_descripcion="";
		this.grupoparametroformularioiva_descripcion="";
		this.subgrupoparametroformularioiva_descripcion="";
		this.cuentacontable1_descripcion="";
		this.cuentacontable2_descripcion="";
		this.cuentacontable3_descripcion="";
		this.cuentacontable4_descripcion="";
		this.cuentacontable5_descripcion="";
		
		
		this.formulariorentas=null;
		this.formularioivas=null;
		
			
		
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
    //PARA REPORTES
	public ParametroFormularioIva (Long id,Date versionRow,Long id_empresa,Long id_tipo_parametro_formulario_iva,Long id_grupo_parametro_formulario_iva,Long id_sub_grupo_parametro_formulario_iva,Integer grupo,Integer grupo2,String codigo_sri,String nombre,Double porcentaje,Boolean con_total,Long id_cuenta_contable1,Long id_cuenta_contable2,Long id_cuenta_contable3,Long id_cuenta_contable4,Long id_cuenta_contable5) throws Exception {
		super();		
		
		this.id=id;
		this.versionRow=versionRow;
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.parametroformularioivaOriginal=this;
		
 		this.id_empresa=id_empresa;
 		this.id_tipo_parametro_formulario_iva=id_tipo_parametro_formulario_iva;
 		this.id_grupo_parametro_formulario_iva=id_grupo_parametro_formulario_iva;
 		this.id_sub_grupo_parametro_formulario_iva=id_sub_grupo_parametro_formulario_iva;
 		this.grupo=grupo;
 		this.grupo2=grupo2;
 		this.codigo_sri=codigo_sri;
 		this.nombre=nombre;
 		this.porcentaje=porcentaje;
 		this.con_total=con_total;
 		this.id_cuenta_contable1=id_cuenta_contable1;
 		this.id_cuenta_contable2=id_cuenta_contable2;
 		this.id_cuenta_contable3=id_cuenta_contable3;
 		this.id_cuenta_contable4=id_cuenta_contable4;
 		this.id_cuenta_contable5=id_cuenta_contable5;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	 //PARA REPORTES
	public ParametroFormularioIva (Long id_empresa,Long id_tipo_parametro_formulario_iva,Long id_grupo_parametro_formulario_iva,Long id_sub_grupo_parametro_formulario_iva,Integer grupo,Integer grupo2,String codigo_sri,String nombre,Double porcentaje,Boolean con_total,Long id_cuenta_contable1,Long id_cuenta_contable2,Long id_cuenta_contable3,Long id_cuenta_contable4,Long id_cuenta_contable5) throws Exception {
		super();		
		
		this.id=0L;
		this.versionRow=new Date();
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.parametroformularioivaOriginal=this;
		
 		this.id_empresa=id_empresa;
 		this.id_tipo_parametro_formulario_iva=id_tipo_parametro_formulario_iva;
 		this.id_grupo_parametro_formulario_iva=id_grupo_parametro_formulario_iva;
 		this.id_sub_grupo_parametro_formulario_iva=id_sub_grupo_parametro_formulario_iva;
 		this.grupo=grupo;
 		this.grupo2=grupo2;
 		this.codigo_sri=codigo_sri;
 		this.nombre=nombre;
 		this.porcentaje=porcentaje;
 		this.con_total=con_total;
 		this.id_cuenta_contable1=id_cuenta_contable1;
 		this.id_cuenta_contable2=id_cuenta_contable2;
 		this.id_cuenta_contable3=id_cuenta_contable3;
 		this.id_cuenta_contable4=id_cuenta_contable4;
 		this.id_cuenta_contable5=id_cuenta_contable5;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	public boolean equals(Object object) {
		boolean equal=false;
		ParametroFormularioIva parametroformularioivaLocal=null;
		
		if(object!=null) {
			parametroformularioivaLocal=(ParametroFormularioIva)object;
			
			if(parametroformularioivaLocal!=null) {
				if(this.getId()!=null && parametroformularioivaLocal.getId()!=null) {
					if(this.getId().equals(parametroformularioivaLocal.getId())) {
						equal=true;
					}
				}
			}
		}
		
		return equal;
	}
	
	public String toString() {
		String sDetalle="";
		
		if(!ParametroFormularioIvaConstantesFunciones.CON_DESCRIPCION_DETALLADO) {
        	sDetalle=ParametroFormularioIvaConstantesFunciones.getParametroFormularioIvaDescripcion(this);
		} else {
			sDetalle=ParametroFormularioIvaConstantesFunciones.getParametroFormularioIvaDescripcionDetallado(this);
		}
		
		return sDetalle;
    }
	
	public ParametroFormularioIva getParametroFormularioIvaOriginal() {
		return this.parametroformularioivaOriginal;
	}
	
	public void setParametroFormularioIvaOriginal(ParametroFormularioIva parametroformularioiva) {
		try {
			this.parametroformularioivaOriginal=parametroformularioiva;
		} catch(Exception e) {
			;
		}
	}
	
	
	protected ParametroFormularioIvaAdditional parametroformularioivaAdditional=null;
	
	public ParametroFormularioIvaAdditional getParametroFormularioIvaAdditional() {
		return this.parametroformularioivaAdditional;
	}
	
	public void setParametroFormularioIvaAdditional(ParametroFormularioIvaAdditional parametroformularioivaAdditional) {
		try {
			this.parametroformularioivaAdditional=parametroformularioivaAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
    
	
	public Long getid_empresa() {
		return this.id_empresa;
	}
    
	
	public Long getid_tipo_parametro_formulario_iva() {
		return this.id_tipo_parametro_formulario_iva;
	}
    
	
	public Long getid_grupo_parametro_formulario_iva() {
		return this.id_grupo_parametro_formulario_iva;
	}
    
	
	public Long getid_sub_grupo_parametro_formulario_iva() {
		return this.id_sub_grupo_parametro_formulario_iva;
	}
    
	
	public Integer getgrupo() {
		return this.grupo;
	}
    
	
	public Integer getgrupo2() {
		return this.grupo2;
	}
    
	
	public String getcodigo_sri() {
		return this.codigo_sri;
	}
    
	
	public String getnombre() {
		return this.nombre;
	}
    
	
	public Double getporcentaje() {
		return this.porcentaje;
	}
    
	
	public Boolean getcon_total() {
		return this.con_total;
	}
    
	
	public Long getid_cuenta_contable1() {
		return this.id_cuenta_contable1;
	}
    
	
	public Long getid_cuenta_contable2() {
		return this.id_cuenta_contable2;
	}
    
	
	public Long getid_cuenta_contable3() {
		return this.id_cuenta_contable3;
	}
    
	
	public Long getid_cuenta_contable4() {
		return this.id_cuenta_contable4;
	}
    
	
	public Long getid_cuenta_contable5() {
		return this.id_cuenta_contable5;
	}
	
    
	public void setid_empresa(Long newid_empresa)throws Exception
	{
		try {
			if(this.id_empresa!=newid_empresa) {
				if(newid_empresa==null) {
					//newid_empresa=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ParametroFormularioIva:Valor nulo no permitido en columna id_empresa");
					}
				}

				this.id_empresa=newid_empresa;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_tipo_parametro_formulario_iva(Long newid_tipo_parametro_formulario_iva)throws Exception
	{
		try {
			if(this.id_tipo_parametro_formulario_iva!=newid_tipo_parametro_formulario_iva) {
				if(newid_tipo_parametro_formulario_iva==null) {
					//newid_tipo_parametro_formulario_iva=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ParametroFormularioIva:Valor nulo no permitido en columna id_tipo_parametro_formulario_iva");
					}
				}

				this.id_tipo_parametro_formulario_iva=newid_tipo_parametro_formulario_iva;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_grupo_parametro_formulario_iva(Long newid_grupo_parametro_formulario_iva)throws Exception
	{
		try {
			if(this.id_grupo_parametro_formulario_iva!=newid_grupo_parametro_formulario_iva) {
				if(newid_grupo_parametro_formulario_iva==null) {
					//newid_grupo_parametro_formulario_iva=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ParametroFormularioIva:Valor nulo no permitido en columna id_grupo_parametro_formulario_iva");
					}
				}

				this.id_grupo_parametro_formulario_iva=newid_grupo_parametro_formulario_iva;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_sub_grupo_parametro_formulario_iva(Long newid_sub_grupo_parametro_formulario_iva)throws Exception
	{
		try {
			if(this.id_sub_grupo_parametro_formulario_iva!=newid_sub_grupo_parametro_formulario_iva) {
				if(newid_sub_grupo_parametro_formulario_iva==null) {
					//newid_sub_grupo_parametro_formulario_iva=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ParametroFormularioIva:Valor nulo no permitido en columna id_sub_grupo_parametro_formulario_iva");
					}
				}

				this.id_sub_grupo_parametro_formulario_iva=newid_sub_grupo_parametro_formulario_iva;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setgrupo(Integer newgrupo)throws Exception
	{
		try {
			if(this.grupo!=newgrupo) {
				if(newgrupo==null) {
					//newgrupo=0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ParametroFormularioIva:Valor nulo no permitido en columna grupo");
					}
				}

				this.grupo=newgrupo;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setgrupo2(Integer newgrupo2)throws Exception
	{
		try {
			if(this.grupo2!=newgrupo2) {
				if(newgrupo2==null) {
					//newgrupo2=0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ParametroFormularioIva:Valor nulo no permitido en columna grupo2");
					}
				}

				this.grupo2=newgrupo2;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setcodigo_sri(String newcodigo_sri)throws Exception
	{
		try {
			if(this.codigo_sri!=newcodigo_sri) {
				if(newcodigo_sri==null) {
					//newcodigo_sri="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("ParametroFormularioIva:Valor nulo no permitido en columna codigo_sri");
					}
				}

				if(newcodigo_sri!=null&&newcodigo_sri.length()>50) {
					newcodigo_sri=newcodigo_sri.substring(0,48);
					System.out.println("ParametroFormularioIva:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=50 en columna codigo_sri");
				}

				this.codigo_sri=newcodigo_sri;
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
						System.out.println("ParametroFormularioIva:Valor nulo no permitido en columna nombre");
					}
				}

				if(newnombre!=null&&newnombre.length()>150) {
					newnombre=newnombre.substring(0,148);
					System.out.println("ParametroFormularioIva:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=150 en columna nombre");
				}

				this.nombre=newnombre;
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
						System.out.println("ParametroFormularioIva:Valor nulo no permitido en columna porcentaje");
					}
				}

				this.porcentaje=newporcentaje;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setcon_total(Boolean newcon_total)throws Exception
	{
		try {
			if(this.con_total!=newcon_total) {
				if(newcon_total==null) {
					//newcon_total=false;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ParametroFormularioIva:Valor nulo no permitido en columna con_total");
					}
				}

				this.con_total=newcon_total;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_cuenta_contable1(Long newid_cuenta_contable1) {
		if(this.id_cuenta_contable1==null&&newid_cuenta_contable1!=null) {
			this.id_cuenta_contable1=newid_cuenta_contable1;
				this.setIsChanged(true);
		}

		if(this.id_cuenta_contable1!=null&&!this.id_cuenta_contable1.equals(newid_cuenta_contable1)) {

			this.id_cuenta_contable1=newid_cuenta_contable1;
				this.setIsChanged(true);
		}
	}
    
	public void setid_cuenta_contable2(Long newid_cuenta_contable2) {
		if(this.id_cuenta_contable2==null&&newid_cuenta_contable2!=null) {
			this.id_cuenta_contable2=newid_cuenta_contable2;
				this.setIsChanged(true);
		}

		if(this.id_cuenta_contable2!=null&&!this.id_cuenta_contable2.equals(newid_cuenta_contable2)) {

			this.id_cuenta_contable2=newid_cuenta_contable2;
				this.setIsChanged(true);
		}
	}
    
	public void setid_cuenta_contable3(Long newid_cuenta_contable3) {
		if(this.id_cuenta_contable3==null&&newid_cuenta_contable3!=null) {
			this.id_cuenta_contable3=newid_cuenta_contable3;
				this.setIsChanged(true);
		}

		if(this.id_cuenta_contable3!=null&&!this.id_cuenta_contable3.equals(newid_cuenta_contable3)) {

			this.id_cuenta_contable3=newid_cuenta_contable3;
				this.setIsChanged(true);
		}
	}
    
	public void setid_cuenta_contable4(Long newid_cuenta_contable4) {
		if(this.id_cuenta_contable4==null&&newid_cuenta_contable4!=null) {
			this.id_cuenta_contable4=newid_cuenta_contable4;
				this.setIsChanged(true);
		}

		if(this.id_cuenta_contable4!=null&&!this.id_cuenta_contable4.equals(newid_cuenta_contable4)) {

			this.id_cuenta_contable4=newid_cuenta_contable4;
				this.setIsChanged(true);
		}
	}
    
	public void setid_cuenta_contable5(Long newid_cuenta_contable5) {
		if(this.id_cuenta_contable5==null&&newid_cuenta_contable5!=null) {
			this.id_cuenta_contable5=newid_cuenta_contable5;
				this.setIsChanged(true);
		}

		if(this.id_cuenta_contable5!=null&&!this.id_cuenta_contable5.equals(newid_cuenta_contable5)) {

			this.id_cuenta_contable5=newid_cuenta_contable5;
				this.setIsChanged(true);
		}
	}
	
	
	public Empresa getEmpresa() {
		return this.empresa;
	}

	public TipoParametroFormularioIva getTipoParametroFormularioIva() {
		return this.tipoparametroformularioiva;
	}

	public GrupoParametroFormularioIva getGrupoParametroFormularioIva() {
		return this.grupoparametroformularioiva;
	}

	public SubGrupoParametroFormularioIva getSubGrupoParametroFormularioIva() {
		return this.subgrupoparametroformularioiva;
	}

	public CuentaContable getCuentaContable1() {
		return this.cuentacontable1;
	}

	public CuentaContable getCuentaContable2() {
		return this.cuentacontable2;
	}

	public CuentaContable getCuentaContable3() {
		return this.cuentacontable3;
	}

	public CuentaContable getCuentaContable4() {
		return this.cuentacontable4;
	}

	public CuentaContable getCuentaContable5() {
		return this.cuentacontable5;
	}

	
	
	public String getempresa_descripcion() {
		return this.empresa_descripcion;
	}

	public String gettipoparametroformularioiva_descripcion() {
		return this.tipoparametroformularioiva_descripcion;
	}

	public String getgrupoparametroformularioiva_descripcion() {
		return this.grupoparametroformularioiva_descripcion;
	}

	public String getsubgrupoparametroformularioiva_descripcion() {
		return this.subgrupoparametroformularioiva_descripcion;
	}

	public String getcuentacontable1_descripcion() {
		return this.cuentacontable1_descripcion;
	}

	public String getcuentacontable2_descripcion() {
		return this.cuentacontable2_descripcion;
	}

	public String getcuentacontable3_descripcion() {
		return this.cuentacontable3_descripcion;
	}

	public String getcuentacontable4_descripcion() {
		return this.cuentacontable4_descripcion;
	}

	public String getcuentacontable5_descripcion() {
		return this.cuentacontable5_descripcion;
	}

	
	
	public  void  setEmpresa(Empresa empresa) {
		try {
			this.empresa=empresa;
		} catch(Exception e) {
			;
		}
	}


	public  void  setTipoParametroFormularioIva(TipoParametroFormularioIva tipoparametroformularioiva) {
		try {
			this.tipoparametroformularioiva=tipoparametroformularioiva;
		} catch(Exception e) {
			;
		}
	}


	public  void  setGrupoParametroFormularioIva(GrupoParametroFormularioIva grupoparametroformularioiva) {
		try {
			this.grupoparametroformularioiva=grupoparametroformularioiva;
		} catch(Exception e) {
			;
		}
	}


	public  void  setSubGrupoParametroFormularioIva(SubGrupoParametroFormularioIva subgrupoparametroformularioiva) {
		try {
			this.subgrupoparametroformularioiva=subgrupoparametroformularioiva;
		} catch(Exception e) {
			;
		}
	}


	public  void  setCuentaContable1(CuentaContable cuentacontable1) {
		try {
			this.cuentacontable1=cuentacontable1;
		} catch(Exception e) {
			;
		}
	}


	public  void  setCuentaContable2(CuentaContable cuentacontable2) {
		try {
			this.cuentacontable2=cuentacontable2;
		} catch(Exception e) {
			;
		}
	}


	public  void  setCuentaContable3(CuentaContable cuentacontable3) {
		try {
			this.cuentacontable3=cuentacontable3;
		} catch(Exception e) {
			;
		}
	}


	public  void  setCuentaContable4(CuentaContable cuentacontable4) {
		try {
			this.cuentacontable4=cuentacontable4;
		} catch(Exception e) {
			;
		}
	}


	public  void  setCuentaContable5(CuentaContable cuentacontable5) {
		try {
			this.cuentacontable5=cuentacontable5;
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


	public  void  settipoparametroformularioiva_descripcion(String tipoparametroformularioiva_descripcion) {
		try {
			this.tipoparametroformularioiva_descripcion=tipoparametroformularioiva_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  setgrupoparametroformularioiva_descripcion(String grupoparametroformularioiva_descripcion) {
		try {
			this.grupoparametroformularioiva_descripcion=grupoparametroformularioiva_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  setsubgrupoparametroformularioiva_descripcion(String subgrupoparametroformularioiva_descripcion) {
		try {
			this.subgrupoparametroformularioiva_descripcion=subgrupoparametroformularioiva_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  setcuentacontable1_descripcion(String cuentacontable1_descripcion) {
		try {
			this.cuentacontable1_descripcion=cuentacontable1_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  setcuentacontable2_descripcion(String cuentacontable2_descripcion) {
		try {
			this.cuentacontable2_descripcion=cuentacontable2_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  setcuentacontable3_descripcion(String cuentacontable3_descripcion) {
		try {
			this.cuentacontable3_descripcion=cuentacontable3_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  setcuentacontable4_descripcion(String cuentacontable4_descripcion) {
		try {
			this.cuentacontable4_descripcion=cuentacontable4_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  setcuentacontable5_descripcion(String cuentacontable5_descripcion) {
		try {
			this.cuentacontable5_descripcion=cuentacontable5_descripcion;
		} catch(Exception e) {
			;
		}
	}


	
	
	public List<FormularioRenta> getFormularioRentas() {
		return this.formulariorentas;
	}

	public List<FormularioIva> getFormularioIvas() {
		return this.formularioivas;
	}

	
	
	public  void  setFormularioRentas(List<FormularioRenta> formulariorentas) {
		try {
			this.formulariorentas=formulariorentas;
		} catch(Exception e) {
			;
		}
	}

	public  void  setFormularioIvas(List<FormularioIva> formularioivas) {
		try {
			this.formularioivas=formularioivas;
		} catch(Exception e) {
			;
		}
	}

	
	/*PARA REPORTES*/
	String id_empresa_descripcion="";String id_tipo_parametro_formulario_iva_descripcion="";String id_grupo_parametro_formulario_iva_descripcion="";String id_sub_grupo_parametro_formulario_iva_descripcion="";String con_total_descripcion="";String id_cuenta_contable1_descripcion="";String id_cuenta_contable2_descripcion="";String id_cuenta_contable3_descripcion="";String id_cuenta_contable4_descripcion="";String id_cuenta_contable5_descripcion="";
	
	
	public String getid_empresa_descripcion() {
		return id_empresa_descripcion;
	}
	public String getid_tipo_parametro_formulario_iva_descripcion() {
		return id_tipo_parametro_formulario_iva_descripcion;
	}
	public String getid_grupo_parametro_formulario_iva_descripcion() {
		return id_grupo_parametro_formulario_iva_descripcion;
	}
	public String getid_sub_grupo_parametro_formulario_iva_descripcion() {
		return id_sub_grupo_parametro_formulario_iva_descripcion;
	}
	public String getcon_total_descripcion() {
		return con_total_descripcion;
	}
	public String getid_cuenta_contable1_descripcion() {
		return id_cuenta_contable1_descripcion;
	}
	public String getid_cuenta_contable2_descripcion() {
		return id_cuenta_contable2_descripcion;
	}
	public String getid_cuenta_contable3_descripcion() {
		return id_cuenta_contable3_descripcion;
	}
	public String getid_cuenta_contable4_descripcion() {
		return id_cuenta_contable4_descripcion;
	}
	public String getid_cuenta_contable5_descripcion() {
		return id_cuenta_contable5_descripcion;
	}
	
	
	public void setid_empresa_descripcion(String newid_empresa_descripcion)throws Exception {
		try {
			this.id_empresa_descripcion=newid_empresa_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_tipo_parametro_formulario_iva_descripcion(String newid_tipo_parametro_formulario_iva_descripcion)throws Exception {
		try {
			this.id_tipo_parametro_formulario_iva_descripcion=newid_tipo_parametro_formulario_iva_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_grupo_parametro_formulario_iva_descripcion(String newid_grupo_parametro_formulario_iva_descripcion)throws Exception {
		try {
			this.id_grupo_parametro_formulario_iva_descripcion=newid_grupo_parametro_formulario_iva_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_sub_grupo_parametro_formulario_iva_descripcion(String newid_sub_grupo_parametro_formulario_iva_descripcion)throws Exception {
		try {
			this.id_sub_grupo_parametro_formulario_iva_descripcion=newid_sub_grupo_parametro_formulario_iva_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setcon_total_descripcion(String newcon_total_descripcion)throws Exception {
		try {
			this.con_total_descripcion=newcon_total_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_cuenta_contable1_descripcion(String newid_cuenta_contable1_descripcion)throws Exception {
		try {
			this.id_cuenta_contable1_descripcion=newid_cuenta_contable1_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_cuenta_contable2_descripcion(String newid_cuenta_contable2_descripcion)throws Exception {
		try {
			this.id_cuenta_contable2_descripcion=newid_cuenta_contable2_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_cuenta_contable3_descripcion(String newid_cuenta_contable3_descripcion)throws Exception {
		try {
			this.id_cuenta_contable3_descripcion=newid_cuenta_contable3_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_cuenta_contable4_descripcion(String newid_cuenta_contable4_descripcion)throws Exception {
		try {
			this.id_cuenta_contable4_descripcion=newid_cuenta_contable4_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_cuenta_contable5_descripcion(String newid_cuenta_contable5_descripcion)throws Exception {
		try {
			this.id_cuenta_contable5_descripcion=newid_cuenta_contable5_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	
	public void inicializarVariablesParaReporte() {
		this.id_empresa_descripcion="";this.id_tipo_parametro_formulario_iva_descripcion="";this.id_grupo_parametro_formulario_iva_descripcion="";this.id_sub_grupo_parametro_formulario_iva_descripcion="";this.con_total_descripcion="";this.id_cuenta_contable1_descripcion="";this.id_cuenta_contable2_descripcion="";this.id_cuenta_contable3_descripcion="";this.id_cuenta_contable4_descripcion="";this.id_cuenta_contable5_descripcion="";
	}
	
	
	Object formulariorentasDescripcionReporte;
	Object formularioivasDescripcionReporte;
	
	
	public Object getformulariorentasDescripcionReporte() {
		return formulariorentasDescripcionReporte;
	}

	public Object getformularioivasDescripcionReporte() {
		return formularioivasDescripcionReporte;
	}

	
	
	public  void  setformulariorentasDescripcionReporte(Object formulariorentas) {
		try {
			this.formulariorentasDescripcionReporte=formulariorentas;
		} catch(Exception ex) {
			;
		}
	}

	public  void  setformularioivasDescripcionReporte(Object formularioivas) {
		try {
			this.formularioivasDescripcionReporte=formularioivas;
		} catch(Exception ex) {
			;
		}
	}

	/*PARA REPORTES FIN*/		
}

