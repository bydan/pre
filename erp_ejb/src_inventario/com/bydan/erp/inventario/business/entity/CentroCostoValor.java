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
package com.bydan.erp.inventario.business.entity;

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
//import com.bydan.erp.inventario.util.CentroCostoValorConstantesFunciones;
import com.bydan.erp.inventario.util.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.contabilidad.util.*;



import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;




@SuppressWarnings("unused")
public class CentroCostoValor extends CentroCostoValorAdditional implements Serializable ,Cloneable {//CentroCostoValorAdditional,GeneralEntity
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
	
	private CentroCostoValor centrocostovalorOriginal;
	
	private Map<String, Object> mapCentroCostoValor;
			
	public Map<String, Object> getMapCentroCostoValor() {
		return mapCentroCostoValor;
	}

	public void setMapCentroCostoValor(Map<String, Object> mapCentroCostoValor) {
		this.mapCentroCostoValor = mapCentroCostoValor;
	}
	
	public void inicializarMapCentroCostoValor() {
		this.mapCentroCostoValor = new HashMap<String,Object>();
	}
	
	public void setMapCentroCostoValorValue(String sKey,Object oValue) {
		this.mapCentroCostoValor.put(sKey, oValue);
	}
	
	public Object getMapCentroCostoValorValue(String sKey) {
		return this.mapCentroCostoValor.get(sKey);
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
	private Long id_ejercicio;
	
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_centro_costo;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=50,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=CentroCostoValorConstantesFunciones.SREGEXNOMBRE,message=CentroCostoValorConstantesFunciones.SMENSAJEREGEXNOMBRE)
	private String nombre;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double enero;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double febrero;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double marzo;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double abril;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double mayo;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double junio;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double julio;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double agosto;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double septiembre;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double octubre;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double noviembre;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double diciembre;
			
	
	public Empresa empresa;
	public Sucursal sucursal;
	public Ejercicio ejercicio;
	public CentroCosto centrocosto;
	
	
	private String empresa_descripcion;
	private String sucursal_descripcion;
	private String ejercicio_descripcion;
	private String centrocosto_descripcion;
	
	
		
	public CentroCostoValor () throws Exception {
		super();		
		
		this.id=0L;
		
		
		this.versionRow=new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());//new Date();
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		this.sType="NONE";
		
		this.centrocostovalorOriginal=this;
		
