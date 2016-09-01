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
package com.bydan.erp.facturacion.business.entity;

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
//import com.bydan.erp.facturacion.util.DetalleTerminoProformaConstantesFunciones;
import com.bydan.erp.facturacion.util.*;


import com.bydan.erp.seguridad.util.*;



import com.bydan.erp.seguridad.business.entity.*;




@SuppressWarnings("unused")
public class DetalleTerminoProforma extends DetalleTerminoProformaAdditional implements Serializable ,Cloneable {//DetalleTerminoProformaAdditional,GeneralEntity
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
	
	private DetalleTerminoProforma detalleterminoproformaOriginal;
	
	private Map<String, Object> mapDetalleTerminoProforma;
			
	public Map<String, Object> getMapDetalleTerminoProforma() {
		return mapDetalleTerminoProforma;
	}

	public void setMapDetalleTerminoProforma(Map<String, Object> mapDetalleTerminoProforma) {
		this.mapDetalleTerminoProforma = mapDetalleTerminoProforma;
	}
	
	public void inicializarMapDetalleTerminoProforma() {
		this.mapDetalleTerminoProforma = new HashMap<String,Object>();
	}
	
	public void setMapDetalleTerminoProformaValue(String sKey,Object oValue) {
		this.mapDetalleTerminoProforma.put(sKey, oValue);
	}
	
	public Object getMapDetalleTerminoProformaValue(String sKey) {
		return this.mapDetalleTerminoProforma.get(sKey);
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
	@Min(value=-100000,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_termino_proforma;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=10,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONINT)
	private Integer numero;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=250,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=DetalleTerminoProformaConstantesFunciones.SREGEXDETALLE,message=DetalleTerminoProformaConstantesFunciones.SMENSAJEREGEXDETALLE)
	private String detalle;
			
	
	public Empresa empresa;
	public Sucursal sucursal;
	public TerminoProforma terminoproforma;
	
	
	private String empresa_descripcion;
	private String sucursal_descripcion;
	private String terminoproforma_descripcion;
	
	
		
	public DetalleTerminoProforma () throws Exception {
		super();		
		
		this.id=0L;
		
		
		this.versionRow=new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());//new Date();
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		this.sType="NONE";
		
		this.detalleterminoproformaOriginal=this;
		
