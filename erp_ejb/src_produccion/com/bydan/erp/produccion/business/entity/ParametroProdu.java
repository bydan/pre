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
package com.bydan.erp.produccion.business.entity;

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
//import com.bydan.erp.produccion.util.ParametroProduConstantesFunciones;
import com.bydan.erp.produccion.util.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.inventario.util.*;
import com.bydan.erp.tesoreria.util.*;



import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.inventario.business.entity.*;
import com.bydan.erp.tesoreria.business.entity.*;




@SuppressWarnings("unused")
public class ParametroProdu extends ParametroProduAdditional implements Serializable ,Cloneable {//ParametroProduAdditional,GeneralEntity
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
	
	private ParametroProdu parametroproduOriginal;
	
	private Map<String, Object> mapParametroProdu;
			
	public Map<String, Object> getMapParametroProdu() {
		return mapParametroProdu;
	}

	public void setMapParametroProdu(Map<String, Object> mapParametroProdu) {
		this.mapParametroProdu = mapParametroProdu;
	}
	
	public void inicializarMapParametroProdu() {
		this.mapParametroProdu = new HashMap<String,Object>();
	}
	
	public void setMapParametroProduValue(String sKey,Object oValue) {
		this.mapParametroProdu.put(sKey, oValue);
	}
	
	public Object getMapParametroProduValue(String sKey) {
		return this.mapParametroProdu.get(sKey);
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
	private Long id_bodega;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_bodega_materia_prima;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_transaccion;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_transaccion_egreso;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	private Long con_relacion_porcentaje;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=200,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=ParametroProduConstantesFunciones.SREGEXDESCRIPCION,message=ParametroProduConstantesFunciones.SMENSAJEREGEXDESCRIPCION)
	private String descripcion;
			
	
	public Empresa empresa;
	public Sucursal sucursal;
	public Bodega bodega;
	public Bodega bodegamateriaprima;
	public Transaccion transaccion;
	public Transaccion transaccionegreso;
	
	
	private String empresa_descripcion;
	private String sucursal_descripcion;
	private String bodega_descripcion;
	private String bodegamateriaprima_descripcion;
	private String transaccion_descripcion;
	private String transaccionegreso_descripcion;
	
	
		
	public ParametroProdu () throws Exception {
		super();		
		
		this.id=0L;
		
		
		this.versionRow=new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());//new Date();
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		this.sType="NONE";
		
		this.parametroproduOriginal=this;
		
