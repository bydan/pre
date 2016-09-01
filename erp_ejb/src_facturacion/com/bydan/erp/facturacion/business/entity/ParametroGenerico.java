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
//import com.bydan.erp.facturacion.util.ParametroGenericoConstantesFunciones;
import com.bydan.erp.facturacion.util.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.tesoreria.util.*;
import com.bydan.erp.inventario.util.*;
import com.bydan.erp.contabilidad.util.*;



import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.tesoreria.business.entity.*;
import com.bydan.erp.inventario.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;




@SuppressWarnings("unused")
public class ParametroGenerico extends ParametroGenericoAdditional implements Serializable ,Cloneable {//ParametroGenericoAdditional,GeneralEntity
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
	
	private ParametroGenerico parametrogenericoOriginal;
	
	private Map<String, Object> mapParametroGenerico;
			
	public Map<String, Object> getMapParametroGenerico() {
		return mapParametroGenerico;
	}

	public void setMapParametroGenerico(Map<String, Object> mapParametroGenerico) {
		this.mapParametroGenerico = mapParametroGenerico;
	}
	
	public void inicializarMapParametroGenerico() {
		this.mapParametroGenerico = new HashMap<String,Object>();
	}
	
	public void setMapParametroGenericoValue(String sKey,Object oValue) {
		this.mapParametroGenerico.put(sKey, oValue);
	}
	
	public Object getMapParametroGenericoValue(String sKey) {
		return this.mapParametroGenerico.get(sKey);
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
	private Long id_modulo;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=20,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=ParametroGenericoConstantesFunciones.SREGEXSECUENCIAL,message=ParametroGenericoConstantesFunciones.SMENSAJEREGEXSECUENCIAL)
	private String secuencial;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Boolean codigo;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_transaccion;
	
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	private Long id_transaccion_recibo;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_bodega;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_servicio;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_formato;
	
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	private Long id_formato_recibo;
			
	
	public Empresa empresa;
	public Sucursal sucursal;
	public Modulo modulo;
	public Transaccion transaccion;
	public Transaccion transaccionrecibo;
	public Bodega bodega;
	public Servicio servicio;
	public Formato formato;
	public Formato formatorecibo;
	
	
	private String empresa_descripcion;
	private String sucursal_descripcion;
	private String modulo_descripcion;
	private String transaccion_descripcion;
	private String transaccionrecibo_descripcion;
	private String bodega_descripcion;
	private String servicio_descripcion;
	private String formato_descripcion;
	private String formatorecibo_descripcion;
	
	
		
	public ParametroGenerico () throws Exception {
		super();		
		
		this.id=0L;
		
		
		this.versionRow=new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());//new Date();
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		this.sType="NONE";
		
		this.parametrogenericoOriginal=this;
		