 		this.id_empresa=-1L;
 		this.id_sucursal=-1L;
 		this.id_termino_proforma=-1L;
 		this.numero=0;
 		this.detalle="";
		
		
		this.empresa=null;
		this.sucursal=null;
		this.terminoproforma=null;
		
		
		this.empresa_descripcion="";
		this.sucursal_descripcion="";
		this.terminoproforma_descripcion="";
		
		
		
			
		
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
    //PARA REPORTES
	public DetalleTerminoProforma (Long id,Date versionRow,Long id_empresa,Long id_sucursal,Long id_termino_proforma,Integer numero,String detalle) throws Exception {
		super();		
		
		this.id=id;
		this.versionRow=versionRow;
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.detalleterminoproformaOriginal=this;
		
 		this.id_empresa=id_empresa;
 		this.id_sucursal=id_sucursal;
 		this.id_termino_proforma=id_termino_proforma;
 		this.numero=numero;
 		this.detalle=detalle;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	 //PARA REPORTES
	public DetalleTerminoProforma (Long id_empresa,Long id_sucursal,Long id_termino_proforma,Integer numero,String detalle) throws Exception {
		super();		
		
		this.id=0L;
		this.versionRow=new Date();
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.detalleterminoproformaOriginal=this;
		
 		this.id_empresa=id_empresa;
 		this.id_sucursal=id_sucursal;
 		this.id_termino_proforma=id_termino_proforma;
 		this.numero=numero;
 		this.detalle=detalle;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	public boolean equals(Object object) {
		boolean equal=false;
		DetalleTerminoProforma detalleterminoproformaLocal=null;
		
		if(object!=null) {
			detalleterminoproformaLocal=(DetalleTerminoProforma)object;
			
			if(detalleterminoproformaLocal!=null) {
				if(this.getId()!=null && detalleterminoproformaLocal.getId()!=null) {
					if(this.getId().equals(detalleterminoproformaLocal.getId())) {
						equal=true;
					}
				}
			}
		}
		
		return equal;
	}
	
	public String toString() {
		String sDetalle="";
		
		if(!DetalleTerminoProformaConstantesFunciones.CON_DESCRIPCION_DETALLADO) {
        	sDetalle=DetalleTerminoProformaConstantesFunciones.getDetalleTerminoProformaDescripcion(this);
		} else {
			sDetalle=DetalleTerminoProformaConstantesFunciones.getDetalleTerminoProformaDescripcionDetallado(this);
		}
		
		return sDetalle;
    }
	
	public DetalleTerminoProforma getDetalleTerminoProformaOriginal() {
		return this.detalleterminoproformaOriginal;
	}
	
	public void setDetalleTerminoProformaOriginal(DetalleTerminoProforma detalleterminoproforma) {
		try {
			this.detalleterminoproformaOriginal=detalleterminoproforma;
		} catch(Exception e) {
			;
		}
	}
	
	
	protected DetalleTerminoProformaAdditional detalleterminoproformaAdditional=null;
	
	public DetalleTerminoProformaAdditional getDetalleTerminoProformaAdditional() {
		return this.detalleterminoproformaAdditional;
	}
	
	public void setDetalleTerminoProformaAdditional(DetalleTerminoProformaAdditional detalleterminoproformaAdditional) {
		try {
			this.detalleterminoproformaAdditional=detalleterminoproformaAdditional;
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
    
	
	public Long getid_termino_proforma() {
		return this.id_termino_proforma;
	}
    
	
	public Integer getnumero() {
		return this.numero;
	}
    
	
	public String getdetalle() {
		return this.detalle;
	}
	
    
	public void setid_empresa(Long newid_empresa)throws Exception
	{
		try {
			if(this.id_empresa!=newid_empresa) {
				if(newid_empresa==null) {
					//newid_empresa=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("DetalleTerminoProforma:Valor nulo no permitido en columna id_empresa");
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
						System.out.println("DetalleTerminoProforma:Valor nulo no permitido en columna id_sucursal");
					}
				}

				this.id_sucursal=newid_sucursal;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_termino_proforma(Long newid_termino_proforma)throws Exception
	{
		try {
			if(this.id_termino_proforma!=newid_termino_proforma) {
				if(newid_termino_proforma==null) {
					//newid_termino_proforma=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("DetalleTerminoProforma:Valor nulo no permitido en columna id_termino_proforma");
					}
				}

				this.id_termino_proforma=newid_termino_proforma;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setnumero(Integer newnumero)throws Exception
	{
		try {
			if(this.numero!=newnumero) {
				if(newnumero==null) {
					//newnumero=0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("DetalleTerminoProforma:Valor nulo no permitido en columna numero");
					}
				}

				this.numero=newnumero;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setdetalle(String newdetalle)throws Exception
	{
		try {
			if(this.detalle!=newdetalle) {
				if(newdetalle==null) {
					//newdetalle="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("DetalleTerminoProforma:Valor nulo no permitido en columna detalle");
					}
				}

				if(newdetalle!=null&&newdetalle.length()>250) {
					newdetalle=newdetalle.substring(0,248);
					System.out.println("DetalleTerminoProforma:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=250 en columna detalle");
				}

				this.detalle=newdetalle;
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

	public TerminoProforma getTerminoProforma() {
		return this.terminoproforma;
	}

	
	
	public String getempresa_descripcion() {
		return this.empresa_descripcion;
	}

	public String getsucursal_descripcion() {
		return this.sucursal_descripcion;
	}

	public String getterminoproforma_descripcion() {
		return this.terminoproforma_descripcion;
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


	public  void  setTerminoProforma(TerminoProforma terminoproforma) {
		try {
			this.terminoproforma=terminoproforma;
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


	public  void  setterminoproforma_descripcion(String terminoproforma_descripcion) {
		try {
			this.terminoproforma_descripcion=terminoproforma_descripcion;
		} catch(Exception e) {
			;
		}
	}


	
	
	
	
	
	/*PARA REPORTES*/
	String id_empresa_descripcion="";String id_sucursal_descripcion="";String id_termino_proforma_descripcion="";
	
	
	public String getid_empresa_descripcion() {
		return id_empresa_descripcion;
	}
	public String getid_sucursal_descripcion() {
		return id_sucursal_descripcion;
	}
	public String getid_termino_proforma_descripcion() {
		return id_termino_proforma_descripcion;
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
	public void setid_termino_proforma_descripcion(String newid_termino_proforma_descripcion)throws Exception {
		try {
			this.id_termino_proforma_descripcion=newid_termino_proforma_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	
	public void inicializarVariablesParaReporte() {
		this.id_empresa_descripcion="";this.id_sucursal_descripcion="";this.id_termino_proforma_descripcion="";
	}
	
	
	
	
	
	
	/*PARA REPORTES FIN*/		
}