 		this.id_empresa=-1L;
 		this.id_sucursal=-1L;
 		this.id_ejercicio=-1L;
 		this.id_centro_costo=null;
 		this.nombre="";
 		this.enero=0.0;
 		this.febrero=0.0;
 		this.marzo=0.0;
 		this.abril=0.0;
 		this.mayo=0.0;
 		this.junio=0.0;
 		this.julio=0.0;
 		this.agosto=0.0;
 		this.septiembre=0.0;
 		this.octubre=0.0;
 		this.noviembre=0.0;
 		this.diciembre=0.0;
		
		
		this.empresa=null;
		this.sucursal=null;
		this.ejercicio=null;
		this.centrocosto=null;
		
		
		this.empresa_descripcion="";
		this.sucursal_descripcion="";
		this.ejercicio_descripcion="";
		this.centrocosto_descripcion="";
		
		
		
			
		
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
    //PARA REPORTES
	public CentroCostoValor (Long id,Date versionRow,Long id_empresa,Long id_sucursal,Long id_ejercicio,Long id_centro_costo,String nombre,Double enero,Double febrero,Double marzo,Double abril,Double mayo,Double junio,Double julio,Double agosto,Double septiembre,Double octubre,Double noviembre,Double diciembre) throws Exception {
		super();		
		
		this.id=id;
		this.versionRow=versionRow;
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.centrocostovalorOriginal=this;
		
 		this.id_empresa=id_empresa;
 		this.id_sucursal=id_sucursal;
 		this.id_ejercicio=id_ejercicio;
 		this.id_centro_costo=id_centro_costo;
 		this.nombre=nombre;
 		this.enero=enero;
 		this.febrero=febrero;
 		this.marzo=marzo;
 		this.abril=abril;
 		this.mayo=mayo;
 		this.junio=junio;
 		this.julio=julio;
 		this.agosto=agosto;
 		this.septiembre=septiembre;
 		this.octubre=octubre;
 		this.noviembre=noviembre;
 		this.diciembre=diciembre;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	 //PARA REPORTES
	public CentroCostoValor (Long id_empresa,Long id_sucursal,Long id_ejercicio,Long id_centro_costo,String nombre,Double enero,Double febrero,Double marzo,Double abril,Double mayo,Double junio,Double julio,Double agosto,Double septiembre,Double octubre,Double noviembre,Double diciembre) throws Exception {
		super();		
		
		this.id=0L;
		this.versionRow=new Date();
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.centrocostovalorOriginal=this;
		
 		this.id_empresa=id_empresa;
 		this.id_sucursal=id_sucursal;
 		this.id_ejercicio=id_ejercicio;
 		this.id_centro_costo=id_centro_costo;
 		this.nombre=nombre;
 		this.enero=enero;
 		this.febrero=febrero;
 		this.marzo=marzo;
 		this.abril=abril;
 		this.mayo=mayo;
 		this.junio=junio;
 		this.julio=julio;
 		this.agosto=agosto;
 		this.septiembre=septiembre;
 		this.octubre=octubre;
 		this.noviembre=noviembre;
 		this.diciembre=diciembre;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	public boolean equals(Object object) {
		boolean equal=false;
		CentroCostoValor centrocostovalorLocal=null;
		
		if(object!=null) {
			centrocostovalorLocal=(CentroCostoValor)object;
			
			if(centrocostovalorLocal!=null) {
				if(this.getId()!=null && centrocostovalorLocal.getId()!=null) {
					if(this.getId().equals(centrocostovalorLocal.getId())) {
						equal=true;
					}
				}
			}
		}
		
		return equal;
	}
	
	public String toString() {
		String sDetalle="";
		
		if(!CentroCostoValorConstantesFunciones.CON_DESCRIPCION_DETALLADO) {
        	sDetalle=CentroCostoValorConstantesFunciones.getCentroCostoValorDescripcion(this);
		} else {
			sDetalle=CentroCostoValorConstantesFunciones.getCentroCostoValorDescripcionDetallado(this);
		}
		
		return sDetalle;
    }
	
	public CentroCostoValor getCentroCostoValorOriginal() {
		return this.centrocostovalorOriginal;
	}
	
	public void setCentroCostoValorOriginal(CentroCostoValor centrocostovalor) {
		try {
			this.centrocostovalorOriginal=centrocostovalor;
		} catch(Exception e) {
			;
		}
	}
	
	
	protected CentroCostoValorAdditional centrocostovalorAdditional=null;
	
	public CentroCostoValorAdditional getCentroCostoValorAdditional() {
		return this.centrocostovalorAdditional;
	}
	
	public void setCentroCostoValorAdditional(CentroCostoValorAdditional centrocostovalorAdditional) {
		try {
			this.centrocostovalorAdditional=centrocostovalorAdditional;
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
    
	
	public Long getid_ejercicio() {
		return this.id_ejercicio;
	}
    
	
	public Long getid_centro_costo() {
		return this.id_centro_costo;
	}
    
	
	public String getnombre() {
		return this.nombre;
	}
    
	
	public Double getenero() {
		return this.enero;
	}
    
	
	public Double getfebrero() {
		return this.febrero;
	}
    
	
	public Double getmarzo() {
		return this.marzo;
	}
    
	
	public Double getabril() {
		return this.abril;
	}
    
	
	public Double getmayo() {
		return this.mayo;
	}
    
	
	public Double getjunio() {
		return this.junio;
	}
    
	
	public Double getjulio() {
		return this.julio;
	}
    
	
	public Double getagosto() {
		return this.agosto;
	}
    
	
	public Double getseptiembre() {
		return this.septiembre;
	}
    
	
	public Double getoctubre() {
		return this.octubre;
	}
    
	
	public Double getnoviembre() {
		return this.noviembre;
	}
    
	
	public Double getdiciembre() {
		return this.diciembre;
	}
	
    
	public void setid_empresa(Long newid_empresa)throws Exception
	{
		try {
			if(this.id_empresa!=newid_empresa) {
				if(newid_empresa==null) {
					//newid_empresa=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("CentroCostoValor:Valor nulo no permitido en columna id_empresa");
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
						System.out.println("CentroCostoValor:Valor nulo no permitido en columna id_sucursal");
					}
				}

				this.id_sucursal=newid_sucursal;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_ejercicio(Long newid_ejercicio)throws Exception
	{
		try {
			if(this.id_ejercicio!=newid_ejercicio) {
				if(newid_ejercicio==null) {
					//newid_ejercicio=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("CentroCostoValor:Valor nulo no permitido en columna id_ejercicio");
					}
				}

				this.id_ejercicio=newid_ejercicio;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_centro_costo(Long newid_centro_costo) {
		if(this.id_centro_costo==null&&newid_centro_costo!=null) {
			this.id_centro_costo=newid_centro_costo;
				this.setIsChanged(true);
		}

		if(this.id_centro_costo!=null&&!this.id_centro_costo.equals(newid_centro_costo)) {

			this.id_centro_costo=newid_centro_costo;
				this.setIsChanged(true);
		}
	}
    
	public void setnombre(String newnombre)throws Exception
	{
		try {
			if(this.nombre!=newnombre) {
				if(newnombre==null) {
					//newnombre="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("CentroCostoValor:Valor nulo no permitido en columna nombre");
					}
				}

				if(newnombre!=null&&newnombre.length()>50) {
					newnombre=newnombre.substring(0,48);
					System.out.println("CentroCostoValor:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=50 en columna nombre");
				}

				this.nombre=newnombre;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setenero(Double newenero)throws Exception
	{
		try {
			if(this.enero!=newenero) {
				if(newenero==null) {
					//newenero=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("CentroCostoValor:Valor nulo no permitido en columna enero");
					}
				}

				this.enero=newenero;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setfebrero(Double newfebrero)throws Exception
	{
		try {
			if(this.febrero!=newfebrero) {
				if(newfebrero==null) {
					//newfebrero=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("CentroCostoValor:Valor nulo no permitido en columna febrero");
					}
				}

				this.febrero=newfebrero;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setmarzo(Double newmarzo)throws Exception
	{
		try {
			if(this.marzo!=newmarzo) {
				if(newmarzo==null) {
					//newmarzo=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("CentroCostoValor:Valor nulo no permitido en columna marzo");
					}
				}

				this.marzo=newmarzo;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setabril(Double newabril)throws Exception
	{
		try {
			if(this.abril!=newabril) {
				if(newabril==null) {
					//newabril=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("CentroCostoValor:Valor nulo no permitido en columna abril");
					}
				}

				this.abril=newabril;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setmayo(Double newmayo)throws Exception
	{
		try {
			if(this.mayo!=newmayo) {
				if(newmayo==null) {
					//newmayo=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("CentroCostoValor:Valor nulo no permitido en columna mayo");
					}
				}

				this.mayo=newmayo;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setjunio(Double newjunio)throws Exception
	{
		try {
			if(this.junio!=newjunio) {
				if(newjunio==null) {
					//newjunio=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("CentroCostoValor:Valor nulo no permitido en columna junio");
					}
				}

				this.junio=newjunio;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setjulio(Double newjulio)throws Exception
	{
		try {
			if(this.julio!=newjulio) {
				if(newjulio==null) {
					//newjulio=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("CentroCostoValor:Valor nulo no permitido en columna julio");
					}
				}

				this.julio=newjulio;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setagosto(Double newagosto)throws Exception
	{
		try {
			if(this.agosto!=newagosto) {
				if(newagosto==null) {
					//newagosto=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("CentroCostoValor:Valor nulo no permitido en columna agosto");
					}
				}

				this.agosto=newagosto;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setseptiembre(Double newseptiembre)throws Exception
	{
		try {
			if(this.septiembre!=newseptiembre) {
				if(newseptiembre==null) {
					//newseptiembre=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("CentroCostoValor:Valor nulo no permitido en columna septiembre");
					}
				}

				this.septiembre=newseptiembre;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setoctubre(Double newoctubre)throws Exception
	{
		try {
			if(this.octubre!=newoctubre) {
				if(newoctubre==null) {
					//newoctubre=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("CentroCostoValor:Valor nulo no permitido en columna octubre");
					}
				}

				this.octubre=newoctubre;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setnoviembre(Double newnoviembre)throws Exception
	{
		try {
			if(this.noviembre!=newnoviembre) {
				if(newnoviembre==null) {
					//newnoviembre=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("CentroCostoValor:Valor nulo no permitido en columna noviembre");
					}
				}

				this.noviembre=newnoviembre;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setdiciembre(Double newdiciembre)throws Exception
	{
		try {
			if(this.diciembre!=newdiciembre) {
				if(newdiciembre==null) {
					//newdiciembre=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("CentroCostoValor:Valor nulo no permitido en columna diciembre");
					}
				}

				this.diciembre=newdiciembre;
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

	public Ejercicio getEjercicio() {
		return this.ejercicio;
	}

	public CentroCosto getCentroCosto() {
		return this.centrocosto;
	}

	
	
	public String getempresa_descripcion() {
		return this.empresa_descripcion;
	}

	public String getsucursal_descripcion() {
		return this.sucursal_descripcion;
	}

	public String getejercicio_descripcion() {
		return this.ejercicio_descripcion;
	}

	public String getcentrocosto_descripcion() {
		return this.centrocosto_descripcion;
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


	public  void  setEjercicio(Ejercicio ejercicio) {
		try {
			this.ejercicio=ejercicio;
		} catch(Exception e) {
			;
		}
	}


	public  void  setCentroCosto(CentroCosto centrocosto) {
		try {
			this.centrocosto=centrocosto;
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


	public  void  setejercicio_descripcion(String ejercicio_descripcion) {
		try {
			this.ejercicio_descripcion=ejercicio_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  setcentrocosto_descripcion(String centrocosto_descripcion) {
		try {
			this.centrocosto_descripcion=centrocosto_descripcion;
		} catch(Exception e) {
			;
		}
	}


	
	
	
	
	
	/*PARA REPORTES*/
	String id_empresa_descripcion="";String id_sucursal_descripcion="";String id_ejercicio_descripcion="";String id_centro_costo_descripcion="";
	
	
	public String getid_empresa_descripcion() {
		return id_empresa_descripcion;
	}
	public String getid_sucursal_descripcion() {
		return id_sucursal_descripcion;
	}
	public String getid_ejercicio_descripcion() {
		return id_ejercicio_descripcion;
	}
	public String getid_centro_costo_descripcion() {
		return id_centro_costo_descripcion;
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
	public void setid_ejercicio_descripcion(String newid_ejercicio_descripcion)throws Exception {
		try {
			this.id_ejercicio_descripcion=newid_ejercicio_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_centro_costo_descripcion(String newid_centro_costo_descripcion)throws Exception {
		try {
			this.id_centro_costo_descripcion=newid_centro_costo_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	
	public void inicializarVariablesParaReporte() {
		this.id_empresa_descripcion="";this.id_sucursal_descripcion="";this.id_ejercicio_descripcion="";this.id_centro_costo_descripcion="";
	}
	
	
	
	
	
	
	/*PARA REPORTES FIN*/		
}