 		this.id_empresa=-1L;
 		this.id_sucursal=-1L;
 		this.id_modulo=-1L;
 		this.secuencial="";
 		this.codigo=false;
 		this.id_transaccion=-1L;
 		this.id_transaccion_recibo=null;
 		this.id_bodega=-1L;
 		this.id_servicio=-1L;
 		this.id_formato=-1L;
 		this.id_formato_recibo=null;
		
		
		this.empresa=null;
		this.sucursal=null;
		this.modulo=null;
		this.transaccion=null;
		this.transaccionrecibo=null;
		this.bodega=null;
		this.servicio=null;
		this.formato=null;
		this.formatorecibo=null;
		
		
		this.empresa_descripcion="";
		this.sucursal_descripcion="";
		this.modulo_descripcion="";
		this.transaccion_descripcion="";
		this.transaccionrecibo_descripcion="";
		this.bodega_descripcion="";
		this.servicio_descripcion="";
		this.formato_descripcion="";
		this.formatorecibo_descripcion="";
		
		
		
			
		
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
    //PARA REPORTES
	public ParametroGenerico (Long id,Date versionRow,Long id_empresa,Long id_sucursal,Long id_modulo,String secuencial,Boolean codigo,Long id_transaccion,Long id_transaccion_recibo,Long id_bodega,Long id_servicio,Long id_formato,Long id_formato_recibo) throws Exception {
		super();		
		
		this.id=id;
		this.versionRow=versionRow;
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.parametrogenericoOriginal=this;
		
 		this.id_empresa=id_empresa;
 		this.id_sucursal=id_sucursal;
 		this.id_modulo=id_modulo;
 		this.secuencial=secuencial;
 		this.codigo=codigo;
 		this.id_transaccion=id_transaccion;
 		this.id_transaccion_recibo=id_transaccion_recibo;
 		this.id_bodega=id_bodega;
 		this.id_servicio=id_servicio;
 		this.id_formato=id_formato;
 		this.id_formato_recibo=id_formato_recibo;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	 //PARA REPORTES
	public ParametroGenerico (Long id_empresa,Long id_sucursal,Long id_modulo,String secuencial,Boolean codigo,Long id_transaccion,Long id_transaccion_recibo,Long id_bodega,Long id_servicio,Long id_formato,Long id_formato_recibo) throws Exception {
		super();		
		
		this.id=0L;
		this.versionRow=new Date();
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.parametrogenericoOriginal=this;
		
 		this.id_empresa=id_empresa;
 		this.id_sucursal=id_sucursal;
 		this.id_modulo=id_modulo;
 		this.secuencial=secuencial;
 		this.codigo=codigo;
 		this.id_transaccion=id_transaccion;
 		this.id_transaccion_recibo=id_transaccion_recibo;
 		this.id_bodega=id_bodega;
 		this.id_servicio=id_servicio;
 		this.id_formato=id_formato;
 		this.id_formato_recibo=id_formato_recibo;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	public boolean equals(Object object) {
		boolean equal=false;
		ParametroGenerico parametrogenericoLocal=null;
		
		if(object!=null) {
			parametrogenericoLocal=(ParametroGenerico)object;
			
			if(parametrogenericoLocal!=null) {
				if(this.getId()!=null && parametrogenericoLocal.getId()!=null) {
					if(this.getId().equals(parametrogenericoLocal.getId())) {
						equal=true;
					}
				}
			}
		}
		
		return equal;
	}
	
	public String toString() {
		String sDetalle="";
		
		if(!ParametroGenericoConstantesFunciones.CON_DESCRIPCION_DETALLADO) {
        	sDetalle=ParametroGenericoConstantesFunciones.getParametroGenericoDescripcion(this);
		} else {
			sDetalle=ParametroGenericoConstantesFunciones.getParametroGenericoDescripcionDetallado(this);
		}
		
		return sDetalle;
    }
	
	public ParametroGenerico getParametroGenericoOriginal() {
		return this.parametrogenericoOriginal;
	}
	
	public void setParametroGenericoOriginal(ParametroGenerico parametrogenerico) {
		try {
			this.parametrogenericoOriginal=parametrogenerico;
		} catch(Exception e) {
			;
		}
	}
	
	
	protected ParametroGenericoAdditional parametrogenericoAdditional=null;
	
	public ParametroGenericoAdditional getParametroGenericoAdditional() {
		return this.parametrogenericoAdditional;
	}
	
	public void setParametroGenericoAdditional(ParametroGenericoAdditional parametrogenericoAdditional) {
		try {
			this.parametrogenericoAdditional=parametrogenericoAdditional;
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
    
	
	public Long getid_modulo() {
		return this.id_modulo;
	}
    
	
	public String getsecuencial() {
		return this.secuencial;
	}
    
	
	public Boolean getcodigo() {
		return this.codigo;
	}
    
	
	public Long getid_transaccion() {
		return this.id_transaccion;
	}
    
	
	public Long getid_transaccion_recibo() {
		return this.id_transaccion_recibo;
	}
    
	
	public Long getid_bodega() {
		return this.id_bodega;
	}
    
	
	public Long getid_servicio() {
		return this.id_servicio;
	}
    
	
	public Long getid_formato() {
		return this.id_formato;
	}
    
	
	public Long getid_formato_recibo() {
		return this.id_formato_recibo;
	}
	
    
	public void setid_empresa(Long newid_empresa)throws Exception
	{
		try {
			if(this.id_empresa!=newid_empresa) {
				if(newid_empresa==null) {
					//newid_empresa=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ParametroGenerico:Valor nulo no permitido en columna id_empresa");
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
						System.out.println("ParametroGenerico:Valor nulo no permitido en columna id_sucursal");
					}
				}

				this.id_sucursal=newid_sucursal;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_modulo(Long newid_modulo)throws Exception
	{
		try {
			if(this.id_modulo!=newid_modulo) {
				if(newid_modulo==null) {
					//newid_modulo=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ParametroGenerico:Valor nulo no permitido en columna id_modulo");
					}
				}

				this.id_modulo=newid_modulo;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setsecuencial(String newsecuencial)throws Exception
	{
		try {
			if(this.secuencial!=newsecuencial) {
				if(newsecuencial==null) {
					//newsecuencial="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("ParametroGenerico:Valor nulo no permitido en columna secuencial");
					}
				}

				if(newsecuencial!=null&&newsecuencial.length()>20) {
					newsecuencial=newsecuencial.substring(0,18);
					System.out.println("ParametroGenerico:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=20 en columna secuencial");
				}

				this.secuencial=newsecuencial;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setcodigo(Boolean newcodigo)throws Exception
	{
		try {
			if(this.codigo!=newcodigo) {
				if(newcodigo==null) {
					//newcodigo=false;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ParametroGenerico:Valor nulo no permitido en columna codigo");
					}
				}

				this.codigo=newcodigo;
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
						System.out.println("ParametroGenerico:Valor nulo no permitido en columna id_transaccion");
					}
				}

				this.id_transaccion=newid_transaccion;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_transaccion_recibo(Long newid_transaccion_recibo) {
		if(this.id_transaccion_recibo==null&&newid_transaccion_recibo!=null) {
			this.id_transaccion_recibo=newid_transaccion_recibo;
				this.setIsChanged(true);
		}

		if(this.id_transaccion_recibo!=null&&!this.id_transaccion_recibo.equals(newid_transaccion_recibo)) {

			this.id_transaccion_recibo=newid_transaccion_recibo;
				this.setIsChanged(true);
		}
	}
    
	public void setid_bodega(Long newid_bodega)throws Exception
	{
		try {
			if(this.id_bodega!=newid_bodega) {
				if(newid_bodega==null) {
					//newid_bodega=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ParametroGenerico:Valor nulo no permitido en columna id_bodega");
					}
				}

				this.id_bodega=newid_bodega;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_servicio(Long newid_servicio)throws Exception
	{
		try {
			if(this.id_servicio!=newid_servicio) {
				if(newid_servicio==null) {
					//newid_servicio=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ParametroGenerico:Valor nulo no permitido en columna id_servicio");
					}
				}

				this.id_servicio=newid_servicio;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_formato(Long newid_formato)throws Exception
	{
		try {
			if(this.id_formato!=newid_formato) {
				if(newid_formato==null) {
					//newid_formato=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ParametroGenerico:Valor nulo no permitido en columna id_formato");
					}
				}

				this.id_formato=newid_formato;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_formato_recibo(Long newid_formato_recibo) {
		if(this.id_formato_recibo==null&&newid_formato_recibo!=null) {
			this.id_formato_recibo=newid_formato_recibo;
				this.setIsChanged(true);
		}

		if(this.id_formato_recibo!=null&&!this.id_formato_recibo.equals(newid_formato_recibo)) {

			this.id_formato_recibo=newid_formato_recibo;
				this.setIsChanged(true);
		}
	}
	
	
	public Empresa getEmpresa() {
		return this.empresa;
	}

	public Sucursal getSucursal() {
		return this.sucursal;
	}

	public Modulo getModulo() {
		return this.modulo;
	}

	public Transaccion getTransaccion() {
		return this.transaccion;
	}

	public Transaccion getTransaccionRecibo() {
		return this.transaccionrecibo;
	}

	public Bodega getBodega() {
		return this.bodega;
	}

	public Servicio getServicio() {
		return this.servicio;
	}

	public Formato getFormato() {
		return this.formato;
	}

	public Formato getFormatoRecibo() {
		return this.formatorecibo;
	}

	
	
	public String getempresa_descripcion() {
		return this.empresa_descripcion;
	}

	public String getsucursal_descripcion() {
		return this.sucursal_descripcion;
	}

	public String getmodulo_descripcion() {
		return this.modulo_descripcion;
	}

	public String gettransaccion_descripcion() {
		return this.transaccion_descripcion;
	}

	public String gettransaccionrecibo_descripcion() {
		return this.transaccionrecibo_descripcion;
	}

	public String getbodega_descripcion() {
		return this.bodega_descripcion;
	}

	public String getservicio_descripcion() {
		return this.servicio_descripcion;
	}

	public String getformato_descripcion() {
		return this.formato_descripcion;
	}

	public String getformatorecibo_descripcion() {
		return this.formatorecibo_descripcion;
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


	public  void  setModulo(Modulo modulo) {
		try {
			this.modulo=modulo;
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


	public  void  setTransaccionRecibo(Transaccion transaccionrecibo) {
		try {
			this.transaccionrecibo=transaccionrecibo;
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


	public  void  setServicio(Servicio servicio) {
		try {
			this.servicio=servicio;
		} catch(Exception e) {
			;
		}
	}


	public  void  setFormato(Formato formato) {
		try {
			this.formato=formato;
		} catch(Exception e) {
			;
		}
	}


	public  void  setFormatoRecibo(Formato formatorecibo) {
		try {
			this.formatorecibo=formatorecibo;
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


	public  void  setmodulo_descripcion(String modulo_descripcion) {
		try {
			this.modulo_descripcion=modulo_descripcion;
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


	public  void  settransaccionrecibo_descripcion(String transaccionrecibo_descripcion) {
		try {
			this.transaccionrecibo_descripcion=transaccionrecibo_descripcion;
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


	public  void  setservicio_descripcion(String servicio_descripcion) {
		try {
			this.servicio_descripcion=servicio_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  setformato_descripcion(String formato_descripcion) {
		try {
			this.formato_descripcion=formato_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  setformatorecibo_descripcion(String formatorecibo_descripcion) {
		try {
			this.formatorecibo_descripcion=formatorecibo_descripcion;
		} catch(Exception e) {
			;
		}
	}


	
	
	
	
	
	/*PARA REPORTES*/
	String id_empresa_descripcion="";String id_sucursal_descripcion="";String id_modulo_descripcion="";String codigo_descripcion="";String id_transaccion_descripcion="";String id_transaccion_recibo_descripcion="";String id_bodega_descripcion="";String id_servicio_descripcion="";String id_formato_descripcion="";String id_formato_recibo_descripcion="";
	
	
	public String getid_empresa_descripcion() {
		return id_empresa_descripcion;
	}
	public String getid_sucursal_descripcion() {
		return id_sucursal_descripcion;
	}
	public String getid_modulo_descripcion() {
		return id_modulo_descripcion;
	}
	public String getcodigo_descripcion() {
		return codigo_descripcion;
	}
	public String getid_transaccion_descripcion() {
		return id_transaccion_descripcion;
	}
	public String getid_transaccion_recibo_descripcion() {
		return id_transaccion_recibo_descripcion;
	}
	public String getid_bodega_descripcion() {
		return id_bodega_descripcion;
	}
	public String getid_servicio_descripcion() {
		return id_servicio_descripcion;
	}
	public String getid_formato_descripcion() {
		return id_formato_descripcion;
	}
	public String getid_formato_recibo_descripcion() {
		return id_formato_recibo_descripcion;
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
	public void setid_modulo_descripcion(String newid_modulo_descripcion)throws Exception {
		try {
			this.id_modulo_descripcion=newid_modulo_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setcodigo_descripcion(String newcodigo_descripcion)throws Exception {
		try {
			this.codigo_descripcion=newcodigo_descripcion;
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
	public void setid_transaccion_recibo_descripcion(String newid_transaccion_recibo_descripcion) {
		this.id_transaccion_recibo_descripcion=newid_transaccion_recibo_descripcion;
	}
	public void setid_bodega_descripcion(String newid_bodega_descripcion)throws Exception {
		try {
			this.id_bodega_descripcion=newid_bodega_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_servicio_descripcion(String newid_servicio_descripcion)throws Exception {
		try {
			this.id_servicio_descripcion=newid_servicio_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_formato_descripcion(String newid_formato_descripcion)throws Exception {
		try {
			this.id_formato_descripcion=newid_formato_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_formato_recibo_descripcion(String newid_formato_recibo_descripcion) {
		this.id_formato_recibo_descripcion=newid_formato_recibo_descripcion;
	}
	
	public void inicializarVariablesParaReporte() {
		this.id_empresa_descripcion="";this.id_sucursal_descripcion="";this.id_modulo_descripcion="";this.codigo_descripcion="";this.id_transaccion_descripcion="";this.id_transaccion_recibo_descripcion="";this.id_bodega_descripcion="";this.id_servicio_descripcion="";this.id_formato_descripcion="";this.id_formato_recibo_descripcion="";
	}
	
	
	
	
	
	
	/*PARA REPORTES FIN*/		
}