 		this.id_empresa=-1L;
 		this.id_sucursal=-1L;
 		this.id_bodega=-1L;
 		this.id_bodega_materia_prima=-1L;
 		this.id_transaccion=-1L;
 		this.id_transaccion_egreso=-1L;
 		this.con_relacion_porcentaje=0L;
 		this.descripcion="";
		
		
		this.empresa=null;
		this.sucursal=null;
		this.bodega=null;
		this.bodegamateriaprima=null;
		this.transaccion=null;
		this.transaccionegreso=null;
		
		
		this.empresa_descripcion="";
		this.sucursal_descripcion="";
		this.bodega_descripcion="";
		this.bodegamateriaprima_descripcion="";
		this.transaccion_descripcion="";
		this.transaccionegreso_descripcion="";
		
		
		
			
		
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
    //PARA REPORTES
	public ParametroProdu (Long id,Date versionRow,Long id_empresa,Long id_sucursal,Long id_bodega,Long id_bodega_materia_prima,Long id_transaccion,Long id_transaccion_egreso,Long con_relacion_porcentaje,String descripcion) throws Exception {
		super();		
		
		this.id=id;
		this.versionRow=versionRow;
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.parametroproduOriginal=this;
		
 		this.id_empresa=id_empresa;
 		this.id_sucursal=id_sucursal;
 		this.id_bodega=id_bodega;
 		this.id_bodega_materia_prima=id_bodega_materia_prima;
 		this.id_transaccion=id_transaccion;
 		this.id_transaccion_egreso=id_transaccion_egreso;
 		this.con_relacion_porcentaje=con_relacion_porcentaje;
 		this.descripcion=descripcion;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	 //PARA REPORTES
	public ParametroProdu (Long id_empresa,Long id_sucursal,Long id_bodega,Long id_bodega_materia_prima,Long id_transaccion,Long id_transaccion_egreso,Long con_relacion_porcentaje,String descripcion) throws Exception {
		super();		
		
		this.id=0L;
		this.versionRow=new Date();
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.parametroproduOriginal=this;
		
 		this.id_empresa=id_empresa;
 		this.id_sucursal=id_sucursal;
 		this.id_bodega=id_bodega;
 		this.id_bodega_materia_prima=id_bodega_materia_prima;
 		this.id_transaccion=id_transaccion;
 		this.id_transaccion_egreso=id_transaccion_egreso;
 		this.con_relacion_porcentaje=con_relacion_porcentaje;
 		this.descripcion=descripcion;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	public boolean equals(Object object) {
		boolean equal=false;
		ParametroProdu parametroproduLocal=null;
		
		if(object!=null) {
			parametroproduLocal=(ParametroProdu)object;
			
			if(parametroproduLocal!=null) {
				if(this.getId()!=null && parametroproduLocal.getId()!=null) {
					if(this.getId().equals(parametroproduLocal.getId())) {
						equal=true;
					}
				}
			}
		}
		
		return equal;
	}
	
	public String toString() {
		String sDetalle="";
		
		if(!ParametroProduConstantesFunciones.CON_DESCRIPCION_DETALLADO) {
        	sDetalle=ParametroProduConstantesFunciones.getParametroProduDescripcion(this);
		} else {
			sDetalle=ParametroProduConstantesFunciones.getParametroProduDescripcionDetallado(this);
		}
		
		return sDetalle;
    }
	
	public ParametroProdu getParametroProduOriginal() {
		return this.parametroproduOriginal;
	}
	
	public void setParametroProduOriginal(ParametroProdu parametroprodu) {
		try {
			this.parametroproduOriginal=parametroprodu;
		} catch(Exception e) {
			;
		}
	}
	
	
	protected ParametroProduAdditional parametroproduAdditional=null;
	
	public ParametroProduAdditional getParametroProduAdditional() {
		return this.parametroproduAdditional;
	}
	
	public void setParametroProduAdditional(ParametroProduAdditional parametroproduAdditional) {
		try {
			this.parametroproduAdditional=parametroproduAdditional;
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
    
	
	public Long getid_bodega() {
		return this.id_bodega;
	}
    
	
	public Long getid_bodega_materia_prima() {
		return this.id_bodega_materia_prima;
	}
    
	
	public Long getid_transaccion() {
		return this.id_transaccion;
	}
    
	
	public Long getid_transaccion_egreso() {
		return this.id_transaccion_egreso;
	}
    
	
	public Long getcon_relacion_porcentaje() {
		return this.con_relacion_porcentaje;
	}
    
	
	public String getdescripcion() {
		return this.descripcion;
	}
	
    
	public void setid_empresa(Long newid_empresa)throws Exception
	{
		try {
			if(this.id_empresa!=newid_empresa) {
				if(newid_empresa==null) {
					//newid_empresa=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ParametroProdu:Valor nulo no permitido en columna id_empresa");
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
						System.out.println("ParametroProdu:Valor nulo no permitido en columna id_sucursal");
					}
				}

				this.id_sucursal=newid_sucursal;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_bodega(Long newid_bodega)throws Exception
	{
		try {
			if(this.id_bodega!=newid_bodega) {
				if(newid_bodega==null) {
					//newid_bodega=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ParametroProdu:Valor nulo no permitido en columna id_bodega");
					}
				}

				this.id_bodega=newid_bodega;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_bodega_materia_prima(Long newid_bodega_materia_prima)throws Exception
	{
		try {
			if(this.id_bodega_materia_prima!=newid_bodega_materia_prima) {
				if(newid_bodega_materia_prima==null) {
					//newid_bodega_materia_prima=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ParametroProdu:Valor nulo no permitido en columna id_bodega_materia_prima");
					}
				}

				this.id_bodega_materia_prima=newid_bodega_materia_prima;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_transaccion(Long newid_transaccion)throws Exception
	{
		try {
			if(this.id_transaccion!=newid_transaccion) {
				if(newid_transaccion==null) {
					//newid_transaccion=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ParametroProdu:Valor nulo no permitido en columna id_transaccion");
					}
				}

				this.id_transaccion=newid_transaccion;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_transaccion_egreso(Long newid_transaccion_egreso)throws Exception
	{
		try {
			if(this.id_transaccion_egreso!=newid_transaccion_egreso) {
				if(newid_transaccion_egreso==null) {
					//newid_transaccion_egreso=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ParametroProdu:Valor nulo no permitido en columna id_transaccion_egreso");
					}
				}

				this.id_transaccion_egreso=newid_transaccion_egreso;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setcon_relacion_porcentaje(Long newcon_relacion_porcentaje)throws Exception
	{
		try {
			if(this.con_relacion_porcentaje!=newcon_relacion_porcentaje) {
				if(newcon_relacion_porcentaje==null) {
					//newcon_relacion_porcentaje=0L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ParametroProdu:Valor nulo no permitido en columna con_relacion_porcentaje");
					}
				}

				this.con_relacion_porcentaje=newcon_relacion_porcentaje;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setdescripcion(String newdescripcion)throws Exception
	{
		try {
			if(this.descripcion!=newdescripcion) {
				if(newdescripcion==null) {
					//newdescripcion="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("ParametroProdu:Valor nulo no permitido en columna descripcion");
					}
				}

				if(newdescripcion!=null&&newdescripcion.length()>200) {
					newdescripcion=newdescripcion.substring(0,198);
					System.out.println("ParametroProdu:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=200 en columna descripcion");
				}

				this.descripcion=newdescripcion;
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

	public Bodega getBodega() {
		return this.bodega;
	}

	public Bodega getBodegaMateriaPrima() {
		return this.bodegamateriaprima;
	}

	public Transaccion getTransaccion() {
		return this.transaccion;
	}

	public Transaccion getTransaccionEgreso() {
		return this.transaccionegreso;
	}

	
	
	public String getempresa_descripcion() {
		return this.empresa_descripcion;
	}

	public String getsucursal_descripcion() {
		return this.sucursal_descripcion;
	}

	public String getbodega_descripcion() {
		return this.bodega_descripcion;
	}

	public String getbodegamateriaprima_descripcion() {
		return this.bodegamateriaprima_descripcion;
	}

	public String gettransaccion_descripcion() {
		return this.transaccion_descripcion;
	}

	public String gettransaccionegreso_descripcion() {
		return this.transaccionegreso_descripcion;
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


	public  void  setBodega(Bodega bodega) {
		try {
			this.bodega=bodega;
		} catch(Exception e) {
			;
		}
	}


	public  void  setBodegaMateriaPrima(Bodega bodegamateriaprima) {
		try {
			this.bodegamateriaprima=bodegamateriaprima;
		} catch(Exception e) {
			;
		}
	}


	public  void  setTransaccion(Transaccion transaccion) {
		try {
			this.transaccion=transaccion;
		} catch(Exception e) {
			;
		}
	}


	public  void  setTransaccionEgreso(Transaccion transaccionegreso) {
		try {
			this.transaccionegreso=transaccionegreso;
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


	public  void  setbodega_descripcion(String bodega_descripcion) {
		try {
			this.bodega_descripcion=bodega_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  setbodegamateriaprima_descripcion(String bodegamateriaprima_descripcion) {
		try {
			this.bodegamateriaprima_descripcion=bodegamateriaprima_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  settransaccion_descripcion(String transaccion_descripcion) {
		try {
			this.transaccion_descripcion=transaccion_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  settransaccionegreso_descripcion(String transaccionegreso_descripcion) {
		try {
			this.transaccionegreso_descripcion=transaccionegreso_descripcion;
		} catch(Exception e) {
			;
		}
	}


	
	
	
	
	
	/*PARA REPORTES*/
	String id_empresa_descripcion="";String id_sucursal_descripcion="";String id_bodega_descripcion="";String id_bodega_materia_prima_descripcion="";String id_transaccion_descripcion="";String id_transaccion_egreso_descripcion="";
	
	
	public String getid_empresa_descripcion() {
		return id_empresa_descripcion;
	}
	public String getid_sucursal_descripcion() {
		return id_sucursal_descripcion;
	}
	public String getid_bodega_descripcion() {
		return id_bodega_descripcion;
	}
	public String getid_bodega_materia_prima_descripcion() {
		return id_bodega_materia_prima_descripcion;
	}
	public String getid_transaccion_descripcion() {
		return id_transaccion_descripcion;
	}
	public String getid_transaccion_egreso_descripcion() {
		return id_transaccion_egreso_descripcion;
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
	public void setid_bodega_descripcion(String newid_bodega_descripcion)throws Exception {
		try {
			this.id_bodega_descripcion=newid_bodega_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_bodega_materia_prima_descripcion(String newid_bodega_materia_prima_descripcion)throws Exception {
		try {
			this.id_bodega_materia_prima_descripcion=newid_bodega_materia_prima_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_transaccion_descripcion(String newid_transaccion_descripcion)throws Exception {
		try {
			this.id_transaccion_descripcion=newid_transaccion_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_transaccion_egreso_descripcion(String newid_transaccion_egreso_descripcion)throws Exception {
		try {
			this.id_transaccion_egreso_descripcion=newid_transaccion_egreso_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	
	public void inicializarVariablesParaReporte() {
		this.id_empresa_descripcion="";this.id_sucursal_descripcion="";this.id_bodega_descripcion="";this.id_bodega_materia_prima_descripcion="";this.id_transaccion_descripcion="";this.id_transaccion_egreso_descripcion="";
	}
	
	
	
	
	
	
	/*PARA REPORTES FIN*/		
}

